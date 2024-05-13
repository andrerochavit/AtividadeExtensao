package model;

public class Aluno extends Pessoa {

	private String matricula;

	public Aluno(String nome, String cpf, String curso, String matricula) {
		super(nome, cpf, curso);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
