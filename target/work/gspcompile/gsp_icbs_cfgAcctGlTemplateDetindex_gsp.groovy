import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("glDescription"),'title':(message(code: 'cfgAcctGlTemplateDet.glDescription.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('message','g',34,['code':("cfgAcctGlTemplateDet.glAcct.label"),'default':("GL Account Name")],-1)
printHtmlPart(17)
invokeTag('message','g',36,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("GL Link Account Template")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( cfgAcctGlTemplateDetInstance in (cfgAcctGlTemplateDetInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateDetInstance, field: "glDescription"))
})
invokeTag('link','g',46,['action':("show"),'id':(cfgAcctGlTemplateDetInstance.id)],4)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateDetInstance, field: "glDescription"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateDetInstance, field: "glCode"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateDetInstance, field: "glDescription"))
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',61,['total':(CfgAcctGlTemplateDetInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(27)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(28)
invokeTag('message','g',67,['code':("default.home.label")],-1)
printHtmlPart(29)
expressionOut.print(createLink(uri: '/CfgAcctGlTemplate'))
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
