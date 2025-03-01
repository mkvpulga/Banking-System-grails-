import icbs.gl.CashInBank
import icbs.gl.CashInBankCheckbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankchkDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/chkDetails.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(cashInBankCheckbookInstance?.checkNo)
printHtmlPart(7)
expressionOut.print(cashInBankCheckbookInstance?.checkVoucherNo)
printHtmlPart(8)
expressionOut.print(cashInBankCheckbookInstance?.reference)
printHtmlPart(9)
invokeTag('formatDate','g',32,['format':("MM/dd/yyyy"),'date':(cashInBankCheckbookInstance?.checkDate)],-1)
printHtmlPart(10)
expressionOut.print(cashInBankCheckbookInstance?.payee)
printHtmlPart(11)
expressionOut.print(cashInBankCheckbookInstance?.particulars)
printHtmlPart(12)
invokeTag('formatDate','g',44,['format':("MM/dd/yyyy"),'date':(cashInBankCheckbookInstance?.releaseDate)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',48,['format':("###,###,##0.00"),'number':(cashInBankCheckbookInstance?.checkAmt)],-1)
printHtmlPart(14)
expressionOut.print(cashInBankCheckbookInstance?.issuedBy?.name)
printHtmlPart(15)
expressionOut.print(cashInBankCheckbookInstance?.approvedBy?.name)
printHtmlPart(16)
expressionOut.print(cashInBankCheckbookInstance?.createdBy?.name)
printHtmlPart(17)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(cashInBankCheckbookInstance?.approveDate)],-1)
printHtmlPart(18)
expressionOut.print(cashInBankCheckbookInstance?.checkStatus?.description)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',78,['action':("show"),'controller':("cashInBank"),'id':(cashInBankCheckbookInstance.cashInBank.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',79,['action':("index"),'controller':("cashInBank")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127938L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
