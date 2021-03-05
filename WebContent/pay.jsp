<%@page import="com.flyaway.admin.Flightinfo"%>
<%@page import="java.util.List"%>
<%@page import="com.user.flyaway.Connect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAwaye</title>
<style type="text/css">
	body {
	background-image: url("user.jpg");background-repeat: no-repeat ;background-size: cover;
}
</style>
</head>
<body>
<div align="center">
<form action="redirect.jsp" method="post">
<%String fid=request.getParameter("id");
Connect c=new Connect();
Flightinfo fl=new Flightinfo();
fl.setFid(fid);
List<Flightinfo> flist=c.flightByid(fl);
session.setAttribute("checkout",flist);
%>

<table border="1">
<tr><th>Details</th></tr>
<%
for(Flightinfo fll:flist){%>
	<tr><th><%=fll.getFid() %></th></tr>
	<tr><th><%=fll.getSource() %></th></tr>
	<tr><th><%=fll.getDestination() %></th></tr>
	<tr><th><%=fll.getDate() %></th></tr>
	<tr><th><%=fll.getPrize() %></th></tr>
<%}
%>
<tr><th><input type="number" placeholder="Number of Tickets" name="ntick"/>
<tr><th><a href="redirect.jsp"><input type="submit" value="Conform"/></a></th></tr>
</table>
</form>
</div>
</body>
</html>