import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_holidaycreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/holiday/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'holiday.label', default: 'Holiday'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/holiday'))
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
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
invokeTag('message','g',23,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',24,['bean':(holidayInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',26,['bean':(holidayInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',39,['template':("form")],-1)
printHtmlPart(20)
invokeTag('render','g',45,['template':("branch")],-1)
printHtmlPart(21)
})
invokeTag('form','g',47,['form':("create"),'id':("create"),'url':([resource:holidayInstance, action:'save'])],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',52,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('submitButton','g',63,['id':("newHoliday"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00302', 'form#create', 'Created a new holiday.', null);                               
                                    },
                                function(){
                                    return;
                                });                    
                """)],-1)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',64,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',64,['action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129016L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
