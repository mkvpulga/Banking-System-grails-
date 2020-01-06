import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
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
invokeTag('message','g',17,['error':(error)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',18,['bean':(customerGroupInstance),'var':("error")],4)
printHtmlPart(13)
})
invokeTag('hasErrors','g',20,['bean':(customerGroupInstance)],3)
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',22,['name':("version"),'value':(customerGroupInstance?.version)],-1)
printHtmlPart(15)
invokeTag('render','g',24,['template':("form")],-1)
printHtmlPart(16)
})
invokeTag('form','g',26,['id':("edit"),'url':([resource:customerGroupInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',27,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('actionSubmit','g',38,['id':("editCustomerGroup"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG00603', 'form#edit', 'Override new Customer Group.', null) 
                                },
                                function(){
                                    return;
                                });                                        
                                    """)],-1)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',50,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128274L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
