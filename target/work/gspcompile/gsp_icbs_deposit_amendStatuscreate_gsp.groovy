import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_amendStatuscreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/amendStatus/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('render','g',18,['template':("inquiry/depositInquiryForm")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: depositInstance, field: 'branch', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',33,['code':("deposit.branch.label"),'default':("Current Deposit Status")],-1)
printHtmlPart(9)
invokeTag('textField','g',36,['id':("oldStatus"),'name':("oldStatus"),'value':(depositInstance?.status?.description),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',37,['id':("idOldStatus"),'name':("idOldStatus"),'value':(depositInstance?.status?.id)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: depositInstance, field: 'branch', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',42,['code':("deposit.branch.label"),'default':("Deposit Status")],-1)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('hiddenField','g',46,['id':("deposit"),'name':("deposit"),'value':(params.id)],-1)
printHtmlPart(13)
if(true && (depositInstance?.status?.id == 5)) {
printHtmlPart(14)
invokeTag('select','g',49,['id':("status"),'name':("status.id"),'from':(icbs.lov.DepositStatus.findAll{id == 3}),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': 'Select New Deposit Status'])],-1)
printHtmlPart(12)
}
else if(true && (depositInstance?.status?.id == 3)) {
printHtmlPart(14)
invokeTag('select','g',52,['id':("status"),'name':("status.id"),'from':(icbs.lov.DepositStatus.findAll{id == 2 || id == 5}),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': 'Select New Deposit Status'])],-1)
printHtmlPart(12)
}
else if(true && (depositInstance?.status?.id == 2)) {
printHtmlPart(14)
invokeTag('select','g',55,['id':("status"),'name':("status.id"),'from':(icbs.lov.DepositStatus.findAll{id == 5}),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': 'Select New Deposit Status'])],-1)
printHtmlPart(12)
}
printHtmlPart(10)
})
invokeTag('form','g',55,['name':("amendDepositForm"),'id':("amendDepositForm"),'url':([action:'saveAmendDepositStatus',controller:'deposit']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(depositInstance?.id)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',98,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',99,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128279L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
