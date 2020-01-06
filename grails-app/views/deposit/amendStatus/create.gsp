<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="depositHelper.js"/>
        <title>Deposit Update Status</title>

    </head>
    <body>
        <content tag="main-content">   
            <div id="depositInquiryDiv">
                <g:render template='inquiry/depositInquiryForm'/>
            </div>
            <%-- MODAL --%>
            <div id="depositStatusModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Deposit Update Status</h4>
                        </div>
                        <div class="modal-body">
                            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'branch', 'has-error')} ">
                                <label class="control-label col-sm-4" for="branch">
                                    <g:message code="deposit.branch.label" default="Current Deposit Status" />
                                </label>
                                <div class="col-sm-8">
                                    <g:textField id="oldStatus" name="oldStatus" value="${depositInstance?.status?.description}" class="form-control" disabled="disable" />
                                    <g:hiddenField id="idOldStatus" name="idOldStatus" value="${depositInstance?.status?.id}" />
                                </div>    
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'branch', 'has-error')} ">
                                <label class="control-label col-sm-4" for="branch">
                                    <g:message code="deposit.branch.label" default="Deposit Status" />
                                </label>
                                <div class="col-sm-8">
                                    <g:form name="amendDepositForm" id="amendDepositForm" url="[action:'saveAmendDepositStatus',controller:'deposit']" onsubmit="callLoadingDialog();" method="POST">
                                        <g:hiddenField id="deposit" name="deposit" value="${params.id}" />
                                        <%-- <g:select id="status" name="status.id" from="${icbs.lov.DepositStatus.findAllByStatusAndDescriptionNotEqual(true,'Closed')}" optionKey="id" optionValue="description" value="${depositInstance?.status?.id}" class="many-to-one form-control" noSelection="['null': '']"/> --%>
                                        <g:if test="${depositInstance?.status?.id == 5}">
                                            <g:select id="status" name="status.id" from="${icbs.lov.DepositStatus.findAll{id == 3}}" optionKey="id" optionValue="description" value="${depositInstance?.status?.id}" class="many-to-one form-control" noSelection="['null': 'Select New Deposit Status']"/>
                                        </g:if>
                                        <g:elseif test="${depositInstance?.status?.id == 3}">
                                            <g:select id="status" name="status.id" from="${icbs.lov.DepositStatus.findAll{id == 2 || id == 5}}" optionKey="id" optionValue="description" value="${depositInstance?.status?.id}" class="many-to-one form-control" noSelection="['null': 'Select New Deposit Status']"/>
                                        </g:elseif>
                                        <g:elseif test="${depositInstance?.status?.id == 2}">
                                            <g:select id="status" name="status.id" from="${icbs.lov.DepositStatus.findAll{id == 5}}" optionKey="id" optionValue="description" value="${depositInstance?.status?.id}" class="many-to-one form-control" noSelection="['null': 'Select New Deposit Status']"/>
                                        </g:elseif>
                                    </g:form>    
                                </div>    
                            </div>    
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-primary" onclick="changedStatusSubmit();">Save</button>  
                          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                        <script>
                            function changedStatusSubmit(){
                                var xstatus = $('#status').val();
                                var idOldStatus = $('#idOldStatus').val();

                                console.log("xstatus: "+xstatus);
                                if(xstatus == "" || xstatus == "null" || xstatus == null){
                                    notify.message("Please Select deposit Status |error|alert");
                                }else if(parseInt(idOldStatus) == parseInt(xstatus)){
                                    notify.message("Selected Status is the current deposit Status |error|alert");
                                }else{
                                    alertify.confirm(AppTitle,"Are you sure about this?",
                                        function(){
                                             checkIfAllowed('DEP00300', 'form#amendDepositForm', 'saveDeposit');
                                        },
                                        function(){
                                          alertify.error('Canceled..');
                                        }
                                    );  // alertify close   
                                }
                            }
                        </script>    
                    </div>
                </div>
            </div>    
             <%--<div class="row">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header">Transfer to Another Branch</legend>
                        <div class="infowrap">
                            <g:form name="saveNewBranchForm" action="updateBranch">
                                <g:render template='amendStatus/form' model='[depositInstance:depositInstance]'/>
                            </g:form>
                            <dl class="dl-horizontal">
                                <dt></dt>
                                <dd></dd>
                            </dl>
                        </div>
                    </fieldset>
                </div>
             </div> --%>
        </content>

        <content tag="main-actions">
            <ul>
                <li><button type="button" data-toggle="modal" data-target="#depositStatusModal">Update Status</button></li>
                
                <li>
                    <a href=# onclick="alertify.confirm(AppTitle,'Are you sure you want to return to Deposit Inquiries page?',
                                    function(){
                                    var t_url = '/icbs/deposit/depositInquiry/${depositInstance?.id}';
                                    location.href=t_url;},
                                    function(){});">Return to Deposit Inquiry Page</a>
                </li>
            </ul>                                        
        </content>
    </body>
</html>