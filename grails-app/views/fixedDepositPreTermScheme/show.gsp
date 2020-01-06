<%@ page import="icbs.deposit.FixedDepositPreTermScheme" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fixedDepositPreTermScheme.label', default: 'FixedDepositPreTermScheme')}" />
		<title>Show Fixed Deposit Pre-Term Scheme</title>
	</head>
	<body>
            <content tag="main-content">   
		<div id="show-fixedDepositPreTermScheme" class="content scaffold-show" role="main">
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
                                <li class="active"><a href="#tab_1" data-toggle="tab">Fixed Deposit Pre-Term Scheme Details</a></li>
                                <li><a href="#tab_2" data-toggle="tab">Fixed Deposit Pre-Term Scheme Product Details</a></li>
                                 
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane active fade in" id="tab_1">
                                <div class="section-container">
                                    <fieldset>
                                    <legend class="section-header"> Fixed Deposit Pre-Term Scheme Details </legend>
                                     <table class="table table-bordered table-striped">
                                        <tbody>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.code}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Code</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="code"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.description}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Description</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="description"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.type}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Type</td>
                                                <td width="70%">${fixedDepositPreTermSchemeInstance?.type?.encodeAsHTML()}</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.rate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Rate</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="rate"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.term1stHalf}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Term 1st Half</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="term1stHalf"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.term2ndHalf}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Term 2nd Half</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="term2ndHalf"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.divisor}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Divisor</td>
                                                <td width="70%"><g:fieldValue bean="${fixedDepositPreTermSchemeInstance}" field="divisor"/></td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.status}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Status</td>
                                                <td width="70%">${fixedDepositPreTermSchemeInstance?.status?.encodeAsHTML()}</td>
                                            </tr>
                                            </g:if>
                                            <g:if test="${fixedDepositPreTermSchemeInstance?.isGradeRate}">
                                            <tr>
                                                <td style="font-weight:bold" width="30%">Is Grade Rate</td>
                                                <td width="70%"><g:formatBoolean boolean="${fixedDepositPreTermSchemeInstance?.isGradeRate}" /></td>
                                            </tr>
                                            </g:if>

                                        </tbody>
                                    </table>
                                    </fieldset>
                                </div>                                

                            </div>
                            <div class="tab-pane fade in" id="tab_2">
                                            <span id="products-label" class="property-label"><h3>Products</h3></span>
                                    <table class="table table-bordered table-rounded table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <g:sortableColumn property="code" title="${message(code: 'product.code.label', default: 'Code')}" />
                                                <g:sortableColumn property="name" title="${message(code: 'product.description.label', default: 'Product Name')}" />
                                            </tr>    
                                        </thead>   
                                        <tbody>
                                            <g:each in="${fixedDepositPreTermSchemeInstance.products}" status="i" var="product">
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td><g:link controller="Product" action="show" id="${product.id}">${product.code}</g:link></td>
                                                    <td>${product.name}</td>
                                                </tr>
                                            </g:each>
                                        </tbody>    
                                    </table>    				
                            </div>    
                        </div>        

		</div>
            </content>
             <content tag="main-actions">
                <ul>
      			<li><g:link class="list" action="index">Fixed Deposit Pre-Term Scheme List</g:link></li>
      			<li><g:link class="create" action="create">New Fixed Deposit Pre-Term Scheme</g:link></li>
                <li><button disabled="disabled">View Fixed Deposit Pre-Term Scheme</button></li>
                <li><g:link action="edit" controller="FixedDepositPreTermScheme" id="${fixedDepositPreTermSchemeInstance.id}">Update Fixed Deposit Pre-Term Scheme</g:link></li>

                <g:if test="${fixedDepositPreTermSchemeInstance.status.id == 1}">
                <li><g:form url="[id:fixedDepositPreTermSchemeInstance.id, action:'activate']" method="POST">
					<g:actionSubmit action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</g:form></li>
                </g:if>

                <g:if test="${fixedDepositPreTermSchemeInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form id="deleteFixedDepositPreTermSchemeForm" url="[id:fixedDepositPreTermSchemeInstance.id, action:'delete']" method="POST">                                           
                        </g:form>
                        <g:actionSubmit id="deleteFixedDepositPreTermScheme" action="delete" value="Delete" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00903', 'form#deleteFixedDepositPreTermSchemeForm', 'Override delete Fixed Deposit PreTerm Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                             
                            " />
                    </li>
                </g:if>
	       	</ul>
                <!--
                <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#deleteFixedDepositPreTermScheme" ).click(function() {
                                 checkIfAllowed('CFG00903', 'form#deleteFixedDepositPreTermSchemeForm', 'Override new Fixed Deposit PreTerm Scheme.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script>
                -->
            </content>
	</body>
</html>
