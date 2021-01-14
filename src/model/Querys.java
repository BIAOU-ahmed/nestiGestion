/**
 * 
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.lambdaworks.crypto.SCryptUtil;

/**
 * @author ahmed
 *
 */
public class Querys extends DBConnection{

	public DefaultComboBoxModel getUnitys(JComboBox<String> unityList) {
//		DefaultComboBoxModel model = new DefaultComboBoxModel();
		
		try {

			startCo();
			String query = "SELECT * FROM `measurement`";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

//			declaration.setString(1, username);
//			declaration.setString(2, password);
			ResultSet resultat = declaration.executeQuery();
			while (resultat.next()) {
//				 boolean matched = SCryptUtil.check(password, resultat.getString(5));
				unityList.addItem(resultat.getString(2));
//				result = matched;
//				System.out.println(result);
			}
			/* Récupération des données */

		} catch (Exception e) {
			System.err.println("Impossible de trouver l'admin: " + e.getMessage());
		}

		closeCo();
		
		return null;
		
	}
}
