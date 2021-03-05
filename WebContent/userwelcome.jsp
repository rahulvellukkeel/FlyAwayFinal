<%@page import="com.flyaway.admin.Flightinfo"%>
<%@page import="java.util.List"%>
<%@page import="com.user.flyaway.Connect"%>
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
<%  
	Connect c=new Connect();
	List<Flightinfo> flist=(List)c.distinct();
%>
<div align="center">
<form action="UserBooking" method="post" >
Source <select name="source" >
<%for(Flightinfo fl:flist){%>
<option value="<%=fl.getSource()%>"><%=fl.getSource()%> </option>
<%} %>
</select>
Destination  <select name="dest" >
<%for(Flightinfo fl:flist){%>
<option value="<%=fl.getDestination()%>"><%=fl.getDestination()%></option>
<%}%>
</select>
<input type="date" name="date" placeholder="YYYY-MM-DD"/>
<input type="submit" name="submit" value="Book"/>
</form>
</div>
</body>
</html>