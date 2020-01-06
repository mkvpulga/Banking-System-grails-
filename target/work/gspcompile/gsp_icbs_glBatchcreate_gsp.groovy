import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'glBatch.label', default: 'General Ledger Batch Transactions'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(createLink(controller:'glBatch',action:'saveGLBatchTransactions'))
printHtmlPart(3)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'GlBatch',action:'addAttachment'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'GlBatch',action:'removeAttachment'))
printHtmlPart(7)
})
invokeTag('javascript','g',151,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',152,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',164,['error':(error)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',165,['bean':(glBatchInstance),'var':("error")],4)
printHtmlPart(20)
})
invokeTag('hasErrors','g',167,['bean':(glBatchInstance)],3)
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('render','g',180,['template':("form")],-1)
printHtmlPart(23)
})
invokeTag('form','g',182,['url':([resource:glBatchInstance, action:'save'])],3)
printHtmlPart(24)
invokeTag('render','g',194,['template':("transactions_table")],-1)
printHtmlPart(25)
invokeTag('render','g',198,['template':("batch_attachment")],-1)
printHtmlPart(26)
invokeTag('render','g',209,['template':("modal")],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',212,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(29)
invokeTag('message','g',215,['code':("default.home.label")],-1)
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',216,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',216,['class':("list"),'action':("index")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',217,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',218,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128967L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
