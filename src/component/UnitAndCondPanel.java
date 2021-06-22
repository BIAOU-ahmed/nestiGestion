package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ArticleDAO;
import dao.ConditioningDAO;
import dao.MeasurementDAO;
import model.Article;
import model.Conditioning;
import model.Measurement;
import model.OrderLine;
import view.Management;
import java.util.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UnitAndCondPanel extends Tab {
	JButton btnAddUnit;
	JButton btnModifyUnit;
	JButton btnModifyCond;
	JButton btnAddCond;
	Management mainContent;
	JTable tableUnit;
	DefaultTableModel unitModel;
	JTextField textFieldUnit;
	JTextField textFieldCond;
	DefaultTableModel condModel;
	JTable tableCond;
	
	/**
	 * Create the panel.
	 * 
	 * @param c the management panel
	 */
	public UnitAndCondPanel(Management c) {
		this.mainContent = c;
		setLayout(null);
		refreshTab();

	}

	@Override
	public void refreshTab() {
		super.refreshTab();

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

		textFieldUnit = new JTextField();
		textFieldUnit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUnit.setBounds(200, 180, 300, 40);
		this.add(textFieldUnit);
		textFieldUnit.setColumns(10);

		textFieldCond = new JTextField();
		textFieldCond.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCond.setBounds(905, 180, 300, 40);
		this.add(textFieldCond);
		textFieldCond.setColumns(10);

		JScrollPane scrollPaneUnit = new JScrollPane();

		scrollPaneUnit.setBounds(200, 400, 300, 300);
		this.add(scrollPaneUnit);

		tableUnit = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneUnit.setViewportView(tableUnit);

		unitModel = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant", "Unite" });

		tableUnit.setModel(unitModel);
		tableUnit.getColumnModel().getColumn(0).setResizable(false);
		tableUnit.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneUnit.setViewportView(tableUnit);

		JScrollPane scrollPaneCond = new JScrollPane();
		scrollPaneCond.setBounds(905, 400, 300, 300);
		this.add(scrollPaneCond);

		tableCond = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneCond.setViewportView(tableCond);

		condModel = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant", "Conditionnement" });

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
		List<Measurement> unitList = (new MeasurementDAO()).findALL();
		refreshUnitTable(unitList);
		
		List<Conditioning> condList = (new ConditioningDAO()).findALL();
		refreshConditioningTable(condList);
	}

	/**
	 * refresh the unit list table
	 * 
	 * @param articles array of articles
	 */
	public void refreshUnitTable(List<Measurement> mesurements) {
		unitModel.setRowCount(0);
		mesurements.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			unitModel.addRow(row1);

		});

	}

	/**
	 * refresh the conditioning list table
	 * 
	 * @param articles array of articles
	 */
	public void refreshConditioningTable(List<Conditioning> conditioning) {
		condModel.setRowCount(0);
		conditioning.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			condModel.addRow(row1);

		});

	}

	/**
	 * this function allows you to add an event listener on all the elements on
	 * which you want to put an event
	 */
	public void setUpListener() {

		btnAddUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var unit = textFieldUnit.getText().isEmpty();

				if (unit == false) {
					Measurement measurement = new Measurement();
					measurement.setUnit(textFieldUnit.getText());
					measurement.createMeasurementUnit();
					List<Measurement> unitList = (new MeasurementDAO()).findALL();
					refreshUnitTable(unitList);
					textFieldUnit.setText("");
				} else {
					JOptionPane.showInternalMessageDialog(null, "Tous les champs ne sont pas remplis.", "Champs vide",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		btnModifyUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tableUnit.getSelectionModel().isSelectionEmpty()) {
					int row = tableUnit.getSelectedRow();
					Measurement measurement = new Measurement();
					measurement.setId(Integer.parseInt(tableUnit.getValueAt(row, 0).toString()));
					measurement.setUnit(textFieldUnit.getText());
					measurement.updateMeasurement();
					List<Measurement> unitList = (new MeasurementDAO()).findALL();
					refreshUnitTable(unitList);
					textFieldUnit.setText("");
				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner une unité",
							"Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		tableUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!tableUnit.getSelectionModel().isSelectionEmpty()) {
					int row = tableUnit.getSelectedRow();

					textFieldUnit.setText(tableUnit.getValueAt(row, 1).toString());

				}
			}
		});

		btnAddCond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				var cond = textFieldCond.getText().isEmpty();

				if (cond == false) {
					Conditioning conditioning = new Conditioning();
					conditioning.setConditioningName(textFieldCond.getText());
					conditioning.createconditioning();
					List<Conditioning> condList = (new ConditioningDAO()).findALL();
					refreshConditioningTable(condList);
					textFieldCond.setText("");
				} else {
					JOptionPane.showInternalMessageDialog(null, "Tous les champs ne sont pas remplis.", "Champs vide",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		tableCond.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!tableCond.getSelectionModel().isSelectionEmpty()) {
					int row = tableCond.getSelectedRow();

					textFieldCond.setText(tableCond.getValueAt(row, 1).toString());

				}
			}
		});
		
		
		btnModifyCond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tableCond.getSelectionModel().isSelectionEmpty()) {
					int row = tableCond.getSelectedRow();
					
					Conditioning conditioning = new Conditioning();
					conditioning.setId(Integer.parseInt(tableCond.getValueAt(row, 0).toString()));
					conditioning.setConditioningName(textFieldCond.getText());
					conditioning.updateconditioning();
					List<Conditioning> condList = (new ConditioningDAO()).findALL();
					refreshConditioningTable(condList);
					textFieldCond.setText("");
				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner un Conditionnement",
							"Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		
		
	}
}
