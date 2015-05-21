<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>OrderLines</h1>
	<table>
		<tr>
			<th>id</th>
			<th>unitPrice</th>
			<th>quantity</th>
		</tr>
		<c:forEach var="orderline" items="${orls}">
			<tr>
				<td>${orderline.id}</td>
				<td>${orderline.unitPrice}</td>
				<td>${orderline.quantity}</td>
				<td><a
					href="<c:url value="/controller/orderLine.get?id=${orderline.product.id}" />">
					<input type="button" onclick="/pagina" value="mostra dettagli"></a></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>