<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.getSession(false);
if(session == null){ %>
	<a href="http://localhost:8080/loginDemo/home.jsp"> Home</a>
	<a href="http://localhost:8080/loginDemo/login.jsp"> Login</a>
	<%
}else{
	%>
	<a href="http://localhost:8080/LoginDemo/logout.jsp"> Logout</a><%
}

String name = request.getParameter("name");
%>
<br><br>

<%

out.println("Welcome : "+name);
%>
</body>
</html>