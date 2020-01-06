package icbs.tellering
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.json.JsonBuilder
import org.springframework.web.context.request.RequestContextHolder
import groovy.sql.Sql
import javax.servlet.http.HttpSession
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.lov.ConfigItemStatus
import icbs.lov.TxnType
import icbs.admin.TxnTemplate
import icbs.tellering.TxnFile
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.tellering.TxnSssCollection
import icbs.lov.SssPaymentCode
import icbs.lov.SssPaymentType
import icbs.lov.SssPayorType
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import icbs.admin.Institution
import icbs.tellering.SssOnlinePaymentDetail
import icbs.lov.SssMembershipType
import icbs.admin.CheckDepositClearingType
import icbs.lov.CheckStatus
import icbs.deposit.Deposit
import icbs.deposit.Cheque
import icbs.deposit.StopPaymentOrder
import icbs.deposit.Chequebook
import icbs.tellering.TxnDepositAcctLedger
import icbs.tellering.TxnTellerBalance
import icbs.lov.YesNoNa
import icbs.lov.MemoTxnType
import icbs.lov.TxnCheckStatus
import icbs.tellering.SssConfig
class SssCollectionController {
    def auditLogService
    def userMasterService
    def glTransactionService
    
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE", saveCharge: "PUT"]
    def dataSource
    def SSSOnlineService
    def jasperService
    private static final DateFormat sssDateReply = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    def index(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null) {  // show all instances 
            def sssOnlinePaymentDetailList = SssOnlinePaymentDetail.createCriteria().list(params) {
                
            }
            respond sssOnlinePaymentDetailList, model:[sssOnlinePaymentDetailList: sssOnlinePaymentDetailList,sssOnlinePaymentDetailInstanceCount: sssOnlinePaymentDetailList.totalCount]
        }
        else {    // show query results
            def sssOnlinePaymentDetailList = SssOnlinePaymentDetail.createCriteria().list(params) {
                or {
                    //eq("code", params.int('query'))
                    ilike("brnum", "%${params.query}%")
                    ilike("ername", "%${params.query}%")
                    ilike("ername", "%${params.query}%")
                    
                    ilike("indiTxnNumber", "%${params.query}%")
                    ilike("indiIprnum", "%${params.query}%")
                    ilike("indiEenum", "%${params.query}%")
                    ilike("indiEenum", "%${params.query}%")
                    ilike("indiEename", "%${params.query}%")
                }
            }
            respond sssOnlinePaymentDetailList, model:[sssOnlinePaymentDetailList: sssOnlinePaymentDetailList,sssOnlinePaymentDetailInstanceCount: sssOnlinePaymentDetailList.totalCount]
        }
    }
    
    def show(SssOnlinePaymentDetail sssOnlinePaymentDetailInstance){
        println params
        respond sssOnlinePaymentDetailInstance
    }
    
    def sssOnlineCreate(){
        println 'sssOnlineCreate()'
        // go top GSP
    }
    
    def sssConfirmBillerRef(){
        session["checks"] = []
        println 'sssConfirmBillerRef#################'
        println params
        String transactionIDid = "00";
        def theReturnValue = SSSOnlineService.collectDataAjax(params,transactionIDid)
        println("theReturnValue: "+theReturnValue)
        // call service
        
        // if reply code is OK display gsp
        
        // otherwise display error
        def splitReplyMessage = ""
        
        def sssInformation = theReturnValue.split("@@#")
        for(int i = 0;i<sssInformation.length;i++){
            
            splitReplyMessage = sssInformation[sssInformation.length - 1]
        }
        println("splitReplyMessage: "+splitReplyMessage)
        flash.message = splitReplyMessage.toString()
        
        [theReturnValue:theReturnValue]
        
    }
    
   
    def saveSssTxn(){
        println 'sssConfirmBillerRef#################'
        println("confirm Bill ref Params: "+params)
        String transactionIDid = "00";
        def theReturnValue = SSSOnlineService.collectDataAjax(params,transactionIDid)

        Date sssTheReplyDate = new Date(params.sssreplyDate);
        
        println("theReturnValue: "+theReturnValue)
        //  call service to post payment
        def sssInformation = theReturnValue.split("@@#")
        def replyMsgCode = sssInformation[0].toString()
        
        def amountCash  = params.sssamount.toString().replace(',','').toDouble()
        // if zero meaning successful transaction 
        
            // save to TXN FILE
            def b = Branch.get(1)
            def t = TxnTemplate.get(params.txnTemplate.id)
            println("***** Saving to Txn File *****")
            

            def txFile  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:Currency.get(1),
            txnAmt:amountCash,txnRef:params.txnReference,status:ConfigItemStatus.get(2), branch:UserMaster.get(session.user_id).branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.txnParticulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            txFile.save(flush:true, failOnError:true);

            String xtxnValidator = params.txnTemplate.id.toString()
            def sssConfTxnTemplateId = SssConfig.findByParamCode("GEN.10263").paramValue.toString()
            println("sssConfTxnTemplateId: "+sssConfTxnTemplateId)
            // if Other Check Receipt transaction
            if(xtxnValidator == sssConfTxnTemplateId){
                session["checks"].id.each { tcoci_id ->
                    def tcoci = TxnCOCI.get(tcoci_id)
                    tcoci.status = ConfigItemStatus.get(2)
                    tcoci.txnCheckStatus = TxnCheckStatus.get(2)
                    tcoci.txnFile = txFile

                    def checkClearDate = tcoci.checkType.clearingDate
                    tcoci.clearingDate = checkClearDate

                    if(tcoci.checkType == CheckDepositClearingType.get(3)){
                        def checks = Cheque.findByChequeNo(tcoci.checkNo)
                        def chequebookInstance = checks.chequebook 
                        checks.chequeAmt = tcoci.checkAmt
                        checks.chequeDate = tcoci.checkDate
                        checks.isChequeClrOnUs = true
                        checks.status = CheckStatus.get(3)
                        checks.save(flush:true,failOnError:true)

                        chequebookInstance.chequesUsed += 1
                        chequebookInstance.save(flush:true,failOnError:true)

                        debitOnus(checks)

                        tcoci.txnCheckStatus = TxnCheckStatus.get(3)
                        tcoci.cleared = true
                        tcoci.clearingDate = txFile.txnDate
                    }                
                    tcoci.save(flush:true,failOnError:true)
                }
                // update blotter
                def tb = new TxnCashCheckBlotter(cashOutAmt:0.00D, cashInAmt:0.00D, 
                    checkInAmt:txFile.txnAmt,checkOutAmt:0.00D,branch:txFile.branch,
                    currency:txFile.currency, user:UserMaster.get(session.user_id),
                    txnParticulars:txFile.txnParticulars, txnFile:txFile)
                tb.save(flush:true,failOnError:true);                   
            } else {
                // update blotter
                def tb = new TxnCashCheckBlotter(cashOutAmt:0.00D, cashInAmt:txFile.txnAmt, 
                    checkInAmt:0.00D,checkOutAmt:0.00D,branch:txFile.branch,
                    currency:txFile.currency, user:UserMaster.get(session.user_id),
                    txnParticulars:txFile.txnParticulars, txnFile:txFile)
                tb.save(flush:true,failOnError:true);                
            }
            

            
            // update txn_breakdown
            userMasterService.updateTellerBalanceStatus(false)
            glTransactionService.saveTxnBreakdown(txFile.id)
            
            println("Success Fully Saved to Txn File ID: "+txFile)
            println("sssTheReplyDate: "+sssTheReplyDate)
            println("reply date: "+sssDateReply.format(sssTheReplyDate))
            //indiTxnNumber:updateStatusTxnFile.id.toInteger()
            def trnsactionNumba = SssConfig.findByParamCode("GEN.10261").paramValue.toString() +"00000000"+txFile.id.toString()
            println("trnsactionNumba: "+trnsactionNumba)
            def sssInfoIntance = new SssOnlinePaymentDetail(txnFile:txFile,amount:amountCash,appmo:params.sssappmo,
            brnum:params.ssstxnBillRef,indiTxnNumber:trnsactionNumba,erbrn:params.ssserbrn,ername:params.sssername,ernum:params.sssernum,replyCode:replyMsgCode.toInteger(),
            replyDate:sssDateReply.format(sssTheReplyDate),indiPayorType:'Employer')
            sssInfoIntance.save(flush:true, failOnError:true);
            
            session["transactionFileId"] = txFile.id
            
            redirect(controller: "sssCollection", action: "show",id: sssInfoIntance.id)  
        
    }
    def debitOnus(Cheque cheque) {
        // update txn file
        def txnType = TxnTemplate.read(Institution.findByParamCode('GLS.60112').paramValue.toInteger())
        def depositInstance = cheque.chequebook.deposit
        
        def txnFile1 = new TxnFile(txnDate:Branch.get(1).runDate,txnParticulars:'ONUS',
            currency:depositInstance.product.currency.id,txnType:txnType.txnType,status:ConfigItemStatus.read(2),
            txnTimestamp:new Date().toTimestamp(),user:UserMaster.get(session.user_id),branch:depositInstance.branch,
            txnCode:txnType.code, txnDescription:txnType.description,acctNo:depositInstance.acctNo,
            txnAmt:cheque.chequeAmt,txnRef:'onus '+ cheque.chequeNo.toString(),depAcct:depositInstance,txnTemplate:txnType)
            txnFile1.save(flush:true,validate:false, failOnError:true)
        println("****************************************************************************")    
        println("checque Amount Debit Onus : "+cheque.chequeAmt)     
        println("before debit deposit availableBalAmt: "+depositInstance.availableBalAmt)
        depositInstance.availableBalAmt-=cheque.chequeAmt
        println("debited deposit available Bal Amt: "+depositInstance.availableBalAmt)
        println("debited deposit ledger Bal Amt: "+depositInstance.ledgerBalAmt)
        depositInstance.ledgerBalAmt-=cheque.chequeAmt
        println("after debiting ledgerBalAmt: "+depositInstance.ledgerBalAmt)
        println("****************************************************************************")
        depositInstance.save(flush:true, failOnError:true)
                        
        // update ledger
        def acctLedger1 = new TxnDepositAcctLedger(txnType:txnType.txnType,user:UserMaster.get(session.user_id),branch:depositInstance.branch,
            currency:depositInstance.product.currency,status:depositInstance.status,txnDate:Branch.get(1).runDate,
            txnFile:txnFile1,acct:depositInstance,acctNo:depositInstance.acctNo,debitAmt:cheque.chequeAmt,
            bal:depositInstance.ledgerBalAmt,txnRef:'onus '+ cheque.chequeNo.toString())
        acctLedger1.save(flush:true, validate:false, failOnError:true)                       
        glTransactionService.saveOnusGl(txnFile1)        
    }
    def sssCreateIndividualPayment(){
        println(" ***** sssCreateIndividualPayment  *********")
    }
    def confirmIndividualPaymentReferenceNumber(){
        println("confirmIndividualPaymentReferenceNumber ")
        session["checks"] = []
        println("params CIPRN: "+params)
        String transactionIDid = "00";
        def theReturnValue = SSSOnlineService.collectDataAjax(params,transactionIDid)
        println("theReturnValue: "+theReturnValue)
        
        println("theReturnValue: "+theReturnValue)
        def splitReplyMessage = ""
        def sssInformation = theReturnValue.split("@@#")
        for(int i = 0;i<sssInformation.length;i++){
            
            splitReplyMessage = sssInformation[sssInformation.length - 1]
        }
        println("splitReplyMessage: "+splitReplyMessage)
        flash.message = splitReplyMessage.toString()
        [theReturnValue:theReturnValue]
    }
    def saveIndividualPrnInquiry(){
        println(" save Individual PRN Inquiry")
        println("params SIPI: "+params)
        def amountCash  = params.tsamt.toString().replace(',','').toDouble()
        def sssFlexiFund = 0.00D
        if(params.flexiFund.toString() == "0"){
            sssFlexiFund = sssFlexiFund.toDouble()
        }else{
            sssFlexiFund = params.flexiFund ? (params.flexiFund.replaceAll(",","")).toDouble() : null
            
        }
        def newmonthlyContribution = 0.00D
        if(params.wsdlMethod.toString() == 'submitPaidIPRNum'){
            newmonthlyContribution = session["monthlycontri"] ? session["monthlycontri"].toString().replaceAll(",","").toDouble() : 0.00D
        }else{
            session["monthlycontri"] = 0
            def flexiFund = computeFlexiFund(params)
            newmonthlyContribution = session["monthlycontri"] ? session["monthlycontri"].toString().replaceAll(",","").toDouble() : 0.00D
        }
        sssFlexiFund = sssFlexiFund.toDouble()
        println("============ FLEXI FUND ==============")
        println("sssFlexiFund: "+sssFlexiFund)
        println("======================================")
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnTemplate.id)
        def txFile  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:Currency.get(1),
            txnAmt:amountCash,txnRef:params.txnReference,status:ConfigItemStatus.get(1), branch:UserMaster.get(session.user_id).branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.txnParticulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            txFile.save(flush:true, failOnError:true);
        println("txFile: "+txFile)
        String transactionIDid = txFile.id.toString()
        def trnsactionNumba = SssConfig.findByParamCode("GEN.10261").paramValue.toString() +"00000000"+transactionIDid
        println("trnsactionNumba: "+trnsactionNumba)
        def theReturnValue = SSSOnlineService.collectDataAjax(params,trnsactionNumba.toString())
        println("theReturnValue: "+theReturnValue)
        def sssInformation = theReturnValue.split("@@#")
        def replyMsgCode = sssInformation[0].toString()

            def updateStatusTxnFile = TxnFile.get(txFile.id)
            updateStatusTxnFile.status = ConfigItemStatus.get(2)
            updateStatusTxnFile.save(flush:true, failOnError:true);
            
            String xtxnValidator = params.txnTemplate.id.toString()
            def sssConfTxnTemplateId = SssConfig.findByParamCode("GEN.10263").paramValue.toString()
            // if Other Check Receipt transaction
            if(xtxnValidator == sssConfTxnTemplateId){
                session["checks"].id.each { tcoci_id ->
                    def tcoci = TxnCOCI.get(tcoci_id)
                    tcoci.status = ConfigItemStatus.get(2)
                    tcoci.txnCheckStatus = TxnCheckStatus.get(2)
                    tcoci.txnFile = txFile

                    def checkClearDate = tcoci.checkType.clearingDate
                    tcoci.clearingDate = checkClearDate

                    if(tcoci.checkType == CheckDepositClearingType.get(3)){
                        def checks = Cheque.findByChequeNo(tcoci.checkNo)
                        def chequebookInstance = checks.chequebook 
                        checks.chequeAmt = tcoci.checkAmt
                        checks.chequeDate = tcoci.checkDate
                        checks.isChequeClrOnUs = true
                        checks.status = CheckStatus.get(3)
                        checks.save(flush:true,failOnError:true)

                        chequebookInstance.chequesUsed += 1
                        chequebookInstance.save(flush:true,failOnError:true)

                        debitOnus(checks)

                        tcoci.txnCheckStatus = TxnCheckStatus.get(3)
                        tcoci.cleared = true
                        tcoci.clearingDate = txFile.txnDate
                    }                
                    tcoci.save(flush:true,failOnError:true)
                }
                // update blotter
                def tb = new TxnCashCheckBlotter(cashOutAmt:0.00D, cashInAmt:0.00D, 
                    checkInAmt:txFile.txnAmt,checkOutAmt:0.00D,branch:txFile.branch,
                    currency:txFile.currency, user:UserMaster.get(session.user_id),
                    txnParticulars:txFile.txnParticulars, txnFile:txFile)
                tb.save(flush:true,failOnError:true);                   
            } else {
                // update blotter
                def tb = new TxnCashCheckBlotter(cashOutAmt:0.00D, cashInAmt:txFile.txnAmt, 
                    checkInAmt:0.00D,checkOutAmt:0.00D,branch:txFile.branch,
                    currency:txFile.currency, user:UserMaster.get(session.user_id),
                    txnParticulars:txFile.txnParticulars, txnFile:txFile)
                tb.save(flush:true,failOnError:true);                
            }
            


             // update txn_breakdown
            userMasterService.updateTellerBalanceStatus(false)
            glTransactionService.saveTxnBreakdown(txFile.id)
            Date sssTheReplyDate = new Date(params.repdt.toString());
            println("Success Fully Saved to Txn File ID: "+txFile)
            println("sssTheReplyDate: "+sssTheReplyDate)
            println("reply date: "+sssDateReply.format(sssTheReplyDate))
            
             
            String xxPayorType = params.iprnum.toString()
            String frstLet = "";
            String payorType = "";
            frstLet = xxPayorType.substring(0,1)
            println("frstLet: "+frstLet)
            if(frstLet == "R"){
                payorType = "Employer"
            }else if(frstLet == "I"){
                payorType = "Individuals"
            }else if(frstLet == "H"){
                payorType = "Household Employer"
            }else if(frstLet == "S"){
                payorType = "Self-Employed Member"
            }else if(frstLet == "V"){
                payorType = "Voluntary Member"
            }else if(frstLet == "O"){
                payorType = "Overseas Filipino Worker"
            }else if(frstLet == "F"){
                payorType = "Farmer/Fisherman"
            }else{
                payorType = "Non-working Spouse"
            }
            def sssInfoIntance = new SssOnlinePaymentDetail(txnFile:txFile,amount:amountCash,indiTxnNumber:trnsactionNumba.toString(),indiIprnum:params.iprnum.toString(),
            indiEenum:params.eenum.toString(),indiEename:params.eename.toString(),fapid:params.fapId.toString(),tapid:params.tapId.toString(),replyCode:replyMsgCode.toInteger(),
            replyDate:sssDateReply.format(sssTheReplyDate),flexiAmt:sssFlexiFund,indiPayorType:payorType,monthlyContribution:newmonthlyContribution)
            sssInfoIntance.save(flush:true, failOnError:true);
            
            session["transactionFileId"] = updateStatusTxnFile.id
            redirect(controller: "sssCollection", action: "show",id: sssInfoIntance.id)    

        
    }
    
    def sssCreateIndividualPaymentNoPrn(){
        println(" ***** sssCreateIndividualPaymentNoPrn  *********")
    }
    
    def confirmIndividualPaymentReferenceNumberNoPrn(){
        session["checks"] = []
        println("============= confirmIndividualPaymentReferenceNumberNoPrn ==========================")
        println("PARAMS: "+params)
       String transactionIDid = "00";
        def theReturnValue = SSSOnlineService.collectDataAjax(params,transactionIDid)
        println("theReturnValue: "+theReturnValue)
        
        println("theReturnValue: "+theReturnValue)
        def splitReplyMessage = ""
        def sssInformation = theReturnValue.split("@@#")
        for(int i = 0;i<sssInformation.length;i++){
            
            splitReplyMessage = sssInformation[sssInformation.length - 1]
        }
        println("splitReplyMessage: "+splitReplyMessage)
        flash.message = splitReplyMessage.toString()
        [theReturnValue:theReturnValue]
    }
    
    def createPrn(){
        // request for new prn
    }
    def requestIndvPrn(){
        println("=============== requestIndvPrn ==================")
        println("params: "+params)
        session["checks"] = []
        session["monthlycontri"] = 0
        def sssgetCode = SssMembershipType.get(params.membershipType.toInteger()).code
        params.membershipType = sssgetCode.toString()
       def trnsactionNumba = "000"
        println("trnsactionNumba: "+trnsactionNumba)
        def theReturnValue = SSSOnlineService.collectDataAjax(params,trnsactionNumba)
        println("theReturnValue: "+theReturnValue)
        
        def flexiFund = computeFlexiFund(params)
        def monthlyContribution = session["monthlycontri"]
        [theReturnValue:theReturnValue,flexiFund:flexiFund,monthlyContribution:monthlyContribution]
        
    }
    def create() {
        // other payment
    }
    def computeFlexiFund(params){
        String fapld = params.fapId.toString()
        String tapld = params.tapId.toString()
        Double tsamt = params.totalAmt ? (params.totalAmt.replaceAll(",","")).toDouble() : null
      
        
        //strErnum + '@@#' +strAmount + '@@#' + strReplyDate + '@@#' + strFapid+ '@@#' + strPrn + '@@#' + strErnum  + '@@#' + strErname + '@@#' + strReplyCode+ '@@#' + replyMesg+ '@@#'    
        int m1 = Integer.parseInt(fapld.substring(0,2));
        int m2 = Integer.parseInt(tapld.substring(0,2));
        int y1 = Integer.parseInt(fapld.substring(2));
        int y2 = Integer.parseInt(tapld.substring(2));
        println("m1: "+m1)
        println("m2: "+m2)
        println("y1: "+y1)
        println("y2: "+y2)
        // if greter than1760
        // flexiamount = (amountPermount - 1760) * noOfMonths
        
        try {
          int noOfMonths = (y2-y1)*12;  
          noOfMonths = noOfMonths +((12-(m1-1)+(m2-12))); 
          
          double amountPerMonth = tsamt / noOfMonths ; 
          double comptedFlexifund = 0.00D
          /*if(comptedFlexifund <= 0){
              comptedFlexifund = 0.00D
          }*/
          if(amountPerMonth > 1760){
              println("testimg")
              println("amountPerMonth: "+amountPerMonth)
              println("tsamt: "+tsamt)
              println("noOfMonths: "+noOfMonths)
              comptedFlexifund = (amountPerMonth - 1760) * noOfMonths;
              amountPerMonth = 1760
          }else if(amountPerMonth < 0){
              comptedFlexifund = 0.00D
          }else{
              comptedFlexifund = 0.00D
          }
          String sResultAmount = String.valueOf(comptedFlexifund);
          println("Computed Flexifund: " + sResultAmount)
          println("Monthly Contribution: "+amountPerMonth)
          session["monthlycontri"] = amountPerMonth
          return sResultAmount;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    def saveSSSCollectionAjax(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        
        println("json.txnType"+json.txnType)
        println("json.paymentCode"+json.paymentCode)
        println("json.paymentType"+json.paymentType)
        println("json.payorType"+json.payorType)
        println("json.ssNumber"+json.ssNumber)
        println("json.startingPeriod"+json.startingPeriod)
        println("json.endingPeriod"+json.endingPeriod)
        println("json.ssAmountPaid"+json.ssAmountPaid)
        println("json.ecAmountPaid"+json.ecAmountPaid)
        println("json.txnRef"+json.txnRef)
        println("json.txnParticulars"+json.txnParticulars)

            def txnFileInstance = new TxnFile()

            txnFileInstance.currency = Currency.get(1)
            txnFileInstance.user = UserMaster.get(session.user_id)
            txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
            txnFileInstance.txnAmt = Double.parseDouble(json.ssAmountPaid.toString().replaceAll(",",""))
            txnFileInstance.txnCode = TxnTemplate.get(json.txnType.toInteger()).code
            txnFileInstance.txnDate = Branch.get(1).runDate
            txnFileInstance.txnTimestamp = new Date().toTimestamp()
            txnFileInstance.txnDescription = TxnTemplate.get(json.txnType.toInteger()).description
            txnFileInstance.status = ConfigItemStatus.get(2)
            txnFileInstance.txnType = TxnTemplate.get(json.txnType.toInteger()).txnType
            txnFileInstance.txnTemplate = TxnTemplate.get(json.txnType.toInteger())
            txnFileInstance.txnRef = json.txnRef.toString()
            txnFileInstance.txnParticulars = json.txnParticulars.toString()
            txnFileInstance.save(flush:true,failOnError:true)  
            
            def sssCollectionInstance = new TxnSssCollection()
            sssCollectionInstance.txnFile = txnFileInstance
            sssCollectionInstance.paymentCode = SssPaymentCode.get(json.paymentCode.toInteger())
            sssCollectionInstance.paymentType = SssPaymentType.get(json.paymentType.toInteger())
            sssCollectionInstance.payorType = SssPayorType.get(json.payorType.toInteger())
            sssCollectionInstance.ssNumber = json.ssNumber.toString()
            sssCollectionInstance.startingPeriod = json.startingPeriod.toString()
            sssCollectionInstance.endingPeriod = json.endingPeriod.toString()
            sssCollectionInstance.ssAmountPaid = Double.parseDouble(json.ssAmountPaid.toString().replaceAll(",",""))
            sssCollectionInstance.ecAmountPaid = Double.parseDouble(json.ecAmountPaid.toString().replaceAll(",",""))
            sssCollectionInstance.save(flush:true,failOnError:true)
            
            // update blotter
            def tb = new TxnCashCheckBlotter(cashOutAmt:0.00D, cashInAmt:txnFileInstance.txnAmt, 
                checkInAmt:0.00D,checkOutAmt:0.00D,branch:txnFileInstance.branch,
                currency:txnFileInstance.currency, user:UserMaster.get(session.user_id),
                txnParticulars:txnFileInstance.txnParticulars, txnFile:txnFileInstance)
            tb.save(flush:true,failOnError:true);

            // update txn_breakdown
            userMasterService.updateTellerBalanceStatus(false)
            glTransactionService.saveTxnBreakdown(txnFileInstance.id)
            
        def queryall = "select * from txn_file order by id desc limit 1"
        def resultqueryall = sql.rows(queryall)
        println("result: "+resultqueryall)
        render resultqueryall as JSON    
   
    }
    
    def save() {
        redirect(controller:"tellering", action:"index")

    }
    
    def validateAmount(Double tsamt, String fapId, String tapId){
      int m1 = Integer.parseInt(fapld.substring(0,2));
      int m2 = Integer.parseInt(tapld.substring(0,2));
      int y1 = Integer.parseInt(fapld.substring(2));
      int y2 = Integer.parseInt(tapld.substring(2));
      
      try {

        int noOfMonths = (y2-y1)*12;  

        noOfMonths = noOfMonths +((12-(m1-1)+(m2-12))); 

        double amountPerMonth = tsamt / noOfMonths ; 

        String sResultAmount = String.valueOf(amountPerMonth);

        return sResultAmount;

      } catch (Exception e) {

          e.printStackTrace();

          return null;

      }
            
    }
    def sssPrintTransactionSlip(){
         println params.txnFile
         // def xxtransactionFileId = session.transactionFileId
         def xxtransactionFileId = params.txnFile.toInteger()
         def xxmap = session.map
         try {  

            println"Reversal Validation"
            params._name = "Transaction Reversal Validation Slip"
            params._format ="PDF"
            params._file ="SssEmployerTransactionSlip.jasper" //jasper file
            params.ID = xxtransactionFileId //parameter name & value
            
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()

            response.outputStream << bytes
            response.outputStream.flush()
            
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }        
    }
    def sssIndividualPrintTransactionSlip(){
         println params.txnFile
         // def xxtransactionFileId = session.transactionFileId
         def xxtransactionFileId = params.txnFile.toInteger()
         def xxmap = session.map
         try {  

            println"Reversal Validation"
            params._name = "Transaction Reversal Validation Slip"
            params._format ="PDF"
            params._file ="SssTransactionSlip.jasper" //jasper file
            params.ID = xxtransactionFileId //parameter name & value
            
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()

            response.outputStream << bytes
            response.outputStream.flush()
            
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }        
    }
    
    
}
