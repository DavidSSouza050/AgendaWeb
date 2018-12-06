<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.dao.ContatoDao"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Usuario usuario = new Usuario();	
	//casting = quando convertamos um atributo para o objeto(usuario está sendo covertido para um objeto);
	usuario = (Usuario) session.getAttribute("usuario");

	CompromissoDao dao = new CompromissoDao();
	ArrayList<Compromisso> compromissos = new ArrayList<>();
	
	compromissos = dao.getCompromisso(usuario.getCod());
	
	if(usuario == null){
		response.sendRedirect("Login.html");
	}else{
		%>
			<!DOCTYPE html>
			<html>
				<head>
					<title>Meus contatos</title>
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
								
								<%@ include file = "PainelUsuario.jsp" %>
								
								<%@ include file = "menu.html" %>
								
							</div>
							<div  class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<div class="row">
											<div class="col-md-9">
												<h5>Meus Contatos</h5>
											</div>
											<div class="col-md-3">
												<a href="NovoCompromisso.jsp" class="badge badge-success">Novo compromisso</a>
											</div>
										</div>
									</div>
									
									<div class="card-body">
										<label>
											Status
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
										</select><br>
										<table class="table table-hover">
											<thead class="thead-dark">
												<tr>
													<th scope="col">Cod.</th>
													<th scope="col">Titulo</th>
													<th scope="col">Data</th>
													<th scope="col">Prioridade<th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												
												
												<% for(Compromisso c : compromissos){ %>
												
												<tr>
													<td><b><%= String.format("%04d", c.getCodCompromisso())%></b></td>
													<td><a href="ExibirCompromissoServlet?cod_compromisso=<%= c.getCodCompromisso()%>"><%= c.getTitulo() %></a></td>
													<td><%= c.getData() %></td>
													<td>
														<%if(c.getPrioridade() == 0){ %>
															Em Andamento															
														<%}else if(c.getPrioridade() == 1){ %>
															Cancelado
														<%}else if(c.getPrioridade() == 2){ %>
															Concluido
														<%}%>
													<td>
													<td>
														<a href="ExcluirComrpomissoServlet?cod_compromisso=<%=c.getCodCompromisso()%>">
															<img src="./imagens/cancela24.png">
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
