package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
	private List<Atividade> atividades;
	private String especialidade;
	public Professor(String nome, String cpf, String curso, String especialidade){
		super(nome, cpf, curso);
		this.especialidade = especialidade;
		this.atividades = new ArrayList<>();

	}
	public String getEspecialidade() {
		return especialidade;
	}

	public void adicionarAtividade(Atividade atividade) {
		atividades.add(atividade);
	}

	public void setMatricula(String matricula) {
		this.especialidade = especialidade;
	}


}
