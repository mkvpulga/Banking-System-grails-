import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(ropaInstanceList)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
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
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 250px;"),'placeholder':("Search Account No or Borrower Name")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("id"),'title':(message(code: 'GlContigentAccount.id.label', default: 'ID'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("loan?.accountNo"),'title':(message(code: 'GlContigentAccount.id.label', default: 'Loan Account No'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("loan?.customer?.displayName"),'title':(message(code: 'GlContigentAccount.id.label', default: 'Borrower Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("ropaDate"),'title':(message(code: 'ropa.ropaDate.label', default: 'Date of Transfer'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',41,['property':("loanBalance"),'title':(message(code: 'ropa.loanBalance.label', default: 'Loan Balance'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( RopaInstance in (RopaInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(RopaInstance.id)
printHtmlPart(21)
expressionOut.print(RopaInstance.loan.accountNo)
printHtmlPart(22)
expressionOut.print(RopaInstance.acquiredFrom.displayName)
printHtmlPart(23)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(RopaInstance.ropaDate)],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(RopaInstance?.loanBalance)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 4)
invokeTag('link','g',58,['class':("btn btn-secondary"),'action':("show"),'id':(RopaInstance?.id)],4)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',67,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',74,['controller':("home"),'action':("landing")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',75,['action':("create")],3)
printHtmlPart(33)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',76,['action':("printRopaSchedule")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129341L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
