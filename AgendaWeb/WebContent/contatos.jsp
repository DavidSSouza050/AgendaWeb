<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.util.FormataData"%>
<%@page import="br.senai.sp.cfp127.dao.ContatoDao"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario está sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");

	ContatoDao dao = new ContatoDao();
	ArrayList<Contato> contatos = new ArrayList<>();
	
	contatos = dao.getContatos(usuario.getCod());
	
	if(usuario == null){
		response.sendRedirect("Login.html");
	}else{
		%>
			<!DOCTYPE html>
			<html>
				<head>
					<title>Meus contatos</title>
					<link rel="stylesheet"	type="text/css" href="./css/bootstrap.css">
					<link rel="shortcut icon" href="./imagens/iconeLogo.png" type="image/x-icon" />
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
									<h1>Agenda Eletrôrnica</h1>
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
										<div class="row">
											<div class="col-md-10">
												<h5>Meus Contatos</h5>
											</div>
											<div class="col-md-2">
												<a href="NovoContato.jsp" class="badge badge-success">Novo contato</a>
											</div>
										</div>
									</div>
									
									<div class="card-body">
										<table class="table table-hover">
											<thead class="thead-dark">
												<tr>
													<th scope="col">Cod.</th>
													<th scope="col">Nome</th>
													<th scope="col">Email</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												
												
												<% for(Contato c : contatos){ %>
												
												<tr>
													<td><b><%= String.format("%04d",c.getCodContato()) %></b></td>
													<td><a href="ExibirContatoServlet?cod_contato=<%= c.getCodContato()%>"><%= c.getNome() %></a></td>
													<td><%= c.getEmail() %></td>
													<td>
														<a href="PegarContato?cod_contato=<%=c.getCodContato()%>">
															<img src="./imagens/deleteX32.png">
														</a>
													</td>
												</tr>
													
												<% } %>
												
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
