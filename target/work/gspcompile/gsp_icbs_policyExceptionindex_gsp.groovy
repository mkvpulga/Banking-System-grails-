import icbs.admin.PolicyException
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyExceptionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policyException/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'policyException.label', default: 'PolicyException'))],-1)
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
invokeTag('sortableColumn','g',34,['property':("dateOfRequest"),'title':(message(code: 'policyException.dateOfRequest.label', default: 'Exception Date'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("requestingUser"),'title':(message(code: 'policyException.requestingUser.label', default: 'Created By'))],-1)
printHtmlPart(17)
invokeTag('message','g',38,['code':("policyException.policyTemplate.label"),'default':("Policy")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',44,['property':("recordUrl"),'title':(message(code: 'policyException.recordUrl.label', default: 'Take Action'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( policyExceptionInstance in (policyExceptionInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
invokeTag('formatDate','g',54,['date':(policyExceptionInstance.dateOfRequest)],-1)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: policyExceptionInstance, field: "requestingUser.name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: policyExceptionInstance, field: "policyTemplate.description"))
printHtmlPart(24)
if(true && (policyExceptionInstance.dateOfAction)) {
printHtmlPart(25)
invokeTag('formatBoolean','g',62,['boolean':(policyExceptionInstance?.isApproved),'true':("Approved"),'false':("Disapproved")],-1)
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(fieldValue(bean: policyExceptionInstance, field: "approvingUser.name"))
printHtmlPart(22)
invokeTag('formatDate','g',68,['date':(policyExceptionInstance.dateOfAction)],-1)
printHtmlPart(28)
expressionOut.print(fieldValue(bean: policyExceptionInstance, field: "recordUrl"))
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
invokeTag('paginate','g',78,['total':(PolicyExceptionInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(5)
createClosureForHtmlPart(32, 2)
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129301L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
