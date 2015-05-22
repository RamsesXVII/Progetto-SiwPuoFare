
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>home</title>
</head>
<body>
	<h1></h1>
	<ul>
		<c:if test="${isAmministrazione!=null}">
				<li><a href="<c:url value="/newProduct.jsp" />">Insert a
						new product</a></li>
		</c:if>
		<li><a href="<c:url value="/controller/product.list" />">List
				all product</a></li>
		<c:if test="${currentCustomer!=null}">
			<li><a href="<c:url value="/controller/ordersCustomer.get" />">Cronologia</a>
			</li>
		</c:if>
	</ul>
	<br>
	<c:if test="${currentCustomer==null}">
		<h3>
			<a href="<c:url value="/controller/customer.login" />">LOGIN</a>
		</h3>
	</c:if>
	<c:if test="${currentCustomer!=null}">
		<h3>
			<a href="<c:url value="/controller/customer.logout" />">LOGOUT</a>
		</h3>
	</c:if>
	<c:if test="${listOrderLines!=null}">
		<h3>
			<a href="<c:url value="/OrderLines.jsp" />"> <input type="submit"
				name="sumbit" value="concludi acquisto" /></a>
		</h3>
	</c:if>
</body>
</html>