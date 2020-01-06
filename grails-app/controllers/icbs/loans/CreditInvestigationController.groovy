package icbs.loans


import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql
import static org.springframework.http.HttpStatus.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.AttachmentType
import icbs.loans.CreditInvestigationBRRHistory
import icbs.lov.BorrowRiskRating
import icbs.loans.LoanApplication
import icbs.cif.Customer
import icbs.admin.Product
import icbs.loans.CreditScoringCodeDescription
import icbs.loans.CreditScoringProductConfig
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringPreQualificationRecords
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringChecklistRecords
import icbs.loans.CreditScoringMatrix
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringRatedItems
import icbs.loans.CreditScoringRatedItemsRecords
import icbs.loans.CreditScoringLoanAppDetails
import icbs.lov.LoanCollateralType
@Transactional(readOnly = true)
class CreditInvestigationController {
    def auditLogService
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE", saveCharge: "PUT"]
    def dataSource
    def index(Integer max) {
        // params.max = Math.min(max ?: 10, 100)
        params.max = Math.min(max ?: 25, 100)
        if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null || params.query.trim() == "") {
            respond CreditInvestigation.list(params), model:[params:params, CreditInvestigationInstanceCount: CreditInvestigation.count()]
        } else{
            def result = CreditInvestigation.createCriteria().list(params) {                
                // idEq(params.query.trim().toLong())
                or{
                    'loanApplication'{
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
           
            }
            respond result, model:[params:params, creditInvestigationInstanceCount: result.totalCount]
        }
        return
    }

    def show(CreditInvestigation creditInvestigationInstance) {
        session["page"]="show"
        def c = CreditInvestigationBRRHistory.createCriteria()
        def lastId = c.list {
            
            eq("creditInvestigation", creditInvestigationInstance)
            
            maxResults(1)
            order("id", "desc")
        }
        println("lastId: "+lastId)
        [creditInvestigationInstance:creditInvestigationInstance,lastId:lastId]
    }

    def create() {
        // initialize session variables
        session["attachments"] = []
        session["page"] = ""
        def loanApplication = null
        if (params?.id) {
            loanApplication = LoanApplication.get(params?.id)
        }

        respond new CreditInvestigation(params), model:[loanApplication:loanApplication]
    }

    @Transactional
    def save(CreditInvestigation creditInvestigationInstance) {
        println("params: "+params)
        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        if (creditInvestigationInstance.hasErrors()) {
            respond creditInvestigationInstance.errors, view:'create'
            return
        }

        for(attachment in session["attachments"]) {
            creditInvestigationInstance.addToAttachments(attachment)
        }
        session["attachments"] = null
        
        creditInvestigationInstance.remarks = params.remarksChecklist
        creditInvestigationInstance.save flush:true
        //============== new code update borrow risk rating
        
        //        def bbrInstance = new CreditInvestigationBRRHistory()
        //        bbrInstance.dateUpdated = UserMaster.get(session.user_id).branch.runDate
        //        bbrInstance.creditInvestigation = creditInvestigationInstance
        //        bbrInstance.datetimestamp = new Date()
        //        if(params.riskRating.id == "" || params.riskRating.id == null){
        //            
        //        }else{
        //            bbrInstance.borrowRiskRating = BorrowRiskRating.get(params.riskRating.id)
        //        }
        //        if(params.remarks == "" || params.remarks == null){
        //            bbrInstance.remarks = ""
        //        }else{
        //            bbrInstance.remarks = params.remarks.toString()
        //        }
        //        bbrInstance.createdBy = UserMaster.get(session.user_id)
        //        bbrInstance.save(flush: true)
        //=======================================================
        def description = 'Loan credit investigation ' +  creditInvestigationInstance.id + ' was created by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00401', description, 'Loan', null, null, null, creditInvestigationInstance.id)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'creditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect creditInvestigationInstance
            }
            '*' { respond creditInvestigationInstance, [status: CREATED] }
        }
    }

    def edit(CreditInvestigation creditInvestigationInstance) {
        def c = CreditInvestigationBRRHistory.createCriteria()
        def lastId = c.list {
            
            eq("creditInvestigation", creditInvestigationInstance)
            
            maxResults(1)
            order("id", "desc")
        }
        println("lastId: "+lastId)
        [creditInvestigationInstance:creditInvestigationInstance,lastId:lastId]
    }

    @Transactional
    def update(CreditInvestigation creditInvestigationInstance) {
        println("update params: "+params)
        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        if (creditInvestigationInstance.hasErrors()) {
            respond creditInvestigationInstance.errors, view:'edit'
            return
        }
        creditInvestigationInstance.remarks = params.remarksChecklist
        creditInvestigationInstance.save flush:true
        //============== new code update borrow risk rating
        
        //        def bbrInstance = CreditInvestigationBRRHistory.get(params.brrRating)
        //        println("bbrInstance: "+bbrInstance)
        //        println("borrowRiskRating: "+bbrInstance.borrowRiskRating)
        //        if(bbrInstance){
        //            
        //                def newRiskRating = 0
        //                def oldRiskRating = 0
        //                if(params.riskRating.id == "" || params.riskRating.id == null){
        //                    newRiskRating = 0;
        //                }else{
        //                   newRiskRating = params.riskRating.id.toInteger()
        //                }
        //                if(bbrInstance.borrowRiskRating == "" || bbrInstance.borrowRiskRating == null){
        //                    oldRiskRating = 0;
        //                }else{
        //                   oldRiskRating = bbrInstance.borrowRiskRating.id.toInteger()
        //                }
        //                if(oldRiskRating == newRiskRating){
        //                    println("if condition be like")
        //                }else{
        //                    println("else condition be like")
        //                    def nbbrInstance = new CreditInvestigationBRRHistory()
        //                    nbbrInstance.dateUpdated = UserMaster.get(session.user_id).branch.runDate
        //                    nbbrInstance.creditInvestigation = creditInvestigationInstance
        //                    nbbrInstance.datetimestamp = new Date()
        //                    if(params.riskRating.id == "" || params.riskRating.id == null){
        //
        //                    }else{
        //                        nbbrInstance.borrowRiskRating = BorrowRiskRating.get(params.riskRating.id)
        //                    }
        //                    if(params.remarks == "" || params.remarks == null){
        //                        nbbrInstance.remarks = ""
        //                    }else{
        //                        nbbrInstance.remarks = params.remarks.toString()
        //                    }
        //                    nbbrInstance.createdBy = UserMaster.get(session.user_id)
        //                    nbbrInstance.save(flush: true)
        //                    //=======================================================
        //                }
        //                
        //        }else{
        //            def nbbrInstance = new CreditInvestigationBRRHistory()
        //                nbbrInstance.dateUpdated = UserMaster.get(session.user_id).branch.runDate
        //                nbbrInstance.creditInvestigation = creditInvestigationInstance
        //                nbbrInstance.datetimestamp = new Date()
        //                if(params.riskRating.id == "" || params.riskRating.id == null){
        //
        //                }else{
        //                    nbbrInstance.borrowRiskRating = BorrowRiskRating.get(params.riskRating.id)
        //                }
        //                if(params.remarks == "" || params.remarks == null){
        //                    nbbrInstance.remarks = ""
        //                }else{
        //                    nbbrInstance.remarks = params.remarks.toString()
        //                }
        //                nbbrInstance.createdBy = UserMaster.get(session.user_id)
        //                nbbrInstance.save(flush: true)
        //        }
        //=======================================================
        def description = 'Loan credit investigation ' +  creditInvestigationInstance.id + ' was edited by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00402', description, 'Loan', null, null, null, creditInvestigationInstance.id)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CreditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect creditInvestigationInstance
            }
            '*'{ respond creditInvestigationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CreditInvestigation creditInvestigationInstance) {

        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        creditInvestigationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CreditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    /*
     * Attachments
     */

    def showAttachmentsAjax() {
        render(template:"attachments/list") as JSON
        return
    }    

    def showAttachmentsAjax2() {
        def id  = params?.id
        def creditInvestigationInstance = CreditInvestigation.get(id)

        render(template:"attachments/list", model:[creditInvestigationInstance:creditInvestigationInstance]) as JSON
        return
    } 

    def showAddAttachmentAjax() {    
        render(template:"attachments/form") as JSON
        return
    }

    def addAttachmentAjax() {  
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def attachments
        if (session["attachments"]) {
            attachments = session["attachments"]
        } else {
            attachments = []
        }        
        attachments.add(attachment)
        session["attachments"] = attachments        

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }

    @Transactional
    def addAttachmentAjax2() { 
        def id  = params?.id 
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def creditInvestigationInstance = CreditInvestigation.get(id)
        creditInvestigationInstance.addToAttachments(attachment)
        creditInvestigationInstance.save flush:true       

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }

    def showUpdateAttachmentAjax() {   
        def id = params?.id?.toInteger()
        
        def attachments = session["attachments"]        
        def attachment = attachments[id]

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    }

    def showUpdateAttachmentAjax2() {
        def id = params?.id?.toInteger()
        
        def attachment = LoanAttachment.get(id)

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    } 

    def updateAttachmentAjax() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachments = session["attachments"]        
        def attachment = attachments[id]

        attachment.description = description
        attachment.type = AttachmentType.get(type)

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }

    @Transactional
    def updateAttachmentAjax2() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachment = LoanAttachment.get(id)
        attachment.description = description
        attachment.type = AttachmentType.get(type)
        attachment.save flush:true

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }

    def deleteAttachmentAjax() {
        def id = params?.id?.toInteger()
        session["attachments"].remove(id)

        render "success"
        return
    }

    @Transactional
    def deleteAttachmentAjax2() {
        def id = params?.id?.toInteger()
        def attachmentId = params?.attachmentId?.toInteger()

        def creditInvestigationInstance = CreditInvestigation.get(id)
        def attachment = LoanAttachment.get(attachmentId)

        creditInvestigationInstance.removeFromAttachments(attachment)
        creditInvestigationInstance.save flush:true

        render "success"
        return
    }

    def showAttachment() {
        def id = params?.id
        def attachment = LoanAttachment.get(id)

        if (attachment) {
            response.setHeader("Content-Disposition", "inline;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }

    def downloadAttachment() {
        def id = params?.id
        def attachment = LoanAttachment.get(id)

        if (attachment) {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }
    def collectionInformation(){
        def json = request.JSON
        //def TxnTypeInstance = TxnType.get(json.typevalue.toInteger())
        //def TxnTypeInstance = TxnType.get(json.typevalue)
        def sql = new Sql(dataSource)
        def TxnTypeInstance = "select a.*,c.display_name from loan_application a inner join customer c on c.id = a.customer_id  where a.id = '${json.id.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)
        
        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    def performCreditScoring(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        
        //use parent code to get scoring sections and questions
        def c = CreditScoringQuestionSection.createCriteria()
        def scoringSectionInstance = c.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        println("scoringSectionInstance: "+scoringSectionInstance)
        [scoringSectionInstance:scoringSectionInstance,creditInvestigationInstance:creditInvestigationInstance]
        
    }
    def preQualification(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        def c = CreditScoringPreQualification.createCriteria()
        def idCreditPreq = c.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        [scoringProductConfigInstance:scoringProductConfigInstance,creditInvestigationInstance:creditInvestigationInstance,idCreditPreq:idCreditPreq]
        
    }
    @Transactional
    def collectPreQualificationEvaluation(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        def loanApplicationInstance = LoanApplication.get(params.loanApp)
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(loanApplicationInstance.product)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        def idCreditPreq = CreditScoringPreQualification.findAllByCreditScoringCodeDescription(crrCodeDescriptionInstance)
        //        def idCreditPreq = CreditScoringPreQualification.findAllByCreditScoringCodeDescription(scoringProductConfigInstance?.creditScoringCodeDescription)
       
        def xxcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        
        for(i in idCreditPreq){
            def preQualificationInstance = new CreditScoringPreQualificationRecords()
            preQualificationInstance.loanApplication = loanApplicationInstance
            preQualificationInstance.creditScoringPreQualification = i
            if(xxcodeAnswers[xxcounter] == null || xxcodeAnswers[xxcounter] == "" || xxcodeAnswers[xxcounter] == "null"){
                xxcodeAnswers[xxcounter] = "5"
            }
            preQualificationInstance.preQualificationAnswer = CreditScoringAnswers.get(xxcodeAnswers[xxcounter].toInteger())
            preQualificationInstance.scoredBy = UserMaster.get(session.user_id)
            preQualificationInstance.scoringDate = UserMaster.get(session.user_id).branch.runDate
            preQualificationInstance.save(flush:true,failOnError:true)
           
            println("i: "+i)
            println("xxcodeAnswers: "+xxcodeAnswers[xxcounter])
            xxcounter = xxcounter + 1
        }
        flash.message = "Pre Qualification for Credit Scoring Successfully Evaluated"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    @Transactional
    def viewCreditScoringDetails(){
        println("params: "+params)
       
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        //================ Insert into Credit Scoring Loan Application Details =============
        def sqlxxx = new Sql(dataSource)
        def creditScoringLoanDetailsInstance
        def loanApplicationCreditDetails = CreditScoringLoanAppDetails.findByLoanApplication(creditInvestigationInstance.loanApplication)
      
        if(loanApplicationCreditDetails){
            // do noting
            creditScoringLoanDetailsInstance = loanApplicationCreditDetails
        }else{
            // insert to table
            def loaanTotalOutStandingBalance = " select round(sum(balance_amount),2) as total_out_standing_bal  from loan A " +
            " left outer join customer B on B.id = A.customer_id " +
            " where A.customer_id = "+ creditInvestigationInstance.loanApplication.customer.id
            def lonTotOs = sqlxxx.rows(loaanTotalOutStandingBalance)


            def credScorloanAppInstance = new CreditScoringLoanAppDetails()
            credScorloanAppInstance.loanApplication = creditInvestigationInstance.loanApplication
            credScorloanAppInstance.createdBy =  UserMaster.get(session.user_id)
            credScorloanAppInstance.dateCreated = UserMaster.get(session.user_id).branch.runDate
            credScorloanAppInstance.totalOsBalance = lonTotOs[0].total_out_standing_bal ? lonTotOs[0].total_out_standing_bal.toDouble() : 0.00D
            credScorloanAppInstance.save(flush:true,failOnError:true)
                
            creditScoringLoanDetailsInstance = credScorloanAppInstance
        }
        println("creditScoringLoanDetailsInstance: "+creditScoringLoanDetailsInstance)
       
        //==================================================================================
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        
        //===== for records with value
        def c = CreditScoringPreQualificationRecords.createCriteria()
        def preQualificationInstance = c.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        // calculateQualification for credit Scoring checklist if there(s) a no dont proceed
        Integer sumCalc = 0 
        Boolean isQualifiedForCheckList = true
            
        /*println("preQualificationInstance: "+preQualificationInstance)
        if(preQualificationInstance){
        for(preQualif in preQualificationInstance){
        println("preQualif.preQualificationAnswer: "+preQualif.preQualificationAnswer.value.toInteger())
        if(preQualif.preQualificationAnswer.value.toInteger() == 0){
        sumCalc = 1
        }
        println("sumCalc: "+sumCalc)
                    
        }
        }else{
        sumCalc = 1
        isQualifiedForCheckList = false
        }
        println("sumCalc: "+sumCalc)
        if(sumCalc > 0){
        isQualifiedForCheckList = false
        } */
        println("isQualifiedForCheckList: "+isQualifiedForCheckList)
            
        //=========================   
        // for default value if theres no record
        def d = CreditScoringPreQualification.createCriteria()
        def idCreditPreq = d.list {
            and {
                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        //====
 
        
        //=========== get Credit Scoring check List instances
        Boolean isCheckListAlreadyDone = false
        def checkListResultInstance = CreditScoringChecklistRecords.createCriteria()
        def creditScoringResultInstance = checkListResultInstance.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        //===================================================
        println("creditScoringResultInstance: "+creditScoringResultInstance)
        if(creditScoringResultInstance){
            isCheckListAlreadyDone = true
        }
        
        //=========== display Sections in Tab
        
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        
        //use parent code to get scoring sections and questions
        def sssectionsInstance = CreditScoringQuestionSection.createCriteria()
        def xxscoringSectionInstance = sssectionsInstance.list {
            and {
                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        //====================
        println("xxscoringSectionInstance: "+xxscoringSectionInstance)
        
        
        // query for tally of scores
        def sql = new Sql(dataSource)
        def tallyQuery = " select A.credit_scoring_question_section_id as id,C.name_of_section as name,sum(CAST (B.value AS DOUBLE PRECISION)) as sumofscores,count(D.id) as noofitems,C.section_percentage " +
            " from Credit_Scoring_Checklist_Records A " +
            " left outer join credit_scoring_answers B on A.credit_scoring_answers_id = B.id " +
            " left outer join credit_scoring_question_section C on A.credit_scoring_question_section_id = C.id " +
            " left outer join credit_scoring_questions D on D.id = A.credit_scoring_questions_id " +
            " where A.loan_application_id = "+ creditInvestigationInstance.loanApplication.id +
            " group by A.credit_scoring_question_section_id,C.name_of_section,C.section_percentage " +
            " order by A.credit_scoring_question_section_id "
        def resultqueryall = sql.rows(tallyQuery)
        def subtotal = 0
        def scoreRateTotal = 0
        def totalScoresInstance = [:]
                   
                   
        for(totalResult in resultqueryall){

            subtotal = subtotal + (totalResult?.sumofscores / totalResult?.noofitems)
            scoreRateTotal = scoreRateTotal + ((totalResult?.sumofscores / totalResult?.noofitems)*(totalResult?.section_percentage * 0.01))
        }
        println("subtotal: "+subtotal)
        println("scoreRateTotal: "+scoreRateTotal)
        totalScoresInstance.put('scoreRateTotal',scoreRateTotal)
        totalScoresInstance.put('scoreSubTotal',subtotal)
        
        // If there is a rated Item
        def ratedInstanceListingRecords
        def isRatedAlreadyEvaluated = false
        if(scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem == true){
            def xratedInstance = CreditScoringRated.createCriteria()
            def theRatedInstances = xratedInstance.list {
                and {
                    eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
                }
                order("id", "asc")
            }
            def xxRecordInstanceItems = CreditScoringRatedItemsRecords.createCriteria()
            def xxxitemsssss = xxRecordInstanceItems.list {
                and {
                    eq("loanApplication", creditInvestigationInstance.loanApplication)
                }
                order("id", "asc")
            }
            
            if(xxxitemsssss){
                isRatedAlreadyEvaluated = true
            }
            ratedInstanceListingRecords = theRatedInstances
            
        }
        
        def initialCrrRatingScores = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
        println("initialCrrRatingScores: "+initialCrrRatingScores)
        
        Boolean isRecommendationEmpty = false
        def finalCrrValueAfterDocu = 0
        def calllculatedCRRvalue = 0.00D
        def initialCccccrr = 0
        
        if(initialCrrRatingScores){
            println("scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem: "+scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem)
            // check if there is a rated Items.
            
            if(initialCrrRatingScores.recommendedCrrScore){
                isRecommendationEmpty = true
            }

            println("================ FINAL CRR BEFORE AND AFTER DOCUMENTATION ==============")
            // for final CRR After documentation compliance factor
            def outStandingBalanceOfLoans = 0.00
            if(creditScoringLoanDetailsInstance.totalOsBalance){
                outStandingBalanceOfLoans = creditScoringLoanDetailsInstance.totalOsBalance
            }
            
            def xrecommended = initialCrrRatingScores.recommendedCrrScore? initialCrrRatingScores.recommendedCrrScore.toInteger() : 0
            
            // reasonFor Rating if there is no rated Items
            def reasonForRating = 0
            if(creditScoringLoanDetailsInstance.reasonsOfRating){
                reasonForRating = creditScoringLoanDetailsInstance.reasonsOfRating
            }
            // appraisalValu if there is rated Items
            def appraisalValueeee = 0.00D
            if(creditScoringLoanDetailsInstance.appraisalValueRem){
                appraisalValueeee = creditScoringLoanDetailsInstance.appraisalValueRem
            }
            def xGivenValue = 0.00D
            def theRecommendedCrr = xrecommended
            if(scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem == true){
                xGivenValue = appraisalValueeee
            }else{
                xGivenValue = reasonForRating
            }
            if(outStandingBalanceOfLoans > 0  && xGivenValue > 0){
                if(theRecommendedCrr >= 8 && xGivenValue >= outStandingBalanceOfLoans){
                    finalCrrValueAfterDocu = 8
                }else{
                    if(theRecommendedCrr >= 8 && xGivenValue < outStandingBalanceOfLoans){
                        finalCrrValueAfterDocu = theRecommendedCrr
                    }else{
                        if(theRecommendedCrr <= 7 && theRecommendedCrr >= 4 && xGivenValue >= outStandingBalanceOfLoans){
                            finalCrrValueAfterDocu = theRecommendedCrr - 1
                        }else{
                            finalCrrValueAfterDocu = theRecommendedCrr
                        }
                    }
                }
            }else{
                finalCrrValueAfterDocu = theRecommendedCrr
            }

            // final crr after documentation
            def xxcompletenessScoreValue = 0
            if(initialCrrRatingScores){
                if(initialCrrRatingScores.scoreCompletenessOfDocument){
                    xxcompletenessScoreValue = initialCrrRatingScores.scoreCompletenessOfDocument.value ? initialCrrRatingScores.scoreCompletenessOfDocument.value.toInteger() : 0
                }
            }
            if(xxcompletenessScoreValue == 0 && finalCrrValueAfterDocu < 7){
                finalCrrValueAfterDocu = 7
            }else{
                if(xxcompletenessScoreValue == 0 && finalCrrValueAfterDocu >= 7 && finalCrrValueAfterDocu < 10){
                    finalCrrValueAfterDocu = finalCrrValueAfterDocu + 1
                }else{
                    if(xxcompletenessScoreValue == 8 && finalCrrValueAfterDocu < 10){
                        finalCrrValueAfterDocu = finalCrrValueAfterDocu + 1
                    }
                }
            }
            
            initialCccccrr = initialCrrRatingScores.calculatedCrr ? initialCrrRatingScores.calculatedCrr.toInteger() : 0
            
        }
        
        
        def daCalculatedCrrDetails  = CreditScoringMatrix.findByCalculatedBrr(initialCccccrr)
       
        
        def finalResultsss = CreditScoringMatrix.findByCalculatedBrr(finalCrrValueAfterDocu.toInteger())
        
        println("finalCrrValueAfterDocu: "+finalCrrValueAfterDocu)
        println("finalResultsss: "+finalResultsss)
        //============================
        [creditScoringLoanDetailsInstance:creditScoringLoanDetailsInstance,daCalculatedCrrDetails:daCalculatedCrrDetails ,
            isRatedAlreadyEvaluated:isRatedAlreadyEvaluated,ratedInstanceListingRecords:ratedInstanceListingRecords,scoringProductConfigInstance:scoringProductConfigInstance ,
            finalResultsss:finalResultsss,isRecommendationEmpty:isRecommendationEmpty ,
            isCheckListAlreadyDone:isCheckListAlreadyDone,initialCrrRatingScores:initialCrrRatingScores,preQualificationInstance:preQualificationInstance ,
            idCreditPreq:idCreditPreq,isQualifiedForCheckList:isQualifiedForCheckList ,
            creditScoringResultInstance:creditScoringResultInstance,xxscoringSectionInstance:xxscoringSectionInstance ,
            creditInvestigationInstance:creditInvestigationInstance,resultqueryall:resultqueryall,totalScoresInstance:totalScoresInstance]
    }
    def updatePreQualificaion(){
        println("params: "+params)

        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        
        def c = CreditScoringPreQualificationRecords.createCriteria()
        def recentPreQualificationInstance = c.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        println("recentPreQualificationInstance: "+recentPreQualificationInstance)
        [recentPreQualificationInstance:recentPreQualificationInstance,creditInvestigationInstance:creditInvestigationInstance]
    }
    def updatePerformedCreditScoring(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        //use parent code to get scoring sections and questions
        def c = CreditScoringQuestionSection.createCriteria()
        def scoringSectionInstance = c.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        def checkListInsss = CreditScoringChecklistRecords.createCriteria()
        def recentCheckListInstance = checkListInsss.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        
        println("scoringSectionInstance: "+scoringSectionInstance)
        [scoringSectionInstance:scoringSectionInstance,creditInvestigationInstance:creditInvestigationInstance]
        
    }
    @Transactional
    def updatePreQualificationEvaluation(){
        println("==== updatePreQualificationEvaluation =====")
        println("params: "+params)
        // credit Investigation id for redirect purposes
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        
        // loan application id to update prequalification result
        def loanApplicationInstance = LoanApplication.get(params.loanApp)
        def d = CreditScoringPreQualificationRecords.createCriteria()
        def preQuallificationInstance = d.list {
            and {
                eq("loanApplication", loanApplicationInstance)
            }
            order("id", "asc")
        }
        
        // loop values for update
        Integer xjmcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        for(preQualOldRecords in preQuallificationInstance){
            println("preQualOldRecords: "+preQualOldRecords)
            // update records base on answers in the form
            // check if some of the answers from the from is null then set value to 'NO'
            if(xxcodeAnswers[xjmcounter] == null || xxcodeAnswers[xjmcounter] == "" || xxcodeAnswers[xjmcounter] == "null"){
                xxcodeAnswers[xjmcounter] = "5"
            }
            preQualOldRecords.preQualificationAnswer = CreditScoringAnswers.get(xxcodeAnswers[xjmcounter].toInteger())
            preQualOldRecords.lastUpdateBy = UserMaster.get(session.user_id)
            preQualOldRecords.lastUpdatedDate = UserMaster.get(session.user_id).branch.runDate
            preQualOldRecords.save(flush: true,failOnError: true)
            xjmcounter = xjmcounter + 1
        }
        flash.message = "Successfully Updated"
        redirect(action: 'show',controller: 'loanApplication',id: creditInvestigationInstance.loanApplication.id)
    }
    @Transactional
    def saveCreditScoringChecklist(){
        println("====== saveCreditScoringChecklist ======")
        println("params: "+params)
        // ==== get all sections and questions
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        
        //use parent code to get scoring sections and questions
        def sectionListInstance = CreditScoringQuestionSection.createCriteria()
        def scoringSectionInstance = sectionListInstance.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        println("scoringSectionInstance: "+scoringSectionInstance)
        
        // set parameters from form
        Integer xjmcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        
        // loop section to get questions under section
        for(secionInstance in scoringSectionInstance){
            println("Section: "+secionInstance)
            //get all questions under section
            def questionUnderSections = CreditScoringQuestions.createCriteria()
            def questionsInstance = questionUnderSections.list {
                and {
                    eq("creditScoringQuestionSection", secionInstance)
                }
                order("id", "asc")
            }
            for(questionsUnderSectionInstance in questionsInstance){
                println("ans from form: "+xxcodeAnswers[xjmcounter])
                println("questions: "+questionsUnderSectionInstance)
                def checkListRecordInstance = new CreditScoringChecklistRecords()
                checkListRecordInstance.loanApplication = LoanApplication.get(params.loanApp)
                checkListRecordInstance.creditScoringQuestionSection = secionInstance
                checkListRecordInstance.creditScoringQuestions = questionsUnderSectionInstance
                if(xxcodeAnswers[xjmcounter] == null || xxcodeAnswers[xjmcounter] == "" || xxcodeAnswers[xjmcounter] == "null"){
                    // 3 means the default answer is letter C = 0
                    xxcodeAnswers[xjmcounter] = "3"
                }
                checkListRecordInstance.creditScoringAnswers = CreditScoringAnswers.get(xxcodeAnswers[xjmcounter].toInteger())
                checkListRecordInstance.evaluatedBy =  UserMaster.get(session.user_id)
                checkListRecordInstance.dateEvaluated = UserMaster.get(session.user_id).branch.runDate
                checkListRecordInstance.save(flush:true,failOnError:true) 
                
                xjmcounter = xjmcounter + 1
            }
            
        }
        def hasRatedxxxx = crrCodeDescriptionInstance.hasRatedItem
        //        def hasRatedxxxx = scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem
        // pass parameter (hasRated,creditInvestigationInstance)
        updateTallyOfScores(hasRatedxxxx,creditInvestigationInstance)
        //=======================================================
        flash.message="Credit Scoring Check list Successfully Evaluated"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
        //====================================
    }
    @Transactional
    def updatesaveCreditScoringChecklist(){
        println("====== updatesaveCreditScoringChecklist ======")
        println("params: "+params)
        // ==== get all sections and questions
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        //use parent code to get scoring sections and questions
        def sectionListInstance = CreditScoringQuestionSection.createCriteria()
        def scoringSectionInstance = sectionListInstance.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        println("scoringSectionInstance: "+scoringSectionInstance)
        
        def recentRecordInstace = CreditScoringChecklistRecords.createCriteria()
        def recentxxxRecs = recentRecordInstace.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        println("recentxxxRecs: "+scoringSectionInstance)
        Integer xjmcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        for(xxjmRects in recentxxxRecs){
            println("xxjmRects: "+xxjmRects)
            // update records base on answers in the form

            if(xxcodeAnswers[xjmcounter] == null || xxcodeAnswers[xjmcounter] == "" || xxcodeAnswers[xjmcounter] == "null"){
                xxcodeAnswers[xjmcounter] = "3"
            }
            xxjmRects.creditScoringAnswers = CreditScoringAnswers.get(xxcodeAnswers[xjmcounter].toInteger())
            xxjmRects.lastUpdatedBy =  UserMaster.get(session.user_id)
            xxjmRects.lastUpdatedDate = UserMaster.get(session.user_id).branch.runDate
            xxjmRects.save(flush:true,failOnError:true) 
                
            xjmcounter = xjmcounter + 1
        }
        def hasRatedxxxx = crrCodeDescriptionInstance.hasRatedItem
        //        def hasRatedxxxx = scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem
        // pass parameter (hasRated,creditInvestigationInstance)
        updateTallyOfScores(hasRatedxxxx,creditInvestigationInstance)
        //=======================================================
        flash.message = "Evaluation for Credit Scoring Checklist Successfully Updated"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    @Transactional
    def saveRecommededCrr(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        def saveTallyofFormInstance = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
            
        saveTallyofFormInstance.recommendedCrrScore = params.recCrr ? params.recCrr.toDouble() : 0.00D
        saveTallyofFormInstance.recommendedCrrRating = CreditScoringMatrix.get(params.matrixId.toInteger())
        saveTallyofFormInstance.justification = params.justification
        saveTallyofFormInstance.save(flush: true,failOnError:true) 
     
        flash.message= "Recommended CRR Successfully Added"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    @Transactional
    def saveUpdateRecommededCrr(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.editcreditInvestigationId)
        def saveTallyofFormInstance = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
            
        saveTallyofFormInstance.recommendedCrrScore = params.editrecCrr ? params.editrecCrr.toDouble() : 0.00D
        saveTallyofFormInstance.recommendedCrrRating = CreditScoringMatrix.get(params.editmatrixId.toInteger())
        saveTallyofFormInstance.justification = params.justification
        saveTallyofFormInstance.save(flush: true,failOnError:true) 
        
        flash.message= "Recommended CRR Successfully Updated"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    def getRiskRatingAjax(){
        def json = request.JSON
  
        def sql = new Sql(dataSource)
        def TxnTypeInstance = "select * from credit_scoring_matrix where calculated_brr = '${json.calculatedbrr.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)
        
        println("return: "+resultqueryall)
        render resultqueryall as JSON 
    }
    @Transactional
    def addCompletenessRecord(){
        println("params: "+params)
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.CI)
        def saveTallyofFormInstance = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
        saveTallyofFormInstance.scoreCompletenessOfDocument = CreditScoringAnswers.get(params.completeNessRequired)
        saveTallyofFormInstance.save(flush: true,failOnError:true) 
        
        flash.message= "Compleness of required documents successfully evaluated.."
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    
    @Transactional
    def updateCompletenessRecord(){
        println("params: "+params)
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.editCI)
        def saveTallyofFormInstance = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
        saveTallyofFormInstance.scoreCompletenessOfDocument = CreditScoringAnswers.get(params.completeNessRequired)
        saveTallyofFormInstance.save(flush: true,failOnError:true) 
        
        flash.message= "Compleness of required documents successfully evaluated.."
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    def performRatedItems(){
        println("============ performRatedItems =============")
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }        
        def c = CreditScoringRated.createCriteria()
        def idRatedSectionList = c.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        
        def hasRatedxxxx = crrCodeDescriptionInstance.hasRatedItem
        //        def hasRatedxxxx = scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem
        // pass parameter (hasRated,creditInvestigationInstance)
        //updateTallyOfScores(hasRatedxxxx,creditInvestigationInstance)
        
        [scoringProductConfigInstance:scoringProductConfigInstance,creditInvestigationInstance:creditInvestigationInstance,idRatedSectionList:idRatedSectionList]
        
    }
    @Transactional
    def saveRatedScoringItems(){
        println("========== saveRatedScoringItems ============")

        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }   
        //use parent code to get scoring sections and questions
        def ratedSectionInstance = CreditScoringRated.createCriteria()
        def ratedInstance = ratedSectionInstance.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        println("ratedInstance: "+ratedInstance)
        
        // set parameters from form
        Integer xjmcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        
        // loop section to get questions under section
        for(secionInstance in ratedInstance){
            println("Section: "+secionInstance)
            //get all questions under section
            def ratedItemInstance = CreditScoringRatedItems.createCriteria()
            def itemInstance = ratedItemInstance.list {
                and {
                    eq("creditScoringRated", secionInstance)
                }
                order("id", "asc")
            }
            
            def remarksList = params.list('remarks')
           
          
            for(questionsUnderSectionInstance in itemInstance){
                println("ans from form: "+xxcodeAnswers[xjmcounter])
                println("questions: "+questionsUnderSectionInstance)
                def ratedItemsRecordInstance = new CreditScoringRatedItemsRecords()
                ratedItemsRecordInstance.loanApplication = LoanApplication.get(params.loanApp)
                ratedItemsRecordInstance.creditScoringRated = secionInstance
                ratedItemsRecordInstance.creditScoringRatedItems = questionsUnderSectionInstance
                if(xxcodeAnswers[xjmcounter] == null || xxcodeAnswers[xjmcounter] == "" || xxcodeAnswers[xjmcounter] == "null"){
                    // 5 means the default answer is letter C = 0
                    xxcodeAnswers[xjmcounter] = "5"
                }
                ratedItemsRecordInstance.creditScoringAnswers = CreditScoringAnswers.get(xxcodeAnswers[xjmcounter].toInteger())
                ratedItemsRecordInstance.evaluatedBy =  UserMaster.get(session.user_id)
                ratedItemsRecordInstance.dateEvaluated = UserMaster.get(session.user_id).branch.runDate
                ratedItemsRecordInstance.remarks = remarksList.get(xjmcounter)
                ratedItemsRecordInstance.save(flush:true,failOnError:true) 
                
                xjmcounter = xjmcounter + 1
            }
        }
        def hasRatedxxxx = crrCodeDescriptionInstance.hasRatedItem
        //        def hasRatedxxxx = scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem
        // pass parameter (hasRated,creditInvestigationInstance)
        updateTallyOfScores(hasRatedxxxx,creditInvestigationInstance)
        
        flash.message = "Rated Items Successfully Evaluated.."
        redirect(action: "show", controller: "loanApplication", id: creditInvestigationInstance.loanApplication.id)
            
    }
    def updatePerformedRated(){
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }   
        //use parent code to get scoring sections and questions
        def c = CreditScoringRated.createCriteria()
        def xxratedInstance = c.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
                
            }
            order("id", "asc")
        }
        
        
        println("ratedInstance: "+xxratedInstance)
       
        [xxratedInstance:xxratedInstance,creditInvestigationInstance:creditInvestigationInstance]
        
    }
    @Transactional
    def updateSaveRatedScoringItems(){
        println("============ updateSaveRatedScoringItems ==================")
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.creditInvestigationId)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }   
        //use parent code to get scoring sections and questions
        def ratedListInstance = CreditScoringRated.createCriteria()
        def scoringRatedInstance = ratedListInstance.list {
            and {
                eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                //                eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
            }
            order("id", "asc")
        }
        println("scoringRatedInstance: "+scoringRatedInstance)
        
        def recentRecordInstace = CreditScoringRatedItemsRecords.createCriteria()
        def recentxxxRecs = recentRecordInstace.list {
            and {
                eq("loanApplication", creditInvestigationInstance.loanApplication)
            }
            order("id", "asc")
        }
        
        Integer xjmcounter = 0
        def xxcodeAnswers = params.list('xcode')  
        def remarksList = params.list('remarks')
           
        for(xxjmRects in recentxxxRecs){
            println("xxjmRects: "+xxjmRects)
            // update records base on answers in the form

            if(xxcodeAnswers[xjmcounter] == null || xxcodeAnswers[xjmcounter] == "" || xxcodeAnswers[xjmcounter] == "null"){
                xxcodeAnswers[xjmcounter] = "5"
            }
            xxjmRects.creditScoringAnswers = CreditScoringAnswers.get(xxcodeAnswers[xjmcounter].toInteger())
            xxjmRects.lastUpdatedBy =  UserMaster.get(session.user_id)
            xxjmRects.lastUpdatedDate = UserMaster.get(session.user_id).branch.runDate
            xxjmRects.remarks = remarksList.get(xjmcounter)
             
            xxjmRects.save(flush:true,failOnError:true) 
                
            xjmcounter = xjmcounter + 1
        }
        def hasRatedxxxx = crrCodeDescriptionInstance.hasRatedItem
        //        def hasRatedxxxx = scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem
        // pass parameter (hasRated,creditInvestigationInstance)
        updateTallyOfScores(hasRatedxxxx,creditInvestigationInstance)
        
        
        flash.message="Rated Item Records Successfully Updated"
        redirect(action: "show", controller: "loanApplication", id: creditInvestigationInstance.loanApplication.id)
    }
    @Transactional
    def updateTallyOfScores(Boolean haasRated, CreditInvestigation creditInvestigationInstance){
               
        // compute total per section for tally of scores in form
        // query for tally of scores
        def sql = new Sql(dataSource)
        def tallyQuery = " select A.credit_scoring_question_section_id as id,C.name_of_section as name,sum(CAST (B.value AS DOUBLE PRECISION)) as sumofscores,count(D.id) as noofitems,C.section_percentage " +
                " from Credit_Scoring_Checklist_Records A " +
                " left outer join credit_scoring_answers B on A.credit_scoring_answers_id = B.id " +
                " left outer join credit_scoring_question_section C on A.credit_scoring_question_section_id = C.id " +
                " left outer join credit_scoring_questions D on D.id = A.credit_scoring_questions_id " +
                " where A.loan_application_id = "+ creditInvestigationInstance.loanApplication.id +
                " group by A.credit_scoring_question_section_id,C.name_of_section,C.section_percentage " +
                " order by A.credit_scoring_question_section_id "
        def resultqueryall = sql.rows(tallyQuery)
        
        
        
        def subtotal = 0
        def scoreRateTotal = 0
        def totalScoresInstance = [:]
         
        for(totalResult in resultqueryall){
            println("totalResult: "+totalResult)
            subtotal = subtotal + (totalResult?.sumofscores / totalResult?.noofitems)
            scoreRateTotal = scoreRateTotal + ((totalResult?.sumofscores / totalResult?.noofitems)*(totalResult?.section_percentage * 0.01))
            scoreRateTotal = scoreRateTotal.round(2)
        }
        
        def initialCRRrating = " select * from credit_scoring_matrix where "+scoreRateTotal+" BETWEEN range_from " +
            " AND range_to and range_from <> 0 and range_to <> 0 "
        def initailCrrResultSet = sql.rows(initialCRRrating)
        def initialCrrRarrrting = null;
        def initialCrrRatingId
            
        for(initialRecordList in  initailCrrResultSet){
            initialCrrRatingId = initialRecordList.id
            initialCrrRarrrting = initialRecordList.calculated_brr
        }
            
        
        def saveTallyofFormInstance = CreditScoringTallyOfScores.findByLoanApplication(creditInvestigationInstance.loanApplication)
        println("saveTallyofFormInstance: "+saveTallyofFormInstance)
        if(saveTallyofFormInstance){
            if(haasRated == true){
                // compute for rated Items

                def ratedTallyQuery = " select A.credit_scoring_rated_id as id,C.rated_name as name,sum(CAST (B.value AS DOUBLE PRECISION)) as sumofscores,count(D.id) as noofitems " +
                        " from credit_scoring_rated_items_records  A " +
                        " left outer join credit_scoring_answers B on A.credit_scoring_answers_id = B.id " +
                        " left outer join credit_scoring_rated C on A.credit_scoring_rated_id = C.id " +
                        " left outer join credit_scoring_rated_items D on D.id = A.credit_scoring_rated_items_id " +
                        " where A.loan_application_id = "+ creditInvestigationInstance.loanApplication.id +
                        " group by A.credit_scoring_rated_id,C.rated_name " +
                        " order by A.credit_scoring_rated_id desc "

                def xresultRatedquery = sql.rows(ratedTallyQuery)

                if(xresultRatedquery){
                    println("ratedXinstanceResult0: "+xresultRatedquery[0].sumofscores)
                    println("ratedXinstanceResult1: "+xresultRatedquery[1].sumofscores)
                    println("ratedXinstanceResult2: "+xresultRatedquery[2].sumofscores)
                    println("ratedXinstanceResult3: "+xresultRatedquery[3].sumofscores)
                    println("ratedXinstanceResult4: "+xresultRatedquery[4].sumofscores)
                    saveTallyofFormInstance.rated10 = xresultRatedquery[0].sumofscores ? xresultRatedquery[0].sumofscores.toDouble() : 0.00D
                    saveTallyofFormInstance.rated9 = xresultRatedquery[1].sumofscores ? xresultRatedquery[1].sumofscores.toDouble() : 0.00D
                    saveTallyofFormInstance.rated8 = xresultRatedquery[2].sumofscores ? xresultRatedquery[2].sumofscores.toDouble() : 0.00D
                    saveTallyofFormInstance.rated7 = xresultRatedquery[3].sumofscores ? xresultRatedquery[3].sumofscores.toDouble() : 0.00D
                    saveTallyofFormInstance.rated6 = xresultRatedquery[4].sumofscores ? xresultRatedquery[4].sumofscores.toDouble() : 0.00D
                }
            }
       
            saveTallyofFormInstance.totalScore = scoreRateTotal ? scoreRateTotal.toDouble() : 0.00D
            saveTallyofFormInstance.initialCrr = initialCrrRarrrting
            saveTallyofFormInstance.calculatedCrr = initialCrrRarrrting
            saveTallyofFormInstance.creditScoringrating = CreditScoringMatrix.get(initialCrrRatingId.toInteger())
            saveTallyofFormInstance.save(flush: true,failOnError:true) 
            
        }else{
            def xsaveTallyofFormInstance = new CreditScoringTallyOfScores()
            xsaveTallyofFormInstance.loanApplication = creditInvestigationInstance.loanApplication
            xsaveTallyofFormInstance.totalScore = scoreRateTotal ? scoreRateTotal.toDouble() : 0.00D
            xsaveTallyofFormInstance.initialCrr = initialCrrRarrrting
            if(initialCrrRatingId){
                xsaveTallyofFormInstance.creditScoringrating = CreditScoringMatrix.get(initialCrrRatingId.toInteger())
            }
            xsaveTallyofFormInstance.save(flush: true,failOnError:true) 
            return
        }
               
        // ======== Calculated Crr 
        def calllculatedCRRvalue = 0.00D
        if(saveTallyofFormInstance?.rated10 > 0){
                
            calllculatedCRRvalue = 10
        }else if(saveTallyofFormInstance?.rated9 > 0){
                
            calllculatedCRRvalue = 9
        }else if(saveTallyofFormInstance?.rated8 > 0){
                
            calllculatedCRRvalue = 8
        }else if(saveTallyofFormInstance?.rated7 > 0){
                
            calllculatedCRRvalue = 7
        }else if(saveTallyofFormInstance?.rated6 > 0){
                
            calllculatedCRRvalue = 6
        }else{
                
            if(saveTallyofFormInstance?.rated10 == 0 && saveTallyofFormInstance?.rated9 == 0 && saveTallyofFormInstance?.rated8 == 0 && saveTallyofFormInstance?.rated7 == 0 && saveTallyofFormInstance?.rated6 == 0){
                calllculatedCRRvalue = saveTallyofFormInstance.initialCrr ? saveTallyofFormInstance.initialCrr : 0.00D
            }
                
        }
        println("calllculatedCRRvalue: "+calllculatedCRRvalue)
        if(calllculatedCRRvalue > 0){
            saveTallyofFormInstance.calculatedCrr = calllculatedCRRvalue
        }
            
        saveTallyofFormInstance.save(flush: true,failOnError:true) 
        return     
    }
    def updateCredScorLoanAppDet(){
        println("=========== updateCredScorLoanAppDet =============")
        println("params: "+params)
        println("params: "+params)
        def creditInvestigationInstance = CreditInvestigation.get(params.id)
        println("creditInvestigationInstance: "+creditInvestigationInstance)
        println("Product: "+creditInvestigationInstance.loanApplication.product)
        
        //find scoring parent product group code base on product
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(creditInvestigationInstance.loanApplication.product)
        def crrCodeDescriptionInstance
        if(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome){
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(creditInvestigationInstance.loanApplication.customer.typeOfSourceIncome.itemValue)
        } else {
            crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
        scoringProductConfigInstance = crrCodeDescriptionInstance
        println("scoringProductConfigInstance: "+scoringProductConfigInstance)
        
        def loanApplicationCredScorDetails = CreditScoringLoanAppDetails.findByLoanApplication(creditInvestigationInstance.loanApplication)
        [loanApplicationCredScorDetails:loanApplicationCredScorDetails,creditInvestigationInstance:creditInvestigationInstance,scoringProductConfigInstance:scoringProductConfigInstance]
    }
    @Transactional
    def xSaveUpdateDetailsLoanAppDetCredScor(){
        println("====== saveupdateDetailsLoanAppDetCredScor ==============")
       
        
        def creditInvestigationInstance = CreditInvestigation.get(params.credInvestigationId)
        def isHasRrated = Boolean.valueOf(params?.confihasRated)
        def loanApplicationInstance = CreditScoringLoanAppDetails.findByLoanApplication(creditInvestigationInstance.loanApplication)
        if(isHasRrated == true){
            println("========== WITH RATED =========")
            println("params: "+params)
            loanApplicationInstance.nameOfBusiness = params.nameOfBusiness ?  params.nameOfBusiness.toString() : ''
            loanApplicationInstance.previousCrrRating = params.previousRating ?  params.previousRating.toString() : ''
            loanApplicationInstance.previousRatingDate = params.previousDate? new Date().parse("MM/dd/yyyy", params.previousDate) : null
            loanApplicationInstance.basicReasonForCrr = params.basicReason ?  params.basicReason.toString() : ''
            loanApplicationInstance.typeOfCollateral = LoanCollateralType.get(params.collateralType.id)
            loanApplicationInstance.facilityTypes = params.facilityType ?  params.facilityType.toString() : ''
            loanApplicationInstance.commitmentAmount = params.commitmentAmount ?  (params.commitmentAmount.toString().replaceAll(",","")).toDouble() : 0.00D
            loanApplicationInstance.originatingUnit = params.originatingUnit ?  params.originatingUnit.toString() : ''
            loanApplicationInstance.contactNumber = params.contactNumber ?  params.contactNumber.toString() : ''
            loanApplicationInstance.industrySubsector = params.industrySubsector ?  params.industrySubsector.toString() : ''
            loanApplicationInstance.industryCode = params.industryCode ?  params.industryCode.toString() : ''
            loanApplicationInstance.dateOfCurrentRating = params.currentRatingDate? new Date().parse("MM/dd/yyyy", params.currentRatingDate) : null
            loanApplicationInstance.rater = params.raterName ?  params.raterName.toString() : ''
            loanApplicationInstance.appraisalValueRem = params.appraisalValueRem ?  (params.appraisalValueRem.toString().replaceAll(",","")).toDouble() : 0.00D
            loanApplicationInstance.avOtherCollateral = params.otherCollateral ?  params.otherCollateral.toString() : ''
            loanApplicationInstance.expiryDateOfLoan = params.expiryDate? new Date().parse("MM/dd/yyyy", params.expiryDate) : null
            loanApplicationInstance.totalOsBalance = params.totalOsBalance ?  (params.totalOsBalance.toString().replaceAll(",","")).toDouble() : 0.00D
        }else{
            println("params: "+params)
            println("============= WITHOUT RATED ============")
            loanApplicationInstance.employer = params.employeer ?  params.employeer.toString() : ''
            loanApplicationInstance.designationRank = params.designationRank ?  params.designationRank.toString() : ''
            loanApplicationInstance.typeOfCollateral = LoanCollateralType.get(params.collateralType.id)
            loanApplicationInstance.avOfCollateral = params.avCollateral ?  params.avCollateral.toString() : ''
            loanApplicationInstance.otherCollateral = params.xotherCollateral ?  params.xotherCollateral.toString() : ''
            loanApplicationInstance.avOtherCollateral = params.otherCollateral ?  params.otherCollateral.toString() : ''
            loanApplicationInstance.loanType = params.loanType ?  params.loanType.toString() : ''
            loanApplicationInstance.commitmentAmount = params.commitmentAmount ?  (params.commitmentAmount.toString().replaceAll(",","")).toDouble() : 0.00D
            loanApplicationInstance.originatingUnit = params.originatingUnit ?  params.originatingUnit.toString() : ''
            loanApplicationInstance.contactNumber = params.contactNumber ?  params.contactNumber.toString() : ''
            loanApplicationInstance.previousCrrRating = params.previousRating ?  params.previousRating.toString() : ''
            loanApplicationInstance.previousRatingDate = params.previousDate? new Date().parse("MM/dd/yyyy", params.previousDate) : null
            loanApplicationInstance.currentRating = params.currentRating ?  params.currentRating.toString() : ''
            loanApplicationInstance.dateOfCurrentRating = params.currentRatingDate? new Date().parse("MM/dd/yyyy", params.currentRatingDate) : null
            loanApplicationInstance.rater = params.raterName ?  params.raterName.toString() : ''
            loanApplicationInstance.reasonsOfRating = params.reasonForRating ?  (params.reasonForRating.toString().replaceAll(",","")).toDouble() : 0.00D
            loanApplicationInstance.expiryDateOfLoan = params.expiryDate? new Date().parse("MM/dd/yyyy", params.expiryDate) : null
            loanApplicationInstance.totalOsBalance = params.totalOsBalance ?  (params.totalOsBalance.toString().replaceAll(",","")).toDouble() : 0.00D
        }
        loanApplicationInstance.lastUpdatedby = UserMaster.get(session.user_id)
        loanApplicationInstance.lastUpdatedDate = UserMaster.get(session.user_id).branch.runDate
        loanApplicationInstance.save(flush: true)
        
        flash.message = "Credit Scoring Loan Application Details Successfully Updated"
        redirect(action: "show",controller: "loanApplication",id: creditInvestigationInstance.loanApplication.id)
    }
    

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'creditInvestigation.label', default: 'CreditInvestigation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
    