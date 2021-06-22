package model;


import java.sql.SQLException;
import java.util.*;

import dao.AdministratorDAO;
import dao.SuperAdminDAO;

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
     * add an super administrator in the database
     * @param admin the administrator
     * @param role the role of the administrator
     */
    public void createAccount(Administrator admin, int role) {
    	try {
			(new AdministratorDAO()).insert(admin);
			if (role == 1) {
				(new SuperAdminDAO()).insert(admin);
			}
		} catch (SQLException e) {
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