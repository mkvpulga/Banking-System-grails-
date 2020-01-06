import icbs.loans.CreditInvestigation
import icbs.loans.CreditScoringQuestions
import icbs.loans.CreditScoringQuestionSection
import icbs.loans.CreditScoringPreQualification
import icbs.loans.CreditScoringCodeDescription
import icbs.loans.CreditScoringChecklistRecords
import icbs.loans.CreditScoringMatrix
import icbs.loans.CreditScoringPreQualification
import icbs.loans.CreditScoringTallyOfScores
import icbs.lov.CreditScoringAnswers
import icbs.loans.CreditScoringRated
import icbs.loans.CreditScoringRatedItems
import icbs.loans.CreditScoringRatedItemsRecords
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_creditScoring_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/creditScoring/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
if(true && (creditScoringProductConfigInstance)) {
printHtmlPart(2)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(3)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(4)
expressionOut.print(creditScoringLoanDetailsInstance?.originatingUnit)
printHtmlPart(5)
invokeTag('set','g',34,['var':("primaryAddress"),'value':((creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(6)
if(true && (primaryAddress!=null)) {
printHtmlPart(7)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(creditScoringLoanDetailsInstance?.contactNumber)
printHtmlPart(11)
expressionOut.print(creditScoringLoanDetailsInstance?.nameOfBusiness)
printHtmlPart(12)
expressionOut.print(creditScoringLoanDetailsInstance?.industrySubsector)
printHtmlPart(13)
expressionOut.print(creditScoringLoanDetailsInstance?.previousCrrRating)
printHtmlPart(14)
expressionOut.print(creditScoringLoanDetailsInstance?.industryCode)
printHtmlPart(15)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.previousRatingDate)],-1)
printHtmlPart(16)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.dateOfCurrentRating)],-1)
printHtmlPart(17)
expressionOut.print(creditScoringLoanDetailsInstance?.basicReasonForCrr)
printHtmlPart(18)
expressionOut.print(creditScoringLoanDetailsInstance?.rater)
printHtmlPart(19)
expressionOut.print(creditScoringLoanDetailsInstance?.typeOfCollateral?.description)
printHtmlPart(20)
if(true && (creditScoringLoanDetailsInstance?.appraisalValueRem)) {
printHtmlPart(7)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.appraisalValueRem)],-1)
printHtmlPart(8)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (creditScoringLoanDetailsInstance?.avOtherCollateral)) {
printHtmlPart(7)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.avOtherCollateral)],-1)
printHtmlPart(8)
}
else {
printHtmlPart(21)
}
printHtmlPart(23)
expressionOut.print(creditScoringLoanDetailsInstance?.facilityTypes)
printHtmlPart(24)
invokeTag('formatDate','g',99,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.expiryDateOfLoan)],-1)
printHtmlPart(25)
if(true && (creditScoringLoanDetailsInstance?.commitmentAmount)) {
printHtmlPart(7)
invokeTag('formatNumber','g',104,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.commitmentAmount)],-1)
printHtmlPart(8)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (creditScoringLoanDetailsInstance?.totalOsBalance)) {
printHtmlPart(7)
invokeTag('formatNumber','g',111,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.totalOsBalance)],-1)
printHtmlPart(8)
}
else {
printHtmlPart(26)
}
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(30)
expressionOut.print(creditScoringLoanDetailsInstance?.originatingUnit)
printHtmlPart(31)
invokeTag('set','g',140,['var':("primaryAddress"),'value':((creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(32)
if(true && (primaryAddress!=null)) {
printHtmlPart(33)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(creditScoringLoanDetailsInstance?.contactNumber)
printHtmlPart(37)
expressionOut.print(creditScoringLoanDetailsInstance?.employer)
printHtmlPart(38)
expressionOut.print(creditScoringLoanDetailsInstance?.previousCrrRating)
printHtmlPart(39)
expressionOut.print(creditScoringLoanDetailsInstance?.designationRank)
printHtmlPart(40)
invokeTag('formatDate','g',167,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.previousRatingDate)],-1)
printHtmlPart(41)
expressionOut.print(creditScoringLoanDetailsInstance?.typeOfCollateral?.description)
printHtmlPart(42)
expressionOut.print(creditScoringLoanDetailsInstance?.currentRating)
printHtmlPart(43)
expressionOut.print(creditScoringLoanDetailsInstance?.avOfCollateral)
printHtmlPart(44)
invokeTag('formatDate','g',179,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.dateOfCurrentRating)],-1)
printHtmlPart(45)
expressionOut.print(creditScoringLoanDetailsInstance?.otherCollateral)
printHtmlPart(46)
expressionOut.print(creditScoringLoanDetailsInstance?.reasonsOfRating)
printHtmlPart(47)
if(true && (creditScoringLoanDetailsInstance?.avOtherCollateral)) {
printHtmlPart(33)
invokeTag('formatNumber','g',190,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.avOtherCollateral)],-1)
printHtmlPart(34)
}
else {
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(creditScoringLoanDetailsInstance?.rater)
printHtmlPart(50)
expressionOut.print(creditScoringLoanDetailsInstance?.loanType)
printHtmlPart(51)
invokeTag('formatDate','g',201,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.expiryDateOfLoan)],-1)
printHtmlPart(52)
if(true && (creditScoringLoanDetailsInstance?.commitmentAmount)) {
printHtmlPart(33)
invokeTag('formatNumber','g',207,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.commitmentAmount)],-1)
printHtmlPart(34)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (creditScoringLoanDetailsInstance?.totalOsBalance)) {
printHtmlPart(33)
invokeTag('formatNumber','g',214,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.totalOsBalance)],-1)
printHtmlPart(34)
}
else {
printHtmlPart(53)
}
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (preQualificationInstance)) {
printHtmlPart(57)
for( recentPrequalification in (preQualificationInstance) ) {
printHtmlPart(58)
expressionOut.print(recentPrequalification?.creditScoringPreQualification?.preQualificationItem)
printHtmlPart(59)
expressionOut.print(recentPrequalification?.preQualificationAnswer?.description)
printHtmlPart(60)
}
printHtmlPart(61)
}
else {
printHtmlPart(57)
for( recentPrequalification in (idCreditPreq) ) {
printHtmlPart(58)
expressionOut.print(recentPrequalification?.preQualificationItem)
printHtmlPart(62)
}
printHtmlPart(61)
}
printHtmlPart(63)
for( sectionListing in (xxscoringSectionInstance) ) {
printHtmlPart(64)
expressionOut.print(sectionListing?.nameOfSection)
printHtmlPart(65)
expressionOut.print(sectionListing?.sectionPercentage)
printHtmlPart(66)
expressionOut.print(sectionListing.id)
printHtmlPart(67)
expressionOut.print(sectionListing.id)
printHtmlPart(68)
expressionOut.print(sectionListing.id)
printHtmlPart(69)
for( questionWithValue in (CreditScoringChecklistRecords.findAllByCreditScoringQuestionSection(sectionListing)) ) {
printHtmlPart(70)
expressionOut.print(questionWithValue?.creditScoringQuestions?.questionNumberDescription)
printHtmlPart(71)
expressionOut.print(questionWithValue?.creditScoringAnswers?.description)
printHtmlPart(71)
expressionOut.print(questionWithValue?.creditScoringAnswers?.value)
printHtmlPart(72)
}
printHtmlPart(73)
}
printHtmlPart(74)
for( tallyOfScores in (resultqueryall) ) {
printHtmlPart(75)
expressionOut.print(tallyOfScores?.name)
printHtmlPart(76)
expressionOut.print(tallyOfScores?.section_percentage)
printHtmlPart(77)
expressionOut.print(tallyOfScores?.noofitems)
printHtmlPart(77)
expressionOut.print(tallyOfScores?.sumofscores)
printHtmlPart(77)
invokeTag('formatNumber','g',313,['format':("###,###,##0.00"),'number':((tallyOfScores?.sumofscores / tallyOfScores?.noofitems)*(tallyOfScores?.section_percentage * 0.01))],-1)
printHtmlPart(78)
}
printHtmlPart(79)
invokeTag('formatNumber','g',319,['format':("###,###,##0.00"),'number':(totalScoresInstance?.scoreRateTotal)],-1)
printHtmlPart(80)
expressionOut.print(initialCrrRatingScores?.totalScore)
printHtmlPart(81)
expressionOut.print(initialCrrRatingScores?.initialCrr)
printHtmlPart(82)
expressionOut.print(initialCrrRatingScores?.creditScoringrating?.ratingAssessment)
printHtmlPart(83)
expressionOut.print(initialCrrRatingScores?.creditScoringrating?.riskLevel)
printHtmlPart(84)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(85)
for( ratedddListing in (ratedInstanceListingRecords) ) {
printHtmlPart(86)
expressionOut.print(ratedddListing?.ratedName.substring(0,ratedddListing?.ratedName.indexOf('-')))
printHtmlPart(87)
expressionOut.print(ratedddListing.id)
printHtmlPart(88)
expressionOut.print(ratedddListing.id)
printHtmlPart(89)
expressionOut.print(ratedddListing.id)
printHtmlPart(90)
invokeTag('message','g',367,['code':("loanApplication.recommendedRemarks1.label"),'default':("Remarks")],-1)
printHtmlPart(91)
if(true && (CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedddListing,loanApplicationInstance))) {
printHtmlPart(92)
invokeTag('textArea','g',373,['id':("remarks"),'name':("remarks"),'value':(CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedddListing,loanApplicationInstance).remarks),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(93)
}
else {
printHtmlPart(57)
invokeTag('textArea','g',374,['id':("remarks"),'name':("remarks"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(94)
}
printHtmlPart(95)
for( ratedWithValues in (CreditScoringRatedItemsRecords.findAllByCreditScoringRated(ratedddListing)) ) {
printHtmlPart(96)
expressionOut.print(ratedWithValues?.creditScoringRatedItems?.itemDescription)
printHtmlPart(97)
expressionOut.print(ratedWithValues?.creditScoringAnswers?.description)
printHtmlPart(98)
}
printHtmlPart(99)
}
printHtmlPart(2)
}
printHtmlPart(100)
if(true && (daCalculatedCrrDetails)) {
printHtmlPart(101)
expressionOut.print(daCalculatedCrrDetails.calculatedBrr ? daCalculatedCrrDetails.calculatedBrr.toInteger() : '')
printHtmlPart(81)
expressionOut.print(daCalculatedCrrDetails?.ratingAssessment)
printHtmlPart(82)
expressionOut.print(daCalculatedCrrDetails?.riskLevel)
printHtmlPart(102)
}
printHtmlPart(103)
if(true && (initialCrrRatingScores)) {
printHtmlPart(57)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(104)
expressionOut.print(initialCrrRatingScores?.recommendedCrrScore.toInteger())
printHtmlPart(105)
expressionOut.print(initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment)
printHtmlPart(105)
expressionOut.print(initialCrrRatingScores?.recommendedCrrRating?.riskLevel)
printHtmlPart(106)
}
else {
printHtmlPart(107)
}
printHtmlPart(108)
}
else {
printHtmlPart(109)
}
printHtmlPart(110)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument)) {
printHtmlPart(111)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 1)) {
printHtmlPart(112)
}
else if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 2)) {
printHtmlPart(113)
}
else {
printHtmlPart(114)
}
printHtmlPart(115)
expressionOut.print(initialCrrRatingScores?.scoreCompletenessOfDocument?.description)
printHtmlPart(77)
expressionOut.print(initialCrrRatingScores?.scoreCompletenessOfDocument?.value)
printHtmlPart(8)
}
else {
printHtmlPart(116)
}
printHtmlPart(117)
if(true && (finalResultsss)) {
printHtmlPart(101)
expressionOut.print(finalResultsss?.calculatedBrr)
printHtmlPart(81)
expressionOut.print(finalResultsss?.ratingAssessment)
printHtmlPart(82)
expressionOut.print(finalResultsss?.riskLevel)
printHtmlPart(102)
}
else {
printHtmlPart(118)
}
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(2)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129180L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
