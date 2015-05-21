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
Dimensione ${orderLines.size()}
<c:forEach var="orderLine" items="${orderLines}">
		<tr>
			<td>${orderLine}</td>
		</tr>
	</c:forEach>
				<td><a href="<c:url value="/controller/Order.Validate?id=${id}" />">
			<input type="submit" name="sumbit" value="confermaESpedisci" /></a></td>
</body>
</html>