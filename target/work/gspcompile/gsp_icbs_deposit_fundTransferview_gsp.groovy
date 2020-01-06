import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_fundTransferview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/fundTransfer/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'changeFundTransferCreditAcct'))
printHtmlPart(5)
expressionOut.print(fundTransferInstance?.fundingAcct?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(7)
})
invokeTag('javascript','g',52,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',53,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',76,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',77,['bean':(fundTransferInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',81,['bean':(fundTransferInstance)],3)
printHtmlPart(19)
invokeTag('render','g',86,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:fundTransferInstance?.fundingAcct?.customer])],-1)
printHtmlPart(20)
invokeTag('render','g',89,['template':("details/depositDetails"),'model':([depositInstance:fundTransferInstance?.fundingAcct])],-1)
printHtmlPart(21)
invokeTag('render','g',96,['template':("fundTransfer/templates/creditAccount"),'model':([fundTransferInstance:fundTransferInstance])],-1)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('render','g',104,['template':("fundTransfer/templates/transactionDetails"),'model':([fundTransferInstance:fundTransferInstance])],-1)
printHtmlPart(24)
})
invokeTag('form','g',106,['name':("transferFundsForm"),'action':("saveFundTransfer"),'class':("form-horizontal")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(fundTransferInstance.fundingAcct?.id)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',122,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128340L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
