import icbs.gl.CashInBank
import icbs.gl.CashInBankCheckbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankcheckbookList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/checkbookList.gsp" }
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
invokeTag('render','g',12,['template':("cashInBankDetails")],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',20,['property':("checkNo"),'title':(message(code: 'CashInBankCheckbook.checkNo.label', default: 'Check Number'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',21,['property':("checkDate"),'title':(message(code: 'CashInBankCheckbook.checkDate.label', default: 'Check Date'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',22,['property':("payee"),'title':(message(code: 'CashInBankCheckbook.payee.label', default: 'Payee'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',23,['property':("checkAmt"),'title':(message(code: 'CashInBankCheckbook.checkAmt.date', default: 'Amount'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',24,['property':("checkStatus"),'title':(message(code: 'CashInBankCheckbook.checkStatus.label', default: 'Status'))],-1)
printHtmlPart(10)
loop:{
int i = 0
for( cbInstance in (CashInBankCheckbook.findAllByCashInBank(cashInBankInstance)) ) {
printHtmlPart(11)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(12)
expressionOut.print(cbInstance?.checkNo)
printHtmlPart(13)
invokeTag('formatDate','g',32,['format':("MM/dd/yyyy"),'date':(cbInstance?.checkDate)],-1)
printHtmlPart(13)
expressionOut.print(cbInstance?.payee)
printHtmlPart(13)
invokeTag('formatNumber','g',34,['format':("###,###,###,##0.00"),'number':(cbInstance?.checkAmt)],-1)
printHtmlPart(13)
expressionOut.print(cbInstance?.checkStatus)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',36,['class':("btn btn-secondary"),'action':("chkDetails"),'id':(cbInstance.id)],4)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',43,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',47,['action':("show"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',48,['action':("createCb"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(20)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',49,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(20)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',50,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',52,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127937L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
