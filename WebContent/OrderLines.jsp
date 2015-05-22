<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Line Orders</title>
</head>
<body>
	<h1>Products Selected</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Quantità</th>
			<th>Unit Price</th>
		</tr> 
		<c:forEach var="orderLine" items="${listOrderLines}">
			<tr>
				<td><a href="<c:url value="/controller/orderLine.get?id=${orderLine.product.id}" />">${orderLine.product.name}</a></td>
				<td>${orderLine.quantity}</td>
				<td>${orderLine.unitPrice}</td>
				<td><a href="<c:url value="/controller/orderLine.remove?idOrderLine=${orderLine.product.id}" />"><input
				type="submit" name="sumbit" value="rimuovi" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<h2>
		<a href="<c:url value="/controller/order.create" />"> <input
			type="submit" name="sumbit" value="effettua pagamento" /></a>
	</h2>
</body>
</html>