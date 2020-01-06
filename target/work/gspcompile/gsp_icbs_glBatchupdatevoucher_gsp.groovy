import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchupdatevoucher_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/updatevoucher.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'GlBatch', 
                                  action:'addVoucherDetails'))
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
for( voucherDetails in (GlBatchVoucherssList) ) {
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
invokeTag('field','g',89,['type':("text"),'name':("check_no"),'id':("check_no"),'value':(voucherDetails.checkNo),'required':(""),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('field','g',100,['type':("text"),'name':("payee"),'value':(voucherDetails.payee),'id':("payee"),'required':(""),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('field','g',112,['type':("text"),'name':("approved_by"),'id':("approved_by"),'value':(voucherDetails.approvedBy),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('field','g',120,['type':("text"),'name':("received_by"),'id':("received_by"),'value':(voucherDetails.receivedBy),'required':(""),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',123,['name':("glbatchId"),'id':("glbatchId"),'value':(params.idbhdr)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',124,['name':("voucherid"),'id':("voucherid"),'value':(params.idvoucher)],-1)
printHtmlPart(18)
invokeTag('submitButton','g',130,['name':("create"),'class':("btn btn-primary"),'value':("Show Schedule")],-1)
printHtmlPart(19)
})
invokeTag('form','g',133,['name':("myForm"),'id':("myForm"),'url':([action:'updatevoucherAddDetailsAction',controller:'GlBatch'])],4)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',136,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',142,['controller':("GlBatch"),'action':("showVoucherDetails"),'id':(glBatchHdrInstance?.id),'params':(['Bid': params.idbhdr])],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-actions")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',147,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128973L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
