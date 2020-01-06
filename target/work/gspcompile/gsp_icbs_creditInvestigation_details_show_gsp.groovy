import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigation_details_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/details/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
expressionOut.print(creditInvestigationInstance?.loanApplication?.id)
})
invokeTag('link','g',6,['controller':("loanApplication"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.id)],1)
printHtmlPart(1)
if(true && (creditInvestigationInstance?.loanApplication)) {
printHtmlPart(2)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(3)
expressionOut.print(creditInvestigationInstance?.loanApplication?.approvalStatus?.description)
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(creditInvestigationInstance?.loanApplication?.product?.name)
})
invokeTag('link','g',19,['controller':("product"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.product?.id)],2)
printHtmlPart(5)
invokeTag('formatNumber','g',23,['format':("###,##0.00"),'number':(creditInvestigationInstance?.loanApplication?.amount)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('fieldValue','g',29,['bean':(creditInvestigationInstance),'field':("recommendation")],-1)
printHtmlPart(8)
invokeTag('formatDate','g',33,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.ciScheduleDate)],-1)
printHtmlPart(9)
expressionOut.print(creditInvestigationInstance?.ciName)
printHtmlPart(10)
invokeTag('formatDate','g',41,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.ciExecutionDate)],-1)
printHtmlPart(11)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.appraisalDate)],-1)
printHtmlPart(12)
expressionOut.print(creditInvestigationInstance?.appraisedBy)
printHtmlPart(13)
invokeTag('formatDate','g',53,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.loanAnalysisScheduleDate)],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128109L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
