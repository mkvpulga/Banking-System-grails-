import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchvoucherDetailsCheck_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/voucherDetailsCheck.gsp" }
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
createTagBody(3, {->
printHtmlPart(11)
invokeTag('field','g',72,['type':("text"),'name':("check_no"),'id':("check_no"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('field','g',81,['type':("text"),'name':("payee"),'value':(""),'id':("payee"),'required':(""),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('field','g',91,['type':("text"),'name':("approved_by"),'id':("approved_by"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('field','g',101,['type':("text"),'name':("received_by"),'id':("received_by"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',105,['name':("glbatchId"),'id':("glbatchId"),'value':(params.Bid)],-1)
printHtmlPart(16)
invokeTag('submitButton','g',114,['name':("create"),'class':("btn btn-primary"),'value':("Show Schedule")],-1)
printHtmlPart(17)
})
invokeTag('form','g',117,['name':("myForm"),'id':("myForm"),'url':([action:'voucherAddDetailsAction',controller:'GlBatch'])],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',126,['controller':("GlBatch"),'action':("showVoucherDetails"),'id':(glBatchHdrInstance?.id),'params':(['Bid': params.Bid])],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',128,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128978L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
