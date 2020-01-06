import icbs.tellering.TxnLoanPaymentDetails
import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCashRepayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCashRepayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(12),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(txnLoanCashRepaymentInstance?.acct)
printHtmlPart(7)
if(true && (!txnLoanCashRepaymentInstance?.acct)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('hiddenField','g',24,['id':("loanId"),'name':("loanId")],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',25,['id':("test_Loan"),'name':("test_Loan"),'value':("0")],-1)
printHtmlPart(11)
expressionOut.print(totalPDue)
printHtmlPart(12)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(hasErrors(bean: txnLoanCashRepaymentInstance, field: 'paymentAmt', 'has-error'))
printHtmlPart(16)
invokeTag('textField','g',89,['type':("number"),'name':("paymentAmt"),'required':(""),'value':(txnLoanCashRepaymentInstance?.paymentAmt),'class':("form-control truncated"),'onkeyup':("updateBreakdown()")],-1)
printHtmlPart(17)
invokeTag('message','g',102,['code':("txnLoanCashRepayment.principalAmt.label"),'default':("Principal")],-1)
printHtmlPart(18)
invokeTag('textField','g',108,['id':("principal"),'type':("number"),'name':("principal"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',108,['name':("principalBalance"),'value':("0")],-1)
printHtmlPart(20)
invokeTag('message','g',115,['code':("txnLoanCashRepayment.interestAmt.label"),'default':("Interest")],-1)
printHtmlPart(18)
invokeTag('textField','g',121,['id':("interest"),'type':("number"),'name':("interest"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',121,['name':("interestBalance"),'value':("0")],-1)
printHtmlPart(21)
invokeTag('message','g',128,['code':("txnLoanCashRepayment.penaltyAmt.label"),'default':("Penalty")],-1)
printHtmlPart(18)
invokeTag('textField','g',134,['id':("penalty"),'type':("number"),'name':("penalty"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',134,['name':("penaltyBalance"),'value':("0")],-1)
printHtmlPart(22)
invokeTag('message','g',142,['code':("txnLoanCashRepayment.serviceChargeAmt.label"),'default':("Service Charge")],-1)
printHtmlPart(18)
invokeTag('textField','g',147,['id':("serviceCharge"),'type':("number"),'name':("serviceCharge"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',147,['name':("chargeBalance"),'value':("0")],-1)
printHtmlPart(23)
invokeTag('message','g',154,['code':("txnLoanCashRepayment.grtAmt.label"),'default':("Gross Receipts Tax")],-1)
printHtmlPart(18)
invokeTag('textField','g',160,['id':("tax"),'type':("number"),'name':("tax"),'required':(""),'readOnly':("true"),'class':("form-control"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',160,['name':("taxBalance"),'value':("0")],-1)
printHtmlPart(24)
invokeTag('message','g',167,['code':("txnLoanCashRepayment.otherAmt.label"),'default':("Others")],-1)
printHtmlPart(18)
invokeTag('textField','g',173,['id':("otherAmt"),'type':("number"),'name':("otherAmt"),'required':(""),'readOnly':("true"),'value':("0"),'class':("form-control")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',173,['name':("otherBalance"),'value':("0")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: txnLoanCashRepaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',184,['code':("txnLoanCashRepayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(27)
invokeTag('textArea','g',187,['name':("txnRef"),'required':(""),'value':(txnLoanCashRepaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129517L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
