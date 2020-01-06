import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposalindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
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
invokeTag('select','g',26,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',29,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Loan Application ID")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(13)
})
invokeTag('form','g',36,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',42,['property':("id"),'title':(message(code: 'loanApplication.id', default: 'ID'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',44,['property':("customer.displayName"),'title':(message(code: 'loanApplication.customer.label', default: 'Customer'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',46,['property':("product.name"),'title':(message(code: 'loanApplication.product.label', default: 'Product'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',48,['property':("branch.name"),'title':(message(code: 'loanApplication.branch.label', default: 'Branch'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',49,['property':("amount"),'title':(message(code: 'loanApplication.amount.label', default: 'Amount'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',51,['property':("term"),'title':(message(code: 'loanApplication.term.label', default: 'Term'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',53,['property':("applicationDate"),'title':(message(code: 'loanApplication.applicationDate.label', default: 'Application Date'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( loanApplicationInstance in (loanApplicationInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(fieldValue(bean: loanApplicationInstance, field: "id"))
printHtmlPart(22)
expressionOut.print(loanApplicationInstance.customer.displayName)
printHtmlPart(23)
expressionOut.print(loanApplicationInstance.product.name)
printHtmlPart(23)
expressionOut.print(loanApplicationInstance.branch.name)
printHtmlPart(24)
expressionOut.print(fieldValue(bean: loanApplicationInstance, field: "amount"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: loanApplicationInstance, field: "term"))
printHtmlPart(22)
invokeTag('formatDate','g',75,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance.applicationDate)],-1)
printHtmlPart(23)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',77,['class':("btn btn-secondary"),'action':("createTemplate"),'id':(loanApplicationInstance.id)],4)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',85,['total':(LoanApplicationInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-content")],2)
printHtmlPart(5)
createClosureForHtmlPart(29, 2)
invokeTag('captureContent','sitemesh',92,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129242L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
