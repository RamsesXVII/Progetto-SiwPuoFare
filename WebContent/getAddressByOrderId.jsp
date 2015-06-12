<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
<link rel="stylesheet" href="css/styles.css" type="text/css">

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<!-- Custom Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">

<!-- Plugin CSS -->
<link rel="stylesheet" href="css/animate.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/creative.css" type="text/css">

</head>
<body id="page-top">
<body background="header.jpg">
	<f:view>
						<nav id="mainNav" class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand page-scroll" href="index.jsp">Cheap And Weak</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
	 
					<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{productController.listProducts}" value="Catalogo" /></h:form></li>
 					<c:if test="${utenteCorrente==null}">
                    <li><a class="page-scroll" href='<c:url value="/faces/newCustomer.jsp" />'>Registrati</a></li>
                    <li><a class="page-scroll" href='<c:url value="/faces/login.jsp" />'>Log in</a></li>	
                   	</c:if>
                   	
                 <c:if test="${utenteCorrente!=null}">
       			<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{orderController.carrello}" value="il mio carrello" /></h:form></li>
				<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{orderController.listCustomerOrders}" value="I miei Ordini" /></h:form></li>
				</c:if>		
       	
       			<c:if test="${admin!=null}">

				<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{customerController.listCustomers}" value="Clienti" /></h:form></li>
				<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{orderController.listOrdersToSend}" value="Odini da spedire" /></h:form></li>
				<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{orderController.listAllOrders}" value="Ordini" /></h:form></li>
				       			<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>Admin tools <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                          <li><a class="fa fa-search-plus" href='<c:url value="/faces/getAddressByOrderId.jsp" />'>Cerca cliente</a></li>
                       	 <li><a class="fa fa-plus" href='<c:url value="/faces/newProduct.jsp" />'>Inserisci prodotto</a></li>                             
                    </ul>
                    </li>
				</c:if>
       				                 <c:if test="${utenteCorrente!=null}">
       				
				<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{customerController.logout}" value="Esci" /></h:form></li>
</c:if>
					</ul> 
					
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

<br>
		<br>
		<br>
		<br>
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-md-offset-4">
					<h1 class="text-center login-title"><font color="white">Cerca cliente tramite id ordine</font></h1>
					<div class="account-wall">
						<img class="profile-img"
							src="https://cdn4.iconfinder.com/data/icons/simplicio/128x128/document_search.png"
							alt="">
						<form class="form-signin">


							<h:form>
								 <h:outputLabel value="inserisci l'id dell' ordine" /><br>
							
								<h:inputText value="#{orderController.idCorrente}" required="true"
									requiredMessage="orderdId is mandatory" id="ord"
									styleClass="form-control" />
								<h:message for="email" />
								<br><br>

								<h:commandButton value="Cerca cliente"
									action="#{orderController.getCustomerDetails()}"
									styleClass="btn btn-lg btn-primary btn-block" />
							
								</h:form>
						</form>

					</div>

				</div>
			</div>
		</div>

	</f:view>
</body>
</html>

