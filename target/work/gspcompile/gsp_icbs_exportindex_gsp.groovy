import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_exportindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/export/index.gsp" }
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
createClosureForHtmlPart(9, 3)
invokeTag('link','g',26,['action':("cif"),'class':("btn btn-primary")],3)
printHtmlPart(10)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',30,['action':("deposit"),'class':("btn btn-primary")],3)
printHtmlPart(11)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',34,['action':("loanAccount"),'class':("btn btn-primary")],3)
printHtmlPart(12)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',38,['action':(""),'class':("btn btn-primary")],3)
printHtmlPart(13)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',42,['action':(""),'class':("btn btn-primary")],3)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',46,['action':("depEdCollectionProcessing"),'class':("btn btn-primary")],3)
printHtmlPart(16)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',50,['action':("loanCollectionProcessing"),'class':("btn btn-primary")],3)
printHtmlPart(17)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',54,['action':("loanCollMixedBatch"),'class':("btn btn-primary")],3)
printHtmlPart(18)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',58,['action':("importGlTransactions"),'class':("btn btn-primary")],3)
printHtmlPart(19)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',62,['action':("importDepositList"),'class':("btn btn-primary")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(4)
createClosureForHtmlPart(21, 2)
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128915L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
