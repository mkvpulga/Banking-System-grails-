<script type="text/javascript">

  
</script>


<legend>Attach Document / File</legend>


<div class="form-group form-buttons">        
        <button  id="add-buttons" type="button" data-toggle="modal" data-target="#myModal" class="btn btn-primary multi-field-btn-add"><span class="fa fa-file-excel-o"></span> Add File</button>
</div>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
    <tbody>
              
		<tr>
			<td class="col-sm-1"><label>No.</label></td>
			<td class="col-sm-3"><label>File Name</label></td>
                        
                        <td class="col-sm-3"><label>Date Uploaded</label></td>
			<td class="col-sm-2"><label>Action</label></td>		
		</tr>
	</tbody>
	<tbody>
                <g:hiddenField name="loanAppid" id="loanAppid" value="${loanApplicationInstance?.id}"/>
                <g:each in="${session["loanApplicationAttchmt"]}" status="i" var="loanApplicationAttachment">
				<tr>
					<td>${i + 1} </td>
                                        <td>${loanApplicationAttachment?.filename}</td>
                                          
                                        
					<td><g:formatDate format="MM/dd/yyyy" date="${loanApplicationAttachment?.uploadDate}"/></td>
                                       
                                        
					<td>
                                            <a href="#" class="btn btn-secondary" onclick="removeAttachment('${i}')">Remove</a>
					</td>
                                        
                                        
                                            
				</tr>
                                
			
                </g:each>                
		
	</tbody>
	</table>
</div>

<!-- Add Attachment Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"><strong>Attachments</strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <div class="fieldcontain form-group required">
                <label class="control-label col-sm-4" for="template">Attach File</label>
                <div class="controls col-sm-6">
                        <input id="file2" class="btn btn-info-form-control" type="file" name="file" />
                </div>  
            </div>
            <div class="fieldcontain form-group required">
                <label class="control-label col-sm-4" for="template">Description</label>
                <div class="controls col-sm-6">
                    <g:textField name="description" id="description" value="" class="form-control"/>
                </div>  
            </div>
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onClick="passAttachmentAndBatchIdToController();">Save File</button>
      </div>
    </div>
  </div>
</div>