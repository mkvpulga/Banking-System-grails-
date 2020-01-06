import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_viewMoreInfoTemplates_accountAndBalance_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/viewMoreInfoTemplates/_accountAndBalance.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',9,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(1)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(2)
invokeTag('formatDate','g',14,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(3)
if(true && (depositInstance?.depositInterestScheme?.fdMonthlyTransfer==true)) {
printHtmlPart(4)
invokeTag('formatDate','g',19,['format':("MM/dd/yyyy"),'date':(depositInstance?.maturityDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
invokeTag('formatDate','g',22,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(5)
}
printHtmlPart(7)
invokeTag('formatNumber','g',27,['format':("##,###"),'number':(depositInstance?.maturityDate - depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(1)
}
printHtmlPart(8)
invokeTag('formatNumber','g',32,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(9)
if(true && (depositInstance.passBookNo)) {
printHtmlPart(10)
invokeTag('formatNumber','g',37,['format':("###############"),'id':("NoPass"),'number':(depositInstance.passBookNo)],-1)
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(14)
expressionOut.print(depositInstance?.currentRollover?.type)
printHtmlPart(15)
expressionOut.print(depositInstance?.currentRollover?.interestPaymentMode?.description)
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(depositInstance?.currentRollover?.fundedDeposit?.acctNo)
})
invokeTag('link','g',54,['action':("depositInquiry"),'id':(depositInstance?.currentRollover?.fundedDeposit?.id)],2)
printHtmlPart(1)
}
printHtmlPart(17)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastTxnDate)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(depositInstance?.statusChangeDate)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',67,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastCapitalizationDate)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',82,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',94,['format':("###,###,##0.00"),'number':(depositInstance?.holdBalAmt)],-1)
printHtmlPart(24)
if(true && (depositInstance?.type?.id == 3 && depositInstance?.currentRollover?.status?.id == 1)) {
printHtmlPart(25)
if(true && (depositInstance?.status?.id == 7)) {
printHtmlPart(26)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(27)
}
else {
printHtmlPart(26)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt)],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',110,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(27)
}
printHtmlPart(29)
}
else {
printHtmlPart(30)
invokeTag('formatNumber','g',117,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('formatNumber','g',122,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',126,['format':("###,###,##0.00"),'number':(depositInstance?.unclearedCheckBalAmt)],-1)
printHtmlPart(34)
expressionOut.print(depositInstance?.depositInterestScheme?.name)
printHtmlPart(35)
expressionOut.print(depositInstance?.depositTaxChargeScheme?.name)
printHtmlPart(36)
if(true && (depositInstance?.type?.id == 3)) {
printHtmlPart(37)
expressionOut.print(depositInstance?.fixedDepositPreTermScheme?.name)
printHtmlPart(38)
expressionOut.print(depositInstance?.fixedDepositTermScheme?.name)
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(depositInstance?.glLink?.description)
printHtmlPart(41)
expressionOut.print(depositInstance?.product?.name)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128842L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
