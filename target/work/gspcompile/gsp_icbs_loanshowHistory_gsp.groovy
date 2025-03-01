import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanshowHistory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/showHistory.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(loanHistoryInstance?.customer?.id)
printHtmlPart(6)
})
invokeTag('javascript','g',31,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('render','g',62,['template':("loanApplication/show")],-1)
printHtmlPart(13)
invokeTag('render','g',65,['template':("specification/show")],-1)
printHtmlPart(14)
invokeTag('render','g',68,['template':("classification/show")],-1)
printHtmlPart(15)
invokeTag('render','g',71,['template':("serviceCharges/show")],-1)
printHtmlPart(16)
invokeTag('render','g',74,['template':("deductions/show")],-1)
printHtmlPart(17)
invokeTag('render','g',77,['template':("advancedInterests/list")],-1)
printHtmlPart(18)
invokeTag('render','g',80,['template':("installments/schedule")],-1)
printHtmlPart(19)
invokeTag('render','g',83,['template':("sweep/show")],-1)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',90,['action':("show"),'id':(origLoanInstance?.id)],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',92,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',93,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129134L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
