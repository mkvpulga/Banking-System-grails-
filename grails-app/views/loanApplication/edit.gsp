<%@ page import="icbs.loans.LoanApplication" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'loanApplication.label', default: 'LoanApplication')}" />
        <title>Edit Loan Application</title>
        <g:javascript>
              $( document ).ready(function() {
                    console.log( "ready!" );
                    changeFormchecklist();
                });
            function changeFormchecklist(){
            var checklistType = $('#checklisttype').val();
            console.log("checklistType: "+checklistType);
            checklistType = parseInt(checklistType);

            // this code will update the checklist form according to what checklist type that a  user select
            if(checklistType == 2){
            // salary loan checklist type
            // not to display regular checklist form
            document.getElementById("salaryLoanChecklist").style.display = "none";
            document.getElementById("businessLoanChecklist").style.display = "none";            
            document.getElementById("housingLoanWithCollateralChecklist").style.display = "none";
            document.getElementById("businessLoanWithCollateralChecklist").style.display = "block";
            }
            else if(checklistType == 3){
            // microfinance checklist type
            // not to display regular checklist  and salary loan checklist form
            document.getElementById("salaryLoanChecklist").style.display = "none";
            document.getElementById("businessLoanWithCollateralChecklist").style.display = "none";
            document.getElementById("businessLoanChecklist").style.display = "block";
            document.getElementById("housingLoanWithCollateralChecklist").style.display = "none";
            }
            else if(checklistType == 4){
            // microfinance checklist type
            // not to display regular checklist  and salary loan checklist form
            document.getElementById("businessLoanChecklist").style.display = "none";
            document.getElementById("salaryLoanChecklist").style.display = "none";
            document.getElementById("businessLoanWithCollateralChecklist").style.display = "none";
            document.getElementById("housingLoanWithCollateralChecklist").style.display = "block";

            }
            else{
            //checklistType == 1
            // regular checklist type
            document.getElementById("salaryLoanChecklist").style.display = "block";
            document.getElementById("businessLoanChecklist").style.display = "none";
            document.getElementById("businessLoanWithCollateralChecklist").style.display = "none";
            document.getElementById("housingLoanWithCollateralChecklist").style.display = "none";

            }
            }
            function updateAmount() 
            {

            var Amt = accounting.unformat($('#value').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,''));
            if (isNaN(Amt))
            Amt = 0;
            $('#value').val(Amt);
            }
            function val() 
            {
            var Amt = accounting.formatNumber($('#value').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,''),2, ",",".");

            if (isNaN(Amt))

            $('#value').val(Amt).toDouble();

            }
            function Comma(Num) { //function to add commas to textboxes
            Num += '';
            Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
            Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
            x = Num.split('.');
            x1 = x[0];
            x2 = x.length > 1 ? '.' + x[1] : '';
            var rgx = /(\d+)(\d{3})/;
            while (rgx.test(x1))
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
            return x1 + x2;
            }
            function AddComma()
            {

            $('#value').val(Comma( $('#value').val()));
            }
            function updateAmount() 
            {
            var Amt = accounting.unformat($('#value').val());
            if (isNaN(Amt))
            Amt = 0;
            $('#value').val(Amt);
            }


            function updateCustomerInfoAjax(params) {							
            $.ajax({
            type: 'POST',
            data: {id:params.customer2},
            url: "${createLink(controller :'customer', action:'showBasicCustomerInfoAjax')}",
            success: function(msg){				    	
            $('#customer-name').val($(msg).find('#display-name').html());
            $('#customer').val(params.customer2);
            $('#birth-date').html($(msg).find('#birth-date').html())
            $('#address').html($(msg).find('#address').html())
            $('#photo').html($(msg).find('#photo').html())
            $('#total-released').html($(msg).find('#total-released').html())
            $('#total-balance').html($(msg).find('#total-balance').html())
            $('#total-count').html($(msg).find('#total-count').html())                                                
            }
            });				
            }

            function showCustomerSearch() {        		        		
            modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
            modal.show();                   
            }

            function showFinancialDetails() {
            $.ajax({
            type: 'POST',
            data: {id:${loanApplicationInstance?.id}},
            url: "${createLink(controller :'loanApplication', action:'showFinancialDetailsAjax2')}",
            success: function(msg){				    	
            $('#tab_2').html(msg);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });				
            }

            function addFinancialDetailAjax() {            	
            $.ajax({
            type: 'POST',
            data: {id:${loanApplicationInstance?.id}, description:$('#description').val(), value:$('#value').val(), type:$('#type').val()},
            url: "${createLink(controller :'loanApplication', action:'addFinancialDetailAjax2')}",
            success: function(msg){
            $('#add-financial-detail-modal .modal-body').html(msg);
            $('#add-financial-detail-modal').on('hidden.bs.modal', function() {
            showFinancialDetails();
            });						
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });				
            }            

            function showAddFinancialDetail() {
            modal = new icbs.UI.Modal({id:"add-financial-detail-modal", url:"${createLink(controller: 'loanApplication', action:'showAddFinancialDetailAjax')}", title:"Add Financial Detail"});
            modal.show();
            }

            function updateFinancialDetailAjax() {
            $.ajax({
            type: 'POST',
            data: {id:$('#financialDetailId').val(), description:$('#description').val(), value:$('#value').val(), type:$('#type').val()},
            url: "${createLink(controller :'loanApplication', action:'updateFinancialDetailAjax2')}",
            success: function(msg){
            $('#update-financial-detail-modal .modal-body').html(msg);
            $('#update-financial-detail-modal').on('hidden.bs.modal', function() {
            showFinancialDetails();
            });						
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }            

            function showUpdateFinancialDetail(id) { 
            $.ajax({
            type: 'POST',
            data: {id:id},
            url: "${createLink(controller :'loanApplication', action:'showUpdateFinancialDetailAjax2')}",
            success: function(msg){
            $('#financialDetailId').val(id);
            $('#update-financial-detail-modal .modal-body').html(msg);				    	
            $('#update-financial-detail-modal').modal({show:true});				    	
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }

            function deleteFinancialDetailAjax(id) {
            if (confirm('Are you sure?')) {
            $.ajax({
            type: 'POST',
            data: {id:id},
            url: "${createLink(controller:'loanApplication', action:'deleteFinancialDetailAjax2')}",
            success: function(msg){
            showFinancialDetails();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            function showComakers() {
            $.ajax({
            type: 'POST',
            url: "${createLink(controller:'loanApplication', action:'showComakersAjax')}",
            success: function(msg){				    	
            $('#tab_3').html(msg);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }

            function addComakerAjax(params) {
            if (params.customer2) {
            $.ajax({
            type: 'POST',
            data: {id:params.customer2},
            url: "${createLink(controller:'loanApplication', action:'addComakerAjax')}",
            success: function(msg){

            showComakers();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            function showComakerSearch() {  
            modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:addComakerAjax});
            modal.show();
            }

            function deleteComakerAjax(id) {            	
            if (confirm('Are you sure?')) {
            $.ajax({
            type: 'POST',
            data: {id:id},
            url: "${createLink(controller :'loanApplication', action:'deleteComakerAjax')}",
            success: function(msg){
            showComakers();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            function showCollateral() {
            $.ajax({
            type: 'POST',
            data: {id:${loanApplicationInstance?.id}},
            url: "${createLink(controller:'loanApplication', action:'showCollateralAjax')}",
            success: function(msg){				    	
            $('#tab_4').html(msg);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }

            function addCollateralAjax(params) {
            if (params.collateral2) {
            $.ajax({
            type: 'POST',
            data: {id:params.collateral2},
            url: "${createLink(controller:'loanApplication', action:'addCollateralAjax')}",
            success: function(msg){					 
            showCollateral();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            function showCollateralSearch() {  
            modal = new icbs.UI.Modal({id:"collateralDetailsModal", url:"${createLink(controller: 'collateralManagement', action:'search')}", title:"Search Collateral", onCloseCallback:addCollateralAjax});
            modal.show();
            }

            function deleteCollateralAjax(id) {            	
            if (confirm('Are you sure?')) {
            $.ajax({
            type: 'POST',
            data: {id:id},
            url: "${createLink(controller:'loanApplication', action:'deleteCollateralAjax')}",
            success: function(msg){
            showCollateral();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            }

            icbs.Dependencies.Ajax.addLoadEvent(function(){            	
            updateCustomerInfoAjax({customer2:"${loanApplicationInstance?.customer?.id}"});	
            });
            function passAttachmentAndBatchIdToController(){


            var filetopass = $("#file2")[0].files[0];                
            var description = $("#description").val(); 
            var oMyForm = new FormData();
            oMyForm.append("file", filetopass);
            oMyForm.append("description", description);

            var url="${createLink(controller:'LoanApplication',action:'addAttachment')}";
            $.ajax({

            url: url,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',

            success: function(data){
            console.log("success");
            $('#tab_6').html(data);

            }
            });

            }
            function removeAttachment(id){
            var sessionID = id
            var oMyForm = new FormData();
            oMyForm.append("id", sessionID);
            console.log("sessionID: "+sessionID);
            var url="${createLink(controller:'LoanApplication',action:'removeAttachment')}";
            $.ajax({

            url: url,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',

            success: function(data){
            console.log("success");
            $('#tab_6').html(data);

            }

            });
            }


        </g:javascript>
    </head>
    <body>
    <content tag="breadcrumbs">
        <span class="fa fa-chevron-right"></span><span class="current">Edit Loan Application</span>
    </content>
    <content tag="main-content">
        <div id="edit-loanApplication" class="content scaffold-edit" role="main">
            <g:if test="${flash.message}">
                <script>
                    $(function(){
                            var x = '${flash.message}';
                    notify.message(x);
                    });
                </script>
            </g:if>
            <g:hasErrors bean="${loanApplicationInstance}">
                <script>
                    $(function
                        var x = '${it}';
                    notify.error(x);
                    // console.log(x)
                    // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                </script>
            </g:hasErrors>
            <g:form id="loan-application-form" onsubmit="callLoadingDialog();" url="[resource:loanApplicationInstance, action:'update']" method="PUT" >
                <g:hiddenField name="version" value="${loanApplicationInstance?.version}" />
                <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                   <%--     <g:if test="${user?.designation?.id == 30 || user?.designation?.id == 17 || user?.designation?.id == 19}"> --%>
                            <li class="active"><a href="#tab_1" data-toggle="tab">Specification</a></li>
                            <li><a href="#tab_2" data-toggle="tab">Financial Details</a></li>
                            <li><a href="#tab_3" data-toggle="tab">Co-Makers</a></li>                        
                            <li><a href="#tab_4" data-toggle="tab">Collateral</a></li>
                            <li><a href="#tab_5" data-toggle="tab">CAM</a></li>
                                <g:if test="${role}">
                                <li><a href="#tab_7" data-toggle="tab" >Checklist</a></li>
                                </g:if>
                            <li><a href="#tab_6" data-toggle="tab">Attachment</a></li>
                         <%--   </g:if>
                            <g:else>                       
                            <li class="active"><a href="#tab_4" data-toggle="tab">Collateral</a></li>                    
                            </g:else> --%>
                    </ul>
                </div>
                <div class="tab-content">
                        <g:if test="${user?.designation?.id == 17}">
                            <div class="tab-pane active fade in table-responsive" id="tab_1">
                                <g:render template="specification/form"/>
                            </div>
                            <div class="tab-pane" id="tab_2">
                                <g:render template="financialDetails/list"/>						
                            </div>
                            <div class="tab-pane" id="tab_3">
                                <g:render template="comakers/list"/>
                            </div>
                            <g:if test="${user?.designation?.id == 33}">
                            <div class="tab-pane" id="tab_4">
                                <g:render template="collateral/list"/>
                            </div>
                            </g:if>
                                <g:else>
                                     <div class="tab-pane" id="tab_4">
                                <g:render template="collateral/show"/>
                            </div>
                                    </g:else>
                            <g:if test="${user?.id == 16}">
                            <div class="tab-pane" id="tab_5">
                                <g:render template="additional/form"/>
                            </div>
                            </g:if>
                                <g:else>
                            <div class="tab-pane" id="tab_5">
                                <g:render template="additional/show"/>
                            </div>
                            </g:else>
                            <div class="tab-pane" id="tab_7">
                                <g:render template="loanApplicationChecklist/checklist"/>
                            </div>
                            <div class="tab-pane" id="tab_6">
                                <g:render template="attachments/list"/>
                            </div>

                        </g:if>
                        <g:else>
                            <g:if test="${user?.id == 15 || user?.id == 12}">
                            <div class="tab-pane active fade in table-responsive" id="tab_1">
                                <g:render template="specification/form"/>
                            </div>
                            </g:if>
                             <g:else>
                            <div class="tab-pane active fade in table-responsive" id="tab_1">
                                <g:render template="specification/show"/>
                            </div>
                            </g:else>
                            <div class="tab-pane" id="tab_2">
                                <g:render template="financialDetails/show"/>
                            </div>
                            <div class="tab-pane" id="tab_3">
                                <g:render template="comakers/show"/>
                            </div>
                             <g:if test="${user?.designation?.id == 33}">
                            <div class="tab-pane" id="tab_4">
                                <g:render template="collateral/list"/>
                            </div>
                            </g:if>
                                <g:else>
                                     <div class="tab-pane" id="tab_4">
                                <g:render template="collateral/show"/>
                            </div>
                                    </g:else>
                            <g:if test="${user?.designation?.id == 30}">
                            <div class="tab-pane" id="tab_5">
                                <g:render template="additional/form"/>
                            </div>
                            </g:if>
                                <g:else>
                            <div class="tab-pane" id="tab_5">
                                <g:render template="additional/show"/>
                            </div>
                            </g:else>
                            <div class="tab-pane" id="tab_7">
                                <g:render template="loanApplicationChecklist/checklist"/>
                            </div>
                            <div class="tab-pane" id="tab_6">
                                <g:render template="attachments/show"/>
                            </div>
                        </g:else>
                   
                    
                </div>
            </g:form>
        </div>
    </content>
    <content tag="main-actions">
        <ul>
            <script>
                function showAttachments() {
                $.ajax({
                type: 'POST',
                    data: {id:${loanApplicationInstance?.id}},
                    url: "${createLink(controller:'loanApplication', action:'showAttachmentsAjax2')}",
                success: function(msg){                     
                $('#tab_6').html(msg);
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }

                function addAttachmentAjax() {
                var file = (document.getElementById("fileData")).files[0];                                

                var data = new FormData(); 
                data.append("id", ${loanApplicationInstance?.id});
                data.append("file", file);
                data.append("description", $('#add-attachment-modal #description').val());
                data.append("type", $('#add-attachment-modal #type').val());

                $.ajax({
                type: 'POST',
                data: data,
                contentType: false,
                processData: false,
                    url: "${createLink(controller:'loanApplication', action:'addAttachmentAjax2')}",
                success: function(msg){
                $('#add-attachment-modal .modal-body').html(msg);
                $('#add-attachment-modal').on('hidden.bs.modal', function() {
                showAttachments();
                });                     
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });        
                }            

                function showAddAttachment() {
                modal = new icbs.UI.Modal({id:"add-attachment-modal", url:"${createLink(controller: 'loanApplication', action:'showAddAttachmentAjax')}", title:"Add Attachment"});
                modal.show();
                }

                function updateAttachmentAjax() {
                var description = $('#update-attachment-modal #description').val();
                var type = $('#update-attachment-modal #type').val();

                $.ajax({
                type: 'POST',
                data: {id:$('#attachmentId').val(), description:description, type:type},
                    url: "${createLink(controller:'loanApplication', action:'updateAttachmentAjax2')}",
                success: function(msg){
                $('#update-attachment-modal .modal-body').html(msg);
                $('#update-attachment-modal').on('hidden.bs.modal', function() {                        
                showAttachments();
                });                     
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }            

                function showUpdateAttachment(id) { 
                $.ajax({
                type: 'POST',
                data: {id:id},
                    url: "${createLink(controller:'loanApplication', action:'showUpdateAttachmentAjax2')}",
                success: function(msg){
                $('#attachmentId').val(id);
                $('#update-attachment-modal .modal-body').html(msg);                      
                $('#update-attachment-modal').modal({show:true});                     
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }

                function deleteAttachmentAjax(id) {
                if (confirm('Are you sure?')) {
                $.ajax({
                type: 'POST',
                        data: {id:${loanApplicationInstance?.id}, attachmentId:id},
                        url: "${createLink(controller:'loanApplication', action:'deleteAttachmentAjax2')}",
                success: function(msg){
                showAttachments();
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }
                }
            </script>
            <li><g:submitButton id="save" name="save" value="Save" onclick="
                    alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                    function(){
                    checkIfAllowed('LON00202', 'form#loan-application-form', 'Edit Loan Application', null);
                    },
                    function(){
                    return;
                    });                        
                    "/></li>
                <!--
                <script type="text/javascript">
                            $(document).ready(function() {
                                $( "#save" ).click(function() {
                                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    //jQuery('#txnBillsPaymentForm').submit();
                                         checkIfAllowed('LON00202', 'form#loan-application-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
                                },
                                function(){
                                    return;
                                });                                 	 
                                });
                            }); 
                </script>
                -->
            <li><g:link action="show" id="${loanApplicationInstance.id}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
            </ul>
        </content>
    </body>
</html>
