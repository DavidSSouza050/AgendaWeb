<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String email= request.getParameter("emailXXX");
	String senha = request.getParameter("senha");
	String nome = request.getParameter("XPTO");
	
	int respsta = Integer.parseInt(email) + Integer.parseInt(senha);
%>
       
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= email   %><br><br>
	<%= senha   %><br><br>
	<%= respsta %><br><br>
	<%= nome %><br><br>
	 <h1>Eu sou um html! � verdade esse bilhete</h1>
</body>
</html>