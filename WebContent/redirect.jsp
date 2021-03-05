<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.user.flyaway.PersonalInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
<%int n=Integer.parseInt(request.getParameter("ntick")); 
List<PersonalInfo> pl=new ArrayList<PersonalInfo>();
PersonalInfo p=new PersonalInfo();
p.setNticket(n);
session.setAttribute("ticket",p);
session.setAttribute("loop", p.getNticket());
session.setAttribute("details", pl);
response.sendRedirect("BookingDetails.html");%>
</body>
</html>