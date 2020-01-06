

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'loanApplication.label', default: 'LoanApplication')}" />
        <title>Create Loan Application</title>		
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
            //===================================================




            //===================================================
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

            function showLoanApplicationSearch() {				
            modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'loanApplication', action:'search')}", title:"Search Loan Application", onCloseCallback:updateLoanApplicationAjax});
            modal.show();
            }

        </g:javascript>
    </head>
    <body>
    <content tag="breadcrumbs">
        <span class="fa fa-chevron-right"></span><span class="current">Create Loan Application</span>
    </content>
    <content tag="main-content">
        <div id="create-loanApplication" class="content scaffold-create" role="main">
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
            <g:form id="loan-application-form" onsubmit="callLoadingDialog();" url="[resource:loanApplicationInstance, action:'save']">
                <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Specification</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Financial Details</a></li>
                        <li><a href="#tab_3" data-toggle="tab">Co-Makers</a></li>
                        <li><a href="#tab_4" data-toggle="tab">Collateral</a></li> 
                            <%-- <li><a href="#tab_5" data-toggle="tab">CAM</a></li> --%>
                            <g:if test="${role}">
                            <li><a href="#tab_6" data-toggle="tab">Checklist</a></li>
                            </g:if>
                        <li><a href="#tab_7" data-toggle="tab">Attachment</a></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <g:render template="specification/form"/>
                    </div>
                    <div class="tab-pane" id="tab_2">
                        <g:render template="financialDetails/list"/>						
                    </div>
                    <div class="tab-pane" id="tab_3">
                        <g:render template="comakers/list"/>
                    </div>
                    <div class="tab-pane" id="tab_4">
                        <g:render template="collateral/list"/>
                    </div> 

<%-- <div class="tab-pane" id="tab_5">
    <g:render template="additional/form"/>
</div> --%>

                    <div class="tab-pane" id="tab_6">
                        <g:render template="loanApplicationChecklist/checklist"/>
                    </div>
                    <div class="tab-pane" id="tab_7">
                        <g:render template="attachments/list"/>
                    </div>
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
                    url: "${createLink(controller:'loanApplication', action:'showAttachmentsAjax')}",
                success: function(msg){                     
                $('#tab_7').html(msg);
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }

                function addAttachmentAjax() {
                var file = (document.getElementById("fileData")).files[0];                                

                var data = new FormData(); 
                data.append("file", file);
                data.append("description", $('#add-attachment-modal #description').val());
                data.append("type", $('#add-attachment-modal #type').val());

                $.ajax({
                type: 'POST',
                data: data,
                contentType: false,
                processData: false,
                    url: "${createLink(controller:'loanApplication', action:'addAttachmentAjax')}",
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
                    url: "${createLink(controller:'loanApplication', action:'updateAttachmentAjax')}",
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
                    url: "${createLink(controller:'loanApplication', action:'showUpdateAttachmentAjax')}",
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
                data: {id:id},
                        url: "${createLink(controller:'loanApplication', action:'deleteAttachmentAjax')}",
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
                    checkIfAllowed('LON00201', 'form#loan-application-form', 'Create Loan Application', null);
                    },
                    function(){
                    return;
                    });                         
                    "/></li>
                <!--
               <script type="text/javascript">
                            $(document).ready(function() {
                                $( "#save" ).click(function() {
                                         checkIfAllowed('LON00201', 'form#loan-application-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
                                });
                            }); 
                </script>
                -->
            <li><a href="#" onClick="callalertifyCondirmationCancel();">Cancel</a></li>
            <script>
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

                function showCollateral() {
                $.ajax({
                type: 'POST',
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
            updateCustomerInfoAjax({customer2:"${loanApplicationInstance?.customer?.id ?: customer?.id}"});
                });
                function AddComma()
                {

                $('#value').val(Comma( $('#value').val()));
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
            url: "${createLink(controller:'loanApplication', action:'deleteComakerAjax')}",
                success: function(msg){
                showComakers();
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }
                }
                function showFinancialDetails() {
                $.ajax({
                type: 'POST',
            url: "${createLink(controller:'loanApplication', action:'showFinancialDetailsAjax')}",
                success: function(msg){				    	
                $('#tab_2').html(msg);
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });				
                }

                function addFinancialDetailAjax() {

                var xaaaa = accounting.unformat($('#value').val());
                $.ajax({
                type: 'POST',
                data: {description:$('#description').val(), value:$('#value').val(), type:$('#type').val()},
            url: "${createLink(controller:'loanApplication', action:'addFinancialDetailAjax')}",
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
            url: "${createLink(controller:'loanApplication', action:'updateFinancialDetailAjax')}",
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
            url: "${createLink(controller:'loanApplication', action:'showUpdateFinancialDetailAjax')}",
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
            url: "${createLink(controller:'loanApplication', action:'deleteFinancialDetailAjax')}",
                success: function(msg){
                showFinancialDetails();
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(XMLHttpRequest+textStatus+errorThrown);
                }
                });
                }
                }
                function updateCustomerInfoAjax(params) {	
                if (params.customer2) {
                $.ajax({
                type: 'POST',
                data: {id:params.customer2},
            url: "${createLink(controller:'customer', action:'showBasicCustomerInfoAjax')}",
                success: function(msg){
                $('#customer-name').val($(msg).find('#display-name').html());
                $('#customer-me').val($(msg).find('#display-name').html());
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
                }
                function showCustomerSearch() {
            modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
                modal.show();                   
                }
                function callalertifyCondirmationCancel(){
                var x1 = "/icbs/loanApplication/index"
                alertify.confirm(AppTitle,"Are you sure you want to cancel?",
                function(){
                window.location = x1;
                },
                function(){
                alertify.error('Canceled');
                });
                }
            </script>
        </ul>
    </content>
</body>
</html>
