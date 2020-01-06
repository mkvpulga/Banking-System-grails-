import icbs.tellering.TxnBillsPayment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnBillsPayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnBillsPayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("txnDepID"),'id':("txnDepID"),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',3,['id':("CashReceiptBills"),'name':("CashReceiptBills"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (!txnCashReceiptRemittanceInstance?.beneficiary)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('render','g',22,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnBillsPaymentInstance?.beneficiary])],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',28,['type':("number"),'name':("txnAmt"),'required':(""),'value':(txnBillsPaymentInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',33,['code':("txnBillsPayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(13)
invokeTag('textArea','g',36,['name':("txnRef"),'required':(""),'value':(txnBillsPaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',41,['code':("txnBillsPayment.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(13)
invokeTag('textArea','g',44,['name':("txnParticulars"),'maxlength':("100"),'value':(txnBillsPaymentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129426L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
