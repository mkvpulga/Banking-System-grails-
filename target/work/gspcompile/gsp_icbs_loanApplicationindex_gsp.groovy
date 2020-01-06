import icbs.loans.LoanApplication
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/index.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',27,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',30,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Loan Application ID")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',32,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(13)
})
invokeTag('form','g',37,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',43,['property':("id"),'title':(message(code: 'loanApplication.id', default: 'Application ID'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',45,['property':("customer.displayName"),'title':(message(code: 'loanApplication.customer.label', default: 'Customer'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',47,['property':("product.name"),'title':(message(code: 'loanApplication.product.label', default: 'Product'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',49,['property':("amount"),'title':(message(code: 'loanApplication.amount.label', default: 'Amount'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',51,['property':("applicationDate"),'defaultOrder':("desc"),'title':(message(code: 'loanApplication.applicationDate.label', default: 'Application Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',53,['property':("approvalStatus"),'title':(message(code: 'loanApplication.approvalStatus.label', default: 'Status'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( loanApplicationInstance in (loanApplicationInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
invokeTag('formatNumber','g',63,['format':("#"),'groupingUsed':("true"),'number':(fieldValue(bean: loanApplicationInstance, field: "id"))],-1)
printHtmlPart(23)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(24)
expressionOut.print(loanApplicationInstance?.product?.name)
printHtmlPart(25)
invokeTag('formatNumber','g',69,['format':("###,##0.00"),'number':(loanApplicationInstance?.amount)],-1)
printHtmlPart(26)
invokeTag('formatDate','g',70,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(27)
expressionOut.print(loanApplicationInstance?.approvalStatus)
printHtmlPart(28)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',74,['class':("btn btn-secondary"),'action':("show"),'id':(loanApplicationInstance.id)],4)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',82,['total':(LoanApplicationInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(33)
if(true && (UserMaster.get(session.user_id).designation?.id == 17)) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',90,['class':("create"),'action':("create")],4)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129185L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
