<legend>Sweep Accounts</legend>
<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
    <tbody>
		<tr>
			<td><label>Account No.</label></td>
                        <td><label>Account Name</label></td>
			<td><label>Type</label></td>
			<td><label>Rule</label></td>		
			<td><label>Remarks</label></td>
			<td><label>Order</label></td>		
		</tr>
	</tbody>
	<tbody>
		<g:if test="${session["sweepAccounts"]}">
			<g:set var="i" value="${0}" />
			<g:each var="sweepAccounts" in="${session["sweeplist"]}">
				<tr>
					<td>${sweepAccounts?.depositAccount?.acctNo}</td>
                                        <td>${sweepAccounts?.depositAccount?.acctName}</td>
					<td>${sweepAccounts?.type?.description}</td>
					<td>${sweepAccounts?.rule?.description}</td>
					<td>${sweepAccounts?.remarks}</td>						
					<td>${sweepAccounts?.ordinalNum}</td>
                                        <g:hiddenField name="actionPage" id="actionPage" value="${session["pageAction"]}" />
					</td>
				</tr>
				<g:set var="i" value="${i = i + 1}" />
			</g:each>
		</g:if>
	</tbody>
	</table>
</div>

<div class="modal" id="add-sweep-account-modal">
	<div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Add Sweep Account</h4>
            </div>
            <div class="modal-body">
            </div>
            
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
                <a href="#" class="btn btn-primary" onclick="addSweepAccountAjax()">Add</a>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="update-sweep-account-modal">
	<div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Update Sweep Account</h4>
            </div>
            <div class="modal-body">            	
            </div>
            <g:hiddenField name="sweepAccountId" value="" />
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
                <a href="#" class="btn btn-primary" onclick="updateSweepAccountAjax()">Save</a>
            </div>
        </div>
    </div>
</div>

