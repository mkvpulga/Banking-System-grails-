package icbs.loans
import icbs.admin.Product
import icbs.admin.UserMaster
import icbs.loans.CreditScoringCodeDescription
class CreditScoringProductConfig {
    

    CreditScoringCodeDescription creditScoringCodeDescription
    Product product

    static constraints = {
        creditScoringCodeDescription nullable:true
        product nullable:true

    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    }    
}
