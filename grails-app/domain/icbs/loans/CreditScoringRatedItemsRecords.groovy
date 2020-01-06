package icbs.loans
import icbs.loans.CreditScoringPreQualification
import icbs.loans.LoanApplication
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringRatedItems
class CreditScoringRatedItemsRecords {
    LoanApplication loanApplication
    CreditScoringRated creditScoringRated
    CreditScoringRatedItems creditScoringRatedItems
    CreditScoringAnswers creditScoringAnswers
    UserMaster evaluatedBy
    Date dateEvaluated
    UserMaster lastUpdatedBy
    Date lastUpdatedDate
       String remarks 
    static constraints = {
        loanApplication nullable:true
        creditScoringRated nullable:true
        creditScoringRatedItems nullable:true
        creditScoringAnswers nullable:true
        evaluatedBy nullable:true
        dateEvaluated nullable:true
        lastUpdatedBy nullable:true
        lastUpdatedDate nullable:true
         remarks nullable:true, size: 0..15000
    }
      static mapping = {
         remarks    sqlType: 'text' 
    }
}
