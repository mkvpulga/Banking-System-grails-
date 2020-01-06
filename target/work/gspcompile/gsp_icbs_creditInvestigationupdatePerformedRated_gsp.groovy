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

class gsp_icbs_creditInvestigationupdatePerformedRated_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/updatePerformedRated.gsp" }
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
for( ratedInstance in (xxratedInstance) ) {
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
for( ratedInstance in (xxratedInstance) ) {
printHtmlPart(19)
if(true && (i == 0)) {
printHtmlPart(20)
expressionOut.print(ratedInstance.id)
printHtmlPart(21)
expressionOut.print(ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length()))
printHtmlPart(22)
invokeTag('message','g',54,['code':("loanApplication.recommendedRemarks1.label"),'default':("Remarks")],-1)
printHtmlPart(23)
invokeTag('textArea','g',58,['id':("remarks"),'name':("remarks"),'value':(CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks),'class':("form-control")],-1)
printHtmlPart(24)
for( ratedItems in (CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(25)
expressionOut.print(ratedItems?.itemDescription)
printHtmlPart(26)
invokeTag('select','g',65,['noSelection':([null:'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')),'optionKey':("id"),'optionValue':("description"),'value':(icbs.loans.CreditScoringRatedItemsRecords.findByCreditScoringRatedItems(ratedItems)?.creditScoringAnswers?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(ratedInstance.id)
printHtmlPart(21)
expressionOut.print(ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length()))
printHtmlPart(30)
for( ratedItems in (CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(31)
invokeTag('message','g',76,['code':("loanApplication.recommendedRemarks1.label"),'default':("Remarks")],-1)
printHtmlPart(32)
invokeTag('textArea','g',80,['id':("remarks"),'name':("remarks"),'value':(CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks),'class':("form-control")],-1)
printHtmlPart(33)
expressionOut.print(ratedItems?.itemDescription)
printHtmlPart(26)
invokeTag('select','g',86,['noSelection':([null:'-Set Score Here-']),'id':("xcode"),'name':("xcode"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')),'optionKey':("id"),'optionValue':("description"),'value':(icbs.loans.CreditScoringRatedItemsRecords.findByCreditScoringRatedItems(ratedItems)?.creditScoringAnswers?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(34)
i++
}
}
printHtmlPart(17)
})
invokeTag('form','g',92,['name':("myForm"),'id':("saveRatedform"),'url':([action:'updateSaveRatedScoringItems',controller:'creditInvestigation']),'method':("POST")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-content")],2)
printHtmlPart(36)
createClosureForHtmlPart(37, 2)
invokeTag('captureContent','sitemesh',111,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',112,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128167L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
