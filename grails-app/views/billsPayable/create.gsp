<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Create New Bills Payable Subsidiary Ledger</title>
    </head>
    <body>
	<content tag="main-content">
            <div id="create-billsPayable" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${billsPayableInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${billsPayableInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
		<g:form id="create" url="[resource:billsPayableInstance, action:'save']" >
                    <fieldset class="form">
			<g:render template="form"/>
                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
		<li><g:submitButton id="newBP" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue create Bills Payable ledger?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#create', 'Create New Bills Payable Ledger', null); 
                                },
                                function(){
                                    return;
                            }); 
                "/></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
