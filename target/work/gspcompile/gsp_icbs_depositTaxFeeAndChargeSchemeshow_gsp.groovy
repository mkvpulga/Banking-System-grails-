import icbs.deposit.DepositTaxFeeAndChargeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (depositTaxFeeAndChargeSchemeInstance?.code)) {
printHtmlPart(10)
invokeTag('fieldValue','g',31,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("code")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.type)) {
printHtmlPart(13)
expressionOut.print(depositTaxFeeAndChargeSchemeInstance?.type?.encodeAsHTML())
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.taxRate)) {
printHtmlPart(14)
invokeTag('formatNumber','g',43,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.taxRate)],-1)
printHtmlPart(15)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeRate)) {
printHtmlPart(16)
invokeTag('formatNumber','g',49,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeRate)],-1)
printHtmlPart(15)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeAmt)) {
printHtmlPart(17)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeAmt)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeRate)) {
printHtmlPart(18)
invokeTag('formatNumber','g',61,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.chargeRate)],-1)
printHtmlPart(15)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeAmt)) {
printHtmlPart(19)
invokeTag('formatNumber','g',67,['format':("###,###,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.chargeAmt)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.specialCalculation)) {
printHtmlPart(20)
expressionOut.print(depositTaxFeeAndChargeSchemeInstance?.specialCalculation?.encodeAsHTML())
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition)) {
printHtmlPart(21)
invokeTag('formatBoolean','g',79,['boolean':(depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeCountCondition)) {
printHtmlPart(22)
invokeTag('formatBoolean','g',85,['boolean':(depositTaxFeeAndChargeSchemeInstance?.feeCountCondition)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.gracePeriod)) {
printHtmlPart(23)
invokeTag('fieldValue','g',91,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeRateBasis)) {
printHtmlPart(24)
invokeTag('fieldValue','g',97,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("feeRateBasis")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeRateBasis)) {
printHtmlPart(25)
invokeTag('fieldValue','g',103,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("chargeRateBasis")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.isApplyToClosingBal)) {
printHtmlPart(26)
invokeTag('fieldValue','g',109,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("isApplyToClosingBal")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.minAmtException)) {
printHtmlPart(27)
invokeTag('fieldValue','g',115,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("minAmtException")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (depositTaxFeeAndChargeSchemeInstance?.description)) {
printHtmlPart(28)
invokeTag('fieldValue','g',121,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("description")],-1)
printHtmlPart(11)
}
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',133,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',136,['class':("list"),'action':("index")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',137,['class':("create"),'action':("create")],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',139,['action':("edit"),'id':(depositTaxFeeAndChargeSchemeInstance.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',141,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',142,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128862L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
