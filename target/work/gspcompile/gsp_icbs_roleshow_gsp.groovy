import icbs.admin.Role
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roleshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/role/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'role.label', default: 'Role'))],-1)
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
expressionOut.print(createLink(uri: '/role'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (roleInstance?.code)) {
printHtmlPart(12)
invokeTag('fieldValue','g',45,['bean':(roleInstance),'field':("code")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (roleInstance?.name)) {
printHtmlPart(15)
invokeTag('fieldValue','g',51,['bean':(roleInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (roleInstance?.configItemStatus)) {
printHtmlPart(16)
expressionOut.print(roleInstance?.configItemStatus?.description)
printHtmlPart(13)
}
printHtmlPart(17)
for( module in (roleInstance.modules) ) {
printHtmlPart(18)
expressionOut.print(module.name)
printHtmlPart(19)
}
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('form','g',86,['id':("remove"),'url':([resource:roleInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',92,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',92,['class':("create"),'action':("create")],3)
printHtmlPart(24)
if(true && (roleInstance.configItemStatus.id.toInteger() in [1, 2])) {
printHtmlPart(25)
createTagBody(4, {->
invokeTag('message','g',94,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',94,['action':("edit"),'resource':(roleInstance)],4)
printHtmlPart(26)
invokeTag('actionSubmit','g',95,['id':("deleteRole"),'class':("btn btn-primary"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(27)
invokeTag('actionSubmit','g',104,['id':("deleteRole"),'resource':(roleInstance),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00304', 'form#remove', 'Remove role.', null);
                                },
                                function(){
                                    return;
                                });                           
                    """)],-1)
printHtmlPart(24)
}
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',116,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129327L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
