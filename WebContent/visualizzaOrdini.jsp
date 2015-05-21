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
	<h1>Orders</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>creationTime</th>
		</tr>		
		<c:forEach var="order" items="${orders}">
			<tr>						
				<td>${order.id}</td>
				<td>${order.creationTime}</td>
				<td><a href="<c:url value="/controller/orderLines.get?idOrder=${order.id}" />"><input
				type="submit" name="sumbit" value="mostra dettagli" /></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>