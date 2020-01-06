<%@ page import="icbs.loans.CreditInvestigationBRRHistory" %>
<%@ page import="icbs.lov.BorrowRiskRating" %>
<legend>Borrow Risk Rating History</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
	    <tbody>
			<tr>
				<td><label>Date</label></td>			
				<td><label>Borrow Risk Rating</label></td>		
				<td><label>Remarks</label></td>
				<td><label>Last Update by</label></td>		
			</tr>
		</tbody>
		<tbody>
			<g:each var="brrHistory" in="${CreditInvestigationBRRHistory.findAllByCreditInvestigation(creditInvestigationInstance)}">
			<tr>
				<td><g:formatDate  format="MM/dd/yyyy" date="${brrHistory?.dateUpdated}" /></td>
				<td>${brrHistory?.borrowRiskRating?.description}</td>
				<td>${brrHistory?.remarks}</td>
				<td>${brrHistory?.createdBy?.username}</td>
			</tr>
			</g:each>
		</tbody>
	</table>
</div>