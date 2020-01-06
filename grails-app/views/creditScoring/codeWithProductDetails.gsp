<%@ page import="icbs.loans.CreditInvestigation" %>\
<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>Credit Scoring Product Information</title>
	</head>
	<body>
        <content tag="main-content">   
            <div id="list-creditInvestigation" class="content scaffold-list" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
            </div>
            <div class="row">
                <div class="col-md-12">
                <div class="section-container">
                    <fieldset>
                    <legend class="section-header"> Details</legend>


                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Code</td>
                                        <td width="70%">${productUndercodeInstance?.code}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Description</td>
                                        <td width="70%">${productUndercodeInstance?.description}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Has Rated Items</td>
                                        <td width="70%">${productUndercodeInstance?.hasRatedItem}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </fieldset>
                </div>
            </div> 
            <div class="row">
                <div class="col-md-12">
                <div class="section-container">
                    <fieldset>
                    <legend class="section-header"> Products</legend>
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th>Product code</td>
                                        <th>Product Name</td>
                                        <th>Product Short Name</td>
                                    </tr>
                                    <g:each in="${productResultsUndercode}" var="prodx" >
                                        <tr>
                                            <td>${prodx?.product?.code}</td>
                                            <td>${prodx?.product?.name}</td>
                                            <td>${prodx?.product?.shortName}</td>
                                        </tr>
                                    </g:each>
                                    
                                </tbody>
                            </table>
                        </div>

                    </fieldset>
                </div>
            </div> 
            
            </content>
            
           <content tag="main-actions">
                <ul>
                    <li><g:link controller="creditScoring"  action="updateCodeAndProducts" id="${productUndercodeInstance.id}">Update</g:link></li>
                    <li><g:link controller="creditScoring"  action="configProduct" >Back to Index</g:link></li>
		</ul>
            </content>
	</body>
</html>
