package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import component.ArticlePanel;
import component.DeliveryPanel;
import component.HistoryPanel;
import component.OrderPanel;
import component.ProductPanel;
import component.ProfilePanel;
import component.ProviderArticlePanel;
import component.ProviderPanel;
import component.UnitAndCondPanel;

public class Management extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	private HistoryPanel panelHistory;
	private DeliveryPanel panelDelivery;
	private OrderPanel panelOrder;
	private UnitAndCondPanel panelUnitAndCond;
	private ArticlePanel panelArticle;
	private ProductPanel panelProduct ;
	private ProviderPanel panelProvider;
	private ProviderArticlePanel panelProviderArticle;
	private ProfilePanel panelProfile;
	
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
	 * @return the tabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}



	public HistoryPanel getPanelHistory() {
		return panelHistory;
	}

	public DeliveryPanel getPanelDelivery() {
		return panelDelivery;
	}

	public OrderPanel getPanelOrder() {
		return panelOrder;
	}

	public UnitAndCondPanel getPanelUnitAndCond() {
		return panelUnitAndCond;
	}


	public ProviderPanel getPanelProvider() {
		return panelProvider;
	}

	public ProviderArticlePanel getPanelProviderArticle() {
		return panelProviderArticle;
	}


	public ProfilePanel getPanelProfile() {
		return panelProfile;
	}

	
	/**
	 * @return the panelProduct
	 */
	public ProductPanel getPanelProduct() {
		return panelProduct;
	}


	/**
	 * @return the comboBoxProductArticle
	 */
	public ArticlePanel getPanelArticle() {
		return panelArticle;
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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(new Dimension(10, 32767));
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// Onglet Historique Commande

		panelHistory = new HistoryPanel();
		tabbedPane.addTab("Historique Commande", null, panelHistory, null);

		// Onglet Gestion Livraison

		panelDelivery = new DeliveryPanel();
		tabbedPane.addTab("Gestion Livraison", null, panelDelivery, null);

		// Gestion Commande

		panelOrder = new OrderPanel();
		tabbedPane.addTab("Gestion Commande", null, panelOrder, null);

		// Gestion Article

		panelArticle = new ArticlePanel(this);
		tabbedPane.addTab("Gestion Article", null, panelArticle, null);

		// Gestion Produit
		panelProduct = new ProductPanel(this);
		tabbedPane.addTab("Gestion Produit", null, panelProduct, null);

		// Unite de mesure et Conditionnement

		panelUnitAndCond = new UnitAndCondPanel();
		tabbedPane.addTab("Unite de mesure et Conditionnement", null, panelUnitAndCond, null);

		// Gestion Fournisseur

		panelProvider = new ProviderPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panelProvider, null);

		// Gestion Articles Fournisseurs

		panelProviderArticle = new ProviderArticlePanel();
		tabbedPane.addTab("Gestion Articles Fournisseurs", null, panelProviderArticle, null);

		// Gestion Profil

		panelProfile = new ProfilePanel();
		tabbedPane.addTab("Profil", null, panelProfile, null);

	}
}
