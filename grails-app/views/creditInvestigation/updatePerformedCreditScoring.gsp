<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.loans.CreditScoringQuestions" %>
<%@ page import="icbs.loans.CreditScoringQuestionSection" %>

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
                                <g:each in="${scoringSectionInstance}" status="i" var="scoringsectionInstance">    
                                    <g:if test="${i == 0}" >
                                        <li class="active"><a href="#tab_${scoringsectionInstance.id}" data-toggle="tab"><b>${scoringsectionInstance?.nameOfSection}  ${scoringsectionInstance?.sectionPercentage}%</b></a></li>
                                    </g:if>
                                    <g:else>
                                    <li><a href="#tab_${scoringsectionInstance.id}" data-toggle="tab"><b>${scoringsectionInstance?.nameOfSection}  ${scoringsectionInstance?.sectionPercentage}%</b></a></li>
                                    </g:else>    
                                </g:each>    
                            </ul>
                        </div>
                        <g:form name="myForm" id="saveFormCreditScoringDetails" url="[action:'updatesaveCreditScoringChecklist',controller:'creditInvestigation']" method="POST" >
                            <g:hiddenField name="loanApp" id="loanApp" value="${creditInvestigationInstance?.loanApplication?.id}" />
                            <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                        
                        <div class="tab-content">
                            
                            <g:each in="${scoringSectionInstance}" status="i" var="scoringsectionInstancex"> 
                                    
                                    <g:if test="${i == 0}" >
                                        <div class="tab-pane active fade in table-responsive"  id="tab_${scoringsectionInstancex.id}">
                                            <g:each in="${CreditScoringQuestions.findAllByCreditScoringQuestionSection(CreditScoringQuestionSection.get(scoringsectionInstancex.id),[sort: "id", order: "asc"] )}" status="j" var="questionXs">  
                                                <div class="col-sm-10">
                                                    <strong>${questionXs?.questionNumberDescription}</strong>
                                                </div>
                                                <div class="col-sm-2"><g:select noSelection="['':'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="${icbs.loans.CreditScoringChecklistRecords.findByCreditScoringQuestions(questionXs)?.creditScoringAnswers?.id}" class="many-to-one form-control" ></g:select></div>
                                                
                                                <ul style="list-style-type: none;">
                                                    <li><label class="control-label col-sm-12" >${questionXs?.choiceDescriptionA}</label></li>
                                                    <li><label class="control-label col-sm-12" >${questionXs?.choiceDescriptionB}</label></li>
                                                    <li><label class="control-label col-sm-12" >${questionXs?.choiceDescriptionC}</label></li>
                                                </ul>   
                                            </g:each>
                                        </div>
                                    </g:if>    
                                    <g:else>
                                        <div class="tab-pane fade in table-responsive" id="tab_${scoringsectionInstancex.id}">
                                            <g:each in="${CreditScoringQuestions.findAllByCreditScoringQuestionSection(CreditScoringQuestionSection.get(scoringsectionInstancex.id),[sort: "id", order: "asc"])}"  var="xquestionXs">  
                                                <div class="col-sm-10">
                                                    <strong>${xquestionXs?.questionNumberDescription}</strong>
                                                </div>
                                                <div class="col-sm-2"><g:select noSelection="['':'-Set Score Here-']" id="xcode" name="xcode" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="${icbs.loans.CreditScoringChecklistRecords.findByCreditScoringQuestions(xquestionXs)?.creditScoringAnswers?.id}" class="many-to-one form-control" ></g:select></div>
                                                
                                                <ul style="list-style-type: none;">
                                                    <li><label class="control-label col-sm-12" >${xquestionXs?.choiceDescriptionA}</label></li>
                                                    <li><label class="control-label col-sm-12" >${xquestionXs?.choiceDescriptionB}</label></li>
                                                    <li><label class="control-label col-sm-12" >${xquestionXs?.choiceDescriptionC}</label></li>
                                                </ul>
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
                <li><button onclick="saveCreditScoring();">Update Credit Scoring Details</button></li>
                <script>
                    function saveCreditScoring(){
                    alertify.confirm(AppTitle,"Are you sure about this ? ",
                        function(){
                           $('#saveFormCreditScoringDetails').submit();
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
