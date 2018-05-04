package br.com.alura.gerenciador.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.model.Empresa;

//@WebServlet(urlPatterns ="/novaEmpresa")
public class NovaEmpresa implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("empresa", empresa);
		
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

	
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String nome = req.getParameter("nome");
//		
//		Empresa empresa = new Empresa(nome);
//		new EmpresaDAO().adiciona(empresa);
//		
//		req.setAttribute("empresa", empresa);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
//		dispatcher.forward(req, resp);
//		
//		//PrintWriter writer = resp.getWriter();
//		//writer.println("<html><body> Empresa " + empresa.getNome() + " adiciona!</body></html>");
//	}
}
