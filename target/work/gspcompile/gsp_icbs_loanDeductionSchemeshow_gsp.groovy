import icbs.loans.LoanDeductionScheme
import icbs.lov.LoanDeductionCalculationType
import icbs.lov.LoanDeductionSpecialCalculation
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanDeductionSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanDeductionScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'loanDeductionScheme.label', default: 'LoanDeductionScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
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
invokeTag('fieldValue','g',38,['bean':(loanDeductionSchemeInstance),'field':("code")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',42,['bean':(loanDeductionSchemeInstance),'field':("name")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',46,['bean':(loanDeductionSchemeInstance),'field':("description")],-1)
printHtmlPart(11)
expressionOut.print(loanDeductionSchemeInstance?.specialCalculation?.description)
printHtmlPart(12)
expressionOut.print(loanDeductionSchemeInstance?.type?.description)
printHtmlPart(13)
if(true && (loanDeductionSchemeInstance.type.id == 1)) {
printHtmlPart(14)
invokeTag('formatNumber','g',59,['format':("###,###,##0.00"),'number':(loanDeductionSchemeInstance?.amount)],-1)
printHtmlPart(13)
}
else if(true && (loanDeductionSchemeInstance.type.id == 2)) {
printHtmlPart(15)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(loanDeductionSchemeInstance?.rate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('formatBoolean','g',72,['boolean':(loanDeductionSchemeInstance?.hasEirMode)],-1)
printHtmlPart(18)
expressionOut.print(loanDeductionSchemeInstance?.contraAcct?.name)
printHtmlPart(19)
expressionOut.print(loanDeductionSchemeInstance?.status?.description)
printHtmlPart(20)
invokeTag('sortableColumn','g',90,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',93,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( product in (loanDeductionSchemeInstance.products) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',98,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(25)
expressionOut.print(product.name)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',104,['class':("list"),'action':("index")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',108,['action':("edit"),'controller':("loanDeductionScheme"),'id':(loanDeductionSchemeInstance.id)],3)
printHtmlPart(32)
if(true && (loanDeductionSchemeInstance.status.id == 1)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 4)
invokeTag('form','g',111,['id':("activate"),'url':([resource:loanDeductionSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(34)
invokeTag('actionSubmit','g',111,['id':("activateLoanDeductionScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (loanDeductionSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(33)
createClosureForHtmlPart(37, 4)
invokeTag('form','g',119,['id':("delete"),'url':([resource:loanDeductionSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(34)
invokeTag('actionSubmit','g',126,['id':("deleteLoanDeductionScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01303', 'form#delete', 'Override new Check Deposit Clearing Type.', null);
                                },
                                function(){
                                    return;
                                });                           
                        """)],-1)
printHtmlPart(38)
}
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',138,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',139,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129230L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
