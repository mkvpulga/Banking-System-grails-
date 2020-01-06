package icbs.cif

import icbs.cif.Customer
class AmlaRiskRating {

    Customer customer
    Integer score1
    Integer score2
    Integer score3
    Integer score4
    Integer score5
    Integer score6
    Integer score7
    Integer score8
    Integer score9
    Integer score10
    Integer score11
    Integer score12
    Integer score13
    Integer score14
    Integer score15
    Integer score16
    Integer score17
    Integer score18
    Integer score19
    Integer score20
    
   
    
    static constraints = {
        customer nullable:true
        score1 nullable:true
        score2 nullable:true
        score3 nullable:true
        score4 nullable:true
        score5 nullable:true
        score6 nullable:true
        score7 nullable:true
        score8 nullable:true
        score9 nullable:true
        score10 nullable:true
        score11 nullable:true  
        score12 nullable:true
        score13 nullable:true
        score14 nullable:true
        score15 nullable:true
        score16 nullable:true
        score17 nullable:true
        score18 nullable:true
        score19 nullable:true
        score20 nullable:true    
        
        
    }
     static mapping = {
        
        id sqlType:'int', generator:'increment'
    }
}
