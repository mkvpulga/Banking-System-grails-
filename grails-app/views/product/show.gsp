<%@ page import="icbs.admin.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title>Product Information</title>
	</head>
	<body>
            <content tag="main-content">   
		<div id="show-product" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
                            <script>
                                $(function(){
                                    var x = '${flash.message}';
                                    notify.message(x+'|success|alert'); 
                                });
                            </script> 
			</g:if>

			<div class="nav-tab-container">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab_1" data-toggle="tab">Product Details</a></li>
                <li><a href="#tab_2" data-toggle="tab">Branches</a></li>
                <li><a href="#tab_3" data-toggle="tab">Customer Groups</a></li>
                <li><a href="#tab_4" data-toggle="tab">Transactions</a></li>
              </ul>
            </div>

            <div class="tab-content">
            	<div class="tab-pane active fade in" id="tab_1">
                    
					<ul class="property-list product">
                                         <div class="section-container">
                                            <fieldset>
                                            <legend class="section-header"> Product Details </legend>
                                             <table class="table table-bordered table-striped">
                                                <tbody>
                                                    <g:if test="${productInstance?.code}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Code</td>
                                                        <td width="70%">${fieldValue(bean: productInstance, field: "code").padLeft(3, '0')}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.name}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Name</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="name"/></td>
                                                    </tr>
                                                    </g:if> 
                                                    <g:if test="${productInstance?.productType}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Product Type</td>
                                                        <td width="70%">${productInstance?.productType?.description}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.shortName}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Short Name</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="shortName"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.allowFdPartialWithrawal}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Allow Fd Partial Withrawal</td>
                                                        <td width="70%"><g:formatBoolean boolean="${productInstance?.allowFdPartialWithrawal}" /></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.allowFdMultiplePlacement}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Allow Fd Multiple Placement</td>
                                                        <td width="70%"><g:formatBoolean boolean="${productInstance?.allowFdMultiplePlacement}" /></td>
                                                    </tr>
                                                    </g:if>
                                                   <g:if test="${productInstance?.depositDormancyMonths}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Deposit Dormancy Months</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="depositDormancyMonths"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.depositDormancyTransferFreq}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Deposit Dormancy Transfer Freq</td>
                                                        <td width="70%"><g:link controller="depositAcctDormancyTransferFreq" action="show" id="${productInstance?.depositDormancyTransferFreq?.id}">${productInstance?.depositDormancyTransferFreq?.description}</g:link></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.hasDepositDormancyInterest}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Has Deposit Dormancy Interest</td>
                                                        <td width="70%"><g:formatBoolean boolean="${productInstance?.hasDepositDormancyInterest}" /></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.depositDormancyAmt}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Deposit Dormancy Amt</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="depositDormancyAmt"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.depositChargeStart}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Dormancy Charge Start</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="depositChargeStart"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.isMicrofinance}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Is Microfinance</td>
                                                        <td width="70%"><g:formatBoolean boolean="${productInstance?.isMicrofinance}" /></td>
                                                    </tr>
                                                    </g:if>
                                                   <g:if test="${productInstance?.documentTemplate}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Document Template</td>
                                                        <td width="70%"><g:fieldValue bean="${productInstance}" field="documentTemplate"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.currency}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Currency</td>
                                                        <td width="70%"><g:link controller="currency" action="show" id="${productInstance?.currency?.id}">${productInstance?.currency?.name}</g:link></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.maxBalance}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Maximum Balance</td>
                                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${productInstance?.maxBalance}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.minBalance}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Minimum Balance</td>
                                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${productInstance?.minBalance}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.maxOpen}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Maximum Open</td>
                                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${productInstance?.maxOpen}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.minOpen}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Minimum Open</td>
                                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${productInstance?.minOpen}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.maxTerm}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Maximum Term</td>
                                                        <td width="70%"><g:formatNumber format="#####" number="${productInstance?.maxTerm}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.minTerm}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Minimum Term</td>
                                                        <td width="70%"><g:formatNumber format="#####" number="${productInstance?.minTerm}"/></td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.loanProvisionFreq}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Loan Provision Freq</td>
                                                        <td width="70%">${productInstance?.loanProvisionFreq?.description}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.loanReclassFreq}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Loan Reclass Freq</td>
                                                        <td width="70%">${productInstance?.loanReclassFreq?.description}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.loanUidTransferFreq}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Loan Uid Transfer Freq</td>
                                                        <td width="70%">${productInstance?.loanUidTransferFreq?.description}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.configItemStatus}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Config Item Status</td>
                                                        <td width="70%">${productInstance?.configItemStatus?.description}</td>
                                                    </tr>
                                                    </g:if>
                                                    <g:if test="${productInstance?.configItemStatus}">
                                                    <tr>
                                                        <td style="font-weight:bold" width="30%">Config Item Status</td>
                                                        <td width="70%">${productInstance?.configItemStatus?.description}</td>
                                                    </tr>
                                                    </g:if>



                                                </tbody>
                                            </table>
                                            </fieldset>
                                        </div>
						<g:if test="${productInstance?.amortizedChargeSchemes}">
						<li class="fieldcontain">
                                                    <div class="section-container">
                                                        <fieldset>
                                                        <legend class="section-header"> Amortized Charge Schemes </legend>
							<table class="table table-bordered table-rounded table-striped table-hover">
                                                                  
                                                                <tbody>
                                                                    <g:each in="${productInstance.amortizedChargeSchemes}" var="a">
                                                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                            <td><g:link controller="amortizedChargeSchemeProduct" action="show" id="${a.id}">${a?.name}</g:link></td>
                                                                        </tr>
                                                                    </g:each>
                                                                </tbody>    
                                                            </table> 
                                                        </fieldset>
                                                    </div>    
						</li>
						</g:if>
					
					
						<g:if test="${productInstance?.interestIncomeSchemes}">
						<li class="fieldcontain">
                                                        <div class="section-container">
                                                        <fieldset>
                                                        <legend class="section-header"> Interest Income Schemes </legend>
                                                            <table class="table table-bordered table-rounded table-striped table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <g:sortableColumn property="code" title="${message(code: 'interestIncomeSchemes.code.label', default: 'Code')}" />
                                                                        <g:sortableColumn property="description" title="${message(code: 'interestIncomeSchemes.description.label', default: 'Description')}" />
                                                                    </tr>    
                                                                </thead>   
                                                                <tbody>
                                                                    <g:each in="${productInstance.interestIncomeSchemes}" status="i" var="intr">
                                                                        <g:if test="${intr.statusId == 2}">
                                                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                <td><g:link controller="interestIncomeScheme" action="show" id="${intr.id}">${intr.code}</g:link></td>
                                                                                <td>${intr.name}</td>
                                                                             
                                                                        </tr>
                                                                        </g:if>
                                                                    </g:each>
                                                                </tbody>    
                                                            </table>    
                                                        </fieldset>
                                                        </div>
						</li>
						</g:if>
					
						<g:if test="${productInstance?.loanDeductionSchemes}">
						<li class="fieldcontain">
                                                    <div class="section-container">
                                                        <fieldset>
                                                        <legend class="section-header"> Loan Deduction Schemes </legend>    
                                                            <table class="table table-bordered table-rounded table-striped table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <g:sortableColumn property="code" title="${message(code: 'loanDeductionSchemes.code.label', default: 'Code')}" />
                                                                        <g:sortableColumn property="description" title="${message(code: 'loanDeductionSchemes.description.label', default: 'Description')}" />
                                                                    </tr>    
                                                                </thead>   
                                                                <tbody>
                                                                    <g:each in="${productInstance.loanDeductionSchemes}" status="i" var="l">
                                                                        <g:if test="${l.statusId == 2}"> 
                                                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                            
                                                                                <td><g:link controller="loanDeductionScheme" action="show" id="${l.id}">${l.code}</g:link></td>
                                                                                <td>${l.name}</td>
                                                                            
                                                                        </tr>
                                                                        </g:if>
                                                                    </g:each>
                                                                </tbody>    
                                                            </table> 							
                                                        </fieldset>
                                                        </div>
						</li>
						</g:if>
					
						<g:if test="${productInstance?.loanPerformanceClassificationSchemes}">
						<li class="fieldcontain">
							
						    <div class="section-container">
                                                        <fieldset>
                                                        <legend class="section-header"> Loan Performance Classifications </legend> 
                                                            <table class="table table-bordered table-rounded table-striped table-hover">
                                                                  
                                                                <tbody>
                                                                    <g:each in="${productInstance.loanPerformanceClassificationSchemes}" var="l">
                                                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                            <td><g:link controller="loanPerformanceClassificationProduct" action="show" id="${l.id}">${l?.name}</g:link></td>
                                                                        </tr>
                                                                    </g:each>
                                                                </tbody>    
                                                            </table> 
								
                                                        </fieldset>
                                                    </div>    
						</li>
						</g:if>
					
						
					
						<g:if test="${productInstance?.penaltyIncomeSchemes}">
						<li class="fieldcontain">
                                                    <div class="section-container">
                                                        <fieldset>    
                                                        <legend class="section-header"> Penalty Income Schemes </legend>     
                                                        <table class="table table-bordered table-rounded table-striped table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <g:sortableColumn property="code" title="${message(code: 'penaltyIncomeSchemes.code.label', default: 'Code')}" />
                                                                    <g:sortableColumn property="description" title="${message(code: 'penaltyIncomeSchemes.description.label', default: 'Description')}" />
                                                                </tr>    
                                                            </thead>   
                                                            <tbody>
                                                                <g:each in="${productInstance.penaltyIncomeSchemes}" status="i" var="p">
                                                                    <g:if test="${p.statusId == 2}"> 
                                                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                        
                                                                        <td><g:link controller="penaltyIncomeScheme" action="show" id="${p.id}">${p.code}</g:link></td>
                                                                        <td>${p.name}</td>
                                                                    </tr>
                                                                    </g:if>
                                                                </g:each>
                                                            </tbody>    
                                                        </table> 
                                                        </fieldset>
                                                    </div>    
						</li>
						</g:if>

						
					
						
					
					</ul>
				</div>
				<div class="tab-pane fade in" id="tab_2">
                                    <legend class="section-header"> Branches </legend>  
                                    <table class="table table-bordered table-rounded table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <g:sortableColumn property="code" title="${message(code: 'branch.code.label', default: 'Code')}" />
                                                <g:sortableColumn property="description" title="${message(code: 'branch.name.label', default: 'Branch Name')}" />
                                            </tr>    
                                        </thead>   
                                        <tbody>
                                            <g:each in="${productBranches}" status="i" var="productBranch" >
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="Branch" action="show" id="${productBranch.branch.id}">${productBranch.branch.code}</g:link></td>
                                                    <td>${productBranch.branch.name}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>
                                       
				</div>
				<div class="tab-pane fade in" id="tab_3">
                                            
                                            <legend class="section-header"> Customer Groups </legend> 
                                                <table class="table table-bordered table-rounded table-striped table-hover">
                                                    <thead>
                                                        <tr>
                                                            <g:sortableColumn property="name" title="${message(code: 'txnTemplates.description.label', default: 'Group Name')}" />
                                                        </tr>    
                                                    </thead> 
                                                    <tbody>
                                                        <g:each in="${productInstance.customerGroups}" var="customerGroup" >
                                                            <tr>    
                                                                <td>${customerGroup.name}</td>
                                                            </tr>    
                                                        </g:each>
                                                    </tbody>    
                                                </table> 

                                             
				</div>
				<div class="tab-pane fade in" id="tab_4">
                                    <legend class="section-header"> Transactions </legend>
                                    <table class="table table-bordered table-rounded table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <g:sortableColumn property="code" title="${message(code: 'txnTemplates.code.label', default: 'Code')}" />
                                                <g:sortableColumn property="description" title="${message(code: 'txnTemplates.description.label', default: 'Description')}" />
                                            </tr>    
                                        </thead>   
                                        <tbody>
                                            <g:each in="${productInstance.txnTemplates}" status="i" var="txnTemplate" >
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="TxnTemplate" action="show" id="${txnTemplate.id}">${txnTemplate.code}</g:link></td>
                                                    <td>${txnTemplate.description}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>    
				</div>	
			</div>
                        <g:form id="delete" url="[resource:productInstance, action:'delete']" method="DELETE">
                        </g:form>
		</div>
            </content>
             <content tag="main-actions">
                <ul>
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    <g:if test="${productInstance.configItemStatus.id.toInteger() in [1, 2]}">      
                        <li><g:link class="edit" action="edit" resource="${productInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
                        <li><g:actionSubmit id="deleteProduct" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00703', 'form#delete', 'Override delete Product.', null);
                                },
                                function(){
                                    return;
                                });                                 
                            " /></li>
                    </g:if>
                    <!--
                    <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#deleteProduct" ).click(function() {
                                 checkIfAllowed('CFG00703', 'form#delete', 'Override edit Product.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                    </script>
                    -->
                      <li><g:link action="index">Product Index</g:link></li>
		</ul>
            </content>
	</body>
</html>
