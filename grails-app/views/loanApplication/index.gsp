
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanApplication.label', default: 'LoanApplication')}" />
		<title>Loan Application</title>
	</head>
	<body>
        <content tag="main-content">   
		<div id="list-loanApplication" class="content scaffold-list" role="main">
			  <g:if test="${flash.message}">
                <script>
                    $(function(){
                            var x = '${flash.message}';
                   
                    alertify.alert('ERROR|alert!', x);
                    });
                </script>
            </g:if>
			<g:form>            	
            	<div class="row">
				    <div class="col-md-12">
				        <div class="col-md-2">
				             <g:select name="max" value="${params.max}" from="[25, 50, 75, 100]" class="form-control input-sm" onchange="this.form.submit()" />
				        </div>
				        <div class="input-group col-md-10">
				            <g:textField  type="text" name="query" class="form-control" placeholder="Enter Loan Application ID"/>
		                	<div class="input-group-btn">
		                    	<g:submitButton name="Search" class="btn btn-primary"></g:submitButton>
		                	</div>
				        </div>
				    </div>
				</div>				
            </g:form>
            <br />
			<div class="table-responsive">
                <table class="table table-hover table-condensed table-bordered table-striped">
                <tbody>
					<tr>
						<g:sortableColumn property="id" title="${message(code: 'loanApplication.id', default: 'Application ID')}" />
						
						<g:sortableColumn property="customer.displayName" title="${message(code: 'loanApplication.customer.label', default: 'Customer')}" />
					
						<g:sortableColumn property="product.name" title="${message(code: 'loanApplication.product.label', default: 'Product')}" />

						<g:sortableColumn property="amount" title="${message(code: 'loanApplication.amount.label', default: 'Amount')}" />					

						<g:sortableColumn property="applicationDate" defaultOrder="desc" title="${message(code: 'loanApplication.applicationDate.label', default: 'Application Date')}"   />
                                                
                                                <g:sortableColumn property="approvalStatus" title="${message(code: 'loanApplication.approvalStatus.label', default: 'Status')}" />

						<td><label>Action</label></td>
					
					</tr>
				</tbody>
				<tbody>
				<g:each in="${loanApplicationInstanceList}" status="i" var="loanApplicationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:formatNumber format="#" groupingUsed="true" number="${fieldValue(bean: loanApplicationInstance, field: "id")}" /></td>

						<td>${loanApplicationInstance?.customer?.displayName}</td>						
					
						<td>${loanApplicationInstance?.product?.name}</td>									
					
						<td><g:formatNumber format="###,##0.00" number="${loanApplicationInstance?.amount}" /></td>					
						<td><g:formatDate format="MM/dd/yyyy" date="${loanApplicationInstance?.applicationDate}"/></td>
					
                                                <td>${loanApplicationInstance?.approvalStatus}</td>
                                                
						<td><g:link class="btn btn-secondary" action="show" id="${loanApplicationInstance.id}">View</g:link></td>

					</tr>
				</g:each>
				</tbody>
				</table>
	        
			<div class="pagination">
				<g:paginate total="${LoanApplicationInstanceCount ?: 0}" params="${params}"/>
			</div>
		</div>
                </div>
        </content>
        <content tag="main-actions">
            <ul>
                 <g:if test="${UserMaster.get(session.user_id).designation?.id == 17}">
                     <li><g:link class="create" action="create">New Loan Application</g:link></li>
                  
                </g:if>
                <g:else>
                      <li><button disabled>New Loan Application</button></li>
                    </g:else>
			</ul>
        </content>
	</body>
</html>
