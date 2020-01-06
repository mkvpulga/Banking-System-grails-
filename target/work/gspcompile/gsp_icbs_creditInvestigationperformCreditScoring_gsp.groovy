import icbs.loans.CreditInvestigation
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringQuestionSection
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationperformCreditScoring_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/performCreditScoring.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
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
loop:{
int i = 0
for( scoringsectionInstance in (scoringSectionInstance) ) {
printHtmlPart(10)
if(true && (i == 0)) {
printHtmlPart(11)
expressionOut.print(scoringsectionInstance.id)
printHtmlPart(12)
expressionOut.print(scoringsectionInstance?.nameOfSection)
printHtmlPart(13)
expressionOut.print(scoringsectionInstance?.sectionPercentage)
printHtmlPart(14)
}
else {
printHtmlPart(15)
expressionOut.print(scoringsectionInstance.id)
printHtmlPart(12)
expressionOut.print(scoringsectionInstance?.nameOfSection)
printHtmlPart(13)
expressionOut.print(scoringsectionInstance?.sectionPercentage)
printHtmlPart(14)
}
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',40,['name':("loanApp"),'id':("loanApp"),'value':(creditInvestigationInstance?.loanApplication?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',41,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(19)
loop:{
int i = 0
for( scoringsectionInstancex in (scoringSectionInstance) ) {
printHtmlPart(20)
if(true && (i == 0)) {
printHtmlPart(21)
expressionOut.print(scoringsectionInstancex.id)
printHtmlPart(22)
loop:{
int j = 0
for( questionXs in (CreditScoringQuestions.findAllByCreditScoringQuestionSection(CreditScoringQuestionSection.get(scoringsectionInstancex.id),[sort: "id", order: "asc"] )) ) {
printHtmlPart(23)
expressionOut.print(questionXs?.questionNumberDescription)
printHtmlPart(24)
invokeTag('select','g',53,['noSelection':(['':'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(25)
expressionOut.print(questionXs?.choiceDescriptionA)
printHtmlPart(26)
expressionOut.print(questionXs?.choiceDescriptionB)
printHtmlPart(26)
expressionOut.print(questionXs?.choiceDescriptionC)
printHtmlPart(27)
j++
}
}
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(scoringsectionInstancex.id)
printHtmlPart(22)
for( xquestionXs in (CreditScoringQuestions.findAllByCreditScoringQuestionSection(CreditScoringQuestionSection.get(scoringsectionInstancex.id),[sort: "id", order: "asc"])) ) {
printHtmlPart(23)
expressionOut.print(xquestionXs?.questionNumberDescription)
printHtmlPart(24)
invokeTag('select','g',69,['noSelection':(['':'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(25)
expressionOut.print(xquestionXs?.choiceDescriptionA)
printHtmlPart(26)
expressionOut.print(xquestionXs?.choiceDescriptionB)
printHtmlPart(26)
expressionOut.print(xquestionXs?.choiceDescriptionC)
printHtmlPart(30)
}
printHtmlPart(28)
}
printHtmlPart(31)
i++
}
}
printHtmlPart(18)
})
invokeTag('form','g',80,['name':("myForm"),'id':("saveFormCreditScoringDetails"),'url':([action:'saveCreditScoringChecklist',controller:'creditInvestigation']),'method':("POST")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(33)
createClosureForHtmlPart(34, 2)
invokeTag('captureContent','sitemesh',99,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',100,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128114L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
