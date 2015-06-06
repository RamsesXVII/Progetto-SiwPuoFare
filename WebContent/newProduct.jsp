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
<title>Cheap&Weak Product Registration Form</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

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

<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<f:view>
		<!-- Top menu -->
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
					<a class="navbar-brand page-scroll" href="index.html">Cheap And Weak</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
	 
					<li><h:form><h:commandLink styleClass="btn btn-inverse navbar-btn" action="#{productController.listProducts}" value="Mostra Catalogo" /></h:form></li>

       				
       
					</ul> 
					
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- Top content -->
		<div class="top-content">

			<div class="inner-bg">
				<div class="container">
					<div class="row">
						<div class="col-sm-8 col-sm-offset-2 text">
							<h1>
								<strong>Cheap&Weak</strong> Product Registration Form
							</h1>
							<div class="description">
								<p>
									Aggiungi un nuovo prodotto compilando la form sottostante
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 book">
							<img src="assets/img/ebook.png" alt="">
						</div>
						<div class="col-sm-5 form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Aggiungi un nuovo Prodotto</h3>
									<p>Riempi tutti i campi</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-pencil"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form role="form" action="" method="post"
									class="registration-form">
									<h:form>

										<div class="form-group">
											<label class="sr-only" for="form-first-name">First
												name</label><font color="white">Name</font>
											<h:inputText value="#{productController.name}"
												required="true" requiredMessage="Name is mandatory"
												id="name" styleClass="form-control" />
											<h:message for="name" />
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-last-name">Code</label><font
												color="white">Code</font>
											<h:inputText value="#{productController.code}"
												required="true" requiredMessage="code is mandatory"
												id="code" styleClass="form-control" />
											<h:message for="code" />
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-email">Price</label><font
												color="white">Price</font>
											<h:inputText value="#{productController.price}"
												required="true" requiredMessage="Price is mandatory"
												id="price" styleClass="form-control" />
											<h:message for="price" />
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-password">Description</label> <font
												color="white">Description</font>
											<h:inputText value="#{productController.description}"
												required="true" requiredMessage="description is mandatory"
												id="description" styleClass="form-control" />
											<h:message for="description" />
										</div>										
										<h:commandButton styleClass="btn" value="Submit"
											action="#{productController.createProduct}"></h:commandButton>
									</h:form>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>


		<!-- Javascript -->
		<script src="assets/js/jquery-1.11.1.min.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/js/jquery.backstretch.min.js"></script>
		<script src="assets/js/retina-1.1.0.min.js"></script>
		<script src="assets/js/scripts.js"></script>

		<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
	</f:view>
</body>

</html>

