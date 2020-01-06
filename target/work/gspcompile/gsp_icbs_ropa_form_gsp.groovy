import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("loanID"),'name':("loanID"),'value':(ropaInstance?.loan)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loanLedger.loan.label"),'default':("Loan Account")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("accountNo"),'value':(ropaInstance?.loan),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it)
printHtmlPart(6)
})
invokeTag('hasErrors','g',19,['bean':(loanLedgerInstance),'field':("loan")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loan', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',26,['name':("loanAccountName"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.loan?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',32,['bean':(ropaInstance),'field':("loan")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',35,['bean':(ropaInstance),'field':("loan")],1)
printHtmlPart(14)
invokeTag('hiddenField','g',38,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'glContraLitigationExp', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',41,['id':("glContraLitigationExp"),'name':("glContraLitigationExp"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.glContraLitigationExp),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',46,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',47,['bean':(ropaInstance),'field':("glContraLitigationExp")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',50,['bean':(ropaInstance),'field':("glContraLitigationExp")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',56,['code':("txnTemplate.memoTxnType.label"),'default':("GL Account Name")],-1)
printHtmlPart(18)
invokeTag('textField','g',59,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'maxlength':("100"),'value':(""),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',66,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(23)
})
invokeTag('hasErrors','g',69,['bean':(ropaInstance),'field':("memoTxnType")],1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'glContraRopa', 'has-error'))
printHtmlPart(25)
invokeTag('textField','g',75,['id':("glContraRopa"),'name':("glContraRopa"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.glContraRopa),'onblur':("validateGlCodeROPA();"),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',80,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',81,['bean':(ropaInstance),'field':("glContraRopa")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',84,['bean':(ropaInstance),'field':("glContraRopa")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',90,['code':("txnTemplate.memoTxnType.label"),'default':("GL Account Name")],-1)
printHtmlPart(18)
invokeTag('textField','g',93,['readonly':("true"),'name':("gldescriptionContra"),'id':("gldescriptionContra"),'maxlength':("100"),'value':(""),'onblur':("validateGlCodeROPA();"),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('message','g',99,['error':(it)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',100,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(23)
})
invokeTag('hasErrors','g',103,['bean':(ropaInstance),'field':("memoTxnType")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ropaDate', 'has-error'))
printHtmlPart(27)
invokeTag('customDatePicker','g',113,['name':("ropaDate"),'precision':("day"),'class':("form-control"),'value':(ropaInstance?.ropaDate)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',119,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',120,['bean':(ropaInstance),'field':("ropaDate")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',123,['bean':(ropaInstance),'field':("ropaDate")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(30)
invokeTag('select','g',130,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(38))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'reference', 'has-error'))
printHtmlPart(32)
invokeTag('textField','g',136,['id':("reference"),'name':("reference"),'maxlength':("25"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',141,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',142,['bean':(ropaInstance),'field':("reference")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',145,['bean':(ropaInstance),'field':("reference")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'particulars', 'has-error'))
printHtmlPart(33)
invokeTag('textField','g',151,['id':("particulars"),'name':("particulars"),'maxlength':("255"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',156,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',157,['bean':(ropaInstance),'field':("particulars")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',160,['bean':(ropaInstance),'field':("particulars")],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129336L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
