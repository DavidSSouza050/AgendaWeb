<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario est� sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");
	
	if(usuario == null){
		response.sendRedirect("Login.html");
	}else{
		%>
			<!DOCTYPE html>
			<html>
				<head>
					<title>Criar novo usuario</title>
					<link rel="stylesheet"	type="text/css" href="./css/bootstrap.css">
					<meta charset="UTF-8">
				</head>
				<body class="bg-dark">
					<div class="bg-info text-white">
						<div class="container">
							<div class="row">
								<div class="col-md-1">
									<img src="./imagens/agenda64.png">
								</div>
								<div class="col-md-11">
									<h1>Agenda Eletr�rnica</h1>
									<h6>Contatos e Compromissos</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="container mt-5 fluid">
						<div class="row">
							<div  class="col-md-4">
								
								<%@ include file = "PainelUsuario.jsp" %>
								
								<%@ include file = "menu.html" %>
								
							</div>
							<div  class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<h5>Bem-vindo</h5>
									</div>
									
									<div class="card-body">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row">1</th>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<th scope="row">2</th>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<th scope="row">3</th>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
									
									<div class="card-footer">
											
									</div>
								</div>
							</div>
						</div>	
					</div>
				</body>
			</html>		
		<%
	}
	
%>
