package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(usuario.getCod() != 0) {
			System.out.println("Logado com sucesso");
			response.sendRedirect("Resultado.jsp");
		}else {
			System.out.println("senha ou email incorreto");
			response.sendRedirect("Login.html");
		}
	}

}
