import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerInfobase_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerInfobase.gsp" }
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
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(2)
createTagBody(3, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'Customer', action:'removeCustomerInfoBaseAjax'))
printHtmlPart(6)
})
invokeTag('javascript','g',56,[:],3)
printHtmlPart(7)
invokeTag('render','g',58,['template':("details/customerDetails"),'model':([customerInstance:customerInstance,boxName:'CIF INFO'])],-1)
printHtmlPart(8)
invokeTag('set','g',71,['var':("i"),'value':(0)],-1)
printHtmlPart(9)
for( infobase in (result) ) {
printHtmlPart(10)
if(true && (infobase.status?.id!=3)) {
printHtmlPart(11)
expressionOut.print(infobase?.refDate.format("MM/dd/yyyy"))
printHtmlPart(12)
expressionOut.print(infobase?.infoMessage)
printHtmlPart(13)
expressionOut.print(infobase?.user?.username)
printHtmlPart(14)
expressionOut.print(infobase.id)
printHtmlPart(15)
expressionOut.print(params?.id)
printHtmlPart(16)
}
printHtmlPart(10)
invokeTag('set','g',93,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(9)
}
printHtmlPart(17)
invokeTag('paginate','g',97,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(19)
if(true && (customerInstance)) {
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(21)
invokeTag('textArea','g',121,['class':("form-control"),'name':("infoMessage"),'id':("infoMessage"),'value':(""),'rows':("6"),'cols':("40")],-1)
printHtmlPart(22)
createTagBody(4, {->
printHtmlPart(23)
expressionOut.print(params.id)
printHtmlPart(24)
expressionOut.print(createLink(controller:'customer', action: 'createCustomerInfoBaseAjax'))
printHtmlPart(25)
expressionOut.print(params.id)
printHtmlPart(26)
})
invokeTag('javascript','g',165,[:],4)
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',174,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',176,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',177,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128197L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
