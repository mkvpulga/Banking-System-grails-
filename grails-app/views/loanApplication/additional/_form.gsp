<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.cif.Customer" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<%@ page import="icbs.loans.GroupRecord" %>
<%@ page import="icbs.lov.LoanSecurity" %>

<legend>Other Information</legend>

<g:if test="${(user?.id == 16 && loanApplicationInstance?.customer?.id == 6605) || (user?.designation?.id == 30 && loanApplicationInstance?.customer?.id != 6605)}">
    <!-- camNo -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'camNo', 'has-error')} ">
        <label class="control-label col-sm-5" for="camNo">
            <g:message code="loanApplication.camNo.label" default="Cam Number" />

        </label>
        <div class="col-sm-8">
            <g:if test="${loanApplicationSpecAdd?.camNo}">
                <g:field id="camNo" name="camNo" value="${loanApplicationSpecAdd?.camNo}" class="form-control" readonly="true" />
            </g:if>
            <g:else>
                <g:field id="camNo" name="camNo" value="${camNo}" class="form-control" readonly="true"/>
            </g:else>
            <g:hasErrors bean="${loanApplicationInstance}" field="camNo">

            </g:hasErrors>
        </div>             
    </div>
    <!-- company -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'company', 'has-error')} ">
        <label class="control-label col-sm-5" for="company">
            <g:message code="loanApplication.company.label" default="Company" />

        </label>
        <div class="col-sm-8">
            <g:field id="company" name="company" value="${loanApplicationSpecAdd?.company}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="company">

            </g:hasErrors>
        </div>             
    </div>
    <!-- loan security -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'loanSecurity', 'has-error')} required">
        <label class="control-label col-sm-4" for="loanSecurity">
            <g:message code="loanApplication.loanSecurity.label" default="Loan Security" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:select id="loanSecurity" name="loanSecurity.id" from="${icbs.lov.LoanSecurity.findAll()}" optionKey="id" optionValue="description" value="${loanApplicationSpecAdd?.loanSecurity?.id}" class="form-control"/>

            <g:hasErrors bean="${loanApplicationInstance}" field="loanSecurity">

            </g:hasErrors>
        </div>             
    </div>
    <!-- loan classification -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'loanClassification', 'has-error')} required">
        <label class="control-label col-sm-4" for="loanClassification">
            <g:message code="loanApplication.loanClassification.label" default="Loan Classification" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="loanClassification" name="loanClassification" value="${loanApplicationSpecAdd?.loanClassification}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="loanClassification">

            </g:hasErrors>
        </div>             
    </div>
    <!-- loan product -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'loanProduct', 'has-error')} required">
        <label class="control-label col-sm-4" for="loanProduct">
            <g:message code="loanApplication.loanProduct.label" default="Loan Product" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="loanProduct" name="loanProduct" value="${loanApplicationSpecAdd?.loanProduct}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="loanProduct">

            </g:hasErrors>
        </div>             
    </div>
    <!-- economic activity-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'economicActivity', 'has-error')} required">
        <label class="control-label col-sm-4" for="economicActivity">
            <g:message code="loanApplication.economicActivity.label" default="Economic Activity" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="economicActivity" name="economicActivity" value="${loanApplicationSpecAdd?.economicActivity}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="economicActivity">

            </g:hasErrors>
        </div>             
    </div>
    <!-- interest rate -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'interestRate', 'has-error')} required">
        <label class="control-label col-sm-4" for="interestRate">
            <g:message code="loanApplication.interestRate.label" default="Interest Rate Payment" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8"><g:field id="interestRate" name="interestRate" class="form-control truncated" value="${loanApplicationSpecAdd?.interestRate}"/>

            <g:hasErrors bean="${loanApplicationInstance}" field="interestRate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- repayment type-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'repaymentType', 'has-error')} required">
        <label class="control-label col-sm-4" for="repaymentType">
            <g:message code="loanApplication.repaymentType.label" default="Repayment Type" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="repaymentType" name="repaymentType" value="${loanApplicationSpecAdd?.repaymentType}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="repaymentType">

            </g:hasErrors>
        </div>             
    </div>
    <!-- manner of payment-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'mannerOfPayment', 'has-error')} required">
        <label class="control-label col-sm-4" for="mannerOfPayment">
            <g:message code="loanApplication.mannerOfPayment.label" default="Manner Of Payment" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="mannerOfPayment" name="mannerOfPayment" value="${loanApplicationSpecAdd?.mannerOfPayment}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="mannerOfPayment">

            </g:hasErrors>
        </div>             
    </div>
    <!-- amortization penalty rate -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'amortizationPenaltyRate', 'has-error')}">
        <label class="control-label col-sm-5" for="amortizationPenaltyRate">
            <g:message code="loanApplication.amortizationPenaltyRate.label" default="Amortization Penalty Rate" />

        </label>
        <div class="col-sm-8">
            <g:field id="amortizationPenaltyRate" name="amortizationPenaltyRate" value="${loanApplicationSpecAdd?.amortizationPenaltyRate}" class="form-control truncated" />
            <g:hasErrors bean="${loanApplicationInstance}" field="amortizationPenaltyRate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- pre termination charge rate -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'preTerminationChargeRate', 'has-error')}">
        <label class="control-label col-sm-5" for="preTerminationChargeRate">
            <g:message code="loanApplication.preTerminationChargeRate.label" default="Pre-Termination Charge Rate" />

        </label>
        <div class="col-sm-8">
            <g:field id="preTerminationChargeRate" name="preTerminationChargeRate" value="${loanApplicationSpecAdd?.preTerminationChargeRate}" class="form-control truncated" />
            <g:hasErrors bean="${loanApplicationInstance}" field="preTerminationChargeRate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- pastdue interest rate -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'pastdueInterestRate', 'has-error')}">
        <label class="control-label col-sm-5" for="pastdueInterestRate">
            <g:message code="loanApplication.pastdueInterestRate.label" default="Pastdue Interest Rate" />

        </label>
        <div class="col-sm-8">
            <g:field id="pastdueInterestRate" name="pastdueInterestRate" value="${loanApplicationSpecAdd?.pastdueInterestRate}" class="form-control truncated" />
            <g:hasErrors bean="${loanApplicationInstance}" field="pastdueInterestRate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- pastdue penalty rate -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'pastduePenaltyRate', 'has-error')}">
        <label class="control-label col-sm-5" for="pastduePenaltyRate">
            <g:message code="loanApplication.pastduePenaltyRate.label" default="Pastdue Penalty Rate" />

        </label>
        <div class="col-sm-8">
            <g:field id="pastduePenaltyRate" name="pastduePenaltyRate" value="${loanApplicationSpecAdd?.pastduePenaltyRate}" class="form-control truncated" />
            <g:hasErrors bean="${loanApplicationInstance}" field="pastduePenaltyRate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 1-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition1', 'has-error')} ">
        <label class="control-label col-sm-4" for="condition1">
            <g:message code="loanApplication.condition1.label" default="Condition 1" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition1" name="condition1" value="${loanApplicationSpecAdd?.condition1}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition1">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 2-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition2', 'has-error')} ">
        <label class="control-label col-sm-4" for="condition2">
            <g:message code="loanApplication.condition2.label" default="Condition 2" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition2" name="condition2" value="${loanApplicationSpecAdd?.condition2}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition2">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 3-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition3', 'has-error')} ">
        <label class="control-label col-sm-4" for="condition3">
            <g:message code="loanApplication.condition3.label" default="Condition 3" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition3" name="condition3" value="${loanApplicationSpecAdd?.condition3}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition3">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 4-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition4', 'has-error')} ">
        <label class="control-label col-sm-4" for="condition4">
            <g:message code="loanApplication.condition4.label" default="Condition 4" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition4" name="condition4" value="${loanApplicationSpecAdd?.condition4}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition4">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 5-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition5', 'has-error')} ">
        <label class="control-label col-sm-5" for="condition5">
            <g:message code="loanApplication.condition5.label" default="Condition 5" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition5" name="condition5" value="${loanApplicationSpecAdd?.condition5}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition5">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 6-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition6', 'has-error')} ">
        <label class="control-label col-sm-4" for="condition6">
            <g:message code="loanApplication.condition6.label" default="Condition 6" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition6" name="condition6" value="${loanApplicationSpecAdd?.condition6}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition6">

            </g:hasErrors>
        </div>             
    </div>
    <!-- condition 7-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'condition7', 'has-error')} ">
        <label class="control-label col-sm-5" for="condition7">
            <g:message code="loanApplication.condition7.label" default="Condition 7" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="condition7" name="condition7" value="${loanApplicationSpecAdd?.condition7}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="condition7">

            </g:hasErrors>
        </div>             
    </div>
    <!-- loan application type-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'loanApplicationType', 'has-error')} required">
        <label class="control-label col-sm-4" for="loanApplicationType">
            <g:message code="loanApplication.loanApplicationType.label" default="Loan Application Type" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="loanApplicationType" name="loanApplicationType" value="${loanApplicationSpecAdd?.loanApplicationType}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="loanApplicationType">

            </g:hasErrors>
        </div>             
    </div>
    <!-- loan status-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'loanStatus', 'has-error')} required">
        <label class="control-label col-sm-4" for="loanStatus">
            <g:message code="loanApplication.loanStatus.label" default="Loan Status" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="loanStatus" name="loanStatus" value="${loanApplicationSpecAdd?.loanStatus}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="loanStatus">

            </g:hasErrors>
        </div>             
    </div>
    <!-- total to date-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'totalToDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="totalToDate">
            <g:message code="loanApplication.totalToDate.label" default="Total to Date" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">
            <g:field id="totalToDate" name="totalToDate" value="${loanApplicationSpecAdd?.totalToDate}" class="form-control truncated" />
            <g:hasErrors bean="${loanApplicationInstance}" field="totalToDate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- remarks 1-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'recommendedRemarks1', 'has-error')} ">
        <label class="control-label col-sm-5" for="recommendedRemarks1">
            <g:message code="loanApplication.recommendedRemarks1.label" default="Recommendation Remark 1" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="recommendedRemarks1" name="recommendedRemarks1" value="${loanApplicationSpecAdd?.recommendedRemarks1}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="recommendedRemarks1">

            </g:hasErrors>
        </div>             
    </div>
    <!-- remarks 2-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'recommendedRemarks2', 'has-error')} ">
        <label class="control-label col-sm-5" for="recommendedRemarks2">
            <g:message code="loanApplication.recommendedRemarks2.label" default="Recommendation Remark 2" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="recommendedRemarks2" name="recommendedRemarks2" value="${loanApplicationSpecAdd?.recommendedRemarks2}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="recommendedRemarks2">

            </g:hasErrors>
        </div>             
    </div>
    <!-- recommended date-->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'recommendedDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="recommendedDate">
            <g:message code="loanApplication.recommendedDate.label" default="Recommended Date" />
            <span class="required-indicator"></span>
        </label>
        <div class="col-sm-8">

            <g:customDatePicker  id="recommendedDate" name="recommendedDate" precision="day" value="${loanApplicationSpecAdd?.recommendedDate}"  class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="recommendedDate">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee remarks -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeRemarks', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeRemarks">
            <g:message code="loanApplication.creditCommitteeRemarks.label" default="Credit Committee Remarks" />

        </label>
        <div class="col-sm-8">
            <g:textArea id="creditCommitteeRemarks" name="creditCommitteeRemarks" value="${loanApplicationSpecAdd?.creditCommitteeRemarks}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeRemarks">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee Signatory1 -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeSignatory1', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeSignatory1">
            <g:message code="loanApplication.creditCommitteeSignatory1.label" default="Credit Committee Signatory 1" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteeSignatory1" name="creditCommitteeSignatory1" value="${loanApplicationSpecAdd?.creditCommitteeSignatory1}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeSignatory1">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee Signatory2 -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeSignatory2', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeSignatory2">
            <g:message code="loanApplication.creditCommitteeSignatory2.label" default="Credit Committee Signatory 2" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteeSignatory2" name="creditCommitteeSignatory2" value="${loanApplicationSpecAdd?.creditCommitteeSignatory2}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeSignatory2">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee Signatory3 -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeSignatory3', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeSignatory3">
            <g:message code="loanApplication.creditCommitteeSignatory3.label" default="Credit Committee Signatory 3" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteeSignatory3" name="creditCommitteeSignatory3" value="${loanApplicationSpecAdd?.creditCommitteeSignatory3}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeSignatory3">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee Member1 -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeMember1', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeMember1">
            <g:message code="loanApplication.creditCommitteeMember1.label" default="Credit Committee Member 1" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteeMember1" name="creditCommitteeMember1" value="${loanApplicationSpecAdd?.creditCommitteeMember1}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeMember1">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee Member2 -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeMember2', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeMember2">
            <g:message code="loanApplication.creditCommitteeMember2.label" default="Credit Committee Member 2" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteeMember2" name="creditCommitteeMember2" value="${loanApplicationSpecAdd?.creditCommitteeMember2}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeMember2">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee president -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteePresident', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteePresident">
            <g:message code="loanApplication.creditCommitteePresident.label" default="Credit Committee President" />

        </label>
        <div class="col-sm-8">
            <g:field id="creditCommitteePresident" name="creditCommitteePresident" value="${loanApplicationSpecAdd?.creditCommitteePresident}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteePresident">

            </g:hasErrors>
        </div>             
    </div>
    <!-- credit commitee date -->
    <div class="fieldcontain form-group ${hasErrors(bean: loanApplicationInstance, field: 'creditCommitteeDate', 'has-error')} ">
        <label class="control-label col-sm-5" for="creditCommitteeDate">
            <g:message code="loanApplication.creditCommitteeDate.label" default="Credit Committee Date" />

        </label>
        <div class="col-sm-8">
            <g:customDatePicker id="creditCommitteeDate" name="creditCommitteeDate" value="${loanApplicationSpecAdd?.creditCommitteeDate}" class="form-control" />
            <g:hasErrors bean="${loanApplicationInstance}" field="creditCommitteeDate">

            </g:hasErrors>
        </div>             
    </div>
</g:if>
<g:else>
    <label class="control-label col-sm-5">
        <g:message code="loanApplication.label" default="CAM is limited for some users only." />

    </label>
</g:else>