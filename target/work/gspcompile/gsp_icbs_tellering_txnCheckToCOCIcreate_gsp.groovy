import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckToCOCIcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckToCOCI/create.gsp" }
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
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',21,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',79,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(2)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
invokeTag('img','g',104,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
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
invokeTag('eachError','g',120,['bean':(txnCashTransferInstance),'var':("error")],4)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(17)
expressionOut.print(error.field)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',130,['error':(error)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',131,['bean':(txnCheckToCOCIInstance),'var':("error")],4)
printHtmlPart(21)
})
invokeTag('hasErrors','g',135,['bean':(txnCheckToCOCIInstance)],3)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('render','g',138,['template':("txnCheckToCOCI/form"),'model':([txnCheckToCOCIInstance:txnCheckToCOCIInstance])],-1)
printHtmlPart(11)
})
invokeTag('form','g',139,['name':("txnCheckToCOCIForm"),'action':("saveTellerCheckToCOCITxn"),'controller':("tellering")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',141,['tag':("main-content")],2)
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('jasperReport','g',145,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',161,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',163,['tag':("main-actions")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',164,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129496L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
