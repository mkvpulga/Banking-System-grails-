package icbs.loans


import grails.converters.JSON
import grails.converters.deep.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.lov.MemoTxnType
import icbs.admin.TxnTemplate
import icbs.admin.Branch
import icbs.tellering.TxnFile
import icbs.tellering.TxnLoanPaymentDetails
import icbs.tellering.TxnDepositAcctLedger
import icbs.lov.LoanAcctStatus
import icbs.admin.Currency
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.admin.Institution
import groovy.sql.Sql
import icbs.loans.LoanOtherCharges
import icbs.loans.LoanLedgerOthers
import icbs.tellering.TxnLoanPaymentOthers
import icbs.deposit.Deposit

@Transactional(readOnly = true)
class LoanAdjustmentController {
    def jrxmlTcId
    def jasperService
    def glTransactionService
    def dataSource
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    def index(Integer max) {
        // params.max = Math.min(max ?: 10, 100)
        params.max = Math.min(max ?: 25, 100)

        if(params.offset == null){
            params.offset = 0
        }

        if (params.sort == null) {
            params.sort = "loan.accountNo"
        }

        if (params.query == null) {
            def LoanLedgerList = LoanLedger.createCriteria().list(params) {
                and
                {
                    eq("txnDate",Branch.get(1).runDate)
                    ge("txnType",MemoTxnType.get(4))
                    le("txnType",MemoTxnType.get(9))
                }

            }
            //respond LoanLedger.list(params), model:[params:params, LoanLedgerInstanceCount:  LoanLedger.count()]
            respond LoanLedgerList, model:[params:params, LoanLedgerInstanceCount: LoanLedgerList.totalCount]
        } else{
            def LoanLedgerList = LoanLedger.createCriteria().list(params) {
                or{
                   'loan'{
                        or{
                    'customer'{
                                or{
                                    ilike("displayName","%${params.query.trim()}%")
                                }
                            }
                        }
                        if(params.query.trim().isLong()){
                            idEq(params.query.trim().toLong())
                        }
                    }
                }
                and
                {
                    eq("txnDate",Branch.get(1).runDate)
                    ge("txnType",MemoTxnType.get(4))
                    le("txnType",MemoTxnType.get(9))
                }
            }
            respond LoanLedgerList, model:[params:params, LoanLedgerInstanceCount: LoanLedgerList.totalCount]
        }
        return
    }

    def printValidation(){
        try {

            params._name = "Validation Slip Loan"
            params._format ="PDF"//required caps
            params._file ="ValidationSlipLoan.jasper" //jasper file name
            params.txnID =  session["jrxmlTcId"]
            //            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }
    }


    def show(LoanLedger loanLedgerInstance) {
        session["jrxmlTcId"]= loanLedgerInstance.txnFile.id.toInteger()
        def txnFileInstance = TxnFile.get(loanLedgerInstance.txnFile.id)
        def txnLoanPaymentDetailsInstance = TxnLoanPaymentDetails.findByTxnFile(txnFileInstance)
        //        respond loanLedgerInstance
        render(view: '/loanAdjustment/show', model: [loanLedgerInstance:loanLedgerInstance, txnLoanPaymentDetailsInstance:txnLoanPaymentDetailsInstance])
    }

    def create() {
        respond new LoanLedger(params)
    }

    @Transactional
    def save(LoanLedger loanLedgerInstance) {
        println("JM LOAN ADJUSTMENT PARAMS: "+params)
        println("load id : "+loanLedgerInstance?.loan?.id)
        if (loanLedgerInstance == null) {
            notFound()
            return
        }
        println("loanLedgerInstance.chargesDebit: "+loanLedgerInstance.chargesDebit)
        println("loanLedgerInstance.chargesCredit: "+loanLedgerInstance.chargesCredit)


        if (loanLedgerInstance.principalDebit == null)
        {
            loanLedgerInstance.principalDebit = 0
        }
        if (loanLedgerInstance.principalCredit == null)
        {
            loanLedgerInstance.principalCredit = 0
        }
        if (loanLedgerInstance.interestCredit == null)
        {
            loanLedgerInstance.interestCredit = 0
        }
        if (loanLedgerInstance.interestDebit == null)
        {
            loanLedgerInstance.interestDebit = 0
        }
        if (loanLedgerInstance.penaltyCredit == null)
        {
            loanLedgerInstance.penaltyCredit = 0
        }
        if (loanLedgerInstance.penaltyDebit == null)
        {
            loanLedgerInstance.penaltyDebit = 0
        }
        if (loanLedgerInstance.chargesDebit == null)
        {
            loanLedgerInstance.chargesDebit = 0
        }
        if (loanLedgerInstance.chargesCredit == null)
        {
            loanLedgerInstance.chargesCredit = 0
        }

        if (loanLedgerInstance.loanId == null )
        {
            flash.message = 'Loan Account cannot be null !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance?.loan.status.id < 3  )
        {

            respond loanLedgerInstance.errors, view:'create'
            flash.message = 'Loan Not Yet Approved!'
            return
        }
        if (loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance.principalDebit == 0  )
        {

            respond loanLedgerInstance.errors, view:'create'
            flash.message = 'Zero Amount Disbursement Not Allowed'
            return
        }
        if (Institution.get(80).paramValue == 'TRUE' && (loanLedgerInstance?.loan.loanKindOfLoan))
        {
            if (loanLedgerInstance?.loan.loanKindOfLoan.id == 1 && loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance.principalDebit != loanLedgerInstance?.loan.totalNetProceeds) {
                //            loanLedgerInstance.errors.rejectValue("principalDebit", "loanAdjustment.disbursement.excess")
                flash.message = 'Partial Disbursement is not Allowed!.|error|alert'
                respond loanLedgerInstance.errors, view:'create'
                return
            }
        }
        if (loanLedgerInstance?.txnType.id == 4L && loanLedgerInstance?.loan.balanceAmount < loanLedgerInstance.principalCredit   )
        {

            flash.message = 'Loan Principal Payment cannot be over Loan Balance Amount ! !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance?.loan.status.id > 4  )
        {

            respond loanLedgerInstance.errors, view:'create'
            flash.message = 'Loan Already Close, Ropa , or write off'
            return
        }

        if (loanLedgerInstance.txnRef == null )
        {
            flash.message = 'Transaction Refference cannot be null !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance.txnDate != Branch.get(1).runDate)
        {
            flash.message = 'Transaction Date should be same as system date !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance.principalDebit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 4L && loanLedgerInstance.principalCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 4L && loanLedgerInstance.interestCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 4L && loanLedgerInstance.penaltyCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 4L && loanLedgerInstance.chargesCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 6L && loanLedgerInstance.principalDebit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance?.txnType.id == 7L && loanLedgerInstance.principalCredit < 0)
        {
            flash.message = 'Transaction Amount not! allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 8L && loanLedgerInstance.interestDebit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 8L && loanLedgerInstance.penaltyDebit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 8L && loanLedgerInstance.chargesDebit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 9L && loanLedgerInstance.interestCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 9L && loanLedgerInstance.penaltyCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }
        if (loanLedgerInstance?.txnType.id == 9L && loanLedgerInstance.chargesCredit < 0)
        {
            flash.message = 'Transaction Amount not allowed for negative value !.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance?.loan.status.id >= 6 && loanLedgerInstance?.loan.status.id <= 7)
        {
            flash.message = 'Transaction not allowed for closed/ROPA/Write-Off loan!.|error|alert'
            render(view: '/loanAdjustment/create', model: [loanLedgerInstance:loanLedgerInstance])
            return
        }

        if (loanLedgerInstance.hasErrors()) {
            respond loanLedgerInstance.errors, view:'create'
            return
        }

        def intBalAmtprams = Double.parseDouble(loanLedgerInstance.interestCredit.toString().replaceAll(",",""))
        def penaltyBalAmtParams = Double.parseDouble(loanLedgerInstance.penaltyCredit.toString().replaceAll(",",""))
        def principalBalAmtParams = Double.parseDouble(loanLedgerInstance.principalCredit.toString().replaceAll(",",""))
        def otherAmt = 0.00D
        if (params.otherCredit){
        otherAmt = Double.parseDouble(params.otherCredit.toString().replaceAll(",",""))
        }
        println("otherAmt: "+otherAmt)
        println("intBalAmtprams: "+intBalAmtprams)
        println("loanLedgerInstance?.loan?.interestBalanceAmount: "+loanLedgerInstance?.loan?.interestBalanceAmount)
        println("loanLedgerInstance?.loan?.overduePrincipalBalance: "+loanLedgerInstance?.loan?.overduePrincipalBalance)

        // commented for some issues december 17, 2017 by jm marquez
        /*if(intBalAmtprams > loanLedgerInstance?.loan?.interestBalanceAmount && principalBalAmtParams < loanLedgerInstance?.loan?.overduePrincipalBalance){
        println("redirecting .... due to ERROR: Interest or Penaly payment should not be more than the amount due.")
        flash.message = 'ERROR: Interest or Penaly payment should not be more than the amount due. |error|alert'
        respond loanLedgerInstance.errors, view:'create'
        return
        }
        if(penaltyBalAmtParams > loanLedgerInstance?.loan?.penaltyBalanceAmount){
        println("redirecting .... due to ERROR: Interest or Penaly payment should not be more than the amount due.")
        flash.message = 'ERROR: Penalty Payment Greater than penalty balance. |error|alert'
        respond loanLedgerInstance.errors, view:'create'
        return
        }*/


        if (loanLedgerInstance?.txnType.id == 5L && loanLedgerInstance?.loan.totalDisbursementAmount.round(2) + (loanLedgerInstance?.principalDebit.round(2) ?: 0) > loanLedgerInstance?.loan.totalNetProceeds.round(2)) {
            //            loanLedgerInstance.errors.rejectValue("principalDebit", "loanAdjustment.disbursement.excess")
            // allow disbursement above net proceeds
            if (Institution.findByParamCode("LNS.50077").paramValue == 'TRUE'){
                flash.message = 'Total disbursement amount cannot exceed total net proceeds!.|error|alert'
                respond loanLedgerInstance.errors, view:'create'
                return    
            } else {
                // do not allow disbursement resulting into balance > granted
                if (loanLedgerInstance?.loan.balanceAmount + (loanLedgerInstance?.principalDebit ?: 0) > loanLedgerInstance?.loan.grantedAmount){
                    flash.message = 'Total disbursement amount resulting to loan balance greater than loan granted amount!.|error|alert'
                    respond loanLedgerInstance.errors, view:'create'
                    return
                }
            }
        } else if (loanLedgerInstance?.txnType.id == 6L && loanLedgerInstance?.loan?.balanceAmount + (loanLedgerInstance?.principalDebit ?: 0) > loanLedgerInstance?.loan.grantedAmount) {
            //            loanLedgerInstance.errors.rejectValue("principalDebit", "loanAdjustment.principalBalance.excess")
            flash.message = 'Principal balance amount cannot exceed loan amount!.|error|alert'
            respond loanLedgerInstance.errors, view:'create'
            return
        } else if (loanLedgerInstance?.txnType.id == 7L && loanLedgerInstance?.loan?.balanceAmount - (loanLedgerInstance?.principalCredit ?: 0) < 0) {
            //            loanLedgerInstance.errors.rejectValue("principalCredit", "loanAdjustment.principalBalance.belowZero")
            flash.message = 'Principal balance amount cannot be less than zeo!.|error|alert'
            respond loanLedgerInstance.errors, view:'create'
            return
        }
        if (loanLedgerInstance?.txnType.id in [4L, 7L, 9L] && loanLedgerInstance?.deposit) {
            if(loanLedgerInstance.deposit.availableBalAmt < (loanLedgerInstance?.principalDebit ?: 0 + 
                    loanLedgerInstance?.interestDebit ?: 0 +
                    loanLedgerInstance?.penaltyDebit ?: 0 + 
                    loanLedgerInstance?.chargesDebit ?: 0)) {
                flash.message = 'Cannot Debit Deposit Account - Insufficient Balance!.|error|alert'
                respond loanLedgerInstance.errors, view:'create'
                return
            }
            
        }
        if (loanLedgerInstance?.txnType.id in [4L]) {
            loanLedgerInstance.othersCredit = otherAmt
        }
        loanLedgerInstance.save flush:true

        // debit - increase balance
        // credit - decrease balance

        if (loanLedgerInstance?.txnType.id in [5L, 6L, 8L]) {  // debit
            def principalDebit = loanLedgerInstance?.principalDebit ?: 0
            def interestDebit = loanLedgerInstance?.interestDebit ?: 0
            def penaltyDebit = loanLedgerInstance?.penaltyDebit ?: 0
            def chargesDebit = loanLedgerInstance?.chargesDebit ?: 0

            // disbursement
            if (loanLedgerInstance?.txnType.id == 5L) {
                loanLedgerInstance?.loan.totalDisbursementAmount += principalDebit
                loanLedgerInstance?.loan.balanceAmount += principalDebit
                loanLedgerInstance?.loan.status = LoanAcctStatus.get(4)
            }
            // loan memo debit principal
            if (loanLedgerInstance?.txnType.id == 6L) {
                //loanLedgerInstance?.loan.totalDisbursementAmount += principalDebit
                loanLedgerInstance?.loan.balanceAmount += principalDebit

                // return payment to installment
                def principalAmt = principalDebit
                for(installment in loanLedgerInstance?.loan?.loanInstallments.findAll{it.status.id > 2L}.sort{a,b-> b.sequenceNo<=>a.sequenceNo}) {
                    if (principalAmt > 0) {
                        if (principalAmt >= installment.principalInstallmentPaid) {
                            principalAmt -= installment.principalInstallmentPaid
                            installment.principalInstallmentPaid = 0
                        } else {
                            installment.principalInstallmentPaid -= principalAmt
                            principalAmt = 0
                        }
                        installment.save(flush:true, failOnError:true)
                    }
                }
            }
            def totalAmount = principalDebit + interestDebit + penaltyDebit + chargesDebit

            def maxBalanceAmount = 0
            //def maxInterestBalanceAmount = 0
            //def maxPenaltyBalanceAmount = 0
            def maxServiceChargeBalanceAmount = 0

            if (loanLedgerInstance?.txnType.id == 8) {
                loanLedgerInstance?.loan?.interestBalanceAmount += loanLedgerInstance?.interestDebit
                loanLedgerInstance?.loan?.penaltyBalanceAmount += loanLedgerInstance?.penaltyDebit
                loanLedgerInstance?.loan?.serviceChargeBalanceAmount += loanLedgerInstance?.chargesDebit
            }

            // update deposit account (credit)
            if (loanLedgerInstance?.deposit) {
                loanLedgerInstance.deposit.ledgerBalAmt += totalAmount
                loanLedgerInstance.deposit.availableBalAmt += totalAmount
                loanLedgerInstance.deposit.interestBalAmt += totalAmount
                def depBranch = Branch.get(loanLedgerInstance?.deposit?.branchId)
                def txnFile = new TxnFile()
                // use credit fund transfer transaction
                def txnCr = TxnTemplate.get(Institution.findByParamCode('DEP.40122').paramValue.toInteger())
                txnFile.acctNo = loanLedgerInstance.deposit.acctNo
                //txnFile.loanAcct = loanLedgerInstance?.loan
                txnFile.depAcct = loanLedgerInstance.deposit
                txnFile.currency = Currency.get(loanLedgerInstance?.deposit?.product?.currencyId)
                txnFile.user = UserMaster.get(session.user_id)
                txnFile.branch = loanLedgerInstance.deposit.branch
                txnFile.txnAmt = totalAmount
                txnFile.txnCode = txnCr.code
                txnFile.txnDate = depBranch.runDate
                txnFile.txnTimestamp = new Date().toTimestamp()
                txnFile.txnDescription = txnCr.codeDescription
                txnFile.status = ConfigItemStatus.get(2)
                txnFile.txnType = txnCr.txnType
                txnFile.txnRef = loanLedgerInstance.txnRef
                txnFile.txnParticulars = loanLedgerInstance.txnParticulars
                txnFile.save(flush:true,failOnError:true)

                def depositLedger = new TxnDepositAcctLedger()
                depositLedger.acct = loanLedgerInstance.deposit
                depositLedger.acctNo = loanLedgerInstance.deposit.acctNo
                depositLedger.creditAmt = totalAmount
                depositLedger.bal = loanLedgerInstance.deposit.ledgerBalAmt
                depositLedger.txnRef = loanLedgerInstance.txnRef
                depositLedger.currency = loanLedgerInstance?.deposit?.product?.currency
                depositLedger.branch = loanLedgerInstance.deposit.branch
                depositLedger.status = loanLedgerInstance.deposit.status
                depositLedger.txnCode = txnCr.code
                depositLedger.txnDate = depBranch.runDate
                depositLedger.txnRef = loanLedgerInstance.txnRef
                depositLedger.txnType = txnCr.txnType
                depositLedger.user = UserMaster.get(session.user_id)
                depositLedger.txnFile = txnFile
                println "hello " + depositLedger
                depositLedger.save(flush:true,failOnError:true)
                glTransactionService.saveTxnBreakdown(txnFile.id)
            }
        } else if (loanLedgerInstance?.txnType.id in [4L, 7L, 9L]) {  // credit
            def principalCredit = loanLedgerInstance?.principalCredit ?: 0
            def interestCredit = loanLedgerInstance?.interestCredit ?: 0
            def penaltyCredit = loanLedgerInstance?.penaltyCredit ?: 0
            def chargesCredit = loanLedgerInstance?.chargesCredit ?: 0

            
            def arOthersVar = params.arOthersCredit ? (params.arOthersCredit.toString().replaceAll(",","")).toDouble() : null

            def insuranceCreditVar = params.insuranceCredit ? (params.insuranceCredit.toString().replaceAll(",","")).toDouble() : null
            
            
            //def insuranceCreditVar = params.savingsDepositCredit ? (params.savingsDepositCredit.toString().replaceAll(",","")).toDouble() : null
            
            
            if (insuranceCreditVar == null || insuranceCreditVar == ""){
                insuranceCreditVar = 0.00D
            }
            
            if (arOthersVar == null ||  arOthersVar == ""){
                arOthersVar = 0.00D
            }
            def totalAmount = principalCredit + interestCredit + penaltyCredit + chargesCredit + insuranceCreditVar + arOthersVar

            def maxInterestBalanceAmount = 0
            def maxPenaltyBalanceAmount = 0

            // update loan account

            if (loanLedgerInstance?.loan?.balanceAmount - loanLedgerInstance?.principalCredit < 0) {
                println "zdero bal"
                loanLedgerInstance?.loan?.balanceAmount = 0
            } else {
                println "decrease"
                loanLedgerInstance?.loan?.balanceAmount -= loanLedgerInstance?.principalCredit
            }

            // loan interest credit
            if (loanLedgerInstance?.txnType.id == 9) {
                loanLedgerInstance?.loan?.interestBalanceAmount -= loanLedgerInstance?.interestCredit
                loanLedgerInstance?.loan?.penaltyBalanceAmount -= loanLedgerInstance?.penaltyCredit
                loanLedgerInstance?.loan?.serviceChargeBalanceAmount -= loanLedgerInstance?.chargesCredit
            }

            if (loanLedgerInstance?.txnType.id == 4) {
                // for payment update interest and penalty balances
                loanLedgerInstance?.loan?.interestBalanceAmount -= loanLedgerInstance.interestCredit
                loanLedgerInstance?.loan?.penaltyBalanceAmount -= loanLedgerInstance.penaltyCredit
                loanLedgerInstance?.loan?.serviceChargeBalanceAmount -= loanLedgerInstance.chargesCredit
            }

            // update deposit account (debit)
            if (loanLedgerInstance?.deposit) {
                loanLedgerInstance.deposit.ledgerBalAmt -= totalAmount
                loanLedgerInstance.deposit.availableBalAmt -= totalAmount
                loanLedgerInstance.deposit.interestBalAmt -= totalAmount

                def depBranch = Branch.get(loanLedgerInstance?.deposit?.branchId)
                def txnFile = new TxnFile()
                txnFile.acctNo = loanLedgerInstance.deposit.acctNo
                txnFile.depAcct = loanLedgerInstance.deposit
                txnFile.currency = Currency.get(loanLedgerInstance?.deposit?.product?.currencyId)
                txnFile.user = UserMaster.get(session.user_id)
                txnFile.branch = Branch.get(UserMaster.get(session.user_id).branchId)
                txnFile.txnAmt = totalAmount
                txnFile.txnCode = TxnTemplate.get(Institution.findByParamCode("LNS.50072").paramValue.toInteger()).code
                txnFile.txnDate = depBranch.runDate
                txnFile.txnTimestamp = new Date().toTimestamp()
                txnFile.txnDescription = 'Loan Recovery from ' + loanLedgerInstance?.loan?.accountNo
                txnFile.status = ConfigItemStatus.get(2)
                txnFile.txnType = TxnTemplate.get(Institution.findByParamCode("LNS.50072").paramValue.toInteger()).txnType
                txnFile.txnRef = loanLedgerInstance.txnRef
                txnFile.txnParticulars = loanLedgerInstance.txnParticulars
                txnFile.save(flush:true,failOnError:true)

                def depositLedger = new TxnDepositAcctLedger()
                depositLedger.acct = loanLedgerInstance.deposit
                depositLedger.acctNo = loanLedgerInstance.deposit.acctNo
                depositLedger.debitAmt = totalAmount
                depositLedger.bal = loanLedgerInstance.deposit.ledgerBalAmt
                depositLedger.txnRef = loanLedgerInstance.txnRef
                depositLedger.currency = Currency.get(loanLedgerInstance?.deposit?.product?.currencyId)
                depositLedger.branch = Branch.get(UserMaster.get(session.user_id).branchId)
                depositLedger.status = loanLedgerInstance.deposit.status
                depositLedger.txnCode = TxnTemplate.get(Institution.findByParamCode("LNS.50072").paramValue.toInteger()).code
                depositLedger.txnDate = depBranch.runDate
                depositLedger.txnRef = loanLedgerInstance.txnRef
                depositLedger.txnType = TxnTemplate.get(Institution.findByParamCode("LNS.50072").paramValue.toInteger()).txnType
                depositLedger.txnFile = txnFile
                depositLedger.user = UserMaster.get(session.user_id)
                println "hello " + depositLedger
                depositLedger.save(flush:true,failOnError:true)
                glTransactionService.saveTxnBreakdown(txnFile.id)

            }
        }


        // update loan ledger balance
        loanLedgerInstance?.principalBalance = loanLedgerInstance?.loan?.balanceAmount
        loanLedgerInstance?.interestBalance = loanLedgerInstance?.loan?.interestBalanceAmount
        loanLedgerInstance?.penaltyBalance = loanLedgerInstance?.loan?.penaltyBalanceAmount
        loanLedgerInstance?.chargesBalance = loanLedgerInstance?.loan?.serviceChargeBalanceAmount
        loanLedgerInstance.save(flush:true, failOnError:true)
        //for creating txn File
        def amount
        if(loanLedgerInstance?.txnType.id == 5L )
        {

            amount = loanLedgerInstance.principalDebit
            println "amount " + amount
        }
        else if (loanLedgerInstance?.txnType.id == 4L)
        {
            amount = loanLedgerInstance.principalCredit + loanLedgerInstance.interestCredit + loanLedgerInstance.penaltyCredit + otherAmt + loanLedgerInstance.chargesCredit
            println "amount " + amount
        }
        else if (loanLedgerInstance?.txnType.id == 6L)
        {
            amount = loanLedgerInstance.principalDebit
            println "amount " + amount
        }
        else if (loanLedgerInstance?.txnType.id == 7L)
        {
            amount = loanLedgerInstance.principalCredit
            println "amount " + amount
        }
        else if (loanLedgerInstance?.txnType.id == 8L){

            amount = loanLedgerInstance.interestDebit + loanLedgerInstance.penaltyDebit + loanLedgerInstance.chargesDebit
            println "amount " + amount
            //STARTCODE
            /*
            def loanExistsValidate = LoanOtherCharges.findByLoan(Loan.get(loanLedgerInstance?.loan?.id))
            def getBranchIDByUserExist = UserMaster.get(session.user_id).branch
            println("getBranchIDByUserExist: "+getBranchIDByUserExist)
            if(loanExistsValidate){
            println("loan exists in Loan Other Charges Table..")
            def loanOtherChargesIntance = LoanOtherCharges.findByLoan(Loan.get(loanLedgerInstance?.loan?.id))
            loanOtherChargesIntance.branch = getBranchIDByUserExist
            loanOtherChargesIntance.currency = Currency.get(1)
            loanOtherChargesIntance.loan = Loan.get(loanLedgerInstance?.loan?.id)
            //=============== DYNAMIC COMPUTATION FOr INSURANCE DEBIT ===================
            def existingInsuranceValue = loanOtherChargesIntance.insurance.toDouble()
            def paramInsuranceValue = params.insuranceDebit.toString().replaceAll(",","").toDouble()
            def newDynamicInsuranceValue = existingInsuranceValue + paramInsuranceValue
            //======================================================================
            loanOtherChargesIntance.insurance =  newDynamicInsuranceValue

            //=============== DYNAMIC COMPUTATION FOr SAVINGS DEPOSIT DEBIT ===================
            def existingSavingDepositValue = loanOtherChargesIntance.savingsDeposit.toDouble()
            def paramSavingsDepositValue = params.savingsDepositDebit.toString().replaceAll(",","").toDouble()
            def newDynamicSavingsDepositValue = existingSavingDepositValue + paramSavingsDepositValue
            //======================================================================
            loanOtherChargesIntance.savingsDeposit = newDynamicSavingsDepositValue

            //=============== DYNAMIC COMPUTATION FOr AR OTHERS DEBIT ===================
            def existingArOthersValue = loanOtherChargesIntance.arOthers.toDouble()
            def paramArOthersValue = params.arOthersDebit.toString().replaceAll(",","").toDouble()
            def newDynamicArOthersValue = existingArOthersValue + paramArOthersValue
            //======================================================================

            loanOtherChargesIntance.arOthers = newDynamicArOthersValue
            loanOtherChargesIntance.txnDate = Branch.get(1).runDate
            loanOtherChargesIntance.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            loanOtherChargesIntance.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            loanOtherChargesIntance.transactBy = UserMaster.get(session.user_id)
            loanOtherChargesIntance.save(flush: true)
            println("Done Updating Loan Other Charges Table..")
            println("loanLedgerInstance.id: "+loanLedgerInstance.id)
            // ============== saving  to LOAN LEDGER OHERS ====================
            def saveToLoanLedgerOthers = new LoanLedgerOthers()
            saveToLoanLedgerOthers.branch = getBranchIDByUserExist
            saveToLoanLedgerOthers.currency = Currency.get(1)
            saveToLoanLedgerOthers.loanLedger = LoanLedger.get(loanLedgerInstance.id)
            saveToLoanLedgerOthers.insurance = params.insuranceDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.savingsDeposit = params.savingsDepositDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.arOthers = params.arOthersDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.txnDate = Branch.get(1).runDate
            saveToLoanLedgerOthers.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            saveToLoanLedgerOthers.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            saveToLoanLedgerOthers.transactBy = UserMaster.get(session.user_id)
            saveToLoanLedgerOthers.save(flush: true)
            //==================================================================
            }else{
            println("New data will be inserted in Loan Other Charges Table..")
            def loanOtherChargesIntance = new LoanOtherCharges()
            loanOtherChargesIntance.branch = getBranchIDByUserExist
            loanOtherChargesIntance.currency = Currency.get(1)
            loanOtherChargesIntance.loan = Loan.get(loanLedgerInstance?.loan?.id)
            loanOtherChargesIntance.insurance = params.insuranceDebit ? (params.insuranceDebit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.savingsDeposit = params.savingsDepositDebit ? (params.savingsDepositDebit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.arOthers = params.arOthersDebit ? (params.arOthersDebit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.txnDate = Branch.get(1).runDate
            loanOtherChargesIntance.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            loanOtherChargesIntance.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            loanOtherChargesIntance.transactBy = UserMaster.get(session.user_id)
            loanOtherChargesIntance.save(flush: true)
            println("New data in Loan Other Charges Table saved complete!...")

            // ============== saving  to LOAN LEDGER OHERS ====================
            def saveToLoanLedgerOthers = new LoanLedgerOthers()
            saveToLoanLedgerOthers.branch = getBranchIDByUserExist
            saveToLoanLedgerOthers.currency = Currency.get(1)
            saveToLoanLedgerOthers.loanLedger = LoanLedger.get(loanLedgerInstance.id)
            saveToLoanLedgerOthers.insurance = params.insuranceDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.savingsDeposit = params.savingsDepositDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.arOthers = params.arOthersDebit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.txnDate = Branch.get(1).runDate
            saveToLoanLedgerOthers.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            saveToLoanLedgerOthers.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            saveToLoanLedgerOthers.transactBy = UserMaster.get(session.user_id)
            saveToLoanLedgerOthers.save(flush: true)
            //==================================================================
            }
            //add to Loan Ledger Others
             */

        }
        else if (loanLedgerInstance?.txnType.id == 9L){

            amount = loanLedgerInstance.interestCredit + loanLedgerInstance.penaltyCredit + loanLedgerInstance.chargesCredit
            println "amount " + amount

            /*def loanExistsValidate = LoanOtherCharges.findByLoan(Loan.get(loanLedgerInstance?.loan?.id))
            def getBranchIDByUserExist = UserMaster.get(session.user_id).branch
            println("getBranchIDByUserExist: "+getBranchIDByUserExist)

            if(loanExistsValidate){

            println("loan exists in Loan Other Charges Table..")
            def loanOtherChargesIntance = LoanOtherCharges.findByLoan(Loan.get(loanLedgerInstance?.loan?.id))
            loanOtherChargesIntance.branch = getBranchIDByUserExist
            loanOtherChargesIntance.currency = Currency.get(1)
            loanOtherChargesIntance.loan = Loan.get(loanLedgerInstance?.loan?.id)
            //=============== DYNAMIC COMPUTATION FOr INSURANCE CREDIT ===================
            def existingInsuranceValue = loanOtherChargesIntance.insurance.toDouble()
            def paramInsuranceValue = params.insuranceCredit.toString().replaceAll(",","").toDouble()
            def newDynamicInsuranceValue = existingInsuranceValue - paramInsuranceValue
            //======================================================================
            loanOtherChargesIntance.insurance =  newDynamicInsuranceValue

            //=============== DYNAMIC COMPUTATION FOr SAVINGS DEPOSIT CREDIT ===================
            def existingSavingDepositValue = loanOtherChargesIntance.savingsDeposit.toDouble()
            def paramSavingsDepositValue = params.savingsDepositCredit.toString().replaceAll(",","").toDouble()
            def newDynamicSavingsDepositValue = existingSavingDepositValue - paramSavingsDepositValue
            //======================================================================
            loanOtherChargesIntance.savingsDeposit = newDynamicSavingsDepositValue

            //=============== DYNAMIC COMPUTATION FOr AR OTHERS CREDIT ===================
            def existingArOthersValue = loanOtherChargesIntance.arOthers.toDouble()
            def paramArOthersValue = params.arOthersCredit.toString().replaceAll(",","").toDouble()
            def newDynamicArOthersValue = existingArOthersValue - paramArOthersValue
            //======================================================================

            loanOtherChargesIntance.arOthers = newDynamicArOthersValue
            loanOtherChargesIntance.txnDate = Branch.get(1).runDate
            loanOtherChargesIntance.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            loanOtherChargesIntance.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            loanOtherChargesIntance.transactBy = UserMaster.get(session.user_id)
            loanOtherChargesIntance.save(flush: true)
            println("Done Updating Loan Other Charges Table..")

            // ============== saving  to LOAN LEDGER OHERS ====================
            def saveToLoanLedgerOthers = new LoanLedgerOthers()
            saveToLoanLedgerOthers.branch = getBranchIDByUserExist
            saveToLoanLedgerOthers.currency = Currency.get(1)
            saveToLoanLedgerOthers.loanLedger = LoanLedger.get(loanLedgerInstance.id)
            saveToLoanLedgerOthers.insurance = params.insuranceCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.savingsDeposit = params.savingsDepositCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.arOthers = params.arOthersCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.txnDate = Branch.get(1).runDate
            saveToLoanLedgerOthers.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            saveToLoanLedgerOthers.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            saveToLoanLedgerOthers.transactBy = UserMaster.get(session.user_id)
            saveToLoanLedgerOthers.save(flush: true)
            //==================================================================

            }else{
            println("New data will be inserted in Loan Other Charges Table..")

            def loanOtherChargesIntance = new LoanOtherCharges()
            loanOtherChargesIntance.branch = getBranchIDByUserExist
            loanOtherChargesIntance.currency = Currency.get(1)
            loanOtherChargesIntance.loan = Loan.get(loanLedgerInstance?.loan?.id)
            loanOtherChargesIntance.insurance = params.insuranceCredit ? (params.insuranceCredit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.savingsDeposit = params.savingsDepositCredit ? (params.savingsDepositCredit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.arOthers = params.arOthersCredit ? (params.arOthersCredit.replaceAll(",","")).toDouble() : null
            loanOtherChargesIntance.txnDate = Branch.get(1).runDate
            loanOtherChargesIntance.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            loanOtherChargesIntance.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            loanOtherChargesIntance.transactBy = UserMaster.get(session.user_id)
            loanOtherChargesIntance.save(flush: true)
            println("New data in Loan Other Charges Table saved complete!...")

            // ============== saving  to LOAN LEDGER OHERS ====================
            def saveToLoanLedgerOthers = new LoanLedgerOthers()
            saveToLoanLedgerOthers.branch = getBranchIDByUserExist
            saveToLoanLedgerOthers.currency = Currency.get(1)
            saveToLoanLedgerOthers.loanLedger = LoanLedger.get(loanLedgerInstance.id)
            saveToLoanLedgerOthers.insurance = params.insuranceCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.savingsDeposit = params.savingsDepositCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.arOthers = params.arOthersCredit.toString().replaceAll(",","").toDouble()
            saveToLoanLedgerOthers.txnDate = Branch.get(1).runDate
            saveToLoanLedgerOthers.txntype = MemoTxnType.get(loanLedgerInstance?.txnType.id)
            saveToLoanLedgerOthers.description = MemoTxnType.get(loanLedgerInstance?.txnType.id).description
            saveToLoanLedgerOthers.transactBy = UserMaster.get(session.user_id)
            saveToLoanLedgerOthers.save(flush: true)
            //==================================================================

            } */
        }

        def txnFileInstance = new TxnFile()

        def branch = Branch.get(loanLedgerInstance?.loan?.branchId)
        txnFileInstance.acctNo = loanLedgerInstance?.loan?.accountNo
        txnFileInstance.loanAcct = loanLedgerInstance?.loan
        txnFileInstance.currency = Currency.get(loanLedgerInstance?.loan?.product?.currencyId)
        txnFileInstance.user = UserMaster.get(session.user_id)
        txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
        txnFileInstance.txnAmt = amount
        txnFileInstance.txnCode = loanLedgerInstance.txnTemplate.code
        txnFileInstance.txnDate = branch.runDate
        txnFileInstance.txnTimestamp = new Date().toTimestamp()
        txnFileInstance.txnDescription = loanLedgerInstance.txnTemplate.codeDescription
        txnFileInstance.status = ConfigItemStatus.get(2)
        txnFileInstance.txnType = loanLedgerInstance.txnTemplate.txnType
        txnFileInstance.txnRef = loanLedgerInstance.txnRef
        txnFileInstance.txnParticulars = loanLedgerInstance.txnParticulars
        txnFileInstance.save(flush:true,failOnError:true)

        loanLedgerInstance.txnFile = txnFileInstance
        loanLedgerInstance.save(flush:true)

        println "gelo" + txnFileInstance.id
        session["jrxmlTcId"]= txnFileInstance.id.toInteger()
            
       
        if (loanLedgerInstance?.txnType.id == 4L){

            def txnLoanPaymentDetailsInstance = new TxnLoanPaymentDetails()
            txnLoanPaymentDetailsInstance.acct = loanLedgerInstance?.loan
            txnLoanPaymentDetailsInstance.acctNo = loanLedgerInstance?.loan?.accountNo
            txnLoanPaymentDetailsInstance.balForwarded = loanLedgerInstance?.loan?.balanceAmount + loanLedgerInstance.principalCredit
            txnLoanPaymentDetailsInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
            txnLoanPaymentDetailsInstance.currency = Currency.get(loanLedgerInstance?.loan?.product?.currencyId)
            txnLoanPaymentDetailsInstance.interestAmt = loanLedgerInstance.interestCredit
            txnLoanPaymentDetailsInstance.interestBalAfterPayment = loanLedgerInstance?.loan?.interestBalanceAmount
            txnLoanPaymentDetailsInstance.paymentAmt = loanLedgerInstance.principalCredit + loanLedgerInstance.interestCredit + loanLedgerInstance.penaltyCredit + loanLedgerInstance.chargesCredit
            txnLoanPaymentDetailsInstance.penaltyAmt = loanLedgerInstance.penaltyCredit
            txnLoanPaymentDetailsInstance.otherAmt = otherAmt
            txnLoanPaymentDetailsInstance.penaltyBalAfterPayment = loanLedgerInstance?.loan?.penaltyAmount
            txnLoanPaymentDetailsInstance.principalAmt = loanLedgerInstance.principalCredit
            txnLoanPaymentDetailsInstance.principalBalAfterPayment = loanLedgerInstance?.loan?.balanceAmount
            txnLoanPaymentDetailsInstance.serviceChargeAmt = loanLedgerInstance.chargesCredit
            txnLoanPaymentDetailsInstance.totalNetProceeds = loanLedgerInstance?.loan?.totalNetProceeds
            txnLoanPaymentDetailsInstance.txnDate = branch.runDate
            txnLoanPaymentDetailsInstance.txnFile = txnFileInstance
            txnLoanPaymentDetailsInstance.txnRef = loanLedgerInstance.txnRef
            txnLoanPaymentDetailsInstance.user = UserMaster.get(session.user_id)
            txnLoanPaymentDetailsInstance.save(flush:true,failOnError:true)

            // adding details to TxnLoanPaymentOthers
            // added by jm marquez october 25, 2017
            def tLonPaymentOthersDeposit
            if(params?.depositSavingsss){
                tLonPaymentOthersDeposit = Deposit.get(params?.depositSavingsss.toInteger())
            }else{
                tLonPaymentOthersDeposit = null
            }
            def txnLoanPaymentDetailsOthersInstance = new TxnLoanPaymentOthers()
            txnLoanPaymentDetailsOthersInstance.txnLoanPaymentDetails = TxnLoanPaymentDetails.get(txnLoanPaymentDetailsInstance.id.toInteger())
            txnLoanPaymentDetailsOthersInstance.arOthers = params.arOthersCredit ? (params.arOthersCredit.toString().replaceAll(",","")).toDouble() : null
            txnLoanPaymentDetailsOthersInstance.arOthersGl = params?.arOthersGLGL ? (params.arOthersGLGL.toString()).toString() : null
            txnLoanPaymentDetailsOthersInstance.insurance = params.insuranceCredit ? (params.insuranceCredit.toString().replaceAll(",","")).toDouble() : null
            txnLoanPaymentDetailsOthersInstance.insuranceGl = params?.insuranceGLGL ? (params.insuranceGLGL.toString()).toString() : null
            txnLoanPaymentDetailsOthersInstance.deposit = tLonPaymentOthersDeposit
            txnLoanPaymentDetailsOthersInstance.depositCr =  params.savingsDepositCredit ? (params.savingsDepositCredit.toString().replaceAll(",","")).toDouble() : null
            txnLoanPaymentDetailsOthersInstance.save(flush:true,failOnError:true)
            
            if (txnLoanPaymentDetailsOthersInstance.insurance == null || txnLoanPaymentDetailsOthersInstance.insurance == ""){
                txnLoanPaymentDetailsOthersInstance.insurance = 0.00D
            }
            if (txnLoanPaymentDetailsOthersInstance.depositCr == null || txnLoanPaymentDetailsOthersInstance.depositCr == ""){
                txnLoanPaymentDetailsOthersInstance.depositCr = 0.00D
            }
            if (txnLoanPaymentDetailsOthersInstance.arOthers == null || txnLoanPaymentDetailsOthersInstance.arOthers == ""){
                txnLoanPaymentDetailsOthersInstance.arOthers = 0.00D
            }

            if ((txnLoanPaymentDetailsOthersInstance.arOthers + txnLoanPaymentDetailsOthersInstance.insurance + txnLoanPaymentDetailsOthersInstance.depositCr) > 0.00D) {
                // update txnAmt
                txnFileInstance.txnAmt += (txnLoanPaymentDetailsOthersInstance.arOthers + txnLoanPaymentDetailsOthersInstance.insurance + txnLoanPaymentDetailsOthersInstance.depositCr)
                txnFileInstance.save(flush:true, failOnError:true)
            }
            if (txnLoanPaymentDetailsOthersInstance.depositCr > 0.00D){
                // credit to deposit account
                tLonPaymentOthersDeposit.availableBalAmt += txnLoanPaymentDetailsOthersInstance.depositCr
                tLonPaymentOthersDeposit.ledgerBalAmt += txnLoanPaymentDetailsOthersInstance.depositCr
                tLonPaymentOthersDeposit.save(flush:true, failOnError:true)
                // credit to deposit account transaction file and ledger
                def tmpCr = TxnTemplate.get(Institution.findByParamCode('DEP.40122').paramValue.toInteger())
                def txnDepCr = new TxnFile(acctNo:tLonPaymentOthersDeposit.acctNo, depAcct:tLonPaymentOthersDeposit,
                    currency:tLonPaymentOthersDeposit?.product?.currency, user:UserMaster.get(session.user_id),
                    branch:tLonPaymentOthersDeposit.branch, txnAmt:txnLoanPaymentDetailsOthersInstance.depositCr,
                    txnCode:tmpCr.code, txnDate:branch.runDate, txnTimestamp:new Date().toTimestamp(),
                    txnDescription:tmpCr.codeDescription, status:ConfigItemStatus.get(2),
                    txnType:tmpCr.txnType, txnRef:loanLedgerInstance.txnRef,
                    txnParticulars:loanLedgerInstance.txnParticulars)
                // use credit fund transfer transaction
                txnDepCr.save(flush:true,failOnError:true)

                def depositCrLedger = new TxnDepositAcctLedger(acct:tLonPaymentOthersDeposit,
                    acctNo:tLonPaymentOthersDeposit.acctNo, creditAmt:txnLoanPaymentDetailsOthersInstance.depositCr,
                    bal:tLonPaymentOthersDeposit.ledgerBalAmt, txnRef:loanLedgerInstance.txnRef,
                    currency:tLonPaymentOthersDeposit?.product?.currency,
                    branch:tLonPaymentOthersDeposit?.branch, status:tLonPaymentOthersDeposit?.status,
                    txnCode:tmpCr.code, txnDate:branch.runDate, txnType:tmpCr.txnType,
                    user:UserMaster.get(session.user_id),txnFile:txnDepCr)

                depositCrLedger.save(flush:true,failOnError:true)
                glTransactionService.saveTxnBreakdown(txnDepCr.id)
            }
        }
        println "angelo " + loanLedgerInstance.txnTemplate.id
        glTransactionService.saveTxnBreakdown(txnFileInstance.id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'loanLedger.label', default: 'LoanLedger'), loanLedgerInstance.id])
                //redirect loanLedgerInstance
                redirect action:'show', id: loanLedgerInstance.id
            }
            '*' { respond loanLedgerInstance, [status: CREATED] }
        }
    }

    def edit(LoanLedger loanLedgerInstance) {
        respond loanLedgerInstance
    }

    @Transactional
    def update(LoanLedger loanLedgerInstance) {
        if (loanLedgerInstance == null) {
            notFound()
            return
        }

        if (loanLedgerInstance.hasErrors()) {
            respond loanLedgerInstance.errors, view:'edit'
            return
        }

        loanLedgerInstance.save flush:true

        request.withFormat {

            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LoanLedger.label', default: 'LoanLedger'), loanLedgerInstance.id])
                //redirect loanLedgerInstance, action:'show'
                redirect action:'show', id: loanLedgerInstance.id
            }
            '*'{ respond loanLedgerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LoanLedger loanLedgerInstance) {

        if (loanLedgerInstance == null) {
            notFound()
            return
        }

        loanLedgerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LoanLedger.label', default: 'LoanLedger'), loanLedgerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def getTxnTemplatesAjax() {
        def json = request.JSON
        def txnType = null
        if (json.txnType) {
            txnType = MemoTxnType.get(json.txnType)
        }
        println("txnType: "+txnType);
        println("txnType: "+json.txnType);
        def txntemplateNewInstance = TxnTemplate.findAllByMemoTxnType(txnType).sort{it.code}
        println("txn_typeeee: "+txntemplateNewInstance)
        def sql = new Sql(dataSource)
        def queryall = "select * from txn_template where memo_txn_type_id ="+json.txnType
        def resultqueryall = sql.rows(queryall)

        render resultqueryall as JSON
        return
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'loanLedger.label', default: 'LoanLedger'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
