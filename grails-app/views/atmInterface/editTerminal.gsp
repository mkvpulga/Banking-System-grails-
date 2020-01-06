
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		
		<title>Edit ATM Terminal Information</title>
	</head>
	<body>
		<content tag="main-content">	
                    <g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
                    </g:if>
                    
                    <g:form id="editatmTerminal" url="[action:'updateTerminal',controller:'ATMInterface']" method="POST" >
			<g:hiddenField name="version" value="${atmTerminalInstance?.version}" />
			<fieldset class="form">
                            <g:render template="terminalform"/>
			</fieldset>
                    </g:form>
		</content>
		<content tag="main-actions">
			<ul>
				<li><button onclick="funcAlertify();">Update</button> </li>
				<li><g:link action="atmTerminalView"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
                                <script>
                                    function funcAlertify(){
                                        alertify.confirm(AppTitle,'Are you sure you want to update ATM Terminal Information?',
                                        function(){
                                            checkIfAllowed('ADM00103', 'form#editatmTerminal', 'Edit Terminal.', null); // params: policyTemplate.code, form to be saved
                                        },
                                        function(){
                                            return;
                                        }); 
                                    }
                                </script>
			</ul>
		</content>
	</body>
</html>
