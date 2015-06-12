<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



<title>Creative - Start Bootstrap Theme</title>

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

		<header>
			<div class="header-content">
				<div class="header-content-inner">
					<table>
						<tr>
							<h1>${productController.product.name}</h1>
							<h2>Dettagli</h2>
							<div>Codice: ${productController.product.code}</div>
							<div>Prezzo: ${productController.product.price}</div>
							<div>Descrizione: ${productController.product.description}</div>
							<div>Quantit&aacute disponibile: ${productController.product.qty}</div>

							<c:if test="${inserimentoIncorso==null}">
								<h:form>
									<div class="form-group">
										<label class="sr-only" for="quantity">Quantity</label><font
											color="white">Quantit&aacute desiderata:</font> <br>
										<br>
										<div class="col-sm-6 col-md-4 col-md-offset-4">
											<img class="profile-img"
												src="http://www.opensuite.it/assets/Icone/ecommerce.png"
												alt="">
											<h:inputText value="#{orderController.quantitaCorrente}"
												required="true" requiredMessage="quantity is mandatory"
												id="country" styleClass="form-control" />

											<h:message for="quantity" />


											<h:commandButton styleClass="btn btn-primary"
												value="ADD to cart" action="#{orderController.addToOrder()}"></h:commandButton>
										</div>
									</div>

								</h:form>
							</c:if>
							<c:if test="${inserimentoIncorso!=null}">

								<!-- inserimento in corso inserito in request, altrimenti una volta inserito un prodotto viene richiesto se aggiungerlo all'ordine -->

								<h:form>
									<a class="btn" href='<c:url value="/faces/newProduct.jsp" />'>Inserisci un nuovo Prodotto</a>
								</h:form>
							</c:if>
					</table>
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


