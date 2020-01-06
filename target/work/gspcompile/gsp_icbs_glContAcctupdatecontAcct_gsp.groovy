import icbs.gl.GlContigentAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctupdatecontAcct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/updatecontAcct.gsp" }
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
expressionOut.print(createLink(controller:'GlContAcct', action:'updatecontAcctajax'))
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',189,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',194,['tag':("breadcrumbs")],2)
printHtmlPart(11)
for( ContigentAccountInstance in (GlContAccts) ) {
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(8)
invokeTag('hiddenField','g',201,['id':("id"),'name':("id"),'value':(ContigentAccountInstance?.id)],-1)
printHtmlPart(14)
})
invokeTag('form','g',202,['id':("myForm"),'name':("myForm"),'controller':("GlContAcct"),'action':("viewdetails"),'params':(['ids': ContigentAccountInstance?.id]),'method':("post")],4)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',205,['code':("customer.customerCode1.label"),'default':("Contigent Type")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',208,['id':("idcontigent"),'name':("idcontigent"),'value':(ContigentAccountInstance?.id)],-1)
printHtmlPart(18)
invokeTag('select','g',210,['id':("contigent"),'name':("contigent"),'from':(icbs.lov.ContigentAccount.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(ContigentAccountInstance?.contigent?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',223,['code':("creditAmt.label"),'default':("Credit Amount")],-1)
printHtmlPart(21)
invokeTag('textField','g',227,['name':("creditAmt"),'id':("creditAmt"),'onkeyup':("formatCreditNumber();"),'maxlength':("50"),'value':(ContigentAccountInstance.creditAmt),'class':("form-control")],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',240,['code':("debitAmt.label"),'default':("Debit Amount")],-1)
printHtmlPart(21)
invokeTag('textField','g',244,['name':("debitAmt"),'id':("debitAmt"),'maxlength':("50"),'onkeyup':("formatDebitNumber();"),'value':(ContigentAccountInstance.debitAmt),'class':("form-control")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',254,['code':("reference.label"),'default':("Reference")],-1)
printHtmlPart(21)
invokeTag('textField','g',258,['name':("reference"),'id':("reference"),'value':(ContigentAccountInstance.reference),'class':("form-control")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',269,['code':("particulars.label"),'default':("Particulars")],-1)
printHtmlPart(21)
invokeTag('textArea','g',273,['name':("particulars"),'id':("particulars"),'value':(ContigentAccountInstance.particulars),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthDate', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',285,['code':("customer.birthDate.label"),'default':("Transaction Date")],-1)
printHtmlPart(27)
invokeTag('customDatePicker','g',289,['name':("txnDate"),'value':(ContigentAccountInstance?.txnDate),'class':("form-control")],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',298,['tag':("main-content")],3)
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',303,['action':("index")],4)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',305,['tag':("main-actions")],3)
printHtmlPart(33)
}
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',307,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128993L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
