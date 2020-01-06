import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_balance_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/balance/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( installment in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sort{it.sequenceNo}) ) {
printHtmlPart(1)
expressionOut.print(installment?.sequenceNo)
printHtmlPart(2)
invokeTag('formatDate','g',24,['format':("MM-dd-yyyy"),'date':(installment?.installmentDate)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',25,['format':("###,##0.00"),'number':(installment?.principalInstallmentAmount)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',26,['format':("###,##0.00"),'number':(installment?.principalInstallmentPaid)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',27,['format':("###,##0.00"),'number':(installment?.principalInstallmentAmount - installment?.principalInstallmentPaid)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',28,['format':("###,##0.00"),'number':(installment?.interestInstallmentAmount)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',29,['format':("###,##0.00"),'number':(installment?.interestInstallmentPaid)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',30,['format':("###,##0.00"),'number':(installment?.interestInstallmentAmount - installment?.interestInstallmentPaid)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',31,['format':("###,##0.00"),'number':(installment?.penaltyInstallmentAmount - installment?.penaltyInstallmentPaid)],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',32,['format':("###,##0.00"),'number':(installment?.serviceChargeInstallmentAmount - installment?.serviceChargeInstallmentPaid)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
for( totalpri in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentAmount}) ) {
printHtmlPart(9)
for( totalpripd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentPaid}) ) {
printHtmlPart(10)
for( totalint in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}) ) {
printHtmlPart(11)
for( totalintpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}) ) {
printHtmlPart(12)
for( totalpen in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentAmount}) ) {
printHtmlPart(13)
for( totalpenpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentPaid}) ) {
printHtmlPart(14)
for( totalser in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentAmount}) ) {
printHtmlPart(15)
for( totalserpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentPaid}) ) {
printHtmlPart(16)
invokeTag('formatNumber','g',46,['format':("###,##0.00"),'number':(totalpri)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',47,['format':("###,##0.00"),'number':(totalpripd)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',48,['format':("###,##0.00"),'number':(totalpri - totalpripd)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',49,['format':("###,##0.00"),'number':(totalint)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',50,['format':("###,##0.00"),'number':(totalintpd)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',51,['format':("###,##0.00"),'number':(totalint - totalintpd)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',52,['format':("###,##0.00"),'number':(totalpen - totalpenpd)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',53,['format':("###,##0.00"),'number':(totalser - totalserpd)],-1)
printHtmlPart(24)
for( totalp in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentAmount}) ) {
printHtmlPart(25)
for( totalppd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentPaid}) ) {
printHtmlPart(26)
for( totali in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}) ) {
printHtmlPart(27)
for( totalipd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}) ) {
printHtmlPart(28)
invokeTag('formatNumber','g',64,['format':("###,##0.00"),'number':(totalp + totali - totalppd - totalipd)],-1)
printHtmlPart(29)
}
printHtmlPart(26)
}
printHtmlPart(25)
}
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(13)
}
printHtmlPart(12)
}
printHtmlPart(32)
}
printHtmlPart(10)
}
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(35)
}
printHtmlPart(36)
createClosureForHtmlPart(37, 1)
invokeTag('javascript','g',109,[:],1)
printHtmlPart(38)
invokeTag('formatNumber','g',129,['format':("###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(39)
if(true && (outstandingInterest)) {
printHtmlPart(40)
invokeTag('formatNumber','g',131,['format':("###,##0.00"),'number':(outstandingInterest)],-1)
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (totalPDue >= 0)) {
printHtmlPart(44)
invokeTag('formatNumber','g',139,['format':("###,##0.00"),'number':(totalPDue)],-1)
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
invokeTag('formatNumber','g',147,['format':("###,##0.00"),'number':(loanInstance?.penaltyBalanceAmount)],-1)
printHtmlPart(48)
invokeTag('formatNumber','g',148,['format':("###,##0.00"),'number':(loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(49)
invokeTag('formatNumber','g',149,['format':("###,##0.00"),'number':(doubleOutstandingInterest + loanInstance?.balanceAmount)],-1)
printHtmlPart(50)
invokeTag('formatNumber','g',161,['format':("###,##0.00"),'number':(loanInstance?.overduePrincipalBalance)],-1)
printHtmlPart(51)
invokeTag('formatNumber','g',169,['format':("###,##0.00"),'number':(loanInstance?.overduePrincipalBalance + loanInstance?.interestBalanceAmount + loanInstance?.penaltyBalanceAmount + loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(52)
if(true && (totalPDue < 0)) {
printHtmlPart(44)
invokeTag('formatNumber','g',177,['format':("###,##0.00"),'number':(totalPDue)],-1)
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129038L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
