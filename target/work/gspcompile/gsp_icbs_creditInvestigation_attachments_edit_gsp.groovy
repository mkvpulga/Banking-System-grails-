import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigation_attachments_edit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/attachments/_edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',24,['bean':(attachment)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: attachment, field: 'fileData', 'has-error'))
printHtmlPart(6)
invokeTag('field','g',30,['name':("name"),'value':(attachment?.fileName),'readonly':("true"),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',37,['bean':(attachment),'field':("fileData")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',40,['bean':(attachment),'field':("fileData")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: attachment, field: 'description', 'has-error'))
printHtmlPart(13)
invokeTag('textArea','g',46,['name':("description"),'value':(attachment?.description),'rows':("3"),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',52,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',53,['bean':(attachment),'field':("description")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',56,['bean':(attachment),'field':("description")],1)
printHtmlPart(14)
invokeTag('select','g',62,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.AttachmentType.list()),'optionKey':("id"),'optionValue':("description"),'value':(attachment?.type?.id)],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128103L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
