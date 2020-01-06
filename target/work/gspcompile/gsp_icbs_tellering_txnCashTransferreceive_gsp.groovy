import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashTransferreceive_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashTransfer/receive.gsp" }
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
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',56,[:],3)
printHtmlPart(9)
invokeTag('hiddenField','g',59,['id':("txnfile"),'name':("myField"),'value':(session["transactionFileId"])],-1)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('render','g',61,['template':("txnCashTransfer/receiveform"),'model':([txnCashTransferInstance:txnCashTransferInstance,sourcetxn:sourcetxn])],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',62,['id':("tlrcashsave"),'value':("Sum"),'action':("receiveTellerCashTransferSave"),'style':("display:none")],-1)
printHtmlPart(11)
invokeTag('actionSubmit','g',63,['id':("tlrcashcancel"),'value':("Difference"),'action':("receiveTellerCashCancel"),'style':("display:none")],-1)
printHtmlPart(7)
})
invokeTag('form','g',64,['name':("txnCashTransferForm"),'controller':("tellering")],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printValidationSlip', params: [txnFile:session.transactionFileId]))
printHtmlPart(15)
invokeTag('img','g',87,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',94,['tag':("main-content")],2)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('jasperReport','g',97,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(message(code: 'Receive', default: 'Receive'))
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',102,['action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',151,['tag':("main-actions")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',152,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129467L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
