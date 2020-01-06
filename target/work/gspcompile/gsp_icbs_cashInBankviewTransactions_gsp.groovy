import icbs.gl.CashInBank
import icbs.gl.CashInBankLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/viewTransactions.gsp" }
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
invokeTag('render','g',13,['template':("cashInBankDetails")],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',24,['property':("txnDate"),'title':(message(code: 'cashInBankLedger.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',25,['property':("valueDate"),'title':(message(code: 'cashInBankLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',26,['property':("reference"),'title':(message(code: 'cashInBankLedger.reference.date', default: 'References'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',27,['property':("particulars"),'title':(message(code: 'cashInBankLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',28,['property':("debitAmt"),'title':(message(code: 'cashInBankLedger.debitAmt.label', default: 'Debit Amount'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',29,['property':("creditAmt"),'title':(message(code: 'cashInBankLedger.creditAmt.label', default: 'Credit Amount'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',30,['property':("balanceAmt"),'title':(message(code: 'cashInBankLedger.balanceAmt.label', default: 'Balance Amount'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',31,['property':("checkbook"),'title':(message(code: 'cashInBankLedger.checkbook.label', default: 'Checkbook'))],-1)
printHtmlPart(10)
loop:{
int i = 0
for( cashInBankLedgerInstance in (CashInBankLedger.findAllByCashInBank(cashInBankInstance)) ) {
printHtmlPart(11)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(12)
invokeTag('formatDate','g',37,['format':("MM/dd/yyyy"),'date':(cashInBankLedgerInstance?.txnDate)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',38,['format':("MM/dd/yyyy"),'date':(cashInBankLedgerInstance?.valueDate)],-1)
printHtmlPart(13)
expressionOut.print(cashInBankLedgerInstance?.reference)
printHtmlPart(13)
expressionOut.print(cashInBankLedgerInstance?.particulars)
printHtmlPart(14)
if(true && (cashInBankLedgerInstance?.debitAmt == 0)) {
printHtmlPart(15)
}
else {
printHtmlPart(16)
invokeTag('formatNumber','g',45,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.debitAmt)],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (cashInBankLedgerInstance?.creditAmt == 0)) {
printHtmlPart(15)
}
else {
printHtmlPart(18)
invokeTag('formatNumber','g',51,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.creditAmt)],-1)
printHtmlPart(14)
}
printHtmlPart(18)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.balanceAmt)],-1)
printHtmlPart(13)
expressionOut.print(cashInBankLedgerInstance?.checkbook)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',63,['total':(CashInBankInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',65,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',69,['action':("edit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',70,['action':("show"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',71,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127991L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
