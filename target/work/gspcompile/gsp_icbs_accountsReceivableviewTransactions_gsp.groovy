import icbs.gl.AccountsReceivable
import icbs.gl.AccountsReceivableLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/viewTransactions.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(10)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(11)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(12)
invokeTag('formatNumber','g',41,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',58,['property':("refDate"),'title':(message(code: 'accountsReceivableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',59,['property':("valueDate"),'title':(message(code: 'accountsReceivableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',60,['property':("reference"),'title':(message(code: 'accountsReceivableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',61,['property':("particulars"),'title':(message(code: 'accountsReceivableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',62,['property':("debit"),'title':(message(code: 'accountsReceivableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',63,['property':("credit"),'title':(message(code: 'accountsReceivableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',64,['property':("balance"),'title':(message(code: 'accountsReceivableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( accountsReceivableLedgerInstance in (AccountsReceivableLedger.findAllByAccountsReceivable(accountsReceivableInstance)) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
invokeTag('formatDate','g',70,['format':("MM/dd/yyyy"),'date':(accountsReceivableLedgerInstance?.refDate)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',71,['format':("MM/dd/yyyy"),'date':(accountsReceivableLedgerInstance?.valueDate)],-1)
printHtmlPart(19)
expressionOut.print(accountsReceivableLedgerInstance?.reference)
printHtmlPart(19)
expressionOut.print(accountsReceivableLedgerInstance?.particulars)
printHtmlPart(20)
if(true && (accountsReceivableLedgerInstance?.debit == 0)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.debit)],-1)
printHtmlPart(20)
}
printHtmlPart(23)
if(true && (accountsReceivableLedgerInstance?.credit == 0)) {
printHtmlPart(21)
}
else {
printHtmlPart(24)
invokeTag('formatNumber','g',84,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.credit)],-1)
printHtmlPart(20)
}
printHtmlPart(24)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.balance)],-1)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',95,['total':(accountsReceivableInstanceCount?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',101,['action':("edit"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',102,['action':("show"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(31)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',103,['action':("index"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',105,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127884L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
