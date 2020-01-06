
<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
		<title>User Information</title>
	</head>
	<body>

		<content tag="breadcrumbs">
		  <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/userMaster')}">User Management</a>
          <span class="fa fa-chevron-right"></span><span class="current">User Information</span>
		</content>

        <content tag="main-content">   
		<div id="show-userMaster" class="content scaffold-show" role="main">
		<g:if test="${flash.message}">
                    <script>
                        $(function(){
                            var x = '${flash.message}';
                                notify.message(x);
                        });
                    </script>
                        
                </g:if>

			<div class="nav-tab-container">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab_1" data-toggle="tab">User Details</a></li>
                <li><a href="#tab_2" data-toggle="tab">Roles</a></li>
              </ul>
            </div>

            <div class="tab-content">
            	<div class="tab-pane active fade in" id="tab_1">
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> User Details </legend>
                         <table class="table table-bordered table-striped">
                            <tbody>
                                <g:if test="${userMasterInstance?.username}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Username</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="username"/></td>
                                </tr>
                                </g:if>      
                                <g:if test="${userMasterInstance?.name1}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">First Name</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="name1"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.name2}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Middle Name</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="name2"/></td>
                                </tr>
                                </g:if>  
                                <g:if test="${userMasterInstance?.name3}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Last Name</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="name3"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.name4}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Name4</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="name4"/></td>
                                </tr>
                                </g:if>   
                                <g:if test="${userMasterInstance?.birthdate}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Birth Date</td>
                                    <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.birthdate}"/></td>
                                </tr>
                                </g:if> 
                                <g:if test="${userMasterInstance?.gender}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Gender</td>
                                    <td width="70%">${userMasterInstance?.gender?.description}</td>
                                </tr>
                                </g:if> 
                                <g:if test="${userMasterInstance?.address1}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Address1</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="address1"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.address2}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Address2</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="address2"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.province}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Province</td>
                                    <td width="70%">${userMasterInstance?.province?.itemValue}</td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.zipCode}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Zip Code</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="zipCode"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.email}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Email</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="email"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.contact}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Contact</td>
                                    <td width="70%"><g:fieldValue bean="${userMasterInstance}" field="contact"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.dateHired}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Date Hired</td>
                                    <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.dateHired}"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.designation}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Designation</td>
                                    <td width="70%">${userMasterInstance?.designation?.description}</td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.branch}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Branch</td>
                                    <td width="70%"><g:link controller="branch" action="show" id="${userMasterInstance?.branch?.id}">${userMasterInstance?.branch?.name}</g:link></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.cash}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Cash</td>
                                    <td width="70%"><g:link controller="glAccount" action="show" id="${userMasterInstance?.cash?.id}">${userMasterInstance?.cash?.name}</g:link></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.coci}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">COCI</td>
                                    <td width="70%"><g:link controller="glAccount" action="show" id="${userMasterInstance?.coci?.id}">${userMasterInstance?.coci?.name}</g:link></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.employmentType}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Employment Type</td>
                                    <td width="70%">${userMasterInstance?.employmentType?.itemValue}</td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.expiryDate}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">User Access Expiry Date</td>
                                    <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.expiryDate}"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.expiryPwdDate}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Password Expiry Date</td>
                                    <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.expiryPwdDate}"/></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.isLocked}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">User Locked</td>
                                    <td width="70%">Yes</td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.hasExceededMaxLogin}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">User Has Exceeded Max Login Attempt</td>
                                    <td width="70%"><g:formatBoolean boolean="${userMasterInstance?.hasExceededMaxLogin}" true="Yes" false="No" /></td>
                                </tr>
                                </g:if>
                                <g:if test="${userMasterInstance?.configItemStatus}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Config Item Status</td>
                                    <td width="70%">${userMasterInstance?.configItemStatus?.description}</td>
                                </tr>
                                </g:if>
                            </tbody>
                        </table>
                        </fieldset>
                    </div>                    
					
                </div>

		<div class="tab-pane fade in" id="tab_2">
                    <div class="section-container">
                        <fieldset>
                        <legend class="section-header"> Role Details </legend>
                         <table class="table table-bordered table-striped">
                            <tbody>
                                <g:each in="${userMasterInstance.roles}" var="role" >
                                <tr>
                                    <td width="70%">${role.name}</td>
                                </tr>
                                </g:each>                      
                            </tbody>
                        </table>
                        </fieldset>
                    </div>		
            	</div>
            </div>

			<g:form id="deactivateUser" url="[resource:userMasterInstance, action:'delete']" method="DELETE"> </g:form>
                        <g:form id="lockUserForm" url="[resource:userMasterInstance, action:'lock']" method="DELETE"> </g:form>
                        <g:form id="unlockUserForm" url="[resource:userMasterInstance, action:'unlock']" method="DELETE"> </g:form>

		</div>
        </content>

        <content tag="main-actions">
            <ul>
                <li><g:link class="create" action="create"><g:message code="default.new.user" args="[entityName]" default="New User" /></g:link></li>
                <li><g:link action="edit" resource="${userMasterInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
                <li><g:link action="resetPassword" resource="${userMasterInstance}">Reset Password</g:link></li>
                <li><g:link action="forceLogout" resource="${userMasterInstance}">Force Logout</g:link></li>
                <li><button onclick="sendRefreshBalance();">Refresh Balancing Record</button></li>
                <g:form name="refreshUserBalance" id="refreshUserBalance"  onsubmit="callLoadingDialog();" url="[action:'refreshBalance',controller:'userMaster']" method="POST">
                    <g:hiddenField name="id" id="id" value="${params?.id}" /> 
                </g:form>   
                <li><g:actionSubmit id="deleteUser" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null);
                                },
                                function(){
                                    return;
                                });                          
                    " /></li>
                <g:if test="${!userMasterInstance.hasExceededMaxLogin && !userMasterInstance.isLocked}">
                    <li><g:actionSubmit id="lockUser" action="lock" value="${message(code: 'default.button.unlock.label', default: 'Lock User')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to lock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                              
                        " /></li>
                </g:if>
                <g:else>
                    <li><g:actionSubmit id="unlockUser" action="unlock" value="${message(code: 'default.button.unlock.label', default: 'Unlock User')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to unlock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                               
                        " /></li>
                </g:else>
                 <script>
                    function sendRefreshBalance(){
                        alertify.confirm(AppTitle,'Are you sure you want to refresh user Teller Balance?',
                        function(){
                            $('#refreshUserBalance').submit();
                        },
                        function(){
                            return;
                        });
                    }
                </script>    
            </ul>
            <!--
            <script type="text/javascript">
                    $(document).ready(function() {
                           $( "#deleteUser" ).click(function() {
                              checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                    $(document).ready(function() {
                           $( "#lockUser" ).click(function() {
                              checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                     $(document).ready(function() {
                           $( "#unlockUser" ).click(function() {
                              checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                </script>
                -->
        </content>
	</body>
</html>
