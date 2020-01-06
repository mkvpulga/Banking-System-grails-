import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/branch'))
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(8)
invokeTag('message','g',17,['code':("default.home.label")],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',22,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',30,['code':("customer.customerAcctTypeId.label"),'default':("Customer Acct Type Id")],-1)
printHtmlPart(15)
invokeTag('message','g',32,['code':("customer.genderId.label"),'default':("Gender Id")],-1)
printHtmlPart(15)
invokeTag('message','g',34,['code':("customer.customerDosriCodeId.label"),'default':("Customer Dosri Code Id")],-1)
printHtmlPart(15)
invokeTag('message','g',36,['code':("customer.customerStatusId.label"),'default':("Customer Status Id")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("displayId"),'title':(message(code: 'customer.displayId.label', default: 'Display Id'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',40,['property':("firstName"),'title':(message(code: 'customer.firstName.label', default: 'First Name'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( customerInstance in (customerInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: customerInstance, field: "customerAcctTypeId"))
})
invokeTag('link','g',48,['action':("show"),'id':(customerInstance.id)],3)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerInstance, field: "genderId"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerInstance, field: "customerDosriCodeId"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerInstance, field: "customerStatusId"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerInstance, field: "displayId"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: customerInstance, field: "firstName"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',65,['total':(customerInstanceCount ?: 0)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128250L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
