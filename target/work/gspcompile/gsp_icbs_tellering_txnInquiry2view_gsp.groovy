import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnInquiry2view_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnInquiry2/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'tellering', action:'showTxnAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'tellering', action:'search'))
printHtmlPart(6)
})
invokeTag('javascript','g',47,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(txnFileInstance.txnType.description)
printHtmlPart(12)
expressionOut.print(txnTemplateInstance.acctNo)
printHtmlPart(13)
expressionOut.print(txnTemplateInstance.branch.name)
printHtmlPart(14)
expressionOut.print(txnFileInstance.txnDate)
printHtmlPart(15)
expressionOut.print(txnFileInstance.txnAmt)
printHtmlPart(16)
expressionOut.print(txnFileInstance.txnCode)
printHtmlPart(17)
expressionOut.print(txnFileInstance.txnTemplate.description)
printHtmlPart(18)
expressionOut.print(txnFileInstance.txnRef)
printHtmlPart(19)
expressionOut.print(txnFileInstance.txnParticulars)
printHtmlPart(20)
expressionOut.print(txnFileInstance.status.description)
printHtmlPart(21)
expressionOut.print(txnFileInstance.user.userName)
printHtmlPart(22)
if(true && (senderInstance)) {
printHtmlPart(23)
expressionOut.print(senderInstance.displayName)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (senderInstance)) {
printHtmlPart(23)
expressionOut.print(senderInstance.birthDate)
printHtmlPart(24)
}
printHtmlPart(26)
invokeTag('set','g',159,['var':("address"),'value':(senderInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(24)
if(true && (address)) {
printHtmlPart(23)
expressionOut.print(address?.address1)
printHtmlPart(27)
expressionOut.print(address?.address2)
printHtmlPart(27)
expressionOut.print(address?.address3)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
invokeTag('set','g',167,['var':("address"),'value':(senderInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(24)
if(true && (address)) {
printHtmlPart(23)
expressionOut.print(address?.address1)
printHtmlPart(27)
expressionOut.print(address?.address2)
printHtmlPart(27)
expressionOut.print(address?.address3)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && ((senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(31)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (beneficiaryInstance)) {
printHtmlPart(23)
expressionOut.print(beneficiaryInstance.displayName)
printHtmlPart(24)
}
printHtmlPart(34)
if(true && (beneficiaryInstance)) {
printHtmlPart(23)
expressionOut.print(beneficiaryInstance.birthDate)
printHtmlPart(24)
}
printHtmlPart(35)
invokeTag('set','g',213,['var':("address"),'value':(beneficiaryInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(24)
if(true && (address)) {
printHtmlPart(23)
expressionOut.print(address?.address1)
printHtmlPart(27)
expressionOut.print(address?.address2)
printHtmlPart(27)
expressionOut.print(address?.address3)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(36)
if(true && ((beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(31)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(32)
}
printHtmlPart(37)
expressionOut.print(indicator)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',277,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',281,['onclick':("createReport")],3)
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',282,['action':("takeAction"),'params':([isApproved:true, txnFileInstanceId:txnFileInstance.id])],3)
printHtmlPart(41)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',283,['action':("takeAction"),'params':([isApproved:false]),'resource':(txnFileInstance)],3)
printHtmlPart(41)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',284,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',286,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',287,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129514L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
