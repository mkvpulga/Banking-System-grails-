import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceshowRequestDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/showRequestDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(atmRequestInstance?.sourceIp)
printHtmlPart(8)
expressionOut.print(atmRequestInstance?.msgLength)
printHtmlPart(9)
expressionOut.print(atmRequestInstance?.dateReceived)
printHtmlPart(10)
expressionOut.print(atmRequestInstance?.msgContent)
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',54,['tag':("main-content")],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',58,['action':("index"),'controller':("ATMInterface")],3)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',59,['action':("viewAtmMsgRequest")],3)
printHtmlPart(15)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',60,['action':("viewResponseDetails"),'controller':("ATMInterface")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127903L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
