<%@page import="com.user.flyaway.PersonalInfo"%>
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
	background-image: url("user.jpg");background-repeat: no-repeat;background-size: cover;
}
</style>
</head>
<body>
<%Flightinfo fl=(Flightinfo)session.getAttribute("booked");
List<PersonalInfo> flist=(List)session.getAttribute("details");
%>
<div align="left" >
<form action="success.html" method="post" ><br><br>
Enter Debit card Number<input type="number"/><br><br>
Enter Account holder name<input type="text"/><br><br>
Enter CVV<input type="number"/>
<input type="submit" value="Submit"/>
</form>
</div><br><br>
<div align="center" >
<table  border="1" style="background-color: silver;">
<tr><th>Persinal Details</th></tr>
<%for(PersonalInfo pl:flist){ %>
<tr><td>Name</td><td><%=pl.getPname() %></td></tr>
<tr><td>Age</td><td><%=pl.getAge() %></td></tr>
<tr><td>Place</td><td><%=pl.getPlace() %></td></tr>
<%} %>
<tr><th>Flight Details</th></tr>
<tr><td>Flight Name</td><td><%=fl.getFid() %></td></tr>
<tr><td>Source</td><td><%=fl.getSource() %></td></tr>
<tr><td>Destinaion</td><td><%=fl.getDestination() %></td></tr>
<tr><td>Date</td><td><%=fl.getDate() %></td></tr>
<tr><td>Total Amound</td><td><%=fl.getPrize() %></td></tr>
</table>
</div>
<%session.invalidate(); %>
</body>
</html>