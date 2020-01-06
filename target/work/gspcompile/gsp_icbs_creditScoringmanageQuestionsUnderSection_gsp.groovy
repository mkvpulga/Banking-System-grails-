import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringmanageQuestionsUnderSection_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/manageQuestionsUnderSection.gsp" }
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
expressionOut.print(sectionInstance?.creditScoringCodeDescription?.code)
printHtmlPart(11)
expressionOut.print(sectionInstance?.nameOfSection)
printHtmlPart(12)
for( descAndQuestion in (xSectionQuestions) ) {
printHtmlPart(13)
expressionOut.print(descAndQuestion?.questionNumberDescription)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',73,['class':("btn btn-primary"),'controller':("creditScoring"),'action':("viewQuestionDetails"),'id':(descAndQuestion?.id)],4)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',95,['name':("sectionId"),'id':("sectionId"),'value':(sectionInstance?.id)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',98,['name':("parentCodeDescription"),'id':("parentCodeDescription"),'value':(sectionInstance?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(20)
invokeTag('textField','g',101,['name':("numberWithDescription"),'id':("numberWithDescription"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(21)
invokeTag('textArea','g',107,['name':("choiceDescriptionA"),'id':("choiceDescriptionA"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control")],-1)
printHtmlPart(22)
invokeTag('textArea','g',113,['name':("choiceDescriptionB"),'id':("choiceDescriptionB"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control")],-1)
printHtmlPart(23)
invokeTag('textArea','g',119,['name':("choiceDescriptionC"),'id':("choiceDescriptionC"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control")],-1)
printHtmlPart(24)
invokeTag('textArea','g',125,['name':("remarks"),'id':("remarks"),'value':(""),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control")],-1)
printHtmlPart(25)
})
invokeTag('form','g',171,['name':("creditScoringQuestion"),'id':("creditScoringQuestion"),'url':([action:'saveQuestionUnderSection',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',172,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',181,['controller':("creditScoring"),'action':("codeWithQuestionSectionDetails"),'id':(sectionInstance?.creditScoringCodeDescription?.id)],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',183,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',185,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128182L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
