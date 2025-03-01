<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
        <title>Periodic Operations Utilities</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/periodicOps')}">Periodic Operation Index</a>
                <span class="fa fa-chevron-right"></span><span class="current">Periodic Operations Utilities</span>
            </content>
        <content tag="main-content">
            <table class="table table-bordered table-rounded table-striped table-hover">
		<thead>
                    <tr>
			<th>Process</th>
                        <th>Action</th>
                    </tr>
		</thead>
		<tbody>            
                    <tr>
                        <td>Rebuilt Loan Recovery GL Entries</td>
			
                        <td><a class="btn btn-primary"href="#" onClick="getConfirmExecute();">Execute</a></td>
                        <script>
                            function getConfirmExecute(){
                                alertify.confirm(AppTitle,"Are you sure you want to execute this ?",
                                    function(){
                                        window.location.href = "/icbs/periodicOps/rebuildLoanRecovery";
                                    },
                                    function(){
                                      alertify.error('Canceled');
                                    });
                            }
                        </script>
                    </tr>
                    <tr>
                        <td>Rebuild General Ledger</td>			
                        <td><g:link action="rebuildGl" class="btn btn-primary">Rebuild</g:link></td>
                    </tr>   
                    <tr>
                        <td>Rebuild Loan Installment Payment Status</td>			
                        <td><a class="btn btn-primary"href="#" onClick="getConfirmExecuteLoanInst();">Execute</a></td>
                        <script>
                            function getConfirmExecuteLoanInst(){
                                alertify.confirm(AppTitle,"Are you sure you want to execute this ?",
                                    function(){
                                        window.location.href = "/icbs/periodicOps/rebuildLoanInst";
                                    },
                                    function(){
                                      alertify.error('Canceled');
                                    });
                            }
                        </script>
                    </tr>
                </tbody>
                
            </table>    
        </content>
        <content tag="main-actions">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">Back to Home</a></li>
                <li><g:link class="index" action="index">Periodic Operations Index</g:link></li>
            </ul>
        </content>
    </body>
</html>
