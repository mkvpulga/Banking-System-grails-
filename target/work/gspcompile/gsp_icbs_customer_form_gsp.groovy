import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (!customerInstance?.id&&customerInstance?.type?.id == 1)) {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (!customerInstance?.id&&customerInstance?.type?.id != 1)) {
printHtmlPart(4)
}
printHtmlPart(3)
if(true && (customerInstance?.type?.id<2)) {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(7)
invokeTag('render','g',26,['template':("form/customer/customerverification/private")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(7)
invokeTag('render','g',29,['template':("form/customer/customerverification/corporation")],-1)
printHtmlPart(3)
}
printHtmlPart(8)
invokeTag('render','g',33,['template':("form/customer/othercustomerinfo/otherCustomerInfo")],-1)
printHtmlPart(9)
invokeTag('render','g',35,['template':("form/contact/contactInfo")],-1)
printHtmlPart(10)
invokeTag('render','g',38,['template':("form/address/addrInfo")],-1)
printHtmlPart(11)
invokeTag('render','g',42,['template':("form/jointviews/employmentsAndBusinessInfo")],-1)
printHtmlPart(12)
if(true && (!customerInstance?.id)) {
printHtmlPart(13)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
invokeTag('render','g',49,['template':("form/relation/relationInfoBusiness"),'model':([customerRelationshipType:customerInstance?.type?.id])],-1)
printHtmlPart(16)
}
printHtmlPart(17)
}
printHtmlPart(3)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(18)
invokeTag('render','g',54,['template':("form/education/educationInfo")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('render','g',57,['template':("form/jointviews/extendedAndAttachmentInfo")],-1)
printHtmlPart(21)
invokeTag('render','g',61,['template':("form/jointviews/presentedIdsAndOtherAcctsInfo")],-1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128192L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
