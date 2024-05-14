package model;

import java.util.List;

public class Aluno extends Pessoa {
	private List<Atividade> atividades;
	private String matricula;

	public Aluno(String nome, String cpf, String curso, String matricula) {
		super(nome, cpf, curso);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void adicionarAtividade(Atividade atividade) {
		atividades.add(atividade);
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
