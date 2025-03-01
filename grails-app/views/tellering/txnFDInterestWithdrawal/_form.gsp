<%@ page import="icbs.tellering.TxnDepositAcctLedger" %>

<g:hiddenField id="FDDepID" name="FDDepID"/>
<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control" onchange="testchange()">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(17),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-require-passbook="${txnTemplateInstance.requirePassbook}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>
<input type="text" id="currency_id" value=0 style="display:none">
<script>
    
    var totalcash = 0;

   function testchange()
   {
        console.log($('#txnTemplate').val());
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                //console.log(JSON.parse(xhttp.responseText).currency);
                currency_id.value = JSON.parse(xhttp.responseText).currency;
                $.each(JSON.parse(totJSON),function(key,value){
                    if(value.currency_id == currency_id.value)
                    {
                        totalcash = value.cashin - value.cashout;  
                    }
                });
            }
        }
        xhttp.open("POST", "getCurrencyOnTemplate?recid="+$('#txnTemplate').val(),true);
        xhttp.send();
   }
</script>

<fieldset class="form-group">
    <g:if test="${!txnFDInterestWithdrawalInstance?.acct}">
        <input type="button" href="#" class="btn btn-primary" onclick="initializeDepositAcctSearchModal();modal.show()" value="Search Account"/>
    </g:if>
</fieldset>

<div id="depositDetDiv">
    <fieldset class="form-group">
        <g:render template='/tellering/details/depositDetails' model="[depositInstance:txnFDInterestWithdrawalInstance?.acct]"/>
        <g:if test="${txnFDInterestWithdrawalInstance?.acct}">
            <g:render template='/tellering/details/signatureDetails' model="[depositInstance:txnFDInterestWithdrawalInstance?.acct]"/>
            <g:render template='/tellering/details/signatoryDetails' model="[depositInstance:txnFDInterestWithdrawalInstance?.acct]"/>
        </g:if>
    </fieldset>
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnFDInterestWithdrawalInstance, field: 'passbookBal', 'has-error')} required">
    <label class="control-label">Passbook Balance</label>
    <div class="col-sm-6">
        <g:textField type="number" name="passbookBalAmt" required="" disabled="disabled" id="FDpassbookBalAmt" value="${depositInstance?.availableBalAmt}"class="form-control"/>
    </div>
    <div class="col-sm-2">
        <i id="passbookValidate" class="glyphicon hide" style="margin-top: 10px;"></i>
    </div>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnFDInterestWithdrawalInstance, field: 'debitAmt', 'has-error')} required">
    <label class="control-label">Withdrawal Amount</label>
    <div class="col-sm-6">
        <g:textField type="number" disabled="disabled" id="FDwithdraw" name="debitAmt" readOnly="true" required=""  value="${depositInstance?.acrintAmt}"class="form-control"/>
   </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnFDInterestWithdrawalInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnFDInterestWithdrawal.txnRef.label" default="Transaction Reference" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" id="txnRef" required="" value="${txnFDInterestWithdrawalInstance?.txnRef}"class="form-control"/>
    </div>             
</div>

<script>
    if(FDwithdraw.value == '')
    {
        FDwithdraw.value = 0;
    }
    
    
</script>