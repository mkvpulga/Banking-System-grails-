<%@ page import="icbs.loans.CreditInvestigation" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Credit Scoring Product Information</title>
	</head>
	<body>
        <content tag="main-content">
            <script>
                  function validatePreQualification(x){
                    alertify.confirm(AppTitle,"Are you sure about this ?",
                        function(){
                             $('#myModal'+x).hide();   
                             $('#creditScoringQuestion'+x).submit();
                        },
                        function(){
                          alertify.error('Cancel');
                        });
                  }
                  function validateRated(y){
                    console.log("y: "+y);
                    var ratedItem = $('#ratedName'+y).val();
                    console.log("ratedItem: "+ratedItem);
                    if(ratedItem == "" || ratedItem == null){
                        notify.message("Rated Section Details cannot be empty !|error|alert");
                    }else{
                        alertify.confirm(AppTitle,"Are you sure about this ?",
                        function(){
                             $('#updateRatedDetails'+y).hide();   
                             $('#creditScoringRated'+y).submit();
                        },
                        function(){
                          alertify.error('Canceled....');
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
                    <legend class="section-header">Details</legend>


                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Code</td>
                                        <td width="70%">${codeInstance?.code}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Description</td>
                                        <td width="70%">${codeInstance?.description}</td>
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
                        <legend class="section-header"><strong>PRE-QUALIFICATION CHECK LIST:  </strong></legend>
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        
                                        <tr>
                                            <th>Item Description</th>
                                            <th>Action</th>
                                        </tr>
                                        <g:each in="${prequalificationList}" var="preQualification" >
                                            <tr>
                                                    <td>${preQualification?.preQualificationItem}</td>
                                                    <td><button class="btn btn-info" data-toggle="modal" data-target="#myModal${preQualification.id}">Update Details</button></td>
                                            </tr>
                                             <!-- Modal -->
                                            <div class="modal fade" id="myModal${preQualification.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                              <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                  <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="myModalLabel">Section Score Sheet Items</h4>
                                                  </div>
                                                  <div class="modal-body">
                                                   <g:form name="creditScoringQuestion" id="creditScoringQuestion${preQualification.id}" url="[action:'updatePreQualification',controller:'CreditScoring']" onsubmit="callLoadingDialog();">

                                                        <%--<div class="fieldcontain form-group">
                                                            <label class="control-label col-sm-4" for="">Products
                                                                <span class="required-indicator">*</span>
                                                            </label>
                                                            <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" value="" class="many-to-one form-control" multiple="" /></div>
                                                        </div> --%>
                                                        <g:hiddenField name="sectionId" id="sectionId${preQualification?.id}" value="${preQualification?.id}" /> 
                                                        <g:hiddenField name="parentCodeDescription" id="parentCodeDescription${preQualification.id}" value="${preQualification?.creditScoringCodeDescription?.id}" /> 

                                                        <div class="fieldcontain form-group">
                                                            <label class="control-label col-sm-4" for="">Item Description
                                                                <span class="required-indicator">*</span>
                                                            </label>
                                                            <div class="col-sm-8"><g:textField name="qualificationItem" id="qualificationItem${preQualification.id}" required="" value="${preQualification?.preQualificationItem}" class="form-control"/></div>
                                                        </div>

                                                        </br></br></br></br>

                                                  </div>
                                                  <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary" onclick="validatePreQualification('${preQualification?.id}');">Save changes</button>

                                                  </div>
                                                </div>
                                              </div>
                                            </div>
                                        </g:form>
                                        </g:each>     
                                             
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
                        <legend class="section-header"><strong>Sections of Credit Risk Rating Score Sheet</strong></legend>
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        
                                        <th>Section Details</td>
                                        <th>Section Percentage</td>
                                        <th>Update Section & Manage Questions</td>    
                                    </tr>
                                    <g:each in="${sectionOfQuestionInstance}" var="sectionQuestion" >
                                        <tr>
                                            
                                            <td>${sectionQuestion?.nameOfSection}</td>
                                            <td>${sectionQuestion?.sectionPercentage} %</td>
                                            <td><g:link class="btn btn-success" action="updateSection" id="${sectionQuestion.id}"> Update Section</g:link><g:link class="btn btn-primary" action="manageQuestionsUnderSection" id="${sectionQuestion.id}"> Manage Questions</g:link></td>
                                        </tr>
                                        
                                    </g:each>
                                    
                                </tbody>
                            </table>
                        </div>

                    </fieldset>
                </div>
            </div> 
            
            <g:if test="${Boolean.valueOf(codeInstance?.hasRatedItem) == true}">
            <div class="row">
                <div class="col-md-12">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><strong>Rated Risk Assessment Section List</strong></legend>
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        
                                        <th>Section Details</th>
                                        <th>Update Rated Name & Manage Items</th>    
                                    </tr>
                                    <g:each in="${ratedList}" var="ratedInstance" >
                                        <tr>
                                            <td>${ratedInstance?.ratedName}</td>
                                            <td><button class="btn btn-success" data-toggle="modal" data-target="#updateRatedDetails${ratedInstance.id}">Update Details</button><g:link class="btn btn-primary" action="createRatedItemList" id="${ratedInstance.id}"> Manage Rated Scoring Items</g:link></td>
                                        </tr>
                                         <!-- Modal -->
                                            <div class="modal fade" id="updateRatedDetails${ratedInstance.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                              <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                  <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="myModalLabel">Section Score Sheet Items</h4>
                                                  </div>
                                                  <div class="modal-body">
                                                   <g:form name="creditScoringRated" id="creditScoringRated${ratedInstance.id}" url="[action:'updateRated',controller:'CreditScoring']" onsubmit="callLoadingDialog();">

                                                        <g:hiddenField name="ratedId" id="ratedId${ratedInstance?.id}" value="${ratedInstance?.id}" /> 
                                                        <g:hiddenField name="parentCodeDescription" id="parentCodeDescription${ratedInstance?.id}" value="${ratedInstance?.creditScoringCodeDescription?.id}" /> 

                                                        <div class="fieldcontain form-group">
                                                            <label class="control-label col-sm-4" for="">Rated Section Description
                                                                <span class="required-indicator">*</span>
                                                            </label>
                                                            <div class="col-sm-8"><g:textArea name="ratedName" id="ratedName${ratedInstance?.id}"  rows="5" cols="40"  required="" value="${ratedInstance?.ratedName}" class="form-control"/></div>
                                                        </div>

                                                        </br></br></br></br>

                                                  </div>
                                                  <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary" onclick="validateRated('${ratedInstance?.id}');">Save changes</button>

                                                  </div>
                                                </div>
                                              </div>
                                            </div>
                                        </g:form>
                                    </g:each>
                                    
                                </tbody>
                            </table>
                        </div>

                    </fieldset>
                </div>
            </div> 
            </g:if>
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><g:link controller="creditScoring" action="createPreQualification" id="${params.id}" >New Pre Qualification Check List</g:link></li>
                    <li><g:link controller="creditScoring" action="createSection" id="${params.id}" >Create Question Section Config</g:link></li>
                    <g:if test="${Boolean.valueOf(codeInstance?.hasRatedItem) == true}">
                        <li><g:link controller="creditScoring" action="createRatedList" id="${params.id}" >Create Credit Scoring Rated Sections</g:link></li>
                    </g:if>
                    <li><g:link conntroller="creditScoring"  action="configSection">Index</g:link></li>
		</ul>
            </content>
	</body>
</html>
