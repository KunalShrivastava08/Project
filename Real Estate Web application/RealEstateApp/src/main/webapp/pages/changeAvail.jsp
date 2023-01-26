<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Avail Property</title>
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
		<h2   class ="heading" align="center">SELLER PROPERTY AVAILABILITY PAGE</h2>
	</div>
	<hr>

	<div>
		<h4 align="center">Enter Property details which you want to
			change</h4>
		<form action="sellchange.do">
			<table align="center">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>
				<tr>
					<td>PROPERTY ID</td>
					<td><input type="text" name="propertyid" required></td>
				</tr>
				<tr>
					<th>PROPERTY AVAILABLE:</th>
					<td><select name="available" required>
							<option>Select your type</option>
							<option value="YES">YES</option>
							<option value="NO">NO</option>
					</select></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Post"></td>
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