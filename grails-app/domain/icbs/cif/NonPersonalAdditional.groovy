package icbs.cif

class NonPersonalAdditional {
    
    Customer customer
    String placeOfBusinessRegistration
    String registeringAgency
    String registrationNo
    Date registrationDate
 
    String tin
   
    String typeOfBusiness
    String authorizedRepresentative
    String listOfDirectorsPartnersStackholder

    static constraints = {
        
            placeOfBusinessRegistration(nullable: true)
            registeringAgency(nullable: true)
            registrationNo(nullable: true)
            registrationDate(nullable: true)
            tin (nullable:true)
            typeOfBusiness(nullable: true)
            authorizedRepresentative(nullable: true,maxSize:250)
            listOfDirectorsPartnersStackholder(nullable: true,maxSize:250)         
    }
    
}
