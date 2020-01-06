<%@ page import="icbs.loans.LoanApplicationChecklist" %>


<legend>Checklist </legend>

<div class="fieldcontain form-group ${hasErrors(bean:
loanApplicationChecklist, field: 'remarks', 'has-error')} ">
    <label class="control-label col-sm-4" for="remarksChecklist">
        <g:message code="loanApplicationChecklist.remarks.label"
            default="Remarks" />

    </label>
    <div class="col-sm-8">
        <g:textArea id="remarksChecklist" name="remarksChecklist"
        cols="40" rows="5" value="${loanApplicationChecklist?.remarks}"
            class="form-control" />
        <g:hasErrors bean="${loanApplicationChecklist}" field="remarks">

        </g:hasErrors>
    </div>
</div>

<div class="fieldcontain form-group ${hasErrors(bean:
cfgAcctGlTemplateDetInstance, field: 'glTemplate', 'has-error')}
     required">
    <label class="control-label col-sm-4" for="glTemplate">
        <g:message code="cfgAcctGlTemplateDet.glTemplate.label"
            default="Checklist Type" />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:select id="checklisttype" name="checklisttype"
        from="${icbs.lov.CreditInvestigationChecklistType.list()}"
            onchange="changeFormchecklist();" optionValue="description"
            optionKey="id" required=""
        value="${loanApplicationChecklist?.checklisttype?.id}"
            class="many-to-one form-control"/>
    </div>
</div>
</br></br></br>
<div id="salaryLoanChecklist" style="display: none;">
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
                <g:checkBox disabled="${disabled}"
                    id="slNoticeOfApproval" name="slNoticeOfApproval"
                value="${loanApplicationChecklist?.slNoticeOfApproval}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slNoticeOfApproval">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slNoticeOfApproval">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td>1. Notice of Approval (NOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slCreditApprovalMemorandum"
                    name="slCreditApprovalMemorandum"
                value="${loanApplicationChecklist?.slCreditApprovalMemorandum}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditApprovalMemorandum">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slCreditApprovalMemorandum">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 2. Credit Approval Memorandum (CAM) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slCreditApplication"
                    name="slCreditApplication"
                value="${loanApplicationChecklist?.slCreditApplication}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditApplication">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slCreditApplication">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 3. Credit Application (CA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slCreditRiskRating"
                    name="slCreditRiskRating"
                value="${loanApplicationChecklist?.slCreditRiskRating}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditRiskRating">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slCreditRiskRating">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 4. Credit Risk Rating (CRR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slCashFlowFinancialStatement"
                    name="slCashFlowFinancialStatement"
                value="${loanApplicationChecklist?.slCashFlowFinancialStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCashFlowFinancialStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slCashFlowFinancialStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slLifeInsurance"
                    name="slLifeInsurance"
                value="${loanApplicationChecklist?.slLifeInsurance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slLifeInsurance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slLifeInsurance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 6. Life Insurance (LI) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slPromissoryNote"
                    name="slPromissoryNote"
                value="${loanApplicationChecklist?.slPromissoryNote}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slPromissoryNote">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slPromissoryNote">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 7. Promissory Note (PN) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slDisclosureStatement"
                    name="slDisclosureStatement"
                value="${loanApplicationChecklist?.slDisclosureStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slDisclosureStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slDisclosureStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 8. Disclosure Statement (DS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slAmortization"
                    name="slAmortization"
                value="${loanApplicationChecklist?.slAmortization}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slAmortization">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slAmortization">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 9. Amortization (AMORT.) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slDeedOfAssignment"
                    name="slDeedOfAssignment"
                value="${loanApplicationChecklist?.slDeedOfAssignment}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slDeedOfAssignment">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slDeedOfAssignment">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 10. Deed of Assignment (DOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slLoanAgreement"
                    name="slLoanAgreement"
                value="${loanApplicationChecklist?.slLoanAgreement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slLoanAgreement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slLoanAgreement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 11. Loan Agreement (LA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="slLoanApplicationForm"
                    name="slLoanApplicationForm"
                value="${loanApplicationChecklist?.slLoanApplicationForm}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slLoanApplicationForm">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slLoanApplicationForm">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 12. Loan Application Form (LAF) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slCreditInvestigationReport"
                    name="slCreditInvestigationReport"
                value="${loanApplicationChecklist?.slCreditInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slCreditInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 13. Credit Investigation Report (CIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="slCreditBackgroundInvestigationReport"
                    name="slCreditBackgroundInvestigationReport"
                value="${loanApplicationChecklist?.slCreditBackgroundInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditBackgroundInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slCreditBackgroundInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 14. Credit Background Investigation Report (CBIR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox
                    id="slCreditInvestigationFromOtherBanks"
                    name="slCreditInvestigationFromOtherBanks"
                value="${loanApplicationChecklist?.slCreditInvestigationFromOtherBanks}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCreditInvestigationFromOtherBanks">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slCreditInvestigationFromOtherBanks">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 15. Credit Investigation from Other Banks (CIFOB) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slCourtClearance"
                    name="slCourtClearance"
                value="${loanApplicationChecklist?.slCourtClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCourtClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slCourtClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 16. Court Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slWaiveOfConfidentiality"
                    name="slWaiveOfConfidentiality"
                value="${loanApplicationChecklist?.slWaiveOfConfidentiality}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slWaiveOfConfidentiality">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slWaiveOfConfidentiality">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 17. Waive of Confidentiality</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slAuthorityToReleaseOfInformation"
                    name="slAuthorityToReleaseOfInformation"
                value="${loanApplicationChecklist?.slAuthorityToReleaseOfInformation}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slAuthorityToReleaseOfInformation">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slAuthorityToReleaseOfInformation">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 18. Authority to Release of Information</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slClientInformationSheetBorrower"
                    name="slClientInformationSheetBorrower"
                value="${loanApplicationChecklist?.slClientInformationSheetBorrower}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slClientInformationSheetBorrower">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slClientInformationSheetBorrower">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 19. Client Information Sheet - Borrower (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slClientInformationSheetComaker"
                    name="slClientInformationSheetComaker"
                value="${loanApplicationChecklist?.slClientInformationSheetComaker}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slClientInformationSheetComaker">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slClientInformationSheetComaker">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 20. Client Information Sheet - Co-Maker (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slComakerStatement"
                    name="slComakerStatement"
                value="${loanApplicationChecklist?.slComakerStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slComakerStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slComakerStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 21. Co-maker Statement</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="sl2pcs2x2IdPicture"
                    name="sl2pcs2x2IdPicture"
                value="${loanApplicationChecklist?.sl2pcs2x2IdPicture}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="sl2pcs2x2IdPicture">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="sl2pcs2x2IdPicture">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 22. 2 pcs. 2x2 ID Picture</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                    name="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                value="${loanApplicationChecklist?.sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="sl3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 23. 3 Copies of 2 Valid ID's with 3 Original Specimen
            Signature each</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slProofOfBillingBrgyClearance"
                    name="slProofOfBillingBrgyClearance"
                value="${loanApplicationChecklist?.slProofOfBillingBrgyClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slProofOfBillingBrgyClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slProofOfBillingBrgyClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 24. Proof Of Billing / Brgy. Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="sl3PayslipForThePast3Months"
                    name="sl3PayslipForThePast3Months"
                value="${loanApplicationChecklist?.sl3PayslipForThePast3Months}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="sl3PayslipForThePast3Months">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="sl3PayslipForThePast3Months">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 25. 3 Payslip for the Past 3 Months</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slCertificateOfEmployment"
                    name="slCertificateOfEmployment"
                value="${loanApplicationChecklist?.slCertificateOfEmployment}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slCertificateOfEmployment">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slCertificateOfEmployment">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 26. Certificate of Employment (COE)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slIncomeTaxReturnOrBIR"
                    name="slIncomeTaxReturnOrBIR"
                value="${loanApplicationChecklist?.slIncomeTaxReturnOrBIR}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slIncomeTaxReturnOrBIR">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="slIncomeTaxReturnOrBIR">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 27. Income Tax Return (ITR) or BIR 2316</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="slProofOfOtherSourceOfIncome"
                    name="slProofOfOtherSourceOfIncome"
                value="${loanApplicationChecklist?.slProofOfOtherSourceOfIncome}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="slProofOfOtherSourceOfIncome">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="slProofOfOtherSourceOfIncome">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 28. Proof of Other Source of Income</td>
    </tr>

</table>
</div>
<!-- ======================== FOR SALARY LOAN CHECKLIST
============================ -->
<div id="businessLoanWithCollateralChecklist" style="display:none;">
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
                <g:checkBox disabled="${disabled}"
                    id="buscolNoticeOfApproval" name="buscolNoticeOfApproval"
                value="${loanApplicationChecklist?.buscolNoticeOfApproval}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolNoticeOfApproval">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolNoticeOfApproval">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td>1. Notice of Approval (NOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCreditApprovalMemorandum"
                    name="buscolCreditApprovalMemorandum"
                value="${loanApplicationChecklist?.buscolCreditApprovalMemorandum}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditApprovalMemorandum">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCreditApprovalMemorandum">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 2. Credit Approval Memorandum (CAM) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCreditApplication"
                    name="buscolCreditApplication"
                value="${loanApplicationChecklist?.buscolCreditApplication}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditApplication">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolCreditApplication">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 3. Credit Application (CA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCreditRiskRating"
                    name="buscolCreditRiskRating"
                value="${loanApplicationChecklist?.buscolCreditRiskRating}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditRiskRating">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolCreditRiskRating">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 4. Credit Risk Rating (CRR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCashFlowFinancialStatement"
                    name="buscolCashFlowFinancialStatement"
                value="${loanApplicationChecklist?.buscolCashFlowFinancialStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCashFlowFinancialStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCashFlowFinancialStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolLifeInsurance"
                    name="buscolLifeInsurance"
                value="${loanApplicationChecklist?.buscolLifeInsurance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolLifeInsurance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolLifeInsurance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 6. Life Insurance (LI) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolPromissoryNote"
                    name="buscolPromissoryNote"
                value="${loanApplicationChecklist?.buscolPromissoryNote}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolPromissoryNote">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolPromissoryNote">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 7. Promissory Note (PN) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolDisclosureStatement"
                    name="buscolDisclosureStatement"
                value="${loanApplicationChecklist?.buscolDisclosureStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolDisclosureStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolDisclosureStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 8. Disclosure Statement (DS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolAmortization"
                    name="buscolAmortization"
                value="${loanApplicationChecklist?.buscolAmortization}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolAmortization">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolAmortization">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 9. Amortization (AMORT.) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolDeedOfAssignment"
                    name="buscolDeedOfAssignment"
                value="${loanApplicationChecklist?.buscolDeedOfAssignment}"/>
                <g:hasErrors bean="${loanApplicafdtionChecklist}"
                    field="buscolDeedOfAssignment">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolDeedOfAssignment">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 10. Deed of Assignment (DOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolLoanAgreement"
                    name="buscolLoanAgreement"
                value="${loanApplicationChecklist?.buscolLoanAgreement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolLoanAgreement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolLoanAgreement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 11. Loan Agreement (LA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolLoanApplicationForm"
                    name="buscolLoanApplicationForm"
                value="${loanApplicationChecklist?.buscolLoanApplicationForm}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolLoanApplicationForm">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolLoanApplicationForm">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 12. Loan Application Form (LAF) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCreditInvestigationReport"
                    name="buscolCreditInvestigationReport"
                value="${loanApplicationChecklist?.buscolCreditInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCreditInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 13. Credit Investigation Report (CIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolCreditBackgroundInvestigationReport"
                    name="buscolCreditBackgroundInvestigationReport"
                value="${loanApplicationChecklist?.buscolCreditBackgroundInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditBackgroundInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCreditBackgroundInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 14. Credit Background Investigation Report (CBIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolPictureOfBusiness"
                    name="buscolPictureOfBusiness"
                value="${loanApplicationChecklist?.buscolPictureOfBusiness}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolPictureOfBusiness">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolPictureOfBusiness">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 15. Picture Of Business </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolCreditInvestigationFromOtherBanks"
                    name="buscolCreditInvestigationFromOtherBanks"
                value="${loanApplicationChecklist?.buscolCreditInvestigationFromOtherBanks}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCreditInvestigationFromOtherBanks">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCreditInvestigationFromOtherBanks">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 16. Credit Investigation from Other Banks (CIFOB) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCourtClearance"
                    name="buscolCourtClearance"
                value="${loanApplicationChecklist?.buscolCourtClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCourtClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolCourtClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 17. Court Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolWaiveOfConfidentiality"
                    name="buscolWaiveOfConfidentiality"
                value="${loanApplicationChecklist?.buscolWaiveOfConfidentiality}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolWaiveOfConfidentiality">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolWaiveOfConfidentiality">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 18. Waive of Confidentiality</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolAuthorityToReleaseOfInformation"
                    name="buscolAuthorityToReleaseOfInformation"
                value="${loanApplicationChecklist?.buscolAuthorityToReleaseOfInformation}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolAuthorityToReleaseOfInformation">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolAuthorityToReleaseOfInformation">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 19. Authority to Release of Information</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolClientInformationSheetBorrower"
                    name="buscolClientInformationSheetBorrower"
                value="${loanApplicationChecklist?.buscolClientInformationSheetBorrower}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolClientInformationSheetBorrower">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolClientInformationSheetBorrower">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 20. Client Information Sheet - Borrower (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolClientInformationSheetComaker"
                    name="buscolClientInformationSheetComaker"
                value="${loanApplicationChecklist?.buscolClientInformationSheetComaker}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolClientInformationSheetComaker">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolClientInformationSheetComaker">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 21. Client Information Sheet - Co-Maker (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolComakerStatement"
                    name="buscolComakerStatement"
                value="${loanApplicationChecklist?.buscolComakerStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolComakerStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolComakerStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 22. Co-maker Statement</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscol2pcs2x2IdPicture"
                    name="buscol2pcs2x2IdPicture"
                value="${loanApplicationChecklist?.buscol2pcs2x2IdPicture}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscol2pcs2x2IdPicture">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscol2pcs2x2IdPicture">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 23. 2 pcs. 2x2 ID Picture</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                    name="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                value="${loanApplicationChecklist?.buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 24. 3 Copies of 2 Valid ID's with 3 Original Specimen
            Signature each</td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="buscolProofOfBillingBrgyClearance"
                    name="buscolProofOfBillingBrgyClearance"
                value="${loanApplicationChecklist?.buscolProofOfBillingBrgyClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolProofOfBillingBrgyClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolProofOfBillingBrgyClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 25. Proof of Billing / Brgy. Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolBrgyPermitBusinessPermitBIRRegistration"
                    name="buscolBrgyPermitBusinessPermitBIRRegistration"
                value="${loanApplicationChecklist?.buscolBrgyPermitBusinessPermitBIRRegistration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolBrgyPermitBusinessPermitBIRRegistration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolBrgyPermitBusinessPermitBIRRegistration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 26. Brgy. Permit / Business Permit / BIR Registration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolDTIRegistration"
                    name="buscolDTIRegistration"
                value="${loanApplicationChecklist?.buscolDTIRegistration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolDTIRegistration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolDTIRegistration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 27. DTI Registration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolIncomeTaxReturnOrBIR"
                    name="buscolIncomeTaxReturnOrBIR"
                value="${loanApplicationChecklist?.buscolIncomeTaxReturnOrBIR}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolIncomeTaxReturnOrBIR">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolIncomeTaxReturnOrBIR">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 28. Income Tax Return (ITR) / BIR 2316</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolProofOfOtherSourceOfIncome"
                    name="buscolProofOfOtherSourceOfIncome"
                value="${loanApplicationChecklist?.buscolProofOfOtherSourceOfIncome}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolProofOfOtherSourceOfIncome">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolProofOfOtherSourceOfIncome">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 29. Proof of Other Source of Income</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolPictureOfCollateral"
                    name="buscolPictureOfCollateral"
                value="${loanApplicationChecklist?.buscolPictureOfCollateral}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolPictureOfCollateral">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolPictureOfCollateral">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 30. Picture of Collateral</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolREMContract"
                    name="buscolREMContract"
                value="${loanApplicationChecklist?.buscolREMContract}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolREMContract">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolREMContract">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 31. REM Contract</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolChattelMortgage"
                    name="buscolChattelMortgage"
                value="${loanApplicationChecklist?.buscolChattelMortgage}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolChattelMortgage">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolChattelMortgage">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 32. Chattel Mortgage</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolLandTitle"
                    name="buscolLandTitle"
                value="${loanApplicationChecklist?.buscolLandTitle}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolLandTitle">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolLandTitle">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 33. Land Title</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolTaxDeclaration"
                    name="buscolTaxDeclaration"
                value="${loanApplicationChecklist?.buscolTaxDeclaration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolTaxDeclaration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolTaxDeclaration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 34. Tax Declaration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolRealEstateTaxReceipt"
                    name="buscolRealEstateTaxReceipt"
                value="${loanApplicationChecklist?.buscolRealEstateTaxReceipt}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolRealEstateTaxReceipt">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolRealEstateTaxReceipt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 35. Real Estate Tax Receipt (BUWIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolAbsoluteOfDeedOfSale"
                    name="buscolAbsoluteOfDeedOfSale"
                value="${loanApplicationChecklist?.buscolAbsoluteOfDeedOfSale}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolAbsoluteOfDeedOfSale">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolAbsoluteOfDeedOfSale">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 36. Absolute of Deed of Sale (ADS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolBlueprints"
                    name="buscolBlueprints"
                value="${loanApplicationChecklist?.buscolBlueprints}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolBlueprints">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolBlueprints">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 37. Blueprints</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolSpecialPowerOfAtty"
                    name="buscolSpecialPowerOfAtty"
                value="${loanApplicationChecklist?.buscolSpecialPowerOfAtty}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolSpecialPowerOfAtty">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="buscolSpecialPowerOfAtty">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 38. Special Power of Atty. (SPA)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="buscolCertificationOfNonDelinquency"
                    name="buscolCertificationOfNonDelinquency"
                value="${loanApplicationChecklist?.buscolCertificationOfNonDelinquency}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCertificationOfNonDelinquency">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCertificationOfNonDelinquency">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 39. Certification of Non Delinquency</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolCertificationFromCENRO"
                    name="buscolCertificationFromCENRO"
                value="${loanApplicationChecklist?.buscolCertificationFromCENRO}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolCertificationFromCENRO">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolCertificationFromCENRO">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 40. Certification from CENRO (for Tax Dec.)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolAffidavitOfNonTenancy"
                    name="buscolAffidavitOfNonTenancy"
                value="${loanApplicationChecklist?.buscolAffidavitOfNonTenancy}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolAffidavitOfNonTenancy">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolAffidavitOfNonTenancy">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 41. Affidavit of Non Tenancy</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="buscolFireInsurancePolicyDated"
                    name="buscolFireInsurancePolicyDated"
                value="${loanApplicationChecklist?.buscolFireInsurancePolicyDated}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="buscolFireInsurancePolicyDated">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="buscolFireInsurancePolicyDated">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 42. Fire Insurance Policy Dated</td>
    </tr>
</table>
</div>
<!-- ========================= FOR MICROFINANCE LOAN CHECKLIST
======================================= -->

<div id="businessLoanChecklist" style="display: none;">
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
                <g:checkBox disabled="${disabled}"
                    id="busNoticeOfApproval" name="busNoticeOfApproval"
                value="${loanApplicationChecklist?.busNoticeOfApproval}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busNoticeOfApproval">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busNoticeOfApproval">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td>1. Notice of Approval (NOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busCreditApprovalMemorandum"
                    name="busCreditApprovalMemorandum"
                value="${loanApplicationChecklist?.busCreditApprovalMemorandum}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditApprovalMemorandum">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busCreditApprovalMemorandum">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 2. Credit Approval Memorandum (CAM) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busCreditApplication"
                    name="busCreditApplication"
                value="${loanApplicationChecklist?.busCreditApplication}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditApplication">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busCreditApplication">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 3. Credit Application (CA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busCreditRiskRating"
                    name="busCreditRiskRating"
                value="${loanApplicationChecklist?.busCreditRiskRating}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditRiskRating">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busCreditRiskRating">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 4. Credit Risk Rating (CRR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busCashFlowFinancialStatement"
                    name="busCashFlowFinancialStatement"
                value="${loanApplicationChecklist?.busCashFlowFinancialStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCashFlowFinancialStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busCashFlowFinancialStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busLifeInsurance"
                    name="busLifeInsurance"
                value="${loanApplicationChecklist?.busLifeInsurance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busLifeInsurance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busLifeInsurance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 6. Life Insurance (LI) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busPromissoryNote"
                    name="busPromissoryNote"
                value="${loanApplicationChecklist?.busPromissoryNote}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busPromissoryNote">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busPromissoryNote">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 7. Promissory Note (PN) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busDisclosureStatement"
                    name="busDisclosureStatement"
                value="${loanApplicationChecklist?.busDisclosureStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busDisclosureStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busDisclosureStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 8. Disclosure Statement (DS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busAmortization"
                    name="busAmortization"
                value="${loanApplicationChecklist?.busAmortization}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busAmortization">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busAmortization">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 9. Amortization (AMORT.) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busDeedOfAssignment"
                    name="busDeedOfAssignment"
                value="${loanApplicationChecklist?.busDeedOfAssignment}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busDeedOfAssignment">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busDeedOfAssignment">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 10. Deed of Assignment (DOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busLoanAgreement"
                    name="busLoanAgreement"
                value="${loanApplicationChecklist?.busLoanAgreement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busLoanAgreement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busLoanAgreement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 11. Loan Agreement (LA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="busLoanApplicationForm"
                    name="busLoanApplicationForm"
                value="${loanApplicationChecklist?.busLoanApplicationForm}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busLoanApplicationForm">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busLoanApplicationForm">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 12. Loan Application Form (LAF) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busCreditInvestigationReport"
                    name="busCreditInvestigationReport"
                value="${loanApplicationChecklist?.busCreditInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busCreditInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 13. Credit Investigation Report (CIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="busCreditBackgroundInvestigationReport"
                    name="busCreditBackgroundInvestigationReport"
                value="${loanApplicationChecklist?.busCreditBackgroundInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditBackgroundInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busCreditBackgroundInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 14. Credit Background Investigation Report (CBIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busPictureOfBusiness"
                    name="busPictureOfBusiness"
                value="${loanApplicationChecklist?.busPictureOfBusiness}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busPictureOfBusiness">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busPictureOfBusiness">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 15. Picture of Business </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="busCreditInvestigationFromOtherBanks"
                    name="busCreditInvestigationFromOtherBanks"
                value="${loanApplicationChecklist?.busCreditInvestigationFromOtherBanks}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCreditInvestigationFromOtherBanks">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busCreditInvestigationFromOtherBanks">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 16. Credit Investigation from Other Banks (CIFOB) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busCourtClearance"
                    name="busCourtClearance"
                value="${loanApplicationChecklist?.busCourtClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busCourtClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busCourtClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 17. Court Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busWaiveOfConfidentiality"
                    name="busWaiveOfConfidentiality"
                value="${loanApplicationChecklist?.busWaiveOfConfidentiality}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busWaiveOfConfidentiality">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busWaiveOfConfidentiality">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 18. Waive of Confidentiality</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="busAuthorityToReleaseOfInformation"
                    name="busAuthorityToReleaseOfInformation"
                value="${loanApplicationChecklist?.busAuthorityToReleaseOfInformation}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busAuthorityToReleaseOfInformation">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busAuthorityToReleaseOfInformation">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 19. Authority to Release of Information</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busClientInformationSheetBorrower"
                    name="busClientInformationSheetBorrower"
                value="${loanApplicationChecklist?.busClientInformationSheetBorrower}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busClientInformationSheetBorrower">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busClientInformationSheetBorrower">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 20. Client Information Sheet - Borrower (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busClientInformationSheetComaker"
                    name="busClientInformationSheetComaker"
                value="${loanApplicationChecklist?.busClientInformationSheetComaker}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busClientInformationSheetComaker">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busClientInformationSheetComaker">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 21. Client Information Sheet - Co-Maker (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busComakerStatement"
                    name="busComakerStatement"
                value="${loanApplicationChecklist?.busComakerStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busComakerStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busComakerStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 22. Co-maker Statement</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="bus2pcs2x2IdPicture"
                    name="bus2pcs2x2IdPicture"
                value="${loanApplicationChecklist?.bus2pcs2x2IdPicture}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="bus2pcs2x2IdPicture">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="bus2pcs2x2IdPicture">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 23. 2 pcs. 2x2 ID Picture</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                    name="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                value="${loanApplicationChecklist?.bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="bus3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 24. 3 Copies of 2 Valid ID's with 3 Original Specimen
            Signature each</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busProofOfBillingBrgyClearance"
                    name="busProofOfBillingBrgyClearance"
                value="${loanApplicationChecklist?.busProofOfBillingBrgyClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busProofOfBillingBrgyClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busProofOfBillingBrgyClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 25. Proof Of Billing / Brgy. Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="busBrgyPermitBusinessPermitBIRRegistration"
                    name="busBrgyPermitBusinessPermitBIRRegistration"
                value="${loanApplicationChecklist?.busBrgyPermitBusinessPermitBIRRegistration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busBrgyPermitBusinessPermitBIRRegistration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busBrgyPermitBusinessPermitBIRRegistration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 26. Brgy. Permit / Business Permit / BIR Registration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busDTIRegistration"
                    name="busDTIRegistration"
                value="${loanApplicationChecklist?.busDTIRegistration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busDTIRegistration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busDTIRegistration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 27. DTI Registration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busIncomeTaxReturnOrBIR"
                    name="busIncomeTaxReturnOrBIR"
                value="${loanApplicationChecklist?.busIncomeTaxReturnOrBIR}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busIncomeTaxReturnOrBIR">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="busIncomeTaxReturnOrBIR">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 28. Income Tax Return (ITR) or BIR 2316</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="busProofOfOtherSourceOfIncome"
                    name="busProofOfOtherSourceOfIncome"
                value="${loanApplicationChecklist?.busProofOfOtherSourceOfIncome}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="busProofOfOtherSourceOfIncome">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="busProofOfOtherSourceOfIncome">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 29. Proof of Other Source of Income</td>
    </tr>

</table>
</div>


<div id="housingLoanWithCollateralChecklist" >
    <table border=0 class="table table-hover table-condensed
    table-bordered table-striped">
    <tr style="font-weight: bold;">
        <td colspan=2>
            <label ><h4>HOUSING LOAN WITH COLLATERAL CHECKLIST</h4></label>
        </td>
    </tr>

    <tr>
        <td >
            <div>
                <g:checkBox disabled="${disabled}"
                    id="houcolNoticeOfApproval" name="houcolNoticeOfApproval"
                value="${loanApplicationChecklist?.houcolNoticeOfApproval}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolNoticeOfApproval">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolNoticeOfApproval">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td>1. Notice of Approval (NOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCreditApprovalMemorandum"
                    name="houcolCreditApprovalMemorandum"
                value="${loanApplicationChecklist?.houcolCreditApprovalMemorandum}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditApprovalMemorandum">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCreditApprovalMemorandum">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 2. Credit Approval Memorandum (CAM) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCreditApplication"
                    name="houcolCreditApplication"
                value="${loanApplicationChecklist?.houcolCreditApplication}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditApplication">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolCreditApplication">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 3. Credit Application (CA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCreditRiskRating"
                    name="houcolCreditRiskRating"
                value="${loanApplicationChecklist?.houcolCreditRiskRating}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditRiskRating">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolCreditRiskRating">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 4. Credit Risk Rating (CRR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCashFlowFinancialStatement"
                    name="houcolCashFlowFinancialStatement"
                value="${loanApplicationChecklist?.houcolCashFlowFinancialStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCashFlowFinancialStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCashFlowFinancialStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 5. Cash Flow / Financial Statement (CF/FS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolLifeInsurance"
                    name="houcolLifeInsurance"
                value="${loanApplicationChecklist?.houcolLifeInsurance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolLifeInsurance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolLifeInsurance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 6. Life Insurance (LI) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolPromissoryNote"
                    name="houcolPromissoryNote"
                value="${loanApplicationChecklist?.houcolPromissoryNote}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolPromissoryNote">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolPromissoryNote">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 7. Promissory Note (PN) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolDisclosureStatement"
                    name="houcolDisclosureStatement"
                value="${loanApplicationChecklist?.houcolDisclosureStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolDisclosureStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolDisclosureStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 8. Disclosure Statement (DS) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolAmortization"
                    name="houcolAmortization"
                value="${loanApplicationChecklist?.houcolAmortization}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolAmortization">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolAmortization">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 9. Amortization (AMORT.) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolDeedOfAssignment"
                    name="houcolDeedOfAssignment"
                value="${loanApplicationChecklist?.houcolDeedOfAssignment}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolDeedOfAssignment">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolDeedOfAssignment">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 10. Deed of Assignment (DOA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolLoanAgreement"
                    name="houcolLoanAgreement"
                value="${loanApplicationChecklist?.houcolLoanAgreement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolLoanAgreement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolLoanAgreement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 11. Loan Agreement (LA) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolLoanApplicationForm"
                    name="houcolLoanApplicationForm"
                value="${loanApplicationChecklist?.houcolLoanApplicationForm}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolLoanApplicationForm">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolLoanApplicationForm">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 12. Loan Application Form (LAF) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCreditInvestigationReport"
                    name="houcolCreditInvestigationReport"
                value="${loanApplicationChecklist?.houcolCreditInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCreditInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 13. Credit Investigation Report (CIR) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolCreditBackgroundInvestigationReport"
                    name="houcolCreditBackgroundInvestigationReport"
                value="${loanApplicationChecklist?.houcolCreditBackgroundInvestigationReport}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditBackgroundInvestigationReport">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCreditBackgroundInvestigationReport">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 14. Credit Background Investigation Report (CBIR) </td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolCreditInvestigationFromOtherBanks"
                    name="houcolCreditInvestigationFromOtherBanks"
                value="${loanApplicationChecklist?.houcolCreditInvestigationFromOtherBanks}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCreditInvestigationFromOtherBanks">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCreditInvestigationFromOtherBanks">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 15. Credit Investigation from Other Banks (CIFOB) </td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCourtClearance"
                    name="houcolCourtClearance"
                value="${loanApplicationChecklist?.houcolCourtClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCourtClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolCourtClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 16. Court Clearance</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolWaiveOfConfidentiality"
                    name="houcolWaiveOfConfidentiality"
                value="${loanApplicationChecklist?.houcolWaiveOfConfidentiality}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolWaiveOfConfidentiality">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolWaiveOfConfidentiality">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 17. Waive of Confidentiality</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolAuthorityToReleaseOfInformation"
                    name="houcolAuthorityToReleaseOfInformation"
                value="${loanApplicationChecklist?.houcolAuthorityToReleaseOfInformation}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolAuthorityToReleaseOfInformation">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolAuthorityToReleaseOfInformation">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 18. Authority to Release of Information</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolClientInformationSheetBorrower"
                    name="houcolClientInformationSheetBorrower"
                value="${loanApplicationChecklist?.houcolClientInformationSheetBorrower}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolClientInformationSheetBorrower">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolClientInformationSheetBorrower">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 19. Client Information Sheet - Borrower (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolClientInformationSheetComaker"
                    name="houcolClientInformationSheetComaker"
                value="${loanApplicationChecklist?.houcolClientInformationSheetComaker}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolClientInformationSheetComaker">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolClientInformationSheetComaker">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 20. Client Information Sheet - Co-Maker (CIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolComakerStatement"
                    name="houcolComakerStatement"
                value="${loanApplicationChecklist?.houcolComakerStatement}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolComakerStatement">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolComakerStatement">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 21. Co-maker Statement</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcol2pcs2x2IdPicture"
                    name="houcol2pcs2x2IdPicture"
                value="${loanApplicationChecklist?.houcol2pcs2x2IdPicture}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcol2pcs2x2IdPicture">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcol2pcs2x2IdPicture">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 22. 2 pcs. 2x2 ID Picture</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                    name="houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach"
                value="${loanApplicationChecklist?.houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcol3CopiesOf2ValidIdsWith3OriginalSpecimenSignatureEach">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 23. 3 Copies of 2 Valid ID's with 3 Original Specimen
            Signature each</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolProofOfBillingBrgyClearance"
                    name="houcolProofOfBillingBrgyClearance"
                value="${loanApplicationChecklist?.houcolProofOfBillingBrgyClearance}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolProofOfBillingBrgyClearance">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolProofOfBillingBrgyClearance">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 24. Proof Of Billing / Brgy. Clearance</td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolDTIRegistration"
                    name="houcolDTIRegistration"
                value="${loanApplicationChecklist?.houcolDTIRegistration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolDTIRegistration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolDTIRegistration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 25. DTI Registration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolIncomeTaxReturnOrBIR"
                    name="houcolIncomeTaxReturnOrBIR"
                value="${loanApplicationChecklist?.houcolIncomeTaxReturnOrBIR}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolIncomeTaxReturnOrBIR">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolIncomeTaxReturnOrBIR">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 26. Income Tax Return (ITR) or BIR 2316</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolProofOfOtherSourceOfIncome"
                    name="houcolProofOfOtherSourceOfIncome"
                value="${loanApplicationChecklist?.houcolProofOfOtherSourceOfIncome}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolProofOfOtherSourceOfIncome">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolProofOfOtherSourceOfIncome">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 27. Proof of Other Source of Income</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolPictureOfCollateral"
                    name="houcolPictureOfCollateral"
                value="${loanApplicationChecklist?.houcolPictureOfCollateral}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolPictureOfCollateral">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolPictureOfCollateral">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 28. Picture of Collateral</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolREMContract"
                    name="houcolREMContract"
                value="${loanApplicationChecklist?.houcolREMContract}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolREMContract">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolREMContract">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 29. REM Contract</td>
    </tr>

    <tr>
        <td>
            <div>
                <g:checkBox id="houcolLandTitle"
                    name="houcolLandTitle"
                value="${loanApplicationChecklist?.houcolLandTitle}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolLandTitle">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolLandTitle">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 30. Land Title</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolTaxDeclaration"
                    name="houcolTaxDeclaration"
                value="${loanApplicationChecklist?.houcolTaxDeclaration}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolTaxDeclaration">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolTaxDeclaration">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 31. Tax Declaration</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolRealEstateTaxReceipt"
                    name="houcolRealEstateTaxReceipt"
                value="${loanApplicationChecklist?.houcolRealEstateTaxReceipt}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolRealEstateTaxReceipt">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolRealEstateTaxReceipt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 32. Real Estate Tax Receipt (BUWIS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolAbsoluteOfDeedOfSale"
                    name="houcolAbsoluteOfDeedOfSale"
                value="${loanApplicationChecklist?.houcolAbsoluteOfDeedOfSale}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolAbsoluteOfDeedOfSale">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolAbsoluteOfDeedOfSale">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 33. Absolute of Deed of Sale (ADS)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolBlueprints"
                    name="houcolBlueprints"
                value="${loanApplicationChecklist?.houcolBlueprints}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolBlueprints">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolBlueprints">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 34. Blueprints</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolSpecialPowerOfAtty"
                    name="houcolSpecialPowerOfAtty"
                value="${loanApplicationChecklist?.houcolSpecialPowerOfAtty}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolSpecialPowerOfAtty">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}" field="houcolSpecialPowerOfAtty">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 35. Special Power of Atty. (SPA)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox
                    id="houcolCertificationOfNonDelinquency"
                    name="houcolCertificationOfNonDelinquency"
                value="${loanApplicationChecklist?.houcolCertificationOfNonDelinquency}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCertificationOfNonDelinquency">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCertificationOfNonDelinquency">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 36. Certification of Non Delinquency</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolCertificationFromCENRO"
                    name="houcolCertificationFromCENRO"
                value="${loanApplicationChecklist?.houcolCertificationFromCENRO}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolCertificationFromCENRO">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolCertificationFromCENRO">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 37. Certification from CENRO (for Tax Dec.)</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolAffidavitOfNonTenancy"
                    name="houcolAffidavitOfNonTenancy"
                value="${loanApplicationChecklist?.houcolAffidavitOfNonTenancy}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolAffidavitOfNonTenancy">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolAffidavitOfNonTenancy">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 38. Affidavit of Non Tenancy</td>
    </tr>
    <tr>
        <td>
            <div>
                <g:checkBox id="houcolFireInsurancePolicyDated"
                    name="houcolFireInsurancePolicyDated"
                value="${loanApplicationChecklist?.houcolFireInsurancePolicyDated}"/>
                <g:hasErrors bean="${loanApplicationChecklist}"
                    field="houcolFireInsurancePolicyDated">
                    <div >
                        <span >
                            <g:eachError
                            bean="${loanApplicationChecklist}"
                                field="houcolFireInsurancePolicyDated">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </td>
        <td> 39. Fire Insurance Policy Dated</td>
    </tr>
</table>
</div>
