<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Other Cash Receipt Transaction - SSS Payment</title>
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Other Cash Receipt Transaction - General</span>
        </content>
        <content tag="main-content">
            <g:form name="txnReceiptAdjustmentForm" action="save" 
                controller="sssCollection" onsubmit="return alertify.alert('Please wait... Processing....')">
                <g:render template='form' />
            </g:form>
        </content>
        <content tag="main-actions">
            <ul>
                <li><a class="save" onclick="validateFields();">${message(code: 'default.button.create.label', default: 'Create')}</a></li>
                <li><g:link action="index">Tellering Index</g:link></li>
        </content>        
    </body>
</html>
