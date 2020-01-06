import icbs.gl.BillsPayable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayableshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/show.gsp" }
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
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(billsPayableInstance?.currency?.name)
printHtmlPart(11)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(12)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(13)
invokeTag('formatDate','g',41,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dateOpened)],-1)
printHtmlPart(14)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dueDate)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.pnDate)],-1)
printHtmlPart(16)
expressionOut.print(billsPayableInstance?.pnNo)
printHtmlPart(17)
expressionOut.print(billsPayableInstance?.pdcIssuedText)
printHtmlPart(18)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(19)
expressionOut.print(billsPayableInstance?.payee)
printHtmlPart(20)
invokeTag('formatNumber','g',69,['format':("###,###,##0.00"),'number':(billsPayableInstance?.interestRate)],-1)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',77,['action':("edit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',78,['action':("viewTransactions"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',79,['action':("bpDebit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',80,['action':("bpCredit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',81,['action':("index"),'controller':("billsPayable")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',84,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127921L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
