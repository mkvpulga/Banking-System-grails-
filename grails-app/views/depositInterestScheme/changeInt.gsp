<%@ page import="icbs.deposit.DepositInterestScheme" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme')}" />
		<title>Change Interest Rate</title>
                <asset:javascript src="depositHelper.js"/>
                <g:javascript>
                    function isGraduatedChecked(){
                        var e = $("#isGraduated")
                        if ($(e).is(":checked")){
                            $($("#tabs").find("li")[1]).show();
                        }else{
                            $("#graduatedList").empty();
                            $($("#tabs").find("li")[1]).hide();
                        }
                    }
                    function addGraduatedAjax(){
                        icbs.Deposit.DepositInterestScheme.Form.getForm('graduated',"${createLink(controller : 'depositInterestScheme', action:'addGraduatedFormAjax')}");
                    }
                    
                </g:javascript>
	</head>
	<body>
            <content tag="main-content">
		<div id="edit-depositInterestScheme" class="content scaffold-edit" role="main">
                    <g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${depositInterestSchemeInstance}">
			<ul class="errors" role="alert">
                            <!--
				<g:eachError bean="${depositInterestSchemeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
                            -->    
			</ul>
                    </g:hasErrors>
                    
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
                                                <td style="font-weight:bold" width="30%">Minimum Balance to Earn Interest</td>
                                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${depositInterestSchemeInstance?.minBalanceToEarnInterest}"/></td>
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
                                            <tr>
                                                <td colspan="2">
                                                    <g:form id="DepositInterestSchemeForm" url="[resource:depositInterestSchemeInstance, action:'saveIntRate']" method="PUT" >
                                                    <g:hiddenField name="version" value="${depositInterestSchemeInstance?.version}" />

                                                    <fieldset class="form">
                                                        <div class="fieldcontain form-group ${hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error')} required">
                                                            <label class="control-label col-sm-4" for="interestRate">
                                                                <g:message code="depositInterestScheme.interestRate.label" default="Interest Rate" />
                                                                <span class="required-indicator">*</span>
                                                            </label>
                                                            <div class="col-sm-8"><g:field name="interestRate" value="${fieldValue(bean: depositInterestSchemeInstance, field: 'interestRate')}"  class="form-control"/>
                                                                <g:hasErrors bean="${depositInterestSchemeInstance}" field="interestRate">
                                                                    <div class="controls">
                                                                        <span class="help-block">
                                                                            <g:eachError bean="${depositInterestSchemeInstance}" field="interestRate">
                                                                                <g:message error="${it}" /><br/>
                                                                            </g:eachError>
                                                                        </span>
                                                                    </div>
                                                                </g:hasErrors>
                                                            </div>             
                                                        </div>
                                                    </fieldset>
                                                    <g:if test="${depositInterestSchemeInstance?.isGraduated==true}">
                                                        <div>
                                                            <g:render template="form/graduated/graduatedInfo"/>
                                                        </div>
                                                    </g:if>
                                                </g:form> 
                                                    
                                                </td>
                                            </tr>
                                              
                                            
                                            
                                        </tbody>
                                    </table> 
                                    
                                </fieldset>
                                </div>
                             </div>
                             <div class="tab-pane fade in" id="tab_2">
                                <div class="section-container">
                                <fieldset>
                                <legend class="section-header"> Deposit Interest Scheme Product Details </legend>
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Product code</th>
                                                <th>Product Name</th>
                                            </tr>
                                        </thead>    
                                        <tbody>
                                            
                                            <g:each in="${depositInterestSchemeInstance.products}" var="product">
                                                <tr>
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
                    <li><button onClick="sendFormCallAlertify();">Update</button>
                        
                    <!--<li><a href="#" onclick="$('#DepositInterestSchemeForm').submit()">Update</a></li>-->
                    <li><g:link class="list" action="show" id="${depositInterestSchemeInstance.id}">Back to Show</g:link></li>
	       	</ul>
                <script type="text/javascript">
                    
                    function sendFormCallAlertify(){
                        alertify.confirm(AppTitle,"Are you sure want to update this?",
                        
                        function(){
                          checkIfAllowed('CFG01003', 'form#DepositInterestSchemeForm', 'Override Change Interest Rate', null); // params: policyTemplate.code, form to be saved
                        },
                        function(){
                          alertify.error('Canceled!');
                        });
                    }
                </script>
            </content>
	</body>
</html>
