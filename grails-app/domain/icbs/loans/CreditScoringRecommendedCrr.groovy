package icbs.loans
import icbs.loans.CreditScoringPreQualification
import icbs.loans.LoanApplication
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringMatrix
class CreditScoringRecommendedCrr {
    LoanApplication loanApplication
    Double crrFinalCalculatedCrr
    CreditScoringMatrix creditScoringMatrix
    
    static constraints = {
        loanApplication nullable:true
        crrFinalCalculatedCrr nullable:true
        creditScoringMatrix nullable:true
        
        
    }
}
