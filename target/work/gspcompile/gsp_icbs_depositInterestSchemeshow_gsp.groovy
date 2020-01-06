import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/show.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (depositInterestSchemeInstance?.code)) {
printHtmlPart(11)
invokeTag('fieldValue','g',46,['bean':(depositInterestSchemeInstance),'field':("code")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.name)) {
printHtmlPart(14)
invokeTag('fieldValue','g',52,['bean':(depositInterestSchemeInstance),'field':("name")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.depositInterestStart)) {
printHtmlPart(15)
invokeTag('fieldValue','g',58,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart.description")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.interestRate)) {
printHtmlPart(16)
invokeTag('formatNumber','g',64,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.interestRate)],-1)
printHtmlPart(17)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.divisor)) {
printHtmlPart(18)
invokeTag('fieldValue','g',70,['bean':(depositInterestSchemeInstance),'field':("divisor")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.minInterestRate)) {
printHtmlPart(19)
invokeTag('formatNumber','g',76,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.minInterestRate)],-1)
printHtmlPart(17)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.maxInterestRate)) {
printHtmlPart(20)
invokeTag('formatNumber','g',82,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(17)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.fdPostMaturityRate)) {
printHtmlPart(21)
invokeTag('formatNumber','g',88,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.fdPostMaturityRate)],-1)
printHtmlPart(17)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.fdMonthlyTransfer)) {
printHtmlPart(22)
invokeTag('formatBoolean','g',94,['boolean':(depositInterestSchemeInstance?.fdMonthlyTransfer)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.minBalanceToEarnInterest)) {
printHtmlPart(23)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(depositInterestSchemeInstance?.minBalanceToEarnInterest)],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (depositInterestSchemeInstance?.minBalanceToEarnInterest)) {
printHtmlPart(26)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(depositInterestSchemeInstance?.minBalanceToEarnInterest + 1)],-1)
printHtmlPart(27)
}
printHtmlPart(25)
if(true && (depositInterestSchemeInstance?.canChangeInterestRate)) {
printHtmlPart(28)
invokeTag('formatBoolean','g',112,['boolean':(depositInterestSchemeInstance?.canChangeInterestRate)],-1)
printHtmlPart(12)
}
printHtmlPart(25)
if(true && (depositInterestSchemeInstance?.isAccrual)) {
printHtmlPart(29)
invokeTag('formatBoolean','g',118,['boolean':(depositInterestSchemeInstance?.isAccrual)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.depositCapitalizationFreq)) {
printHtmlPart(30)
expressionOut.print(depositInterestSchemeInstance?.depositCapitalizationFreq?.encodeAsHTML())
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.depositInterestCalculation)) {
printHtmlPart(31)
expressionOut.print(depositInterestSchemeInstance?.depositInterestCalculation.description)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.status)) {
printHtmlPart(32)
expressionOut.print(depositInterestSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.isGraduated)) {
printHtmlPart(33)
invokeTag('formatBoolean','g',142,['boolean':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(12)
}
printHtmlPart(34)
invokeTag('sortableColumn','g',159,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',160,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(36)
loop:{
int i = 0
for( product in (depositInterestSchemeInstance.products) ) {
printHtmlPart(37)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(38)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',166,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(39)
expressionOut.print(product.name)
printHtmlPart(40)
i++
}
}
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',182,['tag':("main-content")],2)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',185,['class':("list"),'action':("index")],3)
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',186,['class':("create"),'action':("create")],3)
printHtmlPart(47)
if(true && (depositInterestSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(48)
createClosureForHtmlPart(49, 4)
invokeTag('link','g',189,['action':("edit"),'controller':("DepositInterestScheme"),'id':(depositInterestSchemeInstance.id)],4)
printHtmlPart(50)
}
printHtmlPart(2)
if(true && (depositInterestSchemeInstance.status.id == 1)) {
printHtmlPart(51)
createTagBody(4, {->
printHtmlPart(52)
invokeTag('actionSubmit','g',193,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(53)
})
invokeTag('form','g',194,['url':([id:depositInterestSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(50)
}
printHtmlPart(54)
if(true && (depositInterestSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(48)
createClosureForHtmlPart(52, 4)
invokeTag('form','g',199,['id':("deleteDepositInterestSchemeForm"),'url':([id:depositInterestSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(52)
invokeTag('actionSubmit','g',208,['id':("deleteDepositIntScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01004', 'form#deleteDepositInterestSchemeForm', 'Override edit Deposit Interest Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                                
                            """)],-1)
printHtmlPart(55)
}
printHtmlPart(48)
createClosureForHtmlPart(56, 3)
invokeTag('link','g',211,['action':("changeInt"),'controller':("DepositInterestScheme"),'id':(depositInterestSchemeInstance.id)],3)
printHtmlPart(57)
})
invokeTag('captureContent','sitemesh',222,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',223,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128857L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
