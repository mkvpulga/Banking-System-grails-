import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringviewQuestionDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/viewQuestionDetails.gsp" }
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
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',26,[:],3)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(questionInstance?.questionNumberDescription)
printHtmlPart(13)
expressionOut.print(questionInstance?.choiceDescriptionA)
printHtmlPart(14)
expressionOut.print(questionInstance?.choiceDescriptionB)
printHtmlPart(15)
expressionOut.print(questionInstance?.choiceDescriptionC)
printHtmlPart(16)
expressionOut.print(questionInstance?.remarks)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',84,['name':("questionId"),'id':("questionId"),'value':(questionInstance?.id)],-1)
printHtmlPart(19)
invokeTag('textField','g',89,['name':("numberWithDescription"),'id':("numberWithDescription"),'required':(""),'value':(questionInstance?.questionNumberDescription),'class':("form-control")],-1)
printHtmlPart(20)
invokeTag('textArea','g',95,['name':("choiceDescriptionA"),'id':("choiceDescriptionA"),'rows':("4"),'cols':("50"),'required':(""),'value':(questionInstance?.choiceDescriptionA),'class':("form-control")],-1)
printHtmlPart(21)
invokeTag('textArea','g',101,['name':("choiceDescriptionB"),'id':("choiceDescriptionB"),'rows':("4"),'cols':("50"),'required':(""),'value':(questionInstance?.choiceDescriptionB),'class':("form-control")],-1)
printHtmlPart(22)
invokeTag('textArea','g',107,['name':("choiceDescriptionC"),'id':("choiceDescriptionC"),'rows':("4"),'cols':("50"),'required':(""),'value':(questionInstance?.choiceDescriptionC),'class':("form-control")],-1)
printHtmlPart(23)
invokeTag('textArea','g',112,['name':("remarks"),'id':("remarks"),'rows':("4"),'cols':("50"),'required':(""),'value':(questionInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(24)
})
invokeTag('form','g',153,['onsubmit':("callLoadingDialog();"),'name':("creditScoringQuestion"),'id':("creditScoringQuestion"),'url':([action:'saveUpdateQuestionUnderSection',controller:'CreditScoring'])],3)
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('hiddenField','g',158,['name':("xquestionId"),'id':("xquestionId"),'value':(questionInstance?.id)],-1)
printHtmlPart(27)
})
invokeTag('form','g',158,['name':("myForm"),'id':("myDeleteFrom"),'url':([action:'deleteQuestion',controller:'CreditScoring']),'method':("POST")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',158,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',168,['controller':("creditScoring"),'action':("manageQuestionsUnderSection"),'id':(questionInstance?.creditScoringQuestionSection?.id)],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',182,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',182,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128185L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
