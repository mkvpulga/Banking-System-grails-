package icbs.loans

import icbs.loans.CreditScoringPreQualification
import icbs.loans.LoanApplication
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringMatrix

class CreditScoringTallyOfScores {
    
    LoanApplication loanApplication
    Double totalScore
    Double initialCrr
    Double calculatedCrr
    CreditScoringMatrix creditScoringrating
    Double recommendedCrrScore
    CreditScoringMatrix recommendedCrrRating
    String justification
    CreditScoringAnswers scoreCompletenessOfDocument
    Double rated10
    Double rated9
    Double rated8
    Double rated7
    Double rated6
    static constraints = {
        calculatedCrr nullable:true
        loanApplication nullable:true
        totalScore nullable:true
        initialCrr nullable:true
        creditScoringrating nullable:true
        recommendedCrrScore nullable:true
        recommendedCrrRating nullable:true
        justification nullable:true, size: 0..15000
        scoreCompletenessOfDocument nullable:true
        rated10 nullable:true
        rated9 nullable:true
        rated8 nullable:true
        rated7 nullable:true
        rated6 nullable:true
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
        justification    sqlType: 'text' 
    } 
}