import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_loanApplication_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/loanApplication/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.product?.id)
printHtmlPart(2)
expressionOut.print(loanApplicationInstance?.amount)
printHtmlPart(3)
expressionOut.print(loanApplicationInstance?.term)
printHtmlPart(4)
invokeTag('formatDate','g',7,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(5)
invokeTag('message','g',12,['code':("loanApplication.customer.label"),'default':("Customer")],-1)
printHtmlPart(6)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.customer?.birthDate)
printHtmlPart(8)
invokeTag('set','g',24,['var':("primaryAddress"),'value':(loanApplicationInstance?.customer?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(9)
if(true && (primaryAddress)) {
printHtmlPart(10)
invokeTag('set','g',26,['var':("primaryAddress"),'value':(primaryAddress?.address1 + ', ' + primaryAddress?.address2 +', ' +primaryAddress?.address3)],-1)
printHtmlPart(11)
}
else {
printHtmlPart(12)
invokeTag('set','g',29,['var':("primaryAddress"),'value':("")],-1)
printHtmlPart(11)
}
printHtmlPart(13)
expressionOut.print(primaryAddress)
printHtmlPart(14)
if(true && ((loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(15)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',49,['code':("loanApplication.product.label"),'default':("Product")],-1)
printHtmlPart(18)
expressionOut.print(loanApplicationInstance?.product?.name)
printHtmlPart(19)
invokeTag('message','g',57,['code':("loanApplication.branch.label"),'default':("Branch")],-1)
printHtmlPart(20)
expressionOut.print(loanApplicationInstance?.branch?.name)
printHtmlPart(5)
invokeTag('message','g',65,['code':("loanApplication.currency.label"),'default':("Currency")],-1)
printHtmlPart(20)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(5)
invokeTag('message','g',73,['code':("loanApplication.amount.label"),'default':("Amount")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',76,['bean':(loanApplicationInstance),'field':("amount")],-1)
printHtmlPart(5)
invokeTag('message','g',81,['code':("loanApplication.term.label"),'default':("Term")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',84,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(5)
invokeTag('message','g',89,['code':("loanApplication.purpose.label"),'default':("Purpose")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',92,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(5)
invokeTag('message','g',97,['code':("loanApplication.applicationDate.label"),'default':("Application Date")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',100,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(5)
invokeTag('message','g',105,['code':("loanApplication.status.label"),'default':("Status")],-1)
printHtmlPart(20)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129107L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
