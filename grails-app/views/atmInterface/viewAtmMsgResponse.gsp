<%@ page import="icbs.tellering.TxnFile" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ATM Message Response Details</title>
    </head>
    <body>
        <content tag="main-content">   
            <div id="list-atm_txn" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
                
		<g:form class="form-inline" url="[action:'viewAtmMsgResponse',controller:'ATMInterface']" method="POST">
                    <div class="form-group">
			<g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
			<div class="form-group">
                            <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
			</div>
			<g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
		</g:form>

		<div class="table-responsive">
                    <table class="table table-bordered table-rounded table-striped table-hover">
                        <thead>
                            <tr>
				<g:sortableColumn property="id" title="${message(code: 'AtmTxn.txnDate.label', default: 'ID')}" />
                                <g:sortableColumn property="destinationIp" title="${message(code: 'AtmTxn.destinationIp.label', default: 'Destination Ip Address')}" />
				<g:sortableColumn property="msgLength" title="${message(code: 'AtmTxn.mti.label', default: 'Message Length')}" />
				<g:sortableColumn property="dateSent" title="${message(code: 'AtmTxn.acct1.label', default: 'Date Sent')}" />
				<th>Action</th>
                                	
                            </tr>
			</thead>
			<tbody>
                            <g:each in="${atmResponseListInstance}" status="i" var="branchInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fieldValue(bean: branchInstance, field: "id")}</td>
                                    <td>${fieldValue(bean: branchInstance, field: "destinationIp")}</td>
                                    <td>${fieldValue(bean: branchInstance, field: "msgLength")}</td>
                                    <td>${fieldValue(bean: branchInstance, field: "dateSent")}</td>
                                    
                                    <td><g:link class="btn btn-primary" controller="ATMInterface" action="showResponseDetails" id="${branchInstance.id}">View Response Details</g:link></td>    
				</tr>
                            </g:each>
			</tbody>
                    </table>
                </div>
		<div class="pagination">
                    <g:paginate total="${BranchInstanceCount ?: 0}" params="${params}" />
		</div>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="index" controller="ATMInterface" >Return to ATM Interface Index</g:link></li>
                <li><g:link action="viewAtmMsgRequest" controller="ATMInterface" >View Request Message Details</g:link></li>
            
            </ul>
        </content>
    </body>
</html>
