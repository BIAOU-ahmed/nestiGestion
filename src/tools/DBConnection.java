package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import model.Config;

/**
 * 
 */
public class DBConnection {

	static Connection accessDataBase = null;

	static boolean isTest;
	
	

	/**
	 * @return the isTest
	 */
	public static boolean isTest() {
		return isTest;
	}

	/**
	 * @param isTest the isTest to set
	 */
	public static void setTest(boolean isTest) {
		DBConnection.isTest = isTest;
	}

	/**
	 * Connexion � ma base de donn�e NESTI
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
		// on ajoute nos param�tres
		try {
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Connexion � ma base de donn�e NESTI
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Connection get() {

		if (accessDataBase == null) {

			/* Parametres de connexion */
			String url = Config.URL;
			// nesti = nom de ma bdd

			String utilisateur = Config.USER;
			String motDePasse = Config.PASSWORD;

			if(isTest) {
				
				url = Config.URL_TEST;
				// nesti = nom de ma bdd

				utilisateur = Config.USER_TEST;
				motDePasse = Config.PASSWORD_TEST;
				
			}
			
			System.out.println("try to connect");
			// on ajoute nos param�tres
			try {
				accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return accessDataBase;
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