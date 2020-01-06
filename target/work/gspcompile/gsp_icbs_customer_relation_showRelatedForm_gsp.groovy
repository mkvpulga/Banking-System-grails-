import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_relation_showRelatedForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/relation/_showRelatedForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( relation in (custmRelationCustomer) ) {
printHtmlPart(2)
expressionOut.print(relation?.firstName)
printHtmlPart(3)
expressionOut.print(relation?.middleName)
printHtmlPart(3)
expressionOut.print(relation?.lastName)
printHtmlPart(3)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(relation?.birthdate)],-1)
printHtmlPart(3)
expressionOut.print(relation?.relationshipType?.itemValue)
printHtmlPart(3)
expressionOut.print(relation?.status?.description)
printHtmlPart(4)
expressionOut.print(relation.id)
printHtmlPart(5)
expressionOut.print(relation.id)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',48,['code':("relation.type.label"),'default':("Last Name ")],-1)
printHtmlPart(8)
invokeTag('textField','g',55,['class':("form-control"),'name':("lastName"),'id':("lastName${relation.id}"),'value':(relation?.firstName)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',58,['class':("form-control"),'name':("relationshipId"),'id':("relationshipId${relation.id}"),'value':(relation.id)],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',66,['code':("relation.type.label"),'default':("Middle Name ")],-1)
printHtmlPart(8)
invokeTag('textField','g',71,['class':("form-control"),'name':("middleName"),'id':("middleName${relation.id}"),'value':(relation?.middleName)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',76,['code':("relation.type.label"),'default':("First Name ")],-1)
printHtmlPart(8)
invokeTag('textField','g',81,['class':("form-control"),'name':("firstName"),'id':("firstName${relation.id}"),'value':(relation?.firstName)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',87,['code':("relation.type.label"),'default':("Birth Date ")],-1)
printHtmlPart(8)
invokeTag('customDatePicker','g',89,['id':("birthdate${relation.id}"),'name':("birthdate"),'value':(relation?.birthdate),'class':("form-control")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',93,['code':("relation.type.label"),'default':("Status ")],-1)
printHtmlPart(8)
invokeTag('select','g',98,['id':("status${relation.id}"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")),'optionKey':("id"),'optionValue':("description"),'value':(relation?.status),'class':("form-control")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',103,['code':("relation.type.label"),'default':("Relationship Type ")],-1)
printHtmlPart(8)
invokeTag('select','g',107,['id':("type${relation.id}"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")),'optionKey':("id"),'optionValue':("itemValue"),'value':(relation?.relationshipType?.id),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(relation.id)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',117,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128262L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
