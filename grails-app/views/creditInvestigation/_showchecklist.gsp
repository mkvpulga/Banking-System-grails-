<%@ page import="icbs.loans.CreditInvestigation" %>


<legend>Checklist </legend>

<div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'remarks', 'has-error')} ">
    <label class="control-label col-sm-4" for="remarksChecklist">
        <g:message code="creditInvestigation.remarks.label" default="Remarks" />

    </label>
    <div class="col-sm-8">
        <g:textArea id="remarksChecklist" name="remarksChecklist" cols="40" rows="5" value="${creditInvestigationInstance?.remarks}" class="form-control" readonly="true" />
        <g:hasErrors bean="${creditInvestigationInstance}" field="remarks">

        </g:hasErrors>
    </div>             
</div>
<br>
<br>
<br>
<br>
<br>
<g:if test="${creditInvestigationInstance.checklisttype.id == 1}">
    
   
    <div id="regularChecklist">
        <table border=0 class="table table-hover table-condensed table-bordered table-striped">
            <tr style="font-weight: bold;">
                <td colspan=2>
                    <label ><h4>REGULAR LOAN CHECKLIST</h4></label>
                </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>A. PRE - APPROVAL</h4></label>
                </td>
            </tr>
            <tr>
                <td >
                    <div>
                        <g:checkBox disabled="${disabled}" id="rgLoanApp" name="rgLoanApp" value="${creditInvestigationInstance?.rgLoanApp}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgLoanApp">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgLoanApp">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td>1. Loan Application Form </td>
            </tr>		

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgBrr" name="rgBrr" value="${creditInvestigationInstance?.rgBrr}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBrr">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgBrr">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td> 
                <td> 2. Cash Flow Analysis Report / Borrower Risk Rating (BRR) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgItrBir" name="rgItrBir" value="${creditInvestigationInstance?.rgItrBir}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgItrBir">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgItrBir">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. ITR / BIR No. 2316 </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgFs" name="rgFs" value="${creditInvestigationInstance?.rgFs}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgFs">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgFs">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Financial Statements (For the past 3 years) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgBusinessPermit" name="rgBusinessPermit" value="${creditInvestigationInstance?.rgBusinessPermit}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBusinessPermit">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgBusinessPermit">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. Business Permit & Other Licenses </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgPicOfBusiness" name="rgPicOfBusiness" value="${creditInvestigationInstance?.rgPicOfBusiness}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgPicOfBusiness">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgPicOfBusiness">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 6. Picture of Business </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgSalesAndPurchaseJournal" name="rgSalesAndPurchaseJournal" value="${creditInvestigationInstance?.rgSalesAndPurchaseJournal}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgSalesAndPurchaseJournal">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgSalesAndPurchaseJournal">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 7. Sales & Purchase Journal / Receipts / Record & Logbook </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgCertOfEmployment" name="rgCertOfEmployment" value="${creditInvestigationInstance?.rgCertOfEmployment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgCertOfEmployment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgCertOfEmployment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 8. Contract / Certificate Of Employment </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgPayslip" name="rgPayslip" value="${creditInvestigationInstance?.rgPayslip}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgPayslip">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgPayslip">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 9. Pay Slips (At Least 3 -6 Months) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgProofOfRemittance" name="rgProofOfRemittance" value="${creditInvestigationInstance?.rgProofOfRemittance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgProofOfRemittance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgProofOfRemittance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 10. Proof of Remittance </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgBankStatement" name="rgBankStatement" value="${creditInvestigationInstance?.rgBankStatement}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBankStatement">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgBankStatement">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 11. Bank Statement </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgSecRegistration" name="rgSecRegistration" value="${creditInvestigationInstance?.rgSecRegistration}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgSecRegistration">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgSecRegistration">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 12. For Corporation(s):SEC Registration; Articles of Incorporation / By-Laws; Board Resolution & Secretary's Certificate </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgCiTools" name="rgCiTools" value="${creditInvestigationInstance?.rgCiTools}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgCiTools">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgCiTools">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 13. CI Tools (Borrower Profile, Bank Verification; Trade & Credit Checking; ADB of CA/SA; Rental Verification) </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgValidId" name="rgValidId" value="${creditInvestigationInstance?.rgValidId}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgValidId">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgValidId">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 14. Valid Identification & Passport Size Photo(s) </td>
            </tr>  
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgBrgyClearance" name="rgBrgyClearance" value="${creditInvestigationInstance?.rgBrgyClearance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBrgyClearance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgBrgyClearance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 15. Barangay / Police Clearance </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgBirthCert" name="rgBirthCert" value="${creditInvestigationInstance?.rgBirthCert}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBirthCert">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgBirthCert">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 16. Marriage Contract / Birth Certificate (If applicable)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgProofOfBilling" name="rgProofOfBilling" value="${creditInvestigationInstance?.rgProofOfBilling}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgProofOfBilling">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgProofOfBilling">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 17. Proof of Billing</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgNfisReport" name="rgNfisReport" value="${creditInvestigationInstance?.rgNfisReport}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgNfisReport">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgNfisReport">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 18. NFIS / CMAP Report</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgAppraisalReport" name="rgAppraisalReport" value="${creditInvestigationInstance?.rgAppraisalReport}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgAppraisalReport">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgAppraisalReport">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 18. Appraisal & Supplemental Report; Plotting</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgApprovedPlan" name="rgApprovedPlan" value="${creditInvestigationInstance?.rgApprovedPlan}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgApprovedPlan">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgApprovedPlan">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 19. Approved Plan / Sketch Map of Property & / or Residence</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgTrueCopyOfTitle" name="rgTrueCopyOfTitle" value="${creditInvestigationInstance?.rgTrueCopyOfTitle}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgTrueCopyOfTitle">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgTrueCopyOfTitle">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 20. Certified True Copy of Title</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgOthers" name="rgOthers" value="${creditInvestigationInstance?.rgOthers}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgOthers">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgOthers">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 21. Others (specify)</td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>B. REGISTRATION</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgCctNo" name="rgCctNo" value="${creditInvestigationInstance?.rgCctNo}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgOrgCctNothers">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgCctNo">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Original Transfer Certificate of Title / CCT No. </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgRealEstateTaxReceipt" name="rgRealEstateTaxReceipt" value="${creditInvestigationInstance?.rgRealEstateTaxReceipt}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgRealEstateTaxReceipt">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgRealEstateTaxReceipt">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Real Estate Tax Receipt No(s). </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgRemContract" name="rgRemContract" value="${creditInvestigationInstance?.rgRemContract}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgRemContract">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgRemContract">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. REM Contract </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgSpa" name="rgSpa" value="${creditInvestigationInstance?.rgSpa}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgSpa">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgSpa">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. SPA / Revocation of SPA (If Applicable) </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgReleaseOfMortgage" name="rgReleaseOfMortgage" value="${creditInvestigationInstance?.rgReleaseOfMortgage}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgReleaseOfMortgage">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgReleaseOfMortgage">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. Release of Mortgage (if applicable) </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgPetitionToCancel" name="rgPetitionToCancel" value="${creditInvestigationInstance?.rgPetitionToCancel}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgPetitionToCancel">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgPetitionToCancel">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 6. Petition to Cancel Two (2) Years Lien (If Applicable) </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgRegOthers" name="rgRegOthers" value="${creditInvestigationInstance?.rgRegOthers}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgRegOthers">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgRegOthers">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 7. Others (Specify) </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>C. RELEASE OF LOAN</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgDsOrPn" name="rgDsOrPn" value="${creditInvestigationInstance?.rgDsOrPn}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgDsOrPn">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgDsOrPn">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Disclosure Statement / Promissory Note No. </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgAuthorization" name="rgAuthorization" value="${creditInvestigationInstance?.rgAuthorization}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgAuthorization">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgAuthorization">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Authorization / Waiver</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgMriLifeInsurance" name="rgMriLifeInsurance" value="${creditInvestigationInstance?.rgMriLifeInsurance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgMriLifeInsurance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgMriLifeInsurance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. MRI/ Life Insurance Forms:</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgFireInsurance" name="rgFireInsurance" value="${creditInvestigationInstance?.rgFireInsurance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgFireInsurance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgFireInsurance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Fire Insurance Cover Note: </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgEirComputation" name="rgEirComputation" value="${creditInvestigationInstance?.rgEirComputation}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgEirComputation">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgEirComputation">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. Effective Interest Rate (EIR) Computation </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgScheduleOfPayment" name="rgScheduleOfPayment" value="${creditInvestigationInstance?.rgScheduleOfPayment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgScheduleOfPayment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgScheduleOfPayment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 6. Schedule Of Payment & Amortization Schedule </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgModeOfPayment" name="rgModeOfPayment" value="${creditInvestigationInstance?.rgModeOfPayment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgModeOfPayment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgModeOfPayment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 7. Mode of Payment </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="rgRelOthers" name="rgRelOthers" value="${creditInvestigationInstance?.rgRelOthers}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgRelOthers">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="rgRelOthers">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 8. Others (Specify) </td>
            </tr>
        </table>
    </div>    
</g:if>    
<g:if test="${creditInvestigationInstance.checklisttype.id == 2}">
<!-- ======================== FOR SALARY LOAN CHECKLIST ============================ -->
    <div id="salaryLoanChecklist">
        <table border=0 class="table table-hover table-condensed table-bordered table-striped">
            <tr style="font-weight: bold;">
                <td colspan=2>
                    <label ><h4>SALARY LOAN CHECKLIST</h4></label>
                </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>A. DOCUMENTS SUBMITTED</h4></label>
                </td>
            </tr>
            <tr>
                <td >
                    <div>
                        <g:checkBox disabled="${disabled}" id="slLoanApp" name="slLoanApp" value="${creditInvestigationInstance?.slLoanApp}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slLoanApp">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slLoanApp">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td>1. Loan Application</td>
            </tr>		

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slMaxLoanAmountComputation" name="slMaxLoanAmountComputation" value="${creditInvestigationInstance?.slMaxLoanAmountComputation}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="rgBrr">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slMaxLoanAmountComputation">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td> 
                <td> 2. Maximum Loan Amount Computation (Accounting Department) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCertFromHrDept" name="slCertFromHrDept" value="${creditInvestigationInstance?.slCertFromHrDept}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCertFromHrDept">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCertFromHrDept">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Certification From HR Department For Years Of Service To The Bank </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slDeedOfAssignment" name="slDeedOfAssignment" value="${creditInvestigationInstance?.slDeedOfAssignment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slDeedOfAssignment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slDeedOfAssignment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Deed Of Assignment For Retirement Benefits </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>B. EMERGENCY LOAN</h4></label>
                </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slHospitalBill" name="slHospitalBill" value="${creditInvestigationInstance?.slHospitalBill}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slHospitalBill">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slHospitalBill">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Hospital Bills </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>C. HOUSING LOAN</h4></label>
                </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slTctNo" name="slTctNo" value="${creditInvestigationInstance?.slTctNo}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slTctNo">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slTctNo">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. TCT No. </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slTaxDeclaration" name="slTaxDeclaration" value="${creditInvestigationInstance?.slTaxDeclaration}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slTaxDeclaration">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slTaxDeclaration">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Tax Declaration No. </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slRealEstateTax" name="slRealEstateTax" value="${creditInvestigationInstance?.slRealEstateTax}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slRealEstateTax">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slRealEstateTax">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Real Estate Tax </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCertOfNonTaxDeliquency" name="slCertOfNonTaxDeliquency" value="${creditInvestigationInstance?.slCertOfNonTaxDeliquency}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCertOfNonTaxDeliquency">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCertOfNonTaxDeliquency">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Certificate of Non Tax Delinquency </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slSpa" name="slSpa" value="${creditInvestigationInstance?.slSpa}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slSpa">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slSpa">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. SPA </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>D. MOTORCYCLE PLAN</h4></label>
                </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="slApprovedRequisitionSlip" name="slApprovedRequisitionSlip" value="${creditInvestigationInstance?.slApprovedRequisitionSlip}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slApprovedRequisitionSlip">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slApprovedRequisitionSlip">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Approved Requisition Slip </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slPn" name="slPn" value="${creditInvestigationInstance?.slPn}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slPn">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slPn">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Promissory Note </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slDs" name="slDs" value="${creditInvestigationInstance?.slDs}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slDs">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slDs">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Discount Statement</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slTruthLendingStatement" name="slTruthLendingStatement" value="${creditInvestigationInstance?.slTruthLendingStatement}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slTruthLendingStatement">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slTruthLendingStatement">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Truth & Lending Statement </td>
            </tr>  
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slRem" name="slRem" value="${creditInvestigationInstance?.slRem}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slRem">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slRem">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. REM Contract (For Housing Loan Only) </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>E. CO-MAKER STATEMENT (IF CO-EMPLOYEE)</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCmMaxLoanAmountComputation" name="slCmMaxLoanAmountComputation" value="${creditInvestigationInstance?.slCmMaxLoanAmountComputation}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCmMaxLoanAmountComputation">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCmMaxLoanAmountComputation">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Maximum Loan Amount Computation (Accounting Department)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCmCertFromHrDept" name="slCmCertFromHrDept" value="${creditInvestigationInstance?.slCmCertFromHrDept}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCmCertFromHrDept">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCmCertFromHrDept">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Certification From HR Department For Years Of Service To The Bank</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCmDeedOfAssignment" name="slCmDeedOfAssignment" value="${creditInvestigationInstance?.slCmDeedOfAssignment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCmDeedOfAssignment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCmDeedOfAssignment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Deed of Assignment For Retirement Benefits</td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>E. CO-MAKER STATEMENT (IF OUTSIDER)</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCmValidId" name="slCmValidId" value="${creditInvestigationInstance?.slCmValidId}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCmValidId">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCmValidId">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Valid ID</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="slCmLatestPaySlip" name="slCmLatestPaySlip" value="${creditInvestigationInstance?.slCmLatestPaySlip}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="slCmLatestPaySlip">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="slCmLatestPaySlip">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Latest Pay Slip / ITR / Business / Barangay Permit</td>
            </tr>

        </table>
    </div>    
</g:if>    
<!-- ========================= FOR MICROFINANCE LOAN CHECKLIST ======================================= -->
<g:if test="${creditInvestigationInstance.checklisttype.id == 3}">
    <div id="microfinanceChecklist">
        <table border=0 class="table table-hover table-condensed table-bordered table-striped">
            <tr style="font-weight: bold;">
                <td colspan=2>
                    <label ><h4>MICROFINANCE (MABS) CHECKLIST</h4></label>
                </td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>A. PRE-APPROVAL DOCUMENTS</h4></label>
                </td>
            </tr>
            <tr>
                <td >
                    <div>
                        <g:checkBox disabled="${disabled}" id="mfChecklist" name="mfChecklist" value="${creditInvestigationInstance?.mfChecklist}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfChecklist">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfChecklist">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td>1. Checklist</td>
            </tr>		

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfAppWithIdPic" name="mfAppWithIdPic" value="${creditInvestigationInstance?.mfAppWithIdPic}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfAppWithIdPic">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfAppWithIdPic">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td> 
                <td> 2. Application with ID Picture, Sketch Map and Loan Approval </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfValidId" name="mfValidId" value="${creditInvestigationInstance?.mfValidId}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfValidId">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfValidId">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Valid Id / Marriage Contract / Birth Certificate (Optional) (Photocopy) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfProofOfIncome" name="mfProofOfIncome" value="${creditInvestigationInstance?.mfProofOfIncome}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfProofOfIncome">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfProofOfIncome">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Proof of income / Remittances (If Any) (Photocopy) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfPaidUtilityBills" name="mfPaidUtilityBills" value="${creditInvestigationInstance?.mfPaidUtilityBills}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfPaidUtilityBills">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfPaidUtilityBills">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. Photocopy of Paid Utility Bills </td>
            </tr>


            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfBrgyClearance" name="mfBrgyClearance" value="${creditInvestigationInstance?.mfBrgyClearance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfBrgyClearance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfBrgyClearance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 6. Barangay Clearance (For Loan Purpose) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfBusinessClearance" name="mfBusinessClearance" value="${creditInvestigationInstance?.mfBusinessClearance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfBusinessClearance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfBusinessClearance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 7. Barangay Business Clearance / Mayor / DTI Permit (optional) (Photocopy) </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfCiForm" name="mfCiForm" value="${creditInvestigationInstance?.mfCiForm}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfCiForm">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfCiForm">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 8. Credit Investigation Form </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfCashFlowAnalysis" name="mfCashFlowAnalysis" value="${creditInvestigationInstance?.mfCashFlowAnalysis}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfCashFlowAnalysis">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfCashFlowAnalysis">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 9. Cash Flow Analysis </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfCallReport" name="mfCallReport" value="${creditInvestigationInstance?.mfCallReport}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfCallReport">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfCallReport">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 10. Call Report (For Loans 50,000 PHP above) </td>
            </tr>


            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfConfimationSavingsBalance" name="mfConfimationSavingsBalance" value="${creditInvestigationInstance?.mfConfimationSavingsBalance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfConfimationSavingsBalance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfConfimationSavingsBalance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 11. Confirmation of Savings Balance </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfBankStatement" name="mfBankStatement" value="${creditInvestigationInstance?.mfBankStatement}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfBankStatement">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfBankStatement">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 12. Bank Statement </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfClientStatusReport" name="mfClientStatusReport" value="${creditInvestigationInstance?.mfClientStatusReport}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfClientStatusReport">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfClientStatusReport">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 13. Client Status Report</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfComakerStatement" name="mfComakerStatement" value="${creditInvestigationInstance?.mfComakerStatement}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfComakerStatement">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfComakerStatement">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 14. Co-Maker's Statement With ID Picture & Sketch Map </td>
            </tr>  
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfComakerValidId" name="mfComakerValidId" value="${creditInvestigationInstance?.mfComakerValidId}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfComakerValidId">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfComakerValidId">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 15. Co-Maker's Valid ID or Barangay Clearance </td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfComakerIdPicture" name="mfComakerIdPicture" value="${creditInvestigationInstance?.mfComakerIdPicture}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfComakerIdPicture">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfComakerIdPicture">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 16. Co Borrower's ID Picture and Valid ID or Barangay Clearance</td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>B. SECURITY DOCUMENTS</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfCvs" name="mfCvs" value="${creditInvestigationInstance?.mfCvs}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfCvs">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfCvs">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Affidavit of Voluntary Surrender (AVS)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfChattelMortgageContract" name="mfChattelMortgageContract" value="${creditInvestigationInstance?.mfChattelMortgageContract}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfChattelMortgageContract">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfChattelMortgageContract">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Chattel Mortgage Contract</td>
            </tr>

            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfAcknowlegementOfReceipt" name="mfAcknowlegementOfReceipt" value="${creditInvestigationInstance?.mfAcknowlegementOfReceipt}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfAcknowlegementOfReceipt">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfAcknowlegementOfReceipt">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Photocopy of Acknowledgement Of Receipt or OR / CR</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfCertOfOwnership" name="mfCertOfOwnership" value="${creditInvestigationInstance?.mfCertOfOwnership}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfCertOfOwnership">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfCertOfOwnership">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Photocopy of Certificate of Ownership (If Any) Vehicle CR / OR-Current Year</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfPicOfCollateral" name="mfPicOfCollateral" value="${creditInvestigationInstance?.mfPicOfCollateral}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfPicOfCollateral">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfPicOfCollateral">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 5. Picture  of Collateral (Vehicle and Plate Number)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfDeedOfAssignment" name="mfDeedOfAssignment" value="${creditInvestigationInstance?.mfDeedOfAssignment}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfDeedOfAssignment">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfDeedOfAssignment">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 6. Deed of Assignment (For Savings Hold Out)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfInspectionSlip" name="mfInspectionSlip" value="${creditInvestigationInstance?.mfInspectionSlip}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfInspectionSlip">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfInspectionSlip">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 7. Inspection Slip</td>
            </tr>
            <tr style="font-weight: bold;">
                <td></td>
                <td>
                    <label ><h4>C. POST - APPROVAL DOCUMENTS</h4></label>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfAda" name="mfAda" value="${creditInvestigationInstance?.mfAda}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfAda">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfAda">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 1. Automatic Debit Arrangement (ADA)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfPioneerInsurance" name="mfPioneerInsurance" value="${creditInvestigationInstance?.mfPioneerInsurance}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfPioneerInsurance">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfPioneerInsurance">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 2. Pioneer Insurance</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfDs" name="mfDs" value="${creditInvestigationInstance?.mfDs}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfDs">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfDs">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 3. Disclosure Statement (DS)</td>
            </tr>
            <tr>
                <td>
                    <div>
                        <g:checkBox id="mfPn" name="mfPn" value="${creditInvestigationInstance?.mfPn}"/>
                        <g:hasErrors bean="${creditInvestigationInstance}" field="mfPn">
                            <div >
                                <span >
                                    <g:eachError bean="${creditInvestigationInstance}" field="mfPn">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>       
                                </span>
                            </div>	
                        </g:hasErrors>
                    </div>
                </td>
                <td> 4. Promissory Note (PN)</td>
            </tr>

        </table>    
    </div>
</g:if>

