package component;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.AdministratorDAO;
import model.Administrator;
import tools.AppSettings;
import view.AdminManagement;
import view.Management;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePanel extends Tab {

	/**
	 * Create the panel.
	 */

	private JButton btnCancelUsernameProfile;
	private JButton btnAdminProfile;
	private JButton btnCancelPasswordProfile;
	private JButton btnEditUsernameProfile;
	private JButton btnEditPasswordProfile;
	private JTextField textFieldUsernameProfile;
	private JPasswordField passwordFieldCurrent;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldNew2;
	private JButton btnSavePassword;
	private JLabel lblCurrentPassword;
	private JLabel lblNewPassword;
	private JLabel lblNewPassword2;

	public ProfilePanel(Management c) {

		// JPanel this = new JPanel();
		// tabbedPane.addTab("Profil", null, this, null);
		this.setLayout(null);
		refreshTab();
	}

	@Override
	public void refreshTab() {
		super.refreshTab();
		JLabel lblTitleProfile = new JLabel("Profil");
		lblTitleProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleProfile.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleProfile.setBounds(570, 70, 300, 40);
		this.add(lblTitleProfile);

		JLabel lblUsernameProfile = new JLabel("Nom d'utilisateur");
		lblUsernameProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsernameProfile.setBounds(400, 170, 300, 30);
		this.add(lblUsernameProfile);

		textFieldUsernameProfile = new JTextField();
		textFieldUsernameProfile.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUsernameProfile.setBounds(400, 200, 300, 36);
		this.add(textFieldUsernameProfile);
		textFieldUsernameProfile.setColumns(10);
		textFieldUsernameProfile.setEditable(false);
		var adminId = Integer.parseInt(AppSettings.get("loginUser"));
		var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
		textFieldUsernameProfile.setText(admin.getUserName());

		btnEditUsernameProfile = new JButton("Modifier");
		btnEditUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditUsernameProfile.setBounds(750, 200, 150, 40);
		this.add(btnEditUsernameProfile);

		btnCancelUsernameProfile = new JButton("Annuler");
		btnCancelUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelUsernameProfile.setBounds(950, 200, 150, 40);
		this.add(btnCancelUsernameProfile);
		btnCancelUsernameProfile.setVisible(false);

		btnEditPasswordProfile = new JButton("Modifier mot de passe");
		btnEditPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditPasswordProfile.setBounds(620, 350, 200, 40);
		this.add(btnEditPasswordProfile);

		lblCurrentPassword = new JLabel("Mot de passe actuel");
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentPassword.setBounds(400, 320, 300, 30);
		this.add(lblCurrentPassword);
		lblCurrentPassword.setVisible(false);

		passwordFieldCurrent = new JPasswordField();
		passwordFieldCurrent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldCurrent.setBounds(400, 350, 300, 40);
		this.add(passwordFieldCurrent);
		passwordFieldCurrent.setVisible(false);

		lblNewPassword = new JLabel("Nouveau mot de passe");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(400, 420, 300, 30);
		add(lblNewPassword);
		lblNewPassword.setVisible(false);

		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldNew.setText((String) null);
		passwordFieldNew.setBounds(400, 450, 300, 40);
		add(passwordFieldNew);
		passwordFieldNew.setVisible(false);

		lblNewPassword2 = new JLabel("Confirmer mot de passe");
		lblNewPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword2.setBounds(400, 520, 300, 30);
		add(lblNewPassword2);
		lblNewPassword2.setVisible(false);

		passwordFieldNew2 = new JPasswordField();
		passwordFieldNew2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldNew2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldNew2.setText((String) null);
		passwordFieldNew2.setBounds(400, 550, 300, 40);
		add(passwordFieldNew2);
		passwordFieldNew2.setVisible(false);

		btnSavePassword = new JButton("Enregistrer");
		btnSavePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSavePassword.setBounds(750, 400, 150, 40);
		add(btnSavePassword);
		btnSavePassword.setVisible(false);

		btnCancelPasswordProfile = new JButton("Annuler");
		btnCancelPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelPasswordProfile.setBounds(750, 500, 150, 40);
		this.add(btnCancelPasswordProfile);
		btnCancelPasswordProfile.setVisible(false);

		btnAdminProfile = new JButton("Gestion Admin");
		btnAdminProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminProfile.setBounds(620, 500, 200, 40);
		this.add(btnAdminProfile);
		btnAdminProfile.setVisible(true);
		// TODO fonction isSuperAdmin
//		if(isSuperAdmin(adminId)) {
//			btnAdminProfile.setVisible(true);
//		} else {
//			btnAdminProfile.setVisible(false);
//		}

		JLabel lblDateProfile = new JLabel("Profil cr\u00E9\u00E9 le 08/01/21");
		lblDateProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateProfile.setBounds(570, 650, 300, 30);
		this.add(lblDateProfile);

		setUpListener();
	}

	public void setUpListener() {

		// Bouton qui permet de lancer la page de gestion des admins, le bouton
		// n'apparait que pour les SuperAdmins voir sur le bouton lui-même
		btnAdminProfile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AdminManagement gestion = new AdminManagement();
				gestion.setVisible(true);
				setVisible(false);
			}
		});

		// Le bouton Modidier pour l'username permet la modification du champ, fait
		// apparaitre le bouton annuler, et le bouton devient enregistrer
		btnEditUsernameProfile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (btnEditUsernameProfile.getText().equals("Modifier")) {
					textFieldUsernameProfile.setEditable(true);
					btnCancelUsernameProfile.setVisible(true);
					btnEditUsernameProfile.setText("Enregistrer");

				} else if (btnEditUsernameProfile.getText().equals("Enregistrer")) {
					textFieldUsernameProfile.setEditable(false);
					btnCancelUsernameProfile.setVisible(false);
					btnEditUsernameProfile.setText("Modifier");

				}

				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
				// TODO
				// Appel fonction BDD
				textFieldUsernameProfile.setText(admin.getUserName());
			}

		});

		// Le bouton annuler de l'username remet à l'état initial
		btnCancelUsernameProfile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldUsernameProfile.setEditable(false);
				btnCancelUsernameProfile.setVisible(false);
				btnEditUsernameProfile.setText("Modifier");
				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
				textFieldUsernameProfile.setText(admin.getUserName());
			}
		});

		// Bouton qui permet d'afficher les informations pour changer de mot de passe
		btnEditPasswordProfile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (btnEditUsernameProfile.getText() == "Enregistrer") {
					JOptionPane.showMessageDialog(null, "Veuillez finir la modification de votre nom d'utilisateur");
				} else {
					btnEditPasswordProfile.setVisible(false);
					btnAdminProfile.setVisible(false);
					btnSavePassword.setVisible(true);
					btnCancelPasswordProfile.setVisible(true);
					lblCurrentPassword.setVisible(true);
					lblNewPassword.setVisible(true);
					lblNewPassword2.setVisible(true);
					passwordFieldCurrent.setVisible(true);
					passwordFieldNew.setVisible(true);
					passwordFieldNew2.setVisible(true);
				}
			}
		});

		btnSavePassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO: Test des mot de passe
				String username = textFieldUsernameProfile.getText();
				String currentPassword = String.valueOf(passwordFieldCurrent.getPassword());
				String newPassword = String.valueOf(passwordFieldNew.getPassword());
				String testPassword = String.valueOf(passwordFieldNew2.getPassword());
				var admin = (new AdministratorDAO()).find("userName", username);
				if (!currentPassword.equals(admin.getPassword())) {
					JOptionPane.showMessageDialog(null, "Mot de passe actuel non valide");
				} else if (!newPassword.equals(testPassword)) {
					JOptionPane.showMessageDialog(null, "Nouveau mot de passe et confirmation sont différent");
				}

			}
		});

		btnCancelPasswordProfile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnEditPasswordProfile.setVisible(true);
				// TODO faire le fonction isSuperAdmin
				btnAdminProfile.setVisible(true);
//				if (isSuperAdmin) {
//					btnAdminProfile.setVisible(true);
//				}
				btnSavePassword.setVisible(false);
				btnCancelPasswordProfile.setVisible(false);
				lblCurrentPassword.setVisible(false);
				lblNewPassword.setVisible(false);
				lblNewPassword2.setVisible(false);
				passwordFieldCurrent.setVisible(false);
				passwordFieldNew.setVisible(false);
				passwordFieldNew2.setVisible(false);
			}

		});

	}
}
