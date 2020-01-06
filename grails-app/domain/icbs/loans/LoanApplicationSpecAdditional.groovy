package icbs.loans
import icbs.lov.LoanInstallmentFreq
import icbs.loans.LoanApplication
import icbs.lov.LoanSecurity
class LoanApplicationSpecAdditional {
    String camNo
    String company
    LoanApplication loanApplication
    LoanSecurity loanSecurity
    String loanClassification
    String loanProduct
    String economicActivity
    String mannerOfPayment    
    Double interestRate
    String repaymentType    
    String condition1   
    String condition2   
    String condition3   
    String condition4   
    String condition5   
    String condition6   
    String condition7   
    Double amortizationPenaltyRate
    Double preTerminationChargeRate
    Double pastdueInterestRate
    Double pastduePenaltyRate
    String loanApplicationType   
    String loanStatus   
    Double totalToDate
    String recommendedRemarks1   
    String recommendedRemarks2
    Date recommendedDate
    String creditCommitteeRemarks   
    String creditCommitteeSignatory1   
    String creditCommitteeSignatory2
    String creditCommitteeSignatory3   
    String creditCommitteeMember1  
    String creditCommitteeMember2
    String creditCommitteePresident   
    Date creditCommitteeDate
        
    static constraints = {
        camNo nullable:true
        company nullable:true
        loanApplication nullable:true
        loanSecurity nullable:true
        loanClassification nullable:true
        loanProduct nullable:true
        economicActivity nullable:true
        mannerOfPayment nullable:true
        interestRate nullable:true
        repaymentType nullable:true
        condition1 nullable:true, size: 0..15000
        condition2 nullable:true, size: 0..15000
        condition3 nullable:true, size: 0..15000
        condition4 nullable:true, size: 0..15000
        condition5 nullable:true, size: 0..15000
        condition6 nullable:true, size: 0..15000
        condition7 nullable:true, size: 0..15000
        amortizationPenaltyRate nullable:true
        preTerminationChargeRate nullable:true
        pastdueInterestRate nullable:true
        pastduePenaltyRate nullable:true
        loanApplicationType nullable:true
        loanStatus nullable:true
        totalToDate nullable:true
        recommendedRemarks1 nullable:true, size: 0..15000
        recommendedRemarks2 nullable:true, size: 0..15000
        recommendedDate nullable:true
        creditCommitteeRemarks nullable:true, size: 0..15000
        creditCommitteeSignatory1 nullable:true 
      
        creditCommitteeSignatory2 nullable:true
        creditCommitteeSignatory3 nullable:true
        creditCommitteeMember1 nullable:true
        creditCommitteeMember2 nullable:true
        creditCommitteePresident nullable:true
        creditCommitteeDate nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
        condition1    sqlType: 'text' 
        condition2    sqlType: 'text' 
        condition3    sqlType: 'text' 
        condition4    sqlType: 'text' 
        condition5    sqlType: 'text' 
        condition6    sqlType: 'text' 
        condition7    sqlType: 'text' 
        recommendedRemarks1    sqlType: 'text' 
        recommendedRemarks2    sqlType: 'text' 
        creditCommitteeRemarks    sqlType: 'text' 
    }    
}
