import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_classification_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/classification/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanKindOfLoan', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("loan.KindOfLoan.label"),'default':("Kind of Loan")],-1)
printHtmlPart(2)
invokeTag('select','g',7,['id':("loanKindOfLoan"),'name':("loanKindOfLoan.id"),'from':(icbs.lov.LoanKindOfLoan.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanKindOfLoan?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',12,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',13,['bean':(loanInstance),'field':("loanKindOfLoan")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',16,['bean':(loanInstance),'field':("loanKindOfLoan")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanType', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',21,['code':("loan.loanType.label"),'default':("Name of Institution")],-1)
printHtmlPart(2)
invokeTag('select','g',24,['id':("loanType"),'name':("loanType.id"),'from':(icbs.lov.LoanType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanType?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',29,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',30,['bean':(loanInstance),'field':("loanType")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',33,['bean':(loanInstance),'field':("loanType")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanProject', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',38,['code':("loan.loanProject.label"),'default':("Economic Activity")],-1)
printHtmlPart(2)
invokeTag('select','g',41,['id':("loanProject"),'name':("loanProject.id"),'from':(icbs.lov.LoanProject.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanProject?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',46,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',47,['bean':(loanInstance),'field':("loanProject")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',50,['bean':(loanInstance),'field':("loanProject")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanProvision', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',55,['code':("loan.loanProvision.label"),'default':("Loan Provision")],-1)
printHtmlPart(2)
invokeTag('select','g',58,['id':("loanProvision"),'name':("loanProvision.id"),'from':(icbs.lov.LoanProvision.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanProvision?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',63,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',64,['bean':(loanInstance),'field':("loanProvision")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',67,['bean':(loanInstance),'field':("loanProvision")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanPerformanceId', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',72,['code':("loan.loanPerformanceId.label"),'default':("Loan Status")],-1)
printHtmlPart(2)
invokeTag('select','g',75,['id':("loanPerformanceId"),'name':("loanPerformanceId.id"),'from':(icbs.lov.LoanPerformanceId.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanPerformanceId?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',76,['name':("oldPerformanceidid"),'id':("oldPerformanceidid"),'value':(loanInstance?.loanPerformanceId?.id)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',81,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',82,['bean':(loanInstance),'field':("loanPerformanceId")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',85,['bean':(loanInstance),'field':("loanPerformanceId")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanSecurity', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',90,['code':("loan.loanSecurity.label"),'default':("Loan Security")],-1)
printHtmlPart(2)
invokeTag('select','g',93,['id':("loanSecurity"),'name':("loanSecurity.id"),'from':(icbs.lov.LoanSecurity.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanSecurity?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',98,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',99,['bean':(loanInstance),'field':("loanSecurity")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',102,['bean':(loanInstance),'field':("loanSecurity")],1)
printHtmlPart(14)
if(true && (loanInstance.glLink==null)) {
printHtmlPart(15)
expressionOut.print(hasErrors(bean: loanInstance, field: 'glLink', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',107,['code':("loan.glLink.label"),'default':("Loan Type")],-1)
printHtmlPart(2)
invokeTag('select','g',113,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.list().findAll{it.type == 6}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.glLink?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(5)
invokeTag('message','g',119,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',120,['bean':(loanInstance),'field':("glLink")],3)
printHtmlPart(7)
})
invokeTag('hasErrors','g',122,['bean':(loanInstance),'field':("glLink")],2)
printHtmlPart(17)
}
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129040L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
