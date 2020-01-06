import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_acctInfo_acctInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/acctInfo/_acctInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (depositInstance?.type?.id==null || depositInstance?.type?.id==1)) {
printHtmlPart(2)
invokeTag('render','g',13,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (depositInstance?.type?.id==2)) {
printHtmlPart(2)
invokeTag('render','g',16,['template':("form/acctInfo/templates/current")],-1)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(2)
invokeTag('render','g',19,['template':("form/acctInfo/templates/fixedDeposit")],-1)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (depositInstance?.type?.id==4)) {
printHtmlPart(2)
invokeTag('render','g',22,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (depositInstance?.type?.id==5)) {
printHtmlPart(2)
invokeTag('render','g',25,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128313L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
