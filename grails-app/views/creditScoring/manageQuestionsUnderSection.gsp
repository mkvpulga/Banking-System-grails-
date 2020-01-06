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
            <script>
                function validateCreateFields(){
                    alertify.confirm(AppTitle,"Are you sure about this?",
                    function(){
                      $('#myModal').hide()  
                      $('#creditScoringQuestion').submit();
                    },
                    function(){
                      alertify.error('Canceled...');
                    });
                }
            </script>   
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
                                            <td style="font-weight:bold" width="30%">Parent Code</td>
                                            <td width="70%">${sectionInstance?.creditScoringCodeDescription?.code}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Name of Section</td>
                                            <td width="70%">${sectionInstance?.nameOfSection}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </fieldset>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-md-12">
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header">Score Sheet Questions</legend>
                                <table class="table table-bordered table-striped">
                                    <tbody>
                                        <tr>
       
                                            <td>Question</td>
                                            <td>View Details</td>
                                        </tr>
                                        <g:each in="${xSectionQuestions}" var="descAndQuestion" >
                                        <tr>
                                            <td>${descAndQuestion?.questionNumberDescription}</td>
                                            <td><g:link class="btn btn-primary" controller="creditScoring"  action="viewQuestionDetails" id="${descAndQuestion?.id}">View Question Details</g:link></td>
                                        </tr>
                                        </g:each>
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
                        <h4 class="modal-title" id="myModalLabel">Section Score Sheet Items</h4>
                      </div>
                      <div class="modal-body">
                       <g:form name="creditScoringQuestion" id="creditScoringQuestion" url="[action:'saveQuestionUnderSection',controller:'CreditScoring']" onsubmit="callLoadingDialog();">
                            
                            <%--<div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Products
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                            </div> --%>
                            <g:hiddenField name="sectionId" id="sectionId" value="${sectionInstance?.id}" /> 
                            <g:hiddenField name="parentCodeDescription" id="parentCodeDescription" value="${sectionInstance?.creditScoringCodeDescription?.id}" /> 
                            
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Number and Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textField name="numberWithDescription" id="numberWithDescription" required="" value="" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice A Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionA" id="choiceDescriptionA" rows="4" cols="50" values="" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice B Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionB" id="choiceDescriptionB" rows="4" cols="50" values="" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Choice C Description
                                    <span class="required-indicator">*</span>
                                </label>
                                <div class="col-sm-8"><g:textArea name="choiceDescriptionC" id="choiceDescriptionC"  rows="4" cols="50" values="" class="form-control"/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Remarks/Notes (Optional)
                                    
                                </label>
                                <div class="col-sm-8"><g:textArea name="remarks" id="remarks" value="" rows="4" cols="50" values="" class="form-control"/></div>
                            </div>
                            </br></br></br></br>
                            <script>
                                // codes to undelete Format of choices prefix
                                $( document ).ready(function() {
                                    $('#choiceDescriptionA').val('A. ');
                                    $('#choiceDescriptionB').val('B. ');
                                    $('#choiceDescriptionC').val('C. ');
                                });
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
                        <button type="button" class="btn btn-primary" onclick="validateCreateFields();">Save changes</button>
                        
                      </div>
                    </div>
                  </div>
                </div>
                </g:form>
            </content>
            
           <content tag="main-actions">
                <ul>
                    
                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Create Score sheet Item</button></li>
                    <li><g:link controller="creditScoring"  action="codeWithQuestionSectionDetails" id="${sectionInstance?.creditScoringCodeDescription?.id}" >Back</g:link></li>
                    
		</ul>
            </content>
	</body>
</html>
