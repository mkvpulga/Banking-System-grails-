import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMastershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/userMaster'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',15,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (userMasterInstance?.username)) {
printHtmlPart(13)
invokeTag('fieldValue','g',46,['bean':(userMasterInstance),'field':("username")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.name1)) {
printHtmlPart(16)
invokeTag('fieldValue','g',52,['bean':(userMasterInstance),'field':("name1")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.name2)) {
printHtmlPart(18)
invokeTag('fieldValue','g',58,['bean':(userMasterInstance),'field':("name2")],-1)
printHtmlPart(14)
}
printHtmlPart(19)
if(true && (userMasterInstance?.name3)) {
printHtmlPart(20)
invokeTag('fieldValue','g',64,['bean':(userMasterInstance),'field':("name3")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.name4)) {
printHtmlPart(21)
invokeTag('fieldValue','g',70,['bean':(userMasterInstance),'field':("name4")],-1)
printHtmlPart(14)
}
printHtmlPart(22)
if(true && (userMasterInstance?.birthdate)) {
printHtmlPart(23)
invokeTag('formatDate','g',76,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.birthdate)],-1)
printHtmlPart(14)
}
printHtmlPart(24)
if(true && (userMasterInstance?.gender)) {
printHtmlPart(25)
expressionOut.print(userMasterInstance?.gender?.description)
printHtmlPart(14)
}
printHtmlPart(24)
if(true && (userMasterInstance?.address1)) {
printHtmlPart(26)
invokeTag('fieldValue','g',88,['bean':(userMasterInstance),'field':("address1")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.address2)) {
printHtmlPart(27)
invokeTag('fieldValue','g',94,['bean':(userMasterInstance),'field':("address2")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.province)) {
printHtmlPart(28)
expressionOut.print(userMasterInstance?.province?.itemValue)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.zipCode)) {
printHtmlPart(29)
invokeTag('fieldValue','g',106,['bean':(userMasterInstance),'field':("zipCode")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.email)) {
printHtmlPart(30)
invokeTag('fieldValue','g',112,['bean':(userMasterInstance),'field':("email")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.contact)) {
printHtmlPart(31)
invokeTag('fieldValue','g',118,['bean':(userMasterInstance),'field':("contact")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.dateHired)) {
printHtmlPart(32)
invokeTag('formatDate','g',124,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.dateHired)],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.designation)) {
printHtmlPart(33)
expressionOut.print(userMasterInstance?.designation?.description)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.branch)) {
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.branch?.name)
})
invokeTag('link','g',136,['controller':("branch"),'action':("show"),'id':(userMasterInstance?.branch?.id)],4)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.cash)) {
printHtmlPart(35)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.cash?.name)
})
invokeTag('link','g',142,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.cash?.id)],4)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.coci)) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.coci?.name)
})
invokeTag('link','g',148,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.coci?.id)],4)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.employmentType)) {
printHtmlPart(37)
expressionOut.print(userMasterInstance?.employmentType?.itemValue)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.expiryDate)) {
printHtmlPart(38)
invokeTag('formatDate','g',160,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryDate)],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.expiryPwdDate)) {
printHtmlPart(39)
invokeTag('formatDate','g',166,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryPwdDate)],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.isLocked)) {
printHtmlPart(40)
}
printHtmlPart(17)
if(true && (userMasterInstance?.hasExceededMaxLogin)) {
printHtmlPart(41)
invokeTag('formatBoolean','g',178,['boolean':(userMasterInstance?.hasExceededMaxLogin),'true':("Yes"),'false':("No")],-1)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (userMasterInstance?.configItemStatus)) {
printHtmlPart(42)
expressionOut.print(userMasterInstance?.configItemStatus?.description)
printHtmlPart(14)
}
printHtmlPart(43)
for( role in (userMasterInstance.roles) ) {
printHtmlPart(44)
expressionOut.print(role.name)
printHtmlPart(14)
}
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('form','g',212,['id':("deactivateUser"),'url':([resource:userMasterInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(47)
createClosureForHtmlPart(46, 3)
invokeTag('form','g',213,['id':("lockUserForm"),'url':([resource:userMasterInstance, action:'lock']),'method':("DELETE")],3)
printHtmlPart(47)
createClosureForHtmlPart(46, 3)
invokeTag('form','g',214,['id':("unlockUserForm"),'url':([resource:userMasterInstance, action:'unlock']),'method':("DELETE")],3)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',217,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(49)
createTagBody(3, {->
invokeTag('message','g',221,['code':("default.new.user"),'args':([entityName]),'default':("New User")],-1)
})
invokeTag('link','g',221,['class':("create"),'action':("create")],3)
printHtmlPart(50)
createTagBody(3, {->
invokeTag('message','g',222,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',222,['action':("edit"),'resource':(userMasterInstance)],3)
printHtmlPart(50)
createClosureForHtmlPart(51, 3)
invokeTag('link','g',223,['action':("resetPassword"),'resource':(userMasterInstance)],3)
printHtmlPart(50)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',224,['action':("forceLogout"),'resource':(userMasterInstance)],3)
printHtmlPart(53)
createTagBody(3, {->
printHtmlPart(54)
invokeTag('hiddenField','g',227,['name':("id"),'id':("id"),'value':(params?.id)],-1)
printHtmlPart(55)
})
invokeTag('form','g',228,['name':("refreshUserBalance"),'id':("refreshUserBalance"),'onsubmit':("callLoadingDialog();"),'url':([action:'refreshBalance',controller:'userMaster']),'method':("POST")],3)
printHtmlPart(56)
invokeTag('actionSubmit','g',237,['id':("deleteUser"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null);
                                },
                                function(){
                                    return;
                                });                          
                    """)],-1)
printHtmlPart(57)
if(true && (!userMasterInstance.hasExceededMaxLogin && !userMasterInstance.isLocked)) {
printHtmlPart(58)
invokeTag('actionSubmit','g',247,['id':("lockUser"),'action':("lock"),'value':(message(code: 'default.button.unlock.label', default: 'Lock User')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to lock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                              
                        """)],-1)
printHtmlPart(57)
}
else {
printHtmlPart(58)
invokeTag('actionSubmit','g',258,['id':("unlockUser"),'action':("unlock"),'value':(message(code: 'default.button.unlock.label', default: 'Unlock User')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to unlock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                               
                        """)],-1)
printHtmlPart(57)
}
printHtmlPart(59)
})
invokeTag('captureContent','sitemesh',294,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',295,[:],1)
printHtmlPart(60)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129598L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
