import icbs.loans.CreditInvestigation
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringupdateCodeAndProducts_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/updateCodeAndProducts.gsp" }
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
invokeTag('textField','g',41,['name':("code"),'id':("code"),'required':(""),'value':(productUndercodeInstance?.code),'class':("form-control"),'onblur':("validateCode(this.value);")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',44,['id':("codeId"),'name':("codeId"),'value':(params.id)],-1)
printHtmlPart(13)
invokeTag('textField','g',49,['name':("description"),'id':("description"),'required':(""),'value':(productUndercodeInstance?.description),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('checkBox','g',55,['id':("ishasRatedItem"),'name':("ishasRatedItem"),'value':(productUndercodeInstance?.hasRatedItem),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('select','g',63,['id':("products"),'name':("products"),'from':(icbs.admin.Product.list()),'optionKey':("id"),'optionValue':("name"),'value':(productResultsUndercode?.product?.id),'class':("many-to-one form-control"),'multiple':("")],-1)
printHtmlPart(16)
})
invokeTag('form','g',64,['name':("creditScoringProduct"),'id':("creditScoringProduct"),'url':([action:'saveUpdatedCodeAndProduct',controller:'CreditScoring'])],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',68,['controller':("creditScoring"),'action':("index")],3)
printHtmlPart(21)
expressionOut.print(createLink(controller:'CreditScoring', action:'validateExisitingCode'))
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',126,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',126,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128183L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
