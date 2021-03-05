<%@page import="com.flyaway.admin.AdminInfo"%>
<%@page import="com.flyaway.admin.Flightinfo"%>
<%@page import="java.util.ArrayList"%>
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
	background-image: url("Admin.jpg");background-repeat: no-repeat ;background-size: cover;
}
</style>
</head>
<body>
<%		Connect c =new Connect();
		List<Flightinfo> flist=c.flight();
		AdminInfo a=new AdminInfo();
		try{
			a=(AdminInfo)session.getAttribute("Admin");
			String uname=a.getUsername();	
		%>
<div align="center">
<table border="1" >
<tr>
<th>Flight_Name</th>
</tr>
<%
		for(Flightinfo fl:flist){%>
			<tr><td><%=fl.getFid() %></td></tr>
		<%}
}catch(NullPointerException e){
%>
<jsp:include page = "welcome.html" flush = "true" />
<%}%>
</table>
</div>
</body>
</html>