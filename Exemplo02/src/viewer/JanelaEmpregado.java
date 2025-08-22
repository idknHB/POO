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

import model.Departamento;
import model.Empregado;
import model.ModelException;
import model.dao.DaoDepartamento;
import model.dao.DaoEmpregado;

public class JanelaEmpregado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JLabel lblNewLabel_1;
	private JTextField tfNome;
	private JLabel lblNewLabel_2;
	private JComboBox cbDepartamento;

	/**
	 * Create the frame.
	 */
	public JanelaEmpregado() {
		setTitle("Empregado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(32, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(77, 41, 206, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(Departamento.TAMANHO_SIGLA);
		
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
				String cpf = tfCpf.getText();
				String nome = tfNome.getText();
				Departamento depto = (Departamento)cbDepartamento.getSelectedItem();
				try {
					Empregado novo = new Empregado(cpf,nome,depto);
					DaoEmpregado dao = new DaoEmpregado();
					dao.adicionar(novo);
					JOptionPane.showMessageDialog(btOk, "Empregado Criado!");
					setVisible(false);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btOk, e1.getMessage());
				}
			}
		});
		btOk.setBounds(77, 176, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(253, 176, 89, 23);
		contentPane.add(btCancelar);
		
		lblNewLabel_2 = new JLabel("Departamento:");
		lblNewLabel_2.setBounds(32, 125, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		DaoDepartamento dao = new DaoDepartamento();
		cbDepartamento = new JComboBox(dao.obterTodos().toArray());
		cbDepartamento.setBounds(121, 121, 221, 22);
		contentPane.add(cbDepartamento);
		
		this.setVisible(true);
	}
}
