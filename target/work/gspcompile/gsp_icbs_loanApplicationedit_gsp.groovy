import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanApplication', action:'showFinancialDetailsAjax2'))
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loanApplication', action:'addFinancialDetailAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddFinancialDetailAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller :'loanApplication', action:'updateFinancialDetailAjax2'))
printHtmlPart(11)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateFinancialDetailAjax2'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteFinancialDetailAjax2'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'loanApplication', action:'showComakersAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'loanApplication', action:'addComakerAjax'))
printHtmlPart(15)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(16)
expressionOut.print(createLink(controller :'loanApplication', action:'deleteComakerAjax'))
printHtmlPart(17)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'loanApplication', action:'showCollateralAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller:'loanApplication', action:'addCollateralAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller: 'collateralManagement', action:'search'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteCollateralAjax'))
printHtmlPart(21)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(22)
expressionOut.print(createLink(controller:'LoanApplication',action:'addAttachment'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'LoanApplication',action:'removeAttachment'))
printHtmlPart(24)
})
invokeTag('javascript','g',362,[:],2)
printHtmlPart(25)
})
invokeTag('captureHead','sitemesh',363,[:],1)
printHtmlPart(25)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('captureContent','sitemesh',367,['tag':("breadcrumbs")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(27)
if(true && (flash.message)) {
printHtmlPart(28)
expressionOut.print(flash.message)
printHtmlPart(29)
}
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(31)
expressionOut.print(it)
printHtmlPart(32)
})
invokeTag('hasErrors','g',387,['bean':(loanApplicationInstance)],3)
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(33)
invokeTag('hiddenField','g',389,['name':("version"),'value':(loanApplicationInstance?.version)],-1)
printHtmlPart(34)
if(true && (role)) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (user?.designation?.id == 17)) {
printHtmlPart(37)
invokeTag('render','g',405,['template':("specification/form")],-1)
printHtmlPart(38)
invokeTag('render','g',409,['template':("financialDetails/list")],-1)
printHtmlPart(39)
invokeTag('render','g',411,['template':("comakers/list")],-1)
printHtmlPart(40)
if(true && (user?.designation?.id == 33)) {
printHtmlPart(41)
invokeTag('render','g',416,['template':("collateral/list")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(42)
invokeTag('render','g',420,['template':("collateral/show")],-1)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (user?.id == 16)) {
printHtmlPart(45)
invokeTag('render','g',425,['template':("additional/form")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(45)
invokeTag('render','g',430,['template':("additional/show")],-1)
printHtmlPart(40)
}
printHtmlPart(46)
invokeTag('render','g',434,['template':("loanApplicationChecklist/checklist")],-1)
printHtmlPart(47)
invokeTag('render','g',438,['template':("attachments/list")],-1)
printHtmlPart(48)
}
else {
printHtmlPart(44)
if(true && (user?.id == 15 || user?.id == 12)) {
printHtmlPart(37)
invokeTag('render','g',443,['template':("specification/form")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(37)
invokeTag('render','g',449,['template':("specification/show")],-1)
printHtmlPart(40)
}
printHtmlPart(49)
invokeTag('render','g',454,['template':("financialDetails/show")],-1)
printHtmlPart(50)
invokeTag('render','g',456,['template':("comakers/show")],-1)
printHtmlPart(51)
if(true && (user?.designation?.id == 33)) {
printHtmlPart(41)
invokeTag('render','g',461,['template':("collateral/list")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(42)
invokeTag('render','g',465,['template':("collateral/show")],-1)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (user?.designation?.id == 30)) {
printHtmlPart(45)
invokeTag('render','g',470,['template':("additional/form")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(45)
invokeTag('render','g',475,['template':("additional/show")],-1)
printHtmlPart(40)
}
printHtmlPart(46)
invokeTag('render','g',479,['template':("loanApplicationChecklist/checklist")],-1)
printHtmlPart(47)
invokeTag('render','g',483,['template':("attachments/show")],-1)
printHtmlPart(52)
}
printHtmlPart(53)
})
invokeTag('form','g',485,['id':("loan-application-form"),'onsubmit':("callLoadingDialog();"),'url':([resource:loanApplicationInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(54)
})
invokeTag('captureContent','sitemesh',486,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(55)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(56)
expressionOut.print(createLink(controller:'loanApplication', action:'showAttachmentsAjax2'))
printHtmlPart(57)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(58)
expressionOut.print(createLink(controller:'loanApplication', action:'addAttachmentAjax2'))
printHtmlPart(59)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddAttachmentAjax'))
printHtmlPart(60)
expressionOut.print(createLink(controller:'loanApplication', action:'updateAttachmentAjax2'))
printHtmlPart(61)
expressionOut.print(createLink(controller:'loanApplication', action:'showUpdateAttachmentAjax2'))
printHtmlPart(62)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(63)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteAttachmentAjax2'))
printHtmlPart(64)
invokeTag('submitButton','g',599,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                    alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                    function(){
                    checkIfAllowed('LON00202', 'form#loan-application-form', 'Edit Loan Application', null);
                    },
                    function(){
                    return;
                    });                        
                    """)],-1)
printHtmlPart(65)
createClosureForHtmlPart(66, 3)
invokeTag('link','g',618,['action':("show"),'id':(loanApplicationInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(67)
})
invokeTag('captureContent','sitemesh',619,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',619,[:],1)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570695850503L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
