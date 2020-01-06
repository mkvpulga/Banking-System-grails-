package icbs.loans
import icbs.loans.CreditScoringPreQualification
import icbs.loans.LoanApplication
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringCodeDescription
import icbs.admin.UserMaster
import icbs.loans.CreditScoringQuestionSection
class CreditScoringChecklistRecords {
    
    LoanApplication loanApplication
    CreditScoringQuestionSection creditScoringQuestionSection
    CreditScoringQuestions creditScoringQuestions
    CreditScoringAnswers creditScoringAnswers
    UserMaster evaluatedBy
    Date dateEvaluated
    UserMaster lastUpdatedBy
    Date lastUpdatedDate
    static constraints = {
        loanApplication nullable:true
        creditScoringQuestionSection nullable:true
        creditScoringQuestions nullable:true
        creditScoringAnswers nullable:true
        evaluatedBy nullable:true
        dateEvaluated nullable:true
        lastUpdatedBy nullable:true
        lastUpdatedDate nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    } 
    
}
