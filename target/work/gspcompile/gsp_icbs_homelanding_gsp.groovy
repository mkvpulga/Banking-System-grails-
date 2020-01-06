import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_homelanding_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/home/landing.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(1)
if(true && (flash.error)) {
printHtmlPart(5)
expressionOut.print(flash.error)
printHtmlPart(6)
expressionOut.print(flash.error)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (flash.success)) {
printHtmlPart(9)
expressionOut.print(flash.success)
printHtmlPart(10)
expressionOut.print(flash.success)
printHtmlPart(11)
}
printHtmlPart(12)
loop:{
int i = 0
for( userMessageInstance in (userMessageInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sender.name"))
printHtmlPart(15)
if(true && (userMessageInstance.isRead == true)) {
printHtmlPart(16)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',55,['controller':("UserMessage"),'action':("show"),'id':(userMessageInstance.id)],5)
printHtmlPart(15)
}
else {
printHtmlPart(17)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',58,['controller':("UserMessage"),'action':("show"),'id':(userMessageInstance.id),'class':("bold")],5)
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "body"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sentAt"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',70,['uri':("/userMaster/create")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',71,['uri':("/branch")],3)
printHtmlPart(25)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',72,['uri':("")],3)
printHtmlPart(25)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',73,['uri':("")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',74,['controller':("customer")],3)
printHtmlPart(29)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',75,['controller':("deposit"),'action':("depositSearch")],3)
printHtmlPart(29)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',76,['controller':("tellering")],3)
printHtmlPart(29)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',77,['url':("../ATMInterface")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',79,['uri':("/userMessage/create")],3)
printHtmlPart(36)
if(true && (userInstance.designation.id==1)) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('link','g',81,['uri':("/userMaster")],4)
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',82,['controller':("product"),'action':("index")],4)
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('link','g',83,['uri':("/periodicOps")],4)
printHtmlPart(39)
createClosureForHtmlPart(43, 4)
invokeTag('link','g',84,['controller':("Holiday"),'action':("index")],4)
printHtmlPart(44)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',85,['controller':("Branch"),'action':("index")],4)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (userInstance.designation.id==2)) {
printHtmlPart(37)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',89,['controller':("customer"),'action':("create")],4)
printHtmlPart(49)
createClosureForHtmlPart(32, 4)
invokeTag('link','g',90,['uri':("/tellering")],4)
printHtmlPart(46)
}
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129020L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
