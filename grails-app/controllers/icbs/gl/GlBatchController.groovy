package icbs.gl


import icbs.admin.Branch
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartHttpServletRequest
import grails.converters.JSON
import grails.converters.deep.JSON
import grails.converters.*
import org.codehaus.groovy.grails.web.json.JSONObject
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import java.text.SimpleDateFormat
import java.text.DateFormat
import java.io.*;
import java.util.*;
import icbs.gl.GlBatchHdr
import icbs.gl.GlBatch
import icbs.loans.Loan
import icbs.lov.LoanAcctStatus
import icbs.deposit.Deposit
import icbs.lov.DepositStatus
import icbs.admin.UserMaster
import icbs.admin.Module
import icbs.lov.GlBatchHdrStatus
import icbs.gl.GlBatchVoucher
import icbs.gl.GlAttachment
import icbs.lov.ConfigItemStatus
import icbs.admin.Holiday
import groovy.sql.Sql							 


@Transactional(readOnly = true)
class GlBatchController {

    
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    
    def GlTransactionService
    def auditLogService
    def jasperService
    def RoleModuleService
    def dataSource
    def index(Integer max) {
        session["glattachment"] = ""
        session["postedOnOff"]="postedOff"
        def user = UserMaster.get(session.user_id)
        //posted transaction query 
        def postedTransaction =  params.showview.toString()
        println("postedTransaction: "+postedTransaction)
        //posteddddddd

        // ========================== 							 
        params.max = Math.min(max ?: 10, 100)
        if(params.offset==null){
            params.offset=0
            println("if condition")					   
        }
        if (params.query == null || params.query == "") {
            println("params: "+params)						  
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    eq("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                    }
                   
                    if (!user.branch.dataCenter) {
                        eq("branch",user.branch) 
                    }                
                }
		order("id", "asc")				  
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }else{
                postedOnOff = "postedOff"
                session["postedOnOff"]="postedOff"
            }								
            println("posted condition: "+postedTransaction)
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff: postedOnOff,postedTransaction:postedTransaction]
            return
        }
        else{
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    eq("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                    }
                    //eq("branch",user.branch)
                    ilike("batchName", "%${params.query}%")
                    if (!user.branch.dataCenter) {
                        eq("branch",user.branch) 
                    }                      
                }
                order("id", "asc")				  
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }else{
                postedOnOff = "postedOff"
                session["postedOnOff"]="postedOff"
            }
            
            println("posted condition: "+postedTransaction)
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff:postedOnOff,postedTransaction:postedTransaction]

            return
        }
        return
    }
    def viewMyBatchTransactions(Integer max){
        println("============= view My Batch Transactions =============")
        session["glattachment"] = ""
        session["postedOnOff"]="postedOff"
        def user = UserMaster.get(session.user_id)
        //posted transaction query 
        def postedTransaction =  params.showview.toString()
        println("postedTransaction: "+postedTransaction)
        //posteddddddd

        // ========================== 							 
        params.max = Math.min(max ?: 10, 100)
        if(params.offset==null){
            params.offset=0
            println("if condition")					   
        }
        if (params.query == null || params.query == "") {
            println("params: "+params)						  
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    eq("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                        
                    }
                    eq("createdBy", user)
                    /*if (!user.branch.dataCenter) {
                    eq("branch",user.branch) 
                    }*/                
                }
		order("id", "asc")				  
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }else{
                postedOnOff = "postedOff"
                session["postedOnOff"]="postedOff"
            }								
            println("posted condition: "+postedTransaction)
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff: postedOnOff,postedTransaction:postedTransaction]
            return
        }
        else{
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    eq("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                    }
                    //eq("branch",user.branch)
                    eq("branch",user.branch) 
                    ilike("batchName", "%${params.query}%")
                    /*if (!user.branch.dataCenter) {
                    eq("branch",user.branch) 
                    }*/                      
                }
                order("id", "asc")				  
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }else{
                postedOnOff = "postedOff"
                session["postedOnOff"]="postedOff"
            }
            
            println("posted condition: "+postedTransaction)
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff:postedOnOff,postedTransaction:postedTransaction]

            return
        }
        return
    }

    def prevDaysArchive(Integer max){
        session["glattachment"] = ""
        session["postedOnOff"]="postedOff"
        def user = UserMaster.get(session.user_id)
        //posted transaction query 
        //def postedTransaction =  params.showview.toString()
        def postedTransaction =  "posted"
        println("postedTransaction: "+postedTransaction)
        //posteddddddd

        // ========================== 							 
        params.max = Math.min(max ?: 10, 100)
        if(params.offset==null){
            params.offset=0
            println("if condition")					   
        }
        if (params.query == null) {
            println("params: "+params)						  
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    ne("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                    }
                   
                    if (!user.branch.dataCenter) {
                        eq("branch",user.branch) 
                    }                
                }
                order("id", "asc")
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }								
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff: postedOnOff]
            return
        }
        else{
            def btList = GlBatchHdr.createCriteria().list(params) {
                and {
                    ne("txnDate", Branch.get(1).runDate)
                    if(postedTransaction=="posted") {
                        println("haha")
                        eq("status", GlBatchHdrStatus.get(3))
                        
                    }else{
                        ne("status", GlBatchHdrStatus.get(3))
                        ne("status", GlBatchHdrStatus.get(4))
                    }
                    eq("branch",user.branch)
                    ilike("batchName", "%${params.query}%")
                    if (!user.branch.dataCenter) {
                        eq("branch",user.branch) 
                    }                      
                }
                order("id", "asc")
            }            
            def postedOnOff = ""
            if(postedTransaction=="posted"){
                postedOnOff = "postedOn"
                session["postedOnOff"]="postedOn"
            }else{
                postedOnOff = "postedOff"
                session["postedOnOff"]="postedOff"
            }
            respond btList, model:[params:params,GlBatchHdrInstanceCount:  btList.totalCount,postedOnOff:postedOnOff]
            return
        }
        return    
    }
    def show(GlBatch glBatchInstance) {
        respond glBatchInstance
    }

    def create() {
        session["glattachment"] = []
        println("create action...")
        session["postedOnOff"]="postedOff"
        def createModule = Module.findByCode('GEN00301')
        def allowCreate = RoleModuleService.canPerform(createModule)
        if (!allowCreate) {
            // not allowed to create
            flash.error = 'User not allowed to create batch'
            redirect(action:"index")
            return            
        }
        respond new GlBatch(params)
    }

    @Transactional
    def save(GlBatch glBatchInstance) {

        if (glBatchInstance == null) {
            notFound()
            return
        }

        if (glBatchInstance.hasErrors()) {
            respond glBatchInstance.errors, view:'create'
            return
        }
        
        glBatchInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'glBatch.label', default: 'GlBatch'), glBatchInstance.id])
                redirect glBatchInstance
            }
            '*' { respond glBatchInstance, [status: CREATED] }
        }
    }
    def batchDetails(GlBatchHdr glBatchHdrInstance){
        println("glBatchHdrInstance: "+glBatchHdrInstance)
        def c = GlBatch.createCriteria()
        def results = c.list {
            eq("batchId", glBatchHdrInstance.batchId.toString())
            order("id", "asc")
        }
        def attachmentInstance
        def c1 = GlAttachment.createCriteria()
        def resultsAttachment = c1.list {
            eq("batchId",glBatchHdrInstance.batchId.toString())
            order("id", "desc")
        }
        println("results: "+results)
        
        [glBatchHdrInstance:glBatchHdrInstance,batchTransactionInstance:results,batchAttachmentInstance:resultsAttachment]
    }
    def edit(GlBatchHdr glBatchHdrInstance) {
        println("boomssssssssssssssss: "+glBatchHdrInstance.batchId)
        def postedTransaction =  params.showview.toString()
        println("postedTransaction: "+postedTransaction)
        if(postedTransaction=="posted"){
            
            def attachmentInstance
            def c = GlAttachment.createCriteria()
            def results = c.list {

                eq("batchId",glBatchHdrInstance.batchId.toString())
                    
            }
            println("results: "+results)
            session["glattachment"] = results
            session["glattachmentcondtion"] = "edit"
            session["postedOnOff"] = "postedOn"

            println(session["glattachmentcondtion"])
            //
            def editModule = Module.findByCode('GEN00301')
            def allowEdit = RoleModuleService.canPerform(editModule)
            if (!allowEdit) {
                // not allowed to create
                flash.error = 'Cannot edit batch already posted/cancelled'
                redirect(action:"index")
                return            
            }            
            respond glBatchHdrInstance
            
        }else{
        
            if (glBatchHdrInstance.status == GlBatchHdrStatus.get(3) || glBatchHdrInstance.status == GlBatchHdrStatus.get(4)) {
                flash.error = 'Cannot edit batch already posted/cancelled'
                redirect(action:"index")
                return
            } else {
                // get all attachment with the same batch id

                def attachmentInstance
                def c = GlAttachment.createCriteria()
                def results = c.list {

                    eq("batchId",glBatchHdrInstance.batchId.toString())
                    
                }
                println("results: "+results)
                session["glattachment"] = results
                session["glattachmentcondtion"] = "edit"
                session["postedOnOff"] = "postedOff"

                println(session["glattachmentcondtion"])
                //
                def editModule = Module.findByCode('GEN00301')
                def allowEdit = RoleModuleService.canPerform(editModule)
                if (!allowEdit) {
                    // not allowed to create
                    flash.error = 'User not allowed to edit batch'
                    redirect(action:"index")
                    return            
                }            
                respond glBatchHdrInstance
            }            
        } 

    }
    def glBatchApproval(GlBatchHdr glBatchHdrInstance) {
        try {    
            //println"asdf "+session["jrxmlTcId"]
            println ':::' + params
            params._name = "GL_BATCH_APPROVE_REPORT"
            params._format ="PDF"//required caps
            params._file ="GL_BATCHAPPROVEREPORT.jasper" //jasper file name
            params.id=  params.bId.toInteger()
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
    
    def printGlBatch(GlBatchHdr glBatchHdrInstance) {
        try {         
            println params?.id 
            def hdrIdNo = params?.id.toInteger()
            params._name = "GL_Batch_Report"
            params._format ="PDF"//required caps
            params._file ="GL_BATCH_REPORT_NOLOGO.jasper" //jasper file name
            params?.Bid = hdrIdNo
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
    def printGlBatchVoucher() {
        try {    
            println ("pumasok sa print")   
            println params?.id 
            def hdrIdNo = params?.id.toInteger()
            params._name = "GL_Batch_Report"
            params._format ="PDF"//required caps
            params._file ="GL_BATCH_REPORT_VOUCHER.jasper" //jasper file name
            params?.Bid = hdrIdNo
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

    @Transactional
    def update(GlBatch glBatchInstance) {
        if (glBatchInstance == null) {
            notFound()
            return
        }

        if (glBatchInstance.hasErrors()) {
            respond glBatchInstance.errors, view:'edit'
            return
        }

        glBatchInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'GlBatch.label', default: 'GlBatch'), glBatchInstance.id])
                redirect glBatchInstance
            }
            '*'{ respond glBatchInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(GlBatch glBatchInstance) {

        if (glBatchInstance == null) {
            notFound()
            return
        }

        glBatchInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'GlBatch.label', default: 'GlBatch'), glBatchInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'glBatch.label', default: 'GlBatch'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    @Transactional
    def processBatchAjax () { 
        
        def batch = GlBatch.findAllByBatchId(params?.batchId)
        println "Params here:"+params
        println "Batch Here:"+batch
        //println result
        
        // test batch total before running
        def batchHdr = GlBatchHdr.findByBatchId(params?.batchId)
        println("batch: "+batch)
        if (batch){
            println("JM print codess")
            
            def totDr = 0.00D
            def totCr = 0.00D
            for (glb in batch){
                println("glb.debit: "+glb.debit)
                println("glb.credit: "+glb.credit)
                if (glb.debit){
                    totDr += glb.debit
                }
                if (glb.credit){
                    totCr += glb.credit
                }  

            }
            if (totDr.round(2) != totCr.round(2)){
                render (contentType: "application/json") 
                {
                    status = "1"
                }
                println "hdr:1:status:1"
                redirect(action:"index")    
                return
            }
        } else {
            // empty batch nothing to run
            render (contentType: "application/json") 
            {
                status = "1"
            }
            println "hdr:1:status:1"
            redirect(action:"index")    
            return        
        }
        println "Batch hdr and batchid here:"+batchHdr.batchId
        println "Batch hdr status:"+batchHdr.status
        
        if (batchHdr.status == GlBatchHdrStatus.get(1)) {
            
            render (contentType: "application/json") 
            {
                status = "1"
            }
            println "hdr:1:status:1"
            redirect(action:"batchDetails" ,id: batchHdr.id, params: [id: batchHdr.id])
        } else if (batchHdr.status == GlBatchHdrStatus.get(3)) {        
            render (contentType: "application/json") 
            {
                status = "3"
            }
            println "hdr:3:status:3"
            redirect(action:"batchDetails" ,id: batchHdr.id, params: [id: batchHdr.id]) 
        } else if (batchHdr.status == GlBatchHdrStatus.get(4)) {        
            render (contentType: "application/json") 
            {
                status = "4"
            }
            println "hdr:4:status:4"
            redirect(action:"batchDetails" ,id: batchHdr.id, params: [id: batchHdr.id])  

        }  else {
            //Parse the results 
            batch.each {
            
                def batchType = it.batchType
                println "IT here:"+it
                println "batch type here:"+batchType
                println "Datas here:"+it
                println "Account:"+it.account
                println "Amount:"+it.amount
                println "id:"+it.id.toLong()
                println "User:"+UserMaster.read(session.user_id)
                //it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id)


                //Debit Deposit Account
                if(batchType == "1" ) {
                    GlTransactionService.debitDepositAccount(it.id.toLong(), it.account, it.amount, it.particulars, it.batchId, UserMaster.read(session.user_id))
                }
                //Credit Deposit Account
                else if (batchType == "2") {
                    //GlTransactionService.creditDepositAccount(it.id.toLong(), it.account, it.amount, it.particulars, it.batchId, UserMaster.read(session.user_id))
                    GlTransactionService.creditDepositAccount(it.id.toLong(), it.account, it.amount, it.particulars, it.batchId, UserMaster.read(session.user_id))
                }
                //Verify
                else if (batchType == "3") {
                    GlTransactionService.depositAcctIcc(it.id.toLong(), it.account, it.amount, it.checkNo ,UserMaster.read(session.user_id))
                }
                //Debit Loan Account
                else if (batchType == "4") {
                    //def debitLoanAccount (String loanAcctNo, Double amount, Double principal, Double interest, Double penalty, Double serviceCharge)
                    GlTransactionService.debitLoanAccount(it.id.toLong(), it.account, it.amount, it.particulars, it.batchId, UserMaster.read(session.user_id))
                }
                // Credit Loan Account (Not Specified)
                else if (batchType == "5" ) {
                    GlTransactionService.creditLoanAccount(it.id.toLong(), it.account, it.amount, it.principal, it.interest, it.penalty, it.serviceCharge, it.particulars, it.batchId, UserMaster.read(session.user_id))
                }
                // Credit Loan Specified
                else if (batchType == "6") {
                    GlTransactionService.creditLoanAccount(it.id.toLong(), it.account, it.amount, it.principal, it.interest, it.penalty, it.serviceCharge, it.particulars, it.batchId, UserMaster.read(session.user_id))
                }
                //Debit GL Account
                else if (batchType == "7") {
                    GlTransactionService.debitGlAccount(it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id))
                } else if (batchType == "8") {
                    // credit GL Account
                    GlTransactionService.creditGlAccount(it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id))                    
                }
                //Debit AP GL Account
                else if (batchType == "9") {
                    println "pasok sa 9"
                    GlTransactionService.debitAPGlAccount(it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id))
                }
                //Credit AP GL Account
                else if (batchType == "10") {
                    println "pasok sa 10"
                    GlTransactionService.creditAPGlAccount(it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id))
                }
                else {
                    // moved to batchType 8
                    // GlTransactionService.creditGlAccount(it.account, it.amount, it.id.toLong(),UserMaster.read(session.user_id))
                }
                println "End of else"
                println "Go to next loop"
                //GlTransactionService.saveBatchEntry(it)
            }
            println(batchHdr.id)
            println(batchHdr.valueDate)
            // update batch header
            batchHdr.status = GlBatchHdrStatus.get(3)
            batchHdr.postedBy = UserMaster.get(session.user_id)
            batchHdr.isLocked = true
            batchHdr.save(flush:true)
            
            auditLogService.insert('140', 'GEN00700', 'Post GL Batch '+params?.bId, 'glBatchHdr', null, null, null, batchHdr.id)
            //render ""
            redirect(action:"batchDetails" ,id: batchHdr.id, params: [id: batchHdr.id])
        
            return            
        }       
    }
    
    @Transactional
    def getGLAcctByBranch () {
        
        def glAccounts = GlAccount.findAllByBranch(Branch.get(params?.branch_id))
        
        render glAccounts as JSON
    
    }

    @Transactional
    def getLoanAcctByBranch () {
        
        def loanAccounts = Loan.findAllByBranch(Branch.get(params?.branch_id))
        
        def loans = new JsonBuilder()

        loans.message {
            loanAccounts.each {
                accountNo it.accountNo
            }
        }
        
        render loans as JSON
    
    }

    @Transactional
    def getDepositAcctByBranch () {

        def depositAccounts = Deposit.findAllByBranch(Branch.get(params?.branch_id))
        
        render depositAccounts as JSON
    
    }

    @Transactional
    def saveGLBatchTransactions () {
        println(" ================= Save Gl Batch Transactions =================")
        println("params: "+params)
        def slurper = new JsonSlurper()
        def result = slurper.parseText(params?.transactions) 
        println("result: "+result)
        def newLineNumber = 1;
        def newpadZeroNumber = '0000'
        result.each {  
            //Save each transaction as a seperate entry
            def theNewBuildLineNumber = newpadZeroNumber+""+newLineNumber
            GlTransactionService.saveBatchEntry(it,theNewBuildLineNumber)
            newLineNumber = newLineNumber + 1
        }
        
        
        result = slurper.parseText(params?.batchDetails) 
        println("params?.batchDetails: "+params?.batchDetails)
        println("xresult: "+result)
        
        GlTransactionService.saveBatchHeader(result)
        
        //saving gl_attachment =========================
        println("Session size: "+session["glattachment"].size())
        if(session["glattachment"].size() < 1 || session["glattachment"] == ""){
            
            println("Batch with no attachment")
            
        }else{
            
            println("Batch with Attachment")
            println("session: "+session["glattachment"])
            
            session["glattachment"].eachWithIndex { attachmentItem , i ->
                println "attachmentItem: "+attachmentItem.filename
                attachmentItem.save(flush: true)
                println("Attachment saved comletety...")
            };
           
        }
        //==============================================
        def batchDate = Date.parse("yyyy-MM-dd HH:mm:ss", dateconvertwithouttime(result?.valueDate + " 00:00:00"))
        println("valueDate : "+ batchDate)																										  
        def glbh = GlBatchHdr.findByBatchId(result?.batchId)  
        glbh.valueDate = batchDate						  
        glbh.createdBy = UserMaster.get(session.user_id)
        glbh.save(failOnError:true, flush:true) 
        
        render ""
        
        return

    }

    @Transactional
    def getBatchByBatchIdAjax () {

        //def batch = GlBatch.findAllByBatchId(params?.batchId,[sort: "lineNo", order: "asc"])
        def c = GlBatch.createCriteria()
        def batch = c.list {
            and{
                eq("batchId",params?.batchId)
            }
            
            order("id", "asc")
            
        }
        
        render batch as JSON
                
        return 
    }

    @Transactional
    def getBatchDetailsAjax () {
        
        def batchDetails = GlBatchHdr.findByBatchId(params?.batchId)
        
        render(contentType: 'text/json') {[
            'batchDetails' : batchDetails
            ]}
        
        return

    }

    @Transactional
    def updateBatchGLTransactions () {
        println("updateBatchGlTransactions....")
        
        
        def slurper = new JsonSlurper() 
        GlTransactionService.updateBatchHeader(params?.batchId, slurper.parseText(params?.batchDetails))

        GlTransactionService.deleteAllBatchEntries(params?.batchId) 
        
        def result = slurper.parseText(params?.transactions)
        def newLineNumber = 1;
        def newpadZeroNumber = '0000'
        result.each {  
            //Save each transaction as a seperate entry
            def theNewBuildLineNumber = newpadZeroNumber+""+newLineNumber
            GlTransactionService.saveBatchEntry(it,theNewBuildLineNumber)
            newLineNumber = newLineNumber + 1
        }
        
        def sql = new Sql(dataSource)
        def recheckTotalDebitCredit = "select round(sum(credit),2) as totalcredit,round(sum(debit),2) as totaldebit from gl_batch where batch_id = '${params.batchId}'"
        def resultqueryall = sql.rows(recheckTotalDebitCredit)
        def updtTotalCredit = 0.00D
        def updtTotalDebit = 0.00D
        Boolean isTransactionsBalance = false
        updtTotalCredit = resultqueryall.totalcredit[0]
        updtTotalDebit = resultqueryall.totaldebit[0]
        if(updtTotalCredit == updtTotalDebit){
            println("balance transactions")
            isTransactionsBalance = true
        }
        def p = GlBatchHdr.findByBatchId(params?.batchId)
        p.batchId = params.batchId
        p.totalDebit = updtTotalDebit
        p.totalCredit = updtTotalCredit
        p.isBalanced = isTransactionsBalance
        p.save(flush:true, failOnError:true)
        //saving gl_attachment =========================
        println("Session size: "+session["glattachment"].size())
        if(session["glattachment"].size() < 1 || session["glattachment"] == ""){
            
            println("Batch with no attachment")
            
        }else{
            
            println("Batch with Attachment")
            println("session: "+session["glattachment"])
            
            session["glattachment"].eachWithIndex { attachmentItem , i ->
                println "attachmentItem: "+attachmentItem.filename
                attachmentItem.save(flush: true)
                println("Attachment saved comletety...")
            };
           
        }

        render ""

        return
    }
    
    // approve batch
    @Transactional
    def approve() {
        println params
        boolean batchError = false        
        def glb = GlBatchHdr.findByBatchId(params?.bId)      
        
        def batch = GlBatch.findAllByBatchId(glb.batchId)
        def approveModule = Module.findByCode('GEN00303')
        def allowApprove = RoleModuleService.canPerform(approveModule)
        
        for (b in batch) {
            if (b.lineStatus > '') {
                batchError = true
            }
        }
        if (batchError) {
            flash.error = 'GL Batch lines with error'
        } else if (!allowApprove) {
            // not allowed
            flash.error = 'User not allowed to approved!'
        } else if (glb.totalDebit != glb.totalCredit) {
            flash.error = 'GL Batch not balanced'
        } else if (glb.valueDate > Branch.get(1).runDate) {
            flash.error = 'GL Batch Value date later than system date'
        } else if (glb.branch != UserMaster.get(session.user_id).branch) {
            if (!UserMaster.get(session.user_id).branch.dataCenter) {
                flash.error = 'GL Batch Branch must match user branch'  
            } else {
                println("batch approve else 1 condition")
                glb.status = GlBatchHdrStatus.get(2)
                glb.approvedBy = UserMaster.get(session.user_id)
//                glb.valueDate = params.valueDate
                println("una" + params.valueDate)
                println("una" + glb.valueDate)
                glb.txnDate = Branch.get(1).runDate
                glb.save(failOnError:true, flush:true)

                auditLogService.insert('140', 'GEN00700', 'Approve GL Batch '+params?.bId, 'glBatchHdr', null, null, null, glb.id)
                flash.message = 'Batch Approved |success'                
            }           
        }  else {
            println("batch approve else 2 condition")
            glb.status = GlBatchHdrStatus.get(2)
            glb.approvedBy = UserMaster.get(session.user_id)
//            glb.valueDate =  params.valueDate
            println("pangalawa" + params.valueDate)
            println("pangalawa" + glb.valueDate)
            glb.txnDate = Branch.get(1).runDate
            glb.save(failOnError:true, flush:true)
            
            auditLogService.insert('140', 'GEN00700', 'Approve GL Batch '+params?.bId, 'glBatchHdr', null, null, null, glb.id)
            flash.message = 'Batch Approved |success|alert'
        }
        
        //redirect action: 'index'
        def glBatchInstance = batch
        def glBatchHdrInstance = glb
        render(view: "approveBatch", model: [glBatchInstance: glBatchInstance, glBatchHdrInstance: glBatchHdrInstance])
        return
    }

    //date convertion
    public def dateconvertwithouttime(String xxdate){
                
        def functiondate
        println xxdate
        DateFormat yinputDF  = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dat3 = yinputDF.parse(xxdate)
        Calendar ynow = Calendar.getInstance();
        ynow.setTime(dat3);
        int years = ynow.get(Calendar.YEAR);
        int months = ynow.get(Calendar.MONTH) + 1; // Note: zero based!
        int days = ynow.get(Calendar.DAY_OF_MONTH);
                
        // functiontime = years + "-"+ months +"-"+days + " " + hours +":"+ minutes + ":00";
        functiondate = years + "-"+ months +"-"+ days  + " 00:00:00"
        return functiondate
        
    }					 
    // print batch details
    def print() {
        try {
            params._name = "GL Batch Report"
            params._format ="PDF"//required caps
            params._file ="GlBatchReport.jasper" //eto ung pangalang ng jasper file
            params.id = params?.bId
            //params.txn_type=1
            //params.acct_id=1
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
            //redirect, etc
        }
    }
    def voucherDetailsCheck(){
    }
    
   
    @Transactional
    def voucherAddDetailsAction(){
        println("params: "+params)
        def sqlsss = new Sql(dataSource)
        //params.glbatchId = batchHdr
        def appr = params.approved_by
        def checkNo = params.check_no
        def batchhdr = params.glbatchId.toBigInteger()
        def payie = params.payee
        def receive = params.received_by
        
        println("Approove: "+appr)
        println("checkNo: "+checkNo)
        println("batch header: "+batchhdr)
        println("payee: "+payie)
        println("receive: "+receive)
        
        def saveGlBatchVoucher = new GlBatchVoucher()
        saveGlBatchVoucher.approvedBy = appr
        saveGlBatchVoucher.checkNo = checkNo
        saveGlBatchVoucher.payee = payie
        saveGlBatchVoucher.receivedBy = receive
        saveGlBatchVoucher.GlBatchHdr = GlBatchHdr.get(batchhdr)
        saveGlBatchVoucher.save(flush:true)
        def msgcontrol = "CodeAdd"
        if (saveGlBatchVoucher){
            redirect(action: "showVoucherDetails",params: [Bid: batchhdr,xCode:msgcontrol])
        }else{
            println("Failed to add")
        }
    }
    def showVoucherDetails(){
        def sqlsssd = new Sql(dataSource)
        println("paramsSome"+params.someValue)
        println("paramsBID :"+params.Bid)
        def bchhdr
        def updateshowconfirm=""
        if(params.someValue==null){
            bchhdr = params.Bid.toBigInteger()
             

            if(params.xCode=="CodeAdd"){
                updateshowconfirm ="showconfirmadd"
                     
            }else if(params.xCode=="updatevoucher"){
                updateshowconfirm ="showconfirmupdate"
            }
            else{
                updateshowconfirm ="noshow"
            }
        }
        else{
            println("pasok shere")
            bchhdr = params.someValue.toBigInteger()
            updateshowconfirm = "noshow"
        }
        println("updateshowconfirm: "+updateshowconfirm)
        
        
        def query1 = "select * from gl_batch_voucher where gl_batch_hdr_id="+bchhdr
        def resultquery = sqlsssd.rows(query1)
        [dataList:resultquery,updateshowconfirm2:updateshowconfirm]
        
    }
    def updatevoucher(){
        println("parameter: "+params)
        println("params: "+params)
        def GlBatchVoucherssList = GlBatchVoucher.get(params.idvoucher)
        [GlBatchVoucherssList:GlBatchVoucherssList] 
       
    }
    
    @Transactional
    def updatevoucherAddDetailsAction(){
        println("params from form: "+params)
        
        println("updating GL Voucher Details ")
        println("parameters ready: ")
        
        
        def appr = params.approved_by
        def checkNo = params.check_no
        def batchhdr = params.glbatchId.toBigInteger()
        def payie = params.payee
        def receive = params.received_by
        def GlBatchVoucherssList = GlBatchVoucher.get(params.voucherid)
        GlBatchVoucherssList.approvedBy = appr
        GlBatchVoucherssList.checkNo = checkNo
        GlBatchVoucherssList.payee = payie
        GlBatchVoucherssList.receivedBy = receive
        GlBatchVoucherssList.save(flush:true)
        def msgcontrol ="updatevoucher"
        if (GlBatchVoucherssList){
            redirect(action: "showVoucherDetails",params: [Bid: batchhdr,xCode:msgcontrol])
        }else{
            println("Failes to add")
        }   
        
        
        
    }    
	
    @Transactional
    def addAttachment(){
        
        def filename
        println("hahhaa")
        def filedata
        def batchId
        def reference
        def particulars
        def attachedBy
        def branch
        def status
      
             
        
       

        println("params: "+params)
        println("params id: "+params.idbatch)
        println("params file: "+params.file)
        println("params reference: "+params.attreference)
        println("params particular: "+params.attparticular)
        
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
            attchhmnt = new GlAttachment(filename:dfilename,filedata:file.getBytes(), reference:params.attreference,particulars:params.attparticular, batchId:params.idbatch,attachedBy:userid,branch:branchid,status:ConfigItemStatus.get(2))
            
        }
        def attchmnts
            
        if (session["glattachment"]) {
            attchmnts = session["glattachment"]
        } else {
            attchmnts = []
        }        
        attchmnts.add(attchhmnt)
        session["glattachment"] = attchmnts
        session["glattachmentcondtion"] = "upload"
        println("size of the session array: "+session["glattachment"].size())
        println("rendering...")
        def attachmentInstance = session["glattachment"]
        render(template:"batch_attachment") as JSON
      
    }
    def removeAttachment(){
        
        def Attachmentsessionid = params.id
        def id = params?.id?.toInteger()
        session["glattachment"].remove(id)
        render(template:"batch_attachment") as JSON
    }
    
    def downloadAttachment(){
        
        def id = params.id.toLong()
        println("id id id:"+id)
        println("GlAttachment: "+GlAttachment.get(id))
        GlAttachment documentInstance = GlAttachment.get(id)
        if ( documentInstance == null) {
            flash.message = "Document not found."
            redirect (action:'list')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")

            def outputStream = response.getOutputStream()
            outputStream << documentInstance.filedata
            outputStream.flush()
            outputStream.close()
        }
       
        
    }
    
    def showPostedTransactionList(){
        println("Show oisted transaction list....")
    }
    @Transactional
    def cancelBatchAjax(){
        println("params: "+params)
        def batchHdrInstance = GlBatchHdr.get(params.id)
        batchHdrInstance.status = GlBatchHdrStatus.get(4)
        batchHdrInstance.save(flush: true)
        def sqlsss = new Sql(dataSource)
        def query1 = "select * from gl_batch_hdr limit 1"
        def resultquery = sqlsss.rows(query1)        
        render resultquery as JSON
    }
}
