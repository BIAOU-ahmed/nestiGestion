/**
 * 
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author ahmed
 *
 */
public class MyConnection {

	static Connection accessDataBase = null;

	/**
	 * Connexion à ma base de donnée NESTI
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void openConnection() {
		/* Parametres de connexion */
		String url = "jdbc:mysql://127.0.0.1/nesti";
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
	
	
	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
	
}
