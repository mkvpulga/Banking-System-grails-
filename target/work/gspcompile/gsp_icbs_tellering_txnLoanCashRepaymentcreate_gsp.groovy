import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCashRepaymentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCashRepayment/create.gsp" }
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
expressionOut.print(createLink(controller : 'tellering', action:'changeLoanDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'tellering', action:'changeLoanDetails'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'loan', action:'search', params:[searchDomain: "loan"]))
printHtmlPart(10)
})
invokeTag('javascript','g',157,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',158,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
invokeTag('img','g',182,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
invokeTag('img','g',190,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
}
printHtmlPart(13)
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
invokeTag('message','g',214,['error':(error)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',215,['bean':(txnLoanCashRepaymentInstance),'var':("error")],4)
printHtmlPart(25)
})
invokeTag('hasErrors','g',219,['bean':(txnLoanCashRepaymentInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('render','g',221,['template':("txnLoanCashRepayment/form"),'model':([txnLoanCashRepaymentInstance:txnLoanCashRepaymentInstance])],-1)
printHtmlPart(13)
})
invokeTag('form','g',222,['name':("txnLoanCashRepaymentForm"),'action':("saveTellerLoanCashRepaymentTxn"),'controller':("tellering")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',224,['tag':("main-content")],2)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('jasperReport','g',228,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',267,['action':("index")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',269,['tag':("main-actions")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',270,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129519L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
