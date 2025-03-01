
<%@ page import="icbs.admin.CustomerGroup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customerGroup.label', default: 'CustomerGroup')}" />
		<title>Customer Group Information</title>
	</head>
	<body>
		<content tag="main-content">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list customerGroup">
			
				<g:if test="${customerGroupInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="customerGroup.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${customerGroupInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerGroupInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="customerGroup.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${customerGroupInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerGroupInstance?.configItemStatus}">
				<li class="fieldcontain">
					<span id="configItemStatus-label" class="property-label"><g:message code="customerGroup.configItemStatus.label" default="Config Item Status" /></span>
					
						<span class="property-value" aria-labelledby="configItemStatus-label">${customerGroupInstance?.configItemStatus?.description}</span>
					
				</li>
				</g:if>
			
			</ul>
                        <g:form id="delete" url="[resource:customerGroupInstance, action:'delete']" method="DELETE">
                        </g:form>
		</content>

		<content tag="main-actions">
			<ul>
                            <li><g:link class="create" action="create"><g:message code="default.new.customerGroup" args="[entityName]" default="New Customer Group" /></g:link></li>
                            <li><g:link class="btn btn-primary" action="edit" resource="${customerGroupInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
                            <li><g:actionSubmit id="deleteCustomerGroup" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></li>
			</ul>
                        <script type="text/javascript">
                            $(document).ready(function() {
                                $( "#deleteCustomerGroup" ).click(function() {
                                         checkIfAllowed('CFG00604', 'form#delete', 'Override new Customer Group.', null); // params: policyTemplate.code, form to be saved
                                });
                            }); 
                        </script>
		</content>
	</body>
</html>
