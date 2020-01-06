import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateglLinkCreateNewEntry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/glLinkCreateNewEntry.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,['id':("titles")],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action:'checkduplicatesCfgglAcctDetAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'insertnewcfgDetAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'editCfgDetInformationAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'checkGlcodeAjax'))
printHtmlPart(11)
})
invokeTag('javascript','g',396,[:],3)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',402,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Acct Template id")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',405,['id':("cfgdetid"),'name':("cfgdetid"),'value':("")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',406,['id':("cfgtemplateid"),'name':("cfgtemplateid"),'value':(params.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',407,['id':("finyear"),'name':("finyear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',408,['id':("brchid"),'name':("brchid"),'value':(icbs.admin.Branch.findByName(session.branch).id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',409,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(16)
invokeTag('textField','g',411,['id':("cfgdescripss"),'name':("cfgdescripss"),'required':(""),'value':(icbs.gl.CfgAcctGlTemplate.findById(params.id).description),'class':("form-control"),'readonly':("readonly")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',417,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Transaction Type")],-1)
printHtmlPart(18)
invokeTag('select','g',421,['id':("transactionType"),'name':("transactionType"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.GlLinkEntryType.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("changeDropdownStatus();"),'class':("form-control")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',428,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(20)
invokeTag('select','g',432,['id':("status"),'name':("status"),'required':("true"),'noSelection':(['':' ']),'from':(icbs.lov.DepositStatus.findAll{id == 2 || id == 5}),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'class':("form-control")],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',439,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(20)
invokeTag('select','g',443,['id':("status1"),'name':("status1"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.LoanPerformanceId.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'class':("form-control")],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',450,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(23)
invokeTag('select','g',453,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionType(1)),'optionKey':("id"),'optionValue':("description"),'value':(""),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',459,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(25)
invokeTag('select','g',462,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionType(6)),'value':(""),'optionKey':("id"),'optionValue':("description"),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(26)
invokeTag('select','g',465,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionTypeAndIdNotEqual(6,15)),'value':(""),'optionKey':("id"),'optionValue':("description"),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',473,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Code")],-1)
printHtmlPart(23)
invokeTag('textField','g',476,['id':("glCode"),'name':("glCode"),'required':(""),'value':(""),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(3, {->
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
invokeTag('message','g',482,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',483,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],4)
printHtmlPart(32)
})
invokeTag('hasErrors','g',486,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],3)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',492,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Description")],-1)
printHtmlPart(23)
invokeTag('textField','g',495,['id':("glDescription"),'name':("glDescription"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(3, {->
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
invokeTag('message','g',501,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',502,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],4)
printHtmlPart(32)
})
invokeTag('hasErrors','g',505,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',512,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',517,['action':("show"),'id':(params.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',519,['tag':("main-actions")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',521,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673127994L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
