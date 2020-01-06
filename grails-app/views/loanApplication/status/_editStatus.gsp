<%@ page import="icbs.lov.LoanApplicationStatus" %>


<div>
    <g:if test="${message}">
        <div class="box-body">
            <div class="alert alert-info alert-dismissable">
                <i class="fa fa-info"></i>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <b>Message</b> <div class="message" role="status">${message}</div>
            </div>
        </div>
    </g:if>
    <g:hasErrors bean="${loanApplicationInstance}"> 
        <div class="box-body">
            <div class="alert alert-danger alert-dismissable">
                <i class="fa fa-ban"></i>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <b>Alert!</b> 
                <ul class="errors" role="alert">
                    There are errors
                </ul>            
            </div>
        </div>
    </g:hasErrors>
    <g:form name="update-status-form">
        <g:hiddenField name="id" id="id" value="${loanApplicationInstance?.id}"/>
        <div class="form-group fieldcontain ${hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalStatus">Status</label>
            <div class="col-sm-8">
                 
                  <g:if test="${user?.id == 16 && loanApplicationInstance?.customer?.id == 6605}">
                     
                <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id != 4 && it.id != 2  }}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                </g:if>
                <g:elseif test="${user?.designation?.id == 17}">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id == 3 || it.id == 1 }}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                </g:elseif>
                  <g:elseif test="${user?.designation?.id == 33}">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id == 4 || it.id == 1}}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                </g:elseif>
                 <g:elseif test="${user?.designation?.id == 30 && loanApplicationInstance?.customer?.id != 6605}">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id ==1 || it.id >= 5 }}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                </g:elseif>
                 <g:elseif test="${user?.id == 15}">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id ==1 || it.id == 2 }}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                </g:elseif>
                <g:else>
                    <g:select id="approvalStatus" name="approvalStatus.id" from="${LoanApplicationStatus.list().findAll{it.id ==loanApplicationInstance?.approvalStatus?.id}}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" readonly="true" class="form-control"/>             
                </g:else>
                <g:hasErrors bean="${loanApplicationInstance}" field="approvalStatus">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${loanApplicationInstance}" field="approvalStatus">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </div>
    </g:form>  
</div>
