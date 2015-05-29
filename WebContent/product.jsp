<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
	<h1>${productController.product.name}</h1>
	<h2>Details</h2>
	<div>Code: ${productController.product.code}</div>
	<div>Price: ${productController.product.price}</div>
	<div>Description: ${productController.product.description}</div>
	<div>Available quantity: ${productController.product.qty}</div>

	<f:view>
		<h:form>
			<h:inputText value="#{orderController.quantitaCorrente}"/>
			<h:commandLink action="#{orderController.addToOrder()}" value="ADD to cart" />
		</h:form>
	</f:view>
</body>
</html>