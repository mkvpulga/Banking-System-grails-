import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringreprintPassbookShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/reprintPassbookShow.gsp" }
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
expressionOut.print(pbLedger?.acctNo)
printHtmlPart(11)
expressionOut.print(pbLedger?.acct?.acctName)
printHtmlPart(12)
expressionOut.print(pbLedger?.txnDate)
printHtmlPart(13)
expressionOut.print(pbLedger?.passbookLine)
printHtmlPart(14)
if(true && (session["type"]==1 || session["type"]==2)) {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',71,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',75,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(19)
invokeTag('field','g',76,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(20)
})
invokeTag('form','g',79,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLine',controller:'tellering'])],4)
printHtmlPart(15)
}
else {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',85,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',89,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(19)
invokeTag('field','g',90,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(20)
})
invokeTag('form','g',93,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLineTd',controller:'tellering'])],4)
printHtmlPart(15)
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
expressionOut.print(message(code: 'default.button.create.label', default: 'Submit'))
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',102,['action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',105,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129416L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
