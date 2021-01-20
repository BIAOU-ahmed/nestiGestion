package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
import model.Article;
import model.Product;
import model.Provider;
import model.Sell;
import tools.AppSettings;

public class ProviderArticlePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProviderArticlePanel() {

		this.setLayout(null);

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

		JComboBox comboBoxProvider = new JComboBox();
		comboBoxProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProvider.setBounds(200, 180, 300, 40);
		this.add(comboBoxProvider);

		JTextField textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrice.setBounds(250, 480, 200, 40);
		this.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(100, 600, 200, 40);
		this.add(btnAdd);

		JButton btnModify = new JButton("Modifier");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModify.setBounds(400, 600, 200, 40);
		this.add(btnModify);

		DefaultTableModel articleProvierModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Article", "Prix (Euros)" });

		JScrollPane scrollPaneArticleProvider = new JScrollPane();
		scrollPaneArticleProvider.setBounds(700, 100, 600, 550);
		this.add(scrollPaneArticleProvider);

		JTable tableArticleProvider = new JTable();
		tableArticleProvider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneArticleProvider.setViewportView(tableArticleProvider);

		DefaultTableModel providerModel = new DefaultTableModel(new Object[][] {,},
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

		JComboBox comboBoxArticle = new JComboBox();
		comboBoxArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticle.setBounds(200, 330, 300, 40);
		this.add(comboBoxArticle);

		JLabel lblTableTitle = new JLabel("Liste des articles vendus par le fournisseur");
		lblTableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTableTitle.setBounds(700, 50, 600, 30);
		this.add(lblTableTitle);
		
		List<Provider> providertList = (new ProviderDAO()).findALL();//
		providertList.forEach(p -> {

			comboBoxProvider.addItem(p.getCompanyName());

		});
		
		List<Article> articleList = (new ArticleDAO()).findALL();//
		articleList.forEach(a -> {

			comboBoxArticle.addItem(a.getId() +" - "+a.getProduct().getProductName() + " "+ a.getConditioning().getConditioningName()+" "+a.getAmount());

		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var sell = new Sell();
				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
				var admin = (new AdministratorDAO()).find(" 	idAdministrator", adminId);
				
				
//				sell.setIdArticle();
//				sell.setIdProvider();
//				sell.setPrice();
//				sell.setUpdateDate();
			
//				article.setWeight(Double.parseDouble(textFieldWeightArticle.getText()) );
//				article.setAmount(Integer.parseInt(textFieldQtyArticle.getText()) );
//				article.setArticleState(comboBoxStatutArticle.getSelectedItem().toString());
//				java.util.Date sqlDate = new java.util.Date(); 
//				Date createDate = new Date(sqlDate.getTime());
//				article.setCreatedAt(createDate);
//				article.setIdAdministrator(adminId);
//				article.setProductFromName(comboBoxProductArticle.getSelectedItem().toString());
//				article.setConditioningFromName(comboBoxConditioningArticle.getSelectedItem().toString());
//				admin.createArticle(article);

			}
		});
		
		
		
	}

}
