import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',7,['src':("depositHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'depositInterestScheme', action:'addGraduatedFormAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',22,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',33,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',34,['bean':(depositInterestSchemeInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',36,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',39,['template':("form")],-1)
printHtmlPart(20)
})
invokeTag('form','g',44,['id':("DepositInterestSchemeForm"),'url':([resource:depositInterestSchemeInstance, action:'save'])],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',46,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('submitButton','g',57,['name':("create"),'id':("newDepositIntScheme"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01002', 'form#DepositInterestSchemeForm', 'Override new Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                            
                        """)],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',59,['class':("list"),'action':("index")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128849L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
