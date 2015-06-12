<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="it">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Cheap And Weak</title>

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
					<a class="navbar-brand page-scroll" href="#page-top">Cheap And Weak</a>
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

<header>
			<div class="header-content">
				<div class="header-content-inner">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 text-center">
						<h2 class="section-heading">Benvenuto su Cheap&Weak, ${customerController.customer.firstName}</h2>
						<hr class="primary">
						<p>Per qualunque tipo di necessit&aacute non esitare a contattare il nostro servizio clienti</p>
					</div>
					<div class="col-lg-4 col-lg-offset-2 text-center">
						<i class="fa fa-phone fa-3x wow bounceIn"></i>
						<p>346 5800052</p>
					</div>
					<div class="col-lg-4 text-center">
						<i class="fa fa-envelope-o fa-3x wow bounceIn"
							data-wow-delay=".1s"></i>
						<p>
						
							<a href="mailto:your-email@your-domain.com">siwpuofare@uniroma3.it</a>
						</p>
					</div>
						<a href='<c:url value="/faces/login.jsp" />' class="btn btn-primary btn-xl page-scroll" >Prova subito Cheap&Weak</a>					
				</div>
			</div>
			</div>
			</header>

		<!-- jQuery -->
		<script src="js/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>

		<!-- Plugin JavaScript -->
		<script src="js/jquery.easing.min.js"></script>
		<script src="js/jquery.fittext.js"></script>
		<script src="js/wow.min.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="js/creative.js"></script>
	</f:view>

</body>

</html>





