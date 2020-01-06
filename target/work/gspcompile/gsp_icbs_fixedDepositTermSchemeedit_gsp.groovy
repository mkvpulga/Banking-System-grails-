import icbs.deposit.FixedDepositTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermSchemeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'fixedDepositTermScheme.label', default: 'FixedDepositTermScheme'))],-1)
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
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',18,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',19,['bean':(fixedDepositTermSchemeInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',21,['bean':(fixedDepositTermSchemeInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',23,['name':("version"),'value':(fixedDepositTermSchemeInstance?.version)],-1)
printHtmlPart(17)
invokeTag('render','g',25,['template':("form")],-1)
printHtmlPart(18)
})
invokeTag('form','g',27,['id':("fixedDepositTermSchemeForm"),'url':([resource:fixedDepositTermSchemeInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',29,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('submitButton','g',41,['name':("edit"),'id':("editfixedDepositTermScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.Update.label', default: 'Update')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01503', 'form#fixedDepositTermSchemeForm', 'Override new fixed deposit term scheme form.', null); 
                                },
                                function(){
                                    return;
                                });                                 
                            """)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',42,['class':("list"),'action':("show"),'id':(fixedDepositTermSchemeInstance.id)],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-actions")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128927L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
