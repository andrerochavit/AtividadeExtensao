package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GerenciamentoPessoas;
import model.Aluno;
import model.Professor;

public class ListarFrame extends JFrameMelhorado {
	
	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Listagem de Pessoas";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;
	
	public ListarFrame(GerenciamentoPessoas gerenciamentoPessoas, GerenciamentoPessoasFrame mainframe) {
		super(NOME_FRAME, LARGURA, ALTURA);
		
		var pessoas = gerenciamentoPessoas.listarFuncionarios();

		JPanel panel = new JPanel(new GridBagLayout());
		
		var tabela = new TabelaFacil("Nome", "CPF", "Curso", "Matricula", "Especialidade");

		for (var pessoa : pessoas) {
			String nome = pessoa.getNome();
			String cpf = pessoa.getCpf();
			String curso = pessoa.getCurso();
			if (pessoa instanceof Professor professor) {
				tabela.adicionarLinha(nome, cpf, curso, professor.getEspecialidade(), "");
			} else if (pessoa instanceof Aluno aluno) {
				tabela.adicionarLinha(nome, cpf, curso, aluno.getMatricula());
			}
		}

		panel.add(tabela.gerar(), posicionar(0, 0));

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(event -> {
			this.dispose();
			mainframe.setVisible(true);
		});
		panel.add(voltarButton, posicionar(0, 1));

		this.add(panel);
	}
}
