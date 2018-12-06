package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;

@WebServlet("/MudarStatusServlet")
public class MudarStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MudarStatusServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codCompromisso = Integer.parseInt(request.getParameter("cod_compromisso"));
		int status = Integer.parseInt(request.getParameter("status"));
		System.out.println(codCompromisso);
		System.out.println(status);
		
		CompromissoDao dao = new CompromissoDao();
		if(dao.atualizarStatus(status, codCompromisso)) {
			response.sendRedirect("compromissos.jsp");
		}else {
			System.out.println("deu não, arruma ai");
		}
	
	}

}
