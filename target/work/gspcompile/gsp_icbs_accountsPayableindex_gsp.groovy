import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/index.gsp" }
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
invokeTag('sortableColumn','g',38,['property':("payable"),'title':(message(code: 'accountsPayable.description.label', default: 'Payable'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("bookingDate"),'title':(message(code: 'accountsPayable.bookingDate.label', default: 'Booking date'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',40,['property':("balance"),'title':(message(code: 'accountsPayable.balance.label', default: 'Balance'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',41,['property':("currency"),'title':(message(code: 'accountsPayable.currency.label', default: 'Currency'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( accountsPayableInstance in (accountsPayableInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(accountsPayableInstance?.payable)
printHtmlPart(18)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.bookingDate)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(accountsPayableInstance?.balance)],-1)
printHtmlPart(20)
expressionOut.print(accountsPayableInstance?.currency?.code)
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',52,['class':("btn btn-secondary"),'action':("show"),'id':(accountsPayableInstance?.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',58,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',62,['controller':("home"),'action':("landing")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',63,['action':("create")],3)
printHtmlPart(27)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',64,['action':("printSchedule")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',67,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127875L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
