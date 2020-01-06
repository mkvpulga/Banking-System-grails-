import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
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
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',32,['property':("code"),'title':(message(code: 'customerGroup.code.label', default: 'Code'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',34,['property':("name"),'title':(message(code: 'customerGroup.name.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("name"),'title':(message(code: 'customerGroup.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( customerGroupInstance in (customerGroupInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
if(true && (customerGroupInstance?.configItemStatusId==2)) {
printHtmlPart(20)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "code"))
})
invokeTag('link','g',44,['action':("show"),'id':(customerGroupInstance.id)],5)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "name"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "configItemStatus.description"))
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',55,['total':(customerGroupInstanceCount ?: 0)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',57,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',60,['action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128275L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
