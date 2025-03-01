package icbs.atm
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus
import static org.springframework.http.HttpStatus.*
import java.util.*
import java.text.SimpleDateFormat
import java.util.Date
import groovy.sql.Sql
import icbs.atm.*
import grails.transaction.Transactional
import icbs.atm.AtmTxn
import icbs.tellering.*
import icbs.tellering.TxnFile
import grails.converters.JSON

class ATMInterfaceController {

    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    def datasource
       
     def index(Integer max) {
        //def atmReq = AtmMsgRequest.list(sort: "dateReceived", order: "desc")
       // render (view:'/atmInterface/view',model:[atmReq:atmReq]);
        params.max = Math.min(max ?: 10, 100)
        println("params: "+params)
        /*if (params.sort == null) {  // default ordering
            params.sort = "id"
        }*/
        // def dateSearch = Date.parse('yyyy-MM-dd hh:mm:ss',params.query + ' 00:00:00')
        // def dateSearch1 = Date.parse('yyyy-MM-dd hh:mm:ss',params.query + ' 24:00:00')


         def ColumnName = "id"
         def ColumnOrderBy = "desc"
        if (params.query == null || params.query == "") {  // show all instances  
            //def atmTxnList = AtmTxn.list(params)
           // respond AtmTxn.list(params), model:[BranchInstanceCount: AtmTxn.count()]
            println("clickable sort column: "+params)
           if(params.sort==null){
                 ColumnName = "id"
                 ColumnOrderBy = "desc"
           }else{
                 ColumnName = params.sort
                 ColumnOrderBy = params.order
           }
           def atmTxnListInstance = AtmTxn.createCriteria().list(params) {
               order(ColumnName,ColumnOrderBy)
            }
            render (view:'/atmInterface/index',model:[atmTxnListInstance:atmTxnListInstance,BranchInstanceCount: atmTxnListInstance.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        }
        else{
          
             def atmTxnListInstance = AtmTxn.createCriteria().list(params) {


                or {
                    
                    ilike("atmCardNumber", "%${params.query}%")
                    ilike("mti", "%${params.query}%")
                    ilike("txnCode", "%${params.query}%")
                    ilike("txnRef", "%${params.query}%")
                    ilike("acct1", "%${params.query}%")
                    //between("txnDate", dateSearch, dateSearch1) 
                }
                order("id", "desc")
            }
            render (view:'/atmInterface/index',model:[atmTxnListInstance:atmTxnListInstance,BranchInstanceCount: atmTxnListInstance.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        }
       

       
    }
        
    

    def viewAtmInterface(){
        //def atmReq = AtmMsgRequest.list(sort: "dateReceived", order: "desc")
        render (view:'/atmInterface/view');
        
        println("Passed id from GSP: "+params.id)
        
        Long ids = new Long(params.id.toInteger())
        
        def c = AtmTxn.createCriteria()
        def AtmTxn = c.list {
            and {
                eq("id",ids)
            }
        } 
        //def atmTxnList = AtmTxn.list(params)
        println("RESULT : "+AtmTxn)
        respond AtmTxn
        
    }
        def viewAtmTxnFile(){
       
               
        
        println("Passed id for Txn file: "+params.id)
        
        Long ids = new Long(params.id.toInteger())
        
        def c = TxnFile.createCriteria()
        def TxnFile = c.list {
            and {
                eq("id",ids)
            }
        } 
        //def atmTxnList = AtmTxn.list(params)
        println("RESULT FOR TNX FILE: "+TxnFile)
        [aa:TxnFile]
        // render (view:'/atmInterface/viewAtmTxnFile',model:[TxnFile:TxnFile]);
         
    }
    def  viewAtmMsgRequest(Integer max){

        params.max = Math.min(max ?: 10, 100)
		
        println("params: "+params)
		
												  
        
        def ColumnName = "id"
        def ColumnOrderBy = "desc"
        if (params.query == null || params.query=="") {  // show all instances  
            //def atmTxnList = AtmTxn.list(params)
           // respond AtmTxn.list(params), model:[BranchInstanceCount: AtmTxn.count()]
            println("clickable sort column: "+params)
           if(params.sort==null){
                 ColumnName = "id"
                 ColumnOrderBy = "desc"
           }else{
                 ColumnName = params.sort
                 ColumnOrderBy = params.order
           }
            //def atmReqList = AtmMsgRequest.list(sort: "dateReceived", order: "desc")
            def atmReqList = AtmMsgRequest.createCriteria().list(params) {
                
                order("id", "desc")
            }
            render (view:'/atmInterface/viewAtmMsgRequest',model:[atmTxnListInstance:atmReqList,BranchInstanceCount: atmReqList.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        } else {
            def atmReqList = AtmMsgRequest.createCriteria().list(params) {
                or {
                    ilike("msgContent", "%${params.query}%")                
                }
                order("id", "desc")
            }
            render (view:'/atmInterface/viewAtmMsgRequest',model:[atmTxnListInstance:atmReqList,BranchInstanceCount: atmReqList.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        }     
																				
		 
    }
    def  viewAtmMsgResponse(Integer max){
        params.max = Math.min(max ?: 10, 100)
		
        println("params: "+params)
		
												  
        
        def ColumnName = "id"
        def ColumnOrderBy = "desc"
        if (params.query == null || params.query=="") {  // show all instances  
            //def atmTxnList = AtmTxn.list(params)
           // respond AtmTxn.list(params), model:[BranchInstanceCount: AtmTxn.count()]
            println("clickable sort column: "+params)
           if(params.sort==null){
                 ColumnName = "id"
                 ColumnOrderBy = "desc"
           }else{
                 ColumnName = params.sort
                 ColumnOrderBy = params.order
           }
            //def atmReqList = AtmMsgRequest.list(sort: "dateReceived", order: "desc")
            def atmRespList = AtmMsgResponse.createCriteria().list(params) {
                
                order("id", "desc")
            }
            render (view:'/atmInterface/viewAtmMsgResponse',model:[atmResponseListInstance:atmRespList,BranchInstanceCount: atmRespList.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        } else {
            def atmRespList = AtmMsgResponse.createCriteria().list(params) {
                or {
                    ilike("msgContent", "%${params.query}%")                
                }
                order("id", "desc")
            }
            render (view:'/atmInterface/viewAtmMsgResponse',model:[atmResponseListInstance:atmRespList,BranchInstanceCount: atmRespList.totalCount]);
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
            //respond AtmTxnList, model:[BranchInstanceCount: AtmTxnList.totalCount]
        }  
         
    }
    
   
    def atmTerminalView(){
        def atmTerminal = AtmTerminalMapping.list(sort: "terminalCode", order: "asc")
        render (view:'/atmInterface/atmTerminalView',model:[atmTerminal:atmTerminal]);       
    }
    def createAtmTerminal(){
        def atmTerminalInstance = new AtmTerminalMapping()
        respond atmTerminalInstance
    }
    
    def saveAtmTerminal(){
        println params
        println params.terminalCode
        println '++++++++++++++'
        def atmTerminalInstance = new AtmTerminalMapping(terminalCode:params.terminalCode, remarks:params.remarks,
            branch:Branch.get(params.branch.id.toInteger()), 
            terminalStatus:ConfigItemStatus.get(params.terminalStatus.toInteger()))
        
        if (!atmTerminalInstance.validate()) {
            flash.message = 'Errors in Create ATM Terminal |error'
            respond atmTerminalInstance.errors, view:'createAtmTerminal'
            return
        }
        atmTerminalInstance.save(flush:true,failOnError:true)
        
        redirect(controller: "ATMInterface", action: "show",id: atmTerminalInstance.id)  
    }
    
    def show() {
        println 'SHOW >>>>' 
        def atmTerminalInstance = AtmTerminalMapping.get(params.id)
        [atmTerminalInstance:atmTerminalInstance]
    }
    
    def deleteTerminal(AtmTerminalMapping atmTerminalInstance) {
        println 'DEL >>>>' + atmTerminalInstance
        atmTerminalInstance.terminalStatus = ConfigItemStatus.get(3)
        atmTerminalInstance.save(flush:true,failOnError:true)
        
        redirect(controller: "ATMInterface", action: "show",id: atmTerminalInstance.id)  
    }
    
    def editTerminal(AtmTerminalMapping atmTerminalInstance){
        println 'EDIT >>>>' + atmTerminalInstance
        render(view:"editTerminal", model:[atmTerminalInstance:atmTerminalInstance])
    }
    
    def updateTerminal(){
        println params
        println params.terminalCode
        println '++++++++++++++'
        println("params.atmTerminalId: "+params.atmTerminalId.toInteger())
        def atmTerminalInstance = AtmTerminalMapping.get(params.atmTerminalId.toInteger())
        atmTerminalInstance.terminalCode = params.terminalCode
        atmTerminalInstance.remarks = params.remarks
        atmTerminalInstance.branch = Branch.get(params.branch.id.toInteger())
        atmTerminalInstance.terminalStatus = ConfigItemStatus.get(params.terminalStatus.toInteger())
        atmTerminalInstance.save(flush: true,failOnError:true)
        
        /*
         
        def atmTerminalInstance = new AtmTerminalMapping(terminalCode:params.terminalCode, remarks:params.remarks,
            branch:Branch.get(params.branch.id.toInteger()), 
            terminalStatus:ConfigItemStatus.get(params.terminalStatus.toInteger()))
        
        if (!atmTerminalInstance.validate()) {
            flash.message = 'Errors in Create ATM Terminal |error'
            respond atmTerminalInstance.errors, view:'createAtmTerminal'
            return
        }
        atmTerminalInstance.save(flush:true,failOnError:true)
        */
        redirect(controller: "ATMInterface", action: "show",id: atmTerminalInstance.id)  
    }
    
    def atmTxnDetails(){
        // show atm transaction details
        println("params: "+params)
        def atmTxnDetalisInstance = AtmTxn.get(params.id)
        println("atmTxnDetalisInstance: "+atmTxnDetalisInstance)
        [atmTxnDetalisInstance:atmTxnDetalisInstance]
        
    }
    def showRequestDetails(){
        println("============ Show Request Details ===========")
        println("params: "+params)
        def atmRequestInstance = AtmMsgRequest.get(params.id)
        [atmRequestInstance:atmRequestInstance]
    }
    def showResponseDetails(){
        println("============ Show Request Details ===========")
        println("params: "+params)
        def atmResponseInstance = AtmMsgResponse.get(params.id)
        [atmResponseInstance:atmResponseInstance]
    }
    

}
