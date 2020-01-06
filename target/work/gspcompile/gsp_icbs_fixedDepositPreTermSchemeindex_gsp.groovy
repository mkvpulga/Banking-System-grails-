import icbs.deposit.FixedDepositPreTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositPreTermSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositPreTermScheme/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'fixedDepositPreTermScheme.label', default: 'FixedDepositPreTermScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
})
invokeTag('form','g',30,[:],3)
printHtmlPart(12)
invokeTag('sortableColumn','g',37,['property':("code"),'title':(message(code: 'fixedDepositPreTermScheme.code.label', default: 'Code'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',39,['property':("description"),'title':(message(code: 'fixedDepositPreTermScheme.description.label', default: 'Description'))],-1)
printHtmlPart(14)
invokeTag('message','g',41,['code':("fixedDepositPreTermScheme.type.label"),'default':("Type")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',43,['property':("rate"),'title':(message(code: 'fixedDepositPreTermScheme.rate.label', default: 'Rate'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',45,['property':("term1stHalf"),'title':(message(code: 'fixedDepositPreTermScheme.term1stHalf.label', default: 'Term1st Half'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',47,['property':("term2ndHalf"),'title':(message(code: 'fixedDepositPreTermScheme.term2ndHalf.label', default: 'Term2nd Half'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( fixedDepositPreTermSchemeInstance in (fixedDepositPreTermSchemeInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "code"))
})
invokeTag('link','g',55,['action':("show"),'id':(fixedDepositPreTermSchemeInstance.id)],4)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "description"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "type"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "rate"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "term1stHalf"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: "term2ndHalf"))
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',73,['total':(FixedDepositPreTermSchemeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',79,['class':("create"),'action':("create")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128923L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
