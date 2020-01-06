
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.loans.GroupRecord" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'loanApplication.label', default: 'LoanApplication')}" />
        <title>Loan Application Information</title>

    </head>
    <body>
    <content tag="main-content">   
        <g:javascript>

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
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }
            //Override transfer status
            function updateStatusAjax(){
            checkIfAllowed('LON01700', status); // params: policyTemplate.code, form to be saved
            }

            function updateAmount() 
            {
            var Amt = accounting.unformat($('#value').val());
            if (isNaN(Amt))
            Amt = 0;
            $('#value').val(Amt);
            }

            //update status
            function status() {
            $.ajax({
            type: 'POST',
            data: $('#update-status-form').serialize(),
            url: "${createLink(controller :'loanApplication', action:'updateStatusAjax')}",
            success: function(msg){
            jQuery('#update-status-modal .modal-body').html(msg);
            $('#update-status-modal').on('hidden.bs.modal', function() {
            location.reload(true);
            });
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest+textStatus+errorThrown);
            }
            });
            }



            icbs.Dependencies.Ajax.addLoadEvent(function(){
            updateCustomerInfoAjax({customer2:"${loanApplicationInstance?.customer?.id}"});
            });


            function showUpdateStatus() {
            modal = new icbs.UI.Modal({id:"update-status-modal", url:"${createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id])}", title:"Update Status"});		    	
            modal.show();
            }     

            function promptAlertify(){
            notify.message('This Loan Application is being used by other Loan Account!|info|alert'); 
            }
            function emptyCam(){
            notify.message('Please update CAM details!|info|alert'); 
            }

        </g:javascript>
        <div id="show-loanApplication" class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <script>

                    $(function(){
                            var x = '${flash.message}';
                    notify.message(x);return;
                    });
                </script>
            </g:if>
            <div class="nav-tab-container">
                <ul class="nav nav-tabs">
                   <%-- <g:if test="${user?.designation?.id == 30 || user?.designation?.id == 17 || user?.designation?.id == 19 || user?.id == 1}"> --%>
                    <li class="active"><a href="#tab_1" data-toggle="tab">Specification</a></li>
                    <li><a href="#tab_2" data-toggle="tab">Financial Details</a></li>
                    <li><a href="#tab_3" data-toggle="tab">Co-Makers</a></li>
                    <li><a href="#tab_4" data-toggle="tab">Collateral</a></li>

                    <li><a href="#tab_7" data-toggle="tab">Credit Scoring</a></li>

                    <li><a href="#tab_5" data-toggle="tab">CAM</a></li>
                        
                        <li><a href="#tab_8" data-toggle="tab">Checklist</a></li>
                       
                    <li><a href="#tab_6" data-toggle="tab">Attachments</a></li>
                  <%--  </g:if>
                   <g:elseif test="${user?.designation?.id == 33}">

                    <li class="active"><a href="#tab_4" data-toggle="tab">Collateral</a></li>

                    </g:elseif> --%>
                </ul>
            </div>
            <div class="tab-content">

                <div class="tab-pane active fade in" id="tab_1">
                    <g:render template="specification/show"/>
                </div>
                <div class="tab-pane" id="tab_2">
                    <g:render template="financialDetails/show"/>
                </div>
                <div class="tab-pane" id="tab_3">
                    <g:render template="comakers/show"/>
                </div>
                <div class="tab-pane" id="tab_4">
                    <g:render template="collateral/show"/>
                </div>
                <div class="tab-pane" id="tab_7">
                    <g:render template="creditScoring/list"/>
                </div>
                <div class="tab-pane" id="tab_5">
                    <g:render template="additional/show"/>
                </div>
                <div class="tab-pane" id="tab_8">
                    <g:render template="loanApplicationChecklist/showchecklist"/>
                </div>
                <div class="tab-pane" id="tab_6">
                    <g:render template="attachments/show"/>
                </div>


            </div>		

            <div class="modal" id="update-status-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Update Status</h4>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updateStatusAjax()">Save</a>
                        </div>
                    </div>
                </div>
            </div>
            <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                <g:form name="editRommendationForm" id="editRommendationForm" url="[action:'saveUpdateRecommededCrr',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">
                <!-- Modal -->
                    <div class="modal fade" id="updatechangeRecommendation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Update Recommendation CRR Form</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="">Recommended CRR
                                        </label>
                                        <g:hiddenField name="editcreditInvestigationId" id="editcreditInvestigationId" value="${creditInvestigationInstance?.id}" />
                                        <g:hiddenField name="editmatrixId" id="editmatrixId" value="${initialCrrRatingScores?.recommendedCrrRating.id}" />
                                        <div class="col-sm-8"><g:textField type="number" name="editrecCrr" id="editrecCrr" onblur="updategetRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrScore.toInteger()}" class="form-control"/></div>
                                    </div>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-md-4" for="">Risk Assessment 
                                        </label>
                                        <div class="col-sm-8"><g:textField name="editriskAssessment" id="editriskAssessment" onblur="getRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment}" class="form-control" disabled="true"/></div>
                                    </div>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-md-4" for="">Risk Level
                                        </label>
                                        <div class="col-sm-8"><g:textField name="editriskLevel" id="editriskLevel" onblur="getRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrRating?.riskLevel}" class="form-control" disabled="true"/></div>
                                    </div>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-md-4" for="">Justification for Recommended CRR
                                        </label>
                                        <div class="col-sm-8"><g:textArea id="justification" name="justification" value="${initialCrrRatingScores?.justification}" class="form-control" /></div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" onclick="updateSaveRecommendation();">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </g:form>
            </g:if>    
            <g:form name="addRecommendation" id="addRecommendation" url="[action:'saveRecommededCrr',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">
            <!-- Modal -->
                <div class="modal fade" id="changeRecommendation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Recommendation CRR Form</h4>
                            </div>
                            <div class="modal-body">
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="">Recommended CRR
                                    </label>
                                    <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                                    <g:hiddenField name="matrixId" id="matrixId" value="" />
                                    <div class="col-sm-8"><g:textField type="number" name="recCrr" id="recCrr"  onblur="getRiskRating();" values="" class="form-control"/></div>
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-md-4" for="">Risk Assessment
                                    </label>
                                    <div class="col-sm-8"><g:textField type="number" name="riskAssessment" id="riskAssessment" rows="4" cols="50" values="" class="form-control" disabled="true"/></div>
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-md-4" for="">Risk Level
                                    </label>
                                    <div class="col-sm-8"><g:textField type="number" name="riskLevel" id="riskLevel" rows="4" cols="50" values="" class="form-control" disabled="true"/></div>
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-md-4" for="">Justification for Recommended CRR
                                    </label>
                                    <div class="col-sm-8"><g:textArea id="justification" name="justification" value="" class="form-control" /></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="saveAddRecommendation();">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </g:form>



            <g:if test="${initialCrrRatingScores?.scoreCompletenessOfDocument}">
                <g:form name="completenessOfDoducmentForm" url="[action:'updateCompletenessRecord',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">                            
              <!-- Modal -->
                    <div class="modal fade" id="complenessModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">COMPLETENESS OF REQUIRED DOCUMENTS</h4>
                                </div>
                                <div class="modal-body">
                                    <label for="">A. Complete and enforceable documentation</label>
                                    <label for="">B. Acceptable (with deficiencies but covered by Exception Rectification Sheet or ERS by CAD)</label>
                                    <label for="">C. Insufficient or incomplete documentation to include :</label>
                                    <ul>
                                        <li>Missing collateral folders  and documents including but not limited to title, mortgage instruments, and PNs</li>
                                        <li>Unsigned PN or PN signed by unauthorized persons/officers of the borrowing entity</li>
                                        <li>No updated Credit Investigation Report, no latest BIR-stamped Income Tax Return, or Audited Financial Statement</li>
                                    </ul>

                                    <g:hiddenField name="editCI" id="editCI" value="${creditInvestigationInstance?.id}" />    

                                    <g:select noSelection="['':'-Set Score Here-']" id="completeNessRequired" name="completeNessRequired" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="${initialCrrRatingScores?.scoreCompletenessOfDocument?.id}" class="many-to-one form-control" ></g:select>



                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" onclick="saveCompletenessOfDocuments();">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </g:form>
            </g:if>
            <g:form name="completenessOfDoducmentForm" url="[action:'addCompletenessRecord',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">                            
               <!-- Modal -->
                <div class="modal fade" id="complenessModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">COMPLETENESS OF REQUIRED DOCUMENTS</h4>
                            </div>
                            <div class="modal-body">
                                <label for="">A. Complete and enforceable documentation</label>
                                <label for="">B. Acceptable (with deficiencies but covered by Exception Rectification Sheet or ERS by CAD)</label>
                                <label for="">C. Insufficient or incomplete documentation to include :</label>
                                <ul>
                                    <li>Missing collateral folders  and documents including but not limited to title, mortgage instruments, and PNs</li>
                                    <li>Unsigned PN or PN signed by unauthorized persons/officers of the borrowing entity</li>
                                    <li>No updated Credit Investigation Report, no latest BIR-stamped Income Tax Return, or Audited Financial Statement</li>
                                </ul>

                                <g:hiddenField name="CI" id="CI" value="${creditInvestigationInstance?.id}" />    

                                <g:select noSelection="['':'-Set Score Here-']" id="completeNessRequired" name="completeNessRequired" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="${initialCrrRatingScores?.scoreCompletenessOfDocument?.id}" class="many-to-one form-control" ></g:select>



                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="saveCompletenessOfDocuments();">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </g:form>
        </div>
    </content>
    <content tag="main-actions">
        <ul>
            <li><g:link class="list" action="index">Search Loan Application</g:link></li>
            <li><g:link action="edit" resource="${loanApplicationInstance}">Update Loan Application</g:link></li>
                <li><a href="#" onclick="genReportLNA001();">Print Loan Application Form</a></li>

                <g:if test="${user?.designation?.id == 17 || user?.designation?.id == 30 || user?.designation?.id == 33 || user?.id == 15}">
                <li><a href="#" onclick="showUpdateStatus();">Update Status</a></li>
                </g:if> 
                <g:if test="${user?.designation?.id == 33}">
                <li><g:link controller="creditInvestigation" action="create" params="[id:loanApplicationInstance?.id]">Perform Credit Investigation</g:link></li>
                </g:if>    
                <g:if test="${user?.designation?.id == 17}">
                    <g:if test="${isLoanApplicationExist == 'true'}">
                    <li><a href="#" onclick="promptAlertify();" disabled="disabled">Create Loan Account</a></li>

                    </g:if>   

                    <g:else>

                    <li><g:link controller="loan" action="create" disable="disabled" params="[id:loanApplicationInstance?.id]">Create Loan Account</g:link></li>
                    </g:else>  
                </g:if>
                <g:if test="${user?.id == 16 || user?.designation?.id == 30 || user?.designation?.id == 19 }">
                    <g:if test="${loanApplicationSpecAdd}">

                    <li><g:link action="showCam" id="${loanApplicationInstance?.id}">Credit Approval Memorandum</g:link></li>
                    </g:if>

                    <g:else>
                    <li><button onclick="emptyCam();">Credit Approval Memorandum</button></li>
                    </g:else>
                </g:if>
              <%--<li><a href="#" onclick="window.print()">Print Details</a></li>--%>
                <g:if test="${user?.designation?.id == 17}">
                <p style="background-color: grey; text-align:center;">FOR CREDIT SCORING</p>
                <g:if test="${creditScoringProductConfigInstance}" >
                    <g:if test="${creditInvestigationInstance}" >
                        <li><g:link class="list" controller="creditInvestigation" action="updateCredScorLoanAppDet" id="${creditInvestigationInstance?.id}" >Update Credit Score Loan App Details</g:link></li>
                            <g:if test="${preQualificationInstance}">
                            <li><g:link class="list" controller="creditInvestigation" action="updatePreQualificaion" id="${creditInvestigationInstance?.id}" >Update Performed Pre Qualification Credit Score</g:link></li>
                            </g:if>   
                            <g:else>
                            <li><g:link class="list" controller="creditInvestigation" action="preQualification" id="${creditInvestigationInstance?.id}" >Perform Pre Qualification  Credit Score</g:link></li>
                            </g:else>    
                            <g:if test="${Boolean.valueOf(isQualifiedForCheckList) == true}">
                                <g:if test="${Boolean.valueOf(isCheckListAlreadyDone) == true}">
                                <li><g:link class="list" controller="creditInvestigation" action="updatePerformedCreditScoring" id="${creditInvestigationInstance?.id}" >Update Perform Credit Scoring</g:link></li>
                                    <g:if test="${initialCrrRatingScores}">
                                        <g:if test="${Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem) == true}" >

                                            <g:if test="${Boolean.valueOf(isRatedAlreadyEvaluated) == true}">
                                            <li><g:link class="list" controller="creditInvestigation" action="updatePerformedRated" id="${creditInvestigationInstance?.id}" >Update Performed Rated Items</g:link></li>
                                            </g:if> 
                                            <g:else>
                                            <li><g:link class="list" controller="creditInvestigation" action="performRatedItems" id="${creditInvestigationInstance?.id}" >Perform Rated Section Scoring</g:link></li>
                                            </g:else>    

                                            <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                                            <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updatechangeRecommendation">Update Recommendation CRR</button></li>
                                            </g:if>
                                            <g:else>
                                            <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#changeRecommendation">Add Recommendation CRR</button></li>
                                            </g:else>
                                        </g:if>    
                                        <g:else>
                                            <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                                            <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updatechangeRecommendation">Update Recommendation CRR</button></li>
                                            </g:if>
                                            <g:else>
                                            <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#changeRecommendation">Add Recommendation CRR</button></li>
                                            </g:else>
                                        </g:else>     
                                    </g:if>
                                <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#complenessModalForm">Evaluate Completeness Of Required Docs</button></li>

                                </g:if>
                                <g:else>
                                <li><g:link class="list" controller="creditInvestigation" action="performCreditScoring" id="${creditInvestigationInstance?.id}" >Perform Credit Scoring</g:link></li>
                                </g:else>
                            </g:if>    
                            <g:else>
                            <li><button disabled="disable">Perform Credit Scoring</button></li>
                            </g:else>  
                        </g:if>
                        <g:else>
                        <p style="background-color: dodgerblue; text-align:center;">Please complete credit investigation first.</p>
                    </g:else>
                </g:if>
                <g:else>
                    <p style="background-color: dodgerblue; text-align:center;">Please Configure Product of Loan Application under Configuration -> Credit Scoring Maintenance</p>
                </g:else>
            </g:if>

        </ul>

        <g:javascript>
            function saveAddRecommendation(){
            alertify.confirm(AppTitle,"Are you sure about this?",
            function(){
            $('#addRecommendation').submit();
            $('#changeRecommendation').hide();
            },
            function(){
            alertify.error('Cancel');
            });
            }

            function updateSaveRecommendation(){
            alertify.confirm(AppTitle,"Are you sure about this?",
            function(){
            $('#editRommendationForm').submit();
            $('#updatechangeRecommendation').hide();
            },
            function(){
            alertify.error('Cancel');
            });
            }
            function getRiskRating(){
            var recommendedCrr = $('#recCrr').val();

            var obj = { 
            calculatedbrr: recommendedCrr,
            }; 
            $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${createLink(controller:'creditInvestigation', action:'getRiskRatingAjax')}",
            data: JSON.stringify(obj),

            success: function(data){
            if(data.length >=1){
            $.each(data, function (_key, _value) {
            console.log(JSON.stringify(data))

            $('#riskAssessment').val(_value.rating_assessment);
            $('#riskLevel').val(_value.risk_level);
            $('#matrixId').val(_value.id);

            });

            }else{

            notify.message('Sorry, No Risk Assessment found for Recommended CRR value |error|alert');

            }


            },
            error: function(data){

            },

            }); 
            }
            function updategetRiskRating(){

            var recommendedCrr = $('#editrecCrr').val();

            var obj = { 
            calculatedbrr: recommendedCrr,
            }; 
            $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${createLink(controller:'creditInvestigation', action:'getRiskRatingAjax')}",
            data: JSON.stringify(obj),

            success: function(data){
            if(data.length >=1){
            $.each(data, function (_key, _value) {
            console.log(JSON.stringify(data))

            $('#editriskAssessment').val(_value.rating_assessment);
            $('#editriskLevel').val(_value.risk_level);
            $('#editmatrixId').val(_value.id);

            });

            }else{

            notify.message('Sorry, No Risk Assessment found for Recommended CRR value |error|alert');

            }


            },
            error: function(data){

            },

            }); 
            }
            function saveCompletenessOfDocuments(){
            var completnessEvaluation = $('#completeNessRequired').val();
            if(completnessEvaluation == null || completnessEvaluation == ""){
            notify.message('Sorry, Please Set an evaluation to continue |error|alert');
            }else{
            alertify.confirm(AppTitle,"Are you sure about this ?",
            function(){
            $('#completenessOfDoducmentForm').submit();
            $('#complenessModalForm').hide();
            },
            function(){
            alertify.error('Canceled...');
            });
            }


            }
            function genReportLNA001(){
            reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(16).baseParams}&output=${icbs.admin.Report.get(16).outputParam}";
            reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(16).reportUnit}";             
            reportlink = reportlink + "&loan_application_id=${loanApplicationInstance?.id}";
            reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
            sendtojasperver(reportlink);
            }       
        </g:javascript>
    </content>
</body>
</html>
