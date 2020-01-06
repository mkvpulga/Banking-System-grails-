package icbs.loans

import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster

class CreditScoringRated {

    CreditScoringCodeDescription creditScoringCodeDescription
    String ratedName
    ConfigItemStatus status
    UserMaster createdBy
    Date dateCreated
    Date updatedDate
    UserMaster updatedBy
    String remarks 
    
    static constraints = {
        creditScoringCodeDescription nullable:true
        ratedName nullable:true
        status nullable:true
        
        updatedBy nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        updatedDate nullable:true
         remarks nullable:true, size: 0..15000
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
         remarks    sqlType: 'text' 
    }
}
