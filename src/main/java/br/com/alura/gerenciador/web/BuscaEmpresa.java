package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.model.Empresa;

//@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa implements Tarefa {

	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);

		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

	// private static final long serialVersionUID = -5640846148829616329L;

	//
	// @Override
	// public void init() throws ServletException {
	// super.init();
	// System.out.println("Inicializando a Servlet " + this);
	// }
	//
	// @Override
	// public void destroy() {
	// super.destroy();
	// System.out.println("Destruindo a Servlet" + this);
	// }
	//

	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	// ServletException, IOException {
	//
	// PrintWriter writer = resp.getWriter();
	//
	// writer.println("<html>");
	// writer.println("<head> <meta charset=\"ISO-8859-1\"> </head>");
	// writer.println("<body>");
	// writer.println("Resultado da busca: <br>");
	//
	// String filtro = req.getParameter("filtro");
	//
	// Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
	//
	// writer.println("<ul>");
	// for (Empresa empresa : empresas) {
	// writer.println("<li>" + empresa.getId() + " - " + empresa.getNome());
	// }
	//
	// writer.println("</ul>");
	// writer.println("</body>");
	// writer.println("</html>");
	//
	// }

	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	// ServletException, IOException {
	//
	// String filtro = req.getParameter("filtro");
	//
	// Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
	//
	// req.setAttribute("empresas", empresas);
	//
	// RequestDispatcher dispatcher =
	// req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
	// dispatcher.forward(req, resp);
	//
	// }

}
