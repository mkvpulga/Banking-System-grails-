import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositdepositViewMoreInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/depositViewMoreInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(6)
invokeTag('render','g',21,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(7)
invokeTag('render','g',37,['template':("viewMoreInfoTemplates/accountAndBalance")],-1)
printHtmlPart(8)
invokeTag('render','g',41,['template':("viewMoreInfoTemplates/owner")],-1)
printHtmlPart(9)
invokeTag('render','g',45,['template':("/search/searchTemplate/deposit/txn/viewGrid")],-1)
printHtmlPart(10)
invokeTag('render','g',49,['template':("viewMoreInfoTemplates/unclearedDeposits")],-1)
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',56,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');  ")],3)
printHtmlPart(14)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',57,['action':("depositInquiry"),'id':(depositInstance?.id)],3)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(14).baseParams)
printHtmlPart(17)
expressionOut.print(icbs.admin.Report.get(14).outputParam)
printHtmlPart(18)
expressionOut.print(icbs.admin.Report.get(14).reportUnit)
printHtmlPart(19)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(20)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(21)
})
invokeTag('javascript','g',69,[:],3)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(23)
invokeTag('customDatePicker','g',88,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(25)
invokeTag('customDatePicker','g',93,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(15).baseParams)
printHtmlPart(17)
expressionOut.print(icbs.admin.Report.get(15).outputParam)
printHtmlPart(28)
expressionOut.print(icbs.admin.Report.get(15).reportUnit)
printHtmlPart(29)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(30)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(31)
})
invokeTag('javascript','g',111,[:],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128297L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
