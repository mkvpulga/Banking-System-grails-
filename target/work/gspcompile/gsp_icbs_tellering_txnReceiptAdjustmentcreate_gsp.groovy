import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnReceiptAdjustmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnReceiptAdjustment/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',18,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
invokeTag('img','g',43,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
expressionOut.print(it)
printHtmlPart(14)
})
invokeTag('eachError','g',59,['bean':(txnReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(17)
expressionOut.print(error.field)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',70,['error':(error)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',71,['bean':(txnReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(21)
})
invokeTag('hasErrors','g',75,['bean':(txnReceiptAdjustmentInstance)],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('render','g',77,['template':("txnReceiptAdjustment/form"),'model':([txnReceiptAdjustmentInstance:txnReceiptAdjustmentInstance])],-1)
printHtmlPart(7)
})
invokeTag('form','g',78,['name':("txnReceiptAdjustmentForm"),'action':("saveTellerOtherCashReceiptAdjustmentTxn"),'controller':("tellering")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-content")],2)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('jasperReport','g',84,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',116,['action':("index")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-actions")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129553L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
