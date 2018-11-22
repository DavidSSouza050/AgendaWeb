<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario está sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");
	
	Contato contato = new Contato();	
	contato = (Contato) session.getAttribute("contato");
	session.removeAttribute("contato");
%>
			<!DOCTYPE html>
			<html>
				<head>
					<title>Novo contato</title>
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
									<h1>Agenda Eletrôrnica</h1>
									<h6>Contatos e Compromissos</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="container mt-5 fluid">
						<div class="row">
							<div  class="col-md-4">
								<!-- painel fica aqui o painel -->
								<%@ include file = "PainelUsuario.jsp" %>
								
								<!-- Aqui fica o menu -->
								<%@ include file = "menu.html" %>
							</div>
							<div  class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<h5><img src="./imagens/editar64.png">Novo usuario</h5>
									</div>
									
									<div class="card-body">
									
									
										<div class="card" >
											<div class="card-header">
													<h5> Cadastrar um novo usuario</h5>
											</div>
											<form id="contato" action="CadastrarContatoServlet" method="post">
												<div class="card-body">
													<div class="alert-warning">
														<ul id="mensagens-erro" class="mt-2 mb-3">
															
														</ul>	
													</div>
													<div class="row">
														<div class="col-md-12 text-primary">
															<h6 class="text-primary mb-4">Dados do contato</h6>
														</div>
													</div>
													
													<div class="row form-group">
														
														<div class="col-md-4">
															<input type="text" name="txt-codContato" id="txt-codContato" value="<%= contato.getCodContato()%>" hidden="hidden" >
															<label for="txt-nome">Nome:</label>
															<input class="form-control" type="text" name="txt-nome" value="<%= contato.getNome() %>" id="txt-nome" >
														</div>
														<div class="col-md-4">
															<label for="txt-Telefone">Telefone:</label>
															<input class="form-control" type="text" name="txt-telefone" value="<%= contato.getTelefone() %>" id="txt-telefone">
														</div>
														<div class="col-md-4">
															<label for="txt-email">E-mail:</label>
															<input class="form-control" type="text" name="txt-email" value="<%= contato.getEmail() %>"  id="txt-email" >														
														</div>
													</div>												
													<div class="row form-group">

														<div class="col-md-12">
															<label for="txt-endereco">Endereço:</label>
															<input class="form-control" type="text" name="txt-endereco" value="<%= contato.getEndereco()%>" id="txt-endereco" >														
														</div>
													</div>
												</div>
												<div class="card-footer">
													<button class="btn btn-success" id="bt-Criar">Atualizar</button>
													<a href="contatos.jsp" class="btn btn-info">Cancelar</a>
												</div>
											
											</form>
										
										</div>

									</div>
									
								</div>
							</div>
						</div>	
					</div>
				</body>
			</html>		

