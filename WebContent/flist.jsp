<%@page import="java.util.ArrayList"%>
<%@page import="com.flyaway.admin.Flightinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
<style type="text/css">
	body {
	background-image: url("user.jpg");background-repeat: no-repeat ;background-size: cover;
}
</style>
</head>
<body>
<div align="center">
<form action="" method="post">
<table border="1">
<tr>
<th>Flight</th>
<th>Price</th>
</tr>
<%
List<Flightinfo>flist=new ArrayList<Flightinfo>();
flist=(List)session.getAttribute("pay"); 
for(Flightinfo fl:flist){
%>
<tr>
<td><%=fl.getFid() %></td>
<td><%=fl.getPrize() %></td>
<td><a href="pay.jsp?id=<%=fl.getFid() %>">Book Now</a></td>
</tr>
<%} %>
</table>
</form>
</div>
</body>
</html>