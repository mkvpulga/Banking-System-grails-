package icbs.loans
import icbs.loans.CreditScoringPreQualification
import icbs.loans.LoanApplication
import icbs.lov.CreditScoringAnswers
import icbs.admin.UserMaster
class CreditScoringPreQualificationRecords {
    
    LoanApplication loanApplication
    CreditScoringPreQualification creditScoringPreQualification
    CreditScoringAnswers preQualificationAnswer
    UserMaster scoredBy
    Date scoringDate
    UserMaster lastUpdateBy
    Date lastUpdatedDate
    
    static constraints = {
        loanApplication nullable:true
        creditScoringPreQualification nullable:true
        preQualificationAnswer nullable:true
        scoredBy nullable:true
        scoringDate nullable:true
        lastUpdateBy nullable:true
        lastUpdatedDate nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
