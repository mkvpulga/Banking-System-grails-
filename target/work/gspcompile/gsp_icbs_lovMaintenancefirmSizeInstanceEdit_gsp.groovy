import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancefirmSizeInstanceEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/firmSizeInstanceEdit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'firmSize.label', default: 'FirmSize'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',15,['error':(error)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',16,['bean':(firmSizeInstance),'var':("error")],4)
printHtmlPart(14)
})
invokeTag('hasErrors','g',18,['bean':(firmSizeInstance)],3)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',29,['name':("id"),'value':(firmSizeInstance?.id)],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',30,['name':("version"),'value':(firmSizeInstance?.version)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: firmSizeInstance, field: 'code', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',34,['code':("firmSizeInstance.code.label"),'default':("Code")],-1)
printHtmlPart(19)
invokeTag('textField','g',37,['name':("code"),'maxlength':("100"),'required':(""),'value':(firmSizeInstance?.code),'class':("form-control")],-1)
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(22)
invokeTag('message','g',43,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',44,['bean':(firmSizeInstance),'field':("code")],5)
printHtmlPart(24)
})
invokeTag('hasErrors','g',47,['bean':(firmSizeInstance),'field':("code")],4)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: firmSizeInstance, field: 'description', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',52,['code':("frimSizeInstance.description.label"),'default':("Description")],-1)
printHtmlPart(19)
invokeTag('textField','g',55,['name':("description"),'maxlength':("100"),'required':(""),'value':(firmSizeInstance?.description),'class':("form-control")],-1)
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(22)
invokeTag('message','g',61,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',62,['bean':(firmSizeInstance),'field':("description")],5)
printHtmlPart(24)
})
invokeTag('hasErrors','g',65,['bean':(firmSizeInstance),'field':("description")],4)
printHtmlPart(27)
invokeTag('actionSubmit','g',70,['class':("btn btn-primary"),'action':("firmSizeInstanceUpdate"),'value':(message(code: 'default.button.save.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to update this firm size?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',71,['controller':("lovMaintenance"),'action':("firmSIzeInstanceUpdate")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',79,['action':("sizeOfFirmIndex")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129248L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
