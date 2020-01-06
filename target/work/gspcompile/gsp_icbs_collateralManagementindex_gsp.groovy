import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagementindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
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
invokeTag('select','g',24,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',27,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Collateral ID")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',29,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(12)
})
invokeTag('form','g',34,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',40,['property':("id"),'title':("ID")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',42,['property':("collateralType.owner.displayName"),'title':("Owner")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',44,['property':("collateralType.description"),'title':("Type")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',46,['property':("appraisedValue"),'title':("Appraised Value")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',48,['property':("description"),'title':("Description")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',50,['property':("status.description"),'title':("Status")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( collateralInstance in (collateralInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(fieldValue(bean: collateralInstance, field: "id"))
printHtmlPart(20)
expressionOut.print(collateralInstance?.owner?.displayName)
printHtmlPart(20)
expressionOut.print(collateralInstance?.collateralType?.description)
printHtmlPart(21)
invokeTag('formatNumber','g',66,['format':("###,###,##0.00"),'number':(collateralInstance?.appraisedValue)],-1)
printHtmlPart(22)
expressionOut.print(collateralInstance?.description)
printHtmlPart(23)
expressionOut.print(collateralInstance?.status?.description)
printHtmlPart(21)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',72,['class':("btn btn-secondary"),'action':("show"),'id':(collateralInstance.id)],4)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',80,['total':(collateralInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',86,['class':("create"),'action':("create")],3)
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(31)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(18).baseParams)
printHtmlPart(32)
expressionOut.print(icbs.admin.Report.get(18).outputParam)
printHtmlPart(33)
expressionOut.print(icbs.admin.Report.get(18).reportUnit)
printHtmlPart(34)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(35)
})
invokeTag('javascript','g',95,[:],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128078L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
