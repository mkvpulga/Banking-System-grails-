package icbs.loans
import icbs.gl.CfgAcctGlTemplate
class LoanNonReclassToCurrentPointer {
    
    String description
    CfgAcctGlTemplate cfgAcctGlTemplate
    
    static constraints = {
        description nullable:true
        cfgAcctGlTemplate nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
