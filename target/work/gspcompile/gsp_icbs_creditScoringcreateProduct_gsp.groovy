import icbs.loans.CreditInvestigation
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringcreateProduct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/createProduct.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('textField','g',38,['name':("code"),'id':("code"),'required':(""),'value':(""),'class':("form-control"),'onblur':("validateCode(this.value);")],-1)
printHtmlPart(12)
invokeTag('textField','g',45,['name':("description"),'id':("description"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('checkBox','g',50,['id':("ishasRatedItem"),'name':("ishasRatedItem"),'value':("false"),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('select','g',59,['id':("products"),'name':("products"),'from':(icbs.admin.Product.findAllByProductType(icbs.lov.ProductType.get(6))),'optionKey':("id"),'optionValue':("name"),'value':(""),'class':("many-to-one form-control"),'multiple':("")],-1)
printHtmlPart(15)
})
invokeTag('form','g',61,['name':("creditScoringProduct"),'id':("creditScoringProduct"),'url':([action:'saveProduct',controller:'CreditScoring'])],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',64,['controller':("creditScoring"),'action':("configProduct")],3)
printHtmlPart(20)
expressionOut.print(createLink(controller:'CreditScoring', action:'validateExisitingCode'))
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',119,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128178L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
