import icbs.atm.AtmTerminalMapping
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterface_terminalform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/_terminalform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: atmTerminalInstance, field: 'terminalCode', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("atmTerminalInstance.terminalCode.label"),'default':("Terminal Code")],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',8,['name':("atmTerminalId"),'id':("atmTerminalId"),'value':(atmTerminalInstance?.id)],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("terminalCode"),'maxlength':("10"),'required':(""),'value':(atmTerminalInstance?.terminalCode),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',14,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',15,['bean':(atmTerminalMappingInstance),'field':("terminalCode")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',18,['bean':(atmTerminalInstance),'field':("terminalCode")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: atmTerminalInstance, field: 'remarks', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',24,['code':("atmTerminalInstance.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(11)
invokeTag('textArea','g',27,['name':("remarks"),'rows':("5"),'cols':("50"),'required':(""),'value':(atmTerminalInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',32,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',33,['bean':(atmTerminalInstance),'field':("remarks")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',36,['bean':(atmTerminalInstance),'field':("remarks")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: atmTerminalInstance, field: 'branch', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',42,['code':("atmTerminalInstance.branch.label"),'default':("Branch")],-1)
printHtmlPart(11)
invokeTag('select','g',45,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(atmTerminalInstance?.branch?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',52,['bean':(atmTerminalInstance),'field':("branch")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',55,['bean':(atmTerminalInstance),'field':("branch")],1)
printHtmlPart(14)
invokeTag('hiddenField','g',58,['name':("terminalStatus"),'value':("2")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127894L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
