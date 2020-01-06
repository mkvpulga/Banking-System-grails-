import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_groupindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'group.label', default: 'Group'))],-1)
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
invokeTag('select','g',26,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',29,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Group Name")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',36,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',42,['property':("id"),'title':("ID")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',44,['property':("name"),'title':("Name")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',46,['property':("type.description"),'title':("Type")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',48,['property':("meetingDate"),'title':("Meeting Date")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( groupInstance in (groupInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(groupInstance?.id)
printHtmlPart(18)
expressionOut.print(groupInstance?.name)
printHtmlPart(18)
expressionOut.print(groupInstance?.type?.description)
printHtmlPart(18)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(groupInstance?.meetingDate)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('link','g',60,['class':("btn btn-secondary"),'action':("show"),'id':(groupInstance.id)],4)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',67,['total':(groupInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',73,['class':("create"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129008L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
