import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringconfigSection_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/configSection.gsp" }
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
invokeTag('select','g',26,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',29,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Credit Investigation ID")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',36,['name':("creditScoringProduct"),'id':("creditScoringProduct"),'url':([action:'configSection',controller:'CreditScoring'])],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',43,['property':("Date Created"),'title':(message(code: 'creditInvestigation.loanApplication.label', default: 'Date Created'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( creditScoringCodeDescriptionInstance in (creditScoringCodeList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
expressionOut.print(creditScoringCodeDescriptionInstance?.code)
printHtmlPart(17)
expressionOut.print(creditScoringCodeDescriptionInstance?.description)
printHtmlPart(17)
invokeTag('formatDate','g',53,['format':("MM/dd/yyyy"),'date':(creditScoringCodeDescriptionInstance?.dateCreated)],-1)
printHtmlPart(17)
expressionOut.print(creditScoringCodeDescriptionInstance?.createdBy?.username)
printHtmlPart(17)
createClosureForHtmlPart(18, 4)
invokeTag('link','g',55,['class':("btn btn-secondary"),'action':("codeWithQuestionSectionDetails"),'id':(creditScoringCodeDescriptionInstance.id)],4)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(creditScoringCodeListInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',67,['controller':("creditScoring"),'action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128176L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
