import icbs.gl.AccountsPayable
import icbs.gl.AccountsPayableLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/viewTransactions.gsp" }
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
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(7)
expressionOut.print(accountsPayableInstance.payable)
printHtmlPart(8)
invokeTag('formatDate','g',25,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance?.dateCreated)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',29,['format':("###,###,##0.00"),'number':(accountsPayableInstance.balance)],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',43,['property':("refDate"),'title':(message(code: 'accountsPayableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',44,['property':("valueDate"),'title':(message(code: 'accountsPayableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',45,['property':("reference"),'title':(message(code: 'accountsPayableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',46,['property':("particulars"),'title':(message(code: 'accountsPayableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',47,['property':("debit"),'title':(message(code: 'accountsPayableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',48,['property':("credit"),'title':(message(code: 'accountsPayableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',49,['property':("balance"),'title':(message(code: 'accountsPayableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( accountsPayableLedgerInstance in (AccountsPayableLedger.findAllByAccountsPayable(accountsPayableInstance)) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
invokeTag('formatDate','g',55,['format':("MM/dd/yyyy"),'date':(accountsPayableLedgerInstance?.refDate)],-1)
printHtmlPart(16)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(accountsPayableLedgerInstance?.valueDate)],-1)
printHtmlPart(16)
expressionOut.print(accountsPayableLedgerInstance?.reference)
printHtmlPart(16)
expressionOut.print(accountsPayableLedgerInstance?.particulars)
printHtmlPart(17)
if(true && (accountsPayableLedgerInstance?.debit == 0)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
invokeTag('formatNumber','g',63,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.debit)],-1)
printHtmlPart(17)
}
printHtmlPart(20)
if(true && (accountsPayableLedgerInstance?.credit == 0)) {
printHtmlPart(18)
}
else {
printHtmlPart(21)
invokeTag('formatNumber','g',69,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.credit)],-1)
printHtmlPart(17)
}
printHtmlPart(21)
invokeTag('formatNumber','g',71,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.balance)],-1)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',80,['total':(accountsPayableLedgerInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',86,['action':("edit"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',87,['action':("show"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',88,['action':("index"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127877L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
