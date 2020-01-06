import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnSummaryViewviewSummary_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnSummaryView/viewSummary.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',59,['action':("createTellerCashFromVaultTxn")],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',60,['action':("createTellerCashTransferTxn")],3)
printHtmlPart(9)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',61,['action':("createTellerCheckToCOCITxn")],3)
printHtmlPart(9)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',62,['action':("createTellerCashToVaultTxn")],3)
printHtmlPart(9)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',63,['action':("index")],3)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-actions")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129561L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
