package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import view.Management;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnitAndCondPanel extends Tab {
	JButton btnAddUnit;
	JButton btnModifyUnit;
	JButton btnModifyCond;
	JButton btnAddCond;
	Management mainContent;
	
	/**
	 * Create the panel.
	 */
	public UnitAndCondPanel(Management c) {
		mainContent=c;
		setLayout(null);
		refreshTab();

	}

	@Override
	public void refreshTab() {

		JLabel lblTitleUnit = new JLabel("Unit\u00E9 de mesure");
		lblTitleUnit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleUnit.setBounds(0, 50, 705, 40);
		this.add(lblTitleUnit);

		JLabel lblTitleCond = new JLabel("Conditionnement");
		lblTitleCond.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleCond.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleCond.setBounds(705, 50, 705, 40);
		this.add(lblTitleCond);

		JLabel lblUnit = new JLabel("Nouvelle unit\u00E9 de mesure :");
		lblUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUnit.setBounds(200, 150, 300, 30);
		this.add(lblUnit);

		JLabel lblCond = new JLabel("Nouveau conditionnement :");
		lblCond.setHorizontalAlignment(SwingConstants.CENTER);
		lblCond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCond.setBounds(905, 150, 300, 30);
		this.add(lblCond);

		JTextField textFieldUnit = new JTextField();
		textFieldUnit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUnit.setBounds(200, 180, 300, 40);
		this.add(textFieldUnit);
		textFieldUnit.setColumns(10);

		JTextField textFieldCond = new JTextField();
		textFieldCond.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCond.setBounds(905, 180, 300, 40);
		this.add(textFieldCond);
		textFieldCond.setColumns(10);

		JScrollPane scrollPaneUnit = new JScrollPane();
		scrollPaneUnit.setBounds(200, 400, 300, 300);
		this.add(scrollPaneUnit);

		JTable tableUnit = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneUnit.setViewportView(tableUnit);

		DefaultTableModel unitModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Unite" });

		tableUnit.setModel(unitModel);
		tableUnit.getColumnModel().getColumn(0).setResizable(false);
		tableUnit.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneUnit.setViewportView(tableUnit);

		JScrollPane scrollPaneCond = new JScrollPane();
		scrollPaneCond.setBounds(905, 400, 300, 300);
		this.add(scrollPaneCond);

		JTable tableCond = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneCond.setViewportView(tableCond);

		DefaultTableModel condModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Conditionnement" });

		tableCond.setModel(condModel);
		tableCond.getColumnModel().getColumn(0).setResizable(false);
		tableCond.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneCond.setViewportView(tableCond);

		btnAddUnit = new JButton("Cr\u00E9er");

		btnAddUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddUnit.setBounds(150, 250, 150, 30);
		this.add(btnAddUnit);

		btnModifyUnit = new JButton("Modifier");
		btnModifyUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifyUnit.setBounds(400, 250, 150, 30);
		this.add(btnModifyUnit);

		btnAddCond = new JButton("Cr\u00E9er");
		btnAddCond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCond.setBounds(855, 250, 150, 30);
		this.add(btnAddCond);

		btnModifyCond = new JButton("Modifier");
		btnModifyCond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifyCond.setBounds(1105, 250, 150, 30);
		this.add(btnModifyCond);

		JLabel lblUnitTable = new JLabel("Liste des unit\u00E9s de mesure");
		lblUnitTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnitTable.setBounds(200, 350, 300, 50);
		this.add(lblUnitTable);

		JLabel lblCondTable = new JLabel("Liste des conditionnements");
		lblCondTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblCondTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCondTable.setBounds(905, 350, 300, 50);
		this.add(lblCondTable);
		setUpListener();
	}

	public void setUpListener() {

		btnAddUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAddCond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		btnAddUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
