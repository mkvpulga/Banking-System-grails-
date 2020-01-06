import icbs.gl.GlContigentAccount
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctviewDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/viewDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller:'GlContAcct', action:'removeContigentAccountAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',51,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
for( ContigentAccountInstance in (GlContigentAccountList) ) {
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('hiddenField','g',60,['id':("idcontigent"),'name':("id"),'value':(ContigentAccountInstance.id)],-1)
printHtmlPart(14)
invokeTag('message','g',62,['code':("atmTerminalInstance.branch.label"),'default':("ID: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "id"))
printHtmlPart(16)
invokeTag('message','g',66,['code':("atmTerminalInstance.branch.label"),'default':("Transaction Date: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "txnDate"))
printHtmlPart(17)
invokeTag('message','g',70,['code':("atmTerminalInstance.branch.label"),'default':("Contigent Type: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "contigent"))
printHtmlPart(18)
invokeTag('message','g',74,['code':("atmTerminalInstance.branch.label"),'default':("Credit Amount: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "creditAmt"))
printHtmlPart(19)
invokeTag('message','g',78,['code':("atmTerminalInstance.branch.label"),'default':("Debit Amount: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "debitAmt"))
printHtmlPart(19)
invokeTag('message','g',82,['code':("atmTerminalInstance.branch.label"),'default':("Reference: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "reference"))
printHtmlPart(19)
invokeTag('message','g',86,['code':("atmTerminalInstance.branch.label"),'default':("Particulars: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "particulars"))
printHtmlPart(19)
invokeTag('message','g',90,['code':("atmTerminalInstance.branch.label"),'default':("Status: ")],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: ContigentAccountInstance, field: "status"))
printHtmlPart(19)
invokeTag('message','g',94,['code':("atmTerminalInstance.branch.label"),'default':("Created By: ")],-1)
printHtmlPart(15)
expressionOut.print(ContigentAccountInstance?.createdByUser?.username)
printHtmlPart(20)
invokeTag('message','g',99,['code':("atmTerminalInstance.branch.label"),'default':("Branch: ")],-1)
printHtmlPart(15)
expressionOut.print(ContigentAccountInstance?.branch?.name)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',112,['tag':("main-content")],3)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
createTagBody(4, {->
invokeTag('message','g',119,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',119,['class':("create"),'action':("create")],4)
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',121,['contoller':("GlContAcct"),'action':("updatecontAcct"),'params':(['id': ContigentAccountInstance.id])],4)
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',124,['action':("createcontigent")],4)
printHtmlPart(28)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',125,['contoller':("GlContAcct"),'action':("index")],4)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-actions")],3)
printHtmlPart(31)
}
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128995L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
