import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingviewTellerOtherTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/viewTellerOtherTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(5)
invokeTag('select','g',17,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(6)
expressionOut.print(params?.query)
printHtmlPart(7)
invokeTag('submitButton','g',23,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(8)
})
invokeTag('form','g',27,['url':([action:'viewTellerOtherTxn',controller:'Tellering'])],3)
printHtmlPart(9)
loop:{
int i = 0
for( txn in (otherTxn) ) {
printHtmlPart(10)
expressionOut.print(txn.id)
printHtmlPart(11)
expressionOut.print(txn.txnTemplate.description)
printHtmlPart(11)
invokeTag('formatNumber','g',44,['number':(txn.txnAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(11)
expressionOut.print(txn?.txnRef)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('link','g',46,['class':("btn btn-primary"),'action':("showGlEntries"),'id':(txn.id)],4)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',52,['total':(otherTxnInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',56,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',59,['action':("Index")],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',60,['action':("viewTellerBalancing")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129424L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
