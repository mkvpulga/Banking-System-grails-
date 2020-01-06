import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditScoringcreateRatedItemList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditScoring/createRatedItemList.gsp" }
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
expressionOut.print(ratedInstance?.creditScoringCodeDescription?.code)
printHtmlPart(11)
expressionOut.print(ratedInstance?.ratedName)
printHtmlPart(12)
for( ratedItemListing in (ratedItemsInstance) ) {
printHtmlPart(13)
expressionOut.print(ratedItemListing?.itemDescription)
printHtmlPart(14)
expressionOut.print(ratedItemListing?.id)
printHtmlPart(15)
expressionOut.print(ratedItemListing?.id)
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
invokeTag('hiddenField','g',111,['name':("ratedId"),'id':("ratedId${ratedItemListing?.id}"),'value':(ratedItemListing?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',112,['name':("parentCodeDescription"),'id':("parentCodeDescription${ratedItemListing?.id}"),'value':(ratedInstance?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(19)
invokeTag('textArea','g',117,['name':("ratedItem"),'id':("ratedItem${ratedItemListing?.id}"),'rows':("5"),'cols':("40"),'required':(""),'value':(ratedItemListing?.itemDescription),'class':("form-control")],-1)
printHtmlPart(20)
expressionOut.print(ratedItemListing?.id)
printHtmlPart(21)
})
invokeTag('form','g',131,['name':("updateRatedItems"),'id':("updateRatedItems${ratedItemListing?.id}"),'url':([action:'saveUpdateRatedItems',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();"),'method':("POST")],4)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('hiddenField','g',153,['name':("ratedId"),'id':("ratedId"),'value':(ratedInstance?.id)],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',154,['name':("parentCodeDescription"),'id':("parentCodeDescription"),'value':(ratedInstance?.creditScoringCodeDescription?.id)],-1)
printHtmlPart(26)
invokeTag('textArea','g',159,['name':("ratedItem"),'id':("ratedItem"),'rows':("5"),'cols':("40"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(27)
})
invokeTag('form','g',170,['name':("addRatedItems"),'id':("addRatedItems"),'url':([action:'saveRatedItems',controller:'CreditScoring']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',171,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',180,['controller':("creditScoring"),'action':("codeWithQuestionSectionDetails"),'id':(ratedInstance?.creditScoringCodeDescription?.id)],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',180,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',181,[:],1)
printHtmlPart(33)
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
