import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenanceloanProjectInstanceCreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/loanProjectInstanceCreate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 4)
invokeTag('eachError','g',14,['bean':(loanProjectInstance),'var':("error")],4)
printHtmlPart(9)
})
invokeTag('hasErrors','g',16,['bean':(loanProjectInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('hiddenField','g',19,['name':("id"),'value':(loanProjectInstance?.id)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',20,['name':("version"),'value':(loanProjectInstance?.version)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: loanProjectInstance, field: 'code', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',24,['code':("loanProjectInstance.code.label"),'default':("Code")],-1)
printHtmlPart(14)
invokeTag('textField','g',27,['name':("code"),'maxlength':("100"),'required':(""),'value':(loanProjectInstance?.code),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(17)
invokeTag('message','g',33,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',34,['bean':(loanProjectInstance),'field':("code")],5)
printHtmlPart(19)
})
invokeTag('hasErrors','g',37,['bean':(loanProjectInstance),'field':("code")],4)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: loanProjectInstance, field: 'description', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',42,['code':("loanProjectInstance.description.label"),'default':("Description")],-1)
printHtmlPart(14)
invokeTag('textField','g',45,['name':("description"),'maxlength':("100"),'required':(""),'value':(loanProjectInstance?.description),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(22)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',52,['bean':(loanProjectInstance),'field':("description")],5)
printHtmlPart(19)
})
invokeTag('hasErrors','g',55,['bean':(loanProjectInstance),'field':("description")],4)
printHtmlPart(23)
invokeTag('hiddenField','g',58,['name':("status"),'value':("true")],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',60,['class':("btn btn-primary"),'action':("loanProjectInstanceSave"),'value':(message(code: 'default.button.created.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to create this Loan Project?')}');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',61,['controller':("lovMaintenance"),'action':("loanProjectInstanceSave")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',68,['action':("loanProjectIndex")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129252L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
