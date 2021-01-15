package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.lambdaworks.crypto.SCryptUtil;

import tools.DBConnection;

//import com.lambdaworks.crypto.SCryptUtil;

/**
 * 
 */
public class AppConnection extends DBConnection {

    /**
     * Default constructor
     */
    public AppConnection() {
    }

    /**
     * 
     */
    public int idAdmin;

    /**
     * @return 
     * 
     */
//    public boolean logIn(String username, String password) {
//		boolean result = false;
//		try {
//
//			startCo();
//			String query = "SELECT * FROM `administrator` WHERE userName = ?";
//			PreparedStatement declaration = accessDataBase.prepareStatement(query);
//
//			declaration.setString(1, username);
////			declaration.setString(2, password);
//			ResultSet resultat = declaration.executeQuery();
//			if (resultat.next()) {
//				 boolean matched = SCryptUtil.check(password, resultat.getString(5));
//				 
//				result = matched;
//				System.out.println(result);
//			}
//			/* Récupération des données */
//
//		} catch (Exception e) {
//			System.err.println("Impossible de trouver l'admin: " + e.getMessage());
//		}
//
//		closeCo();
//
//		return result;
//    }

    /**
     * 
     */
    public void isConnected() {
        // TODO implement here
    }

}