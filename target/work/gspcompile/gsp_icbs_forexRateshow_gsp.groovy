import icbs.admin.ForexRate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'forexRate.label', default: 'ForexRate'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/forexRate'))
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (forexRateInstance?.currency)) {
printHtmlPart(11)
invokeTag('message','g',24,['code':("forexRate.currency.label"),'default':("Currency")],-1)
printHtmlPart(12)
createTagBody(4, {->
expressionOut.print(forexRateInstance?.currency?.name)
})
invokeTag('link','g',26,['controller':("currency"),'action':("show"),'id':(forexRateInstance?.currency?.id)],4)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.date)) {
printHtmlPart(15)
invokeTag('message','g',33,['code':("forexRate.date.label"),'default':("Date")],-1)
printHtmlPart(16)
expressionOut.print(forexRateInstance?.date)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.rate)) {
printHtmlPart(17)
invokeTag('message','g',42,['code':("forexRate.rate.label"),'default':("Rate")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',44,['bean':(forexRateInstance),'field':("rate")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.refRate)) {
printHtmlPart(19)
invokeTag('message','g',51,['code':("forexRate.refRate.label"),'default':("Ref Rate")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',53,['bean':(forexRateInstance),'field':("refRate")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.buyRate1)) {
printHtmlPart(21)
invokeTag('message','g',60,['code':("forexRate.buyRate1.label"),'default':("Buy Rate1")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',62,['bean':(forexRateInstance),'field':("buyRate1")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.buyRate2)) {
printHtmlPart(23)
invokeTag('message','g',69,['code':("forexRate.buyRate2.label"),'default':("Buy Rate2")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',71,['bean':(forexRateInstance),'field':("buyRate2")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.buyRate3)) {
printHtmlPart(25)
invokeTag('message','g',78,['code':("forexRate.buyRate3.label"),'default':("Buy Rate3")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',80,['bean':(forexRateInstance),'field':("buyRate3")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.buyRate4)) {
printHtmlPart(27)
invokeTag('message','g',87,['code':("forexRate.buyRate4.label"),'default':("Buy Rate4")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',89,['bean':(forexRateInstance),'field':("buyRate4")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.buyRate5)) {
printHtmlPart(29)
invokeTag('message','g',96,['code':("forexRate.buyRate5.label"),'default':("Buy Rate5")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',98,['bean':(forexRateInstance),'field':("buyRate5")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.sellRate1)) {
printHtmlPart(31)
invokeTag('message','g',105,['code':("forexRate.sellRate1.label"),'default':("Sell Rate1")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',107,['bean':(forexRateInstance),'field':("sellRate1")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.sellRate2)) {
printHtmlPart(33)
invokeTag('message','g',114,['code':("forexRate.sellRate2.label"),'default':("Sell Rate2")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',116,['bean':(forexRateInstance),'field':("sellRate2")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.sellRate3)) {
printHtmlPart(35)
invokeTag('message','g',123,['code':("forexRate.sellRate3.label"),'default':("Sell Rate3")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',125,['bean':(forexRateInstance),'field':("sellRate3")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.sellRate4)) {
printHtmlPart(37)
invokeTag('message','g',132,['code':("forexRate.sellRate4.label"),'default':("Sell Rate4")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',134,['bean':(forexRateInstance),'field':("sellRate4")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (forexRateInstance?.sellRate5)) {
printHtmlPart(39)
invokeTag('message','g',141,['code':("forexRate.sellRate5.label"),'default':("Sell Rate5")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',143,['bean':(forexRateInstance),'field':("sellRate5")],-1)
printHtmlPart(13)
}
printHtmlPart(41)
createTagBody(3, {->
printHtmlPart(42)
invokeTag('actionSubmit','g',151,['class':("btn btn-primary"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete'))],-1)
printHtmlPart(43)
})
invokeTag('form','g',153,['url':([resource:forexRateInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',155,['tag':("main-content")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(46)
createTagBody(3, {->
invokeTag('message','g',158,['code':("default.newupdate.label"),'args':([entityName]),'default':("New Forex Rate")],-1)
})
invokeTag('link','g',158,['class':("create"),'action':("create")],3)
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('link','g',159,['action':("edit"),'id':(forexRateInstance.id)],3)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',161,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',162,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128946L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
