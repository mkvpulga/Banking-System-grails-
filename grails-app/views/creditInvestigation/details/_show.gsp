<legend>Credit Investigation Details</legend>
<table class="table table-bordered table-striped">
    <tbody>
        <tr>
            <td style="font-weight:bold" width="30%">Loan Application</td>
            <td width="70%"><g:link controller="loanApplication" action="show" id="${creditInvestigationInstance?.loanApplication?.id}">${creditInvestigationInstance?.loanApplication?.id}</g:link></td>
        </tr>
        <g:if test="${creditInvestigationInstance?.loanApplication}">
            <tr>    
                <td style="font-weight:bold" width="30%">Borrower Name</td>
                <td width="70%">${creditInvestigationInstance?.loanApplication?.customer?.displayName}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Status</td>
                <td width="70%">${creditInvestigationInstance?.loanApplication?.approvalStatus?.description}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Product</td>
                <td width="70%"><g:link controller="product" action="show" id="${creditInvestigationInstance?.loanApplication?.product?.id}">${creditInvestigationInstance?.loanApplication?.product?.name}</g:link></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Amount</td>
                <td width="70%"><g:formatNumber format="###,##0.00" number="${creditInvestigationInstance?.loanApplication?.amount}" /></td>
            </tr>  
  
        </g:if>  
        <tr>
            <td style="font-weight:bold" width="30%">Recommendation</td>
            <td width="70%"><g:fieldValue bean="${creditInvestigationInstance}" field="recommendation"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">CI Schedule Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.ciScheduleDate}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">CI Name</td>
            <td width="70%">${creditInvestigationInstance?.ciName}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">CI Execution Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.ciExecutionDate}"  /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Appraisal Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.appraisalDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Appraised By</td>
            <td width="70%">${creditInvestigationInstance?.appraisedBy}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Loan Analysis Schedule Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.loanAnalysisScheduleDate}" /></td>
        </tr>
        <%-- <tr>
            <td style="font-weight:bold" width="30%">Loan Analysist Name</td>
            <td width="70%">${creditInvestigationInstance?.analysName}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Loan Analysis Execution Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.loanAnalysisExecutionDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Credit Com B Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.creditComBDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Credit Com A Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.creditComADate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Lending Authority Approval Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.approvalDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Date Created</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.dateCreated}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Borrower Risk Score</td>
            <td width="70%"><g:fieldValue bean="${creditInvestigationInstance}" field="borrowerRiskRating"/></td>
        </tr> 
        
        <g:each var="brrlastId" in="${lastId}">
        <tr>
            <td style="font-weight:bold" width="30%">Borrower Risk Rating</td>
            <g:if test="${brrlastId?.borrowRiskRating}">
                <td width="70%">${brrlastId?.borrowRiskRating?.description}</td>
            </g:if>
            <g:else>
                <td width="70%"></td>
            </g:else>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Remarks</td>
            <g:if test="${brrlastId?.remarks}">
                <td width="70%">${brrlastId?.remarks}</td>
            </g:if>
            <g:else>
                <td width="70%"></td>
            </g:else>
        </tr>
        </g:each> --%>
    </tbody>
</table>