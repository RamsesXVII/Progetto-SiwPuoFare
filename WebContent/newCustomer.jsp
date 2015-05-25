<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Customer</title>
</head>
<body>
	<f:view>
		<h:form>
(String firstName, String lastName, String email, String password, String dateOfBirth,
			String street, String city, String state, String zipcode, String country)
			
    <div>
				Name:
				<h:inputText value="#{customerController.firstName}" required="true"
					requiredMessage="name is mandatory" id="name" />
				<h:message for="name" />
			</div>
			<div>
				country:
				<h:inputText value="#{customerController.country}" required="true"
					requiredMessage="country is mandatory" id="country" />
				<h:message for="country" />
			</div>
			<div>
				zipcode:
				<h:inputText value="#{customerController.zipcode}" required="true"
					requiredMessage="zipcode is mandatory" id="zipcode" />
				<h:message for="zipcode" />
			</div>
			</div>
			<div>
				State:
				<h:inputText value="#{customerController.state}" required="true"
					requiredMessage="state is mandatory" id="state" />
				<h:message for="state" />
			</div>

			<div>
				City:
				<h:inputText value="#{customerController.city}" required="true"
					requiredMessage="city is mandatory" id="city" />
				<h:message for="city" />
			</div>
			<div>
				Street:
				<h:inputText value="#{customerController.street}" required="true"
					requiredMessage="street is mandatory" id="street" />
				<h:message for="street" />
			</div>
			<div>
				Date Of Birth:
				<h:inputText value="#{customerController.dateOfBirth}"
					required="true" requiredMessage="dateOfBirth is mandatory"
					id="dateOfBirth" />
				<h:message for="dateOfBirth" />
			</div>
			<div>
				Surname:
				<h:inputText value="#{customerController.lastName}" required="true"
					requiredMessage="lastname is mandatory" id="lastname" />
				<h:message for="lastname" />
			</div>
			<div>
				email:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				password:
				<h:inputText value="#{customerController.password}" required="true"
					requiredMessage="password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{customerController.createCustomer}" />
			</div>
			<h:commandLink action="#{orderController.listOrders}"
				value="List all Orders" />
		</h:form>
	</f:view>
</body>
</html>