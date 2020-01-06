package icbs.loans
import icbs.gl.CfgAcctGlTemplate
import icbs.cif.Customer
import icbs.lov.LoanPerformanceId
import icbs.admin.Product
import icbs.admin.Branch
import icbs.lov.LoanAcctStatus
import icbs.lov.LoanKindOfLoan

class LoanMicrofinanceHist {
    
    Date refDate
    Branch branch
    Loan loan
    String accountNo
    LoanApplication loanApplication
    Customer customer
    CfgAcctGlTemplate glLink
    Double balance
    Double overduePrincipalBalance
    Double interestBalanceAmount
    Integer missedInstallments
    Integer accountOfficer
    Integer groupRecord
    LoanPerformanceId loanPerformanceId
    LoanAcctStatus status
    Integer ageInArrears
    Date openingDate
    Date maturityDate
    Double grantedAmount
    LoanKindOfLoan loanKindOfLoan
    Product product
    Double holdOutBalance
    
    
    static constraints = {
        refDate nullable:true
        branch nullable:true
        loan nullable:true
        accountNo nullable:true
        loanApplication nullable:true
        customer nullable:true
        glLink nullable:true
        balance nullable:true, scale:2, min:0.00D
        overduePrincipalBalance nullable:true, scale:2, min:0.00D
        interestBalanceAmount nullable:true, scale:2, min:0.00D
        missedInstallments nullable:true, min:0
        accountOfficer nullable:true
        groupRecord nullable:true
        loanPerformanceId nullable:true
        status nullable:true
        ageInArrears nullable:true, min:0
        openingDate nullable:true
        maturityDate nullable:true
        grantedAmount nullable:true, scale:2, min:0.00D
        loanKindOfLoan nullable:true
        product nullable:true
        holdOutBalance nullable:true, scale:2, min:0.00D 
    }
    
    static mapping = {
	id sqlType: "int", generator: "increment"

    }
}
