/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Administrator;
import tools.DBConnection;

/**
 * This class contain all common queries
 * @author ahmed
 *
 */
public abstract class BaseDAO<E> {

	public String getTableName() {

		return "";
	}

	/**
	 * this function is a common function which allow to find an object according to the fieldName passing in parameter
	 * @param <T>
	 * @param fieldName
	 * @param fieldValue
	 * @return Object
	 */
	public <T> E find(String fieldName, T fieldValue) {
		E result = null;

		try {
			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " = ?");

			find.setObject(1, fieldValue);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public E getFromResultSet(ResultSet rs) throws SQLException {

		return null;
	}

	/**
	 * find all element of the table
	 * @return array of object
	 */
	public ArrayList<E> findALL() {
		ArrayList<E> result = null;

		try {
			ResultSet allUsersRs = DBConnection.get().createStatement()
					.executeQuery("SELECT * FROM " + getTableName() + ";");
			result = getAllFromResultSet(allUsersRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * find all values by the passed parameter
	 * @param <T>
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public <T> ArrayList<E> findALLBy(String fieldName, T fieldValue) {
		ArrayList<E> result = null;

		try {

			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " = ?");

			find.setObject(1, fieldValue);

			ResultSet allRs = find.executeQuery();

			result = getAllFromResultSet(allRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * find with the like statement
	 * @param <T>
	 * @param fieldName
	 * @param fieldValue
	 * @return array of object
	 */
	public <T> ArrayList<E> findAllLike(String fieldName, T fieldValue) {
		ArrayList<E> result = null;

		try {

			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " LIKE ?");

			System.out.println("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " LIKE %" + fieldValue + "%");
			find.setObject(1, "%" + fieldValue + "%");

			ResultSet allRs = find.executeQuery();

			result = getAllFromResultSet(allRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * make array of object with query resultSet
	 * @param rs
	 * @return array of object
	 * @throws SQLException
	 */
	protected ArrayList<E> getAllFromResultSet(ResultSet rs) throws SQLException {
		ArrayList<E> resultList = new ArrayList<>();
		E result = getFromResultSet(rs);

		while (result != null) {
			resultList.add(result);
			result = getFromResultSet(rs);
		}

		return resultList;
	}

}
