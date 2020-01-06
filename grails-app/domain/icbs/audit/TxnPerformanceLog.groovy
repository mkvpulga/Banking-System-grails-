package icbs.audit

import icbs.tellering.TxnFile

class TxnPerformanceLog {

    TxnFile txnFile
    Date txnStart
    Date txnEnd
    
    static constraints = {
        txnFile nullable:true
        txnStart nullable:true
        txnEnd nullable:true
    }
    
    static mapping = {
    	id sqlType:'bigint', generator:'increment'
    }
}
