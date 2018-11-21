package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.model.Usuario;

@WebServlet(urlPatterns = "/login")
public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario); // Adiciona usuário logado a sessão
		}
			
		return "/WEB-INF/paginas/login.jsp";
	}
}
