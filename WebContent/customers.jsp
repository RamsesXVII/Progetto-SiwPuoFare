<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Customers</title>
</head>
<body>
<f:view>
<h1>Customers</h1>
<h:form>
<table>
	<tr>
		<th>LastName</th><th>email</th>
	</tr>
	<c:forEach var="customer" items="#{customerController.customers}">
		<tr><td>
		<h:commandLink action="#{customerController.findCustomer}" value="#{customer.lastName}">
			<f:param name="id" value="#{customer.id}" />
		</h:commandLink>
		</td><td>${customer.email}</td></tr>
	</c:forEach>
</table>
</h:form>

</f:view>
</body>
</html>