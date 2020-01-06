import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceviewAtmTxnFile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/viewAtmTxnFile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
for( branchInstance in (aa) ) {
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "id"))
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "acctNo"))
printHtmlPart(10)
expressionOut.print(fieldValue(bean: branchInstance, field: "acctStatus.description"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: branchInstance, field: "branch.name"))
printHtmlPart(12)
expressionOut.print(fieldValue(bean: branchInstance, field: "chd"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: branchInstance, field: "currency.name"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: branchInstance, field: "depAcctId"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: branchInstance, field: "senderId"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: branchInstance, field: "status.description"))
printHtmlPart(17)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(fieldValue(bean: branchInstance, field: "txnAmt"))],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnCode"))
printHtmlPart(19)
invokeTag('formatDate','g',73,['format':("MM/dd/yyyy"),'date':(branchInstance?.txnDate)],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDescription"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnParticulars"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnRef"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnTemplate.description"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnTimestamp"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnType.description"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: branchInstance, field: "userId"))
printHtmlPart(27)
}
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',116,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',116,['class':("create"),'action':("create")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',118,['action':("atmTerminalView")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',119,['controller':("ATMInterface"),'action':("atmTxnDetails"),'id':(params.atmtxnid),'params':(['atmtxnid': params.atmtxnid])],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127909L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
