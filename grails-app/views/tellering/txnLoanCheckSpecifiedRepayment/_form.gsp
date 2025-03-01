<%@ page import="icbs.tellering.TxnLoanPaymentDetails" import="icbs.tellering.TxnCOCI" %>
<%@ page import="icbs.loans.LoanInstallment" %>


<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(15),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>

<fieldset class="form-group">
    <div class="col-sm-10">
        <fieldset class="form-group">
            <g:if test="${!txnLoanCheckSpecifiedRepaymentInstance?.acct}">
                <input type="button" href="#" class="btn btn-primary" onclick="initializeLoanAcctSearchModal();modal.show()" value="Search Account"/>
            </g:if>
        </fieldset>
        <g:hiddenField id="loanId" name="loanId"/>
        <g:hiddenField id="_prin_" name="_prin_"/>
        <g:hiddenField id="_interest" name="_interest"/>
        <g:hiddenField id="_penalty" name="_penalty"/>
        <g:hiddenField id="_service" name="_service"/>
        <g:hiddenField id="_tax" name="_tax"/>
        <g:hiddenField id="totalBreakdown" name="totalBreakdown"/>
        <g:hiddenField id="test_Loan" name="test_Loan" value="0"/>
        <%--<g:render template='/tellering/details/loanDetails' model="[loanInstance:txnLoanCheckSpecifiedRepaymentInstance?.acct]"/>--%>
        
        <div class="section-container">
        <fieldset>
        <legend class="section-header">Account Information</legend>
        <div class="infowrap">
        <div class="col-xs-8 col-sm-6 col-md-6">
             <dl class="dl-horizontal">
                <dt>Account Number</dt>
                <dd id="accountNo"></dd>
            </dl>            
            <dl class="dl-horizontal">
                <dt>Account Name</dt>
                <dd id="customer"></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>Date Opened</dt>
                <dd id="openingDate"></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>Status</dt>
                <dd id="status"></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>Principal Balance</dt>
                <dd id="principal1"></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>Interest Balance</dt>
                <dd id="intrest1"></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>Penalty Balance</dt>
                <dd id="penalty1"></dd>
            </dl>            
            <dl class="dl-horizontal">
                <dt>Service Charge Balance</dt>
                <dd id="sc1"></dd>
            </dl>            
            <dl class="dl-horizontal">
                <dt>Tax Balance</dt>
                <dd id="tax1"></dd>
            </dl>          
            
        </div>
        </div>
        <div class="infowrap">
            <dl class="dl-horizontal">
                <dd id="photo"><g:if test="${(loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id}"> <img width="120px" style="float:right" height="120px"src="${createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id )}"/></g:if></dd>
            </dl>
        </div>
        </fieldset>
        </div>
    </div>
</fieldset>

<div class="fieldcontain form-group ${hasErrors(bean: txnLoanCheckSpecifiedRepaymentInstance, field: 'paymentAmt', 'has-error')} required">
    <label class="control-label">Payment Amount</label>
    <div class="col-sm-6">
        <g:textField type="number" name="paymentAmt" required="" value="${txnLoanCheckSpecifiedRepaymentInstance?.paymentAmt}"class="form-control truncated" onkeyup="updateVar()"/>
   </div>             
</div>

<div class="form-group form-buttons">
    <button id="add-button" type="button" onclick="showAddChecks()" class="btn btn-primary multi-field-btn-add"><span class="fa fa-plus"></span> Add Check</button>
</div>


<div class="table-responsive" id="check_table">
    <table class="table table-hover table-condensed table-bordered table-striped">
    <tbody>
        <tr>
            <td><label>Check Type</label></td>
            <td><label>Bank</label></td>
            <td><label>Account Number</label></td>
            <td><label>Check Date</label></td>
            <td><label>Check Number</label></td>
            <td><label>Clearing Date</label></td>
            <td><label>Check Amount</label></td>
            <td class="col-sm-2"><label>Actions</label></td>		
	</tr>
    </tbody>
    <tbody>
        <g:if test="${txnCOCIInstance?.checks}">
            <g:each var="check" in="${txnCOCIInstance?.checks.sort{it.description}}">
                <tr>
                    <td>${check?.checkType?.description}</td>
                    <td>${check?.bank?.name}</td>
                    <td>${check?.acctNo}</td>
                    <td>${check?.checkDate}</td>
                    <td>${check?.checkNo}</td>
                    <td>${check?.clearingDate}</td>
                    <td>${check?.checkAmt}</td>
                    <td>
                        <a href="#" class="btn btn-secondary" onclick="deleteCheckAjax('${check?.id}')">Remove</a>
                    </td>		
                </tr>
            </g:each>
        </g:if>
        <g:elseif test="${session["checks"]}">
            <g:set var="i" value="${0}" />
            <g:each var="check" in="${session["checks"]}">
                <tr>
                    <td>${check?.checkType?.description}</td>
                    <td>${check?.bank?.name}</td>
                    <td>${check?.acctNo}</td>
                    <td>${check?.checkDate}</td>
                    <td>${check?.checkNo}</td>
                    <td>${check?.clearingDate}</td>
                    <td>${check?.checkAmt}</td>
                    <td>
                        <a href="#" class="btn btn-secondary" onclick="deleteCheckAjax('${i}')">Remove</a>
                    </td>		
                </tr>
                <g:set var="i" value="${i = i + 1}" />
            </g:each>		
        </g:elseif>
    </tbody>
    </table>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnCOCIInstance, field: 'txnAmt', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnAmt">
        <g:message code="txnCOCI.txnAmt.label" default="Check Control Total" />
    </label>

    <div class="col-sm-6">
        <g:textField id="Check_Control_Total" name="txnAmt" disabled="" value="${fieldValue(bean: txnCOCIInstance, field: 'txnAmt')}" class="form-control"/>
    </div>             
</div>

<div class="container-fluid">
    <div class="col-xs-9">
        <div class="infowrap">
            <table class="table table-bordered table-hover table-striped">
                <legend class="section-header"><h4>Payment Breakdown</h4></legend>
                <tr>
                    <td>
                        <label class="control-label" for="principalAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.principalAmt.label" default="Principal" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="principalInstallmentAmount" required="" value="${loanInstallmentInstance?.principalInstallmentAmount}" class="form-control truncated" onchange="updateVar()"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="interestAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.interestAmt.label" default="Interest" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="interestInstallmentAmount" required="" value="${loanInstallmentInstance?.interestInstallmentAmount}" class="form-control truncated" onchange="updateVar()"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="penaltyAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.penaltyAmt.label" default="Penalty" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="penaltyInstallmentAmount" required="" value="${loanInstallmentInstance?.penaltyInstallmentAmount}" class="form-control truncated" onchange="updateVar()"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="serviceChargeAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.serviceChargeAmt.label" default="Service Charge" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="serviceChargeInstallmentAmount" required="" value="${loanInstallmentInstance?.serviceChargeInstallmentAmount}" class="form-control truncated" onchange="updateVar()"/>
                    </td>
                </tr>
                <tr> 
                    <td>
                        <label class="control-label" for="grtAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.grtAmt.label" default="Gross Receipts Tax" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="grtAmt" required="" value="${txnLoanCheckSpecifiedRepaymentInstance?.grtAmt}" class="form-control truncated" onchange="updateVar()" disabled="disabled"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="otherAmt">
                            <strong>
                                <g:message code="txnLoanCheckSpecifiedRepayment.otherAmt.label" default="Others" />
                            </strong>
                        </label>
                    </td>
                    <td>
                        <g:textField type="number" name="otherAmt" required="" value="${txnLoanCheckSpecifiedRepaymentInstance?.otherAmt}" class="form-control truncated" onchange="updateVar()" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnLoanCheckSpecifiedRepaymentInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnLoanCheckSpecifiedRepayment.txnRef.label" default="Transaction Reference" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" required="" value="${txnLoanCheckSpecifiedRepaymentInstance?.txnRef}"class="form-control"/>
    </div>             
</div>