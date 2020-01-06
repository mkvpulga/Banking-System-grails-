<%@ page import="icbs.tellering.TxnFile" %>

<g:hiddenField id="CashReceiptAdjustment" name="CashReceiptAdjustment" value="0"/>
<div class="form-group">
    <label class="control-label">Transaction Type <span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>

<!-- FOR SSS VARIABLES -->
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'paymentCode', 'has-error')} required">
    <label class="control-label">Payment Code<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:select id="paymentCode" name="paymentCode" from="${icbs.lov.SssPaymentCode.findAll{status == true}}" optionKey="id" optionValue="description" value="" class="many-to-one form-control"/>
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'paymentType', 'has-error')} required">
    <label class="control-label">Payment Type<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:select id="paymentType" name="paymentType" from="${icbs.lov.SssPaymentType.findAll{status == true}}" optionKey="id" optionValue="description" value="" class="many-to-one form-control"/>
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'payorType', 'has-error')} required">
    <label class="control-label">Payor Type<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:select id="payorType" name="payorType" from="${icbs.lov.SssPayorType.findAll{status == true}}" optionKey="id" optionValue="description" value="" class="many-to-one form-control"/>
   </div>             
</div>
   </br></br><p style="font-weight: italic;color: red;"><i>Please input for SSS Number following Pattern ex. 01-2345678-0</i></p>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ssNumber', 'has-error')} required">
    <label class="control-label">SSS Number<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
       <g:textField name="ssNumber" id="ssNumber" value="" class="form-control"/>
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'startingPeriod', 'has-error')} required">
    <label class="control-label">Starting Period<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
       <g:customDatePicker format="date"  name="startingPeriod" id="startingPeriod" precision="day" class="form-control"  value=""  />
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'endingPeriod', 'has-error')} required">
    <label class="control-label">Ending Period<span class="required-indicator">*</span></label>
    <div class="col-sm-6">
       <g:customDatePicker format="date"  name="endingPeriod" id="endingPeriod" precision="day" class="form-control"  value=""  />
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ssAmountPaid', 'has-error')} required">
    <label class="control-label">SSS Payment Amount <span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:textField type="number" name="ssAmountPaid" id="ssAmountPaid" required="" value="" class="form-control truncated" />
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'ecAmountPaid', 'has-error')} required">
    <label class="control-label">EC Payment Amount <span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:textField type="number" name="ecAmountPaid" id="ecAmountPaid" required="" value="" class="form-control truncated" />
   </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label">Transaction Reference <span class="required-indicator">*</span></label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" id="txnRef" required="" value="${txnReceiptAdjustmentInstance?.txnRef}"class="form-control"/>
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnReceiptAdjustmentInstance, field: 'txnParticulars', 'has-error')} ">
    <label class="control-label">Particulars</label>
    <div class="col-sm-6">
        <g:textArea name="txnParticulars" id="txnParticulars" maxlength="100" value="${txnReceiptAdjustmentInstance?.txnParticulars}"class="form-control"/>
    </div>             
</div>
