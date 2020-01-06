import icbs.loans.CreditInvestigation
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringcodeWithQuestionSectionDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/codeWithQuestionSectionDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(codeInstance?.code)
printHtmlPart(11)
expressionOut.print(codeInstance?.description)
printHtmlPart(12)
for( preQualification in (prequalificationList) ) {
printHtmlPart(13)
expressionOut.print(preQualification?.preQualificationItem)
printHtmlPart(14)
expressionOut.print(preQualification.id)
printHtmlPart(15)
expressionOut.print(preQualification.id)
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
invokeTag('hiddenField','g',109,['name':("sectionId"),'id':("sectionId${preQualification?.id}"),'value':(preQualification?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',111,['name':("parentCodeDescription"),'id':("parentCodeDescription${preQualification.id}"),'value':(preQualification?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(19)
invokeTag('textField','g',114,['name':("qualificationItem"),'id':("qualificationItem${preQualification.id}"),'required':(""),'value':(preQualification?.preQualificationItem),'class':("form-control")],-1)
printHtmlPart(20)
expressionOut.print(preQualification?.id)
printHtmlPart(21)
})
invokeTag('form','g',126,['name':("creditScoringQuestion"),'id':("creditScoringQuestion${preQualification.id}"),'url':([action:'updatePreQualification',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(22)
}
printHtmlPart(23)
for( sectionQuestion in (sectionOfQuestionInstance) ) {
printHtmlPart(24)
expressionOut.print(sectionQuestion?.nameOfSection)
printHtmlPart(25)
expressionOut.print(sectionQuestion?.sectionPercentage)
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',157,['class':("btn btn-success"),'action':("updateSection"),'id':(sectionQuestion.id)],4)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',159,['class':("btn btn-primary"),'action':("manageQuestionsUnderSection"),'id':(sectionQuestion.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (Boolean.valueOf(codeInstance?.hasRatedItem) == true)) {
printHtmlPart(31)
for( ratedInstance in (ratedList) ) {
printHtmlPart(32)
expressionOut.print(ratedInstance?.ratedName)
printHtmlPart(33)
expressionOut.print(ratedInstance.id)
printHtmlPart(34)
createClosureForHtmlPart(35, 5)
invokeTag('link','g',188,['class':("btn btn-primary"),'action':("createRatedItemList"),'id':(ratedInstance.id)],5)
printHtmlPart(36)
expressionOut.print(ratedInstance.id)
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(37)
invokeTag('hiddenField','g',201,['name':("ratedId"),'id':("ratedId${ratedInstance?.id}"),'value':(ratedInstance?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',203,['name':("parentCodeDescription"),'id':("parentCodeDescription${ratedInstance?.id}"),'value':(ratedInstance?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(38)
invokeTag('textArea','g',208,['name':("ratedName"),'id':("ratedName${ratedInstance?.id}"),'rows':("5"),'cols':("40"),'required':(""),'value':(ratedInstance?.ratedName),'class':("form-control")],-1)
printHtmlPart(39)
expressionOut.print(ratedInstance?.id)
printHtmlPart(21)
})
invokeTag('form','g',219,['name':("creditScoringRated"),'id':("creditScoringRated${ratedInstance.id}"),'url':([action:'updateRated',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();")],5)
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',222,['tag':("main-content")],2)
printHtmlPart(43)
createTagBody(2, {->
printHtmlPart(44)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',227,['controller':("creditScoring"),'action':("createPreQualification"),'id':(params.id)],3)
printHtmlPart(46)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',230,['controller':("creditScoring"),'action':("createSection"),'id':(params.id)],3)
printHtmlPart(48)
if(true && (Boolean.valueOf(codeInstance?.hasRatedItem) == true)) {
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',239,['controller':("creditScoring"),'action':("createRatedList"),'id':(params.id)],4)
printHtmlPart(48)
}
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',243,['conntroller':("creditScoring"),'action':("configSection")],3)
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',243,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',243,[:],1)
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128173L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
