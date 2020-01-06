import icbs.loans.CreditInvestigation
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringshowProduct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/showProduct.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(creditScoringProductConfigInstance?.currency?.name)
printHtmlPart(11)
expressionOut.print(creditScoringProductConfigInstance?.glContra)
printHtmlPart(12)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(13)
invokeTag('formatDate','g',40,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dateOpened)],-1)
printHtmlPart(14)
invokeTag('formatDate','g',44,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dueDate)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',48,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.pnDate)],-1)
printHtmlPart(16)
expressionOut.print(billsPayableInstance?.pnNo)
printHtmlPart(17)
expressionOut.print(billsPayableInstance?.pdcIssuedText)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',61,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',66,['controller':("creditScoring"),'action':("index")],3)
printHtmlPart(22)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',67,['controller':("creditScoring"),'action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128182L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
