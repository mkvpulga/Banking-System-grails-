<!-- loan additional spec -->

<legend>Other Information</legend>
<div class="section-container">
    <legend class="section-header">Details</legend>
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <tbody>
                <g:if test="${user?.id == 16 || user?.designation?.id == 30 || user?.designation?.id == 19}">
                    <g:if test="${loanApplicationSpecAdd}">
                        <tr>
                            <td style="font-weight:bold" width="30%">Cam Number</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="camNo"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Company</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="company"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Security</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="loanSecurity"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Classification</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="loanClassification"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Product</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="loanProduct"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Economic Activity</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="economicActivity"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Interest Rate Payment</td>
                            <g:if test="${loanApplicationSpecAdd?.interestRate}">  
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="interestRate"/>%</td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Repayment Type</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="repaymentType"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Manner Of Payment</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="mannerOfPayment"/></td>
                        </tr>

                        <tr>
                            <td style="font-weight:bold" width="30%">Amortization Penalty Rate (PA)</td>
                            <g:if test="${loanApplicationSpecAdd?.amortizationPenaltyRate}">  
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="amortizationPenaltyRate"/>%</td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>




                        <tr>
                            <td style="font-weight:bold" width="30%">Pre-termination Charge Rate</td>
                            <g:if test="${loanApplicationSpecAdd?.preTerminationChargeRate}">  
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="preTerminationChargeRate"/>%</td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>



                        <tr>
                            <td style="font-weight:bold" width="30%">Pastdue Interest Rate(PA)</td>
                            <g:if test="${loanApplicationSpecAdd?.pastdueInterestRate}">  
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="pastdueInterestRate"/>%</td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>



                        <tr>
                            <td style="font-weight:bold" width="30%">Pastdue Penalty Rate(PA)</td>
                            <g:if test="${loanApplicationSpecAdd?.pastduePenaltyRate}">  
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="pastduePenaltyRate"/>%</td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>



                        <tr>
                            <td style="font-weight:bold" width="30%">Condition 1</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition1"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="30%">Condition 2</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition2"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="30%">Condition 3</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition3"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="40%">Condition 4</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition4"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Condition 5</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition5"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="40%">Condition 6</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition6"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Condition 7</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="condition7"/></td>
                        </tr>

                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Application</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="loanApplicationType"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Status</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="loanStatus"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Total to Date</td>
                            <g:if test="${loanApplicationSpecAdd?.totalToDate}">  
                                <td width="70%">Php <g:formatNumber number="${loanApplicationSpecAdd?.totalToDate}" format="###,##0.00" /></td>
                            </g:if>
                            <g:else>
                                <td width="70%"></td>
                            </g:else>
                        </tr>

                        <tr>
                            <td style="font-weight:bold" width="50%">Recommendation Remark 1</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="recommendedRemarks1"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Recommendation Remark 2</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="recommendedRemarks2"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Account Officer</td>
                            <td width="70%">${loanApplicationInstance?.accountOfficer?.description}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Recommended Date</td>

                            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanApplicationSpecAdd?.recommendedDate}"/></td>
                        </tr>

                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Remarks</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeRemarks"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Signatory 1</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeSignatory1"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Signatory 2</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeSignatory2"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Signatory 3</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeSignatory3"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Member 1</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeMember1"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Member 2</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteeMember2"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee President</td>
                            <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="creditCommitteePresident"/></td>
                        </tr>


                        <tr>
                            <td style="font-weight:bold" width="50%">Credit Committee Date</td>
                            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanApplicationSpecAdd?.creditCommitteeDate}"/></td>
                        </tr>


                    </g:if>
                    <g:else>
                        <tr>
                            <td style="font-weight:bold" width="100%">Please Update Loan Application.</td>
                        </tr>
                    </g:else>
                </g:if>
                <g:else>
                    <tr>
                        <td style="font-weight:bold" width="100%">CAM is limited for some users only.</td>
                    </tr>
                </g:else>
            </tbody>
        </table>
    </div>
</div>
