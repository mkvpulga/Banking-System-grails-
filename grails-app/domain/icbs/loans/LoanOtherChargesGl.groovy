package icbs.loans

import icbs.loans.Loan
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.admin.Branch
import icbs.lov.MemoTxnType
import icbs.gl.GlAccount

class LoanOtherChargesGl {
    
    GlAccount glAccount
    Branch branch
    Currency currency
    Loan loan
    Double insurance
    Double savingsDeposit
    Double arOthers
    Date txnDate
    MemoTxnType txntype
    String description
    UserMaster transactBy
    
    static constraints = {
        glAccount nullable:true
        branch nullable:true
        currency nullable:true
        loan nullable:true
        insurance nullable:true
        savingsDeposit nullable:true
        arOthers nullable:true
        txnDate nullable:true
        txntype nullable:true
        description nullable:true
        transactBy nullable:true
    }
}
