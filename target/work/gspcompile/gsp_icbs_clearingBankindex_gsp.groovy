import icbs.admin.ClearingBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_clearingBankindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/clearingBank/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'clearingBank.label', default: 'ClearingBank'))],-1)
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
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',29,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',33,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("code"),'title':(message(code: 'clearingBank.code.label', default: 'Code'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',42,['property':("name"),'title':(message(code: 'clearingBank.name.label', default: 'Name'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',44,['property':("shortName"),'title':(message(code: 'clearingBank.shortName.label', default: 'Short Name'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',46,['property':("contactPerson"),'title':(message(code: 'clearingBank.contactPerson.label', default: 'Contact Person'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( clearingBankInstance in (clearingBankInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
if(true && (clearingBankInstance.configItemStatusId==2)) {
printHtmlPart(21)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: clearingBankInstance, field: "code"))
})
invokeTag('link','g',54,['action':("show"),'id':(clearingBankInstance.id)],5)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: clearingBankInstance, field: "name"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: clearingBankInstance, field: "shortName"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: clearingBankInstance, field: "contactPerson"))
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',68,['total':(ClearingBankInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',74,['class':("create"),'action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128028L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
