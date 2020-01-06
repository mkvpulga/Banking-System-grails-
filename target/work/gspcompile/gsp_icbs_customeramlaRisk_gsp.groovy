import icbs.deposit.Signatory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customeramlaRisk_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/amlaRisk.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
printHtmlPart(7)
invokeTag('hiddenField','g',31,['name':("customerId"),'id':("customerId"),'value':(params.id)],-1)
printHtmlPart(8)
if(true && (amlaRiskInstance?.score1 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score1 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score1 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score1)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score1 == 1)) {
printHtmlPart(15)
}
else if(true && (amlaRiskInstance?.score1 == 2)) {
printHtmlPart(16)
}
else if(true && (amlaRiskInstance?.score1 == 3)) {
printHtmlPart(17)
}
else {
printHtmlPart(12)
}
printHtmlPart(18)
if(true && (amlaRiskInstance?.score2 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score2 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score2 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score2)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score2 == 1)) {
printHtmlPart(19)
}
else if(true && (amlaRiskInstance?.score2 == 2)) {
printHtmlPart(20)
}
else if(true && (amlaRiskInstance?.score2 == 3)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (amlaRiskInstance?.score3 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score3 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score3 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score3)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score3 == 1)) {
printHtmlPart(24)
}
else if(true && (amlaRiskInstance?.score3 == 2)) {
printHtmlPart(25)
}
else if(true && (amlaRiskInstance?.score3 == 3)) {
printHtmlPart(26)
}
else {
printHtmlPart(22)
}
printHtmlPart(27)
if(true && (amlaRiskInstance?.score4 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score4 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score4 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score4)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score4 == 1)) {
printHtmlPart(28)
}
else if(true && (amlaRiskInstance?.score4 == 2)) {
printHtmlPart(29)
}
else if(true && (amlaRiskInstance?.score4 == 3)) {
printHtmlPart(30)
}
else {
printHtmlPart(22)
}
printHtmlPart(31)
if(true && (amlaRiskInstance?.score5 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score5 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score5 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score5)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score5 == 1)) {
printHtmlPart(32)
}
else if(true && (amlaRiskInstance?.score5 == 2)) {
printHtmlPart(33)
}
else if(true && (amlaRiskInstance?.score5 == 3)) {
printHtmlPart(34)
}
else {
printHtmlPart(22)
}
printHtmlPart(35)
if(true && (amlaRiskInstance?.score6 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score6 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score6 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score6)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score6 == 1)) {
printHtmlPart(36)
}
else if(true && (amlaRiskInstance?.score6 == 2)) {
printHtmlPart(37)
}
else if(true && (amlaRiskInstance?.score6 == 3)) {
printHtmlPart(38)
}
else {
printHtmlPart(22)
}
printHtmlPart(39)
if(true && (amlaRiskInstance?.score7 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score7 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score7 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score7)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score7 == 1)) {
printHtmlPart(40)
}
else if(true && (amlaRiskInstance?.score7 == 2)) {
printHtmlPart(41)
}
else if(true && (amlaRiskInstance?.score7 == 3)) {
printHtmlPart(42)
}
else {
printHtmlPart(22)
}
printHtmlPart(43)
if(true && (amlaRiskInstance?.score8 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score8 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score8 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score8)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score8 == 1)) {
printHtmlPart(44)
}
else if(true && (amlaRiskInstance?.score8 == 2)) {
printHtmlPart(45)
}
else if(true && (amlaRiskInstance?.score8 == 3)) {
printHtmlPart(46)
}
else {
printHtmlPart(22)
}
printHtmlPart(47)
if(true && (amlaRiskInstance?.score9 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score9 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score9 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score9)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score9 == 1)) {
printHtmlPart(48)
}
else if(true && (amlaRiskInstance?.score9 == 2)) {
printHtmlPart(49)
}
else if(true && (amlaRiskInstance?.score9 == 3)) {
printHtmlPart(50)
}
else {
printHtmlPart(22)
}
printHtmlPart(51)
if(true && (amlaRiskInstance?.score10 == 1)) {
printHtmlPart(9)
}
else if(true && (amlaRiskInstance?.score10 == 2)) {
printHtmlPart(10)
}
else if(true && (amlaRiskInstance?.score10 == 3)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(amlaRiskInstance?.score10)
printHtmlPart(14)
if(true && (amlaRiskInstance?.score10 == 1)) {
printHtmlPart(52)
}
else if(true && (amlaRiskInstance?.score10 == 2)) {
printHtmlPart(53)
}
else if(true && (amlaRiskInstance?.score10 == 3)) {
printHtmlPart(54)
}
else {
printHtmlPart(22)
}
printHtmlPart(55)
if(true && (totalScore >= 1 && totalScore <= 15)) {
printHtmlPart(56)
}
else if(true && (totalScore >= 16 && totalScore <= 25)) {
printHtmlPart(57)
}
else if(true && (totalScore >= 26 && totalScore <= 30)) {
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(totalScore)
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',376,['tag':("main-content")],2)
printHtmlPart(62)
createTagBody(2, {->
printHtmlPart(63)
createClosureForHtmlPart(64, 3)
invokeTag('link','g',379,['action':("createAmlaRisk"),'id':(params.id)],3)
printHtmlPart(65)
createClosureForHtmlPart(66, 3)
invokeTag('link','g',380,['action':("customerInquiry"),'id':(params.id)],3)
printHtmlPart(67)
})
invokeTag('captureContent','sitemesh',382,['tag':("main-actions")],2)
printHtmlPart(68)
})
invokeTag('captureBody','sitemesh',383,[:],1)
printHtmlPart(69)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128193L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
