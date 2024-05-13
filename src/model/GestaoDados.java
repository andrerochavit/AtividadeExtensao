package model;

import java.util.ArrayList;
import java.util.List;

public class GestaoDados {

	private static final double COMISSAO_GERENTE = 0.2;
	private List<Pessoa> pessoas;

	public GestaoDados() {
		super();
		this.pessoas = new ArrayList<>();
	}


	public void salvar(Professor professor) {
		pessoas.add(professor);
	}

	public void salvar(Aluno aluno) {
		pessoas.add(aluno);
	}

	public List<Pessoa> listar() {
		return pessoas;
	}


}
