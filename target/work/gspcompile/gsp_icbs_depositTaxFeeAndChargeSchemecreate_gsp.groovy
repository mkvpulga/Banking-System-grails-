import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',57,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',58,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',68,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',69,['bean':(depositTaxFeeAndChargeSchemeInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',71,['bean':(depositTaxFeeAndChargeSchemeInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',74,['template':("form")],-1)
printHtmlPart(19)
})
invokeTag('form','g',77,['id':("depositTaxChargeSchemeForm"),'url':([resource:depositTaxFeeAndChargeSchemeInstance, action:'save'])],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('submitButton','g',91,['name':("create"),'id':("newDepositTaxFeeChargeScheme"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue create?',
                                function(){
                                    checkIfAllowed('CFG01402', 'form#depositTaxChargeSchemeForm', 'Override create Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',92,['class':("list"),'action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',104,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128860L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
