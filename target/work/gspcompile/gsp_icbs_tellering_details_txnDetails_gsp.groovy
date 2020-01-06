import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_txnDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_txnDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(createLink(controller:'tellering', action:'search'))
printHtmlPart(1)
})
invokeTag('javascript','g',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('select','g',15,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(4)
expressionOut.print(params?.query)
printHtmlPart(5)
invokeTag('hiddenField','g',28,['name':("searchType"),'value':("0")],-1)
printHtmlPart(6)
})
invokeTag('form','g',32,['id':("searchForm"),'name':("searchForm"),'url':([controller:tellering, action:'search'])],1)
printHtmlPart(7)
invokeTag('sortableColumn','g',39,['property':("id"),'title':(message(code: 'txnFile.id', default: 'ID'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',41,['property':("code"),'title':("Transaction Code")],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',43,['property':("acctNo"),'title':("Account Number")],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',45,['property':("txnAmt"),'title':("Transaction Amount")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',46,['property':("txnRef"),'title':("Transaction Ref")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',47,['property':("txnParticulars"),'title':("Transaction Pariculars")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',48,['property':("txnDescription"),'title':("Transaction Desc")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(12)
expressionOut.print(domainInstance?.txnCode)
printHtmlPart(12)
expressionOut.print(domainInstance?.acctNo)
printHtmlPart(13)
invokeTag('formatNumber','g',61,['number':(domainInstance?.txnAmt),'format':("###,##0.00")],-1)
printHtmlPart(14)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(14)
expressionOut.print(domainInstance?.txnParticulars)
printHtmlPart(14)
expressionOut.print(domainInstance?.txnParticulars)
printHtmlPart(15)
if(true && (params.actionTemplate)) {
printHtmlPart(9)
invokeTag('hiddenField','g',66,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(9)
invokeTag('render','g',67,['template':("actionTemplate/${params.actionTemplate}"),'model':([txnFileInstance:domainInstance])],-1)
printHtmlPart(9)
}
else {
printHtmlPart(16)
expressionOut.print(domainInstance?.id)
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',78,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129411L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
