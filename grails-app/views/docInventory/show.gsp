
<%@ page import="icbs.deposit.DocInventory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'docInventory.label', default: 'DocInventory')}" />
		<title>Show Deposit Inventory</title>
	</head>
	<body>
            <content tag="main-content">   
		<div id="show-docInventory" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<!-- div class="message" role="status">${flash.message}</div -->
                            <script>
                            $(function(){
                                var x = '${flash.message}';
                                    notify.message(x);
                                    //$('#SlipTransaction').hide();
                                    if(x.indexOf('|success') > -1){
                                    //$('#SlipTransaction').show();
                                }
                            });
                            </script>
			</g:if>
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Deposit Inventory Details </legend>
                         <table class="table table-bordered table-striped">
                            <tbody>
                                <g:if test="${docInventoryInstance?.branch}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Branch</td>
                                    <td width="70%"><g:link controller="branch" action="show" id="${docInventoryInstance?.branch?.id}">${docInventoryInstance?.branch?.name.encodeAsHTML()}</g:link></td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.canceledAt}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Canceled At</td>
                                    <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${docInventoryInstance?.canceledAt}"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.canceledBy}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Canceled By</td>
                                    <td width="70%"><g:link controller="userMaster" action="show" id="${docInventoryInstance?.canceledBy?.username}">${docInventoryInstance?.canceledBy?.encodeAsHTML()}</g:link></td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.status}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Status</td>
                                    <td width="70%">${docInventoryInstance?.status?.encodeAsHTML()}</td>
                                </tr>
                                </g:if> 
                                <g:if test="${docInventoryInstance?.type}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Doc Inventory Type</td>
                                    <td width="70%">${docInventoryInstance?.type?.encodeAsHTML()}</td>
                                </tr>
                                </g:if>       
                                <g:if test="${docInventoryInstance?.isCanceled}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Is Canceled</td>
                                    <td width="70%"><g:formatBoolean boolean="${docInventoryInstance?.isCanceled}" /></td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.seriesStart}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Series Start</td>
                                    <td width="70%">${docInventoryInstance?.seriesStart}</td>
                                </tr>
                                </g:if>    
                                <g:if test="${docInventoryInstance?.seriesEnd}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Series End</td>
                                    <td width="70%">${docInventoryInstance?.seriesEnd}</td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.usageCount}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Usage Count</td>
                                    <td width="70%">${docInventoryInstance?.usageCount}</td>
                                </tr>
                                </g:if> 
                                <g:if test="${docInventoryInstance?.docParticulars}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Particulars</td>
                                    <td width="70%">${docInventoryInstance?.docParticulars}</td>
                                </tr>
                                </g:if>
                                <g:if test="${docInventoryInstance?.checkAcctNo}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Account Number</td>
                                    <td width="70%">${docInventoryInstance?.checkAcctNo}</td>
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
                    <li><g:link class="list" action="index">Document Inventory List</g:link></li>
      			<li><g:link class="create" action="create">Create Document Inventory</g:link></li>
                <li><button disabled="disabled">View Document Inventory</button></li>
                <!--        
                <li><g:link action="edit"id="${docInventoryInstance.id}">Update Document Inventory</g:link></li>
                -->
                <g:if test="${docInventoryInstance.status.id == 1}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'activate']" method="POST">
			<g:actionSubmit action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </g:form></li>
                </g:if>
<!--Action cancel added -->
                <g:if test="${docInventoryInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'cancel']" method="POST">
                            <g:actionSubmit action="cancel" value="Cancel" onclick="return confirm('${message(code: 'default.button.cancel.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:if>
                        
                <g:if test="${docInventoryInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'delete']" method="POST">
                            <g:actionSubmit action="delete" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:if>
              
                <li><g:link action="viewDetails"id="${docInventoryInstance.id}">View Inventory Details</g:link></li>
               
		</ul>
            </content>
	</body>
</html>
