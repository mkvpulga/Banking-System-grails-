package icbs.loans

class CreditScoringMatrix {
    Double rangeFrom
    Double rangeTo
    Integer calculatedBrr
    String ratingAssessment
    String riskLevel
    
    static constraints = {
        rangeFrom nullable:true
        rangeTo nullable:true
        calculatedBrr nullable:true
        ratingAssessment nullable:true
        riskLevel nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
