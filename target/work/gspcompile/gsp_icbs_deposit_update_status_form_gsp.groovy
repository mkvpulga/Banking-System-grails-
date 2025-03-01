import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_update_status_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/update/status/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('hiddenField','g',11,['name':("deposit"),'value':(depositInstance?.id)],-1)
printHtmlPart(2)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(3)
invokeTag('hiddenField','g',13,['id':("status"),'name':("status.id"),'value':("7")],-1)
printHtmlPart(2)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',16,['id':("status"),'name':("status.id"),'value':("3")],-1)
printHtmlPart(2)
}
printHtmlPart(4)
})
invokeTag('form','g',18,['name':("depositUpdateStatusForm"),'action':("updateDepositStatus")],1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128839L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
