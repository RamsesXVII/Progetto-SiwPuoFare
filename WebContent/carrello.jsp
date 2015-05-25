<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</body>
</html>