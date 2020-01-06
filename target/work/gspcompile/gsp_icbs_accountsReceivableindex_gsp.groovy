import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(9)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Description")],-1)
printHtmlPart(10)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',29,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(12)
})
invokeTag('form','g',30,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',38,['property':("receivableName"),'title':(message(code: 'accountsReceivable.description.label', default: 'Receivable'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("description"),'title':(message(code: 'accountsReceivable.description.label', default: 'Description'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',40,['property':("bookingDate"),'title':(message(code: 'accountsReceivable.bookingDate.label', default: 'Booking date'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',41,['property':("balance"),'title':(message(code: 'accountsReceivable.balance.label', default: 'Balance'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',42,['property':("currency"),'title':(message(code: 'accountsReceivable.currency.label', default: 'Currency'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( accountsReceivableInstance in (accountsReceivableInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(accountsReceivableInstance?.receivableName)
printHtmlPart(18)
expressionOut.print(accountsReceivableInstance?.description)
printHtmlPart(19)
invokeTag('formatDate','g',51,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.bookingDate)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(accountsReceivableInstance?.balance)],-1)
printHtmlPart(18)
expressionOut.print(accountsReceivableInstance?.currency?.code)
printHtmlPart(18)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',54,['class':("btn btn-secondary"),'action':("show"),'id':(accountsReceivableInstance?.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',64,['controller':("home"),'action':("landing")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',65,['controller':("accountsReceivable"),'action':("create")],3)
printHtmlPart(27)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',66,['controller':("home"),'action':("landing")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127882L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
