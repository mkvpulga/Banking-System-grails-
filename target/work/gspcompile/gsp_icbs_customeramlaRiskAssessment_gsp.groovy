import icbs.loans.CreditInvestigation
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringQuestionSection
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customeramlaRiskAssessment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/amlaRiskAssessment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('hiddenField','g',30,['name':("id"),'id':("id"),'value':(params.id)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score1', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',33,['code':("amlaRisk.score1.label"),'default':("Risk Classification of Person Note: if risk rating is 3 (High Risk), CRR shall be automatically tagged as High.")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',38,['noSelection':(['':'-Set Score Here-']),'id':("score1"),'name':("score1"),'from':(1..3),'value':(amlaRiskInstance.score1),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',41,['noSelection':(['':'-Set Score Here-']),'id':("score1"),'name':("score1"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',49,['bean':(amlaRiskInstance),'field':("score1")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',52,['bean':(amlaRiskInstance),'field':("score1")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score2', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',57,['code':("amlaRisk.score2.label"),'default':("Citizenship")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',62,['noSelection':(['':'-Set Score Here-']),'id':("score2"),'name':("score2"),'from':(1..3),'value':(amlaRiskInstance.score2),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',65,['noSelection':(['':'-Set Score Here-']),'id':("score2"),'name':("score2"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',73,['bean':(amlaRiskInstance),'field':("score2")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',76,['bean':(amlaRiskInstance),'field':("score2")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score3', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',81,['code':("amlaRisk.score3.label"),'default':("Geographical Address")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',86,['noSelection':(['':'-Set Score Here-']),'id':("score3"),'name':("score3"),'from':(1..3),'value':(amlaRiskInstance.score3),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',89,['noSelection':(['':'-Set Score Here-']),'id':("score3"),'name':("score3"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',96,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',97,['bean':(amlaRiskInstance),'field':("score3")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',100,['bean':(amlaRiskInstance),'field':("Geographical Address")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score4', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',105,['code':("amlaRisk.score4.label"),'default':("Individual Identification")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',110,['noSelection':(['':'-Set Score Here-']),'id':("score4"),'name':("score4"),'from':(1..3),'value':(amlaRiskInstance.score4),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',113,['noSelection':(['':'-Set Score Here-']),'id':("score4"),'name':("score4"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',120,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',121,['bean':(amlaRiskInstance),'field':("score4")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',124,['bean':(amlaRiskInstance),'field':("score4")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score5', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',129,['code':("amlaRisk.score5.label"),'default':("Occupation/Nature of work or Self-employment")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',134,['noSelection':(['':'-Set Score Here-']),'id':("score5"),'name':("score5"),'from':(1..3),'value':(amlaRiskInstance.score5),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',137,['noSelection':(['':'-Set Score Here-']),'id':("score5"),'name':("score5"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',144,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',145,['bean':(amlaRiskInstance),'field':("score5")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',148,['bean':(amlaRiskInstance),'field':("score5")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score6', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',153,['code':("amlaRisk.score6.label"),'default':("Source of Fund")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',158,['noSelection':(['':'-Set Score Here-']),'id':("score6"),'name':("score6"),'from':(1..3),'value':(amlaRiskInstance.score6),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',161,['noSelection':(['':'-Set Score Here-']),'id':("score6"),'name':("score6"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',168,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',169,['bean':(amlaRiskInstance),'field':("score6")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',172,['bean':(amlaRiskInstance),'field':("score6")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score7', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',177,['code':("amlaRisk.score7.label"),'default':("Account Opening Method; Loan Application")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',182,['noSelection':(['':'-Set Score Here-']),'id':("score7"),'name':("score7"),'from':(1..3),'value':(amlaRiskInstance.score7),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',185,['noSelection':(['':'-Set Score Here-']),'id':("score7"),'name':("score7"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',192,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',193,['bean':(amlaRiskInstance),'field':("score7")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',196,['bean':(amlaRiskInstance),'field':("score7")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score8', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',201,['code':("amlaRisk.score8.label"),'default':("Declared Gross Monthly Income/Salary")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',206,['noSelection':(['':'-Set Score Here-']),'id':("score8"),'name':("score8"),'from':(1..3),'value':(amlaRiskInstance.score8),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',209,['noSelection':(['':'-Set Score Here-']),'id':("score8"),'name':("score8"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',216,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',217,['bean':(amlaRiskInstance),'field':("score8")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',220,['bean':(amlaRiskInstance),'field':("score8")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score9', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',225,['code':("amlaRisk.score9.label"),'default':("Length of Relationship")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',230,['noSelection':(['':'-Set Score Here-']),'id':("score9"),'name':("score9"),'from':(1..3),'value':(amlaRiskInstance.score9),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',233,['noSelection':(['':'-Set Score Here-']),'id':("score9"),'name':("score9"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',240,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',241,['bean':(amlaRiskInstance),'field':("score9")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',244,['bean':(amlaRiskInstance),'field':("score9")],4)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: amlaRiskInstance, field: 'score10', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',249,['code':("amlaRisk.score10.label"),'default':("Number of Existing Loans")],-1)
printHtmlPart(13)
if(true && (amlaRiskInstance)) {
printHtmlPart(14)
invokeTag('select','g',254,['noSelection':(['':'-Set Score Here-']),'id':("score10"),'name':("score10"),'from':(1..3),'value':(amlaRiskInstance.score10),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
}
else {
printHtmlPart(14)
invokeTag('select','g',257,['noSelection':(['':'-Set Score Here-']),'id':("score10"),'name':("score10"),'from':(1..3),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(17)
createTagBody(5, {->
printHtmlPart(18)
invokeTag('message','g',264,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',265,['bean':(amlaRiskInstance),'field':("score10")],5)
printHtmlPart(20)
})
invokeTag('hasErrors','g',268,['bean':(amlaRiskInstance),'field':("score10")],4)
printHtmlPart(31)
})
invokeTag('form','g',272,['name':("myForm"),'id':("saveFormAmlaRiskAssessment"),'url':([action:'saveAmlaRisk',controller:'customer']),'method':("POST")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',275,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',278,['onclick':("saveAmlaRisk();"),'id':(params.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',279,['action':("amlaRisk"),'id':(params.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',292,['tag':("main-actions")],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',293,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128195L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
