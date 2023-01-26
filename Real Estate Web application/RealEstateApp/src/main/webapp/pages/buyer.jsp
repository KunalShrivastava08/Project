<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="..\css\buyer.css">
<meta charset="ISO-8859-1">
<title>Buyer Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body >
	<%
	String user = (String) request.getParameter("email");
	session.setAttribute("email", user);
	%>
	<div>
		<h1   class ="heading" align="center">WELCOME TO BUYER PAGE</h1>
	</div>
	<hr>
	<div class="buttons">	
			<div>
				<p align="center">
						<a href="..\pages\SelectAndViweSite.jsp"><button type="button"
								class="btn btn-primary btn-lg">SELECT AND VIWE SITES</button></a>
					</p>
			</div>
			<div>
			<p align="center">
						<a href="..\pages\bookproperty.jsp"><button type="button"
								class="btn btn-primary btn-lg">Book Property for Site
								visit? Click here</button></a>
					</p>
			</div>
			<div>
			<p align="center">
						<a href="..\pages\payment.jsp"><button type="button"
								class="btn btn-primary btn-lg">Make Payment? Click here</button></a>
					</p>
			</div>
	</div>

	
		<div>
		<p>
			<a href="..\pages\Login.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Login Page</button></a>
		</p>
	</div>
</body>
</html>