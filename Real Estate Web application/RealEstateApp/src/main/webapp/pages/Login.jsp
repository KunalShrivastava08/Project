<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="..\css\registration.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN PAGE</title>

</head>
<body>
	<div>
		<h2  class ="heading" align="center">LOGIN PAGE</h2>
		<hr>
	</div>
	<div>
		<form action="login.do" method="post">
			<table align="center" class="table">
				<tr>
					<td colspan="2"><c:if test="${requestScope.Err!=null}">
							<font color="red">${requestScope.Err}</font>
						</c:if></td>
				</tr>
				<tr>
					<td>USER ID</td>
					<td><input type="email" name="email" placeholder="Mail-Id" required></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login"></td>
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