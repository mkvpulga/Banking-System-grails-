
<%@ page import="icbs.tellering.SssOnlinePaymentDetail" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'sssOnlinePaymentDetail.label', default: 'sssOnlinePaymentDetail')}" />
	<title>SSS e-Collection Transaction Details</title>
    </head>
    <body>
        <content tag="main-content">   
            <script>
                 function sssTransactionSlip(){
                    var w = window.open("${g.createLink(controller: 'sssCollection', action: 'sssPrintTransactionSlip', params: [txnFile:sssOnlinePaymentDetailInstance.txnFile.id])}",'_blank');
                    w.print();        
                }
                function sssIndividualTransactionSlip(){
                    var w = window.open("${g.createLink(controller: 'sssCollection', action: 'sssIndividualPrintTransactionSlip', params: [txnFile:sssOnlinePaymentDetailInstance.txnFile.id])}",'_blank');
                    w.print();
                }
            </script>    
            <div id="show-sssOnlinePaymentDetail" class="content scaffold-show" role="main">
		<g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>

                <table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>
                        <g:if test="${sssOnlinePaymentDetailInstance.brnum}">
                            <tr>
                                <td style="width:30%"><label>Payment Reference Number</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.brnum}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Date and Time of Reply</label></td>
                                <td style="width:70%"><g:formatDate  format="MM/dd/yyyy hh:mm:ss.ss" date="${sssOnlinePaymentDetailInstance.replyDate}" /></td>
                            </tr>	
                            <tr>
                                <td style="width:30%"><label>Employer SSS ID</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.ernum}</td>
                            </tr>	 
                            <tr>
                                <td style="width:30%"><label>Employer Name</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.ername}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Employer Branch Code</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.erbrn}</td>
                            </tr>                            <tr>
                                <td style="width:30%"><label>Billing Amount</label></td>
                                <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${sssOnlinePaymentDetailInstance?.amount}"/></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Applicable Month</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.appmo}</td>
                            </tr>                            
                        </g:if>
                        <g:else>
                            <tr>
                                <td style="width:30%"><label>Payment Reference Number</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.indiIprnum}</td>
                            </tr>     
                            <tr>
                                <td style="width:30%"><label>Date and Time of Reply</label></td>
                                <td style="width:70%"><g:formatDate  format="MM/dd/yyyy hh:mm:ss.ss" date="${sssOnlinePaymentDetailInstance.replyDate}" /></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Member SSS Number</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.indiEenum}</td>
                            </tr> 
                            <tr>
                                <td style="width:30%"><label>Member Name</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.indiEename}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Payor Type</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.indiPayorType}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Transaction Amount</label></td>
                                <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${sssOnlinePaymentDetailInstance?.amount}"/></td>
                            </tr> 
                            <tr>
                                <td style="width:30%"><label>Flexi Amount</label></td>
                                <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${sssOnlinePaymentDetailInstance?.flexiAmt}"/></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Monthly Contribution Amount</label></td>
                                <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${sssOnlinePaymentDetailInstance?.monthlyContribution}"/></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>From (Applicable Month)</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.fapid}</td>
                            </tr>  
                            <tr>
                                <td style="width:30%"><label>To (Applicable Month)</label></td>
                                <td style="width:70%">${sssOnlinePaymentDetailInstance.tapid}</td>
                            </tr>                            
                        </g:else>
                        <tr>
                            <td style="width:30%"><label>SSS Transaction No</label></td>
                            <td style="width:70%">${sssOnlinePaymentDetailInstance.indiTxnNumber}</td>
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Transaction ID</label></td>
                            <td style="width:70%"><g:link controller="tellering" action="showGlEntries" id="${sssOnlinePaymentDetailInstance.txnFile.id}">${sssOnlinePaymentDetailInstance.txnFile.id}</g:link></td>
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Transaction Date</label></td>
                            <td style="width:70%"><g:formatDate  format="MM/dd/yyyy" date="${sssOnlinePaymentDetailInstance?.txnFile?.txnDate}" /></td>
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Transact By</label></td>
                            <td style="width:70%">${sssOnlinePaymentDetailInstance?.txnFile?.user?.username}</td>
                        </tr> 
                    </tbody>
                </table>
                <g:if test="${sssOnlinePaymentDetailInstance.brnum}">
                <div id="SlipTransaction" class="alert alert-success alert-dismissable" role="alert">
                   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <div> 
                            <a onclick="javascript:sssTransactionSlip()">
                                <g:img dir="images" file="validate.png" width="35" height="35"/>
                                SSS Transaction Slip
                            </a>
                        </div>    
                </div>
                </g:if>
                <g:else>
                    <div id="SlipTransaction" class="alert alert-success alert-dismissable" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <div> 
                            <a onclick="javascript:sssIndividualTransactionSlip()">
                                <g:img dir="images" file="validate.png" width="35" height="35"/>
                                SSS Transaction Slip
                            </a>
                        </div>    
                    </div>
                </g:else>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="index">SSS Collection Index</g:link></li>
                <li><g:link action="sssOnlineCreate">SSS Online Collection (Employer)</g:link></li>
                <li><g:link action="sssCreateIndividualPayment">SSS Online Collection via PRN (Individual Member)</g:link></li>
                <li><g:link action="sssCreateIndividualPaymentNoPrn">SSS Online Collection without PRN (Individual Member)</g:link></li>
                <li><g:link action="createPrn">Request New Individual PRN</g:link></li>
                <li><g:link action="create">SSS Other Collections</g:link></li>
            </ul>                                        
        </content> 
    </body>
</html>
