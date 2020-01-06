import icbs.deposit.FixedDepositTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'fixedDepositTermScheme.label', default: 'FixedDepositTermScheme'))],-1)
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
if(true && (fixedDepositTermSchemeInstance?.code)) {
printHtmlPart(9)
invokeTag('fieldValue','g',39,['bean':(fixedDepositTermSchemeInstance),'field':("code")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositTermSchemeInstance?.description)) {
printHtmlPart(12)
invokeTag('fieldValue','g',45,['bean':(fixedDepositTermSchemeInstance),'field':("description")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositTermSchemeInstance?.value)) {
printHtmlPart(13)
invokeTag('fieldValue','g',51,['bean':(fixedDepositTermSchemeInstance),'field':("value")],-1)
printHtmlPart(10)
}
printHtmlPart(14)
if(true && (fixedDepositTermSchemeInstance?.termMin)) {
printHtmlPart(15)
invokeTag('fieldValue','g',57,['bean':(fixedDepositTermSchemeInstance),'field':("termMin")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositTermSchemeInstance?.termMax)) {
printHtmlPart(16)
invokeTag('fieldValue','g',63,['bean':(fixedDepositTermSchemeInstance),'field':("termMax")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositTermSchemeInstance?.status)) {
printHtmlPart(17)
expressionOut.print(fixedDepositTermSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(10)
}
printHtmlPart(18)
invokeTag('sortableColumn','g',83,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',84,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( product in (fixedDepositTermSchemeInstance.products) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',90,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(23)
expressionOut.print(product.name)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',104,['class':("list"),'action':("index")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',105,['class':("create"),'action':("create")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',107,['action':("edit"),'controller':("FixedDepositTermScheme"),'id':(fixedDepositTermSchemeInstance.id)],3)
printHtmlPart(33)
if(true && (fixedDepositTermSchemeInstance.status.id == 1)) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('form','g',111,['id':("activatefixedDepositTermSchemeForm"),'url':([id:fixedDepositTermSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(35)
invokeTag('actionSubmit','g',112,['id':("activatefixedDepositTermScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
}
printHtmlPart(37)
if(true && (fixedDepositTermSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('form','g',118,['id':("deletefixedDepositTermSchemeForm"),'url':([id:fixedDepositTermSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(35)
invokeTag('actionSubmit','g',127,['id':("deletefixedDepositTermScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01504', 'form#deletefixedDepositTermSchemeForm', 'Override new fixed deposit term scheme form.', null); 
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(38)
}
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',141,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',142,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128932L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
