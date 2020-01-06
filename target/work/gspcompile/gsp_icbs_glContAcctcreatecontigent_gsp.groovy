import icbs.gl.GlContigentAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctcreatecontigent_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/createcontigent.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
invokeTag('set','g',17,['var':("entityName"),'value':(message(code: 'ContigentAccount.label', default: 'Contigent Account'))],-1)
printHtmlPart(5)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',18,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(6)
expressionOut.print(createLink(controller:'GlContAcct', action:'savecontigent'))
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',199,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',204,['tag':("breadcrumbs")],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('hiddenField','g',209,['id':("fromcreate"),'name':("fromcreate"),'value':("showcreate")],-1)
printHtmlPart(13)
})
invokeTag('form','g',210,['id':("myForm"),'name':("myForm"),'controller':("GlContAcct"),'action':("viewdetails"),'method':("post")],3)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthDate', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',213,['code':("customer.birthDate.label"),'default':("Transaction Date")],-1)
printHtmlPart(16)
invokeTag('customDatePicker','g',217,['name':("txnDate"),'value':(customerInstance?.txnDAte),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',228,['code':("customer.customerCode1.label"),'default':("Contigent Type")],-1)
printHtmlPart(19)
invokeTag('select','g',232,['id':("contigent"),'name':("contigent"),'from':(icbs.lov.ContigentAccount.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.customerCode1?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',245,['code':("creditAmt.label"),'default':("Credit Amount")],-1)
printHtmlPart(22)
invokeTag('textField','g',249,['name':("creditAmt"),'id':("creditAmt"),'onkeyup':("formatCreditNumber();"),'maxlength':("50"),'value':(customerInstance?.sssNo),'class':("form-control")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',262,['code':("debitAmt.label"),'default':("Debit Amount")],-1)
printHtmlPart(22)
invokeTag('textField','g',266,['name':("debitAmt"),'id':("debitAmt"),'maxlength':("50"),'onkeyup':("formatDebitNumber();"),'value':(customerInstance?.sssNo),'class':("form-control")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',276,['code':("reference.label"),'default':("Reference")],-1)
printHtmlPart(22)
invokeTag('textField','g',280,['name':("reference"),'id':("reference"),'maxlength':("50"),'value':(customerInstance?.sssNo),'class':("form-control")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',290,['code':("particulars.label"),'default':("Particulars")],-1)
printHtmlPart(22)
invokeTag('textArea','g',294,['name':("particulars"),'id':("particulars"),'value':(customerInstance),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',305,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',310,['action':("index")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',312,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',313,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128991L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
