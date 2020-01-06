import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_currencyindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/currency/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'currency.label', default: 'Currency'))],-1)
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
printHtmlPart(2)
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
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',36,['property':("code"),'title':(message(code: 'currency.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("name"),'title':(message(code: 'currency.name.label', default: 'Name'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',40,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( currencyInstance in (currencyInstanceList) ) {
printHtmlPart(19)
if(true && (currencyInstance.configItemStatusId==2)) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: currencyInstance, field: "code"))
})
invokeTag('link','g',48,['action':("show"),'id':(currencyInstance.id)],5)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: currencyInstance, field: "name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: currencyInstance, field: "configItemStatus.description"))
printHtmlPart(24)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',59,['total':(currencyInstanceCount ?: 0)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',65,['controller':("currency"),'action':("create")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128190L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
