package view;

import model.Aluno;
import model.Atividade;
import model.GestaoDados;
import model.Professor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CriarAtividadePanel extends JPanel {
    private JTextField nomeField;
    private JComboBox<Professor> professorCombo;
    private JComboBox<Aluno> alunoCombo;

    public CriarAtividadePanel(GestaoDados gestaoDados) {
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);
        add(nomeLabel);
        add(nomeField);

        JLabel professorLabel = new JLabel("Professor:");
        professorCombo = new JComboBox<>();
        for (Professor professor : gestaoDados.listarProfessores()) {
            professorCombo.addItem(professor);
        }
        add(professorLabel);
        add(professorCombo);

        JLabel alunoLabel = new JLabel("Aluno:");
        alunoCombo = new JComboBox<>();
        for (Aluno aluno : gestaoDados.listarAlunos()) {
            alunoCombo.addItem(aluno);
        }
        add(alunoLabel);
        add(alunoCombo);

        JButton criarButton = new JButton("Criar Atividade");
        criarButton.addActionListener(event -> {
            String nome = nomeField.getText();
            Professor professor = (Professor) professorCombo.getSelectedItem();
            Aluno aluno = (Aluno) alunoCombo.getSelectedItem();
            if (nome.isEmpty() || professor == null || aluno == null) {
                // Tratar erro ou mostrar mensagem de erro
                return;
            }
            Atividade atividade = new Atividade(nome);
            //bota aqui dog
            gestaoDados.associarProfessorAtividade(professor, atividade);
            gestaoDados.associarAlunoAtividade(aluno, atividade);
            // Limpar campos ou atualizar interface, se necessário
        });
        add(criarButton);
    }
}

