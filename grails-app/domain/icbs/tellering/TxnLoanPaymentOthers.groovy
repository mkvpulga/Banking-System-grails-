package icbs.tellering
import icbs.deposit.Deposit

class TxnLoanPaymentOthers {
    TxnLoanPaymentDetails txnLoanPaymentDetails
    Double arOthers
    String arOthersGl
    Double insurance
    String insuranceGl
    Deposit deposit
    Double depositCr
    
    static constraints = {
        txnLoanPaymentDetails nullable:true
        arOthers scale:2, min:0.00D, nullable:true
        arOthersGl nullable:true
        insurance scale:2, min:0.00D, nullable:true
        insuranceGl nullable:true
        deposit nullable:true
        depositCr scale:2, min:0.00D, nullable:true
    }

    static mapping = {
        id sqlType: 'int', generator: 'increment'
    }
}
