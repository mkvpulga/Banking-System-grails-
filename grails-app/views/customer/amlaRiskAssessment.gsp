<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.loans.CreditScoringQuestions" %>
<%@ page import="icbs.loans.CreditScoringQuestionSection" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title>AMLA Risk Assessment</title>
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

            <g:form name="myForm" id="saveFormAmlaRiskAssessment" url="[action:'saveAmlaRisk',controller:'customer']" method="POST" >

                <g:hiddenField name="id" id="id" value="${params.id}" />
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score1', 'has-error')} ">
                    <label class="col-sm-10"for="score1">
                        <g:message code="amlaRisk.score1.label" default="Risk Classification of Person Note: if risk rating is 3 (High Risk), CRR shall be automatically tagged as High." />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score1" name="score1" from="${1..3}"  value="${amlaRiskInstance.score1}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score1" name="score1" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score1">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score1" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score2', 'has-error')} ">
                    <label class="col-sm-10"for="score2">
                        <g:message code="amlaRisk.score2.label" default="Citizenship" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score2" name="score2" from="${1..3}"  value="${amlaRiskInstance.score2}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score2" name="score2" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score2">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score2" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score3', 'has-error')} ">
                    <label class="col-sm-10"for="score3">
                        <g:message code="amlaRisk.score3.label" default="Geographical Address" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score3" name="score3" from="${1..3}"  value="${amlaRiskInstance.score3}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score3" name="score3" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="Geographical Address">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score3" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score4', 'has-error')} ">
                    <label class="col-sm-10"for="score4">
                        <g:message code="amlaRisk.score4.label" default="Individual Identification" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score4" name="score4" from="${1..3}"  value="${amlaRiskInstance.score4}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score4" name="score4" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score4">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score4" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score5', 'has-error')} ">
                    <label class="col-sm-10"for="score5">
                        <g:message code="amlaRisk.score5.label" default="Occupation/Nature of work or Self-employment" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score5" name="score5" from="${1..3}"  value="${amlaRiskInstance.score5}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score5" name="score5" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score5">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score5" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score6', 'has-error')} ">
                    <label class="col-sm-10"for="score6">
                        <g:message code="amlaRisk.score6.label" default="Source of Fund" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score6" name="score6" from="${1..3}"  value="${amlaRiskInstance.score6}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score6" name="score6" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score6">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score6" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score7', 'has-error')} ">
                    <label class="col-sm-10"for="score7">
                        <g:message code="amlaRisk.score7.label" default="Account Opening Method; Loan Application" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score7" name="score7" from="${1..3}"  value="${amlaRiskInstance.score7}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score7" name="score7" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score7">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score7" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score8', 'has-error')} ">
                    <label class="col-sm-10"for="score8">
                        <g:message code="amlaRisk.score8.label" default="Declared Gross Monthly Income/Salary" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score8" name="score8" from="${1..3}"  value="${amlaRiskInstance.score8}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score8" name="score8" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score8">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score8" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score9', 'has-error')} ">
                    <label class="col-sm-10"for="score9">
                        <g:message code="amlaRisk.score9.label" default="Length of Relationship" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score9" name="score9" from="${1..3}"  value="${amlaRiskInstance.score9}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score9" name="score9" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score9">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score9" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>
                <div class="form-group fieldcontain ${hasErrors(bean: amlaRiskInstance, field: 'score10', 'has-error')} ">
                    <label class="col-sm-10"for="score10">
                        <g:message code="amlaRisk.score10.label" default="Number of Existing Loans" />

                    </label>
                    <div class="col-sm-2">
                        <g:if test="${amlaRiskInstance}">
                            <g:select noSelection="['':'-Set Score Here-']" id="score10" name="score10" from="${1..3}"  value="${amlaRiskInstance.score10}" class="many-to-one form-control" ></g:select>
                        </g:if>
                        <g:else>
                            <g:select noSelection="['':'-Set Score Here-']" id="score10" name="score10" from="${1..3}"  value="" class="many-to-one form-control" ></g:select>

                        </g:else>
                        <g:hasErrors bean="${amlaRiskInstance}" field="score10">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${amlaRiskInstance}" field="score10" >
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>   
                    </div>
                </div>

            </g:form>    

        </div>
    </content>
    <content tag="main-actions">
        <ul>
            <li><g:link onclick="saveAmlaRisk();" id="${params.id}">Save AMLA Risk Assessment</g:link></li>
            <li><g:link action="amlaRisk" id="${params.id}">Back</g:link></li>
                <script>
                function saveAmlaRisk(){
                alertify.confirm(AppTitle,"Are you sure about this ? ",
                function(){
                $('#saveFormAmlaRiskAssessment').submit();
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
