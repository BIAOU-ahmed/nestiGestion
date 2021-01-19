package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfilePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfilePanel() {

		//JPanel this = new JPanel();
		//tabbedPane.addTab("Profil", null, this, null);
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
		
		JTextField textFieldPasswordProfile = new JTextField();
		textFieldPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPasswordProfile.setColumns(10);
		textFieldPasswordProfile.setBounds(395, 392, 280, 36);
		this.add(textFieldPasswordProfile);
		
		JButton btnAdminProfile = new JButton("Gestion Admin");
		btnAdminProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminProfile.setBounds(622, 508, 148, 36);
		this.add(btnAdminProfile);
		
		JButton btnEditUsernameProfile = new JButton("Modifier");
		btnEditUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditUsernameProfile.setBounds(726, 233, 148, 36);
		this.add(btnEditUsernameProfile);
		
		JButton btnEditPasswordProfile = new JButton("Modifier");
		btnEditPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditPasswordProfile.setBounds(726, 392, 148, 36);
		this.add(btnEditPasswordProfile);
		
		JButton btnCancelUsernameProfile = new JButton("Annuler");
		btnCancelUsernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelUsernameProfile.setBounds(897, 233, 148, 36);
		this.add(btnCancelUsernameProfile);
		
		JButton btnCancelPasswordProfile = new JButton("Annuler");
		btnCancelPasswordProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelPasswordProfile.setBounds(897, 392, 148, 36);
		this.add(btnCancelPasswordProfile);
		
	}

}
