import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_sweep_editSweep_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/sweep/_editSweep.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["sweepAccounts"])) {
printHtmlPart(1)
invokeTag('set','g',16,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( sweepAccounts in (session["sweeplist"]) ) {
printHtmlPart(2)
expressionOut.print(sweepAccounts?.depositAccount?.acctNo)
printHtmlPart(3)
expressionOut.print(sweepAccounts?.depositAccount?.acctName)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.type?.description)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.rule?.description)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.remarks)
printHtmlPart(5)
expressionOut.print(sweepAccounts?.ordinalNum)
printHtmlPart(6)
invokeTag('hiddenField','g',25,['name':("actionPage"),'id':("actionPage"),'value':(session["pageAction"])],-1)
printHtmlPart(7)
invokeTag('set','g',28,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('hiddenField','g',62,['name':("sweepAccountId"),'value':("")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129146L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
