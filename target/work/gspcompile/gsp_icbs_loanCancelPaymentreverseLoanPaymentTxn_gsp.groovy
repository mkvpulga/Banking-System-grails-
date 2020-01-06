import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPaymentreverseLoanPaymentTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/reverseLoanPaymentTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'txnLoanPaymentDetails.label', default: 'txnLoanPaymentDetails'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
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
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.accountNo)
})
invokeTag('link','g',29,['action':("show"),'controller':("loan"),'id':(txnLoanPaymentDetailsInstance?.acct?.id)],3)
printHtmlPart(9)
createTagBody(3, {->
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
})
invokeTag('link','g',33,['controller':("customer"),'action':("customerInquiry"),'id':(txnLoanPaymentDetailsInstance?.acct?.customer?.id)],3)
printHtmlPart(10)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(11)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(12)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',49,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.principalAmt)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.interestAmt)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',61,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.penaltyAmt)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.serviceChargeAmt)],-1)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(2, 3)
invokeTag('link','g',74,['action':("create")],3)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',75,['action':("index")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-actions")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129220L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
