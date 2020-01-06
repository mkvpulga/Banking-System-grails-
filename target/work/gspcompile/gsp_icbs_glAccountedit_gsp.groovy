import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller: 'search', action:'search', params:[searchDomain: "gl-sortcode"]))
printHtmlPart(4)
})
invokeTag('javascript','g',25,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',36,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',37,['bean':(glAccountInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',39,['bean':(glAccountInstance)],3)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',41,['name':("version"),'value':(glAccountInstance?.version)],-1)
printHtmlPart(20)
invokeTag('render','g',43,['template':("form")],-1)
printHtmlPart(21)
})
invokeTag('form','g',45,['id':("edit"),'url':([resource:glAccountInstance, action:'update']),'method':("PUT"),'name':("update")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',47,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',50,['class':("list"),'action':("index")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',51,['class':("create"),'action':("create")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128955L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
