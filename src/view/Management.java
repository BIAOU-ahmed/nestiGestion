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

import dao.MeasurementDAO;
import model.Measurement;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;

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

		JPanel panel = new JPanel();
		tabbedPane.addTab("Historique Commande", null, panel, null);
		panel.setLayout(null);


		JLabel lblNewLabel = new JLabel("Historique des commandes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(181, 11, 290, 34);

		panelHistory.add(lblNewLabel);

		panel.add(lblNewLabel);


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

		panelHistory.add(lblNewLabel_1_1);

		panel.add(lblNewLabel_1_1);


		JLabel lblNewLabel_1_1_1 = new JLabel("Num\u00E9ro de commande");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(255, 85, 137, 28);

		panelHistory.add(lblNewLabel_1_1_1);

		panel.add(lblNewLabel_1_1_1);


		textField = new JTextField();
		textField.setBounds(402, 85, 156, 28);
		panelHistory.add(textField);
		textField.setColumns(10);

		table_1 = new JTable();
		table_1.setBounds(836, 85, 548, 378);

		panelHistory.add(table_1);

		panel.add(table_1);


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

		panel.add(comboBox_2);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(1000, 562, 109, 34);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 142, 698, 558);
		panel.add(scrollPane);


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
				new String[] { "Identifiant", "Produit", "Conditionnement", "Qté Commandée", "Qté reçue", "Prix €",
						"Date commande", "Date livraison" });

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

		// Gestion Produit

		JPanel panelProduct = new JPanel();
		tabbedPane.addTab("Gestion Produit", null, panelProduct, null);
		panelProduct.setLayout(null);

//		scrollPane.setColumnHeaderView(table);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestion Livraison", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestion Commande", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Gestion article", null, panel_3, null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Gestion produit", null, panel_4, null);
		panel_4.setLayout(null);


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

		// Gestion Fournisseur

		JPanel panelProvider = new JPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panelProvider, null);

		// Gestion Profil

		JPanel panelProfile = new JPanel();
		tabbedPane.addTab("Profil", null, panelProfile, null);
		// scrollPane.setColumnHeaderView(table);


		panel_4.add(scrollPane_1);

		productList = new JTable();

		DefaultTableModel productModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Libellé", "Type", "Unité", "Nb d'articles créés" });
		productList.setModel(productModel);
		scrollPane_1.setViewportView(productList);

		libeleTxt = new JTextField();
		libeleTxt.setBounds(95, 160, 185, 34);
		panel_4.add(libeleTxt);
		libeleTxt.setColumns(10);

		JComboBox typeCombo = new JComboBox();
		DefaultComboBoxModel productType = new DefaultComboBoxModel(new String[] { "","Ingredients", "Ustensils" });
		typeCombo.setModel(productType);
		JComboBox unityCombo = new JComboBox();
		
		typeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (typeCombo.getSelectedItem() == "Ingredients") {
//					Querys querys = new Querys();
//					querys.getUnitys(unityCombo);
					
					List<Measurement> unitys =(new MeasurementDAO()).findALL();//
					unitys.forEach(m->{
						
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

		panel_4.add(typeCombo);

		

		unityCombo.setBounds(478, 160, 78, 34);
		panel_4.add(unityCombo);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(150, 297, 104, 49);
		panel_4.add(btnAdd);

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(308, 297, 104, 49);
		panel_4.add(btnUpdate);

		JButton btnBlocked = new JButton("Retirer");
		btnBlocked.setBounds(452, 297, 104, 49);
		panel_4.add(btnBlocked);

		JButton btnNewButton_1_3 = new JButton("New button");
		btnNewButton_1_3.setBounds(226, 424, 248, 77);
		panel_4.add(btnNewButton_1_3);

		JLabel lblNewLabel_2 = new JLabel("Libell\u00E9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(95, 132, 78, 27);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(338, 132, 78, 27);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Unit\u00E9");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(478, 130, 78, 27);
		panel_4.add(lblNewLabel_2_2);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panel_5, null);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Profil", null, panel_6, null);

	}
}
