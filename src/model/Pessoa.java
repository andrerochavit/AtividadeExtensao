package model;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String curso;
	
	
	public Pessoa(String nome, String cpf, String curso) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.curso = curso;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
