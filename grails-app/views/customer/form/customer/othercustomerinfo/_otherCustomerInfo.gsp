<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<legend>Customer Details</legend>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'displayName', 'has-error')} ">
	<label class="control-label col-sm-4"for="displayName">
		<g:message code="customer.displayName.label" default="Display Name" />
		<span class="required-indicator">*</span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="displayName"name="displayName" readonly="readonly"  value="${customerInstance?.displayName}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="displayName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="displayName" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
            <label class="control-label col-sm-4" for="dosriCode">
                    <g:message code="customer.customerCode1.label" default="Type of Resident" />
                    <span class="required-indicator">*</span>
            </label>
            <div class="col-sm-8">
                <g:select id="dosriCode" name="customerCode1.id"  required="true" noSelection="${['':'']}" from="${icbs.lov.ResidentType.findAllByStatus(true)}" optionKey="id" optionValue ="description" value="${customerInstance?.customerCode1?.id}" class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="customerCode1">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="customerCode1">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>      
            </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode2', 'has-error')} ">
            <label class="control-label col-sm-4" for="dosriCode">
                    <g:message code="customer.customerCode2.label" default="Risk Classification" />
            </label>
            <div class="col-sm-8">
                <g:select id="dosriCode" name="customerCode2.id" from="${icbs.lov.RiskType.findAllByStatus(true)}" noSelection="${['':'']}" optionKey="id" optionValue ="description" value="${customerInstance?.customerCode2?.id}" class="form-control" />
                <g:hasErrors bean="${customerInstance}" field="customerCode2">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="customerCode2">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>      
            </div>
       </div>
           <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerPepDescription', 'has-error')} ">
            <label class="control-label col-sm-4"for="customerPepDescription">
                    <g:message code="customer.pepDescription.label" default="PEP Description" />
                    <span class="required-indicator">*</span>

            </label>
            <div class="col-sm-8">
                <%-- <g:textField name="pepDescription" maxlength="50" value="${customerInstance?.pepDescription}"class="form-control"/> --%>
                <g:select id="customerPepDescription" name="customerPepDescription.id" from="${icbs.lov.PepDescriptionType.findAllByStatus(true)}" noSelection="${['':'']}" optionKey="id" optionValue ="description" value="${customerInstance?.customerPepDescription?.id}" class="form-control" />
                <%-- <g:hasErrors bean="${customerInstance}" field="customerPepDescription">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="customerPepDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors> --%>    
            </div>
    </div>
       
       
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'amla', 'has-error')} ">
            <label class="control-label col-sm-4"for="amla">
                    <g:message code="customer.amla.label" default="Verified AMLA Blocked" />

            </label>
            <div class="col-sm-8">
                <g:textField name="amla" maxlength="50" value="${customerInstance?.amla}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="amla">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="amla">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>    
            </div>
    </div>

<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode3', 'has-error')} ">
            <label class="control-label col-sm-4" for="customerCode3">
                    <g:message code="customer.customerCode3.label" default=" Size of Firm" />
            </label>
            <div class="col-sm-8">
                <g:select id="dosriCode" name="customerCode3.id" from="${icbs.lov.FirmSize.findAllByStatus(true)}" noSelection="${['':'']}" optionKey="id" optionValue ="description" value="${customerInstance?.customerCode3?.id}" class="form-control" />
                <g:hasErrors bean="${customerInstance}" field="customerCode3">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="customerCode3">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>      
            </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'typeOfSourceIncome', 'has-error')} ">
	<label class="control-label col-sm-4" for="typeOfSourceIncome">
		<g:message code="customer.typeOfSourceIncome.label" default="Type of Source Income" />
		<span class="required-indicator">*</span>
	</label>
        
	<div class="col-sm-8">  
            <g:select id="typeOfSourceIncome" name="typeOfSourceIncome.id" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus("CUST-SOI",true)}" noSelection="${['':'']}" optionKey="id" optionValue ="itemValue" value="${customerInstance?.typeOfSourceIncome?.id}" class="form-control" />
            <g:hasErrors bean="${customerInstance}" field="typeOfSourceIncome">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="typeOfSourceIncome">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>      
        </div>   
</div> 
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sourceOfIncome', 'has-error')} ">
	<label class="control-label col-sm-4" for="name1">
		<g:message code="customer.sourceOfIncome.label" default="Source of Income" />
		<span class="required-indicator">*</span>
	</label>
        
	<div class="col-sm-8">  
            <g:textField id="sourceOfIncome"name="sourceOfIncome" maxlength="50" ="" value="${customerInstance?.sourceOfIncome}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="sourceOfIncome">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="sourceOfIncome">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>      
        </div>   
</div>
<g:if test="${customerInstance?.type?.id==2}">
<!-- new added fields Date: October 18, 2016 -->
            
<!-- place of business registration -->            
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.placeOfBusinessRegistration', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.placeOfBusinessRegistration.label" default="Place of Business Registration" />
		
	</label>
                    <!--.nonpersonaladditional?     .toString().replace('[', '').replace(']', '')}-->
	<div class="col-sm-8">  
            <g:textField id="placeOfBusinessRegistration" name="placeOfBusinessRegistration" maxlength="50"  value="${customerInstance?.placeOfBusinessRegistration}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="placeOfBusinessRegistration">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="placeOfBusinessRegistration">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div>
   
      
</div>
<!-- register agency -->
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.registeringAgency', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.registeringAgency.label" default="Registering Agency" />
		
	</label>
        
	<div class="col-sm-8">  
            <g:textField id="registeringAgency" name="registeringAgency" maxlength="50"  value="${customerInstance?.registeringAgency}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="registeringAgency">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="registeringAgency">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>
<!--registrationNo-->
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.registrationNo', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.registrationNo.label" default="Registration No" />
		
	</label>
        
	<div class="col-sm-8">  
            <g:textField id="registrationNo" name="registrationNo" maxlength="50"  value="${customerInstance?.registrationNo}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="registrationNo">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="registrationNo">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>


<!-- registrationDate -->            
<!--<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.registrationDate', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.registrationDate.label" default="Registration Date" />
		
	</label>
        
	<div class="col-sm-8">  
            <input type="text" class="form-control pull-right" id="registrationDate" name="registrationDate" value="${customerInstance?.registrationDate}">
            <g:hasErrors bean="${customerInstance}" field="registrationDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="registrationDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div> -->
    <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
	<label class="control-label col-sm-4" for="registrationDate">
		<g:message code="customer.registrationDate.label" default="Registration Date" />
                

	</label>
	<div class="col-sm-8"><g:customDatePicker name="registrationDate" precision="day" class="form-control"  value="${customerInstance?.registrationDate}" default="none" noSelection="['': '']" />

            <g:hasErrors bean="${customerInstance}" field="registrationDate">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="registrationDate">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>        
<!-- TIN -->  
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.tin', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.tin.label" default="Tax Identification No (TIN)" />
		
	</label>
        
	<div class="col-sm-8">  
            <g:textField id="tin" name="tin" maxlength="50"  value="${customerInstance?.tin}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="tin">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="tin">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>

<!-- typeOfBusiness -->

<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.typeOfBusiness', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.typeOfBusiness.label" default="Type of Business" />
		
	</label>
        
	<div class="col-sm-8">  
            <g:textField id="typeOfBusiness" name="typeOfBusiness" maxlength="50"  value="${customerInstance?.typeOfBusiness}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="typeOfBusiness">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="typeOfBusiness">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>
<!--  authorizedRepresentative -->

<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.authorizedRepresentative', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.authorizedRepresentative.label" default="Authorized Representative" />
		
	</label>
        
	<div class="col-sm-8">  
            
             <g:textArea  rows="5" cols="20" id="authorizedRepresentative" name="authorizedRepresentative"   value="${customerInstance?.authorizedRepresentative}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="authorizedRepresentative">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="authorizedRepresentative">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>            
 
<!-- listOfDirectorsPartnersStackholder -->
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nonpersonaladditional.listOfDirectorsPartnersStackholder', 'has-error')} ">
	<label class="control-label col-sm-4" for="nonpersonaladditional">
		<g:message code="customer.listOfDirectorsPartnersStackholder.label" default="List of Directors Partners Stockholders" />
		
	</label>
        
	<div class="col-sm-8">  
            <g:textArea  rows="5" cols="20" id="listOfDirectorsPartnersStackholder" name="listOfDirectorsPartnersStackholder" maxlength="50"  value="${customerInstance?.listOfDirectorsPartnersStackholder}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="listOfDirectorsPartnersStackholder">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="listOfDirectorsPartnersStackholder">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>  
        </div> 
</div>             
<!-- end of new added fields Date: October 18,2016 -->
</g:if>
<g:if test="${customerInstance?.type?.id==1}">
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'dosriCode', 'has-error')} ">
            <label class="control-label col-sm-4" for="dosriCode">
                    <g:message code="customer.dosriCode.label" default="DOSRI Code" />
                    <span class="required-indicator">*</span>
            </label>
            <div class="col-sm-8">
                <g:select id="dosriCode" name="dosriCode.id" required="true" noSelection="${['':'']}" from="${icbs.lov.CustomerDosriCode.findAllByStatus(true)}" optionKey="id" optionValue ="description" value="${customerInstance?.dosriCode?.id}" class="form-control" />
                <g:hasErrors bean="${customerInstance}" field="dosriCode">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="dosriCode">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>      
            </div>
    </div>
    <br>
    <legend>Other Customer Details</legend>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'nationality', 'has-error')} ">
	<label class="control-label col-sm-4" for="nationality">
		<g:message code="customer.natonality.label" default="Nationality" />
		<span class="required-indicator">*</span>
	</label>
      
	<div class="col-sm-8"><g:select id="nationality" name="nationality.id" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus("NATL",true)}" noSelection="${['':'']}" optionKey="id" optionValue ="itemValue" value="${customerInstance?.nationality?.id}"class="form-control"/>
        <g:hasErrors bean="${customerInstance}" field="nationality">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${customerInstance}" field="nationality">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
        </div>
    </div>
    <!--
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="customer.sssNo.label" default="SSS" />

            </label>
             <div class="col-sm-8">
                <g:textField name="sssNo" maxlength="50" value="${customerInstance?.sssNo}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="sssNo">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="sssNo">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>    
             </div>

    </div>

    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'gisNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="gisNo">
                    <g:message code="customer.gisNo.label" default="GSIS" />

            </label>
            <div class="col-sm-8">
                <g:textField name="gisNo" maxlength="50" value="${customerInstance?.gisNo}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="gisNo">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="gisNo">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>    
            </div>
    </div>

    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'tinNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="tinNo">
                    <g:message code="customer.tinNo.label" default="TIN" />
            </label>
             <div class="col-sm-8">
                <g:textField name="tinNo" maxlength="50" value="${customerInstance?.tinNo}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="tinNo">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="tinNo">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>    
             </div>


    </div>

    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'passportNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="passportNo">
                    <g:message code="customer.passportNo.label" default="Passport No" />
            </label>
            <div class="col-sm-8">
                <g:textField name="passportNo" maxlength="50" value="${customerInstance?.passportNo}"class="form-control"/>
                <g:hasErrors bean="${customerInstance}" field="passportNo">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${customerInstance}" field="passportNo">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                 </g:hasErrors>    
            </div>
    </div>
    -->
   </g:if>
            
            
            
