

<!DOCTYPE html>
<html>
	<head>
            <meta name="layout" content="main">
            <title>Atm Message Request Details</title>
	</head>
	<body>
            <content tag="main-content">
                <div id="show-currency" class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Atm Message Request Details </legend>
                         <table class="table table-bordered table-striped" style="table-layout: fixed;">
                            <tbody>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Source IP Address</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmRequestInstance?.sourceIp}</td>
                                </tr> 
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Atm Message Length</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmRequestInstance?.msgLength}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Date Received</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmRequestInstance?.dateReceived}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Message Content</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmRequestInstance?.msgContent}</td>
                                </tr>
                                
                            </tbody>
                        </table>
                        </fieldset>
                    </div>   
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header">Message Content Element and Values</legend>
                         <table class="table table-bordered table-striped" style="table-layout: fixed;">
                            <tbody>
                                
                                
                            </tbody>
                        </table>
                        </fieldset>
                    </div>

                </div>
            </content>	

            <content tag="main-actions">
                <ul>
                    <li><g:link action="index" controller="ATMInterface" >Return to ATM Interface Index</g:link></li>
                    <li><g:link action="viewAtmMsgRequest">Return to Message Request List</g:link></li>
                    <li><g:link action="viewResponseDetails" controller="ATMInterface" >View Response Message List</g:link></li>
                </ul>
            </content>

	</body>
</html>
