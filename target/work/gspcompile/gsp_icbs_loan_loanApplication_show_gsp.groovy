import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanApplication_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanApplication/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(2)
expressionOut.print(loanApplicationInstance?.product?.id)
printHtmlPart(3)
expressionOut.print(loanApplicationInstance?.amount)
printHtmlPart(4)
expressionOut.print(loanApplicationInstance?.term)
printHtmlPart(5)
invokeTag('formatDate','g',8,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(6)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(7)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.id)
})
invokeTag('link','g',14,['controller':("loanApplication"),'action':("show"),'id':(loanApplicationInstance?.id)],1)
printHtmlPart(8)
invokeTag('hiddenField','g',16,['name':("forvalidateLoanApplicationId"),'id':("forvalidateLoanApplicationId"),'value':(loanApplicationInstance?.id)],-1)
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.customer?.displayName)
})
invokeTag('link','g',19,['controller':("customer"),'action':("customerInquiry"),'id':(loanApplicationInstance?.customer?.id)],1)
printHtmlPart(10)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.customer?.birthDate)],-1)
printHtmlPart(11)
invokeTag('set','g',25,['var':("primaryAddress"),'value':(loanApplicationInstance?.customer?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(0)
if(true && (primaryAddress)) {
printHtmlPart(12)
invokeTag('set','g',27,['var':("primaryAddress"),'value':(primaryAddress?.address1 + ', ' + primaryAddress?.address2 +', ' +primaryAddress?.address3)],-1)
printHtmlPart(0)
}
else {
printHtmlPart(12)
invokeTag('set','g',30,['var':("primaryAddress"),'value':("")],-1)
printHtmlPart(0)
}
printHtmlPart(13)
expressionOut.print(primaryAddress)
printHtmlPart(11)
if(true && (CustomerInfobase.findAllByCustomerAndStatus(loanApplicationInstance?.customer,ConfigItemStatus.get(2)))) {
printHtmlPart(14)
loop:{
int i = 0
for( infobase in (CustomerInfobase.findAllByCustomerAndStatus(loanApplicationInstance?.customer,ConfigItemStatus.get(2))) ) {
printHtmlPart(15)
if(true && (infobase.status.id==2)) {
printHtmlPart(16)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && ((loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(21)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.product?.name)
})
invokeTag('link','g',64,['controller':("product"),'action':("show"),'id':(loanApplicationInstance?.product?.id)],1)
printHtmlPart(25)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.branch?.name)
})
invokeTag('link','g',68,['controller':("branch"),'action':("show"),'id':(loanApplicationInstance?.branch?.id)],1)
printHtmlPart(26)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(27)
if(true && ((loanApplicationInstance))) {
printHtmlPart(28)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(loanApplicationInstance.amount)],-1)
printHtmlPart(29)
}
else {
printHtmlPart(23)
}
printHtmlPart(30)
invokeTag('fieldValue','g',85,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',89,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(32)
expressionOut.print(loanApplicationInstance?.accountOfficer?.name)
printHtmlPart(33)
invokeTag('formatDate','g',97,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(34)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(35)
if(true && (comakers)) {
printHtmlPart(36)
for( comaker in (comakers) ) {
printHtmlPart(37)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(38)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(39)
invokeTag('formatDate','g',124,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(38)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',125,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(0)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129066L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
