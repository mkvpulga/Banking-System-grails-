import icbs.gl.GlBatch
import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatch_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',7,['name':("userBranchId"),'id':("userBranchId"),'value':(icbs.admin.UserMaster.get(session.user_id).branch.id)],-1)
printHtmlPart(2)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(6)
invokeTag('customDatePicker','g',27,['id':("valueDate"),'name':("valueDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('customDatePicker','g',30,['id':("valueDate"),'name':("valueDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(11)
invokeTag('select','g',41,['id':("template"),'name':("template.id"),'from':(icbs.gl.GlBatchTemplate.list()),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newTemplate"),'disabled':("disabled")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(11)
invokeTag('select','g',44,['id':("template"),'name':("template.id"),'from':(icbs.gl.GlBatchTemplate.list()),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newTemplate")],-1)
printHtmlPart(9)
}
printHtmlPart(13)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(17)
invokeTag('select','g',67,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch")],-1)
printHtmlPart(18)
invokeTag('select','g',68,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'value':(session.branch_id),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch"),'disabled':("disabled")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(8)
invokeTag('select','g',71,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'value':(session.branch_id),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch")],-1)
printHtmlPart(9)
}
printHtmlPart(19)
invokeTag('hiddenField','g',81,['name':("glBatchLoan"),'id':("glBatchLoanHidden"),'v-model':("newLoans")],-1)
printHtmlPart(20)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(21)
invokeTag('select','g',100,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(glAccountInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newCurrency"),'disabled':("disabled")],-1)
printHtmlPart(21)
}
else {
printHtmlPart(8)
invokeTag('select','g',104,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(glAccountInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newCurrency")],-1)
printHtmlPart(12)
}
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128961L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
