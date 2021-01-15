package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;

public class Management extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTable table_2;
	private JTextField textField_3;
	private JTextField textFieldCompanyNameProvider;
	private JTextField textFieldLastNameProvider;
	private JTextField textFieldFirstNameProvider;
	private JTextField textFieldPhoneNumberProvider;
	private JTable tableSelectedProvider;
	private JTextField ProviderSearchBarField;
	private JTable ProviderTable;
	private JTextField textFieldSearchArticle;
	private JTable tableArticle;
	private JTextField textFieldWeightArticle;
	private JTextField textFieldQtyArticle;
	private JTable tableProviderListArticle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(new Dimension(10, 32767));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Historique Commande", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historique des commandes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(181, 11, 290, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fournisseur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 85, 74, 28);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 90, 127, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(585, 88, 137, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Etat livraison");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(608, 49, 84, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Num\u00E9ro de commande");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(255, 85, 137, 28);
		panel.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(402, 85, 156, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(836, 85, 548, 378);
		panel.add(table_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1289, 473, 95, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(836, 562, 127, 34);
		panel.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(1000, 562, 109, 34);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 142, 698, 558);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Numéro commande", "Fournisseur","Montant €", "Date commande","Date livraison","Statut" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestion Livraison", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestion Commande", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Gestion article", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblSearchArticle = new JLabel("Rechercher");
		lblSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearchArticle.setBounds(947, 23, 120, 29);
		panel_3.add(lblSearchArticle);
		
		textFieldSearchArticle = new JTextField();
		textFieldSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSearchArticle.setBounds(643, 63, 726, 40);
		panel_3.add(textFieldSearchArticle);
		textFieldSearchArticle.setColumns(10);
		
		JScrollPane scrollPaneArticle = new JScrollPane();
		scrollPaneArticle.setBounds(643, 142, 726, 560);
		panel_3.add(scrollPaneArticle);
		
		tableArticle = new JTable();
		tableArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneArticle.setViewportView(tableArticle);
		
		DefaultTableModel articleModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Produit","Conditionnement", "Stock","Poids", "Prix €", "Statut"});

		tableArticle.setModel(articleModel);
		tableArticle.getColumnModel().getColumn(0).setResizable(false);
		tableArticle.getColumnModel().getColumn(1).setResizable(false);
		tableArticle.getColumnModel().getColumn(2).setResizable(false);
		tableArticle.getColumnModel().getColumn(3).setResizable(false);
		tableArticle.getColumnModel().getColumn(4).setResizable(false);
		tableArticle.getColumnModel().getColumn(5).setResizable(false);
		tableArticle.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JLabel lblWeightArticle = new JLabel("Poids");
		lblWeightArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeightArticle.setBounds(291, 189, 46, 14);
		panel_3.add(lblWeightArticle);
		
		JLabel lblQtyArticle = new JLabel("Nombre");
		lblQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyArticle.setBounds(87, 189, 57, 14);
		panel_3.add(lblQtyArticle);
		
		JLabel lblProductsArticle = new JLabel("Produits");
		lblProductsArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductsArticle.setBounds(118, 64, 64, 14);
		panel_3.add(lblProductsArticle);
		
		JLabel lblConditioningArticle = new JLabel("Conditionnement");
		lblConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConditioningArticle.setBounds(397, 64, 126, 14);
		panel_3.add(lblConditioningArticle);
		
		JLabel lblStatusArticle = new JLabel("Statut");
		lblStatusArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusArticle.setBounds(487, 189, 46, 14);
		panel_3.add(lblStatusArticle);
		
		textFieldWeightArticle = new JTextField();
		textFieldWeightArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldWeightArticle.setBounds(246, 215, 131, 42);
		panel_3.add(textFieldWeightArticle);
		textFieldWeightArticle.setColumns(10);
		
		textFieldQtyArticle = new JTextField();
		textFieldQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyArticle.setBounds(39, 214, 152, 43);
		panel_3.add(textFieldQtyArticle);
		textFieldQtyArticle.setColumns(10);
		
		JComboBox comboBoxProductArticle = new JComboBox();
		comboBoxProductArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProductArticle.setBounds(39, 103, 219, 44);
		panel_3.add(comboBoxProductArticle);
		
		JComboBox comboBoxConditioningArticle = new JComboBox();
		comboBoxConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxConditioningArticle.setBounds(326, 103, 255, 44);
		panel_3.add(comboBoxConditioningArticle);
		
		JComboBox comboBoxStatutArticle = new JComboBox();
		comboBoxStatutArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatutArticle.setBounds(436, 215, 145, 40);
		panel_3.add(comboBoxStatutArticle);
		
		JButton btnAddArticle = new JButton("Ajouter");
		btnAddArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddArticle.setBounds(79, 286, 111, 40);
		panel_3.add(btnAddArticle);
		
		JButton btnEditArticle = new JButton("Modfifier");
		btnEditArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditArticle.setBounds(200, 286, 111, 40);
		panel_3.add(btnEditArticle);
		
		JButton btnAvailableArticle = new JButton("Disponible");
		btnAvailableArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAvailableArticle.setBounds(321, 286, 111, 40);
		panel_3.add(btnAvailableArticle);
		
		JButton btnRemoveArticle = new JButton("Retirer");
		btnRemoveArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveArticle.setBounds(442, 286, 111, 40);
		panel_3.add(btnRemoveArticle);
		
		JLabel lblProviderListArticle = new JLabel("Liste Fournisseurs");
		lblProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderListArticle.setBounds(200, 341, 191, 40);
		panel_3.add(lblProviderListArticle);
		
		JScrollPane scrollPaneProviderListArticle = new JScrollPane();
		scrollPaneProviderListArticle.setBounds(39, 392, 544, 275);
		panel_3.add(scrollPaneProviderListArticle);
		
		tableProviderListArticle = new JTable();
		tableProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneProviderListArticle.setViewportView(tableProviderListArticle);
		
		DefaultTableModel providerListArticleModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Entreprise", "Qté commandée","Qté reçue", "Stock","Prix €"});

		tableProviderListArticle.setModel(providerListArticleModel);
		tableProviderListArticle.getColumnModel().getColumn(0).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(1).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(2).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(3).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JButton btnOrderArticle = new JButton("Passer une commande");
		btnOrderArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrderArticle.setBounds(214, 687, 203, 35);
		panel_3.add(btnOrderArticle);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Gestion produit", null, panel_4, null);
		panel_4.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(809, 70, 571, 20);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(809, 132, 571, 492);
		panel_4.add(scrollPane_1);
		
		table_2 = new JTable();
		
		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Numéro commande", "Fournisseur","Montant €", "Date commande","Date livraison","Statut" });
		table_2.setModel(model2);
		scrollPane_1.setViewportView(table_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 160, 167, 20);
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblCompanyNameProvider = new JLabel("Nom d'entreprise");
		lblCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompanyNameProvider.setBounds(143, 59, 129, 23);
		panel_5.add(lblCompanyNameProvider);
		
		JLabel lblProviderTitleProvider = new JLabel("Fournisseur");
		lblProviderTitleProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderTitleProvider.setBounds(279, 17, 129, 23);
		panel_5.add(lblProviderTitleProvider);
		
		textFieldCompanyNameProvider = new JTextField();
		textFieldCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCompanyNameProvider.setBounds(109, 103, 192, 35);
		panel_5.add(textFieldCompanyNameProvider);
		textFieldCompanyNameProvider.setColumns(10);
		
		JLabel lblStatusProvider = new JLabel("Statut");
		lblStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusProvider.setBounds(458, 62, 47, 20);
		panel_5.add(lblStatusProvider);
		
		JComboBox comboBoxStatusProvider = new JComboBox();
		comboBoxStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatusProvider.setBounds(425, 103, 123, 35);
		panel_5.add(comboBoxStatusProvider);
		
		JLabel lblContactProvider = new JLabel("Contact");
		lblContactProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblContactProvider.setBounds(305, 162, 85, 35);
		panel_5.add(lblContactProvider);
		
		JLabel lblLastNameProvider = new JLabel("Nom");
		lblLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastNameProvider.setBounds(109, 224, 41, 14);
		panel_5.add(lblLastNameProvider);
		
		JLabel lblFirstNameProvider = new JLabel("Pr\u00E9nom");
		lblFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstNameProvider.setBounds(331, 224, 59, 14);
		panel_5.add(lblFirstNameProvider);
		
		JLabel lblPhoneNumberProvider = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumberProvider.setBounds(519, 224, 165, 14);
		panel_5.add(lblPhoneNumberProvider);
		
		textFieldLastNameProvider = new JTextField();
		textFieldLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLastNameProvider.setBounds(57, 261, 147, 35);
		panel_5.add(textFieldLastNameProvider);
		textFieldLastNameProvider.setColumns(10);
		
		textFieldFirstNameProvider = new JTextField();
		textFieldFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFirstNameProvider.setBounds(278, 261, 164, 35);
		panel_5.add(textFieldFirstNameProvider);
		textFieldFirstNameProvider.setColumns(10);
		
		textFieldPhoneNumberProvider = new JTextField();
		textFieldPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumberProvider.setBounds(508, 261, 176, 35);
		panel_5.add(textFieldPhoneNumberProvider);
		textFieldPhoneNumberProvider.setColumns(10);
		
		JButton btnAddProvider = new JButton("Ajouter");
		btnAddProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddProvider.setBounds(193, 329, 104, 35);
		panel_5.add(btnAddProvider);
		
		JButton btnEditProvider = new JButton("Modifier");
		btnEditProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditProvider.setBounds(425, 329, 104, 35);
		panel_5.add(btnEditProvider);
		
		JLabel lblSelectedCompanyNameProvider = new JLabel("L\u00E9gumes.fr");
		lblSelectedCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectedCompanyNameProvider.setBounds(305, 388, 126, 35);
		panel_5.add(lblSelectedCompanyNameProvider);
		
		JScrollPane scrollPaneSelectedProvider = new JScrollPane();
		scrollPaneSelectedProvider.setBounds(57, 427, 627, 249);
		panel_5.add(scrollPaneSelectedProvider);
		
		tableSelectedProvider = new JTable();
		tableSelectedProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneSelectedProvider.setViewportView(tableSelectedProvider);
		
		DefaultTableModel selectedCompanyModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Produit", "Conditionnement","Poids", "Prix fournisseur €"});

		tableSelectedProvider.setModel(selectedCompanyModel);
		tableSelectedProvider.getColumnModel().getColumn(0).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(1).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(2).setResizable(false);
		tableSelectedProvider.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JLabel ProviderSearchLabel = new JLabel("Rechercher");
		ProviderSearchLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ProviderSearchLabel.setBounds(1010, 11, 129, 35);
		panel_5.add(ProviderSearchLabel);
		
		ProviderSearchBarField = new JTextField();
		ProviderSearchBarField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ProviderSearchBarField.setBounds(771, 62, 595, 35);
		panel_5.add(ProviderSearchBarField);
		ProviderSearchBarField.setColumns(10);
		
		JRadioButton LastNameRadio = new JRadioButton("Nom");
		LastNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LastNameRadio.setBounds(992, 109, 73, 23);
		panel_5.add(LastNameRadio);
		
		JRadioButton FirstNameRadio = new JRadioButton("Pr\u00E9nom");
		FirstNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstNameRadio.setBounds(1067, 109, 85, 23);
		panel_5.add(FirstNameRadio);
		
		JRadioButton StatusRadio = new JRadioButton("Statut");
		StatusRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StatusRadio.setBounds(1154, 109, 73, 23);
		panel_5.add(StatusRadio);
		
		JRadioButton CompanyRadio = new JRadioButton("Entreprise");
		CompanyRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CompanyRadio.setBounds(886, 109, 104, 23);
		panel_5.add(CompanyRadio);
		
		JScrollPane ProviderScrollPanel = new JScrollPane();
		ProviderScrollPanel.setBounds(771, 146, 595, 565);
		panel_5.add(ProviderScrollPanel);
		
		ProviderTable = new JTable();
		ProviderTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProviderScrollPanel.setViewportView(ProviderTable);
		
		DefaultTableModel providerModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Entreprise","Nom", "Prénom","Téléphone","Statut" });

		ProviderTable.setModel(providerModel);
		ProviderTable.getColumnModel().getColumn(0).setResizable(false);
		ProviderTable.getColumnModel().getColumn(1).setResizable(false);
		ProviderTable.getColumnModel().getColumn(2).setResizable(false);
		ProviderTable.getColumnModel().getColumn(3).setResizable(false);
		ProviderTable.getColumnModel().getColumn(4).setResizable(false);
		ProviderTable.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JButton OrderButton = new JButton("Passer une commande");
		OrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OrderButton.setBounds(279, 688, 192, 34);
		panel_5.add(OrderButton);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Profil", null, panel_6, null);
	}
}
