import icbs.loans.CreditScoringCodeDescription
import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationupdateCredScorLoanAppDet_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/updateCredScorLoanAppDet.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('textField','g',29,['name':("name"),'id':("name"),'required':(""),'value':(creditInvestigationInstance?.loanApplication?.customer?.displayName),'class':("form-control"),'disabled':("disable")],-1)
printHtmlPart(11)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
invokeTag('hiddenField','g',33,['name':("credInvestigationId"),'id':("credInvestigationId"),'value':(creditInvestigationInstance.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',34,['name':("confihasRated"),'id':("confihasRated"),'value':(Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem))],-1)
printHtmlPart(14)
invokeTag('textField','g',39,['name':("originatingUnit"),'id':("originatingUnit"),'required':(""),'value':(loanApplicationCredScorDetails?.originatingUnit),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',45,['name':("contactNumber"),'id':("contactNumber"),'required':(""),'value':(loanApplicationCredScorDetails?.contactNumber),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('textField','g',51,['name':("nameOfBusiness"),'id':("nameOfBusiness"),'required':(""),'value':(loanApplicationCredScorDetails?.nameOfBusiness),'class':("form-control")],-1)
printHtmlPart(17)
invokeTag('textField','g',57,['name':("industrySubsector"),'id':("industrySubsector"),'required':(""),'value':(loanApplicationCredScorDetails?.industrySubsector),'class':("form-control")],-1)
printHtmlPart(18)
invokeTag('textField','g',63,['name':("previousRating"),'id':("previousRating"),'required':(""),'value':(loanApplicationCredScorDetails?.previousCrrRating),'class':("form-control")],-1)
printHtmlPart(19)
invokeTag('textField','g',69,['name':("industryCode"),'id':("industryCode"),'required':(""),'value':(loanApplicationCredScorDetails?.industryCode),'class':("form-control")],-1)
printHtmlPart(20)
invokeTag('customDatePicker','g',75,['id':("previousDate"),'name':("previousDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.previousRatingDate)],-1)
printHtmlPart(21)
invokeTag('customDatePicker','g',81,['id':("currentRatingDate"),'name':("currentRatingDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.dateOfCurrentRating)],-1)
printHtmlPart(22)
invokeTag('textField','g',87,['name':("basicReason"),'id':("basicReason"),'required':(""),'value':(loanApplicationCredScorDetails?.basicReasonForCrr),'class':("form-control")],-1)
printHtmlPart(23)
invokeTag('textField','g',93,['name':("raterName"),'id':("raterName"),'required':(""),'value':(loanApplicationCredScorDetails?.rater),'class':("form-control")],-1)
printHtmlPart(24)
invokeTag('select','g',99,['id':("collateralType"),'name':("collateralType.id"),'from':(icbs.lov.LoanCollateralType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationCredScorDetails?.typeOfCollateral?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(25)
invokeTag('textField','g',105,['name':("appraisalValueRem"),'id':("appraisalValueRem"),'required':(""),'value':(loanApplicationCredScorDetails?.appraisalValueRem),'class':("form-control truncated")],-1)
printHtmlPart(26)
invokeTag('textField','g',111,['name':("otherCollateral"),'id':("otherCollateral"),'required':(""),'value':(loanApplicationCredScorDetails?.avOtherCollateral),'class':("form-control truncated")],-1)
printHtmlPart(27)
invokeTag('textField','g',117,['name':("facilityType"),'id':("facilityType"),'required':(""),'value':(loanApplicationCredScorDetails?.facilityTypes),'class':("form-control")],-1)
printHtmlPart(28)
invokeTag('customDatePicker','g',123,['id':("expiryDate"),'name':("expiryDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.expiryDateOfLoan)],-1)
printHtmlPart(29)
invokeTag('textField','g',129,['name':("commitmentAmount"),'id':("qualificationItem"),'required':(""),'value':(loanApplicationCredScorDetails?.commitmentAmount),'class':("form-control truncated")],-1)
printHtmlPart(30)
invokeTag('textField','g',135,['name':("totalOsBalance"),'id':("totalOsBalance"),'required':(""),'value':(loanApplicationCredScorDetails?.totalOsBalance),'class':("form-control truncated")],-1)
printHtmlPart(31)
})
invokeTag('form','g',137,['name':("formWithRated"),'id':("formWithRated"),'url':([action:'xSaveUpdateDetailsLoanAppDetCredScor',controller:'CreditInvestigation']),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(32)
}
else {
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
invokeTag('hiddenField','g',141,['name':("credInvestigationId"),'id':("credInvestigationId"),'value':(creditInvestigationInstance.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',142,['name':("confihasRated"),'id':("confihasRated"),'value':(Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem))],-1)
printHtmlPart(14)
invokeTag('textField','g',147,['name':("originatingUnit"),'id':("originatingUnit"),'required':(""),'value':(loanApplicationCredScorDetails?.originatingUnit),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',153,['name':("contactNumber"),'id':("contactNumber"),'required':(""),'value':(loanApplicationCredScorDetails?.contactNumber),'class':("form-control")],-1)
printHtmlPart(33)
invokeTag('textField','g',159,['name':("employeer"),'id':("employeer"),'required':(""),'value':(loanApplicationCredScorDetails?.employer),'class':("form-control")],-1)
printHtmlPart(18)
invokeTag('textField','g',165,['name':("previousRating"),'id':("previousRating"),'required':(""),'value':(loanApplicationCredScorDetails?.previousCrrRating),'class':("form-control")],-1)
printHtmlPart(34)
invokeTag('textField','g',171,['name':("designationRank"),'id':("designationRank"),'required':(""),'value':(loanApplicationCredScorDetails?.designationRank),'class':("form-control")],-1)
printHtmlPart(20)
invokeTag('customDatePicker','g',177,['id':("previousDate"),'name':("previousDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.previousRatingDate)],-1)
printHtmlPart(35)
invokeTag('select','g',183,['id':("collateralType"),'name':("collateralType.id"),'from':(icbs.lov.LoanCollateralType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationCredScorDetails?.typeOfCollateral?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(36)
invokeTag('textField','g',189,['id':("currentRating"),'name':("currentRating"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.currentRating)],-1)
printHtmlPart(37)
invokeTag('textField','g',195,['name':("avCollateral"),'id':("avCollateral"),'required':(""),'value':(loanApplicationCredScorDetails?.avOfCollateral),'class':("form-control truncated")],-1)
printHtmlPart(38)
invokeTag('customDatePicker','g',201,['id':("currentRatingDate"),'name':("currentRatingDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.dateOfCurrentRating)],-1)
printHtmlPart(39)
invokeTag('textField','g',206,['name':("reasonForRating"),'id':("reasonForRating"),'required':(""),'value':(loanApplicationCredScorDetails?.reasonsOfRating),'class':("form-control truncated")],-1)
printHtmlPart(40)
invokeTag('textField','g',212,['name':("xotherCollateral"),'id':("xotherCollateral"),'required':(""),'value':(loanApplicationCredScorDetails?.otherCollateral),'class':("form-control")],-1)
printHtmlPart(26)
invokeTag('textField','g',218,['name':("otherCollateral"),'id':("otherCollateral"),'required':(""),'value':(loanApplicationCredScorDetails?.avOtherCollateral),'class':("form-control truncated")],-1)
printHtmlPart(23)
invokeTag('textField','g',224,['name':("raterName"),'id':("raterName"),'required':(""),'value':(loanApplicationCredScorDetails?.rater),'class':("form-control")],-1)
printHtmlPart(41)
invokeTag('textField','g',230,['name':("loanType"),'id':("loanType"),'required':(""),'value':(loanApplicationCredScorDetails?.loanType),'class':("form-control")],-1)
printHtmlPart(28)
invokeTag('customDatePicker','g',236,['id':("expiryDate"),'name':("expiryDate"),'precision':("day"),'class':("form-control"),'value':(loanApplicationCredScorDetails?.expiryDateOfLoan)],-1)
printHtmlPart(42)
invokeTag('textField','g',242,['name':("commitmentAmount"),'id':("qualificationItem"),'required':(""),'value':(loanApplicationCredScorDetails?.commitmentAmount),'class':("form-control truncated")],-1)
printHtmlPart(30)
invokeTag('textField','g',248,['name':("totalOsBalance"),'id':("totalOsBalance"),'required':(""),'value':(loanApplicationCredScorDetails?.totalOsBalance),'class':("form-control truncated")],-1)
printHtmlPart(31)
})
invokeTag('form','g',250,['name':("xformWithOutRated"),'id':("xformWithOutRated"),'url':([action:'xSaveUpdateDetailsLoanAppDetCredScor',controller:'CreditInvestigation']),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(32)
}
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',252,['tag':("main-content")],2)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
if(true && (scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true)) {
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
createClosureForHtmlPart(49, 3)
invokeTag('link','g',263,['class':("btn btn-secondary"),'controller':("loanApplication"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.id)],3)
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',285,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',286,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673128166L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
