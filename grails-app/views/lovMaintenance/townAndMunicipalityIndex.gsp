
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="CustomerTown" />
		<title>List of Town/Municipality</title>
	</head>
	<body>
            <content tag="main-content">
		 <g:if test="${flash.success}">
                    <div style="margin:auto" class="box-bodylogin">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <b>Message</b> <div class="message" role="status">${flash.success}</div>
                        </div>
                    </div>
                </g:if>
		<table class="table table-bordered table-rounded table-striped table-hover">
                    <thead>
			<tr>
                            <th>Code</th>
                            <th>Description</th>
                            <th>Actions</th>
			</tr>
                    </thead>
			<tbody>
                            <g:each in="${townInstanceList}" status="i" var="townInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${townInstance.code}</td>
                                     <td>${townInstance.description}</td>
                                    <td>
                                        <g:link class="btn btn-secondary" action="townInstanceEdit" id="${townInstance.id}">Edit</g:link>
                                        <g:link class="btn btn-secondary" action="townInstanceDelete" id="${townInstance.id}" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to delete this town?')}');">Delete</g:link>
                                    </td>
				</tr>
                            </g:each>                            
			</tbody>
		</table>                        
            </content>	
            <content tag="main-actions">
		<ul>
                    <li><g:link action="townInstanceCreate">Create New Town/Municipality</g:link></li>
                    <li><g:link action="index">List of Values Index</g:link></li>
		</ul>
            </content>
	</body>
</html>
