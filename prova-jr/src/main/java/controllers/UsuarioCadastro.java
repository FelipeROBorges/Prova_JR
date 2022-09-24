package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDAO;
import model.Pessoa;

@WebServlet("/UsuarioCadastro")
public class UsuarioCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioCadastro() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pessoa pessoa = new Pessoa();
		List<Pessoa> pessoas = PessoaDAO.find("");
		String email = request.getParameter("email");
		boolean validador = true;
		for(int i = 0; i < pessoas.size(); i ++ ) {
			String pessoa_email = pessoas.get(i).getEmail();
			if(pessoa_email.equals(email)) {
				System.out.println("Email já existe!");
				validador = false;
			}  
		}

		pessoa.setNome(request.getParameter("nome"));
		pessoa.setSexo(request.getParameter("sexo"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setCelular(request.getParameter("celular"));
		pessoa.setSenha(request.getParameter("senha"));
		java.util.Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pessoa.setData_cadastro(sqlDate);


		if(validador == true) {
			PessoaDAO.create(pessoa);
			response.sendRedirect("./sucesso.html");
		} else {
			System.out.println("Email invalido!");
			response.sendRedirect("./index.html"); 
		}
	}
}
