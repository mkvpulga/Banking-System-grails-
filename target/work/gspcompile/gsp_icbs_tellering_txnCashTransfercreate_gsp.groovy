import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashTransfercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashTransfer/create.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'cashtransfer.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'cashtransfer.js'))
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(7)
createClosureForHtmlPart(8, 1)
invokeTag('javascript','g',39,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('javascript','g',78,[:],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
invokeTag('img','g',99,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(15)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(16)
expressionOut.print(it)
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(19)
expressionOut.print(error.field)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('message','g',123,['error':(error)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',124,['bean':(txnCashTransferInstance),'var':("error")],4)
printHtmlPart(23)
})
invokeTag('hasErrors','g',128,['bean':(txnCashTransferInstance)],3)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
invokeTag('render','g',131,['template':("txnCashTransfer/form"),'model':([txnCashTransferInstance:txnCashTransferInstance])],-1)
printHtmlPart(10)
})
invokeTag('form','g',132,['name':("txnCashTransferForm"),'action':("saveTellerCashTransferTxn"),'controller':("tellering")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',134,['tag':("main-content")],2)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('jasperReport','g',137,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',141,['action':("receiveTellerCashTransfer")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',142,['action':("index")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',217,['tag':("main-actions")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',218,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129453L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
