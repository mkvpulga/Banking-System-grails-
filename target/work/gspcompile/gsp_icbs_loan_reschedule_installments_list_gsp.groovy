import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_installments_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/installments/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["installments"])) {
printHtmlPart(1)
invokeTag('set','g',20,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( installment in (session["installments"]) ) {
printHtmlPart(2)
expressionOut.print(i + 1)
printHtmlPart(3)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(installment?.installmentDate)],-1)
printHtmlPart(3)
expressionOut.print(installment?.principalInstallmentAmount)
printHtmlPart(4)
expressionOut.print(installment?.interestInstallmentAmount)
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('set','g',31,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('hiddenField','g',61,['name':("installmentId"),'value':("")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129080L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
