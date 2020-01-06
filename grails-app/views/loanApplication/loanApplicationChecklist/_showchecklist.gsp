<%@ page import="icbs.loans.LoanApplicationChecklist" %>

<g:if test="${loanApplicationChecklist}">
<legend>Checklist </legend>

<div class="fieldcontain form-group ${hasErrors(bean:
loanApplicationChecklist, field: 'remarks', 'has-error')} ">
    <label class="control-label col-sm-4" for="remarksChecklist">

    </label>
    <div class="col-sm-8">
        <g:textArea id="remarksChecklist" name="remarksChecklist"
cols="40" rows="5" value="${loanApplicationChecklist?.remarks}"
class="form-control" readonly="true" />

    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<g:if test="${loanApplicationChecklist?.checklisttype?.id == 1}">


    <div id="salaryLoanChecklist">
   <table border=0 class="table table-hover table-condensed
table-bordered table-striped">
        <tr style="font-weight: bold;">
            <td colspan=2>
                <label ><h4>SALARY LOAN CHECKLIST</h4></label>
            </td>
        </tr>

        <tr>
            <td >
                <div>
                    <g:checkBox disabled="disabled"
id="slNoticeOfApproval" name="slNoticeOfApproval"
value="${loanApplicationChecklist?.slNoticeOfApproval}"/>

                </div>
            </td>
            <td>1. Notice of Approval (NOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditApprovalMemorandum" name="slCreditApprovalMemorandum"
value="${loanApplicationChecklist?.slCreditApprovalMemorandum}"/>

                </div>
            </td>
            <td> 2. Credit Approval Memorandum (CAM) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditApplication" name="slCreditApplication"
value="${loanApplicationChecklist?.slCreditApplication}"/>

                </div>
            </td>
            <td> 3. Credit Application (CA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditRiskRating" name="slCreditRiskRating"
value="${loanApplicationChecklist?.slCreditRiskRating}"/>

                </div>
            </td>
            <td> 4. Credit Risk Rating (CRR) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCashFlowFinancialStatement" name="slCashFlowFinancialStatement"
value="${loanApplicationChecklist?.slCashFlowFinancialStatement}"/>

                </div>
            </td>
            <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slLifeInsurance" name="slLifeInsurance"
value="${loanApplicationChecklist?.slLifeInsurance}"/>

                </div>
            </td>
            <td> 6. Life Insurance (LI) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slPromissoryNote" name="slPromissoryNote"
value="${loanApplicationChecklist?.slPromissoryNote}"/>

                </div>
            </td>
            <td> 7. Promissory Note (PN) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slDisclosureStatement" name="slDisclosureStatement"
value="${loanApplicationChecklist?.slDisclosureStatement}"/>

                </div>
            </td>
            <td> 8. Disclosure Statement (DS) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slAmortization" name="slAmortization"
value="${loanApplicationChecklist?.slAmortization}"/>

                </div>
            </td>
            <td> 9. Amortization (AMORT.) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slDeedOfAssignment" name="slDeedOfAssignment"
value="${loanApplicationChecklist?.slDeedOfAssignment}"/>

                </div>
            </td>
            <td> 10. Deed of Assignment (DOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slLoanAgreement" name="slLoanAgreement"
value="${loanApplicationChecklist?.slLoanAgreement}"/>

                </div>
            </td>
            <td> 11. Loan Agreement (LA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slLoanApplicationForm" name="slLoanApplicationForm"
value="${loanApplicationChecklist?.slLoanApplicationForm}"/>

                </div>
            </td>
            <td> 12. Loan Application Form (LAF) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditInvestigationReport" name="slCreditInvestigationReport"
value="${loanApplicationChecklist?.slCreditInvestigationReport}"/>

                </div>
            </td>
            <td> 13. Credit Investigation Report (CIR) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditBackgroundInvestigationReport"
name="slCreditBackgroundInvestigationReport"
value="${loanApplicationChecklist?.slCreditBackgroundInvestigationReport}"/>

                </div>
            </td>
            <td> 14. Credit Background Investigation Report (CBIR) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCreditInvestigationFromOtherBanks"
name="slCreditInvestigationFromOtherBanks"
value="${loanApplicationChecklist?.slCreditInvestigationFromOtherBanks}"/>

                </div>
            </td>
            <td> 15. Credit Investigation from Other Banks (CIFOB) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCourtClearance" name="slCourtClearance"
value="${loanApplicationChecklist?.slCourtClearance}"/>

                </div>
            </td>
            <td> 16. Court Clearance</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slWaiveOfConfidentiality" name="slWaiveOfConfidentiality"
value="${loanApplicationChecklist?.slWaiveOfConfidentiality}"/>

                </div>
            </td>
            <td> 17. Waive of Confidentiality</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slAuthorityToReleaseOfInformation"
name="slAuthorityToReleaseOfInformation"
value="${loanApplicationChecklist?.slAuthorityToReleaseOfInformation}"/>

                </div>
            </td>
            <td> 18. Authority to Release of Information</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slClientInformationSheetBorrower"
name="slClientInformationSheetBorrower"
value="${loanApplicationChecklist?.slClientInformationSheetBorrower}"/>

                </div>
            </td>
            <td> 19. Client Information Sheet - Borrower (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slClientInformationSheetComaker"
name="slClientInformationSheetComaker"
value="${loanApplicationChecklist?.slClientInformationSheetComaker}"/>

                </div>
            </td>
            <td> 20. Client Information Sheet - Co-Maker (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slComakerStatement" name="slComakerStatement"
value="${loanApplicationChecklist?.slComakerStatement}"/>

                </div>
            </td>
            <td> 21. Co-maker Statement</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="sl2pcs2x2IdPicture" name="sl2pcs2x2IdPicture"
value="${loanApplicationChecklist?.sl2pcs2x2IdPicture}"/>

                </div>
            </td>
            <td> 22. 2 pcs. 2x2 ID Picture</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
name="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
value="${loanApplicationChecklist?.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>

                </div>
            </td>
            <td> 23. 3 Copies of 2 Valid ID's with 3 Original Specimen
Signature each</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slProofOfBillingBrgyClearance"
name="slProofOfBillingBrgyClearance"
value="${loanApplicationChecklist?.slProofOfBillingBrgyClearance}"/>

                </div>
            </td>
            <td> 24. Proof Of Billing / Brgy. Clearance</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="sl3PayslipForThePast3Months" name="sl3PayslipForThePast3Months"
value="${loanApplicationChecklist?.sl3PayslipForThePast3Months}"/>

                </div>
            </td>
            <td> 25. 3 Payslip for the Past 3 Months</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slCertificateOfEmployment" name="slCertificateOfEmployment"
value="${loanApplicationChecklist?.slCertificateOfEmployment}"/>

                </div>
            </td>
            <td> 26. Certificate of Employment (COE)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slIncomeTaxReturnOrBIR" name="slIncomeTaxReturnOrBIR"
value="${loanApplicationChecklist?.slIncomeTaxReturnOrBIR}"/>

                </div>
            </td>
            <td> 27. Income Tax Return (ITR) or BIR 2316</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="slProofOfOtherSourceOfIncome" name="slProofOfOtherSourceOfIncome"
value="${loanApplicationChecklist?.slProofOfOtherSourceOfIncome}"/>

                </div>
            </td>
            <td> 28. Proof of Other Source of Income</td>
        </tr>

    </table>
    </div>
</g:if>
<g:if test="${loanApplicationChecklist?.checklisttype?.id == 2}">
<!-- ======================== FOR SALARY LOAN CHECKLIST
============================ -->
    <div id="businessLoanWithCollateralChecklist">
    <table border=0 class="table table-hover table-condensed
table-bordered table-striped">
        <tr style="font-weight: bold;">
            <td colspan=2>
                <label ><h4>BUSINESS LOAN WITH COLLATERAL CHECKLIST</h4></label>
            </td>
        </tr>

        <tr>
            <td >
                <div>
                    <g:checkBox disabled="disabled"
disabled="disabled" id="buscolNoticeOfApproval"
name="buscolNoticeOfApproval"
value="${loanApplicationChecklist?.buscolNoticeOfApproval}"/>

                </div>
            </td>
            <td>1. Notice of Approval (NOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditApprovalMemorandum"
name="buscolCreditApprovalMemorandum"
value="${loanApplicationChecklist?.buscolCreditApprovalMemorandum}"/>

                </div>
            </td>
            <td> 2. Credit Approval Memorandum (CAM) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditApplication" name="buscolCreditApplication"
value="${loanApplicationChecklist?.buscolCreditApplication}"/>

                </div>
            </td>
            <td> 3. Credit Application (CA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditRiskRating" name="buscolCreditRiskRating"
value="${loanApplicationChecklist?.buscolCreditRiskRating}"/>

                </div>
            </td>
            <td> 4. Credit Risk Rating (CRR) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCashFlowFinancialStatement"
name="buscolCashFlowFinancialStatement"
value="${loanApplicationChecklist?.buscolCashFlowFinancialStatement}"/>

                </div>
            </td>
            <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolLifeInsurance" name="buscolLifeInsurance"
value="${loanApplicationChecklist?.buscolLifeInsurance}"/>

                </div>
            </td>
            <td> 6. Life Insurance (LI) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolPromissoryNote" name="buscolPromissoryNote"
value="${loanApplicationChecklist?.buscolPromissoryNote}"/>

                </div>
            </td>
            <td> 7. Promissory Note (PN) </td>
        </tr>
<tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolDisclosureStatement" name="buscolDisclosureStatement"
value="${loanApplicationChecklist?.buscolDisclosureStatement}"/>

                </div>
            </td>
            <td> 8. Disclosure Statement (DS) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolAmortization" name="buscolAmortization"
value="${loanApplicationChecklist?.buscolAmortization}"/>

                </div>
            </td>
            <td> 9. Amortization (AMORT.) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolDeedOfAssignment" name="buscolDeedOfAssignment"
value="${loanApplicationChecklist?.buscolDeedOfAssignment}"/>

                </div>
            </td>
            <td> 10. Deed of Assignment (DOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolLoanAgreement" name="buscolLoanAgreement"
value="${loanApplicationChecklist?.buscolLoanAgreement}"/>

                </div>
            </td>
            <td> 11. Loan Agreement (LA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolLoanApplicationForm" name="buscolLoanApplicationForm"
value="${loanApplicationChecklist?.buscolLoanApplicationForm}"/>

                </div>
            </td>
            <td> 12. Loan Application Form (LAF) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditInvestigationReport"
name="buscolCreditInvestigationReport"
value="${loanApplicationChecklist?.buscolCreditInvestigationReport}"/>

                </div>
            </td>
            <td> 13. Credit Investigation Report (CIR) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditBackgroundInvestigationReport"
name="buscolCreditBackgroundInvestigationReport"
value="${loanApplicationChecklist?.buscolCreditBackgroundInvestigationReport}"/>

                </div>
            </td>
            <td> 14. Credit Background Investigation Report (CBIR) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolPictureOfBusiness" name="buscolPictureOfBusiness"
value="${loanApplicationChecklist?.buscolPictureOfBusiness}"/>

                </div>
            </td>
            <td> 15. Picture Of Business </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCreditInvestigationFromOtherBanks"
name="buscolCreditInvestigationFromOtherBanks"
value="${loanApplicationChecklist?.buscolCreditInvestigationFromOtherBanks}"/>

                </div>
            </td>
            <td> 16. Credit Investigation from Other Banks (CIFOB) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCourtClearance" name="buscolCourtClearance"
value="${loanApplicationChecklist?.buscolCourtClearance}"/>

                </div>
            </td>
            <td> 17. Court Clearance</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolWaiveOfConfidentiality" name="buscolWaiveOfConfidentiality"
value="${loanApplicationChecklist?.buscolWaiveOfConfidentiality}"/>

                </div>
            </td>
            <td> 18. Waive of Confidentiality</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolAuthorityToReleaseOfInformation"
name="buscolAuthorityToReleaseOfInformation"
value="${loanApplicationChecklist?.buscolAuthorityToReleaseOfInformation}"/>

                </div>
            </td>
            <td> 19. Authority to Release of Information</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolClientInformationSheetBorrower"
name="buscolClientInformationSheetBorrower"
value="${loanApplicationChecklist?.buscolClientInformationSheetBorrower}"/>

                </div>
            </td>
            <td> 20. Client Information Sheet - Borrower (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolClientInformationSheetComaker"
name="buscolClientInformationSheetComaker"
value="${loanApplicationChecklist?.buscolClientInformationSheetComaker}"/>

                </div>
            </td>
            <td> 21. Client Information Sheet - Co-Maker (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolComakerStatement" name="buscolComakerStatement"
value="${loanApplicationChecklist?.buscolComakerStatement}"/>

                </div>
            </td>
            <td> 22. Co-maker Statement</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscol2pcs2x2IdPicture" name="buscol2pcs2x2IdPicture"
value="${loanApplicationChecklist?.buscol2pcs2x2IdPicture}"/>

                </div>
            </td>
            <td> 23. 2 pcs. 2x2 ID Picture</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
name="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
value="${loanApplicationChecklist?.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>

                </div>
            </td>
            <td> 24. 3 Copies of 2 Valid ID's with 3 Original Specimen
Signature each</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolProofOfBillingBrgyClearance"
name="buscolProofOfBillingBrgyClearance"
value="${loanApplicationChecklist?.buscolProofOfBillingBrgyClearance}"/>

                </div>
            </td>
            <td> 25. Proof Of Billing / Brgy. Clearance</td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolBrgyPermitBusinessPermitBIRRegistration"
name="buscolBrgyPermitBusinessPermitBIRRegistration"
value="${loanApplicationChecklist?.buscolBrgyPermitBusinessPermitBIRRegistration}"/>

                </div>
            </td>
            <td> 26. Brgy. Permit / Business Permit / BIR Registration</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolDTIRegistration" name="buscolDTIRegistration"
value="${loanApplicationChecklist?.buscolDTIRegistration}"/>

                </div>
            </td>
            <td> 27. DTI Registration</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolIncomeTaxReturnOrBIR" name="buscolIncomeTaxReturnOrBIR"
value="${loanApplicationChecklist?.buscolIncomeTaxReturnOrBIR}"/>

                </div>
            </td>
            <td> 28. Income Tax Return (ITR) / BIR 2316</td>
        </tr>
       <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolProofOfOtherSourceOfIncome"
name="buscolProofOfOtherSourceOfIncome"
value="${loanApplicationChecklist?.buscolProofOfOtherSourceOfIncome}"/>

                </div>
            </td>
            <td> 29. Proof of Other Source of Income</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolPictureOfCollateral" name="buscolPictureOfCollateral"
value="${loanApplicationChecklist?.buscolPictureOfCollateral}"/>

                </div>
            </td>
            <td> 30. Picture of Collateral</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolREMContract" name="buscolREMContract"
value="${loanApplicationChecklist?.buscolREMContract}"/>

                </div>
            </td>
            <td> 31. REM Contract</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolChattelMortgage" name="buscolChattelMortgage"
value="${loanApplicationChecklist?.buscolChattelMortgage}"/>

                </div>
            </td>
            <td> 32. Chattel Mortgage</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolLandTitle" name="buscolLandTitle"
value="${loanApplicationChecklist?.buscolLandTitle}"/>

                </div>
            </td>
            <td> 33. Land Title</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolTaxDeclaration" name="buscolTaxDeclaration"
value="${loanApplicationChecklist?.buscolTaxDeclaration}"/>

                </div>
            </td>
            <td> 34. Tax Declaration</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolRealEstateTaxReceipt" name="buscolRealEstateTaxReceipt"
value="${loanApplicationChecklist?.buscolRealEstateTaxReceipt}"/>

                </div>
            </td>
            <td> 35. Real Estate Tax Receipt (BUWIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolAbsoluteOfDeedOfSale" name="buscolAbsoluteOfDeedOfSale"
value="${loanApplicationChecklist?.buscolAbsoluteOfDeedOfSale}"/>

                </div>
            </td>
            <td> 36. Absolute of Deed of Sale (ADS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolBlueprints" name="buscolBlueprints"
value="${loanApplicationChecklist?.buscolBlueprints}"/>

                </div>
            </td>
            <td> 37. Blueprints</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolSpecialPowerOfAtty" name="buscolSpecialPowerOfAtty"
value="${loanApplicationChecklist?.buscolSpecialPowerOfAtty}"/>

                </div>
            </td>
            <td> 38. Special Power of Atty. (SPA)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCertificationOfNonDelinquency"
name="buscolCertificationOfNonDelinquency"
value="${loanApplicationChecklist?.buscolCertificationOfNonDelinquency}"/>

                </div>
            </td>
            <td> 39. Certification of Non Delinquency</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolCertificationFromCENRO" name="buscolCertificationFromCENRO"
value="${loanApplicationChecklist?.buscolCertificationFromCENRO}"/>

                </div>
            </td>
            <td> 40. Certification from CENRO (for Tax Dec.)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolAffidavitOfNonTenancy" name="buscolAffidavitOfNonTenancy"
value="${loanApplicationChecklist?.buscolAffidavitOfNonTenancy}"/>

                </div>
            </td>
            <td> 41. Affidavit of Non Tenancy</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="buscolFireInsurancePolicyDated"
name="buscolFireInsurancePolicyDated"
value="${loanApplicationChecklist?.buscolFireInsurancePolicyDated}"/>

                </div>
            </td>
            <td> 42. Fire Insurance Policy Dated</td>
        </tr>
    </table>
</div>
</g:if>
<!-- ========================= FOR MICROFINANCE LOAN CHECKLIST
======================================= -->
<g:if test="${loanApplicationChecklist?.checklisttype?.id == 3}">
   <div id="businessLoanChecklist">
    <table border=0 class="table table-hover table-condensed
table-bordered table-striped">
        <tr style="font-weight: bold;">
            <td colspan=2>
                <label ><h4>BUSINESS LOAN CHECKLIST</h4></label>
            </td>
        </tr>

        <tr>
            <td >
                <div>
                    <g:checkBox disabled="disabled"
id="busNoticeOfApproval" name="busNoticeOfApproval"
value="${loanApplicationChecklist?.busNoticeOfApproval}"/>

                </div>
            </td>
            <td>1. Notice of Approval (NOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditApprovalMemorandum" name="busCreditApprovalMemorandum"
value="${loanApplicationChecklist?.busCreditApprovalMemorandum}"/>

                </div>
            </td>
            <td> 2. Credit Approval Memorandum (CAM) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditApplication" name="busCreditApplication"
value="${loanApplicationChecklist?.busCreditApplication}"/>

                </div>
            </td>
            <td> 3. Credit Application (CA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditRiskRating" name="busCreditRiskRating"
value="${loanApplicationChecklist?.busCreditRiskRating}"/>

                </div>
            </td>
            <td> 4. Credit Risk Rating (CRR) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCashFlowFinancialStatement"
name="busCashFlowFinancialStatement"
value="${loanApplicationChecklist?.busCashFlowFinancialStatement}"/>

                </div>
            </td>
            <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busLifeInsurance" name="busLifeInsurance"
value="${loanApplicationChecklist?.busLifeInsurance}"/>

                </div>
            </td>
            <td> 6. Life Insurance (LI) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busPromissoryNote" name="busPromissoryNote"
value="${loanApplicationChecklist?.busPromissoryNote}"/>

                </div>
            </td>
            <td> 7. Promissory Note (PN) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busDisclosureStatement" name="busDisclosureStatement"
value="${loanApplicationChecklist?.busDisclosureStatement}"/>

                </div>
            </td>
            <td> 8. Disclosure Statement (DS) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busAmortization" name="busAmortization"
value="${loanApplicationChecklist?.busAmortization}"/>

                </div>
            </td>
            <td> 9. Amortization (AMORT.) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busDeedOfAssignment" name="busDeedOfAssignment"
value="${loanApplicationChecklist?.busDeedOfAssignment}"/>

                </div>
            </td>
            <td> 10. Deed of Assignment (DOA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busLoanAgreement" name="busLoanAgreement"
value="${loanApplicationChecklist?.busLoanAgreement}"/>

                </div>
            </td>
            <td> 11. Loan Agreement (LA) </td>
        </tr>

        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busLoanApplicationForm" name="busLoanApplicationForm"
value="${loanApplicationChecklist?.busLoanApplicationForm}"/>

                </div>
            </td>
            <td> 12. Loan Application Form (LAF) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditInvestigationReport" name="busCreditInvestigationReport"
value="${loanApplicationChecklist?.busCreditInvestigationReport}"/>

                </div>
            </td>
            <td> 13. Credit Investigation Report (CIR) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditBackgroundInvestigationReport"
name="busCreditBackgroundInvestigationReport"
value="${loanApplicationChecklist?.busCreditBackgroundInvestigationReport}"/>

                </div>
            </td>
            <td> 14. Credit Background Investigation Report (CBIR) </td>
        </tr>
       <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busPictureOfBusiness" name="busPictureOfBusiness"
value="${loanApplicationChecklist?.busPictureOfBusiness}"/>

                </div>
            </td>
            <td> 15. Picture of Business </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCreditInvestigationFromOtherBanks"
name="busCreditInvestigationFromOtherBanks"
value="${loanApplicationChecklist?.busCreditInvestigationFromOtherBanks}"/>

                </div>
            </td>
            <td> 16. Credit Investigation from Other Banks (CIFOB) </td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busCourtClearance" name="busCourtClearance"
value="${loanApplicationChecklist?.busCourtClearance}"/>

                </div>
            </td>
            <td> 17. Court Clearance</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busWaiveOfConfidentiality" name="busWaiveOfConfidentiality"
value="${loanApplicationChecklist?.busWaiveOfConfidentiality}"/>

                </div>
            </td>
            <td> 18. Waive of Confidentiality</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busAuthorityToReleaseOfInformation"
name="busAuthorityToReleaseOfInformation"
value="${loanApplicationChecklist?.busAuthorityToReleaseOfInformation}"/>

                </div>
            </td>
            <td> 19. Authority to Release of Information</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busClientInformationSheetBorrower"
name="busClientInformationSheetBorrower"
value="${loanApplicationChecklist?.busClientInformationSheetBorrower}"/>

                </div>
            </td>
            <td> 20. Client Information Sheet - Borrower (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busClientInformationSheetComaker"
name="busClientInformationSheetComaker"
value="${loanApplicationChecklist?.busClientInformationSheetComaker}"/>

                </div>
            </td>
            <td> 21. Client Information Sheet - Co-Maker (CIS)</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busComakerStatement" name="busComakerStatement"
value="${loanApplicationChecklist?.busComakerStatement}"/>

                </div>
            </td>
            <td> 22. Co-maker Statement</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="bus2pcs2x2IdPicture" name="bus2pcs2x2IdPicture"
value="${loanApplicationChecklist?.bus2pcs2x2IdPicture}"/>

                </div>
            </td>
            <td> 23. 2 pcs. 2x2 ID Picture</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
name="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
value="${loanApplicationChecklist?.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>

                </div>
            </td>
            <td> 24. 3 Copies of 2 Valid ID's with 3 Original Specimen
Signature each</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busProofOfBillingBrgyClearance"
name="busProofOfBillingBrgyClearance"
value="${loanApplicationChecklist?.busProofOfBillingBrgyClearance}"/>

                </div>
            </td>
            <td> 25. Proof Of Billing / Brgy. Clearance</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busBrgyPermitBusinessPermitBIRRegistration"
name="busBrgyPermitBusinessPermitBIRRegistration"
value="${loanApplicationChecklist?.busBrgyPermitBusinessPermitBIRRegistration}"/>

                </div>
            </td>
            <td> 26. Brgy. Permit / Business Permit / BIR Registration</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busDTIRegistration" name="busDTIRegistration"
value="${loanApplicationChecklist?.busDTIRegistration}"/>

                </div>
            </td>
            <td> 27. DTI Registration</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busIncomeTaxReturnOrBIR" name="busIncomeTaxReturnOrBIR"
value="${loanApplicationChecklist?.busIncomeTaxReturnOrBIR}"/>

                </div>
            </td>
            <td> 28. Income Tax Return (ITR) or BIR 2316</td>
        </tr>
        <tr>
            <td>
                <div>
                    <g:checkBox disabled="disabled"
id="busProofOfOtherSourceOfIncome"
name="busProofOfOtherSourceOfIncome"
value="${loanApplicationChecklist?.busProofOfOtherSourceOfIncome}"/>

                </div>
            </td>
            <td> 29. Proof of Other Source of Income</td>
        </tr>

    </table>
</div>
</g:if>
<g:if test="${loanApplicationChecklist?.checklisttype?.id == 4}">
         <div id="housingLoanWithCollateralChecklist">
     <g:render template="loanApplicationChecklist/form4"/>
</div>
</g:if>
</g:if>
<g:else>
    <legend>Please update loan account. </legend>
    </g:else>