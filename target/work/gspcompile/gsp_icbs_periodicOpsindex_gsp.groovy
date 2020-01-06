import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("periodicOpsHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller : 'periodicOps', action:'startOfDayProgressAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfDayProgressAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfMonthProgressAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfYearProgressAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'periodicOps', action:'startOfDay'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfDay'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfMonth'))
printHtmlPart(12)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfYear'))
printHtmlPart(13)
})
invokeTag('javascript','g',93,[:],2)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',94,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatDate','g',118,['date':(Branch.get(1).runDate),'format':(" MMMMMMMMM dd "),', locale':(Locale.ENGLISH)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',118,['date':(Branch.get(1).runDate),'format':(" yyyy "),', locale':(Locale.ENGLISH)],-1)
printHtmlPart(20)
expressionOut.print(createLink(controller : 'periodicOps', action:'getStartOfDayReport'))
printHtmlPart(21)
invokeTag('formatDate','g',151,['date':(Branch.get(1).runDate),'format':(" MMMMMMMMM dd "),', locale':(Locale.ENGLISH)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',151,['date':(Branch.get(1).runDate),'format':(" yyyy "),', locale':(Locale.ENGLISH)],-1)
printHtmlPart(22)
expressionOut.print(createLink(controller : 'periodicOps', action:'getEndOfDayReport'))
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',198,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(24)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',202,['class':("lockSystem"),'action':("lockSystem")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',203,['class':("unlockSystem"),'action':("unlockSystem")],3)
printHtmlPart(27)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',204,['class':("EODCheck"),'action':("EODCheck")],3)
printHtmlPart(27)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',205,['class':("eodReports"),'action':("eodReport")],3)
printHtmlPart(27)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',206,['class':("eomReports"),'action':("eomReport")],3)
printHtmlPart(27)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',207,['class':("periodicOpsUtil"),'action':("periodicOpsUtil")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',208,['tag':("main-actions")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',208,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129282L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
