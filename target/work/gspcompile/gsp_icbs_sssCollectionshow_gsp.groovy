import icbs.tellering.SssOnlinePaymentDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectionshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'sssOnlinePaymentDetail.label', default: 'sssOnlinePaymentDetail'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(g.createLink(controller: 'sssCollection', action: 'sssPrintTransactionSlip', params: [txnFile:sssOnlinePaymentDetailInstance.txnFile.id]))
printHtmlPart(7)
expressionOut.print(g.createLink(controller: 'sssCollection', action: 'sssIndividualPrintTransactionSlip', params: [txnFile:sssOnlinePaymentDetailInstance.txnFile.id]))
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (sssOnlinePaymentDetailInstance.brnum)) {
printHtmlPart(12)
expressionOut.print(sssOnlinePaymentDetailInstance.brnum)
printHtmlPart(13)
invokeTag('formatDate','g',42,['format':("MM/dd/yyyy hh:mm:ss.ss"),'date':(sssOnlinePaymentDetailInstance.replyDate)],-1)
printHtmlPart(14)
expressionOut.print(sssOnlinePaymentDetailInstance.ernum)
printHtmlPart(15)
expressionOut.print(sssOnlinePaymentDetailInstance.ername)
printHtmlPart(16)
expressionOut.print(sssOnlinePaymentDetailInstance.erbrn)
printHtmlPart(17)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(sssOnlinePaymentDetailInstance?.amount)],-1)
printHtmlPart(18)
expressionOut.print(sssOnlinePaymentDetailInstance.appmo)
printHtmlPart(19)
}
else {
printHtmlPart(12)
expressionOut.print(sssOnlinePaymentDetailInstance.indiIprnum)
printHtmlPart(20)
invokeTag('formatDate','g',71,['format':("MM/dd/yyyy hh:mm:ss.ss"),'date':(sssOnlinePaymentDetailInstance.replyDate)],-1)
printHtmlPart(21)
expressionOut.print(sssOnlinePaymentDetailInstance.indiEenum)
printHtmlPart(22)
expressionOut.print(sssOnlinePaymentDetailInstance.indiEename)
printHtmlPart(23)
expressionOut.print(sssOnlinePaymentDetailInstance.indiPayorType)
printHtmlPart(24)
invokeTag('formatNumber','g',87,['format':("###,###,##0.00"),'number':(sssOnlinePaymentDetailInstance?.amount)],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(sssOnlinePaymentDetailInstance?.flexiAmt)],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(sssOnlinePaymentDetailInstance?.monthlyContribution)],-1)
printHtmlPart(27)
expressionOut.print(sssOnlinePaymentDetailInstance.fapid)
printHtmlPart(28)
expressionOut.print(sssOnlinePaymentDetailInstance.tapid)
printHtmlPart(19)
}
printHtmlPart(29)
expressionOut.print(sssOnlinePaymentDetailInstance.indiTxnNumber)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(sssOnlinePaymentDetailInstance.txnFile.id)
})
invokeTag('link','g',112,['controller':("tellering"),'action':("showGlEntries"),'id':(sssOnlinePaymentDetailInstance.txnFile.id)],3)
printHtmlPart(31)
invokeTag('formatDate','g',116,['format':("MM/dd/yyyy"),'date':(sssOnlinePaymentDetailInstance?.txnFile?.txnDate)],-1)
printHtmlPart(32)
expressionOut.print(sssOnlinePaymentDetailInstance?.txnFile?.user?.username)
printHtmlPart(33)
if(true && (sssOnlinePaymentDetailInstance.brnum)) {
printHtmlPart(34)
invokeTag('img','g',129,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(35)
}
else {
printHtmlPart(36)
invokeTag('img','g',140,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(37)
}
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',150,['action':("index")],3)
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',151,['action':("sssOnlineCreate")],3)
printHtmlPart(41)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',152,['action':("sssCreateIndividualPayment")],3)
printHtmlPart(41)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',153,['action':("sssCreateIndividualPaymentNoPrn")],3)
printHtmlPart(41)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',154,['action':("createPrn")],3)
printHtmlPart(41)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',155,['action':("create")],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',157,['tag':("main-actions")],2)
printHtmlPart(48)
})
invokeTag('captureBody','sitemesh',158,[:],1)
printHtmlPart(49)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129390L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
