<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="br.senai.sp.cfp127.util.FormataData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario está sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");
	
	Contato contato = new Contato();	
	contato = (Contato) session.getAttribute("contato");

%>
			<!DOCTYPE html>
			<html>
				<head>
					<title>Novo contato</title>
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
									<div class="card-header bg-danger text-white">
										<h2><img src="./imagens/excluirContato64.png">Excluir</h2>
									</div>
									
									<div class="card-body">
									
									
										<div class="card" >
											<div class="card-header">
													<h5>Excluir contato</h5>
											</div>
											
												<div class="card-body">
													
													<div class="row form-group">
														<div class="card-body">
															<p><h4 class="text-danger">Você está certo disso ?!</h4></p><br>
															<p>Você realmete deseja excluir: <%= contato.getNome()%></p>
															<p><h6>Aproveite!</h6>
														</div>
														<div class="card-footer">
														</div>
														
													</div>
												</div>
												<div class="card-footer">										
													<a href="ExcluirContatoServlet?cod_contato=<%=contato.getCodContato()%>">
														<button class="btn btn-success" id="bt-Criar">Excluir</button>
													</a>
													<a href="contatos.jsp" class="btn btn-info">Cancelar</a>
												</div>
											
											
										
										</div>

									</div>
									
								</div>
							</div>
						</div>	
					</div>
				</body>
			</html>		

