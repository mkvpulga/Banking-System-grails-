import icbs.atm.AtmTxn
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'AtmTxn.label', default: 'ATM Interface'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',27,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
invokeTag('textField','g',31,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('submitButton','g',33,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(16)
})
invokeTag('form','g',35,['class':("form-inline")],3)
printHtmlPart(17)
invokeTag('sortableColumn','g',41,['property':("txnDate"),'title':(message(code: 'AtmTxn.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',42,['property':("mti"),'title':(message(code: 'AtmTxn.mti.label', default: 'MTI'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',43,['property':("acct1"),'title':(message(code: 'AtmTxn.acct1.label', default: 'Acct1'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',44,['property':("atmCardNumber"),'title':(message(code: 'AtmTxn.atmCardNumber.label', default: 'Atm Card Number'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',45,['property':("txnCode"),'title':(message(code: 'AtmTxn.txnCode.label', default: 'Txn Code'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',46,['property':("txnAmt"),'title':(message(code: 'AtmTxn.txnAmt.label', default: 'Txn Amt'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',47,['property':("txnRef"),'title':(message(code: 'AtmTxn.txnRef.label', default: 'Txn Ref'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( branchInstance in (atmTxnListInstance) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDate"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "mti"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "acct1"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "atmCardNumber"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnCode"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnAmt"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnRef"))
printHtmlPart(23)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',61,['class':("btn btn-primary"),'controller':("ATMInterface"),'action':("atmTxnDetails"),'id':(branchInstance.id),'params':(['atmtxnid': branchInstance.id])],4)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',68,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',74,['action':("atmTerminalView")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',75,['action':("viewAtmMsgRequest")],3)
printHtmlPart(31)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',76,['action':("viewAtmMsgResponse")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127899L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
