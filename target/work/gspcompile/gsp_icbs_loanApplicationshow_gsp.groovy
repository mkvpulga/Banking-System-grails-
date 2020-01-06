import icbs.loans.LoanApplication
import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(9)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(10)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(11)
})
invokeTag('javascript','g',86,[:],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('render','g',113,['template':("specification/show")],-1)
printHtmlPart(16)
invokeTag('render','g',117,['template':("financialDetails/show")],-1)
printHtmlPart(17)
invokeTag('render','g',122,['template':("comakers/show")],-1)
printHtmlPart(18)
invokeTag('render','g',125,['template':("collateral/show")],-1)
printHtmlPart(19)
invokeTag('render','g',128,['template':("creditScoring/list")],-1)
printHtmlPart(20)
invokeTag('render','g',131,['template':("additional/show")],-1)
printHtmlPart(21)
invokeTag('render','g',135,['template':("loanApplicationChecklist/showchecklist")],-1)
printHtmlPart(22)
invokeTag('render','g',137,['template':("attachments/show")],-1)
printHtmlPart(23)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
invokeTag('hiddenField','g',177,['name':("editcreditInvestigationId"),'id':("editcreditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',179,['name':("editmatrixId"),'id':("editmatrixId"),'value':(initialCrrRatingScores?.recommendedCrrRating.id)],-1)
printHtmlPart(27)
invokeTag('textField','g',181,['type':("number"),'name':("editrecCrr"),'id':("editrecCrr"),'onblur':("updategetRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrScore.toInteger()),'class':("form-control")],-1)
printHtmlPart(28)
invokeTag('textField','g',185,['name':("editriskAssessment"),'id':("editriskAssessment"),'onblur':("getRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(29)
invokeTag('textField','g',190,['name':("editriskLevel"),'id':("editriskLevel"),'onblur':("getRiskRating(this.value);"),'value':(initialCrrRatingScores?.recommendedCrrRating?.riskLevel),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(30)
invokeTag('textArea','g',195,['id':("justification"),'name':("justification"),'value':(initialCrrRatingScores?.justification),'class':("form-control")],-1)
printHtmlPart(31)
})
invokeTag('form','g',201,['name':("editRommendationForm"),'id':("editRommendationForm"),'url':([action:'saveUpdateRecommededCrr',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],4)
printHtmlPart(32)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
invokeTag('hiddenField','g',219,['name':("creditInvestigationId"),'id':("creditInvestigationId"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',220,['name':("matrixId"),'id':("matrixId"),'value':("")],-1)
printHtmlPart(36)
invokeTag('textField','g',222,['type':("number"),'name':("recCrr"),'id':("recCrr"),'onblur':("getRiskRating();"),'values':(""),'class':("form-control")],-1)
printHtmlPart(37)
invokeTag('textField','g',226,['type':("number"),'name':("riskAssessment"),'id':("riskAssessment"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(38)
invokeTag('textField','g',231,['type':("number"),'name':("riskLevel"),'id':("riskLevel"),'rows':("4"),'cols':("50"),'values':(""),'class':("form-control"),'disabled':("true")],-1)
printHtmlPart(39)
invokeTag('textArea','g',236,['id':("justification"),'name':("justification"),'value':(""),'class':("form-control")],-1)
printHtmlPart(40)
})
invokeTag('form','g',243,['name':("addRecommendation"),'id':("addRecommendation"),'url':([action:'saveRecommededCrr',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(41)
if(true && (initialCrrRatingScores?.scoreCompletenessOfDocument)) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(42)
invokeTag('hiddenField','g',269,['name':("editCI"),'id':("editCI"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(43)
invokeTag('select','g',275,['noSelection':(['':'-Set Score Here-']),'id':("completeNessRequired"),'name':("completeNessRequired"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(initialCrrRatingScores?.scoreCompletenessOfDocument?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(44)
})
invokeTag('form','g',281,['name':("completenessOfDoducmentForm"),'url':([action:'updateCompletenessRecord',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],4)
printHtmlPart(32)
}
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(45)
invokeTag('hiddenField','g',304,['name':("CI"),'id':("CI"),'value':(creditInvestigationInstance?.id)],-1)
printHtmlPart(46)
invokeTag('select','g',310,['noSelection':(['':'-Set Score Here-']),'id':("completeNessRequired"),'name':("completeNessRequired"),'from':(icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])),'optionKey':("id"),'optionValue':("description"),'value':(initialCrrRatingScores?.scoreCompletenessOfDocument?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(47)
})
invokeTag('form','g',316,['name':("completenessOfDoducmentForm"),'url':([action:'addCompletenessRecord',controller:'creditInvestigation']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',316,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',317,['class':("list"),'action':("index")],3)
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',321,['action':("edit"),'resource':(loanApplicationInstance)],3)
printHtmlPart(53)
if(true && (user?.designation?.id == 17 || user?.designation?.id == 30 || user?.designation?.id == 33 || user?.id == 15)) {
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (user?.designation?.id == 33)) {
printHtmlPart(56)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',331,['controller':("creditInvestigation"),'action':("create"),'params':([id:loanApplicationInstance?.id])],4)
printHtmlPart(58)
}
printHtmlPart(59)
if(true && (user?.designation?.id == 17)) {
printHtmlPart(60)
if(true && (isLoanApplicationExist == 'true')) {
printHtmlPart(61)
}
else {
printHtmlPart(62)
createClosureForHtmlPart(63, 5)
invokeTag('link','g',338,['controller':("loan"),'action':("create"),'disable':("disabled"),'params':([id:loanApplicationInstance?.id])],5)
printHtmlPart(64)
}
printHtmlPart(65)
}
printHtmlPart(24)
if(true && (user?.id == 16 || user?.designation?.id == 30 || user?.designation?.id == 19)) {
printHtmlPart(60)
if(true && (loanApplicationSpecAdd)) {
printHtmlPart(62)
createClosureForHtmlPart(66, 5)
invokeTag('link','g',345,['action':("showCam"),'id':(loanApplicationInstance?.id)],5)
printHtmlPart(64)
}
else {
printHtmlPart(67)
}
printHtmlPart(24)
}
printHtmlPart(68)
if(true && (user?.designation?.id == 17)) {
printHtmlPart(69)
if(true && (creditScoringProductConfigInstance)) {
printHtmlPart(60)
if(true && (creditInvestigationInstance)) {
printHtmlPart(70)
createClosureForHtmlPart(71, 6)
invokeTag('link','g',360,['class':("list"),'controller':("creditInvestigation"),'action':("updateCredScorLoanAppDet"),'id':(creditInvestigationInstance?.id)],6)
printHtmlPart(72)
if(true && (preQualificationInstance)) {
printHtmlPart(73)
createClosureForHtmlPart(74, 7)
invokeTag('link','g',363,['class':("list"),'controller':("creditInvestigation"),'action':("updatePreQualificaion"),'id':(creditInvestigationInstance?.id)],7)
printHtmlPart(72)
}
else {
printHtmlPart(73)
createClosureForHtmlPart(75, 7)
invokeTag('link','g',365,['class':("list"),'controller':("creditInvestigation"),'action':("preQualification"),'id':(creditInvestigationInstance?.id)],7)
printHtmlPart(72)
}
printHtmlPart(76)
if(true && (Boolean.valueOf(isQualifiedForCheckList) == true)) {
printHtmlPart(77)
if(true && (Boolean.valueOf(isCheckListAlreadyDone) == true)) {
printHtmlPart(78)
createClosureForHtmlPart(79, 8)
invokeTag('link','g',369,['class':("list"),'controller':("creditInvestigation"),'action':("updatePerformedCreditScoring"),'id':(creditInvestigationInstance?.id)],8)
printHtmlPart(80)
if(true && (initialCrrRatingScores)) {
printHtmlPart(26)
if(true && (Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem) == true)) {
printHtmlPart(81)
if(true && (Boolean.valueOf(isRatedAlreadyEvaluated) == true)) {
printHtmlPart(82)
createClosureForHtmlPart(83, 11)
invokeTag('link','g',374,['class':("list"),'controller':("creditInvestigation"),'action':("updatePerformedRated"),'id':(creditInvestigationInstance?.id)],11)
printHtmlPart(84)
}
else {
printHtmlPart(82)
createClosureForHtmlPart(85, 11)
invokeTag('link','g',377,['class':("list"),'controller':("creditInvestigation"),'action':("performRatedItems"),'id':(creditInvestigationInstance?.id)],11)
printHtmlPart(84)
}
printHtmlPart(86)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(87)
}
else {
printHtmlPart(88)
}
printHtmlPart(26)
}
else {
printHtmlPart(89)
if(true && (initialCrrRatingScores?.recommendedCrrScore)) {
printHtmlPart(87)
}
else {
printHtmlPart(88)
}
printHtmlPart(26)
}
printHtmlPart(90)
}
printHtmlPart(91)
}
else {
printHtmlPart(78)
createClosureForHtmlPart(92, 8)
invokeTag('link','g',399,['class':("list"),'controller':("creditInvestigation"),'action':("performCreditScoring"),'id':(creditInvestigationInstance?.id)],8)
printHtmlPart(93)
}
printHtmlPart(94)
}
else {
printHtmlPart(95)
}
printHtmlPart(96)
}
else {
printHtmlPart(97)
}
printHtmlPart(24)
}
else {
printHtmlPart(98)
}
printHtmlPart(32)
}
printHtmlPart(99)
createTagBody(3, {->
printHtmlPart(100)
expressionOut.print(createLink(controller:'creditInvestigation', action:'getRiskRatingAjax'))
printHtmlPart(101)
expressionOut.print(createLink(controller:'creditInvestigation', action:'getRiskRatingAjax'))
printHtmlPart(102)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(16).baseParams)
printHtmlPart(103)
expressionOut.print(icbs.admin.Report.get(16).outputParam)
printHtmlPart(104)
expressionOut.print(icbs.admin.Report.get(16).reportUnit)
printHtmlPart(105)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(106)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(107)
})
invokeTag('javascript','g',536,[:],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',536,['tag':("main-actions")],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',537,[:],1)
printHtmlPart(108)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129196L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
