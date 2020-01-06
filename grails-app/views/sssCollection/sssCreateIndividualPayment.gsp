<%@ page import="icbs.lov.TxnType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>SSS eCollection (Individual Member)</title>  
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
            <g:form id="create" url="[action:'confirmIndividualPaymentReferenceNumber',controller: 'SssCollection']" onsubmit="callLoadingDialog();" >  
                <div class="form-group">
                    <label class="control-label">Inquire Individual Payment Reference Number<span class="required-indicator">*</span></label>
                    <div class="col-sm-6">
                        <g:textField id="sssPrnNumber" name="sssPrnNumber" required="" class="form-control"/>
                        <g:hiddenField name="wsdlMethod" id="wsdlMethod" value="inquireIndividualPRN" />  
                    </div>  
                </div>
                                 
            </g:form>
 
        </content>
                
        <content tag="main-actions">
            <ul>
                
                <li><g:submitButton id="newSss" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="
                                alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                function(){
                                    checkIfAllowed('XXXXXXXX', 'form#create', 'Create New SSS', null); 
                                },
                                function(){
                                    return;
                                }); 
                        "/></li>      
                <li><g:link action="index">SSS eCollection Index</g:link></li>
                <script>


                </script>
            </ul>                                        
        </content>
    </body>
</html>

