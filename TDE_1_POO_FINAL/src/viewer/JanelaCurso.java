package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class JanelaCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;

	public JanelaCurso() {
		setTitle("Cadastro de Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(33, 38, 61, 16);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(92, 35, 130, 22);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(33, 78, 61, 16);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(92, 75, 298, 22);
		contentPane.add(tfNome);
		tfNome.setColumns(40);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 1. Coletar os dados da tela
					int codigo = Integer.parseInt(tfCodigo.getText());
					String nome = tfNome.getText();
					
					// 2. Criar o objeto de modelo
					Curso novoCurso = new Curso(codigo, nome);
					
					// 3. Persistir o objeto
					DaoCurso dao = new DaoCurso();
					dao.adicionar(novoCurso);
					
					// 4. Feedback para o usuário e fechar a janela
					JOptionPane.showMessageDialog(btnOk, "Curso criado com sucesso!");
					setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnOk, "Erro na conversão do código. Digite um número válido.");
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btnOk, e1.getMessage());
				}
			}
		});
		btnOk.setBounds(102, 135, 97, 25);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(248, 135, 97, 25);
		contentPane.add(btnCancelar);
		
		this.setVisible(true);
	}
}