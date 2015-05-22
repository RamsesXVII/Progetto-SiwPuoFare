<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>OrderLines</title>
</head>
<body>
<h1>OrderLines</h1>
<table>
	<tr>
		<th>OrderiD</th>
		<th>Quantity</th>
		<th>UnitPrice</th>	
	</tr>
<c:forEach var="orderLine" items="${orderLines}">
		<tr>
			<td>${orderLine.product.name}</td>
			<td>${orderLine.quantity}</td>
			<td>${orderLine.unitPrice}</td>
		</tr>
	</c:forEach>
				<td><a href="<c:url value="/controller/Order.Validate?id=${id}" />">
			<input type="submit" name="sumbit" value="confermaESpedisci" /></a></td>
</table>
</body>
</html>