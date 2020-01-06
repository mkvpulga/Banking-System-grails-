import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_statusreopen_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/status/reopen.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(10)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(11)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(loanInstance?.branch?.name)
})
invokeTag('link','g',39,['controller':("branch"),'action':("show"),'id':(loanInstance?.branch?.id)],3)
printHtmlPart(13)
invokeTag('formatNumber','g',43,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',47,['format':("###,###,##0.00"),'number':(loanInstance?.interestRate)],-1)
printHtmlPart(15)
if(true && (loanInstance?.interestIncomeScheme?.installmentCalcType?.id == 1)) {
printHtmlPart(16)
expressionOut.print(loanInstance?.term)
printHtmlPart(17)
}
else {
printHtmlPart(18)
expressionOut.print(loanInstance?.frequency?.description)
printHtmlPart(19)
expressionOut.print(loanInstance?.numInstallments)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('formatDate','g',67,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(22)
invokeTag('formatDate','g',71,['format':("MM/dd/yyyy"),'date':(loanInstance?.maturityDate)],-1)
printHtmlPart(23)
expressionOut.print(loanInstance?.status?.description)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
invokeTag('hiddenField','g',80,['name':("activity"),'value':("Amendment")],-1)
printHtmlPart(26)
})
invokeTag('form','g',81,['id':("loan-form"),'url':([resource:loanInstance, action:'saveReopen']),'method':("PUT"),'onsubmit':("return alertify.alert('Please wait... Processing....')")],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('submitButton','g',85,['id':("save"),'name':("save"),'value':("Save"),'onclick':("callsendAlertify();")],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',98,['action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',100,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',101,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129144L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
