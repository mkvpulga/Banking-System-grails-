package icbs.periodicops

import grails.transaction.Transactional
import icbs.admin.Branch
import icbs.lov.LoanSecurity
import icbs.lov.LoanProvisionBsp
import icbs.lov.LoanInstallmentStatus
import icbs.lov.LoanPerformanceClassification
import icbs.lov.ConfigItemStatus
import icbs.loans.Loan
import icbs.loans.LoanInstallment
import icbs.loans.LoanLedger
import icbs.loans.LoanReClassHist
import icbs.loans.LoanDueHist
import icbs.loans.LoanRecovery
import icbs.loans.LoanRelief
import icbs.loans.LoanMicrofinanceHist									  
import icbs.lov.LoanFreq
import icbs.tellering.TxnFile
import icbs.tellering.TxnDepositAcctLedger
import icbs.tellering.TxnLoanPaymentDetails
import icbs.tellering.TxnBreakdown
import icbs.admin.Product
import icbs.admin.UserMaster
import icbs.admin.Institution
import icbs.admin.TxnTemplate
import icbs.admin.Holiday
import icbs.lov.ProductType
import icbs.lov.LoanAcctStatus
import icbs.lov.LoanPerformanceId
import icbs.lov.LoanCalculation
import icbs.lov.LoanProvision
import icbs.lov.DepositStatus
import icbs.lov.DepositType
import icbs.lov.TxnType
import icbs.tellering.TxnFile
import icbs.gl.CfgAcctGlTemplateDet
import icbs.gl.GlAccount
import icbs.periodicops.DailyLoanInstallmentProcessing
import icbs.periodicops.DailyLoanRecoveries
import icbs.admin.BranchHoliday
import groovy.time.TimeCategory
import groovy.sql.Sql
import icbs.loans.LoanNonReclassToCurrentPointer
@Transactional
class LoanPeriodicOpsService {

    def GlTransactionService
    def sessionFactory
    def dataSource
    
    def startOfDay(Date currentDate,Branch branch, UserMaster user) {
        reclassifyInstallments(currentDate, branch)
        //updateInterest(currentDate, branch)
        updatePastDueInterest (currentDate, branch)
        updateStatus (currentDate, branch)
        //updateBalances(currentDate,branch)
        updatePenalties(currentDate,branch)
        loanRecoveries(currentDate,branch, user)               
    }
     
        

    def endOfDay(Date currentDate,Branch branch, UserMaster user) {
        // updatePaidInstallments(currentDate, branch)
        postPaidInstallments(currentDate, branch)										 
        updateCancelledPayments(currentDate, branch)
        updateLoanAge(currentDate, branch,user)
        updateOverduePrin(currentDate, branch)
        //uidTransferToIncome(currentDate, branch, user)
        loanPerformanceReclassification(currentDate, "daily", branch, user)
        // new institution record
        // insert into institution values (106,1,'Loan Microfinance Archive','LNS.50130','Logical','TRUE')
        if (Institution.findByParamCode("LNS.50130").paramValue == 'TRUE') {
            archiveMicrofinance(currentDate, branch)
        }
    }

    def endOfMonth(Date currentDate, branch, UserMaster user) {
        loanPerformanceReclassification(currentDate, "monthly", branch, user)
        //uidTransferToIncome(currentDate, branch, user)
    }

    def cleanUpLnGorm() {
        def session = sessionFactory.currentSession
        session.flush()
        session.clear()
        //propertyInstanceMap.get().clear()
        def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP
        propertyInstanceMap.get().clear()
        
    }
    
    def uidTransferToIncome(Date currentDate, Branch branch, UserMaster user) {
        def loans = Loan.createCriteria().list() {
            and{
                eq("branch",branch)   
                gt("balanceAmount",0.00d)
                loanEIRSchedules {      
                    and {
                        eq("transferDate", currentDate)
                    }
                }
            }
        }  
        for (loan in loans) {           
            def txnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
            def dueTransfer = loan?.loanEIRSchedules.find{it.transferDate == currentDate }
            def tf = new TxnFile(acctNo:loan.accountNo, branch:loan.branch, currency:loan.product.currency,
                loanAcct:loan, status:ConfigItemStatus.read(2), txnAmt:dueTransfer.uidAmount, txnCode:txnTmp.code,
                txnDate:currentDate, txnDescription:'UID Transfer', txnParticulars:'To automatically transfer UID',
                txnRef:'Periodic UID Transfer', txnTemplate:txnTmp, txnType:txnTmp.txnType,
                txnTimestamp:new Date().toTimestamp(), user:user)
            tf.save(flush:true)
            def fy = tf.txnDate.format('yyyy').toInteger()
            def ll = new LoanLedger(loan:loan, interestDebit:dueTransfer.uidAmount, interestCredit:dueTransfer.uidAmount, 
                interestBalance:loan.interestBalanceAmount, txnFile:tf, txnCode:tf.txnCode, txnDate:currentDate,
                txnRef:tf.txnRef, txnParticulars:'To automatically transfer UID', txnTemplate:tf.txnTemplate)
            ll.save(flush:true)
            
            // gl entries
            def tbDr = new TxnBreakdown(currency:tf.currency, txnDate:tf.txnDate, txnFile:tf, user:user, branch:tf.branch, debitAmt:tf.txnAmt)
            def tbCr = new TxnBreakdown(currency:tf.currency, txnDate:tf.txnDate, txnFile:tf, user:user, branch:tf.branch, creditAmt:tf.txnAmt)
                
            def debitGlPtr = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(loan.glLink, '9', loan.loanPerformanceId.id)
            def debitGl = GlAccount.findByCodeAndBranchAndFinancialYearAndCurrency(debitGlPtr.glCode,loan.branch, fy, loan.product.currency)
            def creditGlPtr = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(loan.glLink, '2', loan.loanPerformanceId.id)
            def creditGl = GlAccount.findByCodeAndBranchAndFinancialYearAndCurrency(creditGlPtr.glCode,loan.branch, fy, loan.product.currency)   
                    
            tbDr.debitAcct = debitGl.code
            tbCr.creditAcct = creditGl.code
                
            tbDr.save(flush:true)
            tbCr.save(flush:true)                     
        }
        def clsLoans = Loan.createCriteria().list() {
            and{
                eq("branch",branch)   
                eq("status",LoanAcctStatus.get(6))
                eq("lastTransactionDate",currentDate)
                eq("balanceAmount",0.00d)
            }
        }  
        for (l in clsLoans) { 
            
            def clsTxnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
            def clsDueTransfer = l.loanEIRSchedules.find{it.transferDate >= currentDate }
            for (cls in clsDueTransfer) {
                def clsTf = new TxnFile(acctNo:l.accountNo, branch:l.branch, currency:l.product.currency,
                    loanAcct:l, status:ConfigItemStatus.read(2), txnAmt:cls.uidAmount, txnCode:clsTxnTmp.code,
                    txnDate:currentDate, txnDescription:'UID Transfer', txnParticulars:'To automatically transfer UID',
                    txnRef:'Periodic UID Transfer', txnTemplate:clsTxnTmp, txnType:clsTxnTmp.txnType,
                    txnTimestamp:new Date().toTimestamp(), user:user)
                clsTf.save(flush:true)
                def fy = clsTf.txnDate.format('yyyy').toInteger()
                def clsLl = new LoanLedger(loan:l, interestDebit:cls.uidAmount, interestCredit:cls.uidAmount, 
                    interestBalance:l.interestBalanceAmount, txnFile:clsTf, txnCode:clsTf.txnCode, txnDate:currentDate,
                    txnRef:clsTf.txnRef, txnParticulars:'To automatically transfer UID', txnTemplate:clsTf.txnTemplate)
                clsLl.save(flush:true)
            
                // gl entries
                def clsTbDr = new TxnBreakdown(currency:clsTf.currency, txnDate:clsTf.txnDate, txnFile:clsTf, user:user, 
                    branch:clsTf.branch, debitAmt:clsTf.txnAmt)
                def clsTbCr = new TxnBreakdown(currency:clsTf.currency, txnDate:clsTf.txnDate, txnFile:clsTf, user:user, 
                    branch:clsTf.branch, creditAmt:clsTf.txnAmt)
                
                def clsDdebitGlPtr = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(l.glLink, '9', l.loanPerformanceId.id)
                def clsDebitGl = GlAccount.findByCodeAndBranchAndFinancialYearAndCurrency(clsDdebitGlPtr.glCode,l.branch, fy, l.product.currency)
                def clsCreditGlPtr = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(l.glLink, '2', l.loanPerformanceId.id)
                def clsCreditGl = GlAccount.findByCodeAndBranchAndFinancialYearAndCurrency(clsCreditGlPtr.glCode,l.branch, fy, l.product.currency)   
                    
                clsTbDr.debitAcct = clsDebitGl.code
                clsTbCr.creditAcct = clsCreditGl.code
                
                clsTbDr.save(flush:true)
                clsTbCr.save(flush:true)                     
                
            }
            
        }       
    }
    def reclassifyInstallments(Date currentDate, Branch branch) {
        // tag all due installments
        //LoanInstallment.executeUpdate("update LoanInstallment set status=:status where installmentDate<=:date and (principalInstallmentAmount - principalInstallmentPaid) != 0", [status: LoanInstallmentStatus.get(3), date: currentDate])
        def loans = Loan.createCriteria().list() {
            and{
                eq("branch",branch)
                gt("status",LoanAcctStatus.get(1)) 
                lt("status",LoanAcctStatus.get(6))                
                loanInstallments {      
                    and {
                        le("installmentDate", currentDate)
                        eq("status.id", 2L)  // not fully paid
                    }
                }
            }
        }       
        println '+++++++++++++++++++++++++++++++++++++'
        println loans
        println '+++++++++++++++++++++++++++++++++++++'
        def lnOdue = 0.00D
        def intPd = 0.00D
        def penPd = 0.00D
        Integer i = 0
        def aacounter = 0				 
        for (loan in loans) {  
            aacounter = aacounter + 1
            println("Loan Counter Here ================================================= "+aacounter)
            if(!loan.isAttached()) {
                loan.attach()
            }										 
            def dueInstallments = loan?.loanInstallments.findAll{it.installmentDate <= currentDate && it.status.id == 2L}
            for(installment in dueInstallments.sort{it.sequenceNo}) {
                
                
                if (!loan.overduePrincipalBalance) {
                    loan.overduePrincipalBalance = 0d
                }
                if (!loan.normalInterestAmount) {
                    loan.normalInterestAmount = 0d
                }
                if (!loan.interestBalanceAmount) {
                    loan.interestBalanceAmount = 0d 
                }
                if (!loan.serviceChargeBalanceAmount) {
                    loan.serviceChargeBalanceAmount = 0d
                }
                //println("loan overduePrincipalBalance value: "+loan.overduePrincipalBalance)
                lnOdue = loan.overduePrincipalBalance * -1
                //println("lnOdue: "+lnOdue)						  
                intPd = loan.interestBalanceAmount * -1
                //penPd = loan.penaltyBalanceAmount * -1
                loan.overduePrincipalBalance += installment.principalInstallmentAmount
                // checking, do not allow overduePrincipalBalance > balanceAmount
                if (loan.overduePrincipalBalance > loan.balanceAmount) {
                    loan.overduePrincipalBalance = loan.balanceAmount
                }
                if (loan.interestIncomeScheme.installmentCalcType.id == 1 && loan.interestIncomeScheme.advInterestType.id == 1) {
                    // do not change interest for single payment as this is 
                    loan.interestBalanceAmount += 0.00
                } else {
                    loan.interestBalanceAmount += installment.interestInstallmentAmount         
                }
                loan.normalInterestAmount += installment.normalInterestInstallmentAmount
                loan.serviceChargeBalanceAmount += installment.serviceChargeInstallmentAmount
                installment.status = LoanInstallmentStatus.get(3)
                installment.save(failOnError:true)
                
                // mark installment as paid based on advanced
                println("Installment sequence no: "+installment.sequenceNo)
                if (lnOdue > 0) {
                    if (lnOdue >= installment.principalInstallmentAmount) {
                        //println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
                        //println(" lnOdue condition > 0")
                        installment.principalInstallmentPaid = installment.principalInstallmentAmount
                        //println("installment.principalInstallmentPaid value: "+installment.principalInstallmentPaid)
                        //println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
                    } else {
                        //println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
                        //println(" lnOdue condition else")
                        installment.principalInstallmentPaid = lnOdue
                        //println("installment.principalInstallmentPaid value: "+installment.principalInstallmentPaid)
                        //println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
                    }
                }
                if (intPd > 0) {
                    if (intPd > installment.interestInstallmentAmount) {
                        //println(" intPd condition > 0")
                        installment.interestInstallmentPaid =  installment.interestInstallmentAmount
                        //println(" interestInstallmentPaid: "+installment.interestInstallmentPaid)
                    } else {
                        //println(" intPd >0 else condtion")
                        installment.interestInstallmentPaid = intPd
                        //println(" interestInstallmentPaid: "+installment.interestInstallmentPaid)
                    }
                }

                // fully paid
                if ((installment.principalInstallmentPaid == installment.principalInstallmentAmount) && (installment.interestInstallmentPaid == installment.interestInstallmentAmount)) {
                    installment.datePaid = loan.branch.runDate
                    installment.status = LoanInstallmentStatus.get(5)   
                    println '???? FULLY PAID ????'
                    println loan.accountNo
                    println installment
                } else if ((installment.principalInstallmentPaid > 0.00) && (installment.interestInstallmentPaid >= 0.00)) {
                    // partially paid
                    installment.datePaid = loan.branch.runDate
                    installment.status = LoanInstallmentStatus.get(4) 
                   
                }
                installment.save(failOnError:true)
                loan.accruedInterestDate = currentDate
                if (loan.balanceAmount > 0 && installment.installmentDate == loan.maturityDate){
                    // change loan status
                    loan.status = LoanAcctStatus.get(5)
                }
                loan.save(failOnError:true)   
                
                def daily = new DailyLoanInstallmentProcessing(processDate:currentDate, loanInstallment:installment.id, loan:loan.id)
                daily.save(flush:true)
                i++
                if (i == 50 ){
                    i = 1
                    cleanUpLnGorm()
                }
            }
        }
    }
    
    

    def updateBalances(Date currentDate,Branch branch) {
        // get all loans with due installments
        // do not include matured loans
        def loans = Loan.createCriteria().list() {
            and{
                eq("branch",branch)
                gt("maturityDate",currentDate)
                loanInstallments {      
                    and {
                        le("installmentDate", currentDate)
                        ne("status.id", 5L)  // not fully paid
                    }
                }
            }
        }
        
        for (loan in loans) {
            // due installment
            def dueInstallments = loan?.loanInstallments.findAll{it.installmentDate <= currentDate && it.status.id != 5L}

            def balanceAmount = 0
            def normalInterestAmount = 0
            def interestBalanceAmount = 0
            def serviceChargeBalanceAmount = 0
            for(installment in dueInstallments.sort{it.sequenceNo}) {                
                balanceAmount += installment.principalInstallmentAmount
                normalInterestAmount += installment.normalInterestInstallmentAmount
                interestBalanceAmount += installment.interestInstallmentAmount
                serviceChargeBalanceAmount += installment.serviceChargeInstallmentAmount
            }
            loan.overduePrincipalBalance = balanceAmount
            //loan.balanceAmount = balanceAmount
            if (loan.maturityDate >= currentDate) {
                loan.normalInterestAmount = normalInterestAmount
                loan.interestBalanceAmount = interestBalanceAmount
                loan.serviceChargeBalanceAmount = serviceChargeBalanceAmount                
            }
        }
    }    
    def loanRecoveries(Date currentDate,Branch branch, UserMaster user) {
        Boolean depOk
        Double recoveryAmt
        Double lnPayAmt
        Double scPayAmt
        Double penPayAmt
        Double intPayAmt
        Double prinPayAmt
        Integer i = 0
        def loan
        def drDepTxn = Institution.findByParamCode('LNS.50072').paramValue.toInteger()
        def crLoanTxn = Institution.findByParamCode('LNS.50073').paramValue.toInteger()
        def lnSweeps
        def db = new Sql(dataSource)
        def sqlstmt  = "select id from loan where status_id > 1 and status_id < 6 and branch_id = "+branch.id
        def loans = db.rows(sqlstmt)
        /*
        def loans = Loan.createCriteria().list() {
        and{
        eq("branch",branch)
        gt("status",LoanAcctStatus.get(1)) 
        lt("status",LoanAcctStatus.get(6))
        }
        }
         */
        for (ln in loans) {
            loan = Loan.get(ln.id)
            if(!loan.isAttached()) {
                loan.attach()
            }
            def totalDue = 0.00
            if (loan.overduePrincipalBalance > 0) {
                totalDue += loan.overduePrincipalBalance
                if (loan.interestBalanceAmount > 0) {
                    totalDue += loan.interestBalanceAmount
                }
                if (loan.penaltyBalanceAmount > 0) {
                    totalDue += loan.penaltyBalanceAmount
                }
                if (loan.serviceChargeBalanceAmount > 0) {
                    totalDue += loan.serviceChargeBalanceAmount
                }            
            }

            if (totalDue > 0) {
                // update loans due history
                def lnDueHist = new LoanDueHist(branch:loan.branch, loanAcct:loan, refDate:currentDate,
                    status:loan.status, grantedAmt:loan.grantedAmount, principalBalanceAmt:loan.overduePrincipalBalance,
                    intrestBalanceAmt:loan.interestBalanceAmount, penaltyBalanceAmt:loan.penaltyBalanceAmount,
                    scBalanceAmt:loan.serviceChargeBalanceAmount)
                lnDueHist.save()
                i++
                if (i == 50) {
                    i = 0
                    cleanUpLnGorm()
                }
                if(!loan.isAttached()) {
                    loan.attach()
                }
                // posting of recoveries   
                depOk = true
                lnSweeps = LoanRecovery.createCriteria().list() {
                    and{
                        eq("fundedLoan",loan)
                    }
                }
                //for (accts in loan.sweepAccounts) {
                for (accts in lnSweeps) {
                    if(!accts.isAttached()) {
                        accts.attach()
                    }
                    def deposit = accts.depositAccount
                    depOk = true
                    if (deposit.status == DepositStatus.get(1) || deposit.status == DepositStatus.get(7)) {
                        depOk = false
                    }                
                    if (deposit.type == DepositType.get(3)) {
                        depOk = false
                    }    
                    if (deposit.availableBalAmt <= 0.00) {
                        depOk = false
                    }                    
                    if (depOk && (totalDue > 0.00)) {
                        if (deposit.availableBalAmt >= totalDue)  {
                            recoveryAmt = totalDue
                        } else {
                            recoveryAmt = deposit.availableBalAmt
                        }
                        // post transaction
                        // debit deposit
                        def tfDr = new TxnFile(acctNo:deposit.acctNo, branch:deposit.branch, currency:deposit.product.currency, depAcct:deposit, 
                            status:ConfigItemStatus.read(2), txnTimestamp:new Date().toTimestamp(), txnDate:currentDate,
                            txnAmt:recoveryAmt, txnCode:TxnTemplate.get(drDepTxn).code, txnType:TxnTemplate.get(drDepTxn).txnType,
                            txnDescription:'SOD Loan Recovery from '+loan.accountNo, txnRef:'SOD Loan Recovery from '+loan.accountNo,
                            user:user, txnTemplate:TxnTemplate.get(drDepTxn), txnParticulars:'SOD Loan Recovery from '+loan.accountNo)
                        tfDr.save(flush:true)	
                
                        def dlDr = new TxnDepositAcctLedger(acct:deposit, acctNo:deposit.acctNo, bal:deposit.ledgerBalAmt - recoveryAmt,
                            branch:deposit.branch, debitAmt:recoveryAmt, currency:deposit.product.currency, status:deposit.status,
                            txnDate:currentDate, txnFile:tfDr, txnRef:'SOD Loan Recovery from '+loan.accountNo,passbookBal:0.00D,
                            txnType:TxnTemplate.get(drDepTxn).txnType, user:user)
                        dlDr.save(flush:true)     
                    
                        // update deposit
                        deposit.ledgerBalAmt -= recoveryAmt
                        deposit.availableBalAmt -= recoveryAmt
                        deposit.save(flush:true)
                        // credit loan
                        def tfCr = new TxnFile(acctNo:loan.accountNo, loanAcct:loan,
                            currency:loan.product.currency, user:user, branch:loan.branch,
                            txnAmt:recoveryAmt, txnCode:TxnTemplate.get(crLoanTxn).code, txnType:TxnTemplate.get(crLoanTxn).txnType,
                            txnDate:currentDate, txnTimestamp:new Date().toTimestamp(), status:ConfigItemStatus.get(2),
                            txnDescription:'SOD Loan Recovery from '+deposit.acctNo, txnRef:'SOD Loan Recovery from '+deposit.acctNo,
                            txnTemplate:TxnTemplate.get(crLoanTxn), txnParticulars:'SOD Loan Recovery from '+deposit.acctNo) 
                        tfCr.save(flush:true,failOnError:true)
                        
                        lnPayAmt = recoveryAmt
                        if (loan.serviceChargeBalanceAmount <= lnPayAmt) {
                            lnPayAmt -= loan.serviceChargeBalanceAmount
                            scPayAmt = loan.serviceChargeBalanceAmount                            
                            loan.serviceChargeBalanceAmount = 0.00
                        } else {
                            loan.serviceChargeBalanceAmount -= lnPayAmt
                            scPayAmt = lnPayAmt
                            lnPayAmt = 0.00
                        }
                        
                        if (loan.penaltyBalanceAmount <= lnPayAmt) {
                            lnPayAmt -= loan.penaltyBalanceAmount
                            penPayAmt = loan.penaltyBalanceAmount
                            loan.penaltyBalanceAmount = 0.00
                        } else {
                            loan.penaltyBalanceAmount -= lnPayAmt
                            penPayAmt = lnPayAmt
                            lnPayAmt = 0.00
                        }
                        if(loan.interestBalanceAmount > 0.00D){
                            if (loan.interestBalanceAmount <= lnPayAmt) {
                                
                                lnPayAmt -= loan.interestBalanceAmount
                                intPayAmt = loan.interestBalanceAmount
                                loan.interestBalanceAmount = 0.00
                            
                            } else {
                                loan.interestBalanceAmount -= lnPayAmt
                                intPayAmt = lnPayAmt
                                lnPayAmt = 0.00
                            }
                        } else {
                            
                            intPayAmt = 0.00D
										   
                        }
                        
                        if (loan.balanceAmount >= lnPayAmt) {
                            loan.balanceAmount -= lnPayAmt
                            prinPayAmt = lnPayAmt
                        } else {
                            prinPayAmt = loan.balanceAmount                           
                            loan.balanceAmount = 0.00
                        }
                        
                        loan.lastTransactionNo = tfCr.id
                        def txnSeqNo
                        if(loan.transactionSequenceNo == null) {
                            txnSeqNo = 0
                        } else {
                            txnSeqNo = loan.transactionSequenceNo
                        }
                        // automatically close loan for full payment
                        if (loan.balanceAmount == 0.00 && loan.interestBalanceAmount == 0.00 && loan.penaltyBalanceAmount == 0.00 && loan.serviceChargeBalanceAmount == 0.00) {
                            loan.status = LoanAcctStatus.get(6)
                        }
                        loan.transactionSequenceNo = txnSeqNo + 1    
                        loan.lastTransactionDate = currentDate          
                        loan.save(flush:true,failOnError:true)
                        
                        def lnPayDet = new TxnLoanPaymentDetails(acct:loan, acctNo:loan.accountNo, balForwarded:loan.balanceAmount,
                            branch:loan.branch, currency:loan.product.currency, interestAmt:intPayAmt, 
                            interestBalAfterPayment:loan.interestBalanceAmount, paymentAmt:recoveryAmt, 
                            penaltyAmt:penPayAmt, penaltyBalAfterPayment:loan.penaltyBalanceAmount,
                            principalAmt:prinPayAmt, principalBalAfterPayment:loan.balanceAmount,
                            serviceChargeAmt:scPayAmt, txnDate:currentDate, txnFile:tfCr, txnRef:tfCr.txnRef, user:user)
                        lnPayDet.save(flush:true,failOnError:true)
                        
                        def loanLedgerEntry = new LoanLedger(loan: loan, txnFile: tfCr, txnDate: currentDate, 
                            txnTemplate: TxnTemplate.get(crLoanTxn), txnRef: tfCr.txnRef, principalCredit: prinPayAmt, 
                            principalBalance: loan.balanceAmount, interestCredit: intPayAmt, 
                            interestBalance: loan.interestBalanceAmount, penaltyCredit: penPayAmt, 
                            penaltyBalance: loan.penaltyBalanceAmount, chargesCredit: scPayAmt)

                        loanLedgerEntry.save(flush:true,failOnError:true)                  
                        
                        // gl entries for loan recoveries
                        GlTransactionService.saveTxnBreakdown(tfDr.id)
                        GlTransactionService.saveTxnBreakdown(tfCr.id)
                        
                        def daily = new DailyLoanRecoveries(processDate:currentDate, loan:loan, 
                            txnFileDrDeposit:tfDr,txnFileCrLoan:tfCr )
                        daily.save(flush:true)
                        // reset total due
                        totalDue =- recoveryAmt
                    }
                }
            }
        }
    }
   
    
   
    
    def updateStatus(Date currentDate,Branch branch) {
        //update status when matured
        def l = new Loan()
        def db = new Sql(dataSource)
        def sqlstmt  = "select id from loan where balance_amount > 0 and maturity_date = '" +  currentDate+ "' and branch_id = "+branch.id
        def loans = db.rows(sqlstmt)
        
        
        for (ln in loans) {
            l = Loan.get(ln.id)
            l.merge()
            
            l.status = LoanAcctStatus.get(5)
            l.statusChangedDate = currentDate
            l.save(flush:true)
            
        }
    }
    
    def updatePastDueInterest(Date currentDate,Branch branch) {
        def l = new Loan()
        def db = new Sql(dataSource)
        def sqlstmt  = "select id from loan where balance_amount > 0 and maturity_date < '" +  currentDate.format('yyyy-MM-dd') + "' and branch_id = "+branch.id
        def loans = db.rows(sqlstmt)
        /*
        def loans = Loan.createCriteria().list() {
        and{
        eq("branch",branch)    
        gt("balanceAmount",0.00D)
        gt("maturityDate",currentDate)
        }
        }
         */
        Double intAmt
        for (ln in loans) {
            l = Loan.get(ln.id)
            l.merge()
            if (l.hasInterestAccrual) {
                intAmt = (l.balanceAmount.round(2) * l.interestRate.round(2) * 0.01).div(l.interestIncomeScheme.divisor)  
                intAmt = intAmt.round(2)
                l.interestBalanceAmount += intAmt
                l.save(flush:true)
            }
        }
    }

    
    def updatePenalties(Date currentDate,Branch branch) {
        def loan
        
        def db = new Sql(dataSource)
        def sqlstmt  = "select id from loan where status_id in (2,3,4,5) and branch_id = "+branch.id
        def loans = db.rows(sqlstmt)        
        // get all loans with past due installments
        /*
        def loans = Loan.createCriteria().list() {
        and{
        eq("branch",branch)    
        //loanInstallments {      
        //    and {
        //            lt("installmentDate", currentDate)
        //            ne("status.id", 5L)  // not fully paid
        //    }
        //}
        }
        }
         */

        for (ln in loans) {
            loan = Loan.get(ln.id)
            if(!loan.isAttached()) {
                loan.attach()
            }            
            // past due installments
            def installments = loan?.loanInstallments.findAll{it.installmentDate < currentDate && it.status.id != 5L}
            def overduePrincipal
            def cumPen = 0.00D
            def cumInstAmt = 0.00D
            def runningPen = 0.00D
	    def interestBalAmt
            def totalPen = 0.00D
            // println "loan " + loan.id
            
            for (installment in installments) {
                if(!installment.isAttached()) {
                    installment.attach()
                }
                // println "installment " + installment.id + " " + installment.installmentDate + " " + installment.status.id
                // loan age
                use(TimeCategory) {
                    def duration = currentDate - installment.installmentDate
                    println '----Days-----'
                    println installment
                    println duration.days
                    
                    if(installment.status.id == 5 || installment.status.id == 5L){
                        println("nstallment.status.id inside if: "+nstallment.status.id)
                        loan.ageInArrears = 0
                    }else{
                        if (duration.days > loan.ageInArrears) {
                            loan.ageInArrears = duration.days  
                        }
                    }                 
                }  // end TimeCategory  
                
                overduePrincipal = installment.principalInstallmentAmount - installment.principalInstallmentPaid
                interestBalAmt = installment.interestInstallmentAmount - installment.interestInstallmentPaid
                /*println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz")
                println "installment.principalInstallmentAmount: "+installment.principalInstallmentAmount
                println "installment.principalInstallmentPaid amount: "+installment.principalInstallmentPaid
                println "overduePrincipalvalue: "+overduePrincipal
                println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz")
                 */
                // update penalties                
                if (overduePrincipal > 0 || interestBalAmt > 0) {  // use status instead?
                    def penalty = 0.00D
                    def penBasis = 0.00D
                    if(!loan.isAttached()) {
                        loan.attach()
                    }
                    loan.merge()
                    if (loan?.currentPenaltyScheme?.type?.id == 1) {  // fixed amount
                        penalty = loan?.penaltyAmount
                    } else if (loan?.currentPenaltyScheme?.type?.id == 2) {  // rate based
                        def penRate = 0.00D
                        if (loan.loanPerformanceId.id == 1 || loan.loanPerformanceId.id == 2 || loan.loanPerformanceId.id == 3 || loan.loanPerformanceId.id == 4) {
                            penRate = loan?.currentPenaltyScheme.defaultPenaltyRate
                            penBasis = overduePrincipal
                            def pdPenRate = 0.00D
                            if (loan?.currentPenaltyScheme?.basis?.id == 2) {
                                penBasis = overduePrincipal + (installment.interestInstallmentAmount - installment.interestInstallmentPaid)
                            } else if (loan?.currentPenaltyScheme?.basis?.id == 3) {
                                penBasis = loan.balanceAmount
                            } else if (loan?.currentPenaltyScheme?.basis?.id == 4) {
                                penBasis = loan.balanceAmount + loan.interestBalanceAmount
                            }
                            penalty = (penBasis.round(2) * penRate.round(2) * 0.01) / loan?.currentPenaltyScheme?.divisor                            
                            
                            println penBasis
                            println penRate
                            println loan?.currentPenaltyScheme?.divisor
                         
                            // udate loan for current status penalty   
                        
                        }
                     
                    }
                    // for grace period, there should be no penalty
                    if (loan.loanPerformanceId.id == 1 || loan.loanPerformanceId.id == 2 || loan.loanPerformanceId.id == 3 || loan.loanPerformanceId.id == 4) {
                        if (loan.currentPenaltyScheme.gracePeriod > 0) {
                            def penaltyDate = installment.installmentDate.plus(loan.currentPenaltyScheme.gracePeriod)
                            if (penaltyDate > loan.branch.runDate) {
                                penalty = 0.00D
                            }
                        }
                    } 
                      
                    
                    // stop accruals
                    if (!loan.hasInterestAccrual) {
                        penalty = 0.00D
                    }
                    
                    // past due zero penalty as computed as part of main loan loop
                    if (loan.loanPerformanceId.id > 10) {
                        penalty = 0.00D
                    }
                    //installment.penaltyInstallmentAmount = installment.penaltyInstallmentAmount.round(2) +  penalty.round(2) 
                    //loan.penaltyBalanceAmount = loan.penaltyBalanceAmount + penalty
                    
                    //installment.penaltyInstallmentAmount = installment.penaltyInstallmentAmount.round(2)
                    //totalPen += installment.penaltyInstallmentAmount.round(2)
                    //totalPen += installment.penaltyInstallmentAmount.round(2) - installment.penaltyInstallmentPaid.round(2)
                    //loan.penaltyBalanceAmount = loan.penaltyBalanceAmount.round(2)                    
                    totalPen += penalty
                    println '*******************************************'
                    println loan.accountNo
                    println installment
                    println penalty
                    println '*******************************************'
                    
                } 

                // accrued interest
                if (installment.installmentDate == loan.maturityDate && loan.hasInterestAccrual) {
                    loan.accruedInterestDate = installment.installmentDate
                    loan.accruedInterestAmount += (overduePrincipal * loan?.interestRate * 0.01) / loan?.interestIncomeScheme?.divisor
                  
                    
                    loan.accruedInterestAmount = loan.accruedInterestAmount.round(2)
                    loan.interestBalanceAmount = loan.interestBalanceAmount.round(2)
                }
                // bangko mabuhay
                // before maturity
                if (Institution.findByParamCode('GEN.10000').paramValue == 'Bangko Mabuhay (A Rural Bank), Inc.') {
                    if (loan.maturityDate < loan.branch.runDate) {
                        // special penalty computation
                        cumInstAmt += (installment.principalInstallmentAmount + installment.interestInstallmentAmount + runningPen)
                        runningPen = cumInstAmt * loan?.penaltyRate.div(100)
                        cumPen += runningPen
                    } 
                }
                              
            }
            // udate loan for total penalty
            loan.penaltyBalanceAmount = loan.penaltyBalanceAmount + totalPen
            loan.penaltyBalanceAmount = loan.penaltyBalanceAmount.round(2)
            // for past due loans
            if (loan.loanPerformanceId.id > 10) {
                // update penalties 
                overduePrincipal = loan.overduePrincipalBalance
                if (overduePrincipal > 0) {  // use status instead?
                    def pdPenalty = 0.00D
                    def pdPenBasis = 0.00D
                    if (loan?.pastDuePenaltyScheme?.type?.id == 1) {  // fixed amount
                        pdPenalty = loan?.penaltyAmount
                    } else if (loan?.pastDuePenaltyScheme?.type?.id == 2) {  // rate based
                        def pdPenRate = 0.00D
                        pdPenRate = loan.pastDuePenaltyScheme.defaultPenaltyRate
                        pdPenBasis = loan.overduePrincipalBalance
                        if (loan?.pastDuePenaltyScheme?.basis?.id == 4) {
                            pdPenBasis = loan.balanceAmount + loan.interestBalanceAmount
                        }                            
                        pdPenalty = (pdPenBasis.round(2) * pdPenRate.round(2) * 0.01) / loan?.pastDuePenaltyScheme?.divisor
                    }
                    // save to loan
                    loan.penaltyBalanceAmount = loan.penaltyBalanceAmount.round(2) + pdPenalty.round(2)
                    loan.penaltyBalanceAmount = loan.penaltyBalanceAmount.round(2) 
                    
                    // bangko mabuhay
                    // before maturity
                    if (Institution.findByParamCode('GEN.10000').paramValue == 'Bangko Mabuhay (A Rural Bank), Inc.') {
                        if (loan.maturityDate < loan.branch.runDate) {
                            // special penalty computation
                            loan.penaltyBalanceAmount = cumPen
                            loan.penaltyBalanceAmount = loan.penaltyBalanceAmount.round(2) 
                        } 
                    }                    
                    println '%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%'
                    println loan.accountNo
                    println pdPenalty
                    println '%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%'
                    
                }                
            }            

            loan.save(failOnError:true)
        }
    }
    def updateOverduePrin(Date currentDate, Branch branch) {
        
        println("===================== updateOverduePrin ======================")
        println("branch: "+branch.name)
        def db = new Sql(dataSource)
        
        def sqlstmt1  = "select A.acct_id as id, sum(A.principal_amt) as prinAmt " +
            "from txn_loan_payment_details A " +
            "inner join txn_file B on A.txn_file_id = B.id " +
            "where B.status_id = 2 and A.txn_date = '" + currentDate.format('yyyy-MM-dd') + "' " +
            "and A.branch_id = " + branch.id + " " +
            "group by A.acct_id"
        
        def tpays = db.rows(sqlstmt1)
        Integer xrefresh = 0
        for(tp in tpays){
            def ln = Loan.get(tp.id)
            if(!ln.overduePrincipalBalance){
                ln.overduePrincipalBalance = 0.00D
            }
            if(!tp.prinAmt){
                tp.prinAmt = 0.00D
            }
            ln.overduePrincipalBalance = ln.overduePrincipalBalance - tp.prinAmt
            ln.overduePrincipalBalance = ln.overduePrincipalBalance.round(2)
            ln.save(flush:true,failOnError:true)
            xrefresh++
            if (xrefresh == 50 ){
                xrefresh = 1
                cleanUpLnGorm()
            }
        }
        
        //        def sqlstmt  = "select A.branch_id, A.id, C.prinamt "+
        //                " from loan A "+
        //                " inner join loan_loan_installment B on A.id = B.loan_loan_installments_id "+ 
        //                " inner join (select B.loan_loan_installments_id, round((sum(A.penalty_installment_amount)- sum(A.penalty_installment_paid))::numeric,2) as penAmt, "+ 
        //                " round((sum(A.interest_installment_amount) - sum(A.interest_installment_paid))::numeric,2) as intAmt, "+
        //                " round((sum(A.principal_installment_amount) - sum(A.principal_installment_paid))::numeric,2) as prinAmt from loan_installment A inner join loan_loan_installment B on A.id = B.loan_installment_id "+ 
        //                " where A.status_id in (3,4,5) group by B.loan_loan_installments_id) C on C.loan_loan_installments_id = B.loan_loan_installments_id "+
        //                " where A.status_id in (4,5) and A.overdue_principal_balance >= 0 and A.branch_id = " + branch.id + " " +
        //                " group by A.branch_id, A.id, C.prinamt "+
        //                " order by A.id "
        //        println sqlstmt
        //        def loanOverdueInstance = db.rows(sqlstmt)
        //        Integer i = 0
        //        for (lon in loanOverdueInstance){
        //            def loanInstance = Loan.get(lon.id)
        //            if(lon.prinamt >= loanInstance.balanceAmount){
        //                loanInstance.overduePrincipalBalance = loanInstance.balanceAmount
        //            } else {
        //                loanInstance.overduePrincipalBalance = lon.prinamt                
        //            }            
        //            loanInstance.save(flush:true,failOnError:true)
        //            i++
        //            if (i == 50 ){
        //                i = 1
        //                cleanUpLnGorm()
        //            }
        //        }
    }
    def postPaidInstallments(Date currentDate, Branch branch) {
        // get all loans with due installments
        Double scPayAmt
        Double penPayAmt
        Double intPayAmt
        Double prinPayAmt
        Double unpaidAmt
        Double scDueAmt
        Double penDueAmt
        Double intDueAmt
        Double prinDueAmt
        Boolean scPaid
        Boolean penPaid
        Boolean intPaid
        Boolean prinPaid
        def crLoanTxn = Institution.findByParamCode('LNS.50073').paramValue.toInteger()
        
        // get all payments
        def db = new Sql(dataSource)
        def sqlstmt  = "select A.acct_id as loan, sum(principal_amt) as principal, sum(interest_amt) as interest, " +
            "sum(penalty_amt) as penalty " +
            "from txn_loan_payment_details A " +
            "inner join txn_file B on A.txn_file_id = B.id " +
            "where B.status_id = 2 and A.txn_date = '" + currentDate.format('yyyy-MM-dd') + "' " +
            "and A.branch_id = " + branch.id + " " +
            "group by A.acct_id"
        println sqlstmt
        def payments = db.rows(sqlstmt)
        
        
       
            
        
        for (p in payments){
            def loan = Loan.get(p.loan)
            
               
//            def sql = new Sql(dataSource)
//            def query = "select sum(li.interest_installment_amount) - sum(li.interest_installment_paid) from loan_installment li inner join loan_loan_installment lli on lli.loan_installment_id = li.id inner join loan l on l.id = lli.loan_loan_installments_id where l.id = " + loan.id +" and li.status_id in (3,4)"         
//            def resultqueryall = sql.firstRow(query)
//            def resultString = resultqueryall.toString()
//            def outstandingInterest
//            println("resultString: " + resultString)
//            if(resultqueryall){
//           
//                println("sa if")
//                def getAfter = resultString.substring(resultString.lastIndexOf("=") + 1)               
//                def iend = getAfter.indexOf("}")             
//                outstandingInterest = getAfter.substring(0 , iend)
//                println("outstandingInterest: " + outstandingInterest)
//            } 
//            if (!outstandingInterest || outstandingInterest == "null"){
//                println("if walang laman ang outstandingInterest")
//                outstandingInterest = "0.00"
//            }
//            def doubleOutstandingInterest = outstandingInterest as Double
        def totalint = loan.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}
        def totalintpd = loan.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}
        if(totalint == null){
            totalint = 0
        }
        if(totalintpd == null){
            totalintpd = 0
        }
        def totalDue = 0.00D
        totalDue = totalint - totalintpd
       
            println("MICHAEL PDI CHECKING")
            println("Michael LoanId" + loan.id)
            println("p.interest: " + p.interest)
            println("loan.interestBalanceAmount: " + loan.interestBalanceAmount)
            println("totalDue: " + totalDue)
//            println("doubleOutstandingInterest: " + doubleOutstandingInterest)
           
                
            if(!p.penalty){
                p.penalty = 0.00D
            }
            
            prinPayAmt = p.principal
            intPayAmt = p.interest
            penPayAmt = p.penalty
            if((loan.interestBalanceAmount  >= totalDue) && (p.principal == 0.00D)){
                intPayAmt = 0.00D
            }
            if(loan.interestBalanceAmount  < totalDue){
                intPayAmt = totalDue  - loan.interestBalanceAmount 
            }
            
            // apply payment to installment
            if ((penPayAmt + intPayAmt + prinPayAmt) > 0) {
                
                def installments = loan?.loanInstallments.findAll{it.installmentDate <= currentDate && (it.status.id == 3L || it.status.id == 4L)}
                for (inst in installments.sort{it.installmentDate}) { 

                    penPaid = false
                    intPaid = false
                    prinPaid = false   
                    
                    penDueAmt = inst.penaltyInstallmentAmount - inst.penaltyInstallmentPaid
                    intDueAmt = inst.interestInstallmentAmount - inst.interestInstallmentPaid
                    prinDueAmt = inst.principalInstallmentAmount - inst.principalInstallmentPaid
                    
                    
                    
                    // check if zero/paid and mark as true
                    if (penDueAmt == 0) {
                        penPaid = true
                    }
                    if (intDueAmt == 0) {
                        intPaid = true
                    }
                    if (prinDueAmt == 0) {
                        prinPaid = true
                    }
                    // ============ payment
                    penPayAmt = penPayAmt.round(2)
                    intPayAmt = intPayAmt.round(2)
                    prinPayAmt = prinPayAmt.round(2)
                    // ============ due amount
                    penDueAmt = penDueAmt.round(2)
                    intDueAmt = intDueAmt.round(2)
                    prinDueAmt = prinDueAmt.round(2)
                    
                    //println("penPayAmt value: "+penPayAmt)
                    //println("penDueAmt value: "+penDueAmt)
                    if ((penPayAmt > 0) && (penDueAmt > 0)) {
                        println("condition pass: 2")
                        if (penPayAmt >= penDueAmt) {
                            println("condition pass: 2a")
                            inst.penaltyInstallmentPaid = inst.penaltyInstallmentAmount
                            penPayAmt -= penDueAmt
                            penPaid = true
                        } else {
                            println("condition pass: 2b")
                            inst.penaltyInstallmentPaid += penPayAmt
                            penPayAmt = 0.00
                            penPaid = false
                        }
                    }  
                    //println("intPayAmt value: "+intPayAmt)
                    //println("intDueAmt value: "+intDueAmt)
                    if ((intPayAmt > 0) && (intDueAmt > 0)) {
                        //println("condition pass: 3")
                        if (intPayAmt >= intDueAmt) {
                            //println("condition pass: 3a")
                            inst.interestInstallmentPaid = inst.interestInstallmentAmount
                            intPayAmt -= intDueAmt
                            intPaid = true
                        } else {
                            //println("condition pass: 3b")
                            inst.interestInstallmentPaid += intPayAmt
                            intPayAmt = 0.00
                            intPaid = false
                        }
                    }
                    //println("prinPayAmt value: "+prinPayAmt)
                    //println("prinDueAmt value: "+prinDueAmt)
                    if ((prinPayAmt > 0) && (prinDueAmt > 0)) {
                        //println("condition pass: 4")
                        if (prinPayAmt >= prinDueAmt) {
                            //println("condition pass: 4a")
                            inst.principalInstallmentPaid = inst.principalInstallmentAmount
                            prinPayAmt -= prinDueAmt
                            prinPaid = true
                            
                        } else {
                            //println("condition pass: 4b")
                            inst.principalInstallmentPaid += prinPayAmt
                            prinPayAmt = 0.00
                            prinPaid = false
                        }
                    }       
      
                       
                    if(inst.principalInstallmentPaid > 0 || inst.interestInstallmentPaid > 0 ||inst.penaltyInstallmentPaid > 0){
                        // to determine if paid use principal and installment only
                        if(inst.principalInstallmentPaid >= inst.principalInstallmentAmount && inst.interestInstallmentPaid >= inst.interestInstallmentAmount){
                            println("setting installment status fully paid.......")
                            inst.datePaid = loan.branch.runDate
                            inst.status = LoanInstallmentStatus.get(5)
                            loan.ageInArrears = 0
                            loan.save(flush:true)  
                            println("setting fully paid Done..")
                        }else{
                            println("setting status  = Partially Paid")
                            inst.datePaid = loan.branch.runDate
                            inst.status = LoanInstallmentStatus.get(4)
			    use(TimeCategory) {
                                def duration = currentDate - inst.installmentDate
                                println '----Days-----'
                                
                                println("installment.status.id: "+inst.status.id)
                                println("Start of day duration days: "+duration.days)
                    
                    
                                if (duration.days > loan.ageInArrears) {
                                    loan.ageInArrears = duration.days  
                                    //ln.save(flush:true)
                                }
                    
                    
                            }  // end TimeCategory  	
                            loan.save(flush:true)  
                            println("setting status = Partially Paid Done...")
                        }  
                    }
                    
                    if (prinPaid==true && intPaid==true && penPaid==true) {
                        println("condition pass: 5")
                        println("setting installment status fully paid.......")
                        inst.datePaid = loan.branch.runDate
                        inst.status = LoanInstallmentStatus.get(5)
                        loan.ageInArrears = 0
                        loan.save(flush:true)  
                        println("setting fully paid Done..")
                    }
                    
                    inst.save()

                    println 'Loan paid Installment Check **************************************'
                    println loan.accountNo
                    println inst
                    //println scPaid
                    println penPaid
                    println intPaid
                    println prinPaid
                    //println scPayAmt
                    println penPayAmt
                    println intPayAmt
                    println prinPayAmt
                    //println scDueAmt
                    println penDueAmt 
                    println intDueAmt 
                    println prinDueAmt 
                    println loan.overduePrincipalBalance
                    println '******************************************************************'
                   
                }
            }
        }

        //payments for loan ledger
        def dbledger = new Sql(dataSource)
        def sqlstmtledger  = "select A.loan_id as loan, sum(principal_debit) as principal, sum(interest_credit) as interest, " +
            "sum(penalty_credit) as penalty " +
            "from loan_ledger A " +
        
            "inner join txn_file B on A.txn_file_id = B.id " +
            "where B.status_id = 2 and A.txn_date = '" + currentDate.format('yyyy-MM-dd') + "' " +
            "and B.branch_id = " + branch.id + " and A.txn_type_id in (4,7,9) " +
            "group by A.loan_id"
        println sqlstmtledger
        def paymentsledger = dbledger.rows(sqlstmtledger)
        
        
       
            
        
        for (p in paymentsledger){
            def loan = Loan.get(p.loan)
            
               
//            def sql = new Sql(dataSource)
//            def query = "select sum(li.interest_installment_amount) - sum(li.interest_installment_paid) from loan_installment li inner join loan_loan_installment lli on lli.loan_installment_id = li.id inner join loan l on l.id = lli.loan_loan_installments_id where l.id = " + loan.id +" and li.status_id in (3,4)"         
//            def resultqueryall = sql.firstRow(query)
//            def resultString = resultqueryall.toString()
//            def outstandingInterest
//            println("resultString: " + resultString)
//            if(resultqueryall){
//           
//                println("sa if")
//                def getAfter = resultString.substring(resultString.lastIndexOf("=") + 1)               
//                def iend = getAfter.indexOf("}")             
//                outstandingInterest = getAfter.substring(0 , iend)
//                println("outstandingInterest: " + outstandingInterest)
//            } 
//            if (!outstandingInterest || outstandingInterest == "null"){
//                println("if walang laman ang outstandingInterest")
//                outstandingInterest = "0.00"
//            }
//            def doubleOutstandingInterest = outstandingInterest as Double
        def totalint = loan.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}
        def totalintpd = loan.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}
        if(totalint == null){
            totalint = 0
        }
        if(totalintpd == null){
            totalintpd = 0
        }
        def totalDue = 0.00D
        totalDue = totalint - totalintpd
       
            println("MICHAEL PDI CHECKING")
            println("Michael LoanId" + loan.id)
            println("p.interest: " + p.interest)
            println("loan.interestBalanceAmount: " + loan.interestBalanceAmount)
            println("totalDue: " + totalDue)
//            println("doubleOutstandingInterest: " + doubleOutstandingInterest)
           
                
            if(!p.penalty){
                p.penalty = 0.00D
            }
            
            prinPayAmt = p.principal
            intPayAmt = p.interest
            penPayAmt = p.penalty
            if((loan.interestBalanceAmount  >= totalDue) && (p.principal == 0.00D)){
                intPayAmt = 0.00D
            }
            if(loan.interestBalanceAmount  < totalDue){
                intPayAmt = totalDue - loan.interestBalanceAmount 
            }
            
            // apply payment to installment
            if ((penPayAmt + intPayAmt + prinPayAmt) > 0) {
                
                def installments = loan?.loanInstallments.findAll{it.installmentDate <= currentDate && (it.status.id == 3L || it.status.id == 4L)}
                for (inst in installments.sort{it.installmentDate}) { 

                    penPaid = false
                    intPaid = false
                    prinPaid = false   
                    
                    penDueAmt = inst.penaltyInstallmentAmount - inst.penaltyInstallmentPaid
                    intDueAmt = inst.interestInstallmentAmount - inst.interestInstallmentPaid
                    prinDueAmt = inst.principalInstallmentAmount - inst.principalInstallmentPaid
                    
                    
                    
                    // check if zero/paid and mark as true
                    if (penDueAmt == 0) {
                        penPaid = true
                    }
                    if (intDueAmt == 0) {
                        intPaid = true
                    }
                    if (prinDueAmt == 0) {
                        prinPaid = true
                    }
                    // ============ payment
                    penPayAmt = penPayAmt.round(2)
                    intPayAmt = intPayAmt.round(2)
                    prinPayAmt = prinPayAmt.round(2)
                    // ============ due amount
                    penDueAmt = penDueAmt.round(2)
                    intDueAmt = intDueAmt.round(2)
                    prinDueAmt = prinDueAmt.round(2)
                    
                    //println("penPayAmt value: "+penPayAmt)
                    //println("penDueAmt value: "+penDueAmt)
                    if ((penPayAmt > 0) && (penDueAmt > 0)) {
                        println("condition pass: 2")
                        if (penPayAmt >= penDueAmt) {
                            println("condition pass: 2a")
                            inst.penaltyInstallmentPaid = inst.penaltyInstallmentAmount
                            penPayAmt -= penDueAmt
                            penPaid = true
                        } else {
                            println("condition pass: 2b")
                            inst.penaltyInstallmentPaid += penPayAmt
                            penPayAmt = 0.00
                            penPaid = false
                        }
                    }  
                    //println("intPayAmt value: "+intPayAmt)
                    //println("intDueAmt value: "+intDueAmt)
                    if ((intPayAmt > 0) && (intDueAmt > 0)) {
                        //println("condition pass: 3")
                        if (intPayAmt >= intDueAmt) {
                            //println("condition pass: 3a")
                            inst.interestInstallmentPaid = inst.interestInstallmentAmount
                            intPayAmt -= intDueAmt
                            intPaid = true
                        } else {
                            //println("condition pass: 3b")
                            inst.interestInstallmentPaid += intPayAmt
                            intPayAmt = 0.00
                            intPaid = false
                        }
                    }
                    //println("prinPayAmt value: "+prinPayAmt)
                    //println("prinDueAmt value: "+prinDueAmt)
                    if ((prinPayAmt > 0) && (prinDueAmt > 0)) {
                        //println("condition pass: 4")
                        if (prinPayAmt >= prinDueAmt) {
                            //println("condition pass: 4a")
                            inst.principalInstallmentPaid = inst.principalInstallmentAmount
                            prinPayAmt -= prinDueAmt
                            prinPaid = true
                            
                        } else {
                            //println("condition pass: 4b")
                            inst.principalInstallmentPaid += prinPayAmt
                            prinPayAmt = 0.00
                            prinPaid = false
                        }
                    }       
      
                       
                    if(inst.principalInstallmentPaid > 0 || inst.interestInstallmentPaid > 0 ||inst.penaltyInstallmentPaid > 0){
                        // to determine if paid use principal and installment only
                        if(inst.principalInstallmentPaid >= inst.principalInstallmentAmount && inst.interestInstallmentPaid >= inst.interestInstallmentAmount){
                            println("setting installment status fully paid.......")
                            inst.datePaid = loan.branch.runDate
                            inst.status = LoanInstallmentStatus.get(5)
                            loan.ageInArrears = 0
                            loan.save(flush:true)  
                            println("setting fully paid Done..")
                        }else{
                            println("setting status  = Partially Paid")
                            inst.datePaid = loan.branch.runDate
                            inst.status = LoanInstallmentStatus.get(4)
			    use(TimeCategory) {
                                def duration = currentDate - inst.installmentDate
                                println '----Days-----'
                                
                                println("installment.status.id: "+inst.status.id)
                                println("Start of day duration days: "+duration.days)
                    
                    
                                if (duration.days > loan.ageInArrears) {
                                    loan.ageInArrears = duration.days  
                                    //ln.save(flush:true)
                                }
                    
                    
                            }  // end TimeCategory  	
                            loan.save(flush:true)  
                            println("setting status = Partially Paid Done...")
                        }  
                    }
                    
                    if (prinPaid==true && intPaid==true && penPaid==true) {
                        println("condition pass: 5")
                        println("setting installment status fully paid.......")
                        inst.datePaid = loan.branch.runDate
                        inst.status = LoanInstallmentStatus.get(5)
                        loan.ageInArrears = 0
                        loan.save(flush:true)  
                        println("setting fully paid Done..")
                    }
                    
                    inst.save()

                    println 'Loan paid Installment Check **************************************'
                    println loan.accountNo
                    println inst
                    //println scPaid
                    println penPaid
                    println intPaid
                    println prinPaid
                    //println scPayAmt
                    println penPayAmt
                    println intPayAmt
                    println prinPayAmt
                    //println scDueAmt
                    println penDueAmt 
                    println intDueAmt 
                    println prinDueAmt 
                    println loan.overduePrincipalBalance
                    println '******************************************************************'
                   
                }
            }
        }
        
    }															   
    def updatePaidInstallments(Date currentDate, Branch branch) {
        // get all loans with due installments
        Double scPayAmt
        Double penPayAmt
        Double intPayAmt
        Double prinPayAmt
        Double unpaidAmt
        Double scDueAmt
        Double penDueAmt
        Double intDueAmt
        Double prinDueAmt
        Boolean scPaid
        Boolean penPaid
        Boolean intPaid
        Boolean prinPaid
        def crLoanTxn = Institution.findByParamCode('LNS.50073').paramValue.toInteger()
        
        def loans = Loan.createCriteria().list() {
            and{
                eq("branch",branch)
                loanInstallments {      
                    and {
                        le("installmentDate", currentDate)
                        ge("status.id", 3L)
                        le("status.id", 4L)
                    }
                }
            }
        }
        def lncountxxxer = 0
        def validateloanid = 0						  
        for (ln in loans) {
            lncountxxxer = lncountxxxer + 1
            //println("for loop ln in loans  lncounterxxer value: "+lncountxxxer)
            scPayAmt = 0.00
            penPayAmt = 0.00
            intPayAmt = 0.00
            prinPayAmt = 0.00
            unpaidAmt = 0.00
            /*println 'updatePaidInstallments >> ' + ln 
            println("current Date: "+currentDate)
            println("ln value: "+ln)
            println("current date in parameter: "+currentDate)*/
            
            def loanid 												 
            def ledger = LoanLedger.findAllByLoanAndTxnDate(ln,currentDate)
            
            
            if(validateloanid==ln){
                println("validate loop for duplicate id: "+validateloanid)
            }else{
                //println("else condition be like")
                for (t in ledger) {
                    //if (t.txnTemplate.txnType.id in [30,40]){
                    if (t.txnTemplate.txnType.id == 30 || t.txnTemplate.txnType.id == 40){
                        continue;
                    }else{
                            
                        
				  

                        validateloanid = ln
                        /*println("validateloanid value: "+validateloanid)
                        println("t value: "+t)
                        println("t in ledger id: "+t.id)
                        println("t.chargesCredit: "+t.chargesCredit)
                        println("t.penaltyCredit: "+t.penaltyCredit)
                        println("t.interestCredit: "+t.interestCredit)
                        println("t.principalCredit: "+t.principalCredit) */

                        /*
                        iff ((t.txnType >= TxnType.get(12)) && (t.txnType <= TxnType.get(15)) && (t.status == ConfigItemStatus.read(2))) {
                        scPayAmt += t.chargesCredit
                        penPayAmt += t.penaltyCredit
                        intPayAmt += t.intrestCredit
                        prinPayAmt += t.principalCredit                   
                        }
                         */
                        if ((t.chargesCredit > 0) && (t.chargesDebit == 0)){
                            scPayAmt += t.chargesCredit 
                        }
                        if (t.penaltyCredit > 0) {
                            penPayAmt += t.penaltyCredit 
                        }
                        if ((t.interestCredit > 0) && (t.interestDebit == 0)) {
                            intPayAmt += t.interestCredit 
                        }
                        if (t.principalCredit > 0) {
                            prinPayAmt += t.principalCredit  
                        }
                    }    
                }                
            }
            // apply principal to overdue
            //if (prinPayAmt > 0) {
            //    ln.overduePrincipalBalance =- prinPayAmt
            //    ln.save(flush:true)
            //}            
            /* println("-----------------------------------jm")
            println("Service charge payment amount as ->scPayAmt value: "+scPayAmt)
            println("Penalty payment amount as -> penPayAmt value: "+penPayAmt)
            println("Interest payment amount as -> intPayAmt value: "+intPayAmt)
            println("principal payment amount as -> prinPayAmt value: "+prinPayAmt)
            println("-----------------------------------jm") */								
            if ((scPayAmt + penPayAmt + intPayAmt + prinPayAmt) > 0) {
                println("condition scPayAmt + penPayAmt + intPayAmt + prinPayAmt ========= greater sa zero")
                def installments = ln?.loanInstallments.findAll{it.installmentDate <= currentDate && (it.status.id == 3L || it.status.id == 4L)}
                for (inst in installments.sort{it.installmentDate}) {         
                    
                    scPaid = false
                    penPaid = false
                    intPaid = false
                    prinPaid = false   
                    
                    //println("inst.serviceChargeInstallmentAmount: "+inst.serviceChargeInstallmentAmount+" - inst.serviceChargeInstallmentPaid: "+inst.serviceChargeInstallmentPaid)
                    scDueAmt = inst.serviceChargeInstallmentAmount - inst.serviceChargeInstallmentPaid
                    //println("scDueAmt value: "+scDueAmt)
                    //println("----------------------------------")
                    //println("inst.penaltyInstallmentAmount: "+inst.penaltyInstallmentAmount+" - inst.penaltyInstallmentPaid: "+inst.penaltyInstallmentPaid)
                    penDueAmt = inst.penaltyInstallmentAmount - inst.penaltyInstallmentPaid
                    //println("penDueAmt value: "+penDueAmt)
                    //println("----------------------------------")
                    //println("inst.interestInstallmentAmount: "+inst.interestInstallmentAmount+" - inst.interestInstallmentPaid: "+inst.interestInstallmentPaid)
                    intDueAmt = inst.interestInstallmentAmount - inst.interestInstallmentPaid
                    //println("intDueAmt value: "+intDueAmt)
                    //println("----------------------------------")
                    //println("inst.principalInstallmentAmount: "+inst.principalInstallmentAmount+" - inst.principalInstallmentPaid: "+inst.principalInstallmentPaid)
                    prinDueAmt = inst.principalInstallmentAmount - inst.principalInstallmentPaid
                    //println("prinDueAmt value: "+prinDueAmt)
                    //println("----------------------------------")
                    
                    // check if zero/paid and mark as true
                    if (scDueAmt == 0) {
                        scPaid = true
                    }
                    if (penDueAmt == 0) {
                        penPaid = true
                    }
                    if (intDueAmt == 0) {
                        intPaid = true
                    }
                    if (prinDueAmt == 0) {
                        prinPaid = true
                    }
                    // ============ payment
                    scPayAmt = scPayAmt.round(2)
                    penPayAmt = penPayAmt.round(2)
                    intPayAmt = intPayAmt.round(2)
                    prinPayAmt = prinPayAmt.round(2)
                    // ============ due amount
                    scDueAmt = scDueAmt.round(2)
                    penDueAmt = penDueAmt.round(2)
                    intDueAmt = intDueAmt.round(2)
                    prinDueAmt = prinDueAmt.round(2)
                    
                    //println("scPayamt value: "+scPayAmt)
                    //println("scDueAmt value: "+scDueAmt)
                    if ((scPayAmt > 0) && (scDueAmt > 0)) {
                        println("condition pass: 1")
                        if (scPayAmt >= scDueAmt) {
                            println("condition pass: 1a")
                            inst.serviceChargeInstallmentPaid = inst.serviceChargeInstallmentAmount
                            scPayAmt -= scDueAmt
                            scPaid = true
                        } else {
                            println("condition pass: 1b")
                            inst.serviceChargeInstallmentPaid += scPayAmt
                            scPayAmt = 0.00
                            scPaid = false
                        }
                    }
                    //println("penPayAmt value: "+penPayAmt)
                    //println("penDueAmt value: "+penDueAmt)
                    if ((penPayAmt > 0) && (penDueAmt > 0)) {
                        println("condition pass: 2")
                        if (penPayAmt >= penDueAmt) {
                            println("condition pass: 2a")
                            inst.penaltyInstallmentPaid = inst.penaltyInstallmentAmount
                            penPayAmt -= penDueAmt
                            penPaid = true
                        } else {
                            println("condition pass: 2b")
                            inst.penaltyInstallmentPaid += penPayAmt
                            penPayAmt = 0.00
                            penPaid = false
                        }
                    }  
                    //println("intPayAmt value: "+intPayAmt)
                    //println("intDueAmt value: "+intDueAmt)
                    if ((intPayAmt > 0) && (intDueAmt > 0)) {
                        //println("condition pass: 3")
                        if (intPayAmt >= intDueAmt) {
                            //println("condition pass: 3a")
                            inst.interestInstallmentPaid = inst.interestInstallmentAmount
                            intPayAmt -= intDueAmt
                            intPaid = true
                        } else {
                            //println("condition pass: 3b")
                            inst.interestInstallmentPaid += intPayAmt
                            intPayAmt = 0.00
                            intPaid = false
                        }
                    }
                    //println("prinPayAmt value: "+prinPayAmt)
                    //println("prinDueAmt value: "+prinDueAmt)
                    if ((prinPayAmt > 0) && (prinDueAmt > 0)) {
                        //println("condition pass: 4")
                        if (prinPayAmt >= prinDueAmt) {
                            //println("condition pass: 4a")
                            inst.principalInstallmentPaid = inst.principalInstallmentAmount
                            prinPayAmt -= prinDueAmt
                            prinPaid = true
                            
                        } else {
                            //println("condition pass: 4b")
                            inst.principalInstallmentPaid += prinPayAmt
                            prinPayAmt = 0.00
                            prinPaid = false
                        }
                    }       
                    
                    
                    /*println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println("scPaid: "+scPaid)
                    println("penPaid: "+penPaid)
                    println("intPaid: "+intPaid)
                    println("prinPaid: "+prinPaid)
                    println("STATUS ID : "+inst.status)
                    println("DUE SEQUENCE NO: "+inst.sequenceNo)
                    println("principal installment paid value: "+inst.principalInstallmentPaid)
                    println("interest installment paid value: "+inst.interestInstallmentPaid)
                    println("Penalty installment paid value: "+inst.penaltyInstallmentPaid)
                    println("Service Charge installment paid value: "+inst.serviceChargeInstallmentPaid)
                    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx") */
                        
                    // if(prinPaid==true || intPaid==true ){
                    // inst.status = LoanInstallmentStatus.get(5) 
                    // }       
                       
                    if(inst.principalInstallmentPaid > 0 || inst.interestInstallmentPaid > 0 ||inst.penaltyInstallmentPaid > 0 || inst.serviceChargeInstallmentPaid > 0){
                        // to determine if paid use principal and installment only
                        if(inst.principalInstallmentPaid >= inst.principalInstallmentAmount && inst.interestInstallmentPaid >= inst.interestInstallmentAmount){
                            println("setting installment status fully paid.......")
                            inst.datePaid = ln.branch.runDate
                            inst.status = LoanInstallmentStatus.get(5)
                            ln.ageInArrears = 0
                            ln.save(flush:true)  
                            println("setting fully paid Done..")
                        }else{
                            println("setting status  = Partially Paid")
                            inst.datePaid = ln.branch.runDate
                            inst.status = LoanInstallmentStatus.get(4)
			    use(TimeCategory) {
                                def duration = currentDate - inst.installmentDate
                                println '----Days-----'
                                
                                println("installment.status.id: "+inst.status.id)
                                println("Start of day duration days: "+duration.days)
                    
                    
                                if (duration.days > ln.ageInArrears) {
                                    ln.ageInArrears = duration.days  
                                    //ln.save(flush:true)
                                }
                    
                    
                            }  // end TimeCategory  	
                            ln.save(flush:true)  
                            println("setting status = Partially Paid Done...")
                        }  
                    }
                    
                    if (prinPaid==true && intPaid==true && penPaid==true && scPaid==true) {
                        println("condition pass: 5")
                        println("setting installment status fully paid.......")
                        inst.datePaid = ln.branch.runDate
                        inst.status = LoanInstallmentStatus.get(5)
                        ln.ageInArrears = 0
                        ln.save(flush:true)  
                        println("setting fully paid Done..")
                    }
                    
                    inst.save()

                    println 'Loan paid Installment Check **************************************'
                    println ln.accountNo
                    println inst
                    println scPaid
                    println penPaid
                    println intPaid
                    println prinPaid
                    println scPayAmt
                    println penPayAmt
                    println intPayAmt
                    println prinPayAmt
                    println scDueAmt
                    println penDueAmt 
                    println intDueAmt 
                    println prinDueAmt 
                    println ln.overduePrincipalBalance
                    println '******************************************************************'
                }     
            }
        }
    }
    def updateCancelledPayments(Date currentDate, Branch branch){
        println("=============== updateCancelledPayments =================")
        def newPrinPd = 0.00D
        def newIntPd = 0.00D
        def txnAmt = 0.00D
        
        def db = new Sql(dataSource)
        def sqlstmt  = "select A.id, A.loan_acct_id as loan, A.txn_amt as amt " +
            "from txn_file A " +
            "inner join txn_template B on A.txn_template_id = B.id " +
            "inner join loan C on A.loan_acct_id = C.id " + 
            "where (B.memo_txn_type_id = 6 or B.txn_type_id = 68) and A.txn_date = '" + currentDate.format('yyyy-MM-dd') + "' " +
            "and C.branch_id = " + branch.id 

        def cancels = db.rows(sqlstmt)     
        for (c in cancels){
            def loan = Loan.get(c.loan)
            
            txnAmt = c.amt
            def tx = TxnFile.get(c.id)
            def intAmt = 0.00D
            if (tx.txnType.id == 68){
                def lnLed = LoanLedger.findByTxnFile(tx)
                txnAmt = lnLed.principalDebit
                intAmt = lnLed.interestDebit
            }

            /*

            def idb = new Sql(dataSource)
            def sqlstmti  = "select A.id as instid from loan_installment A " +
            "inner join loan_loan_installment B on A.id = B.loan_installment_id " +
            "inner join loan C on C.id = B.loan_loan_installments_id " +
            "inner join branch D on C.branch_id = D.id " +
            "where A.installment_date < D.run_date and A.status_id in (4,5) and C.id =" + c.loan + " "
            "order by A.installment_date desc"
            def inst = idb.rows(sqlstmti)
             */
            def installments = loan?.loanInstallments.findAll{it.installmentDate < currentDate && (it.status.id == 4L || it.status.id == 5L)}
            
            for (i in installments.sort{it.installmentDate}.reverse()){

                newPrinPd = 0.00D
                newIntPd = 0.00D
                def instRec = i
                println '********* installment check ***********'
                println instRec.installmentDate
                println instRec.sequenceNo
                println instRec.principalInstallmentPaid
                println instRec.interestInstallmentPaid
                println instRec.status
                
                // principal
                if (txnAmt >= instRec.principalInstallmentPaid) {
                    newPrinPd = 0.00D
                    txnAmt = txnAmt - instRec.principalInstallmentPaid
                } else {
                    newPrinPd = instRec.principalInstallmentPaid - txnAmt
                    txnAmt = 0.00D
                }
                
                // interest
                if (intAmt >= instRec.interestInstallmentPaid) {
                    newIntPd = 0.00D
                    intAmt = intAmt - instRec.interestInstallmentPaid
                } else {
                    newIntPd = instRec.interestInstallmentPaid - intAmt
                    intAmt = 0.00D
                }    
                
                instRec.principalInstallmentPaid = newPrinPd
                instRec.interestInstallmentPaid = newIntPd
                
                if (newPrinPd == 0.00D && newIntPd == 0.00D) {
                    instRec.status = LoanInstallmentStatus.get(3)
                } else {
                    instRec.status = LoanInstallmentStatus.get(4)
                }
                
                instRec.save(flush:true, failOnError:true)
                
                if (txnAmt == 0.00D && intAmt == 0.00D){
                    break;
                }                
            }
        }
        println("============= DONE updateCancelledPayments ")
    } 
    def updateLoanAge(Date currentDate, Branch branch,UserMaster user) {
        // get all loans with past due installments
        Integer i = 0
        println("============== UPDATE LOAN AGE =================")
        def db = new Sql(dataSource)
        def sqlstmt  = "select C.id, case when max(DATE_PART('day', D.run_date - A.installment_Date)) > 0 " +
            "then max(DATE_PART('day', D.run_date - A.installment_Date)) else 0 end as days " +
            "from loan C " +
            "inner join branch D on C.branch_id = D.id " +
            "inner join loan_loan_installment B on B.loan_loan_installments_id = C.id " +
            "left outer join loan_installment A  on B.loan_installment_id = A.id " +
        //"and A.installment_Date < D.run_date and A.principal_installment_paid < A.principal_installment_amount " +
            "and A.status_id in (3,4) " +
            "where c.balance_amount > 0 and c.status_id in (4,5) " +
            "and C.branch_id = " + branch.id + " group by C.id order by C.id"

        def loans = db.rows(sqlstmt) 
        /*
        def loans = Loan.createCriteria().list() {
        and{
        eq("branch",branch)    
        loanInstallments {      
        and {
        lt("installmentDate", currentDate)
        ne("status.id", 5L)  // not fully paid
        }
        order("installmentDate","desc")
        }
        }
        }
         */
        int daysAge    

        for (ln in loans) {
            def loan = Loan.get(ln.id)
            loan.ageInArrears = ln.days 
            loan.save(flush:true) 
            println("loan.ageInArrears: "+loan.ageInArrears)
            println("loan.loanPerformanceId.id: "+loan.loanPerformanceId.id)
            //if (loan.ageInArrears == 0 && loan.loanPerformanceId.id != 1) {
		
            
            def newPerformanceId = null
            def pDesc = ''
            loan.merge()
            
            // == check if restructed and reschedule
            def isRescheduleResTructured = LoanNonReclassToCurrentPointer.findByCfgAcctGlTemplate(loan.glLink)
            if(isRescheduleResTructured){
                //continue
            }else{
                if (loan.ageInArrears == 0 && loan.loanPerformanceId.id != 1 && loan.product.isMicrofinance == true) {    
                    println("========= CONDITION: loan.ageInArrears == 0 && loan.loanPerformanceId.id != 1 entered")
                    println("loan.ageInArrears: "+loan.ageInArrears)
                    def pId = LoanPerformanceId.get(1) 
                    def txnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
                    def tf = new TxnFile(acctNo:loan.accountNo, branch:loan.branch, currency:loan.product.currency,
                        loanAcct:loan, status:ConfigItemStatus.read(2), txnAmt:loan.balanceAmount, txnCode:txnTmp.code,
                        txnDate:loan.branch.runDate, txnDescription:'Updated - reclassify microfinance to current status', 
                        txnParticulars:'To automatically reclassify microfinance loan to current',
                        txnRef:'Periodic Loan Reclass', txnTemplate:txnTmp, txnType:txnTmp.txnType,
                        txnTimestamp:new Date().toTimestamp(), user:user)
                    tf.save(flush:true)
                    println("Updated - reclassify to current status")
                    def ll = new LoanLedger(loan:loan, principalDebit:loan.balanceAmount, principalCredit:loan.balanceAmount, 
                        principalBalance:loan.balanceAmount, txnFile:tf, txnCode:tf.txnCode, txnDate:loan.branch.runDate,
                        txnRef:tf.txnRef, txnParticulars:'Automatic Reclassification to current - microfinance', txnTemplate:tf.txnTemplate)
                    ll.save(flush:true)
                    println("Automatic Reclassification to current")

                    def rc = new LoanReClassHist(loanAcct:loan, newClass:pId, oldClass:loan.loanPerformanceId, reclassDate:loan.branch.runDate,
                        reclassDesc:'Updated - reclassify microfinance to current status', txnFile:tf)
                    rc.save(flush:true, failOnError:true)            

                    loan.loanPerformanceId = pId
                    loan.save(flush:true)
                
                    GlTransactionService.saveTxnBreakdown(tf.id)
                    println("loan account number: "+loan.accountNo)
                    println("Loan Age: "+loan.ageInArrears)
                    println("Loan Performance ID: "+loan.loanPerformanceId.id)
                    println '**** transferred ****'  
                
                } else if (loan.ageInArrears == 0 && loan.loanPerformanceId.id == 2){
                    println("========= CONDITION: loan.ageInArrears == 0 && loan.loanPerformanceId.id == 2 entered")
                    println("loan.ageInArrears: "+loan.ageInArrears)
                    def pId = LoanPerformanceId.get(1) 
                    def txnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
                    def tf = new TxnFile(acctNo:loan.accountNo, branch:loan.branch, currency:loan.product.currency,
                        loanAcct:loan, status:ConfigItemStatus.read(2), txnAmt:loan.balanceAmount, txnCode:txnTmp.code,
                        txnDate:loan.branch.runDate, txnDescription:'Updated - reclassify past due loan with updated payment to current status', 
                        txnParticulars:'To automatically reclassify past due loan with updated payment loan to current',
                        txnRef:'Periodic Loan Reclass', txnTemplate:txnTmp, txnType:txnTmp.txnType,
                        txnTimestamp:new Date().toTimestamp(), user:user)
                    tf.save(flush:true)
                    println("Updated - reclassify to current status")
                    def ll = new LoanLedger(loan:loan, principalDebit:loan.balanceAmount, principalCredit:loan.balanceAmount, 
                        principalBalance:loan.balanceAmount, txnFile:tf, txnCode:tf.txnCode, txnDate:loan.branch.runDate,
                        txnRef:tf.txnRef, txnParticulars:'Automatic Reclassification to current - past due loan with updated payment', txnTemplate:tf.txnTemplate)
                    ll.save(flush:true)
                    println("Automatic Reclassification to current")

                    def rc = new LoanReClassHist(loanAcct:loan, newClass:pId, oldClass:loan.loanPerformanceId, reclassDate:loan.branch.runDate,
                        reclassDesc:'Updated - reclassify past due loan with updated payment to current status', txnFile:tf)
                    rc.save(flush:true, failOnError:true)            

                    loan.loanPerformanceId = pId
                    loan.save(flush:true)
                
                    GlTransactionService.saveTxnBreakdown(tf.id)
                    println("loan account number: "+loan.accountNo)
                    println("Loan Age: "+loan.ageInArrears)
                    println("Loan Performance ID: "+loan.loanPerformanceId.id)
                    println '**** transferred ****'  
                }
                //clean up Gorm
                i++
                if (i == 50 ){
                    i = 1
                    cleanUpLnGorm()
                }
            
            } // else
        }
    }
    
    def loanPerformanceReclassification(Date currentDate, String type, Branch branch, UserMaster user) {   
        println("======== LOAN PERFORMANCE RECLASSIFICATION")
        println("currentDate: "+currentDate)
        println("type: "+type)
        println("trap0041 => BRANCH: "+branch)
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
        Boolean workingDay = checkWorkingDay(currentDate,branch)
        println("workingDay: "+workingDay)
        if (workingDay == false && type == 'daily') {
            println 'non working day - nothing to do'
            return
        }
        def prList
        if (type == 'daily') {
            println '-----reclass type-----'
            println type
            prList = Product.createCriteria().list() {
                and{
                    eq("productType",ProductType.read(6))    
                    eq("loanReclassFreq",LoanFreq.get(1))
                }    
            }               
        }
        if (type == 'monthly') {
            prList = Product.createCriteria().list() {
                and{
                    eq("productType",ProductType.read(6))    
                    eq("loanReclassFreq",LoanFreq.get(4))
                }    
            }            
        }
        println("type: "+type)
        println("prList: "+prList)
        // nothing to do
        if (!prList) {
            return
        }
        for (p in prList) {
            // first pass -> current to past due
            def lList = Loan.createCriteria().list() {  
                and{
                    eq("branch",branch)
                    eq("product",p)    
                    gt("ageInArrears",0)
                    'in'("status",[LoanAcctStatus.read(4),LoanAcctStatus.read(5)])
                    'in'("loanPerformanceId",[LoanPerformanceId.read(1),LoanPerformanceId.read(2)])
                }    
            }
            def newPerformanceId
            String pDesc
            String reclassMode = Institution.findByParamCode('LNS.50078').paramValue
            println("*****************************************************")
            println("reclassMode: "+reclassMode)
            println("*****************************************************")
            for (l in lList) {
                // perform only for loans
                if (l.product.productType.id != 6) {
                    continue
                }
                newPerformanceId = null
                if (reclassMode == 'M941' || reclassMode.equalsIgnoreCase("M941")) {
                    println '-------------- M941 -------------'
                    println l.accountNo
                    println l.ageInArrears
                    if (l.product.isMicrofinance == true) {
                        
                        if (l.ageInArrears > 10) {
                            l.loanProvisionBsp = LoanProvisionBsp.read(3)
                            newPerformanceId= LoanPerformanceId.read(3)   
                            pDesc = 'Transfer to PD Non-Performing - Micro with arrears'
                            l.save(flush:true)   
                        }                
                    } else {
                       
                        if (l.ageInArrears > 30 && l.ageInArrears <= 90) {
                            l.loanProvisionBsp = LoanProvisionBsp.read(2)
                            newPerformanceId= LoanPerformanceId.read(2)   
                            pDesc = 'Transfer to PD Not yet Non-Performing - no payment after cure period (30 Days)'
                            l.save(flush:true)                              
                        } else if (l.ageInArrears > 90) {
                            l.loanProvisionBsp = LoanProvisionBsp.read(3)
                            newPerformanceId= LoanPerformanceId.read(3)   
                            pDesc = 'Transfer to PD Non-Performing - no payment after 90 days'
                            l.save(flush:true)                             
                        }
                    }           
                      if (l.ageInArrears == 0 && l.loanPerformanceId.id == 3) {
                            newPerformanceId= LoanPerformanceId.read(1)   
                            pDesc = 'Transfer to Current - Past Due loan with 0 age in arrears'
                            l.save(flush:true)   
                        }       
                    if (l.maturityDate <= currentDate) {
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - matured loan'
                        l.save(flush:true)
                    }
                } else if (reclassMode == 'FALSE') {
                    if (l.product.isMicrofinance == true) {
                        // microfinance
                        if ((l.ageInArrears >= 1)) {
                            l.loanProvisionBsp = LoanProvisionBsp.read(3)
                            newPerformanceId= LoanPerformanceId.read(3)   
                            pDesc = 'Transfer to PD Non-Performing - Micro with arrears'
                            l.save(flush:true)                            
                        } 
                    } else if (l.maturityDate <= currentDate) {
                        // matured
                        if (l.numInstallments == 1) {
                            // for single payments check age
                            if (l.ageInArrears <= 30) {
                                l.loanProvisionBsp = LoanProvisionBsp.read(3)
                                newPerformanceId= LoanPerformanceId.read(2)   
                                pDesc = 'Transfer to PD Not yet Non-Performing - matured'
                                l.save(flush:true)                                  
                            } else {
                                l.loanProvisionBsp = LoanProvisionBsp.read(3)
                                newPerformanceId= LoanPerformanceId.read(3)   
                                pDesc = 'Transfer to PD Non-Performing - matured'
                                l.save(flush:true)                                   
                            }
                        } else {
                            l.loanProvisionBsp = LoanProvisionBsp.read(3)
                            newPerformanceId= LoanPerformanceId.read(3)   
                            pDesc = 'Transfer to PD Non-Performing - matured'
                            l.save(flush:true)                             
                        }
                    } else if ((l.frequency.id == 6 || l.frequency.id == 7) && (l.ageInArrears >= 60)) {
                        // monthly
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - monthly with 3 missed'
                        l.save(flush:true)                             
                    } else if ((l.frequency.id == 1 || l.frequency.id == 2 || l.frequency.id == 3 || l.frequency.id == 4 || l.frequency.id == 5) && (((l.interestBalanceAmount+l.overduePrincipalBalance).div(l.balanceAmount)) > 0.10)) {
                        // daily, weekly, semi-monthly and 10%
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - > 10% overdue'
                        l.save(flush:true)                             
                    } else if ((l.frequency.id == 8 || l.frequency.id == 9 || l.frequency.id == 10 || l.frequency.id == 11) && (l.ageInArrears >= 1)){
                        // bi-monthly, quarterly, semi-annual and annual
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - 1 missed'
                        l.save(flush:true)                             
                    }  else if (((l.interestBalanceAmount+l.overduePrincipalBalance).div(l.balanceAmount)) > 0.20) {
                        // 20%
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - > 20% overdue'
                        l.save(flush:true)                           
                    }
                } else if (l.loanProvision == LoanProvision.read(1) && reclassMode == 'TRUE') {
                    if (l.ageInArrears >= 1 && l.ageInArrears <= 30) {
                        // EM
                        l.loanProvisionBsp = LoanProvisionBsp.read(2)
                        newPerformanceId = LoanPerformanceId.read(2)
                        pDesc = 'Transfer to PD Performing - secured in arrears'
                        l.save(flush:true)
                    } else if (l.ageInArrears >= 31 && l.ageInArrears <= 60) {
                        // substandard
                        l.loanProvisionBsp = LoanProvisionBsp.read(3)
                        newPerformanceId= LoanPerformanceId.read(3)   
                        pDesc = 'Transfer to PD Non-Performing - secured 31 to 60 days arrears'
                        l.save(flush:true)                        
                    } else if (l.ageInArrears >= 61 && l.ageInArrears <= 90) {
                        // doubtful
                        l.loanProvisionBsp = LoanProvisionBsp.read(4)
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - secured 61 to 90 days arrears'
                        l.save(flush:true)                        
                    } else if (l.ageInArrears >= 91) {
                        // loss
                        l.loanProvisionBsp = LoanProvisionBsp.read(2)
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - secured > 90 days'
                        l.save(flush:true)                        
                    }    
                } else if (l.loanProvision == LoanProvision.read(2) && reclassMode == 'TRUE'){
                    if (l.ageInArrears >= 31 && l.ageInArrears <= 90) {
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - unsecured 31 to 90 days arrears'                        
                        if (l.loanSecurity == LoanSecurity.read(1) || l.loanSecurity == LoanSecurity.read(2) || l.loanSecurity == LoanSecurity.read(3)) {
                        } else {
                        }    
                    } else if (l.ageInArrears >= 91 && l.ageInArrears <= 120) {
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - unsecured 91 to 120 days arrears'                        
                        if (l.loanSecurity == LoanSecurity.read(1) || l.loanSecurity == LoanSecurity.read(2) || l.loanSecurity == LoanSecurity.read(3)) {
                        } else {
                        }    
                        
                    } else if (l.ageInArrears >= 121 && l.ageInArrears <= 360) {
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - unsecured 121 to 360 days arrears'                        
                        if (l.loanSecurity == LoanSecurity.read(1) || l.loanSecurity == LoanSecurity.read(2) || l.loanSecurity == LoanSecurity.read(3)) {
                        } else {
                        }    
                        
                    } else if (l.ageInArrears >= 361 && l.ageInArrears <= 1826) {
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - unsecured 1 year to 5 years arrears'                        
                        if (l.loanSecurity == LoanSecurity.read(1) || l.loanSecurity == LoanSecurity.read(2) || l.loanSecurity == LoanSecurity.read(3)) {
                        } else {
                        }    
                        
                    } else if (l.ageInArrears >= 1827) {
                        newPerformanceId= LoanPerformanceId.read(3)
                        pDesc = 'Transfer to PD Non-Performing - unsecured more than 5 years arrears'                        
                        if (l.loanSecurity == LoanSecurity.read(1) || l.loanSecurity == LoanSecurity.read(2) || l.loanSecurity == LoanSecurity.read(3)) {
                        } else {
                            // loss
                            l.loanProvisionBsp = LoanProvisionBsp.read(2)
                            newPerformanceId= LoanPerformanceId.read(3)
                            pDesc = 'Transfer to PD Non-Performing'
                            l.save(true)                              
                        }    
                        
                    }    
                }    
                println '-------------------------------------------------------'
                println l.accountNo
                println l.ageInArrears
                println l.loanPerformanceId
                println newPerformanceId
                println pDesc
                println '-------------------------------------------------------'
                // if loan is under relief do not transfer to past due anymore
                /*def relief = LoanRelief.findByLoan(l)
                if (relief) {
                if (relief.loanReliefStatus == true) {
                newPerformanceId = null
                }
                }*/
                // if loan is under relief do not transfer to past due anymore
                def relief = LoanRelief.findByLoan(l)
                if (relief) {
                    if (relief.loanReliefStatus == true) {
                        newPerformanceId = null
                    }
                }
                if (newPerformanceId) {
                    transferToPastDue(l, newPerformanceId, pDesc, currentDate, user)  
                }  
            } // end of first pass (current to past due)
        }
    }
    
    private def transferToPastDue(Loan loan, LoanPerformanceId pId, String reclassDesc, Date runDate, UserMaster user) {
        
        // check for changes on loan performance id
        if (loan.loanPerformanceId != pId) {
            def txnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
            def tf = new TxnFile(acctNo:loan.accountNo, branch:loan.branch, currency:loan.product.currency,
                loanAcct:loan, status:ConfigItemStatus.read(2), txnAmt:loan.balanceAmount, txnCode:txnTmp.code,
                txnDate:runDate, txnDescription:reclassDesc, txnParticulars:'To automatically reclassify loan',
                txnRef:'Periodic Loan Reclass', txnTemplate:txnTmp, txnType:txnTmp.txnType,
                txnTimestamp:new Date().toTimestamp(), user:user)
            tf.save(flush:true)
        
            def ll = new LoanLedger(loan:loan, principalDebit:loan.balanceAmount, principalCredit:loan.balanceAmount, 
                principalBalance:loan.balanceAmount, txnFile:tf, txnCode:tf.txnCode, txnDate:runDate,
                txnRef:tf.txnRef, txnParticulars:'Automatic Reclassification', txnTemplate:tf.txnTemplate)
            ll.save(flush:true)
        
            def rc = new LoanReClassHist(loanAcct:loan, newClass:pId, oldClass:loan.loanPerformanceId, reclassDate:runDate,
                reclassDesc:reclassDesc, txnFile:tf)
            rc.save(flush:true, failOnError:true)            
            
            def loanInstance = loan
            loanInstance.loanPerformanceId = pId
            loanInstance.save(flush:true)
            
            GlTransactionService.saveTxnBreakdown(tf.id)
            println '**** transferred ****'   
        }
    }
    
    private def checkWorkingDay(Date currentDate, Branch branch) {
        // Process only for working days
        println("currentDate: "+currentDate)
        println("branch: "+branch)
        def holidays = Holiday.findAllByHolidayDateAndConfigItemStatus(currentDate,ConfigItemStatus.get(2))
        Boolean bHoliday 
        println("holidays: "+holidays)
        
        if (holidays){
            
            if (holidays.institutionWideHoliday == true){
                // do something for holiday
                println 'Holiday!!!!!'
                return false
            }
            else{
                def branchHoliday = BranchHoliday.findAllByBranchAndConfigItemStatusAndHoliday(branch,ConfigItemStatus.get(2),holidays)
                //def branchHoliday  = holidays.branches.find{it.branch == branch}
                println("branchHoliday: "+branchHoliday)
                if (branchHoliday) {
                    println 'branch Holiday!!!!!'
                    return false
                }else{
                    println 'No branch Holiday!!!!!'
                    return true
                }
            }
        } else {
 
            Boolean notWeekend = false
            String  today = currentDate.toString()
            Calendar calendar = new GregorianCalendar(Integer.parseInt(today.substring(0,4)), Integer.parseInt(today.substring(5,7)),Integer.parseInt(today.substring(8,10)) );
            Date weekDate

            if (branch.openOnSun == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==1)){
                println 'sunday'
                return true
            }
            if (branch.openOnMon == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==2)){
                println 'monday'
                return true
            }                
            if (branch.openOnTue == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==3)){
                println 'tuesday'
                return true
            }                
            if (branch.openOnWed == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==4)){
                println 'wed'
                return true
            }               
            if (branch.openOnThu == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==5)){
                println 'thu'
                return true
            }               
            if (branch.openOnFri == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==6)){
                println 'friday'
                return true
            }                
            if (branch.openOnSat == true && (Date.parse("yyyy-MM-dd", today.substring(0,10))[Calendar.DAY_OF_WEEK]==7)){
                println 'sat'
                return true
            } 
            return false      
        }

    }
    
    def archiveMicrofinance(Date currentDate, Branch branch){
	Integer i = 0				 
        def db = new Sql(dataSource)
        def sqlstmt  = "with X as (select A.id, count(C.id) as missed " +
            "from loan A " +
            "inner join loan_loan_installment B on A.id = B.loan_loan_installments_id " +
            "inner join loan_installment C on C.id = B.loan_installment_id " +
            "where C.status_id in (3,4) " +
            "group by A.id), " +
            "Y as (select A.funded_loan_id as id, sum(B.ledger_bal_amt) as holdOutBalance " +
            "from loan_recovery A " +
            "inner join deposit B on A.deposit_account_id = B.id " +
            "group by A.funded_loan_id) " +
            "select A.branch_id as branch, A.id, A.account_no as accountNo, A.loan_application_id as loanApplication, " +
            "A.customer_id as customer, A.gl_link_id as glLink, A.balance_amount as balanceAmount, " +
            "A.overdue_Principal_Balance as overduePrincipalBalance, " +
            "A.interest_Balance_Amount as interestBalanceAmount,  case when X.missed = null then 0 else X.missed end as missed, " +
            "B.account_officer_id as accountOfficer, C.group_record_members_id as group, " +
            "A.loan_performance_id_id as loanPerformance, A.status_id as status, A.age_in_arrears as ageInArrears, " +
            "A.opening_date as openingDate, A.maturity_date as maturityDate, " +
            "A.granted_amount as grantedAmount, A.loan_Kind_Of_Loan_id as loanKindOfLoan, " +
            "A.product_id as product, case when Y.holdOutBalance = null then 0 else Y.holdOutBalance end as holdOutBalance " +
            "from loan A " +
            "inner join loan_application B on A.loan_application_id = B.id " +
            "left outer join group_record_customer C on A.customer_id = C.customer_id " +
            "left outer join Y on A.id = Y.id " +
            "left outer join X on A.id = X.id " +
            "where A.status_id in (4,5) and A.branch_id = "+branch.id
        def loans = db.rows(sqlstmt)   
        for (ln in loans) {
            if(ln.overduePrincipalBalance.toDouble() < 0){
                ln.overduePrincipalBalance = 0.00D
            }
            if(ln.interestBalanceAmount.toDouble() < 0){
                ln.interestBalanceAmount = 0.00D
            }
            def mf = new LoanMicrofinanceHist(refDate:currentDate, branch:ln.branch, loan:ln.id,
                accountNo:ln.accountNo, loanApplication:ln.loanApplication, customer:ln.customer,
                glLink:ln.glLink, balance:ln.balanceAmount, overduePrincipalBalance:ln.overduePrincipalBalance,
                interestBalanceAmount:ln.interestBalanceAmount, missedInstallments:ln.missed,
                accountOfficer:ln.accountOfficer,groupRecord:ln.group, loanPerformanceId:ln.loanPerformance,
                status:ln.status, ageInArrears:ln.ageInArrears, openingDate:ln.openingDate,
                maturityDate:ln.maturityDate, grantedAmount:ln.grantedAmount, loanKindOfLoan:ln.loanKindOfLoan,
                product:ln.product, holdOutBalance:ln.holdOutBalance)
            mf.save(flush:true,failOnError:true)
            i++
            if (i == 50 ){
                i = 1
                cleanUpLnGorm()
            }
			 
        }
        
    }	
}
