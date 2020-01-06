import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingshowGlEntries_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/showGlEntries.gsp" }
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
invokeTag('formatNumber','g',30,['number':(txnFileInstance?.txnAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(8)
expressionOut.print(txnFileInstance?.txnRef)
printHtmlPart(9)
loop:{
int i = 0
for( gl in (glEntries) ) {
printHtmlPart(10)
if(true && (gl?.debitAcct)) {
printHtmlPart(11)
expressionOut.print(gl?.debitAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('formatNumber','g',60,['number':(gl.debitAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(14)
if(true && (gl?.creditAcct)) {
printHtmlPart(11)
expressionOut.print(gl?.creditAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(12)
}
printHtmlPart(15)
invokeTag('formatNumber','g',66,['number':(gl.creditAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',76,['action':("Index")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',77,['action':("viewTellerBalancing")],3)
printHtmlPart(21)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',78,['action':("viewTellerOtherTxn")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129421L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
