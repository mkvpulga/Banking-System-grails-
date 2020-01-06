import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchapproveBatch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/approveBatch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',6,[:],1)
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
invokeTag('message','g',21,['code':("glBatchHdrInstance.batchId.label"),'default':("Batch ID")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',22,['bean':(glBatchHdrInstance),'field':("batchId")],-1)
printHtmlPart(11)
invokeTag('message','g',25,['code':("glBatchHdrInstance.batchName.label"),'default':("Batch Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',26,['bean':(glBatchHdrInstance),'field':("batchName")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("glBatchHdrInstance.valueDate.label"),'default':("Batch Name")],-1)
printHtmlPart(12)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(glBatchHdrInstance?.valueDate)],-1)
printHtmlPart(14)
invokeTag('set','g',47,['var':("batchOk"),'value':(0)],-1)
printHtmlPart(15)
loop:{
int i = 0
for( glBatch in (glBatchInstance) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(glBatch.lineNo)
printHtmlPart(18)
if(true && (glBatch.debit != 0)) {
printHtmlPart(19)
expressionOut.print(glBatch.debitAccount)
printHtmlPart(18)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (glBatch.credit != 0)) {
printHtmlPart(19)
expressionOut.print(glBatch.creditAccount)
printHtmlPart(18)
}
else {
printHtmlPart(20)
}
printHtmlPart(22)
if(true && (glBatch.debit != 0)) {
printHtmlPart(23)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(glBatch?.debit)],-1)
printHtmlPart(18)
}
else {
printHtmlPart(20)
}
printHtmlPart(22)
if(true && (glBatch.credit != 0)) {
printHtmlPart(23)
invokeTag('formatNumber','g',70,['format':("###,###,##0.00"),'number':(glBatch?.credit)],-1)
printHtmlPart(18)
}
else {
printHtmlPart(20)
}
printHtmlPart(24)
expressionOut.print(glBatch.reference)
printHtmlPart(25)
expressionOut.print(glBatch.particulars)
printHtmlPart(26)
if(true && (glBatch.lineStatus)) {
printHtmlPart(27)
invokeTag('set','g',80,['var':("batchOk"),'value':(1)],-1)
printHtmlPart(28)
expressionOut.print(glBatch.lineStatus)
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',92,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',95,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id)],3)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',96,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance.id)],3)
printHtmlPart(38)
if(true && (batchOk==0)) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',98,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("glBatchApproval"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(38)
}
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',100,['class':("btn btn-primary btn-xs"),'action':("index")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',103,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128965L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
