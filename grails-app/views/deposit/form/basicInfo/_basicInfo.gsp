<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<fieldset>
            <legend>Module and Product</legend>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'type', 'has-error')} required">
                <label class="control-label col-sm-4" for="type">
                        <g:message code="deposit.type.label" default=" Deposit Type" />
                        <span class="required-indicator">*</span>
                </label>
                
                <div class="col-sm-8">
                    <g:if test="${!depositInstance?.type?.id}">
                        <g:select id="type" onchange="changeAcctInformationForm()" name="type.id" from="${icbs.lov.DepositType.list()}" optionKey="id" optionValue="description" required="" value="${depositInstance?.type?.id}" class="many-to-one form-control"/>
                    </g:if>
                    <g:else>
                        <g:hiddenField id="type" name="type.id" value="${depositInstance?.type?.id}"/>
                        <g:textField name="type" disabled="disabled" value="${depositInstance?.type?.description}"class="form-control"/>
                    </g:else>
                    <g:hasErrors bean="${depositInstance}" field="type">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="type">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'product', 'has-error')} required">
                <label class="control-label col-sm-4" for="product">
                    <g:message code="deposit.product.label" default="Deposit Product" />
                    <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    <g:if test="${!depositInstance?.product?.id}">
                       <g:select id="product" name="product.id" from="${icbs.admin.Product.list()}" optionKey="id" optionValue="name" required="" value="${depositInstance?.product?.id}" class="many-to-one form-control"/>
                    </g:if>
                    <g:else>
                        <g:hiddenField id="product" name="product.id" value="${depositInstance?.product?.id}"/>
                        <g:textField name="product" disabled="disabled" value="${depositInstance?.product?.name}"class="form-control"/>
                    </g:else>
                    
                    <g:hasErrors bean="${depositInstance}" field="product">
                        <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${depositInstance}" field="product">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            <div class="form-group fieldcontain ${hasErrors(bean: depositInstance, field: 'glLink', 'has-error')} ">
                <label class="control-label col-sm-4"for="glLink">
                    GL Link
                </label>
                <div class="col-sm-8">
                    <g:if test="${depositInstance?.typeId == 1}">
                        <g:select id="glLink" name="glLink.id" from="${icbs.gl.CfgAcctGlTemplate.findAllByType("1")}" optionKey="id" optionValue ="description" value="${depositInstance?.glLink?.id}" class="form-control" />
                    </g:if>
                    
                    <g:if test="${depositInstance?.typeId == 2}">
                        <g:select id="glLink" name="glLink.id" from="${icbs.gl.CfgAcctGlTemplate.findAllByType("2")}" optionKey="id" optionValue ="description" value="${depositInstance?.glLink?.id}" class="form-control" />
                    </g:if>
                    
                    <g:if test="${depositInstance?.typeId == 3}">
                        <g:select id="glLink" name="glLink.id" from="${icbs.gl.CfgAcctGlTemplate.findAllByType("3")}" optionKey="id" optionValue ="description" value="${depositInstance?.glLink?.id}" class="form-control" />
                    </g:if>
                    
                    <g:if test="${depositInstance?.typeId == 4}">
                        <g:select id="glLink" name="glLink.id" from="${icbs.gl.CfgAcctGlTemplate.findAllByType("4")}" optionKey="id" optionValue ="description" value="${depositInstance?.glLink?.id}" class="form-control" />
                    </g:if>
                    
                    <g:if test="${depositInstance?.typeId == 5}">
                        <g:select id="glLink" name="glLink.id" from="${icbs.gl.CfgAcctGlTemplate.findAllByType("5")}" optionKey="id" optionValue ="description" value="${depositInstance?.glLink?.id}" class="form-control" />
                    </g:if>

                     <g:hiddenField name="oldGlinkId" id="oldGlinkId" value="${depositInstance?.glLink?.id}" />
                    <g:hasErrors bean="${depositInstance}" field="glLink">
                        <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${depositInstance}" field="glLink">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                        </div>
                     </g:hasErrors>    
                </div>
            </div>
            
            <fieldset class="form-group">        
                        <input type="button" href="#" style="background-color: #0089db;color: white;" class="btn btn-secondary"onclick="initializeCustomerDetailsSearchModal();modal.show()" value="Update Customer Information"/>
                    <div id="customerDetailsDiv">
                        <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:depositInstance?.customer]"/>
                    </div>

            </fieldset>            
</fieldset>