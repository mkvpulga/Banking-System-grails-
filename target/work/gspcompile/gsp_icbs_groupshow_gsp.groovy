import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_groupshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'group.label', default: 'Group'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller :'group', action:'updateStatusAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller :'group', action:'showUpdateStatusAjax', params:[id:groupInstance.id]))
printHtmlPart(7)
})
invokeTag('javascript','g',31,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('render','g',53,['template':("details/show")],-1)
printHtmlPart(13)
invokeTag('render','g',56,['template':("members/show")],-1)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',80,['class':("list"),'action':("index")],3)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',81,['action':("edit"),'id':(groupInstance?.id)],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129012L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
