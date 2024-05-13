package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestaoDados {

	private static final String ARQUIVO_DADOS = "dados.txt";
	private List<Pessoa> pessoas;

	public GestaoDados() {
		super();
		this.pessoas = new ArrayList<>();
	}

	private void carregarDadosDoArquivo() {
		try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(",");
				if (partes[0].equals("Aluno")) {
					String nome = partes[1];
					String cpf = partes[2];
					String curso = partes[3];
					String matricula = partes[4];
					pessoas.add(new Aluno(nome, cpf, curso, matricula));
				} else if (partes[0].equals("Professor")) {
					String nome = partes[1];
					String cpf = partes[2];
					String curso = partes[3];
					String especialidade = partes[4];
					pessoas.add(new Professor(nome, cpf, curso, especialidade));
				}
			}
		} catch (IOException e) {
			System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());
		}
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

	private void salvarDadosEmArquivo() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_DADOS))) {
			for (Pessoa pessoa : pessoas) {
				if (pessoa instanceof Professor) {
					Professor professor = (Professor) pessoa;
					writer.println("Professor," + professor.getNome() + "," + professor.getCpf() + "," + professor.getCurso() + "," + professor.getEspecialidade());
				} else if (pessoa instanceof Aluno) {
					Aluno aluno = (Aluno) pessoa;
					writer.println("Aluno," + aluno.getNome() + "," + aluno.getCpf() + "," + aluno.getCurso() + "," + aluno.getMatricula());
				}
			}
		} catch (IOException e) {
			System.err.println("Erro ao salvar dados no arquivo: " + e.getMessage());
		}
	}

	private void criarArquivoSeNaoExistir() {
		File arquivo = new File(ARQUIVO_DADOS);
		if (!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				System.err.println("Erro ao criar arquivo: " + e.getMessage());
			}
		}
	}

}
