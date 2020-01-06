import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'deposit.label', default: 'Deposit'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(depositInstance?.acctNo)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(10)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(depositInstance?.customer?.customerId)
})
invokeTag('link','g',37,['controller':("customer"),'action':("customerInquiry"),'id':(depositInstance?.customer?.id)],3)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(depositInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("branch"),'action':("show"),'id':(depositInstance?.branch?.id)],3)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(depositInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("depositType"),'action':("show"),'id':(depositInstance?.type?.id)],3)
printHtmlPart(16)
invokeTag('fieldValue','g',49,['bean':(depositInstance),'field':("acctNo")],-1)
printHtmlPart(17)
if(true && (depositInstance?.acctNoFormat)) {
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(depositInstance?.acctNoFormat?.encodeAsHTML())
})
invokeTag('link','g',54,['controller':("acctNoFormat"),'action':("show"),'id':(depositInstance?.acctNoFormat?.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.ownershipType)) {
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(depositInstance?.ownershipType?.encodeAsHTML())
})
invokeTag('link','g',60,['controller':("ownershipType"),'action':("show"),'id':(depositInstance?.ownershipType?.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.sigRules)) {
printHtmlPart(22)
invokeTag('fieldValue','g',66,['bean':(depositInstance),'field':("sigRules")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.sigRemarks)) {
printHtmlPart(23)
invokeTag('fieldValue','g',72,['bean':(depositInstance),'field':("sigRemarks")],-1)
printHtmlPart(19)
}
printHtmlPart(24)
if(true && (depositInstance?.signatories)) {
printHtmlPart(25)
for( s in (depositInstance.signatories) ) {
printHtmlPart(26)
createTagBody(5, {->
expressionOut.print(s.id)
})
invokeTag('link','g',79,['controller':("signatory"),'action':("show"),'id':(s.id)],5)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(20)
if(true && (depositInstance?.depositInterestScheme)) {
printHtmlPart(29)
createTagBody(4, {->
expressionOut.print(depositInstance?.depositInterestScheme?.encodeAsHTML())
})
invokeTag('link','g',86,['controller':("depositInterestScheme"),'action':("show"),'id':(depositInstance?.depositInterestScheme?.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.depositTaxChargeScheme)) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(depositInstance?.depositTaxChargeScheme?.encodeAsHTML())
})
invokeTag('link','g',92,['controller':("depositTaxFeeAndChargeScheme"),'action':("show"),'id':(depositInstance?.depositTaxChargeScheme?.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.fixedDepositPreTermScheme)) {
printHtmlPart(31)
createTagBody(4, {->
expressionOut.print(depositInstance?.fixedDepositPreTermScheme?.encodeAsHTML())
})
invokeTag('link','g',98,['controller':("fixedDepositPreTermScheme"),'action':("show"),'id':(depositInstance?.fixedDepositPreTermScheme?.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.dateOpened)) {
printHtmlPart(32)
invokeTag('formatDate','g',104,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.dateClosed)) {
printHtmlPart(33)
invokeTag('formatDate','g',110,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateClosed)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance?.status)) {
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(depositInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',116,['controller':("depositStatus"),'action':("show"),'id':(depositInstance?.status?.id)],4)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.statusChangeDate)) {
printHtmlPart(36)
invokeTag('formatDate','g',122,['format':("MM/dd/yyyy"),'date':(depositInstance?.statusChangeDate)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.ledgerBalAmt)) {
printHtmlPart(37)
invokeTag('fieldValue','g',128,['bean':(depositInstance),'field':("ledgerBalAmt")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.availableBalAmt)) {
printHtmlPart(38)
invokeTag('formatNumber','g',134,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(35)
}
printHtmlPart(39)
if(true && (depositInstance?.passbookBalAmt)) {
printHtmlPart(40)
invokeTag('formatNumber','g',140,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.interestBalAmt)) {
printHtmlPart(41)
invokeTag('formatNumber','g',146,['format':("###,###,##0.00"),'number':(depositInstance?.interestBalAmt)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.lmAveBalAmt)) {
printHtmlPart(42)
invokeTag('formatNumber','g',152,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.interestRate)) {
printHtmlPart(43)
invokeTag('formatNumber','g',158,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(44)
}
printHtmlPart(20)
if(true && (depositInstance?.acrintAmt)) {
printHtmlPart(45)
invokeTag('formatNumber','g',164,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.acrintDate)) {
printHtmlPart(46)
invokeTag('formatDate','g',170,['date':(depositInstance?.acrintDate)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.debitAcrintAmt)) {
printHtmlPart(47)
invokeTag('fieldValue','g',176,['bean':(depositInstance),'field':("debitAcrintAmt")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.debitAcrintDate)) {
printHtmlPart(48)
invokeTag('formatDate','g',182,['format':("MM/dd/yyyy"),'date':(depositInstance?.debitAcrintDate)],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.passbooks)) {
printHtmlPart(49)
for( p in (depositInstance.passbooks) ) {
printHtmlPart(50)
createTagBody(5, {->
expressionOut.print(s?.encodeAsHTML())
})
invokeTag('link','g',190,['controller':("passbook"),'action':("show"),'id':(p.id)],5)
printHtmlPart(51)
}
printHtmlPart(52)
}
printHtmlPart(20)
if(true && (depositInstance?.txnWithdrawalsCounterMonthly)) {
printHtmlPart(53)
invokeTag('fieldValue','g',197,['bean':(depositInstance),'field':("txnWithdrawalsCounterMonthly")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.txnWithdrawalsCounterCummulative)) {
printHtmlPart(54)
invokeTag('fieldValue','g',203,['bean':(depositInstance),'field':("txnWithdrawalsCounterCummulative")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.lastCapitalizationDate)) {
printHtmlPart(55)
invokeTag('formatDate','g',209,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastCapitalizationDate)],-1)
printHtmlPart(35)
}
printHtmlPart(39)
if(true && (depositInstance?.currency)) {
printHtmlPart(56)
invokeTag('fieldValue','g',215,['bean':(depositInstance),'field':("currency")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.isSweep)) {
printHtmlPart(57)
invokeTag('formatBoolean','g',221,['boolean':(depositInstance?.isSweep)],-1)
printHtmlPart(35)
}
printHtmlPart(39)
if(true && (depositInstance?.txnDepCounterCummulative)) {
printHtmlPart(58)
invokeTag('fieldValue','g',227,['bean':(depositInstance),'field':("txnDepCounterCummulative")],-1)
printHtmlPart(35)
}
printHtmlPart(20)
if(true && (depositInstance?.txnDepCounterMonthly)) {
printHtmlPart(59)
invokeTag('fieldValue','g',233,['bean':(depositInstance),'field':("txnDepCounterMonthly")],-1)
printHtmlPart(35)
}
printHtmlPart(60)
createTagBody(3, {->
printHtmlPart(61)
createTagBody(4, {->
invokeTag('message','g',248,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',248,['class':("edit"),'action':("edit"),'resource':(depositInstance)],4)
printHtmlPart(62)
invokeTag('actionSubmit','g',249,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(63)
})
invokeTag('form','g',251,['url':([resource:depositInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(64)
})
invokeTag('captureContent','sitemesh',254,['tag':("main-content")],2)
printHtmlPart(65)
createTagBody(2, {->
printHtmlPart(66)
createClosureForHtmlPart(67, 3)
invokeTag('link','g',257,['action':("depositInquiry"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(68)
createTagBody(3, {->
invokeTag('message','g',258,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(69)
})
invokeTag('link','g',258,['class':("edit"),'action':("edit"),'resource':(depositInstance)],3)
printHtmlPart(70)
})
invokeTag('captureContent','sitemesh',260,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',261,[:],1)
printHtmlPart(71)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128822L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
