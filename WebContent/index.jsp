 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>home</title>
</head>
<body>
<h1>
</h1>
<ul>
<c:if test="${admin=='yes'}">
<li><a href="<c:url value="/newProduct.jsp" />">Insert a new product</a></li>
<li><a href="<c:url value="/getCustomerAndAddress.jsp" />">Get customer address</a></li>
</c:if>
<li><a href="<c:url value="/controller/product.list" />">List all product</a></li>
</ul><br>
<c:if test="${currentCustomer==null}">
<h3><a href="/Progetto-SiwPuoFare/login.jsp">LOGIN</a></h3>
</c:if>
<c:if test="${currentCustomer!=null}">
<h3><a href="/Progetto-SiwPuoFare/controller/customer.logout">LOGOUT</a></h3>
</c:if>
</body>
</html>