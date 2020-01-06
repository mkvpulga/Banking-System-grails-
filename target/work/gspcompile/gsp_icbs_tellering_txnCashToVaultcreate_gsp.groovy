import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashToVaultcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashToVault/create.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'cashtovault.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'cashtovault.js'))
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('javascript','g',69,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',70,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
invokeTag('img','g',94,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(13)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(14)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',109,['bean':(txnCashToVaultInstance)],3)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('render','g',111,['template':("txnCashToVault/form"),'model':([txnCashToVaultInstance:txnCashToVaultInstance])],-1)
printHtmlPart(10)
})
invokeTag('form','g',112,['name':("txnCashToVaultForm"),'action':("saveTellerCashToVaultTxn"),'controller':("tellering")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',114,['tag':("main-content")],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('jasperReport','g',118,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',123,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',189,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',190,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129447L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
