<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Create New Loan Project</title>
	</head>
        <body>
        
         <content tag="main-content">
             <div class="tab-content">
                  <g:hasErrors bean="${loanProjectInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${loanProjectInstance}" var="error">
				</g:eachError>
			</ul>
                    </g:hasErrors>
                        <div class="tab-pane active fade in" id="tab_1">
                            <g:form controller="lovMaintenance" action="loanProjectInstanceSave" >
                                <g:hiddenField name="id" value="${loanProjectInstance?.id}" />
                                <g:hiddenField name="version" value="${loanProjectInstance?.version}" />
                                    <fieldset class="form">
                                        <div class="fieldcontain form-group ${hasErrors(bean: loanProjectInstance, field: 'code', 'has-error')} required">
                                            <label class="control-label col-sm-4" for="code">
                                                <g:message code="loanProjectInstance.code.label" default="Code" />
                                                <span class="required-indicator">*</span>
                                            </label>
                                            <div class="col-sm-8"><g:textField name="code" maxlength="100" required="" value="${loanProjectInstance?.code}"class="form-control"/>

                                                <g:hasErrors bean="${loanProjectInstance}" field="code">
                                                    <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${loanProjectInstance}" field="code">
                                                               <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                    </div>
                                                </g:hasErrors>
                                            </div>             
                                        </div>
                                        <div class="fieldcontain form-group ${hasErrors(bean: loanProjectInstance, field: 'description', 'has-error')} required">
                                            <label class="control-label col-sm-4" for="description">
                                                <g:message code="loanProjectInstance.description.label" default="Description" />
                                                <span class="required-indicator">*</span>
                                            </label>
                                            <div class="col-sm-8"><g:textField name="description" maxlength="100" required="" value="${loanProjectInstance?.description}"class="form-control"/>

                                                <g:hasErrors bean="${loanProjectInstance}" field="description">
                                                    <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${loanProjectInstance}" field="description">
                                                                <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                    </div>
                                                </g:hasErrors>
                                            </div>             
                                        </div>
                                        <g:hiddenField name="status" value="true" />
                                    </fieldset>
                                <g:actionSubmit class="btn btn-primary" action="loanProjectInstanceSave" value="${message(code: 'default.button.created.label', default: 'Save')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to create this Loan Project?')}');" />
                            </g:form>	
                        </div>
                    </div>
            </content>	
             <content tag="main-actions">
		<ul>
                    <li></li>
                    <li><g:link action="loanProjectIndex">Cancel</g:link></li>
		</ul>
            </content>
	</body>
</html>