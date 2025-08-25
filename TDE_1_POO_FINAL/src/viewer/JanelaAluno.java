package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoCurso;

public class JanelaAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JComboBox<Curso> cbCurso;

	public JanelaAluno() {
		setTitle("Cadastro de Aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setBounds(33, 38, 70, 16);
		contentPane.add(lblMatricula);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(110, 35, 130, 22);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(33, 78, 70, 16);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(110, 75, 298, 22);
		contentPane.add(tfNome);
		tfNome.setColumns(40);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(33, 118, 70, 16);
		contentPane.add(lblCurso);
		
		// Carregando os cursos no ComboBox
		DaoCurso daoCurso = new DaoCurso();
		cbCurso = new JComboBox(daoCurso.obterTodos().toArray());
		cbCurso.setBounds(110, 115, 298, 25);
		contentPane.add(cbCurso);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 1. Coletar os dados da tela
					int matricula = Integer.parseInt(tfMatricula.getText());
					String nome = tfNome.getText();
					Curso cursoSelecionado = (Curso)cbCurso.getSelectedItem();

					// 2. Criar o objeto de modelo
					Aluno novoAluno = new Aluno(matricula, nome, cursoSelecionado);
					
					// 3. Persistir o objeto
					DaoAluno dao = new DaoAluno();
					dao.adicionar(novoAluno);
					
					// 4. Feedback e fechar a janela
					JOptionPane.showMessageDialog(btnOk, "Aluno criado com sucesso!");
					setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnOk, "Erro na conversão da matrícula. Digite um número válido.");
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btnOk, e1.getMessage());
				} catch (Exception e1) {
                    JOptionPane.showMessageDialog(btnOk, "Ocorreu um erro: " + e1.getMessage());
                }
			}
		});
		btnOk.setBounds(112, 185, 97, 25);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(258, 185, 97, 25);
		contentPane.add(btnCancelar);
		
		this.setVisible(true);
	}
}