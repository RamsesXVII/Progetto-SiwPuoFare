<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Orders</title>
</head>
<body>
	<f:view>
		<h1>Orders</h1>
		<h:form>
			<table>
				<tr>
					<th>Order</th>
					<th>customer</th>
				</tr>
				<c:forEach var="ora" items="#{orderController.orders}">
					<tr>
						<td><h:commandLink action="#{orderController.sendOrder}"
								value="#{ora.id}">
								<f:param name="id" value="#{ora.id}" />
							</h:commandLink></td>
						<td>${ora.customer.email}</td>
						<td>${ora.dataSpedizione}</td>
					</tr>
				</c:forEach>
			</table>
		</h:form>
	</f:view>
</body>
</html>