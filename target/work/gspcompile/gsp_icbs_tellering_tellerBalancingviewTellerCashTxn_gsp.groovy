import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingviewTellerCashTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/viewTellerCashTxn.gsp" }
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
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(38).baseParams)
printHtmlPart(4)
expressionOut.print(icbs.admin.Report.get(38).outputParam)
printHtmlPart(5)
expressionOut.print(icbs.admin.Report.get(38).reportUnit)
printHtmlPart(6)
expressionOut.print(session.user_id)
printHtmlPart(7)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(8)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(9)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(39).baseParams)
printHtmlPart(4)
expressionOut.print(icbs.admin.Report.get(39).outputParam)
printHtmlPart(5)
expressionOut.print(icbs.admin.Report.get(39).reportUnit)
printHtmlPart(10)
expressionOut.print(session.branch)
printHtmlPart(11)
expressionOut.print(session.user_id)
printHtmlPart(7)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(12)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(8)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(13)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(40).baseParams)
printHtmlPart(4)
expressionOut.print(icbs.admin.Report.get(40).outputParam)
printHtmlPart(5)
expressionOut.print(icbs.admin.Report.get(40).reportUnit)
printHtmlPart(10)
expressionOut.print(session.branch)
printHtmlPart(11)
expressionOut.print(session.user_id)
printHtmlPart(7)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(12)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(8)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(14)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(41).baseParams)
printHtmlPart(4)
expressionOut.print(icbs.admin.Report.get(41).outputParam)
printHtmlPart(5)
expressionOut.print(icbs.admin.Report.get(41).reportUnit)
printHtmlPart(10)
expressionOut.print(session.branch)
printHtmlPart(11)
expressionOut.print(session.user_id)
printHtmlPart(7)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(15)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(16)
})
invokeTag('javascript','g',56,[:],2)
printHtmlPart(17)
})
invokeTag('captureHead','sitemesh',57,[:],1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('set','g',74,['var':("w"),'value':(0)],-1)
printHtmlPart(19)
invokeTag('set','g',75,['var':("x"),'value':(0)],-1)
printHtmlPart(19)
invokeTag('set','g',76,['var':("y"),'value':(0)],-1)
printHtmlPart(19)
invokeTag('set','g',77,['var':("z"),'value':(0)],-1)
printHtmlPart(19)
loop:{
int i = 0
for( tbc in (tbCash) ) {
printHtmlPart(20)
if(true && (tbc?.txnFile.txnDate == tbc?.branch?.runDate)) {
printHtmlPart(21)
createTagBody(5, {->
expressionOut.print(tbc?.txnFile.id)
})
invokeTag('link','g',81,['action':("txnReprint"),'id':(tbc?.txnFile.id)],5)
printHtmlPart(22)
expressionOut.print(tbc?.txnParticulars)
printHtmlPart(23)
if(true && (tbc.cashInAmt != 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',84,['number':(tbc.cashInAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(23)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (tbc.cashOutAmt != 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',90,['number':(tbc.cashOutAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(23)
}
else {
printHtmlPart(25)
}
printHtmlPart(27)
if(true && (tbc.checkInAmt != 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',96,['number':(tbc.checkInAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(23)
}
else {
printHtmlPart(25)
}
printHtmlPart(28)
if(true && (tbc.checkOutAmt != 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',102,['number':(tbc.checkOutAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(23)
}
else {
printHtmlPart(25)
}
printHtmlPart(29)
invokeTag('set','g',107,['var':("w"),'value':(w + tbc?.cashInAmt)],-1)
printHtmlPart(29)
invokeTag('set','g',108,['var':("x"),'value':(x + tbc?.cashOutAmt)],-1)
printHtmlPart(30)
invokeTag('set','g',109,['var':("y"),'value':(y + tbc?.checkInAmt)],-1)
printHtmlPart(30)
invokeTag('set','g',110,['var':("z"),'value':(z + tbc?.checkOutAmt)],-1)
printHtmlPart(31)
}
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
invokeTag('formatNumber','g',125,['number':(w),'format':("###,###,##0.00")],-1)
printHtmlPart(34)
invokeTag('formatNumber','g',129,['number':(x),'format':("###,###,##0.00")],-1)
printHtmlPart(35)
invokeTag('formatNumber','g',133,['number':(y),'format':("###,###,##0.00")],-1)
printHtmlPart(36)
invokeTag('formatNumber','g',137,['number':(z),'format':("###,###,##0.00")],-1)
printHtmlPart(37)
invokeTag('formatNumber','g',141,['number':(w-x),'format':("###,###,##0.00")],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',145,['number':(y-z),'format':("###,###,##0.00")],-1)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',156,['tag':("main-content")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',160,['action':("Index")],3)
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',161,['action':("viewTellerBalancing")],3)
printHtmlPart(45)
invokeTag('textField','g',188,['class':("form-control"),'id':("preparedBy"),'name':("preparedBy"),'value':("")],-1)
printHtmlPart(46)
invokeTag('textField','g',192,['class':("form-control"),'id':("checkedBy"),'name':("checkedBy"),'value':("")],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('javascript','g',203,[:],3)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',212,['tag':("main-actions")],2)
printHtmlPart(50)
})
invokeTag('captureBody','sitemesh',213,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129423L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
