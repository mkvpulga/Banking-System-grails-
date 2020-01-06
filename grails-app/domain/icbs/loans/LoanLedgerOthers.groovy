package icbs.loans

import icbs.loans.LoanLedger
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.admin.Branch
import icbs.lov.MemoTxnType

class LoanLedgerOthers {
    
    Branch branch
    Currency currency
    LoanLedger loanLedger
    Double insurance
    Double savingsDeposit
    Double arOthers
    Date txnDate
    MemoTxnType txntype
    String description
    UserMaster transactBy
    
    static constraints = {
        branch nullable:true
        currency nullable:true
        loanLedger nullable:true
        insurance nullable:true
        savingsDeposit nullable:true
        arOthers nullable:true
        txnDate nullable:true
        txntype nullable:true
        description nullable:true
        transactBy nullable:true
    }
}
