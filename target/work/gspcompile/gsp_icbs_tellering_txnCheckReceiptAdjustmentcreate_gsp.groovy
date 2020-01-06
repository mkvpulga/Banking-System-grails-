import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckReceiptAdjustmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckReceiptAdjustment/create.gsp" }
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
printHtmlPart(4)
invokeTag('javascript','asset',12,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(10)
})
invokeTag('javascript','g',87,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',126,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
invokeTag('img','g',165,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(21)
expressionOut.print(error.field)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('message','g',189,['error':(error)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',190,['bean':(txnCheckReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(25)
})
invokeTag('hasErrors','g',194,['bean':(txnCheckReceiptAdjustmentInstance)],3)
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('render','g',196,['template':("txnCheckReceiptAdjustment/form"),'model':([txnCheckReceiptAdjustmentInstance:txnCheckReceiptAdjustmentInstance])],-1)
printHtmlPart(17)
})
invokeTag('form','g',197,['name':("txnCheckReceiptAdjustmentForm"),'action':("saveTellerOtherCheckReceiptAdjustmentTxn"),'controller':("tellering")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',199,['tag':("main-content")],2)
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('jasperReport','g',203,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',248,['action':("index")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',250,['tag':("main-actions")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',251,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129486L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
