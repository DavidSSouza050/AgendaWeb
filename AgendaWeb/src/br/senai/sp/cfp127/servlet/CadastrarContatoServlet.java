package br.senai.sp.cfp127.servlet;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		u = (Usuario) request.getSession().getAttribute("usuario");
		
		
		Contato contato = new Contato();
		contato.setUsuario(u);
		contato.setNome(request.getParameter("txt-nome"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setEndereco(request.getParameter("txt-endereco"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		
		if(request.getParameter("txt-codContato").length() > 0) {
			contato.setCodContato(Integer.parseInt(request.getParameter("txt-codContato")));
		}
		
		ContatoDao dao = new ContatoDao();
		dao.setContato(contato);
		
		if(contato.getCodContato() == 0) {	
			if(dao.gravar(contato)) {
				response.sendRedirect("contatos.jsp");
			}else {
				response.sendRedirect("NovoContato.jsp");
			}
		}else if(dao.atualizar(contato)) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("contato", contato);
			response.sendRedirect("contatos.jsp");
		}
		
	}

}
