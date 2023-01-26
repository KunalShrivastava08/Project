<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Change Avail Details</title>
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
	<div>
		<p align="center">
			<font color="#922B21" size="20">${requestScope.success }</font>
		</p>
	</div>

	<hr>
	<div>
		<h3 align="center">Your Update property details :</h3>

	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<table class="table table-bordered">

				<tr>
					<td>Property Id : ${requestScope.propertyid}</td>
				</tr>
				<tr>
					<td>Available : ${requestScope.available}</td>
				</tr>

			</table>
		</div>
		<div class="col-md-4"></div>
	</div>
 <div>
		<p>
			<a href="seller.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Seller Page</button></a>
		</p>
	</div>
</body>
</html>