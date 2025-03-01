<%@ page import="icbs.tellering.TxnDepositAcctLedger" %>


<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(4),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-require-passbook="${txnTemplateInstance.requirePassbook}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>
<g:hiddenField id="deposit_no" name="deposit_no" value="${deposit}"/>
<g:hiddenField id="depAmt" name="depAmt" value="0"/>

<fieldset class="form-group">
    <g:if test="${!txnCheckDepositInstance?.acct}">
        <input type="button" href="#" class="btn btn-primary" onclick="initializeDepositAcctSearchModal();modal.show()" value="Search Account"/>
    </g:if>
</fieldset>

<div id="depositDetDiv">
    <fieldset class="form-group">
        <g:render template='/tellering/details/depositDetails' model="[depositInstance:txnCheckDepositInstance?.acct]"/>
        <g:if test="${txnCheckDepositInstance?.acct}">
            <g:render template='/tellering/details/signatureDetails' model="[depositInstance:txnCheckDepositInstance?.acct]"/>
            <g:render template='/tellering/details/signatoryDetails' model="[depositInstance:txnCheckDepositInstance?.acct]"/>
        </g:if>
    </fieldset>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnCheckDepositInstance, field: 'passbookBal', 'has-error')} required">
    <label class="control-label">Passbook Balance</label>
    <div class="col-sm-6">
        <g:textField type="number" readonly="true" name="passbookBal" required="" value="${txnCheckDepositInstance?.passbookBal}"class="form-control truncated"/>
    </div>
    <div class="col-sm-2">
        <i id="passbookValidate" class="glyphicon hide" style="margin-top: 10px;"></i>
    </div>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnCheckDepositInstance, field: 'creditAmt', 'has-error')} required">
    <label class="control-label">Deposit Amount</label>
    <div class="col-sm-6">
        <g:textField type="number" id="creditAmt" name="creditAmt" required="" value="${txnCheckDepositInstance?.creditAmt}"class="form-control truncated" onkeyup="updateVar()"/>
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
            <td><label>Check Amount</label></td>
            <td class="col-sm-2"><label>Actions</label></td>		
	</tr>
    </tbody>
    <tbody>
        <g:if test="${txnCheckDepositInstance?.checks}">
            <g:each var="check" in="${txnCheckDepositInstance?.checks.sort{it.description}}">
                <tr>
                    <td>${check?.checkType?.description}</td>
                    <td>${check?.bank?.name}</td>
                    <td>${check?.acctNo}</td>
                    <td>${check?.checkDate?.format("MM-dd-yyyy")}</td>
                    <td id="Check_Checknumber">${check?.checkNo}</td>
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
                    <td id="Check_Checknumber">${check?.checkNo}</td>
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
<g:hiddenField id="newchecktotals" name="newchecktotals" value="" />
<div class="fieldcontain form-group">
    <label class="control-label">Check Control Total</label>
    <div class="col-sm-6">
        <g:field id="Check_Control_Total" id ="checkCTotal"  name="txnAmt" disabled="" value="${fieldValue(bean: txnCOCIInstance, field: 'txnAmt')}" class="form-control truncated" />
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnCheckDepositInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnCheckDeposit.txnRef.label" default="Transaction Reference" />
    </label>
    <div class="col-sm-6">
        <g:textArea id="txnRef" name="txnRef" required="" value="${txnCheckDepositInstance?.txnRef}"class="form-control"/>
    </div>             
</div>
