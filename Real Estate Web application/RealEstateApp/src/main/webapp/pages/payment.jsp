<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<link rel="stylesheet" type="text/css" href="..\css\buyer.css">
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
		<h2  class ="heading" align="center">PAYMENT PAGE</h2>
		<hr>
	</div>
	<div>
		<form action="payment.do">
			<table  align="center">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>
				<tr>
					<td>PROPERTY ID</td>
					<td><input type="number" name="propertyid" required></td>
				</tr>
		
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Pay"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<p>
			<a href="..\pages\buyer.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Buyer Page</button></a>
		</p>
	</div>
</body>
</html>