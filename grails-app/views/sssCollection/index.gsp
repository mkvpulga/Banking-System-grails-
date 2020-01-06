<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>SSS eCollection Transactions</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Teller Transaction</span>
        </content>
        <content tag="main-content">
            <g:if test="${flash.message}">
                <script>
                     $(function(){
                        notify.message("${flash.message}");
                    });
                </script>
            </g:if>
            <g:form class="form-inline">
                    <div class="form-group">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
                            <div class="form-group">
                                    <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Search"/>
                            </div>
                            <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
            </g:form>
            <table class="table table-hover table-condensed table-bordered table-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="brnum" title="${message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Billing Ref Num')}" />
                        <g:sortableColumn property="indiIprnum" title="${message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Individual Payment Ref Num')}" />
                        <g:sortableColumn property="ername" title="${message(code: 'SssOnlinePaymentDetail.ername.label', default: 'Employer Name')}" />
                        <g:sortableColumn property="indiEename" title="${message(code: 'SssOnlinePaymentDetail.indiEename.label', default: 'Individual Name')}" />
                        <g:sortableColumn property="amount" title="${message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Amount')}" />
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${sssOnlinePaymentDetailList}" status="i" var="sssInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${sssInstance.brnum}</td>
                            <td>${sssInstance.indiIprnum}</td>
                            <td>${sssInstance.ername}</td>
                            <td>${sssInstance.indiEename}</td>
                            <td><g:formatNumber format="###,###,##0.00" number="${sssInstance?.amount}"/></td>
                            <td><g:link class="btn btn-secondary" action="show" id="${sssInstance.id}">View</g:link></td>
                        </tr>
                    </g:each>    
                </tbody>
            </table>    
            <div class="pagination">
                    <g:paginate total="${sssOnlinePaymentDetailInstanceCount ?: 0}" params="${params}" />
            </div>
            
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="sssOnlineCreate">SSS Online Collection (Employer)</g:link></li>
                <li><g:link action="sssCreateIndividualPayment">SSS Online Collection via PRN (Individual Member)</g:link></li>
                <li><g:link action="sssCreateIndividualPaymentNoPrn">SSS Online Collection without PRN (Individual Member)</g:link></li>
                <li><g:link action="createPrn">Request New Individual PRN</g:link></li>
                <li><g:link action="create">SSS Other Collections</g:link></li>
            </ul>                                        
        </content>    
  </body>
</html>
