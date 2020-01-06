import icbs.loans.InterestIncomeScheme
import icbs.lov.LoanInstallmentType
import icbs.lov.LoanCalculation
import icbs.lov.LoanAdvancedInterestType
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_interestIncomeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/interestIncomeScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'interestIncomeScheme.label', default: 'InterestIncomeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('fieldValue','g',41,['bean':(interestIncomeSchemeInstance),'field':("code")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',45,['bean':(interestIncomeSchemeInstance),'field':("name")],-1)
printHtmlPart(10)
expressionOut.print(interestIncomeSchemeInstance.installmentType.description)
printHtmlPart(11)
expressionOut.print(interestIncomeSchemeInstance.installmentCalcType.description)
printHtmlPart(12)
expressionOut.print(interestIncomeSchemeInstance.advInterestType.description)
printHtmlPart(13)
invokeTag('formatNumber','g',62,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.defaultInterestRate)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',66,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.pastDueInterestRate)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',70,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.minInterestRate)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',74,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',78,['bean':(interestIncomeSchemeInstance),'field':("divisor")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',82,['bean':(interestIncomeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(19)
invokeTag('formatBoolean','g',86,['boolean':(interestIncomeSchemeInstance.hasBalloonMode)],-1)
printHtmlPart(20)
invokeTag('formatBoolean','g',90,['boolean':(interestIncomeSchemeInstance.canChangeInterestRate)],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',94,['boolean':(interestIncomeSchemeInstance.hasInterestAccrual)],-1)
printHtmlPart(22)
expressionOut.print(interestIncomeSchemeInstance.status.description)
printHtmlPart(23)
invokeTag('sortableColumn','g',112,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',113,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(25)
loop:{
int i = 0
for( product in (interestIncomeSchemeInstance.products) ) {
printHtmlPart(26)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',119,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(28)
expressionOut.print(product.name)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',129,['class':("list"),'action':("index")],3)
printHtmlPart(33)
if(true && (interestIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',130,['action':("edit"),'controller':("interestIncomeScheme"),'id':(interestIncomeSchemeInstance.id)],4)
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (interestIncomeSchemeInstance.status.id == 1)) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('form','g',137,['id':("activate"),'url':([resource:interestIncomeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',139,['id':("activateInterestIncomeScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (interestIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('form','g',142,['id':("delete"),'url':([resource:interestIncomeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(42)
invokeTag('actionSubmit','g',151,['id':("deleteInterestIncomeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01004', 'form#delete', 'Override delete Interest Income Scheme.', null);
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(43)
}
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',165,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129030L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
