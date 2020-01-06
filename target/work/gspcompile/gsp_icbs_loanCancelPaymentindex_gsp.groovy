import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPaymentindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'TxnLoanPaymentDetails.label', default: 'Loan Payments'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',36,['property':("id"),'title':("Txn ID")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("loan.accountNo"),'title':("Loan Account")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',38,['property':("loan.customer.displayName"),'title':("Borrower's Name")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',39,['property':("txnFile.txnDate"),'title':("Transaction Date")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',40,['property':("txnFile.txnAmt"),'title':("Transaction Amt")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',41,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( txnLoanPaymentDetailsInstance in (txnLoanPaymentDetailsInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.acctNo)
printHtmlPart(20)
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
printHtmlPart(20)
invokeTag('formatDate','g',51,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(19)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',54,['class':("btn btn-secondary"),'action':("reverseLoanPaymentTxn"),'id':(txnLoanPaymentDetailsInstance.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',61,['total':(TxnLoanPaymentDetailsInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',67,['class':("create"),'action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129219L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
