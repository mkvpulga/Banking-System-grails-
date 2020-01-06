package icbs.loans


import grails.converters.JSON
import grails.converters.deep.JSON
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.codehaus.groovy.grails.web.json.JSONObject
import org.hibernate.Session
import org.hibernate.SessionFactory
import icbs.lov.AttachmentType
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.lov.LoanApplicationStatus
import icbs.lov.LoanFinancialInfoType
import icbs.lov.LoanCollateralType
import icbs.lov.LoanCollateralStatus
import icbs.lov.ConfigItemStatus
import icbs.cif.Customer
import icbs.cif.CustomerRelationship
import icbs.cif.Address
import icbs.admin.UserMaster
import icbs.admin.Role
import icbs.admin.UserRole
import icbs.admin.Branch
import icbs.lov.Lov
import icbs.lov.LoanSecurity
import icbs.lov.LoanFinancialInfoType
import icbs.loans.GroupRecord
import icbs.loans.FinancialDetail
import icbs.loans.LoanApplicationAttachment
import icbs.lov.LoanApplicationStatus
import icbs.loans.LoanApplicationSpecAdditional
import icbs.loans.LoanApplicationChecklist
import groovy.sql.Sql
import icbs.loans.Loan
import java.text.DecimalFormat;
import icbs.loans.CreditInvestigationBRRHistory
import icbs.lov.CreditInvestigationChecklistType

@Transactional(readOnly = true)
class LoanApplicationController {
    def auditLogService
    def dataSource
    static allowedMethods = [save: "POST", 
        update: ["PUT","POST"], 
        updateSpecification: ["PUT","POST"], 
        updateCollateral: ["PUT","POST"],
        updateFinancialDetails: ["PUT","POST"], 
        updateComakers: ["PUT","POST"], 
        delete: "DELETE"]

    def index(Integer max) {
        def user = UserMaster.get(session.user_id)
        // params.max = Math.min(max ?: 10, 100)   // no. of items on display
        params.max = Math.min(max ?: 25, 100)
        
        if (params.sort == null) {  // default ordering
            // params.sort = "id"
            params.sort  = "dateApproved" 
            params.order =  "desc"
            println("san ba pumasok")
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            def result = LoanApplication.createCriteria().list(params) {
                and{
                    ne("approvalStatus",LoanApplicationStatus.get(8))
                }
                order("approvalStatus", "asc")
            }
            println result.totalCount
            respond result, model:[params:params, LoanApplicationInstanceCount: result.totalCount]
            //  respond LoanApplication.list(params), model:[params:params, LoanApplicationInstanceCount: LoanApplication.count()]
            println("pumasok ba dito")
        } else {    // show query results
            def result = LoanApplication.createCriteria().list(params) {
                println("dito pumasok")
                or{
                    'customer'{
                        or{
                            ilike("displayName","%${params.query.trim()}%")
                        }
                    }
                    if(params.query.trim().isLong()){
                        idEq(params.query.trim().toLong())
                    }
                }
                and{
                    ne("approvalStatus",LoanApplicationStatus.get(8))
                }
                order("approvalStatus", "asc")
            }
            println result.totalCount
           
            respond result, model:[user:user, params:params, LoanApplicationInstanceCount: result.totalCount]
        }
        return
    } 

    def search(Integer max) {
        // params.max = Math.min(max ?: 10, 100) 
        params.max = Math.min(max ?: 25, 100)
  
        if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            render(template:"search/searchLoanApplication", model:[params:params, domainInstanceList:LoanApplication.list(params), domainInstanceCount:LoanApplication.count()]) as JSON
        } else {    // show query results
            def result = LoanApplication.createCriteria().list(params) {
                or{
                    'customer'{
                        or{
                            ilike("displayName","%${params.query.trim()}%")
                        }
                    }
                    if(params.query.trim().isLong()){
                        idEq(params.query.trim().toLong())
                    }
                }
                and{
                    ne("approvalStatus",LoanApplicationStatus.get(8))
                }
            }
            render(template:"search/searchLoanApplication", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
        }            
        return
    }
    
    //ready for filtering loan application withoucolt pendign status
    def searchLoan(Integer max) {
        // params.max = Math.min(max ?: 10, 100) 
        params.max = Math.min(max ?: 25, 100)
  
        if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            render(template:"search/searchLoanApplication", model:[params:params, domainInstanceList:LoanApplication.list(params), domainInstanceCount:LoanApplication.count()]) as JSON
        } else {    // show query results
            def result = LoanApplication.createCriteria().list(params) {
                or{
                    'customer'{
                        or{
                            ilike("displayName","%${params.query.trim()}%")
                        }
                    }
                    if(params.query.trim().isLong()){
                        idEq(params.query.trim().toLong())
                    }
                }
            }
            render(template:"search/searchLoanApplication", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
        }            
        return
    }
    
    def showAttachmentsAjax() {
        render(template:"attachments/list") as JSON
        return
    }    
    
    def addAttachmentAjax() {  
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanApplicationAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanApplicationAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanApplicationAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def attachments
        if (session["loanApplicationAttchmt"]) {
            attachments = session["loanApplicationAttchmt"]
        } else {
            attachments = []
        }        
        attachments.add(attachment)
        session["loanApplicationAttchmt"] = attachments        

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }
    
    def updateAttachmentAjax() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachments = session["loanApplicationAttchmt"]        
        def attachment = attachments[id]

        attachment.description = description
        attachment.type = AttachmentType.get(type)

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }
    
    def deleteAttachmentAjax() {
        def id = params?.id?.toInteger()
        session["loanApplicationAttchmt"].remove(id)

        render "success"
        return
    }
    
    def showUpdateAttachmentAjax() {   
        def id = params?.id?.toInteger()
        
        def attachments = session["loanApplicationAttchmt"]        
        def attachment = attachments[id]

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    }
    
    def showAddAttachmentAjax() {    
        render(template:"attachments/form") as JSON
        return
    }
    
    def showAttachmentsAjax2() {
        def id  = params?.id
        def loanApplicationInstance = LoanApplication.get(id)

        render(template:"attachments/list", model:[loanApplicationInstance:loanApplicationInstance]) as JSON
        return
    }
    
    @Transactional
    def addAttachmentAjax2() { 
        def id  = params?.id 
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanApplicationAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanApplicationAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanApplicationAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def loanApplicationInstance = LoanApplication.get(id)
        loanApplicationInstance.addToAttachments(attachment)
        loanApplicationInstance.save flush:true       

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }
    
    @Transactional
    def updateAttachmentAjax2() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachment = LoanApplicationAttachment.get(id)
        attachment.description = description
        attachment.type = AttachmentType.get(type)
        attachment.save flush:true

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }
    
    def showUpdateAttachmentAjax2() {
        def id = params?.id?.toInteger()
        
        def attachment = LoanApplicationAttachment.get(id)

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    } 
    
    @Transactional
    def deleteAttachmentAjax2() {
        def id = params?.id?.toInteger()
        def attachmentId = params?.attachmentId?.toInteger()
        println(id)
        println(attachmentId)
        def loanApplicationInstance = LoanApplication.get(id)
        def attachment = LoanApplicationAttachment.get(attachmentId)

        loanApplicationInstance.removeFromAttachments(attachment)
        loanApplicationInstance.save flush:true

        render "success"
        return
    }
    
    @Transactional
    def show(LoanApplication loanApplicationInstance) {
        def creditScoringProductConfigInstance = CreditScoringProductConfig.findByProduct(loanApplicationInstance.product)
        //        if(!creditScoringProductConfigInstance) {
        //            println("walang laman")
        //            flash.message = "Cannot Proceed. Please Configure Product of Loan Application under Configuration -> Credit Scoring Maintenance"
        //            redirect (action:'index')
        //            return
        //        }
        println("creditScoringProductConfigInstance: " + creditScoringProductConfigInstance?.id)
        def crrCodeDescriptionInstance
        if(loanApplicationInstance.customer.typeOfSourceIncome){
             crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription(loanApplicationInstance.customer.typeOfSourceIncome.itemValue)
        } else {
             crrCodeDescriptionInstance = CreditScoringCodeDescription.findByDescription("Personal")
        }
           
        creditScoringProductConfigInstance = crrCodeDescriptionInstance
        def user = UserMaster.get(session.user_id)
        def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
        println("loan application id: "+loanApplicationInstance?.id)
        def validateExistingLoanApplicationIdtoLoan = Loan.findByLoanApplication(loanApplicationInstance)
        println("result: "+validateExistingLoanApplicationIdtoLoan)
        def isLoanApplicationExist = ""
        if(validateExistingLoanApplicationIdtoLoan){
            isLoanApplicationExist = "true"
        }else{
            isLoanApplicationExist = "false"
        }
        
        def lastId
        def creditInvestigationInstance = CreditInvestigation.findByLoanApplication(loanApplicationInstance)
        println(creditInvestigationInstance)
        if(creditInvestigationInstance){
            def c = CreditInvestigationBRRHistory.createCriteria()
            lastId = c.list {

                eq("creditInvestigation", creditInvestigationInstance)

                maxResults(1)
                order("id", "desc")
            }
        }
        
        
        def loanApplicationSpecAdd = LoanApplicationSpecAdditional.findByLoanApplication(loanApplicationInstance)
        
        //        def c1 = LoanApplicationAttachment.createCriteria()
        //        def resultsAttachment = c1.list {
        //            eq("loanApplication",loanApplicationInstance)
        //            order("id", "desc")
        //        }
        //        println("resultsAttachment: "+resultsAttachment)
        
        //CREDIT SCORING
        println("params: "+params)
       
        
        def sqlxxx = new Sql(dataSource)
        def creditScoringLoanDetailsInstance
        println(loanApplicationInstance)
        def loanApplicationCreditDetails = CreditScoringLoanAppDetails.findByLoanApplication(loanApplicationInstance)
     
        if(loanApplicationCreditDetails){
            // do noting
            creditScoringLoanDetailsInstance = loanApplicationCreditDetails
        }else{
            // insert to table
            def loaanTotalOutStandingBalance = " select round(sum(balance_amount),2) as total_out_standing_bal  from loan A " +
            " left outer join customer B on B.id = A.customer_id " +
            " where A.customer_id = "+ loanApplicationInstance.customer.id
            def lonTotOs = sqlxxx.rows(loaanTotalOutStandingBalance)


            def credScorloanAppInstance = new CreditScoringLoanAppDetails()
            credScorloanAppInstance.loanApplication = loanApplicationInstance
            credScorloanAppInstance.createdBy =  UserMaster.get(session.user_id)
            credScorloanAppInstance.dateCreated = UserMaster.get(session.user_id).branch.runDate
            credScorloanAppInstance.totalOsBalance = lonTotOs[0].total_out_standing_bal ? lonTotOs[0].total_out_standing_bal.toDouble() : 0.00D
            credScorloanAppInstance.save(flush:true,failOnError:true)
                
            creditScoringLoanDetailsInstance = credScorloanAppInstance
        }
        println("creditScoringLoanDetailsInstance: "+creditScoringLoanDetailsInstance)
       
        //==================================================================================
        println(loanApplicationInstance.product)
        def scoringProductConfigInstance = CreditScoringProductConfig.findByProduct(loanApplicationInstance.product)
        
        //===== for records with value
        def c = CreditScoringPreQualificationRecords.createCriteria()
        def preQualificationInstance = c.list {
            and {
                eq("loanApplication", loanApplicationInstance)
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
        def idCreditPreq
        if(creditScoringProductConfigInstance) {
            idCreditPreq = d.list {
                and {
//                    eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
                    eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
                }
                order("id", "asc")
            }
        }
        //====
 
        
        //=========== get Credit Scoring check List instances
        Boolean isCheckListAlreadyDone = false
        def checkListResultInstance = CreditScoringChecklistRecords.createCriteria()
        def creditScoringResultInstance = checkListResultInstance.list {
            and {
                eq("loanApplication", loanApplicationInstance)
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
        def xxscoringSectionInstance
        if(creditScoringProductConfigInstance) {
            xxscoringSectionInstance = sssectionsInstance.list {
                and {
                    eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
//                    eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
                }
                order("id", "asc")
            }
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
            " where A.loan_application_id = "+ loanApplicationInstance.id +
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
        def xratedInstance
        def theRatedInstances
        def xxRecordInstanceItems
        def xxxitemsssss
        if(creditScoringProductConfigInstance) {
            if(crrCodeDescriptionInstance.hasRatedItem == true){
//            if(scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem == true){
                xratedInstance = CreditScoringRated.createCriteria()
                theRatedInstances = xratedInstance.list {
                    and {
                        eq("creditScoringCodeDescription", crrCodeDescriptionInstance)
//                        eq("creditScoringCodeDescription", scoringProductConfigInstance.creditScoringCodeDescription)
                    }
                    order("id", "asc")
                }
                xxRecordInstanceItems = CreditScoringRatedItemsRecords.createCriteria()
                xxxitemsssss = xxRecordInstanceItems.list {
                    and {
                        eq("loanApplication", loanApplicationInstance)
                    }
                    order("id", "asc")
                }
            
                if(xxxitemsssss){
                    isRatedAlreadyEvaluated = true
                }
                ratedInstanceListingRecords = theRatedInstances
            
            }
        }
        def initialCrrRatingScores = CreditScoringTallyOfScores.findByLoanApplication(loanApplicationInstance)
        println("initialCrrRatingScores: "+initialCrrRatingScores)
        
        Boolean isRecommendationEmpty = false
        def finalCrrValueAfterDocu = 0
        def calllculatedCRRvalue = 0.00D
        def initialCccccrr = 0
        
        if(initialCrrRatingScores){
            //println("scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem: "+scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem)
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
            if(creditScoringProductConfigInstance) {
                if(crrCodeDescriptionInstance.hasRatedItem == true){
//                if(scoringProductConfigInstance.creditScoringCodeDescription.hasRatedItem == true){
                    xGivenValue = appraisalValueeee
                }else{
                    xGivenValue = reasonForRating
                }
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
        
        def loanApplicationChecklist = LoanApplicationChecklist.findByLoanApplication(loanApplicationInstance)
        println(loanApplicationChecklist)
        
        def role = UserRole.findAllByUserMasterAndRole(UserMaster.get(session.user_id),Role.get(11))
        creditScoringProductConfigInstance = crrCodeDescriptionInstance
        respond loanApplicationInstance, model: [role:role, loanApplicationChecklist:loanApplicationChecklist, creditScoringProductConfigInstance:creditScoringProductConfigInstance, user:user, comakers: comakers, loanApplicationSpecAdd: loanApplicationSpecAdd, isLoanApplicationExist: isLoanApplicationExist,validateExistingLoanApplicationIdtoLoan:validateExistingLoanApplicationIdtoLoan,
            lastId:lastId,creditInvestigationInstance:creditInvestigationInstance, creditScoringLoanDetailsInstance:creditScoringLoanDetailsInstance,daCalculatedCrrDetails:daCalculatedCrrDetails ,
            isRatedAlreadyEvaluated:isRatedAlreadyEvaluated,ratedInstanceListingRecords:ratedInstanceListingRecords,scoringProductConfigInstance:scoringProductConfigInstance ,
            finalResultsss:finalResultsss,isRecommendationEmpty:isRecommendationEmpty ,
            isCheckListAlreadyDone:isCheckListAlreadyDone,initialCrrRatingScores:initialCrrRatingScores,preQualificationInstance:preQualificationInstance ,
            idCreditPreq:idCreditPreq,isQualifiedForCheckList:isQualifiedForCheckList ,
            creditScoringResultInstance:creditScoringResultInstance,xxscoringSectionInstance:xxscoringSectionInstance ,
            resultqueryall:resultqueryall,totalScoresInstance:totalScoresInstance]     
        
    }
    
    @Transactional
    def addAttachment(){
        
        def filename
        println("hahhaa")
        def filedata
        def description
        def dloanApplication
        def attachedBy
        def branch
        def status
      
        println("params: "+params)
        println("params file: "+params.file)
        def uploadDate = Branch.get(1).runDate
        def branchid = UserMaster.get(session.user_id).branch
        def userid =  UserMaster.get(session.user_id)
        println("params branch:"+branchid)
        println("params user id: "+userid)
        def attchhmnt
        def file = request.getFile('file')
        if(file.isEmpty()) {
            flash.message = "File cannot be empty"
            println("if condition")
        } else {
            def dfilename = file.originalFilename
            println("pasok")
            attchhmnt = new LoanApplicationAttachment(loanApplication:dloanApplication,uploadDate: uploadDate, filename:dfilename,filedata:file.getBytes(),description: params.description,attachedBy:userid,branch:branchid,status:ConfigItemStatus.get(2))
            
        }
        def attchmnts
            
        if (session["loanApplicationAttchmt"]) {
            attchmnts = session["loanApplicationAttchmt"]
        } else {
            attchmnts = []
        }        
        attchmnts.add(attchhmnt)
        session["loanApplicationAttchmt"] = attchmnts
        session["attachmentcondtion"] = "upload"
        println("size of the session array: "+session["loanApplicationAttchmt"].size())
        println("rendering...")
        def attachmentInstance = session["loanApplicationAttchmt"]
        render(template:"loanApplicationAttachment/attachmentForm") as JSON
      
    }
    def removeAttachment(){
        
        def Attachmentsessionid = params.id
        def id = params?.id?.toInteger()
        session["loanApplicationAttchmt"].remove(id)
        render(template:"loanApplicationAttachment/attachmentForm") as JSON
    }
    
    def downloadAttachment(){
        def id = params?.id
        def attachment = LoanApplicationAttachment.get(id)

        if (attachment) {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }
    
    def showAttachment() {
        def id = params?.id
        def attachment = LoanApplicationAttachment.get(id)

        if (attachment) {
            response.setHeader("Content-Disposition", "inline;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }
    
    def showPicture(){
        println("giiiiiiiiiiii")
        println("exxxxxxxx : "+ params)
        println("params jmpogi : "+params.id)
        //  println("exxxxxxxx : "+ xxAttachId)
        def studentInstance = LoanApplicationAttachment.get(params.id)
        println("ggggieetest : "+ LoanApplicationAttachment.get(params.id))
        println("show picture: "+studentInstance)
        response.setHeader("Content-Disposition", "inline;Filename=\"${studentInstance.filename}\"")
        //        response.setContentType(studentInstance.fileType)//set content type
        response.outputStream << studentInstance.filedata // write the image to the outputstream
        response.outputStream.flush()
        response.outputStream.close()
    }
    
    def create() {
        // initialize session variables
        def user = UserMaster.get(session.user_id)
        session["financialDetails"] = []
        session["comakers"] = []
        session["collaterals"] = []
        session["loanApplicationAttchmt"] = []
        def loanApplicationChecklist = null
        
        def customer = null
        if (params?.cid) {
            customer = Customer.get(params?.cid)
            
        }
        def role = UserRole.findAllByUserMasterAndRole(UserMaster.get(session.user_id),Role.get(11))
        def parsing = Date.parse('yyyy-MM-dd',UserMaster.get(session.user_id).branch.runDate.toString())
        def sql = new Sql(dataSource)
        def camID = "select id from loan_application_spec_additional order by id desc"         
        def resultqueryall = sql.firstRow(camID)
        def resultString = resultqueryall.toString()
        def getBefore
        println("resultqueryall: " + resultqueryall)
        println("resultString: " + resultString)
        if(resultqueryall){
           
            println("sa if")
            def getAfter = resultString.substring(resultString.lastIndexOf("=") + 1)               
            def iend = getAfter.indexOf("}")             
            getBefore = getAfter.substring(0 , iend)
            println("getbefore: " + getBefore)
        } else{
             
            println("sa else")
            getBefore = "0"
        }
        def forSub = parsing.format('yyyy-MM-dd')
        //getBefore.toString()
        def camNo = forSub.substring(0, 8) +  (Integer.parseInt(getBefore) + 1)
        println(camNo)
        
        respond new LoanApplication(params), model:[camNo:camNo, role:role, loanApplicationChecklist:loanApplicationChecklist, user:user, customer:customer]
        
        
               
    }

    @Transactional
    def save(LoanApplication loanApplicationInstance) {
        def user = UserMaster.get(session.user_id)
        
        //        if (loanApplicationInstance.customer == null) {
        //            customerInfo()
        //            return
        //        }
        //         println params
      
        //        if (pending.id != 2)
        //        {
        //            statusPending()
        //            return
        //        }
        loanApplicationInstance.branch = UserMaster.get(session.user_id).branch
        if (loanApplicationInstance.applicationDate == null)
        {  
            loanApplicationInstance.applicationDate = Branch.get(1).runDate
        } 
        println "loan customer " + loanApplicationInstance.customer
        if (loanApplicationInstance.customer == null)
        { 
            flash.message = 'Customer ID Cannot be null !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        }
        def pending = Customer.get(params.customer.id).status
        if (pending.id != 2)
        { 
            flash.message = 'Update Customer Status First !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        }
        
        if (loanApplicationInstance.amount == null)
        { 
            flash.message = 'Loan Amount Cannot be null !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        } 
        if (loanApplicationInstance.amount < 0)
        { 
            flash.message = 'Amount Cannot be negative !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        } 
        if (loanApplicationInstance.term == null)
        { 
            flash.message = 'Term Cannot be null !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        } 
        if (loanApplicationInstance.purpose == null)
        { 
            flash.message = 'Purpose Cannot be null !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        } 
         
        if (loanApplicationInstance.accountOfficer == null)
        { 
            flash.message = 'Account Officer Cannot be null !.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return
        } 
        // check minimum term
        if (loanApplicationInstance.term < loanApplicationInstance.product.minTerm) {
            flash.message = loanApplicationInstance.product.name + ': Loan term cannot be less than allowed product minimum term!.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return            
        }
        // check maximum term
        if (loanApplicationInstance.term > loanApplicationInstance.product.maxTerm) {
            flash.message = loanApplicationInstance.product.name + ': Loan term cannot be greater than allowed product maximum term!.|error|alert'
            render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
            return            
        }  	 
        if (session["comakers"]) {
            Boolean same = false 
            for(comaker in session["comakers"]) {
                println comaker
                println params.customer
                if (params.customer == comaker) {
                    same = true
                    println 'same comaker'
                }
            }
            if (same) {
                flash.message = 'Customer cannot be co-maker!.|error|alert'
                render(view: '/loanApplication/create', model: [user:user, loanApplicationInstance:loanApplicationInstance])
                return               
            }
        }     
        println '>>> ' + loanApplicationInstance.branch
        if (loanApplicationInstance.hasErrors()) {
            println loanApplicationInstance.errors
            flash.message = loanApplicationInstance.errors
            respond loanApplicationInstance.errors, model: [user:user], view:'create'
            return
        } 
        
        for(financialDetail in session["financialDetails"]) {
            loanApplicationInstance.addToFinancialDetails(financialDetail)
        }
        session["financialDetails"] = null

        for(collateral in session["collaterals"]) {
            if (!collateral.isAttached())
            collateral.attach()
            loanApplicationInstance.addToCollaterals(collateral)
        }
        session["collaterals"] = null
       

    
        println 'customer name'
        println('=====================================')
        println("loan account officer: "+loanApplicationInstance.accountOfficer.toString())
        println('=====================================')
        
        for(attachment in session["loanApplicationAttchmt"]) {
            loanApplicationInstance.addToAttachments(attachment)
        }
        session["loanApplicationAttchmt"] = null
        
        loanApplicationInstance.save flush:true  
        
        for(comaker in session["comakers"]) {
            def comakerLink = new LoanApplicationComaker(loanApplication: loanApplicationInstance, customer: comaker)
            comakerLink.save flush:true            
        }
        session["comakers"] = null
        def description = 'Loan Application ' +  loanApplicationInstance.id + ' was created by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', description, 'Loan', null, null, null, loanApplicationInstance.id)
        def cust = Customer.get(loanApplicationInstance.customer.id)
        //========== SAVE INFORMATION TO LoanApplicationSpecAdditional==================
        /* if((user.id == 16 && cust.id == 6605) || (user.designation.id == 30 && cust.id != 6605)){
        println("PUTANGINANG BUHAY")
        def loanAppSpecAddInstance = LoanApplicationSpecAdditional.findByLoanApplication(loanApplicationInstance)
        if (!loanAppSpecAddInstance){
        loanAppSpecAddInstance = new LoanApplicationSpecAdditional()
        loanAppSpecAddInstance.loanApplication = LoanApplication.get(loanApplicationInstance.id)
        }
        loanAppSpecAddInstance.camNo = params.camNo
        loanAppSpecAddInstance.company = params.company
        loanAppSpecAddInstance.loanSecurity = LoanSecurity.get(params.loanSecurity.id)
        loanAppSpecAddInstance.loanClassification = params.loanClassification
        loanAppSpecAddInstance.loanProduct = params.loanProduct
        loanAppSpecAddInstance.economicActivity = params.economicActivity
        if(params.interestRate){
        loanAppSpecAddInstance.interestRate = params.interestRate.toDouble()
        }
        
        loanAppSpecAddInstance.mannerOfPayment = params.mannerOfPayment
        loanAppSpecAddInstance.repaymentType = params.repaymentType
        loanAppSpecAddInstance.condition1 = params.condition1
        loanAppSpecAddInstance.condition2 = params.condition2
        loanAppSpecAddInstance.condition3 = params.condition3
        loanAppSpecAddInstance.condition4 = params.condition4
        loanAppSpecAddInstance.condition5 = params.condition5
        loanAppSpecAddInstance.condition6 = params.condition6
        loanAppSpecAddInstance.condition7 = params.condition7
        if (params.amortizationPenaltyRate){
        loanAppSpecAddInstance.amortizationPenaltyRate = params.amortizationPenaltyRate.toDouble()
        }
        if (params.preTerminationChargeRate){
        loanAppSpecAddInstance.preTerminationChargeRate = params.preTerminationChargeRate.toDouble()
        }
        if (params.pastdueInterestRate){
        loanAppSpecAddInstance.pastdueInterestRate = params.pastdueInterestRate.toDouble()
        }
        if (params.pastduePenaltyRate){
        loanAppSpecAddInstance.pastduePenaltyRate = params.pastduePenaltyRate.toDouble()
        }
        loanAppSpecAddInstance.loanApplicationType = params.loanApplicationType 
        loanAppSpecAddInstance.loanStatus = params.loanStatus
        if(params.totalToDate){
        loanAppSpecAddInstance.totalToDate = params.totalToDate.toDouble()
        }
        
        loanAppSpecAddInstance.recommendedRemarks1 = params.recommendedRemarks1
        loanAppSpecAddInstance.recommendedRemarks2 = params.recommendedRemarks2
        loanAppSpecAddInstance.recommendedDate =  params.recommendedDate? new Date().parse("MM/dd/yyyy", params.recommendedDate) : null
        loanAppSpecAddInstance.creditCommitteeRemarks = params.creditCommitteeRemarks
        loanAppSpecAddInstance.creditCommitteeSignatory1 = params.creditCommitteeSignatory1
        loanAppSpecAddInstance.creditCommitteeSignatory2 = params.creditCommitteeSignatory2
        loanAppSpecAddInstance.creditCommitteeSignatory3 = params.creditCommitteeSignatory3
        loanAppSpecAddInstance.creditCommitteeMember1 = params.creditCommitteeMember1
        loanAppSpecAddInstance.creditCommitteeMember2 = params.creditCommitteeMember2
        loanAppSpecAddInstance.creditCommitteePresident = params.creditCommitteePresident
        loanAppSpecAddInstance.creditCommitteeDate = params.creditCommitteeDate? new Date().parse("MM/dd/yyyy", params.creditCommitteeDate) : null
              
        loanAppSpecAddInstance.save(flush: true)
        } */
        if(user.id == 15 ) {
            println("tangina ayaw pumasok")
            def loanApplicationChecklistInstance = LoanApplicationChecklist.findByLoanApplication(loanApplicationInstance)
            if (!loanApplicationChecklistInstance){
                loanApplicationChecklistInstance = new LoanApplicationChecklist()
            }
            if(params.remarksChecklist){
                loanApplicationChecklistInstance.remarks = params.remarksChecklist
            }
            loanApplicationChecklistInstance.checklisttype = CreditInvestigationChecklistType.get(params.checklisttype)
            loanApplicationChecklistInstance.loanApplication = LoanApplication.get(loanApplicationInstance.id)
            if(params.slNoticeOfApproval){
                loanApplicationChecklistInstance.slNoticeOfApproval = params.slNoticeOfApproval
            }
            if(params.slCreditApprovalMemorandum){
                loanApplicationChecklistInstance.slCreditApprovalMemorandum = params.slCreditApprovalMemorandum
            }
            if(params.slCreditApplication){
                loanApplicationChecklistInstance.slCreditApplication = params.slCreditApplication
            }
            if(params.slCreditRiskRating){
                loanApplicationChecklistInstance.slCreditRiskRating = params.slCreditRiskRating
            }
            if(params.slCashFlowFinancialStatement){
                loanApplicationChecklistInstance.slCashFlowFinancialStatement = params.slCashFlowFinancialStatement
            }
            if(params.slLifeInsurance){
                loanApplicationChecklistInstance.slLifeInsurance = params.slLifeInsurance
            }
            if(params.slPromissoryNote){
                loanApplicationChecklistInstance.slPromissoryNote = params.slPromissoryNote
            }
            if(params.slDisclosureStatement){
                loanApplicationChecklistInstance.slDisclosureStatement = params.slDisclosureStatement
            }
            if(params.slAmortization){
                loanApplicationChecklistInstance.slAmortization = params.slAmortization
            }
            if(params.slDeedOfAssignment){
                loanApplicationChecklistInstance.slDeedOfAssignment = params.slDeedOfAssignment
            }
            if(params.slLoanAgreement){
                loanApplicationChecklistInstance.slLoanAgreement = params.slLoanAgreement
            }
            if(params.slLoanApplicationForm){
                loanApplicationChecklistInstance.slLoanApplicationForm = params.slLoanApplicationForm
            }
            if(params.slCreditInvestigationReport){
                loanApplicationChecklistInstance.slCreditInvestigationReport = params.slCreditInvestigationReport
            }
            if(params.slCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.slCreditBackgroundInvestigationReport = params.slCreditBackgroundInvestigationReport
            }
            if(params.slCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.slCreditInvestigationFromOtherBanks = params.slCreditInvestigationFromOtherBanks
            }
            if(params.slCourtClearance){
                loanApplicationChecklistInstance.slCourtClearance = params.slCourtClearance
            }
            if(params.slWaiveOfConfidentiality){
                loanApplicationChecklistInstance.slWaiveOfConfidentiality = params.slWaiveOfConfidentiality
            }
            if(params.slAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.slAuthorityToReleaseOfInformation = params.slAuthorityToReleaseOfInformation
            }
            if(params.slClientInformationSheetBorrower){
                loanApplicationChecklistInstance.slClientInformationSheetBorrower = params.slClientInformationSheetBorrower
            }
            if(params.slClientInformationSheetComaker){
                loanApplicationChecklistInstance.slClientInformationSheetComaker = params.slClientInformationSheetComaker
            }
            if(params.slComakerStatement){
                loanApplicationChecklistInstance.slComakerStatement = params.slComakerStatement
            }
            if(params.sl2pcs2x2IdPicture){
                loanApplicationChecklistInstance.sl2pcs2x2IdPicture = params.sl2pcs2x2IdPicture
            }
            if(params.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.slProofOfBillingBrgyClearance){                                      
                loanApplicationChecklistInstance.slProofOfBillingBrgyClearance = params.slProofOfBillingBrgyClearance
            }
            if(params.sl3PayslipForThePast3Months){       
                loanApplicationChecklistInstance.sl3PayslipForThePast3Months = params.sl3PayslipForThePast3Months
            }
            if(params.slCertificateOfEmployment){       
                loanApplicationChecklistInstance.slCertificateOfEmployment = params.slCertificateOfEmployment
            }
            if(params.slIncomeTaxReturnOrBIR){    
                loanApplicationChecklistInstance.slIncomeTaxReturnOrBIR = params.slIncomeTaxReturnOrBIR
            }
            if(params.slProofOfOtherSourceOfIncome){    
                loanApplicationChecklistInstance.slProofOfOtherSourceOfIncome = params.slProofOfOtherSourceOfIncome
            }
            if(params.buscolNoticeOfApproval){    
                loanApplicationChecklistInstance.buscolNoticeOfApproval = params.buscolNoticeOfApproval
            }
            if(params.buscolCreditApprovalMemorandum){    
                loanApplicationChecklistInstance.buscolCreditApprovalMemorandum = params.buscolCreditApprovalMemorandum
            }
            if(params.buscolCreditApplication){    
                loanApplicationChecklistInstance.buscolCreditApplication = params.buscolCreditApplication
            }
            if(params.buscolCreditRiskRating){    
                loanApplicationChecklistInstance.buscolCreditRiskRating = params.buscolCreditRiskRating
            }
            if(params.buscolCashFlowFinancialStatement){    
                loanApplicationChecklistInstance.buscolCashFlowFinancialStatement = params.buscolCashFlowFinancialStatement
            }
            if(params.buscolLifeInsurance){ 
                loanApplicationChecklistInstance.buscolLifeInsurance = params.buscolLifeInsurance
            }
            if(params.buscolPromissoryNote){ 
                loanApplicationChecklistInstance.buscolPromissoryNote = params.buscolPromissoryNote
            }
            if(params.buscolDisclosureStatement){ 
                loanApplicationChecklistInstance.buscolDisclosureStatement = params.buscolDisclosureStatement
            }
            if(params.buscolAmortization){ 
                loanApplicationChecklistInstance.buscolAmortization = params.buscolAmortization
            }
            if(params.buscolDeedOfAssignment){ 
                loanApplicationChecklistInstance.buscolDeedOfAssignment = params.buscolDeedOfAssignment
            }
            if(params.buscolLoanAgreement){ 
                loanApplicationChecklistInstance.buscolLoanAgreement = params.buscolLoanAgreement
            }
            if(params.buscolLoanApplicationForm){ 
                loanApplicationChecklistInstance.buscolLoanApplicationForm = params.buscolLoanApplicationForm
            }
            if(params.buscolCreditInvestigationReport){ 
                loanApplicationChecklistInstance.buscolCreditInvestigationReport = params.buscolCreditInvestigationReport
            }
            if(params.buscolCreditBackgroundInvestigationReport){ 
                loanApplicationChecklistInstance.buscolCreditBackgroundInvestigationReport = params.buscolCreditBackgroundInvestigationReport
            }
            if(params.buscolPictureOfBusiness){
                loanApplicationChecklistInstance.buscolPictureOfBusiness = params.buscolPictureOfBusiness
            }
            if(params.buscolCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.buscolCreditInvestigationFromOtherBanks = params.buscolCreditInvestigationFromOtherBanks
            }
            if(params.buscolCourtClearance){
                loanApplicationChecklistInstance.buscolCourtClearance = params.buscolCourtClearance
            }
            if(params.buscolWaiveOfConfidentiality){
                loanApplicationChecklistInstance.buscolWaiveOfConfidentiality = params.buscolWaiveOfConfidentiality
            }
            if(params.buscolAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.buscolAuthorityToReleaseOfInformation = params.buscolAuthorityToReleaseOfInformation
            }
            if(params.buscolClientInformationSheetBorrower){
                loanApplicationChecklistInstance.buscolClientInformationSheetBorrower = params.buscolClientInformationSheetBorrower
            }
            if(params.buscolClientInformationSheetComaker){
                loanApplicationChecklistInstance.buscolClientInformationSheetComaker = params.buscolClientInformationSheetComaker
            }
            if(params.buscolComakerStatement){
                loanApplicationChecklistInstance.buscolComakerStatement = params.buscolComakerStatement
            }
            if(params.buscol2pcs2x2IdPicture){
                loanApplicationChecklistInstance.buscol2pcs2x2IdPicture = params.buscol2pcs2x2IdPicture
            }
            if(params.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.buscolProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.buscolProofOfBillingBrgyClearance = params.buscolProofOfBillingBrgyClearance
            }
            if(params.buscolBrgyPermitBusinessPermitBIRRegistration){
                loanApplicationChecklistInstance.buscolBrgyPermitBusinessPermitBIRRegistration = params.buscolBrgyPermitBusinessPermitBIRRegistration
            }
            if(params.buscolDTIRegistration){
                loanApplicationChecklistInstance.buscolDTIRegistration = params.buscolDTIRegistration
            }
            if(params.buscolIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.buscolIncomeTaxReturnOrBIR = params.buscolIncomeTaxReturnOrBIR
            }
            if(params.buscolProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.buscolProofOfOtherSourceOfIncome = params.buscolProofOfOtherSourceOfIncome
            }
            if(params.buscolPictureOfCollateral){
                loanApplicationChecklistInstance.buscolPictureOfCollateral = params.buscolPictureOfCollateral
            }
            if(params.buscolREMContract){
                loanApplicationChecklistInstance.buscolREMContract = params.buscolREMContract
            }
            if(params.buscolChattelMortgage){
                loanApplicationChecklistInstance.buscolChattelMortgage = params.buscolChattelMortgage
            }
            if(params.buscolLandTitle){
                loanApplicationChecklistInstance.buscolLandTitle = params.buscolLandTitle
            }
            if(params.buscolTaxDeclaration){
                loanApplicationChecklistInstance.buscolTaxDeclaration = params.buscolTaxDeclaration
            }
            if(params.buscolRealEstateTaxReceipt){
                loanApplicationChecklistInstance.buscolRealEstateTaxReceipt = params.buscolRealEstateTaxReceipt
            }
            if(params.buscolAbsoluteOfDeedOfSale){
                loanApplicationChecklistInstance.buscolAbsoluteOfDeedOfSale = params.buscolAbsoluteOfDeedOfSale
            }
            if(params.buscolBlueprints){
                loanApplicationChecklistInstance.buscolBlueprints = params.buscolBlueprints
            }
            if(params.buscolSpecialPowerOfAtty){
                loanApplicationChecklistInstance.buscolSpecialPowerOfAtty = params.buscolSpecialPowerOfAtty
            }
            if(params.buscolCertificationOfNonDelinquency){
                loanApplicationChecklistInstance.buscolCertificationOfNonDelinquency = params.buscolCertificationOfNonDelinquency
            }
            if(params.buscolCertificationFromCENRO){
                loanApplicationChecklistInstance.buscolCertificationFromCENRO = params.buscolCertificationFromCENRO
            }
            if(params.buscolAffidavitOfNonTenancy){
                loanApplicationChecklistInstance.buscolAffidavitOfNonTenancy = params.buscolAffidavitOfNonTenancy
            }
            if(params.buscolFireInsurancePolicyDated){
                loanApplicationChecklistInstance.buscolFireInsurancePolicyDated = params.buscolFireInsurancePolicyDated
            }
            if(params.busNoticeOfApproval){
                loanApplicationChecklistInstance.busNoticeOfApproval = params.busNoticeOfApproval
            }
            if(params.busCreditApprovalMemorandum){
                loanApplicationChecklistInstance.busCreditApprovalMemorandum = params.busCreditApprovalMemorandum
            }
            if(params.busCreditApplication){
                loanApplicationChecklistInstance.busCreditApplication = params.busCreditApplication
            }
            if(params.busCreditRiskRating){
                loanApplicationChecklistInstance.busCreditRiskRating = params.busCreditRiskRating
            }
            if(params.busCashFlowFinancialStatement){
                loanApplicationChecklistInstance.busCashFlowFinancialStatement = params.busCashFlowFinancialStatement
            }
            if(params.busLifeInsurance){
                loanApplicationChecklistInstance.busLifeInsurance = params.busLifeInsurance
            }
            if(params.busPromissoryNote){
                loanApplicationChecklistInstance.busPromissoryNote = params.busPromissoryNote
            }
            if(params.busDisclosureStatement){
                loanApplicationChecklistInstance.busDisclosureStatement = params.busDisclosureStatement
            }
            if(params.busAmortization){
                loanApplicationChecklistInstance.busAmortization = params.busAmortization
            }
            if(params.busDeedOfAssignment){
                loanApplicationChecklistInstance.busDeedOfAssignment = params.busDeedOfAssignment
            }
            if(params.busLoanAgreement){
                loanApplicationChecklistInstance.busLoanAgreement = params.busLoanAgreement
            }
            if(params.busLoanApplicationForm){
                loanApplicationChecklistInstance.busLoanApplicationForm = params.busLoanApplicationForm
            }
            if(params.busCreditInvestigationReport){
                loanApplicationChecklistInstance.busCreditInvestigationReport = params.busCreditInvestigationReport
            }
            if(params.busCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.busCreditBackgroundInvestigationReport = params.busCreditBackgroundInvestigationReport
            }
            if(params.busPictureOfBusiness){
                loanApplicationChecklistInstance.busPictureOfBusiness = params.busPictureOfBusiness
            }
            if(params.busCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.busCreditInvestigationFromOtherBanks = params.busCreditInvestigationFromOtherBanks
            }
            if(params.busCourtClearance){
                loanApplicationChecklistInstance.busCourtClearance = params.busCourtClearance
            }
            if(params.busWaiveOfConfidentiality){
                loanApplicationChecklistInstance.busWaiveOfConfidentiality = params.busWaiveOfConfidentiality
            }
            if(params.busAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.busAuthorityToReleaseOfInformation = params.busAuthorityToReleaseOfInformation
            }
            if(params.busClientInformationSheetBorrower){
                loanApplicationChecklistInstance.busClientInformationSheetBorrower = params.busClientInformationSheetBorrower
            }
            if(params.busClientInformationSheetComaker){
                loanApplicationChecklistInstance.busClientInformationSheetComaker = params.busClientInformationSheetComaker
            }
            if(params.busComakerStatement){
                loanApplicationChecklistInstance.busComakerStatement = params.busComakerStatement
            }
            if(params.bus2pcs2x2IdPicture){
                loanApplicationChecklistInstance.bus2pcs2x2IdPicture = params.bus2pcs2x2IdPicture
            }
            if(params.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.busProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.busProofOfBillingBrgyClearance = params.busProofOfBillingBrgyClearance
            }
            if(params.busBrgyPermitBusinessPermitBIRRegistration){
                loanApplicationChecklistInstance.busBrgyPermitBusinessPermitBIRRegistration = params.busBrgyPermitBusinessPermitBIRRegistration
            }
            if(params.busDTIRegistration){
                loanApplicationChecklistInstance.busDTIRegistration = params.busDTIRegistration
            }
            if(params.busIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.busIncomeTaxReturnOrBIR = params.busIncomeTaxReturnOrBIR
            }
            if(params.busProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.busProofOfOtherSourceOfIncome = params.busProofOfOtherSourceOfIncome
            }                            
            
            if(params.houcolNoticeOfApproval){
                loanApplicationChecklistInstance.houcolNoticeOfApproval = params.houcolNoticeOfApproval
            }
            if(params.houcolCreditApprovalMemorandum){
                loanApplicationChecklistInstance.houcolCreditApprovalMemorandum = params.houcolCreditApprovalMemorandum
            }
            if(params.houcolCreditApplication){
                loanApplicationChecklistInstance.houcolCreditApplication = params.houcolCreditApplication
            }
            if(params.houcolCreditRiskRating){
                loanApplicationChecklistInstance.houcolCreditRiskRating = params.houcolCreditRiskRating
            }
            if(params.houcolCashFlowFinancialStatement){
                loanApplicationChecklistInstance.houcolCashFlowFinancialStatement = params.houcolCashFlowFinancialStatement
            }
            if(params.houcolLifeInsurance){
                loanApplicationChecklistInstance.houcolLifeInsurance = params.houcolLifeInsurance
            }
            if(params.houcolPromissoryNote){
                loanApplicationChecklistInstance.houcolPromissoryNote = params.houcolPromissoryNote
            }
            if(params.houcolDisclosureStatement){
                loanApplicationChecklistInstance.houcolDisclosureStatement = params.houcolDisclosureStatement
            }
            if(params.houcolAmortization){
                loanApplicationChecklistInstance.houcolAmortization = params.houcolAmortization
            }
            if(params.houcolDeedOfAssignment){
                loanApplicationChecklistInstance.houcolDeedOfAssignment = params.houcolDeedOfAssignment
            }
            if(params.houcolLoanAgreement){
                loanApplicationChecklistInstance.houcolLoanAgreement = params.houcolLoanAgreement
            }
            if(params.houcolLoanApplicationForm){
                loanApplicationChecklistInstance.houcolLoanApplicationForm = params.houcolLoanApplicationForm
            }
            if(params.houcolCreditInvestigationReport){
                loanApplicationChecklistInstance.houcolCreditInvestigationReport = params.houcolCreditInvestigationReport
            }
            if(params.houcolCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.houcolCreditBackgroundInvestigationReport = params.houcolCreditBackgroundInvestigationReport
            }
           
            if(params.houcolCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.houcolCreditInvestigationFromOtherBanks = params.houcolCreditInvestigationFromOtherBanks
            }
            if(params.houcolCourtClearance){
                loanApplicationChecklistInstance.houcolCourtClearance = params.houcolCourtClearance
            }
            if(params.houcolWaiveOfConfidentiality){
                loanApplicationChecklistInstance.houcolWaiveOfConfidentiality = params.houcolWaiveOfConfidentiality
            }
            if(params.houcolAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.houcolAuthorityToReleaseOfInformation = params.houcolAuthorityToReleaseOfInformation
            }
            if(params.houcolClientInformationSheetBorrower){
                loanApplicationChecklistInstance.houcolClientInformationSheetBorrower = params.houcolClientInformationSheetBorrower
            }
            if(params.houcolClientInformationSheetComaker){
                loanApplicationChecklistInstance.houcolClientInformationSheetComaker = params.houcolClientInformationSheetComaker
            }
            if(params.houcolComakerStatement){
                loanApplicationChecklistInstance.houcolComakerStatement = params.houcolComakerStatement
            }
            if(params.houcol2pcs2x2IdPicture){
                loanApplicationChecklistInstance.houcol2pcs2x2IdPicture = params.houcol2pcs2x2IdPicture
            }
            if(params.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.houcolProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.houcolProofOfBillingBrgyClearance = params.houcolProofOfBillingBrgyClearance
            }
           
            if(params.houcolDTIRegistration){
                loanApplicationChecklistInstance.houcolDTIRegistration = params.houcolDTIRegistration
            }
            if(params.houcolIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.houcolIncomeTaxReturnOrBIR = params.houcolIncomeTaxReturnOrBIR
            }
            if(params.houcolProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.houcolProofOfOtherSourceOfIncome = params.houcolProofOfOtherSourceOfIncome
            }            
            if(params.houcolPictureOfCollateral){
                loanApplicationChecklistInstance.houcolPictureOfCollateral = params.houcolPictureOfCollateral
            }
            if(params.houcolREMContract){
                loanApplicationChecklistInstance.houcolREMContract = params.houcolREMContract
            }
            
            if(params.houcolLandTitle){
                loanApplicationChecklistInstance.houcolLandTitle = params.houcolLandTitle
            }
            if(params.houcolTaxDeclaration){
                loanApplicationChecklistInstance.houcolTaxDeclaration = params.houcolTaxDeclaration
            }
            if(params.houcolRealEstateTaxReceipt){
                loanApplicationChecklistInstance.houcolRealEstateTaxReceipt = params.houcolRealEstateTaxReceipt
            }
            if(params.houcolAbsoluteOfDeedOfSale){
                loanApplicationChecklistInstance.houcolAbsoluteOfDeedOfSale = params.houcolAbsoluteOfDeedOfSale
            }
            if(params.houcolBlueprints){
                loanApplicationChecklistInstance.houcolBlueprints = params.houcolBlueprints
            }
            if(params.houcolSpecialPowerOfAtty){
                loanApplicationChecklistInstance.houcolSpecialPowerOfAtty = params.houcolSpecialPowerOfAtty
            }
            if(params.houcolCertificationOfNonDelinquency){
                loanApplicationChecklistInstance.houcolCertificationOfNonDelinquency = params.houcolCertificationOfNonDelinquency
            }
            if(params.houcolCertificationFromCENRO){
                loanApplicationChecklistInstance.houcolCertificationFromCENRO = params.houcolCertificationFromCENRO
            }
            if(params.houcolAffidavitOfNonTenancy){
                loanApplicationChecklistInstance.houcolAffidavitOfNonTenancy = params.houcolAffidavitOfNonTenancy
            }
            if(params.houcolFireInsurancePolicyDated){
                loanApplicationChecklistInstance.houcolFireInsurancePolicyDated = params.houcolFireInsurancePolicyDated
            }
            loanApplicationChecklistInstance.save flush:true
        }
        //saving gl_attachment =========================
        //        println("Session size: "+session["loanApplicationAttchmt"])
        //        if(session["loanApplicationAttchmt"] == "" || session["loanApplicationAttchmt"] == null){
        //            
        //            println("Batch with no attachment")
        //            
        //        }else{
        //            
        //            println("Loan Application with Attachment")
        //            println("session: "+session["loanApplicationAttchmt"])
        //            
        //            session["loanApplicationAttchmt"].eachWithIndex { attachmentItem , i ->
        //                println "attachmentItem: "+attachmentItem.filename
        //                attachmentItem.loanApplication = loanApplicationInstance
        //                attachmentItem.save(flush: true)
        //                println("Attachment saved comletety...")
        //            };
        //           
        //        }
        //        for(attachment in session["loanApplicationAttchmt"]) {
        //            loanApplicationInstance.addToAttachments(attachment)
        //        }
        //        session["attachments"] = null
        request.withFormat {
            
            form multipartForm {
                // flash.message = message(code: 'default.created.message', args: [message(code: 'loanApplication.label', default: 'LoanApplication'), loanApplicationInstance.id])
                redirect loanApplicationInstance
                //redirect action: "show", id: loanApplicationInstance.id
            }
            '*' { respond loanApplicationInstance, [status: CREATED] }
        }
    }

    def edit(LoanApplication loanApplicationInstance) {
        def user = UserMaster.get(session.user_id)
        session["comakerVerifier"]=""        
        //        session["loanApplicationAttchmt"] = ""
        //        def loanApplicationAttachmeneent = LoanApplicationAttachment.findAllByLoanApplication(loanApplicationInstance)
        def uploadDate 
        //        if(loanApplicationAttachmeneent){
        //            uploadDate = LoanApplicationAttachment.findAllByLoanApplication(loanApplicationInstance).uploadDate
        //            
        //        }
        def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
        def loanApplicationSpecAdd = LoanApplicationSpecAdditional.findByLoanApplication(loanApplicationInstance)
        //        def attchhmnt
        //        def attchmnts = []
        //        for(loanAppAttchmet in loanApplicationAttachmeneent){
        //            
        //            attchhmnt = new LoanApplicationAttachment(loanApplication:loanAppAttchmet.loanApplication, uploadDate:loanAppAttchmet.uploadDate, filename:loanAppAttchmet.filename,filedata:loanAppAttchmet.filedata,description: loanAppAttchmet.description,attachedBy:loanAppAttchmet.attachedBy,branch:loanAppAttchmet.branch,status:loanAppAttchmet.status)
        //            attchmnts.add(attchhmnt)
        //        }
        
        //        session["loanApplicationAttchmt"] = attchmnts
        //        session["attachmentcondtion"] = "edit"
        def loanApplicationChecklist = LoanApplicationChecklist.findByLoanApplication(loanApplicationInstance)
        def role = UserRole.findAllByUserMasterAndRole(UserMaster.get(session.user_id),Role.get(11))
        def parsing = Date.parse('yyyy-MM-dd',UserMaster.get(session.user_id).branch.runDate.toString())
        def sql = new Sql(dataSource)
        def camID = "select id from loan_application_spec_additional order by id desc"         
        def resultqueryall = sql.firstRow(camID)
        def resultString = resultqueryall.toString()
        def getBefore
        println("resultqueryall: " + resultqueryall)
        println("resultString: " + resultString)
        if(resultqueryall){
           
            println("sa if")
            def getAfter = resultString.substring(resultString.lastIndexOf("=") + 1)               
            def iend = getAfter.indexOf("}")             
            getBefore = getAfter.substring(0 , iend)
            println("getbefore: " + getBefore)
        } else{
             
            println("sa else")
            getBefore = "0"
        }
        def forSub = parsing.format('yyyy-MM-dd')
        //getBefore.toString()
        def camNo = forSub.substring(0, 8) +  (Integer.parseInt(getBefore) + 1)
        println(camNo)
        respond loanApplicationInstance, model:[camNo:camNo, role:role, loanApplicationChecklist:loanApplicationChecklist, user:user, comakers: comakers, loanApplicationSpecAdd: loanApplicationSpecAdd]

    }
    def editaddAttachment(){
        def loanApplicationInstance = LoanApplication.get(params.loanApplicationId.toInteger())
        def filename
        println("hahhaa")
        def filedata
        def description
        def dloanApplication = loanApplicationInstance
        def attachedBy
        def branch
        def status       
        def uploadDate = LoanApplicationAttachment.get(params.loanApplicationId.toInteger()).uploadDate
        println("params: "+params)
        println("params file: "+params.file)
        
        def branchid = UserMaster.get(session.user_id).branch
        def userid =  UserMaster.get(session.user_id)
        println("params branch:"+branchid)
        println("params user id: "+userid)
        def attchhmnt
        def file = request.getFile('file')
        if(file.isEmpty()) {
            flash.message = "File cannot be empty"
            println("if condition")
        } else {
            def dfilename = file.originalFilename
            println("pasok")
            attchhmnt = new LoanApplicationAttachment(loanApplication:dloanApplication, uploadDate: uploadDate, filename:dfilename,filedata:file.getBytes(),description: params.description,attachedBy:userid,branch:branchid,status:ConfigItemStatus.get(2))
            attchhmnt.save(flush: true)
        }
        redirect(action:'edit',controller:'loanApplication',id:dloanApplication.id)
    }
    @Transactional
    def update(LoanApplication loanApplicationInstance) {
        def user = UserMaster.get(session.user_id)
        if (loanApplicationInstance == null) {
            notFound()
            return
        }

        if (loanApplicationInstance.hasErrors()) {
            def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
            respond loanApplicationInstance.errors, model: [user:user, comakers:comakers], view:'edit'
            return
        }
        
        //        for(comaker in session["comakers"]) {
        //            def comakerLink = new LoanApplicationComaker(loanApplication: loanApplicationInstance, customer: comaker)
        //            comakerLink.save flush:true            
        //        }
        //        session["comakers"] = null
        //         def savedFinancialDetails = FinancialDetail.findAllByLoanApplication(loanApplicationInstance)
        ////         savedFinancialDetails*.delete()
        ////        
        ////          loanApplicationInstance.save flush:true
        ////        println("savedFinancialDetails: " + savedFinancialDetails)
        //        for(financialDetail in session["financialDetails"]) {
        //            for(savedFinancialDetail in savedFinancialDetails) {
        //                 println("savedFinancialDetail: " + savedFinancialDetail)
        //            if(financialDetail.id!=savedFinancialDetail.id){
        //                  loanApplicationInstance.addToFinancialDetails(financialDetail)
        //            }
        //            }
        //          
        //        }
        //        session["financialDetails"] = null
        //
        //        for(collateral in session["collaterals"]) {
        //            if (!collateral.isAttached())
        //            collateral.attach()
        //            loanApplicationInstance.addToCollaterals(collateral)
        //        }
        //        session["collaterals"] = null

        loanApplicationInstance.save flush:true
        
        // update loan account for customer
        def loan = Loan.findByLoanApplication(loanApplicationInstance)
        if (loan){
            if (loan.customer != loanApplicationInstance.customer){
                loan.customer = loanApplicationInstance.customer 
                loan.save(flush:true)
            }    
        }	
        def cust = Customer.get(loanApplicationInstance.customer.id)
        //========== SAVE INFORMATION TO LoanApplicationSpecAdditional==================
        if(user.id == 16 && cust.id == 6605 || user.designation.id == 30){
            println("PUTANGINANG BUHAY")
            def loanAppSpecAddInstance = LoanApplicationSpecAdditional.findByLoanApplication(loanApplicationInstance)
            if (!loanAppSpecAddInstance){
                loanAppSpecAddInstance = new LoanApplicationSpecAdditional()
                loanAppSpecAddInstance.loanApplication = LoanApplication.get(loanApplicationInstance.id)
            }
            loanAppSpecAddInstance.camNo = params.camNo
            loanAppSpecAddInstance.company = params.company
            loanAppSpecAddInstance.loanSecurity = LoanSecurity.get(params.loanSecurity.id)
            loanAppSpecAddInstance.loanClassification = params.loanClassification
            loanAppSpecAddInstance.loanProduct = params.loanProduct
            loanAppSpecAddInstance.economicActivity = params.economicActivity
            if(params.interestRate){
                loanAppSpecAddInstance.interestRate = params.interestRate.replace(',','').toDouble()
            }
        
            loanAppSpecAddInstance.mannerOfPayment = params.mannerOfPayment
            loanAppSpecAddInstance.repaymentType = params.repaymentType
            loanAppSpecAddInstance.condition1 = params.condition1
            loanAppSpecAddInstance.condition2 = params.condition2
            loanAppSpecAddInstance.condition3 = params.condition3
            loanAppSpecAddInstance.condition4 = params.condition4
            loanAppSpecAddInstance.condition5 = params.condition5
            loanAppSpecAddInstance.condition6 = params.condition6
            loanAppSpecAddInstance.condition7 = params.condition7
            if (params.amortizationPenaltyRate){
                loanAppSpecAddInstance.amortizationPenaltyRate = params.amortizationPenaltyRate.replace(',','').toDouble()
            }
            if (params.preTerminationChargeRate){
                loanAppSpecAddInstance.preTerminationChargeRate = params.preTerminationChargeRate.replace(',','').toDouble()
            }
            if (params.pastdueInterestRate){
                loanAppSpecAddInstance.pastdueInterestRate = params.pastdueInterestRate.replace(',','').toDouble()
            }
            if (params.pastduePenaltyRate){
                loanAppSpecAddInstance.pastduePenaltyRate = params.pastduePenaltyRate.replace(',','').toDouble()
            }
            loanAppSpecAddInstance.loanApplicationType = params.loanApplicationType 
            loanAppSpecAddInstance.loanStatus = params.loanStatus
            if(params.totalToDate){
                println(params.totalToDate)
                loanAppSpecAddInstance.totalToDate = params.totalToDate.replace(',','').toDouble()
                println(loanAppSpecAddInstance.totalToDate)
            }
       
            loanAppSpecAddInstance.recommendedRemarks1 = params.recommendedRemarks1
            loanAppSpecAddInstance.recommendedRemarks2 = params.recommendedRemarks2
            loanAppSpecAddInstance.recommendedDate =  params.recommendedDate? new Date().parse("MM/dd/yyyy", params.recommendedDate) : null
            loanAppSpecAddInstance.creditCommitteeRemarks = params.creditCommitteeRemarks
            loanAppSpecAddInstance.creditCommitteeSignatory1 = params.creditCommitteeSignatory1
            loanAppSpecAddInstance.creditCommitteeSignatory2 = params.creditCommitteeSignatory2
            loanAppSpecAddInstance.creditCommitteeSignatory3 = params.creditCommitteeSignatory3
            loanAppSpecAddInstance.creditCommitteeMember1 = params.creditCommitteeMember1
            loanAppSpecAddInstance.creditCommitteeMember2 = params.creditCommitteeMember2
            loanAppSpecAddInstance.creditCommitteePresident = params.creditCommitteePresident
            loanAppSpecAddInstance.creditCommitteeDate = params.creditCommitteeDate? new Date().parse("MM/dd/yyyy", params.creditCommitteeDate) : null
              
            loanAppSpecAddInstance.save(flush: true)
        }
        def description = 'Loan Application ' +  loanApplicationInstance.id + ' was edited by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', description, 'Loan', null, null, null, loanApplicationInstance.id)
        
        //        def loanAppAttachment = LoanApplicationAttachment.findAllByLoanApplication(loanApplicationInstance)
        //        for(xApp in loanAppAttachment){
        //            xApp.delete()
        //        }
        //        println("Session size: "+session["loanApplicationAttchmt"].size())
        //        if(session["loanApplicationAttchmt"].size() < 1 || session["loanApplicationAttchmt"] == ""){
        //            
        //            println("Batch with no attachment")
        //            
        //        }else{
        //            
        //            println("Loan Application with Attachment")
        //            println("session: "+session["loanApplicationAttchmt"])
        //            
        //            session["loanApplicationAttchmt"].eachWithIndex { attachmentItem , i ->
        //                println "attachmentItem: "+attachmentItem.filename
        //                attachmentItem.loanApplication = loanApplicationInstance
        //                attachmentItem.save(flush: true)
        //                println("Attachment saved comletety...")
        //            };
        //           
        //        }
        if(user.id == 15 ) {
            println("tangina ayaw pumasok")
            def loanApplicationChecklistInstance = LoanApplicationChecklist.findByLoanApplication(loanApplicationInstance)
            if (!loanApplicationChecklistInstance){
                loanApplicationChecklistInstance = new LoanApplicationChecklist()
            }
            if(params.remarksChecklist){
                loanApplicationChecklistInstance.remarks = params.remarksChecklist
            }
            loanApplicationChecklistInstance.checklisttype = CreditInvestigationChecklistType.get(params.checklisttype)
            loanApplicationChecklistInstance.loanApplication = LoanApplication.get(loanApplicationInstance.id)
            if(params.slNoticeOfApproval){
                loanApplicationChecklistInstance.slNoticeOfApproval = params.slNoticeOfApproval
            }
            if(params.slCreditApprovalMemorandum){
                loanApplicationChecklistInstance.slCreditApprovalMemorandum = params.slCreditApprovalMemorandum
            }
            if(params.slCreditApplication){
                loanApplicationChecklistInstance.slCreditApplication = params.slCreditApplication
            }
            if(params.slCreditRiskRating){
                loanApplicationChecklistInstance.slCreditRiskRating = params.slCreditRiskRating
            }
            if(params.slCashFlowFinancialStatement){
                loanApplicationChecklistInstance.slCashFlowFinancialStatement = params.slCashFlowFinancialStatement
            }
            if(params.slLifeInsurance){
                loanApplicationChecklistInstance.slLifeInsurance = params.slLifeInsurance
            }
            if(params.slPromissoryNote){
                loanApplicationChecklistInstance.slPromissoryNote = params.slPromissoryNote
            }
            if(params.slDisclosureStatement){
                loanApplicationChecklistInstance.slDisclosureStatement = params.slDisclosureStatement
            }
            if(params.slAmortization){
                loanApplicationChecklistInstance.slAmortization = params.slAmortization
            }
            if(params.slDeedOfAssignment){
                loanApplicationChecklistInstance.slDeedOfAssignment = params.slDeedOfAssignment
            }
            if(params.slLoanAgreement){
                loanApplicationChecklistInstance.slLoanAgreement = params.slLoanAgreement
            }
            if(params.slLoanApplicationForm){
                loanApplicationChecklistInstance.slLoanApplicationForm = params.slLoanApplicationForm
            }
            if(params.slCreditInvestigationReport){
                loanApplicationChecklistInstance.slCreditInvestigationReport = params.slCreditInvestigationReport
            }
            if(params.slCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.slCreditBackgroundInvestigationReport = params.slCreditBackgroundInvestigationReport
            }
            if(params.slCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.slCreditInvestigationFromOtherBanks = params.slCreditInvestigationFromOtherBanks
            }
            if(params.slCourtClearance){
                loanApplicationChecklistInstance.slCourtClearance = params.slCourtClearance
            }
            if(params.slWaiveOfConfidentiality){
                loanApplicationChecklistInstance.slWaiveOfConfidentiality = params.slWaiveOfConfidentiality
            }
            if(params.slAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.slAuthorityToReleaseOfInformation = params.slAuthorityToReleaseOfInformation
            }
            if(params.slClientInformationSheetBorrower){
                loanApplicationChecklistInstance.slClientInformationSheetBorrower = params.slClientInformationSheetBorrower
            }
            if(params.slClientInformationSheetComaker){
                loanApplicationChecklistInstance.slClientInformationSheetComaker = params.slClientInformationSheetComaker
            }
            if(params.slComakerStatement){
                loanApplicationChecklistInstance.slComakerStatement = params.slComakerStatement
            }
            if(params.sl2pcs2x2IdPicture){
                loanApplicationChecklistInstance.sl2pcs2x2IdPicture = params.sl2pcs2x2IdPicture
            }
            if(params.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.slProofOfBillingBrgyClearance){                                      
                loanApplicationChecklistInstance.slProofOfBillingBrgyClearance = params.slProofOfBillingBrgyClearance
            }
            if(params.sl3PayslipForThePast3Months){       
                loanApplicationChecklistInstance.sl3PayslipForThePast3Months = params.sl3PayslipForThePast3Months
            }
            if(params.slCertificateOfEmployment){       
                loanApplicationChecklistInstance.slCertificateOfEmployment = params.slCertificateOfEmployment
            }
            if(params.slIncomeTaxReturnOrBIR){    
                loanApplicationChecklistInstance.slIncomeTaxReturnOrBIR = params.slIncomeTaxReturnOrBIR
            }
            if(params.slProofOfOtherSourceOfIncome){    
                loanApplicationChecklistInstance.slProofOfOtherSourceOfIncome = params.slProofOfOtherSourceOfIncome
            }
            if(params.buscolNoticeOfApproval){    
                loanApplicationChecklistInstance.buscolNoticeOfApproval = params.buscolNoticeOfApproval
            }
            if(params.buscolCreditApprovalMemorandum){    
                loanApplicationChecklistInstance.buscolCreditApprovalMemorandum = params.buscolCreditApprovalMemorandum
            }
            if(params.buscolCreditApplication){    
                loanApplicationChecklistInstance.buscolCreditApplication = params.buscolCreditApplication
            }
            if(params.buscolCreditRiskRating){    
                loanApplicationChecklistInstance.buscolCreditRiskRating = params.buscolCreditRiskRating
            }
            if(params.buscolCashFlowFinancialStatement){    
                loanApplicationChecklistInstance.buscolCashFlowFinancialStatement = params.buscolCashFlowFinancialStatement
            }
            if(params.buscolLifeInsurance){ 
                loanApplicationChecklistInstance.buscolLifeInsurance = params.buscolLifeInsurance
            }
            if(params.buscolPromissoryNote){ 
                loanApplicationChecklistInstance.buscolPromissoryNote = params.buscolPromissoryNote
            }
            if(params.buscolDisclosureStatement){ 
                loanApplicationChecklistInstance.buscolDisclosureStatement = params.buscolDisclosureStatement
            }
            if(params.buscolAmortization){ 
                loanApplicationChecklistInstance.buscolAmortization = params.buscolAmortization
            }
            if(params.buscolDeedOfAssignment){ 
                loanApplicationChecklistInstance.buscolDeedOfAssignment = params.buscolDeedOfAssignment
            }
            if(params.buscolLoanAgreement){ 
                loanApplicationChecklistInstance.buscolLoanAgreement = params.buscolLoanAgreement
            }
            if(params.buscolLoanApplicationForm){ 
                loanApplicationChecklistInstance.buscolLoanApplicationForm = params.buscolLoanApplicationForm
            }
            if(params.buscolCreditInvestigationReport){ 
                loanApplicationChecklistInstance.buscolCreditInvestigationReport = params.buscolCreditInvestigationReport
            }
            if(params.buscolCreditBackgroundInvestigationReport){ 
                loanApplicationChecklistInstance.buscolCreditBackgroundInvestigationReport = params.buscolCreditBackgroundInvestigationReport
            }
            if(params.buscolPictureOfBusiness){
                loanApplicationChecklistInstance.buscolPictureOfBusiness = params.buscolPictureOfBusiness
            }
            if(params.buscolCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.buscolCreditInvestigationFromOtherBanks = params.buscolCreditInvestigationFromOtherBanks
            }
            if(params.buscolCourtClearance){
                loanApplicationChecklistInstance.buscolCourtClearance = params.buscolCourtClearance
            }
            if(params.buscolWaiveOfConfidentiality){
                loanApplicationChecklistInstance.buscolWaiveOfConfidentiality = params.buscolWaiveOfConfidentiality
            }
            if(params.buscolAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.buscolAuthorityToReleaseOfInformation = params.buscolAuthorityToReleaseOfInformation
            }
            if(params.buscolClientInformationSheetBorrower){
                loanApplicationChecklistInstance.buscolClientInformationSheetBorrower = params.buscolClientInformationSheetBorrower
            }
            if(params.buscolClientInformationSheetComaker){
                loanApplicationChecklistInstance.buscolClientInformationSheetComaker = params.buscolClientInformationSheetComaker
            }
            if(params.buscolComakerStatement){
                loanApplicationChecklistInstance.buscolComakerStatement = params.buscolComakerStatement
            }
            if(params.buscol2pcs2x2IdPicture){
                loanApplicationChecklistInstance.buscol2pcs2x2IdPicture = params.buscol2pcs2x2IdPicture
            }
            if(params.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.buscolProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.buscolProofOfBillingBrgyClearance = params.buscolProofOfBillingBrgyClearance
            }
            if(params.buscolBrgyPermitBusinessPermitBIRRegistration){
                loanApplicationChecklistInstance.buscolBrgyPermitBusinessPermitBIRRegistration = params.buscolBrgyPermitBusinessPermitBIRRegistration
            }
            if(params.buscolDTIRegistration){
                loanApplicationChecklistInstance.buscolDTIRegistration = params.buscolDTIRegistration
            }
            if(params.buscolIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.buscolIncomeTaxReturnOrBIR = params.buscolIncomeTaxReturnOrBIR
            }
            if(params.buscolProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.buscolProofOfOtherSourceOfIncome = params.buscolProofOfOtherSourceOfIncome
            }
            if(params.buscolPictureOfCollateral){
                loanApplicationChecklistInstance.buscolPictureOfCollateral = params.buscolPictureOfCollateral
            }
            if(params.buscolREMContract){
                loanApplicationChecklistInstance.buscolREMContract = params.buscolREMContract
            }
            if(params.buscolChattelMortgage){
                loanApplicationChecklistInstance.buscolChattelMortgage = params.buscolChattelMortgage
            }
            if(params.buscolLandTitle){
                loanApplicationChecklistInstance.buscolLandTitle = params.buscolLandTitle
            }
            if(params.buscolTaxDeclaration){
                loanApplicationChecklistInstance.buscolTaxDeclaration = params.buscolTaxDeclaration
            }
            if(params.buscolRealEstateTaxReceipt){
                loanApplicationChecklistInstance.buscolRealEstateTaxReceipt = params.buscolRealEstateTaxReceipt
            }
            if(params.buscolAbsoluteOfDeedOfSale){
                loanApplicationChecklistInstance.buscolAbsoluteOfDeedOfSale = params.buscolAbsoluteOfDeedOfSale
            }
            if(params.buscolBlueprints){
                loanApplicationChecklistInstance.buscolBlueprints = params.buscolBlueprints
            }
            if(params.buscolSpecialPowerOfAtty){
                loanApplicationChecklistInstance.buscolSpecialPowerOfAtty = params.buscolSpecialPowerOfAtty
            }
            if(params.buscolCertificationOfNonDelinquency){
                loanApplicationChecklistInstance.buscolCertificationOfNonDelinquency = params.buscolCertificationOfNonDelinquency
            }
            if(params.buscolCertificationFromCENRO){
                loanApplicationChecklistInstance.buscolCertificationFromCENRO = params.buscolCertificationFromCENRO
            }
            if(params.buscolAffidavitOfNonTenancy){
                loanApplicationChecklistInstance.buscolAffidavitOfNonTenancy = params.buscolAffidavitOfNonTenancy
            }
            if(params.buscolFireInsurancePolicyDated){
                loanApplicationChecklistInstance.buscolFireInsurancePolicyDated = params.buscolFireInsurancePolicyDated
            }
            if(params.busNoticeOfApproval){
                loanApplicationChecklistInstance.busNoticeOfApproval = params.busNoticeOfApproval
            }
            if(params.busCreditApprovalMemorandum){
                loanApplicationChecklistInstance.busCreditApprovalMemorandum = params.busCreditApprovalMemorandum
            }
            if(params.busCreditApplication){
                loanApplicationChecklistInstance.busCreditApplication = params.busCreditApplication
            }
            if(params.busCreditRiskRating){
                loanApplicationChecklistInstance.busCreditRiskRating = params.busCreditRiskRating
            }
            if(params.busCashFlowFinancialStatement){
                loanApplicationChecklistInstance.busCashFlowFinancialStatement = params.busCashFlowFinancialStatement
            }
            if(params.busLifeInsurance){
                loanApplicationChecklistInstance.busLifeInsurance = params.busLifeInsurance
            }
            if(params.busPromissoryNote){
                loanApplicationChecklistInstance.busPromissoryNote = params.busPromissoryNote
            }
            if(params.busDisclosureStatement){
                loanApplicationChecklistInstance.busDisclosureStatement = params.busDisclosureStatement
            }
            if(params.busAmortization){
                loanApplicationChecklistInstance.busAmortization = params.busAmortization
            }
            if(params.busDeedOfAssignment){
                loanApplicationChecklistInstance.busDeedOfAssignment = params.busDeedOfAssignment
            }
            if(params.busLoanAgreement){
                loanApplicationChecklistInstance.busLoanAgreement = params.busLoanAgreement
            }
            if(params.busLoanApplicationForm){
                loanApplicationChecklistInstance.busLoanApplicationForm = params.busLoanApplicationForm
            }
            if(params.busCreditInvestigationReport){
                loanApplicationChecklistInstance.busCreditInvestigationReport = params.busCreditInvestigationReport
            }
            if(params.busCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.busCreditBackgroundInvestigationReport = params.busCreditBackgroundInvestigationReport
            }
            if(params.busPictureOfBusiness){
                loanApplicationChecklistInstance.busPictureOfBusiness = params.busPictureOfBusiness
            }
            if(params.busCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.busCreditInvestigationFromOtherBanks = params.busCreditInvestigationFromOtherBanks
            }
            if(params.busCourtClearance){
                loanApplicationChecklistInstance.busCourtClearance = params.busCourtClearance
            }
            if(params.busWaiveOfConfidentiality){
                loanApplicationChecklistInstance.busWaiveOfConfidentiality = params.busWaiveOfConfidentiality
            }
            if(params.busAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.busAuthorityToReleaseOfInformation = params.busAuthorityToReleaseOfInformation
            }
            if(params.busClientInformationSheetBorrower){
                loanApplicationChecklistInstance.busClientInformationSheetBorrower = params.busClientInformationSheetBorrower
            }
            if(params.busClientInformationSheetComaker){
                loanApplicationChecklistInstance.busClientInformationSheetComaker = params.busClientInformationSheetComaker
            }
            if(params.busComakerStatement){
                loanApplicationChecklistInstance.busComakerStatement = params.busComakerStatement
            }
            if(params.bus2pcs2x2IdPicture){
                loanApplicationChecklistInstance.bus2pcs2x2IdPicture = params.bus2pcs2x2IdPicture
            }
            if(params.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.busProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.busProofOfBillingBrgyClearance = params.busProofOfBillingBrgyClearance
            }
            if(params.busBrgyPermitBusinessPermitBIRRegistration){
                loanApplicationChecklistInstance.busBrgyPermitBusinessPermitBIRRegistration = params.busBrgyPermitBusinessPermitBIRRegistration
            }
            if(params.busDTIRegistration){
                loanApplicationChecklistInstance.busDTIRegistration = params.busDTIRegistration
            }
            if(params.busIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.busIncomeTaxReturnOrBIR = params.busIncomeTaxReturnOrBIR
            }
            if(params.busProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.busProofOfOtherSourceOfIncome = params.busProofOfOtherSourceOfIncome
            }                        
            
            if(params.houcolNoticeOfApproval){
                loanApplicationChecklistInstance.houcolNoticeOfApproval = params.houcolNoticeOfApproval
            }
            if(params.houcolCreditApprovalMemorandum){
                loanApplicationChecklistInstance.houcolCreditApprovalMemorandum = params.houcolCreditApprovalMemorandum
            }
            if(params.houcolCreditApplication){
                loanApplicationChecklistInstance.houcolCreditApplication = params.houcolCreditApplication
            }
            if(params.houcolCreditRiskRating){
                loanApplicationChecklistInstance.houcolCreditRiskRating = params.houcolCreditRiskRating
            }
            if(params.houcolCashFlowFinancialStatement){
                loanApplicationChecklistInstance.houcolCashFlowFinancialStatement = params.houcolCashFlowFinancialStatement
            }
            if(params.houcolLifeInsurance){
                loanApplicationChecklistInstance.houcolLifeInsurance = params.houcolLifeInsurance
            }
            if(params.houcolPromissoryNote){
                loanApplicationChecklistInstance.houcolPromissoryNote = params.houcolPromissoryNote
            }
            if(params.houcolDisclosureStatement){
                loanApplicationChecklistInstance.houcolDisclosureStatement = params.houcolDisclosureStatement
            }
            if(params.houcolAmortization){
                loanApplicationChecklistInstance.houcolAmortization = params.houcolAmortization
            }
            if(params.houcolDeedOfAssignment){
                loanApplicationChecklistInstance.houcolDeedOfAssignment = params.houcolDeedOfAssignment
            }
            if(params.houcolLoanAgreement){
                loanApplicationChecklistInstance.houcolLoanAgreement = params.houcolLoanAgreement
            }
            if(params.houcolLoanApplicationForm){
                loanApplicationChecklistInstance.houcolLoanApplicationForm = params.houcolLoanApplicationForm
            }
            if(params.houcolCreditInvestigationReport){
                loanApplicationChecklistInstance.houcolCreditInvestigationReport = params.houcolCreditInvestigationReport
            }
            if(params.houcolCreditBackgroundInvestigationReport){
                loanApplicationChecklistInstance.houcolCreditBackgroundInvestigationReport = params.houcolCreditBackgroundInvestigationReport
            }
           
            if(params.houcolCreditInvestigationFromOtherBanks){
                loanApplicationChecklistInstance.houcolCreditInvestigationFromOtherBanks = params.houcolCreditInvestigationFromOtherBanks
            }
            if(params.houcolCourtClearance){
                loanApplicationChecklistInstance.houcolCourtClearance = params.houcolCourtClearance
            }
            if(params.houcolWaiveOfConfidentiality){
                loanApplicationChecklistInstance.houcolWaiveOfConfidentiality = params.houcolWaiveOfConfidentiality
            }
            if(params.houcolAuthorityToReleaseOfInformation){
                loanApplicationChecklistInstance.houcolAuthorityToReleaseOfInformation = params.houcolAuthorityToReleaseOfInformation
            }
            if(params.houcolClientInformationSheetBorrower){
                loanApplicationChecklistInstance.houcolClientInformationSheetBorrower = params.houcolClientInformationSheetBorrower
            }
            if(params.houcolClientInformationSheetComaker){
                loanApplicationChecklistInstance.houcolClientInformationSheetComaker = params.houcolClientInformationSheetComaker
            }
            if(params.houcolComakerStatement){
                loanApplicationChecklistInstance.houcolComakerStatement = params.houcolComakerStatement
            }
            if(params.houcol2pcs2x2IdPicture){
                loanApplicationChecklistInstance.houcol2pcs2x2IdPicture = params.houcol2pcs2x2IdPicture
            }
            if(params.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach){
                loanApplicationChecklistInstance.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach = params.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach
            }
            if(params.houcolProofOfBillingBrgyClearance){
                loanApplicationChecklistInstance.houcolProofOfBillingBrgyClearance = params.houcolProofOfBillingBrgyClearance
            }
           
            if(params.houcolDTIRegistration){
                loanApplicationChecklistInstance.houcolDTIRegistration = params.houcolDTIRegistration
            }
            if(params.houcolIncomeTaxReturnOrBIR){
                loanApplicationChecklistInstance.houcolIncomeTaxReturnOrBIR = params.houcolIncomeTaxReturnOrBIR
            }
            if(params.houcolProofOfOtherSourceOfIncome){
                loanApplicationChecklistInstance.houcolProofOfOtherSourceOfIncome = params.houcolProofOfOtherSourceOfIncome
            }            
            if(params.houcolPictureOfCollateral){
                loanApplicationChecklistInstance.houcolPictureOfCollateral = params.houcolPictureOfCollateral
            }
            if(params.houcolREMContract){
                loanApplicationChecklistInstance.houcolREMContract = params.houcolREMContract
            }
           
            if(params.houcolLandTitle){
                loanApplicationChecklistInstance.houcolLandTitle = params.houcolLandTitle
            }
            if(params.houcolTaxDeclaration){
                loanApplicationChecklistInstance.houcolTaxDeclaration = params.houcolTaxDeclaration
            }
            if(params.houcolRealEstateTaxReceipt){
                loanApplicationChecklistInstance.houcolRealEstateTaxReceipt = params.houcolRealEstateTaxReceipt
            }
            if(params.houcolAbsoluteOfDeedOfSale){
                loanApplicationChecklistInstance.houcolAbsoluteOfDeedOfSale = params.houcolAbsoluteOfDeedOfSale
            }
            if(params.houcolBlueprints){
                loanApplicationChecklistInstance.houcolBlueprints = params.houcolBlueprints
            }
            if(params.houcolSpecialPowerOfAtty){
                loanApplicationChecklistInstance.houcolSpecialPowerOfAtty = params.houcolSpecialPowerOfAtty
            }
            if(params.houcolCertificationOfNonDelinquency){
                loanApplicationChecklistInstance.houcolCertificationOfNonDelinquency = params.houcolCertificationOfNonDelinquency
            }
            if(params.houcolCertificationFromCENRO){
                loanApplicationChecklistInstance.houcolCertificationFromCENRO = params.houcolCertificationFromCENRO
            }
            if(params.houcolAffidavitOfNonTenancy){
                loanApplicationChecklistInstance.houcolAffidavitOfNonTenancy = params.houcolAffidavitOfNonTenancy
            }
            if(params.houcolFireInsurancePolicyDated){
                loanApplicationChecklistInstance.houcolFireInsurancePolicyDated = params.houcolFireInsurancePolicyDated
            }
            loanApplicationChecklistInstance.save flush:true
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LoanApplication.label', default: 'LoanApplication'), loanApplicationInstance.id])
                redirect loanApplicationInstance
            }
            '*'{ respond loanApplicationInstance, [status: OK] }
        }
    }

    def showUpdateStatusAjax() {
        def loanApplicationInstance = LoanApplication.get(params.id)
        def user = UserMaster.get(session.user_id)
        render(template:"status/editStatus", model:[user:user, loanApplicationInstance:loanApplicationInstance]) as JSON
        return
    }

    @Transactional
    def updateStatusAjax() {
        def loanApplicationInstance = LoanApplication.get(params.id)

        loanApplicationInstance.approvalStatus = LoanApplicationStatus.get(params.approvalStatus.id)

        if (loanApplicationInstance.approvalStatus.id == 5) {
            loanApplicationInstance.rejectedBy = UserMaster.get(session.user_id)
            loanApplicationInstance.dateRejected = loanApplicationInstance.branch.runDate
        } else if (loanApplicationInstance.approvalStatus.id == 6) {
            loanApplicationInstance.approvedBy = UserMaster.get(session.user_id)
            loanApplicationInstance.dateApproved = loanApplicationInstance.branch.runDate
        }

        loanApplicationInstance.save flush:true

        def message = "Status successfully updated"
        render(template:"status/editStatus", model:[loanApplicationInstance:loanApplicationInstance, message:message]) as JSON
        
        def description = 'Loan Application ' +  loanApplicationInstance.id + ' was updated to '+ LoanApplicationStatus.get(params.approvalStatus.id).description +' by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', description, 'Loan', null, null, null, loanApplicationInstance.id)
        return
    }    
    
    /*
     * Financial Details
     */

    def showFinancialDetailsAjax() {
        render(template:"financialDetails/list") as JSON
        return
    }    

    def showFinancialDetailsAjax2() {
        def id  = params?.id
        def loanApplicationInstance = LoanApplication.get(id)

        render(template:"financialDetails/list", model:[loanApplicationInstance:loanApplicationInstance]) as JSON
        return
    }    

    def showAddFinancialDetailAjax() {    
        render(template:"financialDetails/form") as JSON
        return
    }

    def addFinancialDetailAjax() { 
        
        def description = params?.description
        def value
        //==================================
        def financialvaluex =  params?.value ? (params?.value.replaceAll(",","")): null
        double changetoValuewithComma = Double.parseDouble(financialvaluex);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        financialvaluex = formatter.format(changetoValuewithComma)
        println("financialvaluex: "+financialvaluex)
        //==================================
        params?.value = params?.value ? (params?.value.replaceAll(",","")): null
        println("params: "+params?.value)				 
        if (params?.value == '')
        {
            value = params?.value 
        }
        else
        {
            value = params?.value.toDouble()
        }
        def type = params?.type
        def des = LoanFinancialInfoType.get(params?.type).description
        
        
        
        if (description == '')
        {
            def message = 'Description cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value == '')
        {
            def message = 'Amount Value cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value < 0)
        {
            def message = 'Amount Value cannot be negative !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
       

        def financialDetail = new FinancialDetail(description: description, value: value, type: LoanFinancialInfoType.get(type))
        financialDetail.dateCreated = new Date()

        if (!financialDetail.validate()) {
            render(template:"financialDetails/form", model:[financialDetail:financialDetail]) as JSON
            return
        } 

        def financialDetails
        if (session["financialDetails"]) {
            financialDetails = session["financialDetails"]
            println("may laman ang FD: " + financialDetails)
        } else {
            financialDetails = []
            println("walang laman ang FD: " + financialDetails)
        }        
        financialDetails.add(financialDetail)
        session["financialDetails"] = financialDetails        
        
        def message = 'Financial detail type ' + des + ' with value P' + financialvaluex + ' was succesfully added!'
        render(template:"financialDetails/form", model:[message:message]) as JSON

        return
    }

    @Transactional
    def addFinancialDetailAjax2() {
        def id  = params?.id
        def description = params?.description
        def value
        //==================================
        def financialvaluex =  params?.value ? (params?.value.replaceAll(",","")): null
        double changetoValuewithComma = Double.parseDouble(financialvaluex);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        financialvaluex = formatter.format(changetoValuewithComma)
        println("financialvaluex: "+financialvaluex)
        //==================================
        params?.value = params?.value ? (params?.value.replaceAll(",","")): null
        if (params?.value == '')
        {
            value = params?.value 
        }
        else
        {
            value = params?.value.toDouble()
        }   
        def type = params?.type
        def des = LoanFinancialInfoType.get(params?.type).description
        if (description == '')
        {
            def message = 'Description cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value == '')
        {
            def message = 'Amount Value cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value < 0)
        {
            def message = 'Amount Value cannot be negative !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }

        def financialDetail = new FinancialDetail(description: description, value: value, type: LoanFinancialInfoType.get(type))
        financialDetail.dateCreated = new Date()

        if (!financialDetail.validate()) {
            render(template:"financialDetails/form", model:[financialDetail:financialDetail]) as JSON
            return
        } 

        def loanApplicationInstance = LoanApplication.get(id)
        loanApplicationInstance.addToFinancialDetails(financialDetail)
        loanApplicationInstance.save flush:true
        
        def logdescription = 'Loan Application '+ loanApplicationInstance.id + ' added new financial detail by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null,loanApplicationInstance.id)
        def message = 'Financial detail type ' + des + ' with value P' + financialvaluex + ' was succesfully added!'
        render(template:"financialDetails/form", model:[message:message]) as JSON

        return
    }

    def showUpdateFinancialDetailAjax() {   
        def id = params?.id?.toInteger()
        
        def financialDetails = session["financialDetails"]        
        def financialDetail = financialDetails[id]

        render(template:"financialDetails/form", model:[financialDetail:financialDetail]) as JSON
        return
    }

    def showUpdateFinancialDetailAjax2() {   
        def id = params?.id?.toInteger()
        
        def financialDetail = FinancialDetail.get(id)

        render(template:"financialDetails/form", model:[financialDetail:financialDetail]) as JSON
        return
    }

    def updateFinancialDetailAjax() {   
        def id = params?.id?.toInteger()
        def description = params?.description
        params?.value = params?.value ? (params?.value.replaceAll(",","")): null
        println("params: "+params?.value)	 
        def value = params?.value ? params?.value?.toDouble() : null
        def type = params?.type
        
        
        if (description == '')
        {
            def message = 'Description cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value == '')
        {
            def message = 'Amount Value cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value < 0)
        {
            def message = 'Amount Value cannot be negative !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        } 
        
        def tempFinancialDetail = new FinancialDetail(description: description, value: value, type: LoanFinancialInfoType.get(type))
        tempFinancialDetail.dateCreated = new Date()

        if (!tempFinancialDetail.validate()) {
            render(template:"financialDetails/form", model:[financialDetail:tempFinancialDetail]) as JSON
            return
        }        

        def financialDetails = session["financialDetails"]        
        def financialDetail = financialDetails[id]

        financialDetail.description = description
        financialDetail.value = value
        financialDetail.type = LoanFinancialInfoType.get(type)

        def message = "Financial detail successfully updated"
        render(template:"financialDetails/form", model:[financialDetail:financialDetail, message:message]) as JSON

        return
    }

    @Transactional
    def updateFinancialDetailAjax2() {  
        def id  = params?.id
        def description = params?.description
         params?.value = params?.value ? (params?.value.replaceAll(",","")): null
        def value = params?.value ? params?.value?.toDouble() : null
        def type = params?.type
        
        if (description == '')
        {
            def message = 'Description cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value == '')
        {
            def message = 'Amount Value cannot be null !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        if (value < 0)
        {
            def message = 'Amount Value cannot be negative !'
            render(template:"financialDetails/form" , model:[message:message]) as JSON
            return
        }
        
        def financialDetail = FinancialDetail.get(id)
        financialDetail.description = description
        financialDetail.value = value
        financialDetail.type = LoanFinancialInfoType.get(type)

        if (!financialDetail.validate()) {
            render(template:"financialDetails/form", model:[financialDetail:financialDetail]) as JSON
            return
        }  

        financialDetail.save flush:true
        def logdescription = 'Loan Application '+ FinancialDetail.get(id).loanApplication.id + ' financial details was updated by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null, FinancialDetail.get(id).loanApplication.id)
        def message = "Financial detail successfully updated"
        render(template:"financialDetails/form", model:[financialDetail:financialDetail, message:message]) as JSON

        return
    }
        
    def deleteFinancialDetailAjax() {
        def id = params?.id?.toInteger()
        println("id sa putangina delete: " + id)
        session["financialDetails"].remove(id)

        render "success"
        return
    }

    @Transactional
    def deleteFinancialDetailAjax2() {
        def id = params?.id?.toInteger()
        //        def financialDetailId = params?.financialDetailId?.toInteger()

        //        def loanApplicationInstance = LoanApplication.get(id)
        def financialDetail = FinancialDetail.get(id)
        def loanApplicationInstance = LoanApplication.get(financialDetail.loanApplication.id)
        
        loanApplicationInstance.removeFromFinancialDetails(financialDetail)
        loanApplicationInstance.save flush:true

        render "success"
        return
    }

    /*
     * Comakers
     */

    def showComakersAjax() {
        render(template:"comakers/list") as JSON
        return
    }   

    def showComakersAjax2() {
        def id  = params?.id
        def loanApplicationInstance = LoanApplication.get(id)
        def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)

        render(template:"comakers/list", model:[comakers:comakers]) as JSON
        return
    }  

    def addComakerAjax() {
        def sql = new Sql(dataSource)
        def id = params?.id
        println("params id: "+params?.id)
        session["comakerVerifier"]=""
        def comaker = Customer.get(id)
        def verifyExistingCustomerInstance = "select loan_application_comaker.customer_id,loan_application_comaker.loan_application_id,loan.id,loan.account_no,loan.status_id from loan_application_comaker INNER JOIN loan ON loan_application_comaker.loan_application_id=loan.loan_application_id where loan.status_id < 5 and loan_application_comaker.customer_id="+id
        def existingResultSet = sql.rows(verifyExistingCustomerInstance)
      
        if(existingResultSet){
            println("existingResultSet: "+existingResultSet)
            session["comakerVerifier"] = "Customer Comaker already exists in other Loan Account"
        }else{
            session["comakerVerifier"] = "";
            println("existingResultSet1: "+existingResultSet)
        }
        
       
        def comakers
        if (session["comakers"]) {
            comakers = session["comakers"]
        } else {
            comakers = []
        }

        if (!(comakers*.id.contains(comaker.id))) {
            comakers.add(comaker)
            session["comakers"] = comakers
        }

        render "success"
        return
    }

    @Transactional
    def addComakerAjax2() {    
        def id = params?.id
        def cid = params?.cid
        println("add comaker ajax2")
        def loanApplicationInstance = LoanApplication.get(id)
        def comaker = Customer.get(cid)

        if (!LoanApplicationComaker.find{loanApplication == loanApplicationInstance && customer == comaker}) {            
            def comakerLink = new LoanApplicationComaker(loanApplication: loanApplicationInstance, customer: comaker)
            comakerLink.save flush:true
        }
        
        def logdescription = 'Loan Application '+ loanApplicationInstance.id + ' added co-maker detail by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null,loanApplicationInstance.id)
        render "success"
        return
    }

    def deleteComakerAjax() {
        session["comakerVerifier"] =""
        def id = params?.id?.toInteger()
        session["comakers"].remove(id)

        render "success"
        return
    }

    @Transactional
    def deleteComakerAjax2() {
        def id = params?.id

        def comakerLink = LoanApplicationComaker.get(id)
        def applicationId = comakerLink.loanApplication.id
        println("applicationId: "+applicationId)
        //def applicationId = LoanApplicationComaker.get(id).loanApplication.id
        
        comakerLink.delete flush:true
        
        def logdescription = 'Loan Application '+ applicationId + ' remove co-maker detail by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null,applicationId)
        render "success"
        return
    }
    
    /*
     * Collateral
     */

    def showCollateralAjax() {
        render(template:"collateral/list") as JSON
        return
    }

    def showCollateralAjax2() {
        def id  = params?.id
        def loanApplicationInstance = LoanApplication.get(id)
        
        render(template:"collateral/list",  model:[loanApplicationInstance:loanApplicationInstance]) as JSON
        return
    }  

    def addCollateralAjax() {
        def id = params?.id
        def stat = Collateral.get(params.id).status.id
        println "geloy " + stat
        if (stat != 2)
        {
            def message = 'Update Collateral Status!'
            render "message"
            return  
        }
        def collateral = Collateral.get(id)

        def collaterals
        if (session["collaterals"]) {
            collaterals = session["collaterals"]
        } else {
            collaterals = []
        }

        if (!(collaterals*.id.contains(collateral.id))) {
            collaterals.add(collateral)
            session["collaterals"] = collaterals
        }

        render "success"
        return
    }

    @Transactional
    def addCollateralAjax2() {    
        def id = params?.id
        def collateralId = params?.collateralId
     
        def stat = Collateral.get(collateralId).status.id
        println "gelo" + stat
        if (stat != 2)
        {
            def message = 'Update Collateral Status!'
            render "message"
            return  
        }
        def loanApplicationInstance = LoanApplication.get(id)
        def collateral = Collateral.get(collateralId)

        if (!(loanApplicationInstance*.collaterals.id.contains(collateral.id))) {
            loanApplicationInstance.addToCollaterals(collateral)
            loanApplicationInstance.save flush:true
        }
        def logdescription = 'Loan Application '+ loanApplicationInstance.id + ' added collateral detail by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null,loanApplicationInstance.id)
        render "success"
        return
    }

    def deleteCollateralAjax() {
        def id = params?.id?.toInteger()
        session["collaterals"].remove(id)

        render "success"
        return
    }

    @Transactional
    def deleteCollateralAjax2() {
        def id = params?.id
        def collateralId = params?.collateralId
        
        def loanApplicationInstance = LoanApplication.get(id)
        def collateral = Collateral.get(collateralId)

        loanApplicationInstance.removeFromCollaterals(collateral)
        loanApplicationInstance.save flush:true
        
        def logdescription = 'Loan Application '+ loanApplicationInstance.id + ' remove collateral detail by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00201', logdescription, 'Loan', null, null, null,loanApplicationInstance.id)
        render "success"
        return
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'loanApplication.label', default: 'LoanApplication'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    protected void customerInfo() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.customer', args: [message(code: 'loanApplication.label', default: 'LoanApplication'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def showCam(LoanApplication loanApplicationInstance){
      
        loanApplicationInstance = LoanApplication.get(params?.id)
        
        def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
        def addresses = Address.findAllByCustomer(comakers.customer)
        def lov = Lov.findById(413)
        def spouse = CustomerRelationship.findByCustomerAndRelationshipType(loanApplicationInstance.customer,lov)
        def loanApplicationSpecAdd = LoanApplicationSpecAdditional.findByLoanApplication(loanApplicationInstance)
        println(loanApplicationSpecAdd)
       
        
        println("loan application id: "+loanApplicationInstance?.id)
        def validateExistingLoanApplicationIdtoLoan = Loan.findByLoanApplication(loanApplicationInstance)
        println("result: "+validateExistingLoanApplicationIdtoLoan)
        def isLoanApplicationExist = ""
        if(validateExistingLoanApplicationIdtoLoan){
            isLoanApplicationExist = "true"
        }else{
            isLoanApplicationExist = "false"
        }
        
        def lastId
        def creditInvestigationInstance = CreditInvestigation.findByLoanApplication(loanApplicationInstance)
        if(creditInvestigationInstance){
            def c = CreditInvestigationBRRHistory.createCriteria()
            lastId = c.list {

                eq("creditInvestigation", creditInvestigationInstance)

                maxResults(1)
                order("id", "desc")
            }
        }
       
        
        respond loanApplicationInstance, model: [spouse: spouse, addresses: addresses, comakers: comakers, loanApplicationSpecAdd: loanApplicationSpecAdd, isLoanApplicationExist: isLoanApplicationExist,validateExistingLoanApplicationIdtoLoan:validateExistingLoanApplicationIdtoLoan,
            lastId:lastId,creditInvestigationInstance:creditInvestigationInstance]    
    }
    
    protected void statusPending() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.cifstatus', args: [message(code: 'loan.label', default: 'Loan'), params.id])
                redirect action: "index", method: "GET"
              
           
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def populateSelectAccountOfficer() {
        def dm = group_record.get(params.id)
        def demos = group_record.list()
        [dm: dm, demos: demos]
    }
    

}
