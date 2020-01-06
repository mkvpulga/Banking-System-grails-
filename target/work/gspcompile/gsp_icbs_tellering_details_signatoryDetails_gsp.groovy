import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_signatoryDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_signatoryDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(1)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(2)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(3)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(4)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(5)
if(true && (signatory.status.id!=3)) {
printHtmlPart(6)
invokeTag('render','g',34,['template':("details/signatoryInfo"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(5)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129409L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
