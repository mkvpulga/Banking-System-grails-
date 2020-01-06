import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectionsssConfirmBillerRef_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/sssConfirmBillerRef.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('javascript','asset',15,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(13)
})
invokeTag('javascript','g',90,[:],3)
printHtmlPart(14)
expressionOut.print(icbs.tellering.SssConfig.findByParamCode("GEN.10263").paramValue)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('select','g',240,['id':("txnTemplate"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAll{id == icbs.tellering.SssConfig.findByParamCode("GEN.10262").paramValue || id == icbs.tellering.SssConfig.findByParamCode("GEN.10263").paramValue}),'optionKey':("id"),'optionValue':("description"),'value':(loanLedgerInstance?.txnType?.id),'class':("many-to-one form-control"),'onchange':("showChecksform(this.value);")],-1)
printHtmlPart(17)
if(true && (txnCOCIInstance?.checks)) {
printHtmlPart(18)
for( check in (txnCOCIInstance?.checks.sort{it.description}) ) {
printHtmlPart(19)
expressionOut.print(check?.checkType?.description)
printHtmlPart(20)
expressionOut.print(check?.bank?.name)
printHtmlPart(20)
expressionOut.print(check?.acctNo)
printHtmlPart(20)
expressionOut.print(check?.checkDate)
printHtmlPart(20)
expressionOut.print(check?.checkNo)
printHtmlPart(20)
expressionOut.print(check?.checkAmt)
printHtmlPart(21)
expressionOut.print(check?.id)
printHtmlPart(22)
}
printHtmlPart(23)
}
else if(true && (session["checks"])) {
printHtmlPart(18)
invokeTag('set','g',294,['var':("i"),'value':(0)],-1)
printHtmlPart(18)
for( check in (session["checks"]) ) {
printHtmlPart(19)
expressionOut.print(check?.checkType?.description)
printHtmlPart(20)
expressionOut.print(check?.bank?.name)
printHtmlPart(20)
expressionOut.print(check?.acctNo)
printHtmlPart(20)
expressionOut.print(check?.checkDate)
printHtmlPart(20)
expressionOut.print(check?.checkNo)
printHtmlPart(20)
expressionOut.print(check?.checkAmt)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(24)
invokeTag('set','g',307,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(18)
}
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('hiddenField','g',315,['id':("sssReturnValues"),'name':("sssReturnValues"),'value':(theReturnValue)],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',316,['id':("sssamount"),'name':("sssamount"),'value':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',318,['id':("sssappmo"),'name':("sssappmo"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',319,['id':("ssstxnBillRef"),'name':("ssstxnBillRef"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',320,['id':("ssserbrn"),'name':("ssserbrn"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',321,['id':("sssername"),'name':("sssername"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',322,['id':("sssernum"),'name':("sssernum"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',323,['id':("sssreplyCode"),'name':("sssreplyCode"),'value':("")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',324,['id':("sssreplyDate"),'name':("sssreplyDate"),'value':("")],-1)
printHtmlPart(29)
invokeTag('textField','g',327,['id':("amount"),'name':("amount"),'value':(""),'class':("form-control truncated"),'disabled':("disable")],-1)
printHtmlPart(30)
invokeTag('textField','g',333,['id':("appmo"),'name':("appmo"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(31)
invokeTag('textField','g',339,['id':("txnBillRef"),'name':("txnBillRef"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(32)
invokeTag('textField','g',345,['id':("erbrn"),'name':("erbrn"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(33)
invokeTag('textField','g',351,['id':("ername"),'name':("ername"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(34)
invokeTag('textField','g',357,['id':("ernum"),'name':("ernum"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(35)
invokeTag('textField','g',363,['id':("replyCode"),'name':("replyCode"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(36)
invokeTag('textField','g',369,['id':("replyDate"),'name':("replyDate"),'value':(""),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(37)
invokeTag('textField','g',375,['id':("txnReference"),'name':("txnReference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(38)
invokeTag('textArea','g',381,['name':("txnParticulars"),'id':("txnParticulars"),'value':(""),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',382,['name':("wsdlMethod"),'id':("wsdlMethod"),'value':("submitPaidBRNum")],-1)
printHtmlPart(39)
})
invokeTag('form','g',383,['id':("create"),'url':([action:'saveSssTxn',controller: 'SssCollection']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',383,['tag':("main-content")],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',392,['action':("index")],3)
printHtmlPart(44)
expressionOut.print(createLink(controller:'SssCollection', action:'sampleCreate'))
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',438,['tag':("main-actions")],2)
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',440,[:],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129391L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
