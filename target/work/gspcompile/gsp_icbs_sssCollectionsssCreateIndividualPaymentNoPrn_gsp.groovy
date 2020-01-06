import icbs.lov.TxnType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectionsssCreateIndividualPaymentNoPrn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/sssCreateIndividualPaymentNoPrn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',15,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('textField','g',35,['id':("sssNumber"),'name':("sssNumber"),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',36,['name':("wsdlMethod"),'id':("wsdlMethod"),'value':("inquireIndividualSSnum")],-1)
printHtmlPart(13)
invokeTag('textField','g',42,['id':("indidobBirth"),'name':("indidobBirth"),'required':(""),'class':("form-control")],-1)
printHtmlPart(14)
})
invokeTag('form','g',46,['id':("create"),'url':([action:'confirmIndividualPaymentReferenceNumberNoPrn',controller: 'SssCollection']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('submitButton','g',61,['id':("newSss"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                function(){
                                    checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS', null); 
                                },
                                function(){
                                    return;
                                }); 
                        """)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',62,['action':("index")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-actions")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129393L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
