import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(cfgAcctGlTemplateDetInstance?.glDescription.encodeAsHTML())
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',18,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',19,['bean':(cfgAcctGlTemplateDetInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',21,['bean':(cfgAcctGlTemplateDetInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',23,['name':("version"),'value':(cfgAcctGlTemplateDetInstance?.version)],-1)
printHtmlPart(17)
invokeTag('render','g',25,['template':("form")],-1)
printHtmlPart(18)
})
invokeTag('form','g',27,['url':([resource:cfgAcctGlTemplateDetInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',28,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('actionSubmit','g',33,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',35,['action':("show"),'id':(cfgAcctGlTemplateDetInstance.id)],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',35,['tag':("main-actions")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',36,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127999L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
