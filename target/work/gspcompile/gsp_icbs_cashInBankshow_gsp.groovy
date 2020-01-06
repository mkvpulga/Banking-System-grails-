import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(cashInBankInstance?.branch?.name)
printHtmlPart(11)
expressionOut.print(cashInBankInstance?.type?.description)
printHtmlPart(12)
expressionOut.print(cashInBankInstance?.currency?.code)
printHtmlPart(13)
expressionOut.print(cashInBankInstance?.bankName)
printHtmlPart(14)
expressionOut.print(cashInBankInstance?.bankBranch)
printHtmlPart(15)
expressionOut.print(cashInBankInstance?.bankAddress)
printHtmlPart(16)
expressionOut.print(cashInBankInstance?.acctNo)
printHtmlPart(17)
invokeTag('formatNumber','g',57,['format':("##0.00000"),'number':(cashInBankInstance?.intRate)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',61,['format':("###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.openDate)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',69,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.maturityDate)],-1)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.user?.name)
printHtmlPart(22)
invokeTag('formatDate','g',77,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.createDate)],-1)
printHtmlPart(23)
expressionOut.print(cashInBankInstance?.glContra)
printHtmlPart(24)
expressionOut.print(cashInBankInstance?.status?.description)
printHtmlPart(25)
expressionOut.print(cashInBankInstance?.remarks)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',94,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',98,['action':("edit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',99,['action':("viewTransactions"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(32)
if(true && (cashInBankInstance.type.id == 2)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 4)
invokeTag('link','g',101,['action':("createCb"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(35)
createClosureForHtmlPart(36, 4)
invokeTag('link','g',102,['action':("checkbookList"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('link','g',103,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(32)
}
else {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',106,['action':("cashWithdrawal"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(32)
}
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',108,['action':("cashAndCheckDeposit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',109,['action':("cibDebit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',110,['action':("creditAdjustment"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',111,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(30)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',112,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',114,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',115,[:],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127990L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
