import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposal_loancalculator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/_loancalculator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('field','g',9,['name':("apr"),'value':("7.5"),'required':(""),'class':("form-control")],-1)
printHtmlPart(1)
invokeTag('field','g',18,['name':("term"),'value':("360"),'required':(""),'class':("form-control")],-1)
printHtmlPart(2)
invokeTag('field','g',27,['type':("text"),'name':("down"),'value':(""),'required':(""),'onkeyup':("numberFormat();"),'class':("form-control")],-1)
printHtmlPart(3)
invokeTag('field','g',37,['name':("pmt"),'value':(""),'required':(""),'onkeyup':("numberFormat1();"),'class':("form-control")],-1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129239L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
