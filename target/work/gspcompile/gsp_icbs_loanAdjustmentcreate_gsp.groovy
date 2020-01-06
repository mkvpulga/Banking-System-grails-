import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanAdjustmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanAdjustment/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(7)
expressionOut.print(createLink(controller: 'search', action:'search', params:[searchDomain: 'deposit']))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'search', action:'search', params:[searchDomain: 'deposit']))
printHtmlPart(9)
expressionOut.print(createLink(controller:'loanAdjustment', action:'getTxnTemplatesAjax'))
printHtmlPart(10)
expressionOut.print(message(code: 'default.button.delete.confirm.message', default: 'Are you sure?'))
printHtmlPart(11)
expressionOut.print(loanLedgerInstance?.loan?.id)
printHtmlPart(12)
expressionOut.print(loanLedgerInstance?.deposit?.id)
printHtmlPart(13)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(15)
})
invokeTag('javascript','g',523,[:],2)
printHtmlPart(16)
})
invokeTag('captureHead','sitemesh',524,[:],1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(1)
createTagBody(3, {->
printHtmlPart(20)
if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.disbursement.excess'))) {
printHtmlPart(21)
}
else if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.excess'))) {
printHtmlPart(22)
}
else if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.belowZero'))) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('hasErrors','g',558,['bean':(loanLedgerInstance)],3)
printHtmlPart(1)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('render','g',561,['template':("form")],-1)
printHtmlPart(27)
})
invokeTag('form','g',563,['id':("loan-adjustment-form"),'url':([controller:loanAdjustment, action:'save'])],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',565,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('submitButton','g',568,['id':("adjust"),'name':("save"),'value':("Save"),'onclick':("funcCallValidate();")],-1)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',663,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',665,['tag':("main-actions")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',666,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129159L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
