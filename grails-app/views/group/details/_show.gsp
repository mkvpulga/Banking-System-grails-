<div class="section-container">
    <fieldset>
    <legend class="section-header"> Group Details </legend>
     <table class="table table-bordered table-striped">
        <tbody>
            <tr>
                <td style="font-weight:bold" width="30%">Group Name</td>
                <td width="70%">${groupInstance?.name}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Group Description</td>
                <td width="70%">${groupInstance?.description}</td>
            </tr>  
            <tr>
                <td style="font-weight:bold" width="30%">Group Type</td>
                <td width="70%">${groupInstance?.type?.description}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Parent Group</td>
                <td width="70%">${groupInstance?.parent?.name}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Group Meeting Date</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${groupInstance?.meetingDate}"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Created</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${groupInstance?.dateCreated}"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Status</td>
                <td width="70%">${groupInstance?.status?.description}</td>
            </tr>                            
        </tbody>
    </table>
    </fieldset>
</div>
