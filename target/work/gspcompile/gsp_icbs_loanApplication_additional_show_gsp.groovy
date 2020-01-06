import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_additional_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/additional/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (user?.id == 16 || user?.designation?.id == 30 || user?.designation?.id == 19)) {
printHtmlPart(1)
if(true && (loanApplicationSpecAdd)) {
printHtmlPart(2)
invokeTag('fieldValue','g',13,['bean':(loanApplicationSpecAdd),'field':("camNo")],-1)
printHtmlPart(3)
invokeTag('fieldValue','g',17,['bean':(loanApplicationSpecAdd),'field':("company")],-1)
printHtmlPart(4)
invokeTag('fieldValue','g',21,['bean':(loanApplicationSpecAdd),'field':("loanSecurity")],-1)
printHtmlPart(5)
invokeTag('fieldValue','g',25,['bean':(loanApplicationSpecAdd),'field':("loanClassification")],-1)
printHtmlPart(6)
invokeTag('fieldValue','g',29,['bean':(loanApplicationSpecAdd),'field':("loanProduct")],-1)
printHtmlPart(7)
invokeTag('fieldValue','g',33,['bean':(loanApplicationSpecAdd),'field':("economicActivity")],-1)
printHtmlPart(8)
if(true && (loanApplicationSpecAdd?.interestRate)) {
printHtmlPart(9)
invokeTag('fieldValue','g',38,['bean':(loanApplicationSpecAdd),'field':("interestRate")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('fieldValue','g',46,['bean':(loanApplicationSpecAdd),'field':("repaymentType")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',50,['bean':(loanApplicationSpecAdd),'field':("mannerOfPayment")],-1)
printHtmlPart(14)
if(true && (loanApplicationSpecAdd?.amortizationPenaltyRate)) {
printHtmlPart(9)
invokeTag('fieldValue','g',56,['bean':(loanApplicationSpecAdd),'field':("amortizationPenaltyRate")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(15)
if(true && (loanApplicationSpecAdd?.preTerminationChargeRate)) {
printHtmlPart(9)
invokeTag('fieldValue','g',69,['bean':(loanApplicationSpecAdd),'field':("preTerminationChargeRate")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(16)
if(true && (loanApplicationSpecAdd?.pastdueInterestRate)) {
printHtmlPart(9)
invokeTag('fieldValue','g',81,['bean':(loanApplicationSpecAdd),'field':("pastdueInterestRate")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(17)
if(true && (loanApplicationSpecAdd?.pastduePenaltyRate)) {
printHtmlPart(9)
invokeTag('fieldValue','g',93,['bean':(loanApplicationSpecAdd),'field':("pastduePenaltyRate")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(18)
invokeTag('fieldValue','g',104,['bean':(loanApplicationSpecAdd),'field':("condition1")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',110,['bean':(loanApplicationSpecAdd),'field':("condition2")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',116,['bean':(loanApplicationSpecAdd),'field':("condition3")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',122,['bean':(loanApplicationSpecAdd),'field':("condition4")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',128,['bean':(loanApplicationSpecAdd),'field':("condition5")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',132,['bean':(loanApplicationSpecAdd),'field':("condition6")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',138,['bean':(loanApplicationSpecAdd),'field':("condition7")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',143,['bean':(loanApplicationSpecAdd),'field':("loanApplicationType")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',147,['bean':(loanApplicationSpecAdd),'field':("loanStatus")],-1)
printHtmlPart(27)
if(true && (loanApplicationSpecAdd?.totalToDate)) {
printHtmlPart(28)
invokeTag('formatNumber','g',152,['number':(loanApplicationSpecAdd?.totalToDate),'format':("###,##0.00")],-1)
printHtmlPart(29)
}
else {
printHtmlPart(11)
}
printHtmlPart(30)
invokeTag('fieldValue','g',161,['bean':(loanApplicationSpecAdd),'field':("recommendedRemarks1")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',167,['bean':(loanApplicationSpecAdd),'field':("recommendedRemarks2")],-1)
printHtmlPart(32)
expressionOut.print(loanApplicationInstance?.accountOfficer?.description)
printHtmlPart(33)
invokeTag('formatDate','g',178,['format':("MM/dd/yyyy"),'date':(loanApplicationSpecAdd?.recommendedDate)],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',183,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeRemarks")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',189,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory1")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',195,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory2")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',201,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeSignatory3")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',207,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeMember1")],-1)
printHtmlPart(39)
invokeTag('fieldValue','g',213,['bean':(loanApplicationSpecAdd),'field':("creditCommitteeMember2")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',219,['bean':(loanApplicationSpecAdd),'field':("creditCommitteePresident")],-1)
printHtmlPart(41)
invokeTag('formatDate','g',225,['format':("MM/dd/yyyy"),'date':(loanApplicationSpecAdd?.creditCommitteeDate)],-1)
printHtmlPart(42)
}
else {
printHtmlPart(43)
}
printHtmlPart(44)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129166L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
