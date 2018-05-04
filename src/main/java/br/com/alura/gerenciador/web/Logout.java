package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		session.removeAttribute("usuario");

		return "/WEB-INF/paginas/logout.html";
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		HttpSession session = req.getSession();
//		session.removeAttribute("usuarioLogado");
//		
//		//resp.sendRedirect("logout.html");
//		
//		//RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/paginas/logout.html"); //Pega o Dispacher
//		//disp.forward(req, resp);
//		
//		
//		
//	}
	
	
	
}
