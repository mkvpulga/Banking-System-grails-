import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inquirydepositInquiry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inquiry/depositInquiry.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',12,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('render','g',17,['template':("inquiry/depositInquiryForm")],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(14)
}
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',52,['action':("depositSearch")],3)
printHtmlPart(18)
if(true && (!params?.module)) {
printHtmlPart(19)
if(true && (depositInstance?.status?.id != 7)) {
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 6)
invokeTag('link','g',56,['action':("depositViewMoreInformation"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(25, 6)
invokeTag('link','g',62,['class':("edit"),'action':("edit"),'resource':(depositInstance)],6)
printHtmlPart(23)
}
else {
printHtmlPart(26)
}
printHtmlPart(20)
if(true && (depositInstance?.type?.id == 2)) {
printHtmlPart(21)
createClosureForHtmlPart(27, 6)
invokeTag('link','g',68,['action':("viewCheckbook"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(28)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(29)
if(true && (depositInstance?.branch?.id == UserMaster?.get(session.user_id)?.branch?.id)) {
printHtmlPart(30)
createClosureForHtmlPart(31, 7)
invokeTag('link','g',75,['action':("viewPassbook"),'id':(depositInstance.id)],7)
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(20)
}
else {
printHtmlPart(34)
}
printHtmlPart(20)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(21)
createClosureForHtmlPart(35, 6)
invokeTag('link','g',85,['action':("viewCTD"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(36)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(37, 6)
invokeTag('link','g',91,['action':("viewHold"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(38)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(39)
createClosureForHtmlPart(40, 6)
invokeTag('link','g',98,['action':("viewStandingOrder"),'id':(depositInstance.id)],6)
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(43, 6)
invokeTag('link','g',106,['action':("viewMemo"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (depositInstance?.product?.productType.id!=1 && depositInstance?.product?.productType.id!=3)) {
printHtmlPart(21)
createClosureForHtmlPart(46, 6)
invokeTag('link','g',113,['action':("viewStopPaymentOrder"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(47)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(48)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(30)
createClosureForHtmlPart(49, 7)
invokeTag('link','g',120,['action':("viewDepositStatus"),'id':(depositInstance.id)],7)
printHtmlPart(50)
}
else {
printHtmlPart(51)
createClosureForHtmlPart(52, 7)
invokeTag('link','g',123,['action':("viewDepositStatus"),'id':(depositInstance.id)],7)
printHtmlPart(50)
}
printHtmlPart(20)
}
else {
printHtmlPart(53)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(54, 6)
invokeTag('link','g',130,['action':("viewInterestRateMaintenance"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(55)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(56, 6)
invokeTag('link','g',136,['action':("viewSweep"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(57)
}
printHtmlPart(20)
if(true && (depositInstance?.status?.id == 6)) {
printHtmlPart(58)
}
else {
printHtmlPart(21)
createClosureForHtmlPart(59, 6)
invokeTag('link','g',145,['action':("viewFundTransfer"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(60, 6)
invokeTag('link','g',148,['action':("viewClearChecksManually"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(61)
}
printHtmlPart(20)
if(true && (depositInstance?.type?.id == 3)) {
printHtmlPart(21)
createClosureForHtmlPart(62, 6)
invokeTag('link','g',154,['action':("viewManualFdRollover"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(63)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(64)
}
else {
printHtmlPart(65)
}
printHtmlPart(19)
}
else {
printHtmlPart(66)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 6)
invokeTag('link','g',168,['action':("depositViewMoreInformation"),'id':(depositInstance.id)],6)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(48)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(30)
createClosureForHtmlPart(49, 7)
invokeTag('link','g',175,['action':("viewDepositStatus"),'id':(depositInstance.id)],7)
printHtmlPart(50)
}
else {
printHtmlPart(51)
createClosureForHtmlPart(52, 7)
invokeTag('link','g',178,['action':("viewDepositStatus"),'id':(depositInstance.id)],7)
printHtmlPart(50)
}
printHtmlPart(20)
}
printHtmlPart(67)
}
printHtmlPart(68)
}
else {
printHtmlPart(19)
if(true && (depositInstance&&params.module=="edit")) {
printHtmlPart(69)
createClosureForHtmlPart(25, 5)
invokeTag('link','g',186,['class':("edit"),'action':("edit"),'resource':(depositInstance)],5)
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (depositInstance&&params.module=="checkbook")) {
printHtmlPart(69)
createClosureForHtmlPart(27, 5)
invokeTag('link','g',190,['action':("viewCheckbook"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(72)
if(true && (depositInstance&&params.module=="passbook")) {
printHtmlPart(69)
createClosureForHtmlPart(31, 5)
invokeTag('link','g',194,['action':("viewPassbook"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(72)
if(true && (depositInstance&&params.module=="ctd"&&depositInstance?.type?.id==3)) {
printHtmlPart(69)
createClosureForHtmlPart(73, 5)
invokeTag('link','g',198,['action':("viewCTD"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (depositInstance&&params.module=="hold")) {
printHtmlPart(69)
createClosureForHtmlPart(37, 5)
invokeTag('link','g',202,['action':("viewHold"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (depositInstance&&params.module=="standingorder")) {
printHtmlPart(74)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',207,['action':("viewStandingOrder"),'id':(depositInstance.id)],5)
printHtmlPart(75)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="memo")) {
printHtmlPart(69)
createClosureForHtmlPart(43, 5)
invokeTag('link','g',212,['action':("viewMemo"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="spo")) {
printHtmlPart(69)
createClosureForHtmlPart(46, 5)
invokeTag('link','g',215,['action':("viewStopPaymentOrder"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (depositInstance&&params.module=="close")) {
printHtmlPart(76)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(77)
createClosureForHtmlPart(49, 6)
invokeTag('link','g',220,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(78)
}
else {
printHtmlPart(79)
createClosureForHtmlPart(52, 6)
invokeTag('link','g',223,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(78)
}
printHtmlPart(19)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="irm")) {
printHtmlPart(69)
createClosureForHtmlPart(54, 5)
invokeTag('link','g',228,['action':("viewInterestRateMaintenance"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="sweep")) {
printHtmlPart(69)
createClosureForHtmlPart(56, 5)
invokeTag('link','g',230,['action':("viewSweep"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="fundtransfer")) {
printHtmlPart(69)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',233,['action':("viewFundTransfer"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="clearchecksmanually")) {
printHtmlPart(69)
createClosureForHtmlPart(60, 5)
invokeTag('link','g',236,['action':("viewClearChecksManually"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(19)
if(true && (depositInstance&&params.module=="manualfdrollover"&&depositInstance?.type?.id==3)) {
printHtmlPart(69)
createClosureForHtmlPart(62, 5)
invokeTag('link','g',239,['action':("viewManualFdRollover"),'id':(depositInstance.id)],5)
printHtmlPart(70)
}
printHtmlPart(80)
}
printHtmlPart(81)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(82)
invokeTag('message','g',241,['code':("default.home.label")],-1)
printHtmlPart(83)
})
invokeTag('captureContent','sitemesh',243,['tag':("main-actions")],2)
printHtmlPart(84)
})
invokeTag('captureBody','sitemesh',243,[:],1)
printHtmlPart(85)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128364L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
