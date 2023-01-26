<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Propert Page</title>
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
		<h2  class ="heading" align="center">SELL PROPERTY PAGE</h2>
		<hr>

	</div>
	<div>
		<form action="sell.do">
			<table align="center">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>

				<tr>
					<td>LOCATION</td>
					<td><input type="text" name="location" required></td>
				</tr>
				<tr>
					<th>SELECT PROPERTY TYPE:</th>
					<td><select name="type" required>
							<option>Select your type</option>
							<option value="1BHK">1 BHK</option>
							<option value="2BHK">2 BHK</option>
							<option value="3BHK">3 BHK</option>
					</select></td>
				</tr>
				<tr>
					<td>PRICE</td>
					<td><input type="number" name="price" required></td>
				</tr>
				<tr>
					<td><input type="hidden" name="email"
						value="<%=session.getAttribute("email")%>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="SUBMIT"></td>
					<td><input type="reset" value="CLEAR"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<p>
			<a href="..\pages\seller.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Seller Page</button></a>
		</p>
	</div>
</body>
</html>