package model;


import java.util.*;

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
    private void createConditioner() {
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
	 * @return
	 */
	public Object[] toRow() {
		Object[] conditioning = { getId(), getConditioningName()};
		return conditioning;
		
	}

}