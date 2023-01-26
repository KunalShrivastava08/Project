<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation page</title>
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
		<h4  class ="heading" align="center">Enter Property details which you want Validate</h4>
	</div>
	<hr>
	<div>

		<form action="valid.do">
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
					<th>PROPERTY VALID:</th>
					<td><select name="valid" required>
							<option>Select your type</option>
							<option value="VALID">YES</option>
							<option value="NOT VALID">NO</option>
					</select></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="SUBMIT"></td>
					<td><input type="reset" value="CLEAR"></td>
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