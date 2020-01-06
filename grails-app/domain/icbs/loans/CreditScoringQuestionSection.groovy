package icbs.loans
import icbs.lov.ConfigItemStatus
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster
class CreditScoringQuestionSection {
    CreditScoringCodeDescription creditScoringCodeDescription
    String nameOfSection
    ConfigItemStatus status
    Double sectionPercentage
    UserMaster createdBy
    Date dateCreated
    Date updatedDate
    UserMaster updatedBy
    static constraints = {
        creditScoringCodeDescription nullable:true
        nameOfSection nullable:true
        status nullable:true
        sectionPercentage nullable:true
        updatedBy nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        updatedDate nullable:true
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    }  
}
