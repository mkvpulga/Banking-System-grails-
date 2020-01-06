


<!DOCTYPE html>


<html>
    <head>

	<meta name="layout" content="main">
	<title>Atm Txn Details</title>
    </head>
    <body>
        
  		
        <content tag="main-content">   
                <div class="section-container">
                    <fieldset>
                    <legend class="section-header"> ATM Details </legend>
                     <table class="table table-bordered table-striped">
                        <tbody>
                            <g:each in="${atmTxnInstanceList}" status="i" var="atmDetails">
                            <tr>
                                <td style="font-weight:bold" width="30%">ID</td>
                                <td width="70%">${atmDetails.id}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Account1</td>
                                <td width="70%">${atmDetails.acct1}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Account2</td>
                                <td width="70%">${atmDetails?.acct2}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">ATM Card Number</td>
                                <td width="70%">${atmDetails?.atmCardNumber}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">ATM Terminal</td>
                                <td width="70%">${atmDetails?.atmTerminal}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Balance1</td>
                                <td width="70%"><g:formatNumber format="###,##0.00" number="${atmDetails?.bal1}" /></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Balance2</td>
                                <td width="70%"><g:formatNumber format="###,##0.00" number="${atmDetails?.bal2}" /></td>
                            </tr>

                            <tr>
                                <td style="font-weight:bold" width="30%">MTI</td>
                                <td width="70%">${atmDetails?.mti}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Request Message ID</td>
                                <td width="70%"><g:link   controller="ATMInterface" action="viewAtmMsgRequest" id="${atmDetails.requestMsgId}" params="['atmtxnid': atmDetails.requestMsgId]">View Details</g:link></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Response Date</td>
                                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${atmDetails?.responseDate}"/></td>
                            </tr>
                             <tr>
                                <td style="font-weight:bold" width="30%">Response Message ID</td>
                                <td width="70%"><g:link controller="ATMInterface" action="viewAtmMsgResponse" id="${atmDetails.responseMsgId}" params="['atmtxnid': atmDetails.responseMsgId]">View Details</g:link></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Is Reversed</td>
                                <td width="70%">${atmDetails?.isReversed}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Reversal Date</td>
                                <td width="70%">${atmDetails?.reversalDate}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Status</td>
                                <td width="70%">${atmDetails?.statusId}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                <td width="70%"><g:formatNumber format="###,##0.00" number="${atmDetails?.txnAmt}" /></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Charge Amount</td>
                                <td width="70%"><g:formatNumber format="###,##0.00" number="${atmDetails?.txnChargeAmt}" /></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Charge Amount</td>
                                <td width="70%"><g:formatNumber format="###,##0.00" number="${atmDetails?.txnChargeAmt}" /></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Code </td>
                                <td width="70%">${atmDetails?.txnCode}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Date </td>
                                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${atmDetails?.txnDate}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction File ID 1 </td>
                                <td width="70%"><g:link controller="ATMInterface" action="viewAtmTxnFile" id="${atmDetails.txnFile1}" params="['atmtxnid': atmDetails.txnFile1]">View Details</g:link></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction File ID 2 </td>
                                <td width="70%"><g:link  controller="ATMInterface" action="viewAtmTxnFile" id="${atmDetails.txnFile2}" params="['atmtxnid': atmDetails.txnFile2]">View Details</g:link></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                <td width="70%">${atmDetails?.txnRef}</td>
                            </tr>
                            </g:each>


                        </tbody>
                    </table>
                    </fieldset>
                </div>     

            </content>
            

        <content tag="main-actions">
            <ul>

                    <!--
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    -->
                <li><g:link action="atmTerminalView">View ATM Terminals</g:link></li>
            </ul>
        </content>
    </body>
</html>

