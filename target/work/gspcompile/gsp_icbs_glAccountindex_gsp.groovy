import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',17,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',21,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',23,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',25,['class':("form-inline")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("name"),'title':(message(code: 'glAccount.name.label', default: 'Name'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("code"),'title':(message(code: 'glAccount.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('message','g',33,['code':("glAccount.currency.label"),'default':("Currency")],-1)
printHtmlPart(17)
invokeTag('message','g',35,['code':("glAccount.branch.label"),'default':("Branch")],-1)
printHtmlPart(18)
invokeTag('message','g',37,['code':("glAccount.type.label"),'default':("Type")],-1)
printHtmlPart(19)
invokeTag('message','g',38,['code':("glAccount.parent.label"),'default':("Parent")],-1)
printHtmlPart(20)
loop:{
int i = 0
for( glAccountInstance in (glAccountInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glAccountInstance, field: "name"))
})
invokeTag('link','g',46,['action':("show"),'id':(glAccountInstance.id)],4)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "code"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "currency.name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "branch.name"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "type"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "parent.sort_name"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',64,['total':(GlAccountInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(29)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(30)
invokeTag('message','g',70,['code':("default.home.label")],-1)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',71,['class':("create"),'action':("create")],3)
printHtmlPart(33)
expressionOut.print(createLink(uri: '/glSortCode'))
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(37).baseParams)
printHtmlPart(36)
expressionOut.print(icbs.admin.Report.get(37).outputParam)
printHtmlPart(37)
expressionOut.print(icbs.admin.Report.get(37).reportUnit)
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(39)
})
invokeTag('javascript','g',82,[:],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128956L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
