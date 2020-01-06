import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loaneditSpecial_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/editSpecial.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
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
invokeTag('hasErrors','g',33,['bean':(loanInstance?.special)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('hiddenField','g',37,['name':("version"),'value':(loanInstance?.special?.version)],-1)
printHtmlPart(11)
invokeTag('select','g',41,['id':("type"),'name':("type.id"),'from':(icbs.lov.LoanSpecialType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.special?.type?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
createTagBody(5, {->
printHtmlPart(14)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',48,['bean':(loanInstance?.special),'field':("type")],5)
printHtmlPart(16)
})
invokeTag('hasErrors','g',51,['bean':(loanInstance?.special),'field':("type")],4)
printHtmlPart(17)
invokeTag('textField','g',57,['name':("specialAction"),'value':(loanInstance?.special?.action),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
createTagBody(5, {->
printHtmlPart(14)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',64,['bean':(loanInstance?.special),'field':("action")],5)
printHtmlPart(16)
})
invokeTag('hasErrors','g',67,['bean':(loanInstance?.special),'field':("action")],4)
printHtmlPart(18)
invokeTag('customDatePicker','g',74,['name':("transferDate"),'precision':("day"),'class':("form-control"),'value':(loanInstance?.special?.transferDate),'type':("text"),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
createTagBody(5, {->
printHtmlPart(21)
invokeTag('message','g',80,['error':(it)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',81,['bean':(loanInstance?.special),'field':("transferDate")],5)
printHtmlPart(23)
})
invokeTag('hasErrors','g',84,['bean':(loanInstance?.special),'field':("transferDate")],4)
printHtmlPart(24)
invokeTag('submitButton','g',90,['class':("btn btn-primary"),'name':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(25)
})
invokeTag('form','g',90,['url':([controller:loan, id:"${loanInstance?.id}", action:'updateSpecial']),'method':("POST")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',96,['controller':("loanInquiry"),'action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',97,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129052L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
