package icbs.gl

import icbs.gl.GlBatchHdr
class GlBatchVoucher {

    GlBatchHdr GlBatchHdr
    String checkNo
    String payee
    String approvedBy
    String receivedBy
    
    static constraints = {
        
        checkNo nullable:true
        payee nullable:true
        approvedBy nullable:true
        receivedBy nullable:true

    }
    static mapping = {
        
     
        id sqlType: "int", generator: "increment"
       
    }
}
