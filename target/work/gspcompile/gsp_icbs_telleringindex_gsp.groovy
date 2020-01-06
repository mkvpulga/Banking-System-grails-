import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',35,['action':("createTellerCashFromVaultTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',36,['action':("createTellerCashTransferTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',37,['action':("createTellerCheckToCOCITxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',38,['action':("createTellerCashToVaultTxn")],3)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',46,['action':("viewTxnSummary")],3)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',47,['action':("viewTellerTxnInquiry")],3)
printHtmlPart(10)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',48,['action':("viewTellerReverseCancelTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',49,['action':("createTellerReprintPassbook")],3)
printHtmlPart(10)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',50,['action':("createUpdatePassbook")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',58,['action':("createTellerCashDepositTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',59,['action':("createTellerCheckDepositTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',60,['action':("createTellerCashWithdrawalTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',61,['action':("createTellerCheckEncashmentTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',62,['action':("createTellerFDInterestWithdrawalTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',63,['action':("createTellerFDPreTerminationTxn")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',67,['action':("createTellerOtherCashReceiptAdjustmentTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',68,['action':("createTellerOtherCheckReceiptAdjustmentTxn")],3)
printHtmlPart(10)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',69,['action':("createTellerOtherCashPaymentAdjustmentTxn")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129413L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
