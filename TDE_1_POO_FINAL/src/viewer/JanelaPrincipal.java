package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JanelaPrincipal() {
		setTitle("Menu Principal - TDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaCurso();
			}
		});
		btnCurso.setBounds(30, 45, 117, 66);
		contentPane.add(btnCurso);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaAluno();
			}
		});
		btnAluno.setBounds(175, 45, 117, 66);
		contentPane.add(btnAluno);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(320, 45, 117, 66);
		contentPane.add(btnFechar);
		
		this.setVisible(true);
	}
}