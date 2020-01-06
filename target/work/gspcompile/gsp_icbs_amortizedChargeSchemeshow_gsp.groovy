import icbs.loans.AmortizedChargeScheme
import icbs.lov.LoanServiceChargeType
import icbs.lov.LoanServiceChargeBasis
import icbs.lov.LoanInstallmentFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_amortizedChargeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/amortizedChargeScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'amortizedChargeScheme.label', default: 'AmortizedChargeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
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
invokeTag('message','g',36,['code':("amortizedChargeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',37,['bean':(amortizedChargeSchemeInstance),'field':("code")],-1)
printHtmlPart(10)
invokeTag('message','g',41,['code':("amortizedChargeScheme.name.label"),'default':("Name")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',42,['bean':(amortizedChargeSchemeInstance),'field':("name")],-1)
printHtmlPart(10)
invokeTag('message','g',46,['code':("amortizedChargeScheme.basis.label"),'default':("Basis")],-1)
printHtmlPart(9)
expressionOut.print(amortizedChargeSchemeInstance?.basis?.description)
printHtmlPart(12)
invokeTag('message','g',51,['code':("amortizedChargeScheme.type.label"),'default':("Service Charge Type")],-1)
printHtmlPart(9)
expressionOut.print(amortizedChargeSchemeInstance?.type?.description)
printHtmlPart(13)
if(true && (amortizedChargeSchemeInstance.type.id == 1)) {
printHtmlPart(14)
invokeTag('message','g',57,['code':("amortizedChargeScheme.amount.label"),'default':("Service Charge Amount")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',60,['bean':(amortizedChargeSchemeInstance),'field':("amount")],-1)
printHtmlPart(15)
}
else if(true && (amortizedChargeSchemeInstance.type.id == 2)) {
printHtmlPart(14)
invokeTag('message','g',63,['code':("amortizedChargeScheme.rate.label"),'default':("Service Charge Rate")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',67,['bean':(amortizedChargeSchemeInstance),'field':("rate")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',70,['code':("amortizedChargeScheme.hasEirMode.label"),'default':("EIR Mode")],-1)
printHtmlPart(9)
invokeTag('formatBoolean','g',73,['boolean':(amortizedChargeSchemeInstance?.hasEirMode)],-1)
printHtmlPart(18)
invokeTag('message','g',75,['code':("amortizedChargeScheme.status.label"),'default':("Status")],-1)
printHtmlPart(9)
expressionOut.print(amortizedChargeSchemeInstance?.status?.description)
printHtmlPart(19)
for( product in (amortizedChargeSchemeInstance?.products) ) {
printHtmlPart(20)
expressionOut.print(product?.name)
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',86,['class':("list"),'action':("index")],3)
printHtmlPart(25)
if(true && (amortizedChargeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',94,['action':("edit"),'controller':("amortizedChargeScheme"),'id':(amortizedChargeSchemeInstance.id)],4)
printHtmlPart(25)
}
printHtmlPart(28)
if(true && (amortizedChargeSchemeInstance.status.id == 1)) {
printHtmlPart(29)
createClosureForHtmlPart(30, 4)
invokeTag('form','g',95,['id':("activate"),'url':([resource:amortizedChargeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(30)
invokeTag('actionSubmit','g',100,['id':("activateAmortChargeScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (amortizedChargeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(29)
createClosureForHtmlPart(33, 4)
invokeTag('form','g',104,['id':("delete"),'url':([resource:amortizedChargeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(34)
invokeTag('actionSubmit','g',111,['id':("deleteAmortChargeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01204', 'form#delete', 'Override new Check Deposit Clearing Type.', null);
                                },
                                function(){
                                    return;
                                });                        
                        """)],-1)
printHtmlPart(31)
}
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127892L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
