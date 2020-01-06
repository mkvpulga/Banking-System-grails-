import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',28,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Credit Investigation ID")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',30,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',35,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',41,['property':("id"),'title':(message(code: 'creditInvestigation.id.label', default: 'ID'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',43,['property':("id"),'title':(message(code: 'creditInvestigation.loanApplication.label', default: 'Loan Application'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',45,['property':("recommendation"),'title':(message(code: 'creditInvestigation.appraisedBy.label', default: 'Appraised By'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( creditInvestigationInstance in (creditInvestigationInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(19)
expressionOut.print(creditInvestigationInstance?.loanApplication?.branch?.name)
printHtmlPart(20)
expressionOut.print(creditInvestigationInstance?.loanApplication?.id)
printHtmlPart(19)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(19)
expressionOut.print(creditInvestigationInstance?.appraisedBy)
printHtmlPart(19)
invokeTag('formatDate','g',58,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.appraisalDate)],-1)
printHtmlPart(19)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',59,['class':("btn btn-secondary"),'action':("show"),'id':(creditInvestigationInstance.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',66,['total':(CreditInvestigationInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',72,['class':("create"),'action':("create")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128112L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
