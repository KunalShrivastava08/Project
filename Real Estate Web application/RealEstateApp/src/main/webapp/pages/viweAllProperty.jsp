<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.keane.training.domain.PropertyDetails"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<%
			String email = request.getParameter("email");
			session.setAttribute("email", email);
			%>
	<div>
		<h3  class ="heading" align="center">PROPERTES AVAILABLE</h3>
	</div>
	<hr>
	<div>
		<%
		ArrayList ap = (ArrayList) request.getAttribute("property");
		%>
		<p align="center">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>PROPERTY ID</th>
					<th>LOCATION</th>
					<th>TYPE</th>
					<th>PRICE</th>
					<th>AVAILABLE</th>
					<th>SELLER EMAIL</th>
					<th>PROPERTY VALID</th>
				</tr>
			</thead>

			
			<%for (int i = 0; i < ap.size(); i++) {%>
			
			<tr>
				<%
				PropertyDetails pd = (PropertyDetails) ap.get(i);
				%>
				<td><%=pd.getPropertyid()%></td>
				<td><%=pd.getLocation()%></td>
				<td><%=pd.getType()%></td>
				<td><%=pd.getPrice()%></td>
				<td><%=pd.getAvailable()%></td>
				<td><%=pd.getEmail()%></td>
				<td><%=pd.getValidity()%></td>
			</tr>
			<%}%>

		</table>
		<p>
	</div>
	<div>
		<a href="..\pages\admin.jsp"><button type="button"
				class="btn btn-primary btn-lg">Click here To Admin Page
			</button></a>
	</div>


</body>
</html>