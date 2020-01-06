import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_groupcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'group.label', default: 'Group'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'group', action:'getGroupInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'group', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'group', action:'showMembersAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'group', action:'addMemberAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'group', action:'deleteMemberAjax'))
printHtmlPart(10)
expressionOut.print(groupInstance?.parent?.id)
printHtmlPart(11)
})
invokeTag('javascript','g',83,[:],2)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',84,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('hasErrors','g',108,['bean':(groupInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',118,['template':("details/form")],-1)
printHtmlPart(20)
invokeTag('render','g',121,['template':("members/list")],-1)
printHtmlPart(21)
})
invokeTag('form','g',124,['id':("group-form"),'url':([controller:group, action:'save'])],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',126,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('submitButton','g',129,['name':("save"),'value':("Save"),'onclick':("jQuery('#group-form').submit()")],-1)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',130,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-actions")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129002L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
