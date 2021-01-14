package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldPssw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePane = new JPanel();
		titlePane.setBackground(Color.WHITE);
		titlePane.setBounds(47, 25, 341, 76);
		contentPane.add(titlePane);
		titlePane.setLayout(null);
		
		JLabel title = new JLabel("Nesti");
		title.setFont(new Font("Tahoma", Font.PLAIN, 36));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 11, 321, 54);
		titlePane.add(title);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(85, 176, 271, 44);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Nomd'utilisateur");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(85, 141, 131, 24);
		contentPane.add(lblUserName);
		
		textFieldPssw = new JTextField();
		textFieldPssw.setColumns(10);
		textFieldPssw.setBounds(85, 282, 271, 44);
		contentPane.add(textFieldPssw);
		
		JLabel lblPssw = new JLabel("Mot de passe");
		lblPssw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPssw.setBounds(85, 247, 131, 24);
		contentPane.add(lblPssw);
		
		JButton btnConnection = new JButton("Connexion");
		btnConnection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConnection.setBounds(64, 352, 122, 51);
		contentPane.add(btnConnection);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(252, 352,122, 51);
		contentPane.add(btnCancel);
	}
}