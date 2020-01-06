import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'cashfromvault.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js', file: 'cashfromvault.js'))
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(hasErrors(bean: tellerBalancingInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',31,['code':("tellerBalancing.txnAmt.label"),'default':("Ending Cash")],-1)
printHtmlPart(12)
invokeTag('field','g',35,['name':("txnAmt"),'value':(fieldValue(bean: tellerBalancingInstance, field: 'txnAmt')),'class':("txn-amt form-control")],-1)
printHtmlPart(13)
invokeTag('textField','g',50,['type':("number"),'name':("bills1000"),'value':(tellerBalancingInstance?.bills1000),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',53,['type':("number"),'disabled':("true"),'name':("total1000"),'id':("total1000"),'value':(tellerBalancingInstance?.total1000),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',61,['type':("number"),'name':("bills500"),'value':(tellerBalancingInstance?.bills500),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',64,['type':("number"),'disabled':("true"),'name':("total500"),'id':("total500"),'value':(tellerBalancingInstance?.total500),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('textField','g',72,['type':("number"),'name':("bills200"),'value':(tellerBalancingInstance?.bills200),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',75,['type':("number"),'disabled':("true"),'name':("total200"),'id':("total200"),'value':(tellerBalancingInstance?.total200),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(17)
invokeTag('textField','g',83,['type':("number"),'name':("bills100"),'value':(tellerBalancingInstance?.bills100),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',86,['type':("number"),'disabled':("true"),'name':("total100"),'id':("total100"),'value':(tellerBalancingInstance?.total100),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(18)
invokeTag('textField','g',94,['type':("number"),'name':("bills50"),'value':(tellerBalancingInstance?.bills50),'class':("form-control to-compute")],-1)
printHtmlPart(19)
invokeTag('textField','g',97,['type':("number"),'disabled':("true"),'name':("total50"),'id':("total50"),'value':(tellerBalancingInstance?.total50),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(20)
invokeTag('textField','g',105,['type':("number"),'name':("bills20"),'value':(tellerBalancingInstance?.bills20),'class':("form-control to-compute")],-1)
printHtmlPart(21)
invokeTag('textField','g',108,['type':("number"),'disabled':("true"),'name':("total20"),'id':("total20"),'value':(tellerBalancingInstance?.total20),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(22)
invokeTag('textField','g',116,['type':("number"),'name':("coins10"),'value':(tellerBalancingInstance?.coins10),'class':("form-control to-compute")],-1)
printHtmlPart(23)
invokeTag('textField','g',119,['type':("number"),'disabled':("true"),'name':("total10"),'id':("total10"),'value':(tellerBalancingInstance?.total10),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(24)
invokeTag('textField','g',127,['type':("number"),'name':("coins5"),'value':(tellerBalancingInstance?.coins5),'class':("form-control to-compute")],-1)
printHtmlPart(23)
invokeTag('textField','g',130,['type':("number"),'disabled':("true"),'name':("total5"),'id':("total5"),'value':(tellerBalancingInstance?.total5),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(25)
invokeTag('textField','g',138,['type':("number"),'name':("coins1"),'value':(tellerBalancingInstance?.coins1),'class':("form-control to-compute")],-1)
printHtmlPart(21)
invokeTag('textField','g',141,['type':("number"),'disabled':("true"),'name':("total1"),'id':("total1"),'value':(tellerBalancingInstance?.total1),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(26)
invokeTag('textField','g',149,['type':("number"),'name':("coins025"),'value':(tellerBalancingInstance?.coins025),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',152,['type':("number"),'disabled':("true"),'name':("total025"),'id':("total025"),'value':(tellerBalancingInstance?.total025),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(27)
invokeTag('textField','g',160,['type':("number"),'name':("coins010"),'value':(tellerBalancingInstance?.coins010),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',163,['type':("number"),'disabled':("true"),'name':("total010"),'id':("total010"),'value':(tellerBalancingInstance?.total010),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(28)
invokeTag('textField','g',171,['type':("number"),'name':("coins005"),'value':(tellerBalancingInstance?.coins005),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',174,['type':("number"),'disabled':("true"),'name':("total005"),'id':("total005"),'value':(tellerBalancingInstance?.total005),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(29)
invokeTag('textField','g',182,['type':("number"),'name':("coins001"),'value':(tellerBalancingInstance?.coins001),'class':("form-control to-compute")],-1)
printHtmlPart(14)
invokeTag('textField','g',185,['type':("number"),'disabled':("true"),'name':("total001"),'id':("total001"),'value':(tellerBalancingInstance?.total001),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(30)
invokeTag('textField','g',196,['disabled':("true"),'name':("total"),'id':("total"),'value':("0"),'class':("form-control total")],-1)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',204,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',208,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',209,['action':("comfirmTellerBalance"),'onclick':("return confirm('Confirm Balance?');")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',211,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',212,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129422L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
