<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>OrdersNoSent</title>
</head>
<body>
<h1>OrderToSend</h1>
<table>
	<tr>
	
		<th>Order</th>
		<th>Customer</th>
		<th>Status</th>	
	</tr>
	<c:forEach var="ord" items="${ordersnosent}">
	<!-- 	<tr><td> <input type="button" onclick="/pagina" value="clicca e vai"></td>  -->
	<tr>
	<!-- 	<tr><td><a href="<c:url value="/controller/order.send?id=${ord.id}" />">${ord.id}</a></td>  -->
			<td>${ord.id}</td>
			<td>${ord.customer.email}</td>
			<td>${ord.stato}</td>
			<td><a href="<c:url value="/controller/orderlines.get?id=${ord.id}" />">
			<input type="submit" name="sumbit" value="mostra" /></a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>