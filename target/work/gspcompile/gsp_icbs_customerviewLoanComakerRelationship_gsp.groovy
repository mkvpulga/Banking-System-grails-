import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerviewLoanComakerRelationship_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewLoanComakerRelationship.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("customerHelper.js")],-1)
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',15,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('render','g',20,['template':("details/customerDetails"),'model':([customerInstance:customerInstance,boxName:'CIF INFO'])],-1)
printHtmlPart(7)
loop:{
int i = 0
for( customerLoanComakerDetails in (resultqueryall) ) {
printHtmlPart(8)
expressionOut.print(customerLoanComakerDetails?.customer_id)
printHtmlPart(9)
expressionOut.print(customerLoanComakerDetails?.display_name)
printHtmlPart(9)
expressionOut.print(customerLoanComakerDetails?.account_no)
printHtmlPart(9)
expressionOut.print(customerLoanComakerDetails?.description)
printHtmlPart(10)
expressionOut.print(customerLoanComakerDetails?.customer_id)
printHtmlPart(11)
expressionOut.print(customerLoanComakerDetails?.id)
printHtmlPart(12)
expressionOut.print(customerLoanComakerDetails?.loan_application_id)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',90,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(15)
invokeTag('render','g',106,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(16)
invokeTag('render','g',126,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(17)
invokeTag('render','g',146,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',158,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',161,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',163,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',164,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128270L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
