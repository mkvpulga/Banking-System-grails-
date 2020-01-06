import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_loanApplicationAttachment_attachmentForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/loanApplicationAttachment/_attachmentForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',27,['name':("loanAppid"),'id':("loanAppid"),'value':(loanApplicationInstance?.id)],-1)
printHtmlPart(1)
loop:{
int i = 0
for( loanApplicationAttachment in (session["loanApplicationAttchmt"]) ) {
printHtmlPart(2)
expressionOut.print(i + 1)
printHtmlPart(3)
expressionOut.print(loanApplicationAttachment?.filename)
printHtmlPart(4)
invokeTag('formatDate','g',34,['format':("MM/dd/yyyy"),'date':(loanApplicationAttachment?.uploadDate)],-1)
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
invokeTag('textField','g',72,['name':("description"),'id':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129187L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
