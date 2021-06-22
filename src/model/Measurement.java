package model;

import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import dao.ArticleDAO;
import dao.MeasurementDAO;

/**
 * 
 */
public class Measurement {

	/**
	* 
	*/
	private int id;

	/**
	 * 
	 */
	private String unit;

	/**
	 * Default constructor
	 */
	public Measurement() {
	}

	/**
	 * 
	 */
	public boolean createMeasurementUnit() {

		var flag = false;

		if ((new MeasurementDAO()).find("unit", this.unit) == null) {
			try {
				(new MeasurementDAO()).insert(this);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, "Une erreur est survenue lors de l'ajout de l'unité",
						"Erreur de création", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "L'unité existe déjà");
		}
		return flag;

	}

	public boolean updateMeasurement() {

		var flag = false;
		var existingUnit = (new MeasurementDAO()).find("unit", this.unit);
		
		if (existingUnit == null || existingUnit.getId() == this.id) {
			try {
				(new MeasurementDAO()).update(this);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, "Une erreur est survenue lors de l'ajout de l'unité",
						"Erreur de création", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "L'unité existe déjà");
		}
		return flag;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Object[] toRow() {
		Object[] measurement = { getId(), getUnit() };
		return measurement;
	}

}