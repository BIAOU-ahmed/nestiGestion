package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProviderArticlePanel extends Tab{

	JComboBox comboBoxProvider;
	JComboBox comboBoxArticle;
	JTable tableArticleProvider;
	JButton btnAdd;
	JButton btnModify;
	JButton btnDelete;
	JTextField textFieldPrice;
	DefaultTableModel providerModel;
	Management mainContent;
	
	/**
	 * Create the panel.
	 */
	public ProviderArticlePanel(Management c) {
		mainContent =c;
		this.setLayout(null);

		refreshTab();


//		refreshTable(comboBoxProvider, providerModel);
	}

	/**
	 * refresh the table of items sold by the supplier select 
	 * @param comboBoxProvider
	 * @param providerModel
	 */
	public void refreshTable(JComboBox<String> comboBoxProvider, DefaultTableModel providerModel) {

		var sell = new Sell();
		List<Sell> sells = null;

		if (!comboBoxProvider.getSelectedItem().toString().isEmpty()) {
			sell.setProviderFromName(comboBoxProvider.getSelectedItem().toString());
			var providerId = sell.getIdProvider();
			sells = (new SellDAO()).findALLBy("idProvider", providerId);//
		} else {
			sells = new ArrayList<Sell>();
		}

		Useful.displaySell(sells, providerModel);

	}

	/**
	 * refresh provider combo box
	 */
	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALL();//
		comboBoxProvider.addItem("");
		provider.forEach(p -> {

			comboBoxProvider.addItem(p.getCompanyName());

		});
	}

	/**
	 * refresh articles combo box
	 */
	public void refreshArticle() {
		var article = (new ArticleDAO()).findALL();//

		article.forEach(a -> {

			comboBoxArticle.addItem(a.getId() + " - " + a.getConditioning().getConditioningName() + " de "
					+ +a.getAmount() + " " + a.getProduct().getProductName());

		});
	}

	@Override
	public void refreshTab() {
		super.refreshTab();
		

		JLabel lblTitleProviderArticle = new JLabel("Gestion Articles Fournisseurs");
		lblTitleProviderArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleProviderArticle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleProviderArticle.setBounds(100, 50, 500, 50);
		this.add(lblTitleProviderArticle);

		JLabel lblProvider = new JLabel("Fournisseur");
		lblProvider.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProvider.setBounds(200, 150, 300, 30);
		this.add(lblProvider);

		JLabel lblPrice = new JLabel("Prix (\u20AC)");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(200, 450, 300, 30);
		this.add(lblPrice);

		comboBoxProvider = new JComboBox();
		comboBoxProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProvider.setBounds(200, 180, 300, 40);
		this.add(comboBoxProvider);
		refreshProvider();

		textFieldPrice = new JTextField();
	
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrice.setBounds(250, 480, 200, 40);
		this.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		btnAdd = new JButton("Ajouter");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(50, 600, 150, 40);
		this.add(btnAdd);

		btnModify = new JButton("Modifier");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModify.setBounds(275, 600, 150, 40);
		this.add(btnModify);

		DefaultTableModel articleProvierModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Article", "Prix (Euros)" });

		JScrollPane scrollPaneArticleProvider = new JScrollPane();
		scrollPaneArticleProvider.setBounds(700, 100, 600, 550);
		this.add(scrollPaneArticleProvider);

		tableArticleProvider = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableArticleProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneArticleProvider.setViewportView(tableArticleProvider);

		providerModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Article", "Prix (en Euros)" });

		tableArticleProvider.setModel(providerModel);
		tableArticleProvider.getColumnModel().getColumn(0).setResizable(false);
		tableArticleProvider.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneArticleProvider.setViewportView(tableArticleProvider);

		JLabel lblArticle = new JLabel("Article");
		lblArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticle.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticle.setBounds(200, 300, 300, 30);
		this.add(lblArticle);

		comboBoxArticle = new JComboBox();
		comboBoxArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticle.setBounds(200, 330, 300, 40);
		this.add(comboBoxArticle);
		refreshArticle();

		JLabel lblTableTitle = new JLabel("Liste des articles vendus par le fournisseur");
		lblTableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTableTitle.setBounds(700, 50, 600, 30);
		this.add(lblTableTitle);

		btnDelete = new JButton("Supprimer");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(500, 600, 150, 40);
		add(btnDelete);
		setUpListener();
	}
	
	
	/**
	 * this function allows you to add an event listener 
	 * on all the elements on which you want to put an event
	 */
	public void setUpListener(){
		
		textFieldPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char testChar = e.getKeyChar();

				if ((!(Character.isDigit(testChar)) && !(e.getKeyChar() == KeyEvent.VK_PERIOD))
						|| ((textFieldPrice.getText().indexOf(".") != -1) && (e.getKeyChar() == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
			}
		});
		

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxProvider.getSelectedItem().toString().isEmpty() && !textFieldPrice.getText().isEmpty()) {
					var sell = new Sell();
//					var adminId = Integer.parseInt(AppSettings.get("loginUser"));
//					var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
					var article = comboBoxArticle.getSelectedItem().toString();
//					var provider = new Provider();
//					provider.s
					sell.setProviderFromName(comboBoxProvider.getSelectedItem().toString());
					sell.setIdArticle(Integer.parseInt(article.split(" - ")[0]));
//					sell.setIdProvider();
					sell.setPrice(Double.parseDouble(textFieldPrice.getText()));

					java.util.Date sqlDate = new java.util.Date();
					Date createDate = new Date(sqlDate.getTime());

					sell.setUpdateDate(createDate);

					sell.create();

					comboBoxArticle.setSelectedIndex(0);
					textFieldPrice.setText("");

					refreshTable(comboBoxProvider, providerModel);
				} else {
					JOptionPane.showMessageDialog(null, "required camp empty");
				}

			}
		});

		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tableArticleProvider.getSelectionModel().isSelectionEmpty()) {
					if (!comboBoxProvider.getSelectedItem().toString().isEmpty()
							&& !textFieldPrice.getText().isEmpty()) {
						var sell = new Sell();
//				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
//				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
						var article = comboBoxArticle.getSelectedItem().toString();
//				var provider = new Provider();
//				provider.s
						sell.setProviderFromName(comboBoxProvider.getSelectedItem().toString());
						sell.setIdArticle(Integer.parseInt(article.split(" - ")[0]));
//				sell.setIdProvider();
						sell.setPrice(Double.parseDouble(textFieldPrice.getText()));

						java.util.Date sqlDate = new java.util.Date();
						Date createDate = new Date(sqlDate.getTime());

						sell.setUpdateDate(createDate);

						sell.update();
						comboBoxProvider.setSelectedIndex(0);
						comboBoxArticle.setSelectedIndex(0);
						textFieldPrice.setText("");

						comboBoxProvider.setEnabled(true);
						comboBoxArticle.setEnabled(true);
						List<Sell> sells = (new SellDAO()).findALL();//
						Useful.displaySell(sells, providerModel);
						refreshTable(comboBoxProvider, providerModel);
					}
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tableArticleProvider.getSelectionModel().isSelectionEmpty()) {
					var sell = new Sell();
//				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
//				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);
					var article = comboBoxArticle.getSelectedItem().toString();
//				var provider = new Provider();
//				provider.s
					sell.setProviderFromName(comboBoxProvider.getSelectedItem().toString());
					sell.setIdArticle(Integer.parseInt(article.split(" - ")[0]));
//				sell.setIdProvider();
					sell.setPrice(Double.parseDouble(textFieldPrice.getText()));

					java.util.Date sqlDate = new java.util.Date();
					Date createDate = new Date(sqlDate.getTime());

					sell.setUpdateDate(createDate);

					sell.delete();
					comboBoxProvider.setSelectedIndex(0);
					comboBoxArticle.setSelectedIndex(0);
					textFieldPrice.setText("");

					comboBoxProvider.setEnabled(true);
					comboBoxArticle.setEnabled(true);
					refreshTable(comboBoxProvider, providerModel);
				}
			}
		});

		comboBoxProvider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTable(comboBoxProvider, providerModel);

			}
		});

		tableArticleProvider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tableArticleProvider.getSelectionModel().isSelectionEmpty()) {
					int row = tableArticleProvider.getSelectedRow();
					comboBoxArticle.setSelectedItem((String) providerModel.getValueAt(row, 0));
					textFieldPrice.setText(Double.toString((Double) providerModel.getValueAt(row, 1)));
					comboBoxProvider.setEnabled(false);
					comboBoxArticle.setEnabled(false);

				}
			}
		});
		
	}
}
