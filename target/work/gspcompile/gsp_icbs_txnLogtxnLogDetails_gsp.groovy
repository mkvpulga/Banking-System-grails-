import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnLogtxnLogDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnLog/txnLogDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(txnFileInstance?.id)
printHtmlPart(6)
expressionOut.print(txnFileInstance?.txnTemplate?.description)
printHtmlPart(7)
expressionOut.print(txnFileInstance?.branch?.name)
printHtmlPart(8)
expressionOut.print(txnFileInstance?.acctNo)
printHtmlPart(9)
if(true && (depAcct)) {
printHtmlPart(10)
expressionOut.print(txnFileInstance?.depAcct?.customer?.displayName)
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (loanAcct)) {
printHtmlPart(10)
expressionOut.print(txnFileInstance?.loanAcct?.customer?.displayName)
printHtmlPart(9)
}
printHtmlPart(12)
invokeTag('formatNumber','g',50,['number':(txnFileInstance?.txnAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(13)
invokeTag('formatDate','g',54,['date':(txnFileInstance.txnDate),'format':("MM-dd-yyyy")],-1)
printHtmlPart(14)
expressionOut.print(txnFileInstance?.txnRef)
printHtmlPart(15)
expressionOut.print(txnFileInstance?.txnDescription)
printHtmlPart(16)
expressionOut.print(txnFileInstance?.txnParticulars)
printHtmlPart(17)
expressionOut.print(txnFileInstance?.txnTimestamp)
printHtmlPart(18)
expressionOut.print(txnFileInstance?.user?.username)
printHtmlPart(19)
loop:{
int i = 0
for( gl in (glEntries) ) {
printHtmlPart(20)
if(true && (gl?.debitAcct)) {
printHtmlPart(21)
expressionOut.print(gl?.debitAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('formatNumber','g',100,['number':(gl.debitAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(24)
if(true && (gl?.creditAcct)) {
printHtmlPart(21)
expressionOut.print(gl?.creditAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(22)
}
printHtmlPart(25)
invokeTag('formatNumber','g',106,['number':(gl.creditAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',116,['action':("Index")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',117,['action':("viewTellerBalancing"),'id':(txnFileInstance.id)],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',119,['tag':("main-actions")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',120,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129577L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
