import icbs.gl.CfgAcctGlTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplate.label', default: 'CfgAcctGlTemplate'))],-1)
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
if(true && (cfgAcctGlTemplateInstance?.description)) {
printHtmlPart(7)
invokeTag('fieldValue','g',17,['bean':(cfgAcctGlTemplateInstance),'field':("description")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (cfgAcctGlTemplateInstance?.type)) {
printHtmlPart(10)
invokeTag('fieldValue','g',21,['bean':(cfgAcctGlTemplateInstance),'field':("type")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('select','g',28,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',30,['id':("templateid"),'name':("templateid"),'value':(params.id)],-1)
printHtmlPart(15)
invokeTag('textField','g',34,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('submitButton','g',36,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(18)
})
invokeTag('form','g',38,['class':("form-inline"),'action':("show")],3)
printHtmlPart(19)
invokeTag('sortableColumn','g',45,['property':("id"),'title':(message(code: 'cfgAcctGlTemplate.description.label', default: 'id'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',47,['property':("glCode"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Code'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',48,['property':("glDescription"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Description'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',50,['property':("ordinalPos"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Ordinal Pos'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',51,['property':("status"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Status'))],-1)
printHtmlPart(23)
for( link in (cfgAcctGlTemplateInstance.links) ) {
printHtmlPart(24)
expressionOut.print(link.id)
printHtmlPart(25)
expressionOut.print(link.glCode)
printHtmlPart(25)
expressionOut.print(link.glDescription)
printHtmlPart(26)
expressionOut.print(link.ordinalPos)
printHtmlPart(25)
expressionOut.print(link.status)
printHtmlPart(25)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',68,['controller':("cfgAcctGlTemplateDet"),'action':("show"),'id':(link.id)],4)
printHtmlPart(28)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "type"))
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('paginate','g',107,['total':(CfgAcctGlTemplateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',110,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',116,['class':("list"),'action':("index")],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',119,['action':("glLinkCreateNewEntry"),'id':(params.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127997L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
