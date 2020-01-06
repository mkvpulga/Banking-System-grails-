import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancecustomerResidentTypeIndex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/customerResidentTypeIndex.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':("CustomerResidentType")],-1)
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
if(true && (flash.success)) {
printHtmlPart(6)
expressionOut.print(flash.success)
printHtmlPart(7)
}
printHtmlPart(8)
loop:{
int i = 0
for( residentTypeInstance in (residentTypeInstanceList) ) {
printHtmlPart(9)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(10)
expressionOut.print(residentTypeInstance.code)
printHtmlPart(11)
expressionOut.print(residentTypeInstance.description)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('link','g',34,['class':("btn btn-secondary"),'action':("residentTypeInstanceEdit"),'id':(residentTypeInstance.id)],4)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',35,['class':("btn btn-secondary"),'action':("residentTypeInstanceDelete"),'id':(residentTypeInstance.id),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to delete this resident type?')}');")],4)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',41,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',44,['action':("residentTypeInstanceCreate")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',45,['action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',47,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',48,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129245L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
