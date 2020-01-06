import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',4,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(accountsReceivableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',9,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',10,['bean':(accountsReceivableInstance),'field':("currency")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',13,['bean':(accountsReceivableInstance),'field':("currency")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',19,['name':("glContra"),'maxlength':("25"),'required':(""),'value':(accountsReceivableInstance?.glContra),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',24,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',25,['bean':(accountsReceivableInstance),'field':("glContra")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',28,['bean':(accountsReceivableInstance),'field':("glContra")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'receivableName', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',33,['name':("receivableName"),'maxlength':("100"),'required':(""),'value':(accountsReceivableInstance?.receivableName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',39,['bean':(accountsReceivableInstance),'field':("receivableName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',42,['bean':(accountsReceivableInstance),'field':("receivableName")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'description', 'has-error'))
printHtmlPart(11)
invokeTag('textField','g',48,['name':("description"),'maxlength':("100"),'required':(""),'value':(accountsReceivableInstance?.description),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',54,['bean':(accountsReceivableInstance),'field':("description")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',57,['bean':(accountsReceivableInstance),'field':("description")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'reference', 'has-error'))
printHtmlPart(12)
invokeTag('textField','g',63,['name':("reference"),'maxlength':("100"),'required':(""),'value':(accountsReceivableInstance?.reference),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',68,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',69,['bean':(accountsReceivableInstance),'field':("reference")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',72,['bean':(accountsReceivableInstance),'field':("reference")],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127879L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
