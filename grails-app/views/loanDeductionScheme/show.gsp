<%@ page import="icbs.loans.LoanDeductionScheme" %>
<%@ page import="icbs.lov.LoanDeductionCalculationType" %>
<%@ page import="icbs.lov.LoanDeductionSpecialCalculation" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<%@ page import="icbs.admin.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanDeductionScheme.label', default: 'LoanDeductionScheme')}" />
		<title>View Loan Deduction Scheme</title>
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
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                 
                                <tbody>
                                    <tr>
                                        <td style="width: 30%;"><label>Code</label></td>
                                        <td style="width: 70%;"><g:fieldValue bean="${loanDeductionSchemeInstance}" field="code"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width: 30%;"><label>Name</label></td>
                                        <td style="width: 70%;"><g:fieldValue bean="${loanDeductionSchemeInstance}" field="name"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width: 30%;"><label>Description</label></td>
                                        <td style="width: 70%;"><g:fieldValue bean="${loanDeductionSchemeInstance}" field="description"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width: 30%;"><label>Special Calculation</label></td>
                                        <td style="width: 70%;">${loanDeductionSchemeInstance?.specialCalculation?.description}</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 30%;"><label>Type</label></td>
                                        <td style="width: 70%;">${loanDeductionSchemeInstance?.type?.description}</td>
                                    </tr>
                                    <g:if test="${loanDeductionSchemeInstance.type.id == 1}">
                                    <tr>
                                        <td style="width: 30%;"><label>Amount</label></td>
                                        <td style="width: 70%;"><g:formatNumber format="###,###,##0.00" number="${loanDeductionSchemeInstance?.amount}"/></td>
                                    </tr>
                                    </g:if>
                                    <g:elseif test="${loanDeductionSchemeInstance.type.id == 2}">
                                    <tr>
                                        <td style="width: 30%;"><label>Rate</label></td>
                                        <td style="width: 70%;"><g:formatNumber format="###,###,##0.00" number="${loanDeductionSchemeInstance?.rate}"/> %</td>
                                    </tr>  
                                                                            <%--
					<div class="fieldcontain form-group">
						<label class="control-label col-sm-4"><g:message code="loanDeductionScheme.divisor.label" default="Divisor" /></label>
						<span><g:fieldValue bean="${loanDeductionSchemeInstance}" field="divisor"/></span>
					</div> --%>
                                    </g:elseif> 
                                    <tr>
                                        <td style="width: 30%;"><label>EIR Mode</label></td>
                                        <td style="width: 70%;"><g:formatBoolean boolean="${loanDeductionSchemeInstance?.hasEirMode}" /></td>
                                    </tr>   
                                    <tr>
                                        <td style="width: 30%;"><label>GL Contra Account</label></td>
                                        <td style="width: 70%;">${loanDeductionSchemeInstance?.contraAcct?.name}</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 30%;"><label>Status</label></td>
                                        <td style="width: 70%;">${loanDeductionSchemeInstance?.status?.description}</td>
                                    </tr>
                                </tbody>    
                            </table> 
					
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
                                            <g:each in="${loanDeductionSchemeInstance.products}" status="i" var="product">
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="Product" action="show" id="${product.id}">${product.code}</g:link></td>
                                                    <td>${product.name}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>    				
				</div>	
			</div>
			<%--<g:form url="[resource:loanDeductionSchemeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${loanDeductionSchemeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-primary delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>--%>
		</div>
		</content>
		<content tag="main-actions">
      		<ul>
      			<li><g:link class="list" action="index">Search Loan Deduction Scheme</g:link></li>
                <li><g:link action="edit" controller="loanDeductionScheme" id="${loanDeductionSchemeInstance.id}">Update Loan Deduction Scheme</g:link></li>

                <g:if test="${loanDeductionSchemeInstance.status.id == 1}">
                <li><g:form id="activate" url="[resource:loanDeductionSchemeInstance, action:'activate']" method="POST">
                    </g:form>
                    <g:actionSubmit id="activateLoanDeductionScheme" action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </li>
                </g:if>

                <g:if test="${loanDeductionSchemeInstance.status.id.toInteger() in [1, 2]}">
                <li><g:form id="delete" url="[resource:loanDeductionSchemeInstance, action:'delete']" method="POST">       
                    </g:form>
                    <g:actionSubmit id="deleteLoanDeductionScheme" action="delete" value="Delete" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01303', 'form#delete', 'Override new Check Deposit Clearing Type.', null);
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
                        //$( "#deleteLoanDeductionScheme" ).click(function() {
                        //         checkIfAllowed('CFG01303', 'form#delete', 'Override new Check Deposit Clearing Type.', null); // params: policyTemplate.code, form to be saved
                        //});
                        $( "#activateLoanDeductionScheme" ).click(function() {
                                 checkIfAllowed('CFG01303', 'form#activate', 'Override new Check Deposit Clearing Type.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script>
	    </content>
	</body>
</html>
