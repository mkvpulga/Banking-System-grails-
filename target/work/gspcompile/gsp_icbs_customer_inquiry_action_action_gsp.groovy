import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquiry_action_action_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/action/_action.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('link','g',9,['action':("amlaRisk"),'id':(customerInstance.id)],1)
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('link','g',11,['class':(""),'action':("customerSearch")],1)
printHtmlPart(5)
if(true && (customerInstance)) {
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',13,['action':("customerViewMoreInformation"),'id':(customerInstance.id)],2)
printHtmlPart(5)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (customerInstance&&customerInstance.status?.id!=3)) {
printHtmlPart(6)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',19,['class':("edit"),'action':("edit"),'resource':(customerInstance)],2)
printHtmlPart(5)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (customerInstance)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(9)
if(true && (customerInstance?.type?.id==1&&customerInstance.status?.id!=3)) {
printHtmlPart(6)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',31,['action':("customerShowRelated"),'id':(customerInstance?.id)],2)
printHtmlPart(5)
}
printHtmlPart(9)
if(true && (customerInstance?.type?.id!=1&&customerInstance.status?.id!=3)) {
printHtmlPart(6)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',34,['action':("customerShowRelated"),'id':(customerInstance?.id)],2)
printHtmlPart(5)
}
printHtmlPart(9)
if(true && (customerInstance)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(9)
if(true && (customerInstance&&customerInstance.status?.id!=3)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(9)
if(true && (customerInstance&&customerInstance.status?.id==2)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',54,['action':("customerInfobase"),'id':(customerInstance?.id)],1)
printHtmlPart(25)
createClosureForHtmlPart(26, 1)
invokeTag('link','g',55,['class':(""),'action':("create"),'resource':("")],1)
printHtmlPart(27)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(28)
invokeTag('message','g',57,['code':("default.home.label")],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 1)
invokeTag('link','g',59,['action':("viewLoanComakerRelationship"),'id':(customerInstance?.id)],1)
printHtmlPart(31)
createClosureForHtmlPart(32, 1)
invokeTag('link','g',61,['action':("viewCustomerCollateral"),'id':(customerInstance?.id)],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128253L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
