package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AtualizarCompromissoServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u = (Usuario) request.getSession().getAttribute("usuario");
		
		
		Compromisso compromisso = new Compromisso();
		compromisso.setUsuario(u);
		compromisso.setCodCompromisso(Integer.parseInt(request.getParameter("txt-codCompromisso")));
		compromisso.setTitulo(request.getParameter("txt-titulo"));
		compromisso.setData(request.getParameter("txt-data"));
		compromisso.setHoraInicio(request.getParameter("txt-horaInicio"));
		compromisso.setHoraFim(request.getParameter("txt-horaFim"));
		compromisso.setDescricao(request.getParameter("txt-descricao").trim());
		compromisso.setPrioridade(Integer.parseInt(request.getParameter("txt-prioridades")));
		compromisso.setStatus(Integer.parseInt(request.getParameter("txt-status")));
		
		CompromissoDao dao = new CompromissoDao();
		dao.setCompromisso(compromisso);
		
		if(dao.atualizar(compromisso)) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("compromisso", compromisso);
			response.sendRedirect("compromissos.jsp");
		}
		
		
		
		
	}

}
