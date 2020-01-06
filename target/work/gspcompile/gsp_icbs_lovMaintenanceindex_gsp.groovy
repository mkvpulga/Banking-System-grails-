import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenanceindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':("LOVMaintenance")],-1)
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
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',22,['controller':("lovMaintenance"),'class':("sizeOfFirmIndex"),'action':("sizeOfFirmIndex")],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',25,['controller':("lovMaintenance"),'class':("customerResidentTypeIndex"),'action':("customerResidentTypeIndex")],3)
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',28,['controller':("lovMaintenance"),'class':("townAndMunicipalityIndex"),'action':("townAndMunicipalityIndex")],3)
printHtmlPart(9)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',31,['controller':("lovMaintenance"),'class':("kindsOfLoanIndex"),'action':("kindsOfLoanIndex")],3)
printHtmlPart(9)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',34,['controller':("lovMaintenance"),'class':("loanProjectIndex"),'action':("loanProjectIndex")],3)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',37,['controller':("lovMaintenance"),'class':("loanSecurityClassificationIndex"),'action':("loanSecurityClassificationIndex")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',41,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',44,['onclick':("window.print();")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',46,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(22)
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
