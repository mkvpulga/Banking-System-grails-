import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchviewMyBatchTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/viewMyBatchTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glBatchHdr.label', default: 'GL Batch Transactions'))],-1)
printHtmlPart(1)
if(true && (postedOnOff=='postedOff')) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(1)
}
else {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(1)
}
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'glBatch',action:'processBatchAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'glBatch',action:'getGLAcctByBranch'))
printHtmlPart(8)
})
invokeTag('javascript','g',18,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.error)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (flash.error)) {
printHtmlPart(14)
expressionOut.print(flash.error)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('select','g',42,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(18)
invokeTag('textField','g',46,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',47,['name':("showview"),'id':("showview"),'value':(postedTransaction)],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('submitButton','g',49,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(22)
})
invokeTag('form','g',51,['class':("form-inline"),'url':([action:'viewMyBatchTransactions',controller:'glBatch'])],3)
printHtmlPart(23)
invokeTag('sortableColumn','g',56,['property':("id"),'title':(message(code: 'glBatchHdr.id.label', default: 'Batch Series'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',57,['property':("batchId"),'title':(message(code: 'glBatchHdr.batchId.label', default: 'Batch ID'))],-1)
printHtmlPart(24)
invokeTag('message','g',58,['code':("glBatchHdr.errorGl.label"),'default':("Batch Name")],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',60,['property':("batchType"),'title':(message(code: 'glBatchHdr.batchType.label', default: 'Branch'))],-1)
printHtmlPart(26)
invokeTag('sortableColumn','g',62,['property':("batchParticulars"),'title':(message(code: 'glBatchHdr.batchParticulars.label', default: 'Total Debits'))],-1)
printHtmlPart(27)
invokeTag('message','g',64,['code':("glBatchHdr.loanAcct.label"),'default':("Total Credits")],-1)
printHtmlPart(28)
invokeTag('sortableColumn','g',66,['property':("batchStatus"),'title':(message(code: 'glBatchHdr.batchStatus.label', default: 'Batch Status'))],-1)
printHtmlPart(29)
loop:{
int i = 0
for( glBatchHdrInstance in (glBatchHdrInstanceList) ) {
printHtmlPart(30)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(31)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "id"))
printHtmlPart(32)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
printHtmlPart(33)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
})
invokeTag('link','g',83,['action':("edit"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(34)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchName"))
printHtmlPart(35)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "branch.name"))
printHtmlPart(36)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalDebit)],-1)
printHtmlPart(37)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalCredit)],-1)
printHtmlPart(38)
expressionOut.print(glBatchHdrInstance.status.description)
printHtmlPart(39)
if(true && (postedOnOff=='postedOff')) {
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "createdBy.username"))
printHtmlPart(32)
createClosureForHtmlPart(43, 4)
invokeTag('link','g',100,['class':("btn btn-primary btn-xs"),'action':("batchDetails"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(44)
i++
}
}
printHtmlPart(45)
invokeTag('paginate','g',102,['total':(GlBatchHdrInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(46)
if(true && (postedOnOff=='postedOn')) {
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',103,['class':("prevDaysArchive"),'action':("prevDaysArchive")],4)
printHtmlPart(13)
}
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(50)
createTagBody(2, {->
printHtmlPart(51)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(52)
invokeTag('message','g',108,['code':("default.home.label")],-1)
printHtmlPart(53)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',109,['class':("list"),'action':("index")],3)
printHtmlPart(55)
if(true && (postedOnOff=='postedOn')) {
printHtmlPart(56)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',112,['action':("index"),'class':("btn btn-primary btn-xs")],4)
printHtmlPart(55)
}
printHtmlPart(58)
createTagBody(3, {->
invokeTag('message','g',115,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',115,['class':("create"),'action':("create")],3)
printHtmlPart(59)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',116,['action':("index"),'class':("btn btn-primary btn-xs"),'params':([showview: 'posted'])],3)
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',119,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',120,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128974L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
