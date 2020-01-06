import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerviewCustomerCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewCustomerCollateral.gsp" }
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
for( customerCollateral in (results) ) {
printHtmlPart(8)
expressionOut.print(customerCollateral?.owner?.id)
printHtmlPart(9)
expressionOut.print(customerCollateral?.owner?.displayName)
printHtmlPart(9)
expressionOut.print(customerCollateral?.collateralType?.description)
printHtmlPart(9)
invokeTag('formatNumber','g',46,['number':(customerCollateral?.appraisedValue),'format':("###,##0.00")],-1)
printHtmlPart(9)
expressionOut.print(customerCollateral?.status?.description)
printHtmlPart(10)
expressionOut.print(customerCollateral?.id)
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
invokeTag('paginate','g',71,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(13)
invokeTag('render','g',87,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(14)
invokeTag('render','g',107,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(15)
invokeTag('render','g',127,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',139,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',142,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',144,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',145,[:],1)
printHtmlPart(20)
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
