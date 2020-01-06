<%@ page import="icbs.tellering.TxnCOCI" %>
<g:if test="${flash.message}">
    <script>
         $(function(){
            notify.message("${flash.message}");
        });
    </script>
</g:if>
<table class="table table-hover table-condensed table-bordered table-striped" id="tblcoci">
    <thead>
        <tr>
            <g:sortableColumn property="bank" title="${message(code: 'TxnCOCI.bank.label', default: 'Clearing Bank')}" />
            <g:sortableColumn property="checkNo" title="${message(code: 'TxnCOCI.checkNo.label', default: 'Check No.')}" />
            <g:sortableColumn property="checkAcctName" title="${message(code: 'TxnCOCI.checkAcctName.label', default: 'Check Account Name')}" />
            <g:sortableColumn property="checkAmt" title="${message(code: 'TxnCOCI.checkAmt.label', default: 'Check Amount')}" />
            <g:sortableColumn property="clearingDate" title="${message(code: 'TxnCOCI.clearingDate.label', default: 'Clearing Date')}" />

            <td>Actions</td>
        </tr>
    </thead>
    <tbody>
        <g:each in="${TxnCOCI.findAllByDepAcct(depositInstance,[sort: "id", order: "asc"])}" status="i" var="txnCociInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${txnCociInstance?.bank?.name}</td>
                <td>${txnCociInstance?.checkNo}</td>
                <td>${txnCociInstance?.checkAcctName}</td>
                <td align = "right"><g:formatNumber format="###,###,##0.00" number="${txnCociInstance?.checkAmt}"/></td>
                <td><g:formatDate format="MM/dd/yyyy" date="${txnCociInstance?.clearingDate}"/></td>
                <td><g:link class="btn btn-secondary" action="viewUnclearedDeposit" id="${txnCociInstance.id}">View</g:link></td>
            </tr>
        </g:each>  
    </tbody>
</table>    
<div class="pagination">
       <g:paginate total="${txnCociInstanceCount ?: 0}" params="${params}" />
</div>
<script>
    $(document).ready(function() {
    $('#tblcoci').DataTable({
      dom: 'Bfrtlip',
     //dom : '<"wrapper"flipt>',

        buttons: [
            {
                extend: 'print',
                customize: function ( win ) {
                    $(win.document.body)
                        .css( 'font-size', '10pt' )
                        .prepend(
                            '<img src="icbs/assets/logo.png" style="position:absolute; top:0; left:0;" />'
                        );

                    $(win.document.body).find( 'table' )
                        .addClass( 'compact' )
                        .css( 'font-size', 'inherit' );
                }
            }
        ]   
    });

   $('.buttons-print').hide();
} );
</script>