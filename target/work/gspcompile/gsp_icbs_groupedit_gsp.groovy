import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_groupedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'group.label', default: 'Group'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'group', action:'getGroupInfoAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'group', action:'search'))
printHtmlPart(5)
expressionOut.print(groupInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'group', action:'showMembersAjax2'))
printHtmlPart(7)
expressionOut.print(groupInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller:'group', action:'addMemberAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(10)
expressionOut.print(groupInstance?.id)
printHtmlPart(11)
expressionOut.print(createLink(controller:'group', action:'deleteMemberAjax2'))
printHtmlPart(12)
expressionOut.print(groupInstance?.parent?.id)
printHtmlPart(13)
})
invokeTag('javascript','g',85,[:],2)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',86,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('hasErrors','g',110,['bean':(groupInstance)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',112,['name':("version"),'value':(groupInstance?.version)],-1)
printHtmlPart(22)
invokeTag('render','g',121,['template':("details/form")],-1)
printHtmlPart(23)
invokeTag('render','g',124,['template':("members/list")],-1)
printHtmlPart(24)
})
invokeTag('form','g',127,['id':("group-form"),'url':([controller:group, action:'update', id:groupInstance?.id]),'method':("PUT")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',129,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('submitButton','g',132,['name':("save"),'value':("Save"),'onclick':("jQuery('#group-form').submit()")],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',133,['action':("show"),'id':(groupInstance?.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',135,['tag':("main-actions")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129006L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
