import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposalcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'loanProposal', 
			                      action:'getInterestIncomeSchemeInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loanProposal', 
			                      action:'getInterestIncomeSchemeInfoAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanProposal', action:'showInstallmentScheduleAjax'))
printHtmlPart(7)
})
invokeTag('javascript','g',354,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',355,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',359,['tag':("breadcrumbs")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('render','g',384,['template':("specification")],-1)
printHtmlPart(16)
invokeTag('submitButton','g',410,['name':("create"),'class':("btn btn-primary"),'value':("Show Schedule")],-1)
printHtmlPart(17)
})
invokeTag('form','g',413,[:],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',415,['tag':("main-content")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',419,['class':("create"),'action':("loanAmountCalculator")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',421,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',422,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129241L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
