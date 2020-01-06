import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
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
invokeTag('render','g',30,['template':("details/show")],-1)
printHtmlPart(9)
invokeTag('render','g',33,['template':("attachments/show")],-1)
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',35,['tag':("main-content")],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',38,['class':("list"),'action':("index")],3)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',43,['action':("edit"),'controller':("creditInvestigation"),'id':(creditInvestigationInstance.id)],3)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(17).baseParams)
printHtmlPart(18)
expressionOut.print(icbs.admin.Report.get(17).outputParam)
printHtmlPart(19)
expressionOut.print(icbs.admin.Report.get(17).reportUnit)
printHtmlPart(20)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(21)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(22)
})
invokeTag('javascript','g',52,[:],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128163L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
