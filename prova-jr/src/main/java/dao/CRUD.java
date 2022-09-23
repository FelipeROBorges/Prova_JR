package dao;

import java.util.List;

import model.Pessoa;

public interface CRUD {
	public static void create(Pessoa pessoa) {};
	public static void delete(int pessoaId) {};
	public static List<Pessoa> find(String pesquisa){return null;}
	public static Pessoa findByPk(int pessoaId) {return null;}
	public static void update(Pessoa pessoa) {}
}
