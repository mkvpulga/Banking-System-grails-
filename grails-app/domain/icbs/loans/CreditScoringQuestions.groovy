package icbs.loans

import icbs.loans.CreditScoringCodeDescription
import icbs.loans.CreditScoringQuestionSection
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster
class CreditScoringQuestions {
    
    CreditScoringCodeDescription creditScoringCodeDescription
    CreditScoringQuestionSection creditScoringQuestionSection
    
    String questionNumberDescription
    String choiceDescriptionA
    String choiceDescriptionB
    String choiceDescriptionC
    String remarks
    ConfigItemStatus status
    String otherType
    UserMaster createdBy
    Date dateCreated
    Date updatedDate
    UserMaster updatedBy
    
    static constraints = {
        creditScoringCodeDescription nullable:true
        creditScoringQuestionSection nullable:true
        questionNumberDescription nullable:true
        choiceDescriptionA nullable:true
        choiceDescriptionB nullable:true
        choiceDescriptionC nullable:true
        remarks nullable:true
        otherType nullable:true
        status nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        updatedDate nullable:true
        updatedBy nullable:true
    }
    static mapping = {
        id sqlType:'int', generator:'increment'
    } 
}
