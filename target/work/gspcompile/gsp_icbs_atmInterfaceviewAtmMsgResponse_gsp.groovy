import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceviewAtmMsgResponse_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/viewAtmMsgResponse.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
invokeTag('select','g',17,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',21,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',23,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',25,['class':("form-inline"),'url':([action:'viewAtmMsgResponse',controller:'ATMInterface']),'method':("POST")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("id"),'title':(message(code: 'AtmTxn.txnDate.label', default: 'ID'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("destinationIp"),'title':(message(code: 'AtmTxn.destinationIp.label', default: 'Destination Ip Address'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',33,['property':("msgLength"),'title':(message(code: 'AtmTxn.mti.label', default: 'Message Length'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("dateSent"),'title':(message(code: 'AtmTxn.acct1.label', default: 'Date Sent'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( branchInstance in (atmResponseListInstance) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(fieldValue(bean: branchInstance, field: "id"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: branchInstance, field: "destinationIp"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: branchInstance, field: "msgLength"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: branchInstance, field: "dateSent"))
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',47,['class':("btn btn-primary"),'controller':("ATMInterface"),'action':("showResponseDetails"),'id':(branchInstance.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',54,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',57,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',60,['action':("index"),'controller':("ATMInterface")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',61,['action':("viewAtmMsgRequest"),'controller':("ATMInterface")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127908L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
