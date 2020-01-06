import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposal_installment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/_installment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',2,['var':("loanService"),'bean':("loanService")],-1)
printHtmlPart(1)
invokeTag('set','g',17,['var':("totalPrincipal"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',18,['var':("totalInterest"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',19,['var':("totalDue"),'value':(0)],-1)
printHtmlPart(3)
if(true && (interestIncomeScheme.installmentCalcType.id == 1 && interestIncomeScheme.advInterestType.id == 1)) {
printHtmlPart(4)
invokeTag('set','g',24,['var':("dueDate"),'value':(firstInstallmentDate ?: openingDate + term)],-1)
printHtmlPart(5)
invokeTag('set','g',25,['var':("term"),'value':(dueDate - (interestStartDate ?: openingDate))],-1)
printHtmlPart(5)
invokeTag('set','g',26,['var':("interest"),'value':((amount * interestRate * term) / divisor)],-1)
printHtmlPart(5)
invokeTag('set','g',27,['var':("due"),'value':(amount + interest)],-1)
printHtmlPart(6)
invokeTag('formatDate','g',29,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',30,['format':("###,###,##0.00"),'number':(amount)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',31,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',32,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(8)
invokeTag('set','g',34,['var':("totalPrincipal"),'value':(amount)],-1)
printHtmlPart(5)
invokeTag('set','g',35,['var':("totalInterest"),'value':(interest)],-1)
printHtmlPart(5)
invokeTag('set','g',36,['var':("totalDue"),'value':(due)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (interestIncomeScheme.installmentCalcType.id == 1 && interestIncomeScheme.advInterestType.id == 2)) {
printHtmlPart(11)
invokeTag('set','g',42,['var':("dueDate"),'value':(firstInstallmentDate ?: openingDate + term)],-1)
printHtmlPart(12)
invokeTag('set','g',43,['var':("term"),'value':(dueDate - (interestStartDate ?: openingDate))],-1)
printHtmlPart(12)
invokeTag('set','g',44,['var':("interest"),'value':((amount * interestRate * term) / divisor)],-1)
printHtmlPart(12)
invokeTag('set','g',45,['var':("due"),'value':(amount - interest)],-1)
printHtmlPart(12)
invokeTag('set','g',46,['var':("due1"),'value':(amount)],-1)
printHtmlPart(12)
invokeTag('set','g',47,['var':("interest1"),'value':(interest - interest)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',49,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(amount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',51,['format':("###,###,##0.00"),'number':("${interest1} ")],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(due1)],-1)
printHtmlPart(15)
invokeTag('set','g',54,['var':("totalPrincipal"),'value':(amount)],-1)
printHtmlPart(12)
invokeTag('set','g',55,['var':("totalInterest"),'value':(interest)],-1)
printHtmlPart(12)
invokeTag('set','g',56,['var':("totalDue"),'value':("${due1} ")],-1)
printHtmlPart(16)
}
else if(true && (interestIncomeScheme.installmentType.id == 5 || interestIncomeScheme.installmentCalcType.id == 6)) {
printHtmlPart(17)
invokeTag('set','g',61,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',62,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',63,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..installmentDates.size()) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',67,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',70,['var':("dueDate"),'value':(installmentDates[i - 1])],-1)
printHtmlPart(5)
}
printHtmlPart(5)

/*def interest
                        if (interestStartDate) {
                            if (dueDate > interestStartDate) {
                                interest = prevBalance * (interestRate / divisor) * (dueDate - interestStartDate)
                                interestStartDate = null
                            } else {
                                interest = 0
                            }                            
                        } else {
                            interest = prevBalance * (interestRate / divisor) * (dueDate - prevDueDate)
                        }*/

printHtmlPart(20)
invokeTag('set','g',85,['var':("due"),'value':(principalAmounts[i - 1] + interestAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',86,['var':("balance"),'value':(prevBalance - principalAmounts[i - 1])],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',87,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(principalAmounts[i - 1])],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(interestAmounts[i - 1])],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',92,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',93,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',93,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',95,['var':("totalPrincipal"),'value':(totalPrincipal + principalAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',96,['var':("totalInterest"),'value':(totalInterest + interestAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',97,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(23)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 2)) {
printHtmlPart(24)
invokeTag('set','g',104,['var':("principal"),'value':(amount / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',104,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',105,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',106,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == numInstallments && balloonInstallments > 0)) {
printHtmlPart(19)
invokeTag('set','g',110,['var':("principal"),'value':(amount - (principal * (i - 1)))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',113,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',116,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        if (interestStartDate) {                        
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                        }

printHtmlPart(27)
invokeTag('set','g',140,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',142,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',145,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',146,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',147,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',149,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',150,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',151,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',152,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',153,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',154,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',155,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(28)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 3)) {
printHtmlPart(17)

def frequencyFactor
                    if (frequency == 1 || frequency == 2) {
                        frequencyFactor = 365
                    } else if (frequency == 3) {
                        frequencyFactor = 52
                    } else if (frequency == 4) {
                        frequencyFactor = 26
                    } else if (frequency == 5) {
                        frequencyFactor = 24
                    } else if (frequency == 6 || frequency == 7) {
                        frequencyFactor = 12
                    } else if (frequency == 8) {
                        frequencyFactor = 6
                    } else if (frequency == 9) {
                        frequencyFactor = 4
                    } else if (frequency == 10) {
                        frequencyFactor = 2
                    } else if (frequency == 11) {
                        frequencyFactor = 1
                    } else {
                        frequencyFactor = 365
                    }
                    def factor = interestRate / frequencyFactor
                    def due = installmentAmount ?: amount * (factor / (1 - ((1 / (1 + factor))**numInstallments)))

printHtmlPart(29)
invokeTag('set','g',182,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',184,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(30)
invokeTag('set','g',185,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(31)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',191,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(32)
invokeTag('set','g',194,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        if (interestStartDate) {                        
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                        }
                        def principal
                        if (i == numInstallments) {
                            principal = prevBalance
                            due = principal + interest
                        } else {
                            principal = due - interest
                        }

printHtmlPart(33)
invokeTag('set','g',224,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',226,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',227,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',230,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',231,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',233,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',235,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',237,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',238,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',239,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',241,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(28)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 4)) {
printHtmlPart(17)
invokeTag('set','g',244,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',246,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',247,['var':("factor"),'value':(0)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(5)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',250,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',253,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
invokeTag('set','g',254,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',255,['var':("factor"),'value':(factor + i)],-1)
printHtmlPart(17)
}
printHtmlPart(31)
invokeTag('set','g',256,['var':("maturityDate"),'value':(dueDate)],-1)
printHtmlPart(31)
if(true && (interestStartDate)) {
printHtmlPart(5)
invokeTag('set','g',258,['var':("term"),'value':(maturityDate - interestStartDate)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(5)
invokeTag('set','g',260,['var':("term"),'value':(maturityDate - openingDate)],-1)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (frequency == 2)) {
printHtmlPart(5)
if(true && (interestStartDate)) {
printHtmlPart(19)
invokeTag('set','g',265,['var':("weekends"),'value':(loanService.getNumOfWeekends(interestStartDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',267,['var':("term"),'value':(maturityDate - interestStartDate - weekends)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',269,['var':("weekends"),'value':(loanService.getNumOfWeekends(openingDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',271,['var':("term"),'value':(maturityDate - openingDate - weekends)],-1)
printHtmlPart(5)
}
printHtmlPart(34)
}
printHtmlPart(17)
invokeTag('set','g',273,['var':("principal"),'value':(amount / numInstallments)],-1)
printHtmlPart(35)
invokeTag('set','g',275,['var':("totalInterest"),'value':(amount * (interestRate / divisor) * term)],-1)
printHtmlPart(35)
invokeTag('set','g',277,['var':("prevDueDate"),'value':(firstInstallmentDate),'<g:set var':("baseDate")],-1)
printHtmlPart(30)
invokeTag('set','g',278,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(36)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',282,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',286,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(37)
invokeTag('set','g',289,['var':("interest"),'value':(((numInstallments + 1 - i) / factor) * totalInterest)],-1)
printHtmlPart(5)
invokeTag('set','g',290,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',291,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',292,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',294,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',295,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',296,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',298,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',299,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',300,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',301,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',302,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(28)
}
printHtmlPart(38)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 5)) {
printHtmlPart(17)
invokeTag('set','g',306,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',308,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(5)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',311,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',313,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
invokeTag('set','g',315,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(17)
}
printHtmlPart(17)
invokeTag('set','g',316,['var':("maturityDate"),'value':(dueDate)],-1)
printHtmlPart(17)
if(true && (interestStartDate)) {
printHtmlPart(5)
invokeTag('set','g',318,['var':("term"),'value':(maturityDate - interestStartDate)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(5)
invokeTag('set','g',319,['var':("term"),'value':(maturityDate - openingDate)],-1)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (frequency == 2)) {
printHtmlPart(5)
if(true && (interestStartDate)) {
printHtmlPart(19)
invokeTag('set','g',322,['var':("weekends"),'value':(loanService.getNumOfWeekends(interestStartDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',324,['var':("term"),'value':(maturityDate - interestStartDate - weekends)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',327,['var':("weekends"),'value':(loanService.getNumOfWeekends(openingDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',330,['var':("term"),'value':(maturityDate - openingDate - weekends)],-1)
printHtmlPart(5)
}
printHtmlPart(35)
}
printHtmlPart(17)
invokeTag('set','g',332,['var':("totalInterest"),'value':(amount * (interestRate / divisor) * term)],-1)
printHtmlPart(17)
invokeTag('set','g',333,['var':("interest"),'value':(totalInterest / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',335,['var':("principal"),'value':(amount / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',336,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',338,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',338,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == numInstallments && balloonInstallments > 0)) {
printHtmlPart(19)
invokeTag('set','g',342,['var':("principal"),'value':(amount - (principal * (i - 1)))],-1)
printHtmlPart(19)
invokeTag('set','g',344,['var':("interest"),'value':(totalInterest - (interest * (i - 1)))],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',348,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',351,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
invokeTag('set','g',352,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',353,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',356,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',356,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',357,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',360,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',361,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',361,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',362,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',363,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',364,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(28)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 7)) {
printHtmlPart(17)

def frequencyFactor
                    if (frequency == 1 || frequency == 2) {
                        frequencyFactor = 365
                    } else if (frequency == 3) {
                        frequencyFactor = 52
                    } else if (frequency == 4) {
                        frequencyFactor = 26
                    } else if (frequency == 5) {
                        frequencyFactor = 24
                    } else if (frequency == 6 || frequency == 7) {
                        frequencyFactor = 12
                    } else if (frequency == 8) {
                        frequencyFactor = 6
                    } else if (frequency == 9) {
                        frequencyFactor = 4
                    } else if (frequency == 10) {
                        frequencyFactor = 2
                    } else if (frequency == 11) {
                        frequencyFactor = 1
                    } else {
                        frequencyFactor = 365
                    }
                    def factor = interestRate / frequencyFactor
                    def due = installmentAmount ?: amount * (factor / (1 - ((1 / (1 + factor))**numInstallments)))

printHtmlPart(29)
invokeTag('set','g',385,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',386,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(30)
invokeTag('set','g',387,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(31)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',390,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(32)
invokeTag('set','g',396,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        def principal
                        if (interestStartDate != openingDate) {
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                            if (frequency == 7 || frequency == 6){
                                interest = prevBalance * (interestRate / 12)
                            }
                            if (frequency == 5){
                                interest = prevBalance * (interestRate / 24)
                            }
                            if (frequency == 3){
                                interest = prevBalance * (interestRate / 52)
                            }
                            if (i == numInstallments){
                                interest = due - prevBalance
                            }
                            interest = interest.round(2)
                        }
									 
                        if (i == numInstallments) {
                            principal = prevBalance
                            due = principal + interest
                        } else {
                            principal = due - interest
                        }

printHtmlPart(33)
invokeTag('set','g',441,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',443,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',445,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',446,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',447,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',450,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',452,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',453,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',454,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',456,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',457,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(28)
}
printHtmlPart(2)
}
printHtmlPart(39)
invokeTag('formatNumber','g',462,['format':("###,###,##0.00"),'number':(totalPrincipal)],-1)
printHtmlPart(40)
invokeTag('formatNumber','g',464,['format':("###,###,##0.00"),'number':(totalInterest)],-1)
printHtmlPart(40)
invokeTag('formatNumber','g',466,['format':("###,###,##0.00"),'number':(totalDue)],-1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129237L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
