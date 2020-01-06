import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_amendStatus_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/amendStatus/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: depositInstance, field: 'branch', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',11,['code':("deposit.branch.label"),'default':("Branch")],-1)
printHtmlPart(4)
invokeTag('select','g',14,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.list(sort: "name", order: "asc")),'optionKey':("id"),'optionValue':("name"),'value':(branch?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',19,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',20,['bean':(depositInstance),'field':("branch")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',23,['bean':(depositInstance),'field':("branch")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'reference', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',28,['code':("deposit.reference.label"),'default':("Reference")],-1)
printHtmlPart(4)
invokeTag('textArea','g',31,['name':("reference"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(holdInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: depositInstance, field: 'remarks', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',37,['code':("deposit.remarks.label"),'default':("Particulars")],-1)
printHtmlPart(4)
invokeTag('textArea','g',40,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(holdInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128278L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
