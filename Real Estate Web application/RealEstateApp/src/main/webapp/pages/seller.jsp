<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Page</title>
<link rel="stylesheet" type="text/css" href="..\css\seller.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String user = (String) request.getParameter("email");
	session.setAttribute("email", user);
	%>
	<div>
		<h1 class="heading" align="center">WELCOME TO SELLER PAGE</h1>
		<hr>
	</div>

	<br>
	<br>
	<div class="buttons">
		<div>
			<p align="center">
				<a href="..\pages\sellProperty.jsp"><button type="button"
						class="btn btn-primary btn-lg">Sell your Property</button></a>
			</p>
		</div>
		<br>
		<div>
			<p align="center">
			<a href="..\pages\changeAvail.jsp"><button type="button"
					class="btn btn-primary btn-lg">Change your Availability</button></a>
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