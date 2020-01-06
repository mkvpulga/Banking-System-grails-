<%@ page import="icbs.loans.CreditInvestigation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Credit Scoring</title>
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
            
            </content>
            <content tag="main-actions">
                <ul>
                    <%--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--%>
                    <li><g:link controller="creditScoring"  action="configProduct">Set Credit Scoring Product Group Code</g:link></li>
                    <li><g:link controller="creditScoring"  action="configSection">Set Credit Scoring Items</g:link></li>
		</ul>
            </content>
	</body>
</html>
