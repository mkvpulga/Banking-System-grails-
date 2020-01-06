import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_comakers_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/comakers/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (comakers)) {
printHtmlPart(1)
if(true && (session["comakerVerifier"])) {
printHtmlPart(2)
expressionOut.print(session["comakerVerifier"])
printHtmlPart(3)
}
printHtmlPart(4)
for( comaker in (comakers.sort{it.customer.id}) ) {
printHtmlPart(5)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(6)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(7)
invokeTag('formatDate','g',43,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(6)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',44,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(9)
expressionOut.print(comaker?.id)
printHtmlPart(10)
}
printHtmlPart(11)
}
else if(true && (session["comakers"])) {
printHtmlPart(1)
if(true && (session["comakerVerifier"])) {
printHtmlPart(2)
expressionOut.print(session["comakerVerifier"])
printHtmlPart(12)
}
printHtmlPart(4)
invokeTag('set','g',58,['var':("i"),'value':(0)],-1)
printHtmlPart(4)
for( comaker in (session["comakers"]) ) {
printHtmlPart(5)
expressionOut.print(comaker?.id)
printHtmlPart(6)
expressionOut.print(comaker?.displayName)
printHtmlPart(7)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(comaker?.birthDate)],-1)
printHtmlPart(6)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',67,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.id)],3)
printHtmlPart(9)
expressionOut.print(i)
printHtmlPart(13)
invokeTag('set','g',68,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(4)
}
printHtmlPart(14)
}
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129175L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
