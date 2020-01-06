<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>ATM Transaction Details</title>
    </head>
    <body>
        <content tag="main-content">
            <div id="show-currency" class="content scaffold-show" role="main">
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <ul class="property-list atmTxn">

                </ul>
            </div>
            <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Atm Terminal Details </legend>
                         <table class="table table-bordered table-striped" style="table-layout: fixed;">
                            <tbody>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">ATM TXN ID</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmTxnDetalisInstance?.id}</td>
                                </tr>  
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Transaction Date</td>
                                    <td width="70%">${atmTxnDetalisInstance?.txnDate}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">ATM Request Message</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmTxnDetalisInstance?.requestMsg?.msgContent}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Request Date</td>
                                    <td width="70%">${atmTxnDetalisInstance?.responseDate}</td>
                                </tr>
                                 <tr>
                                    <td style="font-weight:bold" width="30%" style="word-wrap:break-word;">ATM Response Message</td>
                                    <td width="70%" style="word-wrap:break-word;">${atmTxnDetalisInstance?.responseMsg?.msgContent}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Response Date</td>
                                    <td width="70%">${atmTxnDetalisInstance?.responseMsg?.dateSent}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Transaction Code</td>
                                    <td width="70%">${atmTxnDetalisInstance?.txnCode}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">MTI</td>
                                    <td width="70%">${atmTxnDetalisInstance?.mti}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Card Number</td>
                                    <td width="70%">${atmTxnDetalisInstance?.atmCardNumber}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">ATM Terminal</td>
                                    <td width="70%">${atmTxnDetalisInstance?.atmTerminal}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Account Number 1</td>
                                    <td width="70%">${atmTxnDetalisInstance?.acct1}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Account Number 2</td>
                                    <td width="70%">${atmTxnDetalisInstance?.acct2}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                    <td width="70%">${atmTxnDetalisInstance?.txnRef}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                    <td width="70%"><g:formatNumber format="###,###,##0.00" number="${atmTxnDetalisInstance?.txnAmt}"/></td>
                                </tr>
                                <g:if test="${atmTxnDetalisInstance?.txnChargeAmt > 0}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Charge Amount</td>
                                    <td width="70%"><g:formatNumber format="###,###,##0.00" number="${atmTxnDetalisInstance?.txnChargeAmt / 100}"/></td>
                                </tr>
                                </g:if>
                                <g:else>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Charge Amount</td>
                                    <td width="70%"><g:formatNumber format="###,###,##0.00" number="${atmTxnDetalisInstance?.txnChargeAmt}"/></td>
                                </tr>
                                </g:else>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Status</td>
                                    <td width="70%">${atmTxnDetalisInstance?.status?.description}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">is Transaction reverse</td>
                                    <td width="70%">${atmTxnDetalisInstance?.isReversed}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction File ID</td>
                                    <td width="70%"><g:link action="viewAtmTxnFile" controller="ATMInterface" id="${atmTxnDetalisInstance?.txnFile1}" params="['atmtxnid': params.id]">${atmTxnDetalisInstance?.txnFile1}</g:link></td>
                                </tr>
                            </tbody>
                        </table>
                        </fieldset>
                    </div>  
        </content>	
        <content tag="main-actions">
            <ul>
                <li><g:link action="index" controller="ATMInterface" >Return to ATM Interface Index</g:link></li>
                <li><g:link action="viewRequestDetails" controller="ATMInterface" >View Request Message Details</g:link></li>
                <li><g:link action="viewResponseDetails" controller="ATMInterface" >View Response Message Details</g:link></li>
            </ul>
        </content>
    </body>
</html>
