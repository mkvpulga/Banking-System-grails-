


<%@ page import="icbs.tellering.TxnFile" %>
<!DOCTYPE html>


<html>
    <head>

	<meta name="layout" content="main">
	<title>Txn File Details</title>
    </head>
    <body>
        
  		
        <content tag="main-content">   
                        
			
                <div class="section-container">
                    <fieldset>
                    <legend class="section-header"> Txn File Details </legend>
                     <table class="table table-bordered table-striped">
                        <tbody>
                            <g:each in="${aa}" var="branchInstance">
                            <tr>
                                <td style="font-weight:bold" width="30%">ID</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "id")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Account No</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "acctNo")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Account Status</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "acctStatus.description")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Branch</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "branch.name")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">CHD</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "chd")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Currency</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "currency.name")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Deposit Account ID</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "depAcctId")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Sender ID</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "senderId")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Status</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "status.description")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${fieldValue(bean: branchInstance, field: "txnAmt")}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Code</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnCode")}</td>
                            </tr>

                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Date</td>
                                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${branchInstance?.txnDate}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Description</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnDescription")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Particulars</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnParticulars")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnRef")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Template</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnTemplate.description")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Timestamp</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnTimestamp")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Type</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "txnType.description")}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">USER ID</td>
                                <td width="70%">${fieldValue(bean: branchInstance, field: "userId")}</td>
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
                <li><g:link controller="ATMInterface" action="atmTxnDetails" id="${params.atmtxnid}"  params="['atmtxnid': params.atmtxnid]">View ATM Transaction Details</g:link></li>
                
            </ul>
        </content>
    </body>
</html>

