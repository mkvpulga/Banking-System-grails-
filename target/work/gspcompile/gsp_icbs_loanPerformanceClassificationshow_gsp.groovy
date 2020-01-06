import icbs.lov.LoanFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanPerformanceClassificationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanPerformanceClassification/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'loanPerformanceClassification.label', default: 'LoanPerformanceClassification'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('message','g',35,['code':("loanPerformanceClassification.code.label"),'default':("Code")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',36,['bean':(loanPerformanceClassificationInstance),'field':("code")],-1)
printHtmlPart(11)
invokeTag('message','g',40,['code':("loanPerformanceClassification.name.label"),'default':("Name")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',41,['bean':(loanPerformanceClassificationInstance),'field':("name")],-1)
printHtmlPart(11)
invokeTag('message','g',45,['code':("loanPerformanceClassification.prevClassification.label"),'default':("Previous Classification")],-1)
printHtmlPart(10)
expressionOut.print(loanPerformanceClassificationInstance?.prevClassification?.description)
printHtmlPart(11)
invokeTag('message','g',50,['code':("loanPerformanceClassification.newClassification.label"),'default':("New Classification")],-1)
printHtmlPart(10)
expressionOut.print(loanPerformanceClassificationInstance?.newClassification?.description)
printHtmlPart(12)
invokeTag('message','g',55,['code':("loanPerformanceClassification.type.label"),'default':("Type")],-1)
printHtmlPart(10)
expressionOut.print(loanPerformanceClassificationInstance?.type?.description)
printHtmlPart(13)
if(true && (loanPerformanceClassificationInstance.type.id == 1)) {
printHtmlPart(14)
invokeTag('message','g',61,['code':("loanPerformanceClassification.thresholdAmount.label"),'default':("Threshold Amount")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',62,['bean':(loanPerformanceClassificationInstance),'field':("thresholdAmount")],-1)
printHtmlPart(15)
}
else if(true && (loanPerformanceClassificationInstance.type.id == 2)) {
printHtmlPart(14)
invokeTag('message','g',68,['code':("loanPerformanceClassification.thresholdFreq.label"),'default':("Threshold Frequency")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',69,['bean':(loanPerformanceClassificationInstance),'field':("thresholdFreq")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',74,['code':("loanPerformanceClassification.status.label"),'default':("Status")],-1)
printHtmlPart(10)
expressionOut.print(loanPerformanceClassificationInstance?.status?.description)
printHtmlPart(18)
for( product in (loanPerformanceClassificationInstance?.products) ) {
printHtmlPart(19)
expressionOut.print(product?.name)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',88,['class':("list"),'action':("index")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',89,['action':("edit"),'controller':("loanPerformanceClassification"),'id':(loanPerformanceClassificationInstance.id)],3)
printHtmlPart(26)
if(true && (loanPerformanceClassificationInstance.status.id == 1)) {
printHtmlPart(27)
createTagBody(4, {->
printHtmlPart(28)
invokeTag('actionSubmit','g',96,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(29)
})
invokeTag('form','g',97,['url':([controller:loanPerformanceClassification, id:loanPerformanceClassificationInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (loanPerformanceClassificationInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(27)
createTagBody(4, {->
printHtmlPart(28)
invokeTag('actionSubmit','g',101,['action':("delete"),'value':("Delete"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(29)
})
invokeTag('form','g',101,['url':([controller:loanPerformanceClassification, id:loanPerformanceClassificationInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',101,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129235L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
