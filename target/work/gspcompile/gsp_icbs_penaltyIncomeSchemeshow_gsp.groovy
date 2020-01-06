import icbs.loans.PenaltyIncomeScheme
import icbs.lov.LoanPenaltyBasis
import icbs.lov.LoanPenaltyFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_penaltyIncomeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/penaltyIncomeScheme/show.gsp" }
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
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'penaltyIncomeScheme.label', default: 'PenaltyIncomeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('fieldValue','g',40,['bean':(penaltyIncomeSchemeInstance),'field':("code")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',44,['bean':(penaltyIncomeSchemeInstance),'field':("name")],-1)
printHtmlPart(11)
expressionOut.print(penaltyIncomeSchemeInstance?.basis?.description)
printHtmlPart(12)
expressionOut.print(penaltyIncomeSchemeInstance?.type?.description)
printHtmlPart(13)
if(true && (penaltyIncomeSchemeInstance.type.id == 1)) {
printHtmlPart(14)
expressionOut.print(penaltyIncomeSchemeInstance?.frequency?.description)
printHtmlPart(15)
invokeTag('fieldValue','g',61,['bean':(penaltyIncomeSchemeInstance),'field':("defaultPenaltyAmount")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',65,['bean':(penaltyIncomeSchemeInstance),'field':("minPenaltyAmount")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',69,['bean':(penaltyIncomeSchemeInstance),'field':("maxPenaltyAmount")],-1)
printHtmlPart(13)
}
else if(true && (penaltyIncomeSchemeInstance.type.id == 2)) {
printHtmlPart(18)
invokeTag('fieldValue','g',75,['bean':(penaltyIncomeSchemeInstance),'field':("defaultPenaltyRate")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',79,['bean':(penaltyIncomeSchemeInstance),'field':("minPenaltyRate")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',83,['bean':(penaltyIncomeSchemeInstance),'field':("maxPenaltyRate")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',87,['bean':(penaltyIncomeSchemeInstance),'field':("divisor")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('fieldValue','g',92,['bean':(penaltyIncomeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(24)
invokeTag('formatBoolean','g',96,['boolean':(penaltyIncomeSchemeInstance?.canChangePenaltyRate)],-1)
printHtmlPart(25)
invokeTag('formatBoolean','g',100,['boolean':(penaltyIncomeSchemeInstance?.hasWeekendMode)],-1)
printHtmlPart(26)
expressionOut.print(penaltyIncomeSchemeInstance?.status?.description)
printHtmlPart(27)
invokeTag('sortableColumn','g',116,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(28)
invokeTag('sortableColumn','g',117,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(29)
loop:{
int i = 0
for( product in (penaltyIncomeSchemeInstance.products) ) {
printHtmlPart(30)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(31)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',123,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(32)
expressionOut.print(product.name)
printHtmlPart(33)
i++
}
}
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',134,['class':("list"),'action':("index")],3)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',135,['action':("edit"),'controller':("penaltyIncomeScheme"),'id':(penaltyIncomeSchemeInstance.id)],3)
printHtmlPart(39)
if(true && (penaltyIncomeSchemeInstance.status.id == 1)) {
printHtmlPart(40)
createClosureForHtmlPart(41, 4)
invokeTag('form','g',137,['id':("activate"),'url':([resource:penaltyIncomeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(42)
invokeTag('actionSubmit','g',143,['id':("activatePenaltyIncomeScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (penaltyIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(45)
createClosureForHtmlPart(46, 4)
invokeTag('form','g',146,['id':("delete"),'url':([resource:penaltyIncomeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(46)
invokeTag('actionSubmit','g',155,['id':("deletePenaltyIncomeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01104', 'form#delete', 'Override New Penalty Income Scheme.', null);
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(47)
}
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',169,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',169,[:],1)
printHtmlPart(49)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129280L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
