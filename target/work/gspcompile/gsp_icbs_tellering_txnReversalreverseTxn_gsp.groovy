import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnReversalreverseTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnReversal/reverseTxn.gsp" }
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
createTagBody(2, {->
printHtmlPart(6)
invokeTag('fieldValue','g',23,['bean':(txnFileInstance),'field':("id")],-1)
printHtmlPart(7)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(txnFileInstance?.txnDate)],-1)
printHtmlPart(8)
invokeTag('fieldValue','g',31,['bean':(txnFileInstance),'field':("txnType.description")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',35,['bean':(txnFileInstance),'field':("acctNo")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',39,['bean':(txnFileInstance),'field':("branch.name")],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',43,['format':("###,###,##0.00"),'number':(txnFileInstance?.txnAmt)],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',48,['bean':(txnFileInstance),'field':("txnCode")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',52,['bean':(txnFileInstance),'field':("txnTemplate.description")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',56,['bean':(txnFileInstance),'field':("txnDescription")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',60,['bean':(txnFileInstance),'field':("txnRef")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',64,['bean':(txnFileInstance),'field':("txnParticulars")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',68,['bean':(txnFileInstance),'field':("status.description")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',72,['bean':(txnFileInstance),'field':("user.username")],-1)
printHtmlPart(19)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printValidationSlip', params: [txnFile:txnFileInstance.id]))
printHtmlPart(20)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(20).baseParams)
printHtmlPart(21)
expressionOut.print(icbs.admin.Report.get(20).outputParam)
printHtmlPart(22)
expressionOut.print(icbs.admin.Report.get(20).reportUnit)
printHtmlPart(23)
expressionOut.print(txnFileInstance.id)
printHtmlPart(24)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(25)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(62).baseParams)
printHtmlPart(21)
expressionOut.print(icbs.admin.Report.get(62).outputParam)
printHtmlPart(22)
expressionOut.print(icbs.admin.Report.get(62).reportUnit)
printHtmlPart(26)
expressionOut.print(txnFileInstance.id)
printHtmlPart(24)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(27)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printTransactionSlip', params: [txnFile:txnFileInstance.id]))
printHtmlPart(28)
if(true && (print=='PrintValidation-PrintTransactionSlip-PrintPassbook')) {
printHtmlPart(29)
invokeTag('img','g',114,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(30)
invokeTag('img','g',119,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(31)
invokeTag('img','g',129,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(32)
createClosureForHtmlPart(33, 4)
invokeTag('link','g',132,['action':("printPassbookTransactions"),'params':([txnId: txnFileInstance.id])],4)
printHtmlPart(34)
expressionOut.print(passbookline)
printHtmlPart(35)
expressionOut.print(id)
printHtmlPart(36)
expressionOut.print(jrxmlTcId)
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (print=='PrintValidation-PrintTransactionSlip')) {
printHtmlPart(29)
invokeTag('img','g',147,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(39)
invokeTag('img','g',152,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(40)
expressionOut.print(passbookline)
printHtmlPart(35)
expressionOut.print(id)
printHtmlPart(36)
expressionOut.print(jrxmlTcId)
printHtmlPart(37)
}
printHtmlPart(41)
if(true && (print=='PrintValidation')) {
printHtmlPart(29)
invokeTag('img','g',166,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(42)
if(true && (txnFileInstance?.txnTypeId==1 || txnFileInstance?.txnTypeId==2 || txnFileInstance?.txnTypeId==23)) {
printHtmlPart(43)
invokeTag('img','g',173,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(passbookline)
printHtmlPart(35)
expressionOut.print(id)
printHtmlPart(36)
expressionOut.print(jrxmlTcId)
printHtmlPart(46)
}
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',183,['tag':("main-content")],2)
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',185,['action':("createTellerCashFromVaultTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',186,['action':("createTellerCashTransferTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(53, 3)
invokeTag('link','g',187,['action':("createTellerCheckToCOCITxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',188,['action':("createTellerCashToVaultTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',192,['action':("createTellerCashDepositTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(56, 3)
invokeTag('link','g',195,['action':("createTellerCheckDepositTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',196,['action':("createTellerCashWithdrawalTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',197,['action':("createTellerCheckEncashmentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(59, 3)
invokeTag('link','g',199,['action':("createTellerFDInterestWithdrawalTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',200,['action':("createTellerFDPreTerminationTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',201,['action':("createTellerLoanCashRepaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(62, 3)
invokeTag('link','g',202,['action':("createTellerLoanCheckRepaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(63, 3)
invokeTag('link','g',203,['action':("createTellerLoanCashSpecifiedRepaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(64, 3)
invokeTag('link','g',204,['action':("createTellerLoanCheckSpecifiedRepaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(65, 3)
invokeTag('link','g',205,['action':("createTellerLoanProceedsDisbursementTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(66, 3)
invokeTag('link','g',207,['action':("createTellerOtherCashReceiptRemittanceTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(67, 3)
invokeTag('link','g',208,['action':("createTellerOtherCashReceiptBillsPaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',209,['action':("createTellerOtherCashReceiptAdjustmentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(69, 3)
invokeTag('link','g',210,['action':("createTellerOtherCheckReceiptRemittanceTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(70, 3)
invokeTag('link','g',211,['action':("createTellerOtherCheckReceiptBillsPaymentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(71, 3)
invokeTag('link','g',212,['action':("createTellerOtherCheckReceiptAdjustmentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(72, 3)
invokeTag('link','g',213,['action':("createTellerOtherCashPaymentRemittanceTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(73, 3)
invokeTag('link','g',214,['action':("createTellerOtherCashPaymentAdjustmentTxn")],3)
printHtmlPart(51)
createClosureForHtmlPart(74, 3)
invokeTag('link','g',215,['action':("viewTellerReverseCancelTxn")],3)
printHtmlPart(75)
})
invokeTag('captureContent','sitemesh',215,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',216,[:],1)
printHtmlPart(76)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129558L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
