import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_transactions_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/transactions/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( loanLedgerInstance in (LoanLedger.findAllByLoan(loanInstance).sort{it.id}) ) {
printHtmlPart(1)
expressionOut.print(loanLedgerInstance?.id)
printHtmlPart(2)
invokeTag('formatDate','g',20,['format':("MM/dd/yyyy"),'date':(loanLedgerInstance?.txnDate)],-1)
printHtmlPart(3)
expressionOut.print(loanLedgerInstance?.txnType?.description)
printHtmlPart(3)
expressionOut.print(loanLedgerInstance?.txnTemplate?.description)
printHtmlPart(3)
expressionOut.print(loanLedgerInstance?.txnRef)
printHtmlPart(2)
expressionOut.print(loanLedgerInstance?.txnParticulars)
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',25,['class':("btn btn-secondary"),'controller':("loanAdjustment"),'action':("show"),'id':(loanLedgerInstance?.id)],2)
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129149L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
