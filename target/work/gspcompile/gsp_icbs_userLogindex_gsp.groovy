import icbs.audit.AuditLog
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userLogindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userLog/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'auditLog.label', default: 'AuditLog'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
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
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('message','g',32,['code':("auditLog.auditType.label"),'default':("User")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("date"),'title':(message(code: 'auditLog.date.label', default: 'Date/Time'))],-1)
printHtmlPart(17)
invokeTag('message','g',36,['code':("auditLog.module.label"),'default':("Activity")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',39,['property':("ipAddress"),'title':(message(code: 'auditLog.ipAddress.label', default: 'IP Address'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( auditLogInstance in (auditLogInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "userMaster.name"))
printHtmlPart(22)
expressionOut.print(auditLogInstance.date)
printHtmlPart(23)
expressionOut.print(auditLogInstance.auditType.description)
printHtmlPart(24)
expressionOut.print(auditLogInstance.description)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "ipAddress"))
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',65,['total':(AuditLogInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',71,['controller':("UserLog"),'action':("changeLog")],3)
printHtmlPart(30)
invokeTag('select','g',87,['id':("audittype"),'name':("audittype"),'from':(icbs.lov.AuditType.list()),'optionKey':("description"),'optionValue':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(32)
invokeTag('customDatePicker','g',94,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(34)
invokeTag('customDatePicker','g',99,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(26).baseParams)
printHtmlPart(37)
expressionOut.print(icbs.admin.Report.get(26).outputParam)
printHtmlPart(38)
expressionOut.print(icbs.admin.Report.get(26).reportUnit)
printHtmlPart(39)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(40)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(41)
})
invokeTag('javascript','g',121,[:],3)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',128,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129590L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
