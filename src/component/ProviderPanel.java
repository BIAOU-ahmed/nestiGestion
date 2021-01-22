package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import dao.SellDAO;
import model.Article;
import model.Product;
import model.Provider;
import model.Sell;
import tools.AppSettings;
import tools.Useful;
import view.Management;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;

public class ProviderPanel extends JPanel {
	DefaultTableModel providerModel;

	/**
	 * Create the panel.
	 */
	public ProviderPanel(Management mainController) {

		setLayout(null);
		JLabel lblCompanyNameProvider = new JLabel("Nom d'entreprise");
		lblCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompanyNameProvider.setBounds(143, 59, 129, 23);
		this.add(lblCompanyNameProvider);

		JLabel lblProviderTitleProvider = new JLabel("Fournisseur");
		lblProviderTitleProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderTitleProvider.setBounds(279, 17, 129, 23);
		this.add(lblProviderTitleProvider);

		JTextField textFieldCompanyNameProvider = new JTextField();
		textFieldCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCompanyNameProvider.setBounds(109, 103, 192, 35);
		this.add(textFieldCompanyNameProvider);
		textFieldCompanyNameProvider.setColumns(10);

		JLabel lblStatusProvider = new JLabel("Statut");
		lblStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusProvider.setBounds(458, 62, 47, 20);
		this.add(lblStatusProvider);

		JComboBox comboBoxStatusProvider = new JComboBox();
		comboBoxStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultComboBoxModel articleStatutsModel = new DefaultComboBoxModel(new String[] { "Disponible", "Inactif" });
		comboBoxStatusProvider.setModel(articleStatutsModel);
		comboBoxStatusProvider.setBounds(425, 103, 123, 35);
		this.add(comboBoxStatusProvider);

		JLabel lblContactProvider = new JLabel("Contact");
		lblContactProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblContactProvider.setBounds(305, 162, 85, 35);
		this.add(lblContactProvider);

		JLabel lblLastNameProvider = new JLabel("Nom");
		lblLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastNameProvider.setBounds(109, 224, 41, 14);
		this.add(lblLastNameProvider);

		JLabel lblFirstNameProvider = new JLabel("Pr\u00E9nom");
		lblFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstNameProvider.setBounds(331, 224, 59, 14);
		this.add(lblFirstNameProvider);

		JLabel lblPhoneNumberProvider = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumberProvider.setBounds(519, 224, 165, 14);
		this.add(lblPhoneNumberProvider);

		JTextField textFieldLastNameProvider = new JTextField();
		textFieldLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLastNameProvider.setBounds(57, 261, 147, 35);
		this.add(textFieldLastNameProvider);
		textFieldLastNameProvider.setColumns(10);

		JTextField textFieldFirstNameProvider = new JTextField();
		textFieldFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFirstNameProvider.setBounds(278, 261, 164, 35);
		this.add(textFieldFirstNameProvider);
		textFieldFirstNameProvider.setColumns(10);

		JTextField textFieldPhoneNumberProvider = new JTextField();
		textFieldPhoneNumberProvider.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar)) || (textFieldPhoneNumberProvider.getText().length() >= 14)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE || e.getKeyCode() != KeyEvent.VK_DELETE) {
					var textSize = textFieldPhoneNumberProvider.getText();
					var phoneFormat = formatPhoneNumber(textSize);
					// textFieldPhoneNumberProvider.setText(String.format("(%d{2})(%d{2})(%d+)",
					// textSize));
					textFieldPhoneNumberProvider.setText(phoneFormat);
				}
			}

		});

		textFieldPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumberProvider.setBounds(508, 261, 176, 35);
		this.add(textFieldPhoneNumberProvider);
		textFieldPhoneNumberProvider.setColumns(10);

		JButton btnAddProvider = new JButton("Ajouter");

		btnAddProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddProvider.setBounds(193, 329, 104, 35);
		this.add(btnAddProvider);

		JButton btnEditProvider = new JButton("Modifier");
		btnEditProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditProvider.setBounds(425, 329, 104, 35);
		this.add(btnEditProvider);

		JLabel lblSelectedCompanyNameProvider = new JLabel("Légumes.fr");
		lblSelectedCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectedCompanyNameProvider.setBounds(305, 388, 126, 35);
		this.add(lblSelectedCompanyNameProvider);

		JScrollPane scrollPaneSelectedProvider = new JScrollPane();
		scrollPaneSelectedProvider.setBounds(57, 427, 627, 249);
		this.add(scrollPaneSelectedProvider);

		JTable tableSelectedProvider = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableSelectedProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneSelectedProvider.setViewportView(tableSelectedProvider);

		DefaultTableModel selectedCompanyModel = new DefaultTableModel(new Object[][] {,},

				new String[] { "Identifiant", "Article", "Poids", "Prix fournisseur €" });

		tableSelectedProvider.setModel(selectedCompanyModel);
		tableSelectedProvider.getColumnModel().getColumn(0).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(1).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(2).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(3).setResizable(false);
//		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);

		JLabel ProviderSearchLabel = new JLabel("Rechercher");
		ProviderSearchLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ProviderSearchLabel.setBounds(1010, 11, 129, 35);
		this.add(ProviderSearchLabel);

		JTextField ProviderSearchBarField = new JTextField();
		ProviderSearchBarField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				var list = (new ProviderDAO()).findAllLike("compagnyName", ProviderSearchBarField.getText());
//				System.out.println(list.size());
				Useful.displayProvider(list, providerModel);

			}
		});
		ProviderSearchBarField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ProviderSearchBarField.setBounds(771, 62, 595, 35);
		this.add(ProviderSearchBarField);
		ProviderSearchBarField.setColumns(10);

		JRadioButton LastNameRadio = new JRadioButton("Nom");
		LastNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LastNameRadio.setBounds(992, 109, 73, 23);
		this.add(LastNameRadio);

		JRadioButton FirstNameRadio = new JRadioButton("Pr\u00E9nom");
		FirstNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstNameRadio.setBounds(1067, 109, 85, 23);
		this.add(FirstNameRadio);

		JRadioButton StatusRadio = new JRadioButton("Statut");
		StatusRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StatusRadio.setBounds(1154, 109, 73, 23);
		this.add(StatusRadio);

		JRadioButton CompanyRadio = new JRadioButton("Entreprise");
		CompanyRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CompanyRadio.setBounds(886, 109, 104, 23);
		this.add(CompanyRadio);

		JScrollPane ProviderScrollPanel = new JScrollPane();

		ProviderScrollPanel.setBounds(771, 146, 595, 565);
		this.add(ProviderScrollPanel);

		JTable ProviderTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		ProviderTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProviderScrollPanel.setViewportView(ProviderTable);

		providerModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Entreprise", "Nom", "Prénom", "Téléphone", "Statut" });

		ProviderTable.setModel(providerModel);
		ProviderTable.getColumnModel().getColumn(0).setResizable(false);
		ProviderTable.getColumnModel().getColumn(1).setResizable(false);
		ProviderTable.getColumnModel().getColumn(2).setResizable(false);
		ProviderTable.getColumnModel().getColumn(3).setResizable(false);
		ProviderTable.getColumnModel().getColumn(4).setResizable(false);
		ProviderTable.getColumnModel().getColumn(5).setResizable(false);
//		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);

		JButton OrderButton = new JButton("Passer une commande");
		OrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OrderButton.setBounds(255, 687, 250, 34);
		this.add(OrderButton);

		btnAddProvider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				var compName = textFieldCompanyNameProvider.getText().isEmpty();
				var lastName = textFieldLastNameProvider.getText().isEmpty();
				var firstName = textFieldFirstNameProvider.getText().isEmpty();
				var phoneNumber = textFieldPhoneNumberProvider.getText().isEmpty();

				if (compName == false && lastName == false && firstName == false && phoneNumber == false) {

					Provider newProvider = new Provider();
					var adminId = Integer.parseInt(AppSettings.get("loginUser"));
					var admin = (new AdministratorDAO()).find("idAdministrator", adminId);

					newProvider.setCompanyName(textFieldCompanyNameProvider.getText());
					newProvider.setContactLastName(textFieldLastNameProvider.getText());
					newProvider.setContactFirstName(textFieldFirstNameProvider.getText());
					newProvider.setProviderState(comboBoxStatusProvider.getSelectedItem().toString());
					newProvider.setContactPhoneNumber(textFieldPhoneNumberProvider.getText());
					newProvider.setIdAdministrator(adminId);
					admin.createProvider(newProvider);
					List<Provider> updateProvider = (new ProviderDAO()).findALL();//
					Useful.displayProvider(updateProvider, providerModel);

				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
				}

			}
		});

		btnEditProvider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				var compName = textFieldCompanyNameProvider.getText().isEmpty();
				var lastName = textFieldLastNameProvider.getText().isEmpty();
				var firstName = textFieldFirstNameProvider.getText().isEmpty();
				var phoneNumber = textFieldPhoneNumberProvider.getText().isEmpty();

				if (compName == false && lastName == false && firstName == false && phoneNumber == false) {

					if (!ProviderTable.getSelectionModel().isSelectionEmpty()) {
						Provider newProvider = new Provider();
						var adminId = Integer.parseInt(AppSettings.get("loginUser"));
						var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
						int row = ProviderTable.getSelectedRow();

						
						newProvider.setId((Integer) providerModel.getValueAt(row, 0));
						newProvider.setCompanyName(textFieldCompanyNameProvider.getText());
						newProvider.setContactLastName(textFieldLastNameProvider.getText());
						newProvider.setContactFirstName(textFieldFirstNameProvider.getText());
						newProvider.setProviderState(comboBoxStatusProvider.getSelectedItem().toString());
						newProvider.setContactPhoneNumber(textFieldPhoneNumberProvider.getText());
						newProvider.setIdAdministrator(adminId);
						admin.updateProvider(newProvider);
						List<Provider> updateProvider = (new ProviderDAO()).findALL();//
						Useful.displayProvider(updateProvider, providerModel);

						textFieldCompanyNameProvider.setText("");
						textFieldLastNameProvider.setText("");
						textFieldFirstNameProvider.setText("");
						comboBoxStatusProvider.setSelectedIndex(0);
						textFieldPhoneNumberProvider.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
				}
			}
		});

		OrderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tableSelectedProvider.getSelectionModel().isSelectionEmpty()) {
//					System.out.println("oui in the dd");

					int row = tableSelectedProvider.getSelectedRow();
					int providerRow = ProviderTable.getSelectedRow();
//					libeleTxt.setText((String) productModel.getValueAt(row, 1));
////					String t = ((String) productModel.getValueAt(row, 1));
					var a = (new ArticleDAO()).find("idArticle", tableSelectedProvider.getValueAt(row, 0));
					String article = a.getId() + " - " + a.getProduct().getProductName() + " "
							+ a.getConditioning().getConditioningName() + " " + a.getAmount();
//					System.out.println(p);
					mainController.getTabbedPane().setSelectedIndex(2);
					mainController.getPanelOrder().getComboBoxProviderOrder()
							.setSelectedItem(providerModel.getValueAt(providerRow, 1));
					;
					mainController.getPanelOrder().getComboBoxArticleOrder().setSelectedItem(article);

				} else {
					JOptionPane.showMessageDialog(null, "Select product first");
				}

				textFieldCompanyNameProvider.setText("");
				textFieldLastNameProvider.setText("");
				textFieldFirstNameProvider.setText("");
				comboBoxStatusProvider.setSelectedIndex(0);
				textFieldPhoneNumberProvider.setText("");
//				
			}
		});

		ProviderTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ProviderTable.getSelectionModel().isSelectionEmpty()) {
					int row = ProviderTable.getSelectedRow();
					textFieldLastNameProvider.setText((String) providerModel.getValueAt(row, 2));
					textFieldFirstNameProvider.setText((String) providerModel.getValueAt(row, 3));
					textFieldPhoneNumberProvider.setText(formatPhoneNumber((String) providerModel.getValueAt(row, 4)));
					textFieldCompanyNameProvider.setText((String) providerModel.getValueAt(row, 1));
					comboBoxStatusProvider.setSelectedItem((String) providerModel.getValueAt(row, 5));

					lblSelectedCompanyNameProvider.setText((String) providerModel.getValueAt(row, 1));
					List<Sell> acticleSells = (new SellDAO()).findALLBy("idProvider",
							((Integer) providerModel.getValueAt(row, 0)));//
					Useful.displayProviderSell(acticleSells, selectedCompanyModel);

				}
			}
		});

		List<Provider> updateProvider = (new ProviderDAO()).findALL();//
		Useful.displayProvider(updateProvider, providerModel);

	}

	private String formatPhoneNumber(String textSize) {
		// TODO Auto-generated method stub
		String result = "";
		int i = 0;
		for (char c : textSize.toCharArray()) {

			if (Character.isDigit(c)) {
				if (i % 2 == 0 && i != 0) {
					result += " ";
				}
				result += c;
				i++;
			}

		}
		return result;
	}

}
