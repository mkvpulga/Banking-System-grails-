<%@ page import="icbs.loans.LoanLedger" %>
<legend>Missed Installments</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>No.</label></td>
                <td><label>Installment Date</label></td>
                <td><label>Principal Installment Amount</label></td>
                <td><label>Principal Installment Paid</label></td>
                <td><label>Principal Balance Due</label></td>
                <td><label>Interest Installment Amount</label></td>
                <td><label>Interest Installment Paid</label></td>
                <td><label>Interest Balance Due</label></td>
                <!-- <td><label>Penalty</label></td> -->
                <td><label>Service Charge</label></td>
            </tr>
        </tbody>
        <tbody>
            <g:each var="installment" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sort{it.sequenceNo}}">
                <tr>
                    <td>${installment?.sequenceNo}</td>
                    <td><g:formatDate format="MM-dd-yyyy" date="${installment?.installmentDate}"/></td>
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.principalInstallmentAmount}" /></td>
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.principalInstallmentPaid}" /></td>
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.principalInstallmentAmount - installment?.principalInstallmentPaid}" /></td>			
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.interestInstallmentAmount}" /></td>
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.interestInstallmentPaid}" /></td>
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.interestInstallmentAmount - installment?.interestInstallmentPaid}" /></td>
                    <!-- <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.penaltyInstallmentAmount - installment?.penaltyInstallmentPaid}" /></td> -->
                    <td align="right"><g:formatNumber format="###,##0.00" number="${installment?.serviceChargeInstallmentAmount - installment?.serviceChargeInstallmentPaid}" /></td>								
                </tr>
            </g:each>
            <tr>
                <g:each var="totalpri" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentAmount}}">
                    <g:each var="totalpripd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentPaid}}">
                        <g:each var="totalint" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}}"> 
                            <g:each var="totalintpd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}}">
                                <g:each var="totalpen" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentAmount}}">
                                    <g:each var="totalpenpd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentPaid}}">
                                        <g:each var="totalser" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentAmount}}">
                                            <g:each var="totalserpd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentPaid}}">
                                                <td></td>
                                                <td></td>
                                                <td align="right"><label id="totpriins"><g:formatNumber format="###,##0.00" number="${totalpri}" /></label></td>
                                                <td align="right"><label id="totpripad"><g:formatNumber format="###,##0.00" number="${totalpripd}" /></label></td>
                                                <td align="right"><span style="color: red;"><label id="totPrincipalBal"><g:formatNumber format="###,##0.00" number="${totalpri - totalpripd}" /></span></label></td>
                                                <td align="right"><label id="totInterestins"><g:formatNumber format="###,##0.00" number="${totalint}" /></label></td>
                                                <td align="right"><label id="totInterestpad"><g:formatNumber format="###,##0.00" number="${totalintpd}" /></label></td>
                                                <td align="right"><span style="color: red;"><label id="totInterestBal"><g:formatNumber format="###,##0.00" number="${totalint - totalintpd}" /></span></label></td>
                                                <!-- <td align="right"><label id ="totPenaltyBal"><g:formatNumber format="###,##0.00" number="${totalpen - totalpenpd}" /></label></td> -->
                                                <td align="right"><span style="color: red;"><label id="totServiceChargeBal"><g:formatNumber format="###,##0.00" number="${totalser - totalserpd}" /></span></label></td>

                                            </tr>
                                            <tr>

                                                <td></td>
                                                <g:each var="totalp" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentAmount}}">
                                                    <g:each var="totalppd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentPaid}}">
                                                        <g:each var="totali" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}}"> 
                                                            <g:each var="totalipd" in="${loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}}">
                                                                <td align="center"><strong><span style="color: red;">TOTAL INSTALLMENT BALANCE </span></strong></td>
                                                                <td align="right"><span style="color: red;"><label id="installmentTotal"><g:formatNumber format="###,##0.00" number="${totalp + totali - totalppd - totalipd}" /></span></label></td>
                                                            </g:each>
                                                        </g:each>
                                                    </g:each>
                                                </g:each>   
                                            </tr>    

                                        </g:each>
                                    </g:each>
                                </g:each>
                            </g:each>
                        </g:each>   
                    </g:each>
                </g:each>
            </g:each>
        </tbody>
    </table>
</div>
<g:javascript>
    calculateTotalInstallmentBalanceAmount();
    function calculateTotalInstallmentBalanceAmount(){

    var totalPrinBal = document.getElementById('totPrincipalBal').innerHTML;
    var totalIntBal = document.getElementById('totInterestBal').innerHTML;
    //var totalPenBal = document.getElementById('totPenaltyBal').innerHTML;
    var totalChargeBal = document.getElementById('totServiceChargeBal').innerHTML;
    var totalPenBal = "0";
    totalPrinBal = totalPrinBal.replace(",","");
    totalIntBal = totalIntBal.replace(",","");
    totalPenBal = totalPenBal.replace(",","");
    totalChargeBal = totalChargeBal.replace(",","");

    var InstallmentTotalBalanceAmount = parseFloat(totalPrinBal) + parseFloat(totalIntBal) + parseFloat(totalPenBal) + parseFloat(totalChargeBal);

    InstallmentTotalBalanceAmount = InstallmentTotalBalanceAmount.toString();
    var x = InstallmentTotalBalanceAmount.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
    x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    document.getElementById('zxc111').innerHTML= x1 + x2;
    }

</g:javascript>   

<legend>Loan Outstanding Balance</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <thead>
            <tr>

                <td><label>Principal</label></td>
                <td><label>Outstanding Interest</label></td>
                
                <td><label>Past Due Interest</label></td>
                <td><label>Penalty</label></td>
                <td><label>Service Charge</label></td>
                <td><label>TOTAL</label></td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td align="right"><label><g:formatNumber format="###,##0.00" number="${loanInstance?.balanceAmount}"/></label></td>
                   <g:if test="${outstandingInterest}">
                    <td align="right"><label><g:formatNumber format="###,##0.00" number="${outstandingInterest}" /></label></td>
                        </g:if>
                                        <g:else>
                                    <td align="right"><label>0.00</label></td>

                                        </g:else>
                                        
                                        <g:if test="${totalPDue >= 0}">
                                    <td align="right"><label><g:formatNumber format="###,##0.00" number="${totalPDue}"/></label></td>
                                        </g:if>
                                        <g:else>
                                    <td align="right"><label>0.00</label></td>

                                </g:else>


                <td align="right"><label><g:formatNumber format="###,##0.00" number="${loanInstance?.penaltyBalanceAmount}"/></label></td>				
                <td align="right"><label><g:formatNumber format="###,##0.00" number="${loanInstance?.serviceChargeBalanceAmount}"/></label></td>
                <td align="right"><label><g:formatNumber format="###,##0.00" number="${doubleOutstandingInterest + loanInstance?.balanceAmount}"/></label></td>    

            </tr>
        </tbody>

    </table>
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>Principal Amount Due</label></td>


                <td align="right"><g:formatNumber format="###,##0.00" number="${loanInstance?.overduePrincipalBalance}" /></td>

            </tr>
            <tr>

                <td><span style="color: blue;"><label>Total Amount Due</label></span></td>


                <td align="right"><label><span style="color: blue;"><g:formatNumber format="###,##0.00" number="${loanInstance?.overduePrincipalBalance + loanInstance?.interestBalanceAmount + loanInstance?.penaltyBalanceAmount + loanInstance?.serviceChargeBalanceAmount}" /></span></label></td>

            </tr> 
            <tr>

                <%--<td><label>Accrued Interest Balance to Date</label></td> --%>
                  <td><label>Advance Interest</label></td>
                   <%-- <g:if test="${loanInstance?.numInstallments == 1}">
                        <g:formatNumber format="###,##0.00" number="${loanInstance?.interestBalanceAmount}" />

                    </g:if>
                    <g:else>
                        <g:formatNumber format="###,##0.00" number="${intToDate}" />
                    </g:else> --%>
                <g:if test="${totalPDue < 0}">
                                    <td align="right"><label><g:formatNumber format="###,##0.00" number="${totalPDue}"/></label></td>
                                        </g:if>
                                       <g:else>
                                    <td align="right"><label>0.00</label></td>

                                </g:else>
                                 
            </tr>        
        </tbody>    
    </table>   
</div>
