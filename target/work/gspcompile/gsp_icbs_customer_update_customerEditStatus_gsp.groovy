import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_update_customerEditStatus_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/update/_customerEditStatus.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
expressionOut.print(params.id)
printHtmlPart(4)
}
printHtmlPart(5)
createClosureForHtmlPart(6, 1)
invokeTag('hasErrors','g',39,['bean':(customerInstance)],1)
printHtmlPart(5)
if(true && (!saved)) {
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',42,['name':("id"),'id':("id"),'value':(customerInstance?.id)],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: customerInstance, field: 'status', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',45,['code':("customer.status.label"),'default':("Customer Status")],-1)
printHtmlPart(11)
invokeTag('select','g',48,['id':("status"),'name':("status.id"),'from':(icbs.lov.CustomerStatus.findAllByStatusAndIdNotInList(true,['5'])),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.status?.id),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',54,['bean':(customerInstance),'field':("status")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',57,['bean':(customerInstance),'field':("status")],3)
printHtmlPart(17)
})
invokeTag('form','g',60,['name':("customerUpdateStatusForm"),'id':("customerUpdateStatusForm")],2)
printHtmlPart(5)
}
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128269L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
