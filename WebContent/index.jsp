<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>SIW-JEE-ES2</title>
</head>
<body>
	<f:view>
		<h1>SIW-JEE-ES2</h1>
		<ul>
				<li><a href='<c:url value="/faces/newCustomer.jsp" />'>Registrazione</a></li>

				<li><a href='<c:url value="/faces/newProduct.jsp" />'>Insert
						a new product</a></li>
			<li><h:form>
					<h:commandLink action="#{productController.listProducts}"
						value="List all Products" />
				</h:form></li>

				<li><h:form>
						<h:commandLink action="#{customerController.listCustomers}"
							value="List all customers" />
					</h:form></li>
				<li><a href='<c:url value="/faces/getAddressByOrderId.jsp" />'>Trova customer dato un id</a></li>
				<li><h:form>
						<h:commandLink action="#{orderController.listOrdersToSend}"
							value="List all orders to send" />
					</h:form></li>
				<li><h:form>
						<h:commandLink action="#{orderController.findOrders}"
							value="cronologia" />
					</h:form></li>
				<li><h:form>
						<h:commandLink action="#{orderController.findOrders}"
							value="cronologia" />
					</h:form></li>
				<li><h:form>
						<h:commandLink action="#{orderController.listAllOrders}"
							value="list all orders" />
					</h:form></li>
			<c:if test="${utenteCorrente==null}">
				<li><h:form>
						<h:commandLink action="/faces/login.jsp" value="Login" />
					</h:form></li>
			</c:if>
			<c:if test="${utenteCorrente!=null}">
				<li><h:form>
						<h:commandLink action="#{customerController.logout}"
							value="Logout" />
					</h:form></li>
			</c:if>
			
		</ul>
	</f:view>
</body>
</html>

