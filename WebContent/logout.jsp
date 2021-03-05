<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
<%session.invalidate();
out.println("<br><h2 align="+"center>"+"Logout Successfull</h2>");%>
<jsp:include page = "welcome.html" flush = "true" />
</body>
</html>