package icbs.audit



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import icbs.lov.AuditType

@Transactional(readOnly = true)
class UserLogController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        if(params.offset==null){
            params.offset=0
        }
        if (params.query == null) {
            def AuditLogList = AuditLog.createCriteria().list (params) {
                or {
                    eq("auditType", AuditType.get(1))
                    eq("auditType", AuditType.get(2))
                    eq("auditType", AuditType.get(16))
                }
                order("date", "desc")
            }
            respond AuditLogList, model:[params:params,AuditLogInstanceCount: AuditLogList.totalCount]
        }
        else{
            def AuditLogList = AuditLog.createCriteria().list (params) {
                and {
                    ilike("description", "%${params.query}%")
                }            
            }
            respond AuditLogList, model:[params:params,AuditLogInstanceCount: AuditLogList.totalCount]
        }
        return
    }
    
    def changeLog(Integer max){
        params.max = Math.min(max ?: 10, 100)
        def valueList
        if(params.offset==null){
            params.offset=0
        }
        if (params.query == null) {
            valueList = AuditValue.createCriteria().list (params) {
                order("dateStamp", "desc")
            }   
            println '1'
        } else {
            valueList = AuditValue.createCriteria().list (params) {
                and {
                    or {
                        ilike("dataTable", "%${params.query}%")
                        ilike("dataField", "%${params.query}%")
                        ilike("oldValue", "%${params.query}%")
                        ilike("newValue", "%${params.query}%")
                    }   
                }
                order("dateStamp", "desc")
            } 
            println '2'
        }  
        respond valueList, model:[values:valueList, params:params,auditLogInstanceCount: valueList.totalCount]
        return        
    }
    // def show(AuditLog auditLogInstance) {
    //     respond auditLogInstance
    // }

    // protected void notFound() {
    //     request.withFormat {
    //         form multipartForm {
    //             flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), params.id])
    //             redirect action: "index", method: "GET"
    //         }
    //         '*'{ render status: NOT_FOUND }
    //     }
    // }
}
