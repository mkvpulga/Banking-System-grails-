import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchbatchDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/batchDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'branch.label', default: 'Branch'))],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'glBatch',action:'processBatchAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'glBatch',action:'getGLAcctByBranch'))
printHtmlPart(6)
})
invokeTag('javascript','g',16,[:],2)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(7, 3)
invokeTag('captureTitle','sitemesh',17,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',17,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(createLink(uri: '/branch'))
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',23,['tag':("breadcrumbs")],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(17)
invokeTag('formatDate','g',57,['format':("MM/dd/yyyy"),'date':(glBatchHdrInstance?.valueDate)],-1)
printHtmlPart(18)
invokeTag('set','g',59,['var':("batchType"),'value':(glBatchHdrInstance?.batchType as Integer)],-1)
printHtmlPart(19)
expressionOut.print(icbs.gl.GlBatchTemplate.get(batchType).description)
printHtmlPart(20)
expressionOut.print(glBatchHdrInstance?.batchName)
printHtmlPart(21)
expressionOut.print(glBatchHdrInstance?.branch?.name)
printHtmlPart(22)
expressionOut.print(glBatchHdrInstance?.batchCurrency?.name)
printHtmlPart(23)
expressionOut.print(glBatchHdrInstance?.status?.description)
printHtmlPart(24)
expressionOut.print(glBatchHdrInstance?.createdBy?.username)
printHtmlPart(25)
invokeTag('hiddenField','g',86,['id':("glBatchhid"),'name':("glBatchhid"),'value':(glBatchHdrInstance.id)],-1)
printHtmlPart(26)
invokeTag('set','g',89,['var':("debitCounter"),'value':(0.00D)],-1)
printHtmlPart(27)
invokeTag('set','g',90,['var':("creditCounter"),'value':(0.00D)],-1)
printHtmlPart(28)
for( batchTransactInstance in (batchTransactionInstance) ) {
printHtmlPart(29)
expressionOut.print(batchTransactInstance?.lineNo)
printHtmlPart(30)
expressionOut.print(batchTransactInstance?.debitAccount)
printHtmlPart(30)
expressionOut.print(batchTransactInstance?.creditAccount)
printHtmlPart(30)
expressionOut.print(batchTransactInstance?.accountName)
printHtmlPart(31)
invokeTag('formatNumber','g',114,['format':("###,###,##0.00"),'number':(batchTransactInstance?.debit)],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',116,['format':("###,###,##0.00"),'number':(batchTransactInstance?.credit)],-1)
printHtmlPart(30)
expressionOut.print(batchTransactInstance?.particulars)
printHtmlPart(32)
}
printHtmlPart(33)
for( batchTransactInstance in (batchTransactionInstance) ) {
printHtmlPart(34)
if(true && (batchTransactInstance?.debit)) {
printHtmlPart(35)
invokeTag('set','g',126,['var':("debitCounter"),'value':(debitCounter = debitCounter + batchTransactInstance?.debit)],-1)
printHtmlPart(36)
}
printHtmlPart(34)
if(true && (batchTransactInstance?.credit)) {
printHtmlPart(35)
invokeTag('set','g',129,['var':("creditCounter"),'value':(creditCounter = creditCounter + batchTransactInstance?.credit)],-1)
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('formatNumber','g',135,['format':("###,###,##0.00"),'number':(debitCounter)],-1)
printHtmlPart(39)
invokeTag('formatNumber','g',139,['format':("###,###,##0.00"),'number':(creditCounter)],-1)
printHtmlPart(40)
invokeTag('formatNumber','g',143,['format':("###,###,##0.00"),'number':(debitCounter - creditCounter)],-1)
printHtmlPart(41)
loop:{
int i = 0
for( batchAttachInstance in (batchAttachmentInstance) ) {
printHtmlPart(42)
expressionOut.print(i + 1)
printHtmlPart(43)
createTagBody(4, {->
expressionOut.print(batchAttachInstance?.filename)
})
invokeTag('link','g',166,['action':("downloadAttachment"),'id':(batchAttachInstance.id),'target':("_blank")],4)
printHtmlPart(43)
expressionOut.print(batchAttachInstance?.reference)
printHtmlPart(43)
expressionOut.print(batchAttachInstance?.particulars)
printHtmlPart(43)
invokeTag('formatDate','g',169,['format':("MM/dd/yyyy"),'date':(batchAttachInstance?.uploadDate)],-1)
printHtmlPart(43)
expressionOut.print(batchAttachInstance?.attachedBy?.username)
printHtmlPart(44)
i++
}
}
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',181,['tag':("main-content")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(46)
if(true && (glBatchHdrInstance.status.id == 2)) {
printHtmlPart(47)
expressionOut.print(glBatchHdrInstance.batchId)
printHtmlPart(48)
}
else {
printHtmlPart(49)
if(true && (glBatchHdrInstance.status.id == 3)) {
printHtmlPart(50)
}
else {
printHtmlPart(51)
expressionOut.print(glBatchHdrInstance.batchId)
printHtmlPart(52)
createClosureForHtmlPart(53, 5)
invokeTag('link','g',202,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id)],5)
printHtmlPart(54)
if(true && (glBatchHdrInstance?.branch?.id == icbs.admin.UserMaster.get(session.user_id).branch?.id)) {
printHtmlPart(55)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(56)
}
else {
printHtmlPart(57)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(58)
}
printHtmlPart(59)
}
printHtmlPart(60)
}
printHtmlPart(61)
createClosureForHtmlPart(62, 3)
invokeTag('link','g',210,['class':("list"),'action':("index")],3)
printHtmlPart(63)
createClosureForHtmlPart(64, 3)
invokeTag('link','g',211,['class':("create"),'action':("create")],3)
printHtmlPart(63)
createClosureForHtmlPart(65, 3)
invokeTag('link','g',213,['class':("printGlBatch"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],3)
printHtmlPart(66)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch?.id)
printHtmlPart(67)
expressionOut.print(glBatchHdrInstance?.status?.id)
printHtmlPart(68)
expressionOut.print(createLink(controller:'glBatch',action:'processBatchAjax'))
printHtmlPart(69)
expressionOut.print(glBatchHdrInstance?.createdBy?.id)
printHtmlPart(70)
expressionOut.print(session.user_id)
printHtmlPart(71)
expressionOut.print(createLink(controller:'GlBatch',action:'cancelBatchAjax'))
printHtmlPart(72)
expressionOut.print(glBatchHdrInstance?.id)
printHtmlPart(73)
})
invokeTag('captureContent','sitemesh',347,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',348,[:],1)
printHtmlPart(74)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128966L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
