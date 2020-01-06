import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringprintPassbookTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/printPassbookTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(pbLedger?.id)
printHtmlPart(11)
expressionOut.print(pbLedger?.acctNo)
printHtmlPart(12)
expressionOut.print(pbLedger?.acct?.acctName)
printHtmlPart(13)
if(true && (session["type"]==1 || session["type"]==2)) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',61,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',65,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(18)
invokeTag('field','g',66,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(19)
})
invokeTag('form','g',69,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLine',controller:'tellering'])],4)
printHtmlPart(14)
}
else {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',75,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',79,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(18)
invokeTag('field','g',80,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(19)
})
invokeTag('form','g',83,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLineTd',controller:'tellering'])],4)
printHtmlPart(14)
}
printHtmlPart(3)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
expressionOut.print(message(code: 'default.button.create.label', default: 'Submit'))
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',92,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',94,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',95,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129415L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
