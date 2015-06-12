<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">
	<head>
		<title>Il tuo carrello</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="cart/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="cart/css/custom.css"/>		
		
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

	<body>
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
		
		<div class="container-fluid breadcrumbBox text-center">
			<ol class="breadcrumb">
				<li class="active"><a href="#">Order</a></li>
			</ol>
		</div>
		
		<div class="container text-center">

			<div class="col-md-5 col-sm-12">
				<div class="bigcart"></div>
				<h1>Il tuo carrello <c:if test="${carrello==null}"> &eacute vuoto</c:if></h1>
				<p>
					Questo &eacute il tuo carrello. A destra c' &eacute l'elenco degli
					oggetti che hai inserito nel carrello. Sfortunatamente questa versione
					del sito non supporta l'annullamento dell'inserimento degli articoli. Fai molta
					attenzione...
				</p>
			</div>
			
			<div class="col-md-7 col-sm-12 text-left">
				<ul>
					<li class="row list-inline columnCaptions">
						<span>QTY</span>
						<span>Prodotto</span>
						<span>Prezzo</span>
					</li>
						<c:forEach var="p" items="${carrello.keySet()}">
						<li class="row">
						<span class="quantity">${carrello.get(p)}</span>
						<span class="itemName">${p.name}</span>
						<span class="price">${p.price} 	</span>
					</li>
						</c:forEach>

					<li class="row totals">
						<span class="itemName">Total:</span>
						<c:if test="${carrello!=null}">
						<span class="price">${totaleVendita}</span>
						<span class="order"><h:form><h:commandLink action="#{productController.listProducts}" value="Acquista ancora" /></h:form></span>
						<span class="order"><h:form><h:commandLink action="#{orderController.confermaOrdine}" value="Concludi acquisti" /></h:form></span>
						</c:if>
					</li>
				</ul>
			</div>

		</div>

		<!-- The popover content -->

		<div id="popover" style="display: none">
			<a href="#"><span class="glyphicon glyphicon-pencil"></span></a>
			<a href="#"><span class="glyphicon glyphicon-remove"></span></a>
		</div>
		
		<!-- JavaScript includes -->

		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/customjs.js"></script>
</f:view>
	</body>
</html>