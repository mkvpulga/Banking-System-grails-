import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPayment_index_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/_index.gsp" }
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
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',29,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Search value")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',36,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',42,['property':("id"),'title':("Txn ID")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',43,['property':("loan.accountNo"),'title':("Loan Account")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',44,['property':("loan.customer.displayName"),'title':("Borrower's Name")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',45,['property':("txnFile.txnDate"),'title':("Transaction Date")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',46,['property':("txnFile.txnAmt"),'title':("Transaction Amt")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',47,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( txnLoanPaymentDetailsInstance in (txnLoanPaymentDetailsInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(18)
expressionOut.print(txnLoanPaymentDetailsInstance?.acctNo)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
printHtmlPart(19)
invokeTag('formatDate','g',57,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',58,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(18)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(18)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',60,['class':("btn btn-secondary"),'action':("reverseLoanPaymentTxn"),'id':(txnLoanPaymentDetailsInstance.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',67,['total':(txnLoanPaymentDetailInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(25)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(26)
invokeTag('message','g',73,['code':("default.home.label")],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129213L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
