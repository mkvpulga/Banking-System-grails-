<%@ page import="icbs.loans.InterestIncomeScheme" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Update Gl Batch Voucher Details</title>
         
	</head>
     
	<body>
               
        <content tag="main-content">
         <script>
             function SubmitFormNow(){
                alertify.confirm(AppTitle,'Are you sure you want to update this voucher details?',    
                function(){
                    document.getElementById("myForm").submit();
                },
                function(){
                    return;
                });  
                
             }
             function updateSubmitFormNow(){
             
             console.log("hahaha");
                    
             
             }
         /*var details = {    
            addInputs: function(){
                console.log("success");
                var obj = {
                    check_no: $('#check_no').val(),
                    payee: $('#payee').val(),
                    approved_by: $('#approved_by').val(),
                    received_by: $('#received_by').val(),
                    
                };
                console.log(JSON.stringify(obj));
                var ajax = icbs.Dependencies.Ajax;
                    ajax.run({url:"${createLink(controller:'GlBatch', 
                                  action:'addVoucherDetails')}", 
                                  params:{check_no: $('#check_no').val(),
                                          payee: $('#payee').val(),
                                          approved_by: $('#approved_by').val(),
                                          received_by: $('#received_by').val(),},
                                          callback:callback});    		    	
                
            },
         
         }*/
         </script>    
		<div id="create-template" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
            <div id="error-notification" class="box-body" style="display: none">
                <div class="alert alert-danger alert-dismissable">
                    <i class="fa fa-ban"></i>
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <b>Alert!</b> 
                    <ul class="errors" role="alert">
                        There are errors
                    </ul>            
                </div>
            </div>
               <g:each in="${GlBatchVoucherssList}" var="voucherDetails" >          
                    <g:form name="myForm" id="myForm" url="[action:'updatevoucherAddDetailsAction',controller:'GlBatch']">
                    
                    <div>				
                        <div id="loan-template-form">
                             
                       
                        <legend></legend>
                        <div id="interest-rate-form-group" class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="interestRate">
                               Check No:<span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8">
                              
                                     <g:field type="text" name="check_no" id="check_no" value="${voucherDetails.checkNo}"  required="" class="form-control"/>
                            </div>
                        </div>

                        <div id="termOfLoan-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                Payee:
                                </label>
                                <div class="col-sm-8">
                                
                               
                                     <g:field type="text" name="payee" value="${voucherDetails.payee}" id="payee" required="" class="form-control"/>
                                                    
                            </div>
                        </div>
                           

                        <div id="downPayment-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                        Checked By: <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8">

                                      <g:field  type="text" name="approved_by" id="approved_by" value="${voucherDetails.approvedBy}" required=""  class="form-control"/>
                            </div>
                        </div>
                        <div id="desiredMonthlyPayment-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                       Received By: <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8">
                                      <g:field type="text" name="received_by" id="received_by" value="${voucherDetails.receivedBy}" required="" class="form-control" />                               
                            </div>
                        </div>
                              <g:hiddenField name="glbatchId" id="glbatchId" value="${params.idbhdr}" />
                              <g:hiddenField name="voucherid" id="voucherid" value="${params.idvoucher}" />
                        </div>
			<div class="form-group form-buttons">
					
			</div>
				<!--<div class="form-group form-buttons">
					<g:submitButton name="create" class="btn btn-primary" value="Show Schedule" />
				</div>-->
                    </div>
		</g:form>
                </g:each>        
		</div>		
        </content>
        <content tag="main-actions">
            <ul>                    
               <!-- <li><a href="#" onClick="details.addInputs()">Add Voucher Details</a></li>-->
                
                    <li><a href="#" onclick="SubmitFormNow();">Update Voucher Details</a></li>
                    <li><g:link controller="GlBatch" action="showVoucherDetails" id="${glBatchHdrInstance?.id}" params="['Bid': params.idbhdr]">Show Voucher Details</g:link></li>
                

            </ul>
        </content>
	</body>
         
</html>
