import icbs.loans.LoanApplication
import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationshowCam_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/showCam.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(8)
})
invokeTag('javascript','g',73,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',74,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(loanApplicationInstance?.customer?.displayName)
})
invokeTag('link','g',111,['controller':("customer"),'action':("customerInquiry"),'id':(loanApplicationInstance?.customer?.id)],3)
printHtmlPart(14)
invokeTag('fieldValue','g',122,['bean':(loanApplicationSpecAdd),'field':("company")],-1)
printHtmlPart(15)
expressionOut.print(spouse?.firstName)
printHtmlPart(16)
expressionOut.print(spouse?.middleName)
printHtmlPart(16)
expressionOut.print(spouse?.lastName)
printHtmlPart(17)
if(true && (comakers)) {
printHtmlPart(18)
if(true && (addresses)) {
printHtmlPart(19)
for( comaker in (comakers) ) {
printHtmlPart(20)
for( address in (addresses) ) {
printHtmlPart(21)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(22)
expressionOut.print(address.address1)
printHtmlPart(16)
expressionOut.print(address.address2)
printHtmlPart(16)
expressionOut.print(address.address3)
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('fieldValue','g',174,['bean':(loanApplicationSpecAdd),'field':("loanSecurity")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',178,['bean':(loanApplicationSpecAdd),'field':("loanClassification")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',182,['bean':(loanApplicationSpecAdd),'field':("loanProduct")],-1)
printHtmlPart(32)
expressionOut.print(loanApplicationInstance?.purpose)
printHtmlPart(33)
invokeTag('fieldValue','g',193,['bean':(loanApplicationSpecAdd),'field':("economicActivity")],-1)
printHtmlPart(34)
if(true && (loanApplicationInstance?.amount)) {
printHtmlPart(35)
invokeTag('formatNumber','g',199,['number':(loanApplicationInstance?.amount),'format':("###,##0.00")],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (loanApplicationInstance?.term)) {
printHtmlPart(39)
expressionOut.print(loanApplicationInstance?.term / 30)
printHtmlPart(40)
expressionOut.print(loanApplicationInstance?.term / 360)
printHtmlPart(41)
}
else {
printHtmlPart(37)
}
printHtmlPart(42)
if(true && (loanApplicationSpecAdd?.interestRate)) {
printHtmlPart(39)
invokeTag('fieldValue','g',218,['bean':(loanApplicationSpecAdd),'field':("interestRate")],-1)
printHtmlPart(43)
}
else {
printHtmlPart(37)
}
printHtmlPart(44)
invokeTag('fieldValue','g',226,['bean':(loanApplicationSpecAdd),'field':("repaymentType")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',230,['bean':(loanApplicationSpecAdd),'field':("mannerOfPayment")],-1)
printHtmlPart(46)
if(true && (loanApplicationInstance?.collaterals)) {
printHtmlPart(25)
for( collateral in (loanApplicationInstance?.collaterals.sort{it.id}) ) {
printHtmlPart(47)
expressionOut.print(collateral?.description)
printHtmlPart(48)
}
printHtmlPart(27)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (loanApplicationSpecAdd?.amortizationPenaltyRate)) {
printHtmlPart(39)
invokeTag('fieldValue','g',252,['bean':(loanApplicationSpecAdd),'field':("amortizationPenaltyRate")],-1)
printHtmlPart(43)
}
else {
printHtmlPart(37)
}
printHtmlPart(51)
if(true && (loanApplicationSpecAdd?.preTerminationChargeRate)) {
printHtmlPart(39)
invokeTag('fieldValue','g',265,['bean':(loanApplicationSpecAdd),'field':("preTerminationChargeRate")],-1)
printHtmlPart(43)
}
else {
printHtmlPart(37)
}
printHtmlPart(52)
if(true && (loanApplicationSpecAdd?.pastdueInterestRate)) {
printHtmlPart(39)
invokeTag('fieldValue','g',277,['bean':(loanApplicationSpecAdd),'field':("pastdueInterestRate")],-1)
printHtmlPart(43)
}
else {
printHtmlPart(37)
}
printHtmlPart(53)
if(true && (loanApplicationSpecAdd?.pastduePenaltyRate)) {
printHtmlPart(39)
invokeTag('fieldValue','g',289,['bean':(loanApplicationSpecAdd),'field':("pastduePenaltyRate")],-1)
printHtmlPart(43)
}
else {
printHtmlPart(37)
}
printHtmlPart(54)
invokeTag('fieldValue','g',300,['bean':(loanApplicationSpecAdd),'field':("condition1")],-1)
printHtmlPart(55)
invokeTag('fieldValue','g',306,['bean':(loanApplicationSpecAdd),'field':("condition2")],-1)
printHtmlPart(56)
invokeTag('fieldValue','g',312,['bean':(loanApplicationSpecAdd),'field':("condition3")],-1)
printHtmlPart(57)
invokeTag('fieldValue','g',318,['bean':(loanApplicationSpecAdd),'field':("condition4")],-1)
printHtmlPart(58)
invokeTag('fieldValue','g',324,['bean':(loanApplicationSpecAdd),'field':("condition5")],-1)
printHtmlPart(59)
invokeTag('fieldValue','g',328,['bean':(loanApplicationSpecAdd),'field':("condition6")],-1)
printHtmlPart(60)
invokeTag('fieldValue','g',334,['bean':(loanApplicationSpecAdd),'field':("condition7")],-1)
printHtmlPart(61)
invokeTag('fieldValue','g',339,['bean':(loanApplicationSpecAdd),'field':("loanApplicationType")],-1)
printHtmlPart(62)
invokeTag('fieldValue','g',343,['bean':(loanApplicationSpecAdd),'field':("loanStatus")],-1)
printHtmlPart(63)
if(true && (loanApplicationInstance?.amount)) {
printHtmlPart(64)
invokeTag('formatNumber','g',348,['number':(loanApplicationInstance?.amount),'format':("###,##0.00")],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(65)
if(true && (loanApplicationSpecAdd?.totalToDate)) {
printHtmlPart(64)
invokeTag('formatNumber','g',357,['number':(loanApplicationSpecAdd?.totalToDate),'format':("###,##0.00")],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(66)
if(true && (loanApplicationInstance?.amount)) {
printHtmlPart(67)
invokeTag('formatNumber','g',366,['number':(loanApplicationInstance?.amount),'format':("###,##0.00")],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(68)
invokeTag('fieldValue','g',375,['bean':(loanApplicationSpecAdd),'field':("recommendedRemarks1")],-1)
printHtmlPart(69)
invokeTag('fieldValue','g',381,['bean':(loanApplicationSpecAdd),'field':("recommendedRemarks2")],-1)
printHtmlPart(70)
expressionOut.print(loanApplicationInstance?.accountOfficer?.description)
printHtmlPart(71)
invokeTag('formatDate','g',392,['format':("MM/dd/yyyy"),'date':(loanApplicationSpecAdd?.recommendedDate)],-1)
printHtmlPart(72)
invokeTag('fieldValue','g',397,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeRemarks")],-1)
printHtmlPart(73)
invokeTag('fieldValue','g',403,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory1")],-1)
printHtmlPart(74)
invokeTag('fieldValue','g',409,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory2")],-1)
printHtmlPart(75)
invokeTag('fieldValue','g',415,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory3")],-1)
printHtmlPart(76)
invokeTag('fieldValue','g',421,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeMember1")],-1)
printHtmlPart(77)
invokeTag('fieldValue','g',427,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeMember2")],-1)
printHtmlPart(78)
invokeTag('fieldValue','g',433,['bean':(loanApplicationSpecAdd),'field':("creditCommitteePresident")],-1)
printHtmlPart(79)
invokeTag('formatDate','g',439,['format':("MM/dd/yyyy"),'date':(loanApplicationSpecAdd?.creditCommitteeDate)],-1)
printHtmlPart(80)
})
invokeTag('captureContent','sitemesh',451,['tag':("main-content")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(81)
createClosureForHtmlPart(82, 3)
invokeTag('link','g',454,['class':("btn btn-secondary"),'action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(83)
createClosureForHtmlPart(84, 3)
invokeTag('link','g',455,['class':("list"),'action':("index")],3)
printHtmlPart(85)
createClosureForHtmlPart(86, 3)
invokeTag('link','g',456,['action':("edit"),'resource':(loanApplicationInstance)],3)
printHtmlPart(87)
createClosureForHtmlPart(88, 3)
invokeTag('link','g',459,['controller':("creditInvestigation"),'action':("create"),'params':([id:loanApplicationInstance?.id])],3)
printHtmlPart(89)
if(true && (isLoanApplicationExist == 'true')) {
printHtmlPart(90)
}
else {
printHtmlPart(91)
createClosureForHtmlPart(92, 4)
invokeTag('link','g',469,['controller':("loan"),'action':("create"),'disable':("disabled"),'params':([id:loanApplicationInstance?.id])],4)
printHtmlPart(89)
}
printHtmlPart(93)
createClosureForHtmlPart(94, 3)
invokeTag('link','g',471,['action':("showCam"),'resource':(loanApplicationInstance)],3)
printHtmlPart(95)
createTagBody(3, {->
printHtmlPart(96)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(16).baseParams)
printHtmlPart(97)
expressionOut.print(icbs.admin.Report.get(16).outputParam)
printHtmlPart(98)
expressionOut.print(icbs.admin.Report.get(16).reportUnit)
printHtmlPart(99)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(100)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(101)
})
invokeTag('javascript','g',483,[:],3)
printHtmlPart(102)
})
invokeTag('captureContent','sitemesh',484,['tag':("main-actions")],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',485,[:],1)
printHtmlPart(103)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129197L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
