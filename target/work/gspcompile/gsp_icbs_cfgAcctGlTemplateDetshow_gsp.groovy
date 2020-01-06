import icbs.gl.CfgAcctGlTemplateDet
import icbs.lov.DepositStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glDescription.encodeAsHTML())
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
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
if(true && (cfgAcctGlTemplateDetInstance?.glAcct)) {
printHtmlPart(9)
invokeTag('message','g',21,['code':("cfgAcctGlTemplateDet.glAcct.label"),'default':("GL Account")],-1)
printHtmlPart(10)
createTagBody(4, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glAcct?.shortName.encodeAsHTML())
printHtmlPart(11)
expressionOut.print(cfgAcctGlTemplateDetInstance?.glAcct?.code.encodeAsHTML())
printHtmlPart(12)
})
invokeTag('link','g',23,['controller':("glAccount"),'action':("show"),'id':(cfgAcctGlTemplateDetInstance?.glAcct?.id)],4)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (cfgAcctGlTemplateDetInstance?.glDescription)) {
printHtmlPart(15)
invokeTag('message','g',30,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',32,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (cfgAcctGlTemplateDetInstance?.glTemplate)) {
printHtmlPart(17)
invokeTag('message','g',39,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Template")],-1)
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glTemplate?.description.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("cfgAcctGlTemplate"),'action':("show"),'id':(cfgAcctGlTemplateDetInstance?.glTemplate?.id)],4)
printHtmlPart(13)
}
printHtmlPart(19)
if(true && (cfgAcctGlTemplateDetInstance?.glCode)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Gl Code")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',49,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],-1)
printHtmlPart(13)
}
printHtmlPart(19)
if(true && (cfgAcctGlTemplateDetInstance?.ordinalPos)) {
printHtmlPart(20)
invokeTag('message','g',55,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Ordinal Position")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',57,['bean':(cfgAcctGlTemplateDetInstance),'field':("ordinalPos")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('message','g',64,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Status")],-1)
printHtmlPart(24)
if(true && (cfgAcctGlTemplateDetInstance?.glTemplate.type==1 || cfgAcctGlTemplateDetInstance?.glTemplate.type==2 || cfgAcctGlTemplateDetInstance?.glTemplate.type==3)) {
printHtmlPart(25)
expressionOut.print(icbs.lov.DepositStatus.findById(cfgAcctGlTemplateDetInstance.status))
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(icbs.lov.LoanPerformanceId.findById(cfgAcctGlTemplateDetInstance.status))
printHtmlPart(28)
}
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',80,['controller':("CfgAcctGlTemplate"),'action':("show"),'id':(icbs.gl.CfgAcctGlTemplateDet.findById(params.id).glTemplate.id)],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',81,['controller':("CfgAcctGlTemplate"),'action':("glLinkCreateNewEntry"),'id':(icbs.gl.CfgAcctGlTemplateDet.findById(params.id).glTemplate.id)],3)
printHtmlPart(33)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',82,['controller':("CfgAcctGlTemplateDet"),'action':("updatecfgacctdet"),'id':(params.id)],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128001L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
