import icbs.deposit.FixedDepositPreTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositPreTermSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositPreTermScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'fixedDepositPreTermScheme.label', default: 'FixedDepositPreTermScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
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
}
printHtmlPart(8)
if(true && (fixedDepositPreTermSchemeInstance?.code)) {
printHtmlPart(9)
invokeTag('fieldValue','g',38,['bean':(fixedDepositPreTermSchemeInstance),'field':("code")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.description)) {
printHtmlPart(12)
invokeTag('fieldValue','g',44,['bean':(fixedDepositPreTermSchemeInstance),'field':("description")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.type)) {
printHtmlPart(13)
expressionOut.print(fixedDepositPreTermSchemeInstance?.type?.encodeAsHTML())
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.rate)) {
printHtmlPart(14)
invokeTag('fieldValue','g',56,['bean':(fixedDepositPreTermSchemeInstance),'field':("rate")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.term1stHalf)) {
printHtmlPart(15)
invokeTag('fieldValue','g',62,['bean':(fixedDepositPreTermSchemeInstance),'field':("term1stHalf")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.term2ndHalf)) {
printHtmlPart(16)
invokeTag('fieldValue','g',68,['bean':(fixedDepositPreTermSchemeInstance),'field':("term2ndHalf")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.divisor)) {
printHtmlPart(17)
invokeTag('fieldValue','g',74,['bean':(fixedDepositPreTermSchemeInstance),'field':("divisor")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.status)) {
printHtmlPart(18)
expressionOut.print(fixedDepositPreTermSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.isGradeRate)) {
printHtmlPart(19)
invokeTag('formatBoolean','g',86,['boolean':(fixedDepositPreTermSchemeInstance?.isGradeRate)],-1)
printHtmlPart(10)
}
printHtmlPart(20)
invokeTag('sortableColumn','g',101,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',102,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( product in (fixedDepositPreTermSchemeInstance.products) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',108,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(25)
expressionOut.print(product.name)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',121,['class':("list"),'action':("index")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',122,['class':("create"),'action':("create")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',124,['action':("edit"),'controller':("FixedDepositPreTermScheme"),'id':(fixedDepositPreTermSchemeInstance.id)],3)
printHtmlPart(35)
if(true && (fixedDepositPreTermSchemeInstance.status.id == 1)) {
printHtmlPart(36)
createTagBody(4, {->
printHtmlPart(37)
invokeTag('actionSubmit','g',128,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',129,['url':([id:fixedDepositPreTermSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (fixedDepositPreTermSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('form','g',134,['id':("deleteFixedDepositPreTermSchemeForm"),'url':([id:fixedDepositPreTermSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(43)
invokeTag('actionSubmit','g',143,['id':("deleteFixedDepositPreTermScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00903', 'form#deleteFixedDepositPreTermSchemeForm', 'Override delete Fixed Deposit PreTerm Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                             
                            """)],-1)
printHtmlPart(44)
}
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',156,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',157,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128924L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
