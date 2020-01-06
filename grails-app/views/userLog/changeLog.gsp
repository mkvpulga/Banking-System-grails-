<%@ page import="icbs.audit.AuditValue" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'auditValue.label', default: 'AuditValue')}" />
	<title>User Change Logs</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">User Logs</span>
        </content>
        <content tag="main-content">   
            <div id="list-auditValue" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
                <g:form class="form-inline">
                    <div class="form-group">
			<g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
			<div class="form-group">
                            <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
			</div>
			<g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
                </g:form>
		<div class="table-responsive">
                    <table class="table table-hover table-condensed table-bordered table-striped">
                        <thead>
                            <tr>
				<th><g:message code="auditValue.user.label" default="User" /></th>
				<g:sortableColumn property="dateStamp" title="${message(code: 'auditValue.dateStamp.label', default: 'Date/Time')}" />
                                <g:sortableColumn property="dataTable" title="${message(code: 'auditValue.dataTable.label', default: 'Data Table')}" />
                                <g:sortableColumn property="dataField" title="${message(code: 'auditValue.dataField.label', default: 'Data Field')}" />
                                <g:sortableColumn property="oldValue" title="${message(code: 'auditValue.oldValue.label', default: 'Old Value')}" />
				<g:sortableColumn property="newValue" title="${message(code: 'auditValue.newValue.label', default: 'New Field')}" />	
                            </tr>
			</thead>
			<tbody>
                            <g:each in="${values}" status="i" var="valueInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${valueInstance.user.username}</td>
                                    <td>${valueInstance.dateStamp}</td>
                                    <td>${valueInstance.dataTable}</td>
                                    <td>${valueInstance.dataField}</td>
                                    <td>${valueInstance.oldValue}</td>
                                    <td>${valueInstance.newValue}</td>
				</tr>
                            </g:each>
			</tbody>
                    </table>
                </div>
                <div class="pagination">
                    <g:paginate total="${AuditLogInstanceCount ?: 0}" params="${params}" />
		</div>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link controller="UserLog" action="index">Return to User Log</g:link></li>
            </ul>
        </content>
    </body>
</html>
