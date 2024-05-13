package controller;

import java.util.List;

import model.Pessoa;
import model.Professor;
import model.GestaoDados;
import model.Aluno;

public class GerenciamentoPessoas {
	private GestaoDados gestaoDados;

	public GerenciamentoPessoas() {
		super();
		gestaoDados = new GestaoDados();
	}

	public void salvarAluno(String nome, String cpf, String curso, String matricula) {
		var aluno = new Aluno(nome, cpf, curso, matricula);
		gestaoDados.salvar(aluno);
	}

	public void salvarProfessor(String nome, String cpf, String curso,String especialidade) {
		var professor = new Professor(nome, cpf, curso,especialidade);
		gestaoDados.salvar(professor);
	}

	public List<Pessoa> listarFuncionarios() {
		return gestaoDados.listar();
	}

}
