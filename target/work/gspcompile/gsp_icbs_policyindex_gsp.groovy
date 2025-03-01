import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'policy.label', default: 'Policy'))],-1)
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
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',24,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',28,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',30,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',32,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("description"),'title':(message(code: 'policy.description.label', default: 'Description'))],-1)
printHtmlPart(17)
invokeTag('message','g',41,['code':("policy.type.label"),'default':("Type")],-1)
printHtmlPart(18)
invokeTag('message','g',43,['code':("policy.policyTemplate.label"),'default':("Policy Template")],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',45,['width':("150px"),'property':("txnAmtCondition"),'title':(message(code: 'policy.txnAmtCondition.label', default: 'Transaction Amount Condition'))],-1)
printHtmlPart(17)
invokeTag('message','g',47,['code':("policy.policyAction.label"),'default':("Policy Action")],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',49,['property':("reference"),'title':(message(code: 'policy.reference.label', default: 'Reference'))],-1)
printHtmlPart(21)
invokeTag('message','g',51,['code':("policy.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(22)
loop:{
int i = 0
for( policyInstance in (policyInstanceList) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: policyInstance, field: "description"))
})
invokeTag('link','g',59,['action':("show"),'id':(policyInstance.id)],4)
printHtmlPart(25)
expressionOut.print(fieldValue(bean: policyInstance, field: "policyTemplate.type"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: policyInstance, field: "policyTemplate.description"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: policyInstance, field: "txnAmtCondition"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: policyInstance, field: "policyAction.description"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: policyInstance, field: "reference"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: policyInstance, field: "configItemStatus.description"))
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',79,['total':(PolicyInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',85,['class':("create"),'action':("create")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129300L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
