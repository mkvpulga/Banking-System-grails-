<%@ page import="icbs.loans.CreditScoringCodeDescription" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Update Credit Scoring Loan Application Details</title>
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
                
                <div class="fieldcontain form-group">
                    <label class="control-label col-sm-4" for="">Name
                        <span class="required-indicator">*</span>
                    </label>
                    <div class="col-sm-8"><g:textField name="name" id="name"   required="" value="${creditInvestigationInstance?.loanApplication?.customer?.displayName}" class="form-control" disabled="disable"/></div>
                </div>
                <g:if test="${scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true}" >
                    <g:form name="formWithRated" id="formWithRated" url="[action:'xSaveUpdateDetailsLoanAppDetCredScor',controller:'CreditInvestigation']" onsubmit="callLoadingDialog();">
                        <g:hiddenField name="credInvestigationId" id="credInvestigationId" value="${creditInvestigationInstance.id}" />
                        <g:hiddenField name="confihasRated" id="confihasRated" value="${Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem)}" /> 
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Originating unit
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="originatingUnit" id="originatingUnit"   required="" value="${loanApplicationCredScorDetails?.originatingUnit}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Contact Number
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="contactNumber" id="contactNumber"   required="" value="${loanApplicationCredScorDetails?.contactNumber}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Name of Business
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="nameOfBusiness" id="nameOfBusiness"   required="" value="${loanApplicationCredScorDetails?.nameOfBusiness}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Industry/Subsector 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="industrySubsector" id="industrySubsector"   required="" value="${loanApplicationCredScorDetails?.industrySubsector}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Previous CRR/Rating
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="previousRating" id="previousRating"   required="" value="${loanApplicationCredScorDetails?.previousCrrRating}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Industry Code 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="industryCode" id="industryCode"   required="" value="${loanApplicationCredScorDetails?.industryCode}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Previous Rating/Date 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="previousDate" name="previousDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.previousRatingDate}" /></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Date of Current Rating 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="currentRatingDate" name ="currentRatingDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.dateOfCurrentRating}" /></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Basic Reasons for CRR 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="basicReason" id="basicReason"   required="" value="${loanApplicationCredScorDetails?.basicReasonForCrr}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Rater's Name
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="raterName" id="raterName" required="" value="${loanApplicationCredScorDetails?.rater}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Type of Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:select id="collateralType" name="collateralType.id" from="${icbs.lov.LoanCollateralType.list()}" optionKey="id" optionValue="description" value="${loanApplicationCredScorDetails?.typeOfCollateral?.id}" class="many-to-one form-control" /> </div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Appraisal Value - REM 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="appraisalValueRem" id="appraisalValueRem"   required="" value="${loanApplicationCredScorDetails?.appraisalValueRem}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">AV - Other Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="otherCollateral" id="otherCollateral"   required="" value="${loanApplicationCredScorDetails?.avOtherCollateral}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Facility Type 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="facilityType" id="facilityType"   required="" value="${loanApplicationCredScorDetails?.facilityTypes}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Expiry Date of Loan 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="expiryDate" name ="expiryDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.expiryDateOfLoan}" /></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Commitment Amount
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="commitmentAmount" id="qualificationItem"   required="" value="${loanApplicationCredScorDetails?.commitmentAmount}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Total O/s Balance (P)
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="totalOsBalance" id="totalOsBalance"   required="" value="${loanApplicationCredScorDetails?.totalOsBalance}" class="form-control truncated"/></div>
                        </div>
                    </g:form>
                </g:if>
                <g:else>
                    <g:form name="xformWithOutRated" id="xformWithOutRated" url="[action:'xSaveUpdateDetailsLoanAppDetCredScor',controller:'CreditInvestigation']" onsubmit="callLoadingDialog();">
                        <g:hiddenField name="credInvestigationId" id="credInvestigationId" value="${creditInvestigationInstance.id}" />
                        <g:hiddenField name="confihasRated" id="confihasRated" value="${Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem)}" /> 
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Originating unit
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="originatingUnit" id="originatingUnit"   required="" value="${loanApplicationCredScorDetails?.originatingUnit}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Contact Number
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="contactNumber" id="contactNumber"   required="" value="${loanApplicationCredScorDetails?.contactNumber}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Employeer
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="employeer" id="employeer"   required="" value="${loanApplicationCredScorDetails?.employer}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Previous CRR/Rating
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="previousRating" id="previousRating"   required="" value="${loanApplicationCredScorDetails?.previousCrrRating}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Designation/Rank
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="designationRank" id="designationRank"  required="" value="${loanApplicationCredScorDetails?.designationRank}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Previous Rating/Date 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="previousDate" name="previousDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.previousRatingDate}" /></div>
                        </div>
                         <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Type of Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:select id="collateralType" name="collateralType.id" from="${icbs.lov.LoanCollateralType.list()}" optionKey="id" optionValue="description" value="${loanApplicationCredScorDetails?.typeOfCollateral?.id}" class="many-to-one form-control" /> </div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Current Rating
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField id="currentRating" name="currentRating" class="form-control" value="${loanApplicationCredScorDetails?.currentRating}" /></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">AV of Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"> <g:textField name="avCollateral" id="avCollateral"   required="" value="${loanApplicationCredScorDetails?.avOfCollateral}" class="form-control truncated"/></div>
                        </div>
                       <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Date of Current Rating 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="currentRatingDate" name ="currentRatingDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.dateOfCurrentRating}" /></div>
                        </div><div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Reason/s for Rating
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"> <g:textField name="reasonForRating" id="reasonForRating"   required="" value="${loanApplicationCredScorDetails?.reasonsOfRating}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Other Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="xotherCollateral" id="xotherCollateral"   required="" value="${loanApplicationCredScorDetails?.otherCollateral}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">AV - Other Collateral
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="otherCollateral" id="otherCollateral"   required="" value="${loanApplicationCredScorDetails?.avOtherCollateral}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Rater's Name
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="raterName" id="raterName" required="" value="${loanApplicationCredScorDetails?.rater}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Loan Type
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="loanType" id="loanType" required="" value="${loanApplicationCredScorDetails?.loanType}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Expiry Date of Loan 
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:customDatePicker id="expiryDate" name ="expiryDate" precision="day" class="form-control" value="${loanApplicationCredScorDetails?.expiryDateOfLoan}" /></div>
                        </div>
                         <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Commitment Amount
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="commitmentAmount" id="qualificationItem"   required="" value="${loanApplicationCredScorDetails?.commitmentAmount}" class="form-control truncated"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Total O/s Balance (P)
                                <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField name="totalOsBalance" id="totalOsBalance"   required="" value="${loanApplicationCredScorDetails?.totalOsBalance}" class="form-control truncated"/></div>
                        </div>
                    </g:form>
                </g:else>
            </content>
            
           <content tag="main-actions">
                <ul>
                    
                    <g:if test="${scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true}" >
                        <li><button onclick="validateWithRated();">Save Details</button></li>
                    </g:if>
                    <g:else>
                        <li><button onclick="validateWithOutRated();">Save Details</button></li>
                    </g:else>    
                    <li><g:link class="btn btn-secondary" controller="loanApplication" action="show" id="${creditInvestigationInstance?.loanApplication?.id}">Back</g:link></li>
                    <script>
                        function validateWithRated(){
                            alertify.confirm(AppTitle,"Are you sure about this ? ",
                            function(){
                                $('#formWithRated').submit();
                            },
                            function(){
                              alertify.error('Cancel');
                            });
                        }
                        function validateWithOutRated(){
                            alertify.confirm(AppTitle,"Are you sure about this ? ",
                            function(){
                                $('#xformWithOutRated').submit();
                            },
                            function(){
                              alertify.error('Cancel');
                            });
                        }
                    </script>
		</ul>
            </content>
	</body>
</html>
