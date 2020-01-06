import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_serviceCharges_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/serviceCharges/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',12,['var':("x"),'value':(0)],-1)
printHtmlPart(1)
for( serviceCharge in (loanInstance?.serviceCharges.sort{it.scheme.id}) ) {
printHtmlPart(2)
invokeTag('set','g',15,['var':("type"),'value':(serviceCharge?.scheme?.type.id)],-1)
printHtmlPart(3)
expressionOut.print(serviceCharge?.scheme?.name)
printHtmlPart(4)
expressionOut.print(serviceCharge?.scheme?.type?.description)
printHtmlPart(4)
invokeTag('formatNumber','g',18,['format':("###,##0.00"),'number':(serviceCharge?.amount)],-1)
printHtmlPart(5)
invokeTag('set','g',20,['var':("x"),'value':(x + serviceCharge?.amount)],-1)
printHtmlPart(1)
}
printHtmlPart(6)
invokeTag('formatNumber','g',25,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129132L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
