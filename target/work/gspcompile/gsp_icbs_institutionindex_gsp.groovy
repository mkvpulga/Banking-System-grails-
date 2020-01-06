import icbs.admin.Institution
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_institutionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/institution/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'institution.label', default: 'Institution'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
expressionOut.print(params?.query)
printHtmlPart(11)
invokeTag('submitButton','g',24,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',28,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',32,['property':("id"),'title':(message(code: 'institution.id.label', default: 'ID'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',33,['property':("paramCode"),'title':(message(code: 'institution.paramCode.label', default: 'Param Code'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',34,['property':("caption"),'title':(message(code: 'institution.caption.label', default: 'Caption'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',35,['property':("paramValue"),'title':(message(code: 'institution.paramValue.label', default: 'Param Value'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( institutionInstance in (institutionInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(fieldValue(bean: institutionInstance, field: "id"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: institutionInstance, field: "paramCode"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: institutionInstance, field: "caption"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: institutionInstance, field: "paramValue"))
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(22)
expressionOut.print(i)
printHtmlPart(23)
invokeTag('textField','g',68,['class':("form-control"),'id':("pcode${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "paramCode")),'readonly':("readonly")],-1)
printHtmlPart(24)
invokeTag('textField','g',72,['class':("form-control"),'id':("caption${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "caption")),'readonly':("readonly")],-1)
printHtmlPart(25)
invokeTag('textField','g',76,['class':("form-control"),'id':("paramvalue${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "paramValue"))],-1)
printHtmlPart(26)
expressionOut.print(i)
printHtmlPart(27)
createTagBody(4, {->
printHtmlPart(28)
expressionOut.print(createLink(controller:'institution', action:'updateParamvalue'))
printHtmlPart(29)
})
invokeTag('javascript','g',132,[:],4)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',144,['total':(InstitutionInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',157,['onclick':("window.print();")],3)
printHtmlPart(36)
invokeTag('textField','g',171,['class':("form-control"),'id':("crtpcode"),'name':("crtpcode"),'value':("")],-1)
printHtmlPart(24)
invokeTag('textField','g',175,['class':("form-control"),'id':("crtcaption"),'name':("crtcaption"),'value':("")],-1)
printHtmlPart(37)
invokeTag('textField','g',179,['class':("form-control"),'id':("crtparamtype"),'name':("crtparamtype"),'value':("")],-1)
printHtmlPart(38)
invokeTag('textField','g',183,['class':("form-control"),'id':("crtparamvalue"),'name':("crtparamvalue"),'value':("")],-1)
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
expressionOut.print(createLink(controller:'institution', action:'createNewInstitutionAjax'))
printHtmlPart(41)
})
invokeTag('javascript','g',248,[:],3)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',258,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',259,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129024L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
