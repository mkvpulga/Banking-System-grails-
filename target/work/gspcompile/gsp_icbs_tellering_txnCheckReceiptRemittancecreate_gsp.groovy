import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckReceiptRemittancecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckReceiptRemittance/create.gsp" }
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
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(5)
invokeTag('javascript','asset',13,['src':("telleringHelper.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'tellering', action:'showCustomerDetailsAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(14)
})
invokeTag('javascript','g',100,[:],2)
printHtmlPart(15)
})
invokeTag('captureHead','sitemesh',140,[:],1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
invokeTag('img','g',180,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(20)
invokeTag('img','g',188,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
expressionOut.print(it)
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(26)
expressionOut.print(error.field)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('message','g',212,['error':(error)],-1)
printHtmlPart(29)
})
invokeTag('eachError','g',213,['bean':(txnCheckReceiptRemittanceInstance),'var':("error")],4)
printHtmlPart(30)
})
invokeTag('hasErrors','g',216,['bean':(txnCheckReceiptRemittanceInstance)],3)
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('render','g',218,['template':("txnCheckReceiptRemittance/form"),'model':([txnCheckReceiptRemittanceInstance:txnCheckReceiptRemittanceInstance])],-1)
printHtmlPart(33)
})
invokeTag('form','g',219,['name':("txnCheckReceiptRemittanceForm"),'action':("saveTellerOtherCheckReceiptRemittanceTxn"),'controller':("tellering")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',221,['tag':("main-content")],2)
printHtmlPart(35)
createClosureForHtmlPart(36, 2)
invokeTag('jasperReport','g',225,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',279,['action':("index")],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',281,['tag':("main-actions")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',282,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129491L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
