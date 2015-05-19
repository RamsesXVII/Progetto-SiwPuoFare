 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>login</title>
</head>
<body>
<h1>login</h1>
<form action="<c:url value="/controller/customer.login" />" method="get">
	<div>email: <input type="text" name="email"/></div>
	<div>password: <input type="password" name="password"/></div>
	<div><input type="submit" name="sumbit" value="login!" /></div>
</form>
</body>
</html>