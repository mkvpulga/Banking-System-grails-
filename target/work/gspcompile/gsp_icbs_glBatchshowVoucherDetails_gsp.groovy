import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchshowVoucherDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/showVoucherDetails.gsp" }
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
for( Eresult in (dataList) ) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
if(true && (updateshowconfirm2=='showconfirmupdate')) {
printHtmlPart(8)
createClosureForHtmlPart(9, 5)
invokeTag('javascript','g',25,[:],5)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (updateshowconfirm2=='showconfirmadd')) {
printHtmlPart(8)
createClosureForHtmlPart(12, 5)
invokeTag('javascript','g',37,[:],5)
printHtmlPart(10)
}
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(Eresult.check_no)
printHtmlPart(17)
expressionOut.print(Eresult.payee)
printHtmlPart(18)
expressionOut.print(Eresult.approved_by)
printHtmlPart(19)
expressionOut.print(Eresult.received_by)
printHtmlPart(20)
invokeTag('hiddenField','g',108,['name':("glbatchId"),'id':("glbatchId"),'value':(params.Bid)],-1)
printHtmlPart(21)
invokeTag('submitButton','g',117,['name':("create"),'class':("btn btn-primary"),'value':("Show Schedule")],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-content")],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',126,['id':("thelinkid"),'controller':("GlBatch"),'action':("updatevoucher"),'params':(['idbhdr': params.Bid,'idvoucher':Eresult.id])],4)
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',127,['controller':("GlBatch"),'action':("index")],4)
printHtmlPart(26)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',128,['controller':("GlBatch"),'target':("_blank"),'action':("printGlBatchVoucher"),'id':(glBatchHdrInstance?.id),'params':(['id': params.Bid])],4)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',131,['tag':("main-actions")],3)
printHtmlPart(30)
}
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(32)
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
