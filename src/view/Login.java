package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lambdaworks.crypto.SCryptUtil;

import dao.AdministratorDAO;
import dao.ProductDAO;
import model.Administrator;
import model.AppConnection;
import tools.AppSettings;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		var testProduct = (new ProductDAO()).find("idProduct",1);
//		System.out.println(testProduct.getProductName());
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

		textFieldUserName = new JTextField("SuperAdmin");
		textFieldUserName.setBounds(85, 176, 271, 44);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);

		JLabel lblUserName = new JLabel("Nomd'utilisateur");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(85, 141, 131, 24);
		contentPane.add(lblUserName);

		JLabel lblPssw = new JLabel("Mot de passe");
		lblPssw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPssw.setBounds(85, 247, 131, 24);
		contentPane.add(lblPssw);

		JButton btnConnection = new JButton("Connexion");
		btnConnection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = textFieldUserName.getText();
				String passwords = String.valueOf(passwordField.getPassword());
				logIn(username, passwords);
//				AppConnection newLogin = new AppConnection();
//				if(logIn(username, passwords)) {
//				Management manage = new Management();
//				manage.setVisible(true);
//				}else {
//					JOptionPane.showMessageDialog(null, "Invalid informations");
//				}

			}
		});
		btnConnection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConnection.setBounds(64, 352, 122, 51);
		contentPane.add(btnConnection);

		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(252, 352, 122, 51);
		contentPane.add(btnCancel);

		passwordField = new JPasswordField("SUPPERadmin3!");
		passwordField.setBounds(85, 293, 271, 44);
		contentPane.add(passwordField);
	}

	/**
	 * This function allows you to check the connection 
	 * information entered by the user and verify if it is correct.
	 *  If all the information is correct the user is connected, 
	 *  if not an error message is displayed.
	 * @param username the login enter by the user
	 * @param password the password enter by the user
	 * @return true | false
	 */
	public boolean logIn(String username, String password) {
		boolean result = false;

		var admin = (new AdministratorDAO()).find("userName", username);
//			System.out.println(admin.getClass());
		if (admin == null) {
			JOptionPane.showMessageDialog(null, "Invalid informations");

		} else {
			if (username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter a username and a password");
			} else {
				if (admin.isPassword(password)) {
					AppSettings.set("loginUser", Integer.toString(admin.getId()));
					Management m = new Management();
					m.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid informations");
				}
			}

		}

//			var adminId = Integer.parseInt(AppSettings.get("loginUser"));
//			var admin1 = (new  AdministratorDAO()).find("userId",adminId);

		return result;
	}

}
