

<!DOCTYPE html>
<html>
	<head>
            <meta name="layout" content="main">
            <title>Atm Message Response Details</title>
	</head>
	<body>
            <content tag="main-content">
                <div id="show-currency" class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Atm Message Response Details </legend>
                         <table class="table table-bordered table-striped" style="table-layout: fixed;">
                            <tbody>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Destination IP Address</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmResponseInstance?.destinationIp}</td>
                                </tr> 
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Atm Message Length</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmResponseInstance?.msgLength}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Date Sent</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmRequestInstance?.dateSent}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">Message Content</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmResponseInstance?.msgContent}</td>
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
                    <li><g:link action="viewAtmMsgResponse">Return to Message Response List</g:link></li>
                    <li><g:link action="viewAtmMsgRequest" controller="ATMInterface" >View Request Message List</g:link></li>
                </ul>
            </content>

	</body>
</html>
