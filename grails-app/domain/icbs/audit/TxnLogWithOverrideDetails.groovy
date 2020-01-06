package icbs.audit
import icbs.admin.UserMaster
import java.sql.Timestamp
import icbs.tellering.TxnFile

class TxnLogWithOverrideDetails {
    
    UserMaster userOverrideBy
    UserMaster requestBy
    String description
    Date dateOverride
    Timestamp txnTimestamp
    TxnFile txnfile
    
    
    static constraints = {
        userOverrideBy nullable:true
        requestBy nullable:true
        description nullable:true
        dateOverride nullable:true
        txnTimestamp nullable:true
        txnfile nullable:true
    }
    static mapping = {
        id sqlType: 'int', generator: 'increment'
    }
}
