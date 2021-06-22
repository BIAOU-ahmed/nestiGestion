package model;


import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import dao.ConditioningDAO;
import dao.MeasurementDAO;

/**
 * 
 */
public class Conditioning {

    /**
     * Default constructor
     */
    public Conditioning() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String conditioningName;



	/**
	 * 
	 */
	public boolean createconditioning() {

		var flag = false;

		if ((new ConditioningDAO()).find("conditioningName ", this.conditioningName) == null) {
			try {
				(new ConditioningDAO()).insert(this);
				flag = true;
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Une erreur est survenue lors de l'ajout du conditionnement",
						"Erreur de création", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Le conditionnement existe déjà");
		}
		return flag;

	}

	public boolean updateconditioning() {

		var flag = false;
		var existingConditioning = (new ConditioningDAO()).find("conditioningName ", this.conditioningName);

		if (existingConditioning == null || existingConditioning.getId() == this.id) {
			try {
				(new ConditioningDAO()).update(this);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, "Une erreur est survenue lors de l'ajout du conditionnement",
						"Erreur de création", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Le conditionnement existe déjà");
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
	 * @return the conditioningName
	 */
	public String getConditioningName() {
		return conditioningName;
	}



	/**
	 * @param conditioningName the conditioningName to set
	 */
	public void setConditioningName(String conditioningName) {
		this.conditioningName = conditioningName;
	}

	/**
	 * object to display
	 * @return array of object
	 */
	public Object[] toRow() {
		Object[] conditioning = { getId(), getConditioningName()};
		return conditioning;
		
	}

}