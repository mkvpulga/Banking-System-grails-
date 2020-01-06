import icbs.loans.CreditInvestigation
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringPreQualification
import icbs.loans.CreditScoringCodeDescription
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationpreQualification_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/preQualification.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
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
createTagBody(3, {->
printHtmlPart(10)
invokeTag('hiddenField','g',38,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',39,['name':("loanApp"),'id':("loanApp"),'value':(creditInvestigationInstance?.loanApplication?.id)],-1)
printHtmlPart(10)
for( qualListing in (idCreditPreq) ) {
printHtmlPart(11)
expressionOut.print(qualListing?.preQualificationItem)
printHtmlPart(12)
invokeTag('select','g',44,['noSelection':([null:'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('form','g',47,['name':("myForm"),'id':("loanPreQualification"),'method':("POST"),'url':([action:'collectPreQualificationEvaluation',controller:'CreditInvestigation'])],3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',52,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',58,['class':("btn btn-secondary"),'controller':("loanApplication"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.id)],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128116L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
