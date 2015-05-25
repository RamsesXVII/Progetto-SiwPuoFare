<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer</title>
</head>
<body>
<f:view>
<h1>${customerController.customer.id}</h1>
<h1>${customerController.customer.firstName}</h1>
<h1>${customerController.customer.lastName}</h1>
<h1>${customerController.customer.email}</h1>
<h1>${customerController.customer.address.street}</h1>
<h1>${customerController.customer.address.city}</h1>
</f:view>
</body>
</html>