package model;


import java.util.*;

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


    public void setMeasurementFromUnit(String u) {
    	var m =(new MeasurementDAO()).find("unit",u);
    	this.measurementId = m.getId();
    }

    public Measurement getMeasurement() {
    	
    	return (new MeasurementDAO()).find("idMeasurement",this.measurementId);
    }
}