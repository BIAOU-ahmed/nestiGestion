package model;


import java.util.*;

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
    public void createMeasurementUnit() {
        // TODO implement here
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
		Object[] measurement = { getId(), getUnit()};
		return measurement;
	}

}