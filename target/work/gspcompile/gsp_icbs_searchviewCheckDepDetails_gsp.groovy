import icbs.tellering.TxnCOCI
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_searchviewCheckDepDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/viewCheckDepDetails.gsp" }
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
loop:{
int i = 0
for( txnCOCIInstance in (txnCOCIInstanceList) ) {
printHtmlPart(7)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(8)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "id"))
printHtmlPart(9)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "acctNo"))
printHtmlPart(10)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "bank.name"))
printHtmlPart(10)
invokeTag('formatNumber','g',35,['number':(txnCOCIInstance?.checkAmt),'format':("###,##0.00")],-1)
printHtmlPart(10)
expressionOut.print(txnCOCIInstance?.checkDate?.format('MM/dd/yyyy'))
printHtmlPart(10)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "checkNo"))
printHtmlPart(10)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "checkType.description"))
printHtmlPart(10)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "cleared"))
printHtmlPart(10)
expressionOut.print(txnCOCIInstance?.clearingDate?.format('MM/dd/yyyy'))
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
})
invokeTag('captureContent','sitemesh',47,['tag':("main-content")],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('captureContent','sitemesh',51,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129380L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
