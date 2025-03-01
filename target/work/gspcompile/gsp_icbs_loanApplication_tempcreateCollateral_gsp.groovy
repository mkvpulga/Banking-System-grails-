import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempcreateCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/createCollateral.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'collateral.label', default: 'Collateral'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(2, 2)
invokeTag('javascript','g',89,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',90,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',100,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',101,['bean':(collateralInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',103,['bean':(collateralInstance)],3)
printHtmlPart(16)
invokeTag('set','g',105,['var':("loanApplicationInstance"),'value':(LoanApplication.get(params?.loanApplication))],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('render','g',108,['template':("collateral")],-1)
printHtmlPart(18)
invokeTag('submitButton','g',111,['name':("create"),'class':("btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(19)
})
invokeTag('form','g',113,['url':([controller:loanApplication, action:'saveCollateral'])],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',115,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',118,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',119,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129205L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
