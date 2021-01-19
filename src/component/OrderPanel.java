package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class OrderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrderPanel() {

		this.setLayout(null);

		JLabel lblTitle1Order = new JLabel("Passer une commande");
		lblTitle1Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1Order.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle1Order.setBounds(0, 50, 500, 70);
		this.add(lblTitle1Order);

		JLabel lblProviderOrder = new JLabel("Fournisseur");
		lblProviderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderOrder.setBounds(100, 180, 300, 20);
		this.add(lblProviderOrder);

		JLabel lblQtyOrder = new JLabel("Quantit\u00E9e");
		lblQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtyOrder.setBounds(350, 430, 100, 20);
		this.add(lblQtyOrder);

		JLabel lblArticleOrder = new JLabel("Article");
		lblArticleOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleOrder.setBounds(50, 430, 250, 20);
		this.add(lblArticleOrder);

		JLabel lblOrderNumberOrder = new JLabel("Num\u00E9ro de commande en cours");
		lblOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberOrder.setBounds(650, 30, 250, 40);
		this.add(lblOrderNumberOrder);

		JLabel lblTitle2Order = new JLabel("Ligne de Commande");
		lblTitle2Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2Order.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle2Order.setBounds(100, 320, 300, 40);
		this.add(lblTitle2Order);

		JButton btnAddOrder = new JButton("Ajouter");
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddOrder.setBounds(35, 600, 120, 40);
		this.add(btnAddOrder);

		JButton btnUpdateOrder = new JButton("Modifier");
		btnUpdateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateOrder.setBounds(190, 600, 120, 40);
		this.add(btnUpdateOrder);

		JButton btnDeleteOrder = new JButton("Supprimer");
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteOrder.setBounds(345, 600, 120, 40);
		this.add(btnDeleteOrder);

		JComboBox comboBoxOrderNumberOrder = new JComboBox();
		comboBoxOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberOrder.setBounds(900, 30, 250, 40);
		this.add(comboBoxOrderNumberOrder);

		JComboBox comboBoxProviderOrder = new JComboBox();
		comboBoxProviderOrder.setBounds(100, 200, 300, 40);
		this.add(comboBoxProviderOrder);

		JComboBox comboBoxArticleOrder = new JComboBox();
		comboBoxArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleOrder.setBounds(50, 450, 250, 40);
		this.add(comboBoxArticleOrder);

		JTextField textFieldQtyOrder = new JTextField();
		textFieldQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyOrder.setBounds(350, 450, 100, 40);
		this.add(textFieldQtyOrder);
		textFieldQtyOrder.setColumns(10);

		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(500, 90, 850, 550);
		this.add(scrollPaneOrder);

		JTable tableOrder = new JTable();
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
		this.add(btnOrderOrder);
		
		JTextField textFieldTotalPrice = new JTextField();
		textFieldTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPrice.setBounds(1050, 670, 100, 40);
		this.add(textFieldTotalPrice);
		textFieldTotalPrice.setColumns(10);

		JLabel lblTotalPriceOrder = new JLabel("Montant Total");
		lblTotalPriceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalPriceOrder.setBounds(900, 670, 150, 40);
		this.add(lblTotalPriceOrder);
		
	}

}
