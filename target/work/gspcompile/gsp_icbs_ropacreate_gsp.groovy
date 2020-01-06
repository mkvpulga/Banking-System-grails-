import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropacreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',125,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',126,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('captureContent','sitemesh',130,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(19)
expressionOut.print(error.field)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('message','g',139,['error':("${error.field} - ${error}")],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',140,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(23)
})
invokeTag('hasErrors','g',142,['bean':(ropaInstance)],3)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('render','g',145,['template':("form")],-1)
printHtmlPart(25)
})
invokeTag('form','g',147,['id':("create"),'url':([resource:ropaInstance, action:'save'])],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('submitButton','g',160,['id':("newRopa"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue create ROPA?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#create', 'Create New ROPA', null); 
                                },
                                function(){
                                    return;
                            }); 
                """)],-1)
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',161,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',161,['action':("index")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',163,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',164,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129339L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
