import icbs.admin.ForexRate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'forexRate.label', default: 'ForexRate'))],-1)
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
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',27,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',29,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',31,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('message','g',38,['code':("forexRate.currency.label"),'default':("Currency")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("date"),'title':(message(code: 'forexRate.date.label', default: 'Date'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',42,['property':("rate"),'title':(message(code: 'forexRate.rate.label', default: 'Rate'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',44,['property':("refRate"),'title':(message(code: 'forexRate.refRate.label', default: 'Ref Rate'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( forexRateInstance in (forexRateInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: forexRateInstance, field: "currency.name"))
})
invokeTag('link','g',52,['action':("show"),'id':(forexRateInstance.id)],4)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: forexRateInstance, field: "date"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: forexRateInstance, field: "rate"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: forexRateInstance, field: "refRate"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',66,['total':(ForexRateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',72,['class':("create"),'action':("create")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128946L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
