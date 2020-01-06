import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_customer_customerverification_private_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/customer/customerverification/_private.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (customerInstance?.id)) {
printHtmlPart(2)
invokeTag('hiddenField','g',9,['id':("id"),'name':("id"),'value':(customerInstance.id)],-1)
printHtmlPart(1)
}
printHtmlPart(3)
expressionOut.print(hasErrors(bean: customerInstance, field: 'type', 'has-error'))
printHtmlPart(4)
invokeTag('hiddenField','g',16,['name':("type.id"),'value':(customerInstance?.type?.id)],-1)
printHtmlPart(5)
invokeTag('select','g',17,['id':("type"),'onchange':("changeVerificationForm()"),'disabled':("disabled"),'name':("type.id"),'from':(icbs.lov.CustomerType.findAllByStatusAndIdNotInList(true,['4'])),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',22,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',23,['bean':(customerInstance),'field':("type")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',26,['bean':(customerInstance),'field':("type")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: customerInstance, field: 'group', 'has-error'))
printHtmlPart(11)
invokeTag('select','g',34,['id':("group"),'name':("group.id"),'from':(icbs.admin.CustomerGroup.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(customerInstance?.group?.id),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',39,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',40,['bean':(customerInstance),'field':("group")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',43,['bean':(customerInstance),'field':("group")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: customerInstance, field: 'title', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',48,['code':("customer.title.label"),'default':("Title")],-1)
printHtmlPart(15)
invokeTag('select','g',52,['id':("title"),'name':("title.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndIdNotEqual("CT",true,65)),'optionKey':("id"),'optionValue':("itemValue"),'value':(customerInstance?.title?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',58,['bean':(customerInstance),'field':("title")],2)
printHtmlPart(20)
})
invokeTag('hasErrors','g',61,['bean':(customerInstance),'field':("title")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name1', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',65,['code':("customer.name1.label"),'default':("First Name")],-1)
printHtmlPart(23)
invokeTag('textField','g',70,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name1"),'name':("name1"),'maxlength':("50"),'':(""),'value':(customerInstance?.name1),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',75,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',76,['bean':(customerInstance),'field':("name1")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',79,['bean':(customerInstance),'field':("name1")],1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name2', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',85,['code':("customer.name2.label"),'default':("Middle Name")],-1)
printHtmlPart(26)
invokeTag('textField','g',89,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name2"),'name':("name2"),'maxlength':("50"),'':(""),'value':(customerInstance?.name2),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',94,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',95,['bean':(customerInstance),'field':("name2")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',98,['bean':(customerInstance),'field':("name2")],1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name3', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',104,['code':("customer.name3.label"),'default':("Last Name")],-1)
printHtmlPart(29)
invokeTag('textField','g',108,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name3"),'name':("name3"),'maxlength':("50"),'':(""),'value':(customerInstance?.name3),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',113,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',114,['bean':(customerInstance),'field':("name3")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',117,['bean':(customerInstance),'field':("name3")],1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name4', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',123,['code':("customer.name4.label"),'default':("Initials")],-1)
printHtmlPart(26)
invokeTag('textField','g',127,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name4"),'name':("name4"),'maxlength':("50"),'':(""),'value':(customerInstance?.name4),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',132,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',133,['bean':(customerInstance),'field':("name4")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',136,['bean':(customerInstance),'field':("name4")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: customerInstance, field: 'gender', 'has-error'))
printHtmlPart(32)
invokeTag('message','g',141,['code':("customer.gender.label"),'default':("Gender")],-1)
printHtmlPart(33)
invokeTag('select','g',145,['id':("gender"),'name':("gender.id"),'from':(icbs.lov.Gender.findAllByIdNotInListAndStatus(['1'],true)),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.gender?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',150,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',151,['bean':(customerInstance),'field':("gender")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',154,['bean':(customerInstance),'field':("gender")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthDate', 'has-error'))
printHtmlPart(34)
invokeTag('message','g',159,['code':("customer.birthDate.label"),'default':("Birth Date")],-1)
printHtmlPart(29)
invokeTag('customDatePicker','g',163,['id':("birthDate"),'name':("birthDate"),'value':(customerInstance?.birthDate),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',168,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',169,['bean':(customerInstance),'field':("birthDate")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',172,['bean':(customerInstance),'field':("birthDate")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: customerInstance, field: 'civilStatus', 'has-error'))
printHtmlPart(35)
invokeTag('select','g',181,['id':("civilStatus"),'name':("civilStatus.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeNotInList("CS",true,['0'])),'optionKey':("id"),'optionValue':("itemValue"),'value':(customerInstance?.civilStatus?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',186,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',187,['bean':(customerInstance),'field':("civilStatus")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',190,['bean':(customerInstance),'field':("civilStatus")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: customerInstance, field: 'townBirthPlace', 'has-error'))
printHtmlPart(36)
invokeTag('message','g',195,['code':("customer.townBirthPlace.label"),'default':("Birth Place")],-1)
printHtmlPart(37)
invokeTag('select','g',200,['id':("townBirthPlace"),'name':("townBirthPlace.id"),'from':(icbs.lov.Town.findAllByStatus(true)),'noSelection':(['':'']),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.townBirthPlace?.id),'class':("form-control")],-1)
printHtmlPart(38)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',204,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',204,['bean':(customerInstance),'field':("townBirthPlace")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',205,['bean':(customerInstance),'field':("townBirthPlace")],1)
printHtmlPart(39)
if(true && (duplicateList?.size()>0)) {
printHtmlPart(40)
for( customer in (duplicateList) ) {
printHtmlPart(41)
expressionOut.print(customer.name1)
printHtmlPart(42)
expressionOut.print(customer.name3)
printHtmlPart(43)
expressionOut.print(customer.name4)
printHtmlPart(43)
expressionOut.print(customer.gender?.description)
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(46)
createClosureForHtmlPart(47, 1)
invokeTag('link','g',246,['action':("customerInquiry"),'data-dismiss':("modal"),'class':("btn"),'onclick':("return confirm('Are you sure you want to return to CIF inquiries page?');")],1)
printHtmlPart(48)
if(true && (!onsubmit)) {
printHtmlPart(49)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128225L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
