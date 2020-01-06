import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_otheracct_onetomany_otherAcct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/otheracct/onetomany/_otherAcct.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (otherAcct?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',10,['name':("otheraccts[${i}].id"),'value':(otherAcct?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("otheraccts[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',14,['name':("otheraccts[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',16,['name':("otheraccts[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].type', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',21,['code':("otherAcct.type.label"),'default':("Other Acct Type Id")],-1)
printHtmlPart(8)
invokeTag('select','g',25,['id':("otheraccts[${i}].type"),'name':("otheraccts[${i}].type.id"),'from':(icbs.lov.OtherAcctType.list()),'optionValue':("description"),'optionKey':("id"),'value':(otherAcct?.type?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',30,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',31,['bean':(customerInstance),'field':("otheraccts[${i}].type")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',34,['bean':(customerInstance),'field':("otheraccts[${i}].type")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].bankName', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('message','g',40,['code':("otherAcct.bankName.label"),'default':("Bank Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',44,['name':("otheraccts[${i}].bankName"),'maxlength':("50"),'value':(otherAcct?.bankName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',49,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',50,['bean':(customerInstance),'field':("otheraccts[${i}].bankName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',53,['bean':(customerInstance),'field':("otheraccts[${i}].bankName")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].branchName', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',59,['code':("otherAcct.branchName.label"),'default':("Branch Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',63,['name':("otheraccts[${i}].branchName"),'maxlength':("50"),'value':(otherAcct?.branchName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',68,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',69,['bean':(customerInstance),'field':("otheraccts[${i}].branchName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',72,['bean':(customerInstance),'field':("otheraccts[${i}].branchName")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].acctNo', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(19)
invokeTag('message','g',78,['code':("otherAcct.acctNo.label"),'default':("Acct No")],-1)
printHtmlPart(8)
invokeTag('textField','g',82,['name':("otheraccts[${i}].acctNo"),'maxlength':("30"),'value':(otherAcct?.acctNo),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',87,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',88,['bean':(customerInstance),'field':("otheraccts[${i}].acctNo")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',91,['bean':(customerInstance),'field':("otheraccts[${i}].acctNo")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].isOtherAcctJoint', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('message','g',97,['code':("otherAcct.isOtherAcctJoint.label"),'default':("Is Other Acct Joint")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',101,['name':("otheraccts[${i}].isOtherAcctJoint"),'value':(otherAcct?.isOtherAcctJoint)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',106,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',107,['bean':(customerInstance),'field':("otheraccts[${i}].isOtherAcctJoint")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',110,['bean':(customerInstance),'field':("otheraccts[${i}].isOtherAcctJoint")],1)
printHtmlPart(21)
if(true && (canDelete!="false")) {
printHtmlPart(22)
}
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128242L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
