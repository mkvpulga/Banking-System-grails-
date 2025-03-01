import icbs.admin.Holiday
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_holidayindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/holiday/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'holiday.label', default: 'Holiday'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',29,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',33,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',35,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',37,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',44,['property':("code"),'title':(message(code: 'holiday.code.label', default: 'Code'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',46,['property':("description"),'title':(message(code: 'holiday.description.label', default: 'Description'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',48,['property':("date"),'title':(message(code: 'holiday.date.label', default: 'Date'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',50,['property':("type"),'title':(message(code: 'holiday.type.label', default: 'Type'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',52,['property':("status"),'title':(message(code: 'holiday.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',54,['property':("status"),'title':(message(code: 'holiday.institutionWideHoliday.label', default: 'Bank Wide'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( holidayInstance in (holidayInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: holidayInstance, field: "code"))
})
invokeTag('link','g',62,['action':("show"),'id':(holidayInstance.id)],4)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: holidayInstance, field: "description"))
printHtmlPart(22)
invokeTag('formatDate','g',66,['format':("MM/dd/yyyy"),'date':(holidayInstance?.holidayDate)],-1)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: holidayInstance, field: "type"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: holidayInstance, field: "configItemStatus"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: holidayInstance, field: "institutionWideHoliday"))
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',80,['total':(HolidayInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',86,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',86,['class':("create"),'action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129018L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
