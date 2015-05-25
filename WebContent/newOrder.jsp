<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Order</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{orderController.customerEmail}" 
                     required="true"
                     requiredMessage="email is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{orderController.createOrder}"/>
	</div>

	<h:commandLink action="#{orderController.listOrders}" value="List all Orders" />					
</h:form>
</f:view>
</body>
</html>