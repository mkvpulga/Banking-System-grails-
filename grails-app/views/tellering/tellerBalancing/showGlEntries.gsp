<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.gl.GlAccount" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>View GL Entries</title>
    </head>
    <body>
        <content tag="main-content">
            <div class="section-container">
                <fieldset>            
                    <legend class="section-header">Transaction Information</legend>
                    <table class="table table-bordered table-striped">
                        <tbody>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Number</td>
                                <td width="70%">${txnFileInstance?.id}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Type</td>
                                <td width="70%">${txnFileInstance?.txnTemplate?.description}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                <td width="70%"><g:formatNumber number="${txnFileInstance?.txnAmt}" format="###,###,##0.00" /></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                <td width="70%">${txnFileInstance?.txnRef}</td>
                            </tr>

                        </tbody>
                    </table>
                </fieldset>
            </div>
            <div id="grid">
                <div class="table-responsive">
                    <table class="table table-hover table-condensed table-bordered table-striped">
                        <tbody>
                            <tr>    
                                <td><label>Debit Account</label></td>                    
                                <td><label>Debit Amount</label></td>          
                                <td><label>Credit Account</label></td>
                                <td><label>Credit Amount</label></td>
                            </tr>
                        </tbody>   
                        <tbody>
                            <g:each in="${glEntries}" status="i" var="gl">
                                <tr>   
                                    <td>
                                        <g:if test="${gl?.debitAcct}">
                                            ${gl?.debitAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name}
                                        </g:if>    
                                    </td>
                                    <td><g:formatNumber number="${gl.debitAmt}" format="###,###,##0.00" /></td>
                                    <td>
                                        <g:if test="${gl?.creditAcct}">
                                            ${gl?.creditAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name}
                                        </g:if>
                                    </td>
                                    <td><g:formatNumber number="${gl.creditAmt}" format="###,###,##0.00" /></td>
                                </tr>
                            </g:each>                                
                        </tbody>
                    </table>
              </div>
            </div>    
        </content>    
        <content tag="main-actions">
            <ul>
                <li><g:link action="Index">Tellering Index</g:link></li>
                <li><g:link action="viewTellerBalancing">Teller Balancing</g:link></li>
                <li><g:link action="viewTellerOtherTxn">View Non-Cash Transactions</g:link></li>
            </ul>
        </content>        
    </body>    
</html>
