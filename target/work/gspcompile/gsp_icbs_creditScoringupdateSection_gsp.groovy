import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringupdateSection_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/updateSection.gsp" }
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
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(sectionInstance?.creditScoringCodeDescription?.id)
printHtmlPart(12)
invokeTag('hiddenField','g',27,['name':("sectionId"),'id':("sectionId"),'value':(sectionInstance?.id)],-1)
printHtmlPart(13)
invokeTag('select','g',33,['id':("xxcode"),'name':("xxcode"),'from':(icbs.loans.CreditScoringCodeDescription.list()),'optionKey':("id"),'optionValue':("code"),'value':(sectionInstance?.creditScoringCodeDescription?.id),'class':("many-to-one form-control"),'disabled':("disable")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',35,['name':("code"),'id':("code"),'value':(sectionInstance?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(15)
invokeTag('textField','g',38,['name':("groupName"),'id':("groupName"),'required':(""),'value':(sectionInstance?.creditScoringCodeDescription?.description),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(16)
invokeTag('textField','g',44,['name':("sectionName"),'id':("sectionName"),'required':(""),'value':(sectionInstance?.nameOfSection),'class':("form-control")],-1)
printHtmlPart(17)
invokeTag('field','g',51,['type':("number"),'name':("sectionPercentage"),'id':("sectionPercentage"),'required':(""),'value':(sectionInstance?.sectionPercentage),'class':("form-control")],-1)
printHtmlPart(18)
})
invokeTag('form','g',53,['onsubmit':("callLoadingDialog();"),'name':("creditScoringSection"),'id':("creditScoringSection"),'url':([action:'updateSaveSection',controller:'CreditScoring'])],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',57,['controller':("creditScoring"),'action':("codeWithQuestionSectionDetails"),'id':(sectionInstance?.creditScoringCodeDescription?.id)],3)
printHtmlPart(23)
expressionOut.print(createLink(controller:'CreditScoring', action:'validateExisitingCode'))
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',107,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',107,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128184L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
