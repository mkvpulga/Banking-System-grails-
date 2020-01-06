<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="section-container">
    <fieldset><legend class="section-header">Relationships</legend>
    <div id="grid">
            <%--<div class="box-body table-responsive no-padding">
                            <table class="table table-hover table-condensed table-bordered table-striped">
                                <tr> 
                                    <td><label>Customer ID</label></td>
                                    <td><label>Name</label></td>
                                    <td><label>Customer Address</label></td>
                                    <td><label>Customer Type</label></td>
                                    <td><label>Customer Relationship</label></td>
                                    <td><label>Action</label></td>
                                </tr>
                                <g:each in="${customerInstance?.relations}" status="i" var="relation">
                                    <g:if test="${relation.status?.id!=3}">
                                        <tr>
                                            <td><g:link action="customerInquiry" id="${relation?.customer2?.id}">${relation?.customer2?.customerId}</g:link></td>
                                             
                                             <td>
                                               ${relation?.customer2?.displayName}
                                             </td>
                                             <td>
                                                 <g:set var="concatenatedAddress" value="${relation?.customer2?.addresses?.find{it.isPrimary==true}}"/>
                                                 <g:if test="${concatenatedAddress!=null}">
                                                     ${concatenatedAddress.address1 +", " + concatenatedAddress.address2 +", " +concatenatedAddress.address3}
                                                 </g:if>
                                             </td>
                                             <td>
                                                ${relation?.customer2?.type?.description}
                                             </td>
                                             <td>
                                                ${relation?.type?.itemValue}
                                             </td>
                                             <td>
                                                 <input type="button" class="btn btn-secondary" value="Edit" onclick="editRelationship(${relation?.id})"/>
                                                 <!--
                                                 <input type="button" class="btn btn-secondary" value="Delete" onclick="deleteRelationship(${relation?.id})"/>
                                                 -->
                                             </td>
                                        </tr>
                                    </g:if>
                                </g:each>        
                            </table>
                <div class="pagination">
                        <g:paginate total="${domainInstanceCount ?: 0}"/>
                </div>
            </div> --%>
        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover table-condensed table-bordered table-striped">
                                <tr> 
                                   
                                    <td><label>First Name</label></td>
                                    <td><label>Middle Name</label></td>
                                    <td><label>Last Name</label></td>
                                    <td><label>Birthday</label></td>
                                    <td><label>Customer Relationship</label></td>
                                    <td><label>Status</label></td>
                                    <td><label>Action</label></td>
                                </tr>
                                <g:each in="${custmRelationCustomer}" status="i" var="relation">
                                    
                                    <tr>
                                        <td>${relation?.firstName}</td>
                                        <td>${relation?.middleName}</td>
                                        <td>${relation?.lastName}</td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${relation?.birthdate}" /></td>
                                        <td>${relation?.relationshipType?.itemValue}</td>
                                        <td>${relation?.status?.description}</td>
                                        
                                        <td><button class="btn btn-info" data-toggle="modal" data-target="#editnewRelationnonCustomer${relation.id}">Action</button></td>
                                    </tr>
                                    <div class="modal fade" id="editnewRelationnonCustomer${relation.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                    <h4 class="modal-title">Add Customer Relationship</h4>
                                                </div>
                                                <div class="modal-body">
                                                    
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="Last Name " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:textField class="form-control" name="lastName" id="lastName${relation.id}" value="${relation?.firstName}" />
                                                            <g:hiddenField class="form-control" name="relationshipId" id="relationshipId${relation.id}" value="${relation.id}" />
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="Middle Name " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:textField class="form-control" name="middleName" id="middleName${relation.id}" value="${relation?.middleName}" />
                                                        </div>
                                                    </div>
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="First Name " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:textField class="form-control" name="firstName" id="firstName${relation.id}" value="${relation?.firstName}" />
                                                        </div>
                                                    </div>
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="Birth Date " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:customDatePicker id="birthdate${relation.id}" name="birthdate" value="${relation?.birthdate}" class="form-control"  />
                                                        </div>
                                                    </div>
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="Status " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:select id="status${relation.id}"  name="status.id" from="${icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")}" optionKey="id" optionValue ="description" value="${relation?.status}" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                                        <label class="control-label col-sm-4" for="type">
                                                            <g:message code="relation.type.label" default="Relationship Type " />
                                                        </label>
                                                        <div class="col-sm-8"> 
                                                            <g:select id="type${relation.id}" name="type.id"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")}" optionKey="id" optionValue ="itemValue" value="${relation?.relationshipType?.id}" class="form-control"/>
                                                        </div>
                                                    </div>
                                                   
                                                </div>

                                                <div class="modal-footer">
                                                    <a href="#" data-dismiss="modal" class="btn">Close</a>
                                                    <a href="#" class="btn btn-primary"onclick="editoneCustomerRelationship('${relation.id}')">Edit Relationship Details</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>  
                                    
                                </g:each>        
                            </table>
                <div class="pagination">
                        <g:paginate total="${domainInstanceCount ?: 0}"/>
                </div>
            </div>    
    </div>
    </fieldset>
</div>
</div>  
