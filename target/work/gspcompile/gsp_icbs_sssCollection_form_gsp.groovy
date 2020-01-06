import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollection_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',3,['id':("CashReceiptAdjustment"),'name':("CashReceiptAdjustment"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'paymentCode', 'has-error'))
printHtmlPart(7)
invokeTag('select','g',20,['id':("paymentCode"),'name':("paymentCode"),'from':(icbs.lov.SssPaymentCode.findAll{status == true}),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'paymentType', 'has-error'))
printHtmlPart(9)
invokeTag('select','g',26,['id':("paymentType"),'name':("paymentType"),'from':(icbs.lov.SssPaymentType.findAll{status == true}),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'payorType', 'has-error'))
printHtmlPart(10)
invokeTag('select','g',32,['id':("payorType"),'name':("payorType"),'from':(icbs.lov.SssPayorType.findAll{status == true}),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ssNumber', 'has-error'))
printHtmlPart(12)
invokeTag('textField','g',39,['name':("ssNumber"),'id':("ssNumber"),'value':(""),'class':("form-control")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'startingPeriod', 'has-error'))
printHtmlPart(13)
invokeTag('customDatePicker','g',45,['format':("date"),'name':("startingPeriod"),'id':("startingPeriod"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'endingPeriod', 'has-error'))
printHtmlPart(14)
invokeTag('customDatePicker','g',51,['format':("date"),'name':("endingPeriod"),'id':("endingPeriod"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ssAmountPaid', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',57,['type':("number"),'name':("ssAmountPaid"),'id':("ssAmountPaid"),'required':(""),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ecAmountPaid', 'has-error'))
printHtmlPart(16)
invokeTag('textField','g',63,['type':("number"),'name':("ecAmountPaid"),'id':("ecAmountPaid"),'required':(""),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(17)
invokeTag('textArea','g',69,['name':("txnRef"),'id':("txnRef"),'required':(""),'value':(txnReceiptAdjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnReceiptAdjustmentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(19)
invokeTag('textArea','g',77,['name':("txnParticulars"),'id':("txnParticulars"),'maxlength':("100"),'value':(txnReceiptAdjustmentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129382L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
