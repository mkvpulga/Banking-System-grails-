import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_ctdview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/ctd/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'createCTDAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'saveCTDAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'deposit', action:'editCTDAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'deposit', action:'updateCTDAjax'))
printHtmlPart(10)
})
invokeTag('javascript','g',55,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',56,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('render','g',61,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(13)
invokeTag('render','g',64,['template':("details/ctdDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(14)
invokeTag('render','g',69,['template':("/search/searchTemplate/deposit/ctd/viewGrid")],-1)
printHtmlPart(15)
invokeTag('render','g',80,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(16)
invokeTag('render','g',99,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',110,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(18)
if(true && (depositInstance)) {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(depositInstance?.id)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',124,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128296L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
