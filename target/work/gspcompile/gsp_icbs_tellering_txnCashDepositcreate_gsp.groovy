import icbs.admin.TxnTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashDepositcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashDeposit/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(6)
invokeTag('javascript','asset',13,['src':("checkPassbookBal.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("telleringHelper.js")],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit", module:"deposit" ]))
printHtmlPart(10)
})
invokeTag('javascript','g',40,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(13)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(14)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(17)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(18)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(19)
if(true && (signatory.status.id!=3)) {
printHtmlPart(20)
invokeTag('render','g',96,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(19)
}
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(24)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(25)
if(true && (flash.message)) {
printHtmlPart(26)
expressionOut.print(flash.message)
printHtmlPart(27)
invokeTag('img','g',144,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(28)
invokeTag('img','g',152,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(29)
invokeTag('img','g',172,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(30)
expressionOut.print(passbookline)
printHtmlPart(31)
expressionOut.print(id)
printHtmlPart(32)
expressionOut.print(jrxmlTcId)
printHtmlPart(33)
}
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
expressionOut.print(it)
printHtmlPart(36)
})
invokeTag('hasErrors','g',192,['bean':(txnCashDepositInstance)],3)
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(37)
invokeTag('render','g',196,['template':("txnCashDeposit/form"),'model':([txnCashDepositInstance:txnCashDepositInstance])],-1)
printHtmlPart(38)
})
invokeTag('form','g',198,['name':("txnCashDepositForm"),'action':("saveTellerCashDepositTxn"),'controller':("tellering")],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',200,['tag':("main-content")],2)
printHtmlPart(40)
createClosureForHtmlPart(41, 2)
invokeTag('jasperReport','g',204,['action':("printPassbookTransactions"),'controller':("tellering"),'format':("PDF"),'name':("Passbook"),'jasper':("Transaction")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(42)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',262,['action':("index")],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',264,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129431L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
