package icbs.admin

import grails.transaction.Transactional
import javax.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder
import org.hibernate.criterion.CriteriaSpecification
import org.hibernate.FetchMode

import icbs.lov.ConfigItemStatus
import icbs.lov.PolicyAction
import icbs.admin.UserMaster
import groovy.sql.Sql

import icbs.admin.Policy
@Transactional
class PolicyService {
    def dataSource

    def isAllowed(String policyTemplateCode) {
    	HttpSession session = RequestContextHolder.currentRequestAttributes().getSession();

    	def isAllowed = false

    	def roles = UserRole.findAllByUserMasterAndConfigItemStatus(UserMaster.get(session.user_id), ConfigItemStatus.get(2))

        def policyRoleCount = 0

    	roles.each {
            def role = it.role
            def policyRole = PolicyRole.createCriteria().get() {
                createAlias('policy', 'p', CriteriaSpecification.LEFT_JOIN)
                and {
                    eq("role", role)
                    eq("p.policyTemplate", PolicyTemplate.findByCode(policyTemplateCode))
                }
            }
            println("policyRole: "+policyRole)
            if(policyRole) {
                policyRoleCount++
                println("policyRole.policy.policyAction: "+policyRole.policy.policyAction)
                println("policyRole.policy.configItemStatus.id: "+policyRole.policy.configItemStatus.id)
                
                if(policyRole.policy.policyAction == PolicyAction.get(1)) {
                    println("pasok sa condition")
                    isAllowed = true
                }
                
            }
    	}

        // Check if approver
        roles.each {
            def role = it.role
            def policyApprover = PolicyApprover.createCriteria().get() {
                createAlias('policy', 'p', CriteriaSpecification.LEFT_JOIN)
                and {
                    eq("role", role)
                    eq("p.policyTemplate", PolicyTemplate.findByCode(policyTemplateCode))
                }
            }

            if(policyApprover) {
                isAllowed = true
            }
        }

        // If no policy is defined, allow
        if(policyRoleCount == 0) isAllowed = true
        println 'IsAllowedsya ' + isAllowed
    	return isAllowed
    }

    def isAllowedToOverride(String policyTemplateCode, UserMaster userMaster) {
        def isAllowed = false

        def roles = UserRole.findAllByUserMasterAndConfigItemStatus(userMaster, ConfigItemStatus.get(2))

        def policyRoleCount = 0

        roles.each {
            def role = it.role
            def policyRole = PolicyRole.createCriteria().get() {
                createAlias('policy', 'p', CriteriaSpecification.LEFT_JOIN)
                and {
                    eq("role", role)
                    eq("p.policyTemplate", PolicyTemplate.findByCode(policyTemplateCode))
                }
            }
            println("isAllowedToOverride function")
            println("policyRole: "+policyRole)
            if(policyRole) {
                policyRoleCount++
                println("policyRole.policy.policyAction: "+policyRole.policy.policyAction)
                println("policyRole.policy.configItemStatus.id: "+policyRole.policy.configItemStatus.id)
                if(policyRole.policy.policyAction == PolicyAction.get(1)) {
                    isAllowed = true
                }
            }
        }

        // Check if approver
        roles.each {
            def role = it.role
            def policyApprover = PolicyApprover.createCriteria().get() {
                createAlias('policy', 'p', CriteriaSpecification.LEFT_JOIN)
                and {
                    eq("role", role)
                    eq("p.policyTemplate", PolicyTemplate.findByCode(policyTemplateCode))
                }
            }

            if(policyApprover) {
                isAllowed = true
            }
        }

        // If no policy is defined, allow
        if(policyRoleCount == 0) isAllowed = true

        return isAllowed
    }

    def isTxnAllowed(String txnTemplateCode, Double txnAmtCondition) {
        println("======================== OVERRIDE isTxnAllowed ================")
        println("txnTemplateCode: "+txnTemplateCode)
        println("txnAmtCondition: "+txnAmtCondition)
        HttpSession session = RequestContextHolder.currentRequestAttributes().getSession();

        def isAllowed = false

        def roles = UserRole.findAllByUserMasterAndConfigItemStatus(UserMaster.get(session.user_id), ConfigItemStatus.get(2))
        
        def policyRoleCount = 0
        
        /*roles.each {
            def role = it.role
            println "txnAmtCondition" + txnAmtCondition
            def policyTxn = PolicyTxn.executeQuery("select pTxn.id from PolicyTxn pTxn, PolicyRole pRole"
                + " join pTxn.txnTemplate tTemplate"
                + " join pTxn.policy p"
                + " where tTemplate.code = '" + txnTemplateCode + "'"
                + " and pRole.policy = p.id and p.configItemStatus = 2"
                + " and pRole.role = " + role.id
                + " and p.txnAmtCondition < " + txnAmtCondition)
            
            if(policyTxn) {
                policyRoleCount++
            }
        }*/
        def sql = new Sql(dataSource)
        
        def querySql = " select D.id as policy from policy_txn A "+
        " inner join policy_role B on B.policy_id = A.policy_id "+
        " inner join txn_template C on C.id = A.txn_template_id "+
        " inner join policy D on D.id = B.policy_id "+
        " where C.code = '"+txnTemplateCode+"' and D.config_item_status_id = 2 and D.txn_amt_condition < "+txnAmtCondition+"  "+
        " and B.role_id in (select role_id from user_role where user_master_id = "+session.user_id+" ) "
        def resultSetPolicy = sql.rows(querySql)
       
        println("querySql: "+querySql)
        println("resultqueryall: "+resultSetPolicy)
        
        def policyExist = null
        def isCoveredByPolicy = false
        def isUserApprover = false
        
        for(xpolicy in resultSetPolicy){
            
            isCoveredByPolicy = true 
            
            policyExist = Policy.get(xpolicy.policy.toInteger())
            querySql = ""
            querySql = "select id from policy_approver where policy_id = "+policyExist.id+" and role_id in (select role_id from user_role where user_master_id = "+session.user_id+")"
            def resultSetApprover = sql.rows(querySql)
            
            for(xAppver in resultSetApprover){
                isUserApprover = true
            }
        }
        

        
        
        // Check if approver
        /*roles.each {
            def role = it.role
            def policyApprover = PolicyTxn.executeQuery("select pTxn.id from PolicyTxn pTxn, PolicyApprover pApprover"
                + " join pTxn.txnTemplate tTemplate"
                + " join pTxn.policy p"
                + " where tTemplate.code = '" + txnTemplateCode + "'"
                + " and pApprover.policy = p.id and p.configItemStatus = 2"
                + " and pApprover.role = " + role.id
                + " and p.txnAmtCondition < " + txnAmtCondition)

            if(policyApprover) {
                isAllowed = true
            }
        }*/

        // If no policy is defined, allow
        //if(policyRoleCount == 0) isAllowed = true
        
        if(isCoveredByPolicy == true && isUserApprover == true){
            isAllowed = true
            
        }
        if(isCoveredByPolicy == false){
            isAllowed = true
        }
        if(isCoveredByPolicy == true && isUserApprover == false){
            isAllowed = false
        }
        return isAllowed
    }

    def isAllowedToOverrideTxn(String txnTemplateCode, txnAmtCondition, UserMaster userMaster) {
        def isAllowed = false

        def roles = UserRole.findAllByUserMasterAndConfigItemStatus(userMaster, ConfigItemStatus.get(2))

        def policyRoleCount = 0

        roles.each {
            def role = it.role
            def policyTxn = PolicyTxn.executeQuery("select pTxn.id from PolicyTxn pTxn, PolicyRole pRole"
                + " join pTxn.txnTemplate tTemplate"
                + " join pTxn.policy p"
                + " where tTemplate.code = '" + txnTemplateCode + "'"
                + " and pRole.policy = p.id"
                + " and pRole.role = " + role.id
                + " and p.txnAmtCondition <> 0" )
            
            if(policyTxn) {
                policyRoleCount++
            }
        }

        // Check if approver
        roles.each {
            def role = it.role
            def policyApprover = PolicyTxn.executeQuery("select pTxn.id from PolicyTxn pTxn, PolicyApprover pApprover"
                + " join pTxn.txnTemplate tTemplate"
                + " join pTxn.policy p"
                + " where tTemplate.code = '" + txnTemplateCode + "'"
                + " and pApprover.policy = p.id"
                + " and pApprover.role = " + role.id
                + " and p.txnAmtCondition <> 0" )

            if(policyApprover) {
                isAllowed = true
            }
        }

        // If no policy is defined, allow
        if(policyRoleCount == 0) isAllowed = true

        return isAllowed
    }

    def createException(String policyTemplateCode, String tableName, Long recordId, String recordUrl) {
    	HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()

    	def policyException = new PolicyException()
    	policyException.requestingUser = UserMaster.get(session.user_id)
    	policyException.dateOfRequest = new Date()
    	policyException.policyTemplate = PolicyTemplate.findByCode(policyTemplateCode)
        //policyException.tableName = tableName
        //policyException.recordId = recordId
    	//policyException.recordUrl = recordUrl
    	policyException.save flush:true
    }
    
     def createException(String policyTemplateCode, String tableName, Long recordId, String recordUrl, Long targetid) {
        
    	HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()

    	def policyException = new PolicyException()
        policyException.approvingUser = UserMaster.get(session.user_id)
    	policyException.requestingUser = UserMaster.get(targetid)
    	policyException.dateOfRequest = new Date()
    	policyException.policyTemplate = PolicyTemplate.findByCode(policyTemplateCode)
        policyException.tableName = tableName
        policyException.recordId = recordId
    	policyException.recordUrl = recordUrl
    	policyException.save flush:true
    }
    
    def updateException(String TableName, Long recordId, boolean isApproved) {
        HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()
        
        /*
        def policyException = PolicyException.createCriteria().get() {
            and {
                eq("tableName", tableName)
                eq("recordId", (int) (long) recordId)
                isNull("dateOfAction")
            }
        }
        */
        //println TableName
        //println recordId
    
        
        def policyException = PolicyException.get((int) recordId) //findWhere(tableName : TableName, recordId : (int) recordId, dateOfAction: null)
        
        if(policyException)
        {
            policyException.approvingUser = UserMaster.get(session.user_id)
            policyException.dateOfAction = new Date()
            policyException.isApproved = isApproved
            policyException.save flush:true
        }
    }
    
     def updateException(String tableName, Long recordId, boolean isApproved, UserMaster userMaster) {
        HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()
        
      //  println "user id ? " + user_id
        
        def policyException = PolicyException.createCriteria().get() {
            and {
                eq("tableName", tableName)
                eq("recordId", (int) (long) recordId)
                isNull("dateOfAction")
            }
        }
  
        //def policyException = PolicyException.get(recordId)
        
       
        policyException.approvingUser = userMaster
        policyException.dateOfAction = new Date()
        policyException.isApproved = isApproved
        policyException.save flush:true
    }
    

    def takeAction(classInstance, classStatus, String table, boolean isApproved) {
        def currentStatus = classInstance.status.code

        switch(currentStatus) {
            case '000':
                classInstance.status = classStatus.findByCode('010')
                break
            case '002':
                classInstance.status = classStatus.findByCode('990')
        }

        classInstance.save flush:true

        // Update Policy Exception
        updateException(table, classInstance.id, isApproved)
    }

    def getPendingPolicyExceptionCount() {
        HttpSession session = RequestContextHolder.currentRequestAttributes().getSession()
        
        return PolicyException.findAllByDateOfActionAndRequestingUser(null,UserMaster.get(session.user_id)).size()
    }
}