package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;

@WebServlet("/ExibirCompromissoServlet")
public class ExibirCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExibirCompromissoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codCompromisso = (Integer.parseInt(request.getParameter("cod_compromisso")));
		System.out.println(codCompromisso);
		Compromisso compromisso = new Compromisso();
		
		CompromissoDao dao = new CompromissoDao();
		compromisso = dao.exibir(codCompromisso);
	
		
		request.getSession().setAttribute("compromisso", compromisso);
		response.sendRedirect("ExibirCompromisso.jsp");
		
		
	}

}
