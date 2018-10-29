package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.Usuariodao;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/usuarioServlet")
public class usuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public usuarioServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("txt-nome"));
		u.setEmail(request.getParameter("txt-email"));
		u.setDtNascimento(request.getParameter("txt-nascimento"));
		u.setSenha(request.getParameter("senha"));
		u.setSexo(request.getParameter("txt-sexo"));
	
		Usuariodao dao = new Usuariodao();
		dao.setUsuario(u);
		dao.gravar();
		
//		String nome = request.getParameter("txt-nome");
	}

}