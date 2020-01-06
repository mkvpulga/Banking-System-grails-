import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(7)
createTagBody(4, {->
printHtmlPart(8)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(9)
expressionOut.print(error.field)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',16,['error':(error)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',17,['bean':(customerGroupInstance),'var':("error")],4)
printHtmlPart(13)
})
invokeTag('hasErrors','g',19,['bean':(customerGroupInstance)],3)
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('render','g',22,['template':("form")],-1)
printHtmlPart(15)
})
invokeTag('form','g',24,['id':("create"),'url':([resource:customerGroupInstance, action:'save'])],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',25,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('submitButton','g',36,['name':("create"),'id':("newCustomerGroup"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG00602', 'form#create', 'Override new Customer Group.', null); 
                                },
                                function(){
                                    return;
                                });                                          
                                    """)],-1)
printHtmlPart(17)
createTagBody(3, {->
invokeTag('message','g',37,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',37,['action':("index")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128273L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
