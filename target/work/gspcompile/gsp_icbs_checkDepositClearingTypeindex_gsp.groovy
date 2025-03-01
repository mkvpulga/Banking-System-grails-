import icbs.admin.CheckDepositClearingType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_checkDepositClearingTypeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checkDepositClearingType/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'checkDepositClearingType.label', default: 'CheckDepositClearingType'))],-1)
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
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',23,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',25,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',27,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',33,['property':("code"),'title':(message(code: 'checkDepositClearingType.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("description"),'title':(message(code: 'checkDepositClearingType.description.label', default: 'Description'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',38,['property':("isOnUs"),'title':(message(code: 'checkDepositClearingType.isOnUs.label', default: 'Is On Us'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("clearingDays"),'title':(message(code: 'checkDepositClearingType.clearingDays.label', default: 'Clearing Days'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',42,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( checkDepositClearingTypeInstance in (checkDepositClearingTypeInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.configItemStatusId==2)) {
printHtmlPart(22)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: checkDepositClearingTypeInstance, field: "code"))
})
invokeTag('link','g',50,['action':("show"),'id':(checkDepositClearingTypeInstance.id)],5)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: checkDepositClearingTypeInstance, field: "description"))
printHtmlPart(23)
invokeTag('formatBoolean','g',54,['boolean':(checkDepositClearingTypeInstance.isOnUs)],-1)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: checkDepositClearingTypeInstance, field: "clearingDays"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: checkDepositClearingTypeInstance, field: "configItemStatus.description"))
printHtmlPart(25)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',66,['total':(CheckDepositClearingTypeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',72,['class':("create"),'action':("create")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128008L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
