import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBank_cashInBankDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/_cashInBankDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(cashInBankInstance?.bankName)
printHtmlPart(1)
expressionOut.print(cashInBankInstance?.acctNo)
printHtmlPart(2)
expressionOut.print(cashInBankInstance?.bankBranch)
printHtmlPart(3)
invokeTag('formatDate','g',13,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.openDate)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',17,['format':("###,###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127931L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
