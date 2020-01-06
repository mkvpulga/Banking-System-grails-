package icbs.loans
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringCodeDescription
import icbs.loans.CreditScoringQuestionSection
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster

class CreditScoringRatedItems {
    CreditScoringRated creditScoringRated
    CreditScoringCodeDescription creditScoringCodeDescription
    String itemDescription
    ConfigItemStatus status
    UserMaster createdBy
    Date dateCreated
    Date updatedDate
    UserMaster updatedBy
    
    static constraints = {
        creditScoringRated nullable:true
        creditScoringCodeDescription nullable:true
        itemDescription nullable:true
        status nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        updatedDate nullable:true
        updatedBy nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    } 
}
