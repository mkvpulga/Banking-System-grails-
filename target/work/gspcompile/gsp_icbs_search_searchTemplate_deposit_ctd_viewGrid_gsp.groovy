import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_ctd_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/ctd/_viewGrid.gsp" }
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
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',15,['id':("id"),'name':("id"),'value':(params?.id ?:depositInstance?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',16,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-ctd")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',31,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
expressionOut.print(domainInstance?.ctd?.ctdNo)
printHtmlPart(12)
expressionOut.print(domainInstance?.dateIssued?.format("MM/dd/yyyy"))
printHtmlPart(12)
expressionOut.print(domainInstance?.issuedBy?.username)
printHtmlPart(12)
expressionOut.print(domainInstance?.ctd?.dateOpened?.format("MM/dd/yyyy"))
printHtmlPart(12)
expressionOut.print(domainInstance?.ctd?.maturityDate?.format("MM/dd/yyyy"))
printHtmlPart(12)
expressionOut.print(domainInstance?.ctd?.term)
printHtmlPart(12)
invokeTag('formatNumber','g',53,['number':(domainInstance?.ctd?.interestRate),'format':("##0.00%")],-1)
printHtmlPart(13)
expressionOut.print(domainInstance?.id)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(domainInstance?.id)
printHtmlPart(16)
})
invokeTag('jasperReport','g',58,['action':("printCTD"),'controller':("deposit"),'format':("PDF"),'jasper':("ctd"),'name':("CTD")],2)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',64,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129358L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
