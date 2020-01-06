<%@ page import="icbs.loans.InterestIncomeScheme" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Gl Batch Voucher Details</title>
         
	</head>
        
	<body>
   
          <g:each in="${dataList}" var="Eresult" >    
        <content tag="main-content">
               <g:if test="${updateshowconfirm2=='showconfirmupdate'}">  
                    <g:javascript>
                        function callconfirm(){
                       
                              alertify.alert(AppTitle,"Voucher Details Successfully Updated !", 
                              function(){ 
                              });
                        }
                        callconfirm();
                        
                    </g:javascript>    
               </g:if> 
               <g:if test="${updateshowconfirm2=='showconfirmadd'}">  
                    <g:javascript>
                        function callconfirm(){
                       
                              alertify.alert(AppTitle,"Voucher Details Successfully Created !", 
                              function(){ 
                              });
                        }
                        callconfirm();
                        
                    </g:javascript>    
               </g:if> 
               
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
           
                    <div>				
                        <div id="loan-template-form">
                             
                       
                        <legend></legend>
                     
                        <div id="interest-rate-form-group" class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="interestRate">
                               Check No:<span class="required-indicator"></span>
                            </label>
                            <div class="col-sm-8">
                                <span>${Eresult.check_no}</span>
                               
                            </div>
                        </div>

                        <div id="termOfLoan-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                Payee:
                                </label>
                                <div class="col-sm-8">
                                <span>${Eresult.payee}</span>
                            </div>
                        </div>
                           

                        <div id="downPayment-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                        Checked By: <span class="required-indicator"></span>
                                </label>
                                <div class="col-sm-8">
                                    <span>${Eresult.approved_by}</span>
                             

  
                            </div>
                        </div>
                        <div id="desiredMonthlyPayment-form-group"  class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="amount">
                                       Received By: <span class="required-indicator"></span>
                                </label>
                                <div class="col-sm-8">
                                    <span>${Eresult.received_by}</span>
                               
                            </div>
                        </div>
                         
                             <g:hiddenField name="glbatchId" id="glbatchId" value="${params.Bid}" />
                             


                        </div>
			<div class="form-group form-buttons">
					
			</div>
				<!--<div class="form-group form-buttons">
					<g:submitButton name="create" class="btn btn-primary" value="Show Schedule" />
				</div>-->
                    </div>
	
		</div>		
        </content>
        <content tag="main-actions">
            <ul>                    
               <!-- <li><a href="#" onClick="details.addInputs()">Add Voucher Details</a></li>-->
                <li><g:link id="thelinkid" controller="GlBatch" action="updatevoucher" params="['idbhdr': params.Bid,'idvoucher':Eresult.id]" >Update Voucher Details</g:link></li>
                <li><g:link controller="GlBatch" action="index">Gl Batch Transaction List</g:link></li>
                <li><g:link controller="GlBatch" target="_blank" action="printGlBatchVoucher" id="${glBatchHdrInstance?.id}" params="['id': params.Bid]">Print Voucher Details</g:link></li>    
                
            </ul>
        </content>
         </g:each>   
	</body>
         
</html>
