<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String email= request.getParameter("txt-email");
	String senha = request.getParameter("senha");
	String nome = request.getParameter("txt-nome");
	
%>
       
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= email   %><br><br>
	<%= nome %><br><br>
	 <h1>Eu sou um html! È verdade esse bilete</h1>
</body>
</html>