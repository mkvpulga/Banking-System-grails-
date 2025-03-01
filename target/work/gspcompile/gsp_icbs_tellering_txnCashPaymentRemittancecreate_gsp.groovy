import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashPaymentRemittancecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashPaymentRemittance/create.gsp" }
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
})
invokeTag('javascript','g',34,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
invokeTag('img','g',59,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(15)
invokeTag('img','g',67,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(it)
printHtmlPart(18)
createTagBody(4, {->
printHtmlPart(19)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(20)
expressionOut.print(error.field)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('message','g',91,['error':(error)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',92,['bean':(txnCashPaymentRemittanceInstance),'var':("error")],4)
printHtmlPart(24)
})
invokeTag('hasErrors','g',96,['bean':(txnCashPaymentRemittanceInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(25)
invokeTag('render','g',98,['template':("txnCashPaymentRemittance/form"),'model':([txnCashPaymentRemittanceInstance:txnCashPaymentRemittanceInstance])],-1)
printHtmlPart(12)
})
invokeTag('form','g',99,['name':("txnCashPaymentRemittanceForm"),'action':("saveTellerOtherCashPaymentRemittanceTxn"),'controller':("tellering")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('jasperReport','g',104,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(29)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',151,['action':("index")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',153,['tag':("main-actions")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',154,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129441L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
