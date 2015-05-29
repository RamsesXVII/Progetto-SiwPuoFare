<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
	<f:view>
		<h:form>
			    <h:outputLabel value="Enter order ID: " /><br>
   				<h:inputText value="#{orderController.idCorrente}" />
				<h:commandLink action="#{orderController.getCustomerDetails()}" value="search customer" />
		</h:form>
	</f:view>
</body>
</html>