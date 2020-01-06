import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_loanApplicationAttachment_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/loanApplicationAttachment/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( attachment in (resultsAttachment) ) {
printHtmlPart(1)
expressionOut.print(attachment?.filename)
printHtmlPart(2)
expressionOut.print(attachment?.description)
printHtmlPart(2)
invokeTag('formatDate','g',19,['format':("MM-dd-yyyy"),'date':(attachment?.uploadDate)],-1)
printHtmlPart(3)
expressionOut.print(i)
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',23,['class':("btn btn-secondary"),'action':("downloadAttachment"),'id':(attachment?.id)],2)
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
expressionOut.print(attachment?.filename)
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
expressionOut.print(createLink(controller:'loanApplication', action:'showPicture', id: attachment?.id))
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129188L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
