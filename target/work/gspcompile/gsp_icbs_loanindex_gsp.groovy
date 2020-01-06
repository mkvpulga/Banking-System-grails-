import icbs.loans.Loan
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(title)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(module)
printHtmlPart(4)
})
invokeTag('javascript','g',18,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',36,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',39,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Loan Account No.")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',41,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',46,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(10)
})
invokeTag('form','g',47,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',53,['property':("id"),'title':(message(code: 'loan.id', default: 'ID'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',55,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Account No.'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',57,['property':("customer.displayName"),'title':(message(code: 'loan.customer.label', default: 'Customer'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',59,['property':("product.name"),'title':(message(code: 'loan.product.label', default: 'Product'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',61,['property':("amount"),'title':(message(code: 'loan.amount.label', default: 'Amount'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',63,['property':("openingDate"),'title':(message(code: 'loan.openingDate.label', default: 'Opening Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',65,['property':("glCode"),'title':(message(code: 'loan.glCode.label', default: 'GL Code'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',66,['property':("status"),'title':(message(code: 'loan.status.label', default: 'Status'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',67,['property':("balanceAmount"),'title':(message(code: 'loan.status.label', default: 'Balance'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',68,['property':("maturityDate"),'title':(message(code: 'loan.status.label', default: 'Maturity Date'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( loanInstance in (loanInstanceList) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
expressionOut.print(fieldValue(bean: loanInstance, field: "id"))
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(26)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(27)
expressionOut.print(loanInstance?.product?.name)
printHtmlPart(28)
invokeTag('formatNumber','g',85,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(29)
invokeTag('formatDate','g',87,['format':("MM/dd/yyyy"),'date':(loanInstance.dateApproved)],-1)
printHtmlPart(30)
expressionOut.print(loanInstance?.branch?.name)
printHtmlPart(31)
expressionOut.print(loanInstance?.glLink?.description)
printHtmlPart(32)
expressionOut.print(loanInstance?.status?.description)
printHtmlPart(33)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(30)
invokeTag('formatDate','g',92,['format':("MM/dd/yyyy"),'date':(loanInstance.maturityDate)],-1)
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',93,['class':("btn btn-secondary"),'controller':(module),'action':("show"),'id':(loanInstance.id)],4)
printHtmlPart(36)
i++
}
}
printHtmlPart(37)
invokeTag('paginate','g',101,['total':(LoanInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(39)
if(true && (UserMaster.get(session.user_id).designation?.id == 17)) {
printHtmlPart(40)
if(true && (module == 'loan')) {
printHtmlPart(41)
createTagBody(5, {->
invokeTag('message','g',109,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',109,['class':("create"),'action':("create")],5)
printHtmlPart(42)
}
printHtmlPart(43)
}
else {
printHtmlPart(44)
if(true && (module == 'loan')) {
printHtmlPart(45)
}
printHtmlPart(44)
}
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129057L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
