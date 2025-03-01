import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestScheme_form_basic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/form/_basic.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("depositInterestScheme.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',7,['name':("code"),'maxlength':("10"),'value':(depositInterestSchemeInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',13,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',14,['bean':(depositInterestSchemeInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',17,['bean':(depositInterestSchemeInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',24,['code':("depositInterestScheme.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',27,['name':("name"),'maxlength':("50"),'value':(depositInterestSchemeInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',33,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',34,['bean':(depositInterestSchemeInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',37,['bean':(depositInterestSchemeInstance),'field':("name")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'depositInterestStart', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',42,['code':("depositInterestScheme.depositInterestStart.label"),'default':("Deposit Interest Start")],-1)
printHtmlPart(2)
invokeTag('select','g',45,['id':("depositInterestStart"),'name':("depositInterestStart.id"),'from':(icbs.lov.DepositInterestStart.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(depositInterestSchemeInstance?.depositInterestStart?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',52,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',55,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',61,['code':("depositInterestScheme.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(2)
invokeTag('field','g',64,['name':("interestRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'interestRate')),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',70,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',71,['bean':(depositInterestSchemeInstance),'field':("interestRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',74,['bean':(depositInterestSchemeInstance),'field':("interestRate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'divisor', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',81,['code':("depositInterestScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(2)
invokeTag('field','g',84,['name':("divisor"),'value':(depositInterestSchemeInstance.divisor),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',91,['bean':(depositInterestSchemeInstance),'field':("divisor")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',94,['bean':(depositInterestSchemeInstance),'field':("divisor")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'minInterestRate', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',101,['code':("depositInterestScheme.minInterestRate.label"),'default':("Min Interest Rate")],-1)
printHtmlPart(2)
invokeTag('field','g',104,['name':("minInterestRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'minInterestRate')),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',110,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',111,['bean':(depositInterestSchemeInstance),'field':("minInterestRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',114,['bean':(depositInterestSchemeInstance),'field':("minInterestRate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'maxInterestRate', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',121,['code':("depositInterestScheme.maxInterestRate.label"),'default':("Max Interest Rate")],-1)
printHtmlPart(2)
invokeTag('field','g',124,['name':("maxInterestRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'maxInterestRate')),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',130,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',131,['bean':(depositInterestSchemeInstance),'field':("maxInterestRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',134,['bean':(depositInterestSchemeInstance),'field':("maxInterestRate")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'fdPostMaturityRate', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',140,['code':("depositInterestScheme.fdPostMaturityRate.label"),'default':("FD Post Maturity Interest Rate")],-1)
printHtmlPart(17)
invokeTag('field','g',142,['name':("fdPostMaturityRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'fdPostMaturityRate')),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',148,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',149,['bean':(depositInterestSchemeInstance),'field':("fdPostMaturityRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',152,['bean':(depositInterestSchemeInstance),'field':("fdPostMaturityRate")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'fdMonthlyTransfer', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',158,['code':("depositInterestScheme.fdMonthlyTransfer.label"),'default':("FD Monthly Transfer")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',161,['name':("fdMonthlyTransfer"),'class':(""),'value':(depositInterestSchemeInstance?.fdMonthlyTransfer)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',167,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',168,['bean':(depositInterestSchemeInstance),'field':("fdMonthlyTransfer")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',171,['bean':(depositInterestSchemeInstance),'field':("fdMonthlyTransfer")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'minBalanceToEarnInterest', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',177,['code':("depositInterestScheme.minBalanceToEarnInterest.label"),'default':("Min Balance To Earn Interest")],-1)
printHtmlPart(2)
invokeTag('field','g',180,['name':("minBalanceToEarnInterest"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'minBalanceToEarnInterest')),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',186,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',187,['bean':(depositInterestSchemeInstance),'field':("minBalanceToEarnInterest")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',190,['bean':(depositInterestSchemeInstance),'field':("minBalanceToEarnInterest")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'canChangeInterestRate', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',197,['code':("depositInterestScheme.canChangeInterestRate.label"),'default':("Can Change Interest Rate")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',200,['name':("canChangeInterestRate"),'class':(""),'value':(depositInterestSchemeInstance?.canChangeInterestRate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',206,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',207,['bean':(depositInterestSchemeInstance),'field':("canChangeInterestRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',210,['bean':(depositInterestSchemeInstance),'field':("canChangeInterestRate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'isAccrual', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',217,['code':("depositInterestScheme.isAccrual.label"),'default':("Is Accrual")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',220,['name':("isAccrual"),'class':(""),'value':(depositInterestSchemeInstance?.isAccrual)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',226,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',227,['bean':(depositInterestSchemeInstance),'field':("isAccrual")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',230,['bean':(depositInterestSchemeInstance),'field':("isAccrual")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestOnClosing', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',235,['code':("depositInterestScheme.interestOnClosing.label"),'default':("Payout interest on closing")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',238,['name':("interestOnClosing"),'class':(""),'value':(depositInterestSchemeInstance?.interestOnClosing)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',244,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',245,['bean':(depositInterestSchemeInstance),'field':("interestOnClosing")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',248,['bean':(depositInterestSchemeInstance),'field':("interestOnClosing")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'isGraduated', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',254,['code':("depositInterestScheme.isGraduated.label"),'default':("Is Graduated")],-1)
printHtmlPart(25)
if(true && (depositInterestSchemeInstance?.id)) {
printHtmlPart(26)
invokeTag('hiddenField','g',259,['id':("isGraduated"),'name':("isGraduated"),'class':("form-control"),'value':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(26)
invokeTag('checkBox','g',260,['id':("isGraduated"),'name':("isGraduated"),'disabled class':(""),'value':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(27)
}
else {
printHtmlPart(26)
invokeTag('checkBox','g',263,['id':("isGraduated"),'name':("isGraduated"),'onchange':("isGraduatedChecked()"),'class':(""),'value':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(27)
}
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',269,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',270,['bean':(depositInterestSchemeInstance),'field':("isGraduated")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',273,['bean':(depositInterestSchemeInstance),'field':("isGraduated")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'depositCapitalizationFreq', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',278,['code':("depositInterestScheme.depositCapitalizationFreq.label"),'default':("Deposit Capitalization Freq")],-1)
printHtmlPart(2)
invokeTag('select','g',281,['id':("depositCapitalizationFreq"),'name':("depositCapitalizationFreq.id"),'from':(icbs.lov.DepositCapitalizationFreq.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(depositInterestSchemeInstance?.depositCapitalizationFreq?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',287,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',288,['bean':(depositInterestSchemeInstance),'field':("depositCapitalizationFreq")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',291,['bean':(depositInterestSchemeInstance),'field':("depositCapitalizationFreq")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'depositInterestCalculation', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',297,['code':("depositInterestScheme.depositInterestCalculation.label"),'default':("Deposit Interest Calculation")],-1)
printHtmlPart(2)
invokeTag('select','g',300,['id':("depositInterestCalculation"),'name':("depositInterestCalculation.id"),'from':(icbs.lov.DepositInterestCalculation.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(depositInterestSchemeInstance?.depositInterestCalculation?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',306,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',307,['bean':(depositInterestSchemeInstance),'field':("depositInterestCalculation")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',310,['bean':(depositInterestSchemeInstance),'field':("depositInterestCalculation")],1)
printHtmlPart(30)
if(true && (depositInterestSchemeInstance?.id)) {
printHtmlPart(31)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'status', 'has-error'))
printHtmlPart(32)
invokeTag('message','g',317,['code':("depositInterestScheme.status.label"),'default':("Status")],-1)
printHtmlPart(33)
invokeTag('select','g',320,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(depositInterestSchemeInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('message','g',326,['error':(it)],-1)
printHtmlPart(37)
})
invokeTag('eachError','g',327,['bean':(depositInterestSchemeInstance),'field':("status")],3)
printHtmlPart(38)
})
invokeTag('hasErrors','g',330,['bean':(depositInterestSchemeInstance),'field':("status")],2)
printHtmlPart(39)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128851L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
