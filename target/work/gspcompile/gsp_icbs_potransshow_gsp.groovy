import accounting.bankpayables.AccountsPayables
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_potransshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/potrans/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'accountsPayables.label', default: 'accountsPayables'))],-1)
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
expressionOut.print(createLink(uri: '/potrans'))
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
if(true && (accountsPayablesInstance?.reference)) {
printHtmlPart(11)
invokeTag('message','g',24,['code':("payables.reference.label"),'default':("Reference")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',26,['bean':(accountsPayablesInstance),'field':("reference")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (accountsPayablesInstance?.amount)) {
printHtmlPart(15)
invokeTag('message','g',33,['code':("payables.amount.label"),'default':("Amount")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',35,['bean':(accountsPayablesInstance),'field':("amount")],-1)
printHtmlPart(13)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('actionSubmit','g',44,['class':("btn btn-primary"),'action':("update"),'value':(message(code: 'default.button.Disburse.label', default: 'Disburse'))],-1)
printHtmlPart(19)
})
invokeTag('form','g',46,['url':([resource:accountsPayablesInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',51,['code':("default.newupdate.label"),'args':([entityName]),'default':("New AP")],-1)
})
invokeTag('link','g',51,['class':("create"),'action':("create")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',52,['action':("edit"),'id':(accountsPayablesInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',54,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129306L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
