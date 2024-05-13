package model;

public class Professor extends Pessoa {
	private String especialidade;
	public Professor(String nome, String cpf, String curso, String especialidade){
		super(nome, cpf, curso);
		this.especialidade = especialidade;

	}
	public String getEspecialidade() {
		return especialidade;
	}

	public void setMatricula(String matricula) {
		this.especialidade = especialidade;
	}


}
