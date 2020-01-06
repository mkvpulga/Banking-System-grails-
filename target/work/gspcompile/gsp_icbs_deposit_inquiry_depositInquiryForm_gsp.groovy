import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inquiry_depositInquiryForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inquiry/_depositInquiryForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(2)
invokeTag('render','g',17,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(3)
expressionOut.print(depositInstance?.status?.description)
printHtmlPart(4)
expressionOut.print(depositInstance?.branch.name)
printHtmlPart(5)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(6)
expressionOut.print(depositInstance?.product.name)
printHtmlPart(7)
invokeTag('formatNumber','g',48,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(8)
expressionOut.print(depositInstance?.glLink?.description)
printHtmlPart(9)
expressionOut.print(depositInstance?.product?.currency?.name)
printHtmlPart(10)
if(true && (depositInstance?.status?.id==7 && depositInstance?.ledgerBalAmt==0)) {
printHtmlPart(11)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(12)
}
else {
printHtmlPart(11)
invokeTag('formatNumber','g',82,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(14)
if(true && (depositInstance?.type?.id == 1)) {
printHtmlPart(15)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(12)
}
printHtmlPart(16)
invokeTag('formatNumber','g',96,['format':("###,###,##0.00"),'number':(depositInstance?.holdBalAmt)],-1)
printHtmlPart(12)
if(true && (depositInstance?.type?.id == 3 && depositInstance?.currentRollover?.status?.id == 1)) {
printHtmlPart(17)
if(true && (depositInstance?.status?.id == 7)) {
printHtmlPart(18)
invokeTag('formatNumber','g',102,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(20)
invokeTag('formatNumber','g',108,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',112,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt1)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',116,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',120,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt2)],-1)
printHtmlPart(24)
}
printHtmlPart(25)
}
else {
printHtmlPart(20)
invokeTag('formatNumber','g',127,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',131,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(30)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(31)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(32)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(33)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(34)
if(true && (signatory.status.id!=3)) {
printHtmlPart(35)
invokeTag('render','g',178,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(34)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(36)
}
printHtmlPart(37)
if(true && (depositInstance?.type?.id == 3)) {
printHtmlPart(38)
invokeTag('hiddenField','g',205,['id':("rolloverInstanceiidididid"),'name':("rolloverInstanceiidididid"),'value':(depositInstance?.id)],-1)
printHtmlPart(39)
loop:{
int i = 0
for( rolloverInstanceId in (rolloverInstance) ) {
printHtmlPart(40)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(41)
invokeTag('formatDate','g',208,['format':("MM/dd/yyyy"),'date':(rolloverInstanceId?.startDate)],-1)
printHtmlPart(42)
invokeTag('formatDate','g',209,['format':("MM/dd/yyyy"),'date':(rolloverInstanceId?.endDate)],-1)
printHtmlPart(42)
expressionOut.print(rolloverInstanceId?.status?.description)
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',212,['class':("btn btn-secondary"),'id':(rolloverInstanceId?.id),'action':("showRollover")],3)
printHtmlPart(45)
i++
}
}
printHtmlPart(46)
}
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128347L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
