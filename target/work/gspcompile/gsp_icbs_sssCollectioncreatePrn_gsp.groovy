import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectioncreatePrn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/createPrn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',33,['id':("membershipType"),'name':("membershipType"),'from':(icbs.lov.SssMembershipType.findAllWhere(status: true)),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("one-to-one form-control")],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',34,['name':("wsdlMethod"),'id':("wsdlMethod"),'value':("loadIndividualPRNChange")],-1)
printHtmlPart(12)
invokeTag('textField','g',40,['id':("sssNumber"),'name':("sssNumber"),'required':(""),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('textField','g',46,['id':("totalAmt"),'name':("totalAmt"),'required':(""),'class':("form-control truncated")],-1)
printHtmlPart(14)
invokeTag('textField','g',52,['id':("fapId"),'name':("fapId"),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',58,['id':("tapId"),'name':("tapId"),'required':(""),'class':("form-control")],-1)
printHtmlPart(16)
})
invokeTag('form','g',62,['id':("create"),'url':([action:'requestIndvPrn',controller: 'SssCollection']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',70,['action':("index")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(23)
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
