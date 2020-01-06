import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_specification_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/specification/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatNumber','g',10,['format':("#"),'groupingUsed':("true"),'number':(fieldValue(bean: loanApplicationInstance, field: "id"))],-1)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(2)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.customer?.displayName)
})
invokeTag('link','g',18,['controller':("customer"),'action':("customerInquiry"),'id':(loanApplicationInstance?.customer?.id)],1)
printHtmlPart(3)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.product?.name)
})
invokeTag('link','g',46,['controller':("product"),'action':("show"),'id':(loanApplicationInstance?.product?.id)],1)
printHtmlPart(4)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.branch?.name)
})
invokeTag('link','g',50,['controller':("branch"),'action':("show"),'id':(loanApplicationInstance?.branch?.id)],1)
printHtmlPart(5)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(6)
invokeTag('formatNumber','g',58,['format':("###,##0.00"),'number':(loanApplicationInstance?.amount)],-1)
printHtmlPart(7)
invokeTag('fieldValue','g',62,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(8)
invokeTag('fieldValue','g',66,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.accountOfficer?.name)
})
invokeTag('link','g',70,['controller':("group"),'action':("show"),'id':(loanApplicationInstance?.accountOfficer?.id)],1)
printHtmlPart(10)
invokeTag('formatDate','g',75,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance.applicationDate)],-1)
printHtmlPart(11)
if(true && (validateExistingLoanApplicationIdtoLoan)) {
printHtmlPart(12)
for( loan in (validateExistingLoanApplicationIdtoLoan) ) {
printHtmlPart(13)
expressionOut.print(loan?.id)
printHtmlPart(14)
expressionOut.print(loan?.branch?.name)
printHtmlPart(15)
expressionOut.print(loan?.customer?.displayName)
printHtmlPart(15)
expressionOut.print(loan?.accountNo)
printHtmlPart(15)
expressionOut.print(loan?.product?.name)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',100,['class':("btn btn-secondary"),'controller':("loan"),'action':("show"),'id':(loan?.id)],3)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (comakers)) {
printHtmlPart(21)
for( comaker in (comakers) ) {
printHtmlPart(13)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(14)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(15)
invokeTag('formatDate','g',125,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(14)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',129,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129199L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
