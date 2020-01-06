import icbs.gl.AccountsReceivable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(9)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(10)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(11)
expressionOut.print(accountsReceivableInstance.reference)
printHtmlPart(12)
expressionOut.print(accountsReceivableInstance?.currency?.code)
printHtmlPart(13)
expressionOut.print(accountsReceivableInstance.glContra)
printHtmlPart(14)
invokeTag('formatDate','g',48,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.bookingDate)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',56,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.requiredValuationReserves)],-1)
printHtmlPart(17)
expressionOut.print(accountsReceivableInstance?.user?.name)
printHtmlPart(18)
expressionOut.print(accountsReceivableInstance.status)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',73,['action':("edit"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',74,['action':("viewTransactions"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',75,['action':("arDebit"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',76,['action':("arCredit"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',77,['action':("index"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127883L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
