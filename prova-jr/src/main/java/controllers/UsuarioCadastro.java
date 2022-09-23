package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

		pessoa.setNome(request.getParameter("nome"));
		pessoa.setSexo(request.getParameter("sexo"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setCelular(request.getParameter("celular"));
		pessoa.setSenha(request.getParameter("senha"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println("Valor da data:" + date);
		System.out.println("Valor da data formatado:" + formatter.format(date));
		pessoa.setData_cadastro(formatter.format(date));
		PessoaDAO.create(pessoa);

		doGet(request, response);
	}
}
