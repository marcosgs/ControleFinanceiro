package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.model.Usuario;

public class Login extends HttpServlet{
	
	private static final long serialVersionUID = -3796313427747926879L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null) {
            writer.println("<html><body>Usuário ou senha inválida</body></html>");
        } else {
            Cookie cookie = new Cookie("usuario.logado", email);
            resp.addCookie(cookie);
            writer.println("<html><body>Usuário logado: " + email
                    + "</body></html>");
        }
	}
	
	private Cookie getUsuario(HttpServletRequest req) {

	    Cookie[] cookies = req.getCookies();

	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("usuario.logado")) {
	            return cookie;
	        }
	    }

	    return null;
	}
}
