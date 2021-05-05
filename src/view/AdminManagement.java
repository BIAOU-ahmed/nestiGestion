package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.AdministratorDAO;
import model.Administrator;
import model.SuperAdmin;
import tools.AppSettings;
import tools.Useful;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AdminManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTable table;
	private JTextField textFieldResearch;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManagement frame = new AdminManagement();
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
	public AdminManagement() {
		var adminId = Integer.parseInt(AppSettings.get("loginUser"));
		SuperAdmin admin1 = (SuperAdmin) (new AdministratorDAO()).find("userId", adminId);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Gestion des Comptes");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 50, 700, 50);
		contentPane.add(lblTitle);

		JLabel lblUserName = new JLabel("Nom d'utilisateur");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(200, 160, 300, 40);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(200, 260, 300, 40);
		contentPane.add(lblPassword);

		JLabel lblRights = new JLabel("Droits");
		lblRights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRights.setHorizontalAlignment(SwingConstants.CENTER);
		lblRights.setBounds(200, 360, 300, 40);
		contentPane.add(lblRights);

		JComboBox comboBoxRights = new JComboBox();
		comboBoxRights.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Super Admin" }));
		comboBoxRights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxRights.setBounds(200, 400, 300, 40);
		contentPane.add(comboBoxRights);

		JButton btnCreate = new JButton("Cr\u00E9er");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Useful.isUserNameValid(textFieldUserName.getText())
						&& Useful.isPasswordValid(String.valueOf(passwordField.getPassword()))) {
					Administrator admin = new Administrator();
					var userName = textFieldUserName.getText();
					var password = String.valueOf(passwordField.getPassword());
					admin.setUserName(userName);
					admin.setPassword(password);
					admin.setAdminState("a");
					java.util.Date sqlDate = new java.util.Date();
					Date createDate = new Date(sqlDate.getTime());
					admin.setCreatedAt(createDate);
					admin1.createAccount(admin);

//					if (comboBoxRights.getToolTipText().equals("Admin")) {
//						// 2
//					} else if (comboBoxRights.getToolTipText().equals("Super Admin")) {
//						// 1
//					}
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreate.setBounds(100, 520, 100, 40);
		contentPane.add(btnCreate);

		textFieldUserName = new JTextField();
		textFieldUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUserName.setBounds(200, 200, 300, 40);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(300, 520, 100, 40);
		contentPane.add(btnUpdate);

		JButton btnLock = new JButton("Bloquer");
		btnLock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLock.setBounds(500, 520, 100, 40);
		contentPane.add(btnLock);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(700, 100, 700, 650);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Nom d'utilisateur", "Droits", "Date de creation", "Statut" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);

		JLabel lblResearch = new JLabel("Rechercher");
		lblResearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblResearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResearch.setBounds(800, 0, 500, 30);
		contentPane.add(lblResearch);

		textFieldResearch = new JTextField();
		textFieldResearch.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldResearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldResearch.setBounds(800, 30, 500, 30);
		contentPane.add(textFieldResearch);
		textFieldResearch.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(200, 300, 300, 40);
		contentPane.add(passwordField);

		JButton btnReturn = new JButton("Retour");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturn.setBounds(250, 650, 200, 40);
		contentPane.add(btnReturn);

		JRadioButton rdbtnRights = new JRadioButton("Droits");
		rdbtnRights.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRights.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRights.setBounds(900, 60, 100, 40);
		contentPane.add(rdbtnRights);

		JRadioButton rdbnState = new JRadioButton("Statut");
		rdbnState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbnState.setHorizontalAlignment(SwingConstants.CENTER);
		rdbnState.setBounds(1100, 60, 100, 40);
		contentPane.add(rdbnState);
	}
}
