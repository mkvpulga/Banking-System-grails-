import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(createLink(controller:'loan', action:'showLoanApplicationAjax'))
printHtmlPart(3)
expressionOut.print(loanInstance?.status?.id)
printHtmlPart(4)
expressionOut.print(loanInstance?.status?.id)
printHtmlPart(5)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(6)
expressionOut.print(loanInstance?.id)
printHtmlPart(7)
expressionOut.print(loanInstance?.interestIncomeScheme?.id)
printHtmlPart(8)
expressionOut.print(loanInstance?.currentPenaltyScheme?.id)
printHtmlPart(9)
expressionOut.print(loanInstance?.pastDuePenaltyScheme?.id)
printHtmlPart(10)
expressionOut.print(createLink(controller :'loan', action:'getProductSchemesAjax'))
printHtmlPart(11)
expressionOut.print(session['installments']?.size())
printHtmlPart(12)
expressionOut.print(createLink(controller:'loan', 
action:'getSchemeDetailsAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'loan', action:'addInstallmentAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'loan', action:'showAddInstallmentAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'loan', action:'showImportInstallmentAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'loan', action:'updateInstallmentAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loan', action:'showUpdateInstallmentAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller:'loan', action:'deleteInstallmentAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller:'loan', action:'showServiceChargesAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'loan', action:'addServiceChargeAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller:'loan', action:'showAddServiceChargeAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loan', action:'updateServiceChargeAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller:'loan', action:'showUpdateServiceChargeAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller:'loan', action:'deleteServiceChargeAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loan', action:'showDeductionsAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller:'loan', action:'addDeductionAjax'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'loan', action:'showAddDeductionAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller:'loan', action:'showAddDeductionAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller:'loan', action:'updateDeductionAjax'))
printHtmlPart(34)
expressionOut.print(createLink(controller:'loan', action:'showUpdateDeductionAjax'))
printHtmlPart(35)
expressionOut.print(createLink(controller :'loan', action:'getTermAjax'))
printHtmlPart(36)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller:'loan', action:'deleteDeductionAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller:'loan', action:'showSweepAccountsAjax'))
printHtmlPart(39)
expressionOut.print(createLink(controller:'loan', action:'addSweepAccountAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller:'loan', action:'showAddSweepAccountAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loan', action:'updateSweepAccountAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller:'loan', action:'showUpdateSweepAccountAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller:'loan', action:'deleteSweepAccountAjax'))
printHtmlPart(44)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(45)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(46)
expressionOut.print(createLink(controller:'loan',action:'importInstallmentss'))
printHtmlPart(47)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(48)
expressionOut.print(loanInstance?.loanApplication?.id ?: loanApplication?.id)
printHtmlPart(49)
})
invokeTag('javascript','g',1046,[:],2)
printHtmlPart(50)
})
invokeTag('captureHead','sitemesh',1047,[:],1)
printHtmlPart(51)
createTagBody(1, {->
printHtmlPart(51)
createClosureForHtmlPart(52, 2)
invokeTag('captureContent','sitemesh',1051,['tag':("breadcrumbs")],2)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(53)
if(true && (flash.message)) {
printHtmlPart(54)
expressionOut.print(flash.message)
printHtmlPart(55)
}
printHtmlPart(56)
createTagBody(3, {->
printHtmlPart(57)
expressionOut.print(module)
printHtmlPart(58)
})
invokeTag('hasErrors','g',1079,['bean':(loanInstance)],3)
printHtmlPart(56)
createTagBody(3, {->
printHtmlPart(59)
invokeTag('hiddenField','g',1081,['name':("version"),'value':(loanInstance?.version)],-1)
printHtmlPart(59)
invokeTag('hiddenField','g',1082,['name':("activity"),'value':("Amendment")],-1)
printHtmlPart(60)
if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(65)
}
else if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(68)
}
printHtmlPart(64)
if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(71)
invokeTag('render','g',1112,['template':("loanApplication/form")],-1)
printHtmlPart(72)
}
printHtmlPart(73)
invokeTag('render','g',1116,['template':("specification/form")],-1)
printHtmlPart(74)
if(true && (loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(75)
invokeTag('render','g',1121,['template':("classification/form")],-1)
printHtmlPart(76)
}
else if(true && (loanInstance?.status?.id <= 2)) {
printHtmlPart(77)
invokeTag('render','g',1126,['template':("classification/form")],-1)
printHtmlPart(72)
}
printHtmlPart(78)
invokeTag('render','g',1131,['template':("serviceCharges/list")],-1)
printHtmlPart(79)
invokeTag('render','g',1134,['template':("deductions/list")],-1)
printHtmlPart(80)
invokeTag('render','g',1137,['template':("installments/list")],-1)
printHtmlPart(81)
})
invokeTag('form','g',1141,['id':("loan-form"),'url':([resource:loanInstance, action:'update']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(82)
})
invokeTag('captureContent','sitemesh',1143,['tag':("main-content")],2)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(83)
if(true && (module == "loanAmendment")) {
printHtmlPart(84)
invokeTag('submitButton','g',1147,['id':("save"),'name':("save"),'value':("Save"),'onclick':("loanAmendmentOverride();")],-1)
printHtmlPart(85)
}
else {
printHtmlPart(84)
invokeTag('submitButton','g',1150,['id':("save"),'name':("save"),'value':("Save"),'onclick':("callsendAlertify();")],-1)
printHtmlPart(85)
}
printHtmlPart(86)
createClosureForHtmlPart(87, 3)
invokeTag('link','g',1174,['controller':(module),'action':("show"),'id':(loanInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(88)
})
invokeTag('captureContent','sitemesh',1176,['tag':("main-actions")],2)
printHtmlPart(51)
})
invokeTag('captureBody','sitemesh',1177,[:],1)
printHtmlPart(89)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129050L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
