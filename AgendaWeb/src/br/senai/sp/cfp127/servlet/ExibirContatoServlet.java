package br.senai.sp.cfp127.servlet;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;

@WebServlet("/ExibirContatoServlet")
public class ExibirContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExibirContatoServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codContato = (Integer.parseInt(request.getParameter("cod_contato")));
		System.out.println(codContato);
		Contato contato = new Contato();
		
		ContatoDao dao = new ContatoDao();
		contato = dao.getContato(codContato);
	
		
		request.getSession().setAttribute("contato", contato);
		response.sendRedirect("ExibirContato.jsp");
	}

}
