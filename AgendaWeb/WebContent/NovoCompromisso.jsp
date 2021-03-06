<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="br.senai.sp.cfp127.util.FormataData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario est� sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");
	
	Compromisso compromisso = new Compromisso();	
	compromisso = (Compromisso) session.getAttribute("compromisso");
	
%>
			<!DOCTYPE html>
			<html lang="pt-br">
				<head>
					<title>Novo contato</title>
					<link rel="stylesheet"	type="text/css" href="./css/bootstrap.css">
					<link rel="shortcut icon" href="./imagens/iconeLogo.png" type="image/x-icon" />
					<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" >
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
								<!-- painel fica aqui o painel -->
								<%@ include file = "PainelUsuario.jsp" %>
								
								<!-- Aqui fica o menu -->
								<%@ include file = "menu.html" %>
							</div>
							<div  class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<h5><img src="./imagens/editar64.png">Novo compromisso</h5>
									</div>
									
									<div class="card-body">
									
									
										<div class="card" >
											<div class="card-header">
													<h5> Cadastrar um novo compromisso</h5>
											</div>
											<form id="compromisso" action="CadastrarCompromissoServlet" method="post">
												<div class="card-body">
													<div class="alert-warning">
														<ul id="mensagens-errosCompromisso" class="mt-2 mb-3">
															
														</ul>	
													</div>
													<div class="row">
														<div class="col-md-12 text-primary">
															<h6 class="text-primary mb-4">Dados do compromisso</h6>
														</div>
													</div>
													
													<div class="row form-group">														
														<div class="col-md-12">
															<input type="text" name="txt-codCompromisso" id="txt-codCompromisso" hidden="hidden">
															<label for="txt-titulo">Titulo do compromisso:</label>
															<input class="form-control" type="text" name="txt-titulo" id="txt-titulo" >
														</div>														
													</div>
													<div class="row form-group">
														<div class="col-md-4">
															<label for="txt-Data">Data:</label>
															<input class="form-control" type="date" name="txt-data" id="txt-data">
														</div>
														<div class="col-md-4">
															<label for="txt-horaInicio">Hr. Inicio:</label>
															<input class="form-control" type="time" name="txt-horaInicio" id="txt-horaInicio" >														
														</div>
														<div class="col-md-4">
															<label for="txt-horaFim">Hr. Fim:</label>
															<input class="form-control" type="time" name="txt-horaFim" id="txt-horaFim" >														
														</div>
																												
													</div>
													<div class="row form-group">
														<div class="col-md-6">
															<label>
																Status:
															</label>
															<select class="form-control" name="txt-status" id="txt-status">
																<option value="0">
																	Em Andamento
																</option>
																<option value="1">
																	Cancelado
																</option>
																<option value="2">
																	Concluido
																</option>
															</select>
														</div>
														<div class="col-md-6">
															<label>
																Prioridades:
															</label>
															<select class="form-control" name="txt-prioridades" id="txt-prioridades">
																<option value="0">
																	Alto
																</option>
																<option value="1">
																	M�dio
																</option>
																<option value="2">
																	Baixo
																</option>
															</select>
														</div>
													</div>												
													<div class="row form-group">

														<div class="col-md-12">
															<label for="txt-descricao">Descri��o:</label>
															<textarea class="form-control" name="txt-descricao" id="txt-descricao"></textarea>														
														</div>
													</div>
												</div>
												<div class="card-footer">
													<button class="btn btn-success" id="bt-CriarCompromisso">Gravar Compromisso</button>
													<a href="compromissos.jsp" class="btn btn-info">Cancelar</a>
												</div>
											
											</form>
										
										</div>

									</div>
									
								</div>
							</div>
						</div>	
					</div>
					<script type="text/javascript" src="./js/errosCompromisso.js"></script>
					<script type="text/javascript" src="./js/validaCompromisso.js"></script>
				</body>
			</html>		

