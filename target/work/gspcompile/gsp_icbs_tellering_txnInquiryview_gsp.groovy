import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnInquiryview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnInquiry/view.gsp" }
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
invokeTag('javascript','g',57,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',58,[:],1)
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
createTagBody(3, {->
printHtmlPart(12)
invokeTag('textField','g',79,['name':("txnID"),'value':(""),'class':("form-control")],-1)
printHtmlPart(13)
})
invokeTag('form','g',83,['action':("show")],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('hiddenField','g',249,['name':("_format"),'value':("PDF")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',250,['name':("_name"),'value':("Teller Transaction Report")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',251,['name':("_file"),'value':("txn_inquiry")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',252,['name':("tid"),'value':(""),'id':("create_report_id")],-1)
printHtmlPart(16)
})
invokeTag('form','g',256,['action':("createReport")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',258,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',262,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',264,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129512L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
