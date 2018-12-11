<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.util.FormataData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario está sendo covertido para um objeto);
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
								<!-- painel fica aqui o painel -->
								<%@ include file = "PainelUsuario.jsp" %>
								
								
								<!-- Aqui fica o menu -->
								<%@ include file = "menu.html" %>
							</div>
							<div  class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<h5><img src="./imagens/editar64.png">Editar Usuario</h5>
									</div>
									
									<div class="card-body">
									
									
										<div class="card" >
											<div class="card-header">
												
											</div>
											<form id="usuario" action="usuarioServlet" method="post">
												<div class="card-body">
													<div class="alert-warning">
														<ul id="mensagens-erro" class="mt-2 mb-3">
															
														</ul>	
													</div>
													<div class="row">
														<div class="col-md-12 text-primary">
															<h6 class="text-primary mb-4">Dados pessoais</h6>
														</div>
													</div>
													
													<div class="row form-group">
														
														<div class="col-md-5">
															<input type="text" name="txt-cod" value="<%= usuario.getCod()%>" hidden="hidden">
															<label for="txt-nome">Nome:</label>
															<input class="form-control" type="text" name="txt-nome" id="txt-nome" value="<%= usuario.getNome()%>">
														</div>
														<div class="col-md-4">
															<label for="txt-nascimento">Dt.Nascimento:</label>
															<input class="form-control" type="date" name="txt-nascimento" id="txt-nascimento" value="<%= usuario.getDtNascimento()%>">
														</div>
														<div class="col-md-3">
															<label for="txt-sexo">Sexo:</label>
															<select class="form-control" name="txt-sexo" id="txt-sexo">
																<option <%= usuario.getSexo().equals("F")?"Selecione":"" %>>Masculino</option>
																<option <%= usuario.getSexo().equals("M")?"Selecione":"" %>>Feminino</option>
															</select>
														</div>
													</div>
													<div class="row">
														<div class="col-md-12 text-primary">
															<h6 class="text-primary mb-4">Dados de acesso</h6>
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-6">
															<label for="txt-email">E-mail</label>
															<input class="form-control" type="text" name="txt-email" id="txt-email" value="<%= usuario.getEmail()%>">
														</div>
														<div class="col-md-3">
															<label for="senha">Senha:</label>
															<input class="form-control" type="password" name="senha" id="senha">
														</div>
														<div class="col-md-3">
															<label for="conf-senha">Confirmar senha:</label>
															<input class="form-control" type="password" name="conf-senha" id="conf-senha">
														</div>
													</div>
												</div>
												<div class="card-footer">
													<button class="btn btn-success" id="bt-Criar">Editar</button>
													<a href="index.jsp" class="btn btn-info">Cancelar</a>
												</div>
											
											</form>
										
										</div>

									</div>
									
								</div>
							</div>
						</div>	
					</div>
					<script type="text/javascript" src="./js/valida.js"></script>
					<script type="text/javascript" src="./js/erros.js"></script>
				</body>
			</html>		
		<%
	}
	
%>
