package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarioServlet")
public class usuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public usuarioServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("txt-nome"));
		System.out.println(request.getParameter("txt-email"));
		System.out.println(request.getParameter("txt-nascimento"));
		System.out.println(request.getParameter("txt-sexo"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("conf-senha"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		String nome = request.getParameter("txt-nome");
	}

}