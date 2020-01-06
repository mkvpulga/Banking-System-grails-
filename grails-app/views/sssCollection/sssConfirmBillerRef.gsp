<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Confirm SSS Response Information</title> 
    </head>
  
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Other Cash Receipt Transaction - General</span>
        </content>
        <content tag="main-content">
           <asset:javascript src="telleringHelper.js"/>
        <g:javascript>
            function updateVar(){
                var amount = parseFloat($('#amount').val().replace(',', ''));
                if (isNaN(amount))
                    amount = 0;
                $('#CashReceiptCheckAdjustment').val(amount);
            }
            function showChecks() {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller:'tellering', action:'showChecksAjax')}",
                    success: function(msg){				    	
                        $('#check_table').html(msg);
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });				
            }
            function addCheckAjax() {            	
                $.ajax({
                    type: 'POST',
                    data: {checkType:$('#checkType').val(), bank:$('#bank').val(), acctNo:$('#acctNo').val(), checkDate:$('#checkDate').val(), checkNo:$('#checkNo').val(), clearingDate:$('#clearingDate').val(), checkAmt:$('#checkAmt').val()},
                    url: "${createLink(controller:'tellering', action:'addCheckAjax')}",
                    success: function(msg){
                    $('#add-check-modal .modal-body').html(msg);
                    $('#add-check-modal').on('hidden.bs.modal', function() {
                        showChecks();
                    });						
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    alert(XMLHttpRequest+textStatus+errorThrown);
                }
            });				
            }
            function deleteCheckAjax(id) {
            	if (confirm('Are you sure?')) {
                    $.ajax({
                        type: 'POST',
                        data: {id:id},
                        url: "${createLink(controller:'tellering', action:'deleteCheckAjax')}",
                        success: function(msg){
                            showChecks();
                        },
                        error:function(XMLHttpRequest,textStatus,errorThrown){
                            alert(XMLHttpRequest+textStatus+errorThrown);
                        }
                    });
                }
            }
            function showAddChecks() {
                modal = new icbs.UI.Modal({id:"add-check-modal", url:"${createLink(controller: 'tellering', action:'showAddCheckAjax')}", title:"Add Check", modalClass:"null"});
                modal.show();
            }
            function validateOnUs() {
                $.ajax({
                        type: 'POST',
                        data: {checkTypeId:$('#checkType').val()},
                        url: "${createLink(controller:'tellering', action:'changeForm')}",
                        success: function(msg){
                           if($(msg).find('#is-on-us').html() == "true"){
                                $('#bank').attr('disabled','true');
                                $('#acct').attr('disabled','true');
                           }
                           else{
                                $('#bank').removeAttr('disabled','true');
                                $('#acct').removeAttr('disabled','true');
                           }
                        },
                        error:function(XMLHttpRequest,textStatus,errorThrown){
                            alert(XMLHttpRequest+textStatus+errorThrown);
                        }
                    });
            }
        </g:javascript>
                

            <script>
                $(function(){
             

                $('#btnAddMore').click(function(){
                    var lastRow = $('.check-table tbody > tr:last');
                    var lastIndex = parseInt(lastRow.attr('data-index'));
                    lastRow.find('select').select2('destroy');
                    var clonedRow = lastRow.clone();
                    
                    clonedRow.attr('data-index', lastIndex + 1);
                    $.each(clonedRow.find('[data-name]'), function(index,data) {
                        data = $(data);
                        data.attr('name', 'coci[' + (lastIndex + 1) + '].' + data.attr('data-name'));
                    });
                                   
                    <!--Gets the last row and appends appendRow when correct row is found-->
                    $('.check-table tbody > tr:last').after(clonedRow);

                    $('.check-table tbody').find('select').select2({allowClear: true});
                    datepickerInitializer();
                });

                <!--Deletes a row-->
                $(document).on('click', '.deleteThisRow',function(){
                    var rowLength = $('.check-table tbody > tr').size();

                    if(rowLength > 1){
                        deleteRow($(this));
                    }
                });

                function deleteRow(currentNode){
                    currentNode.parent().parent().remove();
                }
            });
                 $( document ).ready(function() {
                            console.log("ready");
                            loanSSSdata();
                            
                            showChecksform($('#txnTemplate').val());
                        });
                       function loanSSSdata(){
                            var sssData = $('#sssReturnValues').val();
                            var sssInformation = sssData.split("@@#");
                            var replymsg = ""
                            $('#amount').val(accounting.format(sssInformation[1]));
                            $('#sssamount').val(accounting.format(sssInformation[1]));
                            $('#txnBillRef').val(sssInformation[4]);
                            $('#appmo').val(sssInformation[3]);
                            $('#erbrn').val(sssInformation[5]);
                            $('#ername').val(sssInformation[6]);
                            $('#replyCode').val(sssInformation[7]);
                            $('#replyDate').val(sssInformation[2]);
                            $('#ernum').val(sssInformation[0]);
                            //$('#replyDate').val(forDateNow(sssInformation[2]));
                            replymsg = sssInformation[8];
                            if(replymsg){
                                notify.message(replymsg);
                            }else{
                                 alertify.alert(AppTitle,sssInformation[0], function(){
                                    window.location.href = '/icbs/sssCollection/sssOnlineCreate';
                                 });
                                 
                            }
                        
                       }
                       var xTxntype = "";
                       function showChecksform(xValueTxnTemplate){
                            console.log("xValueTxnTemplate: "+xValueTxnTemplate);
                            var txnTemplateValue = xValueTxnTemplate.toString();
                            var sssConfigValue = '${icbs.tellering.SssConfig.findByParamCode("GEN.10263").paramValue}';
                            console.log("sssConfigValue: "+sssConfigValue);
                            sssConfigValue = sssConfigValue.toString();
                            if(txnTemplateValue == sssConfigValue){
                                xTxntype = "checkModePayment";
                                document.getElementById('showChecccksForm').style.display = "block";
                            }else{
                                xTxntype = "cashModePayment";
                                document.getElementById('showChecccksForm').style.display = "none";
                            }
                            
                       }
                       function reLoadData(){
                            var sssData = $('#sssReturnValues').val();
                            var sssInformation = sssData.split("@@#");
                            var replymsg = ""
                           
                            $('#sssamount').val(accounting.format(sssInformation[1]));
                            $('#ssstxnBillRef').val(sssInformation[4]);
                            $('#sssappmo').val(sssInformation[3]);
                            $('#ssserbrn').val(sssInformation[5]);
                            $('#sssername').val(sssInformation[6]);
                            $('#sssreplyCode').val(sssInformation[7]);
                            $('#sssreplyDate').val(sssInformation[2]);
                            $('#sssernum').val(sssInformation[0]);
                            var txnRreference = $('#txnReference').val();
                            var txnPparticulars = $('#txnParticulars').val();
                            if(xTxntype == "cashModePayment"){
                                
                                if(txnRreference == "" || txnRreference == null){
                                    notify.message('Transaction Reference Cannot be empty! |error|alert');return;
                                }else if(txnPparticulars == "" || txnPparticulars == null){
                                    notify.message('Transaction Particulars Cannot be empty! |error|alert');return;
                                }else{
                                    alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                        function(){
                                             checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS');
                                        },
                                        function(){
                                            return;
                                        }); 
                                   
                                }
                            }else{
                                if(txnRreference == "" || txnRreference == null){
                                    notify.message('Transaction Reference Cannot be empty! |error|alert');return;
                                }else if(txnPparticulars == "" || txnPparticulars == null){
                                    notify.message('Transaction Particulars Cannot be empty! |error|alert');return;
                                }else{
                                   if($('#test_check').val() > 0 ){
                                        if(accounting.unformat($('#test_checkAmt').val()) == accounting.unformat($('#amount').val())){
                                            alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                                function(){
                                                     checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS');
                                                },
                                                function(){
                                                    return;
                                                }); 
                                        }
                                        else{
                                             notify.message('Total check amount is not equal to transaction amount.|error|alert');return;
                                        }
                                    }
                                    else{
                                         notify.message('Please input check first.|error|alert');return;
                                    }
                                }
                            }
                            
                       }
                       
            </script>    
            <g:form id="create" url="[action:'saveSssTxn',controller: 'SssCollection']" onsubmit="callLoadingDialog();"  >  
                <div class="form-group">
                    <label class="control-label">Transaction Type</label>
                    <div class="col-sm-6">
                        <g:select id="txnTemplate" name="txnTemplate.id" from="${icbs.admin.TxnTemplate.findAll{id == icbs.tellering.SssConfig.findByParamCode("GEN.10262").paramValue || id == icbs.tellering.SssConfig.findByParamCode("GEN.10263").paramValue}}" optionKey="id" optionValue="description" value="${loanLedgerInstance?.txnType?.id}" class="many-to-one form-control" onchange="showChecksform(this.value);" />
                    </div>
                </div> 
                <div id="showChecccksForm">
                <div class="modal" id="add-check-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add Check</h4>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary" onclick="addCheckAjax()">Add</a>
                        </div>
                    </div>
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
                        <g:if test="${txnCOCIInstance?.checks}">
                            <g:each var="check" in="${txnCOCIInstance?.checks.sort{it.description}}">
                                <tr>
                                    <td>${check?.checkType?.description}</td>
                                    <td>${check?.bank?.name}</td>
                                    <td>${check?.acctNo}</td>
                                    <td>${check?.checkDate}</td>
                                    <td>${check?.checkNo}</td>
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
                </div>
                <div class="form-group">
                    <g:hiddenField id="sssReturnValues" name="sssReturnValues" value="${theReturnValue}" />
                    <g:hiddenField id="sssamount" name="sssamount" value="" />
                    
                    <g:hiddenField id="sssappmo" name="sssappmo" value="" />
                    <g:hiddenField id="ssstxnBillRef" name="ssstxnBillRef" value="" />
                    <g:hiddenField id="ssserbrn" name="ssserbrn" value="" />
                    <g:hiddenField id="sssername" name="sssername" value="" />
                    <g:hiddenField id="sssernum" name="sssernum" value="" />
                    <g:hiddenField id="sssreplyCode" name="sssreplyCode" value="" />
                    <g:hiddenField id="sssreplyDate" name="sssreplyDate" value="" />
                    <label class="control-label">Transaction Amount<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="amount" name="amount" value="" class="form-control truncated" disabled="disable" />
                    </div>  
                </div>
                <div class="form-group">
                    <label class="control-label">Month and Year<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="appmo" name="appmo"  value="" class="form-control" disabled="disable" />
                    </div>  
                </div>    
                <div class="form-group">
                    <label class="control-label">Biller Reference Number<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="txnBillRef" name="txnBillRef" value="" class="form-control" disabled="disable" />
                    </div>  
                </div> 
                <div class="form-group">
                    <label class="control-label">Employer Branch Code<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="erbrn" name="erbrn" value="" class="form-control" disabled="disable" />
                    </div>  
                </div>    
                <div class="form-group">
                    <label class="control-label">Employer Name<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="ername" name="ername" value="" class="form-control" disabled="disable" />
                    </div>  
                </div> 
                <div class="form-group">
                    <label class="control-label">Employer ID Number<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="ernum" name="ernum" value="" class="form-control" disabled="disable" />
                    </div>  
                </div>   
                <div class="form-group">
                    <label class="control-label">Reply Code<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="replyCode" name="replyCode" value="" class="form-control" disabled="disable" />
                    </div>  
                </div> 
                <div class="form-group">
                    <label class="control-label">Reply Date<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                         <%--<g:customDatePicker name="replyDate" id="replyDate"  precision="day" class="form-control"  disabled ="disable" value=""  /> --%>
                          <g:textField id="replyDate" name="replyDate" value="" class="form-control" disabled="disable" /> 
                    </div>  
                </div>  
                <div class="form-group">
                    <label class="control-label">Transaction Reference <span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="txnReference" name="txnReference" value="" class="form-control"  />
                    </div>  
                </div>
                <div class="form-group">
                    <label class="control-label">Transaction Particulars <span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textArea name="txnParticulars" id="txnParticulars" value="" rows="5" cols="40" class="form-control"/>
                        <g:hiddenField name="wsdlMethod" id="wsdlMethod" value="submitPaidBRNum" /> 
                    </div>  
                </div>
            </g:form>
 
        </content>
                
        <content tag="main-actions">
            <ul>
                <li><button onclick="reLoadData();">Create</button></li>     
                <li><g:link action="index">Tellering Index</g:link></li>
                
                <script>

                    function getValues(){
                        console.log("booom");
                        //amount/appmo/txnBillRef/erbrn/ername/ernum/replyCode/replyDate/txnReference/txnParticulars/wsdlMethod
                        var amount = $('#amount').val();
                        var appmo = $('#appmo').val();
                        var txnBillRef = $('#txnBillRef').val();
                        var erbrn = $('#erbrn').val();  
                        var ername = $('#ername').val(); 
                        var ernum = $('#ernum').val(); 
                        var replyCode = $('#replyCode').val(); 
                        var replyDate = $('#replyDate').val(); 
                        var txnReference = $('#txnReference').val();
                        var txnParticulars = $('#txnParticulars').val();
                        var wsdlMethod = $('#wsdlMethod').val();
                        console.log("amount: "+amount);
                        console.log("appmo: "+appmo);
                        console.log("txnBillRef: "+txnBillRef);
                        console.log("erbrn: "+erbrn);
                        console.log("ername: "+ername);
                        
                        console.log("ernum: "+ernum);
                        console.log("replyCode: "+replyCode);
                        console.log("replyDate: "+replyDate);
                        console.log("txnReference: "+txnReference);
                        console.log("txnParticulars: "+txnParticulars);
                        console.log("wsdlMethod: "+wsdlMethod);
                        
                        // AJAX FUNCTION TO POST VALUES
                        $.ajax({
                            type: 'POST',
                            data: {amount:amount,appmo:appmo,txnBillRef:txnBillRef,erbrn:erbrn,
                            ername:ername,ernum:ernum,replyCode:replyCode,replyDate:replyDate,txnReference:txnReference,
                            txnParticulars:txnParticulars,wsdlMethod:wsdlMethod},
                            url: "${createLink(controller:'SssCollection', action:'sampleCreate')}",
                            success: function(msg){
                                    //console.log(msg);

                            },
                            error:function(XMLHttpRequest,textStatus,errorThrown){
                                alert(XMLHttpRequest+textStatus+errorThrown);
                            }
                        });
                    }
                </script>
            </ul>                                        
        </content>
    </body>
</html>


