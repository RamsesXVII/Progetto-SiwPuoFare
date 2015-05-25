<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
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
</f:view>
</body>
</html>