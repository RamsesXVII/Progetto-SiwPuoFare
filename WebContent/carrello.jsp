<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<title>Carrello</title>
</head>
<body>
	<c:forEach var="p" items="${carrello.keySet()}">
		${p.name}, ${carrello.get(p)} 
		<br>
	</c:forEach>
	<br>
	<f:view>
		<h:form>
			<h:commandLink action="#{productController.listProducts}" value="aggiungi nuovo prodotto" />
			<br>
			<h:commandLink action="#{orderController.confermaOrdine}" value="concludi aquisto" />
		</h:form>
	</f:view>
</body>
</html>