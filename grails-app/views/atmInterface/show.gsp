

<!DOCTYPE html>
<html>
	<head>
            <meta name="layout" content="main">
            <title>ATM Terminal Information</title>
	</head>
	<body>
            <content tag="main-content">
                <div id="show-currency" class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Atm Terminal Details </legend>
                         <table class="table table-bordered table-striped">
                            <tbody>
                                <g:if test="${atmTerminalInstance?.terminalCode}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Terminal Code</td>
                                    <td width="70%"><g:fieldValue bean="${atmTerminalInstance}" field="terminalCode"/></td>
                                </tr>  
                                </g:if>
                                <g:if test="${atmTerminalInstance?.remarks}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Remarks</td>
                                    <td width="70%"><g:fieldValue bean="${atmTerminalInstance}" field="remarks"/></td>
                                </tr>  
                                </g:if>
                                <g:if test="${atmTerminalInstance?.branch}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Assigned Branch</td>
                                    <td width="70%">${atmTerminalInstance?.branch?.name}</td>
                                </tr>  
                                </g:if>
                                <g:if test="${atmTerminalInstance?.terminalStatus}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Terminal Status</td>
                                    <td width="70%">${atmTerminalInstance?.terminalStatus?.description}</td>
                                </tr>  
                                </g:if>

                            </tbody>
                        </table>
                        </fieldset>
                    </div>                    

                </div>
            </content>	
            
            <content tag="main-actions">
                <ul>
                <g:if test="${atmTerminalInstance.terminalStatus.id == 3}">   
                    <li><button class="disabled">Edit</button></li>
                </g:if>
                <g:else>
                    <li><g:link action="editTerminal" controller="ATMInterface" id="${atmTerminalInstance.id}" >Edit</g:link></li>
               </g:else>
                <li><button onclick="atmdeleteTerminal()">Delete/Disable</button></li>
                <li><g:link action="atmTerminalView" >List</g:link></li>
                <g:form name="atmDeleteform" id="atmDeleteform" url="[action:'deleteTerminal',controller:'ATMInterface']">
                    <g:hiddenField name="id" id="id" value="${atmTerminalInstance.id}" />
                </g:form>
                <script>
                    function atmdeleteTerminal(){
                        alertify.confirm(AppTitle,"Are you sure you want to delete this?",
                            function(){
                                $('#atmDeleteform').submit();
                            },
                            function(){
                              alertify.error('Canceled!');
                            });
                    }
                </script>
            </ul>
            </content>

	</body>
</html>
