<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="..\css\admin.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >
	
	<h1 class ="heading" align="center">WELCOME TO ADMIN PAGE</h1>
	<hr>
	<div class="buttons">	
		<div>
			<p align="center">
				<a href="allproperty.do"><button type="button"
						class="btn btn-primary btn-lg">View All Property</button></a>
			</p>
			<br>
		</div>
		<div>
			<p align="center">
				<a href="..\pages\validate.jsp"><button type="button"
						class="btn btn-primary btn-lg">Validate Data</button></a>
			</p>
			<br>
		</div>
		<div>

		<p align="center">
			<a href="..\pages\delete.jsp"><button type="button"
					class="btn btn-primary btn-lg">Delete Property</button></a>
		</p>
		<br>
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