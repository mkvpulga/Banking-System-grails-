<%@ page import="icbs.loans.CreditInvestigation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Manage Credit Scoring Code product classification</title>
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
            <g:form name="creditScoringProduct" id="creditScoringProduct" url="[action:'configProduct',controller:'CreditScoring']">            	
            	<div class="row">
                    <div class="col-md-12">
                        <div class="col-md-2">
                             <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm" onchange="this.form.submit()" />
                        </div>
                        <div class="input-group col-md-10">
                            <g:textField  type="text" name="query" class="form-control" placeholder="Enter Credit Investigation ID"/>
                        <div class="input-group-btn">
                        <g:submitButton name="Search" class="btn btn-primary"></g:submitButton>
                        </div>
                        </div>
                    </div>
                </div>				
            </g:form>
            <div class="table-responsive">
            	<table class="table table-hover table-condensed table-bordered table-striped">
                    <thead>
                        <tr>                                    
                            <td><label>Code</label></td>
                            <td><label>Description</label></td>
                            <g:sortableColumn property="Date Created" title="${message(code: 'creditInvestigation.loanApplication.label', default: 'Date Created')}" />
                            <td><label>Created By</label></td>
                            <td><label>Action</label></td>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${creditScoringProductList}" status="i" var="creditScoringProductConfigInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${creditScoringProductConfigInstance?.code}</td>
                            <td>${creditScoringProductConfigInstance?.description}</td>
                            <td><g:formatDate format="MM/dd/yyyy" date="${creditScoringProductConfigInstance?.dateCreated}"/></td>
                            <td>${creditScoringProductConfigInstance?.createdBy?.username}</td>
                            <td><g:link class="btn btn-secondary" action="codeWithProductDetails" id="${creditScoringProductConfigInstance.id}">View Details</g:link> </td>
                        </tr>
                    </g:each> 
                    </tbody>
		</table>
            </div>
            <div class="pagination">
                    <g:paginate total="${creditScoringProductInstanceCount ?: 0}" params="${params}" />
            </div>
            </content>
            <content tag="main-actions">
                <ul>
                    <%--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--%>
                    <li><g:link controller="creditScoring"  action="createProduct">Create Code for CR Product Config</g:link></li>
                    <li><g:link controller="creditScoring"  action="index">Back to Index</g:link></li>
		</ul>
            </content>
	</body>
</html>
