import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_loanApplicationChecklist_form4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/loanApplicationChecklist/_form4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('checkBox','g',15,['disabled':("disabled"),'id':("houcolNoticeOfApproval"),'name':("houcolNoticeOfApproval"),'value':(loanApplicationChecklist?.houcolNoticeOfApproval)],-1)
printHtmlPart(1)
invokeTag('checkBox','g',28,['disabled':("disabled"),'id':("houcolCreditApprovalMemorandum"),'name':("houcolCreditApprovalMemorandum"),'value':(loanApplicationChecklist?.houcolCreditApprovalMemorandum)],-1)
printHtmlPart(2)
invokeTag('checkBox','g',40,['disabled':("disabled"),'id':("houcolCreditApplication"),'name':("houcolCreditApplication"),'value':(loanApplicationChecklist?.houcolCreditApplication)],-1)
printHtmlPart(3)
invokeTag('checkBox','g',52,['disabled':("disabled"),'id':("houcolCreditRiskRating"),'name':("houcolCreditRiskRating"),'value':(loanApplicationChecklist?.houcolCreditRiskRating)],-1)
printHtmlPart(4)
invokeTag('checkBox','g',65,['disabled':("disabled"),'id':("houcolCashFlowFinancialStatement"),'name':("houcolCashFlowFinancialStatement"),'value':(loanApplicationChecklist?.houcolCashFlowFinancialStatement)],-1)
printHtmlPart(5)
invokeTag('checkBox','g',77,['disabled':("disabled"),'id':("houcolLifeInsurance"),'name':("houcolLifeInsurance"),'value':(loanApplicationChecklist?.houcolLifeInsurance)],-1)
printHtmlPart(6)
invokeTag('checkBox','g',89,['disabled':("disabled"),'id':("houcolPromissoryNote"),'name':("houcolPromissoryNote"),'value':(loanApplicationChecklist?.houcolPromissoryNote)],-1)
printHtmlPart(7)
invokeTag('checkBox','g',100,['disabled':("disabled"),'id':("houcolAmortization"),'name':("houcolAmortization"),'value':(loanApplicationChecklist?.houcolAmortization)],-1)
printHtmlPart(8)
invokeTag('checkBox','g',113,['disabled':("disabled"),'id':("houcolDisclosureStatement"),'name':("houcolDisclosureStatement"),'value':(loanApplicationChecklist?.houcolDisclosureStatement)],-1)
printHtmlPart(9)
invokeTag('checkBox','g',125,['disabled':("disabled"),'id':("houcolDeedOfAssignment"),'name':("houcolDeedOfAssignment"),'value':(loanApplicationChecklist?.houcolDeedOfAssignment)],-1)
printHtmlPart(10)
invokeTag('checkBox','g',137,['disabled':("disabled"),'id':("houcolLoanAgreement"),'name':("houcolLoanAgreement"),'value':(loanApplicationChecklist?.houcolLoanAgreement)],-1)
printHtmlPart(11)
invokeTag('checkBox','g',149,['disabled':("disabled"),'id':("houcolLoanApplicationForm"),'name':("houcolLoanApplicationForm"),'value':(loanApplicationChecklist?.houcolLoanApplicationForm)],-1)
printHtmlPart(12)
invokeTag('checkBox','g',161,['disabled':("disabled"),'id':("houcolCreditInvestigationReport"),'name':("houcolCreditInvestigationReport"),'value':(loanApplicationChecklist?.houcolCreditInvestigationReport)],-1)
printHtmlPart(13)
invokeTag('checkBox','g',173,['disabled':("disabled"),'id':("houcolCreditBackgroundInvestigationReport"),'name':("houcolCreditBackgroundInvestigationReport"),'value':(loanApplicationChecklist?.houcolCreditBackgroundInvestigationReport)],-1)
printHtmlPart(14)
invokeTag('checkBox','g',186,['disabled':("disabled"),'id':("houcolCreditInvestigationFromOtherBanks"),'name':("houcolCreditInvestigationFromOtherBanks"),'value':(loanApplicationChecklist?.houcolCreditInvestigationFromOtherBanks)],-1)
printHtmlPart(15)
invokeTag('checkBox','g',197,['disabled':("disabled"),'id':("houcolCourtClearance"),'name':("houcolCourtClearance"),'value':(loanApplicationChecklist?.houcolCourtClearance)],-1)
printHtmlPart(16)
invokeTag('checkBox','g',208,['disabled':("disabled"),'id':("houcolWaiveOfConfidentiality"),'name':("houcolWaiveOfConfidentiality"),'value':(loanApplicationChecklist?.houcolWaiveOfConfidentiality)],-1)
printHtmlPart(17)
invokeTag('checkBox','g',220,['disabled':("disabled"),'id':("houcolAuthorityToReleaseOfInformation"),'name':("houcolAuthorityToReleaseOfInformation"),'value':(loanApplicationChecklist?.houcolAuthorityToReleaseOfInformation)],-1)
printHtmlPart(18)
invokeTag('checkBox','g',232,['disabled':("disabled"),'id':("houcolClientInformationSheetBorrower"),'name':("houcolClientInformationSheetBorrower"),'value':(loanApplicationChecklist?.houcolClientInformationSheetBorrower)],-1)
printHtmlPart(19)
invokeTag('checkBox','g',244,['disabled':("disabled"),'id':("houcolClientInformationSheetComaker"),'name':("houcolClientInformationSheetComaker"),'value':(loanApplicationChecklist?.houcolClientInformationSheetComaker)],-1)
printHtmlPart(20)
invokeTag('checkBox','g',255,['disabled':("disabled"),'id':("houcolComakerStatement"),'name':("houcolComakerStatement"),'value':(loanApplicationChecklist?.houcolComakerStatement)],-1)
printHtmlPart(21)
invokeTag('checkBox','g',266,['disabled':("disabled"),'id':("houcol2pcs2x2IdPicture"),'name':("houcol2pcs2x2IdPicture"),'value':(loanApplicationChecklist?.houcol2pcs2x2IdPicture)],-1)
printHtmlPart(22)
invokeTag('checkBox','g',278,['disabled':("disabled"),'id':("houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"),'name':("houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"),'value':(loanApplicationChecklist?.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach)],-1)
printHtmlPart(23)
invokeTag('checkBox','g',291,['disabled':("disabled"),'id':("houcolProofOfBillingBrgyClearance"),'name':("houcolProofOfBillingBrgyClearance"),'value':(loanApplicationChecklist?.houcolProofOfBillingBrgyClearance)],-1)
printHtmlPart(24)
invokeTag('checkBox','g',302,['disabled':("disabled"),'id':("houcolDTIRegistration"),'name':("houcolDTIRegistration"),'value':(loanApplicationChecklist?.houcolDTIRegistration)],-1)
printHtmlPart(25)
invokeTag('checkBox','g',313,['disabled':("disabled"),'id':("houcolIncomeTaxReturnOrBIR"),'name':("houcolIncomeTaxReturnOrBIR"),'value':(loanApplicationChecklist?.houcolIncomeTaxReturnOrBIR)],-1)
printHtmlPart(26)
invokeTag('checkBox','g',325,['disabled':("disabled"),'id':("houcolProofOfOtherSourceOfIncome"),'name':("houcolProofOfOtherSourceOfIncome"),'value':(loanApplicationChecklist?.houcolProofOfOtherSourceOfIncome)],-1)
printHtmlPart(27)
invokeTag('checkBox','g',336,['disabled':("disabled"),'id':("houcolPictureOfCollateral"),'name':("houcolPictureOfCollateral"),'value':(loanApplicationChecklist?.houcolPictureOfCollateral)],-1)
printHtmlPart(28)
invokeTag('checkBox','g',347,['disabled':("disabled"),'id':("houcolREMContract"),'name':("houcolREMContract"),'value':(loanApplicationChecklist?.houcolREMContract)],-1)
printHtmlPart(29)
invokeTag('checkBox','g',359,['disabled':("disabled"),'id':("houcolLandTitle"),'name':("houcolLandTitle"),'value':(loanApplicationChecklist?.houcolLandTitle)],-1)
printHtmlPart(30)
invokeTag('checkBox','g',370,['disabled':("disabled"),'id':("houcolTaxDeclaration"),'name':("houcolTaxDeclaration"),'value':(loanApplicationChecklist?.houcolTaxDeclaration)],-1)
printHtmlPart(31)
invokeTag('checkBox','g',381,['disabled':("disabled"),'id':("houcolRealEstateTaxReceipt"),'name':("houcolRealEstateTaxReceipt"),'value':(loanApplicationChecklist?.houcolRealEstateTaxReceipt)],-1)
printHtmlPart(32)
invokeTag('checkBox','g',392,['disabled':("disabled"),'id':("houcolAbsoluteOfDeedOfSale"),'name':("houcolAbsoluteOfDeedOfSale"),'value':(loanApplicationChecklist?.houcolAbsoluteOfDeedOfSale)],-1)
printHtmlPart(33)
invokeTag('checkBox','g',403,['disabled':("disabled"),'id':("houcolBlueprints"),'name':("houcolBlueprints"),'value':(loanApplicationChecklist?.houcolBlueprints)],-1)
printHtmlPart(34)
invokeTag('checkBox','g',414,['disabled':("disabled"),'id':("houcolSpecialPowerOfAtty"),'name':("houcolSpecialPowerOfAtty"),'value':(loanApplicationChecklist?.houcolSpecialPowerOfAtty)],-1)
printHtmlPart(35)
invokeTag('checkBox','g',426,['disabled':("disabled"),'id':("houcolCertificationOfNonDelinquency"),'name':("houcolCertificationOfNonDelinquency"),'value':(loanApplicationChecklist?.houcolCertificationOfNonDelinquency)],-1)
printHtmlPart(36)
invokeTag('checkBox','g',437,['disabled':("disabled"),'id':("houcolCertificationFromCENRO"),'name':("houcolCertificationFromCENRO"),'value':(loanApplicationChecklist?.houcolCertificationFromCENRO)],-1)
printHtmlPart(37)
invokeTag('checkBox','g',448,['disabled':("disabled"),'id':("houcolAffidavitOfNonTenancy"),'name':("houcolAffidavitOfNonTenancy"),'value':(loanApplicationChecklist?.houcolAffidavitOfNonTenancy)],-1)
printHtmlPart(38)
invokeTag('checkBox','g',460,['disabled':("disabled"),'id':("houcolFireInsurancePolicyDated"),'name':("houcolFireInsurancePolicyDated"),'value':(loanApplicationChecklist?.houcolFireInsurancePolicyDated)],-1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129191L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
