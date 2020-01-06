import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceatmTxnDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/atmTxnDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(atmTxnDetalisInstance?.id)
printHtmlPart(8)
expressionOut.print(atmTxnDetalisInstance?.txnDate)
printHtmlPart(9)
expressionOut.print(atmTxnDetalisInstance?.requestMsg?.msgContent)
printHtmlPart(10)
expressionOut.print(atmTxnDetalisInstance?.responseDate)
printHtmlPart(11)
expressionOut.print(atmTxnDetalisInstance?.responseMsg?.msgContent)
printHtmlPart(12)
expressionOut.print(atmTxnDetalisInstance?.responseMsg?.dateSent)
printHtmlPart(13)
expressionOut.print(atmTxnDetalisInstance?.txnCode)
printHtmlPart(14)
expressionOut.print(atmTxnDetalisInstance?.mti)
printHtmlPart(15)
expressionOut.print(atmTxnDetalisInstance?.atmCardNumber)
printHtmlPart(16)
expressionOut.print(atmTxnDetalisInstance?.atmTerminal)
printHtmlPart(17)
expressionOut.print(atmTxnDetalisInstance?.acct1)
printHtmlPart(18)
expressionOut.print(atmTxnDetalisInstance?.acct2)
printHtmlPart(19)
expressionOut.print(atmTxnDetalisInstance?.txnRef)
printHtmlPart(20)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(atmTxnDetalisInstance?.txnAmt)],-1)
printHtmlPart(21)
if(true && (atmTxnDetalisInstance?.txnChargeAmt > 0)) {
printHtmlPart(22)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(atmTxnDetalisInstance?.txnChargeAmt / 100)],-1)
printHtmlPart(21)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',87,['format':("###,###,##0.00"),'number':(atmTxnDetalisInstance?.txnChargeAmt)],-1)
printHtmlPart(21)
}
printHtmlPart(23)
expressionOut.print(atmTxnDetalisInstance?.status?.description)
printHtmlPart(24)
expressionOut.print(atmTxnDetalisInstance?.isReversed)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(atmTxnDetalisInstance?.txnFile1)
})
invokeTag('link','g',100,['action':("viewAtmTxnFile"),'controller':("ATMInterface"),'id':(atmTxnDetalisInstance?.txnFile1),'params':(['atmtxnid': params.id])],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',106,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',109,['action':("index"),'controller':("ATMInterface")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',110,['action':("viewRequestDetails"),'controller':("ATMInterface")],3)
printHtmlPart(30)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',111,['action':("viewResponseDetails"),'controller':("ATMInterface")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',114,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127896L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
