package model;


import java.sql.SQLException;
import java.util.*;

import dao.AdministratorDAO;

/**
 * 
 */
public class SuperAdmin extends Administrator {

    /**
     * Default constructor
     */
    public SuperAdmin() {
    }

    /**
     * 
     */
    public void createAccount(Administrator admin, int role) {
        // TODO implement here
    	try {
			(new AdministratorDAO()).insert(admin);
			if (role == 1) {
				(new SuperAdminDAO()).insert(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * 
     */
    public void upgradeAccount() {
        // TODO implement here
    }

    /**
     * 
     */
    public void lockAccount() {
        // TODO implement here
    }

    
}