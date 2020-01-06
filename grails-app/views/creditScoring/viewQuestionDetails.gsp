<%@ page import="icbs.loans.CreditScoringCodeDescription" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Score Sheet Items</title>
	</head>
	<body>
        <content tag="main-content">   
            <g:javascript> 
                function validateUpdateFields(){
                    alertify.confirm(AppTitle,"Are you sure about this?",
                    function(){
                      $('#myModal').hide();  
                      $('#creditScoringQuestion').submit();
                    },
                    function(){
                      alertify.error('Canceled...');
                    });
                }
                
                
            </g:javascript>    
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
                <div class="row">
                    <div class="col-md-12">
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Details</legend>
                                <table class="table table-bordered table-striped">
                                    <tbody>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Question</td>
                                            <td width="70%"><strong>${questionInstance?.questionNumberDescription}</strong></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Choice A Description</td>
                                            <td width="70%">${questionInstance?.choiceDescriptionA}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Choice B Description</td>
                                            <td width="70%">${questionInstance?.choiceDescriptionB}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Choice C Description</td>
                                            <td width="70%">${questionInstance?.choiceDescriptionC}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Remarks / Notes</td>
                                            <td width="70%">${questionInstance?.remarks}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </fieldset>
                    </div>
                </div> 
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Update Question and Choice Details</h4>
                      </div>
                      <div class="modal-body">
                       <g:form onsubmit="callLoadingDialog();" name="creditScoringQuestion" id="creditScoringQuestion" url="[action:'saveUpdateQuestionUnderSection',controller:'CreditScoring']">
                            
                            <%--<div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Products
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                            </div> --%>
                            <g:hiddenField name="questionId" id="questionId" value="${questionInstance?.id}" /> 
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Number and Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textField name="numberWithDescription" id="numberWithDescription" required="" value="${questionInstance?.questionNumberDescription}" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice A Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionA" id="choiceDescriptionA"  rows="4" cols="50" required="" value="${questionInstance?.choiceDescriptionA}"  class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice B Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionB" id="choiceDescriptionB"  rows="4" cols="50" required="" value="${questionInstance?.choiceDescriptionB}" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice C Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionC" id="choiceDescriptionC"  rows="4" cols="50" required="" value="${questionInstance?.choiceDescriptionC}" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Remarks/Notes (Optional)
                                    
                                </label>
                                <div class="col-sm-8"><g:textArea name="remarks" id="remarks"  rows="4" cols="50" required="" value="${questionInstance?.remarks}" class="form-control"/></div>
                            </div>
                            </br></br></br></br>
                            <script>
                                // codes to undelete Format of choices prefix
                                $('#choiceDescriptionA').keydown(function(e) {
                                        var codeUniversal = "A. ";
                                        var oldvalue=$(this).val();
                                        var field=this;
                                        setTimeout(function () {
                                                if(field.value.indexOf(codeUniversal) !== 0) {
                                                        $(field).val(oldvalue);
                                                } 
                                        }, 1);
                                });
                                $('#choiceDescriptionB').keydown(function(e) {
                                        var codeUniversal = "B. ";
                                        var oldvalue=$(this).val();
                                        var field=this;
                                        setTimeout(function () {
                                                if(field.value.indexOf(codeUniversal) !== 0) {
                                                        $(field).val(oldvalue);
                                                } 
                                        }, 1);
                                });
                                $('#choiceDescriptionC').keydown(function(e) {
                                        var codeUniversal = "C. ";
                                        var oldvalue=$(this).val();
                                        var field=this;
                                        setTimeout(function () {
                                                if(field.value.indexOf(codeUniversal) !== 0) {
                                                        $(field).val(oldvalue);
                                                } 
                                        }, 1);
                                });
                            </script>
                          
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="validateUpdateFields();">Save changes</button>
                        
                      </div>
                    </div>
                  </div>
                </div>
                </g:form>
                 <g:form name="myForm" id="myDeleteFrom" url="[action:'deleteQuestion',controller:'CreditScoring']" method="POST" >
                    <g:hiddenField name="xquestionId" id="xquestionId" value="${questionInstance?.id}" />
                </g:form> 
            </content>
            
           <content tag="main-actions">
                <ul>
                    
                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Update</button></li>
                    <li><button onclick="confirmDeleteQuestion();">Delete</button></li>
                    <li><g:link controller="creditScoring"  action="manageQuestionsUnderSection" id="${questionInstance?.creditScoringQuestionSection?.id}" >Back</g:link></li>
                    <script>
                        var isCodeExist = "false";
                        function validateFields(){
                            $('#creditScoringQuestion').submit();
                        }
                        function confirmDeleteQuestion(){
                            alertify.confirm(AppTitle,"Are you sure to Delete this Question?",
                                function(){
                                  $('#myDeleteFrom').submit();
                                },
                                function(){
                                  alertify.error('Canceled');
                                }
                            );
                            
                        }
                    </script>
		</ul>
            </content>
	</body>
</html>
