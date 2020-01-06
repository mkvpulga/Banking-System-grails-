import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemechangeInt_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/changeInt.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',8,['src':("depositHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'depositInterestScheme', action:'addGraduatedFormAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',23,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
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
invokeTag('message','g',35,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',36,['bean':(depositInterestSchemeInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',39,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(19)
if(true && (depositInterestSchemeInstance?.code)) {
printHtmlPart(20)
invokeTag('fieldValue','g',58,['bean':(depositInterestSchemeInstance),'field':("code")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.name)) {
printHtmlPart(23)
invokeTag('fieldValue','g',64,['bean':(depositInterestSchemeInstance),'field':("name")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.depositInterestStart)) {
printHtmlPart(24)
invokeTag('fieldValue','g',70,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart.description")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.interestRate)) {
printHtmlPart(25)
invokeTag('formatNumber','g',76,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.interestRate)],-1)
printHtmlPart(26)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.divisor)) {
printHtmlPart(27)
invokeTag('fieldValue','g',82,['bean':(depositInterestSchemeInstance),'field':("divisor")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.minInterestRate)) {
printHtmlPart(28)
invokeTag('formatNumber','g',88,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.minInterestRate)],-1)
printHtmlPart(26)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.maxInterestRate)) {
printHtmlPart(29)
invokeTag('formatNumber','g',94,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(26)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.fdPostMaturityRate)) {
printHtmlPart(30)
invokeTag('formatNumber','g',100,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.fdPostMaturityRate)],-1)
printHtmlPart(26)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.fdMonthlyTransfer)) {
printHtmlPart(31)
invokeTag('formatBoolean','g',106,['boolean':(depositInterestSchemeInstance?.fdMonthlyTransfer)],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.minBalanceToEarnInterest)) {
printHtmlPart(32)
invokeTag('formatNumber','g',112,['format':("###,###,##0.00"),'number':(depositInterestSchemeInstance?.minBalanceToEarnInterest)],-1)
printHtmlPart(21)
}
printHtmlPart(33)
if(true && (depositInterestSchemeInstance?.canChangeInterestRate)) {
printHtmlPart(34)
invokeTag('formatBoolean','g',118,['boolean':(depositInterestSchemeInstance?.canChangeInterestRate)],-1)
printHtmlPart(21)
}
printHtmlPart(33)
if(true && (depositInterestSchemeInstance?.isAccrual)) {
printHtmlPart(35)
invokeTag('formatBoolean','g',124,['boolean':(depositInterestSchemeInstance?.isAccrual)],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.depositCapitalizationFreq)) {
printHtmlPart(36)
expressionOut.print(depositInterestSchemeInstance?.depositCapitalizationFreq?.encodeAsHTML())
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.depositInterestCalculation)) {
printHtmlPart(37)
expressionOut.print(depositInterestSchemeInstance?.depositInterestCalculation.description)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.status)) {
printHtmlPart(38)
expressionOut.print(depositInterestSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInterestSchemeInstance?.isGraduated)) {
printHtmlPart(39)
invokeTag('formatBoolean','g',148,['boolean':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(21)
}
printHtmlPart(40)
createTagBody(3, {->
printHtmlPart(41)
invokeTag('hiddenField','g',154,['name':("version"),'value':(depositInterestSchemeInstance?.version)],-1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error'))
printHtmlPart(43)
invokeTag('message','g',159,['code':("depositInterestScheme.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(44)
invokeTag('field','g',162,['name':("interestRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'interestRate')),'class':("form-control")],-1)
printHtmlPart(45)
createTagBody(4, {->
printHtmlPart(46)
createTagBody(5, {->
printHtmlPart(47)
invokeTag('message','g',167,['error':(it)],-1)
printHtmlPart(48)
})
invokeTag('eachError','g',168,['bean':(depositInterestSchemeInstance),'field':("interestRate")],5)
printHtmlPart(49)
})
invokeTag('hasErrors','g',171,['bean':(depositInterestSchemeInstance),'field':("interestRate")],4)
printHtmlPart(50)
if(true && (depositInterestSchemeInstance?.isGraduated==true)) {
printHtmlPart(51)
invokeTag('render','g',177,['template':("form/graduated/graduatedInfo")],-1)
printHtmlPart(52)
}
printHtmlPart(53)
})
invokeTag('form','g',180,['id':("DepositInterestSchemeForm"),'url':([resource:depositInterestSchemeInstance, action:'saveIntRate']),'method':("PUT")],3)
printHtmlPart(54)
for( product in (depositInterestSchemeInstance.products) ) {
printHtmlPart(55)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',208,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(56)
expressionOut.print(product.name)
printHtmlPart(57)
}
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',221,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(59)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',227,['class':("list"),'action':("show"),'id':(depositInterestSchemeInstance.id)],3)
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',242,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',243,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128848L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
