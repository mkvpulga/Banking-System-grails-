import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_amortizedChargeSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/amortizedChargeScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'amortizedChargeScheme.label', default: 'AmortizedChargeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',30,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('hasErrors','g',55,['bean':(amortizedChargeSchemeInstance)],3)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('render','g',66,['template':("details")],-1)
printHtmlPart(12)
invokeTag('render','g',71,['template':("products")],-1)
printHtmlPart(13)
})
invokeTag('form','g',75,['id':("create"),'url':([resource:amortizedChargeSchemeInstance, action:'save'])],3)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('submitButton','g',80,['name':("save"),'value':("Save"),'onclick':("jQuery('#form').submit()")],-1)
printHtmlPart(16)
invokeTag('submitButton','g',89,['name':("create"),'id':("newAmortChargeScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01202', 'form#create', 'Override new Amortized Service Charge.', null);
                                },
                                function(){
                                    return;
                                });                              
                        """)],-1)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',90,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127888L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
