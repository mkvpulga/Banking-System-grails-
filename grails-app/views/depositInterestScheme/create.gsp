<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme')}" />
		<title>Create Deposit Interest Scheme</title>
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
		<div id="create-depositInterestScheme" class="content scaffold-create" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${depositInterestSchemeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${depositInterestSchemeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form id="DepositInterestSchemeForm" url="[resource:depositInterestSchemeInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					
				</fieldset>
			</g:form>
		</div>
            </content>
            <content tag="main-actions">
                <ul>
                    <li><g:submitButton name="create" id="newDepositIntScheme" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01002', 'form#DepositInterestSchemeForm', 'Override new Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                            
                        "/></li>
                    <!--<li><a href="#" onclick="$('#DepositInterestSchemeForm').submit()">Create</a></li>-->
                    <li><g:link class="list" action="index">Back to List</g:link>
                    
                </ul>
                <!--
                <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#newDepositIntScheme" ).click(function() {
                                 checkIfAllowed('CFG01002', 'form#DepositInterestSchemeForm', 'Override new Deposit Interest Scheme.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script>
                -->
            </content>
	</body>
</html>