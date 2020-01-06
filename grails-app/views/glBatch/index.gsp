<%@ page import="icbs.gl.GlBatchHdr" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'glBatchHdr.label', default: 'GL Batch Transactions')}" />
    <g:if test="${postedOnOff=='postedOff'}">
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </g:if>
    <g:else>
        <title>Posted GL Batch Transactions List</title>
    </g:else>  		 
    <g:javascript>
        var processBatchTransactionAjaxLink = "${createLink(controller:'glBatch',action:'processBatchAjax')}";
        var getGlAccountsAjaxLink = "${createLink(controller:'glBatch',action:'getGLAcctByBranch')}"
	

    </g:javascript>
  </head>
  <body>
    <content tag="main-content">
      <div id="batch">
        <div id="list-glBatchHdr" class="content scaffold-list" role="main">
          <g:if test="${flash.message}">
              <script>
                    $(function(){
                        var x = '${flash.error}';
                            notify.message(x);
                    });
              </script>      
          </g:if>
          <g:if test="${flash.error}">
                <script>
                    $(function(){
                        var x = '${flash.error}';
                            notify.message(x+'|error|alert');
                    });
                </script>
          </g:if>          
                            <g:form class="form-inline">
            <div class="form-group">
              <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
            </div>
            <div class="right">
              <div class="form-group">
                <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
                <g:hiddenField name="showview" id="showview" value="${postedTransaction}" />
              </div>
              <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
            </div>
          </g:form>
          <div class="table-responsive">
                                <table class="table table-hover table-condensed table-bordered table-striped">
                                    <thead>
              <tr>
                <g:sortableColumn property="id" title="${message(code: 'glBatchHdr.id.label', default: 'Batch Series')}" />
                <g:sortableColumn property="batchId" title="${message(code: 'glBatchHdr.batchId.label', default: 'Batch ID')}" />
                <th><g:message code="glBatchHdr.errorGl.label" default="Batch Name" /></th>
              
                <g:sortableColumn property="batchType" title="${message(code: 'glBatchHdr.batchType.label', default: 'Branch')}" />
              
                <g:sortableColumn property="batchParticulars" title="${message(code: 'glBatchHdr.batchParticulars.label', default: 'Total Debits')}" />
              
                <th><g:message code="glBatchHdr.loanAcct.label" default="Total Credits" /></th>
                
                <g:sortableColumn property="batchStatus" title="${message(code: 'glBatchHdr.batchStatus.label', default: 'Batch Status')}" />
              
                <%--<th> Actions </th> --%>
                
                <th> Created By</th>
                <th>Action</th>
			   
              
              </tr>
            </thead>
            <tbody>
            <g:each in="${glBatchHdrInstanceList}" status="i" var="glBatchHdrInstance">
              <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                
                <td>${fieldValue(bean: glBatchHdrInstance, field: "id")}</td>
                <td>${fieldValue(bean: glBatchHdrInstance, field: "batchId")}</td>
                
                <!-- <td><g:link action="edit" id="${glBatchHdrInstance.id}">${fieldValue(bean: glBatchHdrInstance, field: "batchId")}</g:link></td> -->
              
                <td>${fieldValue(bean: glBatchHdrInstance, field: "batchName")}</td>
              
                <td>${fieldValue(bean: glBatchHdrInstance, field: "branch.name")}</td>
              
                <td align="right"><g:formatNumber format="###,###,##0.00" number="${glBatchHdrInstance?.totalDebit}"/></td>
                <td align="right"><g:formatNumber format="###,###,##0.00" number="${glBatchHdrInstance?.totalCredit}"/></td>
                
                <td>${glBatchHdrInstance.status.description}</td>
                <g:if test="${postedOnOff=='postedOff'}">
                    
                <%--<td> <button v-on="click: processBatch('${glBatchHdrInstance.batchId}')" class="btn btn-primary btn-xs"id="${glBatchHdrInstance.batchId}"> Run </button>
                 <g:if test="${glBatchHdrInstance.status.id == 2}">
                    
                 </g:if>
                 <g:else>
                     <g:link class="btn btn-primary btn-xs" action="edit" id="${glBatchHdrInstance.id}"> Edit </g:link>
                 </g:else>    
                 <g:link class="btn btn-primary btn-xs" target="_blank" action="printGlBatch" id="${glBatchHdrInstance.id}" params="[glBatchHdrInstance: glBatchHdrInstance, bId:glBatchHdrInstance.id]"> Print </g:link>
                 <g:hiddenField id="glBatchhid${i}" name="glBatchhid" value="${glBatchHdrInstance.id}" /> 
                 <a href="#" class="btn btn-danger btn-xs" onClick="cancelglBatch(${i});">Cancel</a>
                        <script>
                            function cancelglBatch(x){
                                var batchchidid = $('#glBatchhid'+x).val();
                                console.log("batchchidid: "+batchchidid);
                                alertify.confirm(AppTitle,"Are you sure you want to cancel this?",
                                    function(){
                                        
                                        var sessionID = batchchidid
                                        var oMyForm = new FormData();
                                        oMyForm.append("id", sessionID);
                                        console.log("sessionID: "+sessionID);
                                        var url="${createLink(controller:'GlBatch',action:'cancelBatchAjax')}";
                                                $.ajax({

                                                      url: url,
                                                      data: oMyForm,
                                                      dataType: 'text',
                                                      processData: false,
                                                      contentType: false,
                                                      type: 'POST',

                                                      success: function(data){
                                                           if(data.length > 0){
                                                            alertify.alert(AppTitle,"Successfully Canceled Gl Batch!", function(){
                                                                location.reload();
                                                              });
                                                            
                                                            
                                                           }else{
                                                           
                                                           }
                                                           
                                                           
                                                           

                                                      }

                                               });
                                    },
                                    function(){
                                      
                                    });
                            }
                        </script>
                        
                        
                </td>--%>
                
                </g:if>
                <g:else>
                 <%--<td> 
                 <g:link class="btn btn-primary btn-xs" action="edit" id="${glBatchHdrInstance.id}" params="[showview: 'posted']"> View Posted</g:link>
                 <g:link class="btn btn-primary btn-xs" target="_blank" action="printGlBatch" id="${glBatchHdrInstance.id}" params="[glBatchHdrInstance: glBatchHdrInstance, bId:glBatchHdrInstance.id]"> Print </g:link>
                </td> --%>
                </g:else>		 
                
                <td>${fieldValue(bean: glBatchHdrInstance, field: "createdBy.username")}</td>
                <td><g:link class="btn btn-primary btn-xs" action="batchDetails" id="${glBatchHdrInstance.id}"> View Details</g:link></td>
              </tr>
            </g:each>
            </tbody>
          </table>
                         </div>
          <div class="pagination">
            <g:paginate total="${GlBatchHdrInstanceCount ?: 0}" params="${params}" />
          </div>
          <g:if test="${postedOnOff=='postedOn'}">
              <g:link class="prevDaysArchive" action="prevDaysArchive"><h3>View Previous Days Posted GL Archive</h3></g:link>
          </g:if>    
        </div>
      </div>   
    </content>
            <content tag="main-actions">
                <ul>
                    
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                    <g:if test="${postedOnOff=='postedOn'}">
                        <li><g:link action="index" class="btn btn-primary btn-xs"  > View Gl Batch Transactions </g:link></li>
                    </g:if>

                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    <li><g:link action="index" class="btn btn-primary btn-xs" params="[showview: 'posted']" > GL Batch Transaction Archive </g:link></li>
                    
                   
                    
                    <li><g:link class="viewMyBatchTransactions" action="viewMyBatchTransactions">View My Batch Transactions</g:link></li>                    
                                        
                     
                    
        </ul>
    </content>
  </body>
</html>
