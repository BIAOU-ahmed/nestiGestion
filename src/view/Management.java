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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumnModel;

import dao.MeasurementDAO;
import model.Measurement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

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

	private JTextField textFieldAmountReceived;
	private JTextField textFieldAmountExpected;
	private JTextField textFieldDeliveryDate;
	private JTable tableDelivery;
	private JTextField textFieldQtyOrder;
	private JTable tableOrder;
	private JTextField textField_4;

	private JTable productList;
	private JTextField libeleTxt;

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

		// Onglet Historique Commande

		JPanel panelHistory = new JPanel();
		tabbedPane.addTab("Historique Commande", null, panelHistory, null);
		panelHistory.setLayout(null);

		JLabel lblNewLabel = new JLabel("Historique des commandes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(181, 11, 290, 34);
		panelHistory.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fournisseur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 85, 74, 28);
		panelHistory.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 90, 127, 22);
		panelHistory.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(585, 88, 137, 22);
		panelHistory.add(comboBox_1);

		JLabel lblNewLabel_1_1 = new JLabel("Etat livraison");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(608, 49, 84, 28);
		panelHistory.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Num\u00E9ro de commande");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(255, 85, 137, 28);
		panelHistory.add(lblNewLabel_1_1_1);

		textField = new JTextField();
		textField.setBounds(402, 85, 156, 28);
		panelHistory.add(textField);
		textField.setColumns(10);

		table_1 = new JTable();
		table_1.setBounds(836, 85, 548, 378);
		panelHistory.add(table_1);

		textField_1 = new JTextField();
		textField_1.setBounds(1289, 473, 95, 34);
		panelHistory.add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(836, 562, 127, 34);
		panelHistory.add(comboBox_2);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(1000, 562, 109, 34);
		panelHistory.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 142, 698, 558);
		panelHistory.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);

		// Onglet Gestion Livraison

		JPanel panelDelivery = new JPanel();
		tabbedPane.addTab("Gestion Livraison", null, panelDelivery, null);
		panelDelivery.setLayout(null);

		JLabel lblTitleDelivery = new JLabel("R\u00E9ception des Articles");
		lblTitleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDelivery.setBounds(0, 50, 500, 70);
		panelDelivery.add(lblTitleDelivery);

		JComboBox comboBoxArticleDelivery = new JComboBox();
		comboBoxArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleDelivery.setBounds(25, 320, 250, 40);
		panelDelivery.add(comboBoxArticleDelivery);

		JComboBox comboBoxOrderNumberDelivery = new JComboBox();
		comboBoxOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberDelivery.setBounds(900, 30, 250, 40);
		panelDelivery.add(comboBoxOrderNumberDelivery);

		textFieldAmountReceived = new JTextField();
		textFieldAmountReceived.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountReceived.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountReceived.setBounds(325, 320, 75, 40);
		panelDelivery.add(textFieldAmountReceived);
		textFieldAmountReceived.setColumns(10);

		textFieldAmountExpected = new JTextField();
		textFieldAmountExpected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountExpected.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountExpected.setBounds(400, 320, 75, 40);
		panelDelivery.add(textFieldAmountExpected);
		textFieldAmountExpected.setColumns(10);

		textFieldDeliveryDate = new JTextField();
		textFieldDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDeliveryDate.setBounds(150, 470, 200, 40);
		panelDelivery.add(textFieldDeliveryDate);
		textFieldDeliveryDate.setColumns(10);

		JButton btnSaveDelivery = new JButton("Enregistrer");
		btnSaveDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveDelivery.setBounds(75, 600, 150, 40);
		panelDelivery.add(btnSaveDelivery);

		JButton btnDeleteDelivery = new JButton("Supprimer");
		btnDeleteDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteDelivery.setBounds(275, 600, 150, 40);
		panelDelivery.add(btnDeleteDelivery);

		JLabel lblProviderDelivery = new JLabel("Fournisseur");
		lblProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderDelivery.setBounds(100, 180, 300, 20);
		panelDelivery.add(lblProviderDelivery);

		JLabel lblArticleDelivery = new JLabel("Article");
		lblArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleDelivery.setBounds(25, 300, 250, 20);
		panelDelivery.add(lblArticleDelivery);

		JLabel lblAmountDelivery = new JLabel("Quantit\u00E9 re\u00E7ue/Command\u00E9e");
		lblAmountDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountDelivery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmountDelivery.setBounds(300, 300, 200, 14);
		panelDelivery.add(lblAmountDelivery);

		JLabel lblDeliveryDate = new JLabel("Date de livraison");
		lblDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeliveryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryDate.setBounds(150, 450, 200, 20);
		panelDelivery.add(lblDeliveryDate);

		JLabel lblOrderNumberDelivery = new JLabel("Num\u00E9ro de la commande");
		lblOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberDelivery.setBounds(700, 30, 200, 40);
		panelDelivery.add(lblOrderNumberDelivery);

		JScrollPane scrollPaneDelivery = new JScrollPane();
		scrollPaneDelivery.setBounds(500, 90, 850, 600);
		panelDelivery.add(scrollPaneDelivery);

		tableDelivery = new JTable();
		scrollPaneDelivery.setViewportView(tableDelivery);

		DefaultTableModel modelDelivery = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Produit", "Conditionnement", "Qté Commandée", "Qté reçue",
						"Prix €", "Date commande", "Date livraison" });

		tableDelivery.setModel(modelDelivery);
		tableDelivery.getColumnModel().getColumn(0).setResizable(false);
		tableDelivery.getColumnModel().getColumn(1).setResizable(false);
		tableDelivery.getColumnModel().getColumn(2).setResizable(false);
		tableDelivery.getColumnModel().getColumn(3).setResizable(false);
		tableDelivery.getColumnModel().getColumn(4).setResizable(false);
		tableDelivery.getColumnModel().getColumn(5).setResizable(false);
		tableDelivery.getColumnModel().getColumn(6).setResizable(false);
		tableDelivery.getColumnModel().getColumn(7).setResizable(false);
		scrollPaneDelivery.setViewportView(tableDelivery);

		JComboBox comboBoxProviderDelivery = new JComboBox();
		comboBoxProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProviderDelivery.setBounds(100, 200, 300, 40);
		panelDelivery.add(comboBoxProviderDelivery);

		// Gestion Commande

		JPanel panelOrder = new JPanel();
		tabbedPane.addTab("Gestion Commande", null, panelOrder, null);
		panelOrder.setLayout(null);

		JLabel lblTitle1Order = new JLabel("Passer une commande");
		lblTitle1Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1Order.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle1Order.setBounds(0, 50, 500, 70);
		panelOrder.add(lblTitle1Order);

		JLabel lblProviderOrder = new JLabel("Fournisseur");
		lblProviderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderOrder.setBounds(100, 180, 300, 20);
		panelOrder.add(lblProviderOrder);

		JLabel lblQtyOrder = new JLabel("Quantit\u00E9e");
		lblQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtyOrder.setBounds(350, 430, 100, 20);
		panelOrder.add(lblQtyOrder);

		JLabel lblArticleOrder = new JLabel("Article");
		lblArticleOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleOrder.setBounds(50, 430, 250, 20);
		panelOrder.add(lblArticleOrder);

		JLabel lblOrderNumberOrder = new JLabel("Num\u00E9ro de commande en cours");
		lblOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberOrder.setBounds(650, 30, 250, 40);
		panelOrder.add(lblOrderNumberOrder);

		JLabel lblTitle2Order = new JLabel("Ligne de Commande");
		lblTitle2Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2Order.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle2Order.setBounds(100, 320, 300, 40);
		panelOrder.add(lblTitle2Order);

		JButton btnAddOrder = new JButton("Ajouter");
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddOrder.setBounds(35, 600, 120, 40);
		panelOrder.add(btnAddOrder);

		JButton btnUpdateOrder = new JButton("Modifier");
		btnUpdateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateOrder.setBounds(190, 600, 120, 40);
		panelOrder.add(btnUpdateOrder);

		JButton btnDeleteOrder = new JButton("Supprimer");
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteOrder.setBounds(345, 600, 120, 40);
		panelOrder.add(btnDeleteOrder);

		JComboBox comboBoxOrderNumberOrder = new JComboBox();
		comboBoxOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberOrder.setBounds(900, 30, 250, 40);
		panelOrder.add(comboBoxOrderNumberOrder);

		JComboBox comboBoxProviderOrder = new JComboBox();
		comboBoxProviderOrder.setBounds(100, 200, 300, 40);
		panelOrder.add(comboBoxProviderOrder);

		JComboBox comboBoxArticleOrder = new JComboBox();
		comboBoxArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleOrder.setBounds(50, 450, 250, 40);
		panelOrder.add(comboBoxArticleOrder);

		textFieldQtyOrder = new JTextField();
		textFieldQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyOrder.setBounds(350, 450, 100, 40);
		panelOrder.add(textFieldQtyOrder);
		textFieldQtyOrder.setColumns(10);

		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(500, 90, 850, 550);
		panelOrder.add(scrollPaneOrder);

		tableOrder = new JTable();
		scrollPaneOrder.setViewportView(tableOrder);

		DefaultTableModel modelOrder = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Produit", "Conditionnement", "Qté Commandée", "Prix €" });

		tableOrder.setModel(modelOrder);
		tableOrder.getColumnModel().getColumn(0).setResizable(false);
		tableOrder.getColumnModel().getColumn(1).setResizable(false);
		tableOrder.getColumnModel().getColumn(2).setResizable(false);
		tableOrder.getColumnModel().getColumn(3).setResizable(false);
		tableOrder.getColumnModel().getColumn(4).setResizable(false);
		scrollPaneOrder.setViewportView(tableOrder);

		JButton btnOrderOrder = new JButton("Commander");
		btnOrderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrderOrder.setBounds(1200, 670, 150, 40);
		panelOrder.add(btnOrderOrder);

		textField_4 = new JTextField();
		textField_4.setBounds(1050, 670, 100, 40);
		panelOrder.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblTotalPriceOrder = new JLabel("Montant Total");
		lblTotalPriceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalPriceOrder.setBounds(900, 670, 150, 40);
		panelOrder.add(lblTotalPriceOrder);

		// Gestion Article

		JPanel panelArticle = new JPanel();
		tabbedPane.addTab("Gestion Article", null, panelArticle, null);
		panelArticle.setLayout(null);

		JLabel lblSearchArticle = new JLabel("Rechercher");
		lblSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearchArticle.setBounds(947, 23, 120, 29);
		panelArticle.add(lblSearchArticle);

		textFieldSearchArticle = new JTextField();
		textFieldSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSearchArticle.setBounds(643, 63, 726, 40);
		panelArticle.add(textFieldSearchArticle);
		textFieldSearchArticle.setColumns(10);

		JScrollPane scrollPaneArticle = new JScrollPane();
		scrollPaneArticle.setBounds(643, 142, 726, 560);
		panelArticle.add(scrollPaneArticle);

		tableArticle = new JTable();
		tableArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneArticle.setViewportView(tableArticle);

		DefaultTableModel articleModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Produit", "Conditionnement", "Stock", "Poids", "Prix �", "Statut" });

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
		panelArticle.add(lblWeightArticle);

		JLabel lblQtyArticle = new JLabel("Nombre");
		lblQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyArticle.setBounds(87, 189, 57, 14);
		panelArticle.add(lblQtyArticle);

		JLabel lblProductsArticle = new JLabel("Produits");
		lblProductsArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductsArticle.setBounds(118, 64, 64, 14);
		panelArticle.add(lblProductsArticle);

		JLabel lblConditioningArticle = new JLabel("Conditionnement");
		lblConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConditioningArticle.setBounds(397, 64, 126, 14);
		panelArticle.add(lblConditioningArticle);

		JLabel lblStatusArticle = new JLabel("Statut");
		lblStatusArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusArticle.setBounds(487, 189, 46, 14);
		panelArticle.add(lblStatusArticle);

		textFieldWeightArticle = new JTextField();
		textFieldWeightArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldWeightArticle.setBounds(246, 215, 131, 42);
		panelArticle.add(textFieldWeightArticle);
		textFieldWeightArticle.setColumns(10);

		textFieldQtyArticle = new JTextField();
		textFieldQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyArticle.setBounds(39, 214, 152, 43);
		panelArticle.add(textFieldQtyArticle);
		textFieldQtyArticle.setColumns(10);

		JComboBox comboBoxProductArticle = new JComboBox();
		comboBoxProductArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProductArticle.setBounds(39, 103, 219, 44);
		panelArticle.add(comboBoxProductArticle);

		JComboBox comboBoxConditioningArticle = new JComboBox();
		comboBoxConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxConditioningArticle.setBounds(326, 103, 255, 44);
		panelArticle.add(comboBoxConditioningArticle);

		JComboBox comboBoxStatutArticle = new JComboBox();
		comboBoxStatutArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatutArticle.setBounds(436, 215, 145, 40);
		panelArticle.add(comboBoxStatutArticle);

		JButton btnAddArticle = new JButton("Ajouter");
		btnAddArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddArticle.setBounds(79, 286, 111, 40);
		panelArticle.add(btnAddArticle);

		JButton btnEditArticle = new JButton("Modfifier");
		btnEditArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditArticle.setBounds(200, 286, 111, 40);
		panelArticle.add(btnEditArticle);

		JButton btnAvailableArticle = new JButton("Disponible");
		btnAvailableArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAvailableArticle.setBounds(321, 286, 111, 40);
		panelArticle.add(btnAvailableArticle);

		JButton btnRemoveArticle = new JButton("Retirer");
		btnRemoveArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveArticle.setBounds(442, 286, 111, 40);
		panelArticle.add(btnRemoveArticle);

		JLabel lblProviderListArticle = new JLabel("Liste Fournisseurs");
		lblProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderListArticle.setBounds(200, 341, 191, 40);
		panelArticle.add(lblProviderListArticle);

		JScrollPane scrollPaneProviderListArticle = new JScrollPane();
		scrollPaneProviderListArticle.setBounds(39, 392, 544, 275);
		panelArticle.add(scrollPaneProviderListArticle);

		tableProviderListArticle = new JTable();
		tableProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneProviderListArticle.setViewportView(tableProviderListArticle);

		DefaultTableModel providerListArticleModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Entreprise", "Qt� command�e", "Qt� re�ue", "Stock", "Prix �" });

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
		panelArticle.add(btnOrderArticle);

		// Gestion Produit

		JPanel panelProduct = new JPanel();
		tabbedPane.addTab("Gestion Produit", null, panelProduct, null);
		panelProduct.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(809, 70, 571, 20);
		panelProduct.add(textField_2);
		textField_2.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(809, 132, 571, 492);

		panelProduct.add(scrollPane_1);

		table_2 = new JTable();

		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });
		table_2.setModel(model2);
		scrollPane_1.setViewportView(table_2);

		textField_3 = new JTextField();
		textField_3.setBounds(95, 160, 167, 20);
		panelProduct.add(textField_3);
		textField_3.setColumns(10);

		panelProduct.add(scrollPane_1);

		productList = new JTable();

		DefaultTableModel productModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Libellé", "Type", "Unité", "Nb d'articles créés" });
		productList.setModel(productModel);
		scrollPane_1.setViewportView(productList);

		libeleTxt = new JTextField();
		libeleTxt.setBounds(95, 160, 185, 34);
		panelProduct.add(libeleTxt);
		libeleTxt.setColumns(10);

		JComboBox typeCombo = new JComboBox();
		DefaultComboBoxModel productType = new DefaultComboBoxModel(new String[] { "", "Ingredients", "Ustensils" });
		typeCombo.setModel(productType);
		JComboBox unityCombo = new JComboBox();

		typeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (typeCombo.getSelectedItem() == "Ingredients") {
//					Querys querys = new Querys();
//					querys.getUnitys(unityCombo);

					List<Measurement> unitys = (new MeasurementDAO()).findALL();//
					unitys.forEach(m -> {

						unityCombo.addItem(m.getUnit());

					});
					unityCombo.setEnabled(true);
				} else {
//		  					DefaultComboBoxModel unityModel = new DefaultComboBoxModel();
//		  					unityCombo.setModel(unityModel);
					unityCombo.removeAllItems();
					unityCombo.setEnabled(false);

				}

			}
		});

		typeCombo.setBounds(307, 160, 138, 34);
//		typeCombo.addItem(new ComboItem("Visible String 1", "Value 1"));

		panelProduct.add(typeCombo);

		unityCombo.setBounds(478, 160, 78, 34);
		panelProduct.add(unityCombo);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(150, 297, 104, 49);
		panelProduct.add(btnAdd);

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(308, 297, 104, 49);
		panelProduct.add(btnUpdate);

		JButton btnBlocked = new JButton("Retirer");
		btnBlocked.setBounds(452, 297, 104, 49);
		panelProduct.add(btnBlocked);

		JButton btnNewButton_1_3 = new JButton("New button");
		btnNewButton_1_3.setBounds(226, 424, 248, 77);
		panelProduct.add(btnNewButton_1_3);

		JLabel lblNewLabel_2 = new JLabel("Libell\u00E9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(95, 132, 78, 27);
		panelProduct.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(338, 132, 78, 27);
		panelProduct.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Unit\u00E9");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(478, 130, 78, 27);
		panelProduct.add(lblNewLabel_2_2);

		// Gestion Fournisseur

		JPanel panelProvider = new JPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panelProvider, null);
		panelProvider.setLayout(null);

		JLabel lblCompanyNameProvider = new JLabel("Nom d'entreprise");
		lblCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompanyNameProvider.setBounds(143, 59, 129, 23);
		panelProvider.add(lblCompanyNameProvider);

		JLabel lblProviderTitleProvider = new JLabel("Fournisseur");
		lblProviderTitleProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderTitleProvider.setBounds(279, 17, 129, 23);
		panelProvider.add(lblProviderTitleProvider);

		textFieldCompanyNameProvider = new JTextField();
		textFieldCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCompanyNameProvider.setBounds(109, 103, 192, 35);
		panelProvider.add(textFieldCompanyNameProvider);
		textFieldCompanyNameProvider.setColumns(10);

		JLabel lblStatusProvider = new JLabel("Statut");
		lblStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusProvider.setBounds(458, 62, 47, 20);
		panelProvider.add(lblStatusProvider);

		JComboBox comboBoxStatusProvider = new JComboBox();
		comboBoxStatusProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatusProvider.setBounds(425, 103, 123, 35);
		panelProvider.add(comboBoxStatusProvider);

		JLabel lblContactProvider = new JLabel("Contact");
		lblContactProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblContactProvider.setBounds(305, 162, 85, 35);
		panelProvider.add(lblContactProvider);

		JLabel lblLastNameProvider = new JLabel("Nom");
		lblLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastNameProvider.setBounds(109, 224, 41, 14);
		panelProvider.add(lblLastNameProvider);

		JLabel lblFirstNameProvider = new JLabel("Pr\u00E9nom");
		lblFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstNameProvider.setBounds(331, 224, 59, 14);
		panelProvider.add(lblFirstNameProvider);

		JLabel lblPhoneNumberProvider = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumberProvider.setBounds(519, 224, 165, 14);
		panelProvider.add(lblPhoneNumberProvider);

		textFieldLastNameProvider = new JTextField();
		textFieldLastNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLastNameProvider.setBounds(57, 261, 147, 35);
		panelProvider.add(textFieldLastNameProvider);
		textFieldLastNameProvider.setColumns(10);

		textFieldFirstNameProvider = new JTextField();
		textFieldFirstNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFirstNameProvider.setBounds(278, 261, 164, 35);
		panelProvider.add(textFieldFirstNameProvider);
		textFieldFirstNameProvider.setColumns(10);

		textFieldPhoneNumberProvider = new JTextField();
		textFieldPhoneNumberProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumberProvider.setBounds(508, 261, 176, 35);
		panelProvider.add(textFieldPhoneNumberProvider);
		textFieldPhoneNumberProvider.setColumns(10);

		JButton btnAddProvider = new JButton("Ajouter");
		btnAddProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddProvider.setBounds(193, 329, 104, 35);
		panelProvider.add(btnAddProvider);

		JButton btnEditProvider = new JButton("Modifier");
		btnEditProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditProvider.setBounds(425, 329, 104, 35);
		panelProvider.add(btnEditProvider);

		JLabel lblSelectedCompanyNameProvider = new JLabel("L\u00E9gumes.fr");
		lblSelectedCompanyNameProvider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectedCompanyNameProvider.setBounds(305, 388, 126, 35);
		panelProvider.add(lblSelectedCompanyNameProvider);

		JScrollPane scrollPaneSelectedProvider = new JScrollPane();
		scrollPaneSelectedProvider.setBounds(57, 427, 627, 249);
		panelProvider.add(scrollPaneSelectedProvider);

		tableSelectedProvider = new JTable();
		tableSelectedProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneSelectedProvider.setViewportView(tableSelectedProvider);

		DefaultTableModel selectedCompanyModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Produit", "Conditionnement", "Poids", "Prix fournisseur �" });

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
		panelProvider.add(ProviderSearchLabel);

		ProviderSearchBarField = new JTextField();
		ProviderSearchBarField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ProviderSearchBarField.setBounds(771, 62, 595, 35);
		panelProvider.add(ProviderSearchBarField);
		ProviderSearchBarField.setColumns(10);

		JRadioButton LastNameRadio = new JRadioButton("Nom");
		LastNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LastNameRadio.setBounds(992, 109, 73, 23);
		panelProvider.add(LastNameRadio);

		JRadioButton FirstNameRadio = new JRadioButton("Pr\u00E9nom");
		FirstNameRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstNameRadio.setBounds(1067, 109, 85, 23);
		panelProvider.add(FirstNameRadio);

		JRadioButton StatusRadio = new JRadioButton("Statut");
		StatusRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StatusRadio.setBounds(1154, 109, 73, 23);
		panelProvider.add(StatusRadio);

		JRadioButton CompanyRadio = new JRadioButton("Entreprise");
		CompanyRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CompanyRadio.setBounds(886, 109, 104, 23);
		panelProvider.add(CompanyRadio);

		JScrollPane ProviderScrollPanel = new JScrollPane();
		ProviderScrollPanel.setBounds(771, 146, 595, 565);
		panelProvider.add(ProviderScrollPanel);

		ProviderTable = new JTable();
		ProviderTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProviderScrollPanel.setViewportView(ProviderTable);

		DefaultTableModel providerModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Entreprise", "Nom", "Pr�nom", "T�l�phone", "Statut" });

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
		panelProvider.add(OrderButton);

		// Gestion Profil

		JPanel panelProfile = new JPanel();
		tabbedPane.addTab("Profil", null, panelProfile, null);
		// scrollPane.setColumnHeaderView(table);

	}
}
