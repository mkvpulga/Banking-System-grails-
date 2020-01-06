<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.loans.CreditScoringQuestions" %>
<%@ page import="icbs.loans.CreditScoringQuestionSection" %>
<%@ page import="icbs.loans.CreditScoringPreQualification" %>
<%@ page import="icbs.loans.CreditScoringCodeDescription" %>


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
                                <li class="active"><a href="#tab_1" data-toggle="tab">Credit Scoring Pre Qualification</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane active fade in table-responsive"  id="tab_1">
                                <g:form name="myForm" id="loanPreQualification" method="POST" url="[action:'updatePreQualificationEvaluation',controller:'CreditInvestigation']" >
                                    <g:hiddenField name="loanApp" id="loanApp" value="${creditInvestigationInstance?.loanApplication?.id}" />
                                    <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                                    <g:each in="${recentPreQualificationInstance}"  var="recentQualListing">            
                                        <div class="col-sm-9">
                                            <strong>${recentQualListing?.creditScoringPreQualification?.preQualificationItem}</strong>
                                        </div>
                                        <div class="col-sm-3"><g:select noSelection="[null:'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')}" optionKey="id" optionValue="description" value="${recentQualListing?.preQualificationAnswer?.id}" class="many-to-one form-control" ></g:select></div>
                                        </br>
                                    </g:each>
                                </g:form>
                            </div>   
                            
			</div>
		</div>
        </content>
         <content tag="main-actions">
            <ul>
                <li><button onclick="updatePreQualifiction();">Update Pre Qualification Result</button>
                <script>
                    function updatePreQualifiction(){
                        alertify.confirm(AppTitle,"Are you sure about this? ",
                        function(){
                           $('#loanPreQualification').submit();
                        },
                        function(){
                          alertify.error('Canceled..');
                        });
                      
                        
                    }
                </script>
            </ul>
    	</content>
	</body>
</html>
