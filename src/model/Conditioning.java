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
    public int id;

    /**
     * 
     */
    public String conditioningName;



    /**
     * 
     */
    public void createConditioner() {
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

	public Object[] toRow() {
		Object[] conditioning = { getId(), getConditioningName()};
		return conditioning;
		
	}

}