<%@ page import="icbs.tellering.TxnRemittance" %>
<g:hiddenField name="txnDepIDSender" id="txnDepIDSender" value="${customerInstance?.id}"/>
<g:hiddenField name="txnDepIDBenef" id="txnDepIDBenef" value="${customerInstance?.id}"/>
<g:hiddenField name="txnIdent" id="txnIdent"/>
<g:hiddenField id="CashReceiptRemittance" name="CashReceiptRemittance" value="0"/>
<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(2),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>
<fieldset class="form-group">
<g:if test="${!txnCashReceiptRemittanceInstance?.sender}">
    <input type="button" href="#" class="btn btn-primary" onclick="initializeCustomerDetailsSearchModal('txnSenderDetailsDiv');modal.show()"value="Search Sender"/>
</g:if>
</fieldset>        
        
<fieldset class="form-group">
    <div class="col-sm-10" id="txnSenderDetailsDiv">
        <g:render template='/customer/details/txnCustomerDetails' model="[customerInstance:txnCashReceiptRemittanceInstance?.sender]"/>
    </div>
</fieldset>
<fieldset class="form-group">
<g:if test="${!txnCashReceiptRemittanceInstance?.beneficiary}">
    <input type="button" href="#" class="btn btn-primary" onclick="initializeCustomerDetailsSearchModal('txnBeneficiaryDetailsDiv');modal.show()"value="Search Beneficiary"/>
</g:if>
</fieldset>
<fieldset class="form-group">
    <div class="col-sm-10" id="txnBeneficiaryDetailsDiv">
        <g:render template='/customer/details/txnCustomerDetails' model="[customerInstance:txnCashReceiptRemittanceInstance?.beneficiary]"/>
    </div>
</fieldset>
<div class="fieldcontain form-group ${hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnAmt', 'has-error')} required">
    <label class="control-label">Remittance Amount</label>
    <div class="col-sm-6">
        <g:textField type="number" id="txnAmt" name="txnAmt" required="" value="${txnCashReceiptRemittanceInstance?.txnAmt}"class="form-control truncated" onkeyup="updateVar()"/>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'controlNo', 'has-error')} ">
    <label class="control-label col-sm-4" for="controlNo">
        <g:message code="txnCashReceiptRemittance.controlNo.label" default="Control Number" />
    </label>
    <div class="col-sm-6">
        <g:textField name="controlNo" value="${txnCashReceiptRemittanceInstance?.controlNo}"class="form-control"/>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnParticulars', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnParticulars">
        <g:message code="txnCashReceiptRemittance.txnParticulars.label" default="Particulars" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnParticulars" value="${txnCashReceiptRemittanceInstance?.txnParticulars}"class="form-control"/>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnRef', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnCashReceiptRemittance.txnRef.label" default="Payout Instructions" /></label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" value="${txnCashReceiptRemittanceInstance?.txnRef}"class="form-control"/>
    </div>             
</div>
