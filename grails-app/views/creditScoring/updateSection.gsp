<%@ page import="icbs.loans.CreditScoringCodeDescription" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Create Credit Scoring Section</title>
	</head>
	<body>
        <content tag="main-content">   
            <div id="list-creditInvestigation" class="content scaffold-list" role="main">
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
                <g:form onsubmit="callLoadingDialog();" name="creditScoringSection" id="creditScoringSection" url="[action:'updateSaveSection',controller:'CreditScoring']">
                    <legend>Section Details ${sectionInstance?.creditScoringCodeDescription?.id}</legend>
                    <%--<div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Products
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                    </div> --%>
                    <g:hiddenField name="sectionId" id="sectionId" value="${sectionInstance?.id}" />
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Loan Product Group Code
                            
                        </label>
                        <div class="col-sm-8"><g:select id="xxcode" name="xxcode" from="${icbs.loans.CreditScoringCodeDescription.list()}" optionKey="id" optionValue="code" value="${sectionInstance?.creditScoringCodeDescription?.id}" class="many-to-one form-control" disabled="disable"></g:select></div>
                        <g:hiddenField name="code" id="code" value="${sectionInstance?.creditScoringCodeDescription?.id}" />
                    </div>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Loan Product Group Name
                            
                        </label>
                        <div class="col-sm-8"><g:textField name="groupName" id="groupName"   required="" value="${sectionInstance?.creditScoringCodeDescription?.description}" class="form-control" disabled="disable" /></div>
                    </div>
                    
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Name of Section
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:textField name="sectionName" id="sectionName"   required="" value="${sectionInstance?.nameOfSection}" class="form-control"/></div>
                    </div>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Percentage
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:field type="number" name="sectionPercentage" id="sectionPercentage"  required="" value="${sectionInstance?.sectionPercentage}" class="form-control" /></div>
                    </div>
                </g:form>
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><button onclick="validateFields();">Update Section Details</button></li>
                    <li><g:link controller="creditScoring"  action="codeWithQuestionSectionDetails" id="${sectionInstance?.creditScoringCodeDescription?.id}">Cancel</g:link></li>
                    <script>
                        var isCodeExist = "false";
                        function validateFields(){
                            var code = $('#code').val();
                            var sectionName = $('#sectionName').val();
                            
                            var sectionPercentage = $('#sectionPercentage').val();
                            if(code == null || code==""){
                                notify.message("Code cannot be empty !|error|alert");
                            }else if(sectionName == null || sectionName==""){
                                notify.message("Section Name cannot be empty !|error|alert");
                            }else if(sectionPercentage == null || sectionPercentage == ""){
                                notify.message("Section Percentage cannot be empty !|error|alert");
                            }else{
                                alertify.confirm(AppTitle,"Are you sure about this?",
                                    function(){
                                         $('#creditScoringSection').submit();
                                    },
                                    function(){
                                      alertify.error('Canceled..');
                                    });
                            }
                            
                        }
                        function validateCode(xcode){
                            var obj = { 
                                xcode: xcode,
                                actionType: 'create',
                            }; 
                            console.log(JSON.stringify(obj));
                            console.log("Object Loaded iwth data...");
                            $.ajax({
                                type: "POST",
                                contentType: "application/json",
                                url: "${createLink(controller:'CreditScoring', action:'validateExisitingCode')}",
                                data: JSON.stringify(obj),

                                success: function(data){

                                    if(data.length >=1){
                                        isCodeExist = "true";
                                        notify.message('Code Already Exists! Try another code |error|alert'); 
                                    }else{
                                        isCodeExist = "false";
                                    }
                                },
                                error: function(data){

                                },

                            });     
                        }
                    </script>
		</ul>
            </content>
	</body>
</html>
