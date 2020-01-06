import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(5)
})
invokeTag('javascript','g',84,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',85,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',89,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
expressionOut.print(it)
printHtmlPart(13)
})
invokeTag('hasErrors','g',109,['bean':(loanApplicationInstance)],3)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(14)
if(true && (role)) {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',126,['template':("specification/form")],-1)
printHtmlPart(17)
invokeTag('render','g',129,['template':("financialDetails/list")],-1)
printHtmlPart(18)
invokeTag('render','g',131,['template':("comakers/list")],-1)
printHtmlPart(19)
invokeTag('render','g',135,['template':("collateral/list")],-1)
printHtmlPart(20)
invokeTag('render','g',139,['template':("loanApplicationChecklist/checklist")],-1)
printHtmlPart(21)
invokeTag('render','g',143,['template':("attachments/list")],-1)
printHtmlPart(22)
})
invokeTag('form','g',145,['id':("loan-application-form"),'onsubmit':("callLoadingDialog();"),'url':([resource:loanApplicationInstance, action:'save'])],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(24)
expressionOut.print(createLink(controller:'loanApplication', action:'showAttachmentsAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loanApplication', action:'addAttachmentAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddAttachmentAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller:'loanApplication', action:'updateAttachmentAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller:'loanApplication', action:'showUpdateAttachmentAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteAttachmentAjax'))
printHtmlPart(30)
invokeTag('submitButton','g',255,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                    alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                    function(){
                    checkIfAllowed('LON00201', 'form#loan-application-form', 'Create Loan Application', null);
                    },
                    function(){
                    return;
                    });                         
                    """)],-1)
printHtmlPart(31)
expressionOut.print(createLink(controller:'loanApplication', action:'showCollateralAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller:'loanApplication', action:'addCollateralAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'collateralManagement', action:'search'))
printHtmlPart(34)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteCollateralAjax'))
printHtmlPart(35)
expressionOut.print(loanApplicationInstance?.customer?.id ?: customer?.id)
printHtmlPart(36)
expressionOut.print(createLink(controller:'loanApplication', action:'showComakersAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller:'loanApplication', action:'addComakerAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(39)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteComakerAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller:'loanApplication', action:'showFinancialDetailsAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loanApplication', action:'addFinancialDetailAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddFinancialDetailAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller:'loanApplication', action:'updateFinancialDetailAjax'))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loanApplication', action:'showUpdateFinancialDetailAjax'))
printHtmlPart(45)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteFinancialDetailAjax'))
printHtmlPart(46)
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(47)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',508,['tag':("main-actions")],2)
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',509,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570765118494L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
