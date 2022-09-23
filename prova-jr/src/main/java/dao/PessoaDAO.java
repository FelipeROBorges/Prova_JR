package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import db.PgConnection;
import model.Pessoa;

public class PessoaDAO implements CRUD {
	
	private static Connection connection = PgConnection.createConnection();
	private static String sql;
	
	public static void create(Pessoa pessoa) {
		 sql = "INSERT INTO prv_pessoa VALUES (null, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, pessoa.getNome());
			 preparedStatement.setString(2, pessoa.getSexo());
			 preparedStatement.setString(3, pessoa.getEmail());
			 preparedStatement.setString(4, pessoa.getCelular());
			 preparedStatement.setString(5, pessoa.getSenha());
			 preparedStatement.setString(6, pessoa.getData_cadastro());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct insert on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect insert on database. " + e.getMessage());
		 }
	}
	
	public static void delete(int pessoaId) {
		sql = "DELETE FROM prv_pessoa WHERE pes_id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, pessoaId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on usuario");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on pessoa. " + e.getMessage());
		}
	}
	
	public static List<Pessoa> find(String pesquisa){
		
		sql = String.format("SELECT * FROM prv_pessoa WHERE pes_email LIKE '%s%%' "
				, pesquisa, pesquisa, pesquisa, pesquisa);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(resultSet.getInt("pes_id"));
				pessoa.setNome(resultSet.getString("pes_nome"));
				pessoa.setSexo(resultSet.getString("pes_sexo"));
				pessoa.setEmail(resultSet.getString("pes_email"));
				pessoa.setCelular(resultSet.getString("pes_celular"));
				pessoa.setSenha(resultSet.getString("pes_senha"));
				pessoa.setData_cadastro(resultSet.getString("pes_data_cadastro"));
				
				pessoas.add(pessoa);
				
			}
			
			System.out.println("--correct find pessoas");
			return pessoas;
			
		} catch(SQLException e) {
			System.out.println("--incorrect find pessoas. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Pessoa findByPk(int pessoaId) {
		sql = String.format("SELECT * FROM prv_pessoa WHERE pes_id = %d ", pessoaId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Pessoa pessoa = new Pessoa();
			
			while (resultSet.next()) {
				pessoa.setId(resultSet.getInt("pes_id"));
				pessoa.setNome(resultSet.getString("pes_nome"));
				pessoa.setSexo(resultSet.getString("pes_sexo"));
				pessoa.setEmail(resultSet.getString("pes_email"));
				pessoa.setCelular(resultSet.getString("pes_celular"));
				pessoa.setSenha(resultSet.getString("pes_senha"));
				pessoa.setData_cadastro(resultSet.getString("pes_data_cadastro"));
			}
			
			System.out.println("--correct find by pk pessoa");
			return pessoa;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk pessoa. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Pessoa pessoa) {
		sql = "UPDATE prv_pessoa SET pre_nome=?, pes_sexo=?, pes_emai=?, pes_celular=?, pes_senha=? WHERE pes_id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, pessoa.getNome());
			 preparedStatement.setString(2, pessoa.getSexo());
			 preparedStatement.setString(3, pessoa.getEmail());
			 preparedStatement.setString(4, pessoa.getCelular());
			 preparedStatement.setString(5, pessoa.getSenha());
			 preparedStatement.setInt(7, pessoa.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
}
