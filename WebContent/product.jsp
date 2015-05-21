<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
	<form action="<c:url value="/controller/orderLine.create" />" method="get">
		<h1>${product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${product.code}</div>
		<div>Price: ${product.price}</div>
		<div>Description: ${product.description}</div>
		<div>
			Quantita: <input type="text" name="quantita" />
		</div>
		<div>
			<input type="submit" name="sumbit" value="aggiungi" />
		</div>
	</form>


</body>
</html>