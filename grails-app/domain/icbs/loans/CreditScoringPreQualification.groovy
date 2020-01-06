package icbs.loans

import icbs.lov.ConfigItemStatus
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster


class CreditScoringPreQualification {

    CreditScoringCodeDescription creditScoringCodeDescription
    String preQualificationItem
    ConfigItemStatus status
    
    UserMaster createdBy
    Date dateCreated
    Date updatedDate
    UserMaster updatedBy
    static constraints = {
        creditScoringCodeDescription nullable:true
        preQualificationItem nullable:true
        status nullable:true
        
        updatedBy nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        updatedDate nullable:true
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
