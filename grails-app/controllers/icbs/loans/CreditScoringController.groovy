package icbs.loans
//jm
import icbs.admin.Product
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.admin.Branch
import icbs.loans.CreditScoringProductConfig
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.json.JsonBuilder
import org.springframework.web.context.request.RequestContextHolder
import groovy.sql.Sql
import javax.servlet.http.HttpSession
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.loans.CreditScoringCodeDescription
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringRatedItems
class CreditScoringController {
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE", saveCharge: "PUT"]
    def dataSource
    def index() { }
    
    def configProduct(Integer max){
         params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null) {  // show all instances 
            def creditScoringProductList = CreditScoringCodeDescription.createCriteria().list(params) {
                
            }
            respond creditScoringProductList, model:[creditScoringProductList: creditScoringProductList,creditScoringProductInstanceCount: creditScoringProductList.totalCount]
        }
        else {    // show query results
            def creditScoringProductList = CreditScoringCodeDescription.createCriteria().list(params) {
                or {
                    
                }
            }
            respond creditScoringProductList, model:[creditScoringProductList: creditScoringProductList,creditScoringProductInstanceCount: creditScoringProductList.totalCount]
        }
        
    }
    def configSection(Integer max){
         params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null) {  // show all instances 
            def creditScoringCodeList = CreditScoringCodeDescription.createCriteria().list(params) {
                order("id", "asc")
            }
            respond creditScoringCodeList, model:[creditScoringCodeList: creditScoringCodeList,creditScoringCodeListInstanceCount: creditScoringCodeList.totalCount]
        }
        else {    // show query results
             def creditScoringCodeList = CreditScoringCodeDescription.createCriteria().list(params) {
                or {
                    
                }
                order("id", "asc")
            }
            
            respond creditScoringCodeList, model:[creditScoringCodeList: creditScoringCodeList,creditScoringCodeListInstanceCount: creditScoringCodeList.totalCount]
        }
    }
    def createProduct(){
        
    }
    def saveProduct(){
        println("params: "+params)
        def proxxxxx = params.list('products')     
        def creditCodeProductConfigInstance = new CreditScoringCodeDescription()
            creditCodeProductConfigInstance.code = params.code
            creditCodeProductConfigInstance.description = params.description
            if(params.ishasRatedItem == "" || params.ishasRatedItem == null){
                println("PUTANGINA")
                params.ishasRatedItem = false
            }else{
                params.ishasRatedItem = true
            }
            creditCodeProductConfigInstance.hasRatedItem = params.ishasRatedItem
            creditCodeProductConfigInstance.status = ConfigItemStatus.get(2)
            creditCodeProductConfigInstance.createdBy = UserMaster.get(session.user_id)
            creditCodeProductConfigInstance.dateCreated = Branch.get(1).runDate
        creditCodeProductConfigInstance.save(flush:true,failOnError: true)
        proxxxxx.each {
            println("id: "+it)
            def saveProductInstance = new CreditScoringProductConfig()
                saveProductInstance.creditScoringCodeDescription = creditCodeProductConfigInstance
                saveProductInstance.product = Product.get(it)
                saveProductInstance.save(flush:true, failOnError:true)
        }
        redirect(controller: "creditScoring",action:"codeWithProductDetails",id:creditCodeProductConfigInstance.id)
    }
    def showProduct(){
        
    }
    def codeWithProductDetails(){
        println("params: "+params)
        def productUndercodeInstance = CreditScoringCodeDescription.get(params.id)
        def c = CreditScoringProductConfig.createCriteria()
        def productResultsUndercode = c.list {
            
            and {
                eq("creditScoringCodeDescription", productUndercodeInstance)
            }
            order("id", "asc")
        }
        println("productResultsUndercode: "+productResultsUndercode)
        [productUndercodeInstance:productUndercodeInstance,productResultsUndercode:productResultsUndercode]
    }
    def updateCodeAndProducts(){
        println("params: "+params)
        def productUndercodeInstance = CreditScoringCodeDescription.get(params.id)
        def c = CreditScoringProductConfig.createCriteria()
        def productResultsUndercode = c.list {
            
            and {
                eq("creditScoringCodeDescription", productUndercodeInstance)
            }
            order("id", "asc")
        }
        println("productResultsUndercode: "+productResultsUndercode)
        [productUndercodeInstance:productUndercodeInstance,productResultsUndercode:productResultsUndercode]
    }
    def saveUpdatedCodeAndProduct(){
        println("params: "+params)
        def proxxxxx = params.list('products') 
        
        println("params: "+params)
        def findCode = CreditScoringCodeDescription.get(params.codeId)
        println("findCode: "+findCode)
        
        if(params.ishasRatedItem == "" || params.ishasRatedItem == null){
            println("PUTANGINA")
            params.ishasRatedItem = false
        }else{
            params.ishasRatedItem = true
        }
        findCode.code = params.code
        findCode.description = params.description
        findCode.hasRatedItem = params.ishasRatedItem
        findCode.lastUpdatedBy = UserMaster.get(session.user_id)
        findCode.lastUpdatedDate = Branch.get(1).runDate
        findCode.save(flush:true)

        def sql = new Sql(dataSource)
        def queryall1 = "delete from credit_scoring_product_config where credit_scoring_code_description_id = "+findCode.id
        def resultqueryall1 = sql.execute(queryall1)
        
        proxxxxx.each {
            println("id: "+it)
            def saveProductInstance = new CreditScoringProductConfig()
                saveProductInstance.creditScoringCodeDescription = findCode
                saveProductInstance.product = Product.get(it)
                saveProductInstance.save(flush:true, failOnError:true)
        }
        
        redirect(controller: "creditScoring",action:"codeWithProductDetails",id:findCode.id)
        
    }
    def validateExisitingCode(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        def queryall = ""
       //def txnTemplateInstance = TxnTemplate.findByCodeAndTxnType(json.codevalue.toString(),icbs.lov.TxnType.get(json.txntypevalue.toInteger()))
        println("json.actionType: "+json.actionType)
        if(json.actionType.toString() == 'create'){
            queryall = "select * from credit_scoring_code_description where code = '${json.xcode.toString()}'"
        }else{
            queryall = "select * from credit_scoring_code_description where code = '${json.xcode.toString()}' and id <> "+json.codeId
        }
            
        def resultqueryall = sql.rows(queryall)
        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    def createSection(){
        println("params: "+params)
        def codeInstance = CreditScoringCodeDescription.get(params.id)
        [codeInstance:codeInstance]
    }
    def saveSection(){
        println("matt Params: "+params)
        //Save Section
        def creditScoringQuestionSectionInstance = new CreditScoringQuestionSection()
            creditScoringQuestionSectionInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.code)
            creditScoringQuestionSectionInstance.nameOfSection = params.sectionName ? params?.sectionName.toString() : ''
            
            creditScoringQuestionSectionInstance.status = ConfigItemStatus.get(2)
            creditScoringQuestionSectionInstance.sectionPercentage = params.sectionPercentage ? params.sectionPercentage.toDouble() : 0.00D
            creditScoringQuestionSectionInstance.createdBy = UserMaster.get(session.user_id)
            creditScoringQuestionSectionInstance.dateCreated = Branch.get(1).runDate
            creditScoringQuestionSectionInstance.save(flush:true,failOnError: true)
            
            redirect(controller: "creditScoring",action: "codeWithQuestionSectionDetails", id:CreditScoringCodeDescription.get(params.code).id)
        
    }
    def codeWithQuestionSectionDetails(){
        println("params: "+params)
        
        def codeInstance = CreditScoringCodeDescription.get(params.id)
        
        def c = CreditScoringQuestionSection.createCriteria()
        def sectionOfQuestionInstance = c.list {
            
            and {
                eq("creditScoringCodeDescription", codeInstance)
            }
            order("id", "asc")
        }
        
        //CreditScoringPreQualification
        def d = CreditScoringPreQualification.createCriteria()
        def prequalificationList = d.list {
            
            and {
                eq("creditScoringCodeDescription", codeInstance)
            }
            order("id", "asc")
        }
        
        //rated Items
        
        def e = CreditScoringRated.createCriteria()
        def ratedList = e.list {

            and {
                eq("creditScoringCodeDescription", codeInstance)
            }
            order("id", "asc")
        }
        println("ratedList: "+ratedList)
        
        
        
       
        println("prequalificationList: "+prequalificationList)
        [ratedList:ratedList,codeInstance:codeInstance,sectionOfQuestionInstance:sectionOfQuestionInstance,prequalificationList:prequalificationList]
    }
    def updateSection(){
        println("params: "+params)
        def sectionInstance = CreditScoringQuestionSection.get(params.id)
        [sectionInstance:sectionInstance]
    }
    def updateSaveSection(){
        println("params : "+params)
        def sectionInstance = CreditScoringQuestionSection.get(params.sectionId)
            sectionInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.code)
            sectionInstance.nameOfSection = params.sectionName ? params?.sectionName.toString() : ''
            sectionInstance.sectionPercentage = params.sectionPercentage ? params.sectionPercentage.toDouble() : 0.00D
            sectionInstance.updatedBy = UserMaster.get(session.user_id)
            sectionInstance.updatedDate = Branch.get(1).runDate
        sectionInstance.save(flush:true,failOnError: true)
        
        redirect(controller:"CreditScoring",action:"codeWithQuestionSectionDetails",id:sectionInstance.creditScoringCodeDescription.id)
    }
    def manageQuestionsUnderSection(){
        println("params: "+params)
        def sectionInstance = CreditScoringQuestionSection.get(params.id)
        def c = CreditScoringQuestions.createCriteria()
        def xSectionQuestions = c.list {
            
            and {
                eq("creditScoringQuestionSection", sectionInstance)
            }
            order("id", "asc")
        }
        [sectionInstance:sectionInstance,xSectionQuestions:xSectionQuestions]
        
    }
    def saveQuestionUnderSection(){
        println("================ saveQuestionUnderSection =============")
        println("params: "+params)
        def creditQuestionInstance = new CreditScoringQuestions()
            creditQuestionInstance.creditScoringQuestionSection = CreditScoringQuestionSection.get(params?.sectionId)
            creditQuestionInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params?.parentCodeDescription)
            creditQuestionInstance.questionNumberDescription = params?.numberWithDescription ? params?.numberWithDescription.toString(): ''
            creditQuestionInstance.choiceDescriptionA = params?.choiceDescriptionA ? params?.choiceDescriptionA.toString(): ''
            creditQuestionInstance.choiceDescriptionB = params?.choiceDescriptionB ? params?.choiceDescriptionB.toString(): ''
            creditQuestionInstance.choiceDescriptionC = params?.choiceDescriptionC ? params?.choiceDescriptionC.toString(): ''
            creditQuestionInstance.remarks = params?.remarks ? params?.remarks.toString(): ''
            creditQuestionInstance.status = ConfigItemStatus.get(2)
            creditQuestionInstance.createdBy = UserMaster.get(session.user_id)
            creditQuestionInstance.dateCreated = Branch.get(1).runDate
        creditQuestionInstance.save(flush:true,failOnError: true)
        
        redirect(controller: "CreditScoring",action: "manageQuestionsUnderSection", id:creditQuestionInstance.creditScoringQuestionSection.id)
    }
    def viewQuestionDetails(){
        println("============== viewQuestionDetails =============")
        println("params: "+params)
        def questionInstance = CreditScoringQuestions.get(params.id)
        [questionInstance:questionInstance]
            
    }
    def saveUpdateQuestionUnderSection(){
        println("============== saveUpdateQuestionUnderSection =============")
        println("params: "+params)
        
        def updateInstance = CreditScoringQuestions.get(params?.questionId.toInteger())
            updateInstance.questionNumberDescription = params?.numberWithDescription ? params?.numberWithDescription.toString(): ''
            updateInstance.choiceDescriptionA = params?.choiceDescriptionA ? params?.choiceDescriptionA.toString(): ''
            updateInstance.choiceDescriptionB = params?.choiceDescriptionB ? params?.choiceDescriptionB.toString(): ''
            updateInstance.choiceDescriptionC = params?.choiceDescriptionC ? params?.choiceDescriptionC.toString(): ''
            updateInstance.remarks = params?.remarks ? params?.remarks.toString(): ''
            updateInstance.status = ConfigItemStatus.get(2)
            updateInstance.updatedBy = UserMaster.get(session.user_id)
            updateInstance.updatedDate = Branch.get(1).runDate
        updateInstance.save(flush: true,failOnError:true)    
        flash.message = "Successfull"
        redirect(controller: "CreditScoring",action:"viewQuestionDetails", id:updateInstance.id)
    }
    def deleteQuestion(){
        println("============== saveUpdateQuestionUnderSection =============")
        println("params: "+params)
        
        def xSectionIdInstance = CreditScoringQuestions.get(params.questionId)
        def sql = new Sql(dataSource)
        def queryall1 = "delete from credit_scoring_questions where id = "+params.xquestionId
        def resultqueryall1 = sql.execute(queryall1)
        flash.message = "Question Successfully Deleted.."
        redirect(controller: "CreditScoring",action: "manageQuestionsUnderSection", id:xSectionIdInstance?.creditScoringQuestionSection?.id)
        
    }
    def createPreQualification(){
        println("params: "+params)
        def codeInstance = CreditScoringCodeDescription.get(params.id)
        [codeInstance:codeInstance]
    }
    def savePreQualification(){
        println("params: "+params)
        //Save Section
        def creditScoringQuestionSectionInstance = new CreditScoringPreQualification()
            creditScoringQuestionSectionInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.code)
            creditScoringQuestionSectionInstance.preQualificationItem = params.qualificationItem ? params?.qualificationItem.toString() : ''
            
            creditScoringQuestionSectionInstance.status = ConfigItemStatus.get(2)
            creditScoringQuestionSectionInstance.createdBy = UserMaster.get(session.user_id)
            creditScoringQuestionSectionInstance.dateCreated = Branch.get(1).runDate
            creditScoringQuestionSectionInstance.save(flush:true,failOnError: true)
            
            redirect(controller: "creditScoring",action: "codeWithQuestionSectionDetails", id:CreditScoringCodeDescription.get(params.code).id)
        
    }
    def updatePreQualification(){
        println("params : "+params)
        def preQualificationInstance = CreditScoringPreQualification.get(params.sectionId)
            println("preQualificationInstance: "+preQualificationInstance)
            preQualificationInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.parentCodeDescription)
            preQualificationInstance.preQualificationItem = params.qualificationItem ? params?.qualificationItem.toString() : ''
            preQualificationInstance.updatedBy = UserMaster.get(session.user_id)
            preQualificationInstance.updatedDate = Branch.get(1).runDate
        preQualificationInstance.save(flush:true,failOnError: true)
        
        redirect(controller:"CreditScoring",action:"codeWithQuestionSectionDetails",id:preQualificationInstance.creditScoringCodeDescription.id)
    
    }
    def createRatedList(){
        println("params: "+params)
        def codeInstance = CreditScoringCodeDescription.get(params.id)
        [codeInstance:codeInstance]
    }
    def saveRatedSection(){
        println("============ saveRatedSection ==========")
        println("params: "+params)
        
        def ratedInstance = new CreditScoringRated()
                ratedInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.code)
                ratedInstance.ratedName = params.ratedName
                ratedInstance.status = ConfigItemStatus.get(2)
                ratedInstance.createdBy = UserMaster.get(session.user_id)
                ratedInstance.dateCreated = Branch.get(1).runDate
            ratedInstance.save(flush: true, failOnError:true)
            
        redirect(action: "codeWithQuestionSectionDetails", controller: "creditScoring", id: ratedInstance.creditScoringCodeDescription.id)
    }
    def updateRated(){
        println("========= updateRated =========")
        println("params: "+params)
         def ratedInstance = CreditScoringRated.get(params.ratedId)
                ratedInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params.parentCodeDescription)
                ratedInstance.ratedName = params.ratedName ? params?.ratedName.toString() : ''
                ratedInstance.updatedBy = UserMaster.get(session.user_id)
                ratedInstance.updatedDate = Branch.get(1).runDate
            ratedInstance.save(flush: true, failOnError: true)
            
        redirect(action: "codeWithQuestionSectionDetails", controller: "creditScoring", id: ratedInstance.creditScoringCodeDescription.id)
    }
    def createRatedItemList(){
        println("params: "+params)
        def ratedInstance = CreditScoringRated.get(params.id)
        def c = CreditScoringRatedItems.createCriteria()
        def ratedItemsInstance = c.list {
            
            and {
                eq("creditScoringRated", ratedInstance)
            }
            order("id", "asc")
        }
        [ratedInstance:ratedInstance,ratedItemsInstance:ratedItemsInstance]
    }
    def saveRatedItems(){
        println("========= saveRatedItems =========")
        println("params: "+params)

        def creditScoringRatedItemInstance = new CreditScoringRatedItems()
            creditScoringRatedItemInstance.creditScoringCodeDescription = CreditScoringCodeDescription.get(params?.parentCodeDescription)
            creditScoringRatedItemInstance.creditScoringRated = CreditScoringRated.get(params?.ratedId)
            creditScoringRatedItemInstance.itemDescription = params?.ratedItem ? params?.ratedItem.toString(): ''

            creditScoringRatedItemInstance.status = ConfigItemStatus.get(2)
            creditScoringRatedItemInstance.createdBy = UserMaster.get(session.user_id)
            creditScoringRatedItemInstance.dateCreated = Branch.get(1).runDate
        creditScoringRatedItemInstance.save(flush:true,failOnError: true)
        
        redirect(controller: "CreditScoring",action: "createRatedItemList", id:creditScoringRatedItemInstance.creditScoringRated.id)
    }
    def saveUpdateRatedItems(){
        println("======= saveUpdateRatedItems ========")
        println("params: "+params)
        def creditScoringRatedItemInstance = CreditScoringRatedItems.get(params.ratedId)
            println("creditScoringRatedItemInstance: "+creditScoringRatedItemInstance)
            creditScoringRatedItemInstance.itemDescription = params?.ratedItem ? params?.ratedItem.toString(): ''

            creditScoringRatedItemInstance.status = ConfigItemStatus.get(2)
            creditScoringRatedItemInstance.updatedDate = Branch.get(1).runDate
            creditScoringRatedItemInstance.updatedBy = UserMaster.get(session.user_id)
        creditScoringRatedItemInstance.save(flush:true,failOnError: true)
        
        redirect(controller: "CreditScoring",action: "createRatedItemList", id:creditScoringRatedItemInstance.creditScoringRated.id)
    }
}
