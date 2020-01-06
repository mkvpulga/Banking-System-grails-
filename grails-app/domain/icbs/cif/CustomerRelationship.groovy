package icbs.cif
import icbs.cif.Customer
import icbs.lov.ConfigItemStatus
import icbs.lov.Lov
class CustomerRelationship {
    
    Customer customer
    String firstName
    String middleName
    String lastName
    Date birthdate
    ConfigItemStatus status
    Lov relationshipType
    
    static constraints = {
        customer nullable:true
        firstName nullable:true
        middleName nullable:true
        lastName nullable:true
        birthdate nullable:true
        status nullable:true
        relationshipType nullable:true
    }
    static mapping = {
    	id sqlType: "int", generator: "increment"
    }
}
