<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="..\css\registration.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION PAGE</title>

</head>
<body>
	<div>
		<h2  class ="heading" align="center">REGISTRATION PAGE</h2>
		<hr>
	</div>
	<div>
		<form action="register.do" method="post">
			<table align="center" class="table">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>
				<tr>
					<th>BUYER/SELLER/ADMIN:</th>
					<td><select name="roleid" required>
							<option>Select your type</option>
							<option value="101">BUYER</option>
							<option value="102">SELLER</option>
							<option value="103">ADMIN</option>
					</select></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>EMAIL ID</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>CONTACT NUMBER</td>
					<td><input type="number" name="contactnum" required min="1000000000" max="10000000000"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<p>
			<a href="..\pages\index.jsp"><button type="button"
					class="btn btn-primary btn-lg">Click here To Home Page</button></a>
		</p>
	</div>


</body>
</html>