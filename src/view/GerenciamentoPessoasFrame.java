package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GerenciamentoPessoas;

public class GerenciamentoPessoasFrame extends JFrameMelhorado {
	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Gerenciamento de Funcionários";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;
	private GerenciamentoPessoas gerenciamentoPessoas;

	public GerenciamentoPessoasFrame() {
		super(NOME_FRAME, LARGURA, ALTURA);

		gerenciamentoPessoas = new GerenciamentoPessoas();

		JPanel panel = new JPanel(new GridBagLayout());

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(evento -> {
			this.setVisible(false);
			new CadastrarFrame(gerenciamentoPessoas, this);
		});

		JButton listar = new JButton("Listar");
		listar.addActionListener(evento -> {
			this.setVisible(false);
			new ListarFrame(gerenciamentoPessoas, this);
		});
		

		panel.add(cadastrar, posicionar(0, 0));
		panel.add(listar, posicionar(1, 0));

		this.add(panel);
	}

}
