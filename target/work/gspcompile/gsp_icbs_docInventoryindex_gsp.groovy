import icbs.deposit.DocInventory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/index.gsp" }
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
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('select','g',23,['id':("searchType"),'name':("searchType"),'from':(icbs.lov.DocInventoryType.list(sort: "description")),'optionKey':("id"),'onchange':("this.form.submit()"),'optionValue':("description"),'required':(""),'value':(params?.searchType),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
expressionOut.print(params?.query)
printHtmlPart(13)
invokeTag('submitButton','g',28,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',32,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("type"),'title':(message(code: 'docInventory.type.label', default: 'Document Inventory Type'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("branch"),'title':(message(code: 'docInventory.seriesStart.label', default: 'Branch'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("seriesStart"),'title':(message(code: 'docInventory.seriesStart.label', default: 'Series Start'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("seriesEnd"),'title':(message(code: 'docInventory.seriesEnd.label', default: 'Series End'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',41,['property':("isCanceled"),'title':(message(code: 'docInventory.isCanceled.label', default: 'Is Canceled'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',42,['property':("canceledAt"),'title':(message(code: 'docInventory.canceledAt.label', default: 'Canceled At'))],-1)
printHtmlPart(17)
invokeTag('message','g',43,['code':("docInventory.canceledBy.label"),'default':("Canceled By")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( docInventoryInstance in (docInventoryInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "type.description"))
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.branch?.name)
printHtmlPart(22)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(23)
invokeTag('formatBoolean','g',56,['boolean':(docInventoryInstance.isCanceled)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',57,['format':("yyyy-MM-dd"),'date':(docInventoryInstance.canceledAt)],-1)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "canceledBy.username"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "status.description"))
printHtmlPart(24)
if(true && (docInventoryInstance.usageCount > 0)) {
printHtmlPart(25)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',62,['action':("show"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(27)
}
else {
printHtmlPart(28)
createClosureForHtmlPart(29, 5)
invokeTag('link','g',67,['action':("edit"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(30)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',68,['action':("show"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(27)
}
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
invokeTag('paginate','g',77,['total':(DocInventoryInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',83,['class':("create"),'action':("create")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128905L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
