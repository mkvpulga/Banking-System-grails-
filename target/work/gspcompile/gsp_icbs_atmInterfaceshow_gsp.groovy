import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (atmTerminalInstance?.terminalCode)) {
printHtmlPart(8)
invokeTag('fieldValue','g',23,['bean':(atmTerminalInstance),'field':("terminalCode")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (atmTerminalInstance?.remarks)) {
printHtmlPart(11)
invokeTag('fieldValue','g',29,['bean':(atmTerminalInstance),'field':("remarks")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (atmTerminalInstance?.branch)) {
printHtmlPart(12)
expressionOut.print(atmTerminalInstance?.branch?.name)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (atmTerminalInstance?.terminalStatus)) {
printHtmlPart(13)
expressionOut.print(atmTerminalInstance?.terminalStatus?.description)
printHtmlPart(9)
}
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',51,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
if(true && (atmTerminalInstance.terminalStatus.id == 3)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('link','g',59,['action':("editTerminal"),'controller':("ATMInterface"),'id':(atmTerminalInstance.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',62,['action':("atmTerminalView")],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('hiddenField','g',64,['name':("id"),'id':("id"),'value':(atmTerminalInstance.id)],-1)
printHtmlPart(25)
})
invokeTag('form','g',65,['name':("atmDeleteform"),'id':("atmDeleteform"),'url':([action:'deleteTerminal',controller:'ATMInterface'])],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127901L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
