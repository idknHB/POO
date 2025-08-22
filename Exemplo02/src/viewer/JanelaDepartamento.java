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

import model.Departamento;
import model.ModelException;
import model.dao.DaoDepartamento;

public class JanelaDepartamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSigla;
	private JLabel lblNewLabel_1;
	private JTextField tfNome;

	/**
	 * Create the frame.
	 */
	public JanelaDepartamento() {
		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sigla:");
		lblNewLabel.setBounds(32, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfSigla = new JTextField();
		tfSigla.setBounds(77, 41, 86, 20);
		contentPane.add(tfSigla);
		tfSigla.setColumns(Departamento.TAMANHO_SIGLA);
		
		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(32, 86, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(77, 83, 265, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Precisamos fazer a comunicação com o controller
				String sigla = tfSigla.getText();
				String nome = tfNome.getText();
				try {
					Departamento novo = new Departamento(sigla,nome);
					DaoDepartamento dao = new DaoDepartamento();
					dao.adicionar(novo);
					JOptionPane.showMessageDialog(btOk, "Departamento Criado!");
					setVisible(false);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btOk, e1.getMessage());
				}
			}
		});
		btOk.setBounds(77, 141, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(253, 141, 89, 23);
		contentPane.add(btCancelar);
		this.setVisible(true);
	}
}
