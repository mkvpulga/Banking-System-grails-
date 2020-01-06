import icbs.gl.CfgAcctGlTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/index.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',23,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',25,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',27,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',34,['property':("description"),'title':(message(code: 'cfgAcctGlTemplate.description.label', default: 'Description'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("type"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Type'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( cfgAcctGlTemplateInstance in (cfgAcctGlTemplateInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "description"))
})
invokeTag('link','g',44,['action':("show"),'id':(cfgAcctGlTemplateInstance.id)],4)
printHtmlPart(20)
if(true && (cfgAcctGlTemplateInstance.type==1)) {
printHtmlPart(21)
}
else if(true && (cfgAcctGlTemplateInstance.type==2)) {
printHtmlPart(22)
}
else if(true && (cfgAcctGlTemplateInstance.type==3)) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "type"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',67,['total':(CfgAcctGlTemplateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(29)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(30)
invokeTag('message','g',73,['code':("default.home.label")],-1)
printHtmlPart(31)
expressionOut.print(createLink(uri: '/CfgAcctGlTemplateDet'))
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',76,['action':("glLinkEntry")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127996L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
