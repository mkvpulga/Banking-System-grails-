package icbs.loans
import icbs.loans.LoanApplication
import icbs.lov.LoanCollateralType
import icbs.admin.UserMaster
class CreditScoringLoanAppDetails {
    LoanApplication loanApplication
    UserMaster createdBy
    Date dateCreated
    UserMaster lastUpdatedby
    Date lastUpdatedDate
    //for Consumer fields that doesn't exist in SME
    String employer
    String designationRank
    String otherCollateral
    String avOfCollateral
    String loanType
    String currentRating
    Double reasonsOfRating
    //end
    
    String nameOfBusiness
    String previousCrrRating
    Date previousRatingDate
    String basicReasonForCrr
    LoanCollateralType typeOfCollateral
    String facilityTypes
    Double commitmentAmount
    String originatingUnit
    String contactNumber
    String industrySubsector
    String industryCode
    Date dateOfCurrentRating
    String rater
    Date expiryDateOfLoan
    Double appraisalValueRem
    String avOtherCollateral
    Double totalOsBalance
    
    
    static constraints = {
        loanApplication nullable:true
        createdBy nullable:true
        dateCreated nullable:true
        lastUpdatedby nullable:true
        lastUpdatedDate nullable:true
        
        employer nullable:true
        designationRank nullable:true
        otherCollateral nullable:true
        avOfCollateral nullable:true
        loanType nullable:true
        currentRating nullable:true
        reasonsOfRating nullable:true
        
        nameOfBusiness nullable:true
        previousCrrRating nullable:true
        previousRatingDate nullable:true
        basicReasonForCrr nullable:true
        typeOfCollateral nullable:true
        facilityTypes nullable:true
        commitmentAmount nullable:true
        originatingUnit nullable:true
        contactNumber nullable:true
        industrySubsector nullable:true
        industryCode nullable:true
        dateOfCurrentRating nullable:true
        rater nullable:true
        appraisalValueRem nullable:true
        avOtherCollateral nullable:true
        expiryDateOfLoan nullable:true
        totalOsBalance nullable:true
        
    }
}
