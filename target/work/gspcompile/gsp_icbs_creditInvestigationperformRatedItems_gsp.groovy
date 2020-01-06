import icbs.loans.CreditInvestigation
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringQuestionSection
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringRatedItems
import icbs.loans.CreditScoringRatedItemsRecords
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationperformRatedItems_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/performRatedItems.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
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
loop:{
int i = 0
for( ratedInstance in (idRatedSectionList) ) {
printHtmlPart(10)
if(true && (i == 0)) {
printHtmlPart(11)
expressionOut.print(ratedInstance.id)
printHtmlPart(12)
expressionOut.print(ratedInstance?.ratedName.substring(0,ratedInstance?.ratedName.indexOf('-')))
printHtmlPart(13)
}
else {
printHtmlPart(14)
expressionOut.print(ratedInstance.id)
printHtmlPart(12)
expressionOut.print(ratedInstance?.ratedName.substring(0,ratedInstance?.ratedName.indexOf('-')))
printHtmlPart(13)
}
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('hiddenField','g',43,['name':("loanApp"),'id':("loanApp"),'value':(creditInvestigationInstance?.loanApplication?.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',44,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(18)
loop:{
int i = 0
for( ratedInstance in (idRatedSectionList) ) {
printHtmlPart(19)
if(true && (i == 0)) {
printHtmlPart(20)
expressionOut.print(ratedInstance.id)
printHtmlPart(21)
expressionOut.print(ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length()))
printHtmlPart(22)
invokeTag('message','g',54,['code':("loanApplication.recommendedRemarks1.label"),'default':("Remarks")],-1)
printHtmlPart(23)
if(true && (CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication))) {
printHtmlPart(24)
invokeTag('textArea','g',59,['id':("remarks"),'name':("remarks"),'value':(CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks),'class':("form-control")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textArea','g',62,['id':("remarks"),'name':("remarks"),'class':("form-control")],-1)
printHtmlPart(26)
}
printHtmlPart(27)
for( ratedItems in (CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(28)
expressionOut.print(ratedItems?.itemDescription)
printHtmlPart(29)
invokeTag('select','g',72,['noSelection':([null:'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(30)
}
printHtmlPart(31)
}
else {
printHtmlPart(32)
expressionOut.print(ratedInstance.id)
printHtmlPart(21)
expressionOut.print(ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length()))
printHtmlPart(22)
invokeTag('message','g',81,['code':("loanApplication.recommendedRemarks1.label"),'default':("Remarks")],-1)
printHtmlPart(33)
if(true && (CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication))) {
printHtmlPart(24)
invokeTag('textArea','g',86,['id':("remarks"),'name':("remarks"),'value':(CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks),'class':("form-control")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textArea','g',89,['id':("remarks"),'name':("remarks"),'class':("form-control")],-1)
printHtmlPart(26)
}
printHtmlPart(34)
for( ratedItems in (CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(28)
expressionOut.print(ratedItems?.itemDescription)
printHtmlPart(29)
invokeTag('select','g',98,['noSelection':([null:'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(35)
i++
}
}
printHtmlPart(17)
})
invokeTag('form','g',104,['name':("myForm"),'id':("saveRatedform"),'url':([action:'saveRatedScoringItems',controller:'creditInvestigation']),'method':("POST")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',107,['tag':("main-content")],2)
printHtmlPart(4)
createClosureForHtmlPart(37, 2)
invokeTag('captureContent','sitemesh',123,['tag':("main-actions")],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128115L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
