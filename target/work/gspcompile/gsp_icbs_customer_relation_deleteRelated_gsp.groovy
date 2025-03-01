import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_relation_deleteRelated_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/relation/_deleteRelated.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(2)
expressionOut.print(flash.message)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (!saved)) {
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(7)
expressionOut.print(error.field)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('message','g',29,['error':(error)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',30,['bean':(relationInstance),'var':("error")],3)
printHtmlPart(11)
})
invokeTag('hasErrors','g',34,['bean':(relationInstance)],2)
printHtmlPart(4)
}
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('render','g',37,['template':("relation/deleteformRelated"),'model':([relationInstance:relationInstance,disabled:'disabled',customerRelationshipType:customerRelationshipType])],-1)
printHtmlPart(4)
})
invokeTag('form','g',38,['name':("customerDeleteRelatedForm"),'id':("customerDeleteRelatedForm")],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128259L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
