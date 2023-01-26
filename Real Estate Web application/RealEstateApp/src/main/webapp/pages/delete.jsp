<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Delete Page</title>
<link rel="stylesheet" type="text/css" href="..\css\admin.css">
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
		<h2   class ="heading" align="center">DELETE PROPERTY PAGE</h2>

	</div>
	<hr>
	<div>
		<form action="delete.do" method="post">
			<table align="center">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>
				<tr>
					<th>TABLE NAME</th>
					<td><br> <input type="radio" name="tablename" value="BPD" required>Book
						Property Details<br> <input type="radio" name="tablename"
						value="PD">Property Details<br>
				</tr>
				<tr>
					<td>PROPERTY ID</td>
					<td><input type="number" name="propertyid" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<p>
			<a href="..\pages\admin.jsp"><button type="button"
					class="btn btn-primary btn-sm">Click here To Admin Page</button></a>
		</p>
	</div>
</body>
</html>