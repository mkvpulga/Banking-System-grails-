<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'loanLedger.label', default: 'LoanLedger')}" />
        <title>Create Loan Non-Cash Transaction</title>
        <g:javascript>
            function prcr() 
            {
            console.log('principal Credit : '+$('#principalCredit').val());
            var Amt = $('#principalCredit').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
            $('#principalCredit').val(Amt);
            updateVar();
            }

            function updateLoanDetailsAjax(params) {
            if (params.loan2) {
            $('#loan').val(params.loan2);

            $.ajax({
            type: 'POST',
            data: {id:params.loan2},
            url: "${createLink(controller:'loan', action:'getLoanDetailsAjax')}",
            success: function(msg){
            //console.log(msg);
            $('#accountNo').val($(msg).find('#account-no').html());	
            $('#customer').html($(msg).find('#customer').html());
            $('#granted-amount').html($(msg).find('#granted-amount').html());
            $('#interest-rate').html($(msg).find('#interest-rate').html());
            $('#maturity-date').html($(msg).find('#maturity-date').html());
            $('#total-net-proceeds').html($(msg).find('#total-net-proceeds').html());
            $('#total-disbursement-amount').html($(msg).find('#total-disbursement-amount').html());
            $('#overdue-principal-balance').html($(msg).find('#overdue-principal-balance').html());
            $('#principal-balance').html($(msg).find('#principal-balance').html());
            $('#interest-balance').html($(msg).find('#interest-balance').html());
            $('#penalty-balance').html($(msg).find('#penalty-balance').html());
            $('#service-charge-balance').html($(msg).find('#service-charge-balance').html());
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            function showLoanSearch() {				
            modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Loan Account", onCloseCallback:updateLoanDetailsAjax});
            modal.show();
            }

            function updateDepositAjax(params){
            if (params.deposit) {
            $.ajax({
            type: 'POST',
            data: {id:params.deposit},
            url: "${createLink(controller:'loan', action:'showDepositAccountInfo')}",
            success: function(msg){				    					    	
            $('#depositAccountNo').val($(msg).find('#account-no').html());
            $('#depositAccountName').val($(msg).find('#account-name').html());
            $('#deposit').val(params.deposit);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }
            function newupdateDepositAjaxSavings(params){
            if (params.deposit) {
            $.ajax({
            type: 'POST',
            data: {id:params.deposit},
            url: "${createLink(controller:'loan', action:'showDepositAccountInfo')}",
            success: function(msg){				    					    	
            $('#savingsdepositAccountNo').val($(msg).find('#account-no').html());
            $('#savingsdepositAccountName').val($(msg).find('#account-name').html());
            $('#depositSavingsss').val(params.deposit);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }


            function showDepositSearch(){
            modal = new icbs.UI.Modal({id:"depositModal",url:"${createLink(controller: 'search', action:'search', params:[searchDomain: 'deposit'])}",title:"Search Deposit Account",onCloseCallback:updateDepositAjax});
            modal.show();
            }
            function newsearchSavingsDep(){
            modal = new icbs.UI.Modal({id:"depositModal",url:"${createLink(controller: 'search', action:'search', params:[searchDomain: 'deposit'])}",title:"Search Deposit Account",onCloseCallback:newupdateDepositAjaxSavings});
            modal.show();
            }

            function updateForm() {

            console.log("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            var txnType = $('#txnType').val();
            var selectbox = document.getElementById("txnTemplate");
            console.log("txnType: "+txnType)
            updateVar();        
            for(i = selectbox.options.length - 1 ; i >= 0 ; i--){

            selectbox.remove(i);
            }
            var disbAmt = accounting.unformat($('#total-net-proceeds').html()) - accounting.unformat($('#total-disbursement-amount').html());
            if (txnType == 4) {  // payment
            document.getElementById('principal-debit-form-group').style.display = 'none';
            document.getElementById('principal-credit-form-group').style.display = 'block';
            document.getElementById('interest-debit-form-group').style.display = 'none';
            document.getElementById('interest-credit-form-group').style.display = 'block';
            document.getElementById('penalty-debit-form-group').style.display = 'none';
            document.getElementById('penalty-credit-form-group').style.display = 'block';
            document.getElementById('others-credit-form-group').style.display = 'block';
            document.getElementById('charges-debit-form-group').style.display = 'none';
            document.getElementById('charges-credit-form-group').style.display = 'block';
            document.getElementById('insurance-credit-form-group').style.display = 'block';
            document.getElementById('insurance-debit-form-group').style.display = 'none';
            document.getElementById('insurance-credit-form-group').style.display = 'block';
            //document.getElementById('savingsdeposit-debit-form-group').style.display = 'none';
            //document.getElementById('savingsdeposit-credit-form-group').style.display = 'none';
            document.getElementById('arothers-debit-form-group').style.display = 'none';
            document.getElementById('arothers-credit-form-group').style.display = 'block';
            document.getElementById('glaccountdescription').style.display = 'block';
            document.getElementById('depcontraid').style.display = 'block';
            document.getElementById('depcontraidInsurance').style.display = 'block';
            document.getElementById('glaccountdescriptionInsurance').style.display = 'block';
            //======== calling function to remove new fields
            //removeNewfieldOtherCharge();
            //============================================== 
            } else if (txnType == 5) {  // disbursement
            document.getElementById('principal-debit-form-group').style.display = 'block';
            document.getElementById('principal-credit-form-group').style.display = 'none';
            document.getElementById('interest-debit-form-group').style.display = 'none';
            document.getElementById('interest-credit-form-group').style.display = 'none';
            document.getElementById('penalty-debit-form-group').style.display = 'none';
            document.getElementById('penalty-credit-form-group').style.display = 'none';
            document.getElementById('others-credit-form-group').style.display = 'none';
            document.getElementById('charges-debit-form-group').style.display = 'none';
            document.getElementById('charges-credit-form-group').style.display = 'none';
            //alert($('#total-net-proceeds').html());
            //document.getElementById('principalDebit').value = $('#total-net-proceeds').html()
            document.getElementById('principalDebit').value = disbAmt.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
            //======== calling function to remove new fields
            removeNewfieldOtherCharge();
            //============================================== 
            } else if (txnType == 6) {  // principal debit
            document.getElementById('principal-debit-form-group').style.display = 'block';
            document.getElementById('principal-credit-form-group').style.display = 'none';
            document.getElementById('interest-debit-form-group').style.display = 'none';
            document.getElementById('interest-credit-form-group').style.display = 'none';
            document.getElementById('penalty-debit-form-group').style.display = 'none';
            document.getElementById('penalty-credit-form-group').style.display = 'none';
            document.getElementById('others-credit-form-group').style.display = 'none';
            document.getElementById('charges-debit-form-group').style.display = 'none';
            document.getElementById('charges-credit-form-group').style.display = 'none';
            //======== calling function to remove new fields
            removeNewfieldOtherCharge();
            //============================================== 
            } else if (txnType == 7) {  // principal credit
            document.getElementById('principal-debit-form-group').style.display = 'none';
            document.getElementById('principal-credit-form-group').style.display = 'block';
            document.getElementById('interest-debit-form-group').style.display = 'none';
            document.getElementById('interest-credit-form-group').style.display = 'none';
            document.getElementById('penalty-debit-form-group').style.display = 'none';
            document.getElementById('penalty-credit-form-group').style.display = 'none';
            document.getElementById('others-credit-form-group').style.display = 'none';
            document.getElementById('charges-debit-form-group').style.display = 'none';
            document.getElementById('charges-credit-form-group').style.display = 'none';
            //======== calling function to remove new fields
            removeNewfieldOtherCharge();
            //==============================================    

            } else if (txnType == 8) {  // interest debit
            document.getElementById('principal-debit-form-group').style.display = 'none';
            document.getElementById('principal-credit-form-group').style.display = 'none';
            document.getElementById('interest-debit-form-group').style.display = 'block';
            document.getElementById('interest-credit-form-group').style.display = 'none';
            document.getElementById('penalty-debit-form-group').style.display = 'block';
            document.getElementById('penalty-credit-form-group').style.display = 'none';
            document.getElementById('others-credit-form-group').style.display = 'none';
            document.getElementById('charges-debit-form-group').style.display = 'block';
            document.getElementById('charges-credit-form-group').style.display = 'none';
            //====================== new fields ========================================
            // for insurance debit
            //document.getElementById('insurance-debit-form-group').style.display = 'block';
            //document.getElementById('insurance-credit-form-group').style.display = 'none';
            // for savings deposit debit
            //document.getElementById('savingsdeposit-debit-form-group').style.display = 'block';
            //document.getElementById('savingsdeposit-credit-form-group').style.display = 'none';
            // for ar others debit
            //document.getElementById('arothers-debit-form-group').style.display = 'block';
            //document.getElementById('arothers-credit-form-group').style.display = 'none';
            //======== calling function to remove new fields
            removeNewfieldOtherCharge();
            //============================================== 
            //====================== end new fields ========================================
            } else if (txnType == 9) {  // interest credit
            document.getElementById('principal-debit-form-group').style.display = 'none';
            document.getElementById('principal-credit-form-group').style.display = 'none';
            document.getElementById('interest-debit-form-group').style.display = 'none';
            document.getElementById('interest-credit-form-group').style.display = 'block';
            document.getElementById('penalty-debit-form-group').style.display = 'none';
            document.getElementById('penalty-credit-form-group').style.display = 'block';
            document.getElementById('others-credit-form-group').style.display = 'none';
            document.getElementById('charges-debit-form-group').style.display = 'none';
            document.getElementById('charges-credit-form-group').style.display = 'block';
            //====================== new fields ========================================
            // for insurance debit
            //document.getElementById('insurance-debit-form-group').style.display = 'none';
            //document.getElementById('insurance-credit-form-group').style.display = 'block';
            // for savings deposit debit
            // document.getElementById('savingsdeposit-debit-form-group').style.display = 'none';
            //document.getElementById('savingsdeposit-credit-form-group').style.display = 'block';
            // for ar others debit
            //document.getElementById('arothers-debit-form-group').style.display = 'none';
            //document.getElementById('arothers-credit-form-group').style.display = 'block';
            //======== calling function to remove new fields
            removeNewfieldOtherCharge();
            //============================================== 
            //====================== end new fields ========================================
            }
            $('#txnTemplate').empty(); //remove all child nodes
            $('#txnTemplate').innerHTML="";
            var newOption = $('<option value=""></option>');

            $('#txnTemplate').trigger("chosen:updated");
            // update transaction templates
            var obj = { 
            txnType: txnType,
            }; 
            console.log(JSON.stringify(obj));
            console.log("Object Loaded iwth data...");
            $.ajax({
            type: 'POST',
            contentType: "application/json",
        url: "${createLink(controller:'loanAdjustment', action:'getTxnTemplatesAjax')}",
        data: JSON.stringify(obj),
        success: function(data){
        var selectbox = document.getElementById("txnTemplate");

        for(i = selectbox.options.length - 1 ; i >= 0 ; i--){

        selectbox.remove(i);
        }

        var kk = 0;
        $.each(data, function (_key, _value) {
        //console.log(JSON.stringify(data));

        var zxczxxx = _value.description;
        console.log("boom"+zxczxxx);
        console.log("CONFIG status: "+_value.config_item_status_id);
        var removeStatusID = parseInt(_value.config_item_status_id);
        if(removeStatusID == 2){
        $('#txnTemplate').append($("<option></option>").attr("value",_value.id).text(zxczxxx).prop('selected', kk == 0)); 
        }


        });
        console.log("hayyyyy");
        var xghgh = document.getElementById("txnTemplate");
        $('#txnTemplate').trigger("chosen:updated");
        document.getElementById("txnTemplate").insertBefore(new Option('', ''), document.getElementById("txnTemplate").firstChild);

        //document.getElementById("txnTemplate").find('option:[value='']').attr('selected',1);
        //$('#txn-template').html($(data).find('#txn-template').html());


        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
        alert(XMLHttpRequest+textStatus+errorThrown);
        }
        });
        }

        function submitForm() {
        var response = confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');

        if (response)
        jQuery('#loan-adjustment-form').submit();
        }

        icbs.Dependencies.Ajax.addLoadEvent(function(){
        updateLoanDetailsAjax({loan2:"${loanLedgerInstance?.loan?.id}"});
        updateDepositAjax({deposit:"${loanLedgerInstance?.deposit?.id}"});
        updateForm();        		
        });

        function updateVar() {

        totBreakdown = 0;

        PRINDR = accounting.unformat($('#principalDebit').val());
        if (isNaN(PRINDR))
        PRINDR = 0;

        PRINCR = accounting.unformat($('#principalCredit').val());
        if (isNaN(PRINCR))
        PRINCR = 0;

        INTDR = accounting.unformat($('#interestDebit').val());
        if (isNaN(INTDR))
        INTDR = 0;

        INTCR = accounting.unformat($('#interestCredit').val());
        if (isNaN(INTCR))
        INTCR = 0;

        PENDR = accounting.unformat($('#penaltyDebit').val());
        if (isNaN(PENDR))
        PENDR = 0; 

        PENCR = accounting.unformat($('#penaltyCredit').val());
        if (isNaN(PENCR))
        PENCR = 0;
        OTHCR = accounting.unformat($('#otherCredit').val());
        if (isNaN(OTHCR))
        OTHCR = 0;
        SCDR = accounting.unformat($('#chargesDebit').val());
        if (isNaN(SCDR))
        SCDR = 0;

        SCCR = accounting.unformat($('#chargesCredit').val());
        if (isNaN(SCCR))
        SCCR = 0;
        ARINSU = accounting.unformat($('#arAndInsuranceTotal').val());
        if (isNaN(ARINSU))
        ARINSU = 0;
        console.log("PRINDR: "+PRINDR);    
        console.log("PRINCR: "+PRINCR);  
        console.log("INTDR: "+INTDR);  
        console.log("INTCR: "+INTCR);  
        console.log("PENDR: "+PENDR);  
        console.log("PENCR: "+PENCR);  
        console.log("SCDR: "+SCDR);
        console.log("SCCR: "+SCCR);
        console.log("ARINSU: "+ARINSU);
        totBreakdown = accounting.unformat((PRINDR+PRINCR+INTDR+INTCR+PENDR+PENCR+OTHCR+SCDR+SCCR+ARINSU).toFixed(2));
        document.getElementById('total-amount').value = totBreakdown.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
        //alert(TotBreakdown);
        }
        function removeNewfieldOtherCharge(){
        //====================== new fields ========================================

        // for insurance debit
        document.getElementById('insurance-debit-form-group').style.display = 'none';
        document.getElementById('insurance-credit-form-group').style.display = 'none';
        // for savings deposit debit
        //document.getElementById('savingsdeposit-debit-form-group').style.display = 'none';
        //document.getElementById('savingsdeposit-credit-form-group').style.display = 'none';
        // for ar others debit
        document.getElementById('arothers-debit-form-group').style.display = 'none';
        document.getElementById('arothers-credit-form-group').style.display = 'none';
        document.getElementById('glaccountdescription').style.display = 'none';
        document.getElementById('depcontraid').style.display = 'none';

        document.getElementById('depcontraidInsurance').style.display = 'none';
        document.getElementById('glaccountdescriptionInsurance').style.display = 'none';


        //====================== end new fields ========================================
        }
        function updateFieldChargeDebit(){
        var inseranceVar = $('#insuranceDebit').val();
        var savingsDepositVar = $('#savingsDepositDebit').val();
        var arOthersVar = $('#arOthersDebit').val();
        inseranceVar = parseFloat(inseranceVar.replace(/,/g , ""));
        savingsDepositVar = parseFloat(savingsDepositVar.replace(/,/g , ""));
        arOthersVar = parseFloat(arOthersVar.replace(/,/g , ""));
        console.log("asdasdasdasdasd oooooooooooooooooooooooo");
        if(isNaN(inseranceVar)==true){
        inseranceVar = 0;
        }
        if(isNaN(savingsDepositVar)==true){
        savingsDepositVar = 0;
        }
        if(isNaN(arOthersVar)==true){
        arOthersVar = 0;
        }
        var totalOtherCharges = inseranceVar + savingsDepositVar + arOthersVar;
        console.log("******* DEBIT **********")
        console.log("inseranceVar: "+inseranceVar);
        console.log("savingsDepositVar: "+savingsDepositVar);
        console.log("arOthersVar: "+arOthersVar);
        console.log("totalOtherCharges: "+totalOtherCharges);
        document.getElementById('chargesDebit').value = totalOtherCharges;
        updateVar();
        }
        function updateFieldChargeCredit(){
        var inseranceVar = $('#insuranceCredit').val();
        var savingsDepositVar = $('#savingsDepositCredit').val();
        var arOthersVar = $('#arOthersCredit').val();

        inseranceVar = parseFloat(inseranceVar.replace(/,/g , ""));
        savingsDepositVar = parseFloat(savingsDepositVar.replace(/,/g , ""));
        arOthersVar = parseFloat(arOthersVar.replace(/,/g , ""));
        if(isNaN(inseranceVar)==true){
        inseranceVar = 0;
        }
        if(isNaN(savingsDepositVar)==true){
        savingsDepositVar = 0;
        }
        if(isNaN(arOthersVar)==true){
        arOthersVar = 0;
        }
        var totalOtherCharges = inseranceVar + savingsDepositVar + arOthersVar;
        console.log("******* CREDIT **********")
        console.log("inseranceVar: "+inseranceVar);
        console.log("savingsDepositVar: "+savingsDepositVar);
        console.log("arOthersVar: "+arOthersVar);
        $('#arAndInsuranceTotal').val(totalOtherCharges);
        //document.getElementById('chargesCredit').value = totalOtherCharges;
        updateVar();
        }
        $( document ).ready(function() {
        console.log("im ready");
        updateForm();
        });
        var onoff=""
        function validateGlCode(){
        var depcontra = $('#arOthersGLGL').val();
        var financialYear = $('#financialYear').val();
        console.log("financialYear: "+financialYear);
        if(depcontra==""){

        }else{
        //=================== AJAX FUNCTION to validate code if existing
        var obj = { 
        depcontra: depcontra,
        financialYear: financialYear,
        }; 
        console.log(JSON.stringify(obj));
        console.log("Object Loaded iwth data...");
        $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "${createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax')}",
        data: JSON.stringify(obj),

        success: function(data){
        if(data.length >=1){
        onoff = ""
        //document.getElementById('glaccountdescription').style.display = "block";
        $.each(data, function (_key, _value) {
        console.log(JSON.stringify(obj))
        console.log(_value.gl_code);
        console.log(_value.name);
        $('#arOthersgldescription').val(_value.name);

        });

        }else{
        onoff = "invalidGlCode";
        //document.getElementById('glaccountdescription').style.display = "none";
        notify.message('Sorry, Invalid Gl Code!|error|alert');

        }
        console.log("onoff: "+onoff);


        },
        error: function(data){

        },

        });                                            
        }

        }
        function validateGlCodeinsurance(){
        var depcontra = $('#insuranceGLGL').val();
        var financialYear = $('#financialYear').val();
        console.log("financialYear: "+financialYear);
        if(depcontra==""){

        }else{
        //=================== AJAX FUNCTION to validate code if existing
        var obj = { 
        depcontra: depcontra,
        financialYear: financialYear,
        }; 
        console.log(JSON.stringify(obj));
        console.log("Object Loaded iwth data...");
        $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "${createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax')}",
        data: JSON.stringify(obj),

        success: function(data){
        if(data.length >=1){
        onoff = ""
        //document.getElementById('insuranceGlDescription').style.display = "block";
        $.each(data, function (_key, _value) {
        console.log(JSON.stringify(obj))
        console.log(_value.gl_code);
        console.log(_value.name);
        $('#insuranceGlDescription').val(_value.name);

        });

        }else{
        onoff = "invalidGlCode";
        //document.getElementById('glaccountdescription').style.display = "none";
        notify.message('Sorry, Invalid Gl Code!|error|alert');

        }
        console.log("onoff: "+onoff);


        },
        error: function(data){

        },

        });                                            
        }

        }          

    </g:javascript>
</head>
<body>
<content tag="main-content">
    <div id="create-loanLedger" class="content scaffold-create" role="main">
        <g:if test="${flash.message}">
            <script>
                $(function(){
                            var x = '${flash.message}';
                notify.message(x);
                });
            </script>
        </g:if>
        <g:hasErrors bean="${loanLedgerInstance}">
            <div class="box-body">
                <div class="alert alert-danger alert-dismissable">
                    <i class="fa fa-ban"></i>
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <b>Alert!</b> 
                    <ul class="errors" role="alert">
                        <g:if test="${loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.disbursement.excess')}">
                            Total disbursement amount cannot exceed total net proceeds
                        </g:if>
                        <g:elseif test="${loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.excess')}">
                            Principal balance amount cannot exceed loan amount
                        </g:elseif>
                        <g:elseif test="${loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.belowZero')}">
                            Principal balance amount cannot be less than zeo
                        </g:elseif>
                        <g:else>
                            There are errors
                        </g:else>
                    </ul>            
                </div>
            </div>
        </g:hasErrors>
        <g:form id="loan-adjustment-form" url="[controller:loanAdjustment, action:'save']" >
            <div>
                <g:render template="form"/>
            </div>
        </g:form>
    </div>
</content>
<content tag="main-actions">
    <ul>
        <li><g:submitButton id="adjust"name="save" value="Save" onclick="funcCallValidate();"/> </li>
        <script>
            function funcCallValidate(){

            var xxxxxx = $('#txnTemplate').val();
            console.log("asdasdasd: "+xxxxxx);
            var KKKTTTT = $('#txnType').val();
            console.log("KKKTTTT: "+KKKTTTT);
            if(parseInt(KKKTTTT) == 4){
            var insuranceVar = $('#insuranceCredit').val();
            var insureceGlAmount = $('#insuranceGLGL').val();
            var ararOthersAmount = $('#arOthersCredit').val();
            var ararOthersGLGL = $('#arOthersGLGL').val();

            console.log("insuranceVar: "+insuranceVar);
            console.log("insureceGlAmount: "+insureceGlAmount);
            console.log("ararOthersAmount: "+ararOthersAmount);
            console.log("ararOthersGLGL: "+ararOthersGLGL);

            var proceedProcessNow = "true"	
            if(insuranceVar){
            if(insureceGlAmount=="" || insureceGlAmount==null){
            proceedProcessNow = "false";
            notify.message('Insurance GL Cannot Be Null!|error|alert');
            }
            }
            if(ararOthersAmount){
            if(ararOthersGLGL=="" || ararOthersGLGL==null){
            proceedProcessNow = "false";
            notify.message('AR OTHERS GL Cannot Be Null!|error|alert');
            }
            }
            if(insureceGlAmount){
            if(insuranceVar=="" || insuranceVar==null){
            proceedProcessNow = "false";
            notify.message('Insurance Amount Cannot Be Null!|error|alert');
            }
            }
            if(ararOthersGLGL){
            if(ararOthersAmount=="" || ararOthersAmount==null){
            proceedProcessNow = "false";
            notify.message('Other GL Amount Cannot Be Null!|error|alert');
            }
            }
            }

            if(proceedProcessNow=="false"){

            }
            else{

            var frmtxnType = $('#txnType').val();
            var frmtxnTemplate = $('#txnTemplate').val();
            var frmdepAcct = $('#deposit').val();
            console.log("frmtxnType: "+frmtxnType);
            console.log("frmdepAcct: "+frmdepAcct);
            // loan payment and TxnTemplate Loan Recovery
            if(frmtxnType.toString() == "4" && frmdepAcct == ""){
            console.log("NO SA");
            alertify.confirm(AppTitle,'No Savings Account Define for loan payment would you like to continue?',
            function(){

            checkIfAllowed('LON00900', 'form#loan-adjustment-form', 'Create loan adjustment', null); 
            },
            function(){
            alertify.error('Canceled..');
            return;
            }
            );
            }else{
            alertify.confirm(AppTitle,'Are you sure you want to continue this process?',
            function(){

            checkIfAllowed('LON00900', 'form#loan-adjustment-form', 'Create loan adjustment', null); 
            },
            function(){
            alertify.error('Canceled..');
            return;
            }
            );
            }

            }

            }
        </script>    
<!--
         <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#adjust" ).click(function() {
                                 checkIfAllowed('LON00900', 'form#loan-adjustment-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
       </script>
        -->
        <li><g:link class="list" action="index" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
        </ul>
    </content>
</body>
</html>
