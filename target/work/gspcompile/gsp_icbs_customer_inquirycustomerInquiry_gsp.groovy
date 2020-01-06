import icbs.deposit.Signatory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquirycustomerInquiry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/customerInquiry.gsp" }
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
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',9,['src':("customerHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'customer', action:'getCustomerUpdateStatusFormAjax'))
printHtmlPart(5)
expressionOut.print(customerInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'customer', action:'getCustomerUpdateCreditLimitFormAjax'))
printHtmlPart(5)
expressionOut.print(customerInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateInquiryFormAjax'))
printHtmlPart(5)
expressionOut.print(customerInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateStatusAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateCreditLimitAjax'))
printHtmlPart(10)
})
invokeTag('javascript','g',63,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',64,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('render','g',68,['template':("inquiry/customerInquiryForm")],-1)
printHtmlPart(13)
loop:{
int i = 0
for( address in (customerInstance?.addresses) ) {
printHtmlPart(14)
if(true && (address.statusId==2)) {
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
expressionOut.print(address?.type.description)
printHtmlPart(17)
if(true && (address?.isPrimary)) {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(address?.address1)
printHtmlPart(20)
expressionOut.print(address?.address2)
printHtmlPart(20)
expressionOut.print(address?.town)
printHtmlPart(20)
expressionOut.print(address?.address3)
printHtmlPart(21)
if(true && (address?.postalCode)) {
printHtmlPart(22)
expressionOut.print(address?.postalCode)
}
printHtmlPart(23)
if(true && (address?.phone1)) {
printHtmlPart(24)
expressionOut.print(address?.phone1)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (address?.phone2)) {
printHtmlPart(24)
expressionOut.print(address?.phone2)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(27)
if(true && (address?.phone3)) {
printHtmlPart(24)
expressionOut.print(address?.phone3)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(28)
if(true && (address?.phone4)) {
printHtmlPart(24)
expressionOut.print(address?.phone4)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(29)
if(true && (address?.isMailing)) {
printHtmlPart(30)
}
printHtmlPart(24)
if(true && (address?.isMortaged)) {
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (address?.isOwned)) {
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(35)
i++
}
}
printHtmlPart(36)
invokeTag('render','g',146,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(37)
invokeTag('render','g',167,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(38)
invokeTag('render','g',190,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(39)
loop:{
int i = 0
for( deposit in (customerInstance?.deposits) ) {
printHtmlPart(40)
expressionOut.print(deposit?.product?.name)
printHtmlPart(41)
createTagBody(4, {->
expressionOut.print(deposit.acctNo)
})
invokeTag('link','g',206,['action':("depositInquiry"),'controller':("deposit"),'id':(deposit?.id)],4)
printHtmlPart(41)
expressionOut.print(deposit?.status?.description)
printHtmlPart(42)
i++
}
}
printHtmlPart(43)
loop:{
int p = 0
for( thesignatories in (icbs.deposit.Signatory.findAllBySignatory(customerInstance)) ) {
printHtmlPart(44)
createTagBody(4, {->
expressionOut.print(thesignatories?.deposit?.acctName)
})
invokeTag('link','g',227,['target':("_blank"),'action':("customerInquiry"),'controller':("customer"),'id':(thesignatories?.deposit?.customer?.id)],4)
printHtmlPart(45)
createTagBody(4, {->
expressionOut.print(thesignatories?.deposit?.acctNo)
})
invokeTag('link','g',228,['action':("depositInquiry"),'controller':("deposit"),'id':(thesignatories?.deposit?.id)],4)
printHtmlPart(45)
expressionOut.print(thesignatories?.deposit?.status?.description)
printHtmlPart(46)
p++
}
}
printHtmlPart(47)
loop:{
int i = 0
for( loan in (customerInstance?.loans) ) {
printHtmlPart(44)
expressionOut.print(loan?.product?.name)
printHtmlPart(45)
createTagBody(4, {->
expressionOut.print(loan.accountNo)
})
invokeTag('link','g',247,['action':("show"),'controller':("loan"),'id':(loan?.id)],4)
printHtmlPart(45)
expressionOut.print(loan?.status?.description)
printHtmlPart(46)
i++
}
}
printHtmlPart(48)
invokeTag('render','g',274,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',275,['action':("create"),'controller':("deposit"),'params':([customerFromCIFPage:customerInstance.id])],3)
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',276,['action':("create"),'controller':("loanApplication"),'params':([cid:customerInstance.id])],3)
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',282,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(54)
invokeTag('render','g',287,['template':("inquiry/action/action")],-1)
printHtmlPart(55)
})
invokeTag('captureContent','sitemesh',287,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',289,[:],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128254L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
