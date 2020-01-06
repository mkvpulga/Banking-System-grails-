import icbs.gl.BillsPayable
import icbs.gl.BillsPayableLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/viewTransactions.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(7)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(8)
expressionOut.print(billsPayableInstance?.branch?.name)
printHtmlPart(9)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(10)
invokeTag('formatDate','g',28,['format':("MM/dd/yyyy"),'date':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',32,['format':("###,###,##0.00"),'number':(billsPayableInstance?.principal)],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',46,['property':("refDate"),'title':(message(code: 'billsPayableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',47,['property':("valueDate"),'title':(message(code: 'billsPayableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',48,['property':("reference"),'title':(message(code: 'billsPayableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',49,['property':("particulars"),'title':(message(code: 'billsPayableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',50,['property':("debit"),'title':(message(code: 'billsPayableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',51,['property':("credit"),'title':(message(code: 'billsPayableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',52,['property':("balance"),'title':(message(code: 'billsPayableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( billsPayableLedgerInstance in (BillsPayableLedger.findAllByBillsPayable(billsPayableInstance)) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
invokeTag('formatDate','g',58,['format':("MM/dd/yyyy"),'date':(billsPayableLedgerInstance?.refDate)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(billsPayableLedgerInstance?.valueDate)],-1)
printHtmlPart(18)
expressionOut.print(billsPayableLedgerInstance?.reference)
printHtmlPart(18)
expressionOut.print(billsPayableLedgerInstance?.particulars)
printHtmlPart(19)
if(true && (billsPayableLedgerInstance?.debit == 0)) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
invokeTag('formatNumber','g',66,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.debit)],-1)
printHtmlPart(19)
}
printHtmlPart(22)
if(true && (billsPayableLedgerInstance?.credit == 0)) {
printHtmlPart(20)
}
else {
printHtmlPart(23)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.credit)],-1)
printHtmlPart(19)
}
printHtmlPart(23)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.balance)],-1)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',83,['total':(billsPayableLedgerInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',89,['action':("edit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',90,['action':("show"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',91,['action':("index"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127923L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
