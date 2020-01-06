import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsEODCheck_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/EODCheck.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('sortableColumn','g',33,['property':("username"),'title':(message(code: 'userMaster.username.label', default: 'User Name'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',34,['property':("branch"),'title':(message(code: 'userMaster.branch.label', default: 'Branch Name'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',35,['property':("login"),'title':(message(code: 'userSession.login.label', default: 'Login'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( loggedUserInstance in (loggedUserList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(loggedUserInstance.userMaster.username)
printHtmlPart(14)
expressionOut.print(loggedUserInstance.userMaster.branch.name)
printHtmlPart(14)
expressionOut.print(loggedUserInstance.login)
printHtmlPart(15)
expressionOut.print(loggedUserInstance.userMasterId)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('sortableColumn','g',58,['property':("username"),'title':(message(code: 'userMaster.username.label', default: 'Username'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',60,['property':("name1"),'title':(message(code: 'userMaster.name1.label', default: 'Full Name'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',62,['property':("branch"),'title':(message(code: 'userMaster.branch.label', default: 'Branch'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',64,['property':("designation"),'title':(message(code: 'userMaster.designation.label', default: 'Designation'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',66,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',68,['property':("isLocked"),'title':(message(code: 'userMaster.isLocked.label', default: 'Locked'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',70,['property':("isTellerBalanced"),'title':(message(code: 'userMaster.isTellerBalanced.label', default: 'Balanced'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( userMasterInstance in (userMasterInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "username"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "name1") + " " + fieldValue(bean: userMasterInstance, field: "name2") + " " + fieldValue(bean: userMasterInstance, field: "name3"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "branch.name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "designation.description"))
printHtmlPart(25)
if(true && (userMasterInstance.configItemStatus.description == 'Active')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(19)
if(true && (userMasterInstance.isLocked)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (userMasterInstance.isTellerBalanced)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
invokeTag('sortableColumn','g',114,['property':("userId"),'title':(message(code: 'txnTellerBalance.user.label', default: 'Username'))],-1)
printHtmlPart(33)
invokeTag('sortableColumn','g',115,['property':("branch"),'title':(message(code: 'txnTellerBalance.user.branch.label', default: 'Branch'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',116,['property':("cashIn"),'title':(message(code: 'txnTellerBalance.cashIn.label', default: 'Cash In'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',117,['property':("cashOut"),'title':(message(code: 'txnTellerBalance.cashOut.label', default: 'Cash Out'))],-1)
printHtmlPart(34)
loop:{
int i = 0
for( txnCashInstance in (txnCashList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(txnCashInstance?.user?.username)
printHtmlPart(14)
expressionOut.print(txnCashInstance?.user?.branch?.name)
printHtmlPart(14)
invokeTag('formatNumber','g',125,['format':("###,###,##0.00"),'number':(txnCashInstance?.cashIn)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',126,['format':("###,###,##0.00"),'number':(txnCashInstance?.cashOut)],-1)
printHtmlPart(35)
i++
}
}
printHtmlPart(36)
invokeTag('sortableColumn','g',136,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Loan Account'))],-1)
printHtmlPart(33)
invokeTag('sortableColumn','g',137,['property':("branch"),'title':(message(code: 'loan.branch.label', default: 'Branch'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',138,['property':("totalDisbursementAmount"),'title':(message(code: 'loan.totalDisbursementAmount.label', default: 'Amount Disbursed'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',139,['property':("totalNetProceeds"),'title':(message(code: 'loan.totalNetProceeds.label', default: 'Net Proceeds'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',140,['property':("dateApproved"),'title':(message(code: 'loan.totalNetProceeds.label', default: 'Date Approved'))],-1)
printHtmlPart(34)
loop:{
int i = 0
for( loanInstance in (loanInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(loanInstance.accountNo)
printHtmlPart(14)
expressionOut.print(fieldValue(bean: loanInstance, field: "branch.name"))
printHtmlPart(14)
invokeTag('formatNumber','g',148,['format':("###,###,##0.00"),'number':(loanInstance?.totalDisbursementAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',149,['format':("###,###,##0.00"),'number':(loanInstance?.totalNetProceeds)],-1)
printHtmlPart(14)
invokeTag('formatDate','g',150,['format':("yyyy-MM-dd"),'date':(loanInstance?.dateApproved)],-1)
printHtmlPart(35)
i++
}
}
printHtmlPart(37)
invokeTag('sortableColumn','g',159,['property':("branch"),'title':("Branch")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',160,['property':("id"),'title':("Batch#")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',161,['property':("batchName"),'title':("Batch Name")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',162,['property':("createdBy"),'title':("User")],-1)
printHtmlPart(38)
loop:{
int i = 0
for( upGl in (unpostedGlList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(upGl?.branch?.name)
printHtmlPart(14)
expressionOut.print(upGl?.id)
printHtmlPart(14)
expressionOut.print(upGl?.batchName)
printHtmlPart(14)
expressionOut.print(upGl?.createdBy?.username)
printHtmlPart(35)
i++
}
}
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
expressionOut.print(createLink(controller:'UserMaster', action: 'adminForceLogoutPerUser'))
printHtmlPart(41)
})
invokeTag('javascript','g',236,[:],3)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',237,['tag':("main-content")],2)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(44)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',241,['class':("index"),'action':("index")],3)
printHtmlPart(46)
if(true && (loggedUserList)) {
printHtmlPart(47)
}
else {
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(createLink(controller:'UserMaster', action: 'adminForceLogoutAllUser'))
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',284,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',285,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129281L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
