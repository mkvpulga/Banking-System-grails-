<%@ page import="icbs.loans.CreditInvestigation" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Create Credit Scoring Product</title>
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
            <div class="nav-tab-container">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab_1" data-toggle="tab">Details</a></li>
                    <li><a href="#tab_2" data-toggle="tab">Products</a></li>
                </ul>
            </div>		
            <div class="tab-content">
                <div class="tab-pane active fade in table-responsive" id="tab_1">
                    <g:form name="creditScoringProduct" id="creditScoringProduct" url="[action:'saveProduct',controller:'CreditScoring']">
                        <legend>Code Details</legend>
                            <%--<div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Products
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                            </div> --%>

                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Code
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textField name="code" id="code"  required="" value=""class="form-control" onblur="validateCode(this.value);"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textField name="description" id="description"   required="" value="" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Has Rated Items</label>
                                <div class="col-sm-8"><g:checkBox id="ishasRatedItem" name="ishasRatedItem"  value="false" class="form-control" /></div>
                            </div>
                    
                </div>
                <div class="tab-pane" id="tab_2">
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Products
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.findAllByProductType(icbs.lov.ProductType.get(6))}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                    </div>
                </div>
                </g:form>
            </div>
            
                    
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><button onclick="validateFields();">Save Credit Soring Product</button></li>
                    <li><g:link controller="creditScoring"  action="configProduct">Cancel</g:link></li>
                    <script>
                        var isCodeExist = "false";
                        function validateFields(){
                            var products = $('#products').val();
                            var code = $('#code').val();
                            var description = $('#description').val();
                            if(code == null || code==""){
                                notify.message("Code cannot be empty !|error|alert");
                            }else if(description == null || description==""){
                                notify.message("Description cannot be empty !|error|alert");
                            }else if(products == null || products==""){
                                notify.message("Product cannot be empty !|error|alert");
                            }else if(isCodeExist == "true"){
                                notify.message("Code Already Exists !|error|alert");
                            }else{
                                alertify.confirm(AppTitle,"Are you sure about this?",
                                    function(){
                                         $('#creditScoringProduct').submit();
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
