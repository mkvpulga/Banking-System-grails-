import icbs.gl.GlBatch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'General Ledger Batch'))],-1)
printHtmlPart(3)
if(true && (glBatchHdrInstance?.createdBy?.id==session.user_id)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
expressionOut.print(glBatchHdrInstance?.id)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(7)
createTagBody(3, {->
createClosureForHtmlPart(8, 4)
invokeTag('captureTitle','sitemesh',20,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',20,[:],3)
printHtmlPart(2)
}
else {
printHtmlPart(9)
createTagBody(3, {->
createClosureForHtmlPart(10, 4)
invokeTag('captureTitle','sitemesh',23,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',23,[:],3)
printHtmlPart(2)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(createLink(controller:'glBatch',action:'getBatchByBatchIdAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'glBatch',action:'getBatchDetailsAjax'))
printHtmlPart(14)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(15)
expressionOut.print(createLink(controller:'glBatch',action:'updateBatchGLTransactions'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'glBatch',action:'saveGLBatchTransactions'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'GlBatch',action:'addAttachment'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'GlBatch',action:'removeAttachment'))
printHtmlPart(21)
})
invokeTag('javascript','g',159,[:],2)
printHtmlPart(22)
})
invokeTag('captureHead','sitemesh',160,[:],1)
printHtmlPart(22)
createTagBody(1, {->
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
if(true && (flash.message)) {
printHtmlPart(25)
expressionOut.print(flash.message)
printHtmlPart(26)
}
printHtmlPart(27)
createTagBody(3, {->
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(29)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(30)
expressionOut.print(error.field)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('message','g',173,['error':(error)],-1)
printHtmlPart(33)
})
invokeTag('eachError','g',174,['bean':(glBatchInstance),'var':("error")],4)
printHtmlPart(34)
})
invokeTag('hasErrors','g',176,['bean':(glBatchInstance)],3)
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('render','g',188,['template':("form")],-1)
printHtmlPart(37)
})
invokeTag('form','g',190,['url':([resource:glBatchInstance, action:'save'])],3)
printHtmlPart(38)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('render','g',208,['template':("transactions_table")],-1)
printHtmlPart(42)
invokeTag('render','g',212,['template':("batch_attachment")],-1)
printHtmlPart(43)
invokeTag('render','g',217,['template':("modal")],-1)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',221,['tag':("main-content")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(46)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(47)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(48)
invokeTag('message','g',225,['code':("default.home.label")],-1)
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',226,['class':("list"),'action':("index")],4)
printHtmlPart(51)
createClosureForHtmlPart(52, 4)
invokeTag('link','g',227,['class':("create"),'action':("create")],4)
printHtmlPart(53)
}
else {
printHtmlPart(54)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(48)
invokeTag('message','g',230,['code':("default.home.label")],-1)
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',231,['class':("list"),'action':("index")],4)
printHtmlPart(51)
createClosureForHtmlPart(52, 4)
invokeTag('link','g',232,['class':("create"),'action':("create")],4)
printHtmlPart(55)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(56)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',235,['class':("printGlBatch"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(51)
createClosureForHtmlPart(58, 4)
invokeTag('link','g',236,['class':("voucherDetailsCheck"),'action':("voucherDetailsCheck"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(51)
createClosureForHtmlPart(59, 4)
invokeTag('link','g',237,['class':("printGlBatchVoucher"),'target':("_blank"),'action':("printGlBatchVoucher"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(60)
}
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',261,['tag':("main-actions")],2)
printHtmlPart(62)
})
invokeTag('captureBody','sitemesh',261,[:],1)
printHtmlPart(63)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128968L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
