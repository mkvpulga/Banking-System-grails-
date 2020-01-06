import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/index.gsp" }
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
createTagBody(4, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(1)
}
else {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(1)
}
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'glBatch',action:'processBatchAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'glBatch',action:'getGLAcctByBranch'))
printHtmlPart(7)
})
invokeTag('javascript','g',18,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.error)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (flash.error)) {
printHtmlPart(13)
expressionOut.print(flash.error)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('select','g',42,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(17)
invokeTag('textField','g',46,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',47,['name':("showview"),'id':("showview"),'value':(postedTransaction)],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 4)
invokeTag('submitButton','g',49,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(21)
})
invokeTag('form','g',51,['class':("form-inline")],3)
printHtmlPart(22)
invokeTag('sortableColumn','g',56,['property':("id"),'title':(message(code: 'glBatchHdr.id.label', default: 'Batch Series'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',57,['property':("batchId"),'title':(message(code: 'glBatchHdr.batchId.label', default: 'Batch ID'))],-1)
printHtmlPart(23)
invokeTag('message','g',58,['code':("glBatchHdr.errorGl.label"),'default':("Batch Name")],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',60,['property':("batchType"),'title':(message(code: 'glBatchHdr.batchType.label', default: 'Branch'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',62,['property':("batchParticulars"),'title':(message(code: 'glBatchHdr.batchParticulars.label', default: 'Total Debits'))],-1)
printHtmlPart(26)
invokeTag('message','g',64,['code':("glBatchHdr.loanAcct.label"),'default':("Total Credits")],-1)
printHtmlPart(27)
invokeTag('sortableColumn','g',66,['property':("batchStatus"),'title':(message(code: 'glBatchHdr.batchStatus.label', default: 'Batch Status'))],-1)
printHtmlPart(28)
loop:{
int i = 0
for( glBatchHdrInstance in (glBatchHdrInstanceList) ) {
printHtmlPart(29)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(30)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "id"))
printHtmlPart(31)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
})
invokeTag('link','g',83,['action':("edit"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(33)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchName"))
printHtmlPart(34)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "branch.name"))
printHtmlPart(35)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalDebit)],-1)
printHtmlPart(36)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalCredit)],-1)
printHtmlPart(37)
expressionOut.print(glBatchHdrInstance.status.description)
printHtmlPart(38)
if(true && (postedOnOff=='postedOff')) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "createdBy.username"))
printHtmlPart(31)
createClosureForHtmlPart(42, 4)
invokeTag('link','g',100,['class':("btn btn-primary btn-xs"),'action':("batchDetails"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(43)
i++
}
}
printHtmlPart(44)
invokeTag('paginate','g',102,['total':(GlBatchHdrInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(45)
if(true && (postedOnOff=='postedOn')) {
printHtmlPart(46)
createClosureForHtmlPart(47, 4)
invokeTag('link','g',103,['class':("prevDaysArchive"),'action':("prevDaysArchive")],4)
printHtmlPart(12)
}
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(49)
createTagBody(2, {->
printHtmlPart(50)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(51)
invokeTag('message','g',108,['code':("default.home.label")],-1)
printHtmlPart(52)
if(true && (postedOnOff=='postedOn')) {
printHtmlPart(53)
createClosureForHtmlPart(54, 4)
invokeTag('link','g',110,['action':("index"),'class':("btn btn-primary btn-xs")],4)
printHtmlPart(55)
}
printHtmlPart(56)
createTagBody(3, {->
invokeTag('message','g',113,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',113,['class':("create"),'action':("create")],3)
printHtmlPart(57)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',115,['action':("index"),'class':("btn btn-primary btn-xs"),'params':([showview: 'posted'])],3)
printHtmlPart(59)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',119,['class':("viewMyBatchTransactions"),'action':("viewMyBatchTransactions")],3)
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128969L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
