package icbs.audit

import org.codehaus.groovy.grails.web.util.WebUtils
import javax.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder
import grails.transaction.Transactional

import icbs.lov.AuditType
import icbs.admin.Module
import icbs.admin.UserMaster
import icbs.admin.Branch
import icbs.cif.Customer

@Transactional
class AuditLogService {
    static transactional = true

    def insert(String auditCode, String moduleCode, String description, String tableName, newDomainObj, oldDomainObj, String recordUrl, Long recordId) {
    	def webUtils = WebUtils.retrieveGrailsWebRequest()
    	def request = webUtils.getCurrentRequest()
    	def ipAddress = request.getRemoteAddr()
    	HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()
    	
    	def auditLog = new AuditLog()
    	auditLog.auditType = AuditType.findByCode(auditCode)
        println auditLog.auditType
        println 'module code' + moduleCode
    	auditLog.module = Module.findByCode(moduleCode)
       // println auditLog.module
        auditLog.description = description
        println description
        auditLog.tableName = tableName
        println tableName
        //if(newDomainObj)
        //    auditLog.recordId = newDomainObj.id
    	auditLog.date = new Date()
        auditLog.runDate = Branch.get(1).runDate
        
        println auditLog.runDate
    	auditLog.userMaster = UserMaster.get(session.user_id)
    	auditLog.ipAddress = ipAddress
        println auditLog.ipAddress
    	auditLog.recordUrl = recordUrl
        println auditLog.recordUrl
        auditLog.recordId = recordId
        println auditLog.recordId
        
        if (auditLog.hasErrors()) {
            //respond auditLog.errors, view:'create'
            println auditLog.errors
            return
        }
        
    	auditLog.save(flush:true, validateOnError:true)
        println auditLog

        // Log Details
        // this.logDetails(auditLog, newDomainObj, oldDomainObj)
    }
    
    def updateCustomerValues(Customer customer){
        HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()
        def dirtyProperties = customer.dirtyPropertyNames 
        for (name in dirtyProperties) {
            def originalValue = customer.getPersistentValue(name)
            def newValue = customer."${name}"
            if (newValue.toString() != originalValue.toString()){
                def auditValue = new AuditValue(dataTable:'customer',itemId:customer.id,
                    dataField:name, oldValue:originalValue.toString(), newValue:newValue.toString(),
                    dateStamp:new Date().toTimestamp(), user:UserMaster.get(session.user_id))
                auditValue.save(flush:true,failOnError:true)                
            }
        }
        for (contact in customer.contacts) {
            def dirtyContacts = contact.dirtyPropertyNames
            for (con in dirtyContacts){
                def originalValue = contact.getPersistentValue(con)
                def newValue = contact."${con}"
                if (newValue.toString() != originalValue.toString()){
                    def auditValue = new AuditValue(dataTable:'contact',itemId:contact.id,
                        dataField:con, oldValue:originalValue.toString(), newValue:newValue.toString(),
                        dateStamp:new Date().toTimestamp(), user:UserMaster.get(session.user_id))
                    auditValue.save(flush:true,failOnError:true)                
                }                
            }
        }
        for (address in customer.addresses) {
            def dirtyContacts = address.dirtyPropertyNames
            for (addr in dirtyContacts){
                def originalValue = address.getPersistentValue(addr)
                def newValue = address."${addr}"
                if (newValue.toString() != originalValue.toString()){
                    def auditValue = new AuditValue(dataTable:'address',itemId:address.id,
                        dataField:addr, oldValue:originalValue.toString(), newValue:newValue.toString(),
                        dateStamp:new Date().toTimestamp(), user:UserMaster.get(session.user_id))
                    auditValue.save(flush:true,failOnError:true)                
                }                
            }
        }
    }
}
