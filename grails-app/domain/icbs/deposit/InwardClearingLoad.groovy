package icbs.deposit

class InwardClearingLoad {
    String acctNo
    Long chequeNo
    Double amt
    String brstn
    String trancd
    String remarks
    String acctName
    String caAcctNo
    
    
    static constraints = {
        acctNo nullable: true
        chequeNo nullable: true
        amt nullable: true
        brstn nullable: true
        trancd nullable: true
        remarks nullable: true
        acctName nullable: true
        caAcctNo nullable: true
    }
    static mapping = {
    	id sqlType: "int", generator: "increment"
        
    }
}
