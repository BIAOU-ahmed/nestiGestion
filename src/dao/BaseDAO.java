/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Administrator;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public abstract class BaseDAO<E> {

	public String getTableName() {

		return "";
	}

	public <T> E find(String fieldName, T fieldValue) {
		E result = null;

//		System.out.println("table " + getTableName());
		try {
			var find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " = ?");

			find.setObject(1, fieldValue);
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public E getFromResultSet(ResultSet rs) throws SQLException {

		return null;
	}

	public ArrayList<E> findALL() {
		ArrayList<E> result = null;

		try {
			var allUsersRs = DBConnection.get().createStatement().executeQuery("SELECT * FROM " + getTableName() + ";");
			result = getAllFromResultSet(allUsersRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private ArrayList<E> getAllFromResultSet(ResultSet rs) throws SQLException {
		ArrayList<E> resultList = new ArrayList<>();
		var result = getFromResultSet(rs);

		while (result != null) {
			resultList.add(result);
			result = getFromResultSet(rs);
		}

		return resultList;
	}

}
