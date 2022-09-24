package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDAO;
import model.Pessoa;
import java.util.List;

@WebServlet("/UsuarioLogin")
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean validador = false;
		
		

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Pessoa> pessoas = PessoaDAO.find(pesquisa);

		for(int i = 0; i < pessoas.size(); i ++ ) {
			String pessoa_email = pessoas.get(i).getEmail();
			String pessoa_senha = pessoas.get(i).getSenha();
			if(pessoa_email.equals(email) && pessoa_senha.equals(senha)) {
				System.out.println("Validado com sucesso!");
				validador = true;
			}  
		}
		if(validador == true) {
			response.sendRedirect("./sucesso.html");
		} else {
			System.out.println("Usuario invalido!");
			response.sendRedirect("./index.html"); 
		}
	}
}
