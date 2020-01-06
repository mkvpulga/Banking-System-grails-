import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringreverseTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/reverseTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(reverseTransactionFileInstance?.id)
printHtmlPart(7)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(reverseTransactionFileInstance?.txnDate)],-1)
printHtmlPart(8)
invokeTag('fieldValue','g',31,['bean':(reverseTransactionFileInstance),'field':("txnType.description")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',35,['bean':(reverseTransactionFileInstance),'field':("acctNo")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',39,['bean':(reverseTransactionFileInstance),'field':("branch.name")],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',43,['format':("###,###,##0.00"),'number':(reverseTransactionFileInstance?.txnAmt)],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',48,['bean':(reverseTransactionFileInstance),'field':("txnCode")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',52,['bean':(reverseTransactionFileInstance),'field':("txnTemplate.description")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',56,['bean':(reverseTransactionFileInstance),'field':("txnDescription")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',60,['bean':(reverseTransactionFileInstance),'field':("txnRef")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',64,['bean':(reverseTransactionFileInstance),'field':("txnParticulars")],-1)
printHtmlPart(17)
expressionOut.print(getRefereceAndParticularsReverseInstance.txnParticulars.toString().replace("[", "").replace("]", ""))
printHtmlPart(18)
expressionOut.print(getRefereceAndParticularsReverseInstance.txnReference.toString().replace("[", "").replace("]", ""))
printHtmlPart(19)
invokeTag('fieldValue','g',76,['bean':(reverseTransactionFileInstance),'field':("status.description")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',80,['bean':(reverseTransactionFileInstance),'field':("user.username")],-1)
printHtmlPart(21)
expressionOut.print(g.createLink(controller: 'tellering', action: 'newTransactionReversalPrintValidation', params: [txnFile:reverseTransactionFileInstance.id]))
printHtmlPart(22)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(20).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(20).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(20).reportUnit)
printHtmlPart(25)
expressionOut.print(reverseTransactionFileInstance.id)
printHtmlPart(26)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(27)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(62).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(62).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(62).reportUnit)
printHtmlPart(28)
expressionOut.print(reverseTransactionFileInstance.id)
printHtmlPart(26)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(29)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printTransactionSlip', params: [txnFile:reverseTransactionFileInstance.id]))
printHtmlPart(30)
invokeTag('img','g',122,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(31)
expressionOut.print(passbookline)
printHtmlPart(32)
expressionOut.print(id)
printHtmlPart(33)
expressionOut.print(jrxmlTcId)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',130,['tag':("main-content")],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(37)
invokeTag('message','g',134,['code':("default.home.label")],-1)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',136,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',137,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129417L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
