import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashWithdrawalcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashWithdrawal/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(5)
invokeTag('javascript','asset',13,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',14,['src':("checkPassbookBal.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(9)
})
invokeTag('javascript','g',74,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',75,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(16)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(17)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(18)
if(true && (signatory.status.id!=3)) {
printHtmlPart(19)
invokeTag('render','g',130,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(18)
}
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(23)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(24)
if(true && (flash.message)) {
printHtmlPart(25)
expressionOut.print(flash.message)
printHtmlPart(26)
invokeTag('img','g',178,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(27)
invokeTag('img','g',186,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(28)
invokeTag('img','g',206,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(29)
expressionOut.print(passbookline)
printHtmlPart(30)
expressionOut.print(id)
printHtmlPart(31)
expressionOut.print(jrxmlTcId)
printHtmlPart(32)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
expressionOut.print(it)
printHtmlPart(35)
createTagBody(4, {->
printHtmlPart(36)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(37)
expressionOut.print(error.field)
printHtmlPart(38)
}
printHtmlPart(39)
invokeTag('message','g',234,['error':(error)],-1)
printHtmlPart(40)
})
invokeTag('eachError','g',235,['bean':(txnCashWithdrawalInstance),'var':("error")],4)
printHtmlPart(41)
})
invokeTag('hasErrors','g',239,['bean':(txnCashWithdrawalInstance)],3)
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(42)
invokeTag('render','g',243,['template':("txnCashWithdrawal/form"),'model':([txnCashWithdrawalInstance:txnCashWithdrawalInstance])],-1)
printHtmlPart(43)
})
invokeTag('form','g',245,['name':("txnCashWithdrawalForm"),'action':("saveTellerCashWithdrawalTxn"),'controller':("tellering")],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',247,['tag':("main-content")],2)
printHtmlPart(45)
createClosureForHtmlPart(46, 2)
invokeTag('jasperReport','g',251,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('link','g',257,['action':("index")],3)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',331,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',332,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129471L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
