/**
 * 
 */
package dao;

import java.sql.SQLException;

import model.Administrator;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class AdministratorDAO extends BaseDAO<Administrator> {


	@Override
	public String getTableName() {

		return "administrator";
	}
}
