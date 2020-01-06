import icbs.deposit.DocInventory
import icbs.deposit.Passbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryviewSaPbDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/viewSaPbDetails.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 2)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',10,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],3)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 4)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',13,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],3)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 5)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',16,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',16,[:],3)
printHtmlPart(3)
}
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.branch)) {
printHtmlPart(14)
invokeTag('message','g',39,['code':("docInventory.branch.label"),'default':("Branch")],-1)
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],4)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (docInventoryInstance?.status)) {
printHtmlPart(18)
invokeTag('message','g',48,['code':("docInventory.status.label"),'default':("Doc Inventory Status")],-1)
printHtmlPart(19)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (docInventoryInstance?.seriesStart)) {
printHtmlPart(21)
invokeTag('message','g',57,['code':("docInventory.seriesStart.label"),'default':("Series Start")],-1)
printHtmlPart(22)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(16)
}
printHtmlPart(23)
if(true && (docInventoryInstance?.seriesEnd)) {
printHtmlPart(24)
invokeTag('message','g',66,['code':("docInventory.seriesEnd.label"),'default':("Series End")],-1)
printHtmlPart(25)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(16)
}
printHtmlPart(26)
if(true && (docInventoryInstance?.usageCount)) {
printHtmlPart(27)
invokeTag('message','g',75,['code':("docInventory.usageCount.label"),'default':("Usage Count")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',77,['bean':(docInventoryInstance),'field':("usageCount")],-1)
printHtmlPart(16)
}
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
if(true && (docInventoryInstance?.type?.id == 2)) {
printHtmlPart(31)
invokeTag('hiddenField','g',85,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(32)
}
printHtmlPart(32)
if(true && (docInventoryInstance?.type?.id == 4)) {
printHtmlPart(33)
invokeTag('hiddenField','g',88,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(32)
}
printHtmlPart(32)
if(true && (docInventoryInstance?.type?.id == 5)) {
printHtmlPart(33)
invokeTag('hiddenField','g',91,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(32)
}
printHtmlPart(34)
invokeTag('select','g',96,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit(${docInventoryInstance.id})")],-1)
printHtmlPart(35)
expressionOut.print(params?.query)
printHtmlPart(36)
invokeTag('submitButton','g',102,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(37)
})
invokeTag('form','g',106,['name':("PbDetails"),'url':([action:'viewDetails',controller:'DocInventory'])],3)
printHtmlPart(38)
loop:{
int i = 0
for( pb in (pbInstance) ) {
printHtmlPart(39)
expressionOut.print(pb?.issuePassbook?.deposit?.acctNo)
printHtmlPart(40)
expressionOut.print(pb?.issuePassbook?.deposit?.acctName)
printHtmlPart(40)
expressionOut.print(pb?.passbookNo)
printHtmlPart(40)
invokeTag('formatDate','g',121,['date':(pb?.issuePassbook?.dateIssued),'type':("date"),'style':("LONG")],-1)
printHtmlPart(40)
expressionOut.print(pb?.status?.description)
printHtmlPart(41)
i++
}
}
printHtmlPart(42)
invokeTag('paginate','g',127,['total':(pbInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-content")],2)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',135,['class':("list"),'action':("index")],3)
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('link','g',136,['class':("create"),'action':("create")],3)
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',137,['action':("show"),'id':(docInventoryInstance.id)],3)
printHtmlPart(51)
})
invokeTag('captureContent','sitemesh',139,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',140,[:],1)
printHtmlPart(52)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128909L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
