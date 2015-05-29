<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>SiwPuoFare</title>
</head>
<body>
	<f:view>
		<h1>Welcome!!!</h1>
		<ul>
		<h:form>
			<li><a href='<c:url value="/faces/newCustomer.jsp" />'>Sign up</a></li>
			<c:if test="${utenteCorrente==null}">
			<li><h:commandLink action="/faces/login.jsp" value="Sign in" /></li>
			</c:if>

			<c:if test="${admin!=null}">

				<li><a href='<c:url value="/faces/newProduct.jsp" />'>Insert
						a new product</a></li>
				<li><h:commandLink action="#{customerController.listCustomers}"
						value="List all customers" /></li>
				<li><h:commandLink action="#{orderController.listOrdersToSend}"
						value="List all orders to send" /></li>
				<li><h:commandLink action="#{orderController.listAllOrders}"
						value="List all orders" /></li>
				<li><a href='<c:url value="/faces/getAddressByOrderId.jsp" />'>Get
						customer by id</a></li>
			</c:if>


			<li><h:commandLink action="#{productController.listProducts}"
					value="List all Products" /></li>




			<c:if test="${utenteCorrente!=null}">
				<li><h:commandLink action="#{customerController.logout}"
						value="Sign out" /></li>
				<li><h:commandLink
						action="#{orderController.listCustomerOrders}"
						value="List my orders" /></li>
			</c:if>		
	</h:form>
		</ul>
	</f:view>
</body>
</html>

