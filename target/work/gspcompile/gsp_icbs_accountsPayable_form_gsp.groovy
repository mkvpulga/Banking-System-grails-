import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',4,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(accountsPayableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',9,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',10,['bean':(accountsPayableInstance),'field':("currency")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',13,['bean':(accountsPayableInstance),'field':("currency")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'glContra', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',19,['name':("glContra"),'maxlength':("25"),'required':(""),'value':(accountsPayableInstance?.glContra),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',24,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',25,['bean':(accountsPayableInstance),'field':("glContra")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',28,['bean':(accountsPayableInstance),'field':("glContra")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'payable', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',33,['name':("payable"),'maxlength':("100"),'required':(""),'value':(accountsPayableInstance?.payable),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',39,['bean':(accountsPayableInstance),'field':("payable")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',42,['bean':(accountsReceivableInstance),'field':("payable")],1)
printHtmlPart(11)
invokeTag('hiddenField','g',46,['name':("accountsPayableId"),'id':("accountsPayableId"),'value':(params.id)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'particulars', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',50,['name':("particulars"),'maxlength':("200"),'required':(""),'value':(accountsPayableInstance?.particulars),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',56,['bean':(accountsPayableInstance),'field':("particulars")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',59,['bean':(accountsPayableInstance),'field':("particulars")],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127870L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
