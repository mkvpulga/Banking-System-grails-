import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCheckRepaymentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCheckRepayment/create.gsp" }
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
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(15)
})
invokeTag('javascript','g',228,[:],2)
printHtmlPart(16)
})
invokeTag('captureHead','sitemesh',267,[:],1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(18)
if(true && (flash.message)) {
printHtmlPart(19)
expressionOut.print(flash.message)
printHtmlPart(20)
invokeTag('img','g',307,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(21)
invokeTag('img','g',315,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
expressionOut.print(it)
printHtmlPart(25)
createTagBody(4, {->
printHtmlPart(26)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(27)
expressionOut.print(error.field)
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('message','g',339,['error':(error)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',340,['bean':(txnLoanCheckRepaymentInstance),'var':("error")],4)
printHtmlPart(31)
})
invokeTag('hasErrors','g',344,['bean':(txnLoanCheckRepaymentInstance)],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('render','g',346,['template':("txnLoanCheckRepayment/form"),'model':([txnLoanCheckRepaymentInstance:txnLoanCheckRepaymentInstance])],-1)
printHtmlPart(23)
})
invokeTag('form','g',347,['name':("txnLoanCheckRepaymentForm"),'action':("saveTellerLoanCheckRepaymentTxn"),'controller':("tellering")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',349,['tag':("main-content")],2)
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('jasperReport','g',353,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',409,['action':("index")],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',411,['tag':("main-actions")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',412,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129527L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
