<%@ page import="icbs.loans.PenaltyIncomeScheme" %>
<%@ page import="icbs.lov.LoanPenaltyBasis" %>
<%@ page import="icbs.lov.LoanPenaltyFreq" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<%@ page import="icbs.admin.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'penaltyIncomeScheme.label', default: 'PenaltyIncomeScheme')}" />
		<title>View Penalty Income Scheme</title>		
	</head>
	<body>
		<content tag="main-content">
		<div class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
			<div class="nav-tab-container">
          		<ul class="nav nav-tabs">
            		<li class="active"><a href="#tab_1" data-toggle="tab">Details</a></li>
            		<li><a href="#tab_2" data-toggle="tab">Products</a></li>
          		</ul>
          	</div>
          	<div class="tab-content">
    			<div class="tab-pane active fade in" id="tab_1">
                            <div class="section-container">
                                <fieldset>
                                <legend class="section-header">Penalty Income Scheme Details </legend>
                                 <table class="table table-bordered table-striped">
                                    <tbody>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Code</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="code"/></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Name</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="name"/></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Basis</td>
                                            <td width="70%">${penaltyIncomeSchemeInstance?.basis?.description}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Type</td>
                                            <td width="70%">${penaltyIncomeSchemeInstance?.type?.description}</td>
                                        </tr>
                                        <g:if test="${penaltyIncomeSchemeInstance.type.id == 1}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Frequency</td>
                                            <td width="70%">${penaltyIncomeSchemeInstance?.frequency?.description}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Default Penalty Amount</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="defaultPenaltyAmount"/></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Minimum Penalty Amount</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="minPenaltyAmount"/></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Maximum Penalty Amount</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="maxPenaltyAmount"/></td>
                                        </tr>
                                        </g:if>
                                        <g:elseif test="${penaltyIncomeSchemeInstance.type.id == 2}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Default Penalty Rate</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="defaultPenaltyRate"/>%</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Minimum Penalty Rate</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="minPenaltyRate"/>%</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Maximum Penalty Rate</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="maxPenaltyRate"/>%</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Divisor</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="divisor"/></td>
                                        </tr>
                                       </g:elseif>         
                                       <tr>
                                            <td style="font-weight:bold" width="30%">Grace Period</td>
                                            <td width="70%"><g:fieldValue bean="${penaltyIncomeSchemeInstance}" field="gracePeriod"/></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Changeable Penalty Rate</td>
                                            <td width="70%"><g:formatBoolean boolean="${penaltyIncomeSchemeInstance?.canChangePenaltyRate}" /></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Weekend Mode</td>
                                            <td width="70%"><g:formatBoolean boolean="${penaltyIncomeSchemeInstance?.hasWeekendMode}" /></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Status</td>
                                            <td width="70%">${penaltyIncomeSchemeInstance?.status?.description}</td>
                                        </tr>
                                    </tbody>
                                </table>
                                </fieldset>
                            </div>                            
					
				</div>
				<div class="tab-pane fade in" id="tab_2">	
                                    <table class="table table-bordered table-rounded table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <g:sortableColumn property="code" title="${message(code: 'product.code.label', default: 'Code')}" />
                                                <g:sortableColumn property="name" title="${message(code: 'product.description.label', default: 'Product Name')}" />
                                            </tr>    
                                        </thead>   
                                        <tbody>
                                            <g:each in="${penaltyIncomeSchemeInstance.products}" status="i" var="product">
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="Product" action="show" id="${product.id}">${product.code}</g:link></td>
                                                    <td>${product.name}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>    				
	
				</div>						
			</div>
			<%--<g:form url="[resource:penaltyIncomeSchemeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${penaltyIncomeSchemeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-primary delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>--%>
		</div>
		</content>
		<content tag="main-actions">
      		<ul>
      			<li><g:link class="list" action="index">Search Penalty Income Scheme</g:link></li>
                <li><g:link action="edit" controller="penaltyIncomeScheme" id="${penaltyIncomeSchemeInstance.id}">Update Penalty Income Scheme</g:link></li>

                <g:if test="${penaltyIncomeSchemeInstance.status.id == 1}">
                <li><g:form id="activate" url="[resource:penaltyIncomeSchemeInstance, action:'activate']" method="POST">
                    </g:form>
                     <g:actionSubmit id="activatePenaltyIncomeScheme" action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </li>
                </g:if>

                <g:if test="${penaltyIncomeSchemeInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form id="delete" url="[resource:penaltyIncomeSchemeInstance, action:'delete']" method="POST">
                        </g:form>
                        <g:actionSubmit id="deletePenaltyIncomeScheme" action="delete" value="Delete" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01104', 'form#delete', 'Override New Penalty Income Scheme.', null);
                                },
                                function(){
                                    return;
                                });                               
                            " />
                    </li>
                </g:if>
	       	</ul>
                <script type="text/javascript">
                    $(document).ready(function() {
                        //$( "#deletePenaltyIncomeScheme" ).click(function() {
                        //         checkIfAllowed('CFG01104', 'form#delete', 'Override New Penalty Income Scheme.', null); // params: policyTemplate.code, form to be saved
                        //});
                        $( "#activatePenaltyIncomeScheme" ).click(function() {
                                 checkIfAllowed('CFG01103', 'form#activate', 'Override New Penalty Income Scheme.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script> 
	    </content>
	</body>
</html>
