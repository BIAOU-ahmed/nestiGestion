package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ArticleDAO;
import dao.ProductDAO;
import dao.ProviderDAO;

import view.Management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeliveryPanel extends JPanel {
	JComboBox comboBoxArticleDelivery;
	JComboBox comboBoxProviderDelivery;

	/**
	 * Create the panel.
	 */
	public DeliveryPanel(Management c) {

		this.setLayout(null);

		JLabel lblTitleDelivery = new JLabel("R\u00E9ception des Articles");
		lblTitleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDelivery.setBounds(0, 50, 500, 70);
		this.add(lblTitleDelivery);

		comboBoxArticleDelivery = new JComboBox();
		comboBoxArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleDelivery.setBounds(25, 320, 250, 40);
		this.add(comboBoxArticleDelivery);
		refreshArticle();

		JComboBox comboBoxOrderNumberDelivery = new JComboBox();
		comboBoxOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberDelivery.setBounds(900, 30, 250, 40);
		this.add(comboBoxOrderNumberDelivery);

		JTextField textFieldAmountReceived = new JTextField();
		textFieldAmountReceived.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		textFieldAmountReceived.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountReceived.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountReceived.setBounds(325, 320, 75, 40);
		this.add(textFieldAmountReceived);
		textFieldAmountReceived.setColumns(10);

		JTextField textFieldAmountExpected = new JTextField();
		textFieldAmountExpected.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		textFieldAmountExpected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountExpected.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountExpected.setBounds(400, 320, 75, 40);
		this.add(textFieldAmountExpected);
		textFieldAmountExpected.setColumns(10);
		textFieldAmountExpected.setEditable(false);

		JTextField textFieldDeliveryDate = new JTextField();
		textFieldDeliveryDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE || e.getKeyCode() != KeyEvent.VK_DELETE) {
					var dateSize = textFieldDeliveryDate.getText();
					var dateFormat = formatDeliveryDate(dateSize);
					textFieldDeliveryDate.setText(dateFormat);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar)) || (textFieldDeliveryDate.getText().length() >= 8)) {
					e.consume();
				}
			}
		});
		textFieldDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDeliveryDate.setBounds(150, 470, 200, 40);
		this.add(textFieldDeliveryDate);
		textFieldDeliveryDate.setColumns(10);

		JButton btnSaveDelivery = new JButton("Enregistrer");
		btnSaveDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var amount = textFieldAmountReceived.getText().isEmpty();
				var date = textFieldDeliveryDate.getText().isEmpty();

				if (amount == false && date == false) {
					textFieldAmountReceived.setText("");
					textFieldDeliveryDate.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
				}

			}
		});
		btnSaveDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveDelivery.setBounds(75, 600, 150, 40);
		this.add(btnSaveDelivery);

		JButton btnDeleteDelivery = new JButton("Supprimer");
		btnDeleteDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var amount = textFieldAmountReceived.getText().isEmpty();
				var date = textFieldDeliveryDate.getText().isEmpty();

				if (amount == false && date == false) {
					textFieldAmountReceived.setText("");
					textFieldDeliveryDate.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
				}
			}
		});
		btnDeleteDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteDelivery.setBounds(275, 600, 150, 40);
		this.add(btnDeleteDelivery);

		JLabel lblProviderDelivery = new JLabel("Fournisseur");
		lblProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderDelivery.setBounds(100, 180, 300, 20);
		this.add(lblProviderDelivery);

		JLabel lblArticleDelivery = new JLabel("Article");
		lblArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleDelivery.setBounds(25, 300, 250, 20);
		this.add(lblArticleDelivery);

		JLabel lblAmountDelivery = new JLabel("Quantit\u00E9 re\u00E7ue/Command\u00E9e");
		lblAmountDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountDelivery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmountDelivery.setBounds(300, 300, 200, 14);
		this.add(lblAmountDelivery);

		JLabel lblDeliveryDate = new JLabel("Date de livraison");
		lblDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeliveryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryDate.setBounds(150, 450, 200, 20);
		this.add(lblDeliveryDate);

		JLabel lblOrderNumberDelivery = new JLabel("Num\u00E9ro de la commande");
		lblOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberDelivery.setBounds(700, 30, 200, 40);
		this.add(lblOrderNumberDelivery);

		JScrollPane scrollPaneDelivery = new JScrollPane();
		scrollPaneDelivery.setBounds(500, 90, 850, 600);
		this.add(scrollPaneDelivery);

		JTable tableDelivery = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneDelivery.setViewportView(tableDelivery);

		DefaultTableModel modelDelivery = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant",
				"Article", "Qté Commandée", "Qté reçue", "Prix €", "Date commande", "Date livraison" });

		tableDelivery.setModel(modelDelivery);
		tableDelivery.getColumnModel().getColumn(0).setResizable(false);
		tableDelivery.getColumnModel().getColumn(1).setResizable(false);
		tableDelivery.getColumnModel().getColumn(2).setResizable(false);
		tableDelivery.getColumnModel().getColumn(3).setResizable(false);
		tableDelivery.getColumnModel().getColumn(4).setResizable(false);
		tableDelivery.getColumnModel().getColumn(5).setResizable(false);
		tableDelivery.getColumnModel().getColumn(6).setResizable(false);
		scrollPaneDelivery.setViewportView(tableDelivery);

		comboBoxProviderDelivery = new JComboBox();
		comboBoxProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProviderDelivery.setBounds(100, 200, 300, 40);
		this.add(comboBoxProviderDelivery);
		refreshProvider();
	}

	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALL();//
		comboBoxProviderDelivery.removeAllItems();
		provider.forEach(p -> {

			comboBoxProviderDelivery.addItem(p.getCompanyName());

		});
	}

	public void refreshArticle() {
		var article = (new ArticleDAO()).findALL();//
		comboBoxArticleDelivery.removeAllItems();
		article.forEach(a -> {

			comboBoxArticleDelivery.addItem(a.getId() + " - " + a.getConditioning().getConditioningName() + " de "
					+ a.getAmount() + " " + a.getProduct().getProductName());

		});
	}

	private String formatDeliveryDate(String dateSize) {
		// TODO Auto-generated method stub
		String result = "";
		int i = 0;
		for (char c : dateSize.toCharArray()) {

			if (Character.isDigit(c)) {
				if (i % 2 == 0 && i != 0) {
					result += "/";
				}
				result += c;
				i++;
			}
		}
		return result;
	}
}
