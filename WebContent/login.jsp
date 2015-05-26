<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				email:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="Email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				password:
				<h:inputText value="#{customerController.password}" required="true"
					requiredMessage="password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="login"
					action="#{customerController.login()}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>