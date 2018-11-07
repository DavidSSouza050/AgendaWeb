package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.Usuariodao;
import br.senai.sp.cfp127.model.Usuario;


@WebServlet("/AutenticaServilet")
public class AutenticaServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AutenticaServilet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuariodao dao = new Usuariodao();
		Usuario usuario = new Usuario();
				
		usuario = dao.autenticar(request.getParameter("email"),request.getParameter("senha"));
		
		HttpSession sessao = request.getSession();
		//Atribuindo a sessão para o objeto usuario
		sessao.setAttribute("usuario", usuario);
		
		if(usuario.getCod() != 0) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("Login.html");
		}
	}

}