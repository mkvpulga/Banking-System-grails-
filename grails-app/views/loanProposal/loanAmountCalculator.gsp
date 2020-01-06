<%@ page import="icbs.loans.InterestIncomeScheme" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Calculate Loanable Amount (Monthly)</title>
          
    	<script type="text/javascript">
            <!-- Hide the script from old browsers --
              function calcal(){
              var ss = "cc";
              
              calculate(ss);
              }
              function pv(y,pmt,i) {
                    return ( pmt / i * ( 1 - Math.pow( 1 + i, -y)) ) ;
              }

              function pmt(y,pv,i) {
                    return ( i * Math.pow( 1 + i, y) * pv  / (1 - Math.pow( 1 + i, y) ) );
              }
              function numberFormat(){

                var number = document.getElementsByName("down")[0].value;
                
                number += '';
                number = number.replace(/,/g , "");
               
                x = number.split('.');
                x1 = x[0];
                x2 = x.length > 1 ? '.' + x[1] : '';
            
                var rgx = /(\d+)(\d{3})/;
                while (rgx.test(x1)) {
                    x1 = x1.replace(rgx, '$1' + ',' + '$2');
                }
                 document.getElementsByName("down")[0].value = x1 + x2;
                 

              }


               function numberFormat1(){

                var number = document.getElementsByName("pmt")[0].value;

                number += '';
                number = number.replace(/,/g , "");
                x = number.split('.');
                x1 = x[0];
                x2 = x.length > 1 ? '.' + x[1] : '';
                var rgx = /(\d+)(\d{3})/;
                while (rgx.test(x1)) {
                    x1 = x1.replace(rgx, '$1' + ',' + '$2');
                }
                 document.getElementsByName("pmt")[0].value = x1 + x2;
    

              }
              function curr(n) {
                    n = "" + Math.round(n*100)/100;
                    var k = n.indexOf(".");
                    if (k != -1) {
                            var n1 = n.substring(0,k);
                            var n2 = n.substring(k,n.length);
                    }
                    else {
                            n1 = n;
                             n2=".00";
                    }
                    var n3 = "";
                    for (var i=0; i <= n1.length; i++) {
                            n3 = n1.charAt(i) + n3;
                    }
                    var n4 = "";
                    for (var i=0; i < n3.length; i++) {
                            if ((i%3 == 0) && (i != 0)) {
                                    n4 = n3.charAt(i) + "," + n4;
                            }
                            else {
                                    n4 = n3.charAt(i) + n4;
                            }
                    }
                    return ("" + n4 + n2);
                    
              }

              function calculate(what) {
                    //apr1 = parseFloat(form.apr.value);
                    //term = parseInt(form.term.value);
                    //down = form.down.value ;

                    apr1 = parseFloat(document.getElementsByName("apr")[0].value);
                    term = parseFloat(document.getElementsByName("term")[0].value);
                    down = parseFloat(document.getElementsByName("down")[0].value.replace(',',''));
                    
                    if (apr1 < 1.) {
                     alert("You entered an Interest Rate less than 1.0, please enter 8.5 if you want an interest rate of 8.5%!");
                     return;
                    }

                    apr = apr1 / 1200;

                    for ( i = 0; i < down.length; i++) {
                           testchar = down.charAt(i);
                           if ( (testchar < "0" || testchar > "9") && testchar != ".") {
                              alert("Please use only numbers and decimal points.  Do not use \"$\" or \",\" !");
                              return;
                           }
                    }

                    down = parseFloat(down);
                    
                    if (what == "cc") {

                           //testpmt = form.pmt.value;
                           testpmt = parseFloat(document.getElementsByName("pmt")[0].value.replace(',','')); 

                           for ( i = 0; i < testpmt.length; i++) {
                                  testchar2 = testpmt.charAt(i);
                                  if ( (testchar2 < "0" || testchar2 > "9") && testchar2 != ".") {
                                     alert("Please use only numbers and decimal points.  Do not use \"$\" or \",\" !");
                                     return;
                                  }
                           }

                            var payment = parseFloat(document.getElementsByName("pmt")[0].value.replace(',',''));
                            var carCost = pv(term,payment,apr) + down;
                            //var amount1 = document.getElementsByName("amount")[0].value
                            document.getElementsByName("amount")[0].value = curr(carCost);
                            //form.ti.value = curr((payment * term) - carCost + down);
                            //document.getElementsByName("ti")[0].value = curr((payment * term) - carCost + down);
                    }

                    if (what == "pmt") {

                           testcost = form.cost.value;

                           for ( i = 0; i < testcost.length; i++) {
                                  testchar3 = testcost.charAt(i);
                                  if ( (testchar3 < "0" || testchar3 > "9") && testchar3 != ".") {
                                     alert("Please use only numbers and decimal points.  Do not use \"$\" or \",\" !");
                                     return;
                                  }
                           }

                            carCost = parseFloat(form.cost.value) - down;
                            payment = -1*pmt(term,carCost,apr);
                            form.monthly.value = curr(payment);
                            form.ti.value = curr((payment * term) - carCost);
                    }

              }

            // --End Hiding Here -->

       </script>
	</head>
	<body>
        <content tag="main-content">
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
                <g:form>
                    <div>				
                        <div id="loan-template-form">
                             <g:render template="loancalculator"/>
                        </div>
			<div class="form-group form-buttons">
					
			</div>
				<!--<div class="form-group form-buttons">
					<g:submitButton name="create" class="btn btn-primary" value="Show Schedule" />
				</div>-->
                    </div>
		</g:form>
                 <p style="font-style: italic">Your monthly payment and down payment would result in a total loan amount of:</p>
                 <legend></legend> 
                 <div id="totalLoanamount-form-group" class="fieldcontain form-group">
                    <label class="control-label col-sm-4" for="interestRate">
                        Total Loan Amount:
                    </label>
                    <div class="col-sm-8">
                        <g:field name="amount" size="10" value=""  required="" class="form-control"/>
                    </div>
                </div>
                      
		</div>		
        </content>
        <content tag="main-actions">
            <ul>                    
                <li><g:link controller="LoanProposal" action="index">Show Instalment Schedule</g:link></li>
                
                <li><a href="#" onclick="calcal();">Calculate Loan Amount</a></li>
            </ul>
        </content>
	</body>
</html>
