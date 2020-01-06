import icbs.audit.AuditValue
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userLogchangeLog_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userLog/changeLog.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'auditValue.label', default: 'AuditValue'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',24,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',26,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',28,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('message','g',33,['code':("auditValue.user.label"),'default':("User")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("dateStamp"),'title':(message(code: 'auditValue.dateStamp.label', default: 'Date/Time'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',35,['property':("dataTable"),'title':(message(code: 'auditValue.dataTable.label', default: 'Data Table'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',36,['property':("dataField"),'title':(message(code: 'auditValue.dataField.label', default: 'Data Field'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',37,['property':("oldValue"),'title':(message(code: 'auditValue.oldValue.label', default: 'Old Value'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',38,['property':("newValue"),'title':(message(code: 'auditValue.newValue.label', default: 'New Field'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( valueInstance in (values) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(valueInstance.user.username)
printHtmlPart(22)
expressionOut.print(valueInstance.dateStamp)
printHtmlPart(22)
expressionOut.print(valueInstance.dataTable)
printHtmlPart(22)
expressionOut.print(valueInstance.dataField)
printHtmlPart(22)
expressionOut.print(valueInstance.oldValue)
printHtmlPart(22)
expressionOut.print(valueInstance.newValue)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',56,['total':(AuditLogInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',59,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',62,['controller':("UserLog"),'action':("index")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129586L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
