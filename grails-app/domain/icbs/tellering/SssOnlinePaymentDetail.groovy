package icbs.tellering
import java.sql.Timestamp
import icbs.tellering.TxnFile
class SssOnlinePaymentDetail {
    
    TxnFile txnFile
    Double  amount
    String  appmo
    String  brnum
    String  erbrn
    String  ername
    String  ernum
    Integer replyCode
    Timestamp replyDate
    String indiTxnNumber
    String indiPayorType
    String indiIprnum
    String indiEenum
    String indiEename
    String fapid
    String tapid
    Double flexiAmt
    Double monthlyContribution
    static constraints = {
        flexiAmt nullable:true, min:0.00D, scale:2
        monthlyContribution nullable:true, min:0.00D, scale:2
        txnFile nullable:true
        amount nullable:true, min:0.00D, scale:2
        appmo nullable:true
        brnum nullable:true
        erbrn nullable:true
        ername nullable:true
        ernum nullable:true
        replyCode nullable:true
        replyDate nullable:true
        indiTxnNumber nullable:true
        indiIprnum nullable:true
        indiEenum nullable:true
        indiEename nullable:true
        fapid nullable:true
        tapid nullable:true
        indiPayorType nullable:true
    }
    
    static mapping = {
        id sqlType: 'int', generator: 'increment'
    }
}
