import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_memoview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/memo/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(9)
})
invokeTag('javascript','g',70,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',71,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (flash.errors)) {
printHtmlPart(16)
expressionOut.print(it)
printHtmlPart(17)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
})
invokeTag('hasErrors','g',113,['bean':(billsPaymentInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(20)
})
invokeTag('hasErrors','g',121,['bean':(remittanceInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
})
invokeTag('hasErrors','g',131,['bean':(adjustmentInstance)],3)
printHtmlPart(21)
invokeTag('render','g',134,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(22)
invokeTag('render','g',138,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(23)
if(true && (depositInstance.type.id == 3)) {
printHtmlPart(24)
invokeTag('render','g',144,['template':("/deposit/details/fdDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(25)
}
printHtmlPart(26)
loop:{
int i = 0
for( domainInstance in (TxnFileInstance) ) {
printHtmlPart(27)
expressionOut.print(domainInstance?.id)
printHtmlPart(28)
expressionOut.print(domainInstance?.txnDate?.format("MM/dd/yyyy"))
printHtmlPart(29)
expressionOut.print(domainInstance?.txnType)
printHtmlPart(29)
expressionOut.print(domainInstance?.user?.username)
printHtmlPart(30)
invokeTag('formatNumber','g',172,['number':(domainInstance?.txnAmt),'format':("###,##0.00")],-1)
printHtmlPart(31)
expressionOut.print(domainInstance?.currency?.code)
printHtmlPart(32)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(33)
if(true && (domainInstance?.txnType?.id == 9)) {
printHtmlPart(34)
expressionOut.print(domainInstance?.id)
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (domainInstance?.txnType?.id == 7)) {
printHtmlPart(37)
expressionOut.print(domainInstance?.id)
printHtmlPart(38)
}
printHtmlPart(39)
i++
}
}
printHtmlPart(40)
invokeTag('paginate','g',198,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',203,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('hiddenField','g',206,['id':("depositIdx"),'name':("depositIdx"),'value':(depositInstance.id)],-1)
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',207,['action':("#"),'data-toggle':("modal"),'data-target':("#modalMemoDebit"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',208,['action':("#"),'data-toggle':("modal"),'data-target':("#modalMemoCreedit"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('link','g',210,['action':("depositDebitMemoBills"),'id':(depositInstance.id),'resource':(depositInstance),'disable':("disabled"),'class':("disabled")],3)
printHtmlPart(45)
createClosureForHtmlPart(49, 3)
invokeTag('link','g',211,['action':("depositDebitMemoRem"),'id':(depositInstance.id),'resource':(depositInstance),'disable':("disabled"),'class':("disabled")],3)
printHtmlPart(45)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',212,['action':("depositCreditMemoRem"),'id':(depositInstance.id),'resource':(depositInstance),'disable':("disabled"),'class':("disabled")],3)
printHtmlPart(51)
expressionOut.print(depositInstance?.id)
printHtmlPart(52)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (flash.message == "Memo Remittance Successfully made.|success|alert")) {
printHtmlPart(55)
}
printHtmlPart(54)
if(true && (flash.message == "Bills Payment Successfully made.|success|alert")) {
printHtmlPart(56)
}
printHtmlPart(57)
createTagBody(3, {->
printHtmlPart(58)
invokeTag('hiddenField','g',265,['id':("type"),'name':("type"),'value':("1")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',266,['id':("acct"),'name':("acct.id"),'value':(adjustmentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(59)
invokeTag('hiddenField','g',269,['id':("typeDebit"),'name':("typeDebit"),'value':("1")],-1)
printHtmlPart(60)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(61)
invokeTag('select','g',272,['id':("txnTemplateDebit"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(62)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(63)
invokeTag('textField','g',277,['id':("AjustmentAmtDebit"),'name':("amt"),'value':(adjustmentInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(64)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(65)
invokeTag('textField','g',282,['id':("AdjustRefDebit"),'name':("txnRef"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(66)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(67)
invokeTag('textField','g',286,['id':("txnDescriptionssDebit"),'name':("txnDescription"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(68)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(69)
}
printHtmlPart(70)
createClosureForHtmlPart(71, 4)
invokeTag('javascript','g',341,[:],4)
printHtmlPart(72)
})
invokeTag('form','g',345,['name':("adjustmentMemoDebitFormSend"),'id':("adjustmentMemoDebitFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],3)
printHtmlPart(73)
createTagBody(3, {->
printHtmlPart(74)
invokeTag('hiddenField','g',360,['id':("type"),'name':("type"),'value':("2")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',361,['id':("acct"),'name':("acct.id"),'value':(adjustmentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(75)
invokeTag('hiddenField','g',364,['id':("typeCredit"),'name':("typeCredit"),'value':("2")],-1)
printHtmlPart(60)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(61)
invokeTag('select','g',367,['id':("txnTemplateCredit"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(9),icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':("1"),'class':("form-control")],-1)
printHtmlPart(64)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(63)
invokeTag('textField','g',372,['id':("AjustmentAmtCredit"),'name':("amt"),'value':(adjustmentInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(66)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(65)
invokeTag('textField','g',376,['id':("AdjustRefCredit"),'name':("txnRef"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(66)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(67)
invokeTag('textField','g',380,['id':("txnDescriptionssCredit"),'name':("txnDescription"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(76)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(77)
}
printHtmlPart(70)
createClosureForHtmlPart(78, 4)
invokeTag('javascript','g',436,[:],4)
printHtmlPart(79)
})
invokeTag('form','g',441,['name':("adjustmentMemoCreditFormSend"),'id':("adjustmentMemoCreditFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],3)
printHtmlPart(80)
})
invokeTag('captureContent','sitemesh',446,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',447,[:],1)
printHtmlPart(81)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128813L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
