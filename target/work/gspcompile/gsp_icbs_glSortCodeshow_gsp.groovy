import icbs.gl.GlSortCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glSortCodeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glSortCode/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glSortCode.label', default: 'Gl Sort Code'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (glSortCodeInstance?.sort_code)) {
printHtmlPart(9)
invokeTag('fieldValue','g',33,['bean':(glSortCodeInstance),'field':("sort_code")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (glSortCodeInstance?.sort_name)) {
printHtmlPart(12)
invokeTag('fieldValue','g',39,['bean':(glSortCodeInstance),'field':("sort_name")],-1)
printHtmlPart(10)
}
printHtmlPart(13)
if(true && (glSortCodeInstance?.parent_id)) {
printHtmlPart(14)
createTagBody(4, {->
expressionOut.print(glSortCodeInstance?.parent_id?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("glAcctType"),'action':("show"),'id':(glSortCodeInstance?.parent_id?.id)],4)
printHtmlPart(10)
}
printHtmlPart(15)
if(true && (glSortCodeInstance?.sort_code_status)) {
printHtmlPart(16)
invokeTag('formatBoolean','g',51,['boolean':(glSortCodeInstance?.sort_code_status)],-1)
printHtmlPart(10)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
createTagBody(4, {->
invokeTag('message','g',63,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',63,['class':("edit"),'action':("edit"),'resource':(glSortCodeInstance)],4)
printHtmlPart(19)
invokeTag('actionSubmit','g',64,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(20)
})
invokeTag('form','g',67,['url':([resource:glSortCodeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(24)
invokeTag('message','g',72,['code':("default.home.label")],-1)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',73,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',73,['class':("list"),'action':("index")],3)
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',74,['class':("create"),'action':("create")],3)
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',75,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',75,['class':("edit"),'action':("edit"),'resource':(glSortCodeInstance)],3)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('form','g',80,['id':("deleteSC"),'url':([resource:glSortCodeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129001L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
