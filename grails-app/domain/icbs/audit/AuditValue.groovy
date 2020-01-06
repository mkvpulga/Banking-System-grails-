package icbs.audit
import icbs.admin.UserMaster

class AuditValue {
    String dataTable
    String dataField
    Integer itemId
    String oldValue
    String newValue
    Date dateStamp
    UserMaster user
    
    static constraints = {
        dataTable nullable:true
        dataField nullable:true
        itemId nullable:true
        oldValue nullable:true
        newValue nullable:true
        dateStamp nullable:true
        user nullable:true
    }
    
    static mapping = {
    	id sqlType:'bigint', generator:'increment'
    }    
}
