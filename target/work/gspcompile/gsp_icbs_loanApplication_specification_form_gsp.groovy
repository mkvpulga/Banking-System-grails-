import icbs.lov.ProductType
import icbs.loans.LoanApplication
import icbs.cif.Customer
import icbs.lov.ConfigItemStatus
import icbs.loans.GroupRecord
import icbs.lov.LoanSecurity
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_specification_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/specification/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'customer', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',12,['code':("loanApplication.customer.label"),'default':("Customer ID")],-1)
printHtmlPart(3)
invokeTag('field','g',15,['name':("customer-name"),'value':(loanApplicationInstance?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',16,['id':("customer"),'name':("customer.id"),'value':(loanApplicationInstance?.customer?.id)],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(it)
printHtmlPart(7)
})
invokeTag('hasErrors','g',20,['bean':(loanApplicationInstance),'field':("customer")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'product', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',67,['code':("loanApplication.product.label"),'default':("Product")],-1)
printHtmlPart(10)
if(true && (loanApplicationInstance)) {
printHtmlPart(11)
invokeTag('select','g',77,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAllWhere(productType:ProductType.get(6),configItemStatus:ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'value':(loanApplicationInstance?.product?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(11)
invokeTag('select','g',80,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAllWhere(productType:ProductType.get(6),configItemStatus:ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'value':(loanApplicationInstance?.product?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',87,['bean':(loanApplicationInstance),'field':("product")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'amount', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',94,['code':("loanApplication.amount.label"),'default':("Amount")],-1)
printHtmlPart(18)
invokeTag('field','g',99,['name':("amount"),'value':(fieldValue(bean: loanApplicationInstance, field: 'amount')),'class':("form-control truncated")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',105,['bean':(loanApplicationInstance),'field':("amount")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'term', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',110,['code':("loanApplication.term.label"),'default':("Term")],-1)
printHtmlPart(18)
invokeTag('field','g',116,['name':("term"),'type':("number"),'value':(loanApplicationInstance.term),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(23)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',120,['bean':(loanApplicationInstance),'field':("term")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'purpose', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',125,['code':("loanApplication.purpose.label"),'default':("Purpose")],-1)
printHtmlPart(18)
invokeTag('textArea','g',130,['name':("purpose"),'value':(loanApplicationInstance?.purpose),'rows':("3"),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(23)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',139,['bean':(loanApplicationInstance),'field':("purpose")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'accountOfficer', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',146,['code':("loanApplication.accountOfficer.label"),'default':("Account Officer")],-1)
printHtmlPart(26)
invokeTag('select','g',155,['onchange':("getInfoselect();"),'id':("group_record"),'name':("accountOfficer"),'from':(icbs.loans.GroupRecord.findAll()),'optionKey':("id"),'optionValue':("name"),'value':(loanApplicationInstance?.accountOfficer),'class':("many-to-one form-control")],-1)
printHtmlPart(27)
invokeTag('select','g',159,['id':("accountOfficer"),'name':("accountOfficer.id"),'from':(icbs.loans.GroupRecord.findAllByParentIsNull()),'optionKey':("id"),'optionValue':("name"),'value':(loanApplicationInstance?.accountOfficer?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('hasErrors','g',174,['bean':(loanApplicationInstance),'field':("accountOfficer")],1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'applicationDate', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',181,['code':("loanApplication.applicationDate.label"),'default':(" ")],-1)
printHtmlPart(32)
invokeTag('customDatePicker','g',185,['name':("applicationDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(33)
createTagBody(1, {->
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
invokeTag('message','g',194,['error':(it)],-1)
printHtmlPart(36)
})
invokeTag('eachError','g',194,['bean':(loanApplicationInstance),'field':("applicationDate")],2)
printHtmlPart(37)
})
invokeTag('hasErrors','g',195,['bean':(loanApplicationInstance),'field':("applicationDate")],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129198L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
