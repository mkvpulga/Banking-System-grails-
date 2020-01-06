import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_layoutslogin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/login.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("UTF-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',5,[:],-1)
printHtmlPart(2)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',9,['src':("jquery-1.11.1.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',10,['src':("bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',11,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',12,['src':("select2.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',13,['src':("TreeListFilter.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',14,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',15,['src':("plugins/datepicker/bootstrap-datepicker.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',17,['src':("namespace.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',18,['src':("ICBSDependencies.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',19,['src':("search.js")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',20,['src':("myCustomStyleSheet.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',21,['src':("bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',22,['src':("select2.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',23,['src':("select2-bootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',24,['src':("datepicker3.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',27,['src':("AdminLTE/morris/morris.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',29,['src':("AdminLTE/jvectormap/jquery-jvectormap-1.2.2.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',31,['src':("AdminLTE/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',34,['src':("main.css")],-1)
printHtmlPart(8)
expressionOut.print(resource(dir: "images", file: "body-gradient.png"))
printHtmlPart(9)
expressionOut.print(resource(dir: "images", file: "bg-translucent.png"))
printHtmlPart(10)
invokeTag('layoutHead','g',46,[:],-1)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
if(true && (session.user!=null)) {
printHtmlPart(14)
if(true && (cifMenu)) {
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (depositsMenu)) {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (loansMenu)) {
printHtmlPart(19)
}
printHtmlPart(18)
if(true && (telleringMenu)) {
printHtmlPart(20)
}
printHtmlPart(18)
if(true && (glMenu)) {
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (adminMenu)) {
printHtmlPart(22)
}
printHtmlPart(18)
if(true && (configMenu)) {
printHtmlPart(23)
}
printHtmlPart(18)
if(true && (auditMenu)) {
printHtmlPart(24)
}
printHtmlPart(25)
for( _it1008962419 in (cifMenu) ) {
changeItVariable(_it1008962419)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1100499421 in (depositsMenu) ) {
changeItVariable(_it1100499421)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1964600783 in (loansMenu) ) {
changeItVariable(_it1964600783)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1484287256 in (telleringMenu) ) {
changeItVariable(_it1484287256)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1245868040 in (glMenu) ) {
changeItVariable(_it1245868040)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1338590030 in (adminMenu) ) {
changeItVariable(_it1338590030)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it643948238 in (configMenu) ) {
changeItVariable(_it643948238)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
for( _it1667938833 in (auditMenu) ) {
changeItVariable(_it1667938833)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(30)
if(true && (cifMenu)) {
printHtmlPart(31)
for( _it1943921940 in (cifMenu) ) {
changeItVariable(_it1943921940)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(32)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (depositsMenu)) {
printHtmlPart(35)
for( _it1827323769 in (depositsMenu) ) {
changeItVariable(_it1827323769)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (loansMenu)) {
printHtmlPart(37)
for( _it666949836 in (loansMenu) ) {
changeItVariable(_it666949836)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (telleringMenu)) {
printHtmlPart(38)
for( _it1708739959 in (telleringMenu) ) {
changeItVariable(_it1708739959)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (glMenu)) {
printHtmlPart(39)
for( _it493679582 in (glMenu) ) {
changeItVariable(_it493679582)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (adminMenu)) {
printHtmlPart(40)
for( _it1543406313 in (adminMenu) ) {
changeItVariable(_it1543406313)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (configMenu)) {
printHtmlPart(41)
for( _it574930478 in (configMenu) ) {
changeItVariable(_it574930478)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(36)
if(true && (auditMenu)) {
printHtmlPart(42)
for( _it1327615893 in (auditMenu) ) {
changeItVariable(_it1327615893)
printHtmlPart(26)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(33)
}
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (session.user!=null)) {
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (session.user!=null)) {
printHtmlPart(45)
}
if(true && (session.user==null)) {
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(resource(dir: "images", file: "body-gradient.png"))
printHtmlPart(49)
if(true && (session.user!=null)) {
printHtmlPart(50)
expressionOut.print(createLink(uri: '/userMaster/changePassword'))
printHtmlPart(51)
expressionOut.print(session.user)
printHtmlPart(52)
expressionOut.print(createLink(uri: '/userMessage'))
printHtmlPart(53)
expressionOut.print(unreadMessages)
printHtmlPart(54)
expressionOut.print(createLink(uri: '/policyException'))
printHtmlPart(55)
expressionOut.print(pendingPolicyExceptions)
printHtmlPart(54)
expressionOut.print(createLink(uri: '/authentication/logout'))
printHtmlPart(56)
}
printHtmlPart(57)
if(true && (session.user==null)) {
printHtmlPart(58)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10150').paramValue)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (session.user!=null)) {
printHtmlPart(61)
}
printHtmlPart(62)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(63)
if(true && (session.user!=null)) {
printHtmlPart(64)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(65)
expressionOut.print(resource(dir: "images", file: "mbphil-logo.jpg"))
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (session.user!=null)) {
printHtmlPart(68)
expressionOut.print(session.branch)
printHtmlPart(69)
expressionOut.print(g.formatDate(date: (runDate), format: 'E, dd MMMM yyyy'))
printHtmlPart(57)
}
printHtmlPart(70)
if(true && (session.user!=null)) {
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (session.user!=null)) {
printHtmlPart(73)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(74)
invokeTag('pageProperty','g',281,['name':("page.breadcrumbs")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (pageProperty(name:'title')!='')) {
printHtmlPart(77)
invokeTag('layoutTitle','g',291,[:],-1)
printHtmlPart(78)
}
printHtmlPart(79)
invokeTag('pageProperty','g',294,['name':("page.main-content")],-1)
printHtmlPart(80)
if(true && (pageProperty(name:'page.main-actions')!='')) {
printHtmlPart(81)
invokeTag('pageProperty','g',303,['name':("page.main-actions")],-1)
printHtmlPart(82)
}
printHtmlPart(83)
expressionOut.print(resource(dir:'images', file:'spinner.gif'))
printHtmlPart(84)
invokeTag('javascript','asset',391,['src':("batch.js")],-1)
printHtmlPart(85)
})
invokeTag('captureBody','sitemesh',392,['class':("index-page")],1)
printHtmlPart(86)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129033L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
