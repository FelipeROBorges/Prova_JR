package db;

import java.sql.*;

public class PgConnection {
	private static final String url = "jdbc:postgresql://localhost:5432/prova_jr";
	private static final String user = "postgres";
	private static final String password = "root";
	
	public static Connection createConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver encontrado");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado. " + e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado com sucesso!");
			return connection;
			
		} catch(SQLException e) {
			System.out.println("Não conectao a base de dados." + e.getMessage());
			return null;
		}
	}
}
