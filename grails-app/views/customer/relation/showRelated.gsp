<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Customer Relationships</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="customerHelper.js"/>
        <g:javascript>
            function updateCustomerRelatedForm(){
                icbs.Customer.Relation('relationForm',"${createLink(controller : 'customer', action:'customerShowRelatedFormAjax')}",{id:${customerInstance?.id}});
            }
            function addRelationship(params){
                if(params){
                    icbs.Customer.Relation('add',"${createLink(controller : 'customer', action:'customerCreateRelatedAjax')}",{id:${customerInstance?.id},customerRelationshipType:${customerInstance?.type?.id},customer2:params.customer2});
                }else{
                     icbs.Customer.Relation('add',"${createLink(controller : 'customer', action:'customerCreateRelatedAjax')}",{id:${customerInstance?.id},customerRelationshipType:${customerInstance?.type?.id}});
                }
               
            }
            //Add new customer relation
            function saveRelationshipAuthCallback(){
                icbs.Customer.Relation('save',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#createRelatedDiv :input').serialize());
            }
            //Override for adding new customer relation
            function saveRelationship(){
                checkIfAllowed('CIF00100', saveRelationshipAuthCallback); // params: policyTemplate.code, form to be saved
            }

            function editRelationship(id){
                icbs.Customer.Relation('edit',"${createLink(controller : 'customer', action:'customerEditRelatedAjax')}",{id:id,customerRelationshipType:${customerInstance?.type?.id}});
            }
            function deleteRelationship(id){
                icbs.Customer.Relation('delete',"${createLink(controller : 'customer', action:'customerDeleteRelatedAjax')}",{id:id,customerRelationshipType:${customerInstance?.type?.id}});
            }
            
            //Update Customer Relationship details
            function updateRelationshipAuthCallback(){
                icbs.Customer.Relation('update',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#editRelatedDiv :input').serialize());
            }
            //Override for customer relationship update
            function updateRelationship(){
                checkIfAllowed('CIF00100', updateRelationshipAuthCallback); // params: policyTemplate.code, form to be saved
            }
            
            
            function updtRelationship(){
                icbs.Customer.Relation('update',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#deleteRelatedDiv :input').serialize());
            }
            
            icbs.Dependencies.Ajax.addLoadEvent(function(){
                ;$('#editRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                })
                $('#addRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                });
                $('#deleteRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                });
            })
            var modal;
            function initializeAddRelationSearchModal(){
                modal = new icbs.UI.Modal({id:"addRelationSearchModal",url:"${createLink(controller : 'search', action:'search')}",title:"Search Customer",onCloseCallback:addRelationship});
            }
            
            function addNoneCustomerRelationship(){
                console.log("jmpogi: ");
                //lastName/middleName/firstName/birthdate/status/type
                var lastName = $('#lastName').val();
                var middleName = $('#middleName').val();
                var firstName = $('#firstName').val();
                var birthdate = $('#birthdate').val();
                var status = $('#status').val();
                var type = $('#type').val();
                console.log("lastName: "+lastName);
                console.log("middleName: "+middleName);
                console.log("firstName: "+firstName);
                console.log("birthdate: "+birthdate);
                console.log("status: "+status);
                console.log("type: "+type);
                if(lastName == null || lastName == ""){
                    notify.message("Field Last Name Cannot be empty! |error|alert");
                }else if(firstName == null || firstName == ""){
                    notify.message("Field First Name Cannot be empty! |error|alert");
                }else if(birthdate == null || birthdate == ""){
                    notify.message("Field Birth Date Cannot be empty! |error|alert");
                }else if(status == null || status == ""){
                    notify.message("Field Status Cannot be empty! |error|alert");
                }else if(type == null || type == ""){
                    notify.message("Field Status Cannot be empty! |error|alert");
                }else{
                    alertify.confirm(AppTitle,"Are you you want to add this?",
                    function(){
                      $('#relationForm').submit();
                    },
                    function(){
                      alertify.error('Canceled');
                    });
                    
                }
            }
            function editoneCustomerRelationship(xId){
                console.log("edit jmpogi: ");
                //lastName/middleName/firstName/birthdate/status/type
                
                var lastName = $('#lastName'+xId).val();
                var middleName = $('#middleName'+xId).val();
                var firstName = $('#firstName'+xId).val();
                var birthdate = $('#birthdate'+xId).val();
                var relationId = $('#relationshipId'+xId).val();
                var status = $('#status'+xId).val();
                var type = $('#type'+xId).val();
                
                console.log("relationId: "+relationId);
                console.log("lastName: "+lastName);
                console.log("middleName: "+middleName);
                console.log("firstName: "+firstName);
                console.log("birthdate: "+birthdate);
                console.log("status: "+status);
                console.log("type: "+type);
                
                if(lastName == null || lastName == ""){
                    notify.message("Field Last Name Cannot be empty! |error|alert");
                }else if(firstName == null || firstName == ""){
                    notify.message("Field First Name Cannot be empty! |error|alert");
                }else if(birthdate == null || birthdate == ""){
                    notify.message("Field Birth Date Cannot be empty! |error|alert");
                }else if(status == null || status == ""){
                    notify.message("Field Status Cannot be empty! |error|alert");
                }else if(type == null || type == ""){
                    notify.message("Field Status Cannot be empty! |error|alert");
                }else{
                    alertify.confirm(AppTitle,"Are you you want to add this?",
                    function(){
                        //===========================
                        var obj = { 
                            lastName: lastName,
                            middleName: middleName,
                            firstName: firstName,
                            birthdate: birthdate,
                            relationId: relationId,
                            status: status,
                            type: type,
                        }; 
                        console.log(JSON.stringify(obj));
                        console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: "${createLink(controller:'Customer', action:'editnewCustomerRelationShip')}",
                            data: JSON.stringify(obj),

                            success: function(data){
                                if(data.length >=1){
                                    
                                    alertify.alert(AppTitle,"Successfully updated!", function(){
                                        $('#editnewRelationnonCustomer'+xId).hide();
                                       location.reload();
                                     });

                                }
                            },
                            error: function(data){

                            },

                        });  
                        //===========================
                    },
                    function(){
                      alertify.error('Canceled');
                    });
                    
                }
            }
        </g:javascript>
    </head>
    <body>
        <content tag="main-content">
        <div class="row">
                <div class="col-xs-12 col-sm-12">
                  <div class="section-container">
                    <fieldset>
                        <legend class="section-header">Primary Information</legend>
                        <div class="infowrap">
                             <div class="col-xs-3 col-sm-3">
                                <div style="margin:auto; padding:20px;"><g:if test="${(customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id}"> <img width="160px" height="160px"src="${createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id )}"/></g:if></div>
                             </div>
                            
                            
                            <div class="col-xs-12 col-sm-8">
                            
                                <g:if test="${customerInstance?.type.id==1}">
                                    
                                    <h3 style="font-weight:bold;">${customerInstance?.name3}, ${customerInstance?.name1} ${customerInstance?.name2}</h3>
                                    <p><i>(Last Name, First Name, Middle Name)</i></p>
                                    
                                    
                                    <dl class="dl-horizontal">
                                        <dt>Display Name</dt>
                                        <dd>${customerInstance?.displayName}</dd>
                                    </dl>
                                    
                                    
                                    <dl class="dl-horizontal">
                                        <dt>Title</dt>
                                        <dd>${customerInstance?.title?.itemValue}</dd>
                                    </dl>
                                    
                                                                      
                                     <dl class="dl-horizontal">
                                        <dt>Initials</dt>
                                        <dd>${customerInstance?.name4}</dd>
                                    </dl>
                                    
                                    <dl class="dl-horizontal">
                                        <dt>Gender</dt>
                                        <dd>${customerInstance?.gender?.description}</dd>
                                    </dl>
                                    <dl class="dl-horizontal">
                                        <dt>Date of Birth</dt>
                                        <dd>${customerInstance?.birthDate?.format("MM/dd/yyyy")}</dd>
                                    </dl>
                                </g:if>
                                <g:else>
                                    <dl class="dl-horizontal">
                                        <dt>Company Name</dt>
                                        <dd>${customerInstance?.name1}</dd>
                                    </dl>
                                    <dl class="dl-horizontal">
                                        <dt>Registration Date</dt>
                                        <dd>${customerInstance?.birthDate?.format("MM/dd/yyyy")}</dd>
                                    </dl>
                                </g:else>
                                    
                                      <dl class="dl-horizontal">
                                        <dt>Customer ID</dt>
                                        <dd>${customerInstance?.customerId}</dd>
                                     </dl>
                                      
                                     <dl  class="dl-horizontal">
                                       <dt>Customer Type</dt>
                                        <dd>${customerInstance?.type?.description}</dd>
                                    </dl>
                                
                                <g:if test="${customerInstance?.type?.id==1}">
                                    <dl class="dl-horizontal">
                                        <dt>Civil Status</dt>
                                        <dd>${customerInstance?.civilStatus?.itemValue}</dd>
                                    </dl>
                                    <dl class="dl-horizontal">
                                        <dt>Birth Place</dt>
                                        <dd>${customerInstance?.birthPlace}</dd>
                                    </dl>
                                    <dl class="dl-horizontal">
                                        <dt>Nationality</dt>
                                        <dd>${customerInstance?.nationality?.itemValue}</dd>
                                    </dl>
                      
                                    <dl class="dl-horizontal">
                                        <dt>Credit Limit</dt>
                                        <dd><g:formatNumber format="#,##0.00" number="${customerInstance?.creditLimit}"/></dd>
                                    </dl>
                                </g:if>   
                    </div>    
                </fieldset>
              </div><!-- end section-container-->
            </div><!-- end of column -->
           </div> <!-- end of row-->
           <div class="row">
                <div id="showRelatedFormDiv">
                    <g:render template='relation/showRelatedForm'/>
                </div>
            </div>
            <div class="modal" id="addRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="createRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="saveRelationship()">Save changes</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal" id="editRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Edit Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="editRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updateRelationship()">Save changes</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal" id="deleteRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Delete Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="deleteRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updtRelationship()">Delete</a>
                        </div>
                    </div>
                </div>
            </div>  
            <%-- sdsdsd --%>
            <div class="modal fade" id="addnewRelationnonCustomer">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add Customer Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:form method="POST" id="relationForm" url="[action:'addnewCustomerRelationShip',controller:'Customer']">
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="Last Name " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:textField class="form-control" name="lastName" id="lastName" value="" />
                                    <g:hiddenField class="form-control" name="customer" id="customer" value="${customerInstance?.id}" />
                                </div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="Middle Name " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:textField class="form-control" name="middleName" id="middleName" value="" />
                                </div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="First Name " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:textField class="form-control" name="firstName" id="firstName" value="" />
                                </div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="Birth Date " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:customDatePicker id="birthdate" name="birthdate" value="" class="form-control"  />
                                </div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="Status " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:select id="status"  name="status.id" from="${icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")}" optionKey="id" optionValue ="description" value="" class="form-control"/>
                                </div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
                                <label class="control-label col-sm-4" for="type">
                                    <g:message code="relation.type.label" default="Relationship Type " />
                                </label>
                                <div class="col-sm-8"> 
                                    <g:select id="type" name="type.id"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")}" optionKey="id" optionValue ="itemValue" value="" class="form-control"/>
                                </div>
                            </div>
                            </g:form>
                        </div>
                        
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="addNoneCustomerRelationship()">Add Relationship</a>
                        </div>
                    </div>
                </div>
            </div>                      
        </content>
        <content tag="main-actions">
            <ul>
                <%--<g:if test="${customerInstance}">
                    <li><a href="#" onclick="addRelationship()">Add new Relationship</a></li>
                </g:if>
                <g:else>
                    <li><button disabled>Add New Relationship</button></li>
                </g:else> --%>
                <li><button data-toggle="modal" data-target="#addnewRelationnonCustomer" >Add new Relationship</button></li>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
            </ul>
        </content>
    </body> 
</html>
        

