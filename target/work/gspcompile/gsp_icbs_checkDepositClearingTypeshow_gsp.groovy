import icbs.admin.CheckDepositClearingType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_checkDepositClearingTypeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checkDepositClearingType/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'checkDepositClearingType.label', default: 'CheckDepositClearingType'))],-1)
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
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (checkDepositClearingTypeInstance?.code)) {
printHtmlPart(10)
invokeTag('message','g',31,['code':("checkDepositClearingType.code.label"),'default':("Code")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',33,['bean':(checkDepositClearingTypeInstance),'field':("code")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.description)) {
printHtmlPart(14)
invokeTag('message','g',40,['code':("checkDepositClearingType.description.label"),'default':("Description")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',42,['bean':(checkDepositClearingTypeInstance),'field':("description")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.shortDescription)) {
printHtmlPart(16)
invokeTag('message','g',49,['code':("checkDepositClearingType.shortDescription.label"),'default':("Short Description")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',51,['bean':(checkDepositClearingTypeInstance),'field':("shortDescription")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.isOnUs)) {
printHtmlPart(18)
invokeTag('message','g',58,['code':("checkDepositClearingType.isOnUs.label"),'default':("Is On Us")],-1)
printHtmlPart(19)
invokeTag('formatBoolean','g',60,['boolean':(checkDepositClearingTypeInstance?.isOnUs)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.hasVariableClearingDays)) {
printHtmlPart(20)
invokeTag('message','g',67,['code':("checkDepositClearingType.hasVariableClearingDays.label"),'default':("Has Variable Clearing Days")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',69,['boolean':(checkDepositClearingTypeInstance?.hasVariableClearingDays)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.clearingDays)) {
printHtmlPart(22)
invokeTag('message','g',76,['code':("checkDepositClearingType.clearingDays.label"),'default':("Clearing Days")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',78,['bean':(checkDepositClearingTypeInstance),'field':("clearingDays")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.currency)) {
printHtmlPart(24)
invokeTag('message','g',85,['code':("checkDepositClearingType.currency.label"),'default':("Currency")],-1)
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(checkDepositClearingTypeInstance?.currency?.name)
})
invokeTag('link','g',87,['controller':("currency"),'action':("show"),'id':(checkDepositClearingTypeInstance?.currency?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (checkDepositClearingTypeInstance?.configItemStatus)) {
printHtmlPart(26)
invokeTag('message','g',94,['code':("checkDepositClearingType.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(27)
expressionOut.print(checkDepositClearingTypeInstance?.configItemStatus?.description)
printHtmlPart(12)
}
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('form','g',106,['id':("delete"),'url':([resource:checkDepositClearingTypeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',106,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',113,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',114,['class':("edit"),'action':("edit"),'resource':(checkDepositClearingTypeInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',122,['class':("delete"),'id':("deleteDepositClearingType"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00403', 'form#delete', 'Override delete Check Deposit Clearing Type.', null); 
                                },
                                function(){
                                    return;
                                });                                
                        """)],-1)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',133,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128009L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
