package icbs.gl
import icbs.admin.Branch
class GlAccountBranch {
    String glAccount
    Branch branch
    
    static constraints = {
        glAccount nullable:true
        branch nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    }
    
}
