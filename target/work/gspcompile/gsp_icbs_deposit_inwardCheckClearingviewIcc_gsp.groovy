import icbs.deposit.InwardClearingLoad
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inwardCheckClearingviewIcc_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inwardCheckClearing/viewIcc.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
loop:{
int i = 0
for( check in (domainInstance?.checks) ) {
printHtmlPart(12)
invokeTag('hiddenField','g',50,['name':("checks[${i}].chequeNo"),'value':(check?.chequeNo)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',51,['name':("checks[${i}].amt"),'value':(check?.amt)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',52,['name':("checks[${i}].brstn"),'value':(check?.brstn)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',53,['name':("checks[${i}].trancd"),'value':(check?.trancd)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',54,['name':("checks[${i}].acctNo"),'value':(check?.acctNo)],-1)
printHtmlPart(14)
expressionOut.print(i + 1)
printHtmlPart(15)
expressionOut.print(check?.acctNo)
printHtmlPart(16)
if(true && (InwardClearingLoad.findByChequeNo(check?.chequeNo))) {
printHtmlPart(17)
expressionOut.print(InwardClearingLoad.findByChequeNo(check?.chequeNo).acctName)
printHtmlPart(16)
}
else {
printHtmlPart(18)
}
printHtmlPart(13)
if(true && (InwardClearingLoad.findByChequeNo(check?.chequeNo))) {
printHtmlPart(17)
expressionOut.print(InwardClearingLoad.findByChequeNo(check?.chequeNo).caAcctNo)
printHtmlPart(16)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(check?.chequeNo)
printHtmlPart(15)
invokeTag('formatNumber','g',70,['format':("###,###,##0.00"),'number':(check?.amt)],-1)
printHtmlPart(15)
expressionOut.print(check?.brstn)
printHtmlPart(15)
expressionOut.print(check?.trancd)
printHtmlPart(20)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',78,['bean':(domainInstance),'field':("checks[${i}].acctNo")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',80,['bean':(domainInstance),'field':("checks[${i}].acctNo")],5)
printHtmlPart(25)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',84,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',85,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',87,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',91,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',92,['bean':(domainInstance),'field':("checks[${i}].amt")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',94,['bean':(domainInstance),'field':("checks[${i}].amt")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',98,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',99,['bean':(domainInstance),'field':("checks[${i}].brstn")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',101,['bean':(domainInstance),'field':("checks[${i}].brstn")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',105,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',106,['bean':(domainInstance),'field':("checks[${i}].trancd")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',108,['bean':(domainInstance),'field':("checks[${i}].trancd")],5)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
})
invokeTag('form','g',114,['name':("processInwardCheckingForm"),'action':("processInwardCheckClearing"),'controller':("deposit")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',116,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('submitButton','g',127,['name':("submit"),'id':("processIcc"),'class':("btn btn-primary"),'value':('Process'),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this process?',
                                function(){
                                    checkIfAllowed('CFG00302', 'form#processInwardCheckingForm', 'Override Inward clearing process', null);
                                },
                                function(){
                                    return;
                                });
                """)],-1)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',128,['action':("index")],3)
printHtmlPart(31)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',129,['action':("index")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',132,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',135,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128374L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
