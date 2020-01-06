import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_rem_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/rem/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: remInstance, field: 'landArea', 'has-error'))
printHtmlPart(1)
invokeTag('field','g',6,['name':("landArea"),'value':(remInstance?.landArea),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(it)
printHtmlPart(4)
})
invokeTag('hasErrors','g',16,['bean':(remInstance),'field':("landArea")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'tctNo', 'has-error'))
printHtmlPart(6)
invokeTag('field','g',25,['name':("tctNo"),'value':(remInstance?.tctNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(it)
printHtmlPart(4)
})
invokeTag('hasErrors','g',35,['bean':(remInstance),'field':("tctNo")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'lotNo', 'has-error'))
printHtmlPart(7)
invokeTag('field','g',44,['name':("lotNo"),'value':(remInstance?.lotNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(it)
printHtmlPart(4)
})
invokeTag('hasErrors','g',54,['bean':(remInstance),'field':("lotNo")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'location', 'has-error'))
printHtmlPart(8)
invokeTag('field','g',63,['name':("location"),'value':(remInstance?.location),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(it)
printHtmlPart(4)
})
invokeTag('hasErrors','g',73,['bean':(remInstance),'field':("location")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'otherOwners', 'has-error'))
printHtmlPart(10)
invokeTag('field','g',81,['name':("otherOwners"),'value':(remInstance?.otherOwners),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',86,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',87,['bean':(remInstance),'field':("otherOwners")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',90,['bean':(remInstance),'field':("otherOwners")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'registryOfDeeds', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',99,['name':("registryOfDeeds"),'value':(remInstance?.registryOfDeeds),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',104,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',105,['bean':(remInstance),'field':("registryOfDeeds")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',108,['bean':(remInstance),'field':("registryOfDeeds")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: remInstance, field: 'dateOfIssuance', 'has-error'))
printHtmlPart(16)
invokeTag('customDatePicker','g',117,['name':("dateOfIssuance"),'precision':("day"),'class':("form-control"),'value':(remInstance?.dateOfIssuance)],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',122,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',123,['bean':(remInstance),'field':("dateOfIssuance")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',126,['bean':(remInstance),'field':("dateOfIssuance")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: remInstance, field: 'encumberances', 'has-error'))
printHtmlPart(19)
invokeTag('field','g',134,['name':("encumberances"),'value':(remInstance?.encumberances),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',139,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',140,['bean':(remInstance),'field':("encumberances")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',143,['bean':(remInstance),'field':("encumberances")],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128087L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
