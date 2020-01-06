import icbs.admin.ClearingBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_clearingBankshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/clearingBank/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'clearingBank.label', default: 'ClearingBank'))],-1)
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
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (clearingBankInstance?.code)) {
printHtmlPart(11)
invokeTag('message','g',38,['code':("clearingBank.code.label"),'default':("Code")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',40,['bean':(clearingBankInstance),'field':("code")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.name)) {
printHtmlPart(15)
invokeTag('message','g',47,['code':("clearingBank.name.label"),'default':("Name")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',49,['bean':(clearingBankInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.shortName)) {
printHtmlPart(17)
invokeTag('message','g',56,['code':("clearingBank.shortName.label"),'default':("Short Name")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',58,['bean':(clearingBankInstance),'field':("shortName")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.address)) {
printHtmlPart(19)
invokeTag('message','g',65,['code':("clearingBank.address.label"),'default':("Address")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',67,['bean':(clearingBankInstance),'field':("address")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.contactPerson)) {
printHtmlPart(21)
invokeTag('message','g',74,['code':("clearingBank.contactPerson.label"),'default':("Contact Person")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',76,['bean':(clearingBankInstance),'field':("contactPerson")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.contact)) {
printHtmlPart(23)
invokeTag('message','g',83,['code':("clearingBank.contact.label"),'default':("Contact")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',85,['bean':(clearingBankInstance),'field':("contact")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.email)) {
printHtmlPart(25)
invokeTag('message','g',92,['code':("clearingBank.email.label"),'default':("Email")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',94,['bean':(clearingBankInstance),'field':("email")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.swiftCode)) {
printHtmlPart(27)
invokeTag('message','g',101,['code':("clearingBank.swiftCode.label"),'default':("Swift Code")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',103,['bean':(clearingBankInstance),'field':("swiftCode")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (clearingBankInstance?.configItemStatus)) {
printHtmlPart(29)
invokeTag('message','g',110,['code':("clearingBank.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(30)
expressionOut.print(clearingBankInstance?.configItemStatus?.description)
printHtmlPart(13)
}
printHtmlPart(31)
invokeTag('form','g',121,['id':("delete"),'url':([resource:clearingBankInstance, action:'delete']),'method':("DELETE")],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createTagBody(3, {->
invokeTag('message','g',128,['code':("default.new.clearingBank"),'args':([entityName]),'default':("New Clearing Bank")],-1)
})
invokeTag('link','g',128,['class':("create"),'action':("create")],3)
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',134,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',134,['class':("edit"),'action':("edit"),'resource':(clearingBankInstance)],3)
printHtmlPart(35)
invokeTag('actionSubmit','g',139,['class':("delete"),'id':("deleteClearingBank"),'name':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00303', 'form#delete', 'Override delete clearing bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                """)],-1)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',149,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128029L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
