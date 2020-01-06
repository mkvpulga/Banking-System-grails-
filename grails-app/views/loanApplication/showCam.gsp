
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.loans.GroupRecord" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'loanApplication.label', default: 'LoanApplication')}" />
        <title>Loan Application - Credit Approval Memorandum</title>
        <g:javascript>

            function updateCustomerInfoAjax(params) {
            $.ajax({
            type: 'POST',
            data: {id:params.customer2},
            url: "${createLink(controller :'customer', action:'showBasicCustomerInfoAjax')}",
            success: function(msg){						
            $('#customer-name').val($(msg).find('#display-name').html());
            $('#customer').val(params.customer2);
            $('#birth-date').html($(msg).find('#birth-date').html())
            $('#address').html($(msg).find('#address').html())
            $('#photo').html($(msg).find('#photo').html())
            $('#total-released').html($(msg).find('#total-released').html())
            $('#total-balance').html($(msg).find('#total-balance').html())
            $('#total-count').html($(msg).find('#total-count').html())
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            //Override transfer status
            function updateStatusAjax(){
            checkIfAllowed('LON01700', status); // params: policyTemplate.code, form to be saved
            }

            function updateAmount() 
            {
            var Amt = accounting.unformat($('#value').val());
            if (isNaN(Amt))
            Amt = 0;
            $('#value').val(Amt);
            }

            //update status
            function status() {
            $.ajax({
            type: 'POST',
            data: $('#update-status-form').serialize(),
            url: "${createLink(controller :'loanApplication', action:'updateStatusAjax')}",
            success: function(msg){
            jQuery('#update-status-modal .modal-body').html(msg);
            $('#update-status-modal').on('hidden.bs.modal', function() {
            location.reload(true);
            });
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }

            function showUpdateStatus() {
            modal = new icbs.UI.Modal({id:"update-status-modal", url:"${createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id])}", title:"Update Status"});		    	
            modal.show();
            }        

            icbs.Dependencies.Ajax.addLoadEvent(function(){
            updateCustomerInfoAjax({customer2:"${loanApplicationInstance?.customer?.id}"});
            });


        </g:javascript>
    </head>
    <body>
    <content tag="main-content">   
        <div id="show-loanApplication" class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <script>
                    $(function(){
                            var x = '${flash.message}';
                    notify.message(x);return;
                    });
                </script>
            </g:if>

            <div class="modal" id="update-status-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Update Status</h4>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updateStatusAjax()">Save</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="section-container">
                <legend class="section-header">Information</legend>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <tbody>
                            <tr>
                                <td style="font-weight:bold" width="30%">Name of Borrower</td>
                                <td width="70%"><g:link controller="customer" action="customerInquiry" id="${loanApplicationInstance?.customer?.id}">${loanApplicationInstance?.customer?.displayName}</g:link></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Home Address</td>
                                    <td width="70%"><span id="address"></span></td>
                                </tr>


                            <tr>
                                <td style="font-weight:bold" width="30%">Company</td>

                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="company"/></td>

                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Name of Spouse</td>

                                <td width="70%">${spouse?.firstName} ${spouse?.middleName} ${spouse?.lastName}</td>

                            </tr>


                            <g:if test="${comakers}">           
                                <g:if test="${addresses}">  
                                    <g:each var="comaker" in="${comakers}">
                                        <g:each var="address" in="${addresses}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Name of Comaker</td>

                                                <td width="70%">${comaker?.customer?.displayName}</td>


                                            </tr>
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Home Address</td>

                                                <td width="70%">${address.address1} ${address.address2} ${address.address3}</td>

                                            </tr>

                                        </g:each>
                                    </g:each>
                                </g:if>
                                <g:else>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Home Address</td>

                                        <td width="70%"></td>

                                    </tr>
                                </g:else>
                            </g:if>
                            <g:else>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Name of Comaker</td>

                                    <td width="70%"></td>


                                </tr>
                            </g:else>
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
                                <td style="font-weight:bold" width="30%">Loan Purpose</td>
                                <td width="70%">${loanApplicationInstance?.purpose}</td>
                            </tr>

                            <tr>
                                <td style="font-weight:bold" width="30%">Economic Activity</td>
                                <td width="70%"><g:fieldValue bean="${loanApplicationSpecAdd}" field="economicActivity"/></td>
                            </tr>

                            <tr>
                                <td style="font-weight:bold" width="30%">Amount of Loan</td>
                                <g:if test="${loanApplicationInstance?.amount}">      
                                    <td width="70%">Php <g:formatNumber number="${loanApplicationInstance?.amount}" format="###,##0.00" /></td>
                                </g:if>
                                <g:else>
                                    <td width="70%"></td>
                                </g:else>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Term/s</td>
                                <g:if test="${loanApplicationInstance?.term}">  
                                    <td width="70%">${loanApplicationInstance?.term / 30} months or ${loanApplicationInstance?.term / 360} years </td>                        
                                </g:if>
                                <g:else>
                                    <td width="70%"></td>
                                </g:else>
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

                            <g:if test="${loanApplicationInstance?.collaterals}">
                                <g:each var="collateral" in="${loanApplicationInstance?.collaterals.sort{it.id}}">
                                    <tr>

                                        <td style="font-weight:bold" width="30%">Collateral</td>
                                        <td width="70%">${collateral?.description}</td>
                                    </tr>
                                </g:each>
                            </g:if> 
                            <g:else>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Collateral</td>
                                    <td width="70%"></td>
                                </tr>
                            </g:else>

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
                                <td style="font-weight:bold" width="30%">Outstanding Principal</td>
                                <g:if test="${loanApplicationInstance?.amount}">  
                                    <td width="70%">Php <g:formatNumber number="${loanApplicationInstance?.amount}" format="###,##0.00" /></td>
                                </g:if>
                                <g:else>
                                    <td width="70%"></td>
                                </g:else>
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
                                <td style="font-weight:bold" width="30%">Approved Amount</td>
                                <g:if test="${loanApplicationInstance?.amount}"> 
                                    <td width="70%">Php <g:formatNumber number="${loanApplicationInstance?.amount}" format="###,##0.00" /></td>
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




                        </tbody>
                    </table>
                </div>
            </div>


    </content>
    <content tag="main-actions">
        <ul>
            <li><g:link class="btn btn-secondary" action="show" id="${loanApplicationInstance.id}">Back</g:link></li>
<!--                <li><g:link class="list" action="index">Search Loan Application</g:link></li>                
            <li><g:link action="edit" resource="${loanApplicationInstance}">Update Loan Application</g:link></li>
            <li><a href="#" onclick="genReportLNA001();">Print Loan Application Form</a></li>
            <li><a href="#" onclick="showUpdateStatus()">Update Status</a></li>
            <li><g:link controller="creditInvestigation" action="create" params="[id:loanApplicationInstance?.id]">Perform Credit Investigation</g:link></li>
            <g:if test="${isLoanApplicationExist == 'true'}">
                <li><a href="#" onclick="promptAlertify();" disabled="disabled">Create Loan Account</a></li>
                <script>
                            function promptAlertify(){
                                notify.message('This Loan Application is being used by other Loan Account!|info|alert'); 
                            }
                </script>    
            </g:if>   
            <g:else>
                <li><g:link controller="loan" action="create" disable="disabled" params="[id:loanApplicationInstance?.id]">Create Loan Account</g:link></li>
            </g:else>    
            <li><g:link action="showCam" resource="${loanApplicationInstance}">Credit Approval Memorandum</g:link></li>
            <li><a href="#" onclick="window.print()">Print Details</a></li>-->
        </ul>

<!--   <g:javascript>
function genReportLNA001(){
    reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(16).baseParams}&output=${icbs.admin.Report.get(16).outputParam}";
    reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(16).reportUnit}";             
    reportlink = reportlink + "&loan_application_id=${loanApplicationInstance?.id}";
    reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
    sendtojasperver(reportlink);
}           
</g:javascript>-->
    </content>
</body>
</html>
