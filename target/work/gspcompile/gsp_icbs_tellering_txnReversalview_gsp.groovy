import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnReversalview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnReversal/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'tellering', action:'showTxnAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'tellering', action:'search'))
printHtmlPart(6)
})
invokeTag('javascript','g',68,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',69,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('textField','g',92,['readonly':("true"),'name':("txnID"),'value':(""),'class':("form-control")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnCashDepositInstance, field: 'txnRef', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',203,['code':("txnCashDeposit.txnRef.label"),'default':("Particulars")],-1)
printHtmlPart(15)
invokeTag('textArea','g',206,['class':("form-control"),'id':("txnParticulars"),'name':("txnParticulars"),'value':(""),'rows':("5"),'cols':("40")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnCashDepositInstance, field: 'txnRef', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',211,['code':("txnCashDeposit.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(15)
invokeTag('textField','g',214,['id':("txnReference"),'name':("txnReference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(17)
})
invokeTag('form','g',218,['action':("reverseTxn"),'controller':("tellering"),'name':("reverseForm")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',233,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',238,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',240,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',241,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129559L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
