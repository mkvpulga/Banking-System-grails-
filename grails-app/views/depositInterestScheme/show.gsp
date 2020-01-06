<%@ page import="icbs.deposit.DepositInterestScheme" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme')}" />
                <title>Show Deposit Interest Scheme</title>
	</head>
	<body>
            <content tag="main-content">   
		<div id="show-depositInterestScheme" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
                            <script>
                            $(function(){
                                var x = '${flash.message}';
                                    notify.message(x);
                            });
                            </script>  
                            <!--
                            <div class="box-body">
                                <div class="alert alert-info alert-dismissable">
                                    <i class="fa fa-info"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <b>Message</b> <div class="message" role="status">${flash.message}</div>
                                </div>
                            </div>
                            -->
			</g:if>
                        <div class="nav-tab-container">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab_1" data-toggle="tab">Deposit Interest Scheme Details</a></li>
                                <li><a href="#tab_2" data-toggle="tab">Deposit Interest Scheme Product Details</a></li>
                                 
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane active fade in" id="tab_1">
                                <div class="section-container">
                                <fieldset>
                                <legend class="section-header"> Deposit Interest Scheme Details </legend>
                                    <table class="table table-bordered table-striped">
                                        <tbody>
                                            <g:if test="${depositInterestSchemeInstance?.code}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Code</td>
                                                <td width="70%"><g:fieldValue bean="${depositInterestSchemeInstance}" field="code"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.name}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Name</td>
                                                <td width="70%"><g:fieldValue bean="${depositInterestSchemeInstance}" field="name"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.depositInterestStart}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Deposit Interest Start</td>
                                                <td width="70%"><g:fieldValue bean="${depositInterestSchemeInstance}" field="depositInterestStart.description"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.interestRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Interest Rate</td>
                                                <td width="70%"><g:formatNumber format="#,##0.00" number="${depositInterestSchemeInstance?.interestRate}"/>%</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.divisor}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Divisor</td>
                                                <td width="70%"><g:fieldValue bean="${depositInterestSchemeInstance}" field="divisor"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.minInterestRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Minimum Interest Rate</td>
                                                <td width="70%"><g:formatNumber format="#,##0.00" number="${depositInterestSchemeInstance?.minInterestRate}"/>%</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.maxInterestRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Maximum Interest Rate</td>
                                                <td width="70%"><g:formatNumber format="#,##0.00" number="${depositInterestSchemeInstance?.maxInterestRate}"/>%</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.fdPostMaturityRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">FD Post Maturity Rate</td>
                                                <td width="70%"><g:formatNumber format="#,##0.00" number="${depositInterestSchemeInstance?.fdPostMaturityRate}"/>%</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.fdMonthlyTransfer}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">FD Monthly Transfer</td>
                                                <td width="70%"><g:formatBoolean boolean="${depositInterestSchemeInstance?.fdMonthlyTransfer}" /></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.minBalanceToEarnInterest}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Balance Without Interest</td>
                                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${depositInterestSchemeInstance?.minBalanceToEarnInterest}"/> and Below</td>
                                            </tr>
                                            </g:if> 
                                            <g:if test="${depositInterestSchemeInstance?.minBalanceToEarnInterest}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Balance To Earn Interest</td>
                                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${depositInterestSchemeInstance?.minBalanceToEarnInterest + 1}"/> and Above</td>
                                            </tr>
                                            </g:if> 
                                            <g:if test="${depositInterestSchemeInstance?.canChangeInterestRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Can Change Interest Rate</td>
                                                <td width="70%"><g:formatBoolean boolean="${depositInterestSchemeInstance?.canChangeInterestRate}" /></td>
                                            </tr>
                                            </g:if> 
                                            <g:if test="${depositInterestSchemeInstance?.isAccrual}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Is Accrual</td>
                                                <td width="70%"><g:formatBoolean boolean="${depositInterestSchemeInstance?.isAccrual}" /></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.depositCapitalizationFreq}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Deposit Capitalization Frequency</td>
                                                <td width="70%">${depositInterestSchemeInstance?.depositCapitalizationFreq?.encodeAsHTML()}</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.depositInterestCalculation}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Deposit Interest Calculation</td>
                                                <td width="70%">${depositInterestSchemeInstance?.depositInterestCalculation.description}</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.status}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Status</td>
                                                <td width="70%">${depositInterestSchemeInstance?.status?.encodeAsHTML()}</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${depositInterestSchemeInstance?.isGraduated}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">is Graduated</td>
                                                <td width="70%"><g:formatBoolean boolean="${depositInterestSchemeInstance?.isGraduated}" /></td>
                                            </tr>
                                            </g:if>

                                        </tbody>
                                    </table> 
                                    
                                </fieldset>
                                </div>
                             </div>
                             <div class="tab-pane fade in" id="tab_2">
                                <div class="section-container">
                                <fieldset>
                                <legend class="section-header"> Deposit Interest Scheme Product Details </legend>
                                    <table class="table table-bordered table-rounded table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <g:sortableColumn property="code" title="${message(code: 'product.code.label', default: 'Code')}" />
                                                <g:sortableColumn property="name" title="${message(code: 'product.description.label', default: 'Product Name')}" />
                                            </tr>    
                                        </thead>   
                                        <tbody>
                                            <g:each in="${depositInterestSchemeInstance.products}" status="i" var="product">
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="Product" action="show" id="${product.id}">${product.code}</g:link></td>
                                                    <td>${product.name}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>  
                                </fieldset>    
                             </div>    
                        </div>
			          
			
		</div>    
			
			
                               
		</div>
            </content>
             <content tag="main-actions">
                <ul>
      			<li><g:link class="list" action="index">Deposit Interest Scheme List</g:link></li>
      			<li><g:link class="create" action="create">New Deposit Interest Scheme</g:link></li>
                <li><button disabled="disabled">View Deposit Interest Scheme</button></li>
                <g:if test="${depositInterestSchemeInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:link action="edit" controller="DepositInterestScheme" id="${depositInterestSchemeInstance.id}">Update Deposit Interest Scheme</g:link></li>
                </g:if>
                <g:if test="${depositInterestSchemeInstance.status.id == 1}">
                <li><g:form url="[id:depositInterestSchemeInstance.id, action:'activate']" method="POST">
                        <g:actionSubmit action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </g:form></li>
                </g:if>

                <g:if test="${depositInterestSchemeInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form id="deleteDepositInterestSchemeForm" url="[id:depositInterestSchemeInstance.id, action:'delete']" method="POST">
                        </g:form>
                        <g:actionSubmit id="deleteDepositIntScheme" action="delete" value="Delete" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01004', 'form#deleteDepositInterestSchemeForm', 'Override edit Deposit Interest Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                                
                            " />
                    </li>
                </g:if>
                    <li><g:link action="changeInt" controller="DepositInterestScheme" id="${depositInterestSchemeInstance.id}">Change Interest Rate</g:link></li>
	       	</ul>
                <!--
                <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#deleteDepositIntScheme" ).click(function() {
                                 checkIfAllowed('CFG01004', 'form#deleteDepositInterestSchemeForm', 'Override edit Deposit Interest Scheme.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script>
                -->
            </content>
	</body>
</html>
