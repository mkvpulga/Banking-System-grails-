import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(9)
invokeTag('textField','g',27,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('submitButton','g',29,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(12)
})
invokeTag('form','g',31,['class':("form-inline")],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("brnum"),'title':(message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Billing Ref Num'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',36,['property':("indiIprnum"),'title':(message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Individual Payment Ref Num'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',37,['property':("ername"),'title':(message(code: 'SssOnlinePaymentDetail.ername.label', default: 'Employer Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',38,['property':("indiEename"),'title':(message(code: 'SssOnlinePaymentDetail.indiEename.label', default: 'Individual Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("amount"),'title':(message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Amount'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( sssInstance in (sssOnlinePaymentDetailList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(sssInstance.brnum)
printHtmlPart(18)
expressionOut.print(sssInstance.indiIprnum)
printHtmlPart(18)
expressionOut.print(sssInstance.ername)
printHtmlPart(18)
expressionOut.print(sssInstance.indiEename)
printHtmlPart(18)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(sssInstance?.amount)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('link','g',51,['class':("btn btn-secondary"),'action':("show"),'id':(sssInstance.id)],4)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',57,['total':(sssOnlinePaymentDetailInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',63,['action':("sssOnlineCreate")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',64,['action':("sssCreateIndividualPayment")],3)
printHtmlPart(25)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',65,['action':("sssCreateIndividualPaymentNoPrn")],3)
printHtmlPart(25)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',66,['action':("createPrn")],3)
printHtmlPart(25)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',67,['action':("create")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129387L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
