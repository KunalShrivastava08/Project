<%@page import="com.keane.training.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="..\css\registration.css">
<title>Display Resistration Details Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center">
		<font   color="#1F618D" size="20">${requestScope.success}</font>
	</div>
	<hr>
	<div class="row">
				<div class="col-md-4" ></div>
				<div class="col-md-4" ><h3 align="center">Welcome ${requestScope.details.name}</h3>
		<table align="center" class="table table-bordered" class="viwetable">

			<tr>
				<td>Your Login Details</td>
			</tr>
			<tr>
				<td>User Id : ${requestScope.details.email}</td>
			</tr>
			<tr>
				<td>Password : ${requestScope.details.password}</td>
			</tr>

		</table></div>
				<div class="col-md-4" ></div>
	</div>
 <div>
		<p>
			<a href="index.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Login Page</button></a>
		</p>
	</div>
</body>
</html>