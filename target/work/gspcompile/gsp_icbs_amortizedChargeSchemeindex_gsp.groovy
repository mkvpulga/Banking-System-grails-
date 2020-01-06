import icbs.loans.AmortizedChargeScheme
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_amortizedChargeSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/amortizedChargeScheme/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'amortizedChargeScheme.label', default: 'AmortizedChargeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
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
invokeTag('select','g',27,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',30,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Code or Name")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',32,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',37,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',43,['property':("code"),'title':(message(code: 'amortizedChargeScheme.code.label', default: 'Code'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',45,['property':("name"),'title':(message(code: 'amortizedChargeScheme.name.label', default: 'Name'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',47,['property':("name"),'title':(message(code: 'amortizedChargeScheme.basis.label', default: 'Basis'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',49,['property':("status"),'title':(message(code: 'amortizedChargeScheme.status.label', default: 'Status'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( amortizedChargeSchemeInstance in (amortizedChargeSchemeInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(fieldValue(bean: amortizedChargeSchemeInstance, field: "code"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: amortizedChargeSchemeInstance, field: "name"))
printHtmlPart(20)
expressionOut.print(amortizedChargeSchemeInstance?.basis?.description)
printHtmlPart(19)
expressionOut.print(amortizedChargeSchemeInstance?.status?.description)
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',64,['class':("btn btn-secondary"),'action':("show"),'id':(amortizedChargeSchemeInstance.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',71,['total':(amortizedChargeSchemeInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',77,['class':("create"),'action':("create")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127890L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
