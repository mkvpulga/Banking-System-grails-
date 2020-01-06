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

class gsp_icbs_creditInvestigationviewCreditScoringDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/viewCreditScoringDetails.gsp" }
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
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',19,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',20,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',21,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',21,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(8)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(9)
expressionOut.print(creditScoringLoanDetailsInstance?.originatingUnit)
printHtmlPart(10)
invokeTag('set','g',42,['var':("primaryAddress"),'value':((creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(11)
if(true && (primaryAddress!=null)) {
printHtmlPart(12)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(creditScoringLoanDetailsInstance?.contactNumber)
printHtmlPart(16)
expressionOut.print(creditScoringLoanDetailsInstance?.nameOfBusiness)
printHtmlPart(17)
expressionOut.print(creditScoringLoanDetailsInstance?.industrySubsector)
printHtmlPart(18)
expressionOut.print(creditScoringLoanDetailsInstance?.previousCrrRating)
printHtmlPart(19)
expressionOut.print(creditScoringLoanDetailsInstance?.industryCode)
printHtmlPart(20)
invokeTag('formatDate','g',71,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.previousRatingDate)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',73,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.dateOfCurrentRating)],-1)
printHtmlPart(22)
expressionOut.print(creditScoringLoanDetailsInstance?.basicReasonForCrr)
printHtmlPart(23)
expressionOut.print(creditScoringLoanDetailsInstance?.rater)
printHtmlPart(24)
expressionOut.print(creditScoringLoanDetailsInstance?.typeOfCollateral?.description)
printHtmlPart(25)
if(true && (creditScoringLoanDetailsInstance?.appraisalValueRem)) {
printHtmlPart(12)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.appraisalValueRem)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (creditScoringLoanDetailsInstance?.avOtherCollateral)) {
printHtmlPart(12)
invokeTag('formatNumber','g',97,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.avOtherCollateral)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(26)
}
printHtmlPart(28)
expressionOut.print(creditScoringLoanDetailsInstance?.facilityTypes)
printHtmlPart(29)
invokeTag('formatDate','g',107,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.expiryDateOfLoan)],-1)
printHtmlPart(30)
if(true && (creditScoringLoanDetailsInstance?.commitmentAmount)) {
printHtmlPart(12)
invokeTag('formatNumber','g',112,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.commitmentAmount)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (creditScoringLoanDetailsInstance?.totalOsBalance)) {
printHtmlPart(12)
invokeTag('formatNumber','g',119,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.totalOsBalance)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(31)
}
printHtmlPart(33)
}
else {
printHtmlPart(34)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(35)
expressionOut.print(creditScoringLoanDetailsInstance?.originatingUnit)
printHtmlPart(36)
invokeTag('set','g',148,['var':("primaryAddress"),'value':((creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(37)
if(true && (primaryAddress!=null)) {
printHtmlPart(38)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(creditScoringLoanDetailsInstance?.contactNumber)
printHtmlPart(42)
expressionOut.print(creditScoringLoanDetailsInstance?.employer)
printHtmlPart(43)
expressionOut.print(creditScoringLoanDetailsInstance?.previousCrrRating)
printHtmlPart(44)
expressionOut.print(creditScoringLoanDetailsInstance?.designationRank)
printHtmlPart(45)
invokeTag('formatDate','g',175,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.previousRatingDate)],-1)
printHtmlPart(46)
expressionOut.print(creditScoringLoanDetailsInstance?.typeOfCollateral?.description)
printHtmlPart(47)
expressionOut.print(creditScoringLoanDetailsInstance?.currentRating)
printHtmlPart(48)
expressionOut.print(creditScoringLoanDetailsInstance?.avOfCollateral)
printHtmlPart(49)
invokeTag('formatDate','g',187,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.dateOfCurrentRating)],-1)
printHtmlPart(50)
expressionOut.print(creditScoringLoanDetailsInstance?.otherCollateral)
printHtmlPart(51)
expressionOut.print(creditScoringLoanDetailsInstance?.reasonsOfRating)
printHtmlPart(52)
if(true && (creditScoringLoanDetailsInstance?.avOtherCollateral)) {
printHtmlPart(38)
invokeTag('formatNumber','g',198,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.avOtherCollateral)],-1)
printHtmlPart(39)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(creditScoringLoanDetailsInstance?.rater)
printHtmlPart(55)
expressionOut.print(creditScoringLoanDetailsInstance?.loanType)
printHtmlPart(56)
invokeTag('formatDate','g',209,['format':("MM/dd/yyyy"),'date':(creditScoringLoanDetailsInstance?.expiryDateOfLoan)],-1)
printHtmlPart(57)
if(true && (creditScoringLoanDetailsInstance?.commitmentAmount)) {
printHtmlPart(38)
invokeTag('formatNumber','g',215,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.commitmentAmount)],-1)
printHtmlPart(39)
}
else {
printHtmlPart(58)
}
printHtmlPart(59)
if(true && (creditScoringLoanDetailsInstance?.totalOsBalance)) {
printHtmlPart(38)
invokeTag('formatNumber','g',222,['format':("###,###,##0.00"),'number':(creditScoringLoanDetailsInstance?.totalOsBalance)],-1)
printHtmlPart(39)
}
else {
printHtmlPart(58)
}
printHtmlPart(60)
}
printHtmlPart(61)
if(true && (preQualificationInstance)) {
printHtmlPart(62)
for( recentPrequalification in (preQualificationInstance) ) {
printHtmlPart(63)
expressionOut.print(recentPrequalification?.creditScoringPreQualification?.preQualificationItem)
printHtmlPart(64)
expressionOut.print(recentPrequalification?.preQualificationAnswer?.description)
printHtmlPart(65)
}
printHtmlPart(66)
}
else {
printHtmlPart(62)
for( recentPrequalification in (idCreditPreq) ) {
printHtmlPart(63)
expressionOut.print(recentPrequalification?.preQualificationItem)
printHtmlPart(67)
}
printHtmlPart(66)
}
printHtmlPart(68)
for( sectionListing in (xxscoringSectionInstance) ) {
printHtmlPart(69)
expressionOut.print(sectionListing?.nameOfSection)
printHtmlPart(70)
expressionOut.print(sectionListing?.sectionPercentage)
printHtmlPart(71)
expressionOut.print(sectionListing.id)
printHtmlPart(72)
expressionOut.print(sectionListing.id)
printHtmlPart(73)
expressionOut.print(sectionListing.id)
printHtmlPart(74)
for( questionWithValue in (CreditScoringChecklistRecords.findAllByCreditScoringQuestionSection(sectionListing)) ) {
printHtmlPart(75)
expressionOut.print(questionWithValue?.creditScoringQuestions?.questionNumberDescription)
printHtmlPart(76)
expressionOut.print(questionWithValue?.creditScoringAnswers?.description)
printHtmlPart(76)
expressionOut.print(questionWithValue?.creditScoringAnswers?.value)
printHtmlPart(77)
}
printHtmlPart(78)
}
printHtmlPart(79)
for( tallyOfScores in (resultqueryall) ) {
printHtmlPart(80)
expressionOut.print(tallyOfScores?.name)
printHtmlPart(81)
expressionOut.print(tallyOfScores?.section_percentage)
printHtmlPart(82)
expressionOut.print(tallyOfScores?.noofitems)
printHtmlPart(82)
expressionOut.print(tallyOfScores?.sumofscores)
printHtmlPart(82)
invokeTag('formatNumber','g',321,['format':("###,###,##0.00"),'number':((tallyOfScores?.sumofscores / tallyOfScores?.noofitems)*(tallyOfScores?.section_percentage * 0.01))],-1)
printHtmlPart(83)
}
printHtmlPart(84)
invokeTag('formatNumber','g',327,['format':("###,###,##0.00"),'number':(totalScoresInstance?.scoreRateTotal)],-1)
printHtmlPart(85)
expressionOut.print(initialCrrRatingScores?.totalScore)
printHtmlPart(86)
expressionOut.print(initialCrrRatingScores?.initialCrr)
printHtmlPart(87)
expressionOut.print(initialCrrRatingScores?.creditScoringrating?.ratingAssessment)
printHtmlPart(88)
expressionOut.print(initialCrrRatingScores?.creditScoringrating?.riskLevel)
printHtmlPart(89)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(90)
for( ratedddListing in (ratedInstanceListingRecords) ) {
printHtmlPart(91)
expressionOut.print(ratedddListing?.ratedName.substring(0,ratedddListing?.ratedName.indexOf('-')))
printHtmlPart(92)
expressionOut.print(ratedddListing.id)
printHtmlPart(93)
expressionOut.print(ratedddListing.id)
printHtmlPart(94)
expressionOut.print(ratedddListing.id)
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
printHtmlPart(100)
}
printHtmlPart(101)
if(true && (daCalculatedCrrDetails)) {
printHtmlPart(102)
expressionOut.print(daCalculatedCrrDetails.calculatedBrr ? daCalculatedCrrDetails.calculatedBrr.toInteger() : '')
printHtmlPart(86)
expressionOut.print(daCalculatedCrrDetails?.ratingAssessment)
printHtmlPart(87)
expressionOut.print(daCalculatedCrrDetails?.riskLevel)
printHtmlPart(103)
}
printHtmlPart(104)
if(true && (initialCrrRatingScores)) {
printHtmlPart(62)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(105)
expressionOut.print(initialCrrRatingScores?.recommendedCrrScore.toInteger())
printHtmlPart(106)
expressionOut.print(initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment)
printHtmlPart(106)
expressionOut.print(initialCrrRatingScores?.recommendedCrrRating?.riskLevel)
printHtmlPart(107)
}
else {
printHtmlPart(108)
}
printHtmlPart(109)
}
else {
printHtmlPart(110)
}
printHtmlPart(111)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument)) {
printHtmlPart(112)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 1)) {
printHtmlPart(113)
}
else if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 1)) {
printHtmlPart(114)
}
else {
printHtmlPart(115)
}
printHtmlPart(116)
expressionOut.print(initialCrrRatingScores?.scoreCompletenessOfDocument?.description)
printHtmlPart(82)
expressionOut.print(initialCrrRatingScores?.scoreCompletenessOfDocument?.value)
printHtmlPart(13)
}
else {
printHtmlPart(117)
}
printHtmlPart(118)
if(true && (finalResultsss)) {
printHtmlPart(102)
expressionOut.print(finalResultsss?.calculatedBrr)
printHtmlPart(86)
expressionOut.print(finalResultsss?.ratingAssessment)
printHtmlPart(87)
expressionOut.print(finalResultsss?.riskLevel)
printHtmlPart(103)
}
else {
printHtmlPart(119)
}
printHtmlPart(120)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(121)
createTagBody(4, {->
printHtmlPart(122)
invokeTag('hiddenField','g',559,['name':("editcreditInvestigationId"),'id':("editcreditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(123)
invokeTag('hiddenField','g',561,['name':("editmatrixId"),'id':("editmatrixId"),'value':(initialCrrRatingScores?.recommendedCrrRating.id)],-1)
printHtmlPart(124)
invokeTag('textField','g',563,['name':("editrecCrr"),'id':("editrecCrr"),'onblur':("updategetRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrScore.toInteger()),'class':("form-control")],-1)
printHtmlPart(125)
invokeTag('textField','g',567,['name':("editriskAssessment"),'id':("editriskAssessment"),'onblur':("getRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(126)
invokeTag('textField','g',572,['name':("editriskLevel"),'id':("editriskLevel"),'onblur':("getRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrRating?.riskLevel),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(127)
})
invokeTag('form','g',578,['name':("editRommendationForm"),'id':("editRommendationForm"),'url':([action:'saveUpdateRecommededCrr',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],4)
printHtmlPart(100)
}
printHtmlPart(128)
createTagBody(3, {->
printHtmlPart(129)
invokeTag('hiddenField','g',596,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(130)
invokeTag('hiddenField','g',597,['name':("matrixId"),'id':("matrixId"),'value':("")],-1)
printHtmlPart(131)
invokeTag('textField','g',599,['type':("number"),'name':("recCrr"),'id':("recCrr"),'onblur':("getRiskRating();"),'values':(""),'class':("form-control")],-1)
printHtmlPart(132)
invokeTag('textField','g',603,['type':("number"),'name':("riskAssessment"),'id':("riskAssessment"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(133)
invokeTag('textField','g',608,['type':("number"),'name':("riskLevel"),'id':("riskLevel"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(134)
})
invokeTag('form','g',615,['name':("addRecommendation"),'id':("addRecommendation"),'url':([action:'saveRecommededCrr',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(100)
createTagBody(3, {->
printHtmlPart(135)
if(true && (initialCrrRatingScores)) {
printHtmlPart(136)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument)) {
printHtmlPart(137)
invokeTag('hiddenField','g',640,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(138)
invokeTag('select','g',645,['noSelection':(['':'-Set Score Here-']),'id':("completeNessRequired"),'name':("completeNessRequired"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(initialCrrRatingScores?.scoreCompletenessOfDocument?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(123)
}
else {
printHtmlPart(139)
invokeTag('hiddenField','g',645,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(140)
invokeTag('select','g',650,['noSelection':(['':'-Set Score Here-']),'id':("completeNessRequired"),'name':("completeNessRequired"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(123)
}
printHtmlPart(141)
}
printHtmlPart(142)
})
invokeTag('form','g',655,['name':("completenessOfDoducmentForm"),'url':([action:'addCompletenessRecord',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(100)
createTagBody(3, {->
printHtmlPart(143)
expressionOut.print(createLink(controller:'creditInvestigation', action:'getRiskRatingAjax'))
printHtmlPart(144)
expressionOut.print(createLink(controller:'creditInvestigation', action:'getRiskRatingAjax'))
printHtmlPart(145)
})
invokeTag('javascript','g',767,[:],3)
printHtmlPart(146)
})
invokeTag('captureContent','sitemesh',767,['tag':("main-content")],2)
printHtmlPart(147)
createTagBody(2, {->
printHtmlPart(148)
createClosureForHtmlPart(149, 3)
invokeTag('link','g',777,['class':("list"),'controller':("creditInvestigation"),'action':("updateCredScorLoanAppDet"),'id':(creditInvestigationInstance.id)],3)
printHtmlPart(150)
if(true && (preQualificationInstance)) {
printHtmlPart(151)
createClosureForHtmlPart(152, 4)
invokeTag('link','g',781,['class':("list"),'controller':("creditInvestigation"),'action':("updatePreQualificaion"),'id':(creditInvestigationInstance.id)],4)
printHtmlPart(150)
}
else {
printHtmlPart(151)
createClosureForHtmlPart(153, 4)
invokeTag('link','g',783,['class':("list"),'controller':("creditInvestigation"),'action':("preQualification"),'id':(creditInvestigationInstance.id)],4)
printHtmlPart(150)
}
printHtmlPart(154)
if(true && (Boolean.valueOf(isQualifiedForCheckList) == true)) {
printHtmlPart(155)
if(true && (Boolean.valueOf(isCheckListAlreadyDone) == true)) {
printHtmlPart(156)
createClosureForHtmlPart(157, 5)
invokeTag('link','g',788,['class':("list"),'controller':("creditInvestigation"),'action':("updatePerformedCreditScoring"),'id':(creditInvestigationInstance.id)],5)
printHtmlPart(158)
if(true && (initialCrrRatingScores)) {
printHtmlPart(123)
if(true && (Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem) == true)) {
printHtmlPart(139)
if(true && (Boolean.valueOf(isRatedAlreadyEvaluated) == true)) {
printHtmlPart(159)
createClosureForHtmlPart(160, 8)
invokeTag('link','g',793,['class':("list"),'controller':("creditInvestigation"),'action':("updatePerformedRated"),'id':(creditInvestigationInstance.id)],8)
printHtmlPart(161)
}
else {
printHtmlPart(159)
createClosureForHtmlPart(162, 8)
invokeTag('link','g',795,['class':("list"),'controller':("creditInvestigation"),'action':("performRatedItems"),'id':(creditInvestigationInstance.id)],8)
printHtmlPart(161)
}
printHtmlPart(163)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(164)
}
else {
printHtmlPart(165)
}
printHtmlPart(123)
}
else {
printHtmlPart(137)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(164)
}
else {
printHtmlPart(165)
}
printHtmlPart(123)
}
printHtmlPart(166)
}
printHtmlPart(167)
}
else {
printHtmlPart(156)
createClosureForHtmlPart(168, 5)
invokeTag('link','g',817,['class':("list"),'controller':("creditInvestigation"),'action':("performCreditScoring"),'id':(creditInvestigationInstance.id)],5)
printHtmlPart(169)
}
printHtmlPart(121)
}
else {
printHtmlPart(170)
}
printHtmlPart(171)
createClosureForHtmlPart(172, 3)
invokeTag('link','g',824,['class':("list"),'controller':("creditInvestigation"),'action':("show"),'id':(creditInvestigationInstance.id)],3)
printHtmlPart(173)
})
invokeTag('captureContent','sitemesh',825,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',826,[:],1)
printHtmlPart(174)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128170L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
