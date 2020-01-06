
<legend>Attachments</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>File Name</label></td>			
                <td><label>Description</label></td>		
                <td><label>Upload Date</label></td>
                <td class="col-sm-2"><label>Actions</label></td>		
            </tr>
        </tbody>
        <tbody>
            <g:each var="attachment" status="i" in="${resultsAttachment}">
                <tr>
                    <td>${attachment?.filename}</td>
                    <td>${attachment?.description}</td>
                    <td><g:formatDate format="MM-dd-yyyy" date="${attachment?.uploadDate}"/></td>

                    <td>
                        <button class="btn btn-secondary"  data-toggle="modal" data-target="#othersignatureDeposit${i}" >View</button> 
                    <g:link class="btn btn-secondary" action="downloadAttachment" id="${attachment?.id}">Download</g:link>
                    </td>
                </tr>
            <div class="modal fade" role="dialog" id="othersignatureDeposit${i}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">${attachment?.filename} </h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <img width="100%" height="100%" id="xxxx${i}" src="${createLink(controller:'loanApplication', action:'showPicture', id: attachment?.id)}" alt="Attachment is not a valid picture format. Please download the file for viewing."  />
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                        </div>
                    </div>
                </div>
            </div>
        </g:each>  

        </tbody>
    </table>
</div>