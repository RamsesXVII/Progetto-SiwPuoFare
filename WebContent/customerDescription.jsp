 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Customer Description</title>
</head>
<body>
${requestedCustomer}<br><br>
${requestedAddress}<br><br>
<a href="<c:url value="/index.jsp" />">Home</a>

</body>
</html>