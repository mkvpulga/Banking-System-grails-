package icbs.loans

import icbs.admin.UserMaster
import icbs.loans.CreditInvestigation
import icbs.lov.BorrowRiskRating

class CreditInvestigationBRRHistory {
    
    Date dateUpdated
    Date datetimestamp
    CreditInvestigation creditInvestigation
    BorrowRiskRating borrowRiskRating
    String remarks
    UserMaster createdBy
    
    static constraints = {
        dateUpdated nullable: true
        creditInvestigation nullable: true
        borrowRiskRating nullable: true
        remarks nullable: true
        createdBy nullable: true
        datetimestamp nullable: true
    }
    
    static mapping = {
        
    	id sqlType: "int", generator: "increment"
    }
}
