import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashFromVaultcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashFromVault/create.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'cashfromvault.css'))
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('javascript','g',38,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',39,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
invokeTag('img','g',63,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(it)
printHtmlPart(16)
})
invokeTag('eachError','g',79,['bean':(txnCashTransferInstance),'var':("error")],4)
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(19)
expressionOut.print(error.field)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('message','g',89,['error':(error)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',90,['bean':(txnCashFromVaultInstance),'var':("error")],4)
printHtmlPart(23)
})
invokeTag('hasErrors','g',94,['bean':(txnCashFromVaultInstance)],3)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('render','g',96,['template':("txnCashFromVault/form"),'model':([txnCashFromVaultInstance:txnCashFromVaultInstance])],-1)
printHtmlPart(9)
})
invokeTag('form','g',97,['name':("txnCashFromVaultForm"),'action':("saveTellerCashFromVaultTxn"),'controller':("tellering")],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',98,['tag':("main-content")],2)
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('jasperReport','g',101,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',145,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',148,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129437L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
