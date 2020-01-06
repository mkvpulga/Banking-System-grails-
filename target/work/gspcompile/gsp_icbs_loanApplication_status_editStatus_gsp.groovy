import icbs.lov.LoanApplicationStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_status_editStatus_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/status/_editStatus.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',25,['bean':(loanApplicationInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("id"),'id':("id"),'value':(loanApplicationInstance?.id)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error'))
printHtmlPart(7)
if(true && (user?.id == 16 && loanApplicationInstance?.customer?.id == 6605)) {
printHtmlPart(8)
invokeTag('select','g',34,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id != 4 && it.id != 2  }),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else if(true && (user?.designation?.id == 17)) {
printHtmlPart(9)
invokeTag('select','g',37,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id == 3 || it.id == 1 }),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else if(true && (user?.designation?.id == 33)) {
printHtmlPart(9)
invokeTag('select','g',40,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id == 4 || it.id == 1}),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else if(true && (user?.designation?.id == 30 && loanApplicationInstance?.customer?.id != 6605)) {
printHtmlPart(9)
invokeTag('select','g',43,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id ==1 || it.id >= 5 }),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else if(true && (user?.id == 15)) {
printHtmlPart(9)
invokeTag('select','g',46,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id ==1 || it.id == 2 }),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('select','g',49,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(LoanApplicationStatus.list().findAll{it.id ==loanApplicationInstance?.approvalStatus?.id}),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'readonly':("true"),'class':("form-control")],-1)
printHtmlPart(11)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',56,['bean':(loanApplicationInstance),'field':("approvalStatus")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',59,['bean':(loanApplicationInstance),'field':("approvalStatus")],2)
printHtmlPart(16)
})
invokeTag('form','g',62,['name':("update-status-form")],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129202L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
