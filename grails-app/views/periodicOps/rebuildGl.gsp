<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
        <title>Periodic Operations Utilities - Rebuild General Ledger</title>
    </head>
    <body>

        <content tag="main-content">
            <h3>Rebuild General Ledger from Cut-Off Date</h3>
            <g:if test="${flash.message}">
                <script>
                        $(function(){
                            var x = '${flash.message}';
                                notify.message(x);
                        });
                </script>
            </g:if>

            <g:form id="create" name="create" action="saveNewGl" 
                onsubmit="return alertify.alert('Express-O','Please wait... Processing....')">
                <div class="fieldcontain form-group" >
                    <div class="col-sm-8"><g:customDatePicker name="cutOffDate" precision="day" class="form-control" />
                    </div>             
                </div>                
            </g:form>
        </content>
        <content tag="main-actions">
            <ul>
		<li><g:submitButton id="rGl" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue rebuild general ledger?',
                            function(){
                                    checkIfAllowed('GEN00202', 'form#create', 'Rebuild General Ledger', null); 
                                },
                                function(){
                                    return;
                            }); 
                "/></li>
                <li><g:link controller="periodicOps" action="index">Periodic Operations Index</g:link></li>
            </ul>
        </content>
    </body>
</html>
