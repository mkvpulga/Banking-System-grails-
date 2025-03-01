import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_memo_form_billsPayment_debit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/memo/form/billsPayment/debit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("txnType"),'name':("tnxType.id"),'value':("7")],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',10,['id':("acct"),'name':("acct.id"),'value':(billsPaymentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: billsPaymentInstance, field: 'type', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("billsPayment.type.label"),'default':("Memo Type")],-1)
printHtmlPart(5)
invokeTag('select','g',16,['id':("type"),'name':("type.id"),'onchange':("changeMemoForm('billsPayment')"),'from':(icbs.lov.MemoType.findAllByIdInListAndStatus([1],true)),'optionKey':("id"),'optionValue':("description"),'value':(billsPaymentInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',22,['bean':(billsPaymentInstance),'field':("type")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',25,['bean':(billsPaymentInstance),'field':("type")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: billsPaymentInstance, field: 'txnTemplate', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',30,['code':("billsPayment.txnTemplate.label"),'default':("Transaction Template")],-1)
printHtmlPart(5)
invokeTag('select','g',33,['id':("txnTemplate"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(billsPaymentInstance?.txnTemplate?.id),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',39,['bean':(billsPaymentInstance),'field':("txnTemplate")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',42,['bean':(billsPaymentInstance),'field':("txnTemplate")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: billsPaymentInstance, field: 'amt', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',47,['code':("billsPayment.amt.label"),'default':("Amount")],-1)
printHtmlPart(14)
invokeTag('textField','g',50,['id':("BillsDebitAmt"),'name':("amt"),'value':(billsPaymentInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',56,['bean':(billsPaymentInstance),'field':("amt")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',59,['bean':(billsPaymentInstance),'field':("amt")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: billsPaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',65,['code':("billsPayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(14)
invokeTag('textField','g',68,['id':("BillsDebitRef"),'name':("txnRef"),'value':(billsPaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',73,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',74,['bean':(billsPaymentInstance),'field':("txnRef")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',77,['bean':(billsPaymentInstance),'field':("txnRef")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: billsPaymentInstance, field: 'txnDescription', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',84,['code':("billsPayment.txnDescription.label"),'default':("Description")],-1)
printHtmlPart(5)
invokeTag('textField','g',87,['name':("txnDescription"),'value':(billsPaymentInstance?.txnDescription),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',92,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',93,['bean':(billsPaymentInstance),'field':("txnDescription")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',96,['bean':(billsPaymentInstance),'field':("txnDescription")],1)
printHtmlPart(18)
invokeTag('submitButton','g',101,['name':("submit"),'class':("btn btn-primary"),'id':("submitFrmBills"),'style':("display:none")],-1)
printHtmlPart(19)
if(true && (flash.message == "Bills Payment Successfully made.|success|alert")) {
printHtmlPart(20)
}
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128770L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
