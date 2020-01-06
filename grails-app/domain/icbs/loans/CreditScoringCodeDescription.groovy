package icbs.loans
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster
class CreditScoringCodeDescription {
    
    String code
    String description
    Boolean hasRatedItem
    ConfigItemStatus status
    UserMaster createdBy
    Date dateCreated
    UserMaster lastUpdatedBy
    Date lastUpdatedDate
    
    static constraints = {
        code nullable:true,Unique:true
        description nullable:true
        hasRatedItem nullable: true
        status nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        lastUpdatedBy nullable:true
        lastUpdatedDate nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    } 
}
