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
		u.setSexo(request.getParameter("txt-sexo").substring(0,1));
	
		if(request.getParameter("txt-cod").length() > 0) {
			u.setCod(Integer.parseInt(request.getParameter("txt-cod")));
		}
		
		Usuariodao dao = new Usuariodao();
		dao.setUsuario(u);
		
		if(u.getCod() == 0) {
			if(dao.gravar()){
				response.sendRedirect("sucesso.html");
			}else {
				response.sendRedirect("novo-usuario.html");
			}
		}else if(dao.Atualizar()){
			HttpSession sessao = request.getSession();
			sessao .setAttribute("usuario", u);
			response.sendRedirect("index.jsp");
		}
		
	}

}