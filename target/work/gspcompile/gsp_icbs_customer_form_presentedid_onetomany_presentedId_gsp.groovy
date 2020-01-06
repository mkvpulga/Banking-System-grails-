import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_presentedid_onetomany_presentedId_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/presentedid/onetomany/_presentedId.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (presentedId?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("presentedids[${i}].id"),'value':(presentedId?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',12,['name':("presentedids[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',15,['name':("presentedids[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',17,['name':("presentedids[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].type', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',22,['code':("presentedId.type.label"),'default':("Presented Id Type")],-1)
printHtmlPart(8)
invokeTag('select','g',26,['id':("presentedids[${i}].type"),'name':("presentedids[${i}].type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CIDT",true)),'optionKey':("id"),'optionValue':("itemValue"),'required':(""),'value':(presentedId?.type?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',32,['bean':(customerInstance),'field':("presentedids[${i}].type")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',35,['bean':(customerInstance),'field':("presentedids[${i}].type")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].idNo', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('message','g',41,['code':("presentedId.idNo.label"),'default':("Id No")],-1)
printHtmlPart(17)
invokeTag('textField','g',46,['name':("presentedids[${i}].idNo"),'maxlength':("50"),'value':(presentedId?.idNo),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',52,['bean':(customerInstance),'field':("presentedids[${i}].idNo")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',55,['bean':(customerInstance),'field':("presentedids[${i}].idNo")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].issueDate', 'has-error'))
printHtmlPart(19)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('message','g',62,['code':("presentedId.issueDate.label"),'default':("Issue Date")],-1)
printHtmlPart(21)
invokeTag('customDatePicker','g',66,['name':("presentedids[${i}].issueDate"),'precision':("day"),'value':(presentedId?.issueDate),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',71,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',72,['bean':(customerInstance),'field':("presentedids[${i}].issueDate")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',75,['bean':(customerInstance),'field':("presentedids[${i}].issueDate")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].validDate', 'has-error'))
printHtmlPart(19)
expressionOut.print(i)
printHtmlPart(27)
invokeTag('message','g',82,['code':("presentedId.issueDate.label"),'default':("Valid Till Date")],-1)
printHtmlPart(21)
invokeTag('customDatePicker','g',86,['name':("presentedids[${i}].validDate"),'precision':("day"),'value':(presentedId?.validDate),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',91,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',92,['bean':(customerInstance),'field':("presentedids[${i}].validDate")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',95,['bean':(customerInstance),'field':("presentedids[${i}].validDate")],1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isGovtIssue', 'has-error'))
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(30)
invokeTag('message','g',103,['code':("presentedId.isGovtIssue.label"),'default':("Is Govt Issue")],-1)
printHtmlPart(21)
invokeTag('checkBox','g',107,['name':("presentedids[${i}].isGovtIssue"),'value':(presentedId?.isGovtIssue)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',113,['bean':(customerInstance),'field':("presentedids[${i}].isGovtIssue")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',116,['bean':(customerInstance),'field':("presentedids[${i}].isGovtIssue")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isWithPhoto', 'has-error'))
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(32)
invokeTag('message','g',124,['code':("presentedId.isWithPhoto.label"),'default':("Is With Photo")],-1)
printHtmlPart(21)
invokeTag('checkBox','g',128,['name':("presentedids[${i}].isWithPhoto"),'value':(presentedId?.isWithPhoto)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',133,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',134,['bean':(customerInstance),'field':("presentedids[${i}].isWithPhoto")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',137,['bean':(customerInstance),'field':("presentedids[${i}].isWithPhoto")],1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isWithSignature', 'has-error'))
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(34)
invokeTag('message','g',144,['code':("presentedId.isWithSignature.label"),'default':("Is With Signature")],-1)
printHtmlPart(21)
invokeTag('checkBox','g',148,['name':("presentedids[${i}].isWithSignature"),'value':(presentedId?.isWithSignature)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',153,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',154,['bean':(customerInstance),'field':("presentedids[${i}].isWithSignature")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',157,['bean':(customerInstance),'field':("presentedids[${i}].isWithSignature")],1)
printHtmlPart(35)
if(true && (canDelete!="false")) {
printHtmlPart(36)
}
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128245L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
