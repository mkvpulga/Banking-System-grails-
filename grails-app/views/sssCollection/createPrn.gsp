<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>SSS eCollection - Request Individual PRN</title>  
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Other Cash Receipt Transaction - General</span>
        </content>
        <content tag="main-content">
            <g:if test="${flash.message}">
                <script>
                    $(function(){
                           var x = '${flash.message}';
                               notify.message(x);
                               $('#SlipTransaction').hide();
                               if(x.indexOf('|success') > -1){
                               $('#SlipTransaction').show();
                           }
                          // console.log(x)
                          // setTimeout(function(){ notify.success(x); }, 3000);
                       });
                </script>
            </g:if>
            <g:form id="create" url="[action:'requestIndvPrn',controller: 'SssCollection']" onsubmit="callLoadingDialog();" >  
                <div class="form-group">
                    <label class="control-label">Membership Type <span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:select id="membershipType" name="membershipType" from="${icbs.lov.SssMembershipType.findAllWhere(status: true)}" optionKey="id" optionValue="description" value="" class="one-to-one form-control"/>
                        <g:hiddenField name="wsdlMethod" id="wsdlMethod" value="loadIndividualPRNChange" />  
                    </div>  
                </div>
                <div class="form-group">
                    <label class="control-label">SSS Number<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="sssNumber" name="sssNumber" required="" class="form-control"/>
                    </div>  
                </div> 
                <div class="form-group">
                    <label class="control-label">Total Amount<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="totalAmt" name="totalAmt" required="" class="form-control truncated"/>
                    </div>  
                </div>
                <div class="form-group">
                    <label class="control-label">Applicable Month Start (MMYYYY)<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="fapId" name="fapId" required="" class="form-control"/>
                    </div>  
                </div>   
                <div class="form-group">
                    <label class="control-label">Applicable Month End (MMYYYY)<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="tapId" name="tapId" required="" class="form-control"/>
                    </div>  
                </div>
                                
            </g:form>
 
        </content>
                
        <content tag="main-actions">
            <ul>
                <li><button onClick="validateFieldsSSS();">Create</button></li>
                     
                <li><g:link action="index">SSS eCollection Index</g:link></li>
                <script>
                    function validateFieldsSSS(){
                    //sssNumber/totalAmt/fapId/tapId
                        var sssNummberField = $('#sssNumber').val();
                        var ssstotalAmtsss = $('#totalAmt').val();
                        var sssfapId = $('#fapId').val();
                        var sssTheTapId = $('#tapId').val();
                        var memShtType = $('#membershipType').val();
                        console.log("memShtType: "+memShtType);
                        if(sssNummberField == null || sssNummberField == ""){
                            notify.message("SSS Number cannot be Empty! |error|alert");
                        }else if(ssstotalAmtsss == null || ssstotalAmtsss == ""){
                            notify.message("SSS Transaction Amount cannot be Empty! |error|alert");
                        }else if(sssfapId == null || sssfapId == ""){
                            notify.message("SSS Applicable Month Start cannot be Empty! |error|alert");
                        }else if(sssTheTapId == null || sssTheTapId == ""){
                            notify.message("SSS Applicable Month End cannot be Empty! |error|alert");
                        }else{
                            if(memShtType == 4){
                                console.log("ss NYO: "+accounting.unformat(ssstotalAmtsss));
                                var theAmountEntered = parseFloat(accounting.unformat(ssstotalAmtsss));
                                if(theAmountEntered < 550){
                                    notify.message("Invalid Transaction amount for Member Type|error|alert");
                                }else{
                                    console.log("boom");
                                    alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                        function(){
                                            checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS', null); 
                                        },
                                        function(){
                                            return;
                                        }
                                    );
                                }
                                
                            }else{
                                var theAmountEntered = parseFloat(accounting.unformat(ssstotalAmtsss));
                                if(theAmountEntered < 110){
                                    notify.message("Invalid Transaction amount for Selected Member Type|error|alert");
                                }else{
                                    console.log("boom");
                                    alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                        function(){
                                            checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS', null); 
                                        },
                                        function(){
                                            return;
                                        }
                                    );
                                }
                            }
                        }
                    }

                </script>
            </ul>                                        
        </content>
    </body>
</html>


