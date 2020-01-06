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
                   
                    var ratedItem = $('#ratedItem').val();
                    if(ratedItem == "" || ratedItem == null){
                        notify.message("Rated Section Item Details cannot be empty !|error|alert");
                    }else{
                        alertify.confirm(AppTitle,"Are you sure about this?",
                        function(){
                          $('#addRateditemsModal').hide()  
                          $('#addRatedItems').submit();
                        },
                        function(){
                          alertify.error('Canceled...');
                        });
                    }   
                }
                function validateUpdateFields(x){

                    var ratedItem = $('#ratedItem'+x).val();
                    if(ratedItem == "" || ratedItem == null){
                        notify.message("Rated Section Item Details cannot be empty !|error|alert");
                    }else{
                        alertify.confirm(AppTitle,"Are you sure about this?",
                        function(){
                          
                          $('#updateRatedItems'+x).submit();
                          $('#updatedRatedItemModal'+x).hide()  
                        },
                        function(){
                          alertify.error('Canceled...');
                        });
                    }   
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
                                            <td width="70%">${ratedInstance?.creditScoringCodeDescription?.code}</td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Rated Name Description</td>
                                            <td width="70%">${ratedInstance?.ratedName}</td>
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
       
                                            <td>Item Description</td>
                                            <td>Action</td>
                                        </tr>
                                        <g:each in="${ratedItemsInstance}" var="ratedItemListing" >
                                        <tr>
                                            <td>${ratedItemListing?.itemDescription}</td>
                                            <td><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updatedRatedItemModal${ratedItemListing?.id}">Update Item Description</button></td>
                                        </tr>
                                        <%-- UPDATE MOOOOOOOOOOOODALLLLLLLLL --%>
                                            <!-- Modal -->
                                        <div class="modal fade" id="updatedRatedItemModal${ratedItemListing?.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                          <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                              <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel">Section Score Sheet Item </h4>
                                              </div>
                                              <div class="modal-body">
                                               <g:form name="updateRatedItems" id="updateRatedItems${ratedItemListing?.id}" url="[action:'saveUpdateRatedItems',controller:'CreditScoring']" onsubmit="callLoadingDialog();" method="POST">


                                                    <g:hiddenField name="ratedId" id="ratedId${ratedItemListing?.id}" value="${ratedItemListing?.id}" /> 
                                                    <g:hiddenField name="parentCodeDescription" id="parentCodeDescription${ratedItemListing?.id}" value="${ratedInstance?.creditScoringCodeDescription?.id}" /> 


                                                    <div class="fieldcontain form-group">
                                                        <label class="control-label col-sm-4" for="">Rated Section Items</label>
                                                        <div class="col-sm-8"><g:textArea name="ratedItem" id="ratedItem${ratedItemListing?.id}"  rows="5" cols="40" required="" value="${ratedItemListing?.itemDescription}" class="form-control"/></div>
                                                    </div>
                                                    </br></br></br></br>


                                              </div>
                                              <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" onclick="validateUpdateFields('${ratedItemListing?.id}');">Save changes</button>

                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                        </g:form>
                                        <%-- =============================== --%>
                                        </g:each>
                                    </tbody>
                                </table>
                            </div>

                        </fieldset>
                    </div>
                </div> 
                 <!-- Modal -->
                <div class="modal fade" id="addRateditemsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Section Score Sheet Items</h4>
                      </div>
                      <div class="modal-body">
                       <g:form name="addRatedItems" id="addRatedItems" url="[action:'saveRatedItems',controller:'CreditScoring']" onsubmit="callLoadingDialog();" method="POST">
                            
                            
                            <g:hiddenField name="ratedId" id="ratedId" value="${ratedInstance?.id}" /> 
                            <g:hiddenField name="parentCodeDescription" id="parentCodeDescription" value="${ratedInstance?.creditScoringCodeDescription?.id}" /> 
                            
                            
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="">Rated Section Items</label>
                                <div class="col-sm-8"><g:textArea name="ratedItem" id="ratedItem"  rows="5" cols="40" required="" value="" class="form-control"/></div>
                            </div>
                            </br></br></br></br>
                            
                          
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
                    
                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addRateditemsModal">Create Score sheet Rated Item</button></li>
                    <li><g:link controller="creditScoring"  action="codeWithQuestionSectionDetails" id="${ratedInstance?.creditScoringCodeDescription?.id}" >Back</g:link></li>
                    
		</ul>
            </content>
	</body>
</html>
