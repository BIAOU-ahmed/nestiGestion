package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class DBConnection {
	
	static Connection accessDataBase = null;
	

   

    /**
	 * Connexion à ma base de donnée NESTI
	 * 
	 * @throws SQLException
	 * 
	 */
    public void startCo() {
    	/* Parametres de connexion */
		String url = "jdbc:mysql://127.0.0.1/nestigestion";
		// nesti = nom de ma bdd
		String utilisateur = Config.USER;
		String motDePasse = Config.PASSWORD;

		System.out.println("try to connect");
		// on ajoute nos paramètres
		try {
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }

    /**
     * 
     */
    public void closeCo() {
    	if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
    }

    /**
     * 
     */
    public void testCo() {
        // TODO implement here
    }

}