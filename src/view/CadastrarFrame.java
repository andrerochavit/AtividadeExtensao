package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GerenciamentoPessoas;

public class CadastrarFrame extends JFrameMelhorado {

	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Gerenciamento : Projetos de Extensões";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;

	public CadastrarFrame(GerenciamentoPessoas gerenciamentoPessoas,
						  GerenciamentoPessoasFrame mainframe) {
		super(NOME_FRAME, LARGURA, ALTURA);

		JPanel panel = new JPanel(new GridBagLayout());

		var nomeField = criarCampo(panel, "Nome: ", 0, 0, 1, 0);
		JTextField cpfField = criarCampo(panel, "CPF: ", 0, 1, 1, 1);
		JTextField cursoField = criarCampo(panel, "Curso: ", 0, 2, 1, 2);

		JComboBox<String> PessoaCombo = new JComboBox<>(new String[] { "Aluno", "Professor" });
		panel.add(PessoaCombo, posicionar(0, 3));

		JLabel labelMatricula = new JLabel("Projeto De Extensão: ");
		JLabel labelEspecialidade = new JLabel("Especialidade: ");
		panel.add(labelMatricula, posicionar(0, 4));
		JTextField projetoExtensao = new JTextField(20);
		panel.add(projetoExtensao, posicionar(1, 4));
		JTextField especialidadeField = new JTextField(20);
		panel.add(especialidadeField, posicionar(1, 4));

		labelMatricula.setVisible(false);
		labelEspecialidade.setVisible(false);

		PessoaCombo.addActionListener(event -> {
			String itemSelecionado = (String) PessoaCombo.getSelectedItem();

			if (!itemSelecionado.equals("Aluno")) {
				labelMatricula.setVisible(true);
				labelEspecialidade.setVisible(false);
				projetoExtensao.setVisible(true);
			} else {
				labelMatricula.setVisible(false);
				labelEspecialidade.setVisible(true);
				especialidadeField.setVisible(true);
			}
		});

		JButton salvarButton = new JButton("Salvar");
		panel.add(salvarButton, posicionar(0, 5));
		JButton voltarButton = new JButton("Voltar");
		panel.add(voltarButton, posicionar(1, 5));

		salvarButton.addActionListener(event -> {

			String nome = nomeField.getText();
			String cpf = cpfField.getText();
			String curso = cursoField.getText();
			if (PessoaCombo.getSelectedItem().equals("Aluno")) {
				String matricula = projetoExtensao.getText();
				gerenciamentoPessoas.salvarAluno(nome, cpf, curso, matricula);
			} else {
				String especialidade = especialidadeField.getText();
				gerenciamentoPessoas.salvarProfessor(nome, cpf, curso, especialidade);
			}
			close(mainframe);
		});

		voltarButton.addActionListener(event -> close(mainframe));

		this.add(panel);
	}

	private JTextField criarCampo(JPanel panel, String nomeCampo, int labelX, int labelY, int fieldX, int fieldY) {
		panel.add(new JLabel(nomeCampo), posicionar(labelX, labelY));
		JTextField field = new JTextField(20);
		panel.add(field, posicionar(fieldX, fieldY));
		return field;
	}

	private void close(GerenciamentoPessoasFrame mainframe) {
		this.dispose();
		mainframe.setVisible(true);
	}

}