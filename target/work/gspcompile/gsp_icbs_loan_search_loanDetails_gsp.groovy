import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_search_loanDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/search/_loanDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(1)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(2)
invokeTag('formatNumber','g',4,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',5,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',6,['format':("###,###,##0.00"),'number':(loanInstance?.interestRate)],-1)
printHtmlPart(5)
invokeTag('formatDate','g',7,['format':("MM/dd/yyyy"),'date':(loanInstance?.maturityDate)],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',8,['format':("###,###,##0.00"),'number':(loanInstance?.totalNetProceeds)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',9,['format':("###,###,##0.00"),'number':(loanInstance?.totalDisbursementAmount)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',10,['format':("###,###,##0.00"),'number':(loanInstance?.overduePrincipalBalance)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',11,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',12,['format':("###,###,##0.00"),'number':(loanInstance?.interestBalanceAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',13,['format':("###,###,##0.00"),'number':(loanInstance?.penaltyBalanceAmount)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',14,['format':("###,###,##0.00"),'number':(loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129126L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
