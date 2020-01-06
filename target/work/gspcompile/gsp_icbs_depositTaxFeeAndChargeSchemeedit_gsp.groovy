import icbs.deposit.DepositTaxFeeAndChargeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',58,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',59,[:],1)
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
invokeTag('message','g',69,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',70,['bean':(depositTaxFeeAndChargeSchemeInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',72,['bean':(depositTaxFeeAndChargeSchemeInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',74,['name':("version"),'value':(depositTaxFeeAndChargeSchemeInstance?.version)],-1)
printHtmlPart(19)
invokeTag('render','g',76,['template':("form")],-1)
printHtmlPart(20)
})
invokeTag('form','g',79,['id':("depositTaxChargeSchemeForm"),'url':([resource:depositTaxFeeAndChargeSchemeInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('submitButton','g',93,['name':("create"),'id':("editDepositTaxFeeChargeScheme"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                function(){
                                    checkIfAllowed('CFG01403', 'form#depositTaxChargeSchemeForm', 'Override edit Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                                 
                            """)],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',94,['class':("list"),'action':("show"),'id':(depositTaxFeeAndChargeSchemeInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',105,['tag':("main-actions")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',107,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128861L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
