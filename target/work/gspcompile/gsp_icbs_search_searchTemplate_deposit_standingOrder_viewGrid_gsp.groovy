import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_standingOrder_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/standingOrder/_viewGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',11,[:],1)
printHtmlPart(3)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',17,['id':("id"),'name':("id"),'value':(params?.id ?:depositInstance?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-standingOrder")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',19,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',54,['id':("searchForm"),'name':("searchForm"),'action':("searchVar()")],1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
invokeTag('hiddenField','g',68,['name':("id"),'value':(domainInstance?.id),'disabled':("disabled")],-1)
printHtmlPart(12)
expressionOut.print(domainInstance?.id)
printHtmlPart(13)
expressionOut.print(domainInstance?.fundingDeposit?.acctNo)
printHtmlPart(13)
expressionOut.print(domainInstance?.freq?.description)
printHtmlPart(13)
expressionOut.print(domainInstance?.type?.description)
printHtmlPart(13)
expressionOut.print(domainInstance?.status)
printHtmlPart(14)
expressionOut.print(domainInstance?.id)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',81,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129365L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
