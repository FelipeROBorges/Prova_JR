package model;


public class Pessoa {
	private int id;
	private String nome;
	private String sexo;
	private String email;
	private String celular;
	private String senha;
	private String data_cadastro;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id +", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", celular=" + celular + ", senha="
				+ senha + ", data_cadastro=" + data_cadastro + "]";
	}
	
}
