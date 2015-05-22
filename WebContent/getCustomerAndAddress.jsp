 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Trova dati cliente</title>
</head>
<body>
<h1>Trova dati cliente</h1>
<form action="<c:url value="/controller/customer.getaddress" />" method="get">
	<div>Inserire id dell'ordine di cui si vogliono conoscere i dettagli del cliente: 
	<input type="text" name="orderId"/></div>
	<div><input type="submit" name="sumbit" value="Cerca!" /></div>
</form>
</body>
</html>