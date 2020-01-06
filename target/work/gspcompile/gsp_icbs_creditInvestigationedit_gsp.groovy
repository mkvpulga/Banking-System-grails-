import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(4)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showAttachmentsAjax2'))
printHtmlPart(5)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'creditInvestigation', action:'addAttachmentAjax2'))
printHtmlPart(7)
expressionOut.print(createLink(controller: 'creditInvestigation', action:'showAddAttachmentAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'creditInvestigation', action:'updateAttachmentAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showUpdateAttachmentAjax2'))
printHtmlPart(10)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(11)
expressionOut.print(createLink(controller:'creditInvestigation', action:'deleteAttachmentAjax2'))
printHtmlPart(12)
})
invokeTag('javascript','g',107,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',108,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('captureContent','sitemesh',112,['tag':("breadcrumbs")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('hasErrors','g',135,['bean':(creditInvestigationInstance)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',137,['name':("version"),'value':(creditInvestigationInstance?.version)],-1)
printHtmlPart(22)
invokeTag('render','g',147,['template':("details/form")],-1)
printHtmlPart(23)
invokeTag('render','g',150,['template':("attachments/list")],-1)
printHtmlPart(24)
})
invokeTag('form','g',154,['id':("credit-investigation-form"),'onsubmit':("callLoadingDialog();"),'url':([controller:creditInvestigation, action:'update', id:creditInvestigationInstance?.id]),'method':("PUT")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',156,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('submitButton','g',159,['id':("save"),'name':("save"),'value':("Save")],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',175,['class':("list"),'action':("show"),'id':(creditInvestigationInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-actions")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',178,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128110L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
