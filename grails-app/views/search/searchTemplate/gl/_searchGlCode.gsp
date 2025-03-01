<g:javascript>
    var searchVar = new icbs.Utilities.Search("${createLink(controller : 'search', action:'search')}");
    $("#searchForm").submit(function(e){
        e.preventDefault();
  });
</g:javascript>

<div  name="inlineSearchDiv"id="inlineSearchDiv">
<%@ page contentType="text/html;charset=UTF-8" %>
<g:form id="searchForm" name="searchForm">
    <!--Custom Action  -->
     <g:hiddenField id="actionTemplate" name="actionTemplate" value="${params.actionTemplate}"/>
     <g:hiddenField id="searchDomain" name="searchDomain" value="gl-glcode"/>
     <g:hiddenField id="branch_id" name="branch_id" value="${params?.branch_id}"/>
     <g:hiddenField id="currency" name="currency" value="${params?.currency}"/>
<div class="row">
    <div class="col-md-12">
        <div class=" col-md-2">
             <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm "onchange="searchVar.searchMe();" />
        </div>
        <div class="input-group col-md-10">
            <input id="searchQuery"name="searchQuery"type="text" class="form-control" value="${params?.searchQuery}"onchange="searchVar.searchMe();">
            <span class="input-group-btn">
              <a href="#" class="btn btn-primary" onclick="searchVar.searchMe();">Search</a>
            </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
</div>
<br>
</g:form>
    <div id="grid">
        <div class="table-responsive">
                <table class="table table-hover table-condensed table-bordered table-striped">
                    <tbody>
                        <tr>    
                           <g:sortableColumn property="sort_code" title="${message(code: 'GlAccount.code.label', default: 'Gl Code')}" />

                            <g:sortableColumn property="sort_name" title="${message(code: 'GlAccount.name.label', default: 'Name')}" />

                            <g:sortableColumn property="sort_name" title="${message(code: 'GlAccount.branch.label', default: 'Branch')}" />
                            
                            <g:sortableColumn property="sort_name" title="${message(code: 'GlAccount.currency.label', default: 'Currency')}" />

                            <g:sortableColumn property="sort_name" title="${message(code: 'GlAccount.type.label', default: 'Type')}" />
                            
                            <td><label>Action</label></td> 
                            
                        </tr>
                    </tbody>
                    <tbody>
                        <g:each in="${domainInstanceList}" status="i" var="domainInstance">
                            <tr>
                                <td>${fieldValue(bean: domainInstance, field: "code")}</td>
                                <td>${fieldValue(bean: domainInstance, field: "name")}</td>
                                <td>${fieldValue(bean: domainInstance, field: "branch.name")}</td>
                                <td>${fieldValue(bean: domainInstance, field: "currency.code")}</td>
                                <td>${fieldValue(bean: domainInstance, field: "type")}</td>
                                <td><input type="button"class="btn btn-secondary" data-dismiss="modal" onclick="var temp = confirm('Are you sure you want to select this Gl Code?'); if(temp){
                                modal.addOnCloseCallbackParams('glCode2',${domainInstance?.id});
                                modal.addOnCloseCallbackParams('glCode3', '${domainInstance?.code}');
                                modal.addOnCloseCallbackParams('glName','${domainInstance?.name}');
                                }" value="Select"/></td> 
                                
                             </tr>

                        </g:each>
                    </tbody>
                </table>
            </div>            
            <div class="pagination">
                <g:paginate total="${domainInstanceCount ?: 0}"/>
            </div>
        </div>
</div>   
    
