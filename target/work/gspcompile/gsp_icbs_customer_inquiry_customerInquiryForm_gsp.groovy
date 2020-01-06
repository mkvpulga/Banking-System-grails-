import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquiry_customerInquiryForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/_customerInquiryForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(2)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (customerInstance?.type.id==1)) {
printHtmlPart(5)
expressionOut.print(customerInstance?.name3)
printHtmlPart(6)
expressionOut.print(customerInstance?.name1)
printHtmlPart(7)
expressionOut.print(customerInstance?.name2)
printHtmlPart(8)
expressionOut.print(customerInstance?.title?.itemValue)
printHtmlPart(9)
expressionOut.print(customerInstance?.name4)
printHtmlPart(10)
expressionOut.print(customerInstance?.gender?.description)
printHtmlPart(11)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(12)
if(true && (customerInstance?.birthDate)) {
printHtmlPart(13)
invokeTag('formatNumber','g',55,['format':("####"),'number':((customerInstance?.branch?.runDate - customerInstance?.birthDate)/365.25)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(customerInstance?.dosriCode?.description)
printHtmlPart(16)
}
else {
printHtmlPart(17)
expressionOut.print(customerInstance?.name1)
printHtmlPart(18)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(21)
expressionOut.print(customerInstance?.type?.description)
printHtmlPart(22)
expressionOut.print(customerInstance?.status?.description)
printHtmlPart(23)
invokeTag('set','g',104,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(24)
if(true && (primaryAddress!=null)) {
printHtmlPart(25)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (customerInstance?.addresses?.size()>0)) {
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
printHtmlPart(31)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryPhone ==true})?.contactValue)
printHtmlPart(32)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryEmail ==true})?.contactValue)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128252L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
