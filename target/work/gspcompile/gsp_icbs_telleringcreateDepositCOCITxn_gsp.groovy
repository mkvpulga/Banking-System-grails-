import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringcreateDepositCOCITxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/createDepositCOCITxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
invokeTag('img','g',75,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
expressionOut.print(it)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',99,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',100,['bean':(txnPaymentAdjustmentInstance),'var':("error")],4)
printHtmlPart(19)
})
invokeTag('hasErrors','g',104,['bean':(txnPaymentAdjustmentInstance)],3)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('hiddenField','g',107,['id':("OtherCashPaymentAdjustment"),'name':("OtherCashPaymentAdjustment"),'value':("0")],-1)
printHtmlPart(21)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByMemoTxnTypeAndTxnType(icbs.lov.MemoTxnType.read(1), icbs.lov.TxnType.read(67),[sort:"code", order:"asc"])) ) {
printHtmlPart(22)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(23)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(24)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(27)
invokeTag('textField','g',123,['type':("number"),'id':("txnAmt"),'name':("txnAmt"),'required':(""),'value':(txnPaymentAdjustmentInstance?.txnAmt),'class':("form-control truncated")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(29)
invokeTag('textArea','g',131,['name':("txnRef"),'required':(""),'value':(txnPaymentAdjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(31)
invokeTag('textArea','g',139,['name':("txnParticulars"),'value':(txnPaymentAdjustmentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(32)
})
invokeTag('form','g',142,['name':("txnPaymentAdjustmentForm"),'action':("saveDepositCOCItxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',144,['tag':("main-content")],2)
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('jasperReport','g',148,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',153,['action':("index")],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',212,['tag':("main-actions")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',213,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129404L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
