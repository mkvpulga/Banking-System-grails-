import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_inwardClearingPointerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/inwardClearingPointer/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'inwardClearingPointer.label', default: 'InwardClearingPointer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',30,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',33,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Code or Name")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',35,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',40,[:],3)
printHtmlPart(13)
loop:{
int i = 0
for( InwardClearingPointerInstance in (inwardClearingPointerInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
expressionOut.print(InwardClearingPointerInstance?.description)
printHtmlPart(16)
expressionOut.print(InwardClearingPointerInstance?.inwardBRSTN)
printHtmlPart(17)
expressionOut.print(InwardClearingPointerInstance?.txnTemplate?.description)
printHtmlPart(18)
expressionOut.print(i)
printHtmlPart(19)
expressionOut.print(InwardClearingPointerInstance?.id)
printHtmlPart(20)
expressionOut.print(createLink(controller:'InwardClearingPointer', action:'deleteInwardClearingPointer'))
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(22)
createTagBody(4, {->
printHtmlPart(23)
invokeTag('hiddenField','g',116,['id':("inwardClearId${i}"),'name':("inwardClearId"),'value':(InwardClearingPointerInstance?.id)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(25)
invokeTag('textField','g',119,['id':("description${i}"),'name':("description"),'value':(InwardClearingPointerInstance?.description),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(27)
invokeTag('textField','g',123,['id':("inwardBRSTN${i}"),'name':("inwardBRSTN"),'value':(InwardClearingPointerInstance?.inwardBRSTN),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(28)
invokeTag('select','g',127,['id':("txnTemplatePointer${i}"),'name':("txnTemplatePointer"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(10),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(InwardClearingPointerInstance?.txnTemplate?.description),'class':("form-control")],-1)
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(30)
createTagBody(5, {->
printHtmlPart(31)
expressionOut.print(createLink(controller:'InwardClearingPointer', action:'editInwardClearingPointer'))
printHtmlPart(32)
})
invokeTag('javascript','g',193,[:],5)
printHtmlPart(33)
})
invokeTag('form','g',197,['name':("editInwardClearingPointerModal"),'id':("editInwardClearingPointerModal${i}"),'controller':("InwardClearingPointer"),'action':("editInwardClearingPointer")],4)
printHtmlPart(34)
i++
}
}
printHtmlPart(35)
invokeTag('paginate','g',206,['total':(interestIncomeSchemeInstanceCount ?: 0)],-1)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',209,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',213,['class':("icc"),'controller':("deposit"),'action':("viewInwardCheckClearing")],3)
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(41)
invokeTag('textField','g',232,['id':("description"),'name':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(43)
invokeTag('textField','g',236,['id':("inwardBRSTN"),'name':("inwardBRSTN"),'value':(""),'class':("form-control")],-1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(44)
invokeTag('select','g',240,['id':("txnTemplatePointer"),'name':("txnTemplatePointer"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(10),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':("1"),'class':("form-control")],-1)
printHtmlPart(45)
createClosureForHtmlPart(46, 4)
invokeTag('javascript','g',276,[:],4)
printHtmlPart(47)
})
invokeTag('form','g',280,['name':("newInwardClearingPointerFormSend"),'id':("newInwardClearingPointerFormSend"),'controller':("InwardClearingPointer"),'action':("saveInwardClearingPointer")],3)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',285,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',286,[:],1)
printHtmlPart(49)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129031L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
