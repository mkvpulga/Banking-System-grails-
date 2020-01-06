import icbs.deposit.DocInventory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
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
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (docInventoryInstance?.branch)) {
printHtmlPart(11)
createTagBody(4, {->
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',34,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.canceledAt)) {
printHtmlPart(14)
invokeTag('formatDate','g',40,['format':("MM/dd/yyyy"),'date':(docInventoryInstance?.canceledAt)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.canceledBy)) {
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(docInventoryInstance?.canceledBy?.encodeAsHTML())
})
invokeTag('link','g',46,['controller':("userMaster"),'action':("show"),'id':(docInventoryInstance?.canceledBy?.username)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.status)) {
printHtmlPart(16)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(12)
}
printHtmlPart(17)
if(true && (docInventoryInstance?.type)) {
printHtmlPart(18)
expressionOut.print(docInventoryInstance?.type?.encodeAsHTML())
printHtmlPart(12)
}
printHtmlPart(19)
if(true && (docInventoryInstance?.isCanceled)) {
printHtmlPart(20)
invokeTag('formatBoolean','g',64,['boolean':(docInventoryInstance?.isCanceled)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.seriesStart)) {
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(12)
}
printHtmlPart(22)
if(true && (docInventoryInstance?.seriesEnd)) {
printHtmlPart(23)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.usageCount)) {
printHtmlPart(24)
expressionOut.print(docInventoryInstance?.usageCount)
printHtmlPart(12)
}
printHtmlPart(17)
if(true && (docInventoryInstance?.docParticulars)) {
printHtmlPart(25)
expressionOut.print(docInventoryInstance?.docParticulars)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.checkAcctNo)) {
printHtmlPart(26)
expressionOut.print(docInventoryInstance?.checkAcctNo)
printHtmlPart(12)
}
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',106,['class':("list"),'action':("index")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',107,['class':("create"),'action':("create")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',110,['action':("edit"),'id':(docInventoryInstance.id)],3)
printHtmlPart(35)
if(true && (docInventoryInstance.status.id == 1)) {
printHtmlPart(36)
createTagBody(4, {->
printHtmlPart(37)
invokeTag('actionSubmit','g',114,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',115,['url':([id:docInventoryInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (docInventoryInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(36)
createTagBody(4, {->
printHtmlPart(41)
invokeTag('actionSubmit','g',120,['action':("cancel"),'value':("Cancel"),'onclick':("return confirm('${message(code: 'default.button.cancel.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',121,['url':([id:docInventoryInstance.id, action:'cancel']),'method':("POST")],4)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (docInventoryInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(36)
createTagBody(4, {->
printHtmlPart(41)
invokeTag('actionSubmit','g',127,['action':("delete"),'value':("Delete"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',128,['url':([id:docInventoryInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(43)
}
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',132,['action':("viewDetails"),'id':(docInventoryInstance.id)],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',135,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128906L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
