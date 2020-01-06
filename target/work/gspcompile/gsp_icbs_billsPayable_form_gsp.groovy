import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',4,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(billsPayableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',9,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',10,['bean':(billsPayableInstance),'field':("currency")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',13,['bean':(billsPayableInstance),'field':("currency")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'glContra', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',19,['name':("glContra"),'maxlength':("25"),'required':(""),'value':(billsPayableInstance?.glContra),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',24,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',25,['bean':(billsPayableInstance),'field':("glContra")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',28,['bean':(billsPayableInstance),'field':("glContra")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'creditorName', 'has-error'))
printHtmlPart(9)
invokeTag('textField','g',34,['name':("creditorName"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.creditorName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',39,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',40,['bean':(billsPayableInstance),'field':("creditorName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',43,['bean':(billsPayableInstance),'field':("creditorName")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'dateOpened', 'has-error'))
printHtmlPart(11)
invokeTag('customDatePicker','g',54,['name':("dateOpened"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',60,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',61,['bean':(billsPayableInstance),'field':("dateOpened")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',64,['bean':(billsPayableInstance),'field':("dateOpened")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'dueDate', 'has-error'))
printHtmlPart(13)
invokeTag('customDatePicker','g',74,['name':("dueDate"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.dueDate)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',80,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',81,['bean':(billsPayableInstance),'field':("dueDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',84,['bean':(billsPayableInstance),'field':("dueDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pnDate', 'has-error'))
printHtmlPart(14)
invokeTag('customDatePicker','g',94,['name':("pnDate"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.pnDate)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',100,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',101,['bean':(billsPayableInstance),'field':("pnDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',104,['bean':(billsPayableInstance),'field':("pnDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pnNo', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',110,['name':("pnNo"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.pnNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',115,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',116,['bean':(billsPayableInstance),'field':("pnNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',119,['bean':(billsPayableInstance),'field':("pnNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pdcIssuedText', 'has-error'))
printHtmlPart(16)
invokeTag('textField','g',125,['name':("pdcIssuedText"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.pdcIssuedText),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',130,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',131,['bean':(billsPayableInstance),'field':("pdcIssuedText")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',134,['bean':(billsPayableInstance),'field':("pdcIssuedText")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'accountName', 'has-error'))
printHtmlPart(17)
invokeTag('textField','g',140,['name':("accountName"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.accountName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',145,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',146,['bean':(billsPayableInstance),'field':("accountName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',149,['bean':(billsPayableInstance),'field':("accountName")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'payee', 'has-error'))
printHtmlPart(18)
invokeTag('textField','g',155,['name':("payee"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.payee),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',160,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',161,['bean':(billsPayableInstance),'field':("payee")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',164,['bean':(billsPayableInstance),'field':("payee")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'interestRate', 'has-error'))
printHtmlPart(19)
invokeTag('field','g',172,['class':("form-control"),'type':("number"),'name':("interestRate"),'value':(billsPayableInstance?.interestRate)],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',177,['error':(it?.code)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',178,['bean':(billsPayableInstance),'field':("interestRate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',181,['bean':(billsPayableInstance),'field':("interestRate")],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127912L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
