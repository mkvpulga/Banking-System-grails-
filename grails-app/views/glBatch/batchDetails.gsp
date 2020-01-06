
<%@ page import="icbs.admin.Branch" %>
<%@ page import="icbs.admin.UserMaster" %>


<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'branch.label', default: 'Branch')}" />
             <g:javascript>
        var processBatchTransactionAjaxLink = "${createLink(controller:'glBatch',action:'processBatchAjax')}";
        var getGlAccountsAjaxLink = "${createLink(controller:'glBatch',action:'getGLAcctByBranch')}"


    </g:javascript>
	<title>Batch Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/branch')}">Branch Maintenance</a>
            <span class="fa fa-chevron-right"></span><span class="current">Batch Information</span>
        </content>

        <content tag="main-content">
            <div id="show-branch" class="content scaffold-show" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
                        </div>
                <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                       <li class="active"><a href="#tab_1" data-toggle="tab">Batch Details</a></li>
                       <li><a href="#tab_2" data-toggle="tab">Transactions</a></li>
                       <li><a href="#tab_3" data-toggle="tab">Attachments</a></li>
                    </ul>
               </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in" id="tab_1">
                        <!-- START OF BATCH DETAILS TABLE -->
                        <div class="section-container">
                            <legend class="section-header">Details</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td style="width:30%"><label>Batch ID</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.batchId}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Batch value date</label></td>
                                        <td style="width:70%"><g:formatDate  format="MM/dd/yyyy" date="${glBatchHdrInstance?.valueDate}" /></td>
                                    </tr>
                                    <g:set var="batchType" value="${glBatchHdrInstance?.batchType as Integer}"/>
                                    <tr>
                                        <td style="width:30%"><label>Batch Type</label></td>
                                        <td style="width:70%">${icbs.gl.GlBatchTemplate.get(batchType).description}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Batch Name</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.batchName}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Branch</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.branch?.name}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Batch Currency</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.batchCurrency?.name}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Status</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.status?.description}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Created By</label></td>
                                        <td style="width:70%">${glBatchHdrInstance?.createdBy?.username}</td>
                                    </tr>
                                </tbody>
                            </table>
                            <g:hiddenField id="glBatchhid" name="glBatchhid" value="${glBatchHdrInstance.id}" />
                        </div><!-- END OF BATCH DETAILS TABLE -->
                    </div>
                    <g:set var="debitCounter" value="${0.00D}" />
                    <g:set var="creditCounter" value="${0.00D}" />
                    <div class="tab-pane fade in" id="tab_2">

                        <!-- START OF BATCH TRANSACTION TABLE -->
                        <div class="section-container">
                        <legend class="section-header">Batch Transactions</legend>
                        <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <th>Line No.</th>
                                <th>Debit Account</th>
                                <th>Credit Account</th>
                                <th>Account Name</th>
                                <th>Debit Amount</th>
                                <th>Credit Amount</th>
                                <th>Particulars</th>

                                <g:each var="batchTransactInstance" in="${batchTransactionInstance}">
                                <tr>

                                    <td >${batchTransactInstance?.lineNo}</td>
                                    <td >${batchTransactInstance?.debitAccount}</td>
                                    <td >${batchTransactInstance?.creditAccount}</td>
                                    <td >${batchTransactInstance?.accountName}</td>

                                    <td ><g:formatNumber format="###,###,##0.00" number="${batchTransactInstance?.debit}"/></td>

                                    <td ><g:formatNumber format="###,###,##0.00" number="${batchTransactInstance?.credit}"/></td>
                                    <td >${batchTransactInstance?.particulars}</td>
                                </tr>

                                </g:each>

                            </tbody>
                        </table>
                        <g:each var="batchTransactInstance" in="${batchTransactionInstance}">
                            <g:if test="${batchTransactInstance?.debit}">
                                <g:set var="debitCounter" value="${debitCounter = debitCounter + batchTransactInstance?.debit}" /><br/>
                            </g:if>
                            <g:if test="${batchTransactInstance?.credit}">
                                <g:set var="creditCounter" value="${creditCounter = creditCounter + batchTransactInstance?.credit}" /><br/>
                            </g:if>
                        </g:each>
                        <table class="table table-bordered table-rounded table-striped table-hover">
                                <tr>
                                    <td style="width: 30%;"><label>Total Debit </label></td>
                                    <td style="width: 70%;"><g:formatNumber format="###,###,##0.00" number="${debitCounter}"/></td>
                                </tr>
                                <tr>
                                    <td><label>Total Credit </label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${creditCounter}"/></td>
                                </tr>
                                <tr>
                                    <td><label>Difference </label></td>
                                    <td id="differenceBatchtotal"><g:formatNumber format="###,###,##0.00" number="${debitCounter - creditCounter}"/></td>
                                </tr>
                            </table>
                        </div> <!-- END OF BATCH TRANSACTION TABLE -->

                    </div>

                <div class="tab-pane fade in" id="tab_3">
                <!-- START OF BATCH ATTACHMENT TABLE -->
                <div class="section-container">
                <legend class="section-header">Batch Attachment</legend>
		<table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>
                        <th>No.</th>
                        <th>File Name</th>
                        <th>Reference</th>
                        <th>Particulars</th>
                        <th>Date Uploaded</th>
                        <th>Attached By</th>
                        <g:each var="batchAttachInstance" status="i" in="${batchAttachmentInstance}">
                        <tr>

                            <td>${i + 1}</td>
                            <td><g:link  action="downloadAttachment" id="${batchAttachInstance.id}" target="_blank">${batchAttachInstance?.filename}</g:link></td>
                            <td>${batchAttachInstance?.reference}</td>
                            <td>${batchAttachInstance?.particulars}</td>
                            <td><g:formatDate format="MM/dd/yyyy" date="${batchAttachInstance?.uploadDate}"/></td>
                            <td>${batchAttachInstance?.attachedBy?.username}</td>
                        </tr>
                        </g:each>

                    </tbody>
                </table>

                </div> <!-- END OF BATCH ATTACHMENT TABLE -->
                </div>
            </div>

        </content>
        <content tag="main-actions">
            <ul>
                <%-- if batch is Approved --%>
                <g:if test="${glBatchHdrInstance.status.id == 2}">
                    <li><a href="#" onClick="processRunBatch('${glBatchHdrInstance.batchId}');"> Run </a></li>
                    <li><button class="disabled">Edit</button></li>
                    <li><button class="disabled">Cancel</button></li>
                    <li><button class="disabled">Approve Batch Transactions</button></li>
                </g:if>

                <g:else>
                    <%-- if batch is Posted --%>
                    <g:if test="${glBatchHdrInstance.status.id == 3}">
                        <li><button class="disabled">Run Batch</button></li>
                        <li><button class="disabled">Edit</button></li>
                        <li><button class="disabled">Cancel</button></li>
                        <li><button class="disabled">Approve Batch Transactions</button></li>
                    </g:if>
                    <g:else>
                        <li><a href="#" onClick="processRunBatch('${glBatchHdrInstance.batchId}');"> Run </a></li>
                        <li><g:link class="btn btn-primary btn-xs" action="edit" id="${glBatchHdrInstance.id}"> Edit </g:link></li>
                        <li><a href="#" onClick="cancelglBatch();">Cancel</a></li>
                        
                        <%-- trace user branch and batch branch details if match --%>
                        <g:if test="${glBatchHdrInstance?.branch?.id == icbs.admin.UserMaster.get(session.user_id).branch?.id}">
                            <%--<li><g:link class="approve" action="approve" id="${glBatchHdrInstance?.batchId}" params="['bId': glBatchHdrInstance?.batchId]">Approve Batch Transactions</g:link></li>--%>
                            <li><button onClick="approveBatchwithConfirmMatchBranch('${glBatchHdrInstance?.batchId}')">Approve Batch Transactions</button></li>
                        </g:if>  
                        <%-- else Validate the batch branch Only Main Branch can approve the other branch's batch transaction--%>
                        <%-- Other Branch can view all the batch but only their local batch transaction can be approve --%>
                        <g:else>
                            <li><a href="#" onClick="approveBatchwithConfirm('${glBatchHdrInstance?.batchId}')">Approve Batch Transactions</a></li>
                        </g:else>    
                    </g:else>
                </g:else>
                <li><g:link class="list" action="index">GL Batch Transactions</g:link></li>
                <li><g:link class="create" action="create">New Batch Transactions</g:link></li>
                <li><g:link class="printGlBatch" target="_blank" action="printGlBatch" id="${glBatchHdrInstance?.id}" params="['Bid': glBatchHdrInstance?.id]">Print Batch Transactions</g:link></li>
                <%--<li><g:link class="voucherDetailsCheck" action="voucherDetailsCheck" id="${glBatchHdrInstance?.id}" params="['Bid': glBatchHdrInstance?.id]">Add Voucher Details</g:link></li>
                <li><g:link class="printGlBatchVoucher" target="_blank" action="printGlBatchVoucher" id="${glBatchHdrInstance?.id}" params="['Bid': glBatchHdrInstance?.id]">Print Voucher Details</g:link></li> --%>
                <script>
                    function approveBatchwithConfirmMatchBranch(theFckBatchId){
                        var differenceTotal = document.getElementById("differenceBatchtotal").innerHTML
                        differenceTotal = parseFloat(differenceTotal.replace(/,/g , ""));
                        
                        if(differenceTotal != 0){
                            notify.message('Disbalance Gl Batch Transaction |error|alert');
                        }else{
                            
                            alertify.confirm(AppTitle,"Are you sure you want to Approve This Gl Batch Transaction?",
                                function(){
                                    var approvingLink = '/icbs/glBatch/approve/'+theFckBatchId+'?bId='+theFckBatchId 
                                    location.href=approvingLink;
                                },
                                function(){
                                  alertify.error('Canceled!');
                                }
                            );
                            
                        }
                        
                        console.log("differenceTotal: "+differenceTotal);
                    }
                    
                    function approveBatchwithConfirm(theFckBatchId){
                        var differenceTotal = document.getElementById("differenceBatchtotal").innerHTML
                        differenceTotal = parseFloat(differenceTotal.replace(/,/g , ""));
                        
                        if(differenceTotal != 0){
                            notify.message('Disbalance Gl Batch Transaction |error|alert');
                        }else{
                            //check if branch id of user is HEAD OFFICE or MAIN OFFICE
                            if(parseInt('${icbs.admin.UserMaster.get(session.user_id).branch?.id}') == 1){
                                console.log("branch HEAD OFFICE");
                                alertify.confirm(AppTitle,"Are you sure you want to Approve other Branch Batch Transaction?",
                                    function(){
                                        var approvingLink = '/icbs/glBatch/approve/'+theFckBatchId+'?bId='+theFckBatchId 
                                        location.href=approvingLink;
                                    },
                                    function(){
                                      alertify.error('Canceled!');
                                    }
                                );
                            }else{
                                notify.message('Warning.., Please check the batch branch details |error|alert');
                            }
                        }
                        
                        console.log("differenceTotal: "+differenceTotal);
                        
                    }
                    function processRunBatch(batccchID){
                    var statusBatch = '${glBatchHdrInstance?.status?.id}';
                    console.log("statusBatch: "+statusBatch);
                    if (statusBatch == "1"){
                        notify.message('Batch not yet approved|error|alert');
                    }  else if (statusBatch == "3"){
                        notify.message('Batch already Posted|error|alert');
                    }else if (statusBatch == "4"){
                        notify.message('Batch already Cancelled|error|alert');
                    }else {
                        alertify.confirm(AppTitle,"Are you sure you want to update this batch?",
                            function(){
                                var sessionID = batccchID
                                var oMyForm = new FormData();
                                oMyForm.append("batchId", sessionID);
                                console.log("sessionID: "+sessionID);
                                var url="${createLink(controller:'glBatch',action:'processBatchAjax')}";
                                        $.ajax({
                                              url: url,
                                              data: oMyForm,
                                              dataType: 'text',
                                              processData: false,
                                              contentType: false,
                                              type: 'POST',
                                              success: function(data){
                                                   var status = data.status;
                                                    if (status == "1")
                                                    {
                                                        //alert("Batch not yet approved");
                                                        notify.message('Batch not yet approved|error|alert');
                                                    } else if (status == "2")
                                                    {
                                                        //alert("Batch already posted");
                                                        notify.message('Batch already posted|error|alert');
                                                    } else if (status == "3")
                                                    {
                                                        //alert("Batch already cancelled");
                                                        notify.message('Batch already cancelled|error|alert');
                                                    } else
                                                    {
                                                        //alert("Success");
                                                        alertify.alert(AppTitle,"Sucess!", function(){
                                                         location.reload();
                                                       });
                                                    }
                                              }
                                       });
                            },
                            function(){
                            });
                    }
                    }
                    function cancelglBatch(){
                        if('${glBatchHdrInstance?.createdBy?.id}'=='${session.user_id}'){
                        var batchchidid = $('#glBatchhid').val();
                        console.log("batchchidid: "+batchchidid);
                        alertify.confirm(AppTitle,"Are you sure you want to cancel this?",
                            function(){
                                var sessionID = batchchidid
                                var oMyForm = new FormData();
                                oMyForm.append("id", sessionID);
                                console.log("sessionID: "+sessionID);
                                var url="${createLink(controller:'GlBatch',action:'cancelBatchAjax')}";
                                        $.ajax({
                                              url: url,
                                              data: oMyForm,
                                              dataType: 'text',
                                              processData: false,
                                              contentType: false,
                                              type: 'POST',
                                              success: function(data){
                                                   if(data.length > 0){
                                                    alertify.alert(AppTitle,"Successfully Canceled Gl Batch!", function(){
                                                        location.reload();
                                                      });
                                                   }else{
                                                   }
                                              }
                                       });
                            },
                            function(){
                            });
                        }else{
                           alertify.alert(AppTitle,"The Batch was created by other user you are not Authorize to cancel this batch", function(){
                                var t_url = '/icbs/glBatch/batchDetails/${glBatchHdrInstance?.id}';
                                location.href=t_url;
                            });
                        }
                    }
                </script>
            </ul>
            <script type="text/javascript">
            </script>
        </content>
    </body>
</html>