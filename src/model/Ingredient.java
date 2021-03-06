package model;


import java.sql.SQLException;
import java.util.*;

import dao.IngredientDAO;
import dao.MeasurementDAO;

/**
 * 
 */
public class Ingredient extends Product {

	private int measurementId;
    /**
     * Default constructor
     */
    public Ingredient() {
    }


    
    
    /**
	 * @return the measurementId
	 */
	public int getMeasurementId() {
		return measurementId;
	}




	/**
	 * @param measurementId the measurementId to set
	 */
	public void setMeasurementId(int measurementId) {
		this.measurementId = measurementId;
	}




	/**
	 * set the object Measurement from the measurement name
	 * @param u the measurement name
	 */
	public void setMeasurementFromUnit(String u) {
    	var m =(new MeasurementDAO()).find("unit",u);
    	this.measurementId = m.getId();
    }

	/**
	 * 
	 * @return measurement
	 */
    public Measurement getMeasurement() {
    	
    	return (new MeasurementDAO()).find("idMeasurement",this.measurementId);
    }
    
    /**
     * update the ingredient in the database
     */
    public void update() {
    	
    	Ingredient ing = new Ingredient();
    	ing.setId(this.id);
    	ing.setMeasurementId(getMeasurementId()); ;
    	
    	try {
			(new IngredientDAO()).update(ing);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    }

}