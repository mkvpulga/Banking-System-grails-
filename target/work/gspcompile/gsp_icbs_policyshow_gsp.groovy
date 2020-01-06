import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'policy.label', default: 'Policy'))],-1)
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
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/policy'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (policyInstance.policyTemplate.type.toString() == 'TXN')) {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(policyInstance?.policyTemplate?.description)
printHtmlPart(14)
expressionOut.print(policyInstance?.description)
printHtmlPart(15)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(policyInstance?.txnAmtCondition)],-1)
printHtmlPart(16)
expressionOut.print(policyInstance?.policyAction?.description)
printHtmlPart(17)
expressionOut.print(policyInstance?.reference)
printHtmlPart(18)
expressionOut.print(policyInstance?.configItemStatus?.description)
printHtmlPart(19)
for( txnTemplate in (policyInstance.txnTemplates) ) {
printHtmlPart(20)
expressionOut.print(txnTemplate.description)
printHtmlPart(21)
}
printHtmlPart(22)
for( role in (policyInstance.roles) ) {
printHtmlPart(20)
expressionOut.print(role.name)
printHtmlPart(23)
}
printHtmlPart(24)
for( approver in (policyInstance.approvers) ) {
printHtmlPart(25)
expressionOut.print(approver.name)
printHtmlPart(26)
}
printHtmlPart(27)
createClosureForHtmlPart(1, 3)
invokeTag('form','g',101,['id':("remove"),'url':([resource:policyInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',106,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',106,['class':("create"),'action':("create")],3)
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',107,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',107,['class':("edit"),'action':("edit"),'resource':(policyInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',108,['id':("deletePolicy"),'resource':(policyInstance),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete'))],-1)
printHtmlPart(33)
if(true && (policyInstance?.configItemStatus?.id == 1 || policyInstance?.configItemStatus?.id == 2)) {
printHtmlPart(34)
invokeTag('actionSubmit','g',118,['id':("deletePolicy"),'form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00404', 'form#remove', 'Remove policy.', null);
                                },
                                function(){
                                    return;
                                });                                       
                                """)],-1)
printHtmlPart(35)
}
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',130,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',131,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129300L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
