<%@ page import="icbs.loans.CreditInvestigation" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Credit Scoring Product Information</title>
	</head>
	<body>
        <content tag="main-content">   
            <div id="list-creditInvestigation" class="content scaffold-list" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
            </div>
            <table class="table table-bordered table-rounded table-striped table-hover">
                <tbody>
                    <tr>
                        <td style="width:30%"><label>Product</label></td>
                        <td style="width:70%">${creditScoringProductConfigInstance?.currency?.name}</td>    
                    </tr>                         
                    <tr>
                        <td style="width:30%"><label>GL Account Code</label></td>
                        <td style="width:70%">${creditScoringProductConfigInstance?.glContra}</td>    
                    </tr> 
                    <tr>
                        <td style="width:30%"><label>Creditor Name</label></td>
                        <td style="width:70%">${billsPayableInstance?.creditorName}</td>    
                    </tr> 
                    <tr>
                        <td style="width:30%"><label>Date Opened</label></td>
                        <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.dateOpened}" /></td>    
                    </tr>                        
                    <tr>
                        <td style="width:30%"><label>Maturity Date</label></td>
                        <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.dueDate}" /></td>    
                    </tr>
                    <tr>
                        <td style="width:30%"><label>Promissory Note Date</label></td>
                        <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.pnDate}" /></td>    
                    </tr>  
                    <tr>
                        <td style="width:30%"><label>Promissory Note Number</label></td>
                        <td style="width:70%">${billsPayableInstance?.pnNo}</td>    
                    </tr>
                    <tr>
                        <td style="width:30%"><label>Post Dated Check Issued</label></td>
                        <td style="width:70%">${billsPayableInstance?.pdcIssuedText}</td>  
                    </tr>    
                </tbody>
            </table>  
            
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><button onclick="validateFields();">Save Credit Soring Product</button></li>
                    <li><g:link controller="creditScoring"  action="index">Cancel</g:link></li>
                    <li><g:link controller="creditScoring"  action="index">Cancel</g:link></li>
                    <script>
                        function validateFields(){
                            var products = $('#products').val();
                            var code = $('#code').val();
                            
                            if(products == null || products==""){
                                notify.message("Product cannot be empty !|error|alert");
                            }else if(code == null || code==""){
                                notify.message("Code cannot be empty !|error|alert");
                            }else{
                                alertify.confirm(AppTitle,"Are you sure about this?",
                                    function(){
                                         $('#creditScoringProduct').submit();
                                    },
                                    function(){
                                      alertify.error('Canceled..');
                                    });
                            }
                            
                        }
                    </script>
		</ul>
            </content>
	</body>
</html>
