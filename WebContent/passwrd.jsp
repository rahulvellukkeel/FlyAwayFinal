<%@page import="com.flyaway.admin.AdminInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
<style type="text/css">
	body {
	background-image: url("Admin.jpg");background-repeat: no-repeat;background-size: cover;
}
</style>
</head>
<body>
<%String npass=request.getParameter("npass");
String npass1=request.getParameter("npass1");
String cpass=request.getParameter("cpass");
AdminInfo a=new AdminInfo();
RequestDispatcher rd=null;
try{
a=(AdminInfo)session.getAttribute("Admin");
String pass=a.getPassword();
if(cpass.equals(pass) && npass.equals(npass1)){
	a.setNewpassword(npass);
	session.setAttribute("Admin", a);
	rd=request.getRequestDispatcher("passwrd");
	rd.forward(request, response);
	}
else{
	out.println("<h3 align="+"center>"+"Password Mismatch!!!<h3>");%>
	<jsp:include page = "passchange.html" flush = "true" />
<%}
}catch(NullPointerException e){%>
	<jsp:include page = "welcome.html" flush = "true" />
<%}
%>
</body>
</html>