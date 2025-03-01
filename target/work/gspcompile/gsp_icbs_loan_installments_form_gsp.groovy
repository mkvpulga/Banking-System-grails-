import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_installments_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/installments/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(add)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('hasErrors','g',44,['bean':(installment)],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: installment, field: 'installmentDate', 'has-error'))
printHtmlPart(7)
invokeTag('customDatePicker','g',50,['name':("installmentDate"),'precision':("day"),'class':("form-control"),'value':(installment?.installmentDate)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',57,['bean':(installment),'field':("installmentDate")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',60,['bean':(installment),'field':("installmentDate")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: installment, field: 'principalInstallmentAmount', 'has-error'))
printHtmlPart(14)
invokeTag('field','g',66,['class':("form-control"),'name':("principalInstallmentAmount"),'value':(installment?.principalInstallmentAmount)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',73,['bean':(installment),'field':("principalInstallmentAmount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',76,['bean':(installment),'field':("principalInstallmentAmount")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: installment, field: 'interestInstallmentAmount', 'has-error'))
printHtmlPart(16)
invokeTag('field','g',82,['class':("form-control"),'name':("interestInstallmentAmount"),'value':(installment?.interestInstallmentAmount)],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',88,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',89,['bean':(installment),'field':("interestInstallmentAmount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',92,['bean':(installment),'field':("interestInstallmentAmount")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: installment, field: 'serviceChargeInstallmentAmount', 'has-error'))
printHtmlPart(19)
invokeTag('field','g',101,['class':("form-control"),'name':("serviceChargeInstallmentAmount"),'value':(installment?.serviceChargeInstallmentAmount)],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',107,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',108,['bean':(installment),'field':("serviceChargeInstallmentAmount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',111,['bean':(installment),'field':("serviceChargeInstallmentAmount")],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129058L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
