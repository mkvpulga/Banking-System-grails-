<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.loans.CreditScoringQuestions" %>
<%@ page import="icbs.loans.CreditScoringQuestionSection" %>
<%@ page import="icbs.lov.CreditScoringAnswers" %>
<%@ page import="icbs.loans.CreditScoringRated" %>
<%@ page import="icbs.loans.CreditScoringRatedItems" %>
<%@ page import="icbs.loans.CreditScoringRatedItemsRecords" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>View Credit Investigation</title>
	</head>
	<body>  
        <content tag="main-content">   
                <script>
                    
                </script>    
		<div id="show-creditInvestigation" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
                            <div class="box-body">
                                <div class="alert alert-info alert-dismissable">
                                    <i class="fa fa-info"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <b>Message</b> <div class="message" role="status">${flash.message}</div>
                                </div>
                            </div>
                        </g:if>
			<div class="nav-tab-container">
                            <ul class="nav nav-tabs">
                                <g:each in="${xxratedInstance}" status="i" var="ratedInstance">    
                                    <g:if test="${i == 0}" >
                                        <li class="active"><a href="#tab_${ratedInstance.id}" data-toggle="tab"><b>${ratedInstance?.ratedName.substring(0,ratedInstance?.ratedName.indexOf('-'))}</b></a></li>
                                    </g:if>
                                    <g:else>
                                    <li><a href="#tab_${ratedInstance.id}" data-toggle="tab"><b>${ratedInstance?.ratedName.substring(0,ratedInstance?.ratedName.indexOf('-'))}</b></a></li>
                                    </g:else>    
                                </g:each>    
                            </ul>
                        </div>
                        <g:form name="myForm" id="saveRatedform" url="[action:'updateSaveRatedScoringItems',controller:'creditInvestigation']" method="POST" >
                            <g:hiddenField name="loanApp" id="loanApp" value="${creditInvestigationInstance?.loanApplication?.id}" />
                            <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                        
                        <div class="tab-content">
                            
                            <g:each in="${xxratedInstance}" status="i" var="ratedInstance"> 
                                    
                                    <g:if test="${i == 0}" >
                                        <div class="tab-pane active fade in table-responsive"  id="tab_${ratedInstance.id}">
                                            <p style="color: orangered;"><label style="color: black;">Description: </label>${ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length())}</p>
                                             <label class="control-label col-sm-5" for="remarks">
                                       <g:message code="loanApplication.recommendedRemarks1.label" default="Remarks" />

                                    </label>
                                    <div class="col-sm-8">
                                           <g:textArea id="remarks" name="remarks" value="${CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks}" class="form-control" />
                                 
                                    </div> 
                                            <g:each in="${CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])}"  var="ratedItems">            
                                                <div class="col-sm-9">
                                                    <strong>${ratedItems?.itemDescription}</strong>
                                                </div>
                                                <div class="col-sm-3"><g:select noSelection="[null:'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')}" optionKey="id" optionValue="description" value="${icbs.loans.CreditScoringRatedItemsRecords.findByCreditScoringRatedItems(ratedItems)?.creditScoringAnswers?.id}" class="many-to-one form-control" ></g:select></div>
                                                </br>
                                            </g:each>
                                        </div>
                                    </g:if>    
                                    <g:else>
                                        <div class="tab-pane fade in table-responsive" id="tab_${ratedInstance.id}">
                                            <p style="color: orangered;"><label style="color: black;">Description: </label>${ratedInstance?.ratedName.substring(ratedInstance?.ratedName.indexOf('-') + 1,ratedInstance?.ratedName.length())}</p>
                                        
                                    <g:each in="${CreditScoringRatedItems.findAllByCreditScoringRated(ratedInstance,[sort: "id", order: "asc"])}"  var="ratedItems">            
                                             <label class="control-label col-sm-5" for="remarks">
                                       <g:message code="loanApplication.recommendedRemarks1.label" default="Remarks" />

                                    </label>
                                    <div class="col-sm-8">
                                    <g:textArea id="remarks" name="remarks" value="${CreditScoringRatedItemsRecords.findByCreditScoringRatedAndLoanApplication(ratedInstance,creditInvestigationInstance?.loanApplication).remarks}" class="form-control" />
                                 
                                    </div>       
                                        <div class="col-sm-9">
                                                    <strong>${ratedItems?.itemDescription}</strong>
                                                </div>
                                                <div class="col-sm-3"><g:select noSelection="[null:'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')}" optionKey="id" optionValue="description" value="${icbs.loans.CreditScoringRatedItemsRecords.findByCreditScoringRatedItems(ratedItems)?.creditScoringAnswers?.id}" class="many-to-one form-control" ></g:select></div>
                                                </br>
                                            </g:each>
                                        </div>
                                    </g:else>    
                            </g:each>
                            </g:form>    
			</div>			
		</div>
        </content>
         <content tag="main-actions">
            <ul>
                <li><button onclick="saveCreditScoring();">Save Rated Scoring Details</button></li>
                <script>
                    function saveCreditScoring(){
                    alertify.confirm(AppTitle,"Are you sure about this ? ",
                        function(){
                           $('#saveRatedform').submit();
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
