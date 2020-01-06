import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanAdjustmentedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanAdjustment/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
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
createClosureForHtmlPart(9, 3)
invokeTag('hasErrors','g',32,['bean':(loanLedgerInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('hiddenField','g',34,['name':("version"),'value':(loanLedgerInstance?.version)],-1)
printHtmlPart(11)
invokeTag('render','g',36,['template':("form")],-1)
printHtmlPart(12)
invokeTag('actionSubmit','g',39,['class':("btn btn-primary"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(13)
})
invokeTag('form','g',41,['url':([controller:loanAdjustment, id:"${loanLedgerInstance?.id}", action:'update']),'method':("PUT")],3)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',43,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',46,['action':("index")],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',47,['action':("show"),'id':(loanLedgerInstance.id)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('actionSubmit','g',51,['action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(10)
})
invokeTag('form','g',51,['url':([controller:loanAdjustment, id:"${loanLedgerInstance?.id}", action:'delete']),'method':("DELETE")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',51,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129161L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
