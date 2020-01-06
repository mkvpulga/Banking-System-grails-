import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'CreditInvestigation', action:'collectionInformation'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showAttachmentsAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'creditInvestigation', action:'addAttachmentAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'creditInvestigation', action:'showAddAttachmentAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'creditInvestigation', action:'updateAttachmentAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showUpdateAttachmentAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'creditInvestigation', action:'deleteAttachmentAjax'))
printHtmlPart(12)
expressionOut.print(loanApplication?.id)
printHtmlPart(13)
})
invokeTag('javascript','g',163,[:],2)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',164,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('captureContent','sitemesh',168,['tag':("breadcrumbs")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(18)
if(true && (flash.message)) {
printHtmlPart(19)
expressionOut.print(flash.message)
printHtmlPart(20)
}
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('hasErrors','g',191,['bean':(creditInvestigationInstance)],3)
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('render','g',202,['template':("details/form")],-1)
printHtmlPart(24)
invokeTag('render','g',205,['template':("attachments/list")],-1)
printHtmlPart(25)
})
invokeTag('uploadForm','g',209,['id':("credit-investigation-form"),'onsubmit':("callLoadingDialog();"),'url':([resource:creditInvestigationInstance, action:'save'])],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',211,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('submitButton','g',222,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('LON00401', 'form#credit-investigation-form', 'Save Credit Investigation', null); 
                                },
                                function(){
                                    return;
                                });                          
                    """)],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',232,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',234,['tag':("main-actions")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',235,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128106L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
