import icbs.deposit.DocInventory
import icbs.deposit.Passbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryviewCtdDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/viewCtdDetails.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (docInventoryInstance?.branch)) {
printHtmlPart(10)
invokeTag('message','g',31,['code':("docInventory.branch.label"),'default':("Branch")],-1)
printHtmlPart(11)
createTagBody(4, {->
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',33,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (docInventoryInstance?.status)) {
printHtmlPart(14)
invokeTag('message','g',40,['code':("docInventory.status.label"),'default':("Doc Inventory Status")],-1)
printHtmlPart(15)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (docInventoryInstance?.seriesStart)) {
printHtmlPart(17)
invokeTag('message','g',49,['code':("docInventory.seriesStart.label"),'default':("Series Start")],-1)
printHtmlPart(18)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(12)
}
printHtmlPart(19)
if(true && (docInventoryInstance?.seriesEnd)) {
printHtmlPart(20)
invokeTag('message','g',58,['code':("docInventory.seriesEnd.label"),'default':("Series End")],-1)
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(12)
}
printHtmlPart(22)
if(true && (docInventoryInstance?.usageCount)) {
printHtmlPart(23)
invokeTag('message','g',67,['code':("docInventory.usageCount.label"),'default':("Usage Count")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',69,['bean':(docInventoryInstance),'field':("usageCount")],-1)
printHtmlPart(12)
}
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('hiddenField','g',76,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(27)
invokeTag('select','g',79,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("submit(${docInventoryInstance.id})")],-1)
printHtmlPart(28)
expressionOut.print(params?.query)
printHtmlPart(29)
invokeTag('submitButton','g',85,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(30)
})
invokeTag('form','g',89,['name':("ChkDetails"),'url':([action:'viewDetails',controller:'DocInventory'])],3)
printHtmlPart(31)
for( ctd in (ctdInstance) ) {
printHtmlPart(32)
expressionOut.print(ctd?.issueCTD?.deposit?.acctNo)
printHtmlPart(33)
expressionOut.print(ctd?.issueCTD?.deposit?.acctName)
printHtmlPart(33)
expressionOut.print(ctd?.ctdNo)
printHtmlPart(33)
invokeTag('formatDate','g',104,['date':(ctd?.issueCTD?.dateIssued),'type':("date"),'style':("LONG")],-1)
printHtmlPart(33)
expressionOut.print(ctd?.status?.description)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('paginate','g',110,['total':(ctdInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',115,['tag':("main-content")],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',118,['class':("list"),'action':("index")],3)
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',119,['class':("create"),'action':("create")],3)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',120,['action':("show"),'id':(docInventoryInstance.id)],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128908L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
