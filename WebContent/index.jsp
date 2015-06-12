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
					<h1>Cheap And Weak</h1>
					<hr>
					<p>Cheap And Weak &eacute la miglior piattaforma di ecommerce dell'intero web.
						In pochi click sarete in grado di portare a casa i prodotti dei vostri sogni
						a prezzi vantaggiosi.  </p>
					<a href="#about" class="btn btn-primary btn-xl page-scroll">Scopri di pi&uacute</a>
				</div>
			</div>
		</header>

		<section class="bg-primary" id="about">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 text-center">
						<h2 class="section-heading">Abbiamo ci&oacute di cui hai bisogno</h2>
						<hr class="light">
						<p class="text-faded">Cheap And Weak fornisce un'ampia gamma di prodotti
						, di numerose categorie. Sport, Abbigliamento, Informatica e molto altro ancora.
						Registrarsi &eacute facile e veloce.</p>
						<a class="btn btn-default btn-xl" href='<c:url value="/faces/newCustomer.jsp" />'>Sign up</a>
					</div>
				</div>
			</div>
		</section>

		<section id="services">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2 class="section-heading">Al tuo servizio</h2>
						<hr class="primary">
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
							<i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>
							<h3>Qualit&aacute</h3>
							<p class="text-muted">La qualit&aacute dei nostri prodotti &eacute garantita.</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
							<i class="fa fa-4x fa-paper-plane wow bounceIn text-primary"
								data-wow-delay=".1s"></i>
							<h3>Spedizione immediata</h3>
							<p class="text-muted">Spediamo i vostri ordini entro 24h.</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
							<i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary"
								data-wow-delay=".2s"></i>
							<h3>Garanzia</h3>
							<p class="text-muted">Su ogni acquisto avrete diritto ad una garanzia soddisfatti o rimborsati</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
							<i class="fa fa-4x fa-heart wow bounceIn text-primary"
								data-wow-delay=".3s"></i>
							<h3>Cura dei dettagli</h3>
							<p class="text-muted">&Eacute ci&oacute che ci contraddistingue</p>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="no-padding" id="portfolio">
			<div class="container-fluid">
				<div class="row no-gutter">
					<div class="col-lg-4 col-sm-6">
						<a  class="portfolio-box"> <img
							src="img/portfolio/1.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Abbigliamento</div>
								</div>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-sm-6">
						<a  class="portfolio-box"> <img
							src="img/portfolio/2.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Oggettistica</div>
								</div>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-sm-6">
						<a  class="portfolio-box"> <img
							src="img/portfolio/3.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Fotografia</div>
								</div>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-sm-6">
						<a  class="portfolio-box"> <img
							src="img/portfolio/4.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Giardinaggio</div>
								</div>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-sm-6">
						<a class="portfolio-box"> <img
							src="img/portfolio/5.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Ricamo</div>
								</div>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-sm-6">
						<a  class="portfolio-box"> <img
							src="img/portfolio/6.jpg" class="img-responsive" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-category text-faded">Categoria</div>
									<div class="project-name">Fai da te</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
		</section>

		<aside class="bg-dark">
			<div class="container text-center">
				<div class="call-to-action">
					<h2>Visualizza subito il nostro catalogo</h2>
					<li><h:form><h:commandLink styleClass="bbtn btn-default btn-xl wow tada" action="#{productController.listProducts}" value="Visualizza il catalogo" /></h:form></li>
					
				
				</div>
			</div>
		</aside>

		<section id="contact">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 text-center">
						<h2 class="section-heading">Let's Get In Touch!</h2>
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
				</div>
			</div>
		</section>

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





