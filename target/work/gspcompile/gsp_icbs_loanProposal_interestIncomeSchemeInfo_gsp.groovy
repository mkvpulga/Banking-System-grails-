import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposal_interestIncomeSchemeInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/_interestIncomeSchemeInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(interestIncomeScheme?.installmentType.id ?: 1)
printHtmlPart(1)
expressionOut.print(interestIncomeScheme?.installmentCalcType.id ?: 1)
printHtmlPart(2)
expressionOut.print(interestIncomeScheme?.defaultInterestRate ?: 0)
printHtmlPart(3)
expressionOut.print(interestIncomeScheme?.minInterestRate ?: 0)
printHtmlPart(4)
expressionOut.print(interestIncomeScheme?.maxInterestRate ?: 100)
printHtmlPart(5)
expressionOut.print(interestIncomeScheme?.hasBalloonMode)
printHtmlPart(6)
expressionOut.print(interestIncomeScheme?.canChangeInterestRate)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129238L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
