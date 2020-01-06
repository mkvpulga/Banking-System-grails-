import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_productedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(5)
invokeTag('render','g',24,['template':("form"),'model':(['mode':'edit'])],-1)
printHtmlPart(6)
invokeTag('render','g',30,['template':("branch")],-1)
printHtmlPart(7)
invokeTag('render','g',36,['template':("customerGroup")],-1)
printHtmlPart(8)
invokeTag('render','g',42,['template':("txnTemplate")],-1)
printHtmlPart(9)
})
invokeTag('form','g',44,['id':("edit"),'url':([resource:productInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('submitButton','g',59,['name':("edit"),'id':("editProduct"),'class':("btn btn-primary"),'value':(message(code: 'default.button.save.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG00703', 'form#edit', 'Override edit Product.', null);                            
                                    },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',60,['action':("show"),'id':(productInstance.id)],3)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129314L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
