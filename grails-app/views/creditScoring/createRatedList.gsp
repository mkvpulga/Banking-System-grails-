<%@ page import="icbs.loans.CreditScoringCodeDescription" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Create Credit Scoring Rated Sections</title>
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
                <g:form name="creditScoringRated" id="creditScoringRated" url="[action:'saveRatedSection',controller:'CreditScoring']" onsubmit="callLoadingDialog();" method="POST">
                    <legend>Section Details</legend>
                    <%--<div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Products
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                    </div> --%>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Loan Product Group Code
                            
                        </label>
                        <div class="col-sm-8"><g:select id="xcode" name="xcode" from="${icbs.loans.CreditScoringCodeDescription.list()}" optionKey="id" optionValue="code" value="${codeInstance?.id}" class="many-to-one form-control" disabled="disable"></g:select></div>
                    </div>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Loan Product Group Name
                            
                        </label>
                        <div class="col-sm-8"><g:textField name="groupName" id="groupName"   required="" value="${codeInstance?.description}" class="form-control" disabled="disable" /></div>
                    </div>
                    <g:hiddenField name="code" id="code" value="${codeInstance?.id}" />
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Rated Section Details
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-8"><g:textArea name="ratedName" id="ratedName"  rows="5" cols="40" required="" value="" class="form-control"/></div>
                    </div>
                </g:form>
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><button onclick="validateFields();">Save Credit Soring Product</button></li>
                    <li><g:link controller="creditScoring"  action="codeWithQuestionSectionDetails" id="${params.id}">Back</g:link></li>
                    <script>
                        var isCodeExist = "false";
                        function validateFields(){
                            var code = $('#code').val();
                            var sectionName = $('#ratedName').val();
                            console.log("code: "+code);
                            var sectionPercentage = $('#sectionPercentage').val();
                            if(code == null || code==""){
                                notify.message("Code cannot be empty !|error|alert");
                            }else if(sectionName == null || sectionName==""){
                                notify.message("Rated Section Details cannot be empty !|error|alert");
                            }else{
                                alertify.confirm(AppTitle,"Are you sure about this?",
                                    function(){
                                         $('#creditScoringRated').submit();
                                    },
                                    function(){
                                      alertify.error('Canceled..');
                                    });
                            }
                            
                        }
                        
                    </script>
		</ul>
            </content>
	</body>
</html>
