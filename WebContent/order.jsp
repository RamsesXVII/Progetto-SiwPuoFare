<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<title>Order</title>
</head>
<body>
	<f:view>
		<h1>${orderController.order.id}</h1>
		<h2>Details</h2>
		<div>Id: ${orderController.order.stato}</div>
		<div>DataSpedizione: ${orderController.order.dataSpedizione}</div>
		<div>Cliente: ${orderController.order.customer.email}</div>
		<div>Data di creazione: ${orderController.order.creationTime}</div>
		<h1>Order Lines</h1>
		<h:form>
			<table>
				<tr>
					<th>id</th>
					<th>quantity</th>
					<th>product</th>
					<th>price</th>
				</tr>
				<c:forEach var="orderLine" items="#{orderController.order.orderLines}">
					<tr>
						<td>${orderLine.id}</td>
					
					<td>${orderLine.quantity}</td>
					
					<td>${orderLine.product.name}</td>
					
					<td>${orderLine.unitPrice}</td>
					</tr>
				</c:forEach>
			</table>
		</h:form>
	</f:view>
</body>
</html>