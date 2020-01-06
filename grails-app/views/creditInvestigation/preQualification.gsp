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
                                <g:form name="myForm" id="loanPreQualification" method="POST" url="[action:'collectPreQualificationEvaluation',controller:'CreditInvestigation']" >
                                    <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                                    <g:hiddenField name="loanApp" id="loanApp" value="${creditInvestigationInstance?.loanApplication?.id}" />
                                    <g:each in="${idCreditPreq}"  var="qualListing">            
                                        <div class="col-sm-9">
                                            <strong>${qualListing?.preQualificationItem}</strong>
                                        </div>
                                        <div class="col-sm-3"><g:select noSelection="[null:'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'logicalAnswer')}" optionKey="id" optionValue="description" value="" class="many-to-one form-control" ></g:select></div>
                                        </br>
                                    </g:each>
                                </g:form>
                            </div>   
                            
			</div>
		</div>
        </content>
         <content tag="main-actions">
            <ul>
               
                
                <li><button onclick="taena();">Evaluate Pre Qualification</button>
                <li><g:link class="btn btn-secondary" controller="loanApplication" action="show" id="${creditInvestigationInstance?.loanApplication?.id}">Back</g:link></li>
                <script>
                    function taena(){
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
