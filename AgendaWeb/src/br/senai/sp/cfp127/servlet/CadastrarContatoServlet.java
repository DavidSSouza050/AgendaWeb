package br.senai.sp.cfp127.servlet;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;


@WebServlet("/CadastrarContatoServlet")
public class CadastrarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CadastrarContatoServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		
		u = (Usuario) request.getSession().getAttribute("u");
		
		
		Contato contato = new Contato(); 
		contato.setNome(request.getParameter("txt-nome"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setEndereco(request.getParameter("txt-endereco"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		contato.setUsuario(u);
		
		ContatoDao dao = new ContatoDao();
		dao.gravar(contato);
		
		if(dao.gravar(contato)) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("NovoContato.jsp");
		}
		
	}

}
