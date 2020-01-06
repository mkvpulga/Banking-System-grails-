import icbs.gl.GlContigentAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'ContigentAccount.label', default: 'Contigent Account'))],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',12,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('select','g',29,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(14)
invokeTag('textField','g',33,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('submitButton','g',35,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(17)
})
invokeTag('form','g',37,['class':("form-inline")],3)
printHtmlPart(18)
invokeTag('sortableColumn','g',44,['property':("id"),'title':(message(code: 'GlContigentAccount.id.label', default: 'ID'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',46,['property':("txnDate"),'title':(message(code: 'GlContigentAccount.txnDate.label', default: 'Transaction Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',48,['property':("contigentId"),'title':(message(code: 'GlContigentAccount.contigentId.label', default: 'Contigent Type'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',50,['property':("creditAmt"),'title':(message(code: 'GlContigentAccount.creditAmt.label', default: 'Credit Amount'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',52,['property':("debitAmt"),'title':(message(code: 'GlContigentAccount.debitAmt.label', default: 'Debit Amount'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',53,['property':("reference"),'title':(message(code: 'GlContigentAccount.reference.label', default: 'Reference'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',54,['property':("particulars"),'title':(message(code: 'GlContigentAccount.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(23)
loop:{
int i = 0
for( ContigentInstance in (GlContigentAccountList) ) {
printHtmlPart(24)
if(true && (ContigentInstance?.status?.description=='Active')) {
printHtmlPart(25)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(26)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "id"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "txnDate"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "contigent"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "creditAmt"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "debitAmt"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "reference"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "particulars"))
printHtmlPart(29)
createClosureForHtmlPart(30, 5)
invokeTag('link','g',76,['class':("btn btn-secondary"),'controller':("GlContAcct"),'action':("viewdetails"),'id':(ContigentInstance.id)],5)
printHtmlPart(31)
}
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
invokeTag('paginate','g',86,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',89,['tag':("main-content")],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',93,['action':("createcontigent")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128992L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
