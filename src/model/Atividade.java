package model;

import java.util.ArrayList;
import java.util.List;

public class Atividade {
    private String nome;
    private List<Professor> professores;
    private List<Aluno> alunos;

    public Atividade(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }


}