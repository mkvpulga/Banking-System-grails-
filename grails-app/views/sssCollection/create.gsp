<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Other Cash Receipt Transaction - SSS Collection</title>
        <g:javascript>
            function updateVar(){
                var amount = parseFloat($('#txnAmt').val().replace(',', ''));
                if (isNaN(amount))
                    amount = 0;
                $('#CashReceiptAdjustment').val(amount);
            }
        </g:javascript>   
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
                <div id="SlipTransaction" class="alert alert-success alert-dismissable" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <div> 
                            <a onclick="
                                     var w = window.open('printValidationSlip', '_blank')
                                         w.print();
                                     ">
                                 <g:img dir="images" file="validate.png" width="35" height="35"/>
                                 Validation Slip
                            </a>
                        </div>   
                </div>
            </g:if>
             <g:hasErrors bean="${txnReceiptAdjustmentInstance}">
               <g:eachError bean="${txnReceiptAdjustmentInstance}" var="error">
                <script>
                    $(function(){
                        var x = '${it}';
                        notify.message(x);
                       // console.log(x)
                       // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                </script>
                </g:eachError>
                <div id= "addCustomerRelatedError" class="box-body">
<!--                <div id= "addCustomerRelatedError" class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            <div id="errorList">
                            </div>
                            <g:eachError bean="${txnReceiptAdjustmentInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                            </g:eachError>
                        </ul>            
                    </div>
                </div>-->
         </g:hasErrors>
            <g:form name="txnReceiptAdjustmentForm" action="save" 
                controller="sssCollection" onsubmit="return alertify.alert('Please wait... Processing....')">
                <g:render template='form' />
            </g:form>
            <g:form name="idTxnSucess" id="idTxnSucess" url="[action:'processIDforSSSCollectionTxnSuccess',controller:'tellering']">
                <g:hiddenField id="txnFileId" name="txnFileId" value="" />
            </g:form>
 
        </content>
        
          <!--Grails tag for jasper plugin-->
         <g:jasperReport action="printSLIP"  controller="tellering" format="PDF" name="TRANSACTION"  jasper="SLIP">
         </g:jasperReport>
        
        <content tag="main-actions">
            <ul>
                <li><a class="save" onclick="validateFields();">${message(code: 'default.button.create.label', default: 'Create')}</a></li>
                <li><g:link action="index">Tellering Index</g:link></li>
                <script>
                    function validateFields(){
                            
                        var txnType = $('#txnTemplate').val();
                        var paymentCode = $('#paymentCode').val();
                        var paymentType = $('#paymentType').val();
                        var payorType = $('#payorType').val();
                        var ssNumber = $('#ssNumber').val();
                        var startingPeriod = $('#startingPeriod').val();
                        var endingPeriod = $('#endingPeriod').val();
                        var ssAmountPaid = $('#ssAmountPaid').val();
                        var ecAmountPaid = $('#ecAmountPaid').val();
                        var txnRef = $('#txnRef').val();
                        var txnParticulars = $('#txnParticulars').val();
                        
                        if(txnType == "" || txnType == null){
                            notify.message('Transaction Type Cannot be null or Empty! |error|alert'); 
                        }
                        else if(paymentCode == "" || paymentCode == null){
                            notify.message('Payment code Cannot be null or Empty! |error|alert'); 
                        }
                        else if(paymentType == "" || paymentType == null){
                            notify.message('Payment Type Cannot be null or Empty! |error|alert'); 
                        }
                        else if(ssNumber == "" || ssNumber == null){
                            notify.message('SSS Number Cannot be null or Empty! |error|alert'); 
                        }
                        else if(startingPeriod == "" || startingPeriod == null){
                            notify.message('Starting Period Cannot be null or Empty! |error|alert'); 
                        }
                        else if(endingPeriod == "" || endingPeriod == null){
                            notify.message('Ending Period Cannot be null or Empty! |error|alert'); 
                        }
                        else if(ssAmountPaid == "" || ssAmountPaid == null){
                            notify.message('SSS Payment Amount Cannot be null or Empty! |error|alert'); 
                        }
                        else if(ecAmountPaid == "" || ecAmountPaid == null){
                            notify.message('EC Payment Amount Cannot be null or Empty! |error|alert'); 
                        }
                        else if(txnRef == "" || txnRef == null){
                            notify.message('Transaction Reference Cannot be null or Empty! |error|alert'); 
                        }
                        else if(txnParticulars == "" || txnParticulars == null){
                            notify.message('Particulars Cannot be null or Empty! |error|alert'); 
                        }
                        else{
                            //validate Negative Values 
                            if(parseFloat(ssAmountPaid.toString().replace(/,/g , "")) < 0 || parseFloat(ecAmountPaid.toString().replace(/,/g , "")) < 0 ){
                                notify.message('Cannot Accept Negative Values |error|alert'); 
                            }
                            var trueSSNumber = generateSSSNumber(ssNumber)
                            var xMark = "success"
                            if(trueSSNumber != ssNumber){
                                notify.message('Wrong SSS Number!,Please check your SSS Number|error|alert'); 
                                xMark = "failed"
                            }
                            
                            if(xMark == "success"){
                                startingPeriod = startingPeriod.toString();
                                var startingPe = generateStartOrEndPeriod(startingPeriod);

                                endingPeriod = endingPeriod.toString();
                                var endingPe = generateStartOrEndPeriod(endingPeriod);

                                console.log("startingPe: "+startingPe);
                                console.log("endingPe: "+endingPe);
                                startingPeriod = startingPe
                                endingPeriod = endingPe
                                
                                alertify.confirm(AppTitle,"Are you sure about this?",
                                    function(){
                                      //=============================================
                                        var obj = { 
                                            txnType: txnType,
                                            paymentCode:paymentCode,
                                            paymentType:paymentType,
                                            payorType: payorType,
                                            ssNumber: ssNumber,
                                            startingPeriod: startingPeriod,
                                            endingPeriod: endingPeriod,
                                            ssAmountPaid: ssAmountPaid,
                                            ecAmountPaid: ecAmountPaid,
                                            txnRef: txnRef,
                                            txnParticulars: txnParticulars,
                                         }; 
                                            console.log(JSON.stringify(obj));
                                            console.log("Object Loaded iwth data...");
                                        $.ajax({
                                            type: "POST",
                                            contentType: "application/json",
                                            url: "${createLink(controller:'SssCollection', action:'saveSSSCollectionAjax')}",
                                            data: JSON.stringify(obj),

                                            success: function(data){
                                                if(data.length >=1){
                                                    alertify.alert(AppTitle,"Transaction Successfully Created!", function(){
                                                        isCodeExist = 1;
                                                        console.log(data[0].id);
                                                        var txnfileID = data[0].id;
                                                        $('#txnFileId').val(txnfileID);
                                                        $('#idTxnSucess').submit();
                                                    //=============================================
                                                        /*var obj = { 
                                                            txnfileID: txnfileID,

                                                         }; 
                                                            console.log(JSON.stringify(obj));
                                                            console.log("Object Loaded iwth data...");
                                                        $.ajax({
                                                            type: "POST",
                                                            contentType: "application/json",
                                                            url: "${createLink(controller:'tellering', action:'processIDforSSSCollectionTxnSuccess')}",
                                                            data: JSON.stringify(obj),

                                                            success: function(data){
                                                                if(data.length >=1){
                                                                    isCodeExist = 1;
                                                                    console.log(data[0].id);

                                                                }else{
                                                                    isCodeExist = 0;
                                                                }


                                                            },
                                                            error: function(data){

                                                            },

                                                        });*/
                                                      });
                                                }else{
                                                
                                                }
                                                
                                                

                                            },
                                            error: function(data){

                                            },

                                        });     
                                      //=============================================
                                    },
                                    function(){
                                      alertify.error('Cancel');
                                    }
                                ); // end of alertify
                            }else{
                            
                            }
                            
                            
                        }
                        
                        //checkIfAllowed($('#txnTemplate option:selected').data('code'), 'form#txnReceiptAdjustmentForm', 'txnReceiptAdjustmentOverride', $('#CashReceiptAdjustment').val());    
                    }

                    function generateSSSNumber(ssNumber){
                        var inputedSSNumber = ssNumber.toString();
                        
                        var removeDash = inputedSSNumber.split('-');
                        var combinedString = removeDash[0] +''+ removeDash[1] +''+removeDash[2];

                        var lengthOfNumber = combinedString.length
                        console.log("lengthOfNumber: "+lengthOfNumber);
                        var counterX = 1;
                        var products = []
                        var sumOfProducts = 0;
                        
                        for (var x = 0; x < lengthOfNumber; x++){
                            var letter = combinedString.charAt(x);
                            
                            if(counterX == 1){
                                letter = parseInt(letter);
                                products[x] = parseInt(letter * 1);
                            }
                            if(counterX == 2){
                                letter = parseInt(letter);
                                products[x] = parseInt(letter * 3);
                            }
                            if(counterX == 3){
                                letter = parseInt(letter);
                                products[x] = parseInt(letter * 7);         
                                counterX = 0;
                            }
                            if(x==8 || x == 9){
                                counterX =0;
                            }else{
                                counterX = counterX + 1;
                            }                            
                        } // end curly for loop
                        
                        //sum all products of STEP 1 
                        for(var i=0;i<products.length;i++){
                            sumOfProducts = sumOfProducts + parseInt(products[i]);
                        }
                        
                        //get the last digit to get the check number
                        var convertedString = sumOfProducts
                        convertedString = convertedString.toString();
                        var lastDigit = convertedString.substring(convertedString.length - 1, convertedString.length);
                        
                        //subtract the Last digit  from 10 to get the check digit
                        var differenceStep = 10 - parseInt(lastDigit);
                        differenceStep = differenceStep.toString();
                        var finalSuffix = differenceStep.substring(differenceStep.length - 1, differenceStep.length);
                        
                        // TRUE SSS NUMBER
                        var generatedSSSNumberFromFormula = removeDash[0] +'-'+ removeDash[1] + '-' +finalSuffix.toString();
                        console.log("generatedSSSNumberFromFormula: "+generatedSSSNumberFromFormula);
                        return generatedSSSNumberFromFormula;
                        
                    } // end function of generateSSSNumber();
                    
                    function generateStartOrEndPeriod(datePeriod){
                        console.log("datePeriod: "+datePeriod);
                        
                        var dateCatcher = datePeriod.split('/');
                        
                        var MM = dateCatcher[0].toString();
                        var YYYY = dateCatcher[2].toString();
                        var yyyyMM = YYYY+''+MM;

                        return yyyyMM;
                        
                    }
                </script>
            </ul>                                        
        </content>
    </body>
</html>
