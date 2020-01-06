
<%@ page import="icbs.deposit.DepositTaxFeeAndChargeScheme" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme')}" />
		<title>Show Deposit Taxes/Fees and Charges Scheme</title>
	</head>
	<body>
            <content tag="main-content">   
		<div id="show-depositTaxFeeAndChargeScheme" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
                            <div class="box-body">
                                <div class="alert alert-info alert-dismissable">
                                    <i class="fa fa-info"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <b>Message</b> <div class="message" role="status">${flash.message}</div>
                                </div>
                            </div>
			</g:if>
			<ol class="property-list depositTaxFeeAndChargeScheme">
                            <div class="section-container">
                                <fieldset>
                                <legend class="section-header"> Deposit Taxes/Fees and Charges Scheme Details </legend>
                                 <table class="table table-bordered table-striped">
                                    <tbody>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.code}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Code</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="code"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.type}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Type</td>
                                            <td width="70%">${depositTaxFeeAndChargeSchemeInstance?.type?.encodeAsHTML()}</td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.taxRate}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Tax Rate</td>
                                            <td width="70%"><g:formatNumber format="#,##0.00" number="${depositTaxFeeAndChargeSchemeInstance?.taxRate}"/>%</td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.feeRate}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Fee Rate</td>
                                            <td width="70%"><g:formatNumber format="#,##0.00" number="${depositTaxFeeAndChargeSchemeInstance?.feeRate}"/>%</td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.feeAmt}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Fee Amount</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${depositTaxFeeAndChargeSchemeInstance?.feeAmt}"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.chargeRate}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charge Rate</td>
                                            <td width="70%"><g:formatNumber format="#,##0.00" number="${depositTaxFeeAndChargeSchemeInstance?.chargeRate}"/>%</td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.chargeAmt}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charge Amount</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${depositTaxFeeAndChargeSchemeInstance?.chargeAmt}"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.specialCalculation}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Special Calculation</td>
                                            <td width="70%">${depositTaxFeeAndChargeSchemeInstance?.specialCalculation?.encodeAsHTML()}</td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Fee Base Amt Condition</td>
                                            <td width="70%"><g:formatBoolean boolean="${depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.feeCountCondition}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Fee Count Condition</td>
                                            <td width="70%"><g:formatBoolean boolean="${depositTaxFeeAndChargeSchemeInstance?.feeCountCondition}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.gracePeriod}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Grace Period</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="gracePeriod"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.feeRateBasis}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Fee Rate Basis</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="feeRateBasis"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.chargeRateBasis}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charge Rate Basis</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="chargeRateBasis"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.isApplyToClosingBal}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Is Apply To Closing Bal</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="isApplyToClosingBal"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.minAmtException}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Minimum Amount Exception</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="minAmtException"/></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${depositTaxFeeAndChargeSchemeInstance?.description}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Description</td>
                                            <td width="70%"><g:fieldValue bean="${depositTaxFeeAndChargeSchemeInstance}" field="description"/></td>
                                        </tr>
                                        </g:if>

                                    </tbody>
                                </table>
                                </fieldset>
                            </div>			

			</ol>
			
		</div>
            </content>
             <content tag="main-actions">
                <ul>
                    <li><g:link class="list" action="index">Deposit Taxes/Fees and Charges Scheme List</g:link></li>
                    <li><g:link class="create" action="create">New Deposit Taxes/Fees and Charges Scheme</g:link></li>
                    <li><button disabled="disabled">View Deposit Tax/Charges and Fees Scheme </button></li>
                    <li><g:link action="edit" id="${depositTaxFeeAndChargeSchemeInstance.id}">Update Deposit Taxes/Fees and Charges Scheme</g:link></li>                    
	       	</ul>
            </content>
	</body>
</html>
