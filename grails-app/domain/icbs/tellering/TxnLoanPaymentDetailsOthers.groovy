package icbs.tellering
import icbs.tellering.TxnLoanPaymentDetails
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.admin.Branch

class TxnLoanPaymentDetailsOthers {
    
    Branch branch
    Currency currency
    TxnLoanPaymentDetails txnLoanPaymentDetails
    Double insurance
    Double savingsDeposit
    Double arOthers
    Date txnDate
    UserMaster transactBy
    
    static constraints = {
        branch nullable:true
        currency nullable:true
        txnLoanPaymentDetails nullable:true
        insurance nullable:true
        savingsDeposit nullable:true
        arOthers nullable:true
        txnDate nullable:true
        transactBy nullable:true
    }
}
