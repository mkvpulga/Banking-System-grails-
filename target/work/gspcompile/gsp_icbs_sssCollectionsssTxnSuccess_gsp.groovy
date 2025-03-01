import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectionsssTxnSuccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/sssTxnSuccess.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(txnFileInstance.id)
printHtmlPart(8)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(txnFileInstance?.txnDate)],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',34,['bean':(txnFileInstance),'field':("txnType.description")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',38,['bean':(txnFileInstance),'field':("acctNo")],-1)
printHtmlPart(11)
if(true && (txnFileInstance.depAcct)) {
printHtmlPart(12)
expressionOut.print(txnFileInstance.depAcct.customer.displayName)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnFileInstance.loanAcct)) {
printHtmlPart(15)
expressionOut.print(txnFileInstance.loanAcct.customer.displayName)
printHtmlPart(13)
}
printHtmlPart(16)
invokeTag('fieldValue','g',54,['bean':(txnFileInstance),'field':("branch.name")],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',58,['format':("###,###,##0.00"),'number':(txnFileInstance?.txnAmt)],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',63,['bean':(txnFileInstance),'field':("txnCode")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',67,['bean':(txnFileInstance),'field':("txnTemplate.description")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',71,['bean':(txnFileInstance),'field':("txnDescription")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',75,['bean':(txnFileInstance),'field':("txnRef")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',79,['bean':(txnFileInstance),'field':("txnParticulars")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',83,['bean':(txnFileInstance),'field':("status.description")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',87,['bean':(txnFileInstance),'field':("user.username")],-1)
printHtmlPart(25)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printValidationSlip', params: [txnFile:txnFileInstance.id]))
printHtmlPart(26)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(20).baseParams)
printHtmlPart(27)
expressionOut.print(icbs.admin.Report.get(20).outputParam)
printHtmlPart(28)
expressionOut.print(icbs.admin.Report.get(20).reportUnit)
printHtmlPart(29)
expressionOut.print(txnFileInstance.id)
printHtmlPart(30)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(31)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(62).baseParams)
printHtmlPart(27)
expressionOut.print(icbs.admin.Report.get(62).outputParam)
printHtmlPart(28)
expressionOut.print(icbs.admin.Report.get(62).reportUnit)
printHtmlPart(32)
expressionOut.print(txnFileInstance.id)
printHtmlPart(30)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(33)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printTransactionSlip', params: [txnFile:txnFileInstance.id]))
printHtmlPart(34)
if(true && (print=='PrintValidation-PrintTransactionSlip-PrintPassbook')) {
printHtmlPart(35)
invokeTag('img','g',129,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(36)
invokeTag('img','g',134,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(37)
invokeTag('img','g',144,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(38)
createClosureForHtmlPart(39, 4)
invokeTag('link','g',147,['action':("printPassbookTransactions"),'params':([txnId: txnFileInstance.id])],4)
printHtmlPart(40)
expressionOut.print(passbookline)
printHtmlPart(41)
expressionOut.print(id)
printHtmlPart(42)
expressionOut.print(jrxmlTcId)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (print=='PrintValidation-PrintTransactionSlip')) {
printHtmlPart(35)
invokeTag('img','g',162,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(45)
invokeTag('img','g',167,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(46)
expressionOut.print(passbookline)
printHtmlPart(41)
expressionOut.print(id)
printHtmlPart(42)
expressionOut.print(jrxmlTcId)
printHtmlPart(43)
}
printHtmlPart(47)
if(true && (print=='PrintValidation')) {
printHtmlPart(35)
invokeTag('img','g',181,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(48)
if(true && (txnFileInstance?.txnTypeId==1 || txnFileInstance?.txnTypeId==2 || txnFileInstance?.txnTypeId==23)) {
printHtmlPart(49)
invokeTag('img','g',188,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(passbookline)
printHtmlPart(41)
expressionOut.print(id)
printHtmlPart(42)
expressionOut.print(jrxmlTcId)
printHtmlPart(52)
}
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',198,['tag':("main-content")],2)
printHtmlPart(54)
createTagBody(2, {->
printHtmlPart(55)
createClosureForHtmlPart(56, 3)
invokeTag('link','g',200,['action':("index")],3)
printHtmlPart(57)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',201,['action':("sssOnlineCreate")],3)
printHtmlPart(57)
createClosureForHtmlPart(59, 3)
invokeTag('link','g',202,['action':("sssCreateIndividualPayment")],3)
printHtmlPart(57)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',205,['action':("sssCreateIndividualPaymentNoPrn")],3)
printHtmlPart(57)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',209,['action':("createPrn")],3)
printHtmlPart(57)
createClosureForHtmlPart(62, 3)
invokeTag('link','g',211,['action':("create")],3)
printHtmlPart(63)
})
invokeTag('captureContent','sitemesh',212,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',212,[:],1)
printHtmlPart(64)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129395L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
