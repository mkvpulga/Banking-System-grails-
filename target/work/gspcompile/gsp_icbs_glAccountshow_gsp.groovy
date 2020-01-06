import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(glAccountInstance?.name.encodeAsHTML())
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
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (glAccountInstance?.type)) {
printHtmlPart(8)
createTagBody(4, {->
expressionOut.print(glAccountInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',23,['controller':("glAcctType"),'action':("show"),'id':(glAccountInstance?.type?.id)],4)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.currency)) {
printHtmlPart(11)
createTagBody(4, {->
expressionOut.print(glAccountInstance?.currency?.name.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("currency"),'action':("show"),'id':(glAccountInstance?.currency?.id)],4)
printHtmlPart(9)
}
printHtmlPart(12)
if(true && (glAccountInstance?.branch)) {
printHtmlPart(13)
createTagBody(4, {->
expressionOut.print(glAccountInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("branch"),'action':("show"),'id':(glAccountInstance?.branch?.id)],4)
printHtmlPart(9)
}
printHtmlPart(14)
if(true && (glAccountInstance?.code)) {
printHtmlPart(15)
invokeTag('fieldValue','g',41,['bean':(glAccountInstance),'field':("code")],-1)
printHtmlPart(9)
}
printHtmlPart(16)
if(true && (glAccountInstance?.name)) {
printHtmlPart(17)
invokeTag('fieldValue','g',47,['bean':(glAccountInstance),'field':("name")],-1)
printHtmlPart(9)
}
printHtmlPart(14)
if(true && (glAccountInstance?.parent)) {
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(glAccountInstance?.parent?.sort_name.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("glSortCode"),'action':("show"),'id':(glAccountInstance?.parent?.id)],4)
printHtmlPart(9)
}
printHtmlPart(19)
if(true && (glAccountInstance?.shortName)) {
printHtmlPart(20)
invokeTag('fieldValue','g',59,['bean':(glAccountInstance),'field':("shortName")],-1)
printHtmlPart(9)
}
printHtmlPart(14)
if(true && (glAccountInstance?.debit)) {
printHtmlPart(21)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(glAccountInstance?.debit)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.credit)) {
printHtmlPart(22)
invokeTag('formatNumber','g',71,['format':("###,###,##0.00"),'number':(glAccountInstance?.credit)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.debitToday)) {
printHtmlPart(23)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(glAccountInstance?.debitToday)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.creditToday)) {
printHtmlPart(24)
invokeTag('formatNumber','g',83,['format':("###,###,##0.00"),'number':(glAccountInstance?.creditToday)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.debitBalance)) {
printHtmlPart(25)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(glAccountInstance?.debitBalance)],-1)
printHtmlPart(9)
}
printHtmlPart(26)
if(true && (glAccountInstance?.creditBalance)) {
printHtmlPart(27)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(glAccountInstance?.creditBalance)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.balance)) {
printHtmlPart(28)
invokeTag('formatNumber','g',101,['format':("###,###,##0.00"),'number':(glAccountInstance?.balance)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (glAccountInstance?.batchUpdate)) {
printHtmlPart(29)
invokeTag('formatBoolean','g',107,['boolean':(glAccountInstance?.batchUpdate)],-1)
printHtmlPart(9)
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',124,['class':("list"),'action':("index")],3)
printHtmlPart(34)
createTagBody(3, {->
invokeTag('message','g',125,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',125,['class':("edit"),'action':("edit"),'resource':(glAccountInstance)],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('form','g',130,['id':("delete"),'url':([resource:glAccountInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',132,['class':("create"),'action':("create")],3)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(39)
invokeTag('textField','g',148,['class':("form-control"),'id':("glcode"),'name':("glcode"),'value':(glAccountInstance?.currency?.code.encodeAsHTML())],-1)
printHtmlPart(40)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(41)
invokeTag('textField','g',152,['class':("form-control"),'id':("glcode"),'name':("glcode"),'value':(glAccountInstance.code)],-1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(43)
invokeTag('customDatePicker','g',159,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(44)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(45)
invokeTag('customDatePicker','g',164,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(46)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',168,['target':("_blank"),'class':("btn btn-default"),'url':("${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(6).baseParams}&output=${icbs.admin.Report.get(6).outputParam}&reportUnit=${icbs.admin.Report.get(6).reportUnit}&date_start=document.getElementById('date1').value&date_end=document.getElementById('date2').value&gl_code=${glAccountInstance.code}&currency_code=${glAccountInstance?.currency?.code}&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}")],3)
printHtmlPart(48)
createTagBody(3, {->
printHtmlPart(49)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(24).baseParams)
printHtmlPart(50)
expressionOut.print(icbs.admin.Report.get(24).outputParam)
printHtmlPart(51)
expressionOut.print(icbs.admin.Report.get(24).reportUnit)
printHtmlPart(52)
expressionOut.print(glAccountInstance.code)
printHtmlPart(53)
expressionOut.print(glAccountInstance?.currency?.code)
printHtmlPart(54)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(55)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(56)
})
invokeTag('javascript','g',200,[:],3)
printHtmlPart(57)
})
invokeTag('captureContent','sitemesh',207,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',208,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128957L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
