import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
loop:{
int i = 0
for( atmDetails in (atmTxnInstanceList) ) {
printHtmlPart(7)
expressionOut.print(atmDetails.id)
printHtmlPart(8)
expressionOut.print(atmDetails.acct1)
printHtmlPart(9)
expressionOut.print(atmDetails?.acct2)
printHtmlPart(10)
expressionOut.print(atmDetails?.atmCardNumber)
printHtmlPart(11)
expressionOut.print(atmDetails?.atmTerminal)
printHtmlPart(12)
invokeTag('formatNumber','g',45,['format':("###,##0.00"),'number':(atmDetails?.bal1)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',49,['format':("###,##0.00"),'number':(atmDetails?.bal2)],-1)
printHtmlPart(14)
expressionOut.print(atmDetails?.mti)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',58,['controller':("ATMInterface"),'action':("viewAtmMsgRequest"),'id':(atmDetails.requestMsgId),'params':(['atmtxnid': atmDetails.requestMsgId])],4)
printHtmlPart(17)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(atmDetails?.responseDate)],-1)
printHtmlPart(18)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',66,['controller':("ATMInterface"),'action':("viewAtmMsgResponse"),'id':(atmDetails.responseMsgId),'params':(['atmtxnid': atmDetails.responseMsgId])],4)
printHtmlPart(19)
expressionOut.print(atmDetails?.isReversed)
printHtmlPart(20)
expressionOut.print(atmDetails?.reversalDate)
printHtmlPart(21)
expressionOut.print(atmDetails?.statusId)
printHtmlPart(22)
invokeTag('formatNumber','g',82,['format':("###,##0.00"),'number':(atmDetails?.txnAmt)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',86,['format':("###,##0.00"),'number':(atmDetails?.txnChargeAmt)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',90,['format':("###,##0.00"),'number':(atmDetails?.txnChargeAmt)],-1)
printHtmlPart(24)
expressionOut.print(atmDetails?.txnCode)
printHtmlPart(25)
invokeTag('formatDate','g',98,['format':("MM/dd/yyyy"),'date':(atmDetails?.txnDate)],-1)
printHtmlPart(26)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',102,['controller':("ATMInterface"),'action':("viewAtmTxnFile"),'id':(atmDetails.txnFile1),'params':(['atmtxnid': atmDetails.txnFile1])],4)
printHtmlPart(27)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',106,['controller':("ATMInterface"),'action':("viewAtmTxnFile"),'id':(atmDetails.txnFile2),'params':(['atmtxnid': atmDetails.txnFile2])],4)
printHtmlPart(28)
expressionOut.print(atmDetails?.txnRef)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',127,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',127,['class':("create"),'action':("create")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',129,['action':("atmTerminalView")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',131,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127905L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
