import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringcreatePreQualification_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/createPreQualification.gsp" }
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
invokeTag('select','g',31,['id':("xcode"),'name':("xcode"),'from':(icbs.loans.CreditScoringCodeDescription.list()),'optionKey':("id"),'optionValue':("code"),'value':(codeInstance?.id),'class':("many-to-one form-control"),'disabled':("disable")],-1)
printHtmlPart(12)
invokeTag('textField','g',36,['name':("groupName"),'id':("groupName"),'required':(""),'value':(codeInstance?.description),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',38,['name':("code"),'id':("code"),'value':(codeInstance?.id)],-1)
printHtmlPart(14)
invokeTag('textField','g',44,['name':("qualificationItem"),'id':("qualificationItem"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(15)
})
invokeTag('form','g',45,['name':("creditScoringPreQualification"),'id':("creditScoringPreQualification"),'url':([action:'savePreQualification',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',45,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',49,['controller':("creditScoring"),'action':("codeWithQuestionSectionDetails"),'id':(params.id)],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128177L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
