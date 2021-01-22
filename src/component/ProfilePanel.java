package component;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.AdministratorDAO;
import model.Administrator;
import tools.AppSettings;
import view.Management;

public class ProfilePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JPasswordField passwordField;
	
	public ProfilePanel(Management c) {

		// JPanel this = new JPanel();
		// tabbedPane.addTab("Profil", null, this, null);
		this.setLayout(null);

		JLabel lblTitleProfile = new JLabel("Profil");
		lblTitleProfile.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleProfile.setBounds(681, 96, 59, 29);
		this.add(lblTitleProfile);

		JLabel lblUsernameProfile = new JLabel("Nom d'utilisateur");
		lblUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsernameProfile.setBounds(395, 202, 127, 20);
		this.add(lblUsernameProfile);

		JLabel lblPasswordProfile = new JLabel("Mot de passe");
		lblPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswordProfile.setBounds(395, 361, 92, 20);
		this.add(lblPasswordProfile);

		JLabel lblDateProfile = new JLabel("Profil cr\u00E9\u00E9 le 08/01/21");
		lblDateProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateProfile.setBounds(622, 609, 159, 14);
		this.add(lblDateProfile);

		JTextField textFieldUsernameProfile = new JTextField();
		textFieldUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUsernameProfile.setBounds(395, 233, 280, 36);
		this.add(textFieldUsernameProfile);
		textFieldUsernameProfile.setColumns(10);
		textFieldUsernameProfile.setEditable(false);
		var adminId = Integer.parseInt(AppSettings.get("loginUser"));
		var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
		textFieldUsernameProfile.setText(admin.getUserName());

		passwordField = new JPasswordField();
		passwordField.setBounds(395, 392, 280, 36);
		this.add(passwordField);
		passwordField.setEditable(false);
		// TODO 
		// Decryptage
		passwordField.setText(admin.getPassword());

		JButton btnAdminProfile = new JButton("Gestion Admin");
		btnAdminProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminProfile.setBounds(622, 508, 148, 36);
		this.add(btnAdminProfile);
		btnAdminProfile.setVisible(false);
		
		btnAdminProfile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				// TODO
				// Appel fonction BDD
			}

		});
		

		JButton btnCancelUsernameProfile = new JButton("Annuler");
		btnCancelUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelUsernameProfile.setBounds(897, 233, 148, 36);
		this.add(btnCancelUsernameProfile);
		btnCancelUsernameProfile.setVisible(false);
		

		JButton btnCancelPasswordProfile = new JButton("Annuler");
		btnCancelPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelPasswordProfile.setBounds(897, 392, 148, 36);
		this.add(btnCancelPasswordProfile);
		btnCancelPasswordProfile.setVisible(false);

		JButton btnEditUsernameProfile = new JButton("Modifier");
		btnEditUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditUsernameProfile.setBounds(726, 233, 148, 36);
		this.add(btnEditUsernameProfile);
		

		JButton btnEditPasswordProfile = new JButton("Modifier");
		btnEditPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditPasswordProfile.setBounds(726, 392, 148, 36);
		this.add(btnEditPasswordProfile);
		
		btnEditUsernameProfile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (btnEditUsernameProfile.getText().equals("Modifier")) {
					textFieldUsernameProfile.setEditable(true);
					btnCancelUsernameProfile.setVisible(true);
					btnEditUsernameProfile.setText("Enregistrer");
					
				}else if (btnEditUsernameProfile.getText().equals("Enregistrer")){
					textFieldUsernameProfile.setEditable(false);
					btnCancelUsernameProfile.setVisible(false);
					btnEditUsernameProfile.setText("Modifier");
				}
				// TODO
				// Appel fonction BDD
			}

		});
		
		btnEditPasswordProfile.addMouseListener(new MouseAdapter() {

			
			public void mouseClicked(MouseEvent e) {

				if (btnEditPasswordProfile.getText().equals("Modifier")) {
					passwordField.setEditable(true);
					btnCancelPasswordProfile.setVisible(true);
					btnEditPasswordProfile.setText("Enregistrer");
					
				}else if (btnEditPasswordProfile.getText().equals("Enregistrer")){
					passwordField.setEditable(false);
					btnCancelPasswordProfile.setVisible(false);
					btnEditPasswordProfile.setText("Modifier");
				}
				
				
				// TODO
				// Appel fonction BDD
			}

		});

		
		btnCancelUsernameProfile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				textFieldUsernameProfile.setEditable(false);
				btnCancelUsernameProfile.setVisible(false);
				btnEditUsernameProfile.setText("Modifier");
			}

		});
		
		btnCancelPasswordProfile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				passwordField.setEditable(false);
				btnCancelPasswordProfile.setVisible(false);
				btnEditPasswordProfile.setText("Modifier");
			}

		});
		
		
	}

}
