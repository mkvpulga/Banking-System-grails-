import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (customerGroupInstance?.code)) {
printHtmlPart(9)
invokeTag('message','g',19,['code':("customerGroup.code.label"),'default':("Code")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',21,['bean':(customerGroupInstance),'field':("code")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (customerGroupInstance?.name)) {
printHtmlPart(13)
invokeTag('message','g',28,['code':("customerGroup.name.label"),'default':("Name")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',30,['bean':(customerGroupInstance),'field':("name")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (customerGroupInstance?.configItemStatus)) {
printHtmlPart(15)
invokeTag('message','g',37,['code':("customerGroup.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(16)
expressionOut.print(customerGroupInstance?.configItemStatus?.description)
printHtmlPart(11)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('form','g',46,['id':("delete"),'url':([resource:customerGroupInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',47,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',51,['code':("default.new.customerGroup"),'args':([entityName]),'default':("New Customer Group")],-1)
})
invokeTag('link','g',51,['class':("create"),'action':("create")],3)
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',52,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',52,['class':("btn btn-primary"),'action':("edit"),'resource':(customerGroupInstance)],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',53,['id':("deleteCustomerGroup"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128276L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
